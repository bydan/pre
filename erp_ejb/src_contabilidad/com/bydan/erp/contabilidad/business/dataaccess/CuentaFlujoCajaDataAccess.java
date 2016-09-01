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
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.util.*;//CuentaFlujoCajaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CuentaFlujoCajaDataAccess extends  CuentaFlujoCajaDataAccessAdditional{ //CuentaFlujoCajaDataAccessAdditional,DataAccessHelper<CuentaFlujoCaja>
	//static Logger logger = Logger.getLogger(CuentaFlujoCajaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_flujo_caja";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+"(version_row,id_empresa,nombre,id_mes,id_dia,id_cuenta_contable,formula,es_flujo_caja,con_agrupar)values(current_timestamp,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,id_mes=?,id_dia=?,id_cuenta_contable=?,formula=?,es_flujo_caja=?,con_agrupar=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentaflujocaja from "+CuentaFlujoCajaConstantesFunciones.SPERSISTENCENAME+" cuentaflujocaja";
	public static String QUERYSELECTNATIVE="select "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_empresa,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".nombre,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_mes,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_dia,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".formula,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".es_flujo_caja,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".con_agrupar from "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+CuentaFlujoCajaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".id,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".version_row,"+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+".nombre from "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME;//+" as "+CuentaFlujoCajaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaFlujoCajaConstantesFunciones.SCHEMA+"."+CuentaFlujoCajaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,nombre=?,id_mes=?,id_dia=?,id_cuenta_contable=?,formula=?,es_flujo_caja=?,con_agrupar=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTAFLUJOCAJA_INSERT(?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTAFLUJOCAJA_UPDATE(?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTAFLUJOCAJA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTAFLUJOCAJA_SELECT(?,?)";
	
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
	
	
	protected CuentaFlujoCajaDataAccessAdditional cuentaflujocajaDataAccessAdditional=null;
	
	public CuentaFlujoCajaDataAccessAdditional getCuentaFlujoCajaDataAccessAdditional() {
		return this.cuentaflujocajaDataAccessAdditional;
	}
	
	public void setCuentaFlujoCajaDataAccessAdditional(CuentaFlujoCajaDataAccessAdditional cuentaflujocajaDataAccessAdditional) {
		try {
			this.cuentaflujocajaDataAccessAdditional=cuentaflujocajaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaFlujoCajaDataAccess() {
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
		CuentaFlujoCajaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaFlujoCajaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaFlujoCajaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaFlujoCajaOriginal(CuentaFlujoCaja cuentaflujocaja)throws Exception  {
		cuentaflujocaja.setCuentaFlujoCajaOriginal((CuentaFlujoCaja)cuentaflujocaja.clone());		
	}
	
	public void setCuentaFlujoCajasOriginal(List<CuentaFlujoCaja> cuentaflujocajas)throws Exception  {
		
		for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas){
			cuentaflujocaja.setCuentaFlujoCajaOriginal((CuentaFlujoCaja)cuentaflujocaja.clone());
		}
	}
	
	public static void setCuentaFlujoCajaOriginalStatic(CuentaFlujoCaja cuentaflujocaja)throws Exception  {
		cuentaflujocaja.setCuentaFlujoCajaOriginal((CuentaFlujoCaja)cuentaflujocaja.clone());		
	}
	
	public static void setCuentaFlujoCajasOriginalStatic(List<CuentaFlujoCaja> cuentaflujocajas)throws Exception  {
		
		for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas){
			cuentaflujocaja.setCuentaFlujoCajaOriginal((CuentaFlujoCaja)cuentaflujocaja.clone());
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
	
	public  CuentaFlujoCaja getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		
		
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
	
	public  CuentaFlujoCaja getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.CuentaFlujoCaja.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaFlujoCajaOriginal(new CuentaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaFlujoCaja("",entity,resultSet); 
				
				//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaFlujoCaja(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaFlujoCaja getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();
				
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
	
	public  CuentaFlujoCaja getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CuentaFlujoCaja.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaFlujoCajaOriginal(new CuentaFlujoCaja());
      	    	entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaFlujoCaja("",entity,resultSet);    
				
				//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaFlujoCaja
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaFlujoCaja entity = new CuentaFlujoCaja();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CuentaFlujoCaja.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaFlujoCaja(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaFlujoCaja> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		
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
	
	public  List<CuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
      	    	//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaFlujoCajas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
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
	
	public  List<CuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaFlujoCaja();
					//entity.setMapCuentaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=CuentaFlujoCajaDataAccess.getEntityCuentaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
					////entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaFlujoCajas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaFlujoCaja getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
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
	
	public  CuentaFlujoCaja getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaFlujoCaja();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaFlujoCaja();
					//entity.setMapCuentaFlujoCaja(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaFlujoCajaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaFlujoCaja().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=CuentaFlujoCajaDataAccess.getEntityCuentaFlujoCaja("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
					////entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaFlujoCaja(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaFlujoCaja getEntityCuentaFlujoCaja(String strPrefijo,CuentaFlujoCaja entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaFlujoCaja.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaFlujoCajaDataAccess.setFieldReflectionCuentaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaFlujoCaja=CuentaFlujoCajaConstantesFunciones.getTodosTiposColumnasCuentaFlujoCaja();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaFlujoCaja) {
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
							field = CuentaFlujoCaja.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaFlujoCaja.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaFlujoCajaDataAccess.setFieldReflectionCuentaFlujoCaja(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaFlujoCaja(Field field,String strPrefijo,String sColumn,CuentaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaFlujoCajaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.IDDIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.FORMULA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaFlujoCajaConstantesFunciones.CONAGRUPAR:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaFlujoCaja>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaFlujoCaja();
					entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaFlujoCaja("",entity,resultSet);
					
					//entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
					//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaFlujoCajas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaFlujoCaja>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaFlujoCajaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaFlujoCajaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaFlujoCaja> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
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
	
	public  List<CuentaFlujoCaja> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
      	    	//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaFlujoCajas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaFlujoCaja(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaFlujoCaja> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
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
	
	public  List<CuentaFlujoCaja> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaFlujoCaja> entities = new  ArrayList<CuentaFlujoCaja>();
		CuentaFlujoCaja entity = new CuentaFlujoCaja();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaFlujoCaja();
      	    	entity=super.getEntity("",entity,resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaFlujoCaja("",entity,resultSet);
      	    	
				//entity.setCuentaFlujoCajaOriginal( new CuentaFlujoCaja());
      	    	//entity.setCuentaFlujoCajaOriginal(super.getEntity("",entity.getCuentaFlujoCajaOriginal(),resultSet,CuentaFlujoCajaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaFlujoCajaOriginal(this.getEntityCuentaFlujoCaja("",entity.getCuentaFlujoCajaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaFlujoCajas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaFlujoCaja getEntityCuentaFlujoCaja(String strPrefijo,CuentaFlujoCaja entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentaFlujoCajaConstantesFunciones.IDEMPRESA));
				entity.setnombre(resultSet.getString(strPrefijo+CuentaFlujoCajaConstantesFunciones.NOMBRE));
				entity.setid_mes(resultSet.getLong(strPrefijo+CuentaFlujoCajaConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
				entity.setid_dia(resultSet.getLong(strPrefijo+CuentaFlujoCajaConstantesFunciones.IDDIA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaFlujoCajaConstantesFunciones.IDCUENTACONTABLE));
				entity.setformula(resultSet.getString(strPrefijo+CuentaFlujoCajaConstantesFunciones.FORMULA));
				entity.setes_flujo_caja(resultSet.getBoolean(strPrefijo+CuentaFlujoCajaConstantesFunciones.ESFLUJOCAJA));
				entity.setcon_agrupar(resultSet.getBoolean(strPrefijo+CuentaFlujoCajaConstantesFunciones.CONAGRUPAR));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CuentaFlujoCajaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaFlujoCaja(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaFlujoCaja entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaFlujoCajaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaFlujoCajaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaFlujoCajaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaFlujoCajaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaFlujoCajaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaFlujoCajaDataAccess.TABLENAME,CuentaFlujoCajaDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaFlujoCajaDataAccess.setCuentaFlujoCajaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentaFlujoCaja relcuentaflujocaja)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentaflujocaja.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Mes getMes(Connexion connexion,CuentaFlujoCaja relcuentaflujocaja)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,relcuentaflujocaja.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}

	public Dia getDia(Connexion connexion,CuentaFlujoCaja relcuentaflujocaja)throws SQLException,Exception {

		Dia dia= new Dia();

		try {
			DiaDataAccess diaDataAccess=new DiaDataAccess();

			diaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			diaDataAccess.setConnexionType(this.connexionType);
			diaDataAccess.setParameterDbType(this.parameterDbType);

			dia=diaDataAccess.getEntity(connexion,relcuentaflujocaja.getid_dia());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return dia;

	}

	public CuentaContable getCuentaContable(Connexion connexion,CuentaFlujoCaja relcuentaflujocaja)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentaflujocaja.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<DetalleCuentaFlujoCaja> getDetalleCuentaFlujoCajas(Connexion connexion,CuentaFlujoCaja cuentaflujocaja)throws SQLException,Exception {

		List<DetalleCuentaFlujoCaja> detallecuentaflujocajas= new ArrayList<DetalleCuentaFlujoCaja>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaFlujoCajaConstantesFunciones.SCHEMA+".cuenta_flujo_caja ON "+DetalleCuentaFlujoCajaConstantesFunciones.SCHEMA+".detalle_cuenta_flujo_caja.id_cuenta_flujo_caja="+CuentaFlujoCajaConstantesFunciones.SCHEMA+".cuenta_flujo_caja.id WHERE "+CuentaFlujoCajaConstantesFunciones.SCHEMA+".cuenta_flujo_caja.id="+String.valueOf(cuentaflujocaja.getId());
			} else {
				sQuery=" INNER JOIN detallecuentaflujocaja.CuentaFlujoCaja WHERE detallecuentaflujocaja.CuentaFlujoCaja.id="+String.valueOf(cuentaflujocaja.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleCuentaFlujoCajaDataAccess detallecuentaflujocajaDataAccess=new DetalleCuentaFlujoCajaDataAccess();

			detallecuentaflujocajaDataAccess.setConnexionType(this.connexionType);
			detallecuentaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			detallecuentaflujocajas=detallecuentaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallecuentaflujocajas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaFlujoCaja cuentaflujocaja) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentaflujocaja.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentaflujocaja.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cuentaflujocaja.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(cuentaflujocaja.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_dia=new ParameterValue<Long>();
					parameterMaintenanceValueid_dia.setValue(cuentaflujocaja.getid_dia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_dia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentaflujocaja.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueformula=new ParameterValue<String>();
					parameterMaintenanceValueformula.setValue(cuentaflujocaja.getformula());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueformula);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_flujo_caja=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_flujo_caja.setValue(cuentaflujocaja.getes_flujo_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_flujo_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_agrupar=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_agrupar.setValue(cuentaflujocaja.getcon_agrupar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_agrupar);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentaflujocaja.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentaflujocaja.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentaflujocaja.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentaflujocaja.getId());
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
	
	public void setIsNewIsChangedFalseCuentaFlujoCaja(CuentaFlujoCaja cuentaflujocaja)throws Exception  {		
		cuentaflujocaja.setIsNew(false);
		cuentaflujocaja.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaFlujoCajas(List<CuentaFlujoCaja> cuentaflujocajas)throws Exception  {				
		for(CuentaFlujoCaja cuentaflujocaja:cuentaflujocajas) {
			cuentaflujocaja.setIsNew(false);
			cuentaflujocaja.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaFlujoCaja(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
