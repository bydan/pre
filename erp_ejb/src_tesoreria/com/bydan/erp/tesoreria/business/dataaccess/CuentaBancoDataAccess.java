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
import com.bydan.erp.tesoreria.util.*;//CuentaBancoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class CuentaBancoDataAccess extends  CuentaBancoDataAccessAdditional{ //CuentaBancoDataAccessAdditional,DataAccessHelper<CuentaBanco>
	//static Logger logger = Logger.getLogger(CuentaBancoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_banco";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_banco,id_tipo_cuenta_banco_global,codigo,numero_cuenta,numero_cheque,numero_cheque_auxiliar,saldo,procedencia,destino,id_cuenta_contable,es_banco,id_estado_cuenta_banco,id_formato_ingreso,id_formato_egreso,id_formato_diario,id_formato_cheque,id_formato_retencion,id_formato_retencion_iva)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,id_tipo_cuenta_banco_global=?,codigo=?,numero_cuenta=?,numero_cheque=?,numero_cheque_auxiliar=?,saldo=?,procedencia=?,destino=?,id_cuenta_contable=?,es_banco=?,id_estado_cuenta_banco=?,id_formato_ingreso=?,id_formato_egreso=?,id_formato_diario=?,id_formato_cheque=?,id_formato_retencion=?,id_formato_retencion_iva=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentabanco from "+CuentaBancoConstantesFunciones.SPERSISTENCENAME+" cuentabanco";
	public static String QUERYSELECTNATIVE="select "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_empresa,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_sucursal,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".codigo,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cuenta,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cheque,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".numero_cheque_auxiliar,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".saldo,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".procedencia,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".destino,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".es_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_estado_cuenta_banco,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_ingreso,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_egreso,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_diario,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_cheque,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_retencion,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id_formato_retencion_iva from "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME;//+" as "+CuentaBancoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".id,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".version_row,"+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+".codigo from "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME;//+" as "+CuentaBancoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaBancoConstantesFunciones.SCHEMA+"."+CuentaBancoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_banco=?,id_tipo_cuenta_banco_global=?,codigo=?,numero_cuenta=?,numero_cheque=?,numero_cheque_auxiliar=?,saldo=?,procedencia=?,destino=?,id_cuenta_contable=?,es_banco=?,id_estado_cuenta_banco=?,id_formato_ingreso=?,id_formato_egreso=?,id_formato_diario=?,id_formato_cheque=?,id_formato_retencion=?,id_formato_retencion_iva=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTABANCO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTABANCO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTABANCO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTABANCO_SELECT(?,?)";
	
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
	
	
	protected CuentaBancoDataAccessAdditional cuentabancoDataAccessAdditional=null;
	
	public CuentaBancoDataAccessAdditional getCuentaBancoDataAccessAdditional() {
		return this.cuentabancoDataAccessAdditional;
	}
	
	public void setCuentaBancoDataAccessAdditional(CuentaBancoDataAccessAdditional cuentabancoDataAccessAdditional) {
		try {
			this.cuentabancoDataAccessAdditional=cuentabancoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaBancoDataAccess() {
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
		CuentaBancoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaBancoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaBancoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaBancoOriginal(CuentaBanco cuentabanco)throws Exception  {
		cuentabanco.setCuentaBancoOriginal((CuentaBanco)cuentabanco.clone());		
	}
	
	public void setCuentaBancosOriginal(List<CuentaBanco> cuentabancos)throws Exception  {
		
		for(CuentaBanco cuentabanco:cuentabancos){
			cuentabanco.setCuentaBancoOriginal((CuentaBanco)cuentabanco.clone());
		}
	}
	
	public static void setCuentaBancoOriginalStatic(CuentaBanco cuentabanco)throws Exception  {
		cuentabanco.setCuentaBancoOriginal((CuentaBanco)cuentabanco.clone());		
	}
	
	public static void setCuentaBancosOriginalStatic(List<CuentaBanco> cuentabancos)throws Exception  {
		
		for(CuentaBanco cuentabanco:cuentabancos){
			cuentabanco.setCuentaBancoOriginal((CuentaBanco)cuentabanco.clone());
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
	
	public  CuentaBanco getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();		
		
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
	
	public  CuentaBanco getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Tesoreria.CuentaBanco.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaBancoOriginal(new CuentaBanco());
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaBanco("",entity,resultSet); 
				
				//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaBanco(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaBanco getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();
				
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
	
	public  CuentaBanco getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.CuentaBanco.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaBancoOriginal(new CuentaBanco());
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaBanco("",entity,resultSet);    
				
				//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaBanco
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaBanco entity = new CuentaBanco();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Tesoreria.CuentaBanco.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaBanco(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaBanco> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		
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
	
	public  List<CuentaBanco> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBanco();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBanco("",entity,resultSet);
      	    	
				//entity.setCuentaBancoOriginal( new CuentaBanco());
      	    	//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
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
	
	public  List<CuentaBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaBanco();
					//entity.setMapCuentaBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=CuentaBancoDataAccess.getEntityCuentaBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaBancoOriginal( new CuentaBanco());
					////entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaBanco getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();		  
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
	
	public  CuentaBanco getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBanco();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaBanco();
					//entity.setMapCuentaBanco(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaBancoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaBanco().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=CuentaBancoDataAccess.getEntityCuentaBanco("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaBancoOriginal( new CuentaBanco());
					////entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaBanco(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaBanco getEntityCuentaBanco(String strPrefijo,CuentaBanco entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaBanco.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaBancoDataAccess.setFieldReflectionCuentaBanco(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaBanco=CuentaBancoConstantesFunciones.getTodosTiposColumnasCuentaBanco();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaBanco) {
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
							field = CuentaBanco.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaBanco.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaBancoDataAccess.setFieldReflectionCuentaBanco(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaBanco(Field field,String strPrefijo,String sColumn,CuentaBanco entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaBancoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDBANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.NUMEROCUENTA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.NUMEROCHEQUE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.SALDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.PROCEDENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.DESTINO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.ESBANCO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATOINGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATOEGRESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATODIARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATOCHEQUE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaBanco>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaBanco();
					entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaBanco("",entity,resultSet);
					
					//entity.setCuentaBancoOriginal( new CuentaBanco());
					//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaBancos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaBanco>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaBancoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaBancoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaBanco> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
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
	
	public  List<CuentaBanco> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBanco();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBanco("",entity,resultSet);
      	    	
				//entity.setCuentaBancoOriginal( new CuentaBanco());
      	    	//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaBancos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaBanco(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaBanco> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
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
	
	public  List<CuentaBanco> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaBanco> entities = new  ArrayList<CuentaBanco>();
		CuentaBanco entity = new CuentaBanco();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaBanco();
      	    	entity=super.getEntity("",entity,resultSet,CuentaBancoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaBanco("",entity,resultSet);
      	    	
				//entity.setCuentaBancoOriginal( new CuentaBanco());
      	    	//entity.setCuentaBancoOriginal(super.getEntity("",entity.getCuentaBancoOriginal(),resultSet,CuentaBancoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaBancoOriginal(this.getEntityCuentaBanco("",entity.getCuentaBancoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaBancos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaBanco getEntityCuentaBanco(String strPrefijo,CuentaBanco entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDSUCURSAL));
				entity.setid_banco(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDBANCO));
				entity.setid_tipo_cuenta_banco_global(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL));
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.CODIGO));
				entity.setnumero_cuenta(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.NUMEROCUENTA));
				entity.setnumero_cheque(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.NUMEROCHEQUE));
				entity.setnumero_cheque_auxiliar(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR));
				entity.setsaldo(resultSet.getDouble(strPrefijo+CuentaBancoConstantesFunciones.SALDO));
				entity.setprocedencia(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.PROCEDENCIA));
				entity.setdestino(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.DESTINO));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDCUENTACONTABLE));
				entity.setes_banco(resultSet.getBoolean(strPrefijo+CuentaBancoConstantesFunciones.ESBANCO));
				entity.setid_estado_cuenta_banco(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO));
				entity.setid_formato_ingreso(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATOINGRESO));
				entity.setid_formato_egreso(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATOEGRESO));
				entity.setid_formato_diario(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATODIARIO));
				entity.setid_formato_cheque(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATOCHEQUE));
				entity.setid_formato_retencion(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATORETENCION));if(resultSet.wasNull()) {entity.setid_formato_retencion(null); }
				entity.setid_formato_retencion_iva(resultSet.getLong(strPrefijo+CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA));if(resultSet.wasNull()) {entity.setid_formato_retencion_iva(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaBancoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaBanco(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaBanco entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaBancoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaBancoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaBancoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaBancoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaBancoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaBancoDataAccess.TABLENAME,CuentaBancoDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaBancoDataAccess.setCuentaBancoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentabanco.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcuentabanco.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Banco getBanco(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Banco banco= new Banco();

		try {
			BancoDataAccess bancoDataAccess=new BancoDataAccess();

			bancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bancoDataAccess.setConnexionType(this.connexionType);
			bancoDataAccess.setParameterDbType(this.parameterDbType);

			banco=bancoDataAccess.getEntity(connexion,relcuentabanco.getid_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return banco;

	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		TipoCuentaBancoGlobal tipocuentabancoglobal= new TipoCuentaBancoGlobal();

		try {
			TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess=new TipoCuentaBancoGlobalDataAccess();

			tipocuentabancoglobalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);

			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,relcuentabanco.getid_tipo_cuenta_banco_global());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocuentabancoglobal;

	}

	public CuentaContable getCuentaContable(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentabanco.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public EstadoCuentaBanco getEstadoCuentaBanco(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		EstadoCuentaBanco estadocuentabanco= new EstadoCuentaBanco();

		try {
			EstadoCuentaBancoDataAccess estadocuentabancoDataAccess=new EstadoCuentaBancoDataAccess();

			estadocuentabancoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadocuentabancoDataAccess.setConnexionType(this.connexionType);
			estadocuentabancoDataAccess.setParameterDbType(this.parameterDbType);

			estadocuentabanco=estadocuentabancoDataAccess.getEntity(connexion,relcuentabanco.getid_estado_cuenta_banco());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadocuentabanco;

	}

	public Formato getFormatoIngreso(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_ingreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoEgreso(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_egreso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoDiario(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_diario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoCheque(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_cheque());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoRetencion(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public Formato getFormatoRetencionIva(Connexion connexion,CuentaBanco relcuentabanco)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relcuentabanco.getid_formato_retencion_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}


		
		public List<PagoAuto> getPagoAutos(Connexion connexion,CuentaBanco cuentabanco)throws SQLException,Exception {

		List<PagoAuto> pagoautos= new ArrayList<PagoAuto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco ON "+PagoAutoConstantesFunciones.SCHEMA+".pago_auto.id_cuenta_banco="+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id WHERE "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id="+String.valueOf(cuentabanco.getId());
			} else {
				sQuery=" INNER JOIN pagoauto.CuentaBanco WHERE pagoauto.CuentaBanco.id="+String.valueOf(cuentabanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PagoAutoDataAccess pagoautoDataAccess=new PagoAutoDataAccess();

			pagoautoDataAccess.setConnexionType(this.connexionType);
			pagoautoDataAccess.setParameterDbType(this.parameterDbType);
			pagoautos=pagoautoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pagoautos;

	}

	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras(Connexion connexion,CuentaBanco cuentabanco)throws SQLException,Exception {

		List<AutoriPagoOrdenCompra> autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco ON "+AutoriPagoOrdenCompraConstantesFunciones.SCHEMA+".autori_pago_orden_compra.id_cuenta_banco="+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id WHERE "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id="+String.valueOf(cuentabanco.getId());
			} else {
				sQuery=" INNER JOIN autoripagoordencompra.CuentaBanco WHERE autoripagoordencompra.CuentaBanco.id="+String.valueOf(cuentabanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoOrdenCompraDataAccess autoripagoordencompraDataAccess=new AutoriPagoOrdenCompraDataAccess();

			autoripagoordencompraDataAccess.setConnexionType(this.connexionType);
			autoripagoordencompraDataAccess.setParameterDbType(this.parameterDbType);
			autoripagoordencompras=autoripagoordencompraDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagoordencompras;

	}

	public List<DetalleChequeGirado> getDetalleChequeGirados(Connexion connexion,CuentaBanco cuentabanco)throws SQLException,Exception {

		List<DetalleChequeGirado> detallechequegirados= new ArrayList<DetalleChequeGirado>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco ON "+DetalleChequeGiradoConstantesFunciones.SCHEMA+".detalle_cheque_girado.id_cuenta_banco="+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id WHERE "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id="+String.valueOf(cuentabanco.getId());
			} else {
				sQuery=" INNER JOIN detallechequegirado.CuentaBanco WHERE detallechequegirado.CuentaBanco.id="+String.valueOf(cuentabanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleChequeGiradoDataAccess detallechequegiradoDataAccess=new DetalleChequeGiradoDataAccess();

			detallechequegiradoDataAccess.setConnexionType(this.connexionType);
			detallechequegiradoDataAccess.setParameterDbType(this.parameterDbType);
			detallechequegirados=detallechequegiradoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallechequegirados;

	}

	public List<AutoriPago> getAutoriPagos(Connexion connexion,CuentaBanco cuentabanco)throws SQLException,Exception {

		List<AutoriPago> autoripagos= new ArrayList<AutoriPago>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco ON "+AutoriPagoConstantesFunciones.SCHEMA+".autori_pago.id_cuenta_banco="+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id WHERE "+CuentaBancoConstantesFunciones.SCHEMA+".cuenta_banco.id="+String.valueOf(cuentabanco.getId());
			} else {
				sQuery=" INNER JOIN autoripago.CuentaBanco WHERE autoripago.CuentaBanco.id="+String.valueOf(cuentabanco.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			AutoriPagoDataAccess autoripagoDataAccess=new AutoriPagoDataAccess();

			autoripagoDataAccess.setConnexionType(this.connexionType);
			autoripagoDataAccess.setParameterDbType(this.parameterDbType);
			autoripagos=autoripagoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return autoripagos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaBanco cuentabanco) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentabanco.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentabanco.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(cuentabanco.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_banco.setValue(cuentabanco.getid_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_cuenta_banco_global=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_cuenta_banco_global.setValue(cuentabanco.getid_tipo_cuenta_banco_global());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_cuenta_banco_global);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(cuentabanco.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cuenta=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cuenta.setValue(cuentabanco.getnumero_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque.setValue(cuentabanco.getnumero_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_cheque_auxiliar=new ParameterValue<String>();
					parameterMaintenanceValuenumero_cheque_auxiliar.setValue(cuentabanco.getnumero_cheque_auxiliar());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cheque_auxiliar);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesaldo=new ParameterValue<Double>();
					parameterMaintenanceValuesaldo.setValue(cuentabanco.getsaldo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesaldo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueprocedencia=new ParameterValue<String>();
					parameterMaintenanceValueprocedencia.setValue(cuentabanco.getprocedencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprocedencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedestino=new ParameterValue<String>();
					parameterMaintenanceValuedestino.setValue(cuentabanco.getdestino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedestino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentabanco.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_banco=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_banco.setValue(cuentabanco.getes_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_cuenta_banco=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_cuenta_banco.setValue(cuentabanco.getid_estado_cuenta_banco());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_cuenta_banco);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_ingreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_ingreso.setValue(cuentabanco.getid_formato_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_egreso=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_egreso.setValue(cuentabanco.getid_formato_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_diario=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_diario.setValue(cuentabanco.getid_formato_diario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_diario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_cheque=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_cheque.setValue(cuentabanco.getid_formato_cheque());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_cheque);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_retencion.setValue(cuentabanco.getid_formato_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato_retencion_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato_retencion_iva.setValue(cuentabanco.getid_formato_retencion_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato_retencion_iva);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentabanco.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentabanco.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentabanco.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentabanco.getId());
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
	
	public void setIsNewIsChangedFalseCuentaBanco(CuentaBanco cuentabanco)throws Exception  {		
		cuentabanco.setIsNew(false);
		cuentabanco.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaBancos(List<CuentaBanco> cuentabancos)throws Exception  {				
		for(CuentaBanco cuentabanco:cuentabancos) {
			cuentabanco.setIsNew(false);
			cuentabanco.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaBanco(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
