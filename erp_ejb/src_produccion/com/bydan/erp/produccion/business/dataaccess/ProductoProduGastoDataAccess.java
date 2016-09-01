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
import com.bydan.erp.produccion.util.*;//ProductoProduGastoConstantesFunciones;


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class ProductoProduGastoDataAccess extends  ProductoProduGastoDataAccessAdditional{ //ProductoProduGastoDataAccessAdditional,DataAccessHelper<ProductoProduGasto>
	//static Logger logger = Logger.getLogger(ProductoProduGastoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_produ_gasto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+"(version_row,id_producto_defi_produ,id_tipo_gasto_produ_empresa,id_cuenta_contable_debito,id_cuenta_contable_credito,id_cliente_proveedor,id_factura,id_unidad,canitdad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_gasto_produ_empresa=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cliente_proveedor=?,id_factura=?,id_unidad=?,canitdad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoprodugasto from "+ProductoProduGastoConstantesFunciones.SPERSISTENCENAME+" productoprodugasto";
	public static String QUERYSELECTNATIVE="select "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".version_row,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_producto_defi_produ,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_tipo_gasto_produ_empresa,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_factura,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".canitdad,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".costo,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".costo_total,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".descripcion from "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoProduGastoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+".version_row from "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoProduGastoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoProduGastoConstantesFunciones.SCHEMA+"."+ProductoProduGastoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_producto_defi_produ=?,id_tipo_gasto_produ_empresa=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cliente_proveedor=?,id_factura=?,id_unidad=?,canitdad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOPRODUGASTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOPRODUGASTO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOPRODUGASTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOPRODUGASTO_SELECT(?,?)";
	
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
	
	
	protected ProductoProduGastoDataAccessAdditional productoprodugastoDataAccessAdditional=null;
	
	public ProductoProduGastoDataAccessAdditional getProductoProduGastoDataAccessAdditional() {
		return this.productoprodugastoDataAccessAdditional;
	}
	
	public void setProductoProduGastoDataAccessAdditional(ProductoProduGastoDataAccessAdditional productoprodugastoDataAccessAdditional) {
		try {
			this.productoprodugastoDataAccessAdditional=productoprodugastoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoProduGastoDataAccess() {
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
		ProductoProduGastoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoProduGastoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoProduGastoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoProduGastoOriginal(ProductoProduGasto productoprodugasto)throws Exception  {
		productoprodugasto.setProductoProduGastoOriginal((ProductoProduGasto)productoprodugasto.clone());		
	}
	
	public void setProductoProduGastosOriginal(List<ProductoProduGasto> productoprodugastos)throws Exception  {
		
		for(ProductoProduGasto productoprodugasto:productoprodugastos){
			productoprodugasto.setProductoProduGastoOriginal((ProductoProduGasto)productoprodugasto.clone());
		}
	}
	
	public static void setProductoProduGastoOriginalStatic(ProductoProduGasto productoprodugasto)throws Exception  {
		productoprodugasto.setProductoProduGastoOriginal((ProductoProduGasto)productoprodugasto.clone());		
	}
	
	public static void setProductoProduGastosOriginalStatic(List<ProductoProduGasto> productoprodugastos)throws Exception  {
		
		for(ProductoProduGasto productoprodugasto:productoprodugastos){
			productoprodugasto.setProductoProduGastoOriginal((ProductoProduGasto)productoprodugasto.clone());
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
	
	public  ProductoProduGasto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();		
		
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
	
	public  ProductoProduGasto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoProduGasto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoProduGastoOriginal(new ProductoProduGasto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduGasto("",entity,resultSet); 
				
				//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduGasto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoProduGasto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();
				
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
	
	public  ProductoProduGasto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduGasto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoProduGastoOriginal(new ProductoProduGasto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoProduGasto("",entity,resultSet);    
				
				//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoProduGasto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoProduGasto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoProduGasto entity = new ProductoProduGasto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoProduGasto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoProduGasto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoProduGasto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		
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
	
	public  List<ProductoProduGasto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoProduGastoOriginal( new ProductoProduGasto());
      	    	//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduGastos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduGasto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
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
	
	public  List<ProductoProduGasto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduGasto();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduGasto();
					//entity.setMapProductoProduGasto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoProduGastoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduGasto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduGastoDataAccess.getEntityProductoProduGasto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduGastoOriginal( new ProductoProduGasto());
					////entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduGastos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoProduGasto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();		  
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
	
	public  ProductoProduGasto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduGasto();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoProduGasto();
					//entity.setMapProductoProduGasto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoProduGastoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoProduGasto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoProduGastoDataAccess.getEntityProductoProduGasto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoProduGastoOriginal( new ProductoProduGasto());
					////entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoProduGasto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoProduGasto getEntityProductoProduGasto(String strPrefijo,ProductoProduGasto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoProduGasto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoProduGasto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoProduGastoDataAccess.setFieldReflectionProductoProduGasto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoProduGasto=ProductoProduGastoConstantesFunciones.getTodosTiposColumnasProductoProduGasto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoProduGasto) {
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
							field = ProductoProduGasto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoProduGasto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoProduGastoDataAccess.setFieldReflectionProductoProduGasto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoProduGasto(Field field,String strPrefijo,String sColumn,ProductoProduGasto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoProduGastoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoProduGastoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduGasto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoProduGasto();
					entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoProduGasto("",entity,resultSet);
					
					//entity.setProductoProduGastoOriginal( new ProductoProduGasto());
					//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoProduGastos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoProduGasto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoProduGasto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
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
	
	public  List<ProductoProduGasto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoProduGastoOriginal( new ProductoProduGasto());
      	    	//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoProduGastos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoProduGasto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
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
	
	public  List<ProductoProduGasto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoProduGasto> entities = new  ArrayList<ProductoProduGasto>();
		ProductoProduGasto entity = new ProductoProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoProduGastoOriginal( new ProductoProduGasto());
      	    	//entity.setProductoProduGastoOriginal(super.getEntity("",entity.getProductoProduGastoOriginal(),resultSet,ProductoProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoProduGastoOriginal(this.getEntityProductoProduGasto("",entity.getProductoProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoProduGastos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoProduGasto getEntityProductoProduGasto(String strPrefijo,ProductoProduGasto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_producto_defi_produ(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDPRODUCTODEFIPRODU));
				entity.setid_tipo_gasto_produ_empresa(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO));
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO));
				entity.setid_cliente_proveedor(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR));
				entity.setid_factura(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDFACTURA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoProduGastoConstantesFunciones.IDUNIDAD));
				entity.setcanitdad(resultSet.getInt(strPrefijo+ProductoProduGastoConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoProduGastoConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoProduGastoConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoProduGastoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoProduGasto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoProduGasto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoProduGastoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoProduGastoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoProduGastoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoProduGastoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoProduGastoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoProduGastoDataAccess.TABLENAME,ProductoProduGastoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoProduGastoDataAccess.setProductoProduGastoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ProductoDefiProdu getProductoDefiProdu(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		ProductoDefiProdu productodefiprodu= new ProductoDefiProdu();

		try {
			ProductoDefiProduDataAccess productodefiproduDataAccess=new ProductoDefiProduDataAccess();

			productodefiproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productodefiproduDataAccess.setConnexionType(this.connexionType);
			productodefiproduDataAccess.setParameterDbType(this.parameterDbType);

			productodefiprodu=productodefiproduDataAccess.getEntity(connexion,relproductoprodugasto.getid_producto_defi_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productodefiprodu;

	}

	public TipoGastoProduEmpresa getTipoGastoProduEmpresa(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		TipoGastoProduEmpresa tipogastoproduempresa= new TipoGastoProduEmpresa();

		try {
			TipoGastoProduEmpresaDataAccess tipogastoproduempresaDataAccess=new TipoGastoProduEmpresaDataAccess();

			tipogastoproduempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogastoproduempresaDataAccess.setConnexionType(this.connexionType);
			tipogastoproduempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion,relproductoprodugasto.getid_tipo_gasto_produ_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogastoproduempresa;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductoprodugasto.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductoprodugasto.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Cliente getClienteProveedor(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relproductoprodugasto.getid_cliente_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relproductoprodugasto.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Unidad getUnidad(Connexion connexion,ProductoProduGasto relproductoprodugasto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoprodugasto.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoProduGasto productoprodugasto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoprodugasto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto_defi_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto_defi_produ.setValue(productoprodugasto.getid_producto_defi_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto_defi_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_gasto_produ_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_gasto_produ_empresa.setValue(productoprodugasto.getid_tipo_gasto_produ_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_gasto_produ_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(productoprodugasto.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(productoprodugasto.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_proveedor.setValue(productoprodugasto.getid_cliente_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(productoprodugasto.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoprodugasto.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecanitdad=new ParameterValue<Integer>();
					parameterMaintenanceValuecanitdad.setValue(productoprodugasto.getcanitdad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecanitdad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoprodugasto.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoprodugasto.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoprodugasto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoprodugasto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoprodugasto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoprodugasto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoprodugasto.getId());
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
	
	public void setIsNewIsChangedFalseProductoProduGasto(ProductoProduGasto productoprodugasto)throws Exception  {		
		productoprodugasto.setIsNew(false);
		productoprodugasto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoProduGastos(List<ProductoProduGasto> productoprodugastos)throws Exception  {				
		for(ProductoProduGasto productoprodugasto:productoprodugastos) {
			productoprodugasto.setIsNew(false);
			productoprodugasto.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoProduGasto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
