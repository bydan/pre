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
package com.bydan.erp.seguridad.business.dataaccess;

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

import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.seguridad.util.*;//HistorialCambioClaveConstantesFunciones;










@SuppressWarnings("unused")
final public class HistorialCambioClaveDataAccess extends  HistorialCambioClaveDataAccessAdditional{ //HistorialCambioClaveDataAccessAdditional,DataAccessHelper<HistorialCambioClave>
	//static Logger logger = Logger.getLogger(HistorialCambioClaveDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="historial_cambio_clave";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+"(version_row,id_usuario,nombre,fecha_hora,observacion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,nombre=?,fecha_hora=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select historialcambioclave from "+HistorialCambioClaveConstantesFunciones.SPERSISTENCENAME+" historialcambioclave";
	public static String QUERYSELECTNATIVE="select "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".id,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".version_row,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".id_usuario,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".nombre,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".fecha_hora,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".observacion from "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME;//+" as "+HistorialCambioClaveConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".id,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".version_row,"+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+".nombre from "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME;//+" as "+HistorialCambioClaveConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+HistorialCambioClaveConstantesFunciones.SCHEMA+"."+HistorialCambioClaveConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_usuario=?,nombre=?,fecha_hora=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_HISTORIALCAMBIOCLAVE_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_HISTORIALCAMBIOCLAVE_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_HISTORIALCAMBIOCLAVE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_HISTORIALCAMBIOCLAVE_SELECT(?,?)";
	
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
	
	
	protected HistorialCambioClaveDataAccessAdditional historialcambioclaveDataAccessAdditional=null;
	
	public HistorialCambioClaveDataAccessAdditional getHistorialCambioClaveDataAccessAdditional() {
		return this.historialcambioclaveDataAccessAdditional;
	}
	
