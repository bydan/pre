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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//PuertoConstantesFunciones;


import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class PuertoDataAccess extends  PuertoDataAccessAdditional{ //PuertoDataAccessAdditional,DataAccessHelper<Puerto>
	//static Logger logger = Logger.getLogger(PuertoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="puerto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+"(version_row,id_tipo_puerto,id_pais,nombre,es_local,descripcion)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_puerto=?,id_pais=?,nombre=?,es_local=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select puerto from "+PuertoConstantesFunciones.SPERSISTENCENAME+" puerto";
	public static String QUERYSELECTNATIVE="select "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".version_row,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id_tipo_puerto,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id_pais,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".nombre,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".es_local,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".descripcion from "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME;//+" as "+PuertoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".id,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".version_row,"+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+".nombre from "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME;//+" as "+PuertoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PuertoConstantesFunciones.SCHEMA+"."+PuertoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_puerto=?,id_pais=?,nombre=?,es_local=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PUERTO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PUERTO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PUERTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PUERTO_SELECT(?,?)";
	
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
	
	
	protected PuertoDataAccessAdditional puertoDataAccessAdditional=null;
	
	public PuertoDataAccessAdditional getPuertoDataAccessAdditional() {
		return this.puertoDataAccessAdditional;
	}
	
	public void setPuertoDataAccessAdditional(PuertoDataAccessAdditional puertoDataAccessAdditional) {
		try {
			this.puertoDataAccessAdditional=puertoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PuertoDataAccess() {
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
		PuertoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PuertoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PuertoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setPuertoOriginal(Puerto puerto)throws Exception  {
		puerto.setPuertoOriginal((Puerto)puerto.clone());		
	}
	
	public void setPuertosOriginal(List<Puerto> puertos)throws Exception  {
		
		for(Puerto puerto:puertos){
			puerto.setPuertoOriginal((Puerto)puerto.clone());
		}
	}
	
	public static void setPuertoOriginalStatic(Puerto puerto)throws Exception  {
		puerto.setPuertoOriginal((Puerto)puerto.clone());		
	}
	
	public static void setPuertosOriginalStatic(List<Puerto> puertos)throws Exception  {
		
		for(Puerto puerto:puertos){
			puerto.setPuertoOriginal((Puerto)puerto.clone());
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
	
	public  Puerto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Puerto entity = new Puerto();		
		
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
	
	public  Puerto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Puerto entity = new Puerto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Puerto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPuertoOriginal(new Puerto());
      	    	entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPuerto("",entity,resultSet); 
				
				//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePuerto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Puerto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Puerto entity = new Puerto();
				
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
	
	public  Puerto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Puerto entity = new Puerto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PuertoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Puerto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPuertoOriginal(new Puerto());
      	    	entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPuerto("",entity,resultSet);    
				
				//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePuerto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Puerto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Puerto entity = new Puerto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PuertoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Puerto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalsePuerto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Puerto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		
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
	
	public  List<Puerto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PuertoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Puerto();
      	    	entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPuerto("",entity,resultSet);
      	    	
				//entity.setPuertoOriginal( new Puerto());
      	    	//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePuertos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPuerto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Puerto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
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
	
	public  List<Puerto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Puerto();
				
				if(conMapGenerico) {
					entity.inicializarMapPuerto();
					//entity.setMapPuerto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPuertoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPuerto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
					entity=PuertoDataAccess.getEntityPuerto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPuertoOriginal( new Puerto());
					////entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
					////entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePuertos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPuerto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Puerto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Puerto entity = new Puerto();		  
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
	
	public  Puerto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Puerto entity = new Puerto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Puerto();
				
				if(conMapGenerico) {
					entity.inicializarMapPuerto();
					//entity.setMapPuerto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPuertoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPuerto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
					entity=PuertoDataAccess.getEntityPuerto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPuertoOriginal( new Puerto());
					////entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
					////entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePuerto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPuerto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Puerto getEntityPuerto(String strPrefijo,Puerto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Puerto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Puerto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PuertoDataAccess.setFieldReflectionPuerto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPuerto=PuertoConstantesFunciones.getTodosTiposColumnasPuerto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPuerto) {
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
							field = Puerto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Puerto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PuertoDataAccess.setFieldReflectionPuerto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPuerto(Field field,String strPrefijo,String sColumn,Puerto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PuertoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PuertoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PuertoConstantesFunciones.IDTIPOPUERTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PuertoConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PuertoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PuertoConstantesFunciones.ESLOCAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case PuertoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Puerto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PuertoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Puerto();
					entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPuerto("",entity,resultSet);
					
					//entity.setPuertoOriginal( new Puerto());
					//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
					//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePuertos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPuerto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Puerto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PuertoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PuertoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Puerto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
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
	
	public  List<Puerto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Puerto();
      	    	entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPuerto("",entity,resultSet);
      	    	
				//entity.setPuertoOriginal( new Puerto());
      	    	//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePuertos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPuerto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Puerto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
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
	
	public  List<Puerto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Puerto> entities = new  ArrayList<Puerto>();
		Puerto entity = new Puerto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Puerto();
      	    	entity=super.getEntity("",entity,resultSet,PuertoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPuerto("",entity,resultSet);
      	    	
				//entity.setPuertoOriginal( new Puerto());
      	    	//entity.setPuertoOriginal(super.getEntity("",entity.getPuertoOriginal(),resultSet,PuertoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPuertoOriginal(this.getEntityPuerto("",entity.getPuertoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePuertos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Puerto getEntityPuerto(String strPrefijo,Puerto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_puerto(resultSet.getLong(strPrefijo+PuertoConstantesFunciones.IDTIPOPUERTO));
				entity.setid_pais(resultSet.getLong(strPrefijo+PuertoConstantesFunciones.IDPAIS));
				entity.setnombre(resultSet.getString(strPrefijo+PuertoConstantesFunciones.NOMBRE));
				entity.setes_local(resultSet.getBoolean(strPrefijo+PuertoConstantesFunciones.ESLOCAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+PuertoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+PuertoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPuerto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Puerto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PuertoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PuertoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PuertoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PuertoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PuertoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PuertoDataAccess.TABLENAME,PuertoDataAccess.ISWITHSTOREPROCEDURES);
			
			PuertoDataAccess.setPuertoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoPuerto getTipoPuerto(Connexion connexion,Puerto relpuerto)throws SQLException,Exception {

		TipoPuerto tipopuerto= new TipoPuerto();

		try {
			TipoPuertoDataAccess tipopuertoDataAccess=new TipoPuertoDataAccess();

			tipopuertoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipopuertoDataAccess.setConnexionType(this.connexionType);
			tipopuertoDataAccess.setParameterDbType(this.parameterDbType);

			tipopuerto=tipopuertoDataAccess.getEntity(connexion,relpuerto.getid_tipo_puerto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipopuerto;

	}

	public Pais getPais(Connexion connexion,Puerto relpuerto)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relpuerto.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
		public List<PedidoCompraImpor> getPedidoCompraImpors(Connexion connexion,Puerto puerto)throws SQLException,Exception {

		List<PedidoCompraImpor> pedidocompraimpors= new ArrayList<PedidoCompraImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PuertoConstantesFunciones.SCHEMA+".puerto ON "+PedidoCompraImporConstantesFunciones.SCHEMA+".pedido_compra_impor.id_puerto="+PuertoConstantesFunciones.SCHEMA+".puerto.id WHERE "+PuertoConstantesFunciones.SCHEMA+".puerto.id="+String.valueOf(puerto.getId());
			} else {
				sQuery=" INNER JOIN pedidocompraimpor.Puerto WHERE pedidocompraimpor.Puerto.id="+String.valueOf(puerto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PedidoCompraImporDataAccess pedidocompraimporDataAccess=new PedidoCompraImporDataAccess();

			pedidocompraimporDataAccess.setConnexionType(this.connexionType);
			pedidocompraimporDataAccess.setParameterDbType(this.parameterDbType);
			pedidocompraimpors=pedidocompraimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pedidocompraimpors;

	}

	public List<LiquidacionImpor> getLiquidacionImpors(Connexion connexion,Puerto puerto)throws SQLException,Exception {

		List<LiquidacionImpor> liquidacionimpors= new ArrayList<LiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PuertoConstantesFunciones.SCHEMA+".puerto ON "+LiquidacionImporConstantesFunciones.SCHEMA+".liquidacion_impor.id_puerto="+PuertoConstantesFunciones.SCHEMA+".puerto.id WHERE "+PuertoConstantesFunciones.SCHEMA+".puerto.id="+String.valueOf(puerto.getId());
			} else {
				sQuery=" INNER JOIN liquidacionimpor.Puerto WHERE liquidacionimpor.Puerto.id="+String.valueOf(puerto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			LiquidacionImporDataAccess liquidacionimporDataAccess=new LiquidacionImporDataAccess();

			liquidacionimporDataAccess.setConnexionType(this.connexionType);
			liquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return liquidacionimpors;

	}

	public List<Embarcador> getEmbarcadors(Connexion connexion,Puerto puerto)throws SQLException,Exception {

		List<Embarcador> embarcadors= new ArrayList<Embarcador>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+PuertoConstantesFunciones.SCHEMA+".puerto ON "+EmbarcadorConstantesFunciones.SCHEMA+".embarcador.id_puerto="+PuertoConstantesFunciones.SCHEMA+".puerto.id WHERE "+PuertoConstantesFunciones.SCHEMA+".puerto.id="+String.valueOf(puerto.getId());
			} else {
				sQuery=" INNER JOIN embarcador.Puerto WHERE embarcador.Puerto.id="+String.valueOf(puerto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmbarcadorDataAccess embarcadorDataAccess=new EmbarcadorDataAccess();

			embarcadorDataAccess.setConnexionType(this.connexionType);
			embarcadorDataAccess.setParameterDbType(this.parameterDbType);
			embarcadors=embarcadorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return embarcadors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Puerto puerto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!puerto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_puerto=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_puerto.setValue(puerto.getid_tipo_puerto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_puerto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(puerto.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(puerto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_local=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_local.setValue(puerto.getes_local());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_local);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(puerto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!puerto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(puerto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(puerto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(puerto.getId());
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
	
	public void setIsNewIsChangedFalsePuerto(Puerto puerto)throws Exception  {		
		puerto.setIsNew(false);
		puerto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePuertos(List<Puerto> puertos)throws Exception  {				
		for(Puerto puerto:puertos) {
			puerto.setIsNew(false);
			puerto.setIsChanged(false);
		}
	}
	
	public void generarExportarPuerto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
