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
import com.bydan.erp.inventario.util.*;//ProductoReemplaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ProductoReemplaDataAccess extends  ProductoReemplaDataAccessAdditional{ //ProductoReemplaDataAccessAdditional,DataAccessHelper<ProductoReempla>
	//static Logger logger = Logger.getLogger(ProductoReemplaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_reempla";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_producto_reempla,descripcion)values(current_timestamp,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_producto_reempla=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoreempla from "+ProductoReemplaConstantesFunciones.SPERSISTENCENAME+" productoreempla";
	public static String QUERYSELECTNATIVE="select "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".version_row,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_empresa,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_bodega,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_producto,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id_producto_reempla,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".descripcion from "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME;//+" as "+ProductoReemplaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".id,"+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+".version_row from "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME;//+" as "+ProductoReemplaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoReemplaConstantesFunciones.SCHEMA+"."+ProductoReemplaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_producto_reempla=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOREEMPLA_INSERT(?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOREEMPLA_UPDATE(?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOREEMPLA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOREEMPLA_SELECT(?,?)";
	
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
	
	
	protected ProductoReemplaDataAccessAdditional productoreemplaDataAccessAdditional=null;
	
	public ProductoReemplaDataAccessAdditional getProductoReemplaDataAccessAdditional() {
		return this.productoreemplaDataAccessAdditional;
	}
	
	public void setProductoReemplaDataAccessAdditional(ProductoReemplaDataAccessAdditional productoreemplaDataAccessAdditional) {
		try {
			this.productoreemplaDataAccessAdditional=productoreemplaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoReemplaDataAccess() {
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
		ProductoReemplaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoReemplaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoReemplaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoReemplaOriginal(ProductoReempla productoreempla)throws Exception  {
		productoreempla.setProductoReemplaOriginal((ProductoReempla)productoreempla.clone());		
	}
	
	public void setProductoReemplasOriginal(List<ProductoReempla> productoreemplas)throws Exception  {
		
		for(ProductoReempla productoreempla:productoreemplas){
			productoreempla.setProductoReemplaOriginal((ProductoReempla)productoreempla.clone());
		}
	}
	
	public static void setProductoReemplaOriginalStatic(ProductoReempla productoreempla)throws Exception  {
		productoreempla.setProductoReemplaOriginal((ProductoReempla)productoreempla.clone());		
	}
	
	public static void setProductoReemplasOriginalStatic(List<ProductoReempla> productoreemplas)throws Exception  {
		
		for(ProductoReempla productoreempla:productoreemplas){
			productoreempla.setProductoReemplaOriginal((ProductoReempla)productoreempla.clone());
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
	
	public  ProductoReempla getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();		
		
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
	
	public  ProductoReempla getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ProductoReempla.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoReemplaOriginal(new ProductoReempla());
      	    	entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoReempla("",entity,resultSet); 
				
				//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoReempla(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoReempla getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();
				
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
	
	public  ProductoReempla getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoReemplaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoReempla.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoReemplaOriginal(new ProductoReempla());
      	    	entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoReempla("",entity,resultSet);    
				
				//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoReempla(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoReempla
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoReempla entity = new ProductoReempla();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoReemplaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoReempla.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoReempla(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoReempla> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		
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
	
	public  List<ProductoReempla> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoReemplaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoReempla();
      	    	entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoReempla("",entity,resultSet);
      	    	
				//entity.setProductoReemplaOriginal( new ProductoReempla());
      	    	//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoReemplas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoReempla(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoReempla> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
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
	
	public  List<ProductoReempla> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoReempla();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoReempla();
					//entity.setMapProductoReempla(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoReemplaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoReempla().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoReemplaDataAccess.getEntityProductoReempla("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoReemplaOriginal( new ProductoReempla());
					////entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoReemplas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoReempla(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoReempla getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();		  
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
	
	public  ProductoReempla getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoReempla();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoReempla();
					//entity.setMapProductoReempla(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoReemplaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoReempla().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoReemplaDataAccess.getEntityProductoReempla("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoReemplaOriginal( new ProductoReempla());
					////entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoReempla(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoReempla(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoReempla getEntityProductoReempla(String strPrefijo,ProductoReempla entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoReempla.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoReempla.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoReemplaDataAccess.setFieldReflectionProductoReempla(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoReempla=ProductoReemplaConstantesFunciones.getTodosTiposColumnasProductoReempla();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoReempla) {
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
							field = ProductoReempla.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoReempla.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoReemplaDataAccess.setFieldReflectionProductoReempla(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoReempla(Field field,String strPrefijo,String sColumn,ProductoReempla entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoReemplaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoReemplaConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoReempla>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoReemplaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoReempla();
					entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoReempla("",entity,resultSet);
					
					//entity.setProductoReemplaOriginal( new ProductoReempla());
					//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoReemplas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoReempla(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoReempla>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoReemplaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoReemplaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoReempla> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
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
	
	public  List<ProductoReempla> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoReempla();
      	    	entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoReempla("",entity,resultSet);
      	    	
				//entity.setProductoReemplaOriginal( new ProductoReempla());
      	    	//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoReemplas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoReempla(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoReempla> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
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
	
	public  List<ProductoReempla> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoReempla> entities = new  ArrayList<ProductoReempla>();
		ProductoReempla entity = new ProductoReempla();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoReempla();
      	    	entity=super.getEntity("",entity,resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoReempla("",entity,resultSet);
      	    	
				//entity.setProductoReemplaOriginal( new ProductoReempla());
      	    	//entity.setProductoReemplaOriginal(super.getEntity("",entity.getProductoReemplaOriginal(),resultSet,ProductoReemplaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoReemplaOriginal(this.getEntityProductoReempla("",entity.getProductoReemplaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoReemplas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoReempla getEntityProductoReempla(String strPrefijo,ProductoReempla entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProductoReemplaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProductoReemplaConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoReemplaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoReemplaConstantesFunciones.IDPRODUCTO));
				entity.setid_producto_reempla(resultSet.getLong(strPrefijo+ProductoReemplaConstantesFunciones.IDPRODUCTOREEMPLA));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoReemplaConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoReempla(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoReempla entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoReemplaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoReemplaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoReemplaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoReemplaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoReemplaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoReemplaDataAccess.TABLENAME,ProductoReemplaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoReemplaDataAccess.setProductoReemplaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProductoReempla relproductoreempla)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproductoreempla.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductoReempla relproductoreempla)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductoreempla.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductoReempla relproductoreempla)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductoreempla.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoReempla relproductoreempla)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductoreempla.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public ProductoReempla getProductoReempla(Connexion connexion,ProductoReempla relproductoreempla)throws SQLException,Exception {

		ProductoReempla productoreempla= new ProductoReempla();

		try {
			ProductoReemplaDataAccess productoreemplaDataAccess=new ProductoReemplaDataAccess();

			productoreemplaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoreemplaDataAccess.setConnexionType(this.connexionType);
			productoreemplaDataAccess.setParameterDbType(this.parameterDbType);

			productoreempla=productoreemplaDataAccess.getEntity(connexion,relproductoreempla.getid_producto_reempla());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoreempla;

	}


		
		public List<ProductoReempla> getProductoReemplas(Connexion connexion,ProductoReempla productoreempla)throws SQLException,Exception {

		List<ProductoReempla> productoreemplas= new ArrayList<ProductoReempla>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoReemplaConstantesFunciones.SCHEMA+".producto_reempla ON "+ProductoReemplaConstantesFunciones.SCHEMA+".producto_reempla.id_producto_reempla="+ProductoReemplaConstantesFunciones.SCHEMA+".producto_reempla.id WHERE "+ProductoReemplaConstantesFunciones.SCHEMA+".producto_reempla.id="+String.valueOf(productoreempla.getId());
			} else {
				sQuery=" INNER JOIN productoreempla.ProductoReempla WHERE productoreempla.ProductoReempla.id="+String.valueOf(productoreempla.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoReemplaDataAccess productoreemplaDataAccess=new ProductoReemplaDataAccess();

			productoreemplaDataAccess.setConnexionType(this.connexionType);
			productoreemplaDataAccess.setParameterDbType(this.parameterDbType);
			productoreemplas=productoreemplaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoreemplas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoReempla productoreempla) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoreempla.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(productoreempla.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(productoreempla.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productoreempla.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productoreempla.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_reempla=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_reempla.setValue(productoreempla.getid_producto_reempla());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_reempla);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoreempla.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoreempla.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoreempla.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoreempla.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoreempla.getId());
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
	
	public void setIsNewIsChangedFalseProductoReempla(ProductoReempla productoreempla)throws Exception  {		
		productoreempla.setIsNew(false);
		productoreempla.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoReemplas(List<ProductoReempla> productoreemplas)throws Exception  {				
		for(ProductoReempla productoreempla:productoreemplas) {
			productoreempla.setIsNew(false);
			productoreempla.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoReempla(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
