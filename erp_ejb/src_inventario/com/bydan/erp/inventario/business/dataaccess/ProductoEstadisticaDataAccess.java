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
import com.bydan.erp.inventario.util.*;//ProductoEstadisticaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;




@SuppressWarnings("unused")
final public class ProductoEstadisticaDataAccess extends  ProductoEstadisticaDataAccessAdditional{ //ProductoEstadisticaDataAccessAdditional,DataAccessHelper<ProductoEstadistica>
	//static Logger logger = Logger.getLogger(ProductoEstadisticaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto_estadistica";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,precio_ultima_compra,precio_ultima_venta,precio_ultima_cotizacion,precio_ultima_proforma,cantidad_disponible,cantidad_reservada,cantidad_demanda,cantidad_maximo,cantidad_minimo,cantidad_fisica,cantidad_orden_compra,cantidad_pedida,cantidad_requisicion,fecha_ultima_ingreso,fecha_ultima_egreso,fecha_ultima_produccion,fecha_ultima_compra,fecha_ultima_venta,fecha_ultima_devolucion,fecha_ultima_orden_compra,fecha_ultima_pedido,fecha_ultima_requisicion,total_ingreso,total_egreso,total_compra,total_venta,total_producido,total_devuelto,costo_ultimo,costo_total,costo_produccion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,precio_ultima_compra=?,precio_ultima_venta=?,precio_ultima_cotizacion=?,precio_ultima_proforma=?,cantidad_disponible=?,cantidad_reservada=?,cantidad_demanda=?,cantidad_maximo=?,cantidad_minimo=?,cantidad_fisica=?,cantidad_orden_compra=?,cantidad_pedida=?,cantidad_requisicion=?,fecha_ultima_ingreso=?,fecha_ultima_egreso=?,fecha_ultima_produccion=?,fecha_ultima_compra=?,fecha_ultima_venta=?,fecha_ultima_devolucion=?,fecha_ultima_orden_compra=?,fecha_ultima_pedido=?,fecha_ultima_requisicion=?,total_ingreso=?,total_egreso=?,total_compra=?,total_venta=?,total_producido=?,total_devuelto=?,costo_ultimo=?,costo_total=?,costo_produccion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select productoestadistica from "+ProductoEstadisticaConstantesFunciones.SPERSISTENCENAME+" productoestadistica";
	public static String QUERYSELECTNATIVE="select "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".version_row,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_empresa,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_bodega,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id_producto,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_cotizacion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".precio_ultima_proforma,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_disponible,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_reservada,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_demanda,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_maximo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_minimo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_fisica,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_orden_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_pedida,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".cantidad_requisicion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_ingreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_egreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_produccion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_devolucion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_orden_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_pedido,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".fecha_ultima_requisicion,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_ingreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_egreso,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_compra,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_venta,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_producido,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".total_devuelto,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_ultimo,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_total,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".costo_produccion from "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME;//+" as "+ProductoEstadisticaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".id,"+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+".version_row from "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME;//+" as "+ProductoEstadisticaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoEstadisticaConstantesFunciones.SCHEMA+"."+ProductoEstadisticaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,precio_ultima_compra=?,precio_ultima_venta=?,precio_ultima_cotizacion=?,precio_ultima_proforma=?,cantidad_disponible=?,cantidad_reservada=?,cantidad_demanda=?,cantidad_maximo=?,cantidad_minimo=?,cantidad_fisica=?,cantidad_orden_compra=?,cantidad_pedida=?,cantidad_requisicion=?,fecha_ultima_ingreso=?,fecha_ultima_egreso=?,fecha_ultima_produccion=?,fecha_ultima_compra=?,fecha_ultima_venta=?,fecha_ultima_devolucion=?,fecha_ultima_orden_compra=?,fecha_ultima_pedido=?,fecha_ultima_requisicion=?,total_ingreso=?,total_egreso=?,total_compra=?,total_venta=?,total_producido=?,total_devuelto=?,costo_ultimo=?,costo_total=?,costo_produccion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTOESTADISTICA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTOESTADISTICA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTOESTADISTICA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTOESTADISTICA_SELECT(?,?)";
	
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
	
	
	protected ProductoEstadisticaDataAccessAdditional productoestadisticaDataAccessAdditional=null;
	
