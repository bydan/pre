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
import com.bydan.erp.inventario.util.*;//TipoProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;




@SuppressWarnings("unused")
final public class TipoProductoDataAccess extends  TipoProductoDataAccessAdditional{ //TipoProductoDataAccessAdditional,DataAccessHelper<TipoProducto>
	//static Logger logger = Logger.getLogger(TipoProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tipo_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,codigo,nombre,descripcion)values(current_timestamp,?,?,?,?)";
	public static String QUERYUPDATE="update "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tipoproducto from "+TipoProductoConstantesFunciones.SPERSISTENCENAME+" tipoproducto";
	public static String QUERYSELECTNATIVE="select "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".id,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".version_row,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".id_empresa,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".codigo,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".nombre,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".descripcion from "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME;//+" as "+TipoProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".id,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".version_row,"+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+".codigo from "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME;//+" as "+TipoProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TipoProductoConstantesFunciones.SCHEMA+"."+TipoProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,codigo=?,nombre=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TIPOPRODUCTO_INSERT(?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TIPOPRODUCTO_UPDATE(?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TIPOPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TIPOPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected TipoProductoDataAccessAdditional tipoproductoDataAccessAdditional=null;
	
	public TipoProductoDataAccessAdditional getTipoProductoDataAccessAdditional() {
		return this.tipoproductoDataAccessAdditional;
	}
	
