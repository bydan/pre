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
import com.bydan.erp.tesoreria.util.*;//TipoCuentaBancoGlobalConstantesFunciones;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;




@SuppressWarnings("unused")
final public class TipoCuentaBancoGlobalDataAccess extends  DataAccessHelperSinIdGenerated<TipoCuentaBancoGlobal>{ //TipoCuentaBancoGlobalDataAccessAdditional,DataAccessHelper<TipoCuentaBancoGlobal>
	//static Logger logger = Logger.getLogger(TipoCuentaBancoGlobalDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_cuenta_banco_global";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+"(id,version_row,codigo,nombre)values(?,current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipocuentabancoglobal from "+TipoCuentaBancoGlobalConstantesFunciones.SPERSISTENCENAME+" tipocuentabancoglobal";
	public static String QUERYSELECTNATIVE="select "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".codigo,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".nombre from "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".id,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".version_row,"+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+".codigo from "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;//+" as "+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+"."+TipoCuentaBancoGlobalConstantesFunciones.TABLENAME+" set id=?,version_row=current_timestamp,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOCUENTABANCOGLOBAL_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOCUENTABANCOGLOBAL_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOCUENTABANCOGLOBAL_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOCUENTABANCOGLOBAL_SELECT(?,?)";
	
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
	
	
	public TipoCuentaBancoGlobalDataAccess() {
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
		TipoCuentaBancoGlobalDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoCuentaBancoGlobalDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoCuentaBancoGlobalDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoCuentaBancoGlobalOriginal(TipoCuentaBancoGlobal tipocuentabancoglobal)throws Exception  {
		tipocuentabancoglobal.setTipoCuentaBancoGlobalOriginal((TipoCuentaBancoGlobal)tipocuentabancoglobal.clone());		
	}
	
	public void setTipoCuentaBancoGlobalsOriginal(List<TipoCuentaBancoGlobal> tipocuentabancoglobals)throws Exception  {
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals){
			tipocuentabancoglobal.setTipoCuentaBancoGlobalOriginal((TipoCuentaBancoGlobal)tipocuentabancoglobal.clone());
		}
	}
	
	public static void setTipoCuentaBancoGlobalOriginalStatic(TipoCuentaBancoGlobal tipocuentabancoglobal)throws Exception  {
		tipocuentabancoglobal.setTipoCuentaBancoGlobalOriginal((TipoCuentaBancoGlobal)tipocuentabancoglobal.clone());		
	}
	
