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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//ServicioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class ServicioDataAccess extends  ServicioDataAccessAdditional{ //ServicioDataAccessAdditional,DataAccessHelper<Servicio>
	//static Logger logger = Logger.getLogger(ServicioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="servicio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_tipo_servicio,codigo,nombre,iva,ice,es_bien,id_estado_servicio,descripcion,id_cuenta_contable_gasto,id_cuenta_contable_fiscal,id_cuenta_contable_fiscal2,id_cuenta_contable_retencion,id_cuenta_contable_retencion2,id_cuenta_contable_iva,id_cuenta_contable_iva2,id_cuenta_contable_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_servicio=?,codigo=?,nombre=?,iva=?,ice=?,es_bien=?,id_estado_servicio=?,descripcion=?,id_cuenta_contable_gasto=?,id_cuenta_contable_fiscal=?,id_cuenta_contable_fiscal2=?,id_cuenta_contable_retencion=?,id_cuenta_contable_retencion2=?,id_cuenta_contable_iva=?,id_cuenta_contable_iva2=?,id_cuenta_contable_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select servicio from "+ServicioConstantesFunciones.SPERSISTENCENAME+" servicio";
	public static String QUERYSELECTNATIVE="select "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".version_row,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_empresa,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_tipo_servicio,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".codigo,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".nombre,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".iva,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".ice,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".es_bien,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_estado_servicio,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".descripcion,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_gasto,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_fiscal2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_retencion2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_iva,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_iva2,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id_cuenta_contable_credito from "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME;//+" as "+ServicioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".id,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".version_row,"+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+".codigo from "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME;//+" as "+ServicioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ServicioConstantesFunciones.SCHEMA+"."+ServicioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_tipo_servicio=?,codigo=?,nombre=?,iva=?,ice=?,es_bien=?,id_estado_servicio=?,descripcion=?,id_cuenta_contable_gasto=?,id_cuenta_contable_fiscal=?,id_cuenta_contable_fiscal2=?,id_cuenta_contable_retencion=?,id_cuenta_contable_retencion2=?,id_cuenta_contable_iva=?,id_cuenta_contable_iva2=?,id_cuenta_contable_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_SERVICIO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_SERVICIO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_SERVICIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_SERVICIO_SELECT(?,?)";
	
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
	
	
	protected ServicioDataAccessAdditional servicioDataAccessAdditional=null;
	
	public ServicioDataAccessAdditional getServicioDataAccessAdditional() {
		return this.servicioDataAccessAdditional;
	}
	
	public void setServicioDataAccessAdditional(ServicioDataAccessAdditional servicioDataAccessAdditional) {
		try {
			this.servicioDataAccessAdditional=servicioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ServicioDataAccess() {
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
		ServicioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ServicioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ServicioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setServicioOriginal(Servicio servicio)throws Exception  {
		servicio.setServicioOriginal((Servicio)servicio.clone());		
	}
	
	public void setServiciosOriginal(List<Servicio> servicios)throws Exception  {
		
		for(Servicio servicio:servicios){
			servicio.setServicioOriginal((Servicio)servicio.clone());
		}
	}
	
	public static void setServicioOriginalStatic(Servicio servicio)throws Exception  {
		servicio.setServicioOriginal((Servicio)servicio.clone());		
	}
	
	public static void setServiciosOriginalStatic(List<Servicio> servicios)throws Exception  {
		
		for(Servicio servicio:servicios){
			servicio.setServicioOriginal((Servicio)servicio.clone());
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
	
	public  Servicio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Servicio entity = new Servicio();		
		
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
	
	public  Servicio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Servicio entity = new Servicio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Servicio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setServicioOriginal(new Servicio());
      	    	entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityServicio("",entity,resultSet); 
				
				//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseServicio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Servicio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Servicio entity = new Servicio();
				
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
	
	public  Servicio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Servicio entity = new Servicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Servicio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setServicioOriginal(new Servicio());
      	    	entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityServicio("",entity,resultSet);    
				
				//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Servicio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Servicio entity = new Servicio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Servicio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseServicio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Servicio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		
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
	
	public  List<Servicio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Servicio();
      	    	entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicio("",entity,resultSet);
      	    	
				//entity.setServicioOriginal( new Servicio());
      	    	//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Servicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
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
	
	public  List<Servicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Servicio();
				
				if(conMapGenerico) {
					entity.inicializarMapServicio();
					//entity.setMapServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
					entity=ServicioDataAccess.getEntityServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setServicioOriginal( new Servicio());
					////entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Servicio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Servicio entity = new Servicio();		  
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
	
	public  Servicio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Servicio entity = new Servicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Servicio();
				
				if(conMapGenerico) {
					entity.inicializarMapServicio();
					//entity.setMapServicio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapServicioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapServicio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
					entity=ServicioDataAccess.getEntityServicio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setServicioOriginal( new Servicio());
					////entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
					////entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseServicio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Servicio getEntityServicio(String strPrefijo,Servicio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Servicio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Servicio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ServicioDataAccess.setFieldReflectionServicio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasServicio=ServicioConstantesFunciones.getTodosTiposColumnasServicio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasServicio) {
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
							field = Servicio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Servicio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ServicioDataAccess.setFieldReflectionServicio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionServicio(Field field,String strPrefijo,String sColumn,Servicio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ServicioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDTIPOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ServicioConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ServicioConstantesFunciones.ESBIEN:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDESTADOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLEGASTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLERETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLEIVA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLEIVA2:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ServicioConstantesFunciones.IDCUENTACONTABLECREDITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Servicio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Servicio();
					entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityServicio("",entity,resultSet);
					
					//entity.setServicioOriginal( new Servicio());
					//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
					//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseServicios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Servicio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ServicioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ServicioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Servicio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
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
	
	public  List<Servicio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Servicio();
      	    	entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicio("",entity,resultSet);
      	    	
				//entity.setServicioOriginal( new Servicio());
      	    	//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseServicios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarServicio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Servicio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
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
	
	public  List<Servicio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Servicio> entities = new  ArrayList<Servicio>();
		Servicio entity = new Servicio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Servicio();
      	    	entity=super.getEntity("",entity,resultSet,ServicioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityServicio("",entity,resultSet);
      	    	
				//entity.setServicioOriginal( new Servicio());
      	    	//entity.setServicioOriginal(super.getEntity("",entity.getServicioOriginal(),resultSet,ServicioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setServicioOriginal(this.getEntityServicio("",entity.getServicioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseServicios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Servicio getEntityServicio(String strPrefijo,Servicio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDEMPRESA));
				entity.setid_tipo_servicio(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDTIPOSERVICIO));
				entity.setcodigo(resultSet.getString(strPrefijo+ServicioConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+ServicioConstantesFunciones.NOMBRE));
				entity.setiva(resultSet.getDouble(strPrefijo+ServicioConstantesFunciones.IVA));
				entity.setice(resultSet.getDouble(strPrefijo+ServicioConstantesFunciones.ICE));
				entity.setes_bien(resultSet.getBoolean(strPrefijo+ServicioConstantesFunciones.ESBIEN));
				entity.setid_estado_servicio(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDESTADOSERVICIO));
				entity.setdescripcion(resultSet.getString(strPrefijo+ServicioConstantesFunciones.DESCRIPCION));
				entity.setid_cuenta_contable_gasto(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLEGASTO));
				entity.setid_cuenta_contable_fiscal(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL));
				entity.setid_cuenta_contable_fiscal2(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLEFISCAL2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_fiscal2(null); }
				entity.setid_cuenta_contable_retencion(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLERETENCION));
				entity.setid_cuenta_contable_retencion2(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLERETENCION2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_retencion2(null); }
				entity.setid_cuenta_contable_iva(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLEIVA));
				entity.setid_cuenta_contable_iva2(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLEIVA2));if(resultSet.wasNull()) {entity.setid_cuenta_contable_iva2(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+ServicioConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+ServicioConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowServicio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Servicio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ServicioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ServicioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ServicioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ServicioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ServicioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ServicioDataAccess.TABLENAME,ServicioDataAccess.ISWITHSTOREPROCEDURES);
			
			ServicioDataAccess.setServicioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relservicio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public TipoServicio getTipoServicio(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		TipoServicio tiposervicio= new TipoServicio();

		try {
			TipoServicioDataAccess tiposervicioDataAccess=new TipoServicioDataAccess();

			tiposervicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiposervicioDataAccess.setConnexionType(this.connexionType);
			tiposervicioDataAccess.setParameterDbType(this.parameterDbType);

			tiposervicio=tiposervicioDataAccess.getEntity(connexion,relservicio.getid_tipo_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiposervicio;

	}

	public EstadoServicio getEstadoServicio(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		EstadoServicio estadoservicio= new EstadoServicio();

		try {
			EstadoServicioDataAccess estadoservicioDataAccess=new EstadoServicioDataAccess();

			estadoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadoservicioDataAccess.setConnexionType(this.connexionType);
			estadoservicioDataAccess.setParameterDbType(this.parameterDbType);

			estadoservicio=estadoservicioDataAccess.getEntity(connexion,relservicio.getid_estado_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadoservicio;

	}

	public CuentaContable getCuentaContableGasto(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_gasto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFiscal(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_fiscal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableFiscal2(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_fiscal2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableRetencion(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableRetencion2(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_retencion2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIva(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_iva());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIva2(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_iva2());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,Servicio relservicio)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relservicio.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
		public List<ParametroGenerico> getParametroGenericos(Connexion connexion,Servicio servicio)throws SQLException,Exception {

		List<ParametroGenerico> parametrogenericos= new ArrayList<ParametroGenerico>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ServicioConstantesFunciones.SCHEMA+".servicio ON "+ParametroGenericoConstantesFunciones.SCHEMA+".parametro_generico.id_servicio="+ServicioConstantesFunciones.SCHEMA+".servicio.id WHERE "+ServicioConstantesFunciones.SCHEMA+".servicio.id="+String.valueOf(servicio.getId());
			} else {
				sQuery=" INNER JOIN parametrogenerico.Servicio WHERE parametrogenerico.Servicio.id="+String.valueOf(servicio.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroGenericoDataAccess parametrogenericoDataAccess=new ParametroGenericoDataAccess();

			parametrogenericoDataAccess.setConnexionType(this.connexionType);
			parametrogenericoDataAccess.setParameterDbType(this.parameterDbType);
			parametrogenericos=parametrogenericoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametrogenericos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Servicio servicio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!servicio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(servicio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_servicio.setValue(servicio.getid_tipo_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(servicio.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(servicio.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(servicio.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(servicio.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_bien=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_bien.setValue(servicio.getes_bien());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_bien);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_servicio.setValue(servicio.getid_estado_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(servicio.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_gasto=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_gasto.setValue(servicio.getid_cuenta_contable_gasto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_gasto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_fiscal=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_fiscal.setValue(servicio.getid_cuenta_contable_fiscal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_fiscal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_fiscal2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_fiscal2.setValue(servicio.getid_cuenta_contable_fiscal2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_fiscal2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_retencion.setValue(servicio.getid_cuenta_contable_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_retencion2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_retencion2.setValue(servicio.getid_cuenta_contable_retencion2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_retencion2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva.setValue(servicio.getid_cuenta_contable_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_iva2=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_iva2.setValue(servicio.getid_cuenta_contable_iva2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_iva2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(servicio.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!servicio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(servicio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(servicio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(servicio.getId());
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
	
	public void setIsNewIsChangedFalseServicio(Servicio servicio)throws Exception  {		
		servicio.setIsNew(false);
		servicio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseServicios(List<Servicio> servicios)throws Exception  {				
		for(Servicio servicio:servicios) {
			servicio.setIsNew(false);
			servicio.setIsChanged(false);
		}
	}
	
	public void generarExportarServicio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
