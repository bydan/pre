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
package com.bydan.erp.sris.business.dataaccess;

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

import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.sris.util.*;//RetencionVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class RetencionVentaDataAccess extends  RetencionVentaDataAccessAdditional{ //RetencionVentaDataAccessAdditional,DataAccessHelper<RetencionVenta>
	//static Logger logger = Logger.getLogger(RetencionVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="retencion_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_periodo_declara,id_tipo_retencion,ruc,numero_retencion,base_imponible,porcentaje,valor,es_debito)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_periodo_declara=?,id_tipo_retencion=?,ruc=?,numero_retencion=?,base_imponible=?,porcentaje=?,valor=?,es_debito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select retencionventa from "+RetencionVentaConstantesFunciones.SPERSISTENCENAME+" retencionventa";
	public static String QUERYSELECTNATIVE="select "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".version_row,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_empresa,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_periodo_declara,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id_tipo_retencion,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".ruc,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".numero_retencion,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".base_imponible,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".porcentaje,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".valor,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".es_debito from "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME;//+" as "+RetencionVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".id,"+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+".version_row from "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME;//+" as "+RetencionVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+RetencionVentaConstantesFunciones.SCHEMA+"."+RetencionVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_periodo_declara=?,id_tipo_retencion=?,ruc=?,numero_retencion=?,base_imponible=?,porcentaje=?,valor=?,es_debito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_RETENCIONVENTA_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_RETENCIONVENTA_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_RETENCIONVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_RETENCIONVENTA_SELECT(?,?)";
	
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
	
	
	protected RetencionVentaDataAccessAdditional retencionventaDataAccessAdditional=null;
	
	public RetencionVentaDataAccessAdditional getRetencionVentaDataAccessAdditional() {
		return this.retencionventaDataAccessAdditional;
	}
	
	public void setRetencionVentaDataAccessAdditional(RetencionVentaDataAccessAdditional retencionventaDataAccessAdditional) {
		try {
			this.retencionventaDataAccessAdditional=retencionventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public RetencionVentaDataAccess() {
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
		RetencionVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		RetencionVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		RetencionVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setRetencionVentaOriginal(RetencionVenta retencionventa)throws Exception  {
		retencionventa.setRetencionVentaOriginal((RetencionVenta)retencionventa.clone());		
	}
	
	public void setRetencionVentasOriginal(List<RetencionVenta> retencionventas)throws Exception  {
		
		for(RetencionVenta retencionventa:retencionventas){
			retencionventa.setRetencionVentaOriginal((RetencionVenta)retencionventa.clone());
		}
	}
	
	public static void setRetencionVentaOriginalStatic(RetencionVenta retencionventa)throws Exception  {
		retencionventa.setRetencionVentaOriginal((RetencionVenta)retencionventa.clone());		
	}
	
	public static void setRetencionVentasOriginalStatic(List<RetencionVenta> retencionventas)throws Exception  {
		
		for(RetencionVenta retencionventa:retencionventas){
			retencionventa.setRetencionVentaOriginal((RetencionVenta)retencionventa.clone());
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
	
	public  RetencionVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();		
		
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
	
	public  RetencionVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Sris.RetencionVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setRetencionVentaOriginal(new RetencionVenta());
      	    	entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRetencionVenta("",entity,resultSet); 
				
				//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseRetencionVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  RetencionVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();
				
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
	
	public  RetencionVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RetencionVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.RetencionVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setRetencionVentaOriginal(new RetencionVenta());
      	    	entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityRetencionVenta("",entity,resultSet);    
				
				//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseRetencionVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //RetencionVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		RetencionVenta entity = new RetencionVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RetencionVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Sris.RetencionVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseRetencionVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<RetencionVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		
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
	
	public  List<RetencionVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RetencionVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionVenta();
      	    	entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRetencionVenta("",entity,resultSet);
      	    	
				//entity.setRetencionVentaOriginal( new RetencionVenta());
      	    	//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRetencionVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRetencionVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RetencionVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
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
	
	public  List<RetencionVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapRetencionVenta();
					//entity.setMapRetencionVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapRetencionVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRetencionVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
					entity=RetencionVentaDataAccess.getEntityRetencionVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRetencionVentaOriginal( new RetencionVenta());
					////entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRetencionVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRetencionVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public RetencionVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();		  
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
	
	public  RetencionVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapRetencionVenta();
					//entity.setMapRetencionVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapRetencionVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapRetencionVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
					entity=RetencionVentaDataAccess.getEntityRetencionVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setRetencionVentaOriginal( new RetencionVenta());
					////entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseRetencionVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRetencionVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static RetencionVenta getEntityRetencionVenta(String strPrefijo,RetencionVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = RetencionVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = RetencionVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					RetencionVentaDataAccess.setFieldReflectionRetencionVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasRetencionVenta=RetencionVentaConstantesFunciones.getTodosTiposColumnasRetencionVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasRetencionVenta) {
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
							field = RetencionVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = RetencionVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						RetencionVentaDataAccess.setFieldReflectionRetencionVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionRetencionVenta(Field field,String strPrefijo,String sColumn,RetencionVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case RetencionVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.IDPERIODODECLARA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.IDTIPORETENCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.NUMERORETENCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.BASEIMPONIBLE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case RetencionVentaConstantesFunciones.ESDEBITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RetencionVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RetencionVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new RetencionVenta();
					entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityRetencionVenta("",entity,resultSet);
					
					//entity.setRetencionVentaOriginal( new RetencionVenta());
					//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseRetencionVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRetencionVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<RetencionVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=RetencionVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,RetencionVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<RetencionVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
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
	
	public  List<RetencionVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionVenta();
      	    	entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRetencionVenta("",entity,resultSet);
      	    	
				//entity.setRetencionVentaOriginal( new RetencionVenta());
      	    	//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseRetencionVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarRetencionVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<RetencionVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
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
	
	public  List<RetencionVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<RetencionVenta> entities = new  ArrayList<RetencionVenta>();
		RetencionVenta entity = new RetencionVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new RetencionVenta();
      	    	entity=super.getEntity("",entity,resultSet,RetencionVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityRetencionVenta("",entity,resultSet);
      	    	
				//entity.setRetencionVentaOriginal( new RetencionVenta());
      	    	//entity.setRetencionVentaOriginal(super.getEntity("",entity.getRetencionVentaOriginal(),resultSet,RetencionVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setRetencionVentaOriginal(this.getEntityRetencionVenta("",entity.getRetencionVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseRetencionVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public RetencionVenta getEntityRetencionVenta(String strPrefijo,RetencionVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+RetencionVentaConstantesFunciones.IDEMPRESA));
				entity.setid_periodo_declara(resultSet.getLong(strPrefijo+RetencionVentaConstantesFunciones.IDPERIODODECLARA));
				entity.setid_tipo_retencion(resultSet.getLong(strPrefijo+RetencionVentaConstantesFunciones.IDTIPORETENCION));
				entity.setruc(resultSet.getString(strPrefijo+RetencionVentaConstantesFunciones.RUC));
				entity.setnumero_retencion(resultSet.getString(strPrefijo+RetencionVentaConstantesFunciones.NUMERORETENCION));
				entity.setbase_imponible(resultSet.getDouble(strPrefijo+RetencionVentaConstantesFunciones.BASEIMPONIBLE));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+RetencionVentaConstantesFunciones.PORCENTAJE));
				entity.setvalor(resultSet.getDouble(strPrefijo+RetencionVentaConstantesFunciones.VALOR));
				entity.setes_debito(resultSet.getBoolean(strPrefijo+RetencionVentaConstantesFunciones.ESDEBITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowRetencionVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(RetencionVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=RetencionVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=RetencionVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=RetencionVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=RetencionVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(RetencionVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,RetencionVentaDataAccess.TABLENAME,RetencionVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			RetencionVentaDataAccess.setRetencionVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,RetencionVenta relretencionventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relretencionventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public PeriodoDeclara getPeriodoDeclara(Connexion connexion,RetencionVenta relretencionventa)throws SQLException,Exception {

		PeriodoDeclara periododeclara= new PeriodoDeclara();

		try {
			PeriodoDeclaraDataAccess periododeclaraDataAccess=new PeriodoDeclaraDataAccess();

			periododeclaraDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periododeclaraDataAccess.setConnexionType(this.connexionType);
			periododeclaraDataAccess.setParameterDbType(this.parameterDbType);

			periododeclara=periododeclaraDataAccess.getEntity(connexion,relretencionventa.getid_periodo_declara());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periododeclara;

	}

	public TipoRetencion getTipoRetencion(Connexion connexion,RetencionVenta relretencionventa)throws SQLException,Exception {

		TipoRetencion tiporetencion= new TipoRetencion();

		try {
			TipoRetencionDataAccess tiporetencionDataAccess=new TipoRetencionDataAccess();

			tiporetencionDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tiporetencionDataAccess.setConnexionType(this.connexionType);
			tiporetencionDataAccess.setParameterDbType(this.parameterDbType);

			tiporetencion=tiporetencionDataAccess.getEntity(connexion,relretencionventa.getid_tipo_retencion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tiporetencion;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,RetencionVenta retencionventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!retencionventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(retencionventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo_declara=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo_declara.setValue(retencionventa.getid_periodo_declara());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo_declara);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_retencion=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_retencion.setValue(retencionventa.getid_tipo_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(retencionventa.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_retencion=new ParameterValue<String>();
					parameterMaintenanceValuenumero_retencion.setValue(retencionventa.getnumero_retencion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_retencion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuebase_imponible=new ParameterValue<Double>();
					parameterMaintenanceValuebase_imponible.setValue(retencionventa.getbase_imponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuebase_imponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(retencionventa.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(retencionventa.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_debito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_debito.setValue(retencionventa.getes_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_debito);
					parametersTemp.add(parameterMaintenance);
					
						if(!retencionventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(retencionventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(retencionventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(retencionventa.getId());
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
	
	public void setIsNewIsChangedFalseRetencionVenta(RetencionVenta retencionventa)throws Exception  {		
		retencionventa.setIsNew(false);
		retencionventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseRetencionVentas(List<RetencionVenta> retencionventas)throws Exception  {				
		for(RetencionVenta retencionventa:retencionventas) {
			retencionventa.setIsNew(false);
			retencionventa.setIsChanged(false);
		}
	}
	
	public void generarExportarRetencionVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
