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
import com.bydan.erp.inventario.util.*;//ProductoConstantesFunciones;


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
final public class ProductoDataAccess extends  ProductoDataAccessAdditional{ //ProductoDataAccessAdditional,DataAccessHelper<Producto>
	//static Logger logger = Logger.getLogger(ProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,codigo,nombre,nombre_extranjero,resumen_detalle,codigo_barra,id_linea,id_linea_grupo,id_linea_categoria,id_linea_marca,id_tipo_producto_servicio,id_tipo_producto_servicio_inven,id_tipo_costeo,id_unidad,id_unidad_peso,id_arancel,id_cliente,id_cliente_proveedor_defecto,esta_activo,descripcion,precio,iva,iva_valor,ice,ice_valor,descuento,descuento_valor,arancel_porcentaje,arancel_valor,comision,comision_valor,dias_produccion,con_stock_negativo,con_precio_minimo,con_lote,con_confirmacion,con_presupuesto,con_importacion,con_final,con_consep,con_serie,con_balanza,alto,ancho,largo,volumen,peso,gramos,unidades_caja,margen,factor,fob,fob2,id_tipo_producto,id_color_producto,id_clase_producto,id_efecto_producto,id_marca_producto,id_modelo_producto,id_material_producto,id_segmento_producto,id_talla_producto,grupo,referencia,aplicacion,procedencia)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,nombre_extranjero=?,resumen_detalle=?,codigo_barra=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_tipo_producto_servicio=?,id_tipo_producto_servicio_inven=?,id_tipo_costeo=?,id_unidad=?,id_unidad_peso=?,id_arancel=?,id_cliente=?,id_cliente_proveedor_defecto=?,esta_activo=?,descripcion=?,precio=?,iva=?,iva_valor=?,ice=?,ice_valor=?,descuento=?,descuento_valor=?,arancel_porcentaje=?,arancel_valor=?,comision=?,comision_valor=?,dias_produccion=?,con_stock_negativo=?,con_precio_minimo=?,con_lote=?,con_confirmacion=?,con_presupuesto=?,con_importacion=?,con_final=?,con_consep=?,con_serie=?,con_balanza=?,alto=?,ancho=?,largo=?,volumen=?,peso=?,gramos=?,unidades_caja=?,margen=?,factor=?,fob=?,fob2=?,id_tipo_producto=?,id_color_producto=?,id_clase_producto=?,id_efecto_producto=?,id_marca_producto=?,id_modelo_producto=?,id_material_producto=?,id_segmento_producto=?,id_talla_producto=?,grupo=?,referencia=?,aplicacion=?,procedencia=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select producto from "+ProductoConstantesFunciones.SPERSISTENCENAME+" producto";
	public static String QUERYSELECTNATIVE="select "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".version_row,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_empresa,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_sucursal,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".codigo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".nombre,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".nombre_extranjero,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".resumen_detalle,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".codigo_barra,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_grupo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_categoria,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_linea_marca,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto_servicio_inven,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_costeo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_unidad,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_unidad_peso,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_arancel,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_cliente,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_cliente_proveedor_defecto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".esta_activo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descripcion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".precio,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".iva,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".iva_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ice,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ice_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descuento,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".descuento_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".arancel_porcentaje,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".arancel_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".comision,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".comision_valor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".dias_produccion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_stock_negativo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_precio_minimo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_lote,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_confirmacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_presupuesto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_importacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_final,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_consep,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_serie,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".con_balanza,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".alto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".ancho,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".largo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".volumen,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".peso,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".gramos,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".unidades_caja,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".margen,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".factor,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".fob,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".fob2,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_tipo_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_color_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_clase_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_efecto_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_marca_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_modelo_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_material_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_segmento_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id_talla_producto,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".grupo,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".referencia,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".aplicacion,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".procedencia from "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME;//+" as "+ProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".id,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".version_row,"+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+".nombre from "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME;//+" as "+ProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ProductoConstantesFunciones.SCHEMA+"."+ProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,nombre_extranjero=?,resumen_detalle=?,codigo_barra=?,id_linea=?,id_linea_grupo=?,id_linea_categoria=?,id_linea_marca=?,id_tipo_producto_servicio=?,id_tipo_producto_servicio_inven=?,id_tipo_costeo=?,id_unidad=?,id_unidad_peso=?,id_arancel=?,id_cliente=?,id_cliente_proveedor_defecto=?,esta_activo=?,descripcion=?,precio=?,iva=?,iva_valor=?,ice=?,ice_valor=?,descuento=?,descuento_valor=?,arancel_porcentaje=?,arancel_valor=?,comision=?,comision_valor=?,dias_produccion=?,con_stock_negativo=?,con_precio_minimo=?,con_lote=?,con_confirmacion=?,con_presupuesto=?,con_importacion=?,con_final=?,con_consep=?,con_serie=?,con_balanza=?,alto=?,ancho=?,largo=?,volumen=?,peso=?,gramos=?,unidades_caja=?,margen=?,factor=?,fob=?,fob2=?,id_tipo_producto=?,id_color_producto=?,id_clase_producto=?,id_efecto_producto=?,id_marca_producto=?,id_modelo_producto=?,id_material_producto=?,id_segmento_producto=?,id_talla_producto=?,grupo=?,referencia=?,aplicacion=?,procedencia=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRODUCTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRODUCTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRODUCTO_SELECT(?,?)";
	
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
	
	
	protected ProductoDataAccessAdditional productoDataAccessAdditional=null;
	
