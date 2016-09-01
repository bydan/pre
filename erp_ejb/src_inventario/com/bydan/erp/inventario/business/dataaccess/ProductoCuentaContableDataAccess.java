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
import com.bydan.erp.inventario.util.*;//ProductoCuentaContableConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class ProductoCuentaContableDataAccess extends  ProductoCuentaContableDataAccessAdditional{ //ProductoCuentaContableDataAccessAdditional,DataAccessHelper<ProductoCuentaContable>
	//static Logger logger = Logger.getLogger(ProductoCuentaContableDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_cuenta_contable";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_centro_costo,id_cuenta_contable_inventario,id_cuenta_contable_costo,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_devolucion,id_cuenta_contable_debito,id_cuenta_contable_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_centro_costo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productocuentacontable from "+ProductoCuentaContableConstantesFunciones.SPERSISTENCENAME+" productocuentacontable";
	public static String QUERYSELECTNATIVE="select "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".version_row,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_empresa,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_bodega,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_producto,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_centro_costo,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id_cuenta_contable_credito from "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME;//+" as "+ProductoCuentaContableConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".id,"+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+".version_row from "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME;//+" as "+ProductoCuentaContableConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoCuentaContableConstantesFunciones.SCHEMA+"."+ProductoCuentaContableConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_centro_costo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOCUENTACONTABLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOCUENTACONTABLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOCUENTACONTABLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOCUENTACONTABLE_SELECT(?,?)";
	
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
	
	
	protected ProductoCuentaContableDataAccessAdditional productocuentacontableDataAccessAdditional=null;
	
	public ProductoCuentaContableDataAccessAdditional getProductoCuentaContableDataAccessAdditional() {
		return this.productocuentacontableDataAccessAdditional;
	}
	
	public void setProductoCuentaContableDataAccessAdditional(ProductoCuentaContableDataAccessAdditional productocuentacontableDataAccessAdditional) {
		try {
			this.productocuentacontableDataAccessAdditional=productocuentacontableDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoCuentaContableDataAccess() {
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
		ProductoCuentaContableDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoCuentaContableDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoCuentaContableDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoCuentaContableOriginal(ProductoCuentaContable productocuentacontable)throws Exception  {
		productocuentacontable.setProductoCuentaContableOriginal((ProductoCuentaContable)productocuentacontable.clone());		
	}
	
	public void setProductoCuentaContablesOriginal(List<ProductoCuentaContable> productocuentacontables)throws Exception  {
		
		for(ProductoCuentaContable productocuentacontable:productocuentacontables){
			productocuentacontable.setProductoCuentaContableOriginal((ProductoCuentaContable)productocuentacontable.clone());
		}
	}
	
	public static void setProductoCuentaContableOriginalStatic(ProductoCuentaContable productocuentacontable)throws Exception  {
		productocuentacontable.setProductoCuentaContableOriginal((ProductoCuentaContable)productocuentacontable.clone());		
	}
	
	public static void setProductoCuentaContablesOriginalStatic(List<ProductoCuentaContable> productocuentacontables)throws Exception  {
		
		for(ProductoCuentaContable productocuentacontable:productocuentacontables){
			productocuentacontable.setProductoCuentaContableOriginal((ProductoCuentaContable)productocuentacontable.clone());
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
	
	public  ProductoCuentaContable getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();		
		
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
	
	public  ProductoCuentaContable getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ProductoCuentaContable.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoCuentaContableOriginal(new ProductoCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoCuentaContable("",entity,resultSet); 
				
				//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoCuentaContable(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoCuentaContable getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();
				
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
	
	public  ProductoCuentaContable getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoCuentaContable.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoCuentaContableOriginal(new ProductoCuentaContable());
      	    	entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoCuentaContable("",entity,resultSet);    
				
				//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoCuentaContable
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoCuentaContable entity = new ProductoCuentaContable();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoCuentaContable.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoCuentaContable(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoCuentaContable> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		
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
	
	public  List<ProductoCuentaContable> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoCuentaContable("",entity,resultSet);
      	    	
				//entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
      	    	//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoCuentaContables(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
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
	
	public  List<ProductoCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoCuentaContable();
					//entity.setMapProductoCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=ProductoCuentaContableDataAccess.getEntityProductoCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
					////entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoCuentaContables(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoCuentaContable getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
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
	
	public  ProductoCuentaContable getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoCuentaContable();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoCuentaContable();
					//entity.setMapProductoCuentaContable(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoCuentaContableValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoCuentaContable().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=ProductoCuentaContableDataAccess.getEntityProductoCuentaContable("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
					////entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoCuentaContable(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoCuentaContable getEntityProductoCuentaContable(String strPrefijo,ProductoCuentaContable entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoCuentaContable.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoCuentaContableDataAccess.setFieldReflectionProductoCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoCuentaContable=ProductoCuentaContableConstantesFunciones.getTodosTiposColumnasProductoCuentaContable();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoCuentaContable) {
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
							field = ProductoCuentaContable.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoCuentaContable.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoCuentaContableDataAccess.setFieldReflectionProductoCuentaContable(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoCuentaContable(Field field,String strPrefijo,String sColumn,ProductoCuentaContable entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoCuentaContableConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoCuentaContable>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoCuentaContable();
					entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoCuentaContable("",entity,resultSet);
					
					//entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
					//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoCuentaContables(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoCuentaContable>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoCuentaContableDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoCuentaContableDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoCuentaContable> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
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
	
	public  List<ProductoCuentaContable> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoCuentaContable("",entity,resultSet);
      	    	
				//entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
      	    	//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoCuentaContables(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoCuentaContable(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoCuentaContable> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
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
	
	public  List<ProductoCuentaContable> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoCuentaContable> entities = new  ArrayList<ProductoCuentaContable>();
		ProductoCuentaContable entity = new ProductoCuentaContable();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoCuentaContable();
      	    	entity=super.getEntity("",entity,resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoCuentaContable("",entity,resultSet);
      	    	
				//entity.setProductoCuentaContableOriginal( new ProductoCuentaContable());
      	    	//entity.setProductoCuentaContableOriginal(super.getEntity("",entity.getProductoCuentaContableOriginal(),resultSet,ProductoCuentaContableDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoCuentaContableOriginal(this.getEntityProductoCuentaContable("",entity.getProductoCuentaContableOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoCuentaContables(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoCuentaContable getEntityProductoCuentaContable(String strPrefijo,ProductoCuentaContable entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDPRODUCTO));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECOSTO));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDESCUENTO));
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO));
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+ProductoCuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoCuentaContable(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoCuentaContable entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoCuentaContableDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoCuentaContableDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoCuentaContableDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoCuentaContableDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoCuentaContableConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoCuentaContableDataAccess.TABLENAME,ProductoCuentaContableDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoCuentaContableDataAccess.setProductoCuentaContableOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproductocuentacontable.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductocuentacontable.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductocuentacontable.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductocuentacontable.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public CentroCosto getCentroCosto(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relproductocuentacontable.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,ProductoCuentaContable relproductocuentacontable)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relproductocuentacontable.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoCuentaContable productocuentacontable) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productocuentacontable.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(productocuentacontable.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(productocuentacontable.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productocuentacontable.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productocuentacontable.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(productocuentacontable.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(productocuentacontable.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(productocuentacontable.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(productocuentacontable.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(productocuentacontable.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(productocuentacontable.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(productocuentacontable.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(productocuentacontable.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!productocuentacontable.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productocuentacontable.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productocuentacontable.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productocuentacontable.getId());
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
	
	public void setIsNewIsChangedFalseProductoCuentaContable(ProductoCuentaContable productocuentacontable)throws Exception  {		
		productocuentacontable.setIsNew(false);
		productocuentacontable.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoCuentaContables(List<ProductoCuentaContable> productocuentacontables)throws Exception  {				
		for(ProductoCuentaContable productocuentacontable:productocuentacontables) {
			productocuentacontable.setIsNew(false);
			productocuentacontable.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoCuentaContable(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
