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
import com.bydan.erp.nomina.util.*;//EmpleadoDiscaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoDiscaDataAccess extends  EmpleadoDiscaDataAccessAdditional{ //EmpleadoDiscaDataAccessAdditional,DataAccessHelper<EmpleadoDisca>
	//static Logger logger = Logger.getLogger(EmpleadoDiscaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_disca";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_tipo_discapacidad,porcentaje_inicial,porcentaje_final,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_discapacidad=?,porcentaje_inicial=?,porcentaje_final=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadodisca from "+EmpleadoDiscaConstantesFunciones.SPERSISTENCENAME+" empleadodisca";
	public static String QUERYSELECTNATIVE="select "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".version_row,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id_tipo_discapacidad,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".porcentaje_inicial,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".porcentaje_final,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME;//+" as "+EmpleadoDiscaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".id,"+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+".version_row from "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME;//+" as "+EmpleadoDiscaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoDiscaConstantesFunciones.SCHEMA+"."+EmpleadoDiscaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_tipo_discapacidad=?,porcentaje_inicial=?,porcentaje_final=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADODISCA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADODISCA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADODISCA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADODISCA_SELECT(?,?)";
	
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
	
	
	protected EmpleadoDiscaDataAccessAdditional empleadodiscaDataAccessAdditional=null;
	
	public EmpleadoDiscaDataAccessAdditional getEmpleadoDiscaDataAccessAdditional() {
		return this.empleadodiscaDataAccessAdditional;
	}
	
	public void setEmpleadoDiscaDataAccessAdditional(EmpleadoDiscaDataAccessAdditional empleadodiscaDataAccessAdditional) {
		try {
			this.empleadodiscaDataAccessAdditional=empleadodiscaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoDiscaDataAccess() {
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
		EmpleadoDiscaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoDiscaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoDiscaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoDiscaOriginal(EmpleadoDisca empleadodisca)throws Exception  {
		empleadodisca.setEmpleadoDiscaOriginal((EmpleadoDisca)empleadodisca.clone());		
	}
	
	public void setEmpleadoDiscasOriginal(List<EmpleadoDisca> empleadodiscas)throws Exception  {
		
		for(EmpleadoDisca empleadodisca:empleadodiscas){
			empleadodisca.setEmpleadoDiscaOriginal((EmpleadoDisca)empleadodisca.clone());
		}
	}
	
	public static void setEmpleadoDiscaOriginalStatic(EmpleadoDisca empleadodisca)throws Exception  {
		empleadodisca.setEmpleadoDiscaOriginal((EmpleadoDisca)empleadodisca.clone());		
	}
	
	public static void setEmpleadoDiscasOriginalStatic(List<EmpleadoDisca> empleadodiscas)throws Exception  {
		
		for(EmpleadoDisca empleadodisca:empleadodiscas){
			empleadodisca.setEmpleadoDiscaOriginal((EmpleadoDisca)empleadodisca.clone());
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
	
	public  EmpleadoDisca getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();		
		
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
	
	public  EmpleadoDisca getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoDisca.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoDiscaOriginal(new EmpleadoDisca());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoDisca("",entity,resultSet); 
				
				//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoDisca(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoDisca getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();
				
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
	
	public  EmpleadoDisca getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDiscaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoDisca.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoDiscaOriginal(new EmpleadoDisca());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoDisca("",entity,resultSet);    
				
				//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoDisca(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoDisca
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoDisca entity = new EmpleadoDisca();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDiscaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoDisca.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoDisca(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoDisca> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		
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
	
	public  List<EmpleadoDisca> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDiscaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoDisca();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoDisca("",entity,resultSet);
      	    	
				//entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
      	    	//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoDiscas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoDisca(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoDisca> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
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
	
	public  List<EmpleadoDisca> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoDisca();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoDisca();
					//entity.setMapEmpleadoDisca(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoDiscaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoDisca().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoDiscaDataAccess.getEntityEmpleadoDisca("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
					////entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoDiscas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoDisca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoDisca getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();		  
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
	
	public  EmpleadoDisca getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoDisca();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoDisca();
					//entity.setMapEmpleadoDisca(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoDiscaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoDisca().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoDiscaDataAccess.getEntityEmpleadoDisca("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
					////entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoDisca(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoDisca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoDisca getEntityEmpleadoDisca(String strPrefijo,EmpleadoDisca entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoDisca.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoDisca.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoDiscaDataAccess.setFieldReflectionEmpleadoDisca(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoDisca=EmpleadoDiscaConstantesFunciones.getTodosTiposColumnasEmpleadoDisca();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoDisca) {
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
							field = EmpleadoDisca.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoDisca.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoDiscaDataAccess.setFieldReflectionEmpleadoDisca(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoDisca(Field field,String strPrefijo,String sColumn,EmpleadoDisca entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoDiscaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case EmpleadoDiscaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoDisca>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDiscaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoDisca();
					entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoDisca("",entity,resultSet);
					
					//entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
					//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoDiscas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoDisca(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoDisca>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoDiscaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoDiscaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoDisca> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
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
	
	public  List<EmpleadoDisca> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoDisca();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoDisca("",entity,resultSet);
      	    	
				//entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
      	    	//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoDiscas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoDisca(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoDisca> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
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
	
	public  List<EmpleadoDisca> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoDisca> entities = new  ArrayList<EmpleadoDisca>();
		EmpleadoDisca entity = new EmpleadoDisca();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoDisca();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoDisca("",entity,resultSet);
      	    	
				//entity.setEmpleadoDiscaOriginal( new EmpleadoDisca());
      	    	//entity.setEmpleadoDiscaOriginal(super.getEntity("",entity.getEmpleadoDiscaOriginal(),resultSet,EmpleadoDiscaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoDiscaOriginal(this.getEntityEmpleadoDisca("",entity.getEmpleadoDiscaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoDiscas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoDisca getEntityEmpleadoDisca(String strPrefijo,EmpleadoDisca entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoDiscaConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoDiscaConstantesFunciones.IDEMPLEADO));
				entity.setid_tipo_discapacidad(resultSet.getLong(strPrefijo+EmpleadoDiscaConstantesFunciones.IDTIPODISCAPACIDAD));
				entity.setporcentaje_inicial(resultSet.getDouble(strPrefijo+EmpleadoDiscaConstantesFunciones.PORCENTAJEINICIAL));
				entity.setporcentaje_final(resultSet.getDouble(strPrefijo+EmpleadoDiscaConstantesFunciones.PORCENTAJEFINAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpleadoDiscaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoDisca(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoDisca entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoDiscaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoDiscaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoDiscaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoDiscaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoDiscaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoDiscaDataAccess.TABLENAME,EmpleadoDiscaDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoDiscaDataAccess.setEmpleadoDiscaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoDisca relempleadodisca)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadodisca.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoDisca relempleadodisca)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadodisca.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public TipoDiscapacidad getTipoDiscapacidad(Connexion connexion,EmpleadoDisca relempleadodisca)throws SQLException,Exception {

		TipoDiscapacidad tipodiscapacidad= new TipoDiscapacidad();

		try {
			TipoDiscapacidadDataAccess tipodiscapacidadDataAccess=new TipoDiscapacidadDataAccess();

			tipodiscapacidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipodiscapacidadDataAccess.setConnexionType(this.connexionType);
			tipodiscapacidadDataAccess.setParameterDbType(this.parameterDbType);

			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion,relempleadodisca.getid_tipo_discapacidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipodiscapacidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoDisca empleadodisca) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadodisca.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadodisca.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadodisca.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_discapacidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_discapacidad.setValue(empleadodisca.getid_tipo_discapacidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_discapacidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_inicial=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_inicial.setValue(empleadodisca.getporcentaje_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_final=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_final.setValue(empleadodisca.getporcentaje_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(empleadodisca.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadodisca.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadodisca.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadodisca.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadodisca.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoDisca(EmpleadoDisca empleadodisca)throws Exception  {		
		empleadodisca.setIsNew(false);
		empleadodisca.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoDiscas(List<EmpleadoDisca> empleadodiscas)throws Exception  {				
		for(EmpleadoDisca empleadodisca:empleadodiscas) {
			empleadodisca.setIsNew(false);
			empleadodisca.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoDisca(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
