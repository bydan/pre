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
package com.bydan.erp.tesoreria.business.dataaccess;

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

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//TipoMovimiento_TSConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoMovimiento_TSDataAccess extends  TipoMovimiento_TSDataAccessAdditional{ //TipoMovimiento_TSDataAccessAdditional,DataAccessHelper<TipoMovimiento_TS>
	//static Logger logger = Logger.getLogger(TipoMovimiento_TSDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_movimiento__t_s";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+"(version_row,codigo,nombre,id_empresa)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=?,id_empresa=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipomovimiento_ts from "+TipoMovimiento_TSConstantesFunciones.SPERSISTENCENAME+" tipomovimiento_ts";
	public static String QUERYSELECTNATIVE="select "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".id,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".version_row,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".codigo,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".nombre,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".id_empresa from "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME;//+" as "+TipoMovimiento_TSConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".id,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".version_row,"+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+".codigo from "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME;//+" as "+TipoMovimiento_TSConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoMovimiento_TSConstantesFunciones.SCHEMA+"."+TipoMovimiento_TSConstantesFunciones.TABLENAME+" set version_row=current_timestamp,codigo=?,nombre=?,id_empresa=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOMOVIMIENTO_TS_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOMOVIMIENTO_TS_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOMOVIMIENTO_TS_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOMOVIMIENTO_TS_SELECT(?,?)";
	
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
	
	
	protected TipoMovimiento_TSDataAccessAdditional tipomovimiento_tsDataAccessAdditional=null;
	
	public TipoMovimiento_TSDataAccessAdditional getTipoMovimiento_TSDataAccessAdditional() {
		return this.tipomovimiento_tsDataAccessAdditional;
	}
	
	public void setTipoMovimiento_TSDataAccessAdditional(TipoMovimiento_TSDataAccessAdditional tipomovimiento_tsDataAccessAdditional) {
		try {
			this.tipomovimiento_tsDataAccessAdditional=tipomovimiento_tsDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoMovimiento_TSDataAccess() {
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
		TipoMovimiento_TSDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoMovimiento_TSDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoMovimiento_TSDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoMovimiento_TSOriginal(TipoMovimiento_TS tipomovimiento_ts)throws Exception  {
		tipomovimiento_ts.setTipoMovimiento_TSOriginal((TipoMovimiento_TS)tipomovimiento_ts.clone());		
	}
	
	public void setTipoMovimiento_TSsOriginal(List<TipoMovimiento_TS> tipomovimiento_tss)throws Exception  {
		
		for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss){
			tipomovimiento_ts.setTipoMovimiento_TSOriginal((TipoMovimiento_TS)tipomovimiento_ts.clone());
		}
	}
	
	public static void setTipoMovimiento_TSOriginalStatic(TipoMovimiento_TS tipomovimiento_ts)throws Exception  {
		tipomovimiento_ts.setTipoMovimiento_TSOriginal((TipoMovimiento_TS)tipomovimiento_ts.clone());		
	}
	
	public static void setTipoMovimiento_TSsOriginalStatic(List<TipoMovimiento_TS> tipomovimiento_tss)throws Exception  {
		
		for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss){
			tipomovimiento_ts.setTipoMovimiento_TSOriginal((TipoMovimiento_TS)tipomovimiento_ts.clone());
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
	
	public  TipoMovimiento_TS getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		
		
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
	
	public  TipoMovimiento_TS getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoMovimiento_TS.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoMovimiento_TSOriginal(new TipoMovimiento_TS());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimiento_TS("",entity,resultSet); 
				
				//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimiento_TS(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoMovimiento_TS getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();
				
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
	
	public  TipoMovimiento_TS getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimiento_TSDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoMovimiento_TS.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoMovimiento_TSOriginal(new TipoMovimiento_TS());
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoMovimiento_TS("",entity,resultSet);    
				
				//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoMovimiento_TS(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoMovimiento_TS
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoMovimiento_TS entity = new TipoMovimiento_TS();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimiento_TSDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoMovimiento_TS.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoMovimiento_TS(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoMovimiento_TS> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		
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
	
	public  List<TipoMovimiento_TS> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimiento_TSDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento_TS();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimiento_TS("",entity,resultSet);
      	    	
				//entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
      	    	//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimiento_TSs(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento_TS(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMovimiento_TS> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
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
	
	public  List<TipoMovimiento_TS> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento_TS();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimiento_TS();
					//entity.setMapTipoMovimiento_TS(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoMovimiento_TSValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimiento_TS().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimiento_TSDataAccess.getEntityTipoMovimiento_TS("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
					////entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimiento_TSs(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento_TS(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoMovimiento_TS getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
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
	
	public  TipoMovimiento_TS getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento_TS();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoMovimiento_TS();
					//entity.setMapTipoMovimiento_TS(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoMovimiento_TSValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoMovimiento_TS().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
					entity=TipoMovimiento_TSDataAccess.getEntityTipoMovimiento_TS("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
					////entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoMovimiento_TS(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento_TS(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoMovimiento_TS getEntityTipoMovimiento_TS(String strPrefijo,TipoMovimiento_TS entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoMovimiento_TS.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoMovimiento_TS.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoMovimiento_TSDataAccess.setFieldReflectionTipoMovimiento_TS(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoMovimiento_TS=TipoMovimiento_TSConstantesFunciones.getTodosTiposColumnasTipoMovimiento_TS();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoMovimiento_TS) {
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
							field = TipoMovimiento_TS.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoMovimiento_TS.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoMovimiento_TSDataAccess.setFieldReflectionTipoMovimiento_TS(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoMovimiento_TS(Field field,String strPrefijo,String sColumn,TipoMovimiento_TS entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoMovimiento_TSConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoMovimiento_TSConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimiento_TSConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimiento_TSConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoMovimiento_TSConstantesFunciones.IDEMPRESA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimiento_TS>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimiento_TSDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoMovimiento_TS();
					entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoMovimiento_TS("",entity,resultSet);
					
					//entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
					//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoMovimiento_TSs(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento_TS(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoMovimiento_TS>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoMovimiento_TSDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoMovimiento_TSDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoMovimiento_TS> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
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
	
	public  List<TipoMovimiento_TS> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento_TS();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimiento_TS("",entity,resultSet);
      	    	
				//entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
      	    	//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoMovimiento_TSs(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoMovimiento_TS(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoMovimiento_TS> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
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
	
	public  List<TipoMovimiento_TS> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoMovimiento_TS> entities = new  ArrayList<TipoMovimiento_TS>();
		TipoMovimiento_TS entity = new TipoMovimiento_TS();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoMovimiento_TS();
      	    	entity=super.getEntity("",entity,resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoMovimiento_TS("",entity,resultSet);
      	    	
				//entity.setTipoMovimiento_TSOriginal( new TipoMovimiento_TS());
      	    	//entity.setTipoMovimiento_TSOriginal(super.getEntity("",entity.getTipoMovimiento_TSOriginal(),resultSet,TipoMovimiento_TSDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoMovimiento_TSOriginal(this.getEntityTipoMovimiento_TS("",entity.getTipoMovimiento_TSOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoMovimiento_TSs(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoMovimiento_TS getEntityTipoMovimiento_TS(String strPrefijo,TipoMovimiento_TS entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMovimiento_TSConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoMovimiento_TSConstantesFunciones.NOMBRE));
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoMovimiento_TSConstantesFunciones.IDEMPRESA));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoMovimiento_TSConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoMovimiento_TS(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoMovimiento_TS entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoMovimiento_TSDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoMovimiento_TSDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoMovimiento_TSDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoMovimiento_TSDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoMovimiento_TSConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoMovimiento_TSDataAccess.TABLENAME,TipoMovimiento_TSDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoMovimiento_TSDataAccess.setTipoMovimiento_TSOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoMovimiento_TS reltipomovimiento_ts)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipomovimiento_ts.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoMovimiento_TS tipomovimiento_ts) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipomovimiento_ts.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipomovimiento_ts.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipomovimiento_ts.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipomovimiento_ts.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipomovimiento_ts.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipomovimiento_ts.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipomovimiento_ts.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipomovimiento_ts.getId());
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
	
	public void setIsNewIsChangedFalseTipoMovimiento_TS(TipoMovimiento_TS tipomovimiento_ts)throws Exception  {		
		tipomovimiento_ts.setIsNew(false);
		tipomovimiento_ts.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoMovimiento_TSs(List<TipoMovimiento_TS> tipomovimiento_tss)throws Exception  {				
		for(TipoMovimiento_TS tipomovimiento_ts:tipomovimiento_tss) {
			tipomovimiento_ts.setIsNew(false);
			tipomovimiento_ts.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoMovimiento_TS(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
