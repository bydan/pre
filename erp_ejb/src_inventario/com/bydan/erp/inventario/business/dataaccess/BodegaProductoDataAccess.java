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
import com.bydan.erp.inventario.util.*;//BodegaProductoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class BodegaProductoDataAccess extends  BodegaProductoDataAccessAdditional{ //BodegaProductoDataAccessAdditional,DataAccessHelper<BodegaProducto>
	//static Logger logger = Logger.getLogger(BodegaProductoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="bodega_producto";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_bodega,id_producto,id_unidad,id_centro_costo,id_estado_bodega_producto,descripcion,cantidad_disponible,stock_maximo,stock_minimo,iva,iva_valor,descuento,descuento_valor,ice,ice_valor,costo_promedio,porcentaje_comision,precio,ultimo_costo,costo,arancel_porcentaje,ice_porcentaje,peso,con_iva,con_impuesto,con_ice,esta_activo,con_balanza,cantidad_pedida,cantidad_fisica,cantidad_requerido,precio_costo,precio_promedio,total_ingresos,total_egresos,total_provision,total_proceso,costo_calculado,dias_produccion,precio_reposicion,fecha_ultimo_pedido,fecha_ingreso,fecha_egreso,fecha_ultima_compra,fecha_ultima_venta,fecha_ultima_devolucion,id_cuenta_contable_inventario,id_cuenta_contable_costo_venta,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_produccion,id_cuenta_contable_devolucion,id_cuenta_contable_ingreso_debito,id_cuenta_contable_ingreso_credito,id_cuenta_contable_resultado_debito,id_cuenta_contable_resultado_credito)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,id_estado_bodega_producto=?,descripcion=?,cantidad_disponible=?,stock_maximo=?,stock_minimo=?,iva=?,iva_valor=?,descuento=?,descuento_valor=?,ice=?,ice_valor=?,costo_promedio=?,porcentaje_comision=?,precio=?,ultimo_costo=?,costo=?,arancel_porcentaje=?,ice_porcentaje=?,peso=?,con_iva=?,con_impuesto=?,con_ice=?,esta_activo=?,con_balanza=?,cantidad_pedida=?,cantidad_fisica=?,cantidad_requerido=?,precio_costo=?,precio_promedio=?,total_ingresos=?,total_egresos=?,total_provision=?,total_proceso=?,costo_calculado=?,dias_produccion=?,precio_reposicion=?,fecha_ultimo_pedido=?,fecha_ingreso=?,fecha_egreso=?,fecha_ultima_compra=?,fecha_ultima_venta=?,fecha_ultima_devolucion=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_produccion=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_ingreso_debito=?,id_cuenta_contable_ingreso_credito=?,id_cuenta_contable_resultado_debito=?,id_cuenta_contable_resultado_credito=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select bodegaproducto from "+BodegaProductoConstantesFunciones.SPERSISTENCENAME+" bodegaproducto";
	public static String QUERYSELECTNATIVE="select "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".version_row,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_empresa,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_sucursal,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_bodega,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_producto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_unidad,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_centro_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_estado_bodega_producto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descripcion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_disponible,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".stock_maximo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".stock_minimo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".iva,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".iva_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descuento,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".descuento_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice_valor,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo_promedio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".porcentaje_comision,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ultimo_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".arancel_porcentaje,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".ice_porcentaje,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".peso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_iva,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_impuesto,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_ice,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".esta_activo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".con_balanza,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_pedida,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_fisica,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".cantidad_requerido,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_costo,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_promedio,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_ingresos,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_egresos,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_provision,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".total_proceso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".costo_calculado,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".dias_produccion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".precio_reposicion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultimo_pedido,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ingreso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_egreso,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_compra,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".fecha_ultima_devolucion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso_debito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_ingreso_credito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_resultado_debito,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id_cuenta_contable_resultado_credito from "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME;//+" as "+BodegaProductoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".id,"+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+".version_row from "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME;//+" as "+BodegaProductoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BodegaProductoConstantesFunciones.SCHEMA+"."+BodegaProductoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,id_estado_bodega_producto=?,descripcion=?,cantidad_disponible=?,stock_maximo=?,stock_minimo=?,iva=?,iva_valor=?,descuento=?,descuento_valor=?,ice=?,ice_valor=?,costo_promedio=?,porcentaje_comision=?,precio=?,ultimo_costo=?,costo=?,arancel_porcentaje=?,ice_porcentaje=?,peso=?,con_iva=?,con_impuesto=?,con_ice=?,esta_activo=?,con_balanza=?,cantidad_pedida=?,cantidad_fisica=?,cantidad_requerido=?,precio_costo=?,precio_promedio=?,total_ingresos=?,total_egresos=?,total_provision=?,total_proceso=?,costo_calculado=?,dias_produccion=?,precio_reposicion=?,fecha_ultimo_pedido=?,fecha_ingreso=?,fecha_egreso=?,fecha_ultima_compra=?,fecha_ultima_venta=?,fecha_ultima_devolucion=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo_venta=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_produccion=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_ingreso_debito=?,id_cuenta_contable_ingreso_credito=?,id_cuenta_contable_resultado_debito=?,id_cuenta_contable_resultado_credito=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BODEGAPRODUCTO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BODEGAPRODUCTO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BODEGAPRODUCTO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BODEGAPRODUCTO_SELECT(?,?)";
	
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
	
	
	protected BodegaProductoDataAccessAdditional bodegaproductoDataAccessAdditional=null;
	
	public BodegaProductoDataAccessAdditional getBodegaProductoDataAccessAdditional() {
		return this.bodegaproductoDataAccessAdditional;
	}
	
	public void setBodegaProductoDataAccessAdditional(BodegaProductoDataAccessAdditional bodegaproductoDataAccessAdditional) {
		try {
			this.bodegaproductoDataAccessAdditional=bodegaproductoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BodegaProductoDataAccess() {
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
		BodegaProductoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BodegaProductoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BodegaProductoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBodegaProductoOriginal(BodegaProducto bodegaproducto)throws Exception  {
		bodegaproducto.setBodegaProductoOriginal((BodegaProducto)bodegaproducto.clone());		
	}
	
	public void setBodegaProductosOriginal(List<BodegaProducto> bodegaproductos)throws Exception  {
		
		for(BodegaProducto bodegaproducto:bodegaproductos){
			bodegaproducto.setBodegaProductoOriginal((BodegaProducto)bodegaproducto.clone());
		}
	}
	
	public static void setBodegaProductoOriginalStatic(BodegaProducto bodegaproducto)throws Exception  {
		bodegaproducto.setBodegaProductoOriginal((BodegaProducto)bodegaproducto.clone());		
	}
	
	public static void setBodegaProductosOriginalStatic(List<BodegaProducto> bodegaproductos)throws Exception  {
		
		for(BodegaProducto bodegaproducto:bodegaproductos){
			bodegaproducto.setBodegaProductoOriginal((BodegaProducto)bodegaproducto.clone());
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
	
	public  BodegaProducto getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();		
		
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
	
	public  BodegaProducto getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.BodegaProducto.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBodegaProductoOriginal(new BodegaProducto());
      	    	entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBodegaProducto("",entity,resultSet); 
				
				//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBodegaProducto(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  BodegaProducto getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();
				
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
	
	public  BodegaProducto getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.BodegaProducto.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBodegaProductoOriginal(new BodegaProducto());
      	    	entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBodegaProducto("",entity,resultSet);    
				
				//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBodegaProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //BodegaProducto
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		BodegaProducto entity = new BodegaProducto();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.BodegaProducto.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBodegaProducto(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<BodegaProducto> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		
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
	
	public  List<BodegaProducto> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BodegaProducto();
      	    	entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodegaProducto("",entity,resultSet);
      	    	
				//entity.setBodegaProductoOriginal( new BodegaProducto());
      	    	//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegaProductos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodegaProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BodegaProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
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
	
	public  List<BodegaProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BodegaProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapBodegaProducto();
					//entity.setMapBodegaProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBodegaProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBodegaProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
					entity=BodegaProductoDataAccess.getEntityBodegaProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBodegaProductoOriginal( new BodegaProducto());
					////entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegaProductos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodegaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public BodegaProducto getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();		  
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
	
	public  BodegaProducto getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BodegaProducto();
				
				if(conMapGenerico) {
					entity.inicializarMapBodegaProducto();
					//entity.setMapBodegaProducto(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBodegaProductoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBodegaProducto().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
					entity=BodegaProductoDataAccess.getEntityBodegaProducto("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBodegaProductoOriginal( new BodegaProducto());
					////entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
					////entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBodegaProducto(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodegaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static BodegaProducto getEntityBodegaProducto(String strPrefijo,BodegaProducto entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = BodegaProducto.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = BodegaProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BodegaProductoDataAccess.setFieldReflectionBodegaProducto(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBodegaProducto=BodegaProductoConstantesFunciones.getTodosTiposColumnasBodegaProducto();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBodegaProducto) {
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
							field = BodegaProducto.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = BodegaProducto.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BodegaProductoDataAccess.setFieldReflectionBodegaProducto(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBodegaProducto(Field field,String strPrefijo,String sColumn,BodegaProducto entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BodegaProductoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.STOCKMAXIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.STOCKMINIMO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IVAVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.DESCUENTOVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ICEVALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.COSTOPROMEDIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PORCENTAJECOMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ULTIMOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ARANCELPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ICEPORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CONIVA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CONIMPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CONICE:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.ESTAACTIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CONBALANZA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CANTIDADPEDIDA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CANTIDADFISICA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.CANTIDADREQUERIDO:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PRECIOCOSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PRECIOPROMEDIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.TOTALINGRESOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.TOTALEGRESOS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.TOTALPROVISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.TOTALPROCESO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.COSTOCALCULADO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.DIASPRODUCCION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.PRECIOREPOSICION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAINGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAEGRESO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAULTIMAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BodegaProducto>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new BodegaProducto();
					entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBodegaProducto("",entity,resultSet);
					
					//entity.setBodegaProductoOriginal( new BodegaProducto());
					//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
					//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBodegaProductos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodegaProducto(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<BodegaProducto>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaProductoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaProductoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<BodegaProducto> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
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
	
	public  List<BodegaProducto> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BodegaProducto();
      	    	entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodegaProducto("",entity,resultSet);
      	    	
				//entity.setBodegaProductoOriginal( new BodegaProducto());
      	    	//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBodegaProductos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodegaProducto(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<BodegaProducto> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
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
	
	public  List<BodegaProducto> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<BodegaProducto> entities = new  ArrayList<BodegaProducto>();
		BodegaProducto entity = new BodegaProducto();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new BodegaProducto();
      	    	entity=super.getEntity("",entity,resultSet,BodegaProductoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodegaProducto("",entity,resultSet);
      	    	
				//entity.setBodegaProductoOriginal( new BodegaProducto());
      	    	//entity.setBodegaProductoOriginal(super.getEntity("",entity.getBodegaProductoOriginal(),resultSet,BodegaProductoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaProductoOriginal(this.getEntityBodegaProducto("",entity.getBodegaProductoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegaProductos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public BodegaProducto getEntityBodegaProducto(String strPrefijo,BodegaProducto entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDSUCURSAL));
				entity.setid_bodega(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDUNIDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_estado_bodega_producto(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDESTADOBODEGAPRODUCTO));
				entity.setdescripcion(resultSet.getString(strPrefijo+BodegaProductoConstantesFunciones.DESCRIPCION));
				entity.setcantidad_disponible(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.CANTIDADDISPONIBLE));
				entity.setstock_maximo(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.STOCKMAXIMO));
				entity.setstock_minimo(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.STOCKMINIMO));
				entity.setiva(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.IVA));
				entity.setiva_valor(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.IVAVALOR));
				entity.setdescuento(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.DESCUENTO));
				entity.setdescuento_valor(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.DESCUENTOVALOR));
				entity.setice(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.ICE));
				entity.setice_valor(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.ICEVALOR));
				entity.setcosto_promedio(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.COSTOPROMEDIO));
				entity.setporcentaje_comision(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PORCENTAJECOMISION));
				entity.setprecio(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PRECIO));
				entity.setultimo_costo(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.ULTIMOCOSTO));
				entity.setcosto(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.COSTO));
				entity.setarancel_porcentaje(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.ARANCELPORCENTAJE));
				entity.setice_porcentaje(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.ICEPORCENTAJE));
				entity.setpeso(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PESO));
				entity.setcon_iva(resultSet.getBoolean(strPrefijo+BodegaProductoConstantesFunciones.CONIVA));
				entity.setcon_impuesto(resultSet.getBoolean(strPrefijo+BodegaProductoConstantesFunciones.CONIMPUESTO));
				entity.setcon_ice(resultSet.getBoolean(strPrefijo+BodegaProductoConstantesFunciones.CONICE));
				entity.setesta_activo(resultSet.getBoolean(strPrefijo+BodegaProductoConstantesFunciones.ESTAACTIVO));
				entity.setcon_balanza(resultSet.getBoolean(strPrefijo+BodegaProductoConstantesFunciones.CONBALANZA));
				entity.setcantidad_pedida(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.CANTIDADPEDIDA));
				entity.setcantidad_fisica(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.CANTIDADFISICA));
				entity.setcantidad_requerido(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.CANTIDADREQUERIDO));
				entity.setprecio_costo(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PRECIOCOSTO));
				entity.setprecio_promedio(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PRECIOPROMEDIO));
				entity.settotal_ingresos(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.TOTALINGRESOS));
				entity.settotal_egresos(resultSet.getInt(strPrefijo+BodegaProductoConstantesFunciones.TOTALEGRESOS));
				entity.settotal_provision(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.TOTALPROVISION));
				entity.settotal_proceso(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.TOTALPROCESO));
				entity.setcosto_calculado(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.COSTOCALCULADO));
				entity.setdias_produccion(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.DIASPRODUCCION));
				entity.setprecio_reposicion(resultSet.getDouble(strPrefijo+BodegaProductoConstantesFunciones.PRECIOREPOSICION));
				entity.setfecha_ultimo_pedido(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAULTIMOPEDIDO).getTime()));
				entity.setfecha_ingreso(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAINGRESO).getTime()));
				entity.setfecha_egreso(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAEGRESO).getTime()));
				entity.setfecha_ultima_compra(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAULTIMACOMPRA).getTime()));
				entity.setfecha_ultima_venta(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAULTIMAVENTA).getTime()));
				entity.setfecha_ultima_devolucion(new Date(resultSet.getDate(strPrefijo+BodegaProductoConstantesFunciones.FECHAULTIMADEVOLUCION).getTime()));
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_costo_venta(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLECOSTOVENTA));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEDESCUENTO));
				entity.setid_cuenta_contable_produccion(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEPRODUCCION));
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));
				entity.setid_cuenta_contable_ingreso_debito(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESODEBITO));
				entity.setid_cuenta_contable_ingreso_credito(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLEINGRESOCREDITO));
				entity.setid_cuenta_contable_resultado_debito(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADODEBITO));
				entity.setid_cuenta_contable_resultado_credito(resultSet.getLong(strPrefijo+BodegaProductoConstantesFunciones.IDCUENTACONTABLERESULTADOCREDITO));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBodegaProducto(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(BodegaProducto entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BodegaProductoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BodegaProductoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BodegaProductoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BodegaProductoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BodegaProductoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BodegaProductoDataAccess.TABLENAME,BodegaProductoDataAccess.ISWITHSTOREPROCEDURES);
			
			BodegaProductoDataAccess.setBodegaProductoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbodegaproducto.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relbodegaproducto.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Bodega getBodega(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,relbodegaproducto.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,relbodegaproducto.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,relbodegaproducto.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relbodegaproducto.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public EstadoBodegaProducto getEstadoBodegaProducto(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		EstadoBodegaProducto estadobodegaproducto= new EstadoBodegaProducto();

		try {
			EstadoBodegaProductoDataAccess estadobodegaproductoDataAccess=new EstadoBodegaProductoDataAccess();

			estadobodegaproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadobodegaproductoDataAccess.setConnexionType(this.connexionType);
			estadobodegaproductoDataAccess.setParameterDbType(this.parameterDbType);

			estadobodegaproducto=estadobodegaproductoDataAccess.getEntity(connexion,relbodegaproducto.getid_estado_bodega_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadobodegaproducto;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoVenta(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_costo_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableProduccion(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_produccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngresoDebito(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_ingreso_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableIngresoCredito(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_ingreso_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableResultadoDebito(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_resultado_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableResultadoCredito(Connexion connexion,BodegaProducto relbodegaproducto)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodegaproducto.getid_cuenta_contable_resultado_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,BodegaProducto bodegaproducto) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!bodegaproducto.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(bodegaproducto.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(bodegaproducto.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(bodegaproducto.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(bodegaproducto.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(bodegaproducto.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(bodegaproducto.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_bodega_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_bodega_producto.setValue(bodegaproducto.getid_estado_bodega_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_bodega_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(bodegaproducto.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_disponible=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_disponible.setValue(bodegaproducto.getcantidad_disponible());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_disponible);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuestock_maximo=new ParameterValue<Integer>();
					parameterMaintenanceValuestock_maximo.setValue(bodegaproducto.getstock_maximo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock_maximo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuestock_minimo=new ParameterValue<Integer>();
					parameterMaintenanceValuestock_minimo.setValue(bodegaproducto.getstock_minimo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuestock_minimo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(bodegaproducto.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva_valor=new ParameterValue<Double>();
					parameterMaintenanceValueiva_valor.setValue(bodegaproducto.getiva_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(bodegaproducto.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento_valor=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento_valor.setValue(bodegaproducto.getdescuento_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(bodegaproducto.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_valor=new ParameterValue<Double>();
					parameterMaintenanceValueice_valor.setValue(bodegaproducto.getice_valor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_valor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_promedio=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_promedio.setValue(bodegaproducto.getcosto_promedio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_promedio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_comision=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_comision.setValue(bodegaproducto.getporcentaje_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(bodegaproducto.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueultimo_costo=new ParameterValue<Double>();
					parameterMaintenanceValueultimo_costo.setValue(bodegaproducto.getultimo_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueultimo_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(bodegaproducto.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuearancel_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValuearancel_porcentaje.setValue(bodegaproducto.getarancel_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuearancel_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice_porcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueice_porcentaje.setValue(bodegaproducto.getice_porcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice_porcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuepeso=new ParameterValue<Double>();
					parameterMaintenanceValuepeso.setValue(bodegaproducto.getpeso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuepeso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_iva=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_iva.setValue(bodegaproducto.getcon_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_impuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_impuesto.setValue(bodegaproducto.getcon_impuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_impuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_ice=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_ice.setValue(bodegaproducto.getcon_ice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_ice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValueesta_activo=new ParameterValue<Boolean>();
					parameterMaintenanceValueesta_activo.setValue(bodegaproducto.getesta_activo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueesta_activo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_balanza=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_balanza.setValue(bodegaproducto.getcon_balanza());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_balanza);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_pedida=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_pedida.setValue(bodegaproducto.getcantidad_pedida());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_pedida);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_fisica=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_fisica.setValue(bodegaproducto.getcantidad_fisica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_fisica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_requerido=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_requerido.setValue(bodegaproducto.getcantidad_requerido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_requerido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_costo=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_costo.setValue(bodegaproducto.getprecio_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_promedio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_promedio.setValue(bodegaproducto.getprecio_promedio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_promedio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuetotal_ingresos=new ParameterValue<Integer>();
					parameterMaintenanceValuetotal_ingresos.setValue(bodegaproducto.gettotal_ingresos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_ingresos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuetotal_egresos=new ParameterValue<Integer>();
					parameterMaintenanceValuetotal_egresos.setValue(bodegaproducto.gettotal_egresos());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_egresos);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_provision=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_provision.setValue(bodegaproducto.gettotal_provision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_provision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_proceso=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_proceso.setValue(bodegaproducto.gettotal_proceso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_proceso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto_calculado=new ParameterValue<Double>();
					parameterMaintenanceValuecosto_calculado.setValue(bodegaproducto.getcosto_calculado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto_calculado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedias_produccion=new ParameterValue<Double>();
					parameterMaintenanceValuedias_produccion.setValue(bodegaproducto.getdias_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedias_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio_reposicion=new ParameterValue<Double>();
					parameterMaintenanceValueprecio_reposicion.setValue(bodegaproducto.getprecio_reposicion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio_reposicion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultimo_pedido=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultimo_pedido.setValue(bodegaproducto.getfecha_ultimo_pedido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultimo_pedido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ingreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ingreso.setValue(bodegaproducto.getfecha_ingreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ingreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_egreso=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_egreso.setValue(bodegaproducto.getfecha_egreso());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_egreso);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_compra=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_compra.setValue(bodegaproducto.getfecha_ultima_compra());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_compra);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_venta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_venta.setValue(bodegaproducto.getfecha_ultima_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_devolucion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_devolucion.setValue(bodegaproducto.getfecha_ultima_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(bodegaproducto.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_venta.setValue(bodegaproducto.getid_cuenta_contable_costo_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(bodegaproducto.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(bodegaproducto.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_produccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_produccion.setValue(bodegaproducto.getid_cuenta_contable_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(bodegaproducto.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso_debito.setValue(bodegaproducto.getid_cuenta_contable_ingreso_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_ingreso_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_ingreso_credito.setValue(bodegaproducto.getid_cuenta_contable_ingreso_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_ingreso_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_resultado_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_resultado_debito.setValue(bodegaproducto.getid_cuenta_contable_resultado_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_resultado_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_resultado_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_resultado_credito.setValue(bodegaproducto.getid_cuenta_contable_resultado_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_resultado_credito);
					parametersTemp.add(parameterMaintenance);
					
						if(!bodegaproducto.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(bodegaproducto.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(bodegaproducto.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(bodegaproducto.getId());
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
	
	public void setIsNewIsChangedFalseBodegaProducto(BodegaProducto bodegaproducto)throws Exception  {		
		bodegaproducto.setIsNew(false);
		bodegaproducto.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBodegaProductos(List<BodegaProducto> bodegaproductos)throws Exception  {				
		for(BodegaProducto bodegaproducto:bodegaproductos) {
			bodegaproducto.setIsNew(false);
			bodegaproducto.setIsChanged(false);
		}
	}
	
	public void generarExportarBodegaProducto(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
