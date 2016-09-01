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
package com.bydan.erp.puntoventa.business.dataaccess;

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

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//TurnoPunVenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TurnoPunVenDataAccess extends  TurnoPunVenDataAccessAdditional{ //TurnoPunVenDataAccessAdditional,DataAccessHelper<TurnoPunVen>
	//static Logger logger = Logger.getLogger(TurnoPunVenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="turno_pun_ven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,nombre,hora_inicio,hora_fin)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,nombre=?,hora_inicio=?,hora_fin=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select turnopunven from "+TurnoPunVenConstantesFunciones.SPERSISTENCENAME+" turnopunven";
	public static String QUERYSELECTNATIVE="select "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".version_row,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_empresa,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id_usuario,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".nombre,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".hora_inicio,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".hora_fin from "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME;//+" as "+TurnoPunVenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".id,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".version_row,"+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+".nombre from "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME;//+" as "+TurnoPunVenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TurnoPunVenConstantesFunciones.SCHEMA+"."+TurnoPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,nombre=?,hora_inicio=?,hora_fin=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TURNOPUNVEN_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TURNOPUNVEN_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TURNOPUNVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TURNOPUNVEN_SELECT(?,?)";
	
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
	
	
	protected TurnoPunVenDataAccessAdditional turnopunvenDataAccessAdditional=null;
	
	public TurnoPunVenDataAccessAdditional getTurnoPunVenDataAccessAdditional() {
		return this.turnopunvenDataAccessAdditional;
	}
	
	public void setTurnoPunVenDataAccessAdditional(TurnoPunVenDataAccessAdditional turnopunvenDataAccessAdditional) {
		try {
			this.turnopunvenDataAccessAdditional=turnopunvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TurnoPunVenDataAccess() {
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
		TurnoPunVenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TurnoPunVenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TurnoPunVenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTurnoPunVenOriginal(TurnoPunVen turnopunven)throws Exception  {
		turnopunven.setTurnoPunVenOriginal((TurnoPunVen)turnopunven.clone());		
	}
	
	public void setTurnoPunVensOriginal(List<TurnoPunVen> turnopunvens)throws Exception  {
		
		for(TurnoPunVen turnopunven:turnopunvens){
			turnopunven.setTurnoPunVenOriginal((TurnoPunVen)turnopunven.clone());
		}
	}
	
	public static void setTurnoPunVenOriginalStatic(TurnoPunVen turnopunven)throws Exception  {
		turnopunven.setTurnoPunVenOriginal((TurnoPunVen)turnopunven.clone());		
	}
	
	public static void setTurnoPunVensOriginalStatic(List<TurnoPunVen> turnopunvens)throws Exception  {
		
		for(TurnoPunVen turnopunven:turnopunvens){
			turnopunven.setTurnoPunVenOriginal((TurnoPunVen)turnopunven.clone());
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
	
	public  TurnoPunVen getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();		
		
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
	
	public  TurnoPunVen getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.TurnoPunVen.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTurnoPunVenOriginal(new TurnoPunVen());
      	    	entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTurnoPunVen("",entity,resultSet); 
				
				//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTurnoPunVen(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TurnoPunVen getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();
				
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
	
	public  TurnoPunVen getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TurnoPunVen.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTurnoPunVenOriginal(new TurnoPunVen());
      	    	entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTurnoPunVen("",entity,resultSet);    
				
				//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTurnoPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TurnoPunVen
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TurnoPunVen entity = new TurnoPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.TurnoPunVen.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTurnoPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TurnoPunVen> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		
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
	
	public  List<TurnoPunVen> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TurnoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurnoPunVen("",entity,resultSet);
      	    	
				//entity.setTurnoPunVenOriginal( new TurnoPunVen());
      	    	//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnoPunVens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurnoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TurnoPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
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
	
	public  List<TurnoPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TurnoPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapTurnoPunVen();
					//entity.setMapTurnoPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTurnoPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTurnoPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=TurnoPunVenDataAccess.getEntityTurnoPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTurnoPunVenOriginal( new TurnoPunVen());
					////entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnoPunVens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurnoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TurnoPunVen getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();		  
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
	
	public  TurnoPunVen getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TurnoPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapTurnoPunVen();
					//entity.setMapTurnoPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTurnoPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTurnoPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=TurnoPunVenDataAccess.getEntityTurnoPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTurnoPunVenOriginal( new TurnoPunVen());
					////entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTurnoPunVen(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurnoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TurnoPunVen getEntityTurnoPunVen(String strPrefijo,TurnoPunVen entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TurnoPunVen.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TurnoPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TurnoPunVenDataAccess.setFieldReflectionTurnoPunVen(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTurnoPunVen=TurnoPunVenConstantesFunciones.getTodosTiposColumnasTurnoPunVen();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTurnoPunVen) {
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
							field = TurnoPunVen.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TurnoPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TurnoPunVenDataAccess.setFieldReflectionTurnoPunVen(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTurnoPunVen(Field field,String strPrefijo,String sColumn,TurnoPunVen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TurnoPunVenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.HORAINICIO:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case TurnoPunVenConstantesFunciones.HORAFIN:
					field.set(entity,resultSet.getTime(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TurnoPunVen>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TurnoPunVen();
					entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTurnoPunVen("",entity,resultSet);
					
					//entity.setTurnoPunVenOriginal( new TurnoPunVen());
					//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
					//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTurnoPunVens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurnoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TurnoPunVen>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TurnoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TurnoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TurnoPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
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
	
	public  List<TurnoPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TurnoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurnoPunVen("",entity,resultSet);
      	    	
				//entity.setTurnoPunVenOriginal( new TurnoPunVen());
      	    	//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTurnoPunVens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTurnoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TurnoPunVen> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
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
	
	public  List<TurnoPunVen> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TurnoPunVen> entities = new  ArrayList<TurnoPunVen>();
		TurnoPunVen entity = new TurnoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TurnoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTurnoPunVen("",entity,resultSet);
      	    	
				//entity.setTurnoPunVenOriginal( new TurnoPunVen());
      	    	//entity.setTurnoPunVenOriginal(super.getEntity("",entity.getTurnoPunVenOriginal(),resultSet,TurnoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTurnoPunVenOriginal(this.getEntityTurnoPunVen("",entity.getTurnoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTurnoPunVens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TurnoPunVen getEntityTurnoPunVen(String strPrefijo,TurnoPunVen entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TurnoPunVenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TurnoPunVenConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+TurnoPunVenConstantesFunciones.IDUSUARIO));
				entity.setnombre(resultSet.getString(strPrefijo+TurnoPunVenConstantesFunciones.NOMBRE));
				entity.sethora_inicio(resultSet.getTime(strPrefijo+TurnoPunVenConstantesFunciones.HORAINICIO));
				entity.sethora_fin(resultSet.getTime(strPrefijo+TurnoPunVenConstantesFunciones.HORAFIN));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TurnoPunVenConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTurnoPunVen(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TurnoPunVen entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TurnoPunVenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TurnoPunVenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TurnoPunVenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TurnoPunVenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TurnoPunVenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TurnoPunVenDataAccess.TABLENAME,TurnoPunVenDataAccess.ISWITHSTOREPROCEDURES);
			
			TurnoPunVenDataAccess.setTurnoPunVenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TurnoPunVen relturnopunven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relturnopunven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TurnoPunVen relturnopunven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relturnopunven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,TurnoPunVen relturnopunven)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relturnopunven.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
		public List<CajaIngreso> getCajaIngresos(Connexion connexion,TurnoPunVen turnopunven)throws SQLException,Exception {

		List<CajaIngreso> cajaingresos= new ArrayList<CajaIngreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven ON "+CajaIngresoConstantesFunciones.SCHEMA+".caja_ingreso.id_turno_pun_ven="+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id WHERE "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id="+String.valueOf(turnopunven.getId());
			} else {
				sQuery=" INNER JOIN cajaingreso.TurnoPunVen WHERE cajaingreso.TurnoPunVen.id="+String.valueOf(turnopunven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaIngresoDataAccess cajaingresoDataAccess=new CajaIngresoDataAccess();

			cajaingresoDataAccess.setConnexionType(this.connexionType);
			cajaingresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaingresos=cajaingresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaingresos;

	}

	public List<CajeroTurno> getCajeroTurnos(Connexion connexion,TurnoPunVen turnopunven)throws SQLException,Exception {

		List<CajeroTurno> cajeroturnos= new ArrayList<CajeroTurno>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven ON "+CajeroTurnoConstantesFunciones.SCHEMA+".cajero_turno.id_turno_pun_ven="+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id WHERE "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id="+String.valueOf(turnopunven.getId());
			} else {
				sQuery=" INNER JOIN cajeroturno.TurnoPunVen WHERE cajeroturno.TurnoPunVen.id="+String.valueOf(turnopunven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajeroTurnoDataAccess cajeroturnoDataAccess=new CajeroTurnoDataAccess();

			cajeroturnoDataAccess.setConnexionType(this.connexionType);
			cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajeroturnos;

	}

	public List<CajaEgreso> getCajaEgresos(Connexion connexion,TurnoPunVen turnopunven)throws SQLException,Exception {

		List<CajaEgreso> cajaegresos= new ArrayList<CajaEgreso>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven ON "+CajaEgresoConstantesFunciones.SCHEMA+".caja_egreso.id_turno_pun_ven="+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id WHERE "+TurnoPunVenConstantesFunciones.SCHEMA+".turno_pun_ven.id="+String.valueOf(turnopunven.getId());
			} else {
				sQuery=" INNER JOIN cajaegreso.TurnoPunVen WHERE cajaegreso.TurnoPunVen.id="+String.valueOf(turnopunven.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajaEgresoDataAccess cajaegresoDataAccess=new CajaEgresoDataAccess();

			cajaegresoDataAccess.setConnexionType(this.connexionType);
			cajaegresoDataAccess.setParameterDbType(this.parameterDbType);
			cajaegresos=cajaegresoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajaegresos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TurnoPunVen turnopunven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!turnopunven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(turnopunven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(turnopunven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(turnopunven.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(turnopunven.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_inicio=new ParameterValue<Time>();
					parameterMaintenanceValuehora_inicio.setValue(turnopunven.gethora_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora_fin=new ParameterValue<Time>();
					parameterMaintenanceValuehora_fin.setValue(turnopunven.gethora_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora_fin);
					parametersTemp.add(parameterMaintenance);
					
						if(!turnopunven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(turnopunven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(turnopunven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(turnopunven.getId());
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
	
	public void setIsNewIsChangedFalseTurnoPunVen(TurnoPunVen turnopunven)throws Exception  {		
		turnopunven.setIsNew(false);
		turnopunven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTurnoPunVens(List<TurnoPunVen> turnopunvens)throws Exception  {				
		for(TurnoPunVen turnopunven:turnopunvens) {
			turnopunven.setIsNew(false);
			turnopunven.setIsChanged(false);
		}
	}
	
	public void generarExportarTurnoPunVen(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
