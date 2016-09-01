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
import com.bydan.erp.produccion.util.*;//ProductoDefiProduConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoDefiProduDataAccess extends  ProductoDefiProduDataAccessAdditional{ //ProductoDefiProduDataAccessAdditional,DataAccessHelper<ProductoDefiProdu>
	//static Logger logger = Logger.getLogger(ProductoDefiProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_defi_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,con_genera_sub_productos,descripcion)values(current_timestamp,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,con_genera_sub_productos=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productodefiprodu from "+ProductoDefiProduConstantesFunciones.SPERSISTENCENAME+" productodefiprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".version_row,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_empresa,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".con_genera_sub_productos,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME;//+" as "+ProductoDefiProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".version_row,"+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+".id_producto from "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME;//+" as "+ProductoDefiProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoDefiProduConstantesFunciones.SCHEMA+"."+ProductoDefiProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,con_genera_sub_productos=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTODEFIPRODU_INSERT(?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTODEFIPRODU_UPDATE(?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTODEFIPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTODEFIPRODU_SELECT(?,?)";
	
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
	
	
	protected ProductoDefiProduDataAccessAdditional productodefiproduDataAccessAdditional=null;
	
	public ProductoDefiProduDataAccessAdditional getProductoDefiProduDataAccessAdditional() {
		return this.productodefiproduDataAccessAdditional;
	}
	
	public void setProductoDefiProduDataAccessAdditional(ProductoDefiProduDataAccessAdditional productodefiproduDataAccessAdditional) {
		try {
			this.productodefiproduDataAccessAdditional=productodefiproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoDefiProduDataAccess() {
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
		ProductoDefiProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoDefiProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoDefiProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoDefiProduOriginal(ProductoDefiProdu productodefiprodu)throws Exception  {
		productodefiprodu.setProductoDefiProduOriginal((ProductoDefiProdu)productodefiprodu.clone());		
	}
	
	public void setProductoDefiProdusOriginal(List<ProductoDefiProdu> productodefiprodus)throws Exception  {
		
		for(ProductoDefiProdu productodefiprodu:productodefiprodus){
			productodefiprodu.setProductoDefiProduOriginal((ProductoDefiProdu)productodefiprodu.clone());
		}
	}
	
	public static void setProductoDefiProduOriginalStatic(ProductoDefiProdu productodefiprodu)throws Exception  {
		productodefiprodu.setProductoDefiProduOriginal((ProductoDefiProdu)productodefiprodu.clone());		
	}
	
	public static void setProductoDefiProdusOriginalStatic(List<ProductoDefiProdu> productodefiprodus)throws Exception  {
		
		for(ProductoDefiProdu productodefiprodu:productodefiprodus){
			productodefiprodu.setProductoDefiProduOriginal((ProductoDefiProdu)productodefiprodu.clone());
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
	
	public  ProductoDefiProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();		
		
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
	
	public  ProductoDefiProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoDefiProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoDefiProduOriginal(new ProductoDefiProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoDefiProdu("",entity,resultSet); 
				
				//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoDefiProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoDefiProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();
				
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
	
	public  ProductoDefiProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDefiProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoDefiProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoDefiProduOriginal(new ProductoDefiProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoDefiProdu("",entity,resultSet);    
				
				//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoDefiProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoDefiProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoDefiProdu entity = new ProductoDefiProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDefiProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoDefiProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoDefiProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoDefiProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		
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
	
	public  List<ProductoDefiProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDefiProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoDefiProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoDefiProdu("",entity,resultSet);
      	    	
				//entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
      	    	//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoDefiProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoDefiProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoDefiProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
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
	
	public  List<ProductoDefiProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoDefiProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoDefiProdu();
					//entity.setMapProductoDefiProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoDefiProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoDefiProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoDefiProduDataAccess.getEntityProductoDefiProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
					////entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoDefiProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoDefiProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoDefiProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
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
	
	public  ProductoDefiProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoDefiProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoDefiProdu();
					//entity.setMapProductoDefiProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoDefiProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoDefiProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoDefiProduDataAccess.getEntityProductoDefiProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
					////entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoDefiProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoDefiProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoDefiProdu getEntityProductoDefiProdu(String strPrefijo,ProductoDefiProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoDefiProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoDefiProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoDefiProduDataAccess.setFieldReflectionProductoDefiProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoDefiProdu=ProductoDefiProduConstantesFunciones.getTodosTiposColumnasProductoDefiProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoDefiProdu) {
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
							field = ProductoDefiProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoDefiProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoDefiProduDataAccess.setFieldReflectionProductoDefiProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoDefiProdu(Field field,String strPrefijo,String sColumn,ProductoDefiProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoDefiProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoDefiProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoDefiProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDefiProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoDefiProdu();
					entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoDefiProdu("",entity,resultSet);
					
					//entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
					//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoDefiProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoDefiProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoDefiProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDefiProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDefiProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoDefiProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
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
	
	public  List<ProductoDefiProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoDefiProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoDefiProdu("",entity,resultSet);
      	    	
				//entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
      	    	//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoDefiProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoDefiProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoDefiProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
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
	
	public  List<ProductoDefiProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoDefiProdu> entities = new  ArrayList<ProductoDefiProdu>();
		ProductoDefiProdu entity = new ProductoDefiProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoDefiProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoDefiProdu("",entity,resultSet);
      	    	
				//entity.setProductoDefiProduOriginal( new ProductoDefiProdu());
      	    	//entity.setProductoDefiProduOriginal(super.getEntity("",entity.getProductoDefiProduOriginal(),resultSet,ProductoDefiProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoDefiProduOriginal(this.getEntityProductoDefiProdu("",entity.getProductoDefiProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoDefiProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoDefiProdu getEntityProductoDefiProdu(String strPrefijo,ProductoDefiProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDUNIDAD));
				entity.setcon_genera_sub_productos(resultSet.getBoolean(strPrefijo+ProductoDefiProduConstantesFunciones.CONGENERASUBPRODUCTOS));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoDefiProduConstantesFunciones.DESCRIPCION));
			} else {
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoDefiProduConstantesFunciones.IDPRODUCTO));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoDefiProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoDefiProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoDefiProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoDefiProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoDefiProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoDefiProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoDefiProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoDefiProduDataAccess.TABLENAME,ProductoDefiProduDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoDefiProduDataAccess.setProductoDefiProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProductoDefiProdu relproductodefiprodu)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproductodefiprodu.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductoDefiProdu relproductodefiprodu)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductodefiprodu.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductoDefiProdu relproductodefiprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductodefiprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoDefiProdu relproductodefiprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductodefiprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,ProductoDefiProdu relproductodefiprodu)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductodefiprodu.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
		public List<ProductoProduMano> getProductoProduManos(Connexion connexion,ProductoDefiProdu productodefiprodu)throws SQLException,Exception {

		List<ProductoProduMano> productoprodumanos= new ArrayList<ProductoProduMano>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ ON "+ProductoProduManoConstantesFunciones.SCHEMA+".producto_produ_mano.id_producto_defi_produ="+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id WHERE "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id="+String.valueOf(productodefiprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodumano.ProductoDefiProdu WHERE productoprodumano.ProductoDefiProdu.id="+String.valueOf(productodefiprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduManoDataAccess productoprodumanoDataAccess=new ProductoProduManoDataAccess();

			productoprodumanoDataAccess.setConnexionType(this.connexionType);
			productoprodumanoDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumanos=productoprodumanoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumanos;

	}

	public List<ProductoProduMerma> getProductoProduMermas(Connexion connexion,ProductoDefiProdu productodefiprodu)throws SQLException,Exception {

		List<ProductoProduMerma> productoprodumermas= new ArrayList<ProductoProduMerma>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ ON "+ProductoProduMermaConstantesFunciones.SCHEMA+".producto_produ_merma.id_producto_defi_produ="+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id WHERE "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id="+String.valueOf(productodefiprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodumerma.ProductoDefiProdu WHERE productoprodumerma.ProductoDefiProdu.id="+String.valueOf(productodefiprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduMermaDataAccess productoprodumermaDataAccess=new ProductoProduMermaDataAccess();

			productoprodumermaDataAccess.setConnexionType(this.connexionType);
			productoprodumermaDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumermas=productoprodumermaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumermas;

	}

	public List<ProductoProduGasto> getProductoProduGastos(Connexion connexion,ProductoDefiProdu productodefiprodu)throws SQLException,Exception {

		List<ProductoProduGasto> productoprodugastos= new ArrayList<ProductoProduGasto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ ON "+ProductoProduGastoConstantesFunciones.SCHEMA+".producto_produ_gasto.id_producto_defi_produ="+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id WHERE "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id="+String.valueOf(productodefiprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodugasto.ProductoDefiProdu WHERE productoprodugasto.ProductoDefiProdu.id="+String.valueOf(productodefiprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduGastoDataAccess productoprodugastoDataAccess=new ProductoProduGastoDataAccess();

			productoprodugastoDataAccess.setConnexionType(this.connexionType);
			productoprodugastoDataAccess.setParameterDbType(this.parameterDbType);
			productoprodugastos=productoprodugastoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodugastos;

	}

	public List<ProductoProdu> getProductoProdus(Connexion connexion,ProductoDefiProdu productodefiprodu)throws SQLException,Exception {

		List<ProductoProdu> productoprodus= new ArrayList<ProductoProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ ON "+ProductoProduConstantesFunciones.SCHEMA+".producto_produ.id_producto_defi_produ="+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id WHERE "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id="+String.valueOf(productodefiprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodu.ProductoDefiProdu WHERE productoprodu.ProductoDefiProdu.id="+String.valueOf(productodefiprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduDataAccess productoproduDataAccess=new ProductoProduDataAccess();

			productoproduDataAccess.setConnexionType(this.connexionType);
			productoproduDataAccess.setParameterDbType(this.parameterDbType);
			productoprodus=productoproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodus;

	}

	public List<ProductoProduMaquina> getProductoProduMaquinas(Connexion connexion,ProductoDefiProdu productodefiprodu)throws SQLException,Exception {

		List<ProductoProduMaquina> productoprodumaquinas= new ArrayList<ProductoProduMaquina>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ ON "+ProductoProduMaquinaConstantesFunciones.SCHEMA+".producto_produ_maquina.id_producto_defi_produ="+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id WHERE "+ProductoDefiProduConstantesFunciones.SCHEMA+".producto_defi_produ.id="+String.valueOf(productodefiprodu.getId());
			} else {
				sQuery=" INNER JOIN productoprodumaquina.ProductoDefiProdu WHERE productoprodumaquina.ProductoDefiProdu.id="+String.valueOf(productodefiprodu.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoProduMaquinaDataAccess productoprodumaquinaDataAccess=new ProductoProduMaquinaDataAccess();

			productoprodumaquinaDataAccess.setConnexionType(this.connexionType);
			productoprodumaquinaDataAccess.setParameterDbType(this.parameterDbType);
			productoprodumaquinas=productoprodumaquinaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoprodumaquinas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoDefiProdu productodefiprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productodefiprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(productodefiprodu.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(productodefiprodu.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productodefiprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productodefiprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productodefiprodu.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_genera_sub_productos=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_genera_sub_productos.setValue(productodefiprodu.getcon_genera_sub_productos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_genera_sub_productos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productodefiprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productodefiprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productodefiprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productodefiprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productodefiprodu.getId());
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
	
	public void setIsNewIsChangedFalseProductoDefiProdu(ProductoDefiProdu productodefiprodu)throws Exception  {		
		productodefiprodu.setIsNew(false);
		productodefiprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoDefiProdus(List<ProductoDefiProdu> productodefiprodus)throws Exception  {				
		for(ProductoDefiProdu productodefiprodu:productodefiprodus) {
			productodefiprodu.setIsNew(false);
			productodefiprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoDefiProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
