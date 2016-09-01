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
import com.bydan.erp.contabilidad.util.*;//TransaccionContaConstantesFunciones;


import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.sris.business.dataaccess.*;


import com.bydan.erp.sris.util.*;




@SuppressWarnings("unused")
final public class TransaccionContaDataAccess extends  TransaccionContaDataAccessAdditional{ //TransaccionContaDataAccessAdditional,DataAccessHelper<TransaccionConta>
	//static Logger logger = Logger.getLogger(TransaccionContaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="transaccion_conta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select transaccionconta from "+TransaccionContaConstantesFunciones.SPERSISTENCENAME+" transaccionconta";
	public static String QUERYSELECTNATIVE="select "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".id,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".version_row,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".codigo,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".nombre from "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME;//+" as "+TransaccionContaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".id,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".version_row,"+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+".codigo from "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME;//+" as "+TransaccionContaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TransaccionContaConstantesFunciones.SCHEMA+"."+TransaccionContaConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TRANSACCIONCONTA_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TRANSACCIONCONTA_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TRANSACCIONCONTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TRANSACCIONCONTA_SELECT(?,?)";
	
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
	
	
	protected TransaccionContaDataAccessAdditional transaccioncontaDataAccessAdditional=null;
	
	public TransaccionContaDataAccessAdditional getTransaccionContaDataAccessAdditional() {
		return this.transaccioncontaDataAccessAdditional;
	}
	
