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
import com.bydan.erp.contabilidad.util.*;//SriConstantesFunciones;


import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class SriDataAccess extends  SriDataAccessAdditional{ //SriDataAccessAdditional,DataAccessHelper<Sri>
	//static Logger logger = Logger.getLogger(SriDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="sri";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+"(version_row,id_asiento_contable,id_transaccion_conta,ruc,id_cliente,razon_social,tipo_comprobante,es_rise,numero_serie,numero_autorizacion,numero_secuencial,fecha_emision,fecha_registro_contable,fecha_caducidad,tipo_tributario,bienes_tar12,bienes_tar0,id_tipo_iva,servicios_tar12,servicios_tar0,monto_iva,base_impo_tar12,base_impo_tar0,monto_ice,monto_iva_bien,monto_iva_servicio,id_tipo_retencion_iva_bien,id_tipo_retencion_iva_servicio,retencion_iva_bien,retencion_iva_servicio,con_devolucion,id_tipo_movimiento)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_asiento_contable=?,id_transaccion_conta=?,ruc=?,id_cliente=?,razon_social=?,tipo_comprobante=?,es_rise=?,numero_serie=?,numero_autorizacion=?,numero_secuencial=?,fecha_emision=?,fecha_registro_contable=?,fecha_caducidad=?,tipo_tributario=?,bienes_tar12=?,bienes_tar0=?,id_tipo_iva=?,servicios_tar12=?,servicios_tar0=?,monto_iva=?,base_impo_tar12=?,base_impo_tar0=?,monto_ice=?,monto_iva_bien=?,monto_iva_servicio=?,id_tipo_retencion_iva_bien=?,id_tipo_retencion_iva_servicio=?,retencion_iva_bien=?,retencion_iva_servicio=?,con_devolucion=?,id_tipo_movimiento=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select sri from "+SriConstantesFunciones.SPERSISTENCENAME+" sri";
	public static String QUERYSELECTNATIVE="select "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".version_row,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_asiento_contable,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_transaccion_conta,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".ruc,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_cliente,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".razon_social,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".tipo_comprobante,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".es_rise,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_serie,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_autorizacion,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".numero_secuencial,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_emision,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_registro_contable,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".fecha_caducidad,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".tipo_tributario,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".bienes_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".bienes_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_iva,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".servicios_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".servicios_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".base_impo_tar12,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".base_impo_tar0,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_ice,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".monto_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_retencion_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".retencion_iva_bien,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".retencion_iva_servicio,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".con_devolucion,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id_tipo_movimiento from "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME;//+" as "+SriConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".id,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".version_row,"+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+".ruc from "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME;//+" as "+SriConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+SriConstantesFunciones.SCHEMA+"."+SriConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_asiento_contable=?,id_transaccion_conta=?,ruc=?,id_cliente=?,razon_social=?,tipo_comprobante=?,es_rise=?,numero_serie=?,numero_autorizacion=?,numero_secuencial=?,fecha_emision=?,fecha_registro_contable=?,fecha_caducidad=?,tipo_tributario=?,bienes_tar12=?,bienes_tar0=?,id_tipo_iva=?,servicios_tar12=?,servicios_tar0=?,monto_iva=?,base_impo_tar12=?,base_impo_tar0=?,monto_ice=?,monto_iva_bien=?,monto_iva_servicio=?,id_tipo_retencion_iva_bien=?,id_tipo_retencion_iva_servicio=?,retencion_iva_bien=?,retencion_iva_servicio=?,con_devolucion=?,id_tipo_movimiento=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SRI_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SRI_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SRI_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SRI_SELECT(?,?)";
	
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
	
	
	protected SriDataAccessAdditional sriDataAccessAdditional=null;
	
	public SriDataAccessAdditional getSriDataAccessAdditional() {
		return this.sriDataAccessAdditional;
	}
	
	public void setSriDataAccessAdditional(SriDataAccessAdditional sriDataAccessAdditional) {
		try {
			this.sriDataAccessAdditional=sriDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public SriDataAccess() {
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
		SriDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		SriDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		SriDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setSriOriginal(Sri sri)throws Exception  {
		sri.setSriOriginal((Sri)sri.clone());		
	}
	
	public void setSrisOriginal(List<Sri> sris)throws Exception  {
		
		for(Sri sri:sris){
			sri.setSriOriginal((Sri)sri.clone());
		}
	}
	
	public static void setSriOriginalStatic(Sri sri)throws Exception  {
		sri.setSriOriginal((Sri)sri.clone());		
	}
	
	public static void setSrisOriginalStatic(List<Sri> sris)throws Exception  {
		
		for(Sri sri:sris){
			sri.setSriOriginal((Sri)sri.clone());
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
	
	public  Sri getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Sri entity = new Sri();		
		
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
	
	public  Sri getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Sri entity = new Sri();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Contabilidad.Sri.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setSriOriginal(new Sri());
      	    	entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySri("",entity,resultSet); 
				
				//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseSri(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Sri getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Sri entity = new Sri();
				
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
	
	public  Sri getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Sri entity = new Sri();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Sri.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setSriOriginal(new Sri());
      	    	entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntitySri("",entity,resultSet);    
				
				//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseSri(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Sri
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Sri entity = new Sri();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Contabilidad.Sri.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseSri(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Sri> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		
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
	
	public  List<Sri> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sri();
      	    	entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySri("",entity,resultSet);
      	    	
				//entity.setSriOriginal( new Sri());
      	    	//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSris(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSri(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Sri> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
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
	
	public  List<Sri> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sri();
				
				if(conMapGenerico) {
					entity.inicializarMapSri();
					//entity.setMapSri(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapSriValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSri().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
					entity=SriDataAccess.getEntitySri("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSriOriginal( new Sri());
					////entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
					////entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSris(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Sri getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Sri entity = new Sri();		  
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
	
	public  Sri getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Sri entity = new Sri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sri();
				
				if(conMapGenerico) {
					entity.inicializarMapSri();
					//entity.setMapSri(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapSriValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapSri().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
					entity=SriDataAccess.getEntitySri("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setSriOriginal( new Sri());
					////entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
					////entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseSri(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Sri getEntitySri(String strPrefijo,Sri entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Sri.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Sri.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					SriDataAccess.setFieldReflectionSri(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasSri=SriConstantesFunciones.getTodosTiposColumnasSri();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasSri) {
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
							field = Sri.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Sri.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						SriDataAccess.setFieldReflectionSri(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionSri(Field field,String strPrefijo,String sColumn,Sri entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case SriConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.IDTRANSACCIONCONTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.RAZONSOCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.IDTIPOCOMPROBANTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.ESRISE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case SriConstantesFunciones.NUMEROSERIE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.NUMEROAUTORIZACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case SriConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriConstantesFunciones.FECHAREGISTROCONTABLE:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriConstantesFunciones.FECHACADUCIDAD:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case SriConstantesFunciones.IDTIPOTRIBUTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.BIENESTAR12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.BIENESTAR0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.IDTIPOIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.SERVICIOSTAR12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.SERVICIOSTAR0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.MONTOIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.BASEIMPOTAR12:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.BASEIMPOTAR0:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.MONTOICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.MONTOIVABIEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.MONTOIVASERVICIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.IDTIPORETENCIONIVABIEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case SriConstantesFunciones.RETENCIONIVABIEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.RETENCIONIVASERVICIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case SriConstantesFunciones.CONDEVOLUCION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case SriConstantesFunciones.IDTIPOMOVIMIENTO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Sri>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Sri();
					entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntitySri("",entity,resultSet);
					
					//entity.setSriOriginal( new Sri());
					//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
					//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseSris(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSri(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Sri>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=SriDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,SriDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Sri> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
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
	
	public  List<Sri> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sri();
      	    	entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySri("",entity,resultSet);
      	    	
				//entity.setSriOriginal( new Sri());
      	    	//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseSris(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarSri(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Sri> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
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
	
	public  List<Sri> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Sri> entities = new  ArrayList<Sri>();
		Sri entity = new Sri();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Sri();
      	    	entity=super.getEntity("",entity,resultSet,SriDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntitySri("",entity,resultSet);
      	    	
				//entity.setSriOriginal( new Sri());
      	    	//entity.setSriOriginal(super.getEntity("",entity.getSriOriginal(),resultSet,SriDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setSriOriginal(this.getEntitySri("",entity.getSriOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseSris(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Sri getEntitySri(String strPrefijo,Sri entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDASIENTOCONTABLE));
				entity.setid_transaccion_conta(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTRANSACCIONCONTA));
				entity.setruc(resultSet.getString(strPrefijo+SriConstantesFunciones.RUC));
				entity.setid_cliente(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDCLIENTE));
				entity.setrazon_social(resultSet.getString(strPrefijo+SriConstantesFunciones.RAZONSOCIAL));
				entity.settipo_comprobante(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPOCOMPROBANTE));
				entity.setes_rise(resultSet.getBoolean(strPrefijo+SriConstantesFunciones.ESRISE));
				entity.setnumero_serie(resultSet.getString(strPrefijo+SriConstantesFunciones.NUMEROSERIE));
				entity.setnumero_autorizacion(resultSet.getString(strPrefijo+SriConstantesFunciones.NUMEROAUTORIZACION));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+SriConstantesFunciones.NUMEROSECUENCIAL));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+SriConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_registro_contable(new Date(resultSet.getDate(strPrefijo+SriConstantesFunciones.FECHAREGISTROCONTABLE).getTime()));
				entity.setfecha_caducidad(new Date(resultSet.getDate(strPrefijo+SriConstantesFunciones.FECHACADUCIDAD).getTime()));
				entity.settipo_tributario(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPOTRIBUTARIO));
				entity.setbienes_tar12(resultSet.getDouble(strPrefijo+SriConstantesFunciones.BIENESTAR12));
				entity.setbienes_tar0(resultSet.getDouble(strPrefijo+SriConstantesFunciones.BIENESTAR0));
				entity.setid_tipo_iva(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPOIVA));
				entity.setservicios_tar12(resultSet.getDouble(strPrefijo+SriConstantesFunciones.SERVICIOSTAR12));
				entity.setservicios_tar0(resultSet.getDouble(strPrefijo+SriConstantesFunciones.SERVICIOSTAR0));
				entity.setmonto_iva(resultSet.getDouble(strPrefijo+SriConstantesFunciones.MONTOIVA));
				entity.setbase_impo_tar12(resultSet.getDouble(strPrefijo+SriConstantesFunciones.BASEIMPOTAR12));
				entity.setbase_impo_tar0(resultSet.getDouble(strPrefijo+SriConstantesFunciones.BASEIMPOTAR0));
				entity.setmonto_ice(resultSet.getDouble(strPrefijo+SriConstantesFunciones.MONTOICE));
				entity.setmonto_iva_bien(resultSet.getDouble(strPrefijo+SriConstantesFunciones.MONTOIVABIEN));
				entity.setmonto_iva_servicio(resultSet.getDouble(strPrefijo+SriConstantesFunciones.MONTOIVASERVICIO));
				entity.setid_tipo_retencion_iva_bien(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPORETENCIONIVABIEN));
				entity.setid_tipo_retencion_iva_servicio(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPORETENCIONIVASERVICIO));
				entity.setretencion_iva_bien(resultSet.getDouble(strPrefijo+SriConstantesFunciones.RETENCIONIVABIEN));
				entity.setretencion_iva_servicio(resultSet.getDouble(strPrefijo+SriConstantesFunciones.RETENCIONIVASERVICIO));
				entity.setcon_devolucion(resultSet.getBoolean(strPrefijo+SriConstantesFunciones.CONDEVOLUCION));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+SriConstantesFunciones.IDTIPOMOVIMIENTO));
			} else {
				entity.setruc(resultSet.getString(strPrefijo+SriConstantesFunciones.RUC));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowSri(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Sri entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=SriDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=SriDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=SriDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=SriDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(SriConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,SriDataAccess.TABLENAME,SriDataAccess.ISWITHSTOREPROCEDURES);
			
			SriDataAccess.setSriOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public AsientoContable getAsientoContable(Connexion connexion,Sri relsri)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relsri.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public TransaccionConta getTransaccionConta(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TransaccionConta transaccionconta= new TransaccionConta();

		try {
			TransaccionContaDataAccess transaccioncontaDataAccess=new TransaccionContaDataAccess();

			transaccioncontaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			transaccioncontaDataAccess.setConnexionType(this.connexionType);
			transaccioncontaDataAccess.setParameterDbType(this.parameterDbType);

			transaccionconta=transaccioncontaDataAccess.getEntity(connexion,relsri.getid_transaccion_conta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return transaccionconta;

	}

	public Cliente getCliente(Connexion connexion,Sri relsri)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relsri.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoComprobante getTipoComprobante(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoComprobante tipocomprobante= new TipoComprobante();

		try {
			TipoComprobanteDataAccess tipocomprobanteDataAccess=new TipoComprobanteDataAccess();

			tipocomprobanteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocomprobanteDataAccess.setConnexionType(this.connexionType);
			tipocomprobanteDataAccess.setParameterDbType(this.parameterDbType);

			tipocomprobante=tipocomprobanteDataAccess.getEntity(connexion,relsri.gettipo_comprobante());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocomprobante;

	}

	public TipoTributario getTipoTributario(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoTributario tipotributario= new TipoTributario();

		try {
			TipoTributarioDataAccess tipotributarioDataAccess=new TipoTributarioDataAccess();

			tipotributarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipotributarioDataAccess.setConnexionType(this.connexionType);
			tipotributarioDataAccess.setParameterDbType(this.parameterDbType);

			tipotributario=tipotributarioDataAccess.getEntity(connexion,relsri.gettipo_tributario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipotributario;

	}

	public TipoIva getTipoIva(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoIva tipoiva= new TipoIva();

		try {
			TipoIvaDataAccess tipoivaDataAccess=new TipoIvaDataAccess();

			tipoivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoivaDataAccess.setConnexionType(this.connexionType);
			tipoivaDataAccess.setParameterDbType(this.parameterDbType);

			tipoiva=tipoivaDataAccess.getEntity(connexion,relsri.getid_tipo_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoiva;

	}

	public TipoRetencionIva getTipoRetencionIvaBien(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoRetencionIva tiporetencioniva= new TipoRetencionIva();

		try {
			TipoRetencionIvaDataAccess tiporetencionivaDataAccess=new TipoRetencionIvaDataAccess();

			tiporetencionivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,relsri.getid_tipo_retencion_iva_bien());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencioniva;

	}

	public TipoRetencionIva getTipoRetencionIvaServicio(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoRetencionIva tiporetencioniva= new TipoRetencionIva();

		try {
			TipoRetencionIvaDataAccess tiporetencionivaDataAccess=new TipoRetencionIvaDataAccess();

			tiporetencionivaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionivaDataAccess.setConnexionType(this.connexionType);
			tiporetencionivaDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencioniva=tiporetencionivaDataAccess.getEntity(connexion,relsri.getid_tipo_retencion_iva_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencioniva;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,Sri relsri)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relsri.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Sri sri) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!sri.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(sri.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_transaccion_conta=new ParameterValue<Long>();
					parameterMaintenanceValueid_transaccion_conta.setValue(sri.getid_transaccion_conta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_transaccion_conta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(sri.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(sri.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerazon_social=new ParameterValue<String>();
					parameterMaintenanceValuerazon_social.setValue(sri.getrazon_social());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerazon_social);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuetipo_comprobante=new ParameterValue<Long>();
					parameterMaintenanceValuetipo_comprobante.setValue(sri.gettipo_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_rise=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_rise.setValue(sri.getes_rise());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_rise);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_serie=new ParameterValue<String>();
					parameterMaintenanceValuenumero_serie.setValue(sri.getnumero_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_autorizacion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_autorizacion.setValue(sri.getnumero_autorizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_autorizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(sri.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(sri.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_registro_contable=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_registro_contable.setValue(sri.getfecha_registro_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_registro_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_caducidad=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_caducidad.setValue(sri.getfecha_caducidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_caducidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValuetipo_tributario=new ParameterValue<Long>();
					parameterMaintenanceValuetipo_tributario.setValue(sri.gettipo_tributario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetipo_tributario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_tar12=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_tar12.setValue(sri.getbienes_tar12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_tar12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebienes_tar0=new ParameterValue<Double>();
					parameterMaintenanceValuebienes_tar0.setValue(sri.getbienes_tar0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebienes_tar0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_iva.setValue(sri.getid_tipo_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_tar12=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_tar12.setValue(sri.getservicios_tar12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_tar12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueservicios_tar0=new ParameterValue<Double>();
					parameterMaintenanceValueservicios_tar0.setValue(sri.getservicios_tar0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueservicios_tar0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva.setValue(sri.getmonto_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_impo_tar12=new ParameterValue<Double>();
					parameterMaintenanceValuebase_impo_tar12.setValue(sri.getbase_impo_tar12());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_impo_tar12);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_impo_tar0=new ParameterValue<Double>();
					parameterMaintenanceValuebase_impo_tar0.setValue(sri.getbase_impo_tar0());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_impo_tar0);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_ice=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_ice.setValue(sri.getmonto_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva_bien=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva_bien.setValue(sri.getmonto_iva_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_iva_servicio=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_iva_servicio.setValue(sri.getmonto_iva_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_iva_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva_bien=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva_bien.setValue(sri.getid_tipo_retencion_iva_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion_iva_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion_iva_servicio.setValue(sri.getid_tipo_retencion_iva_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion_iva_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion_iva_bien=new ParameterValue<Double>();
					parameterMaintenanceValueretencion_iva_bien.setValue(sri.getretencion_iva_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion_iva_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueretencion_iva_servicio=new ParameterValue<Double>();
					parameterMaintenanceValueretencion_iva_servicio.setValue(sri.getretencion_iva_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueretencion_iva_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_devolucion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_devolucion.setValue(sri.getcon_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(sri.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
						if(!sri.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(sri.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(sri.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(sri.getId());
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
	
	public void setIsNewIsChangedFalseSri(Sri sri)throws Exception  {		
		sri.setIsNew(false);
		sri.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseSris(List<Sri> sris)throws Exception  {				
		for(Sri sri:sris) {
			sri.setIsNew(false);
			sri.setIsChanged(false);
		}
	}
	
	public void generarExportarSri(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