	public static void setTipoCuentaBancoGlobalsOriginalStatic(List<TipoCuentaBancoGlobal> tipocuentabancoglobals)throws Exception  {
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals){
			tipocuentabancoglobal.setTipoCuentaBancoGlobalOriginal((TipoCuentaBancoGlobal)tipocuentabancoglobal.clone());
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
	
	public  TipoCuentaBancoGlobal getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		
		
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
	
	public  TipoCuentaBancoGlobal getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.TipoCuentaBancoGlobal.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoCuentaBancoGlobalOriginal(new TipoCuentaBancoGlobal());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaBancoGlobal("",entity,resultSet); 
				
				//entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaBancoGlobal(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoCuentaBancoGlobal getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();
				
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
	
	public  TipoCuentaBancoGlobal getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCuentaBancoGlobal.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoCuentaBancoGlobalOriginal(new TipoCuentaBancoGlobal());
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoCuentaBancoGlobal("",entity,resultSet);    
				
				//entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoCuentaBancoGlobal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoCuentaBancoGlobal
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.TipoCuentaBancoGlobal.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoCuentaBancoGlobal(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoCuentaBancoGlobal> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		
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
	
	public  List<TipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGlobal();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaBancoGlobal("",entity,resultSet);
      	    	
				//entity.setTipoCuentaBancoGlobalOriginal( new TipoCuentaBancoGlobal());
      	    	//entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGlobals(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoCuentaBancoGlobal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
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
	
	public  List<TipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGlobal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaBancoGlobal();
					//entity.setMapTipoCuentaBancoGlobal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoCuentaBancoGlobalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaBancoGlobal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaBancoGlobalDataAccess.getEntityTipoCuentaBancoGlobal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaBancoGlobalOriginal( new TipoCuentaBancoGlobal());
					////entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGlobals(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoCuentaBancoGlobal getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
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
	
	public  TipoCuentaBancoGlobal getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGlobal();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoCuentaBancoGlobal();
					//entity.setMapTipoCuentaBancoGlobal(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoCuentaBancoGlobalValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoCuentaBancoGlobal().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=TipoCuentaBancoGlobalDataAccess.getEntityTipoCuentaBancoGlobal("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoCuentaBancoGlobalOriginal( new TipoCuentaBancoGlobal());
					////entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoCuentaBancoGlobal(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoCuentaBancoGlobal getEntityTipoCuentaBancoGlobal(String strPrefijo,TipoCuentaBancoGlobal entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoCuentaBancoGlobal.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoCuentaBancoGlobal.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoCuentaBancoGlobalDataAccess.setFieldReflectionTipoCuentaBancoGlobal(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoCuentaBancoGlobal=TipoCuentaBancoGlobalConstantesFunciones.getTodosTiposColumnasTipoCuentaBancoGlobal();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoCuentaBancoGlobal) {
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
							field = TipoCuentaBancoGlobal.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoCuentaBancoGlobal.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoCuentaBancoGlobalDataAccess.setFieldReflectionTipoCuentaBancoGlobal(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoCuentaBancoGlobal(Field field,String strPrefijo,String sColumn,TipoCuentaBancoGlobal entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoCuentaBancoGlobalConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoCuentaBancoGlobalConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCuentaBancoGlobalConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoCuentaBancoGlobalConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaBancoGlobal>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoCuentaBancoGlobal();
					entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoCuentaBancoGlobal("",entity,resultSet);
					
					//entity.setTipoCuentaBancoGlobalOriginal( new TipoCuentaBancoGlobal());
					//entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoCuentaBancoGlobals(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoCuentaBancoGlobal>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoCuentaBancoGlobalDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,TipoCuentaBancoGlobalDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoCuentaBancoGlobal> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
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
	
	public  List<TipoCuentaBancoGlobal> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoCuentaBancoGlobal> entities = new  ArrayList<TipoCuentaBancoGlobal>();
		TipoCuentaBancoGlobal entity = new TipoCuentaBancoGlobal();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelperSinIdGenerated.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoCuentaBancoGlobal();
      	    	entity=super.getEntity("",entity,resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoCuentaBancoGlobal("",entity,resultSet);
      	    	
				//entity.setTipoCuentaBancoGlobalOriginal( new TipoCuentaBancoGlobal());
      	    	//entity.setTipoCuentaBancoGlobalOriginal(super.getEntity("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet,TipoCuentaBancoGlobalDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoCuentaBancoGlobalOriginal(this.getEntityTipoCuentaBancoGlobal("",entity.getTipoCuentaBancoGlobalOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoCuentaBancoGlobals(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoCuentaBancoGlobal(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	
	
	public TipoCuentaBancoGlobal getEntityTipoCuentaBancoGlobal(String strPrefijo,TipoCuentaBancoGlobal entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCuentaBancoGlobalConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoCuentaBancoGlobalConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoCuentaBancoGlobalConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoCuentaBancoGlobal(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoCuentaBancoGlobal entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoCuentaBancoGlobalDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoCuentaBancoGlobalDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoCuentaBancoGlobalDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoCuentaBancoGlobalDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoCuentaBancoGlobalConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelperSinIdGenerated.save(entity, connexion,parametersMaintenance,sQuerySave,TipoCuentaBancoGlobalDataAccess.TABLENAME,TipoCuentaBancoGlobalDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoCuentaBancoGlobalDataAccess.setTipoCuentaBancoGlobalOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
	
		
		public List<BancoTipoCuentaBancoGlobal> getBancoTipoCuentaBancoGlobals(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals= new ArrayList<BancoTipoCuentaBancoGlobal>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+BancoTipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".banco_tipo_cuenta_banco_global.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN bancotipocuentabancoglobal.TipoCuentaBancoGlobal WHERE bancotipocuentabancoglobal.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BancoTipoCuentaBancoGlobalDataAccess bancotipocuentabancoglobalDataAccess=new BancoTipoCuentaBancoGlobalDataAccess();

			bancotipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			bancotipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bancotipocuentabancoglobals;

	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<DatoGeneralEmpleado> datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+DatoGeneralEmpleadoConstantesFunciones.SCHEMA+".dato_general_empleado.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN datogeneralempleado.TipoCuentaBancoGlobal WHERE datogeneralempleado.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DatoGeneralEmpleadoDataAccess datogeneralempleadoDataAccess=new DatoGeneralEmpleadoDataAccess();

			datogeneralempleadoDataAccess.setConnexionType(this.connexionType);
			datogeneralempleadoDataAccess.setParameterDbType(this.parameterDbType);
			datogeneralempleados=datogeneralempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return datogeneralempleados;

	}

	public List<PoliticasCliente> getPoliticasClientes(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<PoliticasCliente> politicasclientes= new ArrayList<PoliticasCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+PoliticasClienteConstantesFunciones.SCHEMA+".politicas_cliente.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN politicascliente.TipoCuentaBancoGlobal WHERE politicascliente.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticasClienteDataAccess politicasclienteDataAccess=new PoliticasClienteDataAccess();

			politicasclienteDataAccess.setConnexionType(this.connexionType);
			politicasclienteDataAccess.setParameterDbType(this.parameterDbType);
			politicasclientes=politicasclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicasclientes;

	}

	public List<Empleado> getEmpleados(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<Empleado> empleados= new ArrayList<Empleado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+EmpleadoConstantesFunciones.SCHEMA+".empleado.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN empleado.TipoCuentaBancoGlobal WHERE empleado.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);
			empleados=empleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleados;

	}

	public List<CuentaBanco> getCuentaBancos(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<CuentaBanco> cuentabancos= new ArrayList<CuentaBanco>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN cuentabanco.TipoCuentaBancoGlobal WHERE cuentabanco.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

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

	public List<ParametroTesoreriaDefecto> getParametroTesoreriaDefectos(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws SQLException,Exception {

		List<ParametroTesoreriaDefecto> parametrotesoreriadefectos= new ArrayList<ParametroTesoreriaDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global ON "+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+".parametro_tesoreria_defecto.id_tipo_cuenta_banco_global="+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id WHERE "+TipoCuentaBancoGlobalConstantesFunciones.SCHEMA+".tipo_cuenta_banco_global.id="+String.valueOf(tipocuentabancoglobal.getId());
			} else {
				sQuery=" INNER JOIN parametrotesoreriadefecto.TipoCuentaBancoGlobal WHERE parametrotesoreriadefecto.TipoCuentaBancoGlobal.id="+String.valueOf(tipocuentabancoglobal.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroTesoreriaDefectoDataAccess parametrotesoreriadefectoDataAccess=new ParametroTesoreriaDefectoDataAccess();

			parametrotesoreriadefectoDataAccess.setConnexionType(this.connexionType);
			parametrotesoreriadefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrotesoreriadefectos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoCuentaBancoGlobal tipocuentabancoglobal) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipocuentabancoglobal.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid=new ParameterValue<Long>();
					parameterMaintenanceValueid.setValue(tipocuentabancoglobal.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipocuentabancoglobal.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipocuentabancoglobal.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipocuentabancoglobal.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipocuentabancoglobal.getIdOriginal());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipocuentabancoglobal.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipocuentabancoglobal.getId());
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
	
	public void setIsNewIsChangedFalseTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal)throws Exception  {		
		tipocuentabancoglobal.setIsNew(false);
		tipocuentabancoglobal.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> tipocuentabancoglobals)throws Exception  {				
		for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals) {
			tipocuentabancoglobal.setIsNew(false);
			tipocuentabancoglobal.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoCuentaBancoGlobal(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
