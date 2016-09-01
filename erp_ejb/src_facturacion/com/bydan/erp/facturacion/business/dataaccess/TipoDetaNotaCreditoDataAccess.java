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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TipoDetaNotaCreditoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoDetaNotaCreditoDataAccess extends  TipoDetaNotaCreditoDataAccessAdditional{ //TipoDetaNotaCreditoDataAccessAdditional,DataAccessHelper<TipoDetaNotaCredito>
	//static Logger logger = Logger.getLogger(TipoDetaNotaCreditoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_deta_nota_credito";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipodetanotacredito from "+TipoDetaNotaCreditoConstantesFunciones.SPERSISTENCENAME+" tipodetanotacredito";
	public static String QUERYSELECTNATIVE="select "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".codigo,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".nombre from "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".id,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".version_row,"+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+".codigo from "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;//+" as "+TipoDetaNotaCreditoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+"."+TipoDetaNotaCreditoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPODETANOTACREDITO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPODETANOTACREDITO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPODETANOTACREDITO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPODETANOTACREDITO_SELECT(?,?)";
	
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
	
	
	protected TipoDetaNotaCreditoDataAccessAdditional tipodetanotacreditoDataAccessAdditional=null;
	
	public TipoDetaNotaCreditoDataAccessAdditional getTipoDetaNotaCreditoDataAccessAdditional() {
		return this.tipodetanotacreditoDataAccessAdditional;
	}
	
	public void setTipoDetaNotaCreditoDataAccessAdditional(TipoDetaNotaCreditoDataAccessAdditional tipodetanotacreditoDataAccessAdditional) {
		try {
			this.tipodetanotacreditoDataAccessAdditional=tipodetanotacreditoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoDetaNotaCreditoDataAccess() {
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
		TipoDetaNotaCreditoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoDetaNotaCreditoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoDetaNotaCreditoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoDetaNotaCreditoOriginal(TipoDetaNotaCredito tipodetanotacredito)throws Exception  {
		tipodetanotacredito.setTipoDetaNotaCreditoOriginal((TipoDetaNotaCredito)tipodetanotacredito.clone());		
	}
	
	public void setTipoDetaNotaCreditosOriginal(List<TipoDetaNotaCredito> tipodetanotacreditos)throws Exception  {
		
		for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos){
			tipodetanotacredito.setTipoDetaNotaCreditoOriginal((TipoDetaNotaCredito)tipodetanotacredito.clone());
		}
	}
	
	public static void setTipoDetaNotaCreditoOriginalStatic(TipoDetaNotaCredito tipodetanotacredito)throws Exception  {
		tipodetanotacredito.setTipoDetaNotaCreditoOriginal((TipoDetaNotaCredito)tipodetanotacredito.clone());		
	}
	
	public static void setTipoDetaNotaCreditosOriginalStatic(List<TipoDetaNotaCredito> tipodetanotacreditos)throws Exception  {
		
		for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos){
			tipodetanotacredito.setTipoDetaNotaCreditoOriginal((TipoDetaNotaCredito)tipodetanotacredito.clone());
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
	
	public  TipoDetaNotaCredito getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		
		
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
	
	public  TipoDetaNotaCredito getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TipoDetaNotaCredito.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoDetaNotaCreditoOriginal(new TipoDetaNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet); 
				
				//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetaNotaCredito(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoDetaNotaCredito getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();
				
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
	
	public  TipoDetaNotaCredito getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDetaNotaCredito.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoDetaNotaCreditoOriginal(new TipoDetaNotaCredito());
      	    	entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet);    
				
				//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoDetaNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoDetaNotaCredito
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TipoDetaNotaCredito.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoDetaNotaCredito(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoDetaNotaCredito> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		
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
	
	public  List<TipoDetaNotaCredito> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
      	    	//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetaNotaCreditos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDetaNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
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
	
	public  List<TipoDetaNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetaNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetaNotaCredito();
					//entity.setMapTipoDetaNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoDetaNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetaNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetaNotaCreditoDataAccess.getEntityTipoDetaNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
					////entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetaNotaCreditos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoDetaNotaCredito getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
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
	
	public  TipoDetaNotaCredito getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetaNotaCredito();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoDetaNotaCredito();
					//entity.setMapTipoDetaNotaCredito(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoDetaNotaCreditoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoDetaNotaCredito().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=TipoDetaNotaCreditoDataAccess.getEntityTipoDetaNotaCredito("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
					////entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoDetaNotaCredito(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoDetaNotaCredito getEntityTipoDetaNotaCredito(String strPrefijo,TipoDetaNotaCredito entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoDetaNotaCredito.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoDetaNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoDetaNotaCreditoDataAccess.setFieldReflectionTipoDetaNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoDetaNotaCredito=TipoDetaNotaCreditoConstantesFunciones.getTodosTiposColumnasTipoDetaNotaCredito();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoDetaNotaCredito) {
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
							field = TipoDetaNotaCredito.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoDetaNotaCredito.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoDetaNotaCreditoDataAccess.setFieldReflectionTipoDetaNotaCredito(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoDetaNotaCredito(Field field,String strPrefijo,String sColumn,TipoDetaNotaCredito entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoDetaNotaCreditoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDetaNotaCreditoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoDetaNotaCreditoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoDetaNotaCreditoConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetaNotaCredito>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoDetaNotaCredito();
					entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet);
					
					//entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
					//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoDetaNotaCreditos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoDetaNotaCredito>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoDetaNotaCreditoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoDetaNotaCreditoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoDetaNotaCredito> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
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
	
	public  List<TipoDetaNotaCredito> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
      	    	//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoDetaNotaCreditos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoDetaNotaCredito(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoDetaNotaCredito> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
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
	
	public  List<TipoDetaNotaCredito> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoDetaNotaCredito> entities = new  ArrayList<TipoDetaNotaCredito>();
		TipoDetaNotaCredito entity = new TipoDetaNotaCredito();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoDetaNotaCredito();
      	    	entity=super.getEntity("",entity,resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoDetaNotaCredito("",entity,resultSet);
      	    	
				//entity.setTipoDetaNotaCreditoOriginal( new TipoDetaNotaCredito());
      	    	//entity.setTipoDetaNotaCreditoOriginal(super.getEntity("",entity.getTipoDetaNotaCreditoOriginal(),resultSet,TipoDetaNotaCreditoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoDetaNotaCreditoOriginal(this.getEntityTipoDetaNotaCredito("",entity.getTipoDetaNotaCreditoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoDetaNotaCreditos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoDetaNotaCredito getEntityTipoDetaNotaCredito(String strPrefijo,TipoDetaNotaCredito entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoDetaNotaCreditoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetaNotaCreditoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoDetaNotaCreditoConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoDetaNotaCreditoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoDetaNotaCredito(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoDetaNotaCredito entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoDetaNotaCreditoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoDetaNotaCreditoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoDetaNotaCreditoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoDetaNotaCreditoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoDetaNotaCreditoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoDetaNotaCreditoDataAccess.TABLENAME,TipoDetaNotaCreditoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoDetaNotaCreditoDataAccess.setTipoDetaNotaCreditoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoDetaNotaCredito reltipodetanotacredito)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipodetanotacredito.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<DetaNotaCredito> getDetaNotaCreditos(Connexion connexion,TipoDetaNotaCredito tipodetanotacredito)throws SQLException,Exception {

		List<DetaNotaCredito> detanotacreditos= new ArrayList<DetaNotaCredito>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+".tipo_deta_nota_credito ON "+DetaNotaCreditoConstantesFunciones.SCHEMA+".deta_nota_credito.id_tipo_deta_nota_credito="+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+".tipo_deta_nota_credito.id WHERE "+TipoDetaNotaCreditoConstantesFunciones.SCHEMA+".tipo_deta_nota_credito.id="+String.valueOf(tipodetanotacredito.getId());
			} else {
				sQuery=" INNER JOIN detanotacredito.TipoDetaNotaCredito WHERE detanotacredito.TipoDetaNotaCredito.id="+String.valueOf(tipodetanotacredito.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetaNotaCreditoDataAccess detanotacreditoDataAccess=new DetaNotaCreditoDataAccess();

			detanotacreditoDataAccess.setConnexionType(this.connexionType);
			detanotacreditoDataAccess.setParameterDbType(this.parameterDbType);
			detanotacreditos=detanotacreditoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detanotacreditos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoDetaNotaCredito tipodetanotacredito) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipodetanotacredito.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipodetanotacredito.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipodetanotacredito.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipodetanotacredito.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipodetanotacredito.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipodetanotacredito.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipodetanotacredito.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipodetanotacredito.getId());
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
	
	public void setIsNewIsChangedFalseTipoDetaNotaCredito(TipoDetaNotaCredito tipodetanotacredito)throws Exception  {		
		tipodetanotacredito.setIsNew(false);
		tipodetanotacredito.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoDetaNotaCreditos(List<TipoDetaNotaCredito> tipodetanotacreditos)throws Exception  {				
		for(TipoDetaNotaCredito tipodetanotacredito:tipodetanotacreditos) {
			tipodetanotacredito.setIsNew(false);
			tipodetanotacredito.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoDetaNotaCredito(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
