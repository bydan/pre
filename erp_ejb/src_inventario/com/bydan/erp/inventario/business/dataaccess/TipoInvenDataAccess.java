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
import com.bydan.erp.inventario.util.*;//TipoInvenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoInvenDataAccess extends  TipoInvenDataAccessAdditional{ //TipoInvenDataAccessAdditional,DataAccessHelper<TipoInven>
	//static Logger logger = Logger.getLogger(TipoInvenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_inven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoinven from "+TipoInvenConstantesFunciones.SPERSISTENCENAME+" tipoinven";
	public static String QUERYSELECTNATIVE="select "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".id,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".id_empresa,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".codigo,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".nombre from "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME;//+" as "+TipoInvenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".id,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".codigo from "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME;//+" as "+TipoInvenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOINVEN_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOINVEN_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOINVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOINVEN_SELECT(?,?)";
	
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
	
	
	protected TipoInvenDataAccessAdditional tipoinvenDataAccessAdditional=null;
	
	public TipoInvenDataAccessAdditional getTipoInvenDataAccessAdditional() {
		return this.tipoinvenDataAccessAdditional;
	}
	
	public void setTipoInvenDataAccessAdditional(TipoInvenDataAccessAdditional tipoinvenDataAccessAdditional) {
		try {
			this.tipoinvenDataAccessAdditional=tipoinvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoInvenDataAccess() {
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
		TipoInvenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoInvenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoInvenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoInvenOriginal(TipoInven tipoinven)throws Exception  {
		tipoinven.setTipoInvenOriginal((TipoInven)tipoinven.clone());		
	}
	
	public void setTipoInvensOriginal(List<TipoInven> tipoinvens)throws Exception  {
		
		for(TipoInven tipoinven:tipoinvens){
			tipoinven.setTipoInvenOriginal((TipoInven)tipoinven.clone());
		}
	}
	
	public static void setTipoInvenOriginalStatic(TipoInven tipoinven)throws Exception  {
		tipoinven.setTipoInvenOriginal((TipoInven)tipoinven.clone());		
	}
	
	public static void setTipoInvensOriginalStatic(List<TipoInven> tipoinvens)throws Exception  {
		
		for(TipoInven tipoinven:tipoinvens){
			tipoinven.setTipoInvenOriginal((TipoInven)tipoinven.clone());
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
	
	public  TipoInven getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoInven entity = new TipoInven();		
		
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
	
	public  TipoInven getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoInven entity = new TipoInven();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoInven.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoInvenOriginal(new TipoInven());
      	    	entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoInven("",entity,resultSet); 
				
				//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoInven(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoInven getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoInven entity = new TipoInven();
				
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
	
	public  TipoInven getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoInven entity = new TipoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoInven.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoInvenOriginal(new TipoInven());
      	    	entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoInven("",entity,resultSet);    
				
				//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoInven
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoInven entity = new TipoInven();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoInven.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoInven(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoInven> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		
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
	
	public  List<TipoInven> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInven();
      	    	entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoInven("",entity,resultSet);
      	    	
				//entity.setTipoInvenOriginal( new TipoInven());
      	    	//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoInvens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
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
	
	public  List<TipoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoInven();
					//entity.setMapTipoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
					entity=TipoInvenDataAccess.getEntityTipoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoInvenOriginal( new TipoInven());
					////entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoInvens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoInven getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoInven entity = new TipoInven();		  
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
	
	public  TipoInven getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoInven entity = new TipoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInven();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoInven();
					//entity.setMapTipoInven(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoInvenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoInven().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
					entity=TipoInvenDataAccess.getEntityTipoInven("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoInvenOriginal( new TipoInven());
					////entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoInven(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoInven getEntityTipoInven(String strPrefijo,TipoInven entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoInven.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoInvenDataAccess.setFieldReflectionTipoInven(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoInven=TipoInvenConstantesFunciones.getTodosTiposColumnasTipoInven();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoInven) {
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
							field = TipoInven.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoInven.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoInvenDataAccess.setFieldReflectionTipoInven(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoInven(Field field,String strPrefijo,String sColumn,TipoInven entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoInvenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoInvenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoInvenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoInvenConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoInvenConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoInven>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoInven();
					entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoInven("",entity,resultSet);
					
					//entity.setTipoInvenOriginal( new TipoInven());
					//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoInvens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInven(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoInven>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoInvenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoInvenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoInven> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
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
	
	public  List<TipoInven> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInven();
      	    	entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoInven("",entity,resultSet);
      	    	
				//entity.setTipoInvenOriginal( new TipoInven());
      	    	//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoInvens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoInven(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoInven> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
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
	
	public  List<TipoInven> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoInven> entities = new  ArrayList<TipoInven>();
		TipoInven entity = new TipoInven();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoInven();
      	    	entity=super.getEntity("",entity,resultSet,TipoInvenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoInven("",entity,resultSet);
      	    	
				//entity.setTipoInvenOriginal( new TipoInven());
      	    	//entity.setTipoInvenOriginal(super.getEntity("",entity.getTipoInvenOriginal(),resultSet,TipoInvenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoInvenOriginal(this.getEntityTipoInven("",entity.getTipoInvenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoInvens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoInven getEntityTipoInven(String strPrefijo,TipoInven entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoInvenConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoInvenConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoInvenConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoInvenConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoInven(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoInven entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoInvenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoInvenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoInvenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoInvenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoInvenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoInvenDataAccess.TABLENAME,TipoInvenDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoInvenDataAccess.setTipoInvenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoInven reltipoinven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoinven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoInven tipoinven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoinven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoinven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoinven.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoinven.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoinven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoinven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoinven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoinven.getId());
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
	
	public void setIsNewIsChangedFalseTipoInven(TipoInven tipoinven)throws Exception  {		
		tipoinven.setIsNew(false);
		tipoinven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoInvens(List<TipoInven> tipoinvens)throws Exception  {				
		for(TipoInven tipoinven:tipoinvens) {
			tipoinven.setIsNew(false);
			tipoinven.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoInven(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
