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
package com.bydan.erp.comisiones.business.dataaccess;

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

import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.comisiones.util.*;//TipoComisionConfigConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class TipoComisionConfigDataAccess extends  TipoComisionConfigDataAccessAdditional{ //TipoComisionConfigDataAccessAdditional,DataAccessHelper<TipoComisionConfig>
	//static Logger logger = Logger.getLogger(TipoComisionConfigDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_comision_config";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocomisionconfig from "+TipoComisionConfigConstantesFunciones.SPERSISTENCENAME+" tipocomisionconfig";
	public static String QUERYSELECTNATIVE="select "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".id,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".version_row,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".id_empresa,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".codigo,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".nombre from "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME;//+" as "+TipoComisionConfigConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".id,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".version_row,"+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+".codigo from "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME;//+" as "+TipoComisionConfigConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoComisionConfigConstantesFunciones.SCHEMA+"."+TipoComisionConfigConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCOMISIONCONFIG_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCOMISIONCONFIG_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCOMISIONCONFIG_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCOMISIONCONFIG_SELECT(?,?)";
	
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
	
	
	protected TipoComisionConfigDataAccessAdditional tipocomisionconfigDataAccessAdditional=null;
	
	public TipoComisionConfigDataAccessAdditional getTipoComisionConfigDataAccessAdditional() {
		return this.tipocomisionconfigDataAccessAdditional;
	}
	
	public void setTipoComisionConfigDataAccessAdditional(TipoComisionConfigDataAccessAdditional tipocomisionconfigDataAccessAdditional) {
		try {
			this.tipocomisionconfigDataAccessAdditional=tipocomisionconfigDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoComisionConfigDataAccess() {
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
		TipoComisionConfigDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoComisionConfigDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoComisionConfigDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoComisionConfigOriginal(TipoComisionConfig tipocomisionconfig)throws Exception  {
		tipocomisionconfig.setTipoComisionConfigOriginal((TipoComisionConfig)tipocomisionconfig.clone());		
	}
	
	public void setTipoComisionConfigsOriginal(List<TipoComisionConfig> tipocomisionconfigs)throws Exception  {
		
		for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs){
			tipocomisionconfig.setTipoComisionConfigOriginal((TipoComisionConfig)tipocomisionconfig.clone());
		}
	}
	
	public static void setTipoComisionConfigOriginalStatic(TipoComisionConfig tipocomisionconfig)throws Exception  {
		tipocomisionconfig.setTipoComisionConfigOriginal((TipoComisionConfig)tipocomisionconfig.clone());		
	}
	
	public static void setTipoComisionConfigsOriginalStatic(List<TipoComisionConfig> tipocomisionconfigs)throws Exception  {
		
		for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs){
			tipocomisionconfig.setTipoComisionConfigOriginal((TipoComisionConfig)tipocomisionconfig.clone());
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
	
	public  TipoComisionConfig getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();		
		
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
	
	public  TipoComisionConfig getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.TipoComisionConfig.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoComisionConfigOriginal(new TipoComisionConfig());
      	    	entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoComisionConfig("",entity,resultSet); 
				
				//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoComisionConfig(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoComisionConfig getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();
				
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
	
	public  TipoComisionConfig getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.TipoComisionConfig.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoComisionConfigOriginal(new TipoComisionConfig());
      	    	entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoComisionConfig("",entity,resultSet);    
				
				//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoComisionConfig(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoComisionConfig
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoComisionConfig entity = new TipoComisionConfig();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.TipoComisionConfig.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoComisionConfig(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoComisionConfig> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		
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
	
	public  List<TipoComisionConfig> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoComisionConfig("",entity,resultSet);
      	    	
				//entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
      	    	//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoComisionConfigs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoComisionConfig> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
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
	
	public  List<TipoComisionConfig> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoComisionConfig();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoComisionConfig();
					//entity.setMapTipoComisionConfig(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoComisionConfigValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoComisionConfig().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=TipoComisionConfigDataAccess.getEntityTipoComisionConfig("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
					////entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoComisionConfigs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoComisionConfig getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();		  
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
	
	public  TipoComisionConfig getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoComisionConfig();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoComisionConfig();
					//entity.setMapTipoComisionConfig(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoComisionConfigValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoComisionConfig().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=TipoComisionConfigDataAccess.getEntityTipoComisionConfig("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
					////entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoComisionConfig(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoComisionConfig getEntityTipoComisionConfig(String strPrefijo,TipoComisionConfig entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoComisionConfig.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoComisionConfig.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoComisionConfigDataAccess.setFieldReflectionTipoComisionConfig(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoComisionConfig=TipoComisionConfigConstantesFunciones.getTodosTiposColumnasTipoComisionConfig();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoComisionConfig) {
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
							field = TipoComisionConfig.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoComisionConfig.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoComisionConfigDataAccess.setFieldReflectionTipoComisionConfig(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoComisionConfig(Field field,String strPrefijo,String sColumn,TipoComisionConfig entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoComisionConfigConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoComisionConfigConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoComisionConfigConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoComisionConfigConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoComisionConfigConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoComisionConfig>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoComisionConfig();
					entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoComisionConfig("",entity,resultSet);
					
					//entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
					//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoComisionConfigs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoComisionConfig>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoComisionConfig> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
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
	
	public  List<TipoComisionConfig> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoComisionConfig("",entity,resultSet);
      	    	
				//entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
      	    	//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoComisionConfigs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoComisionConfig> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
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
	
	public  List<TipoComisionConfig> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoComisionConfig> entities = new  ArrayList<TipoComisionConfig>();
		TipoComisionConfig entity = new TipoComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoComisionConfig("",entity,resultSet);
      	    	
				//entity.setTipoComisionConfigOriginal( new TipoComisionConfig());
      	    	//entity.setTipoComisionConfigOriginal(super.getEntity("",entity.getTipoComisionConfigOriginal(),resultSet,TipoComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoComisionConfigOriginal(this.getEntityTipoComisionConfig("",entity.getTipoComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoComisionConfigs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoComisionConfig getEntityTipoComisionConfig(String strPrefijo,TipoComisionConfig entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoComisionConfigConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoComisionConfigConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoComisionConfigConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoComisionConfigConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoComisionConfig(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoComisionConfig entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoComisionConfigDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoComisionConfigDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoComisionConfigDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoComisionConfigDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoComisionConfigConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoComisionConfigDataAccess.TABLENAME,TipoComisionConfigDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoComisionConfigDataAccess.setTipoComisionConfigOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoComisionConfig reltipocomisionconfig)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipocomisionconfig.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ComisionConfig> getComisionConfigs(Connexion connexion,TipoComisionConfig tipocomisionconfig)throws SQLException,Exception {

		List<ComisionConfig> comisionconfigs= new ArrayList<ComisionConfig>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoComisionConfigConstantesFunciones.SCHEMA+".tipo_comision_config ON "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id_tipo_comision_config="+TipoComisionConfigConstantesFunciones.SCHEMA+".tipo_comision_config.id WHERE "+TipoComisionConfigConstantesFunciones.SCHEMA+".tipo_comision_config.id="+String.valueOf(tipocomisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisionconfig.TipoComisionConfig WHERE comisionconfig.TipoComisionConfig.id="+String.valueOf(tipocomisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionConfigDataAccess comisionconfigDataAccess=new ComisionConfigDataAccess();

			comisionconfigDataAccess.setConnexionType(this.connexionType);
			comisionconfigDataAccess.setParameterDbType(this.parameterDbType);
			comisionconfigs=comisionconfigDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionconfigs;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoComisionConfig tipocomisionconfig) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocomisionconfig.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipocomisionconfig.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocomisionconfig.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocomisionconfig.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocomisionconfig.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocomisionconfig.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocomisionconfig.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocomisionconfig.getId());
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
	
	public void setIsNewIsChangedFalseTipoComisionConfig(TipoComisionConfig tipocomisionconfig)throws Exception  {		
		tipocomisionconfig.setIsNew(false);
		tipocomisionconfig.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoComisionConfigs(List<TipoComisionConfig> tipocomisionconfigs)throws Exception  {				
		for(TipoComisionConfig tipocomisionconfig:tipocomisionconfigs) {
			tipocomisionconfig.setIsNew(false);
			tipocomisionconfig.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoComisionConfig(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
