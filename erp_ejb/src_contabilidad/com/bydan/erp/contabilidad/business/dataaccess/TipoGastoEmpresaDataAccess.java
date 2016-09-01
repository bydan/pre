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
import com.bydan.erp.contabilidad.util.*;//TipoGastoEmpresaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class TipoGastoEmpresaDataAccess extends  TipoGastoEmpresaDataAccessAdditional{ //TipoGastoEmpresaDataAccessAdditional,DataAccessHelper<TipoGastoEmpresa>
	//static Logger logger = Logger.getLogger(TipoGastoEmpresaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_gasto_empresa";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,nombre,id_formato,descripcion,id_cuenta_contable_gasto,id_cuenta_contable_fiscal_bien,id_cuenta_contable_fiscal_servicio,id_cuenta_contable_retencion_bien,id_cuenta_contable_retencion_servicio,id_cuenta_contable_iva_bien,id_cuenta_contable_iva_servicio)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,nombre=?,id_formato=?,descripcion=?,id_cuenta_contable_gasto=?,id_cuenta_contable_fiscal_bien=?,id_cuenta_contable_fiscal_servicio=?,id_cuenta_contable_retencion_bien=?,id_cuenta_contable_retencion_servicio=?,id_cuenta_contable_iva_bien=?,id_cuenta_contable_iva_servicio=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipogastoempresa from "+TipoGastoEmpresaConstantesFunciones.SPERSISTENCENAME+" tipogastoempresa";
	public static String QUERYSELECTNATIVE="select "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_sucursal,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_formato,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".descripcion,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal_servicio,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion_servicio,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_bien,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id_cuenta_contable_iva_servicio from "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoEmpresaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".id,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+".nombre from "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoGastoEmpresaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoGastoEmpresaConstantesFunciones.SCHEMA+"."+TipoGastoEmpresaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,nombre=?,id_formato=?,descripcion=?,id_cuenta_contable_gasto=?,id_cuenta_contable_fiscal_bien=?,id_cuenta_contable_fiscal_servicio=?,id_cuenta_contable_retencion_bien=?,id_cuenta_contable_retencion_servicio=?,id_cuenta_contable_iva_bien=?,id_cuenta_contable_iva_servicio=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOGASTOEMPRESA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOGASTOEMPRESA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOGASTOEMPRESA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOGASTOEMPRESA_SELECT(?,?)";
	
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
	
	
	protected TipoGastoEmpresaDataAccessAdditional tipogastoempresaDataAccessAdditional=null;
	
	public TipoGastoEmpresaDataAccessAdditional getTipoGastoEmpresaDataAccessAdditional() {
		return this.tipogastoempresaDataAccessAdditional;
	}
	
	public void setTipoGastoEmpresaDataAccessAdditional(TipoGastoEmpresaDataAccessAdditional tipogastoempresaDataAccessAdditional) {
		try {
			this.tipogastoempresaDataAccessAdditional=tipogastoempresaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoGastoEmpresaDataAccess() {
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
		TipoGastoEmpresaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoGastoEmpresaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoGastoEmpresaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoGastoEmpresaOriginal(TipoGastoEmpresa tipogastoempresa)throws Exception  {
		tipogastoempresa.setTipoGastoEmpresaOriginal((TipoGastoEmpresa)tipogastoempresa.clone());		
	}
	
	public void setTipoGastoEmpresasOriginal(List<TipoGastoEmpresa> tipogastoempresas)throws Exception  {
		
		for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas){
			tipogastoempresa.setTipoGastoEmpresaOriginal((TipoGastoEmpresa)tipogastoempresa.clone());
		}
	}
	
	public static void setTipoGastoEmpresaOriginalStatic(TipoGastoEmpresa tipogastoempresa)throws Exception  {
		tipogastoempresa.setTipoGastoEmpresaOriginal((TipoGastoEmpresa)tipogastoempresa.clone());		
	}
	
	public static void setTipoGastoEmpresasOriginalStatic(List<TipoGastoEmpresa> tipogastoempresas)throws Exception  {
		
		for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas){
			tipogastoempresa.setTipoGastoEmpresaOriginal((TipoGastoEmpresa)tipogastoempresa.clone());
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
	
	public  TipoGastoEmpresa getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		
		
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
	
	public  TipoGastoEmpresa getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.TipoGastoEmpresa.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoGastoEmpresaOriginal(new TipoGastoEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGastoEmpresa("",entity,resultSet); 
				
				//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGastoEmpresa(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoGastoEmpresa getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();
				
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
	
	public  TipoGastoEmpresa getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoGastoEmpresa.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoGastoEmpresaOriginal(new TipoGastoEmpresa());
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoGastoEmpresa("",entity,resultSet);    
				
				//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoGastoEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoGastoEmpresa
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoGastoEmpresa entity = new TipoGastoEmpresa();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.TipoGastoEmpresa.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoGastoEmpresa(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoGastoEmpresa> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		
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
	
	public  List<TipoGastoEmpresa> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
      	    	//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoEmpresas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGastoEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
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
	
	public  List<TipoGastoEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGastoEmpresa();
					//entity.setMapTipoGastoEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoGastoEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGastoEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGastoEmpresaDataAccess.getEntityTipoGastoEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
					////entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoEmpresas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoGastoEmpresa getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
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
	
	public  TipoGastoEmpresa getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoEmpresa();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoGastoEmpresa();
					//entity.setMapTipoGastoEmpresa(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoGastoEmpresaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoGastoEmpresa().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=TipoGastoEmpresaDataAccess.getEntityTipoGastoEmpresa("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
					////entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoGastoEmpresa(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoGastoEmpresa getEntityTipoGastoEmpresa(String strPrefijo,TipoGastoEmpresa entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoGastoEmpresa.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoGastoEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoGastoEmpresaDataAccess.setFieldReflectionTipoGastoEmpresa(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoGastoEmpresa=TipoGastoEmpresaConstantesFunciones.getTodosTiposColumnasTipoGastoEmpresa();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoGastoEmpresa) {
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
							field = TipoGastoEmpresa.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoGastoEmpresa.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoGastoEmpresaDataAccess.setFieldReflectionTipoGastoEmpresa(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoGastoEmpresa(Field field,String strPrefijo,String sColumn,TipoGastoEmpresa entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoGastoEmpresaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGastoEmpresa>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoGastoEmpresa();
					entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoGastoEmpresa("",entity,resultSet);
					
					//entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
					//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoGastoEmpresas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoGastoEmpresa>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoGastoEmpresaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoGastoEmpresaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoGastoEmpresa> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
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
	
	public  List<TipoGastoEmpresa> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
      	    	//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoGastoEmpresas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoGastoEmpresa(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoGastoEmpresa> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
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
	
	public  List<TipoGastoEmpresa> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoGastoEmpresa> entities = new  ArrayList<TipoGastoEmpresa>();
		TipoGastoEmpresa entity = new TipoGastoEmpresa();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoGastoEmpresa();
      	    	entity=super.getEntity("",entity,resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoGastoEmpresa("",entity,resultSet);
      	    	
				//entity.setTipoGastoEmpresaOriginal( new TipoGastoEmpresa());
      	    	//entity.setTipoGastoEmpresaOriginal(super.getEntity("",entity.getTipoGastoEmpresaOriginal(),resultSet,TipoGastoEmpresaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoGastoEmpresaOriginal(this.getEntityTipoGastoEmpresa("",entity.getTipoGastoEmpresaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoGastoEmpresas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoGastoEmpresa getEntityTipoGastoEmpresa(String strPrefijo,TipoGastoEmpresa entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDSUCURSAL));
				entity.setnombre(resultSet.getString(strPrefijo+TipoGastoEmpresaConstantesFunciones.NOMBRE));
				entity.setid_formato(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDFORMATO));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoGastoEmpresaConstantesFunciones.DESCRIPCION));
				entity.setid_cuenta_contable_gasto(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEGASTO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_gasto(null); }
				entity.setid_cuenta_contable_fiscal_bien(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALBIEN));if(resultSet.wasNull()) {entity.setid_cuenta_contable_fiscal_bien(null); }
				entity.setid_cuenta_contable_fiscal_servicio(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEFISCALSERVICIO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_fiscal_servicio(null); }
				entity.setid_cuenta_contable_retencion_bien(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONBIEN));if(resultSet.wasNull()) {entity.setid_cuenta_contable_retencion_bien(null); }
				entity.setid_cuenta_contable_retencion_servicio(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLERETENCIONSERVICIO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_retencion_servicio(null); }
				entity.setid_cuenta_contable_iva_bien(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVABIEN));if(resultSet.wasNull()) {entity.setid_cuenta_contable_iva_bien(null); }
				entity.setid_cuenta_contable_iva_servicio(resultSet.getLong(strPrefijo+TipoGastoEmpresaConstantesFunciones.IDCUENTACONTABLEIVASERVICIO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_iva_servicio(null); }
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+TipoGastoEmpresaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoGastoEmpresa(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoGastoEmpresa entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoGastoEmpresaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoGastoEmpresaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoGastoEmpresaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoGastoEmpresaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoGastoEmpresaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoGastoEmpresaDataAccess.TABLENAME,TipoGastoEmpresaDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoGastoEmpresaDataAccess.setTipoGastoEmpresaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipogastoempresa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltipogastoempresa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Formato getFormato(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,reltipogastoempresa.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public CuentaContable getCuentaContableGasto(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_gasto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFiscalBien(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_fiscal_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFiscalServicio(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_fiscal_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableRetencionBien(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_retencion_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableRetencionServicio(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_retencion_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIvaBien(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_iva_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIvaServicio(Connexion connexion,TipoGastoEmpresa reltipogastoempresa)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,reltipogastoempresa.getid_cuenta_contable_iva_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas(Connexion connexion,TipoGastoEmpresa tipogastoempresa)throws SQLException,Exception {

		List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoGastoEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_empresa ON "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+".detalle_asiento_contable_caja_chica.id_tipo_gasto_empresa="+TipoGastoEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_empresa.id WHERE "+TipoGastoEmpresaConstantesFunciones.SCHEMA+".tipo_gasto_empresa.id="+String.valueOf(tipogastoempresa.getId());
			} else {
				sQuery=" INNER JOIN detalleasientocontablecajachica.TipoGastoEmpresa WHERE detalleasientocontablecajachica.TipoGastoEmpresa.id="+String.valueOf(tipogastoempresa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleAsientoContableCajaChicaDataAccess detalleasientocontablecajachicaDataAccess=new DetalleAsientoContableCajaChicaDataAccess();

			detalleasientocontablecajachicaDataAccess.setConnexionType(this.connexionType);
			detalleasientocontablecajachicaDataAccess.setParameterDbType(this.parameterDbType);
			detalleasientocontablecajachicas=detalleasientocontablecajachicaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleasientocontablecajachicas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoGastoEmpresa tipogastoempresa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipogastoempresa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipogastoempresa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tipogastoempresa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipogastoempresa.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(tipogastoempresa.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipogastoempresa.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_gasto=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_gasto.setValue(tipogastoempresa.getid_cuenta_contable_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_gasto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_fiscal_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_fiscal_bien.setValue(tipogastoempresa.getid_cuenta_contable_fiscal_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_fiscal_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_fiscal_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_fiscal_servicio.setValue(tipogastoempresa.getid_cuenta_contable_fiscal_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_fiscal_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_retencion_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_retencion_bien.setValue(tipogastoempresa.getid_cuenta_contable_retencion_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_retencion_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_retencion_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_retencion_servicio.setValue(tipogastoempresa.getid_cuenta_contable_retencion_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_retencion_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva_bien.setValue(tipogastoempresa.getid_cuenta_contable_iva_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva_servicio.setValue(tipogastoempresa.getid_cuenta_contable_iva_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva_servicio);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipogastoempresa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipogastoempresa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipogastoempresa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipogastoempresa.getId());
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
	
	public void setIsNewIsChangedFalseTipoGastoEmpresa(TipoGastoEmpresa tipogastoempresa)throws Exception  {		
		tipogastoempresa.setIsNew(false);
		tipogastoempresa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoGastoEmpresas(List<TipoGastoEmpresa> tipogastoempresas)throws Exception  {				
		for(TipoGastoEmpresa tipogastoempresa:tipogastoempresas) {
			tipogastoempresa.setIsNew(false);
			tipogastoempresa.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoGastoEmpresa(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
