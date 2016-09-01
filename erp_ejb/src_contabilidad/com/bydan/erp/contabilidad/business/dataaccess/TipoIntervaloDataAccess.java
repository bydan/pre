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
package com.bydan.erp.contabilidad.business.dataaccess;

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

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//TipoIntervaloConstantesFunciones;


import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class TipoIntervaloDataAccess extends  DataAccessHelperSinIdGenerated<TipoIntervalo>{ //TipoIntervaloDataAccessAdditional,DataAccessHelper<TipoIntervalo>
	//static Logger logger = Logger.getLogger(TipoIntervaloDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_intervalo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+"(id,version_row,nombre)values(?,current_timestamp,?)";
	public static String QUERYUPDATE="update "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipointervalo from "+TipoIntervaloConstantesFunciones.SPERSISTENCENAME+" tipointervalo";
	public static String QUERYSELECTNATIVE="select "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".id,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".version_row,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".nombre from "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME;//+" as "+TipoIntervaloConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".id,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".version_row,"+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+".nombre from "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME;//+" as "+TipoIntervaloConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoIntervaloConstantesFunciones.SCHEMA+"."+TipoIntervaloConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOINTERVALO_INSERT(?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOINTERVALO_UPDATE(? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOINTERVALO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOINTERVALO_SELECT(?,?)";
	
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
	
	
	public TipoIntervaloDataAccess() {
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
		TipoIntervaloDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoIntervaloDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoIntervaloDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoIntervaloOriginal(TipoIntervalo tipointervalo)throws Exception  {
		tipointervalo.setTipoIntervaloOriginal((TipoIntervalo)tipointervalo.clone());		
	}
	
	public void setTipoIntervalosOriginal(List<TipoIntervalo> tipointervalos)throws Exception  {
		
		for(TipoIntervalo tipointervalo:tipointervalos){
			tipointervalo.setTipoIntervaloOriginal((TipoIntervalo)tipointervalo.clone());
		}
	}
	
	public static void setTipoIntervaloOriginalStatic(TipoIntervalo tipointervalo)throws Exception  {
		tipointervalo.setTipoIntervaloOriginal((TipoIntervalo)tipointervalo.clone());		
	}
	
	public static void setTipoIntervalosOriginalStatic(List<TipoIntervalo> tipointervalos)throws Exception  {
		
		for(TipoIntervalo tipointervalo:tipointervalos){
			tipointervalo.setTipoIntervaloOriginal((TipoIntervalo)tipointervalo.clone());
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
	
	public  TipoIntervalo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();		
		
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
	
	public  TipoIntervalo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoIntervalo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoIntervaloOriginal(new TipoIntervalo());
      	    	entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoIntervalo("",entity,resultSet); 
				
				//entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoIntervalo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoIntervalo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();
				
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
	
	public  TipoIntervalo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIntervaloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoIntervalo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoIntervaloOriginal(new TipoIntervalo());
      	    	entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoIntervalo("",entity,resultSet);    
				
				//entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoIntervalo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoIntervalo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoIntervalo entity = new TipoIntervalo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIntervaloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoIntervalo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoIntervalo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoIntervalo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		
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
	
	public  List<TipoIntervalo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIntervaloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIntervalo();
      	    	entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoIntervalo("",entity,resultSet);
      	    	
				//entity.setTipoIntervaloOriginal( new TipoIntervalo());
      	    	//entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoIntervalos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIntervalo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoIntervalo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
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
	
	public  List<TipoIntervalo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIntervalo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoIntervalo();
					//entity.setMapTipoIntervalo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoIntervaloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoIntervalo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         		
					entity=TipoIntervaloDataAccess.getEntityTipoIntervalo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoIntervaloOriginal( new TipoIntervalo());
					////entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoIntervalos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIntervalo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoIntervalo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();		  
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
	
	public  TipoIntervalo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIntervalo();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoIntervalo();
					//entity.setMapTipoIntervalo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoIntervaloValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoIntervalo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         		
					entity=TipoIntervaloDataAccess.getEntityTipoIntervalo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoIntervaloOriginal( new TipoIntervalo());
					////entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoIntervalo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIntervalo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoIntervalo getEntityTipoIntervalo(String strPrefijo,TipoIntervalo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoIntervalo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoIntervalo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoIntervaloDataAccess.setFieldReflectionTipoIntervalo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoIntervalo=TipoIntervaloConstantesFunciones.getTodosTiposColumnasTipoIntervalo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoIntervalo) {
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
							field = TipoIntervalo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoIntervalo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoIntervaloDataAccess.setFieldReflectionTipoIntervalo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoIntervalo(Field field,String strPrefijo,String sColumn,TipoIntervalo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoIntervaloConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoIntervaloConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoIntervaloConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoIntervalo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIntervaloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoIntervalo();
					entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoIntervalo("",entity,resultSet);
					
					//entity.setTipoIntervaloOriginal( new TipoIntervalo());
					//entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoIntervalos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIntervalo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoIntervalo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoIntervaloDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoIntervaloDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoIntervalo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
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
	
	public  List<TipoIntervalo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoIntervalo> entities = new  ArrayList<TipoIntervalo>();
		TipoIntervalo entity = new TipoIntervalo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoIntervalo();
      	    	entity=super.getEntity("",entity,resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoIntervalo("",entity,resultSet);
      	    	
				//entity.setTipoIntervaloOriginal( new TipoIntervalo());
      	    	//entity.setTipoIntervaloOriginal(super.getEntity("",entity.getTipoIntervaloOriginal(),resultSet,TipoIntervaloDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoIntervaloOriginal(this.getEntityTipoIntervalo("",entity.getTipoIntervaloOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoIntervalos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoIntervalo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoIntervalo getEntityTipoIntervalo(String strPrefijo,TipoIntervalo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setnombre(resultSet.getString(strPrefijo+TipoIntervaloConstantesFunciones.NOMBRE));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoIntervaloConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoIntervalo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoIntervalo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoIntervaloDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoIntervaloDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoIntervaloDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoIntervaloDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoIntervaloConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoIntervaloDataAccess.TABLENAME,TipoIntervaloDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoIntervaloDataAccess.setTipoIntervaloOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<CuentaContable> getCuentaContables(Connexion connexion,TipoIntervalo tipointervalo)throws SQLException,Exception {

		List<CuentaContable> cuentacontables= new ArrayList<CuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo ON "+CuentaContableConstantesFunciones.SCHEMA+".cuenta_contable.id_tipo_intervalo="+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id WHERE "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id="+String.valueOf(tipointervalo.getId());
			} else {
				sQuery=" INNER JOIN cuentacontable.TipoIntervalo WHERE cuentacontable.TipoIntervalo.id="+String.valueOf(tipointervalo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontables;

	}

	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos(Connexion connexion,TipoIntervalo tipointervalo)throws SQLException,Exception {

		List<ParametroContabilidadDefecto> parametrocontabilidaddefectos= new ArrayList<ParametroContabilidadDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo ON "+ParametroContabilidadDefectoConstantesFunciones.SCHEMA+".parametro_contabilidad_defecto.id_tipo_intervalo="+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id WHERE "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id="+String.valueOf(tipointervalo.getId());
			} else {
				sQuery=" INNER JOIN parametrocontabilidaddefecto.TipoIntervalo WHERE parametrocontabilidaddefecto.TipoIntervalo.id="+String.valueOf(tipointervalo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroContabilidadDefectoDataAccess parametrocontabilidaddefectoDataAccess=new ParametroContabilidadDefectoDataAccess();

			parametrocontabilidaddefectoDataAccess.setConnexionType(this.connexionType);
			parametrocontabilidaddefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrocontabilidaddefectos=parametrocontabilidaddefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrocontabilidaddefectos;

	}

	public List<TablaAmortiDetalle> getTablaAmortiDetalles(Connexion connexion,TipoIntervalo tipointervalo)throws SQLException,Exception {

		List<TablaAmortiDetalle> tablaamortidetalles= new ArrayList<TablaAmortiDetalle>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo ON "+TablaAmortiDetalleConstantesFunciones.SCHEMA+".tabla_amorti_detalle.id_tipo_intervalo="+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id WHERE "+TipoIntervaloConstantesFunciones.SCHEMA+".tipo_intervalo.id="+String.valueOf(tipointervalo.getId());
			} else {
				sQuery=" INNER JOIN tablaamortidetalle.TipoIntervalo WHERE tablaamortidetalle.TipoIntervalo.id="+String.valueOf(tipointervalo.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TablaAmortiDetalleDataAccess tablaamortidetalleDataAccess=new TablaAmortiDetalleDataAccess();

			tablaamortidetalleDataAccess.setConnexionType(this.connexionType);
			tablaamortidetalleDataAccess.setParameterDbType(this.parameterDbType);
			tablaamortidetalles=tablaamortidetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tablaamortidetalles;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoIntervalo tipointervalo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipointervalo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipointervalo.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipointervalo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipointervalo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipointervalo.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipointervalo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipointervalo.getId());
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
	
	public void setIsNewIsChangedFalseTipoIntervalo(TipoIntervalo tipointervalo)throws Exception  {		
		tipointervalo.setIsNew(false);
		tipointervalo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoIntervalos(List<TipoIntervalo> tipointervalos)throws Exception  {				
		for(TipoIntervalo tipointervalo:tipointervalos) {
			tipointervalo.setIsNew(false);
			tipointervalo.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoIntervalo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