	public void setHistorialCambioClaveDataAccessAdditional(HistorialCambioClaveDataAccessAdditional historialcambioclaveDataAccessAdditional) {
		try {
			this.historialcambioclaveDataAccessAdditional=historialcambioclaveDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public HistorialCambioClaveDataAccess() {
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
		HistorialCambioClaveDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		HistorialCambioClaveDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		HistorialCambioClaveDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setHistorialCambioClaveOriginal(HistorialCambioClave historialcambioclave)throws Exception  {
		historialcambioclave.setHistorialCambioClaveOriginal((HistorialCambioClave)historialcambioclave.clone());		
	}
	
	public void setHistorialCambioClavesOriginal(List<HistorialCambioClave> historialcambioclaves)throws Exception  {
		
		for(HistorialCambioClave historialcambioclave:historialcambioclaves){
			historialcambioclave.setHistorialCambioClaveOriginal((HistorialCambioClave)historialcambioclave.clone());
		}
	}
	
	public static void setHistorialCambioClaveOriginalStatic(HistorialCambioClave historialcambioclave)throws Exception  {
		historialcambioclave.setHistorialCambioClaveOriginal((HistorialCambioClave)historialcambioclave.clone());		
	}
	
	public static void setHistorialCambioClavesOriginalStatic(List<HistorialCambioClave> historialcambioclaves)throws Exception  {
		
		for(HistorialCambioClave historialcambioclave:historialcambioclaves){
			historialcambioclave.setHistorialCambioClaveOriginal((HistorialCambioClave)historialcambioclave.clone());
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
	
	public  HistorialCambioClave getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();		
		
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
	
	public  HistorialCambioClave getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Seguridad.HistorialCambioClave.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setHistorialCambioClaveOriginal(new HistorialCambioClave());
      	    	entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialCambioClave("",entity,resultSet); 
				
				entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
      	    	entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialCambioClave(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  HistorialCambioClave getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();
				
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
	
	public  HistorialCambioClave getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialCambioClaveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.HistorialCambioClave.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setHistorialCambioClaveOriginal(new HistorialCambioClave());
      	    	entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityHistorialCambioClave("",entity,resultSet);    
				
				entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
      	    	entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseHistorialCambioClave(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //HistorialCambioClave
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		HistorialCambioClave entity = new HistorialCambioClave();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialCambioClaveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Seguridad.HistorialCambioClave.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseHistorialCambioClave(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<HistorialCambioClave> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		
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
	
	public  List<HistorialCambioClave> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialCambioClaveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialCambioClave();
      	    	entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialCambioClave("",entity,resultSet);
      	    	
				entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
      	    	entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
      	    	entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialCambioClaves(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialCambioClave(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialCambioClave> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
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
	
	public  List<HistorialCambioClave> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialCambioClave();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialCambioClave();
					//entity.setMapHistorialCambioClave(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapHistorialCambioClaveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialCambioClave().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
					entity=HistorialCambioClaveDataAccess.getEntityHistorialCambioClave("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
					//entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialCambioClaves(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialCambioClave(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public HistorialCambioClave getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();		  
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
	
	public  HistorialCambioClave getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialCambioClave();
				
				if(conMapGenerico) {
					entity.inicializarMapHistorialCambioClave();
					//entity.setMapHistorialCambioClave(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapHistorialCambioClaveValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapHistorialCambioClave().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
					entity=HistorialCambioClaveDataAccess.getEntityHistorialCambioClave("",entity,resultSet,listColumns,deepLoadType);
					
					//entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
					//entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
					//entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseHistorialCambioClave(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialCambioClave(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static HistorialCambioClave getEntityHistorialCambioClave(String strPrefijo,HistorialCambioClave entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = HistorialCambioClave.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = HistorialCambioClave.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					HistorialCambioClaveDataAccess.setFieldReflectionHistorialCambioClave(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasHistorialCambioClave=HistorialCambioClaveConstantesFunciones.getTodosTiposColumnasHistorialCambioClave();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasHistorialCambioClave) {
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
							field = HistorialCambioClave.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = HistorialCambioClave.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						HistorialCambioClaveDataAccess.setFieldReflectionHistorialCambioClave(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionHistorialCambioClave(Field field,String strPrefijo,String sColumn,HistorialCambioClave entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case HistorialCambioClaveConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialCambioClaveConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialCambioClaveConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case HistorialCambioClaveConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case HistorialCambioClaveConstantesFunciones.FECHAHORA:
					field.set(entity,resultSet.getTimestamp(sCampo));
					break;
				
				case HistorialCambioClaveConstantesFunciones.OBSERVACION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialCambioClave>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialCambioClaveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new HistorialCambioClave();
					entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityHistorialCambioClave("",entity,resultSet);
					
					entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
					entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
					entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseHistorialCambioClaves(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialCambioClave(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<HistorialCambioClave>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=HistorialCambioClaveDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,HistorialCambioClaveDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<HistorialCambioClave> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
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
	
	public  List<HistorialCambioClave> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialCambioClave();
      	    	entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialCambioClave("",entity,resultSet);
      	    	
				entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
      	    	entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
      	    	entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseHistorialCambioClaves(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarHistorialCambioClave(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<HistorialCambioClave> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
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
	
	public  List<HistorialCambioClave> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<HistorialCambioClave> entities = new  ArrayList<HistorialCambioClave>();
		HistorialCambioClave entity = new HistorialCambioClave();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new HistorialCambioClave();
      	    	entity=super.getEntity("",entity,resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityHistorialCambioClave("",entity,resultSet);
      	    	
				entity.setHistorialCambioClaveOriginal( new HistorialCambioClave());
      	    	entity.setHistorialCambioClaveOriginal(super.getEntity("",entity.getHistorialCambioClaveOriginal(),resultSet,HistorialCambioClaveDataAccess.ISWITHSCHEMA));         		
      	    	entity.setHistorialCambioClaveOriginal(this.getEntityHistorialCambioClave("",entity.getHistorialCambioClaveOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseHistorialCambioClaves(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public HistorialCambioClave getEntityHistorialCambioClave(String strPrefijo,HistorialCambioClave entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_usuario(resultSet.getLong(strPrefijo+HistorialCambioClaveConstantesFunciones.IDUSUARIO));
				entity.setnombre(resultSet.getString(strPrefijo+HistorialCambioClaveConstantesFunciones.NOMBRE));
				entity.setfecha_hora(resultSet.getTimestamp(strPrefijo+HistorialCambioClaveConstantesFunciones.FECHAHORA));
				entity.setobservacion(resultSet.getString(strPrefijo+HistorialCambioClaveConstantesFunciones.OBSERVACION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+HistorialCambioClaveConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowHistorialCambioClave(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(HistorialCambioClave entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=HistorialCambioClaveDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=HistorialCambioClaveDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=HistorialCambioClaveDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=HistorialCambioClaveDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(HistorialCambioClaveConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,HistorialCambioClaveDataAccess.TABLENAME,HistorialCambioClaveDataAccess.ISWITHSTOREPROCEDURES);
			
			HistorialCambioClaveDataAccess.setHistorialCambioClaveOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Usuario getUsuario(Connexion connexion,HistorialCambioClave relhistorialcambioclave)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relhistorialcambioclave.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,HistorialCambioClave historialcambioclave) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!historialcambioclave.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(historialcambioclave.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(historialcambioclave.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
					ParameterValue<Timestamp> parameterMaintenanceValuefecha_hora=new ParameterValue<Timestamp>();
					parameterMaintenanceValuefecha_hora.setValue(historialcambioclave.getfecha_hora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_hora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(historialcambioclave.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!historialcambioclave.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(historialcambioclave.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(historialcambioclave.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(historialcambioclave.getId());
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
	
	public void setIsNewIsChangedFalseHistorialCambioClave(HistorialCambioClave historialcambioclave)throws Exception  {		
		historialcambioclave.setIsNew(false);
		historialcambioclave.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseHistorialCambioClaves(List<HistorialCambioClave> historialcambioclaves)throws Exception  {				
		for(HistorialCambioClave historialcambioclave:historialcambioclaves) {
			historialcambioclave.setIsNew(false);
			historialcambioclave.setIsChanged(false);
		}
	}
	
	public void generarExportarHistorialCambioClave(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
