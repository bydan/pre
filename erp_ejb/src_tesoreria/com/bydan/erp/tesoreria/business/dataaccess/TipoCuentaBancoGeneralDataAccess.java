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
import com.bydan.erp.tesoreria.util.*;//TipoCuentaBancoGeneralConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoCuentaBancoGeneralDataAccess extends  TipoCuentaBancoGeneralDataAccessAdditional{ //TipoCuentaBancoGeneralDataAccessAdditional,DataAccessHelper<TipoCuentaBancoGeneral>
	//static Logger logger = Logger.getLogger(TipoCuentaBancoGeneralDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_cuenta_banco_general";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_banco,id_tipo_cuenta_banco,codigo)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_banco=?,id_tipo_cuenta_banco=?,codigo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocuentabancogeneral from "+TipoCuentaBancoGeneralConstantesFunciones.SPERSISTENCENAME+" tipocuentabancogeneral";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_empresa,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_banco,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".codigo from "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+".codigo from "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCuentaBancoGeneralConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGeneralConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_banco=?,id_tipo_cuenta_banco=?,codigo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCUENTABANCOGENERAL_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCUENTABANCOGENERAL_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCUENTABANCOGENERAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCUENTABANCOGENERAL_SELECT(?,?)";
	
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
	
	
	protected TipoCuentaBancoGeneralDataAccessAdditional tipocuentabancogeneralDataAccessAdditional=null;
	
	public TipoCuentaBancoGeneralDataAccessAdditional getTipoCuentaBancoGeneralDataAccessAdditional() {
		return this.tipocuentabancogeneralDataAccessAdditional;
	}
	
	public void setTipoCuentaBancoGeneralDataAccessAdditional(TipoCuentaBancoGeneralDataAccessAdditional tipocuentabancogeneralDataAccessAdditional) {
		try {
			this.tipocuentabancogeneralDataAccessAdditional=tipocuentabancogeneralDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoCuentaBancoGeneralDataAccess() {
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
		TipoCuentaBancoGeneralDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCuentaBancoGeneralDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCuentaBancoGeneralDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCuentaBancoGeneralOriginal(TipoCuentaBancoGeneral tipocuentabancogeneral)throws Exception  {
		tipocuentabancogeneral.setTipoCuentaBancoGeneralOriginal((TipoCuentaBancoGeneral)tipocuentabancogeneral.clone());		
	}
	
	public void setTipoCuentaBancoGeneralsOriginal(List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception  {
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals){
			tipocuentabancogeneral.setTipoCuentaBancoGeneralOriginal((TipoCuentaBancoGeneral)tipocuentabancogeneral.clone());
		}
	}
	
	public static void setTipoCuentaBancoGeneralOriginalStatic(TipoCuentaBancoGeneral tipocuentabancogeneral)throws Exception  {
		tipocuentabancogeneral.setTipoCuentaBancoGeneralOriginal((TipoCuentaBancoGeneral)tipocuentabancogeneral.clone());		
	}
	
	public static void setTipoCuentaBancoGeneralsOriginalStatic(List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception  {
		
		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals){
			tipocuentabancogeneral.setTipoCuentaBancoGeneralOriginal((TipoCuentaBancoGeneral)tipocuentabancogeneral.clone());
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
	
	public  TipoCuentaBancoGeneral getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		
		
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
	
	public  TipoCuentaBancoGeneral getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoCuentaBancoGeneral.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCuentaBancoGeneralOriginal(new TipoCuentaBancoGeneral());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet); 
				
				//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaBancoGeneral(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCuentaBancoGeneral getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();
				
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
	
	public  TipoCuentaBancoGeneral getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCuentaBancoGeneral.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCuentaBancoGeneralOriginal(new TipoCuentaBancoGeneral());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet);    
				
				//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaBancoGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCuentaBancoGeneral
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCuentaBancoGeneral.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCuentaBancoGeneral(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCuentaBancoGeneral> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		
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
	
	public  List<TipoCuentaBancoGeneral> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
      	    	//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGenerals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCuentaBancoGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
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
	
	public  List<TipoCuentaBancoGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaBancoGeneral();
					//entity.setMapTipoCuentaBancoGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCuentaBancoGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaBancoGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaBancoGeneralDataAccess.getEntityTipoCuentaBancoGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
					////entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGenerals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCuentaBancoGeneral getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
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
	
	public  TipoCuentaBancoGeneral getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGeneral();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaBancoGeneral();
					//entity.setMapTipoCuentaBancoGeneral(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCuentaBancoGeneralValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaBancoGeneral().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaBancoGeneralDataAccess.getEntityTipoCuentaBancoGeneral("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
					////entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGeneral(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCuentaBancoGeneral getEntityTipoCuentaBancoGeneral(String strPrefijo,TipoCuentaBancoGeneral entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCuentaBancoGeneral.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCuentaBancoGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCuentaBancoGeneralDataAccess.setFieldReflectionTipoCuentaBancoGeneral(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCuentaBancoGeneral=TipoCuentaBancoGeneralConstantesFunciones.getTodosTiposColumnasTipoCuentaBancoGeneral();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCuentaBancoGeneral) {
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
							field = TipoCuentaBancoGeneral.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCuentaBancoGeneral.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCuentaBancoGeneralDataAccess.setFieldReflectionTipoCuentaBancoGeneral(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCuentaBancoGeneral(Field field,String strPrefijo,String sColumn,TipoCuentaBancoGeneral entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCuentaBancoGeneralConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaBancoGeneralConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaBancoGeneralConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaBancoGeneralConstantesFunciones.CODIGO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaBancoGeneral>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCuentaBancoGeneral();
					entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet);
					
					//entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
					//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCuentaBancoGenerals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaBancoGeneral>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGeneralDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGeneralDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCuentaBancoGeneral> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
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
	
	public  List<TipoCuentaBancoGeneral> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
      	    	//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCuentaBancoGenerals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGeneral(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCuentaBancoGeneral> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
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
	
	public  List<TipoCuentaBancoGeneral> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGeneral> entities = new  ArrayList<TipoCuentaBancoGeneral>();
		TipoCuentaBancoGeneral entity = new TipoCuentaBancoGeneral();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGeneral();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaBancoGeneral("",entity,resultSet);
      	    	
				//entity.setTipoCuentaBancoGeneralOriginal( new TipoCuentaBancoGeneral());
      	    	//entity.setTipoCuentaBancoGeneralOriginal(super.getEntity("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet,TipoCuentaBancoGeneralDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGeneralOriginal(this.getEntityTipoCuentaBancoGeneral("",entity.getTipoCuentaBancoGeneralOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGenerals(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoCuentaBancoGeneral getEntityTipoCuentaBancoGeneral(String strPrefijo,TipoCuentaBancoGeneral entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoCuentaBancoGeneralConstantesFunciones.IDEMPRESA));
				entity.setid_banco(resultSet.getLong(strPrefijo+TipoCuentaBancoGeneralConstantesFunciones.IDBANCO));
				entity.setid_tipo_cuenta_banco(resultSet.getLong(strPrefijo+TipoCuentaBancoGeneralConstantesFunciones.IDTIPOCUENTABANCO));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCuentaBancoGeneralConstantesFunciones.CODIGO));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCuentaBancoGeneralConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCuentaBancoGeneral(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCuentaBancoGeneral entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCuentaBancoGeneralDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCuentaBancoGeneralDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCuentaBancoGeneralDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCuentaBancoGeneralDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCuentaBancoGeneralConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCuentaBancoGeneralDataAccess.TABLENAME,TipoCuentaBancoGeneralDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCuentaBancoGeneralDataAccess.setTipoCuentaBancoGeneralOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoCuentaBancoGeneral reltipocuentabancogeneral)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipocuentabancogeneral.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Banco getBanco(Connexion connexion,TipoCuentaBancoGeneral reltipocuentabancogeneral)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,reltipocuentabancogeneral.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoCuentaBanco getTipoCuentaBanco(Connexion connexion,TipoCuentaBancoGeneral reltipocuentabancogeneral)throws SQLException,Exception {

		TipoCuentaBanco tipocuentabanco= new TipoCuentaBanco();

		try {
			TipoCuentaBancoDataAccess tipocuentabancoDataAccess=new TipoCuentaBancoDataAccess();

			tipocuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion,reltipocuentabancogeneral.getid_tipo_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabanco;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCuentaBancoGeneral tipocuentabancogeneral) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocuentabancogeneral.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipocuentabancogeneral.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(tipocuentabancogeneral.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco.setValue(tipocuentabancogeneral.getid_tipo_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocuentabancogeneral.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocuentabancogeneral.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocuentabancogeneral.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocuentabancogeneral.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocuentabancogeneral.getId());
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
	
	public void setIsNewIsChangedFalseTipoCuentaBancoGeneral(TipoCuentaBancoGeneral tipocuentabancogeneral)throws Exception  {		
		tipocuentabancogeneral.setIsNew(false);
		tipocuentabancogeneral.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception  {				
		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabancogenerals) {
			tipocuentabancogeneral.setIsNew(false);
			tipocuentabancogeneral.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCuentaBancoGeneral(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
