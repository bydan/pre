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
import com.bydan.erp.produccion.util.*;//ProductoOrdenDetaProduGastoConstantesFunciones;


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
final public class ProductoOrdenDetaProduGastoDataAccess extends  ProductoOrdenDetaProduGastoDataAccessAdditional{ //ProductoOrdenDetaProduGastoDataAccessAdditional,DataAccessHelper<ProductoOrdenDetaProduGasto>
	//static Logger logger = Logger.getLogger(ProductoOrdenDetaProduGastoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_orden_deta_produ_gasto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+"(version_row,id_orden_deta_produ,id_tipo_gasto_produ_empresa,id_cuenta_contable_debito,id_cuenta_contable_credito,id_cliente_proveedor,id_factura,id_unidad,cantidad,costo,costo_total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_gasto_produ_empresa=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cliente_proveedor=?,id_factura=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoordendetaprodugasto from "+ProductoOrdenDetaProduGastoConstantesFunciones.SPERSISTENCENAME+" productoordendetaprodugasto";
	public static String QUERYSELECTNATIVE="select "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".version_row,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_orden_deta_produ,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_tipo_gasto_produ_empresa,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_cliente_proveedor,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_factura,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".cantidad,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".costo,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".costo_total,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".descripcion from "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".id,"+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+".version_row from "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;//+" as "+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoOrdenDetaProduGastoConstantesFunciones.SCHEMA+"."+ProductoOrdenDetaProduGastoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_orden_deta_produ=?,id_tipo_gasto_produ_empresa=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cliente_proveedor=?,id_factura=?,id_unidad=?,cantidad=?,costo=?,costo_total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOORDENDETAPRODUGASTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOORDENDETAPRODUGASTO_UPDATE(?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOORDENDETAPRODUGASTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOORDENDETAPRODUGASTO_SELECT(?,?)";
	
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
	
	
	protected ProductoOrdenDetaProduGastoDataAccessAdditional productoordendetaprodugastoDataAccessAdditional=null;
	
	public ProductoOrdenDetaProduGastoDataAccessAdditional getProductoOrdenDetaProduGastoDataAccessAdditional() {
		return this.productoordendetaprodugastoDataAccessAdditional;
	}
	
