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
package com.bydan.erp.nomina.business.dataaccess;

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

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.util.*;//TelefonoReferenciaConstantesFunciones;










@SuppressWarnings("unused")
final public class TelefonoReferenciaDataAccess extends  TelefonoReferenciaDataAccessAdditional{ //TelefonoReferenciaDataAccessAdditional,DataAccessHelper<TelefonoReferencia>
	//static Logger logger = Logger.getLogger(TelefonoReferenciaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="telefono_referencia";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+"(version_row,id_referencia,numero)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_referencia=?,numero=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select telefonoreferencia from "+TelefonoReferenciaConstantesFunciones.SPERSISTENCENAME+" telefonoreferencia";
	public static String QUERYSELECTNATIVE="select "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".id,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".version_row,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".id_referencia,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".numero from "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME;//+" as "+TelefonoReferenciaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".id,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".version_row,"+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+".numero from "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME;//+" as "+TelefonoReferenciaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TelefonoReferenciaConstantesFunciones.SCHEMA+"."+TelefonoReferenciaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_referencia=?,numero=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TELEFONOREFERENCIA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TELEFONOREFERENCIA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TELEFONOREFERENCIA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TELEFONOREFERENCIA_SELECT(?,?)";
	
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
	
	
	protected TelefonoReferenciaDataAccessAdditional telefonoreferenciaDataAccessAdditional=null;
	
	public TelefonoReferenciaDataAccessAdditional getTelefonoReferenciaDataAccessAdditional() {
		return this.telefonoreferenciaDataAccessAdditional;
	}
	
