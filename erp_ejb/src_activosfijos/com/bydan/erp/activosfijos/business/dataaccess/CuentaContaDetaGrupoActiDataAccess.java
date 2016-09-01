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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//CuentaContaDetaGrupoActiConstantesFunciones;


import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentaContaDetaGrupoActiDataAccess extends  CuentaContaDetaGrupoActiDataAccessAdditional{ //CuentaContaDetaGrupoActiDataAccessAdditional,DataAccessHelper<CuentaContaDetaGrupoActi>
	//static Logger logger = Logger.getLogger(CuentaContaDetaGrupoActiDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_conta_deta_grupo_acti";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+"(version_row,id_cuenta_contable,id_detalle_grupo_activo_fijo)values(current_timestamp,?,?)";
	public static String QUERYUPDATE="update "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cuenta_contable=?,id_detalle_grupo_activo_fijo=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentacontadetagrupoacti from "+CuentaContaDetaGrupoActiConstantesFunciones.SPERSISTENCENAME+" cuentacontadetagrupoacti";
	public static String QUERYSELECTNATIVE="select "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".version_row,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id_detalle_grupo_activo_fijo from "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;//+" as "+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".id,"+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+".version_row from "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;//+" as "+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaContaDetaGrupoActiConstantesFunciones.SCHEMA+"."+CuentaContaDetaGrupoActiConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_cuenta_contable=?,id_detalle_grupo_activo_fijo=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTACONTADETAGRUPOACTI_INSERT(?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTACONTADETAGRUPOACTI_UPDATE(?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTACONTADETAGRUPOACTI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTACONTADETAGRUPOACTI_SELECT(?,?)";
	
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
	
	
	protected CuentaContaDetaGrupoActiDataAccessAdditional cuentacontadetagrupoactiDataAccessAdditional=null;
	
	public CuentaContaDetaGrupoActiDataAccessAdditional getCuentaContaDetaGrupoActiDataAccessAdditional() {
		return this.cuentacontadetagrupoactiDataAccessAdditional;
	}
	
	public void setCuentaContaDetaGrupoActiDataAccessAdditional(CuentaContaDetaGrupoActiDataAccessAdditional cuentacontadetagrupoactiDataAccessAdditional) {
		try {
			this.cuentacontadetagrupoactiDataAccessAdditional=cuentacontadetagrupoactiDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaContaDetaGrupoActiDataAccess() {
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
		CuentaContaDetaGrupoActiDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaContaDetaGrupoActiDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaContaDetaGrupoActiDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaContaDetaGrupoActiOriginal(CuentaContaDetaGrupoActi cuentacontadetagrupoacti)throws Exception  {
		cuentacontadetagrupoacti.setCuentaContaDetaGrupoActiOriginal((CuentaContaDetaGrupoActi)cuentacontadetagrupoacti.clone());		
	}
	
	public void setCuentaContaDetaGrupoActisOriginal(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis)throws Exception  {
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis){
			cuentacontadetagrupoacti.setCuentaContaDetaGrupoActiOriginal((CuentaContaDetaGrupoActi)cuentacontadetagrupoacti.clone());
		}
	}
	
	public static void setCuentaContaDetaGrupoActiOriginalStatic(CuentaContaDetaGrupoActi cuentacontadetagrupoacti)throws Exception  {
		cuentacontadetagrupoacti.setCuentaContaDetaGrupoActiOriginal((CuentaContaDetaGrupoActi)cuentacontadetagrupoacti.clone());		
	}
	
	public static void setCuentaContaDetaGrupoActisOriginalStatic(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis)throws Exception  {
		
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis){
			cuentacontadetagrupoacti.setCuentaContaDetaGrupoActiOriginal((CuentaContaDetaGrupoActi)cuentacontadetagrupoacti.clone());
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
	
	public  CuentaContaDetaGrupoActi getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		
		
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
	
	public  CuentaContaDetaGrupoActi getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.CuentaContaDetaGrupoActi.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaContaDetaGrupoActiOriginal(new CuentaContaDetaGrupoActi());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet); 
				
				//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContaDetaGrupoActi(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaContaDetaGrupoActi getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();
				
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
	
	public  CuentaContaDetaGrupoActi getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaDetaGrupoActiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.CuentaContaDetaGrupoActi.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaContaDetaGrupoActiOriginal(new CuentaContaDetaGrupoActi());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet);    
				
				//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContaDetaGrupoActi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaContaDetaGrupoActi
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaDetaGrupoActiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.CuentaContaDetaGrupoActi.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaContaDetaGrupoActi(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaContaDetaGrupoActi> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		
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
	
	public  List<CuentaContaDetaGrupoActi> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaDetaGrupoActiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaDetaGrupoActi();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet);
      	    	
				//entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaDetaGrupoActis(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaDetaGrupoActi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContaDetaGrupoActi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
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
	
	public  List<CuentaContaDetaGrupoActi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaDetaGrupoActi();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContaDetaGrupoActi();
					//entity.setMapCuentaContaDetaGrupoActi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaContaDetaGrupoActiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContaDetaGrupoActi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContaDetaGrupoActiDataAccess.getEntityCuentaContaDetaGrupoActi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
					////entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaDetaGrupoActis(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaDetaGrupoActi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaContaDetaGrupoActi getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
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
	
	public  CuentaContaDetaGrupoActi getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaDetaGrupoActi();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContaDetaGrupoActi();
					//entity.setMapCuentaContaDetaGrupoActi(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaContaDetaGrupoActiValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContaDetaGrupoActi().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContaDetaGrupoActiDataAccess.getEntityCuentaContaDetaGrupoActi("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
					////entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaContaDetaGrupoActi(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaDetaGrupoActi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaContaDetaGrupoActi getEntityCuentaContaDetaGrupoActi(String strPrefijo,CuentaContaDetaGrupoActi entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaContaDetaGrupoActi.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaContaDetaGrupoActi.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaContaDetaGrupoActiDataAccess.setFieldReflectionCuentaContaDetaGrupoActi(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaContaDetaGrupoActi=CuentaContaDetaGrupoActiConstantesFunciones.getTodosTiposColumnasCuentaContaDetaGrupoActi();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaContaDetaGrupoActi) {
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
							field = CuentaContaDetaGrupoActi.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaContaDetaGrupoActi.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaContaDetaGrupoActiDataAccess.setFieldReflectionCuentaContaDetaGrupoActi(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaContaDetaGrupoActi(Field field,String strPrefijo,String sColumn,CuentaContaDetaGrupoActi entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaContaDetaGrupoActiConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContaDetaGrupoActiConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContaDetaGrupoActi>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaDetaGrupoActiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaContaDetaGrupoActi();
					entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet);
					
					//entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
					//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaContaDetaGrupoActis(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaDetaGrupoActi(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContaDetaGrupoActi>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContaDetaGrupoActiDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContaDetaGrupoActiDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaContaDetaGrupoActi> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
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
	
	public  List<CuentaContaDetaGrupoActi> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaDetaGrupoActi();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet);
      	    	
				//entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaContaDetaGrupoActis(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContaDetaGrupoActi(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContaDetaGrupoActi> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
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
	
	public  List<CuentaContaDetaGrupoActi> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContaDetaGrupoActi> entities = new  ArrayList<CuentaContaDetaGrupoActi>();
		CuentaContaDetaGrupoActi entity = new CuentaContaDetaGrupoActi();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContaDetaGrupoActi();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContaDetaGrupoActi("",entity,resultSet);
      	    	
				//entity.setCuentaContaDetaGrupoActiOriginal( new CuentaContaDetaGrupoActi());
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(super.getEntity("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet,CuentaContaDetaGrupoActiDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContaDetaGrupoActiOriginal(this.getEntityCuentaContaDetaGrupoActi("",entity.getCuentaContaDetaGrupoActiOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContaDetaGrupoActis(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaContaDetaGrupoActi getEntityCuentaContaDetaGrupoActi(String strPrefijo,CuentaContaDetaGrupoActi entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaContaDetaGrupoActiConstantesFunciones.IDCUENTACONTABLE));
				entity.setid_detalle_grupo_activo_fijo(resultSet.getLong(strPrefijo+CuentaContaDetaGrupoActiConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaContaDetaGrupoActi(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaContaDetaGrupoActi entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaContaDetaGrupoActiDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaContaDetaGrupoActiDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaContaDetaGrupoActiDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaContaDetaGrupoActiDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaContaDetaGrupoActiConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaContaDetaGrupoActiDataAccess.TABLENAME,CuentaContaDetaGrupoActiDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaContaDetaGrupoActiDataAccess.setCuentaContaDetaGrupoActiOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public CuentaContable getCuentaContable(Connexion connexion,CuentaContaDetaGrupoActi relcuentacontadetagrupoacti)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontadetagrupoacti.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public DetalleGrupoActivoFijo getDetalleGrupoActivoFijo(Connexion connexion,CuentaContaDetaGrupoActi relcuentacontadetagrupoacti)throws SQLException,Exception {

		DetalleGrupoActivoFijo detallegrupoactivofijo= new DetalleGrupoActivoFijo();

		try {
			DetalleGrupoActivoFijoDataAccess detallegrupoactivofijoDataAccess=new DetalleGrupoActivoFijoDataAccess();

			detallegrupoactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detallegrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			detallegrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detallegrupoactivofijo=detallegrupoactivofijoDataAccess.getEntity(connexion,relcuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallegrupoactivofijo;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaContaDetaGrupoActi cuentacontadetagrupoacti) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentacontadetagrupoacti.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentacontadetagrupoacti.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_grupo_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_grupo_activo_fijo.setValue(cuentacontadetagrupoacti.getid_detalle_grupo_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_grupo_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentacontadetagrupoacti.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentacontadetagrupoacti.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentacontadetagrupoacti.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentacontadetagrupoacti.getId());
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
	
	public void setIsNewIsChangedFalseCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi cuentacontadetagrupoacti)throws Exception  {		
		cuentacontadetagrupoacti.setIsNew(false);
		cuentacontadetagrupoacti.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis)throws Exception  {				
		for(CuentaContaDetaGrupoActi cuentacontadetagrupoacti:cuentacontadetagrupoactis) {
			cuentacontadetagrupoacti.setIsNew(false);
			cuentacontadetagrupoacti.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaContaDetaGrupoActi(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
