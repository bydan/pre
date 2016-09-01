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
import com.bydan.erp.puntoventa.util.*;//CuentaBancoPunVenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentaBancoPunVenDataAccess extends  CuentaBancoPunVenDataAccessAdditional{ //CuentaBancoPunVenDataAccessAdditional,DataAccessHelper<CuentaBancoPunVen>
	//static Logger logger = Logger.getLogger(CuentaBancoPunVenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_banco_pun_ven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_banco,id_cliente,id_cuenta_contable,codigo,nombre)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,id_cliente=?,id_cuenta_contable=?,codigo=?,nombre=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentabancopunven from "+CuentaBancoPunVenConstantesFunciones.SPERSISTENCENAME+" cuentabancopunven";
	public static String QUERYSELECTNATIVE="select "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_empresa,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_banco,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_cliente,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".codigo,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".nombre from "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME;//+" as "+CuentaBancoPunVenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".id,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+".codigo from "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME;//+" as "+CuentaBancoPunVenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaBancoPunVenConstantesFunciones.SCHEMA+"."+CuentaBancoPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,id_cliente=?,id_cuenta_contable=?,codigo=?,nombre=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTABANCOPUNVEN_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTABANCOPUNVEN_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTABANCOPUNVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTABANCOPUNVEN_SELECT(?,?)";
	
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
	
	
	protected CuentaBancoPunVenDataAccessAdditional cuentabancopunvenDataAccessAdditional=null;
	
	public CuentaBancoPunVenDataAccessAdditional getCuentaBancoPunVenDataAccessAdditional() {
		return this.cuentabancopunvenDataAccessAdditional;
	}
	
	public void setCuentaBancoPunVenDataAccessAdditional(CuentaBancoPunVenDataAccessAdditional cuentabancopunvenDataAccessAdditional) {
		try {
			this.cuentabancopunvenDataAccessAdditional=cuentabancopunvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaBancoPunVenDataAccess() {
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
		CuentaBancoPunVenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaBancoPunVenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaBancoPunVenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaBancoPunVenOriginal(CuentaBancoPunVen cuentabancopunven)throws Exception  {
		cuentabancopunven.setCuentaBancoPunVenOriginal((CuentaBancoPunVen)cuentabancopunven.clone());		
	}
	
	public void setCuentaBancoPunVensOriginal(List<CuentaBancoPunVen> cuentabancopunvens)throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens){
			cuentabancopunven.setCuentaBancoPunVenOriginal((CuentaBancoPunVen)cuentabancopunven.clone());
		}
	}
	
	public static void setCuentaBancoPunVenOriginalStatic(CuentaBancoPunVen cuentabancopunven)throws Exception  {
		cuentabancopunven.setCuentaBancoPunVenOriginal((CuentaBancoPunVen)cuentabancopunven.clone());		
	}
	
	public static void setCuentaBancoPunVensOriginalStatic(List<CuentaBancoPunVen> cuentabancopunvens)throws Exception  {
		
		for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens){
			cuentabancopunven.setCuentaBancoPunVenOriginal((CuentaBancoPunVen)cuentabancopunven.clone());
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
	
	public  CuentaBancoPunVen getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		
		
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
	
	public  CuentaBancoPunVen getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.CuentaBancoPunVen.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaBancoPunVenOriginal(new CuentaBancoPunVen());
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaBancoPunVen("",entity,resultSet); 
				
				//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaBancoPunVen(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaBancoPunVen getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();
				
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
	
	public  CuentaBancoPunVen getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CuentaBancoPunVen.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaBancoPunVenOriginal(new CuentaBancoPunVen());
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaBancoPunVen("",entity,resultSet);    
				
				//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaBancoPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaBancoPunVen
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaBancoPunVen entity = new CuentaBancoPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.CuentaBancoPunVen.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaBancoPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaBancoPunVen> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		
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
	
	public  List<CuentaBancoPunVen> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBancoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBancoPunVen("",entity,resultSet);
      	    	
				//entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
      	    	//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancoPunVens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBancoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaBancoPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
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
	
	public  List<CuentaBancoPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBancoPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaBancoPunVen();
					//entity.setMapCuentaBancoPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaBancoPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaBancoPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=CuentaBancoPunVenDataAccess.getEntityCuentaBancoPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
					////entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancoPunVens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBancoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaBancoPunVen getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
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
	
	public  CuentaBancoPunVen getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBancoPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaBancoPunVen();
					//entity.setMapCuentaBancoPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaBancoPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaBancoPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=CuentaBancoPunVenDataAccess.getEntityCuentaBancoPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
					////entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaBancoPunVen(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBancoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaBancoPunVen getEntityCuentaBancoPunVen(String strPrefijo,CuentaBancoPunVen entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaBancoPunVen.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaBancoPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaBancoPunVenDataAccess.setFieldReflectionCuentaBancoPunVen(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaBancoPunVen=CuentaBancoPunVenConstantesFunciones.getTodosTiposColumnasCuentaBancoPunVen();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaBancoPunVen) {
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
							field = CuentaBancoPunVen.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaBancoPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaBancoPunVenDataAccess.setFieldReflectionCuentaBancoPunVen(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaBancoPunVen(Field field,String strPrefijo,String sColumn,CuentaBancoPunVen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaBancoPunVenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoPunVenConstantesFunciones.NOMBRE:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaBancoPunVen>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaBancoPunVen();
					entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaBancoPunVen("",entity,resultSet);
					
					//entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
					//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaBancoPunVens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBancoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaBancoPunVen>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaBancoPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
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
	
	public  List<CuentaBancoPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBancoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBancoPunVen("",entity,resultSet);
      	    	
				//entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
      	    	//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaBancoPunVens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBancoPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaBancoPunVen> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
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
	
	public  List<CuentaBancoPunVen> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBancoPunVen> entities = new  ArrayList<CuentaBancoPunVen>();
		CuentaBancoPunVen entity = new CuentaBancoPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBancoPunVen();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBancoPunVen("",entity,resultSet);
      	    	
				//entity.setCuentaBancoPunVenOriginal( new CuentaBancoPunVen());
      	    	//entity.setCuentaBancoPunVenOriginal(super.getEntity("",entity.getCuentaBancoPunVenOriginal(),resultSet,CuentaBancoPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoPunVenOriginal(this.getEntityCuentaBancoPunVen("",entity.getCuentaBancoPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancoPunVens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaBancoPunVen getEntityCuentaBancoPunVen(String strPrefijo,CuentaBancoPunVen entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentaBancoPunVenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CuentaBancoPunVenConstantesFunciones.IDSUCURSAL));
				entity.setid_banco(resultSet.getLong(strPrefijo+CuentaBancoPunVenConstantesFunciones.IDBANCO));
				entity.setid_cliente(resultSet.getLong(strPrefijo+CuentaBancoPunVenConstantesFunciones.IDCLIENTE));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE));
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaBancoPunVenConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CuentaBancoPunVenConstantesFunciones.NOMBRE));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaBancoPunVenConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaBancoPunVen(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaBancoPunVen entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaBancoPunVenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaBancoPunVenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaBancoPunVenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaBancoPunVenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaBancoPunVenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaBancoPunVenDataAccess.TABLENAME,CuentaBancoPunVenDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaBancoPunVenDataAccess.setCuentaBancoPunVenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentaBancoPunVen relcuentabancopunven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentabancopunven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CuentaBancoPunVen relcuentabancopunven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcuentabancopunven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Banco getBanco(Connexion connexion,CuentaBancoPunVen relcuentabancopunven)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relcuentabancopunven.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public Cliente getCliente(Connexion connexion,CuentaBancoPunVen relcuentabancopunven)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relcuentabancopunven.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public CuentaContable getCuentaContable(Connexion connexion,CuentaBancoPunVen relcuentabancopunven)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentabancopunven.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas(Connexion connexion,CuentaBancoPunVen cuentabancopunven)throws SQLException,Exception {

		List<FormaPagoPuntoVenta> formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaBancoPunVenConstantesFunciones.SCHEMA+".cuenta_banco_pun_ven ON "+FormaPagoPuntoVentaConstantesFunciones.SCHEMA+".forma_pago_punto_venta.id_cuenta_banco_pun_ven="+CuentaBancoPunVenConstantesFunciones.SCHEMA+".cuenta_banco_pun_ven.id WHERE "+CuentaBancoPunVenConstantesFunciones.SCHEMA+".cuenta_banco_pun_ven.id="+String.valueOf(cuentabancopunven.getId());
			} else {
				sQuery=" INNER JOIN formapagopuntoventa.CuentaBancoPunVen WHERE formapagopuntoventa.CuentaBancoPunVen.id="+String.valueOf(cuentabancopunven.getId());

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


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaBancoPunVen cuentabancopunven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentabancopunven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentabancopunven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cuentabancopunven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(cuentabancopunven.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(cuentabancopunven.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentabancopunven.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(cuentabancopunven.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cuentabancopunven.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentabancopunven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentabancopunven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentabancopunven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentabancopunven.getId());
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
	
	public void setIsNewIsChangedFalseCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven)throws Exception  {		
		cuentabancopunven.setIsNew(false);
		cuentabancopunven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaBancoPunVens(List<CuentaBancoPunVen> cuentabancopunvens)throws Exception  {				
		for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
			cuentabancopunven.setIsNew(false);
			cuentabancopunven.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaBancoPunVen(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
