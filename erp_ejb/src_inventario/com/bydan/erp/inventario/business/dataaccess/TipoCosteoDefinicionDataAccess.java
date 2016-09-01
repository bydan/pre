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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//TipoCosteoDefinicionConstantesFunciones;










@SuppressWarnings("unused")
final public class TipoCosteoDefinicionDataAccess extends  DataAccessHelperSinIdGenerated<TipoCosteoDefinicion>{ //TipoCosteoDefinicionDataAccessAdditional,DataAccessHelper<TipoCosteoDefinicion>
	//static Logger logger = Logger.getLogger(TipoCosteoDefinicionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_costeo_definicion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocosteodefinicion from "+TipoCosteoDefinicionConstantesFunciones.SPERSISTENCENAME+" tipocosteodefinicion";
	public static String QUERYSELECTNATIVE="select "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".id,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".version_row,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".codigo,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".nombre from "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME;//+" as "+TipoCosteoDefinicionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".id,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".version_row,"+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+".codigo from "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME;//+" as "+TipoCosteoDefinicionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+"."+TipoCosteoDefinicionConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCOSTEODEFINICION_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCOSTEODEFINICION_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCOSTEODEFINICION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCOSTEODEFINICION_SELECT(?,?)";
	
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
	
	
	public TipoCosteoDefinicionDataAccess() {
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
		TipoCosteoDefinicionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCosteoDefinicionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCosteoDefinicionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCosteoDefinicionOriginal(TipoCosteoDefinicion tipocosteodefinicion)throws Exception  {
		tipocosteodefinicion.setTipoCosteoDefinicionOriginal((TipoCosteoDefinicion)tipocosteodefinicion.clone());		
	}
	
	public void setTipoCosteoDefinicionsOriginal(List<TipoCosteoDefinicion> tipocosteodefinicions)throws Exception  {
		
		for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions){
			tipocosteodefinicion.setTipoCosteoDefinicionOriginal((TipoCosteoDefinicion)tipocosteodefinicion.clone());
		}
	}
	
	public static void setTipoCosteoDefinicionOriginalStatic(TipoCosteoDefinicion tipocosteodefinicion)throws Exception  {
		tipocosteodefinicion.setTipoCosteoDefinicionOriginal((TipoCosteoDefinicion)tipocosteodefinicion.clone());		
	}
	
