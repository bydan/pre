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
import com.bydan.erp.produccion.util.*;//ProductoProduConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoProduDataAccess extends  ProductoProduDataAccessAdditional{ //ProductoProduDataAccessAdditional,DataAccessHelper<ProductoProdu>
	//static Logger logger = Logger.getLogger(ProductoProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+"(version_row,id_producto_defi_produ,id_bodega,id_producto,id_unidad,porcentaje,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_bodega=?,id_producto=?,id_unidad=?,porcentaje=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoprodu from "+ProductoProduConstantesFunciones.SPERSISTENCENAME+" productoprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".version_row,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".porcentaje,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".cantidad,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".costo,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME;//+" as "+ProductoProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".id,"+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+".version_row from "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME;//+" as "+ProductoProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoProduConstantesFunciones.SCHEMA+"."+ProductoProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_bodega=?,id_producto=?,id_unidad=?,porcentaje=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPRODU_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPRODU_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPRODU_SELECT(?,?)";
	
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
	
	
	protected ProductoProduDataAccessAdditional productoproduDataAccessAdditional=null;
	
	public ProductoProduDataAccessAdditional getProductoProduDataAccessAdditional() {
		return this.productoproduDataAccessAdditional;
	}
	
	public void setProductoProduDataAccessAdditional(ProductoProduDataAccessAdditional productoproduDataAccessAdditional) {
		try {
			this.productoproduDataAccessAdditional=productoproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoProduDataAccess() {
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
		ProductoProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoProduOriginal(ProductoProdu productoprodu)throws Exception  {
		productoprodu.setProductoProduOriginal((ProductoProdu)productoprodu.clone());		
	}
	
	public void setProductoProdusOriginal(List<ProductoProdu> productoprodus)throws Exception  {
		
		for(ProductoProdu productoprodu:productoprodus){
			productoprodu.setProductoProduOriginal((ProductoProdu)productoprodu.clone());
		}
	}
	
	public static void setProductoProduOriginalStatic(ProductoProdu productoprodu)throws Exception  {
		productoprodu.setProductoProduOriginal((ProductoProdu)productoprodu.clone());		
	}
	
	public static void setProductoProdusOriginalStatic(List<ProductoProdu> productoprodus)throws Exception  {
		
		for(ProductoProdu productoprodu:productoprodus){
			productoprodu.setProductoProduOriginal((ProductoProdu)productoprodu.clone());
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
	
	public  ProductoProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();		
		
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
	
	public  ProductoProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoProduOriginal(new ProductoProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProdu("",entity,resultSet); 
				
				//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();
				
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
	
	public  ProductoProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoProduOriginal(new ProductoProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProdu("",entity,resultSet);    
				
				//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoProdu entity = new ProductoProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		
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
	
	public  List<ProductoProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProdu("",entity,resultSet);
      	    	
				//entity.setProductoProduOriginal( new ProductoProdu());
      	    	//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
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
	
	public  List<ProductoProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProdu();
					//entity.setMapProductoProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduDataAccess.getEntityProductoProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduOriginal( new ProductoProdu());
					////entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();		  
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
	
	public  ProductoProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProdu();
					//entity.setMapProductoProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduDataAccess.getEntityProductoProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduOriginal( new ProductoProdu());
					////entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoProdu getEntityProductoProdu(String strPrefijo,ProductoProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoProduDataAccess.setFieldReflectionProductoProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoProdu=ProductoProduConstantesFunciones.getTodosTiposColumnasProductoProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoProdu) {
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
							field = ProductoProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoProduDataAccess.setFieldReflectionProductoProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoProdu(Field field,String strPrefijo,String sColumn,ProductoProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoProdu();
					entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoProdu("",entity,resultSet);
					
					//entity.setProductoProduOriginal( new ProductoProdu());
					//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
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
	
	public  List<ProductoProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProdu("",entity,resultSet);
      	    	
				//entity.setProductoProduOriginal( new ProductoProdu());
      	    	//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
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
	
	public  List<ProductoProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProdu> entities = new  ArrayList<ProductoProdu>();
		ProductoProdu entity = new ProductoProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProdu("",entity,resultSet);
      	    	
				//entity.setProductoProduOriginal( new ProductoProdu());
      	    	//entity.setProductoProduOriginal(super.getEntity("",entity.getProductoProduOriginal(),resultSet,ProductoProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduOriginal(this.getEntityProductoProdu("",entity.getProductoProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoProdu getEntityProductoProdu(String strPrefijo,ProductoProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_producto_defi_produ(resultSet.getLong(strPrefijo+ProductoProduConstantesFunciones.IDPRODUCTODEFIPRODU));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoProduConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoProduConstantesFunciones.IDUNIDAD));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ProductoProduConstantesFunciones.PORCENTAJE));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoProduConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoProduConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoProduConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoProduConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoProduDataAccess.TABLENAME,ProductoProduDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoProduDataAccess.setProductoProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ProductoDefiProdu getProductoDefiProdu(Connexion connexion,ProductoProdu relproductoprodu)throws SQLException,Exception {

		ProductoDefiProdu productodefiprodu= new ProductoDefiProdu();

		try {
			ProductoDefiProduDataAccess productodefiproduDataAccess=new ProductoDefiProduDataAccess();

			productodefiproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productodefiproduDataAccess.setConnexionType(this.connexionType);
			productodefiproduDataAccess.setParameterDbType(this.parameterDbType);

			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,relproductoprodu.getid_producto_defi_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productodefiprodu;

	}

	public Bodega getBodega(Connexion connexion,ProductoProdu relproductoprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductoprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoProdu relproductoprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductoprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,ProductoProdu relproductoprodu)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoprodu.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoProdu productoprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_defi_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_defi_produ.setValue(productoprodu.getid_producto_defi_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_defi_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productoprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productoprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoprodu.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(productoprodu.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoprodu.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoprodu.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoprodu.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoprodu.getId());
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
	
	public void setIsNewIsChangedFalseProductoProdu(ProductoProdu productoprodu)throws Exception  {		
		productoprodu.setIsNew(false);
		productoprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoProdus(List<ProductoProdu> productoprodus)throws Exception  {				
		for(ProductoProdu productoprodu:productoprodus) {
			productoprodu.setIsNew(false);
			productoprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