	public void setTransaccionContaDataAccessAdditional(TransaccionContaDataAccessAdditional transaccioncontaDataAccessAdditional) {
		try {
			this.transaccioncontaDataAccessAdditional=transaccioncontaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TransaccionContaDataAccess() {
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
		TransaccionContaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TransaccionContaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TransaccionContaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTransaccionContaOriginal(TransaccionConta transaccionconta)throws Exception  {
		transaccionconta.setTransaccionContaOriginal((TransaccionConta)transaccionconta.clone());		
	}
	
	public void setTransaccionContasOriginal(List<TransaccionConta> transaccioncontas)throws Exception  {
		
		for(TransaccionConta transaccionconta:transaccioncontas){
			transaccionconta.setTransaccionContaOriginal((TransaccionConta)transaccionconta.clone());
		}
	}
	
	public static void setTransaccionContaOriginalStatic(TransaccionConta transaccionconta)throws Exception  {
		transaccionconta.setTransaccionContaOriginal((TransaccionConta)transaccionconta.clone());		
	}
	
	public static void setTransaccionContasOriginalStatic(List<TransaccionConta> transaccioncontas)throws Exception  {
		
		for(TransaccionConta transaccionconta:transaccioncontas){
			transaccionconta.setTransaccionContaOriginal((TransaccionConta)transaccionconta.clone());
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
	
	public  TransaccionConta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();		
		
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
	
	public  TransaccionConta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TransaccionConta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTransaccionContaOriginal(new TransaccionConta());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionConta("",entity,resultSet); 
				
				//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionConta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TransaccionConta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();
				
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
	
	public  TransaccionConta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TransaccionConta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTransaccionContaOriginal(new TransaccionConta());
      	    	entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTransaccionConta("",entity,resultSet);    
				
				//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTransaccionConta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TransaccionConta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TransaccionConta entity = new TransaccionConta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TransaccionConta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTransaccionConta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TransaccionConta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		
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
	
	public  List<TransaccionConta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionConta();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionConta("",entity,resultSet);
      	    	
				//entity.setTransaccionContaOriginal( new TransaccionConta());
      	    	//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionContas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionConta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionConta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
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
	
	public  List<TransaccionConta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionConta();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionConta();
					//entity.setMapTransaccionConta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTransaccionContaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionConta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionContaDataAccess.getEntityTransaccionConta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionContaOriginal( new TransaccionConta());
					////entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionContas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TransaccionConta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();		  
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
	
	public  TransaccionConta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionConta();
				
				if(conMapGenerico) {
					entity.inicializarMapTransaccionConta();
					//entity.setMapTransaccionConta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTransaccionContaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTransaccionConta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
					entity=TransaccionContaDataAccess.getEntityTransaccionConta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTransaccionContaOriginal( new TransaccionConta());
					////entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
					////entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTransaccionConta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TransaccionConta getEntityTransaccionConta(String strPrefijo,TransaccionConta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TransaccionConta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TransaccionConta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TransaccionContaDataAccess.setFieldReflectionTransaccionConta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTransaccionConta=TransaccionContaConstantesFunciones.getTodosTiposColumnasTransaccionConta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTransaccionConta) {
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
							field = TransaccionConta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TransaccionConta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TransaccionContaDataAccess.setFieldReflectionTransaccionConta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTransaccionConta(Field field,String strPrefijo,String sColumn,TransaccionConta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TransaccionContaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TransaccionContaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionContaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TransaccionContaConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionConta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TransaccionConta();
					entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTransaccionConta("",entity,resultSet);
					
					//entity.setTransaccionContaOriginal( new TransaccionConta());
					//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
					//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTransaccionContas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionConta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TransaccionConta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TransaccionContaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TransaccionContaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TransaccionConta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
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
	
	public  List<TransaccionConta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionConta();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionConta("",entity,resultSet);
      	    	
				//entity.setTransaccionContaOriginal( new TransaccionConta());
      	    	//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTransaccionContas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTransaccionConta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TransaccionConta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
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
	
	public  List<TransaccionConta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TransaccionConta> entities = new  ArrayList<TransaccionConta>();
		TransaccionConta entity = new TransaccionConta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TransaccionConta();
      	    	entity=super.getEntity("",entity,resultSet,TransaccionContaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTransaccionConta("",entity,resultSet);
      	    	
				//entity.setTransaccionContaOriginal( new TransaccionConta());
      	    	//entity.setTransaccionContaOriginal(super.getEntity("",entity.getTransaccionContaOriginal(),resultSet,TransaccionContaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTransaccionContaOriginal(this.getEntityTransaccionConta("",entity.getTransaccionContaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTransaccionContas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TransaccionConta getEntityTransaccionConta(String strPrefijo,TransaccionConta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TransaccionContaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TransaccionContaConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TransaccionContaConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTransaccionConta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TransaccionConta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TransaccionContaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TransaccionContaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TransaccionContaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TransaccionContaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TransaccionContaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TransaccionContaDataAccess.TABLENAME,TransaccionContaDataAccess.ISWITHSTOREPROCEDURES);
			
			TransaccionContaDataAccess.setTransaccionContaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<Sri> getSris(Connexion connexion,TransaccionConta transaccionconta)throws SQLException,Exception {

		List<Sri> sris= new ArrayList<Sri>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta ON "+SriConstantesFunciones.SCHEMA+".sri.id_transaccion_conta="+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id WHERE "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id="+String.valueOf(transaccionconta.getId());
			} else {
				sQuery=" INNER JOIN sri.TransaccionConta WHERE sri.TransaccionConta.id="+String.valueOf(transaccionconta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SriDataAccess sriDataAccess=new SriDataAccess();

			sriDataAccess.setConnexionType(this.connexionType);
			sriDataAccess.setParameterDbType(this.parameterDbType);
			sris=sriDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sris;

	}

	public List<ImportarExportar> getImportarExportars(Connexion connexion,TransaccionConta transaccionconta)throws SQLException,Exception {

		List<ImportarExportar> importarexportars= new ArrayList<ImportarExportar>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta ON "+ImportarExportarConstantesFunciones.SCHEMA+".importar_exportar.id_transaccion_conta="+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id WHERE "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id="+String.valueOf(transaccionconta.getId());
			} else {
				sQuery=" INNER JOIN importarexportar.TransaccionConta WHERE importarexportar.TransaccionConta.id="+String.valueOf(transaccionconta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ImportarExportarDataAccess importarexportarDataAccess=new ImportarExportarDataAccess();

			importarexportarDataAccess.setConnexionType(this.connexionType);
			importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return importarexportars;

	}

	public List<TransaccionLocal> getTransaccionLocals(Connexion connexion,TransaccionConta transaccionconta)throws SQLException,Exception {

		List<TransaccionLocal> transaccionlocals= new ArrayList<TransaccionLocal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta ON "+TransaccionLocalConstantesFunciones.SCHEMA+".transaccion_local.id_transaccion_conta="+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id WHERE "+TransaccionContaConstantesFunciones.SCHEMA+".transaccion_conta.id="+String.valueOf(transaccionconta.getId());
			} else {
				sQuery=" INNER JOIN transaccionlocal.TransaccionConta WHERE transaccionlocal.TransaccionConta.id="+String.valueOf(transaccionconta.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TransaccionLocalDataAccess transaccionlocalDataAccess=new TransaccionLocalDataAccess();

			transaccionlocalDataAccess.setConnexionType(this.connexionType);
			transaccionlocalDataAccess.setParameterDbType(this.parameterDbType);
			transaccionlocals=transaccionlocalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionlocals;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TransaccionConta transaccionconta) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!transaccionconta.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(transaccionconta.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(transaccionconta.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(transaccionconta.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!transaccionconta.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(transaccionconta.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(transaccionconta.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(transaccionconta.getId());
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
	
	public void setIsNewIsChangedFalseTransaccionConta(TransaccionConta transaccionconta)throws Exception  {		
		transaccionconta.setIsNew(false);
		transaccionconta.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTransaccionContas(List<TransaccionConta> transaccioncontas)throws Exception  {				
		for(TransaccionConta transaccionconta:transaccioncontas) {
			transaccionconta.setIsNew(false);
			transaccionconta.setIsChanged(false);
		}
	}
	
	public void generarExportarTransaccionConta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
