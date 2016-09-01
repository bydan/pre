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
import com.bydan.erp.tesoreria.util.*;//BancoTipoCuentaBancoGlobalConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class BancoTipoCuentaBancoGlobalDataAccess extends  BancoTipoCuentaBancoGlobalDataAccessAdditional{ //BancoTipoCuentaBancoGlobalDataAccessAdditional,DataAccessHelper<BancoTipoCuentaBancoGlobal>
	//static Logger logger = Logger.getLogger(BancoTipoCuentaBancoGlobalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="banco_tipo_cuenta_banco_global";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_banco,id_tipo_cuenta_banco_global)values(current_timestamp,?,?,?)";
	public static String QUERYUPDATE="update "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_banco=?,id_tipo_cuenta_banco_global=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select bancotipocuentabancoglobal from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCENAME+" bancotipocuentabancoglobal";
	public static String QUERYSELECTNATIVE="select "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_empresa,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_banco,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row from "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+BancoTipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_banco=?,id_tipo_cuenta_banco_global=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BANCOTIPOCUENTABANCOGLOBAL_INSERT(?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BANCOTIPOCUENTABANCOGLOBAL_UPDATE(?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BANCOTIPOCUENTABANCOGLOBAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BANCOTIPOCUENTABANCOGLOBAL_SELECT(?,?)";
	
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
	
	
	protected BancoTipoCuentaBancoGlobalDataAccessAdditional bancotipocuentabancoglobalDataAccessAdditional=null;
	
	public BancoTipoCuentaBancoGlobalDataAccessAdditional getBancoTipoCuentaBancoGlobalDataAccessAdditional() {
		return this.bancotipocuentabancoglobalDataAccessAdditional;
	}
	
	public void setBancoTipoCuentaBancoGlobalDataAccessAdditional(BancoTipoCuentaBancoGlobalDataAccessAdditional bancotipocuentabancoglobalDataAccessAdditional) {
		try {
			this.bancotipocuentabancoglobalDataAccessAdditional=bancotipocuentabancoglobalDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BancoTipoCuentaBancoGlobalDataAccess() {
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
		BancoTipoCuentaBancoGlobalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BancoTipoCuentaBancoGlobalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BancoTipoCuentaBancoGlobalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBancoTipoCuentaBancoGlobalOriginal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal)throws Exception  {
		bancotipocuentabancoglobal.setBancoTipoCuentaBancoGlobalOriginal((BancoTipoCuentaBancoGlobal)bancotipocuentabancoglobal.clone());		
	}
	
	public void setBancoTipoCuentaBancoGlobalsOriginal(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals)throws Exception  {
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals){
			bancotipocuentabancoglobal.setBancoTipoCuentaBancoGlobalOriginal((BancoTipoCuentaBancoGlobal)bancotipocuentabancoglobal.clone());
		}
	}
	
	public static void setBancoTipoCuentaBancoGlobalOriginalStatic(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal)throws Exception  {
		bancotipocuentabancoglobal.setBancoTipoCuentaBancoGlobalOriginal((BancoTipoCuentaBancoGlobal)bancotipocuentabancoglobal.clone());		
	}
	
	public static void setBancoTipoCuentaBancoGlobalsOriginalStatic(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals)throws Exception  {
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals){
			bancotipocuentabancoglobal.setBancoTipoCuentaBancoGlobalOriginal((BancoTipoCuentaBancoGlobal)bancotipocuentabancoglobal.clone());
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
	
	public  BancoTipoCuentaBancoGlobal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		
		
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
	
	public  BancoTipoCuentaBancoGlobal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.BancoTipoCuentaBancoGlobal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBancoTipoCuentaBancoGlobalOriginal(new BancoTipoCuentaBancoGlobal());
      	    	entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet); 
				
				//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  BancoTipoCuentaBancoGlobal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();
				
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
	
	public  BancoTipoCuentaBancoGlobal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.BancoTipoCuentaBancoGlobal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBancoTipoCuentaBancoGlobalOriginal(new BancoTipoCuentaBancoGlobal());
      	    	entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet);    
				
				//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //BancoTipoCuentaBancoGlobal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.BancoTipoCuentaBancoGlobal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<BancoTipoCuentaBancoGlobal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		
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
	
	public  List<BancoTipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoTipoCuentaBancoGlobal();
      	    	entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet);
      	    	
				//entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BancoTipoCuentaBancoGlobal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
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
	
	public  List<BancoTipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoTipoCuentaBancoGlobal();
				
				if(conMapGenerico) {
					entity.inicializarMapBancoTipoCuentaBancoGlobal();
					//entity.setMapBancoTipoCuentaBancoGlobal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBancoTipoCuentaBancoGlobalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBancoTipoCuentaBancoGlobal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=BancoTipoCuentaBancoGlobalDataAccess.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
					////entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public BancoTipoCuentaBancoGlobal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
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
	
	public  BancoTipoCuentaBancoGlobal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoTipoCuentaBancoGlobal();
				
				if(conMapGenerico) {
					entity.inicializarMapBancoTipoCuentaBancoGlobal();
					//entity.setMapBancoTipoCuentaBancoGlobal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBancoTipoCuentaBancoGlobalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBancoTipoCuentaBancoGlobal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=BancoTipoCuentaBancoGlobalDataAccess.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
					////entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					////entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BancoTipoCuentaBancoGlobal getEntityBancoTipoCuentaBancoGlobal(String strPrefijo,BancoTipoCuentaBancoGlobal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = BancoTipoCuentaBancoGlobal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = BancoTipoCuentaBancoGlobal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BancoTipoCuentaBancoGlobalDataAccess.setFieldReflectionBancoTipoCuentaBancoGlobal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBancoTipoCuentaBancoGlobal=BancoTipoCuentaBancoGlobalConstantesFunciones.getTodosTiposColumnasBancoTipoCuentaBancoGlobal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBancoTipoCuentaBancoGlobal) {
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
							field = BancoTipoCuentaBancoGlobal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = BancoTipoCuentaBancoGlobal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BancoTipoCuentaBancoGlobalDataAccess.setFieldReflectionBancoTipoCuentaBancoGlobal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBancoTipoCuentaBancoGlobal(Field field,String strPrefijo,String sColumn,BancoTipoCuentaBancoGlobal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BancoTipoCuentaBancoGlobalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoTipoCuentaBancoGlobalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BancoTipoCuentaBancoGlobal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new BancoTipoCuentaBancoGlobal();
					entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet);
					
					//entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
					//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BancoTipoCuentaBancoGlobal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BancoTipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<BancoTipoCuentaBancoGlobal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
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
	
	public  List<BancoTipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoTipoCuentaBancoGlobal();
      	    	entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet);
      	    	
				//entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBancoTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BancoTipoCuentaBancoGlobal> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
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
	
	public  List<BancoTipoCuentaBancoGlobal> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BancoTipoCuentaBancoGlobal> entities = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		BancoTipoCuentaBancoGlobal entity = new BancoTipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BancoTipoCuentaBancoGlobal();
      	    	entity=super.getEntity("",entity,resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBancoTipoCuentaBancoGlobal("",entity,resultSet);
      	    	
				//entity.setBancoTipoCuentaBancoGlobalOriginal( new BancoTipoCuentaBancoGlobal());
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBancoTipoCuentaBancoGlobalOriginal(this.getEntityBancoTipoCuentaBancoGlobal("",entity.getBancoTipoCuentaBancoGlobalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public BancoTipoCuentaBancoGlobal getEntityBancoTipoCuentaBancoGlobal(String strPrefijo,BancoTipoCuentaBancoGlobal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA));
				entity.setid_banco(resultSet.getLong(strPrefijo+BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO));
				entity.setid_tipo_cuenta_banco_global(resultSet.getLong(strPrefijo+BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBancoTipoCuentaBancoGlobal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(BancoTipoCuentaBancoGlobal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BancoTipoCuentaBancoGlobalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BancoTipoCuentaBancoGlobalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BancoTipoCuentaBancoGlobalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BancoTipoCuentaBancoGlobalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BancoTipoCuentaBancoGlobalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME,BancoTipoCuentaBancoGlobalDataAccess.ISWITHSTOREPROCEDURES);
			
			BancoTipoCuentaBancoGlobalDataAccess.setBancoTipoCuentaBancoGlobalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,BancoTipoCuentaBancoGlobal relbancotipocuentabancoglobal)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbancotipocuentabancoglobal.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Banco getBanco(Connexion connexion,BancoTipoCuentaBancoGlobal relbancotipocuentabancoglobal)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relbancotipocuentabancoglobal.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal(Connexion connexion,BancoTipoCuentaBancoGlobal relbancotipocuentabancoglobal)throws SQLException,Exception {

		TipoCuentaBancoGlobal tipocuentabancoglobal= new TipoCuentaBancoGlobal();

		try {
			TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess=new TipoCuentaBancoGlobalDataAccess();

			tipocuentabancoglobalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,relbancotipocuentabancoglobal.getid_tipo_cuenta_banco_global());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancoglobal;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!bancotipocuentabancoglobal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(bancotipocuentabancoglobal.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(bancotipocuentabancoglobal.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco_global=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco_global.setValue(bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco_global);
					parametersTemp.add(parameterMaintenance);
					
						if(!bancotipocuentabancoglobal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(bancotipocuentabancoglobal.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(bancotipocuentabancoglobal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(bancotipocuentabancoglobal.getId());
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
	
	public void setIsNewIsChangedFalseBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal)throws Exception  {		
		bancotipocuentabancoglobal.setIsNew(false);
		bancotipocuentabancoglobal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals)throws Exception  {				
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
			bancotipocuentabancoglobal.setIsNew(false);
			bancotipocuentabancoglobal.setIsChanged(false);
		}
	}
	
	public void generarExportarBancoTipoCuentaBancoGlobal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
