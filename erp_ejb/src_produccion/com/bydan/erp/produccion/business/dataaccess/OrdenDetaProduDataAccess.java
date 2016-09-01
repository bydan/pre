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
package com.bydan.erp.produccion.business.dataaccess;

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

import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.produccion.util.*;//OrdenDetaProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class OrdenDetaProduDataAccess extends  OrdenDetaProduDataAccessAdditional{ //OrdenDetaProduDataAccessAdditional,DataAccessHelper<OrdenDetaProdu>
	//static Logger logger = Logger.getLogger(OrdenDetaProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="orden_deta_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_orden_produ,id_bodega,id_producto,id_unidad,id_bodega_destino,id_tipo_proceso_produ,cantidad,cantidad_pendiente,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_orden_produ=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_destino=?,id_tipo_proceso_produ=?,cantidad=?,cantidad_pendiente=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select ordendetaprodu from "+OrdenDetaProduConstantesFunciones.SPERSISTENCENAME+" ordendetaprodu";
	public static String QUERYSELECTNATIVE="select "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".version_row,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_empresa,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_periodo,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_orden_produ,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_producto,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega_destino,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id_tipo_proceso_produ,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".cantidad,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".cantidad_pendiente,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".descripcion from "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+OrdenDetaProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".id,"+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+".version_row from "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+OrdenDetaProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+OrdenDetaProduConstantesFunciones.SCHEMA+"."+OrdenDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_orden_produ=?,id_bodega=?,id_producto=?,id_unidad=?,id_bodega_destino=?,id_tipo_proceso_produ=?,cantidad=?,cantidad_pendiente=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_ORDENDETAPRODU_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_ORDENDETAPRODU_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_ORDENDETAPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_ORDENDETAPRODU_SELECT(?,?)";
	
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
	
	
	protected OrdenDetaProduDataAccessAdditional ordendetaproduDataAccessAdditional=null;
	
	public OrdenDetaProduDataAccessAdditional getOrdenDetaProduDataAccessAdditional() {
		return this.ordendetaproduDataAccessAdditional;
	}
	
	public void setOrdenDetaProduDataAccessAdditional(OrdenDetaProduDataAccessAdditional ordendetaproduDataAccessAdditional) {
		try {
			this.ordendetaproduDataAccessAdditional=ordendetaproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public OrdenDetaProduDataAccess() {
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
		OrdenDetaProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		OrdenDetaProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		OrdenDetaProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setOrdenDetaProduOriginal(OrdenDetaProdu ordendetaprodu)throws Exception  {
		ordendetaprodu.setOrdenDetaProduOriginal((OrdenDetaProdu)ordendetaprodu.clone());		
	}
	
	public void setOrdenDetaProdusOriginal(List<OrdenDetaProdu> ordendetaprodus)throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu:ordendetaprodus){
			ordendetaprodu.setOrdenDetaProduOriginal((OrdenDetaProdu)ordendetaprodu.clone());
		}
	}
	
	public static void setOrdenDetaProduOriginalStatic(OrdenDetaProdu ordendetaprodu)throws Exception  {
		ordendetaprodu.setOrdenDetaProduOriginal((OrdenDetaProdu)ordendetaprodu.clone());		
	}
	
	public static void setOrdenDetaProdusOriginalStatic(List<OrdenDetaProdu> ordendetaprodus)throws Exception  {
		
		for(OrdenDetaProdu ordendetaprodu:ordendetaprodus){
			ordendetaprodu.setOrdenDetaProduOriginal((OrdenDetaProdu)ordendetaprodu.clone());
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
	
	public  OrdenDetaProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();		
		
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
	
	public  OrdenDetaProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.OrdenDetaProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setOrdenDetaProduOriginal(new OrdenDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenDetaProdu("",entity,resultSet); 
				
				//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenDetaProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  OrdenDetaProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();
				
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
	
	public  OrdenDetaProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.OrdenDetaProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setOrdenDetaProduOriginal(new OrdenDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityOrdenDetaProdu("",entity,resultSet);    
				
				//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseOrdenDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //OrdenDetaProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		OrdenDetaProdu entity = new OrdenDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.OrdenDetaProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseOrdenDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<OrdenDetaProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		
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
	
	public  List<OrdenDetaProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
      	    	//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenDetaProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
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
	
	public  List<OrdenDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenDetaProdu();
					//entity.setMapOrdenDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapOrdenDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=OrdenDetaProduDataAccess.getEntityOrdenDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
					////entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenDetaProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public OrdenDetaProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
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
	
	public  OrdenDetaProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapOrdenDetaProdu();
					//entity.setMapOrdenDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapOrdenDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapOrdenDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=OrdenDetaProduDataAccess.getEntityOrdenDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
					////entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseOrdenDetaProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static OrdenDetaProdu getEntityOrdenDetaProdu(String strPrefijo,OrdenDetaProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = OrdenDetaProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = OrdenDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					OrdenDetaProduDataAccess.setFieldReflectionOrdenDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasOrdenDetaProdu=OrdenDetaProduConstantesFunciones.getTodosTiposColumnasOrdenDetaProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasOrdenDetaProdu) {
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
							field = OrdenDetaProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = OrdenDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						OrdenDetaProduDataAccess.setFieldReflectionOrdenDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionOrdenDetaProdu(Field field,String strPrefijo,String sColumn,OrdenDetaProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case OrdenDetaProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDORDENPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDBODEGADESTINO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case OrdenDetaProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenDetaProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new OrdenDetaProdu();
					entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityOrdenDetaProdu("",entity,resultSet);
					
					//entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
					//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseOrdenDetaProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<OrdenDetaProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=OrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,OrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<OrdenDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
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
	
	public  List<OrdenDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
      	    	//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseOrdenDetaProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<OrdenDetaProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
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
	
	public  List<OrdenDetaProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<OrdenDetaProdu> entities = new  ArrayList<OrdenDetaProdu>();
		OrdenDetaProdu entity = new OrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new OrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setOrdenDetaProduOriginal( new OrdenDetaProdu());
      	    	//entity.setOrdenDetaProduOriginal(super.getEntity("",entity.getOrdenDetaProduOriginal(),resultSet,OrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setOrdenDetaProduOriginal(this.getEntityOrdenDetaProdu("",entity.getOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseOrdenDetaProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public OrdenDetaProdu getEntityOrdenDetaProdu(String strPrefijo,OrdenDetaProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDPERIODO));
				entity.setid_orden_produ(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDORDENPRODU));
				entity.setid_bodega(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDUNIDAD));
				entity.setid_bodega_destino(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDBODEGADESTINO));
				entity.setid_tipo_proceso_produ(resultSet.getLong(strPrefijo+OrdenDetaProduConstantesFunciones.IDTIPOPROCESOPRODU));
				entity.setcantidad(resultSet.getInt(strPrefijo+OrdenDetaProduConstantesFunciones.CANTIDAD));
				entity.setcantidad_pendiente(resultSet.getInt(strPrefijo+OrdenDetaProduConstantesFunciones.CANTIDADPENDIENTE));
				entity.setdescripcion(resultSet.getString(strPrefijo+OrdenDetaProduConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowOrdenDetaProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(OrdenDetaProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=OrdenDetaProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=OrdenDetaProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=OrdenDetaProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=OrdenDetaProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(OrdenDetaProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,OrdenDetaProduDataAccess.TABLENAME,OrdenDetaProduDataAccess.ISWITHSTOREPROCEDURES);
			
			OrdenDetaProduDataAccess.setOrdenDetaProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relordendetaprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relordendetaprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relordendetaprodu.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relordendetaprodu.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public OrdenProdu getOrdenProdu(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		OrdenProdu ordenprodu= new OrdenProdu();

		try {
			OrdenProduDataAccess ordenproduDataAccess=new OrdenProduDataAccess();

			ordenproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordenproduDataAccess.setConnexionType(this.connexionType);
			ordenproduDataAccess.setParameterDbType(this.parameterDbType);

			ordenprodu=ordenproduDataAccess.getEntity(connexion,relordendetaprodu.getid_orden_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordenprodu;

	}

	public Bodega getBodega(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relordendetaprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relordendetaprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relordendetaprodu.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Bodega getBodegaDestino(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relordendetaprodu.getid_bodega_destino());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public TipoProcesoProdu getTipoProcesoProdu(Connexion connexion,OrdenDetaProdu relordendetaprodu)throws SQLException,Exception {

		TipoProcesoProdu tipoprocesoprodu= new TipoProcesoProdu();

		try {
			TipoProcesoProduDataAccess tipoprocesoproduDataAccess=new TipoProcesoProduDataAccess();

			tipoprocesoproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprocesoproduDataAccess.setConnexionType(this.connexionType);
			tipoprocesoproduDataAccess.setParameterDbType(this.parameterDbType);

			tipoprocesoprodu=tipoprocesoproduDataAccess.getEntity(connexion,relordendetaprodu.getid_tipo_proceso_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprocesoprodu;

	}


		
		public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastos(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos= new ArrayList<ProductoOrdenDetaProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ ON "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+".producto_orden_deta_produ_gasto.id_orden_deta_produ="+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id WHERE "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id="+String.valueOf(ordendetaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodugasto.OrdenDetaProdu WHERE productoordendetaprodugasto.OrdenDetaProdu.id="+String.valueOf(ordendetaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduGastoDataAccess productoordendetaprodugastoDataAccess=new ProductoOrdenDetaProduGastoDataAccess();

			productoordendetaprodugastoDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodugastos=productoordendetaprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodugastos;

	}

	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMano> productoordendetaprodumanos= new ArrayList<ProductoOrdenDetaProduMano>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ ON "+ProductoOrdenDetaProduManoConstantesFunciones.SCHEMA+".producto_orden_deta_produ_mano.id_orden_deta_produ="+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id WHERE "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id="+String.valueOf(ordendetaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumano.OrdenDetaProdu WHERE productoordendetaprodumano.OrdenDetaProdu.id="+String.valueOf(ordendetaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduManoDataAccess productoordendetaprodumanoDataAccess=new ProductoOrdenDetaProduManoDataAccess();

			productoordendetaprodumanoDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumanos=productoordendetaprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumanos;

	}

	public List<ProductoOrdenDetaProdu> getProductoOrdenDetaProdus(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProdu> productoordendetaprodus= new ArrayList<ProductoOrdenDetaProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ ON "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+".producto_orden_deta_produ.id_orden_deta_produ="+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id WHERE "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id="+String.valueOf(ordendetaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodu.OrdenDetaProdu WHERE productoordendetaprodu.OrdenDetaProdu.id="+String.valueOf(ordendetaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduDataAccess productoordendetaproduDataAccess=new ProductoOrdenDetaProduDataAccess();

			productoordendetaproduDataAccess.setConnexionType(this.connexionType);
			productoordendetaproduDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodus=productoordendetaproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodus;

	}

	public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ ON "+ProductoOrdenDetaProduMaquinaConstantesFunciones.SCHEMA+".producto_orden_deta_produ_maquina.id_orden_deta_produ="+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id WHERE "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id="+String.valueOf(ordendetaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumaquina.OrdenDetaProdu WHERE productoordendetaprodumaquina.OrdenDetaProdu.id="+String.valueOf(ordendetaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduMaquinaDataAccess productoordendetaprodumaquinaDataAccess=new ProductoOrdenDetaProduMaquinaDataAccess();

			productoordendetaprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumaquinas=productoordendetaprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumaquinas;

	}

	public List<ProductoOrdenDetaProduMerma> getProductoOrdenDetaProduMermas(Connexion connexion,OrdenDetaProdu ordendetaprodu)throws SQLException,Exception {

		List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas= new ArrayList<ProductoOrdenDetaProduMerma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ ON "+ProductoOrdenDetaProduMermaConstantesFunciones.SCHEMA+".producto_orden_deta_produ_merma.id_orden_deta_produ="+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id WHERE "+OrdenDetaProduConstantesFunciones.SCHEMA+".orden_deta_produ.id="+String.valueOf(ordendetaprodu.getId());
			} else {
				sQuery=" INNER JOIN productoordendetaprodumerma.OrdenDetaProdu WHERE productoordendetaprodumerma.OrdenDetaProdu.id="+String.valueOf(ordendetaprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoOrdenDetaProduMermaDataAccess productoordendetaprodumermaDataAccess=new ProductoOrdenDetaProduMermaDataAccess();

			productoordendetaprodumermaDataAccess.setConnexionType(this.connexionType);
			productoordendetaprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			productoordendetaprodumermas=productoordendetaprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoordendetaprodumermas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,OrdenDetaProdu ordendetaprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!ordendetaprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(ordendetaprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(ordendetaprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(ordendetaprodu.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(ordendetaprodu.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_produ.setValue(ordendetaprodu.getid_orden_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(ordendetaprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(ordendetaprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(ordendetaprodu.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega_destino=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega_destino.setValue(ordendetaprodu.getid_bodega_destino());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega_destino);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_proceso_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_proceso_produ.setValue(ordendetaprodu.getid_tipo_proceso_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_proceso_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(ordendetaprodu.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pendiente=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pendiente.setValue(ordendetaprodu.getcantidad_pendiente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pendiente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(ordendetaprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!ordendetaprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(ordendetaprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(ordendetaprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(ordendetaprodu.getId());
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
	
	public void setIsNewIsChangedFalseOrdenDetaProdu(OrdenDetaProdu ordendetaprodu)throws Exception  {		
		ordendetaprodu.setIsNew(false);
		ordendetaprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus)throws Exception  {				
		for(OrdenDetaProdu ordendetaprodu:ordendetaprodus) {
			ordendetaprodu.setIsNew(false);
			ordendetaprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarOrdenDetaProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
