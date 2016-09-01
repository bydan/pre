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
import com.bydan.erp.tesoreria.util.*;//TipoCodigoRetencionSriConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoCodigoRetencionSriDataAccess extends  DataAccessHelper<TipoCodigoRetencionSri>{ //TipoCodigoRetencionSriDataAccessAdditional,DataAccessHelper<TipoCodigoRetencionSri>
	//static Logger logger = Logger.getLogger(TipoCodigoRetencionSriDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_codigo_retencion_sri";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+"(version_row,id_pais,codigo,nombre)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocodigoretencionsri from "+TipoCodigoRetencionSriConstantesFunciones.SPERSISTENCENAME+" tipocodigoretencionsri";
	public static String QUERYSELECTNATIVE="select "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".id,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".id_pais,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".codigo,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".nombre from "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;//+" as "+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".id,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".version_row,"+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+".codigo from "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;//+" as "+TipoCodigoRetencionSriConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCodigoRetencionSriConstantesFunciones.SCHEMA+"."+TipoCodigoRetencionSriConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_pais=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCODIGORETENCIONSRI_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCODIGORETENCIONSRI_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCODIGORETENCIONSRI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCODIGORETENCIONSRI_SELECT(?,?)";
	
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
	
	
	public TipoCodigoRetencionSriDataAccess() {
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
		TipoCodigoRetencionSriDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCodigoRetencionSriDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCodigoRetencionSriDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCodigoRetencionSriOriginal(TipoCodigoRetencionSri tipocodigoretencionsri)throws Exception  {
		tipocodigoretencionsri.setTipoCodigoRetencionSriOriginal((TipoCodigoRetencionSri)tipocodigoretencionsri.clone());		
	}
	
	public void setTipoCodigoRetencionSrisOriginal(List<TipoCodigoRetencionSri> tipocodigoretencionsris)throws Exception  {
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris){
			tipocodigoretencionsri.setTipoCodigoRetencionSriOriginal((TipoCodigoRetencionSri)tipocodigoretencionsri.clone());
		}
	}
	
	public static void setTipoCodigoRetencionSriOriginalStatic(TipoCodigoRetencionSri tipocodigoretencionsri)throws Exception  {
		tipocodigoretencionsri.setTipoCodigoRetencionSriOriginal((TipoCodigoRetencionSri)tipocodigoretencionsri.clone());		
	}
	
	public static void setTipoCodigoRetencionSrisOriginalStatic(List<TipoCodigoRetencionSri> tipocodigoretencionsris)throws Exception  {
		
		for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris){
			tipocodigoretencionsri.setTipoCodigoRetencionSriOriginal((TipoCodigoRetencionSri)tipocodigoretencionsri.clone());
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
	
	public  TipoCodigoRetencionSri getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		
		
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
	
	public  TipoCodigoRetencionSri getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoCodigoRetencionSri.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCodigoRetencionSriOriginal(new TipoCodigoRetencionSri());
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCodigoRetencionSri("",entity,resultSet); 
				
				//entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCodigoRetencionSri(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCodigoRetencionSri getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();
				
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
	
	public  TipoCodigoRetencionSri getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoRetencionSriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCodigoRetencionSri.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCodigoRetencionSriOriginal(new TipoCodigoRetencionSri());
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCodigoRetencionSri("",entity,resultSet);    
				
				//entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCodigoRetencionSri(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCodigoRetencionSri
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoRetencionSriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCodigoRetencionSri.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCodigoRetencionSri(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCodigoRetencionSri> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		
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
	
	public  List<TipoCodigoRetencionSri> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoRetencionSriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoRetencionSri();
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCodigoRetencionSri("",entity,resultSet);
      	    	
				//entity.setTipoCodigoRetencionSriOriginal( new TipoCodigoRetencionSri());
      	    	//entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCodigoRetencionSris(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoRetencionSri(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCodigoRetencionSri> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
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
	
	public  List<TipoCodigoRetencionSri> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoRetencionSri();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCodigoRetencionSri();
					//entity.setMapTipoCodigoRetencionSri(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCodigoRetencionSriValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCodigoRetencionSri().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         		
					entity=TipoCodigoRetencionSriDataAccess.getEntityTipoCodigoRetencionSri("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCodigoRetencionSriOriginal( new TipoCodigoRetencionSri());
					////entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCodigoRetencionSris(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoRetencionSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCodigoRetencionSri getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
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
	
	public  TipoCodigoRetencionSri getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoRetencionSri();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCodigoRetencionSri();
					//entity.setMapTipoCodigoRetencionSri(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCodigoRetencionSriValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCodigoRetencionSri().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         		
					entity=TipoCodigoRetencionSriDataAccess.getEntityTipoCodigoRetencionSri("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCodigoRetencionSriOriginal( new TipoCodigoRetencionSri());
					////entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCodigoRetencionSri(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoRetencionSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCodigoRetencionSri getEntityTipoCodigoRetencionSri(String strPrefijo,TipoCodigoRetencionSri entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCodigoRetencionSri.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCodigoRetencionSri.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCodigoRetencionSriDataAccess.setFieldReflectionTipoCodigoRetencionSri(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCodigoRetencionSri=TipoCodigoRetencionSriConstantesFunciones.getTodosTiposColumnasTipoCodigoRetencionSri();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCodigoRetencionSri) {
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
							field = TipoCodigoRetencionSri.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCodigoRetencionSri.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCodigoRetencionSriDataAccess.setFieldReflectionTipoCodigoRetencionSri(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCodigoRetencionSri(Field field,String strPrefijo,String sColumn,TipoCodigoRetencionSri entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCodigoRetencionSriConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCodigoRetencionSriConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCodigoRetencionSriConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCodigoRetencionSriConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCodigoRetencionSriConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCodigoRetencionSri>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoRetencionSriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCodigoRetencionSri();
					entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCodigoRetencionSri("",entity,resultSet);
					
					//entity.setTipoCodigoRetencionSriOriginal( new TipoCodigoRetencionSri());
					//entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCodigoRetencionSris(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoRetencionSri(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCodigoRetencionSri>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCodigoRetencionSriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCodigoRetencionSriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCodigoRetencionSri> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
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
	
	public  List<TipoCodigoRetencionSri> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCodigoRetencionSri> entities = new  ArrayList<TipoCodigoRetencionSri>();
		TipoCodigoRetencionSri entity = new TipoCodigoRetencionSri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCodigoRetencionSri();
      	    	entity=super.getEntity("",entity,resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCodigoRetencionSri("",entity,resultSet);
      	    	
				//entity.setTipoCodigoRetencionSriOriginal( new TipoCodigoRetencionSri());
      	    	//entity.setTipoCodigoRetencionSriOriginal(super.getEntity("",entity.getTipoCodigoRetencionSriOriginal(),resultSet,TipoCodigoRetencionSriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCodigoRetencionSriOriginal(this.getEntityTipoCodigoRetencionSri("",entity.getTipoCodigoRetencionSriOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCodigoRetencionSris(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCodigoRetencionSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoCodigoRetencionSri getEntityTipoCodigoRetencionSri(String strPrefijo,TipoCodigoRetencionSri entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_pais(resultSet.getLong(strPrefijo+TipoCodigoRetencionSriConstantesFunciones.IDPAIS));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCodigoRetencionSriConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCodigoRetencionSriConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCodigoRetencionSriConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCodigoRetencionSri(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCodigoRetencionSri entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCodigoRetencionSriDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCodigoRetencionSriDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCodigoRetencionSriDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCodigoRetencionSriDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCodigoRetencionSriConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCodigoRetencionSriDataAccess.TABLENAME,TipoCodigoRetencionSriDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCodigoRetencionSriDataAccess.setTipoCodigoRetencionSriOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Pais getPais(Connexion connexion,TipoCodigoRetencionSri reltipocodigoretencionsri)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,reltipocodigoretencionsri.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCodigoRetencionSri tipocodigoretencionsri) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocodigoretencionsri.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(tipocodigoretencionsri.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocodigoretencionsri.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocodigoretencionsri.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocodigoretencionsri.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocodigoretencionsri.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocodigoretencionsri.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocodigoretencionsri.getId());
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
	
	public void setIsNewIsChangedFalseTipoCodigoRetencionSri(TipoCodigoRetencionSri tipocodigoretencionsri)throws Exception  {		
		tipocodigoretencionsri.setIsNew(false);
		tipocodigoretencionsri.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> tipocodigoretencionsris)throws Exception  {				
		for(TipoCodigoRetencionSri tipocodigoretencionsri:tipocodigoretencionsris) {
			tipocodigoretencionsri.setIsNew(false);
			tipocodigoretencionsri.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCodigoRetencionSri(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