	public void setTipoProductoDataAccessAdditional(TipoProductoDataAccessAdditional tipoproductoDataAccessAdditional) {
		try {
			this.tipoproductoDataAccessAdditional=tipoproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TipoProductoDataAccess() {
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
		TipoProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TipoProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TipoProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTipoProductoOriginal(TipoProducto tipoproducto)throws Exception  {
		tipoproducto.setTipoProductoOriginal((TipoProducto)tipoproducto.clone());		
	}
	
	public void setTipoProductosOriginal(List<TipoProducto> tipoproductos)throws Exception  {
		
		for(TipoProducto tipoproducto:tipoproductos){
			tipoproducto.setTipoProductoOriginal((TipoProducto)tipoproducto.clone());
		}
	}
	
	public static void setTipoProductoOriginalStatic(TipoProducto tipoproducto)throws Exception  {
		tipoproducto.setTipoProductoOriginal((TipoProducto)tipoproducto.clone());		
	}
	
	public static void setTipoProductosOriginalStatic(List<TipoProducto> tipoproductos)throws Exception  {
		
		for(TipoProducto tipoproducto:tipoproductos){
			tipoproducto.setTipoProductoOriginal((TipoProducto)tipoproducto.clone());
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
	
	public  TipoProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();		
		
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
	
	public  TipoProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.TipoProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTipoProductoOriginal(new TipoProducto());
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProducto("",entity,resultSet); 
				
				//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TipoProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();
				
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
	
	public  TipoProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTipoProductoOriginal(new TipoProducto());
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTipoProducto("",entity,resultSet);    
				
				//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTipoProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TipoProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TipoProducto entity = new TipoProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.TipoProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTipoProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TipoProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		
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
	
	public  List<TipoProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProducto();
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProducto("",entity,resultSet);
      	    	
				//entity.setTipoProductoOriginal( new TipoProducto());
      	    	//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
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
	
	public  List<TipoProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProducto();
					//entity.setMapTipoProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTipoProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
					entity=TipoProductoDataAccess.getEntityTipoProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProductoOriginal( new TipoProducto());
					////entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TipoProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();		  
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
	
	public  TipoProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapTipoProducto();
					//entity.setMapTipoProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTipoProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTipoProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
					entity=TipoProductoDataAccess.getEntityTipoProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTipoProductoOriginal( new TipoProducto());
					////entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTipoProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TipoProducto getEntityTipoProducto(String strPrefijo,TipoProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TipoProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TipoProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TipoProductoDataAccess.setFieldReflectionTipoProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTipoProducto=TipoProductoConstantesFunciones.getTodosTiposColumnasTipoProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTipoProducto) {
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
							field = TipoProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TipoProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TipoProductoDataAccess.setFieldReflectionTipoProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTipoProducto(Field field,String strPrefijo,String sColumn,TipoProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TipoProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TipoProductoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProductoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TipoProductoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TipoProducto();
					entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTipoProducto("",entity,resultSet);
					
					//entity.setTipoProductoOriginal( new TipoProducto());
					//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTipoProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TipoProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TipoProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TipoProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TipoProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
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
	
	public  List<TipoProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProducto();
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProducto("",entity,resultSet);
      	    	
				//entity.setTipoProductoOriginal( new TipoProducto());
      	    	//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTipoProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTipoProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TipoProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
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
	
	public  List<TipoProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TipoProducto> entities = new  ArrayList<TipoProducto>();
		TipoProducto entity = new TipoProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TipoProducto();
      	    	entity=super.getEntity("",entity,resultSet,TipoProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTipoProducto("",entity,resultSet);
      	    	
				//entity.setTipoProductoOriginal( new TipoProducto());
      	    	//entity.setTipoProductoOriginal(super.getEntity("",entity.getTipoProductoOriginal(),resultSet,TipoProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTipoProductoOriginal(this.getEntityTipoProducto("",entity.getTipoProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTipoProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TipoProducto getEntityTipoProducto(String strPrefijo,TipoProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TipoProductoConstantesFunciones.IDEMPRESA));
				entity.setcodigo(resultSet.getString(strPrefijo+TipoProductoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+TipoProductoConstantesFunciones.NOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+TipoProductoConstantesFunciones.DESCRIPCION));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+TipoProductoConstantesFunciones.CODIGO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTipoProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TipoProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TipoProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TipoProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TipoProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TipoProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TipoProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TipoProductoDataAccess.TABLENAME,TipoProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			TipoProductoDataAccess.setTipoProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TipoProducto reltipoproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltipoproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}


		
		public List<ModeloProducto> getModeloProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<ModeloProducto> modeloproductos= new ArrayList<ModeloProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+ModeloProductoConstantesFunciones.SCHEMA+".modelo_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN modeloproducto.TipoProducto WHERE modeloproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ModeloProductoDataAccess modeloproductoDataAccess=new ModeloProductoDataAccess();

			modeloproductoDataAccess.setConnexionType(this.connexionType);
			modeloproductoDataAccess.setParameterDbType(this.parameterDbType);
			modeloproductos=modeloproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modeloproductos;

	}

	public List<MaterialProducto> getMaterialProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<MaterialProducto> materialproductos= new ArrayList<MaterialProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+MaterialProductoConstantesFunciones.SCHEMA+".material_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN materialproducto.TipoProducto WHERE materialproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MaterialProductoDataAccess materialproductoDataAccess=new MaterialProductoDataAccess();

			materialproductoDataAccess.setConnexionType(this.connexionType);
			materialproductoDataAccess.setParameterDbType(this.parameterDbType);
			materialproductos=materialproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return materialproductos;

	}

	public List<MarcaProducto> getMarcaProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<MarcaProducto> marcaproductos= new ArrayList<MarcaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+MarcaProductoConstantesFunciones.SCHEMA+".marca_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN marcaproducto.TipoProducto WHERE marcaproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			MarcaProductoDataAccess marcaproductoDataAccess=new MarcaProductoDataAccess();

			marcaproductoDataAccess.setConnexionType(this.connexionType);
			marcaproductoDataAccess.setParameterDbType(this.parameterDbType);
			marcaproductos=marcaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return marcaproductos;

	}

	public List<SegmentoProducto> getSegmentoProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<SegmentoProducto> segmentoproductos= new ArrayList<SegmentoProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+SegmentoProductoConstantesFunciones.SCHEMA+".segmento_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN segmentoproducto.TipoProducto WHERE segmentoproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SegmentoProductoDataAccess segmentoproductoDataAccess=new SegmentoProductoDataAccess();

			segmentoproductoDataAccess.setConnexionType(this.connexionType);
			segmentoproductoDataAccess.setParameterDbType(this.parameterDbType);
			segmentoproductos=segmentoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return segmentoproductos;

	}

	public List<ColorProducto> getColorProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<ColorProducto> colorproductos= new ArrayList<ColorProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+ColorProductoConstantesFunciones.SCHEMA+".color_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN colorproducto.TipoProducto WHERE colorproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ColorProductoDataAccess colorproductoDataAccess=new ColorProductoDataAccess();

			colorproductoDataAccess.setConnexionType(this.connexionType);
			colorproductoDataAccess.setParameterDbType(this.parameterDbType);
			colorproductos=colorproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return colorproductos;

	}

	public List<EfectoProducto> getEfectoProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<EfectoProducto> efectoproductos= new ArrayList<EfectoProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+EfectoProductoConstantesFunciones.SCHEMA+".efecto_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN efectoproducto.TipoProducto WHERE efectoproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			EfectoProductoDataAccess efectoproductoDataAccess=new EfectoProductoDataAccess();

			efectoproductoDataAccess.setConnexionType(this.connexionType);
			efectoproductoDataAccess.setParameterDbType(this.parameterDbType);
			efectoproductos=efectoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return efectoproductos;

	}

