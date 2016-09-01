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
import com.bydan.erp.nomina.util.*;//EmpleadoEstructuraConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoEstructuraDataAccess extends  EmpleadoEstructuraDataAccessAdditional{ //EmpleadoEstructuraDataAccessAdditional,DataAccessHelper<EmpleadoEstructura>
	//static Logger logger = Logger.getLogger(EmpleadoEstructuraDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_estructura";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_empleado,id_estructura,id_cargo,fecha_ingreso,fecha_salida,numero_reingreso,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_estructura=?,id_cargo=?,fecha_ingreso=?,fecha_salida=?,numero_reingreso=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadoestructura from "+EmpleadoEstructuraConstantesFunciones.SPERSISTENCENAME+" empleadoestructura";
	public static String QUERYSELECTNATIVE="select "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".version_row,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_sucursal,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_estructura,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id_cargo,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".fecha_ingreso,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".fecha_salida,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".numero_reingreso,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".descripcion from "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME;//+" as "+EmpleadoEstructuraConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".id,"+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+".version_row from "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME;//+" as "+EmpleadoEstructuraConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoEstructuraConstantesFunciones.SCHEMA+"."+EmpleadoEstructuraConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_empleado=?,id_estructura=?,id_cargo=?,fecha_ingreso=?,fecha_salida=?,numero_reingreso=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOESTRUCTURA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOESTRUCTURA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOESTRUCTURA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOESTRUCTURA_SELECT(?,?)";
	
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
	
	
	protected EmpleadoEstructuraDataAccessAdditional empleadoestructuraDataAccessAdditional=null;
	
	public EmpleadoEstructuraDataAccessAdditional getEmpleadoEstructuraDataAccessAdditional() {
		return this.empleadoestructuraDataAccessAdditional;
	}
	
	public void setEmpleadoEstructuraDataAccessAdditional(EmpleadoEstructuraDataAccessAdditional empleadoestructuraDataAccessAdditional) {
		try {
			this.empleadoestructuraDataAccessAdditional=empleadoestructuraDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoEstructuraDataAccess() {
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
		EmpleadoEstructuraDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoEstructuraDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoEstructuraDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoEstructuraOriginal(EmpleadoEstructura empleadoestructura)throws Exception  {
		empleadoestructura.setEmpleadoEstructuraOriginal((EmpleadoEstructura)empleadoestructura.clone());		
	}
	
	public void setEmpleadoEstructurasOriginal(List<EmpleadoEstructura> empleadoestructuras)throws Exception  {
		
		for(EmpleadoEstructura empleadoestructura:empleadoestructuras){
			empleadoestructura.setEmpleadoEstructuraOriginal((EmpleadoEstructura)empleadoestructura.clone());
		}
	}
	
	public static void setEmpleadoEstructuraOriginalStatic(EmpleadoEstructura empleadoestructura)throws Exception  {
		empleadoestructura.setEmpleadoEstructuraOriginal((EmpleadoEstructura)empleadoestructura.clone());		
	}
	
	public static void setEmpleadoEstructurasOriginalStatic(List<EmpleadoEstructura> empleadoestructuras)throws Exception  {
		
		for(EmpleadoEstructura empleadoestructura:empleadoestructuras){
			empleadoestructura.setEmpleadoEstructuraOriginal((EmpleadoEstructura)empleadoestructura.clone());
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
	
	public  EmpleadoEstructura getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();		
		
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
	
	public  EmpleadoEstructura getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoEstructura.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoEstructuraOriginal(new EmpleadoEstructura());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoEstructura("",entity,resultSet); 
				
				//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoEstructura(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoEstructura getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();
				
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
	
	public  EmpleadoEstructura getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoEstructura.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoEstructuraOriginal(new EmpleadoEstructura());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoEstructura("",entity,resultSet);    
				
				//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoEstructura
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoEstructura entity = new EmpleadoEstructura();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoEstructura.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoEstructura(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoEstructura> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		
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
	
	public  List<EmpleadoEstructura> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEstructura("",entity,resultSet);
      	    	
				//entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
      	    	//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEstructuras(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoEstructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
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
	
	public  List<EmpleadoEstructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEstructura();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoEstructura();
					//entity.setMapEmpleadoEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoEstructuraDataAccess.getEntityEmpleadoEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
					////entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEstructuras(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoEstructura getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
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
	
	public  EmpleadoEstructura getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEstructura();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoEstructura();
					//entity.setMapEmpleadoEstructura(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoEstructuraValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoEstructura().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoEstructuraDataAccess.getEntityEmpleadoEstructura("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
					////entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoEstructura(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoEstructura getEntityEmpleadoEstructura(String strPrefijo,EmpleadoEstructura entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoEstructura.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoEstructura.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoEstructuraDataAccess.setFieldReflectionEmpleadoEstructura(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoEstructura=EmpleadoEstructuraConstantesFunciones.getTodosTiposColumnasEmpleadoEstructura();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoEstructura) {
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
							field = EmpleadoEstructura.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoEstructura.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoEstructuraDataAccess.setFieldReflectionEmpleadoEstructura(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoEstructura(Field field,String strPrefijo,String sColumn,EmpleadoEstructura entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoEstructuraConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.IDCARGO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.FECHAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.FECHASALIDA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case EmpleadoEstructuraConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoEstructura>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoEstructura();
					entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoEstructura("",entity,resultSet);
					
					//entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
					//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoEstructuras(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoEstructura>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoEstructuraDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoEstructuraDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoEstructura> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
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
	
	public  List<EmpleadoEstructura> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEstructura("",entity,resultSet);
      	    	
				//entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
      	    	//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoEstructuras(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoEstructura(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoEstructura> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
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
	
	public  List<EmpleadoEstructura> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoEstructura> entities = new  ArrayList<EmpleadoEstructura>();
		EmpleadoEstructura entity = new EmpleadoEstructura();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoEstructura();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoEstructura("",entity,resultSet);
      	    	
				//entity.setEmpleadoEstructuraOriginal( new EmpleadoEstructura());
      	    	//entity.setEmpleadoEstructuraOriginal(super.getEntity("",entity.getEmpleadoEstructuraOriginal(),resultSet,EmpleadoEstructuraDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoEstructuraOriginal(this.getEntityEmpleadoEstructura("",entity.getEmpleadoEstructuraOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoEstructuras(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoEstructura getEntityEmpleadoEstructura(String strPrefijo,EmpleadoEstructura entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoEstructuraConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+EmpleadoEstructuraConstantesFunciones.IDSUCURSAL));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoEstructuraConstantesFunciones.IDEMPLEADO));
				entity.setid_estructura(resultSet.getLong(strPrefijo+EmpleadoEstructuraConstantesFunciones.IDESTRUCTURA));
				entity.setid_cargo(resultSet.getLong(strPrefijo+EmpleadoEstructuraConstantesFunciones.IDCARGO));
				entity.setfecha_ingreso(new Date(resultSet.getDate(strPrefijo+EmpleadoEstructuraConstantesFunciones.FECHAINGRESO).getTime()));
				entity.setfecha_salida(new Date(resultSet.getDate(strPrefijo+EmpleadoEstructuraConstantesFunciones.FECHASALIDA).getTime()));
				entity.setnumero_reingreso(resultSet.getInt(strPrefijo+EmpleadoEstructuraConstantesFunciones.NUMEROREINGRESO));
				entity.setdescripcion(resultSet.getString(strPrefijo+EmpleadoEstructuraConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoEstructura(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoEstructura entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoEstructuraDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoEstructuraDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoEstructuraDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoEstructuraDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoEstructuraConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoEstructuraDataAccess.TABLENAME,EmpleadoEstructuraDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoEstructuraDataAccess.setEmpleadoEstructuraOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoEstructura relempleadoestructura)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadoestructura.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,EmpleadoEstructura relempleadoestructura)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relempleadoestructura.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoEstructura relempleadoestructura)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadoestructura.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Estructura getEstructura(Connexion connexion,EmpleadoEstructura relempleadoestructura)throws SQLException,Exception {

		Estructura estructura= new Estructura();

		try {
			EstructuraDataAccess estructuraDataAccess=new EstructuraDataAccess();

			estructuraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estructuraDataAccess.setConnexionType(this.connexionType);
			estructuraDataAccess.setParameterDbType(this.parameterDbType);

			estructura=estructuraDataAccess.getEntity(connexion,relempleadoestructura.getid_estructura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estructura;

	}

	public Cargo getCargo(Connexion connexion,EmpleadoEstructura relempleadoestructura)throws SQLException,Exception {

		Cargo cargo= new Cargo();

		try {
			CargoDataAccess cargoDataAccess=new CargoDataAccess();

			cargoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cargoDataAccess.setConnexionType(this.connexionType);
			cargoDataAccess.setParameterDbType(this.parameterDbType);

			cargo=cargoDataAccess.getEntity(connexion,relempleadoestructura.getid_cargo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cargo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoEstructura empleadoestructura) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadoestructura.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadoestructura.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(empleadoestructura.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadoestructura.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estructura=new ParameterValue<Long>();
					parameterMaintenanceValueid_estructura.setValue(empleadoestructura.getid_estructura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estructura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cargo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cargo.setValue(empleadoestructura.getid_cargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ingreso.setValue(empleadoestructura.getfecha_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_salida=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_salida.setValue(empleadoestructura.getfecha_salida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_salida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_reingreso=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_reingreso.setValue(empleadoestructura.getnumero_reingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_reingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(empleadoestructura.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadoestructura.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadoestructura.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadoestructura.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadoestructura.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoEstructura(EmpleadoEstructura empleadoestructura)throws Exception  {		
		empleadoestructura.setIsNew(false);
		empleadoestructura.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoEstructuras(List<EmpleadoEstructura> empleadoestructuras)throws Exception  {				
		for(EmpleadoEstructura empleadoestructura:empleadoestructuras) {
			empleadoestructura.setIsNew(false);
			empleadoestructura.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoEstructura(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
