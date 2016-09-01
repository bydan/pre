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
import com.bydan.erp.cartera.util.*;//ClienteCoaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ClienteCoaDataAccess extends  ClienteCoaDataAccessAdditional{ //ClienteCoaDataAccessAdditional,DataAccessHelper<ClienteCoa>
	//static Logger logger = Logger.getLogger(ClienteCoaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cliente_coa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_cliente,id_usuario,autori_imprenta,autori_usuario,num_factura_ini,num_factura_fin,serie_docu,fecha_vali)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_usuario=?,autori_imprenta=?,autori_usuario=?,num_factura_ini=?,num_factura_fin=?,serie_docu=?,fecha_vali=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select clientecoa from "+ClienteCoaConstantesFunciones.SPERSISTENCENAME+" clientecoa";
	public static String QUERYSELECTNATIVE="select "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".version_row,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_empresa,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_cliente,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id_usuario,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".autori_imprenta,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".autori_usuario,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".num_factura_ini,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".num_factura_fin,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".serie_docu,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".fecha_vali from "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME;//+" as "+ClienteCoaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".id,"+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+".version_row from "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME;//+" as "+ClienteCoaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ClienteCoaConstantesFunciones.SCHEMA+"."+ClienteCoaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_cliente=?,id_usuario=?,autori_imprenta=?,autori_usuario=?,num_factura_ini=?,num_factura_fin=?,serie_docu=?,fecha_vali=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CLIENTECOA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CLIENTECOA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CLIENTECOA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CLIENTECOA_SELECT(?,?)";
	
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
	
	
	protected ClienteCoaDataAccessAdditional clientecoaDataAccessAdditional=null;
	
	public ClienteCoaDataAccessAdditional getClienteCoaDataAccessAdditional() {
		return this.clientecoaDataAccessAdditional;
	}
	
	public void setClienteCoaDataAccessAdditional(ClienteCoaDataAccessAdditional clientecoaDataAccessAdditional) {
		try {
			this.clientecoaDataAccessAdditional=clientecoaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ClienteCoaDataAccess() {
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
		ClienteCoaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ClienteCoaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ClienteCoaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setClienteCoaOriginal(ClienteCoa clientecoa)throws Exception  {
		clientecoa.setClienteCoaOriginal((ClienteCoa)clientecoa.clone());		
	}
	
	public void setClienteCoasOriginal(List<ClienteCoa> clientecoas)throws Exception  {
		
		for(ClienteCoa clientecoa:clientecoas){
			clientecoa.setClienteCoaOriginal((ClienteCoa)clientecoa.clone());
		}
	}
	
	public static void setClienteCoaOriginalStatic(ClienteCoa clientecoa)throws Exception  {
		clientecoa.setClienteCoaOriginal((ClienteCoa)clientecoa.clone());		
	}
	
	public static void setClienteCoasOriginalStatic(List<ClienteCoa> clientecoas)throws Exception  {
		
		for(ClienteCoa clientecoa:clientecoas){
			clientecoa.setClienteCoaOriginal((ClienteCoa)clientecoa.clone());
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
	
	public  ClienteCoa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();		
		
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
	
	public  ClienteCoa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.ClienteCoa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setClienteCoaOriginal(new ClienteCoa());
      	    	entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteCoa("",entity,resultSet); 
				
				//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteCoa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ClienteCoa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();
				
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
	
	public  ClienteCoa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteCoaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteCoa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setClienteCoaOriginal(new ClienteCoa());
      	    	entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityClienteCoa("",entity,resultSet);    
				
				//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseClienteCoa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ClienteCoa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ClienteCoa entity = new ClienteCoa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteCoaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.ClienteCoa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseClienteCoa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ClienteCoa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		
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
	
	public  List<ClienteCoa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteCoaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteCoa();
      	    	entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteCoa("",entity,resultSet);
      	    	
				//entity.setClienteCoaOriginal( new ClienteCoa());
      	    	//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteCoas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteCoa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteCoa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
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
	
	public  List<ClienteCoa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteCoa();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteCoa();
					//entity.setMapClienteCoa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapClienteCoaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteCoa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
					entity=ClienteCoaDataAccess.getEntityClienteCoa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteCoaOriginal( new ClienteCoa());
					////entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteCoas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteCoa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ClienteCoa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();		  
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
	
	public  ClienteCoa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteCoa();
				
				if(conMapGenerico) {
					entity.inicializarMapClienteCoa();
					//entity.setMapClienteCoa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapClienteCoaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapClienteCoa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
					entity=ClienteCoaDataAccess.getEntityClienteCoa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setClienteCoaOriginal( new ClienteCoa());
					////entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
					////entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseClienteCoa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteCoa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ClienteCoa getEntityClienteCoa(String strPrefijo,ClienteCoa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ClienteCoa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ClienteCoa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ClienteCoaDataAccess.setFieldReflectionClienteCoa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasClienteCoa=ClienteCoaConstantesFunciones.getTodosTiposColumnasClienteCoa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasClienteCoa) {
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
							field = ClienteCoa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ClienteCoa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ClienteCoaDataAccess.setFieldReflectionClienteCoa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionClienteCoa(Field field,String strPrefijo,String sColumn,ClienteCoa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ClienteCoaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.AUTORIIMPRENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.AUTORIUSUARIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.NUMFACTURAINI:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.NUMFACTURAFIN:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.SERIEDOCU:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ClienteCoaConstantesFunciones.FECHAVALI:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteCoa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteCoaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ClienteCoa();
					entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityClienteCoa("",entity,resultSet);
					
					//entity.setClienteCoaOriginal( new ClienteCoa());
					//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
					//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseClienteCoas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteCoa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ClienteCoa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ClienteCoaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ClienteCoaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ClienteCoa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
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
	
	public  List<ClienteCoa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteCoa();
      	    	entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteCoa("",entity,resultSet);
      	    	
				//entity.setClienteCoaOriginal( new ClienteCoa());
      	    	//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseClienteCoas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarClienteCoa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ClienteCoa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
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
	
	public  List<ClienteCoa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ClienteCoa> entities = new  ArrayList<ClienteCoa>();
		ClienteCoa entity = new ClienteCoa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ClienteCoa();
      	    	entity=super.getEntity("",entity,resultSet,ClienteCoaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityClienteCoa("",entity,resultSet);
      	    	
				//entity.setClienteCoaOriginal( new ClienteCoa());
      	    	//entity.setClienteCoaOriginal(super.getEntity("",entity.getClienteCoaOriginal(),resultSet,ClienteCoaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setClienteCoaOriginal(this.getEntityClienteCoa("",entity.getClienteCoaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseClienteCoas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ClienteCoa getEntityClienteCoa(String strPrefijo,ClienteCoa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ClienteCoaConstantesFunciones.IDEMPRESA));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ClienteCoaConstantesFunciones.IDCLIENTE));
				entity.setid_usuario(resultSet.getLong(strPrefijo+ClienteCoaConstantesFunciones.IDUSUARIO));
				entity.setautori_imprenta(resultSet.getString(strPrefijo+ClienteCoaConstantesFunciones.AUTORIIMPRENTA));
				entity.setautori_usuario(resultSet.getString(strPrefijo+ClienteCoaConstantesFunciones.AUTORIUSUARIO));
				entity.setnum_factura_ini(resultSet.getString(strPrefijo+ClienteCoaConstantesFunciones.NUMFACTURAINI));
				entity.setnum_factura_fin(resultSet.getString(strPrefijo+ClienteCoaConstantesFunciones.NUMFACTURAFIN));
				entity.setserie_docu(resultSet.getString(strPrefijo+ClienteCoaConstantesFunciones.SERIEDOCU));
				entity.setfecha_vali(new Date(resultSet.getDate(strPrefijo+ClienteCoaConstantesFunciones.FECHAVALI).getTime()));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowClienteCoa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ClienteCoa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ClienteCoaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ClienteCoaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ClienteCoaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ClienteCoaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ClienteCoaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ClienteCoaDataAccess.TABLENAME,ClienteCoaDataAccess.ISWITHSTOREPROCEDURES);
			
			ClienteCoaDataAccess.setClienteCoaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ClienteCoa relclientecoa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relclientecoa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Cliente getCliente(Connexion connexion,ClienteCoa relclientecoa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relclientecoa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Usuario getUsuario(Connexion connexion,ClienteCoa relclientecoa)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relclientecoa.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ClienteCoa clientecoa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!clientecoa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(clientecoa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(clientecoa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(clientecoa.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautori_imprenta=new ParameterValue<String>();
					parameterMaintenanceValueautori_imprenta.setValue(clientecoa.getautori_imprenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautori_imprenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueautori_usuario=new ParameterValue<String>();
					parameterMaintenanceValueautori_usuario.setValue(clientecoa.getautori_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueautori_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenum_factura_ini=new ParameterValue<String>();
					parameterMaintenanceValuenum_factura_ini.setValue(clientecoa.getnum_factura_ini());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenum_factura_ini);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenum_factura_fin=new ParameterValue<String>();
					parameterMaintenanceValuenum_factura_fin.setValue(clientecoa.getnum_factura_fin());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenum_factura_fin);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueserie_docu=new ParameterValue<String>();
					parameterMaintenanceValueserie_docu.setValue(clientecoa.getserie_docu());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueserie_docu);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vali=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vali.setValue(clientecoa.getfecha_vali());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vali);
					parametersTemp.add(parameterMaintenance);
					
						if(!clientecoa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(clientecoa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(clientecoa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(clientecoa.getId());
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
	
	public void setIsNewIsChangedFalseClienteCoa(ClienteCoa clientecoa)throws Exception  {		
		clientecoa.setIsNew(false);
		clientecoa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseClienteCoas(List<ClienteCoa> clientecoas)throws Exception  {				
		for(ClienteCoa clientecoa:clientecoas) {
			clientecoa.setIsNew(false);
			clientecoa.setIsChanged(false);
		}
	}
	
	public void generarExportarClienteCoa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
