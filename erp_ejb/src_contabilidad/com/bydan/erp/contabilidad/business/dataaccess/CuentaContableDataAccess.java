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
import com.bydan.erp.contabilidad.util.*;//CuentaContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CuentaContableDataAccess extends  CuentaContableDataAccessAdditional{ //CuentaContableDataAccessAdditional,DataAccessHelper<CuentaContable>
	//static Logger logger = Logger.getLogger(CuentaContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="cuenta_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,codigo_extranjero,nombre_extranjero,id_nivel_cuenta,id_cuenta_contable,id_centro_costo,id_modulo,descripcion,es_movimiento,es_centro_costo,es_centro_actividad,es_activo,es_relacion,es_para_f52,id_moneda,id_tipo_intervalo,id_tipo_flujo_efectivo,id_cuenta_contable_debito,id_cuenta_contable_credito,orden)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,codigo_extranjero=?,nombre_extranjero=?,id_nivel_cuenta=?,id_cuenta_contable=?,id_centro_costo=?,id_modulo=?,descripcion=?,es_movimiento=?,es_centro_costo=?,es_centro_actividad=?,es_activo=?,es_relacion=?,es_para_f52=?,id_moneda=?,id_tipo_intervalo=?,id_tipo_flujo_efectivo=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,orden=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select cuentacontable from "+CuentaContableConstantesFunciones.SPERSISTENCENAME+" cuentacontable";
	public static String QUERYSELECTNATIVE="select "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".version_row,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".codigo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".nombre,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".codigo_extranjero,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".nombre_extranjero,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_nivel_cuenta,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_centro_costo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_modulo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".descripcion,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_movimiento,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_centro_costo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_centro_actividad,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_activo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_relacion,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".es_para_f52,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_moneda,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_tipo_flujo_efectivo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".orden from "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME;//+" as "+CuentaContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".id,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".version_row,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".codigo,"+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+".nombre from "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME;//+" as "+CuentaContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CuentaContableConstantesFunciones.SCHEMA+"."+CuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,codigo_extranjero=?,nombre_extranjero=?,id_nivel_cuenta=?,id_cuenta_contable=?,id_centro_costo=?,id_modulo=?,descripcion=?,es_movimiento=?,es_centro_costo=?,es_centro_actividad=?,es_activo=?,es_relacion=?,es_para_f52=?,id_moneda=?,id_tipo_intervalo=?,id_tipo_flujo_efectivo=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,orden=?";
	
	public static String STOREPROCEDUREINSERT="call SP_CUENTACONTABLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_CUENTACONTABLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_CUENTACONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_CUENTACONTABLE_SELECT(?,?)";
	
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
	
	
	protected CuentaContableDataAccessAdditional cuentacontableDataAccessAdditional=null;
	
	public CuentaContableDataAccessAdditional getCuentaContableDataAccessAdditional() {
		return this.cuentacontableDataAccessAdditional;
	}
	
	public void setCuentaContableDataAccessAdditional(CuentaContableDataAccessAdditional cuentacontableDataAccessAdditional) {
		try {
			this.cuentacontableDataAccessAdditional=cuentacontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CuentaContableDataAccess() {
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
		CuentaContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CuentaContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CuentaContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCuentaContableOriginal(CuentaContable cuentacontable)throws Exception  {
		cuentacontable.setCuentaContableOriginal((CuentaContable)cuentacontable.clone());		
	}
	
	public void setCuentaContablesOriginal(List<CuentaContable> cuentacontables)throws Exception  {
		
		for(CuentaContable cuentacontable:cuentacontables){
			cuentacontable.setCuentaContableOriginal((CuentaContable)cuentacontable.clone());
		}
	}
	
	public static void setCuentaContableOriginalStatic(CuentaContable cuentacontable)throws Exception  {
		cuentacontable.setCuentaContableOriginal((CuentaContable)cuentacontable.clone());		
	}
	
	public static void setCuentaContablesOriginalStatic(List<CuentaContable> cuentacontables)throws Exception  {
		
		for(CuentaContable cuentacontable:cuentacontables){
			cuentacontable.setCuentaContableOriginal((CuentaContable)cuentacontable.clone());
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
	
	public  CuentaContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();		
		
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
	
	public  CuentaContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.CuentaContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCuentaContableOriginal(new CuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContable("",entity,resultSet); 
				
				//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CuentaContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();
				
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
	
	public  CuentaContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CuentaContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCuentaContableOriginal(new CuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCuentaContable("",entity,resultSet);    
				
				//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CuentaContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CuentaContable entity = new CuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.CuentaContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CuentaContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		
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
	
	public  List<CuentaContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContable("",entity,resultSet);
      	    	
				//entity.setCuentaContableOriginal( new CuentaContable());
      	    	//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
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
	
	public  List<CuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContable();
					//entity.setMapCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContableDataAccess.getEntityCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContableOriginal( new CuentaContable());
					////entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CuentaContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();		  
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
	
	public  CuentaContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapCuentaContable();
					//entity.setMapCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=CuentaContableDataAccess.getEntityCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCuentaContableOriginal( new CuentaContable());
					////entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCuentaContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CuentaContable getEntityCuentaContable(String strPrefijo,CuentaContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CuentaContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CuentaContableDataAccess.setFieldReflectionCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCuentaContable=CuentaContableConstantesFunciones.getTodosTiposColumnasCuentaContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCuentaContable) {
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
							field = CuentaContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CuentaContableDataAccess.setFieldReflectionCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCuentaContable(Field field,String strPrefijo,String sColumn,CuentaContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CuentaContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.CODIGOEXTRANJERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.NOMBREEXTRANJERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDNIVELCUENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDCUENTACONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDMODULO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESMOVIMIENTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESCENTROCOSTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESCENTROACTIVIDAD:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESRELACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ESPARAF52:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDMONEDA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDTIPOINTERVALO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CuentaContableConstantesFunciones.ORDEN:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CuentaContable();
					entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCuentaContable("",entity,resultSet);
					
					//entity.setCuentaContableOriginal( new CuentaContable());
					//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
					//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCuentaContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CuentaContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
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
	
	public  List<CuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContable("",entity,resultSet);
      	    	
				//entity.setCuentaContableOriginal( new CuentaContable());
      	    	//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCuentaContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CuentaContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
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
	
	public  List<CuentaContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CuentaContable> entities = new  ArrayList<CuentaContable>();
		CuentaContable entity = new CuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,CuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCuentaContable("",entity,resultSet);
      	    	
				//entity.setCuentaContableOriginal( new CuentaContable());
      	    	//entity.setCuentaContableOriginal(super.getEntity("",entity.getCuentaContableOriginal(),resultSet,CuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCuentaContableOriginal(this.getEntityCuentaContable("",entity.getCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCuentaContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CuentaContable getEntityCuentaContable(String strPrefijo,CuentaContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.NOMBRE));
				entity.setcodigo_extranjero(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.CODIGOEXTRANJERO));
				entity.setnombre_extranjero(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.NOMBREEXTRANJERO));
				entity.setid_nivel_cuenta(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDNIVELCUENTA));
				entity.setid_cuenta_contable(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDCUENTACONTABLE));if(resultSet.wasNull()) {entity.setid_cuenta_contable(null); }
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_modulo(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDMODULO));
				entity.setdescripcion(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.DESCRIPCION));
				entity.setes_movimiento(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESMOVIMIENTO));
				entity.setes_centro_costo(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESCENTROCOSTO));
				entity.setes_centro_actividad(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESCENTROACTIVIDAD));
				entity.setes_activo(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESACTIVO));
				entity.setes_relacion(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESRELACION));
				entity.setes_para_f52(resultSet.getBoolean(strPrefijo+CuentaContableConstantesFunciones.ESPARAF52));
				entity.setid_moneda(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDMONEDA));
				entity.setid_tipo_intervalo(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDTIPOINTERVALO));
				entity.setid_tipo_flujo_efectivo(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO));if(resultSet.wasNull()) {entity.setid_tipo_flujo_efectivo(null); }
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_debito(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setorden(resultSet.getInt(strPrefijo+CuentaContableConstantesFunciones.ORDEN));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+CuentaContableConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCuentaContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CuentaContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CuentaContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CuentaContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CuentaContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CuentaContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CuentaContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CuentaContableDataAccess.TABLENAME,CuentaContableDataAccess.ISWITHSTOREPROCEDURES);
			
			CuentaContableDataAccess.setCuentaContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcuentacontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public NivelCuenta getNivelCuenta(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		NivelCuenta nivelcuenta= new NivelCuenta();

		try {
			NivelCuentaDataAccess nivelcuentaDataAccess=new NivelCuentaDataAccess();

			nivelcuentaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			nivelcuentaDataAccess.setConnexionType(this.connexionType);
			nivelcuentaDataAccess.setParameterDbType(this.parameterDbType);

			nivelcuenta=nivelcuentaDataAccess.getEntity(connexion,relcuentacontable.getid_nivel_cuenta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return nivelcuenta;

	}

	public CuentaContable getCuentaContable(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontable.getid_cuenta_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CentroCosto getCentroCosto(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relcuentacontable.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Modulo getModulo(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		Modulo modulo= new Modulo();

		try {
			ModuloDataAccess moduloDataAccess=new ModuloDataAccess();

			moduloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			moduloDataAccess.setConnexionType(this.connexionType);
			moduloDataAccess.setParameterDbType(this.parameterDbType);

			modulo=moduloDataAccess.getEntity(connexion,relcuentacontable.getid_modulo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modulo;

	}

	public Moneda getMoneda(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		Moneda moneda= new Moneda();

		try {
			MonedaDataAccess monedaDataAccess=new MonedaDataAccess();

			monedaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			monedaDataAccess.setConnexionType(this.connexionType);
			monedaDataAccess.setParameterDbType(this.parameterDbType);

			moneda=monedaDataAccess.getEntity(connexion,relcuentacontable.getid_moneda());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return moneda;

	}

	public TipoIntervalo getTipoIntervalo(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		TipoIntervalo tipointervalo= new TipoIntervalo();

		try {
			TipoIntervaloDataAccess tipointervaloDataAccess=new TipoIntervaloDataAccess();

			tipointervaloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipointervaloDataAccess.setConnexionType(this.connexionType);
			tipointervaloDataAccess.setParameterDbType(this.parameterDbType);

			tipointervalo=tipointervaloDataAccess.getEntity(connexion,relcuentacontable.getid_tipo_intervalo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipointervalo;

	}

	public TipoFlujoEfectivo getTipoFlujoEfectivo(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		TipoFlujoEfectivo tipoflujoefectivo= new TipoFlujoEfectivo();

		try {
			TipoFlujoEfectivoDataAccess tipoflujoefectivoDataAccess=new TipoFlujoEfectivoDataAccess();

			tipoflujoefectivoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoflujoefectivoDataAccess.setConnexionType(this.connexionType);
			tipoflujoefectivoDataAccess.setParameterDbType(this.parameterDbType);

			tipoflujoefectivo=tipoflujoefectivoDataAccess.getEntity(connexion,relcuentacontable.getid_tipo_flujo_efectivo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoflujoefectivo;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontable.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,CuentaContable relcuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relcuentacontable.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CuentaContable cuentacontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!cuentacontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(cuentacontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(cuentacontable.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(cuentacontable.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_extranjero=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_extranjero.setValue(cuentacontable.getcodigo_extranjero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_extranjero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_extranjero=new ParameterValue<String>();
					parameterMaintenanceValuenombre_extranjero.setValue(cuentacontable.getnombre_extranjero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_extranjero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_nivel_cuenta=new ParameterValue<Long>();
					parameterMaintenanceValueid_nivel_cuenta.setValue(cuentacontable.getid_nivel_cuenta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_nivel_cuenta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable.setValue(cuentacontable.getid_cuenta_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(cuentacontable.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modulo=new ParameterValue<Long>();
					parameterMaintenanceValueid_modulo.setValue(cuentacontable.getid_modulo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modulo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(cuentacontable.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_movimiento=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_movimiento.setValue(cuentacontable.getes_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_centro_costo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_centro_costo.setValue(cuentacontable.getes_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_centro_actividad=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_centro_actividad.setValue(cuentacontable.getes_centro_actividad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_centro_actividad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_activo.setValue(cuentacontable.getes_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_relacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_relacion.setValue(cuentacontable.getes_relacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_relacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_para_f52=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_para_f52.setValue(cuentacontable.getes_para_f52());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_para_f52);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_moneda=new ParameterValue<Long>();
					parameterMaintenanceValueid_moneda.setValue(cuentacontable.getid_moneda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_moneda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_intervalo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_intervalo.setValue(cuentacontable.getid_tipo_intervalo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_intervalo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_flujo_efectivo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_flujo_efectivo.setValue(cuentacontable.getid_tipo_flujo_efectivo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_flujo_efectivo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(cuentacontable.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(cuentacontable.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValueorden=new ParameterValue<Integer>();
					parameterMaintenanceValueorden.setValue(cuentacontable.getorden());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueorden);
					parametersTemp.add(parameterMaintenance);
					
						if(!cuentacontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(cuentacontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(cuentacontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(cuentacontable.getId());
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
	
	public void setIsNewIsChangedFalseCuentaContable(CuentaContable cuentacontable)throws Exception  {		
		cuentacontable.setIsNew(false);
		cuentacontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCuentaContables(List<CuentaContable> cuentacontables)throws Exception  {				
		for(CuentaContable cuentacontable:cuentacontables) {
			cuentacontable.setIsNew(false);
			cuentacontable.setIsChanged(false);
		}
	}
	
	public void generarExportarCuentaContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
