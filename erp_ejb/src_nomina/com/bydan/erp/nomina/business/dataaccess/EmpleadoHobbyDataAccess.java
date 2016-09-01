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
import com.bydan.erp.nomina.util.*;//EmpleadoHobbyConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class EmpleadoHobbyDataAccess extends  EmpleadoHobbyDataAccessAdditional{ //EmpleadoHobbyDataAccessAdditional,DataAccessHelper<EmpleadoHobby>
	//static Logger logger = Logger.getLogger(EmpleadoHobbyDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="empleado_hobby";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_empleado,id_hobby)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_hobby=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select empleadohobby from "+EmpleadoHobbyConstantesFunciones.SPERSISTENCENAME+" empleadohobby";
	public static String QUERYSELECTNATIVE="select "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".version_row,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_empresa,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_empleado,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id_hobby from "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME;//+" as "+EmpleadoHobbyConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".id,"+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+".version_row from "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME;//+" as "+EmpleadoHobbyConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EmpleadoHobbyConstantesFunciones.SCHEMA+"."+EmpleadoHobbyConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_empleado=?,id_hobby=?";
	
	public static String STOREPROCEDUREINSERT="call SP_EMPLEADOHOBBY_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_EMPLEADOHOBBY_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_EMPLEADOHOBBY_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_EMPLEADOHOBBY_SELECT(?,?)";
	
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
	
	
	protected EmpleadoHobbyDataAccessAdditional empleadohobbyDataAccessAdditional=null;
	
	public EmpleadoHobbyDataAccessAdditional getEmpleadoHobbyDataAccessAdditional() {
		return this.empleadohobbyDataAccessAdditional;
	}
	
	public void setEmpleadoHobbyDataAccessAdditional(EmpleadoHobbyDataAccessAdditional empleadohobbyDataAccessAdditional) {
		try {
			this.empleadohobbyDataAccessAdditional=empleadohobbyDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public EmpleadoHobbyDataAccess() {
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
		EmpleadoHobbyDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EmpleadoHobbyDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EmpleadoHobbyDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEmpleadoHobbyOriginal(EmpleadoHobby empleadohobby)throws Exception  {
		empleadohobby.setEmpleadoHobbyOriginal((EmpleadoHobby)empleadohobby.clone());		
	}
	
	public void setEmpleadoHobbysOriginal(List<EmpleadoHobby> empleadohobbys)throws Exception  {
		
		for(EmpleadoHobby empleadohobby:empleadohobbys){
			empleadohobby.setEmpleadoHobbyOriginal((EmpleadoHobby)empleadohobby.clone());
		}
	}
	
	public static void setEmpleadoHobbyOriginalStatic(EmpleadoHobby empleadohobby)throws Exception  {
		empleadohobby.setEmpleadoHobbyOriginal((EmpleadoHobby)empleadohobby.clone());		
	}
	
	public static void setEmpleadoHobbysOriginalStatic(List<EmpleadoHobby> empleadohobbys)throws Exception  {
		
		for(EmpleadoHobby empleadohobby:empleadohobbys){
			empleadohobby.setEmpleadoHobbyOriginal((EmpleadoHobby)empleadohobby.clone());
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
	
	public  EmpleadoHobby getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();		
		
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
	
	public  EmpleadoHobby getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.EmpleadoHobby.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEmpleadoHobbyOriginal(new EmpleadoHobby());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoHobby("",entity,resultSet); 
				
				//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoHobby(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EmpleadoHobby getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();
				
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
	
	public  EmpleadoHobby getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoHobbyDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoHobby.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEmpleadoHobbyOriginal(new EmpleadoHobby());
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEmpleadoHobby("",entity,resultSet);    
				
				//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEmpleadoHobby(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EmpleadoHobby
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EmpleadoHobby entity = new EmpleadoHobby();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoHobbyDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.EmpleadoHobby.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEmpleadoHobby(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EmpleadoHobby> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		
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
	
	public  List<EmpleadoHobby> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoHobbyDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoHobby();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoHobby("",entity,resultSet);
      	    	
				//entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
      	    	//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoHobbys(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoHobby(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoHobby> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
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
	
	public  List<EmpleadoHobby> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoHobby();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoHobby();
					//entity.setMapEmpleadoHobby(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEmpleadoHobbyValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoHobby().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoHobbyDataAccess.getEntityEmpleadoHobby("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
					////entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoHobbys(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoHobby(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EmpleadoHobby getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();		  
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
	
	public  EmpleadoHobby getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoHobby();
				
				if(conMapGenerico) {
					entity.inicializarMapEmpleadoHobby();
					//entity.setMapEmpleadoHobby(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEmpleadoHobbyValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEmpleadoHobby().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
					entity=EmpleadoHobbyDataAccess.getEntityEmpleadoHobby("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
					////entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
					////entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEmpleadoHobby(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoHobby(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EmpleadoHobby getEntityEmpleadoHobby(String strPrefijo,EmpleadoHobby entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EmpleadoHobby.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EmpleadoHobby.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EmpleadoHobbyDataAccess.setFieldReflectionEmpleadoHobby(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEmpleadoHobby=EmpleadoHobbyConstantesFunciones.getTodosTiposColumnasEmpleadoHobby();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEmpleadoHobby) {
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
							field = EmpleadoHobby.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EmpleadoHobby.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EmpleadoHobbyDataAccess.setFieldReflectionEmpleadoHobby(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEmpleadoHobby(Field field,String strPrefijo,String sColumn,EmpleadoHobby entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EmpleadoHobbyConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoHobbyConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EmpleadoHobbyConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoHobbyConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EmpleadoHobbyConstantesFunciones.IDHOBBY:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoHobby>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoHobbyDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EmpleadoHobby();
					entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEmpleadoHobby("",entity,resultSet);
					
					//entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
					//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
					//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEmpleadoHobbys(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoHobby(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EmpleadoHobby>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EmpleadoHobbyDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,EmpleadoHobbyDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EmpleadoHobby> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
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
	
	public  List<EmpleadoHobby> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoHobby();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoHobby("",entity,resultSet);
      	    	
				//entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
      	    	//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEmpleadoHobbys(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEmpleadoHobby(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EmpleadoHobby> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
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
	
	public  List<EmpleadoHobby> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EmpleadoHobby> entities = new  ArrayList<EmpleadoHobby>();
		EmpleadoHobby entity = new EmpleadoHobby();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EmpleadoHobby();
      	    	entity=super.getEntity("",entity,resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEmpleadoHobby("",entity,resultSet);
      	    	
				//entity.setEmpleadoHobbyOriginal( new EmpleadoHobby());
      	    	//entity.setEmpleadoHobbyOriginal(super.getEntity("",entity.getEmpleadoHobbyOriginal(),resultSet,EmpleadoHobbyDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEmpleadoHobbyOriginal(this.getEntityEmpleadoHobby("",entity.getEmpleadoHobbyOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEmpleadoHobbys(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public EmpleadoHobby getEntityEmpleadoHobby(String strPrefijo,EmpleadoHobby entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+EmpleadoHobbyConstantesFunciones.IDEMPRESA));
				entity.setid_empleado(resultSet.getLong(strPrefijo+EmpleadoHobbyConstantesFunciones.IDEMPLEADO));
				entity.setid_hobby(resultSet.getLong(strPrefijo+EmpleadoHobbyConstantesFunciones.IDHOBBY));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEmpleadoHobby(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EmpleadoHobby entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EmpleadoHobbyDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EmpleadoHobbyDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EmpleadoHobbyDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EmpleadoHobbyDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EmpleadoHobbyConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,EmpleadoHobbyDataAccess.TABLENAME,EmpleadoHobbyDataAccess.ISWITHSTOREPROCEDURES);
			
			EmpleadoHobbyDataAccess.setEmpleadoHobbyOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,EmpleadoHobby relempleadohobby)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relempleadohobby.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Empleado getEmpleado(Connexion connexion,EmpleadoHobby relempleadohobby)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relempleadohobby.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Hobby getHobby(Connexion connexion,EmpleadoHobby relempleadohobby)throws SQLException,Exception {

		Hobby hobby= new Hobby();

		try {
			HobbyDataAccess hobbyDataAccess=new HobbyDataAccess();

			hobbyDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			hobbyDataAccess.setConnexionType(this.connexionType);
			hobbyDataAccess.setParameterDbType(this.parameterDbType);

			hobby=hobbyDataAccess.getEntity(connexion,relempleadohobby.getid_hobby());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return hobby;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EmpleadoHobby empleadohobby) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!empleadohobby.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(empleadohobby.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(empleadohobby.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_hobby=new ParameterValue<Long>();
					parameterMaintenanceValueid_hobby.setValue(empleadohobby.getid_hobby());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_hobby);
					parametersTemp.add(parameterMaintenance);
					
						if(!empleadohobby.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(empleadohobby.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(empleadohobby.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(empleadohobby.getId());
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
	
	public void setIsNewIsChangedFalseEmpleadoHobby(EmpleadoHobby empleadohobby)throws Exception  {		
		empleadohobby.setIsNew(false);
		empleadohobby.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEmpleadoHobbys(List<EmpleadoHobby> empleadohobbys)throws Exception  {				
		for(EmpleadoHobby empleadohobby:empleadohobbys) {
			empleadohobby.setIsNew(false);
			empleadohobby.setIsChanged(false);
		}
	}
	
	public void generarExportarEmpleadoHobby(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
