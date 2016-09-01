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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//TipoCompaniaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoCompaniaDataAccess extends  TipoCompaniaDataAccessAdditional{ //TipoCompaniaDataAccessAdditional,DataAccessHelper<TipoCompania>
	//static Logger logger = Logger.getLogger(TipoCompaniaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_compania";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocompania from "+TipoCompaniaConstantesFunciones.SPERSISTENCENAME+" tipocompania";
	public static String QUERYSELECTNATIVE="select "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".id,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".version_row,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".id_empresa,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".codigo,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".nombre from "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME;//+" as "+TipoCompaniaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".id,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".version_row,"+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+".codigo from "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME;//+" as "+TipoCompaniaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCompaniaConstantesFunciones.SCHEMA+"."+TipoCompaniaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCOMPANIA_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCOMPANIA_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCOMPANIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCOMPANIA_SELECT(?,?)";
	
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
	
	
	protected TipoCompaniaDataAccessAdditional tipocompaniaDataAccessAdditional=null;
	
	public TipoCompaniaDataAccessAdditional getTipoCompaniaDataAccessAdditional() {
		return this.tipocompaniaDataAccessAdditional;
	}
	
	public void setTipoCompaniaDataAccessAdditional(TipoCompaniaDataAccessAdditional tipocompaniaDataAccessAdditional) {
		try {
			this.tipocompaniaDataAccessAdditional=tipocompaniaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCompaniaDataAccess() {
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
		TipoCompaniaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCompaniaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCompaniaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCompaniaOriginal(TipoCompania tipocompania)throws Exception  {
		tipocompania.setTipoCompaniaOriginal((TipoCompania)tipocompania.clone());		
	}
	
	public void setTipoCompaniasOriginal(List<TipoCompania> tipocompanias)throws Exception  {
		
		for(TipoCompania tipocompania:tipocompanias){
			tipocompania.setTipoCompaniaOriginal((TipoCompania)tipocompania.clone());
		}
	}
	
	public static void setTipoCompaniaOriginalStatic(TipoCompania tipocompania)throws Exception  {
		tipocompania.setTipoCompaniaOriginal((TipoCompania)tipocompania.clone());		
	}
	
	public static void setTipoCompaniasOriginalStatic(List<TipoCompania> tipocompanias)throws Exception  {
		
		for(TipoCompania tipocompania:tipocompanias){
			tipocompania.setTipoCompaniaOriginal((TipoCompania)tipocompania.clone());
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
	
	public  TipoCompania getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();		
		
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
	
	public  TipoCompania getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.TipoCompania.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCompaniaOriginal(new TipoCompania());
      	    	entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCompania("",entity,resultSet); 
				
				//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCompania(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCompania getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();
				
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
	
	public  TipoCompania getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCompaniaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoCompania.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCompaniaOriginal(new TipoCompania());
      	    	entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCompania("",entity,resultSet);    
				
				//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCompania(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCompania
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCompania entity = new TipoCompania();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCompaniaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.TipoCompania.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCompania(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCompania> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		
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
	
	public  List<TipoCompania> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCompaniaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCompania();
      	    	entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCompania("",entity,resultSet);
      	    	
				//entity.setTipoCompaniaOriginal( new TipoCompania());
      	    	//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCompanias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCompania(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCompania> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
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
	
	public  List<TipoCompania> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCompania();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCompania();
					//entity.setMapTipoCompania(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCompaniaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCompania().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
					entity=TipoCompaniaDataAccess.getEntityTipoCompania("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCompaniaOriginal( new TipoCompania());
					////entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCompanias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCompania(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCompania getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();		  
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
	
	public  TipoCompania getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCompania();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCompania();
					//entity.setMapTipoCompania(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCompaniaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCompania().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
					entity=TipoCompaniaDataAccess.getEntityTipoCompania("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCompaniaOriginal( new TipoCompania());
					////entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCompania(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCompania(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCompania getEntityTipoCompania(String strPrefijo,TipoCompania entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCompania.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCompania.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCompaniaDataAccess.setFieldReflectionTipoCompania(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCompania=TipoCompaniaConstantesFunciones.getTodosTiposColumnasTipoCompania();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCompania) {
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
							field = TipoCompania.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCompania.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCompaniaDataAccess.setFieldReflectionTipoCompania(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCompania(Field field,String strPrefijo,String sColumn,TipoCompania entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCompaniaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCompaniaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCompaniaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCompaniaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCompaniaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCompania>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCompaniaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCompania();
					entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCompania("",entity,resultSet);
					
					//entity.setTipoCompaniaOriginal( new TipoCompania());
					//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCompanias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCompania(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCompania>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCompaniaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCompaniaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCompania> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
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
	
	public  List<TipoCompania> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCompania();
      	    	entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCompania("",entity,resultSet);
      	    	
				//entity.setTipoCompaniaOriginal( new TipoCompania());
      	    	//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCompanias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCompania(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCompania> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
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
	
	public  List<TipoCompania> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCompania> entities = new  ArrayList<TipoCompania>();
		TipoCompania entity = new TipoCompania();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCompania();
      	    	entity=super.getEntity("",entity,resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCompania("",entity,resultSet);
      	    	
				//entity.setTipoCompaniaOriginal( new TipoCompania());
      	    	//entity.setTipoCompaniaOriginal(super.getEntity("",entity.getTipoCompaniaOriginal(),resultSet,TipoCompaniaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCompaniaOriginal(this.getEntityTipoCompania("",entity.getTipoCompaniaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCompanias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCompania getEntityTipoCompania(String strPrefijo,TipoCompania entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoCompaniaConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCompaniaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCompaniaConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCompaniaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCompania(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCompania entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCompaniaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCompaniaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCompaniaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCompaniaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCompaniaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCompaniaDataAccess.TABLENAME,TipoCompaniaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCompaniaDataAccess.setTipoCompaniaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoCompania reltipocompania)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipocompania.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DatoConstitucion> getDatoConstitucions(Connexion connexion,TipoCompania tipocompania)throws SQLException,Exception {

		List<DatoConstitucion> datoconstitucions= new ArrayList<DatoConstitucion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCompaniaConstantesFunciones.SCHEMA+".tipo_compania ON "+DatoConstitucionConstantesFunciones.SCHEMA+".datoconstitucion.id_tipo_compania="+TipoCompaniaConstantesFunciones.SCHEMA+".tipo_compania.id WHERE "+TipoCompaniaConstantesFunciones.SCHEMA+".tipo_compania.id="+String.valueOf(tipocompania.getId());
			} else {
				sQuery=" INNER JOIN datoconstitucion.TipoCompania WHERE datoconstitucion.TipoCompania.id="+String.valueOf(tipocompania.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoConstitucionDataAccess datoconstitucionDataAccess=new DatoConstitucionDataAccess();

			datoconstitucionDataAccess.setConnexionType(this.connexionType);
			datoconstitucionDataAccess.setParameterDbType(this.parameterDbType);
			datoconstitucions=datoconstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datoconstitucions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCompania tipocompania) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocompania.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipocompania.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocompania.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocompania.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocompania.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocompania.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocompania.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocompania.getId());
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
	
	public void setIsNewIsChangedFalseTipoCompania(TipoCompania tipocompania)throws Exception  {		
		tipocompania.setIsNew(false);
		tipocompania.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCompanias(List<TipoCompania> tipocompanias)throws Exception  {				
		for(TipoCompania tipocompania:tipocompanias) {
			tipocompania.setIsNew(false);
			tipocompania.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCompania(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
