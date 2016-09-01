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
import com.bydan.erp.puntoventa.util.*;//ConexionConstantesFunciones;










@SuppressWarnings("unused")
final public class ConexionDataAccess extends  ConexionDataAccessAdditional{ //ConexionDataAccessAdditional,DataAccessHelper<Conexion>
	//static Logger logger = Logger.getLogger(ConexionDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="conexion";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+"(version_row,id_tipo_conexion,nombre,nombre_maquina)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_conexion=?,nombre=?,nombre_maquina=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select conexion from "+ConexionConstantesFunciones.SPERSISTENCENAME+" conexion";
	public static String QUERYSELECTNATIVE="select "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".id,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".version_row,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".id_tipo_conexion,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".nombre,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".nombre_maquina from "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME;//+" as "+ConexionConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".id,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".version_row,"+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+".nombre from "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME;//+" as "+ConexionConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ConexionConstantesFunciones.SCHEMA+"."+ConexionConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_tipo_conexion=?,nombre=?,nombre_maquina=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CONEXION_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CONEXION_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CONEXION_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CONEXION_SELECT(?,?)";
	
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
	
	
	protected ConexionDataAccessAdditional conexionDataAccessAdditional=null;
	
	public ConexionDataAccessAdditional getConexionDataAccessAdditional() {
		return this.conexionDataAccessAdditional;
	}
	
