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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperSinIdGenerated;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.tesoreria.util.*;//EstadoCuentaBancoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class EstadoCuentaBancoDataAccess extends  DataAccessHelperSinIdGenerated<EstadoCuentaBanco>{ //EstadoCuentaBancoDataAccessAdditional,DataAccessHelper<EstadoCuentaBanco>
	//static Logger logger = Logger.getLogger(EstadoCuentaBancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="estado_cuenta_banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre,es_defecto)values(?,current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,es_defecto=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select estadocuentabanco from "+EstadoCuentaBancoConstantesFunciones.SPERSISTENCENAME+" estadocuentabanco";
	public static String QUERYSELECTNATIVE="select "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".id,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".codigo,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".nombre,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".es_defecto from "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME;//+" as "+EstadoCuentaBancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".id,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".version_row,"+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+".codigo from "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME;//+" as "+EstadoCuentaBancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+EstadoCuentaBancoConstantesFunciones.SCHEMA+"."+EstadoCuentaBancoConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?,es_defecto=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ESTADOCUENTABANCO_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ESTADOCUENTABANCO_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ESTADOCUENTABANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ESTADOCUENTABANCO_SELECT(?,?)";
	
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
	
	
	public EstadoCuentaBancoDataAccess() {
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
		EstadoCuentaBancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		EstadoCuentaBancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		EstadoCuentaBancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setEstadoCuentaBancoOriginal(EstadoCuentaBanco estadocuentabanco)throws Exception  {
		estadocuentabanco.setEstadoCuentaBancoOriginal((EstadoCuentaBanco)estadocuentabanco.clone());		
	}
	
	public void setEstadoCuentaBancosOriginal(List<EstadoCuentaBanco> estadocuentabancos)throws Exception  {
		
		for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos){
			estadocuentabanco.setEstadoCuentaBancoOriginal((EstadoCuentaBanco)estadocuentabanco.clone());
		}
	}
	
	public static void setEstadoCuentaBancoOriginalStatic(EstadoCuentaBanco estadocuentabanco)throws Exception  {
		estadocuentabanco.setEstadoCuentaBancoOriginal((EstadoCuentaBanco)estadocuentabanco.clone());		
	}
	
	public static void setEstadoCuentaBancosOriginalStatic(List<EstadoCuentaBanco> estadocuentabancos)throws Exception  {
		
		for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos){
			estadocuentabanco.setEstadoCuentaBancoOriginal((EstadoCuentaBanco)estadocuentabanco.clone());
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
	
	public  EstadoCuentaBanco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		
		
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
	
	public  EstadoCuentaBanco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.EstadoCuentaBanco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setEstadoCuentaBancoOriginal(new EstadoCuentaBanco());
      	    	entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoCuentaBanco("",entity,resultSet); 
				
				//entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoCuentaBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  EstadoCuentaBanco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();
				
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
	
	public  EstadoCuentaBanco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoCuentaBanco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setEstadoCuentaBancoOriginal(new EstadoCuentaBanco());
      	    	entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityEstadoCuentaBanco("",entity,resultSet);    
				
				//entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseEstadoCuentaBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //EstadoCuentaBanco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		EstadoCuentaBanco entity = new EstadoCuentaBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.EstadoCuentaBanco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseEstadoCuentaBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<EstadoCuentaBanco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		
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
	
	public  List<EstadoCuentaBanco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCuentaBanco();
      	    	entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoCuentaBanco("",entity,resultSet);
      	    	
				//entity.setEstadoCuentaBancoOriginal( new EstadoCuentaBanco());
      	    	//entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoCuentaBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<EstadoCuentaBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
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
	
	public  List<EstadoCuentaBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCuentaBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoCuentaBanco();
					//entity.setMapEstadoCuentaBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapEstadoCuentaBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoCuentaBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoCuentaBancoDataAccess.getEntityEstadoCuentaBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoCuentaBancoOriginal( new EstadoCuentaBanco());
					////entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseEstadoCuentaBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public EstadoCuentaBanco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
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
	
	public  EstadoCuentaBanco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCuentaBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapEstadoCuentaBanco();
					//entity.setMapEstadoCuentaBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapEstadoCuentaBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapEstadoCuentaBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=EstadoCuentaBancoDataAccess.getEntityEstadoCuentaBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setEstadoCuentaBancoOriginal( new EstadoCuentaBanco());
					////entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseEstadoCuentaBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static EstadoCuentaBanco getEntityEstadoCuentaBanco(String strPrefijo,EstadoCuentaBanco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = EstadoCuentaBanco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = EstadoCuentaBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					EstadoCuentaBancoDataAccess.setFieldReflectionEstadoCuentaBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasEstadoCuentaBanco=EstadoCuentaBancoConstantesFunciones.getTodosTiposColumnasEstadoCuentaBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasEstadoCuentaBanco) {
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
							field = EstadoCuentaBanco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = EstadoCuentaBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						EstadoCuentaBancoDataAccess.setFieldReflectionEstadoCuentaBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionEstadoCuentaBanco(Field field,String strPrefijo,String sColumn,EstadoCuentaBanco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case EstadoCuentaBancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case EstadoCuentaBancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoCuentaBancoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoCuentaBancoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case EstadoCuentaBancoConstantesFunciones.ESDEFECTO:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoCuentaBanco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new EstadoCuentaBanco();
					entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityEstadoCuentaBanco("",entity,resultSet);
					
					//entity.setEstadoCuentaBancoOriginal( new EstadoCuentaBanco());
					//entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
					//entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseEstadoCuentaBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<EstadoCuentaBanco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=EstadoCuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,EstadoCuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<EstadoCuentaBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
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
	
	public  List<EstadoCuentaBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<EstadoCuentaBanco> entities = new  ArrayList<EstadoCuentaBanco>();
		EstadoCuentaBanco entity = new EstadoCuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new EstadoCuentaBanco();
      	    	entity=super.getEntity("",entity,resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityEstadoCuentaBanco("",entity,resultSet);
      	    	
				//entity.setEstadoCuentaBancoOriginal( new EstadoCuentaBanco());
      	    	//entity.setEstadoCuentaBancoOriginal(super.getEntity("",entity.getEstadoCuentaBancoOriginal(),resultSet,EstadoCuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setEstadoCuentaBancoOriginal(this.getEntityEstadoCuentaBanco("",entity.getEstadoCuentaBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseEstadoCuentaBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarEstadoCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public EstadoCuentaBanco getEntityEstadoCuentaBanco(String strPrefijo,EstadoCuentaBanco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoCuentaBancoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+EstadoCuentaBancoConstantesFunciones.NOMBRE));
				entity.setes_defecto(resultSet.getBoolean(strPrefijo+EstadoCuentaBancoConstantesFunciones.ESDEFECTO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+EstadoCuentaBancoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowEstadoCuentaBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(EstadoCuentaBanco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=EstadoCuentaBancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=EstadoCuentaBancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=EstadoCuentaBancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=EstadoCuentaBancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(EstadoCuentaBancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,EstadoCuentaBancoDataAccess.TABLENAME,EstadoCuentaBancoDataAccess.ISWITHSTOREPROCEDURES);
			
			EstadoCuentaBancoDataAccess.setEstadoCuentaBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<CuentaBanco> getCuentaBancos(Connexion connexion,EstadoCuentaBanco estadocuentabanco)throws SQLException,Exception {

		List<CuentaBanco> cuentabancos= new ArrayList<CuentaBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+EstadoCuentaBancoConstantesFunciones.SCHEMA+".estado_cuenta_banco ON "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id_estado_cuenta_banco="+EstadoCuentaBancoConstantesFunciones.SCHEMA+".estado_cuenta_banco.id WHERE "+EstadoCuentaBancoConstantesFunciones.SCHEMA+".estado_cuenta_banco.id="+String.valueOf(estadocuentabanco.getId());
			} else {
				sQuery=" INNER JOIN cuentabanco.EstadoCuentaBanco WHERE cuentabanco.EstadoCuentaBanco.id="+String.valueOf(estadocuentabanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CuentaBancoDataAccess cuentabancoDataAccess=new CuentaBancoDataAccess();

			cuentabancoDataAccess.setConnexionType(this.connexionType);
			cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentabancos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,EstadoCuentaBanco estadocuentabanco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!estadocuentabanco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(estadocuentabanco.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(estadocuentabanco.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(estadocuentabanco.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_defecto=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_defecto.setValue(estadocuentabanco.getes_defecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_defecto);
					parametersTemp.add(parameterMaintenance);
					
						if(!estadocuentabanco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(estadocuentabanco.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(estadocuentabanco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(estadocuentabanco.getId());
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
	
	public void setIsNewIsChangedFalseEstadoCuentaBanco(EstadoCuentaBanco estadocuentabanco)throws Exception  {		
		estadocuentabanco.setIsNew(false);
		estadocuentabanco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseEstadoCuentaBancos(List<EstadoCuentaBanco> estadocuentabancos)throws Exception  {				
		for(EstadoCuentaBanco estadocuentabanco:estadocuentabancos) {
			estadocuentabanco.setIsNew(false);
			estadocuentabanco.setIsChanged(false);
		}
	}
	
	public void generarExportarEstadoCuentaBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
