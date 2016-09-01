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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//ClienteArchivoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ClienteArchivoDataAccess extends  ClienteArchivoDataAccessAdditional{ //ClienteArchivoDataAccessAdditional,DataAccessHelper<ClienteArchivo>
	//static Logger logger = Logger.getLogger(ClienteArchivoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cliente_archivo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+"(version_row,id_cliente,id_tipo_archivo,nombre,archivo,descripcion)values(current_timestamp,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_tipo_archivo=?,nombre=?,archivo=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select clientearchivo from "+ClienteArchivoConstantesFunciones.SPERSISTENCENAME+" clientearchivo";
	public static String QUERYSELECTNATIVE="select "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".version_row,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id_cliente,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id_tipo_archivo,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".nombre,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".archivo,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".descripcion from "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME;//+" as "+ClienteArchivoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".id,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".version_row,"+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+".nombre from "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME;//+" as "+ClienteArchivoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ClienteArchivoConstantesFunciones.SCHEMA+"."+ClienteArchivoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_tipo_archivo=?,nombre=?,archivo=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CLIENTEARCHIVO_INSERT(?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CLIENTEARCHIVO_UPDATE(?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CLIENTEARCHIVO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CLIENTEARCHIVO_SELECT(?,?)";
	
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
	
	
	protected ClienteArchivoDataAccessAdditional clientearchivoDataAccessAdditional=null;
	
	public ClienteArchivoDataAccessAdditional getClienteArchivoDataAccessAdditional() {
		return this.clientearchivoDataAccessAdditional;
	}
	
	public void setClienteArchivoDataAccessAdditional(ClienteArchivoDataAccessAdditional clientearchivoDataAccessAdditional) {
		try {
			this.clientearchivoDataAccessAdditional=clientearchivoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ClienteArchivoDataAccess() {
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
		ClienteArchivoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ClienteArchivoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ClienteArchivoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setClienteArchivoOriginal(ClienteArchivo clientearchivo)throws Exception  {
		clientearchivo.setClienteArchivoOriginal((ClienteArchivo)clientearchivo.clone());		
	}
	
	public void setClienteArchivosOriginal(List<ClienteArchivo> clientearchivos)throws Exception  {
		
		for(ClienteArchivo clientearchivo:clientearchivos){
			clientearchivo.setClienteArchivoOriginal((ClienteArchivo)clientearchivo.clone());
		}
	}
	
	public static void setClienteArchivoOriginalStatic(ClienteArchivo clientearchivo)throws Exception  {
		clientearchivo.setClienteArchivoOriginal((ClienteArchivo)clientearchivo.clone());		
	}
	
	public static void setClienteArchivosOriginalStatic(List<ClienteArchivo> clientearchivos)throws Exception  {
		
		for(ClienteArchivo clientearchivo:clientearchivos){
			clientearchivo.setClienteArchivoOriginal((ClienteArchivo)clientearchivo.clone());
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
	
	public  ClienteArchivo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();		
		
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
	
	public  ClienteArchivo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ClienteArchivo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setClienteArchivoOriginal(new ClienteArchivo());
      	    	entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteArchivo("",entity,resultSet); 
				
				//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteArchivo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ClienteArchivo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();
				
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
	
	public  ClienteArchivo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteArchivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteArchivo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setClienteArchivoOriginal(new ClienteArchivo());
      	    	entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteArchivo("",entity,resultSet);    
				
				//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteArchivo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ClienteArchivo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ClienteArchivo entity = new ClienteArchivo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteArchivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteArchivo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseClienteArchivo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ClienteArchivo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		
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
	
	public  List<ClienteArchivo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteArchivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteArchivo();
      	    	entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteArchivo("",entity,resultSet);
      	    	
				//entity.setClienteArchivoOriginal( new ClienteArchivo());
      	    	//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteArchivos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteArchivo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteArchivo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
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
	
	public  List<ClienteArchivo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteArchivo();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteArchivo();
					//entity.setMapClienteArchivo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapClienteArchivoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteArchivo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
					entity=ClienteArchivoDataAccess.getEntityClienteArchivo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteArchivoOriginal( new ClienteArchivo());
					////entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteArchivos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteArchivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ClienteArchivo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();		  
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
	
	public  ClienteArchivo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteArchivo();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteArchivo();
					//entity.setMapClienteArchivo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapClienteArchivoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteArchivo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
					entity=ClienteArchivoDataAccess.getEntityClienteArchivo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteArchivoOriginal( new ClienteArchivo());
					////entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseClienteArchivo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteArchivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ClienteArchivo getEntityClienteArchivo(String strPrefijo,ClienteArchivo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ClienteArchivo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ClienteArchivo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ClienteArchivoDataAccess.setFieldReflectionClienteArchivo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasClienteArchivo=ClienteArchivoConstantesFunciones.getTodosTiposColumnasClienteArchivo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasClienteArchivo) {
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
							field = ClienteArchivo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ClienteArchivo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ClienteArchivoDataAccess.setFieldReflectionClienteArchivo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionClienteArchivo(Field field,String strPrefijo,String sColumn,ClienteArchivo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ClienteArchivoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.IDTIPOARCHIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.ARCHIVO:
					field.set(entity,resultSet.getBytes(sCampo));
					break;
				
				case ClienteArchivoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteArchivo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteArchivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ClienteArchivo();
					entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityClienteArchivo("",entity,resultSet);
					
					//entity.setClienteArchivoOriginal( new ClienteArchivo());
					//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
					//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseClienteArchivos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteArchivo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteArchivo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteArchivoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteArchivoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ClienteArchivo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
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
	
	public  List<ClienteArchivo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteArchivo();
      	    	entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteArchivo("",entity,resultSet);
      	    	
				//entity.setClienteArchivoOriginal( new ClienteArchivo());
      	    	//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseClienteArchivos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteArchivo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteArchivo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
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
	
	public  List<ClienteArchivo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteArchivo> entities = new  ArrayList<ClienteArchivo>();
		ClienteArchivo entity = new ClienteArchivo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteArchivo();
      	    	entity=super.getEntity("",entity,resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteArchivo("",entity,resultSet);
      	    	
				//entity.setClienteArchivoOriginal( new ClienteArchivo());
      	    	//entity.setClienteArchivoOriginal(super.getEntity("",entity.getClienteArchivoOriginal(),resultSet,ClienteArchivoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteArchivoOriginal(this.getEntityClienteArchivo("",entity.getClienteArchivoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteArchivos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ClienteArchivo getEntityClienteArchivo(String strPrefijo,ClienteArchivo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_cliente(resultSet.getLong(strPrefijo+ClienteArchivoConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_archivo(resultSet.getLong(strPrefijo+ClienteArchivoConstantesFunciones.IDTIPOARCHIVO));
				entity.setnombre(resultSet.getString(strPrefijo+ClienteArchivoConstantesFunciones.NOMBRE));
				if(resultSet.getBytes(strPrefijo+ClienteArchivoConstantesFunciones.ARCHIVO)!=null) {entity.setarchivo(resultSet.getBytes(strPrefijo+ClienteArchivoConstantesFunciones.ARCHIVO));}
				entity.setdescripcion(resultSet.getString(strPrefijo+ClienteArchivoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ClienteArchivoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowClienteArchivo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ClienteArchivo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ClienteArchivoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ClienteArchivoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ClienteArchivoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ClienteArchivoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ClienteArchivoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ClienteArchivoDataAccess.TABLENAME,ClienteArchivoDataAccess.ISWITHSTOREPROCEDURES);
			
			ClienteArchivoDataAccess.setClienteArchivoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,ClienteArchivo relclientearchivo)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relclientearchivo.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoArchivo getTipoArchivo(Connexion connexion,ClienteArchivo relclientearchivo)throws SQLException,Exception {

		TipoArchivo tipoarchivo= new TipoArchivo();

		try {
			TipoArchivoDataAccess tipoarchivoDataAccess=new TipoArchivoDataAccess();

			tipoarchivoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoarchivoDataAccess.setConnexionType(this.connexionType);
			tipoarchivoDataAccess.setParameterDbType(this.parameterDbType);

			tipoarchivo=tipoarchivoDataAccess.getEntity(connexion,relclientearchivo.getid_tipo_archivo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoarchivo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ClienteArchivo clientearchivo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!clientearchivo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(clientearchivo.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_archivo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_archivo.setValue(clientearchivo.getid_tipo_archivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_archivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(clientearchivo.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BYTES);
					ParameterValue<byte []> parameterMaintenanceValuearchivo=new ParameterValue<byte []>();
					parameterMaintenanceValuearchivo.setValue(clientearchivo.getarchivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearchivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(clientearchivo.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!clientearchivo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(clientearchivo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(clientearchivo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(clientearchivo.getId());
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
	
	public void setIsNewIsChangedFalseClienteArchivo(ClienteArchivo clientearchivo)throws Exception  {		
		clientearchivo.setIsNew(false);
		clientearchivo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseClienteArchivos(List<ClienteArchivo> clientearchivos)throws Exception  {				
		for(ClienteArchivo clientearchivo:clientearchivos) {
			clientearchivo.setIsNew(false);
			clientearchivo.setIsChanged(false);
		}
	}
	
	public void generarExportarClienteArchivo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