	public static void setTipoCosteoDefinicionsOriginalStatic(List<TipoCosteoDefinicion> tipocosteodefinicions)throws Exception  {
		
		for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions){
			tipocosteodefinicion.setTipoCosteoDefinicionOriginal((TipoCosteoDefinicion)tipocosteodefinicion.clone());
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
	
	public  TipoCosteoDefinicion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		
		
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
	
	public  TipoCosteoDefinicion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoCosteoDefinicion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCosteoDefinicionOriginal(new TipoCosteoDefinicion());
      	    	entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCosteoDefinicion("",entity,resultSet); 
				
				//entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCosteoDefinicion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCosteoDefinicion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();
				
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
	
	public  TipoCosteoDefinicion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCosteoDefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoCosteoDefinicion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCosteoDefinicionOriginal(new TipoCosteoDefinicion());
      	    	entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCosteoDefinicion("",entity,resultSet);    
				
				//entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCosteoDefinicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCosteoDefinicion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCosteoDefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoCosteoDefinicion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCosteoDefinicion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCosteoDefinicion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		
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
	
	public  List<TipoCosteoDefinicion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCosteoDefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCosteoDefinicion();
      	    	entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCosteoDefinicion("",entity,resultSet);
      	    	
				//entity.setTipoCosteoDefinicionOriginal( new TipoCosteoDefinicion());
      	    	//entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCosteoDefinicions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCosteoDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCosteoDefinicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
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
	
	public  List<TipoCosteoDefinicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCosteoDefinicion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCosteoDefinicion();
					//entity.setMapTipoCosteoDefinicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCosteoDefinicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCosteoDefinicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         		
					entity=TipoCosteoDefinicionDataAccess.getEntityTipoCosteoDefinicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCosteoDefinicionOriginal( new TipoCosteoDefinicion());
					////entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCosteoDefinicions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCosteoDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCosteoDefinicion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
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
	
	public  TipoCosteoDefinicion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCosteoDefinicion();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCosteoDefinicion();
					//entity.setMapTipoCosteoDefinicion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCosteoDefinicionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCosteoDefinicion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         		
					entity=TipoCosteoDefinicionDataAccess.getEntityTipoCosteoDefinicion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCosteoDefinicionOriginal( new TipoCosteoDefinicion());
					////entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCosteoDefinicion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCosteoDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCosteoDefinicion getEntityTipoCosteoDefinicion(String strPrefijo,TipoCosteoDefinicion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCosteoDefinicion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCosteoDefinicion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCosteoDefinicionDataAccess.setFieldReflectionTipoCosteoDefinicion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCosteoDefinicion=TipoCosteoDefinicionConstantesFunciones.getTodosTiposColumnasTipoCosteoDefinicion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCosteoDefinicion) {
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
							field = TipoCosteoDefinicion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCosteoDefinicion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCosteoDefinicionDataAccess.setFieldReflectionTipoCosteoDefinicion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCosteoDefinicion(Field field,String strPrefijo,String sColumn,TipoCosteoDefinicion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCosteoDefinicionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCosteoDefinicionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCosteoDefinicionConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCosteoDefinicionConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCosteoDefinicion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCosteoDefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCosteoDefinicion();
					entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCosteoDefinicion("",entity,resultSet);
					
					//entity.setTipoCosteoDefinicionOriginal( new TipoCosteoDefinicion());
					//entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCosteoDefinicions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCosteoDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCosteoDefinicion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCosteoDefinicionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCosteoDefinicionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCosteoDefinicion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
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
	
	public  List<TipoCosteoDefinicion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCosteoDefinicion> entities = new  ArrayList<TipoCosteoDefinicion>();
		TipoCosteoDefinicion entity = new TipoCosteoDefinicion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCosteoDefinicion();
      	    	entity=super.getEntity("",entity,resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCosteoDefinicion("",entity,resultSet);
      	    	
				//entity.setTipoCosteoDefinicionOriginal( new TipoCosteoDefinicion());
      	    	//entity.setTipoCosteoDefinicionOriginal(super.getEntity("",entity.getTipoCosteoDefinicionOriginal(),resultSet,TipoCosteoDefinicionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCosteoDefinicionOriginal(this.getEntityTipoCosteoDefinicion("",entity.getTipoCosteoDefinicionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCosteoDefinicions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCosteoDefinicion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoCosteoDefinicion getEntityTipoCosteoDefinicion(String strPrefijo,TipoCosteoDefinicion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCosteoDefinicionConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCosteoDefinicionConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCosteoDefinicionConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCosteoDefinicion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCosteoDefinicion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCosteoDefinicionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCosteoDefinicionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCosteoDefinicionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCosteoDefinicionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCosteoDefinicionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCosteoDefinicionDataAccess.TABLENAME,TipoCosteoDefinicionDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCosteoDefinicionDataAccess.setTipoCosteoDefinicionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Definicion> getDefinicions(Connexion connexion,TipoCosteoDefinicion tipocosteodefinicion)throws SQLException,Exception {

		List<Definicion> definicions= new ArrayList<Definicion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+".tipo_costeo_definicion ON "+DefinicionConstantesFunciones.SCHEMA+".definicion.id_tipo_costeo_definicion="+TipoCosteoDefinicionConstantesFunciones.SCHEMA+".tipo_costeo_definicion.id WHERE "+TipoCosteoDefinicionConstantesFunciones.SCHEMA+".tipo_costeo_definicion.id="+String.valueOf(tipocosteodefinicion.getId());
			} else {
				sQuery=" INNER JOIN definicion.TipoCosteoDefinicion WHERE definicion.TipoCosteoDefinicion.id="+String.valueOf(tipocosteodefinicion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DefinicionDataAccess definicionDataAccess=new DefinicionDataAccess();

			definicionDataAccess.setConnexionType(this.connexionType);
			definicionDataAccess.setParameterDbType(this.parameterDbType);
			definicions=definicionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return definicions;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCosteoDefinicion tipocosteodefinicion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocosteodefinicion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocosteodefinicion.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocosteodefinicion.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocosteodefinicion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocosteodefinicion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocosteodefinicion.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocosteodefinicion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocosteodefinicion.getId());
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
	
	public void setIsNewIsChangedFalseTipoCosteoDefinicion(TipoCosteoDefinicion tipocosteodefinicion)throws Exception  {		
		tipocosteodefinicion.setIsNew(false);
		tipocosteodefinicion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCosteoDefinicions(List<TipoCosteoDefinicion> tipocosteodefinicions)throws Exception  {				
		for(TipoCosteoDefinicion tipocosteodefinicion:tipocosteodefinicions) {
			tipocosteodefinicion.setIsNew(false);
			tipocosteodefinicion.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCosteoDefinicion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