	public void setTelefonoReferenciaDataAccessAdditional(TelefonoReferenciaDataAccessAdditional telefonoreferenciaDataAccessAdditional) {
		try {
			this.telefonoreferenciaDataAccessAdditional=telefonoreferenciaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TelefonoReferenciaDataAccess() {
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
		TelefonoReferenciaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TelefonoReferenciaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TelefonoReferenciaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTelefonoReferenciaOriginal(TelefonoReferencia telefonoreferencia)throws Exception  {
		telefonoreferencia.setTelefonoReferenciaOriginal((TelefonoReferencia)telefonoreferencia.clone());		
	}
	
	public void setTelefonoReferenciasOriginal(List<TelefonoReferencia> telefonoreferencias)throws Exception  {
		
		for(TelefonoReferencia telefonoreferencia:telefonoreferencias){
			telefonoreferencia.setTelefonoReferenciaOriginal((TelefonoReferencia)telefonoreferencia.clone());
		}
	}
	
	public static void setTelefonoReferenciaOriginalStatic(TelefonoReferencia telefonoreferencia)throws Exception  {
		telefonoreferencia.setTelefonoReferenciaOriginal((TelefonoReferencia)telefonoreferencia.clone());		
	}
	
	public static void setTelefonoReferenciasOriginalStatic(List<TelefonoReferencia> telefonoreferencias)throws Exception  {
		
		for(TelefonoReferencia telefonoreferencia:telefonoreferencias){
			telefonoreferencia.setTelefonoReferenciaOriginal((TelefonoReferencia)telefonoreferencia.clone());
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
	
	public  TelefonoReferencia getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();		
		
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
	
	public  TelefonoReferencia getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Nomina.TelefonoReferencia.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTelefonoReferenciaOriginal(new TelefonoReferencia());
      	    	entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTelefonoReferencia("",entity,resultSet); 
				
				//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTelefonoReferencia(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TelefonoReferencia getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();
				
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
	
	public  TelefonoReferencia getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TelefonoReferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TelefonoReferencia.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTelefonoReferenciaOriginal(new TelefonoReferencia());
      	    	entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTelefonoReferencia("",entity,resultSet);    
				
				//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTelefonoReferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TelefonoReferencia
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TelefonoReferencia entity = new TelefonoReferencia();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TelefonoReferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Nomina.TelefonoReferencia.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTelefonoReferencia(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TelefonoReferencia> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		
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
	
	public  List<TelefonoReferencia> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TelefonoReferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TelefonoReferencia();
      	    	entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTelefonoReferencia("",entity,resultSet);
      	    	
				//entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
      	    	//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTelefonoReferencias(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTelefonoReferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TelefonoReferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
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
	
	public  List<TelefonoReferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TelefonoReferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapTelefonoReferencia();
					//entity.setMapTelefonoReferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTelefonoReferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTelefonoReferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
					entity=TelefonoReferenciaDataAccess.getEntityTelefonoReferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
					////entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTelefonoReferencias(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTelefonoReferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TelefonoReferencia getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();		  
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
	
	public  TelefonoReferencia getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TelefonoReferencia();
				
				if(conMapGenerico) {
					entity.inicializarMapTelefonoReferencia();
					//entity.setMapTelefonoReferencia(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTelefonoReferenciaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTelefonoReferencia().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
					entity=TelefonoReferenciaDataAccess.getEntityTelefonoReferencia("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
					////entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
					////entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTelefonoReferencia(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTelefonoReferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TelefonoReferencia getEntityTelefonoReferencia(String strPrefijo,TelefonoReferencia entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TelefonoReferencia.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TelefonoReferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TelefonoReferenciaDataAccess.setFieldReflectionTelefonoReferencia(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTelefonoReferencia=TelefonoReferenciaConstantesFunciones.getTodosTiposColumnasTelefonoReferencia();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTelefonoReferencia) {
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
							field = TelefonoReferencia.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TelefonoReferencia.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TelefonoReferenciaDataAccess.setFieldReflectionTelefonoReferencia(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTelefonoReferencia(Field field,String strPrefijo,String sColumn,TelefonoReferencia entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TelefonoReferenciaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TelefonoReferenciaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TelefonoReferenciaConstantesFunciones.IDREFERENCIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TelefonoReferenciaConstantesFunciones.NUMERO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TelefonoReferencia>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TelefonoReferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TelefonoReferencia();
					entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTelefonoReferencia("",entity,resultSet);
					
					//entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
					//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
					//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTelefonoReferencias(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTelefonoReferencia(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TelefonoReferencia>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TelefonoReferenciaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TelefonoReferenciaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TelefonoReferencia> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
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
	
	public  List<TelefonoReferencia> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TelefonoReferencia();
      	    	entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTelefonoReferencia("",entity,resultSet);
      	    	
				//entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
      	    	//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTelefonoReferencias(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTelefonoReferencia(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TelefonoReferencia> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
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
	
	public  List<TelefonoReferencia> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TelefonoReferencia> entities = new  ArrayList<TelefonoReferencia>();
		TelefonoReferencia entity = new TelefonoReferencia();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TelefonoReferencia();
      	    	entity=super.getEntity("",entity,resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTelefonoReferencia("",entity,resultSet);
      	    	
				//entity.setTelefonoReferenciaOriginal( new TelefonoReferencia());
      	    	//entity.setTelefonoReferenciaOriginal(super.getEntity("",entity.getTelefonoReferenciaOriginal(),resultSet,TelefonoReferenciaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTelefonoReferenciaOriginal(this.getEntityTelefonoReferencia("",entity.getTelefonoReferenciaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTelefonoReferencias(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TelefonoReferencia getEntityTelefonoReferencia(String strPrefijo,TelefonoReferencia entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_referencia(resultSet.getLong(strPrefijo+TelefonoReferenciaConstantesFunciones.IDREFERENCIA));
				entity.setnumero(resultSet.getString(strPrefijo+TelefonoReferenciaConstantesFunciones.NUMERO));
			} else {
				entity.setnumero(resultSet.getString(strPrefijo+TelefonoReferenciaConstantesFunciones.NUMERO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTelefonoReferencia(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TelefonoReferencia entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TelefonoReferenciaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TelefonoReferenciaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TelefonoReferenciaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TelefonoReferenciaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TelefonoReferenciaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TelefonoReferenciaDataAccess.TABLENAME,TelefonoReferenciaDataAccess.ISWITHSTOREPROCEDURES);
			
			TelefonoReferenciaDataAccess.setTelefonoReferenciaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Referencia getReferencia(Connexion connexion,TelefonoReferencia reltelefonoreferencia)throws SQLException,Exception {

		Referencia referencia= new Referencia();

		try {
			ReferenciaDataAccess referenciaDataAccess=new ReferenciaDataAccess();

			referenciaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			referenciaDataAccess.setConnexionType(this.connexionType);
			referenciaDataAccess.setParameterDbType(this.parameterDbType);

			referencia=referenciaDataAccess.getEntity(connexion,reltelefonoreferencia.getid_referencia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return referencia;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TelefonoReferencia telefonoreferencia) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!telefonoreferencia.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_referencia=new ParameterValue<Long>();
					parameterMaintenanceValueid_referencia.setValue(telefonoreferencia.getid_referencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_referencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero=new ParameterValue<String>();
					parameterMaintenanceValuenumero.setValue(telefonoreferencia.getnumero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero);
					parametersTemp.add(parameterMaintenance);
					
						if(!telefonoreferencia.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(telefonoreferencia.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(telefonoreferencia.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(telefonoreferencia.getId());
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
	
	public void setIsNewIsChangedFalseTelefonoReferencia(TelefonoReferencia telefonoreferencia)throws Exception  {		
		telefonoreferencia.setIsNew(false);
		telefonoreferencia.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTelefonoReferencias(List<TelefonoReferencia> telefonoreferencias)throws Exception  {				
		for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
			telefonoreferencia.setIsNew(false);
			telefonoreferencia.setIsChanged(false);
		}
	}
	
	public void generarExportarTelefonoReferencia(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
