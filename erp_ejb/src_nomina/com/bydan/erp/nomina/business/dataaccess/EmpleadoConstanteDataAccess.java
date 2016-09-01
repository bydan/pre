/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.nomina.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//EmpleadoConstanteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoConstanteDataAccess extends  EmpleadoConstanteDataAccessAdditional{ //EmpleadoConstanteDataAccessAdditional,DataAccessHelper<EmpleadoConstante>
	//static Logger logger = Logger.getLogger(EmpleadoConstanteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_constante";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_constante_nomi,valor,esta_activo)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_constante_nomi=?,valor=?,esta_activo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoconstante from "+EmpleadoConstanteConstantesFunciones.SPERSISTENCENAME+" empleadoconstante";
	public static String QUERYSELECTNATIVE="select "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".version_row,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id_constante_nomi,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".valor,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".esta_activo from "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstanteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".id,"+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+".version_row from "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME;//+" as "+EmpleadoConstanteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoConstanteConstantesFunciones.SCHEMA+"."+EmpleadoConstanteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_constante_nomi=?,valor=?,esta_activo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOCONSTANTE_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOCONSTANTE_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOCONSTANTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOCONSTANTE_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected EmpleadoConstanteDataAccessAdditional empleadoconstanteDataAccessAdditional=null;
	
	public EmpleadoConstanteDataAccessAdditional getEmpleadoConstanteDataAccessAdditional() {
		return this.empleadoconstanteDataAccessAdditional;
	}
	
	public void setEmpleadoConstanteDataAccessAdditional(EmpleadoConstanteDataAccessAdditional empleadoconstanteDataAccessAdditional) {
		try {
			this.empleadoconstanteDataAccessAdditional=empleadoconstanteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoConstanteDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		EmpleadoConstanteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoConstanteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoConstanteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}

	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setEmpleadoConstanteOriginal(EmpleadoConstante empleadoconstante)throws Exception  {
		empleadoconstante.setEmpleadoConstanteOriginal((EmpleadoConstante)empleadoconstante.clone());		
	}
	
	public void setEmpleadoConstantesOriginal(List<EmpleadoConstante> empleadoconstantes)throws Exception  {
		
		for(EmpleadoConstante empleadoconstante:empleadoconstantes){
			empleadoconstante.setEmpleadoConstanteOriginal((EmpleadoConstante)empleadoconstante.clone());
		}
	}
	
	public static void setEmpleadoConstanteOriginalStatic(EmpleadoConstante empleadoconstante)throws Exception  {
		empleadoconstante.setEmpleadoConstanteOriginal((EmpleadoConstante)empleadoconstante.clone());		
	}
	
	public static void setEmpleadoConstantesOriginalStatic(List<EmpleadoConstante> empleadoconstantes)throws Exception  {
		
		for(EmpleadoConstante empleadoconstante:empleadoconstantes){
			empleadoconstante.setEmpleadoConstanteOriginal((EmpleadoConstante)empleadoconstante.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  EmpleadoConstante getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  EmpleadoConstante getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoConstante.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoConstanteOriginal(new EmpleadoConstante());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoConstante("",entity,resultSet); 
				
				//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoConstante(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoConstante getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  EmpleadoConstante getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoConstanteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoConstante.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoConstanteOriginal(new EmpleadoConstante());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoConstante("",entity,resultSet);    
				
				//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoConstante(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoConstante
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoConstante entity = new EmpleadoConstante();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoConstanteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoConstante.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalseEmpleadoConstante(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoConstante> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EmpleadoConstante> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoConstanteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoConstante();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoConstante("",entity,resultSet);
      	    	
				//entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
      	    	//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoConstantes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoConstante(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoConstante> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EmpleadoConstante> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoConstante();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoConstante();
					//entity.setMapEmpleadoConstante(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoConstanteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoConstante().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoConstanteDataAccess.getEntityEmpleadoConstante("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
					////entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoConstantes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoConstante(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoConstante getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  EmpleadoConstante getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoConstante();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoConstante();
					//entity.setMapEmpleadoConstante(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoConstanteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoConstante().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoConstanteDataAccess.getEntityEmpleadoConstante("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
					////entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoConstante(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoConstante(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoConstante getEntityEmpleadoConstante(String strPrefijo,EmpleadoConstante entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoConstante.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoConstante.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoConstanteDataAccess.setFieldReflectionEmpleadoConstante(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoConstante=EmpleadoConstanteConstantesFunciones.getTodosTiposColumnasEmpleadoConstante();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoConstante) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = EmpleadoConstante.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoConstante.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoConstanteDataAccess.setFieldReflectionEmpleadoConstante(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoConstante(Field field,String strPrefijo,String sColumn,EmpleadoConstante entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoConstanteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoConstanteConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoConstante>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoConstanteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new EmpleadoConstante();
					entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoConstante("",entity,resultSet);
					
					//entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
					//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoConstantes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoConstante(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoConstante>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoConstanteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoConstanteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<EmpleadoConstante> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EmpleadoConstante> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoConstante();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoConstante("",entity,resultSet);
      	    	
				//entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
      	    	//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoConstantes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoConstante(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoConstante> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<EmpleadoConstante> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoConstante> entities = new  ArrayList<EmpleadoConstante>();
		EmpleadoConstante entity = new EmpleadoConstante();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoConstante();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoConstante("",entity,resultSet);
      	    	
				//entity.setEmpleadoConstanteOriginal( new EmpleadoConstante());
      	    	//entity.setEmpleadoConstanteOriginal(super.getEntity("",entity.getEmpleadoConstanteOriginal(),resultSet,EmpleadoConstanteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoConstanteOriginal(this.getEntityEmpleadoConstante("",entity.getEmpleadoConstanteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoConstantes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoConstante getEntityEmpleadoConstante(String strPrefijo,EmpleadoConstante entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoConstanteConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoConstanteConstantesFunciones.IDEMPLEADO));
				entity.setid_constante_nomi(resultSet.getLong(strPrefijo+EmpleadoConstanteConstantesFunciones.IDCONSTANTENOMI));
				entity.setvalor(resultSet.getDouble(strPrefijo+EmpleadoConstanteConstantesFunciones.VALOR));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+EmpleadoConstanteConstantesFunciones.ESTAACTIVO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoConstante(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoConstante entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoConstanteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoConstanteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoConstanteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoConstanteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoConstanteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoConstanteDataAccess.TABLENAME,EmpleadoConstanteDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoConstanteDataAccess.setEmpleadoConstanteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoConstante relempleadoconstante)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoconstante.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoConstante relempleadoconstante)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoconstante.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public ConstanteNomi getConstanteNomi(Connexion connexion,EmpleadoConstante relempleadoconstante)throws SQLException,Exception {

		ConstanteNomi constantenomi= new ConstanteNomi();

		try {
			ConstanteNomiDataAccess constantenomiDataAccess=new ConstanteNomiDataAccess();

			constantenomiDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			constantenomiDataAccess.setConnexionType(this.connexionType);
			constantenomiDataAccess.setParameterDbType(this.parameterDbType);

			constantenomi=constantenomiDataAccess.getEntity(connexion,relempleadoconstante.getid_constante_nomi());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return constantenomi;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoConstante empleadoconstante) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoconstante.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoconstante.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoconstante.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_constante_nomi=new ParameterValue<Long>();
					parameterMaintenanceValueid_constante_nomi.setValue(empleadoconstante.getid_constante_nomi());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_constante_nomi);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(empleadoconstante.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(empleadoconstante.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoconstante.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoconstante.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoconstante.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoconstante.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalseEmpleadoConstante(EmpleadoConstante empleadoconstante)throws Exception  {		
		empleadoconstante.setIsNew(false);
		empleadoconstante.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes)throws Exception  {				
		for(EmpleadoConstante empleadoconstante:empleadoconstantes) {
			empleadoconstante.setIsNew(false);
			empleadoconstante.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoConstante(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