	public void setProductoOrdenDetaProduGastoDataAccessAdditional(ProductoOrdenDetaProduGastoDataAccessAdditional productoordendetaprodugastoDataAccessAdditional) {
		try {
			this.productoordendetaprodugastoDataAccessAdditional=productoordendetaprodugastoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoOrdenDetaProduGastoDataAccess() {
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
		ProductoOrdenDetaProduGastoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoOrdenDetaProduGastoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoOrdenDetaProduGastoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOrdenDetaProduGastoOriginal(ProductoOrdenDetaProduGasto productoordendetaprodugasto)throws Exception  {
		productoordendetaprodugasto.setProductoOrdenDetaProduGastoOriginal((ProductoOrdenDetaProduGasto)productoordendetaprodugasto.clone());		
	}
	
	public void setProductoOrdenDetaProduGastosOriginal(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos)throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos){
			productoordendetaprodugasto.setProductoOrdenDetaProduGastoOriginal((ProductoOrdenDetaProduGasto)productoordendetaprodugasto.clone());
		}
	}
	
	public static void setProductoOrdenDetaProduGastoOriginalStatic(ProductoOrdenDetaProduGasto productoordendetaprodugasto)throws Exception  {
		productoordendetaprodugasto.setProductoOrdenDetaProduGastoOriginal((ProductoOrdenDetaProduGasto)productoordendetaprodugasto.clone());		
	}
	
	public static void setProductoOrdenDetaProduGastosOriginalStatic(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos)throws Exception  {
		
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos){
			productoordendetaprodugasto.setProductoOrdenDetaProduGastoOriginal((ProductoOrdenDetaProduGasto)productoordendetaprodugasto.clone());
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
	
	public  ProductoOrdenDetaProduGasto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		
		
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
	
	public  ProductoOrdenDetaProduGasto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Produccion.ProductoOrdenDetaProduGasto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduGastoOriginal(new ProductoOrdenDetaProduGasto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet); 
				
				//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduGasto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoOrdenDetaProduGasto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();
				
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
	
	public  ProductoOrdenDetaProduGasto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduGasto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOrdenDetaProduGastoOriginal(new ProductoOrdenDetaProduGasto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet);    
				
				//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoOrdenDetaProduGasto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoOrdenDetaProduGasto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Produccion.ProductoOrdenDetaProduGasto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoOrdenDetaProduGasto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoOrdenDetaProduGasto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		
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
	
	public  List<ProductoOrdenDetaProduGasto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduGastos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduGasto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
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
	
	public  List<ProductoOrdenDetaProduGasto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduGasto();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduGasto();
					//entity.setMapProductoOrdenDetaProduGasto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoOrdenDetaProduGastoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduGasto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduGastoDataAccess.getEntityProductoOrdenDetaProduGasto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
					////entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduGastos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoOrdenDetaProduGasto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
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
	
	public  ProductoOrdenDetaProduGasto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduGasto();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoOrdenDetaProduGasto();
					//entity.setMapProductoOrdenDetaProduGasto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoOrdenDetaProduGastoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoOrdenDetaProduGasto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoOrdenDetaProduGastoDataAccess.getEntityProductoOrdenDetaProduGasto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
					////entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduGasto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoOrdenDetaProduGasto getEntityProductoOrdenDetaProduGasto(String strPrefijo,ProductoOrdenDetaProduGasto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoOrdenDetaProduGasto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoOrdenDetaProduGasto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoOrdenDetaProduGastoDataAccess.setFieldReflectionProductoOrdenDetaProduGasto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoOrdenDetaProduGasto=ProductoOrdenDetaProduGastoConstantesFunciones.getTodosTiposColumnasProductoOrdenDetaProduGasto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoOrdenDetaProduGasto) {
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
							field = ProductoOrdenDetaProduGasto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoOrdenDetaProduGasto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoOrdenDetaProduGastoDataAccess.setFieldReflectionProductoOrdenDetaProduGasto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoOrdenDetaProduGasto(Field field,String strPrefijo,String sColumn,ProductoOrdenDetaProduGasto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduGasto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoOrdenDetaProduGasto();
					entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet);
					
					//entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
					//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoOrdenDetaProduGastos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoOrdenDetaProduGasto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoOrdenDetaProduGastoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoOrdenDetaProduGastoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoOrdenDetaProduGasto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
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
	
	public  List<ProductoOrdenDetaProduGasto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoOrdenDetaProduGastos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoOrdenDetaProduGasto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoOrdenDetaProduGasto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
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
	
	public  List<ProductoOrdenDetaProduGasto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoOrdenDetaProduGasto> entities = new  ArrayList<ProductoOrdenDetaProduGasto>();
		ProductoOrdenDetaProduGasto entity = new ProductoOrdenDetaProduGasto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoOrdenDetaProduGasto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoOrdenDetaProduGasto("",entity,resultSet);
      	    	
				//entity.setProductoOrdenDetaProduGastoOriginal( new ProductoOrdenDetaProduGasto());
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(super.getEntity("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet,ProductoOrdenDetaProduGastoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOrdenDetaProduGastoOriginal(this.getEntityProductoOrdenDetaProduGasto("",entity.getProductoOrdenDetaProduGastoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoOrdenDetaProduGastos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoOrdenDetaProduGasto getEntityProductoOrdenDetaProduGasto(String strPrefijo,ProductoOrdenDetaProduGasto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_orden_deta_produ(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDORDENDETAPRODU));
				entity.setid_tipo_gasto_produ_empresa(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDTIPOGASTOPRODUEMPRESA));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLEDEBITO));
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDCUENTACONTABLECREDITO));
				entity.setid_cliente_proveedor(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDCLIENTEPROVEEDOR));
				entity.setid_factura(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDFACTURA));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.IDUNIDAD));
				entity.setcantidad(resultSet.getInt(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.CANTIDAD));
				entity.setcosto(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.COSTO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.COSTOTOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoOrdenDetaProduGastoConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoOrdenDetaProduGasto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoOrdenDetaProduGasto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoOrdenDetaProduGastoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoOrdenDetaProduGastoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoOrdenDetaProduGastoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoOrdenDetaProduGastoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoOrdenDetaProduGastoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoOrdenDetaProduGastoDataAccess.TABLENAME,ProductoOrdenDetaProduGastoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoOrdenDetaProduGastoDataAccess.setProductoOrdenDetaProduGastoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public OrdenDetaProdu getOrdenDetaProdu(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		OrdenDetaProdu ordendetaprodu= new OrdenDetaProdu();

		try {
			OrdenDetaProduDataAccess ordendetaproduDataAccess=new OrdenDetaProduDataAccess();

			ordendetaproduDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ordendetaproduDataAccess.setConnexionType(this.connexionType);
			ordendetaproduDataAccess.setParameterDbType(this.parameterDbType);

			ordendetaprodu=ordendetaproduDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_orden_deta_produ());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ordendetaprodu;

	}

	public TipoGastoProduEmpresa getTipoGastoProduEmpresa(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		TipoGastoProduEmpresa tipogastoproduempresa= new TipoGastoProduEmpresa();

		try {
			TipoGastoProduEmpresaDataAccess tipogastoproduempresaDataAccess=new TipoGastoProduEmpresaDataAccess();

			tipogastoproduempresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipogastoproduempresaDataAccess.setConnexionType(this.connexionType);
			tipogastoproduempresaDataAccess.setParameterDbType(this.parameterDbType);

			tipogastoproduempresa=tipogastoproduempresaDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_tipo_gasto_produ_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipogastoproduempresa;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public Cliente getClienteProveedor(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_cliente_proveedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Factura getFactura(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public Unidad getUnidad(Connexion connexion,ProductoOrdenDetaProduGasto relproductoordendetaprodugasto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproductoordendetaprodugasto.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoOrdenDetaProduGasto productoordendetaprodugasto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoordendetaprodugasto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_orden_deta_produ=new ParameterValue<Long>();
					parameterMaintenanceValueid_orden_deta_produ.setValue(productoordendetaprodugasto.getid_orden_deta_produ());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_orden_deta_produ);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_gasto_produ_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_gasto_produ_empresa.setValue(productoordendetaprodugasto.getid_tipo_gasto_produ_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_gasto_produ_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(productoordendetaprodugasto.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(productoordendetaprodugasto.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_proveedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_proveedor.setValue(productoordendetaprodugasto.getid_cliente_proveedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_proveedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(productoordendetaprodugasto.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(productoordendetaprodugasto.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(productoordendetaprodugasto.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(productoordendetaprodugasto.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoordendetaprodugasto.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(productoordendetaprodugasto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoordendetaprodugasto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoordendetaprodugasto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoordendetaprodugasto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoordendetaprodugasto.getId());
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
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto productoordendetaprodugasto)throws Exception  {		
		productoordendetaprodugasto.setIsNew(false);
		productoordendetaprodugasto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos)throws Exception  {				
		for(ProductoOrdenDetaProduGasto productoordendetaprodugasto:productoordendetaprodugastos) {
			productoordendetaprodugasto.setIsNew(false);
			productoordendetaprodugasto.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoOrdenDetaProduGasto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
