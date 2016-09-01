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
import com.bydan.erp.produccion.util.*;//ProductoOrdenDetaProduConstantesFunciones;


import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoOrdenDetaProduDataAccess extends  ProductoOrdenDetaProduDataAccessAdditional{ //ProductoOrdenDetaProduDataAccessAdditional,DataAccessHelper<ProductoOrdenDetaProdu>
	//static Logger logger = Logger.getLogger(ProductoOrdenDetaProduDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_orden_deta_produ";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+"(version_row,id_orden_deta_produ,id_bodega,id_producto,id_unidad,porcentaje,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_bodega=?,id_producto=?,id_unidad=?,porcentaje=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoordendetaprodu from "+ProductoOrdenDetaProduConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodu";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_bodega,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_producto,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".porcentaje,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+".version_row from "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoOrdenDetaProduConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_bodega=?,id_producto=?,id_unidad=?,porcentaje=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOORDENDETAPRODU_INSERT(?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOORDENDETAPRODU_UPDATE(?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOORDENDETAPRODU_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOORDENDETAPRODU_SELECT(?,?)";
	
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
	
	
	protected ProductoOrdenDetaProduDataAccessAdditional productoordendetaproduDataAccessAdditional=null;
	
	public ProductoOrdenDetaProduDataAccessAdditional getProductoOrdenDetaProduDataAccessAdditional() {
		return this.productoordendetaproduDataAccessAdditional;
	}
	
	public void setProductoOrdenDetaProduDataAccessAdditional(ProductoOrdenDetaProduDataAccessAdditional productoordendetaproduDataAccessAdditional) {
		try {
			this.productoordendetaproduDataAccessAdditional=productoordendetaproduDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoOrdenDetaProduDataAccess() {
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
		ProductoOrdenDetaProduDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoOrdenDetaProduDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoOrdenDetaProduDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOrdenDetaProduOriginal(ProductoOrdenDetaProdu productoordendetaprodu)throws Exception  {
		productoordendetaprodu.setProductoOrdenDetaProduOriginal((ProductoOrdenDetaProdu)productoordendetaprodu.clone());		
	}
	
	public void setProductoOrdenDetaProdusOriginal(List<ProductoOrdenDetaProdu> productoordendetaprodus)throws Exception  {
		
		for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus){
			productoordendetaprodu.setProductoOrdenDetaProduOriginal((ProductoOrdenDetaProdu)productoordendetaprodu.clone());
		}
	}
	
	public static void setProductoOrdenDetaProduOriginalStatic(ProductoOrdenDetaProdu productoordendetaprodu)throws Exception  {
		productoordendetaprodu.setProductoOrdenDetaProduOriginal((ProductoOrdenDetaProdu)productoordendetaprodu.clone());		
	}
	
	public static void setProductoOrdenDetaProdusOriginalStatic(List<ProductoOrdenDetaProdu> productoordendetaprodus)throws Exception  {
		
		for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus){
			productoordendetaprodu.setProductoOrdenDetaProduOriginal((ProductoOrdenDetaProdu)productoordendetaprodu.clone());
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
	
	public  ProductoOrdenDetaProdu getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		
		
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
	
	public  ProductoOrdenDetaProdu getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoOrdenDetaProdu.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduOriginal(new ProductoOrdenDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet); 
				
				//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProdu(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoOrdenDetaProdu getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();
				
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
	
	public  ProductoOrdenDetaProdu getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProdu.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduOriginal(new ProductoOrdenDetaProdu());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet);    
				
				//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoOrdenDetaProdu
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProdu.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoOrdenDetaProdu(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoOrdenDetaProdu> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		
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
	
	public  List<ProductoOrdenDetaProdu> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
      	    	//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProdus(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
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
	
	public  List<ProductoOrdenDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProdu();
					//entity.setMapProductoOrdenDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoOrdenDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduDataAccess.getEntityProductoOrdenDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
					////entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProdus(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoOrdenDetaProdu getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
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
	
	public  ProductoOrdenDetaProdu getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProdu();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProdu();
					//entity.setMapProductoOrdenDetaProdu(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoOrdenDetaProduValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProdu().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduDataAccess.getEntityProductoOrdenDetaProdu("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
					////entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProdu(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoOrdenDetaProdu getEntityProductoOrdenDetaProdu(String strPrefijo,ProductoOrdenDetaProdu entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoOrdenDetaProdu.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoOrdenDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoOrdenDetaProduDataAccess.setFieldReflectionProductoOrdenDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoOrdenDetaProdu=ProductoOrdenDetaProduConstantesFunciones.getTodosTiposColumnasProductoOrdenDetaProdu();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoOrdenDetaProdu) {
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
							field = ProductoOrdenDetaProdu.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoOrdenDetaProdu.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoOrdenDetaProduDataAccess.setFieldReflectionProductoOrdenDetaProdu(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoOrdenDetaProdu(Field field,String strPrefijo,String sColumn,ProductoOrdenDetaProdu entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoOrdenDetaProduConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProdu>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoOrdenDetaProdu();
					entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet);
					
					//entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
					//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoOrdenDetaProdus(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProdu>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoOrdenDetaProdu> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
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
	
	public  List<ProductoOrdenDetaProdu> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
      	    	//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoOrdenDetaProdus(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProdu(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProdu> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
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
	
	public  List<ProductoOrdenDetaProdu> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProdu> entities = new  ArrayList<ProductoOrdenDetaProdu>();
		ProductoOrdenDetaProdu entity = new ProductoOrdenDetaProdu();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProdu();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProdu("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduOriginal( new ProductoOrdenDetaProdu());
      	    	//entity.setProductoOrdenDetaProduOriginal(super.getEntity("",entity.getProductoOrdenDetaProduOriginal(),resultSet,ProductoOrdenDetaProduDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduOriginal(this.getEntityProductoOrdenDetaProdu("",entity.getProductoOrdenDetaProduOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProdus(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoOrdenDetaProdu getEntityProductoOrdenDetaProdu(String strPrefijo,ProductoOrdenDetaProdu entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_deta_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.IDORDENDETAPRODU));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.IDUNIDAD));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.PORCENTAJE));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoOrdenDetaProduConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoOrdenDetaProdu(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoOrdenDetaProdu entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoOrdenDetaProduDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoOrdenDetaProduDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoOrdenDetaProduDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoOrdenDetaProduDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoOrdenDetaProduConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoOrdenDetaProduDataAccess.TABLENAME,ProductoOrdenDetaProduDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoOrdenDetaProduDataAccess.setProductoOrdenDetaProduOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenDetaProdu getOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProdu relproductoordendetaprodu)throws SQLException,Exception {

		OrdenDetaProdu ordendetaprodu= new OrdenDetaProdu();

		try {
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);

			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,relproductoordendetaprodu.getid_orden_deta_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodu;

	}

	public Bodega getBodega(Connexion connexion,ProductoOrdenDetaProdu relproductoordendetaprodu)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductoordendetaprodu.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoOrdenDetaProdu relproductoordendetaprodu)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductoordendetaprodu.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,ProductoOrdenDetaProdu relproductoordendetaprodu)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoordendetaprodu.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoOrdenDetaProdu productoordendetaprodu) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoordendetaprodu.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_deta_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_deta_produ.setValue(productoordendetaprodu.getid_orden_deta_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_deta_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productoordendetaprodu.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productoordendetaprodu.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoordendetaprodu.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(productoordendetaprodu.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoordendetaprodu.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoordendetaprodu.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoordendetaprodu.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoordendetaprodu.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoordendetaprodu.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoordendetaprodu.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoordendetaprodu.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoordendetaprodu.getId());
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
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProdu(ProductoOrdenDetaProdu productoordendetaprodu)throws Exception  {		
		productoordendetaprodu.setIsNew(false);
		productoordendetaprodu.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> productoordendetaprodus)throws Exception  {				
		for(ProductoOrdenDetaProdu productoordendetaprodu:productoordendetaprodus) {
			productoordendetaprodu.setIsNew(false);
			productoordendetaprodu.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoOrdenDetaProdu(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