	public ProductoDataAccessAdditional getProductoDataAccessAdditional() {
		return this.productoDataAccessAdditional;
	}
	
	public void setProductoDataAccessAdditional(ProductoDataAccessAdditional productoDataAccessAdditional) {
		try {
			this.productoDataAccessAdditional=productoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ProductoDataAccess() {
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
		ProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setProductoOriginal(Producto producto)throws Exception  {
		producto.setProductoOriginal((Producto)producto.clone());		
	}
	
	public void setProductosOriginal(List<Producto> productos)throws Exception  {
		
		for(Producto producto:productos){
			producto.setProductoOriginal((Producto)producto.clone());
		}
	}
	
	public static void setProductoOriginalStatic(Producto producto)throws Exception  {
		producto.setProductoOriginal((Producto)producto.clone());		
	}
	
	public static void setProductosOriginalStatic(List<Producto> productos)throws Exception  {
		
		for(Producto producto:productos){
			producto.setProductoOriginal((Producto)producto.clone());
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
	
	public  Producto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Producto entity = new Producto();		
		
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
	
	public  Producto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Producto entity = new Producto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Producto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setProductoOriginal(new Producto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProducto("",entity,resultSet); 
				
				//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Producto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Producto entity = new Producto();
				
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
	
	public  Producto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Producto entity = new Producto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Producto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setProductoOriginal(new Producto());
      	    	entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityProducto("",entity,resultSet);    
				
				//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Producto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Producto entity = new Producto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Producto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Producto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		
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
	
	public  List<Producto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Producto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProducto("",entity,resultSet);
      	    	
				//entity.setProductoOriginal( new Producto());
      	    	//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Producto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
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
	
	public  List<Producto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Producto();
				
				if(conMapGenerico) {
					entity.inicializarMapProducto();
					//entity.setMapProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoDataAccess.getEntityProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOriginal( new Producto());
					////entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Producto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Producto entity = new Producto();		  
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
	
	public  Producto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Producto entity = new Producto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Producto();
				
				if(conMapGenerico) {
					entity.inicializarMapProducto();
					//entity.setMapProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
					entity=ProductoDataAccess.getEntityProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setProductoOriginal( new Producto());
					////entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Producto getEntityProducto(String strPrefijo,Producto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Producto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Producto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ProductoDataAccess.setFieldReflectionProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasProducto=ProductoConstantesFunciones.getTodosTiposColumnasProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasProducto) {
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
							field = Producto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Producto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ProductoDataAccess.setFieldReflectionProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionProducto(Field field,String strPrefijo,String sColumn,Producto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.NOMBREEXTRANJERO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.RESUMENDETALLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.CODIGOBARRA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDLINEA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDLINEAGRUPO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDLINEACATEGORIA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDLINEAMARCA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDTIPOCOSTEO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDUNIDADPESO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDARANCEL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.ARANCELPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.ARANCELVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.COMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.COMISIONVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.DIASPRODUCCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONSTOCKNEGATIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONPRECIOMINIMO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONLOTE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONCONFIRMACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONPRESUPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONIMPORTACION:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONFINAL:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONCONSEP:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONSERIE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.CONBALANZA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case ProductoConstantesFunciones.ALTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.ANCHO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.LARGO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.VOLUMEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.PESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.GRAMOS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.UNIDADESCAJA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.MARGEN:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.FACTOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.FOB:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.FOB2:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDTIPOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDCOLORPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDCLASEPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDEFECTOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDMARCAPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDMODELOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDMATERIALPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDSEGMENTOPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.IDTALLAPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ProductoConstantesFunciones.GRUPO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.APLICACION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ProductoConstantesFunciones.PROCEDENCIA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Producto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Producto();
					entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityProducto("",entity,resultSet);
					
					//entity.setProductoOriginal( new Producto());
					//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Producto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Producto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
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
	
	public  List<Producto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Producto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProducto("",entity,resultSet);
      	    	
				//entity.setProductoOriginal( new Producto());
      	    	//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Producto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
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
	
	public  List<Producto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Producto> entities = new  ArrayList<Producto>();
		Producto entity = new Producto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Producto();
      	    	entity=super.getEntity("",entity,resultSet,ProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityProducto("",entity,resultSet);
      	    	
				//entity.setProductoOriginal( new Producto());
      	    	//entity.setProductoOriginal(super.getEntity("",entity.getProductoOriginal(),resultSet,ProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setProductoOriginal(this.getEntityProducto("",entity.getProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Producto getEntityProducto(String strPrefijo,Producto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDSUCURSAL));
				entity.setcodigo(resultSet.getString(strPrefijo+ProductoConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+ProductoConstantesFunciones.NOMBRE));
				entity.setnombre_extranjero(resultSet.getString(strPrefijo+ProductoConstantesFunciones.NOMBREEXTRANJERO));
				entity.setresumen_detalle(resultSet.getString(strPrefijo+ProductoConstantesFunciones.RESUMENDETALLE));
				entity.setcodigo_barra(resultSet.getString(strPrefijo+ProductoConstantesFunciones.CODIGOBARRA));
				entity.setid_linea(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDLINEA));
				entity.setid_linea_grupo(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDLINEAGRUPO));if(resultSet.wasNull()) {entity.setid_linea_grupo(null); }
				entity.setid_linea_categoria(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDLINEACATEGORIA));if(resultSet.wasNull()) {entity.setid_linea_categoria(null); }
				entity.setid_linea_marca(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDLINEAMARCA));if(resultSet.wasNull()) {entity.setid_linea_marca(null); }
				entity.setid_tipo_producto_servicio(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIO));
				entity.setid_tipo_producto_servicio_inven(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDTIPOPRODUCTOSERVICIOINVEN));
				entity.setid_tipo_costeo(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDTIPOCOSTEO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDUNIDAD));
				entity.setid_unidad_peso(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDUNIDADPESO));
				entity.setid_arancel(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDARANCEL));
				entity.setid_cliente(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDCLIENTE));
				entity.setid_cliente_proveedor_defecto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDCLIENTEPROVEEDORDEFECTO));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.ESTAACTIVO));
				entity.setdescripcion(resultSet.getString(strPrefijo+ProductoConstantesFunciones.DESCRIPCION));
				entity.setprecio(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.PRECIO));
				entity.setiva(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.IVAVALOR));
				entity.setice(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ICEVALOR));
				entity.setdescuento(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.DESCUENTO));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.DESCUENTOVALOR));
				entity.setarancel_porcentaje(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ARANCELPORCENTAJE));
				entity.setarancel_valor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ARANCELVALOR));
				entity.setcomision(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.COMISION));
				entity.setcomision_valor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.COMISIONVALOR));
				entity.setdias_produccion(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.DIASPRODUCCION));
				entity.setcon_stock_negativo(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONSTOCKNEGATIVO));
				entity.setcon_precio_minimo(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONPRECIOMINIMO));
				entity.setcon_lote(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONLOTE));
				entity.setcon_confirmacion(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONCONFIRMACION));
				entity.setcon_presupuesto(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONPRESUPUESTO));
				entity.setcon_importacion(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONIMPORTACION));
				entity.setcon_final(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONFINAL));
				entity.setcon_consep(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONCONSEP));
				entity.setcon_serie(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONSERIE));
				entity.setcon_balanza(resultSet.getBoolean(strPrefijo+ProductoConstantesFunciones.CONBALANZA));
				entity.setalto(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ALTO));
				entity.setancho(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.ANCHO));
				entity.setlargo(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.LARGO));
				entity.setvolumen(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.VOLUMEN));
				entity.setpeso(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.PESO));
				entity.setgramos(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.GRAMOS));
				entity.setunidades_caja(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.UNIDADESCAJA));
				entity.setmargen(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.MARGEN));
				entity.setfactor(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.FACTOR));
				entity.setfob(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.FOB));
				entity.setfob2(resultSet.getDouble(strPrefijo+ProductoConstantesFunciones.FOB2));
				entity.setid_tipo_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDTIPOPRODUCTO));
				entity.setid_color_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDCOLORPRODUCTO));
				entity.setid_clase_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDCLASEPRODUCTO));
				entity.setid_efecto_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDEFECTOPRODUCTO));
				entity.setid_marca_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDMARCAPRODUCTO));
				entity.setid_modelo_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDMODELOPRODUCTO));
				entity.setid_material_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDMATERIALPRODUCTO));
				entity.setid_segmento_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDSEGMENTOPRODUCTO));
				entity.setid_talla_producto(resultSet.getLong(strPrefijo+ProductoConstantesFunciones.IDTALLAPRODUCTO));
				entity.setgrupo(resultSet.getString(strPrefijo+ProductoConstantesFunciones.GRUPO));
				entity.setreferencia(resultSet.getString(strPrefijo+ProductoConstantesFunciones.REFERENCIA));
				entity.setaplicacion(resultSet.getString(strPrefijo+ProductoConstantesFunciones.APLICACION));
				entity.setprocedencia(resultSet.getString(strPrefijo+ProductoConstantesFunciones.PROCEDENCIA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+ProductoConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Producto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ProductoDataAccess.TABLENAME,ProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			ProductoDataAccess.setProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relproducto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Linea getLinea(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproducto.getid_linea());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaGrupo(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproducto.getid_linea_grupo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaCategoria(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproducto.getid_linea_categoria());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public Linea getLineaMarca(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Linea linea= new Linea();

		try {
			LineaDataAccess lineaDataAccess=new LineaDataAccess();

			lineaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			lineaDataAccess.setConnexionType(this.connexionType);
			lineaDataAccess.setParameterDbType(this.parameterDbType);

			linea=lineaDataAccess.getEntity(connexion,relproducto.getid_linea_marca());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return linea;

	}

	public TipoProductoServicio getTipoProductoServicio(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		TipoProductoServicio tipoproductoservicio= new TipoProductoServicio();

		try {
			TipoProductoServicioDataAccess tipoproductoservicioDataAccess=new TipoProductoServicioDataAccess();

			tipoproductoservicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,relproducto.getid_tipo_producto_servicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicio;

	}

	public TipoProductoServicioInven getTipoProductoServicioInven(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		TipoProductoServicioInven tipoproductoservicioinven= new TipoProductoServicioInven();

		try {
			TipoProductoServicioInvenDataAccess tipoproductoservicioinvenDataAccess=new TipoProductoServicioInvenDataAccess();

			tipoproductoservicioinvenDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoservicioinvenDataAccess.setConnexionType(this.connexionType);
			tipoproductoservicioinvenDataAccess.setParameterDbType(this.parameterDbType);

			tipoproductoservicioinven=tipoproductoservicioinvenDataAccess.getEntity(connexion,relproducto.getid_tipo_producto_servicio_inven());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproductoservicioinven;

	}

	public TipoCosteo getTipoCosteo(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		TipoCosteo tipocosteo= new TipoCosteo();

		try {
			TipoCosteoDataAccess tipocosteoDataAccess=new TipoCosteoDataAccess();

			tipocosteoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipocosteoDataAccess.setConnexionType(this.connexionType);
			tipocosteoDataAccess.setParameterDbType(this.parameterDbType);

			tipocosteo=tipocosteoDataAccess.getEntity(connexion,relproducto.getid_tipo_costeo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipocosteo;

	}

	public Unidad getUnidad(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproducto.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Unidad getUnidadPeso(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relproducto.getid_unidad_peso());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public Arancel getArancel(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Arancel arancel= new Arancel();

		try {
			ArancelDataAccess arancelDataAccess=new ArancelDataAccess();

			arancelDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			arancelDataAccess.setConnexionType(this.connexionType);
			arancelDataAccess.setParameterDbType(this.parameterDbType);

			arancel=arancelDataAccess.getEntity(connexion,relproducto.getid_arancel());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return arancel;

	}

	public Cliente getCliente(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relproducto.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Cliente getClienteProveedorDefecto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relproducto.getid_cliente_proveedor_defecto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public TipoProducto getTipoProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		TipoProducto tipoproducto= new TipoProducto();

		try {
			TipoProductoDataAccess tipoproductoDataAccess=new TipoProductoDataAccess();

			tipoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoproductoDataAccess.setConnexionType(this.connexionType);
			tipoproductoDataAccess.setParameterDbType(this.parameterDbType);

			tipoproducto=tipoproductoDataAccess.getEntity(connexion,relproducto.getid_tipo_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoproducto;

	}

	public ColorProducto getColorProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		ColorProducto colorproducto= new ColorProducto();

		try {
			ColorProductoDataAccess colorproductoDataAccess=new ColorProductoDataAccess();

			colorproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			colorproductoDataAccess.setConnexionType(this.connexionType);
			colorproductoDataAccess.setParameterDbType(this.parameterDbType);

			colorproducto=colorproductoDataAccess.getEntity(connexion,relproducto.getid_color_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return colorproducto;

	}

	public ClaseProducto getClaseProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		ClaseProducto claseproducto= new ClaseProducto();

		try {
			ClaseProductoDataAccess claseproductoDataAccess=new ClaseProductoDataAccess();

			claseproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			claseproductoDataAccess.setConnexionType(this.connexionType);
			claseproductoDataAccess.setParameterDbType(this.parameterDbType);

			claseproducto=claseproductoDataAccess.getEntity(connexion,relproducto.getid_clase_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return claseproducto;

	}

	public EfectoProducto getEfectoProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		EfectoProducto efectoproducto= new EfectoProducto();

		try {
			EfectoProductoDataAccess efectoproductoDataAccess=new EfectoProductoDataAccess();

			efectoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			efectoproductoDataAccess.setConnexionType(this.connexionType);
			efectoproductoDataAccess.setParameterDbType(this.parameterDbType);

			efectoproducto=efectoproductoDataAccess.getEntity(connexion,relproducto.getid_efecto_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return efectoproducto;

	}

	public MarcaProducto getMarcaProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		MarcaProducto marcaproducto= new MarcaProducto();

		try {
			MarcaProductoDataAccess marcaproductoDataAccess=new MarcaProductoDataAccess();

			marcaproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			marcaproductoDataAccess.setConnexionType(this.connexionType);
			marcaproductoDataAccess.setParameterDbType(this.parameterDbType);

			marcaproducto=marcaproductoDataAccess.getEntity(connexion,relproducto.getid_marca_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return marcaproducto;

	}

	public ModeloProducto getModeloProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		ModeloProducto modeloproducto= new ModeloProducto();

		try {
			ModeloProductoDataAccess modeloproductoDataAccess=new ModeloProductoDataAccess();

			modeloproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			modeloproductoDataAccess.setConnexionType(this.connexionType);
			modeloproductoDataAccess.setParameterDbType(this.parameterDbType);

			modeloproducto=modeloproductoDataAccess.getEntity(connexion,relproducto.getid_modelo_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return modeloproducto;

	}

	public MaterialProducto getMaterialProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		MaterialProducto materialproducto= new MaterialProducto();

		try {
			MaterialProductoDataAccess materialproductoDataAccess=new MaterialProductoDataAccess();

			materialproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			materialproductoDataAccess.setConnexionType(this.connexionType);
			materialproductoDataAccess.setParameterDbType(this.parameterDbType);

			materialproducto=materialproductoDataAccess.getEntity(connexion,relproducto.getid_material_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return materialproducto;

	}

	public SegmentoProducto getSegmentoProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		SegmentoProducto segmentoproducto= new SegmentoProducto();

		try {
			SegmentoProductoDataAccess segmentoproductoDataAccess=new SegmentoProductoDataAccess();

			segmentoproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			segmentoproductoDataAccess.setConnexionType(this.connexionType);
			segmentoproductoDataAccess.setParameterDbType(this.parameterDbType);

			segmentoproducto=segmentoproductoDataAccess.getEntity(connexion,relproducto.getid_segmento_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return segmentoproducto;

	}

	public TallaProducto getTallaProducto(Connexion connexion,Producto relproducto)throws SQLException,Exception {

		TallaProducto tallaproducto= new TallaProducto();

		try {
			TallaProductoDataAccess tallaproductoDataAccess=new TallaProductoDataAccess();

			tallaproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tallaproductoDataAccess.setConnexionType(this.connexionType);
			tallaproductoDataAccess.setParameterDbType(this.parameterDbType);

			tallaproducto=tallaproductoDataAccess.getEntity(connexion,relproducto.getid_talla_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tallaproducto;

	}


		
		public List<ProveedorProducto> getProveedorProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProveedorProducto> proveedorproductos= new ArrayList<ProveedorProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProveedorProductoConstantesFunciones.SCHEMA+".proveedor_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN proveedorproducto.Producto WHERE proveedorproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProveedorProductoDataAccess proveedorproductoDataAccess=new ProveedorProductoDataAccess();

			proveedorproductoDataAccess.setConnexionType(this.connexionType);
			proveedorproductoDataAccess.setParameterDbType(this.parameterDbType);
			proveedorproductos=proveedorproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return proveedorproductos;

	}

	public List<Precio> getPrecios(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<Precio> precios= new ArrayList<Precio>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+PrecioConstantesFunciones.SCHEMA+".precio.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN precio.Producto WHERE precio.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PrecioDataAccess precioDataAccess=new PrecioDataAccess();

			precioDataAccess.setConnexionType(this.connexionType);
			precioDataAccess.setParameterDbType(this.parameterDbType);
			precios=precioDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return precios;

	}

	public List<DetalleImpuestoInven> getDetalleImpuestoInvens(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<DetalleImpuestoInven> detalleimpuestoinvens= new ArrayList<DetalleImpuestoInven>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+DetalleImpuestoInvenConstantesFunciones.SCHEMA+".detalle_impuesto_inven.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN detalleimpuestoinven.Producto WHERE detalleimpuestoinven.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleImpuestoInvenDataAccess detalleimpuestoinvenDataAccess=new DetalleImpuestoInvenDataAccess();

			detalleimpuestoinvenDataAccess.setConnexionType(this.connexionType);
			detalleimpuestoinvenDataAccess.setParameterDbType(this.parameterDbType);
			detalleimpuestoinvens=detalleimpuestoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleimpuestoinvens;

	}

	public List<PresupuestoVentas> getPresupuestoVentass(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<PresupuestoVentas> presupuestoventass= new ArrayList<PresupuestoVentas>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+PresupuestoVentasConstantesFunciones.SCHEMA+".presupuesto_ventas.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN presupuestoventas.Producto WHERE presupuestoventas.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoVentasDataAccess presupuestoventasDataAccess=new PresupuestoVentasDataAccess();

			presupuestoventasDataAccess.setConnexionType(this.connexionType);
			presupuestoventasDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoventass;

	}

	public List<PoliticaProducto> getPoliticaProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<PoliticaProducto> politicaproductos= new ArrayList<PoliticaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+PoliticaProductoConstantesFunciones.SCHEMA+".politica_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN politicaproducto.Producto WHERE politicaproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticaProductoDataAccess politicaproductoDataAccess=new PoliticaProductoDataAccess();

			politicaproductoDataAccess.setConnexionType(this.connexionType);
			politicaproductoDataAccess.setParameterDbType(this.parameterDbType);
			politicaproductos=politicaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicaproductos;

	}

	public List<SerieProducto> getSerieProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<SerieProducto> serieproductos= new ArrayList<SerieProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+SerieProductoConstantesFunciones.SCHEMA+".serie_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN serieproducto.Producto WHERE serieproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SerieProductoDataAccess serieproductoDataAccess=new SerieProductoDataAccess();

			serieproductoDataAccess.setConnexionType(this.connexionType);
			serieproductoDataAccess.setParameterDbType(this.parameterDbType);
			serieproductos=serieproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serieproductos;

	}

	public List<UbicacionProdu> getUbicacionProdus(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<UbicacionProdu> ubicacionprodus= new ArrayList<UbicacionProdu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+UbicacionProduConstantesFunciones.SCHEMA+".ubicacion_produ.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN ubicacionprodu.Producto WHERE ubicacionprodu.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			UbicacionProduDataAccess ubicacionproduDataAccess=new UbicacionProduDataAccess();

			ubicacionproduDataAccess.setConnexionType(this.connexionType);
			ubicacionproduDataAccess.setParameterDbType(this.parameterDbType);
			ubicacionprodus=ubicacionproduDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ubicacionprodus;

	}

	public List<ParametroProducto> getParametroProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ParametroProducto> parametroproductos= new ArrayList<ParametroProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ParametroProductoConstantesFunciones.SCHEMA+".parametro_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN parametroproducto.Producto WHERE parametroproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ParametroProductoDataAccess parametroproductoDataAccess=new ParametroProductoDataAccess();

			parametroproductoDataAccess.setConnexionType(this.connexionType);
			parametroproductoDataAccess.setParameterDbType(this.parameterDbType);
			parametroproductos=parametroproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return parametroproductos;

	}

	public List<ProductoUnidad> getProductoUnidads(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoUnidad> productounidads= new ArrayList<ProductoUnidad>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoUnidadConstantesFunciones.SCHEMA+".producto_unidad.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productounidad.Producto WHERE productounidad.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoUnidadDataAccess productounidadDataAccess=new ProductoUnidadDataAccess();

			productounidadDataAccess.setConnexionType(this.connexionType);
			productounidadDataAccess.setParameterDbType(this.parameterDbType);
			productounidads=productounidadDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productounidads;

	}

	public List<Ingrediente> getIngredienteRelacions(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<Ingrediente> ingredienterelacions= new ArrayList<Ingrediente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+IngredienteConstantesFunciones.SCHEMA+".ingrediente.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN ingrediente.ProductoRelacion WHERE ingrediente.ProductoRelacion.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			IngredienteDataAccess ingredienteDataAccess=new IngredienteDataAccess();

			ingredienteDataAccess.setConnexionType(this.connexionType);
			ingredienteDataAccess.setParameterDbType(this.parameterDbType);
			ingredienterelacions=ingredienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ingredienterelacions;

	}

	public List<ProductoCarac> getProductoCaracs(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoCarac> productocaracs= new ArrayList<ProductoCarac>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoCaracConstantesFunciones.SCHEMA+".producto_carac.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productocarac.Producto WHERE productocarac.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoCaracDataAccess productocaracDataAccess=new ProductoCaracDataAccess();

			productocaracDataAccess.setConnexionType(this.connexionType);
			productocaracDataAccess.setParameterDbType(this.parameterDbType);
			productocaracs=productocaracDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productocaracs;

	}

	public List<ServicioCliente> getServicioClientes(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ServicioCliente> servicioclientes= new ArrayList<ServicioCliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ServicioClienteConstantesFunciones.SCHEMA+".servicio_cliente.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN serviciocliente.Producto WHERE serviciocliente.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ServicioClienteDataAccess servicioclienteDataAccess=new ServicioClienteDataAccess();

			servicioclienteDataAccess.setConnexionType(this.connexionType);
			servicioclienteDataAccess.setParameterDbType(this.parameterDbType);
			servicioclientes=servicioclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return servicioclientes;

	}

	public List<ProductoPromocion> getProductoPromocionRelacions(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoPromocion> productopromocionrelacions= new ArrayList<ProductoPromocion>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoPromocionConstantesFunciones.SCHEMA+".producto_promocion.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productopromocion.ProductoRelacion WHERE productopromocion.ProductoRelacion.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoPromocionDataAccess productopromocionDataAccess=new ProductoPromocionDataAccess();

			productopromocionDataAccess.setConnexionType(this.connexionType);
			productopromocionDataAccess.setParameterDbType(this.parameterDbType);
			productopromocionrelacions=productopromocionDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productopromocionrelacions;

	}

	public List<ProductoEspeci> getProductoEspecis(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoEspeci> productoespecis= new ArrayList<ProductoEspeci>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoEspeciConstantesFunciones.SCHEMA+".producto_especi.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productoespeci.Producto WHERE productoespeci.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoEspeciDataAccess productoespeciDataAccess=new ProductoEspeciDataAccess();

			productoespeciDataAccess.setConnexionType(this.connexionType);
			productoespeciDataAccess.setParameterDbType(this.parameterDbType);
			productoespecis=productoespeciDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoespecis;

	}

	public List<ProductoReempla> getProductoReemplas(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoReempla> productoreemplas= new ArrayList<ProductoReempla>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoReemplaConstantesFunciones.SCHEMA+".producto_reempla.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productoreempla.Producto WHERE productoreempla.Producto.id="+String.valueOf(producto.getId());

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

	public List<ProductoEstadistica> getProductoEstadisticas(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoEstadistica> productoestadisticas= new ArrayList<ProductoEstadistica>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoEstadisticaConstantesFunciones.SCHEMA+".producto_estadistica.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productoestadistica.Producto WHERE productoestadistica.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoEstadisticaDataAccess productoestadisticaDataAccess=new ProductoEstadisticaDataAccess();

			productoestadisticaDataAccess.setConnexionType(this.connexionType);
			productoestadisticaDataAccess.setParameterDbType(this.parameterDbType);
			productoestadisticas=productoestadisticaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productoestadisticas;

	}

	public List<PoliticaFactu> getPoliticaFactus(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<PoliticaFactu> politicafactus= new ArrayList<PoliticaFactu>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+PoliticaFactuConstantesFunciones.SCHEMA+".politica_factu.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN politicafactu.Producto WHERE politicafactu.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PoliticaFactuDataAccess politicafactuDataAccess=new PoliticaFactuDataAccess();

			politicafactuDataAccess.setConnexionType(this.connexionType);
			politicafactuDataAccess.setParameterDbType(this.parameterDbType);
			politicafactus=politicafactuDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return politicafactus;

	}

	public List<ProductoCuentaContable> getProductoCuentaContables(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<ProductoCuentaContable> productocuentacontables= new ArrayList<ProductoCuentaContable>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+ProductoCuentaContableConstantesFunciones.SCHEMA+".producto_cuenta_contable.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN productocuentacontable.Producto WHERE productocuentacontable.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ProductoCuentaContableDataAccess productocuentacontableDataAccess=new ProductoCuentaContableDataAccess();

			productocuentacontableDataAccess.setConnexionType(this.connexionType);
			productocuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			productocuentacontables=productocuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return productocuentacontables;

	}

	public List<BodegaProducto> getBodegaProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<BodegaProducto> bodegaproductos= new ArrayList<BodegaProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+BodegaProductoConstantesFunciones.SCHEMA+".bodega_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN bodegaproducto.Producto WHERE bodegaproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			BodegaProductoDataAccess bodegaproductoDataAccess=new BodegaProductoDataAccess();

			bodegaproductoDataAccess.setConnexionType(this.connexionType);
			bodegaproductoDataAccess.setParameterDbType(this.parameterDbType);
			bodegaproductos=bodegaproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodegaproductos;

	}

	public List<PresupuestoProducto> getPresupuestoProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<PresupuestoProducto> presupuestoproductos= new ArrayList<PresupuestoProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+PresupuestoProductoConstantesFunciones.SCHEMA+".presupuesto_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN presupuestoproducto.Producto WHERE presupuestoproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoProductoDataAccess presupuestoproductoDataAccess=new PresupuestoProductoDataAccess();

			presupuestoproductoDataAccess.setConnexionType(this.connexionType);
			presupuestoproductoDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoproductos=presupuestoproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoproductos;

	}

	public List<SaldoMesProducto> getSaldoMesProductos(Connexion connexion,Producto producto)throws SQLException,Exception {

		List<SaldoMesProducto> saldomesproductos= new ArrayList<SaldoMesProducto>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+ProductoConstantesFunciones.SCHEMA+".producto ON "+SaldoMesProductoConstantesFunciones.SCHEMA+".saldo_mes_producto.id_producto="+ProductoConstantesFunciones.SCHEMA+".producto.id WHERE "+ProductoConstantesFunciones.SCHEMA+".producto.id="+String.valueOf(producto.getId());
			} else {
				sQuery=" INNER JOIN saldomesproducto.Producto WHERE saldomesproducto.Producto.id="+String.valueOf(producto.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			SaldoMesProductoDataAccess saldomesproductoDataAccess=new SaldoMesProductoDataAccess();

			saldomesproductoDataAccess.setConnexionType(this.connexionType);
			saldomesproductoDataAccess.setParameterDbType(this.parameterDbType);
			saldomesproductos=saldomesproductoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return saldomesproductos;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Producto producto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!producto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(producto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(producto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(producto.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(producto.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_extranjero=new ParameterValue<String>();
					parameterMaintenanceValuenombre_extranjero.setValue(producto.getnombre_extranjero());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_extranjero);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresumen_detalle=new ParameterValue<String>();
					parameterMaintenanceValueresumen_detalle.setValue(producto.getresumen_detalle());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresumen_detalle);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_barra=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_barra.setValue(producto.getcodigo_barra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_barra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea.setValue(producto.getid_linea());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_grupo=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_grupo.setValue(producto.getid_linea_grupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_grupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_categoria=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_categoria.setValue(producto.getid_linea_categoria());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_categoria);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_linea_marca=new ParameterValue<Long>();
					parameterMaintenanceValueid_linea_marca.setValue(producto.getid_linea_marca());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_linea_marca);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto_servicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto_servicio.setValue(producto.getid_tipo_producto_servicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto_servicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto_servicio_inven=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto_servicio_inven.setValue(producto.getid_tipo_producto_servicio_inven());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto_servicio_inven);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_costeo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_costeo.setValue(producto.getid_tipo_costeo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_costeo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(producto.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad_peso=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad_peso.setValue(producto.getid_unidad_peso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad_peso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_arancel=new ParameterValue<Long>();
					parameterMaintenanceValueid_arancel.setValue(producto.getid_arancel());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_arancel);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(producto.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente_proveedor_defecto=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente_proveedor_defecto.setValue(producto.getid_cliente_proveedor_defecto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente_proveedor_defecto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(producto.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(producto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(producto.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(producto.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(producto.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(producto.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(producto.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(producto.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(producto.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuearancel_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuearancel_porcentaje.setValue(producto.getarancel_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearancel_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuearancel_valor=new ParameterValue<Double>();
					parameterMaintenanceValuearancel_valor.setValue(producto.getarancel_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearancel_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecomision=new ParameterValue<Double>();
					parameterMaintenanceValuecomision.setValue(producto.getcomision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecomision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecomision_valor=new ParameterValue<Double>();
					parameterMaintenanceValuecomision_valor.setValue(producto.getcomision_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecomision_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_produccion=new ParameterValue<Double>();
					parameterMaintenanceValuedias_produccion.setValue(producto.getdias_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_stock_negativo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_stock_negativo.setValue(producto.getcon_stock_negativo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_stock_negativo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_precio_minimo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_precio_minimo.setValue(producto.getcon_precio_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_precio_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_lote=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_lote.setValue(producto.getcon_lote());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_lote);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_confirmacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_confirmacion.setValue(producto.getcon_confirmacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_confirmacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_presupuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_presupuesto.setValue(producto.getcon_presupuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_presupuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_importacion=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_importacion.setValue(producto.getcon_importacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_importacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_final=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_final.setValue(producto.getcon_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_consep=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_consep.setValue(producto.getcon_consep());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_consep);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_serie=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_serie.setValue(producto.getcon_serie());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_serie);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_balanza=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_balanza.setValue(producto.getcon_balanza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_balanza);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuealto=new ParameterValue<Double>();
					parameterMaintenanceValuealto.setValue(producto.getalto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuealto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueancho=new ParameterValue<Double>();
					parameterMaintenanceValueancho.setValue(producto.getancho());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueancho);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuelargo=new ParameterValue<Double>();
					parameterMaintenanceValuelargo.setValue(producto.getlargo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuelargo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevolumen=new ParameterValue<Double>();
					parameterMaintenanceValuevolumen.setValue(producto.getvolumen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevolumen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepeso=new ParameterValue<Double>();
					parameterMaintenanceValuepeso.setValue(producto.getpeso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepeso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuegramos=new ParameterValue<Double>();
					parameterMaintenanceValuegramos.setValue(producto.getgramos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegramos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueunidades_caja=new ParameterValue<Double>();
					parameterMaintenanceValueunidades_caja.setValue(producto.getunidades_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueunidades_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemargen=new ParameterValue<Double>();
					parameterMaintenanceValuemargen.setValue(producto.getmargen());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemargen);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefactor=new ParameterValue<Double>();
					parameterMaintenanceValuefactor.setValue(producto.getfactor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefactor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob=new ParameterValue<Double>();
					parameterMaintenanceValuefob.setValue(producto.getfob());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefob2=new ParameterValue<Double>();
					parameterMaintenanceValuefob2.setValue(producto.getfob2());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefob2);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_producto.setValue(producto.getid_tipo_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_color_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_color_producto.setValue(producto.getid_color_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_color_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_clase_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_clase_producto.setValue(producto.getid_clase_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_clase_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_efecto_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_efecto_producto.setValue(producto.getid_efecto_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_efecto_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_marca_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_marca_producto.setValue(producto.getid_marca_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_marca_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_modelo_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_modelo_producto.setValue(producto.getid_modelo_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_modelo_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_material_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_material_producto.setValue(producto.getid_material_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_material_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_segmento_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_segmento_producto.setValue(producto.getid_segmento_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_segmento_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_talla_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_talla_producto.setValue(producto.getid_talla_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_talla_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuegrupo=new ParameterValue<String>();
					parameterMaintenanceValuegrupo.setValue(producto.getgrupo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuegrupo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuereferencia=new ParameterValue<String>();
					parameterMaintenanceValuereferencia.setValue(producto.getreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueaplicacion=new ParameterValue<String>();
					parameterMaintenanceValueaplicacion.setValue(producto.getaplicacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueaplicacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueprocedencia=new ParameterValue<String>();
					parameterMaintenanceValueprocedencia.setValue(producto.getprocedencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprocedencia);
					parametersTemp.add(parameterMaintenance);
					
						if(!producto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(producto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(producto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(producto.getId());
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
	
	public void setIsNewIsChangedFalseProducto(Producto producto)throws Exception  {		
		producto.setIsNew(false);
		producto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseProductos(List<Producto> productos)throws Exception  {				
		for(Producto producto:productos) {
			producto.setIsNew(false);
			producto.setIsChanged(false);
		}
	}
	
	public void generarExportarProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
