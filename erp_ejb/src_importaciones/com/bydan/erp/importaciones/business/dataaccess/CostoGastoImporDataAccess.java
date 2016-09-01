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
package com.bydan.erp.importaciones.business.dataaccess;

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

import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.importaciones.util.*;//CostoGastoImporConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class CostoGastoImporDataAccess extends  CostoGastoImporDataAccessAdditional{ //CostoGastoImporDataAccessAdditional,DataAccessHelper<CostoGastoImpor>
	//static Logger logger = Logger.getLogger(CostoGastoImporDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="costo_gasto_impor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_costo_gasto_impor,nombre,es_activo,con_agrupa,con_prorratea,con_factura,con_flete,con_arancel,con_seguro,con_total_general,con_digitado)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_costo_gasto_impor=?,nombre=?,es_activo=?,con_agrupa=?,con_prorratea=?,con_factura=?,con_flete=?,con_arancel=?,con_seguro=?,con_total_general=?,con_digitado=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select costogastoimpor from "+CostoGastoImporConstantesFunciones.SPERSISTENCENAME+" costogastoimpor";
	public static String QUERYSELECTNATIVE="select "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_empresa,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_sucursal,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id_tipo_costo_gasto_impor,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".nombre,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".es_activo,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_agrupa,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_prorratea,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_factura,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_flete,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_arancel,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_seguro,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_total_general,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".con_digitado from "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME;//+" as "+CostoGastoImporConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".id,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".version_row,"+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+".nombre from "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME;//+" as "+CostoGastoImporConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+CostoGastoImporConstantesFunciones.SCHEMA+"."+CostoGastoImporConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_costo_gasto_impor=?,nombre=?,es_activo=?,con_agrupa=?,con_prorratea=?,con_factura=?,con_flete=?,con_arancel=?,con_seguro=?,con_total_general=?,con_digitado=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COSTOGASTOIMPOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COSTOGASTOIMPOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COSTOGASTOIMPOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COSTOGASTOIMPOR_SELECT(?,?)";
	
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
	
	
	protected CostoGastoImporDataAccessAdditional costogastoimporDataAccessAdditional=null;
	
	public CostoGastoImporDataAccessAdditional getCostoGastoImporDataAccessAdditional() {
		return this.costogastoimporDataAccessAdditional;
	}
	
	public void setCostoGastoImporDataAccessAdditional(CostoGastoImporDataAccessAdditional costogastoimporDataAccessAdditional) {
		try {
			this.costogastoimporDataAccessAdditional=costogastoimporDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public CostoGastoImporDataAccess() {
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
		CostoGastoImporDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		CostoGastoImporDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		CostoGastoImporDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setCostoGastoImporOriginal(CostoGastoImpor costogastoimpor)throws Exception  {
		costogastoimpor.setCostoGastoImporOriginal((CostoGastoImpor)costogastoimpor.clone());		
	}
	
	public void setCostoGastoImporsOriginal(List<CostoGastoImpor> costogastoimpors)throws Exception  {
		
		for(CostoGastoImpor costogastoimpor:costogastoimpors){
			costogastoimpor.setCostoGastoImporOriginal((CostoGastoImpor)costogastoimpor.clone());
		}
	}
	
	public static void setCostoGastoImporOriginalStatic(CostoGastoImpor costogastoimpor)throws Exception  {
		costogastoimpor.setCostoGastoImporOriginal((CostoGastoImpor)costogastoimpor.clone());		
	}
	
	public static void setCostoGastoImporsOriginalStatic(List<CostoGastoImpor> costogastoimpors)throws Exception  {
		
		for(CostoGastoImpor costogastoimpor:costogastoimpors){
			costogastoimpor.setCostoGastoImporOriginal((CostoGastoImpor)costogastoimpor.clone());
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
	
	public  CostoGastoImpor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();		
		
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
	
	public  CostoGastoImpor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Importaciones.CostoGastoImpor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setCostoGastoImporOriginal(new CostoGastoImpor());
      	    	entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCostoGastoImpor("",entity,resultSet); 
				
				//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseCostoGastoImpor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  CostoGastoImpor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();
				
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
	
	public  CostoGastoImpor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.CostoGastoImpor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setCostoGastoImporOriginal(new CostoGastoImpor());
      	    	entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityCostoGastoImpor("",entity,resultSet);    
				
				//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseCostoGastoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //CostoGastoImpor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		CostoGastoImpor entity = new CostoGastoImpor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Importaciones.CostoGastoImpor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseCostoGastoImpor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<CostoGastoImpor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		
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
	
	public  List<CostoGastoImpor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CostoGastoImpor();
      	    	entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCostoGastoImpor("",entity,resultSet);
      	    	
				//entity.setCostoGastoImporOriginal( new CostoGastoImpor());
      	    	//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCostoGastoImpors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CostoGastoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
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
	
	public  List<CostoGastoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CostoGastoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapCostoGastoImpor();
					//entity.setMapCostoGastoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapCostoGastoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCostoGastoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=CostoGastoImporDataAccess.getEntityCostoGastoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCostoGastoImporOriginal( new CostoGastoImpor());
					////entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCostoGastoImpors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public CostoGastoImpor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();		  
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
	
	public  CostoGastoImpor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CostoGastoImpor();
				
				if(conMapGenerico) {
					entity.inicializarMapCostoGastoImpor();
					//entity.setMapCostoGastoImpor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapCostoGastoImporValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapCostoGastoImpor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=CostoGastoImporDataAccess.getEntityCostoGastoImpor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setCostoGastoImporOriginal( new CostoGastoImpor());
					////entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
					////entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseCostoGastoImpor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static CostoGastoImpor getEntityCostoGastoImpor(String strPrefijo,CostoGastoImpor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = CostoGastoImpor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = CostoGastoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					CostoGastoImporDataAccess.setFieldReflectionCostoGastoImpor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasCostoGastoImpor=CostoGastoImporConstantesFunciones.getTodosTiposColumnasCostoGastoImpor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasCostoGastoImpor) {
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
							field = CostoGastoImpor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = CostoGastoImpor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						CostoGastoImporDataAccess.setFieldReflectionCostoGastoImpor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionCostoGastoImpor(Field field,String strPrefijo,String sColumn,CostoGastoImpor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case CostoGastoImporConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.ESACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONAGRUPA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONPRORRATEA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONFACTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONFLETE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONARANCEL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONSEGURO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONTOTALGENERAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case CostoGastoImporConstantesFunciones.CONDIGITADO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CostoGastoImpor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new CostoGastoImpor();
					entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityCostoGastoImpor("",entity,resultSet);
					
					//entity.setCostoGastoImporOriginal( new CostoGastoImpor());
					//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
					//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseCostoGastoImpors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<CostoGastoImpor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=CostoGastoImporDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,CostoGastoImporDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<CostoGastoImpor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
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
	
	public  List<CostoGastoImpor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CostoGastoImpor();
      	    	entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCostoGastoImpor("",entity,resultSet);
      	    	
				//entity.setCostoGastoImporOriginal( new CostoGastoImpor());
      	    	//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseCostoGastoImpors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarCostoGastoImpor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<CostoGastoImpor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
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
	
	public  List<CostoGastoImpor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<CostoGastoImpor> entities = new  ArrayList<CostoGastoImpor>();
		CostoGastoImpor entity = new CostoGastoImpor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new CostoGastoImpor();
      	    	entity=super.getEntity("",entity,resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityCostoGastoImpor("",entity,resultSet);
      	    	
				//entity.setCostoGastoImporOriginal( new CostoGastoImpor());
      	    	//entity.setCostoGastoImporOriginal(super.getEntity("",entity.getCostoGastoImporOriginal(),resultSet,CostoGastoImporDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setCostoGastoImporOriginal(this.getEntityCostoGastoImpor("",entity.getCostoGastoImporOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseCostoGastoImpors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public CostoGastoImpor getEntityCostoGastoImpor(String strPrefijo,CostoGastoImpor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+CostoGastoImporConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+CostoGastoImporConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_costo_gasto_impor(resultSet.getLong(strPrefijo+CostoGastoImporConstantesFunciones.IDTIPOCOSTOGASTOIMPOR));
				entity.setnombre(resultSet.getString(strPrefijo+CostoGastoImporConstantesFunciones.NOMBRE));
				entity.setes_activo(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.ESACTIVO));
				entity.setcon_agrupa(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONAGRUPA));
				entity.setcon_prorratea(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONPRORRATEA));
				entity.setcon_factura(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONFACTURA));
				entity.setcon_flete(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONFLETE));
				entity.setcon_arancel(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONARANCEL));
				entity.setcon_seguro(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONSEGURO));
				entity.setcon_total_general(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONTOTALGENERAL));
				entity.setcon_digitado(resultSet.getBoolean(strPrefijo+CostoGastoImporConstantesFunciones.CONDIGITADO));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+CostoGastoImporConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowCostoGastoImpor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(CostoGastoImpor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=CostoGastoImporDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=CostoGastoImporDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=CostoGastoImporDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=CostoGastoImporDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(CostoGastoImporConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,CostoGastoImporDataAccess.TABLENAME,CostoGastoImporDataAccess.ISWITHSTOREPROCEDURES);
			
			CostoGastoImporDataAccess.setCostoGastoImporOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,CostoGastoImpor relcostogastoimpor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcostogastoimpor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,CostoGastoImpor relcostogastoimpor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relcostogastoimpor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoCostoGastoImpor getTipoCostoGastoImpor(Connexion connexion,CostoGastoImpor relcostogastoimpor)throws SQLException,Exception {

		TipoCostoGastoImpor tipocostogastoimpor= new TipoCostoGastoImpor();

		try {
			TipoCostoGastoImporDataAccess tipocostogastoimporDataAccess=new TipoCostoGastoImporDataAccess();

			tipocostogastoimporDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocostogastoimporDataAccess.setConnexionType(this.connexionType);
			tipocostogastoimporDataAccess.setParameterDbType(this.parameterDbType);

			tipocostogastoimpor=tipocostogastoimporDataAccess.getEntity(connexion,relcostogastoimpor.getid_tipo_costo_gasto_impor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocostogastoimpor;

	}


		
		public List<DetalleLiquidacionImpor> getDetalleLiquidacionImpors(Connexion connexion,CostoGastoImpor costogastoimpor)throws SQLException,Exception {

		List<DetalleLiquidacionImpor> detalleliquidacionimpors= new ArrayList<DetalleLiquidacionImpor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+CostoGastoImporConstantesFunciones.SCHEMA+".costo_gasto_impor ON "+DetalleLiquidacionImporConstantesFunciones.SCHEMA+".detalle_liquidacion_impor.id_costo_gasto_impor="+CostoGastoImporConstantesFunciones.SCHEMA+".costo_gasto_impor.id WHERE "+CostoGastoImporConstantesFunciones.SCHEMA+".costo_gasto_impor.id="+String.valueOf(costogastoimpor.getId());
			} else {
				sQuery=" INNER JOIN detalleliquidacionimpor.CostoGastoImpor WHERE detalleliquidacionimpor.CostoGastoImpor.id="+String.valueOf(costogastoimpor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleLiquidacionImporDataAccess detalleliquidacionimporDataAccess=new DetalleLiquidacionImporDataAccess();

			detalleliquidacionimporDataAccess.setConnexionType(this.connexionType);
			detalleliquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			detalleliquidacionimpors=detalleliquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleliquidacionimpors;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,CostoGastoImpor costogastoimpor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!costogastoimpor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(costogastoimpor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(costogastoimpor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_costo_gasto_impor=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_costo_gasto_impor.setValue(costogastoimpor.getid_tipo_costo_gasto_impor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_costo_gasto_impor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(costogastoimpor.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_activo.setValue(costogastoimpor.getes_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_agrupa=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_agrupa.setValue(costogastoimpor.getcon_agrupa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_agrupa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_prorratea=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_prorratea.setValue(costogastoimpor.getcon_prorratea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_prorratea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_factura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_factura.setValue(costogastoimpor.getcon_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_flete=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_flete.setValue(costogastoimpor.getcon_flete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_flete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_arancel=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_arancel.setValue(costogastoimpor.getcon_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_seguro=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_seguro.setValue(costogastoimpor.getcon_seguro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_seguro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_total_general=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_total_general.setValue(costogastoimpor.getcon_total_general());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_total_general);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_digitado=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_digitado.setValue(costogastoimpor.getcon_digitado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_digitado);
					parametersTemp.add(parameterMaintenance);
					
						if(!costogastoimpor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(costogastoimpor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(costogastoimpor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(costogastoimpor.getId());
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
	
	public void setIsNewIsChangedFalseCostoGastoImpor(CostoGastoImpor costogastoimpor)throws Exception  {		
		costogastoimpor.setIsNew(false);
		costogastoimpor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseCostoGastoImpors(List<CostoGastoImpor> costogastoimpors)throws Exception  {				
		for(CostoGastoImpor costogastoimpor:costogastoimpors) {
			costogastoimpor.setIsNew(false);
			costogastoimpor.setIsChanged(false);
		}
	}
	
	public void generarExportarCostoGastoImpor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
