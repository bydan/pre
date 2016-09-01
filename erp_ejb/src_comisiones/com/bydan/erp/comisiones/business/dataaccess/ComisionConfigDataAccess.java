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
import com.bydan.erp.comisiones.util.*;//ComisionConfigConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ComisionConfigDataAccess extends  ComisionConfigDataAccessAdditional{ //ComisionConfigDataAccessAdditional,DataAccessHelper<ComisionConfig>
	//static Logger logger = Logger.getLogger(ComisionConfigDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="comision_config";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_comision_config,id_nivel_linea,con_vendedor,con_ventas,con_cobros,con_remesa_transito,con_penalidad,con_abono)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_comision_config=?,id_nivel_linea=?,con_vendedor=?,con_ventas=?,con_cobros=?,con_remesa_transito=?,con_penalidad=?,con_abono=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select comisionconfig from "+ComisionConfigConstantesFunciones.SPERSISTENCENAME+" comisionconfig";
	public static String QUERYSELECTNATIVE="select "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".version_row,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_empresa,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_tipo_comision_config,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id_nivel_linea,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_vendedor,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_ventas,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_cobros,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_remesa_transito,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_penalidad,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".con_abono from "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME;//+" as "+ComisionConfigConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".id,"+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+".version_row from "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME;//+" as "+ComisionConfigConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ComisionConfigConstantesFunciones.SCHEMA+"."+ComisionConfigConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_comision_config=?,id_nivel_linea=?,con_vendedor=?,con_ventas=?,con_cobros=?,con_remesa_transito=?,con_penalidad=?,con_abono=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COMISIONCONFIG_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COMISIONCONFIG_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COMISIONCONFIG_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COMISIONCONFIG_SELECT(?,?)";
	
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
	
	
	protected ComisionConfigDataAccessAdditional comisionconfigDataAccessAdditional=null;
	
	public ComisionConfigDataAccessAdditional getComisionConfigDataAccessAdditional() {
		return this.comisionconfigDataAccessAdditional;
	}
	
	public void setComisionConfigDataAccessAdditional(ComisionConfigDataAccessAdditional comisionconfigDataAccessAdditional) {
		try {
			this.comisionconfigDataAccessAdditional=comisionconfigDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ComisionConfigDataAccess() {
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
		ComisionConfigDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ComisionConfigDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ComisionConfigDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setComisionConfigOriginal(ComisionConfig comisionconfig)throws Exception  {
		comisionconfig.setComisionConfigOriginal((ComisionConfig)comisionconfig.clone());		
	}
	
	public void setComisionConfigsOriginal(List<ComisionConfig> comisionconfigs)throws Exception  {
		
		for(ComisionConfig comisionconfig:comisionconfigs){
			comisionconfig.setComisionConfigOriginal((ComisionConfig)comisionconfig.clone());
		}
	}
	
	public static void setComisionConfigOriginalStatic(ComisionConfig comisionconfig)throws Exception  {
		comisionconfig.setComisionConfigOriginal((ComisionConfig)comisionconfig.clone());		
	}
	
	public static void setComisionConfigsOriginalStatic(List<ComisionConfig> comisionconfigs)throws Exception  {
		
		for(ComisionConfig comisionconfig:comisionconfigs){
			comisionconfig.setComisionConfigOriginal((ComisionConfig)comisionconfig.clone());
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
	
	public  ComisionConfig getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();		
		
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
	
	public  ComisionConfig getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.ComisionConfig.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setComisionConfigOriginal(new ComisionConfig());
      	    	entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionConfig("",entity,resultSet); 
				
				//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionConfig(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ComisionConfig getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();
				
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
	
	public  ComisionConfig getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionConfig.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setComisionConfigOriginal(new ComisionConfig());
      	    	entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionConfig("",entity,resultSet);    
				
				//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionConfig(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ComisionConfig
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ComisionConfig entity = new ComisionConfig();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionConfig.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseComisionConfig(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ComisionConfig> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		
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
	
	public  List<ComisionConfig> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionConfig("",entity,resultSet);
      	    	
				//entity.setComisionConfigOriginal( new ComisionConfig());
      	    	//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionConfigs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionConfig> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
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
	
	public  List<ComisionConfig> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionConfig();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionConfig();
					//entity.setMapComisionConfig(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapComisionConfigValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionConfig().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=ComisionConfigDataAccess.getEntityComisionConfig("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionConfigOriginal( new ComisionConfig());
					////entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionConfigs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ComisionConfig getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();		  
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
	
	public  ComisionConfig getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionConfig();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionConfig();
					//entity.setMapComisionConfig(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapComisionConfigValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionConfig().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=ComisionConfigDataAccess.getEntityComisionConfig("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionConfigOriginal( new ComisionConfig());
					////entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseComisionConfig(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComisionConfig getEntityComisionConfig(String strPrefijo,ComisionConfig entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ComisionConfig.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ComisionConfig.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ComisionConfigDataAccess.setFieldReflectionComisionConfig(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasComisionConfig=ComisionConfigConstantesFunciones.getTodosTiposColumnasComisionConfig();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasComisionConfig) {
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
							field = ComisionConfig.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ComisionConfig.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ComisionConfigDataAccess.setFieldReflectionComisionConfig(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComisionConfig(Field field,String strPrefijo,String sColumn,ComisionConfig entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComisionConfigConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.IDNIVELLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONVENDEDOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONVENTAS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONCOBROS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONREMESATRANSITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONPENALIDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ComisionConfigConstantesFunciones.CONABONO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionConfig>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ComisionConfig();
					entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityComisionConfig("",entity,resultSet);
					
					//entity.setComisionConfigOriginal( new ComisionConfig());
					//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
					//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseComisionConfigs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionConfig>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionConfigDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionConfigDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ComisionConfig> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
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
	
	public  List<ComisionConfig> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionConfig("",entity,resultSet);
      	    	
				//entity.setComisionConfigOriginal( new ComisionConfig());
      	    	//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseComisionConfigs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionConfig(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionConfig> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
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
	
	public  List<ComisionConfig> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionConfig> entities = new  ArrayList<ComisionConfig>();
		ComisionConfig entity = new ComisionConfig();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionConfig();
      	    	entity=super.getEntity("",entity,resultSet,ComisionConfigDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionConfig("",entity,resultSet);
      	    	
				//entity.setComisionConfigOriginal( new ComisionConfig());
      	    	//entity.setComisionConfigOriginal(super.getEntity("",entity.getComisionConfigOriginal(),resultSet,ComisionConfigDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionConfigOriginal(this.getEntityComisionConfig("",entity.getComisionConfigOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionConfigs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ComisionConfig getEntityComisionConfig(String strPrefijo,ComisionConfig entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ComisionConfigConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_comision_config(resultSet.getLong(strPrefijo+ComisionConfigConstantesFunciones.IDTIPOCOMISIONCONFIG));
				entity.setid_nivel_linea(resultSet.getLong(strPrefijo+ComisionConfigConstantesFunciones.IDNIVELLINEA));
				entity.setcon_vendedor(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONVENDEDOR));
				entity.setcon_ventas(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONVENTAS));
				entity.setcon_cobros(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONCOBROS));
				entity.setcon_remesa_transito(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONREMESATRANSITO));
				entity.setcon_penalidad(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONPENALIDAD));
				entity.setcon_abono(resultSet.getBoolean(strPrefijo+ComisionConfigConstantesFunciones.CONABONO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowComisionConfig(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ComisionConfig entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ComisionConfigDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ComisionConfigDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ComisionConfigDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ComisionConfigDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ComisionConfigConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ComisionConfigDataAccess.TABLENAME,ComisionConfigDataAccess.ISWITHSTOREPROCEDURES);
			
			ComisionConfigDataAccess.setComisionConfigOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ComisionConfig relcomisionconfig)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcomisionconfig.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoComisionConfig getTipoComisionConfig(Connexion connexion,ComisionConfig relcomisionconfig)throws SQLException,Exception {

		TipoComisionConfig tipocomisionconfig= new TipoComisionConfig();

		try {
			TipoComisionConfigDataAccess tipocomisionconfigDataAccess=new TipoComisionConfigDataAccess();

			tipocomisionconfigDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomisionconfigDataAccess.setConnexionType(this.connexionType);
			tipocomisionconfigDataAccess.setParameterDbType(this.parameterDbType);

			tipocomisionconfig=tipocomisionconfigDataAccess.getEntity(connexion,relcomisionconfig.getid_tipo_comision_config());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomisionconfig;

	}

	public NivelLinea getNivelLinea(Connexion connexion,ComisionConfig relcomisionconfig)throws SQLException,Exception {

		NivelLinea nivellinea= new NivelLinea();

		try {
			NivelLineaDataAccess nivellineaDataAccess=new NivelLineaDataAccess();

			nivellineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			nivellineaDataAccess.setConnexionType(this.connexionType);
			nivellineaDataAccess.setParameterDbType(this.parameterDbType);

			nivellinea=nivellineaDataAccess.getEntity(connexion,relcomisionconfig.getid_nivel_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return nivellinea;

	}


		
		public List<ComisionCate> getComisionCates(Connexion connexion,ComisionConfig comisionconfig)throws SQLException,Exception {

		List<ComisionCate> comisioncates= new ArrayList<ComisionCate>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config ON "+ComisionCateConstantesFunciones.SCHEMA+".comision_cate.id_comision_config="+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id WHERE "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id="+String.valueOf(comisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisioncate.ComisionConfig WHERE comisioncate.ComisionConfig.id="+String.valueOf(comisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionCateDataAccess comisioncateDataAccess=new ComisionCateDataAccess();

			comisioncateDataAccess.setConnexionType(this.connexionType);
			comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisioncates;

	}

	public List<ComisionMarca> getComisionMarcas(Connexion connexion,ComisionConfig comisionconfig)throws SQLException,Exception {

		List<ComisionMarca> comisionmarcas= new ArrayList<ComisionMarca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config ON "+ComisionMarcaConstantesFunciones.SCHEMA+".comision_marca.id_comision_config="+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id WHERE "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id="+String.valueOf(comisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisionmarca.ComisionConfig WHERE comisionmarca.ComisionConfig.id="+String.valueOf(comisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionMarcaDataAccess comisionmarcaDataAccess=new ComisionMarcaDataAccess();

			comisionmarcaDataAccess.setConnexionType(this.connexionType);
			comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionmarcas;

	}

	public List<ComisionLinea> getComisionLineas(Connexion connexion,ComisionConfig comisionconfig)throws SQLException,Exception {

		List<ComisionLinea> comisionlineas= new ArrayList<ComisionLinea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config ON "+ComisionLineaConstantesFunciones.SCHEMA+".comision_linea.id_comision_config="+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id WHERE "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id="+String.valueOf(comisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisionlinea.ComisionConfig WHERE comisionlinea.ComisionConfig.id="+String.valueOf(comisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionLineaDataAccess comisionlineaDataAccess=new ComisionLineaDataAccess();

			comisionlineaDataAccess.setConnexionType(this.connexionType);
			comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionlineas;

	}

	public List<ComisionPena> getComisionPenas(Connexion connexion,ComisionConfig comisionconfig)throws SQLException,Exception {

		List<ComisionPena> comisionpenas= new ArrayList<ComisionPena>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config ON "+ComisionPenaConstantesFunciones.SCHEMA+".comision_pena.id_comision_config="+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id WHERE "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id="+String.valueOf(comisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisionpena.ComisionConfig WHERE comisionpena.ComisionConfig.id="+String.valueOf(comisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionPenaDataAccess comisionpenaDataAccess=new ComisionPenaDataAccess();

			comisionpenaDataAccess.setConnexionType(this.connexionType);
			comisionpenaDataAccess.setParameterDbType(this.parameterDbType);
			comisionpenas=comisionpenaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionpenas;

	}

	public List<ComisionGrupo> getComisionGrupos(Connexion connexion,ComisionConfig comisionconfig)throws SQLException,Exception {

		List<ComisionGrupo> comisiongrupos= new ArrayList<ComisionGrupo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config ON "+ComisionGrupoConstantesFunciones.SCHEMA+".comision_grupo.id_comision_config="+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id WHERE "+ComisionConfigConstantesFunciones.SCHEMA+".comision_config.id="+String.valueOf(comisionconfig.getId());
			} else {
				sQuery=" INNER JOIN comisiongrupo.ComisionConfig WHERE comisiongrupo.ComisionConfig.id="+String.valueOf(comisionconfig.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionGrupoDataAccess comisiongrupoDataAccess=new ComisionGrupoDataAccess();

			comisiongrupoDataAccess.setConnexionType(this.connexionType);
			comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisiongrupos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ComisionConfig comisionconfig) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!comisionconfig.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(comisionconfig.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_comision_config=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_comision_config.setValue(comisionconfig.getid_tipo_comision_config());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_comision_config);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_nivel_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_nivel_linea.setValue(comisionconfig.getid_nivel_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_nivel_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_vendedor=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_vendedor.setValue(comisionconfig.getcon_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_ventas=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_ventas.setValue(comisionconfig.getcon_ventas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_ventas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cobros=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cobros.setValue(comisionconfig.getcon_cobros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cobros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_remesa_transito=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_remesa_transito.setValue(comisionconfig.getcon_remesa_transito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_remesa_transito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_penalidad=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_penalidad.setValue(comisionconfig.getcon_penalidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_penalidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_abono=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_abono.setValue(comisionconfig.getcon_abono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_abono);
					parametersTemp.add(parameterMaintenance);
					
						if(!comisionconfig.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(comisionconfig.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(comisionconfig.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(comisionconfig.getId());
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
	
	public void setIsNewIsChangedFalseComisionConfig(ComisionConfig comisionconfig)throws Exception  {		
		comisionconfig.setIsNew(false);
		comisionconfig.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseComisionConfigs(List<ComisionConfig> comisionconfigs)throws Exception  {				
		for(ComisionConfig comisionconfig:comisionconfigs) {
			comisionconfig.setIsNew(false);
			comisionconfig.setIsChanged(false);
		}
	}
	
	public void generarExportarComisionConfig(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
