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
import com.bydan.erp.cartera.util.*;//ClienteImagenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ClienteImagenDataAccess extends  ClienteImagenDataAccessAdditional{ //ClienteImagenDataAccessAdditional,DataAccessHelper<ClienteImagen>
	//static Logger logger = Logger.getLogger(ClienteImagenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cliente_imagen";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+"(version_row,id_cliente,id_tipo_imagen_persona,id_tipo_imagen,nombre,imagen,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_tipo_imagen_persona=?,id_tipo_imagen=?,nombre=?,imagen=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select clienteimagen from "+ClienteImagenConstantesFunciones.SPERSISTENCENAME+" clienteimagen";
	public static String QUERYSELECTNATIVE="select "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".version_row,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_cliente,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_tipo_imagen_persona,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id_tipo_imagen,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".nombre,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".imagen,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".descripcion from "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME;//+" as "+ClienteImagenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".id,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".version_row,"+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+".nombre from "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME;//+" as "+ClienteImagenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ClienteImagenConstantesFunciones.SCHEMA+"."+ClienteImagenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cliente=?,id_tipo_imagen_persona=?,id_tipo_imagen=?,nombre=?,imagen=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CLIENTEIMAGEN_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CLIENTEIMAGEN_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CLIENTEIMAGEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CLIENTEIMAGEN_SELECT(?,?)";
	
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
	
	
	protected ClienteImagenDataAccessAdditional clienteimagenDataAccessAdditional=null;
	
	public ClienteImagenDataAccessAdditional getClienteImagenDataAccessAdditional() {
		return this.clienteimagenDataAccessAdditional;
	}
	
	public void setClienteImagenDataAccessAdditional(ClienteImagenDataAccessAdditional clienteimagenDataAccessAdditional) {
		try {
			this.clienteimagenDataAccessAdditional=clienteimagenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ClienteImagenDataAccess() {
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
		ClienteImagenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ClienteImagenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ClienteImagenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setClienteImagenOriginal(ClienteImagen clienteimagen)throws Exception  {
		clienteimagen.setClienteImagenOriginal((ClienteImagen)clienteimagen.clone());		
	}
	
	public void setClienteImagensOriginal(List<ClienteImagen> clienteimagens)throws Exception  {
		
		for(ClienteImagen clienteimagen:clienteimagens){
			clienteimagen.setClienteImagenOriginal((ClienteImagen)clienteimagen.clone());
		}
	}
	
	public static void setClienteImagenOriginalStatic(ClienteImagen clienteimagen)throws Exception  {
		clienteimagen.setClienteImagenOriginal((ClienteImagen)clienteimagen.clone());		
	}
	
	public static void setClienteImagensOriginalStatic(List<ClienteImagen> clienteimagens)throws Exception  {
		
		for(ClienteImagen clienteimagen:clienteimagens){
			clienteimagen.setClienteImagenOriginal((ClienteImagen)clienteimagen.clone());
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
	
	public  ClienteImagen getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();		
		
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
	
	public  ClienteImagen getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ClienteImagen.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setClienteImagenOriginal(new ClienteImagen());
      	    	entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteImagen("",entity,resultSet); 
				
				//entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteImagen(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ClienteImagen getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();
				
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
	
	public  ClienteImagen getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteImagenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteImagen.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setClienteImagenOriginal(new ClienteImagen());
      	    	entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteImagen("",entity,resultSet);    
				
				//entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteImagen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ClienteImagen
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ClienteImagen entity = new ClienteImagen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteImagenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteImagen.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseClienteImagen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ClienteImagen> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		
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
	
	public  List<ClienteImagen> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteImagenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteImagen();
      	    	entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteImagen("",entity,resultSet);
      	    	
				//entity.setClienteImagenOriginal( new ClienteImagen());
      	    	//entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteImagens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteImagen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteImagen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
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
	
	public  List<ClienteImagen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteImagen();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteImagen();
					//entity.setMapClienteImagen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapClienteImagenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteImagen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         		
					entity=ClienteImagenDataAccess.getEntityClienteImagen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteImagenOriginal( new ClienteImagen());
					////entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteImagens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteImagen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ClienteImagen getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();		  
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
	
	public  ClienteImagen getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteImagen();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteImagen();
					//entity.setMapClienteImagen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapClienteImagenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteImagen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         		
					entity=ClienteImagenDataAccess.getEntityClienteImagen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteImagenOriginal( new ClienteImagen());
					////entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseClienteImagen(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteImagen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ClienteImagen getEntityClienteImagen(String strPrefijo,ClienteImagen entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ClienteImagen.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ClienteImagen.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ClienteImagenDataAccess.setFieldReflectionClienteImagen(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasClienteImagen=ClienteImagenConstantesFunciones.getTodosTiposColumnasClienteImagen();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasClienteImagen) {
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
							field = ClienteImagen.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ClienteImagen.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ClienteImagenDataAccess.setFieldReflectionClienteImagen(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionClienteImagen(Field field,String strPrefijo,String sColumn,ClienteImagen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ClienteImagenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.IDTIPOIMAGEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.IMAGEN:
					field.set(entity,resultSet.getBytes(sCampo));
					break;
				
				case ClienteImagenConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteImagen>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteImagenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ClienteImagen();
					entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityClienteImagen("",entity,resultSet);
					
					//entity.setClienteImagenOriginal( new ClienteImagen());
					//entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
					//entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseClienteImagens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteImagen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteImagen>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteImagenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteImagenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ClienteImagen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
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
	
	public  List<ClienteImagen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteImagen> entities = new  ArrayList<ClienteImagen>();
		ClienteImagen entity = new ClienteImagen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteImagen();
      	    	entity=super.getEntity("",entity,resultSet,ClienteImagenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteImagen("",entity,resultSet);
      	    	
				//entity.setClienteImagenOriginal( new ClienteImagen());
      	    	//entity.setClienteImagenOriginal(super.getEntity("",entity.getClienteImagenOriginal(),resultSet,ClienteImagenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteImagenOriginal(this.getEntityClienteImagen("",entity.getClienteImagenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseClienteImagens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteImagen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public ClienteImagen getEntityClienteImagen(String strPrefijo,ClienteImagen entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_cliente(resultSet.getLong(strPrefijo+ClienteImagenConstantesFunciones.IDCLIENTE));
				entity.setid_tipo_imagen_persona(resultSet.getLong(strPrefijo+ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA));
				entity.setid_tipo_imagen(resultSet.getLong(strPrefijo+ClienteImagenConstantesFunciones.IDTIPOIMAGEN));
				entity.setnombre(resultSet.getString(strPrefijo+ClienteImagenConstantesFunciones.NOMBRE));
				if(resultSet.getBytes(strPrefijo+ClienteImagenConstantesFunciones.IMAGEN)!=null) {entity.setimagen(resultSet.getBytes(strPrefijo+ClienteImagenConstantesFunciones.IMAGEN));}
				entity.setdescripcion(resultSet.getString(strPrefijo+ClienteImagenConstantesFunciones.DESCRIPCION));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ClienteImagenConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowClienteImagen(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ClienteImagen entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ClienteImagenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ClienteImagenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ClienteImagenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ClienteImagenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ClienteImagenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ClienteImagenDataAccess.TABLENAME,ClienteImagenDataAccess.ISWITHSTOREPROCEDURES);
			
			ClienteImagenDataAccess.setClienteImagenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Cliente getCliente(Connexion connexion,ClienteImagen relclienteimagen)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relclienteimagen.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoImagenPersona getTipoImagenPersona(Connexion connexion,ClienteImagen relclienteimagen)throws SQLException,Exception {

		TipoImagenPersona tipoimagenpersona= new TipoImagenPersona();

		try {
			TipoImagenPersonaDataAccess tipoimagenpersonaDataAccess=new TipoImagenPersonaDataAccess();

			tipoimagenpersonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoimagenpersonaDataAccess.setConnexionType(this.connexionType);
			tipoimagenpersonaDataAccess.setParameterDbType(this.parameterDbType);

			tipoimagenpersona=tipoimagenpersonaDataAccess.getEntity(connexion,relclienteimagen.getid_tipo_imagen_persona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoimagenpersona;

	}

	public TipoImagen getTipoImagen(Connexion connexion,ClienteImagen relclienteimagen)throws SQLException,Exception {

		TipoImagen tipoimagen= new TipoImagen();

		try {
			TipoImagenDataAccess tipoimagenDataAccess=new TipoImagenDataAccess();

			tipoimagenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoimagenDataAccess.setConnexionType(this.connexionType);
			tipoimagenDataAccess.setParameterDbType(this.parameterDbType);

			tipoimagen=tipoimagenDataAccess.getEntity(connexion,relclienteimagen.getid_tipo_imagen());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoimagen;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ClienteImagen clienteimagen) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!clienteimagen.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(clienteimagen.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_imagen_persona=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_imagen_persona.setValue(clienteimagen.getid_tipo_imagen_persona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_imagen_persona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_imagen=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_imagen.setValue(clienteimagen.getid_tipo_imagen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_imagen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(clienteimagen.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BYTES);
					ParameterValue<byte []> parameterMaintenanceValueimagen=new ParameterValue<byte []>();
					parameterMaintenanceValueimagen.setValue(clienteimagen.getimagen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueimagen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(clienteimagen.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!clienteimagen.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(clienteimagen.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(clienteimagen.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(clienteimagen.getId());
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
	
	public void setIsNewIsChangedFalseClienteImagen(ClienteImagen clienteimagen)throws Exception  {		
		clienteimagen.setIsNew(false);
		clienteimagen.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseClienteImagens(List<ClienteImagen> clienteimagens)throws Exception  {				
		for(ClienteImagen clienteimagen:clienteimagens) {
			clienteimagen.setIsNew(false);
			clienteimagen.setIsChanged(false);
		}
	}
	
	public void generarExportarClienteImagen(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