	public void setConexionDataAccessAdditional(ConexionDataAccessAdditional conexionDataAccessAdditional) {
		try {
			this.conexionDataAccessAdditional=conexionDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ConexionDataAccess() {
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
		ConexionDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ConexionDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ConexionDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setConexionOriginal(Conexion conexion)throws Exception  {
		conexion.setConexionOriginal((Conexion)conexion.clone());		
	}
	
	public void setConexionsOriginal(List<Conexion> conexions)throws Exception  {
		
		for(Conexion conexion:conexions){
			conexion.setConexionOriginal((Conexion)conexion.clone());
		}
	}
	
	public static void setConexionOriginalStatic(Conexion conexion)throws Exception  {
		conexion.setConexionOriginal((Conexion)conexion.clone());		
	}
	
	public static void setConexionsOriginalStatic(List<Conexion> conexions)throws Exception  {
		
		for(Conexion conexion:conexions){
			conexion.setConexionOriginal((Conexion)conexion.clone());
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
	
	public  Conexion getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Conexion entity = new Conexion();		
		
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
	
	public  Conexion getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Conexion entity = new Conexion();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.Conexion.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setConexionOriginal(new Conexion());
      	    	entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConexion("",entity,resultSet); 
				
				//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseConexion(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Conexion getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Conexion entity = new Conexion();
				
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
	
	public  Conexion getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Conexion entity = new Conexion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.Conexion.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setConexionOriginal(new Conexion());
      	    	entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityConexion("",entity,resultSet);    
				
				//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseConexion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Conexion
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Conexion entity = new Conexion();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.Conexion.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseConexion(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Conexion> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		
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
	
	public  List<Conexion> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Conexion();
      	    	entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConexion("",entity,resultSet);
      	    	
				//entity.setConexionOriginal( new Conexion());
      	    	//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConexions(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConexion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Conexion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
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
	
	public  List<Conexion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Conexion();
				
				if(conMapGenerico) {
					entity.inicializarMapConexion();
					//entity.setMapConexion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapConexionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConexion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
					entity=ConexionDataAccess.getEntityConexion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConexionOriginal( new Conexion());
					////entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
					////entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConexions(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Conexion getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Conexion entity = new Conexion();		  
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
	
	public  Conexion getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Conexion entity = new Conexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Conexion();
				
				if(conMapGenerico) {
					entity.inicializarMapConexion();
					//entity.setMapConexion(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapConexionValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapConexion().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
					entity=ConexionDataAccess.getEntityConexion("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setConexionOriginal( new Conexion());
					////entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
					////entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseConexion(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Conexion getEntityConexion(String strPrefijo,Conexion entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Conexion.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Conexion.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ConexionDataAccess.setFieldReflectionConexion(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasConexion=ConexionConstantesFunciones.getTodosTiposColumnasConexion();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasConexion) {
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
							field = Conexion.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Conexion.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ConexionDataAccess.setFieldReflectionConexion(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionConexion(Field field,String strPrefijo,String sColumn,Conexion entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ConexionConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConexionConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConexionConstantesFunciones.IDTIPOCONEXION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ConexionConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ConexionConstantesFunciones.NOMBREMAQUINA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Conexion>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Conexion();
					entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityConexion("",entity,resultSet);
					
					//entity.setConexionOriginal( new Conexion());
					//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
					//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseConexions(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConexion(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Conexion>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ConexionDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ConexionDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Conexion> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
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
	
	public  List<Conexion> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Conexion();
      	    	entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConexion("",entity,resultSet);
      	    	
				//entity.setConexionOriginal( new Conexion());
      	    	//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseConexions(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarConexion(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Conexion> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
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
	
	public  List<Conexion> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Conexion> entities = new  ArrayList<Conexion>();
		Conexion entity = new Conexion();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Conexion();
      	    	entity=super.getEntity("",entity,resultSet,ConexionDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityConexion("",entity,resultSet);
      	    	
				//entity.setConexionOriginal( new Conexion());
      	    	//entity.setConexionOriginal(super.getEntity("",entity.getConexionOriginal(),resultSet,ConexionDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setConexionOriginal(this.getEntityConexion("",entity.getConexionOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseConexions(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Conexion getEntityConexion(String strPrefijo,Conexion entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_tipo_conexion(resultSet.getLong(strPrefijo+ConexionConstantesFunciones.IDTIPOCONEXION));
				entity.setnombre(resultSet.getString(strPrefijo+ConexionConstantesFunciones.NOMBRE));
				entity.setnombre_maquina(resultSet.getString(strPrefijo+ConexionConstantesFunciones.NOMBREMAQUINA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ConexionConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowConexion(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Conexion entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ConexionDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ConexionDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ConexionDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ConexionDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ConexionConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ConexionDataAccess.TABLENAME,ConexionDataAccess.ISWITHSTOREPROCEDURES);
			
			ConexionDataAccess.setConexionOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public TipoConexion getTipoConexion(Connexion connexion,Conexion relconexion)throws SQLException,Exception {

		TipoConexion tipoconexion= new TipoConexion();

		try {
			TipoConexionDataAccess tipoconexionDataAccess=new TipoConexionDataAccess();

			tipoconexionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoconexionDataAccess.setConnexionType(this.connexionType);
			tipoconexionDataAccess.setParameterDbType(this.parameterDbType);

			tipoconexion=tipoconexionDataAccess.getEntity(connexion,relconexion.getid_tipo_conexion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoconexion;

	}


		
		public List<TarjetaCreditoConexion> getTarjetaCreditoConexions(Connexion connexion,Conexion conexion)throws SQLException,Exception {

		List<TarjetaCreditoConexion> tarjetacreditoconexions= new ArrayList<TarjetaCreditoConexion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ConexionConstantesFunciones.SCHEMA+".conexion ON "+TarjetaCreditoConexionConstantesFunciones.SCHEMA+".tarjeta_credito_conexion.id_conexion="+ConexionConstantesFunciones.SCHEMA+".conexion.id WHERE "+ConexionConstantesFunciones.SCHEMA+".conexion.id="+String.valueOf(conexion.getId());
			} else {
				sQuery=" INNER JOIN tarjetacreditoconexion.Conexion WHERE tarjetacreditoconexion.Conexion.id="+String.valueOf(conexion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TarjetaCreditoConexionDataAccess tarjetacreditoconexionDataAccess=new TarjetaCreditoConexionDataAccess();

			tarjetacreditoconexionDataAccess.setConnexionType(this.connexionType);
			tarjetacreditoconexionDataAccess.setParameterDbType(this.parameterDbType);
			tarjetacreditoconexions=tarjetacreditoconexionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tarjetacreditoconexions;

	}

	public List<NumeroRecap> getNumeroRecaps(Connexion connexion,Conexion conexion)throws SQLException,Exception {

		List<NumeroRecap> numerorecaps= new ArrayList<NumeroRecap>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ConexionConstantesFunciones.SCHEMA+".conexion ON "+NumeroRecapConstantesFunciones.SCHEMA+".numero_recap.id_conexion="+ConexionConstantesFunciones.SCHEMA+".conexion.id WHERE "+ConexionConstantesFunciones.SCHEMA+".conexion.id="+String.valueOf(conexion.getId());
			} else {
				sQuery=" INNER JOIN numerorecap.Conexion WHERE numerorecap.Conexion.id="+String.valueOf(conexion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NumeroRecapDataAccess numerorecapDataAccess=new NumeroRecapDataAccess();

			numerorecapDataAccess.setConnexionType(this.connexionType);
			numerorecapDataAccess.setParameterDbType(this.parameterDbType);
			numerorecaps=numerorecapDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return numerorecaps;

	}

	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,Conexion conexion)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ConexionConstantesFunciones.SCHEMA+".conexion ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_conexion="+ConexionConstantesFunciones.SCHEMA+".conexion.id WHERE "+ConexionConstantesFunciones.SCHEMA+".conexion.id="+String.valueOf(conexion.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.Conexion WHERE formapagopuntoventa.Conexion.id="+String.valueOf(conexion.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess=new FormaPagoPuntoVentaDataAccess();

			formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formapagopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Conexion conexion) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!conexion.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_conexion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_conexion.setValue(conexion.getid_tipo_conexion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_conexion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(conexion.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_maquina=new ParameterValue<String>();
					parameterMaintenanceValuenombre_maquina.setValue(conexion.getnombre_maquina());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_maquina);
					parametersTemp.add(parameterMaintenance);
					
						if(!conexion.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(conexion.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(conexion.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(conexion.getId());
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
	
	public void setIsNewIsChangedFalseConexion(Conexion conexion)throws Exception  {		
		conexion.setIsNew(false);
		conexion.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseConexions(List<Conexion> conexions)throws Exception  {				
		for(Conexion conexion:conexions) {
			conexion.setIsNew(false);
			conexion.setIsChanged(false);
		}
	}
	
	public void generarExportarConexion(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
