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
import com.bydan.erp.inventario.util.*;//UtilidadTipoPrecioConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class UtilidadTipoPrecioDataAccess extends  UtilidadTipoPrecioDataAccessAdditional{ //UtilidadTipoPrecioDataAccessAdditional,DataAccessHelper<UtilidadTipoPrecio>
	//static Logger logger = Logger.getLogger(UtilidadTipoPrecioDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="utilidad_tipo_precio";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_tipo_precio,porcentaje)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_precio=?,porcentaje=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select utilidadtipoprecio from "+UtilidadTipoPrecioConstantesFunciones.SPERSISTENCENAME+" utilidadtipoprecio";
	public static String QUERYSELECTNATIVE="select "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".version_row,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_empresa,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_sucursal,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id_tipo_precio,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".porcentaje from "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME;//+" as "+UtilidadTipoPrecioConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".id,"+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+".version_row from "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME;//+" as "+UtilidadTipoPrecioConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+UtilidadTipoPrecioConstantesFunciones.SCHEMA+"."+UtilidadTipoPrecioConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_tipo_precio=?,porcentaje=?";
	
	public static String STOREPROCEDUREINSERT="call SP_UTILIDADTIPOPRECIO_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_UTILIDADTIPOPRECIO_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_UTILIDADTIPOPRECIO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_UTILIDADTIPOPRECIO_SELECT(?,?)";
	
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
	
	
	protected UtilidadTipoPrecioDataAccessAdditional utilidadtipoprecioDataAccessAdditional=null;
	
	public UtilidadTipoPrecioDataAccessAdditional getUtilidadTipoPrecioDataAccessAdditional() {
		return this.utilidadtipoprecioDataAccessAdditional;
	}
	
	public void setUtilidadTipoPrecioDataAccessAdditional(UtilidadTipoPrecioDataAccessAdditional utilidadtipoprecioDataAccessAdditional) {
		try {
			this.utilidadtipoprecioDataAccessAdditional=utilidadtipoprecioDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public UtilidadTipoPrecioDataAccess() {
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
		UtilidadTipoPrecioDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		UtilidadTipoPrecioDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		UtilidadTipoPrecioDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setUtilidadTipoPrecioOriginal(UtilidadTipoPrecio utilidadtipoprecio)throws Exception  {
		utilidadtipoprecio.setUtilidadTipoPrecioOriginal((UtilidadTipoPrecio)utilidadtipoprecio.clone());		
	}
	
	public void setUtilidadTipoPreciosOriginal(List<UtilidadTipoPrecio> utilidadtipoprecios)throws Exception  {
		
		for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios){
			utilidadtipoprecio.setUtilidadTipoPrecioOriginal((UtilidadTipoPrecio)utilidadtipoprecio.clone());
		}
	}
	
	public static void setUtilidadTipoPrecioOriginalStatic(UtilidadTipoPrecio utilidadtipoprecio)throws Exception  {
		utilidadtipoprecio.setUtilidadTipoPrecioOriginal((UtilidadTipoPrecio)utilidadtipoprecio.clone());		
	}
	
	public static void setUtilidadTipoPreciosOriginalStatic(List<UtilidadTipoPrecio> utilidadtipoprecios)throws Exception  {
		
		for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios){
			utilidadtipoprecio.setUtilidadTipoPrecioOriginal((UtilidadTipoPrecio)utilidadtipoprecio.clone());
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
	
	public  UtilidadTipoPrecio getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		
		
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
	
	public  UtilidadTipoPrecio getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.UtilidadTipoPrecio.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setUtilidadTipoPrecioOriginal(new UtilidadTipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet); 
				
				//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseUtilidadTipoPrecio(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  UtilidadTipoPrecio getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();
				
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
	
	public  UtilidadTipoPrecio getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UtilidadTipoPrecio.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setUtilidadTipoPrecioOriginal(new UtilidadTipoPrecio());
      	    	entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet);    
				
				//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseUtilidadTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //UtilidadTipoPrecio
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.UtilidadTipoPrecio.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseUtilidadTipoPrecio(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<UtilidadTipoPrecio> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		
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
	
	public  List<UtilidadTipoPrecio> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet);
      	    	
				//entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
      	    	//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadTipoPrecios(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UtilidadTipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
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
	
	public  List<UtilidadTipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadTipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapUtilidadTipoPrecio();
					//entity.setMapUtilidadTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapUtilidadTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUtilidadTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=UtilidadTipoPrecioDataAccess.getEntityUtilidadTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
					////entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadTipoPrecios(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public UtilidadTipoPrecio getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
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
	
	public  UtilidadTipoPrecio getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadTipoPrecio();
				
				if(conMapGenerico) {
					entity.inicializarMapUtilidadTipoPrecio();
					//entity.setMapUtilidadTipoPrecio(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapUtilidadTipoPrecioValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapUtilidadTipoPrecio().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=UtilidadTipoPrecioDataAccess.getEntityUtilidadTipoPrecio("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
					////entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
					////entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseUtilidadTipoPrecio(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static UtilidadTipoPrecio getEntityUtilidadTipoPrecio(String strPrefijo,UtilidadTipoPrecio entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = UtilidadTipoPrecio.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = UtilidadTipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					UtilidadTipoPrecioDataAccess.setFieldReflectionUtilidadTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasUtilidadTipoPrecio=UtilidadTipoPrecioConstantesFunciones.getTodosTiposColumnasUtilidadTipoPrecio();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasUtilidadTipoPrecio) {
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
							field = UtilidadTipoPrecio.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = UtilidadTipoPrecio.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						UtilidadTipoPrecioDataAccess.setFieldReflectionUtilidadTipoPrecio(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionUtilidadTipoPrecio(Field field,String strPrefijo,String sColumn,UtilidadTipoPrecio entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case UtilidadTipoPrecioConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadTipoPrecioConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case UtilidadTipoPrecioConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case UtilidadTipoPrecioConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UtilidadTipoPrecio>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new UtilidadTipoPrecio();
					entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet);
					
					//entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
					//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
					//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseUtilidadTipoPrecios(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<UtilidadTipoPrecio>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=UtilidadTipoPrecioDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,UtilidadTipoPrecioDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<UtilidadTipoPrecio> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
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
	
	public  List<UtilidadTipoPrecio> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet);
      	    	
				//entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
      	    	//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseUtilidadTipoPrecios(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarUtilidadTipoPrecio(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<UtilidadTipoPrecio> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
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
	
	public  List<UtilidadTipoPrecio> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<UtilidadTipoPrecio> entities = new  ArrayList<UtilidadTipoPrecio>();
		UtilidadTipoPrecio entity = new UtilidadTipoPrecio();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new UtilidadTipoPrecio();
      	    	entity=super.getEntity("",entity,resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityUtilidadTipoPrecio("",entity,resultSet);
      	    	
				//entity.setUtilidadTipoPrecioOriginal( new UtilidadTipoPrecio());
      	    	//entity.setUtilidadTipoPrecioOriginal(super.getEntity("",entity.getUtilidadTipoPrecioOriginal(),resultSet,UtilidadTipoPrecioDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setUtilidadTipoPrecioOriginal(this.getEntityUtilidadTipoPrecio("",entity.getUtilidadTipoPrecioOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseUtilidadTipoPrecios(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public UtilidadTipoPrecio getEntityUtilidadTipoPrecio(String strPrefijo,UtilidadTipoPrecio entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+UtilidadTipoPrecioConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL));
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+UtilidadTipoPrecioConstantesFunciones.PORCENTAJE));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowUtilidadTipoPrecio(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(UtilidadTipoPrecio entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=UtilidadTipoPrecioDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=UtilidadTipoPrecioDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=UtilidadTipoPrecioDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=UtilidadTipoPrecioDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(UtilidadTipoPrecioConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,UtilidadTipoPrecioDataAccess.TABLENAME,UtilidadTipoPrecioDataAccess.ISWITHSTOREPROCEDURES);
			
			UtilidadTipoPrecioDataAccess.setUtilidadTipoPrecioOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,UtilidadTipoPrecio relutilidadtipoprecio)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relutilidadtipoprecio.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,UtilidadTipoPrecio relutilidadtipoprecio)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relutilidadtipoprecio.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,UtilidadTipoPrecio relutilidadtipoprecio)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relutilidadtipoprecio.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,UtilidadTipoPrecio utilidadtipoprecio) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!utilidadtipoprecio.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(utilidadtipoprecio.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(utilidadtipoprecio.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(utilidadtipoprecio.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(utilidadtipoprecio.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
						if(!utilidadtipoprecio.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(utilidadtipoprecio.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(utilidadtipoprecio.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(utilidadtipoprecio.getId());
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
	
	public void setIsNewIsChangedFalseUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio)throws Exception  {		
		utilidadtipoprecio.setIsNew(false);
		utilidadtipoprecio.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseUtilidadTipoPrecios(List<UtilidadTipoPrecio> utilidadtipoprecios)throws Exception  {				
		for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
			utilidadtipoprecio.setIsNew(false);
			utilidadtipoprecio.setIsChanged(false);
		}
	}
	
	public void generarExportarUtilidadTipoPrecio(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