	public ProductoEstadisticaDataAccessAdditional getProductoEstadisticaDataAccessAdditional() {
		return this.productoestadisticaDataAccessAdditional;
	}
	
	public void setProductoEstadisticaDataAccessAdditional(ProductoEstadisticaDataAccessAdditional productoestadisticaDataAccessAdditional) {
		try {
			this.productoestadisticaDataAccessAdditional=productoestadisticaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoEstadisticaDataAccess() {
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
		ProductoEstadisticaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoEstadisticaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoEstadisticaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoEstadisticaOriginal(ProductoEstadistica productoestadistica)throws Exception  {
		productoestadistica.setProductoEstadisticaOriginal((ProductoEstadistica)productoestadistica.clone());		
	}
	
	public void setProductoEstadisticasOriginal(List<ProductoEstadistica> productoestadisticas)throws Exception  {
		
		for(ProductoEstadistica productoestadistica:productoestadisticas){
			productoestadistica.setProductoEstadisticaOriginal((ProductoEstadistica)productoestadistica.clone());
		}
	}
	
	public static void setProductoEstadisticaOriginalStatic(ProductoEstadistica productoestadistica)throws Exception  {
		productoestadistica.setProductoEstadisticaOriginal((ProductoEstadistica)productoestadistica.clone());		
	}
	
	public static void setProductoEstadisticasOriginalStatic(List<ProductoEstadistica> productoestadisticas)throws Exception  {
		
		for(ProductoEstadistica productoestadistica:productoestadisticas){
			productoestadistica.setProductoEstadisticaOriginal((ProductoEstadistica)productoestadistica.clone());
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
	
	public  ProductoEstadistica getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();		
		
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
	
	public  ProductoEstadistica getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.ProductoEstadistica.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoEstadisticaOriginal(new ProductoEstadistica());
      	    	entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoEstadistica("",entity,resultSet); 
				
				//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoEstadistica(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ProductoEstadistica getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();
				
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
	
	public  ProductoEstadistica getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoEstadisticaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoEstadistica.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoEstadisticaOriginal(new ProductoEstadistica());
      	    	entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProductoEstadistica("",entity,resultSet);    
				
				//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProductoEstadistica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ProductoEstadistica
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ProductoEstadistica entity = new ProductoEstadistica();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoEstadisticaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.ProductoEstadistica.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProductoEstadistica(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ProductoEstadistica> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		
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
	
	public  List<ProductoEstadistica> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoEstadisticaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoEstadistica();
      	    	entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoEstadistica("",entity,resultSet);
      	    	
				//entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
      	    	//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoEstadisticas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoEstadistica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoEstadistica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
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
	
	public  List<ProductoEstadistica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoEstadistica();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoEstadistica();
					//entity.setMapProductoEstadistica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoEstadisticaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoEstadistica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoEstadisticaDataAccess.getEntityProductoEstadistica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
					////entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoEstadisticas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoEstadistica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ProductoEstadistica getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();		  
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
	
	public  ProductoEstadistica getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoEstadistica();
				
				if(conMapGenerico) {
					entity.inicializarMapProductoEstadistica();
					//entity.setMapProductoEstadistica(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoEstadisticaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProductoEstadistica().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
					entity=ProductoEstadisticaDataAccess.getEntityProductoEstadistica("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
					////entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProductoEstadistica(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoEstadistica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ProductoEstadistica getEntityProductoEstadistica(String strPrefijo,ProductoEstadistica entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ProductoEstadistica.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ProductoEstadistica.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoEstadisticaDataAccess.setFieldReflectionProductoEstadistica(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProductoEstadistica=ProductoEstadisticaConstantesFunciones.getTodosTiposColumnasProductoEstadistica();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProductoEstadistica) {
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
							field = ProductoEstadistica.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ProductoEstadistica.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoEstadisticaDataAccess.setFieldReflectionProductoEstadistica(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProductoEstadistica(Field field,String strPrefijo,String sColumn,ProductoEstadistica entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoEstadisticaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADFISICA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALINGRESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALEGRESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALCOMPRA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.COSTOULTIMO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.COSTOTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoEstadistica>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoEstadisticaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ProductoEstadistica();
					entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProductoEstadistica("",entity,resultSet);
					
					//entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
					//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductoEstadisticas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoEstadistica(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ProductoEstadistica>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoEstadisticaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoEstadisticaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ProductoEstadistica> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
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
	
	public  List<ProductoEstadistica> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoEstadistica();
      	    	entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoEstadistica("",entity,resultSet);
      	    	
				//entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
      	    	//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductoEstadisticas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProductoEstadistica(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ProductoEstadistica> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
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
	
	public  List<ProductoEstadistica> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ProductoEstadistica> entities = new  ArrayList<ProductoEstadistica>();
		ProductoEstadistica entity = new ProductoEstadistica();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ProductoEstadistica();
      	    	entity=super.getEntity("",entity,resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProductoEstadistica("",entity,resultSet);
      	    	
				//entity.setProductoEstadisticaOriginal( new ProductoEstadistica());
      	    	//entity.setProductoEstadisticaOriginal(super.getEntity("",entity.getProductoEstadisticaOriginal(),resultSet,ProductoEstadisticaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoEstadisticaOriginal(this.getEntityProductoEstadistica("",entity.getProductoEstadisticaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductoEstadisticas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ProductoEstadistica getEntityProductoEstadistica(String strPrefijo,ProductoEstadistica entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProductoEstadisticaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProductoEstadisticaConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+ProductoEstadisticaConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+ProductoEstadisticaConstantesFunciones.IDPRODUCTO));
				entity.setprecio_ultima_compra(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOMPRA));
				entity.setprecio_ultima_venta(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.PRECIOULTIMAVENTA));
				entity.setprecio_ultima_cotizacion(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.PRECIOULTIMACOTIZACION));
				entity.setprecio_ultima_proforma(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.PRECIOULTIMAPROFORMA));
				entity.setcantidad_disponible(resultSet.getInt(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADDISPONIBLE));
				entity.setcantidad_reservada(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADRESERVADA));
				entity.setcantidad_demanda(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADDEMANDA));
				entity.setcantidad_maximo(resultSet.getInt(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADMAXIMO));
				entity.setcantidad_minimo(resultSet.getInt(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADMINIMO));
				entity.setcantidad_fisica(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADFISICA));
				entity.setcantidad_orden_compra(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADORDENCOMPRA));
				entity.setcantidad_pedida(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADPEDIDA));
				entity.setcantidad_requisicion(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.CANTIDADREQUISICION));
				entity.setfecha_ultima_ingreso(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAINGRESO).getTime()));
				entity.setfecha_ultima_egreso(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAEGRESO).getTime()));
				entity.setfecha_ultima_produccion(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAPRODUCCION).getTime()));
				entity.setfecha_ultima_compra(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMACOMPRA).getTime()));
				entity.setfecha_ultima_venta(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAVENTA).getTime()));
				entity.setfecha_ultima_devolucion(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMADEVOLUCION).getTime()));
				entity.setfecha_ultima_orden_compra(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAORDENCOMPRA).getTime()));
				entity.setfecha_ultima_pedido(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAPEDIDO).getTime()));
				entity.setfecha_ultima_requisicion(new Date(resultSet.getDate(strPrefijo+ProductoEstadisticaConstantesFunciones.FECHAULTIMAREQUISICION).getTime()));
				entity.settotal_ingreso(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALINGRESO));
				entity.settotal_egreso(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALEGRESO));
				entity.settotal_compra(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALCOMPRA));
				entity.settotal_venta(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALVENTA));
				entity.settotal_producido(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALPRODUCIDO));
				entity.settotal_devuelto(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.TOTALDEVUELTO));
				entity.setcosto_ultimo(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.COSTOULTIMO));
				entity.setcosto_total(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.COSTOTOTAL));
				entity.setcosto_produccion(resultSet.getDouble(strPrefijo+ProductoEstadisticaConstantesFunciones.COSTOPRODUCCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProductoEstadistica(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ProductoEstadistica entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoEstadisticaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoEstadisticaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoEstadisticaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoEstadisticaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoEstadisticaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoEstadisticaDataAccess.TABLENAME,ProductoEstadisticaDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoEstadisticaDataAccess.setProductoEstadisticaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ProductoEstadistica relproductoestadistica)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproductoestadistica.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,ProductoEstadistica relproductoestadistica)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproductoestadistica.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,ProductoEstadistica relproductoestadistica)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relproductoestadistica.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,ProductoEstadistica relproductoestadistica)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relproductoestadistica.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ProductoEstadistica productoestadistica) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!productoestadistica.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(productoestadistica.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(productoestadistica.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(productoestadistica.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(productoestadistica.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_ultima_compra=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_ultima_compra.setValue(productoestadistica.getprecio_ultima_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_ultima_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_ultima_venta=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_ultima_venta.setValue(productoestadistica.getprecio_ultima_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_ultima_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_ultima_cotizacion=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_ultima_cotizacion.setValue(productoestadistica.getprecio_ultima_cotizacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_ultima_cotizacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_ultima_proforma=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_ultima_proforma.setValue(productoestadistica.getprecio_ultima_proforma());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_ultima_proforma);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_disponible=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_disponible.setValue(productoestadistica.getcantidad_disponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_disponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_reservada=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_reservada.setValue(productoestadistica.getcantidad_reservada());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_reservada);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_demanda=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_demanda.setValue(productoestadistica.getcantidad_demanda());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_demanda);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_maximo=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_maximo.setValue(productoestadistica.getcantidad_maximo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_maximo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_minimo=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_minimo.setValue(productoestadistica.getcantidad_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_fisica=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_fisica.setValue(productoestadistica.getcantidad_fisica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_fisica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_orden_compra=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_orden_compra.setValue(productoestadistica.getcantidad_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_pedida=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_pedida.setValue(productoestadistica.getcantidad_pedida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pedida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecantidad_requisicion=new ParameterValue<Double>();
					parameterMaintenanceValuecantidad_requisicion.setValue(productoestadistica.getcantidad_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_ingreso.setValue(productoestadistica.getfecha_ultima_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_egreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_egreso.setValue(productoestadistica.getfecha_ultima_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_produccion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_produccion.setValue(productoestadistica.getfecha_ultima_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_compra=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_compra.setValue(productoestadistica.getfecha_ultima_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_venta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_venta.setValue(productoestadistica.getfecha_ultima_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_devolucion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_devolucion.setValue(productoestadistica.getfecha_ultima_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_orden_compra=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_orden_compra.setValue(productoestadistica.getfecha_ultima_orden_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_orden_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_pedido=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_pedido.setValue(productoestadistica.getfecha_ultima_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_requisicion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_requisicion.setValue(productoestadistica.getfecha_ultima_requisicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_requisicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_ingreso=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_ingreso.setValue(productoestadistica.gettotal_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_egreso=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_egreso.setValue(productoestadistica.gettotal_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_compra=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_compra.setValue(productoestadistica.gettotal_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_venta=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_venta.setValue(productoestadistica.gettotal_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_producido=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_producido.setValue(productoestadistica.gettotal_producido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_producido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_devuelto=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_devuelto.setValue(productoestadistica.gettotal_devuelto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_devuelto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_ultimo=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_ultimo.setValue(productoestadistica.getcosto_ultimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_ultimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_total=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_total.setValue(productoestadistica.getcosto_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_produccion=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_produccion.setValue(productoestadistica.getcosto_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_produccion);
					parametersTemp.add(parameterMaintenance);
					
						if(!productoestadistica.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(productoestadistica.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(productoestadistica.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(productoestadistica.getId());
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
	
	public void setIsNewIsChangedFalseProductoEstadistica(ProductoEstadistica productoestadistica)throws Exception  {		
		productoestadistica.setIsNew(false);
		productoestadistica.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductoEstadisticas(List<ProductoEstadistica> productoestadisticas)throws Exception  {				
		for(ProductoEstadistica productoestadistica:productoestadisticas) {
			productoestadistica.setIsNew(false);
			productoestadistica.setIsChanged(false);
		}
	}
	
	public void generarExportarProductoEstadistica(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