	public List<TallaProducto> getTallaProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<TallaProducto> tallaproductos= new ArrayList<TallaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+TallaProductoConstantesFunciones.SCHEMA+".talla_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN tallaproducto.TipoProducto WHERE tallaproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			TallaProductoDataAccess tallaproductoDataAccess=new TallaProductoDataAccess();

			tallaproductoDataAccess.setConnexionType(this.connexionType);
			tallaproductoDataAccess.setParameterDbType(this.parameterDbType);
			tallaproductos=tallaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tallaproductos;

	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<ParametroInventarioDefecto> parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+ParametroInventarioDefectoConstantesFunciones.SCHEMA+".parametro_inventario_defecto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN parametroinventariodefecto.TipoProducto WHERE parametroinventariodefecto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroInventarioDefectoDataAccess parametroinventariodefectoDataAccess=new ParametroInventarioDefectoDataAccess();

			parametroinventariodefectoDataAccess.setConnexionType(this.connexionType);
			parametroinventariodefectoDataAccess.setParameterDbType(this.parameterDbType);
			parametroinventariodefectos=parametroinventariodefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroinventariodefectos;

	}

	public List<ClaseProducto> getClaseProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<ClaseProducto> claseproductos= new ArrayList<ClaseProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+ClaseProductoConstantesFunciones.SCHEMA+".clase_producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN claseproducto.TipoProducto WHERE claseproducto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClaseProductoDataAccess claseproductoDataAccess=new ClaseProductoDataAccess();

			claseproductoDataAccess.setConnexionType(this.connexionType);
			claseproductoDataAccess.setParameterDbType(this.parameterDbType);
			claseproductos=claseproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return claseproductos;

	}

	public List<Producto> getProductos(Connexion connexion,TipoProducto tipoproducto)throws SQLException,Exception {

		List<Producto> productos= new ArrayList<Producto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto ON "+ProductoConstantesFunciones.SCHEMA+".producto.id_tipo_producto="+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id WHERE "+TipoProductoConstantesFunciones.SCHEMA+".tipo_producto.id="+String.valueOf(tipoproducto.getId());
			} else {
				sQuery=" INNER JOIN producto.TipoProducto WHERE producto.TipoProducto.id="+String.valueOf(tipoproducto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);
			productos=productoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TipoProducto tipoproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tipoproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tipoproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(tipoproducto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(tipoproducto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(tipoproducto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!tipoproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tipoproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tipoproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tipoproducto.getId());
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
	
	public void setIsNewIsChangedFalseTipoProducto(TipoProducto tipoproducto)throws Exception  {		
		tipoproducto.setIsNew(false);
		tipoproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTipoProductos(List<TipoProducto> tipoproductos)throws Exception  {				
		for(TipoProducto tipoproducto:tipoproductos) {
			tipoproducto.setIsNew(false);
			tipoproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarTipoProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
