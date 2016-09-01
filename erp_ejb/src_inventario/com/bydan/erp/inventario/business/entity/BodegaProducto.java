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
package com.bydan.erp.inventario.business.entity;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class BodegaProducto extends BodegaProductoAdditional implements Serializable ,Cloneable {//BodegaProductoAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private BodegaProducto bodegaproductoOriginal;
	
	private Map<String, Object> mapBodegaProducto;
			
	public Map<String, Object> getMapBodegaProducto() {
		return mapBodegaProducto;
	}

	public void setMapBodegaProducto(Map<String, Object> mapBodegaProducto) {
		this.mapBodegaProducto = mapBodegaProducto;
	}
	
	public void inicializarMapBodegaProducto() {
		this.mapBodegaProducto = new HashMap<String,Object>();
	}
	
	public void setMapBodegaProductoValue(String sKey,Object oValue) {
		this.mapBodegaProducto.put(sKey, oValue);
	}
	
	public Object getMapBodegaProductoValue(String sKey) {
		return this.mapBodegaProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_bodega_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=BodegaProductoConstantesFunciones.SREGEXDESCRIPCION,message=BodegaProductoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer stock_maximo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer stock_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_promedio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ultimo_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double arancel_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double peso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_balanza;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_pedida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_fisica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_requerido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_promedio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer total_ingresos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer total_egresos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_provision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_proceso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_calculado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_reposicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_ingreso_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_ingreso_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_resultado_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_resultado_credito;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public CentroCosto centrocosto;
	public EstadoBodegaProducto estadobodegaproducto;
	public CuentaContable cuentacontableinventario;
	public CuentaContable cuentacontablecostoventa;
	public CuentaContable cuentacontableventa;
	public CuentaContable cuentacontabledescuento;
	public CuentaContable cuentacontableproduccion;
	public CuentaContable cuentacontabledevolucion;
	public CuentaContable cuentacontableingresodebito;
	public CuentaContable cuentacontableingresocredito;
	public CuentaContable cuentacontableresultadodebito;
	public CuentaContable cuentacontableresultadocredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String centrocosto_descripcion;
	private String estadobodegaproducto_descripcion;
	private String cuentacontableinventario_descripcion;
	private String cuentacontablecostoventa_descripcion;
	private String cuentacontableventa_descripcion;
	private String cuentacontabledescuento_descripcion;
	private String cuentacontableproduccion_descripcion;
	private String cuentacontabledevolucion_descripcion;
	private String cuentacontableingresodebito_descripcion;
	private String cuentacontableingresocredito_descripcion;
	private String cuentacontableresultadodebito_descripcion;
	private String cuentacontableresultadocredito_descripcion;
	
	
		
	public BodegaProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.bodegaproductoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_centro_costo=null;
 		this.id_estado_bodega_producto=-1L;
 		this.descripcion="";
 		this.cantidad_disponible=0;
 		this.stock_maximo=0;
 		this.stock_minimo=0;
 		this.iva=0.0;
 		this.iva_valor=0.0;
 		this.descuento=0.0;
 		this.descuento_valor=0.0;
 		this.ice=0.0;
 		this.ice_valor=0.0;
 		this.costo_promedio=0.0;
 		this.porcentaje_comision=0.0;
 		this.precio=0.0;
 		this.ultimo_costo=0.0;
 		this.costo=0.0;
 		this.arancel_porcentaje=0.0;
 		this.ice_porcentaje=0.0;
 		this.peso=0.0;
 		this.con_iva=false;
 		this.con_impuesto=false;
 		this.con_ice=false;
 		this.esta_activo=false;
 		this.con_balanza=false;
 		this.cantidad_pedida=0;
 		this.cantidad_fisica=0;
 		this.cantidad_requerido=0;
 		this.precio_costo=0.0;
 		this.precio_promedio=0.0;
 		this.total_ingresos=0;
 		this.total_egresos=0;
 		this.total_provision=0.0;
 		this.total_proceso=0.0;
 		this.costo_calculado=0.0;
 		this.dias_produccion=0.0;
 		this.precio_reposicion=0.0;
 		this.fecha_ultimo_pedido=new Date();
 		this.fecha_ingreso=new Date();
 		this.fecha_egreso=new Date();
 		this.fecha_ultima_compra=new Date();
 		this.fecha_ultima_venta=new Date();
 		this.fecha_ultima_devolucion=new Date();
 		this.id_cuenta_contable_inventario=-1L;
 		this.id_cuenta_contable_costo_venta=-1L;
 		this.id_cuenta_contable_venta=-1L;
 		this.id_cuenta_contable_descuento=-1L;
 		this.id_cuenta_contable_produccion=-1L;
 		this.id_cuenta_contable_devolucion=-1L;
 		this.id_cuenta_contable_ingreso_debito=-1L;
 		this.id_cuenta_contable_ingreso_credito=-1L;
 		this.id_cuenta_contable_resultado_debito=-1L;
 		this.id_cuenta_contable_resultado_credito=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.centrocosto=null;
		this.estadobodegaproducto=null;
		this.cuentacontableinventario=null;
		this.cuentacontablecostoventa=null;
		this.cuentacontableventa=null;
		this.cuentacontabledescuento=null;
		this.cuentacontableproduccion=null;
		this.cuentacontabledevolucion=null;
		this.cuentacontableingresodebito=null;
		this.cuentacontableingresocredito=null;
		this.cuentacontableresultadodebito=null;
		this.cuentacontableresultadocredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.centrocosto_descripcion="";
		this.estadobodegaproducto_descripcion="";
		this.cuentacontableinventario_descripcion="";
		this.cuentacontablecostoventa_descripcion="";
		this.cuentacontableventa_descripcion="";
		this.cuentacontabledescuento_descripcion="";
		this.cuentacontableproduccion_descripcion="";
		this.cuentacontabledevolucion_descripcion="";
		this.cuentacontableingresodebito_descripcion="";
		this.cuentacontableingresocredito_descripcion="";
		this.cuentacontableresultadodebito_descripcion="";
		this.cuentacontableresultadocredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public BodegaProducto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_centro_costo,Long id_estado_bodega_producto,String descripcion,Integer cantidad_disponible,Integer stock_maximo,Integer stock_minimo,Double iva,Double iva_valor,Double descuento,Double descuento_valor,Double ice,Double ice_valor,Double costo_promedio,Double porcentaje_comision,Double precio,Double ultimo_costo,Double costo,Double arancel_porcentaje,Double ice_porcentaje,Double peso,Boolean con_iva,Boolean con_impuesto,Boolean con_ice,Boolean esta_activo,Boolean con_balanza,Integer cantidad_pedida,Integer cantidad_fisica,Integer cantidad_requerido,Double precio_costo,Double precio_promedio,Integer total_ingresos,Integer total_egresos,Double total_provision,Double total_proceso,Double costo_calculado,Double dias_produccion,Double precio_reposicion,Date fecha_ultimo_pedido,Date fecha_ingreso,Date fecha_egreso,Date fecha_ultima_compra,Date fecha_ultima_venta,Date fecha_ultima_devolucion,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_produccion,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_ingreso_debito,Long id_cuenta_contable_ingreso_credito,Long id_cuenta_contable_resultado_debito,Long id_cuenta_contable_resultado_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bodegaproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_estado_bodega_producto=id_estado_bodega_producto;
 		this.descripcion=descripcion;
 		this.cantidad_disponible=cantidad_disponible;
 		this.stock_maximo=stock_maximo;
 		this.stock_minimo=stock_minimo;
 		this.iva=iva;
 		this.iva_valor=iva_valor;
 		this.descuento=descuento;
 		this.descuento_valor=descuento_valor;
 		this.ice=ice;
 		this.ice_valor=ice_valor;
 		this.costo_promedio=costo_promedio;
 		this.porcentaje_comision=porcentaje_comision;
 		this.precio=precio;
 		this.ultimo_costo=ultimo_costo;
 		this.costo=costo;
 		this.arancel_porcentaje=arancel_porcentaje;
 		this.ice_porcentaje=ice_porcentaje;
 		this.peso=peso;
 		this.con_iva=con_iva;
 		this.con_impuesto=con_impuesto;
 		this.con_ice=con_ice;
 		this.esta_activo=esta_activo;
 		this.con_balanza=con_balanza;
 		this.cantidad_pedida=cantidad_pedida;
 		this.cantidad_fisica=cantidad_fisica;
 		this.cantidad_requerido=cantidad_requerido;
 		this.precio_costo=precio_costo;
 		this.precio_promedio=precio_promedio;
 		this.total_ingresos=total_ingresos;
 		this.total_egresos=total_egresos;
 		this.total_provision=total_provision;
 		this.total_proceso=total_proceso;
 		this.costo_calculado=costo_calculado;
 		this.dias_produccion=dias_produccion;
 		this.precio_reposicion=precio_reposicion;
 		this.fecha_ultimo_pedido=fecha_ultimo_pedido;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_egreso=fecha_egreso;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.fecha_ultima_devolucion=fecha_ultima_devolucion;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_ingreso_debito=id_cuenta_contable_ingreso_debito;
 		this.id_cuenta_contable_ingreso_credito=id_cuenta_contable_ingreso_credito;
 		this.id_cuenta_contable_resultado_debito=id_cuenta_contable_resultado_debito;
 		this.id_cuenta_contable_resultado_credito=id_cuenta_contable_resultado_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public BodegaProducto (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_centro_costo,Long id_estado_bodega_producto,String descripcion,Integer cantidad_disponible,Integer stock_maximo,Integer stock_minimo,Double iva,Double iva_valor,Double descuento,Double descuento_valor,Double ice,Double ice_valor,Double costo_promedio,Double porcentaje_comision,Double precio,Double ultimo_costo,Double costo,Double arancel_porcentaje,Double ice_porcentaje,Double peso,Boolean con_iva,Boolean con_impuesto,Boolean con_ice,Boolean esta_activo,Boolean con_balanza,Integer cantidad_pedida,Integer cantidad_fisica,Integer cantidad_requerido,Double precio_costo,Double precio_promedio,Integer total_ingresos,Integer total_egresos,Double total_provision,Double total_proceso,Double costo_calculado,Double dias_produccion,Double precio_reposicion,Date fecha_ultimo_pedido,Date fecha_ingreso,Date fecha_egreso,Date fecha_ultima_compra,Date fecha_ultima_venta,Date fecha_ultima_devolucion,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_produccion,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_ingreso_debito,Long id_cuenta_contable_ingreso_credito,Long id_cuenta_contable_resultado_debito,Long id_cuenta_contable_resultado_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.bodegaproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_centro_costo=id_centro_costo;
 		this.id_estado_bodega_producto=id_estado_bodega_producto;
 		this.descripcion=descripcion;
 		this.cantidad_disponible=cantidad_disponible;
 		this.stock_maximo=stock_maximo;
 		this.stock_minimo=stock_minimo;
 		this.iva=iva;
 		this.iva_valor=iva_valor;
 		this.descuento=descuento;
 		this.descuento_valor=descuento_valor;
 		this.ice=ice;
 		this.ice_valor=ice_valor;
 		this.costo_promedio=costo_promedio;
 		this.porcentaje_comision=porcentaje_comision;
 		this.precio=precio;
 		this.ultimo_costo=ultimo_costo;
 		this.costo=costo;
 		this.arancel_porcentaje=arancel_porcentaje;
 		this.ice_porcentaje=ice_porcentaje;
 		this.peso=peso;
 		this.con_iva=con_iva;
 		this.con_impuesto=con_impuesto;
 		this.con_ice=con_ice;
 		this.esta_activo=esta_activo;
 		this.con_balanza=con_balanza;
 		this.cantidad_pedida=cantidad_pedida;
 		this.cantidad_fisica=cantidad_fisica;
 		this.cantidad_requerido=cantidad_requerido;
 		this.precio_costo=precio_costo;
 		this.precio_promedio=precio_promedio;
 		this.total_ingresos=total_ingresos;
 		this.total_egresos=total_egresos;
 		this.total_provision=total_provision;
 		this.total_proceso=total_proceso;
 		this.costo_calculado=costo_calculado;
 		this.dias_produccion=dias_produccion;
 		this.precio_reposicion=precio_reposicion;
 		this.fecha_ultimo_pedido=fecha_ultimo_pedido;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_egreso=fecha_egreso;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.fecha_ultima_devolucion=fecha_ultima_devolucion;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_ingreso_debito=id_cuenta_contable_ingreso_debito;
 		this.id_cuenta_contable_ingreso_credito=id_cuenta_contable_ingreso_credito;
 		this.id_cuenta_contable_resultado_debito=id_cuenta_contable_resultado_debito;
 		this.id_cuenta_contable_resultado_credito=id_cuenta_contable_resultado_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		BodegaProducto bodegaproductoLocal=null;
		
		if(object!=null) {
			bodegaproductoLocal=(BodegaProducto)object;
			
			if(bodegaproductoLocal!=null) {
				if(this.getId()!=null && bodegaproductoLocal.getId()!=null) {
					if(this.getId().equals(bodegaproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BodegaProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BodegaProductoConstantesFunciones.getBodegaProductoDescripcion(this);
		} else {
			sDetalle=BodegaProductoConstantesFunciones.getBodegaProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public BodegaProducto getBodegaProductoOriginal() {
		return this.bodegaproductoOriginal;
	}
	
	public void setBodegaProductoOriginal(BodegaProducto bodegaproducto) {
		try {
			this.bodegaproductoOriginal=bodegaproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BodegaProductoAdditional bodegaproductoAdditional=null;
	
	public BodegaProductoAdditional getBodegaProductoAdditional() {
		return this.bodegaproductoAdditional;
	}
	
	public void setBodegaProductoAdditional(BodegaProductoAdditional bodegaproductoAdditional) {
		try {
			this.bodegaproductoAdditional=bodegaproductoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_estado_bodega_producto() {
		return this.id_estado_bodega_producto;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Integer getcantidad_disponible() {
		return this.cantidad_disponible;
	}
    
	
	public Integer getstock_maximo() {
		return this.stock_maximo;
	}
    
	
	public Integer getstock_minimo() {
		return this.stock_minimo;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getiva_valor() {
		return this.iva_valor;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getice_valor() {
		return this.ice_valor;
	}
    
	
	public Double getcosto_promedio() {
		return this.costo_promedio;
	}
    
	
	public Double getporcentaje_comision() {
		return this.porcentaje_comision;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getultimo_costo() {
		return this.ultimo_costo;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getarancel_porcentaje() {
		return this.arancel_porcentaje;
	}
    
	
	public Double getice_porcentaje() {
		return this.ice_porcentaje;
	}
    
	
	public Double getpeso() {
		return this.peso;
	}
    
	
	public Boolean getcon_iva() {
		return this.con_iva;
	}
    
	
	public Boolean getcon_impuesto() {
		return this.con_impuesto;
	}
    
	
	public Boolean getcon_ice() {
		return this.con_ice;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
    
	
	public Boolean getcon_balanza() {
		return this.con_balanza;
	}
    
	
	public Integer getcantidad_pedida() {
		return this.cantidad_pedida;
	}
    
	
	public Integer getcantidad_fisica() {
		return this.cantidad_fisica;
	}
    
	
	public Integer getcantidad_requerido() {
		return this.cantidad_requerido;
	}
    
	
	public Double getprecio_costo() {
		return this.precio_costo;
	}
    
	
	public Double getprecio_promedio() {
		return this.precio_promedio;
	}
    
	
	public Integer gettotal_ingresos() {
		return this.total_ingresos;
	}
    
	
	public Integer gettotal_egresos() {
		return this.total_egresos;
	}
    
	
	public Double gettotal_provision() {
		return this.total_provision;
	}
    
	
	public Double gettotal_proceso() {
		return this.total_proceso;
	}
    
	
	public Double getcosto_calculado() {
		return this.costo_calculado;
	}
    
	
	public Double getdias_produccion() {
		return this.dias_produccion;
	}
    
	
	public Double getprecio_reposicion() {
		return this.precio_reposicion;
	}
    
	
	public Date getfecha_ultimo_pedido() {
		return this.fecha_ultimo_pedido;
	}
    
	
	public Date getfecha_ingreso() {
		return this.fecha_ingreso;
	}
    
	
	public Date getfecha_egreso() {
		return this.fecha_egreso;
	}
    
	
	public Date getfecha_ultima_compra() {
		return this.fecha_ultima_compra;
	}
    
	
	public Date getfecha_ultima_venta() {
		return this.fecha_ultima_venta;
	}
    
	
	public Date getfecha_ultima_devolucion() {
		return this.fecha_ultima_devolucion;
	}
    
	
	public Long getid_cuenta_contable_inventario() {
		return this.id_cuenta_contable_inventario;
	}
    
	
	public Long getid_cuenta_contable_costo_venta() {
		return this.id_cuenta_contable_costo_venta;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Long getid_cuenta_contable_descuento() {
		return this.id_cuenta_contable_descuento;
	}
    
	
	public Long getid_cuenta_contable_produccion() {
		return this.id_cuenta_contable_produccion;
	}
    
	
	public Long getid_cuenta_contable_devolucion() {
		return this.id_cuenta_contable_devolucion;
	}
    
	
	public Long getid_cuenta_contable_ingreso_debito() {
		return this.id_cuenta_contable_ingreso_debito;
	}
    
	
	public Long getid_cuenta_contable_ingreso_credito() {
		return this.id_cuenta_contable_ingreso_credito;
	}
    
	
	public Long getid_cuenta_contable_resultado_debito() {
		return this.id_cuenta_contable_resultado_debito;
	}
    
	
	public Long getid_cuenta_contable_resultado_credito() {
		return this.id_cuenta_contable_resultado_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_estado_bodega_producto(Long newid_estado_bodega_producto)throws Exception
	{
		try {
			if(this.id_estado_bodega_producto!=newid_estado_bodega_producto) {
				if(newid_estado_bodega_producto==null) {
					//newid_estado_bodega_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_estado_bodega_producto");
					}
				}

				this.id_estado_bodega_producto=newid_estado_bodega_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("BodegaProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_disponible(Integer newcantidad_disponible)throws Exception
	{
		try {
			if(this.cantidad_disponible!=newcantidad_disponible) {
				if(newcantidad_disponible==null) {
					//newcantidad_disponible=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna cantidad_disponible");
					}
				}

				this.cantidad_disponible=newcantidad_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock_maximo(Integer newstock_maximo)throws Exception
	{
		try {
			if(this.stock_maximo!=newstock_maximo) {
				if(newstock_maximo==null) {
					//newstock_maximo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna stock_maximo");
					}
				}

				this.stock_maximo=newstock_maximo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock_minimo(Integer newstock_minimo)throws Exception
	{
		try {
			if(this.stock_minimo!=newstock_minimo) {
				if(newstock_minimo==null) {
					//newstock_minimo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna stock_minimo");
					}
				}

				this.stock_minimo=newstock_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva_valor(Double newiva_valor)throws Exception
	{
		try {
			if(this.iva_valor!=newiva_valor) {
				if(newiva_valor==null) {
					//newiva_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna iva_valor");
					}
				}

				this.iva_valor=newiva_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_valor(Double newdescuento_valor)throws Exception
	{
		try {
			if(this.descuento_valor!=newdescuento_valor) {
				if(newdescuento_valor==null) {
					//newdescuento_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice_valor(Double newice_valor)throws Exception
	{
		try {
			if(this.ice_valor!=newice_valor) {
				if(newice_valor==null) {
					//newice_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna ice_valor");
					}
				}

				this.ice_valor=newice_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_promedio(Double newcosto_promedio)throws Exception
	{
		try {
			if(this.costo_promedio!=newcosto_promedio) {
				if(newcosto_promedio==null) {
					//newcosto_promedio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna costo_promedio");
					}
				}

				this.costo_promedio=newcosto_promedio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_comision(Double newporcentaje_comision)throws Exception
	{
		try {
			if(this.porcentaje_comision!=newporcentaje_comision) {
				if(newporcentaje_comision==null) {
					//newporcentaje_comision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna porcentaje_comision");
					}
				}

				this.porcentaje_comision=newporcentaje_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setultimo_costo(Double newultimo_costo)throws Exception
	{
		try {
			if(this.ultimo_costo!=newultimo_costo) {
				if(newultimo_costo==null) {
					//newultimo_costo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna ultimo_costo");
					}
				}

				this.ultimo_costo=newultimo_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto(Double newcosto)throws Exception
	{
		try {
			if(this.costo!=newcosto) {
				if(newcosto==null) {
					//newcosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarancel_porcentaje(Double newarancel_porcentaje)throws Exception
	{
		try {
			if(this.arancel_porcentaje!=newarancel_porcentaje) {
				if(newarancel_porcentaje==null) {
					//newarancel_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna arancel_porcentaje");
					}
				}

				this.arancel_porcentaje=newarancel_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice_porcentaje(Double newice_porcentaje)throws Exception
	{
		try {
			if(this.ice_porcentaje!=newice_porcentaje) {
				if(newice_porcentaje==null) {
					//newice_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna ice_porcentaje");
					}
				}

				this.ice_porcentaje=newice_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpeso(Double newpeso)throws Exception
	{
		try {
			if(this.peso!=newpeso) {
				if(newpeso==null) {
					//newpeso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna peso");
					}
				}

				this.peso=newpeso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_iva(Boolean newcon_iva)throws Exception
	{
		try {
			if(this.con_iva!=newcon_iva) {
				if(newcon_iva==null) {
					//newcon_iva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna con_iva");
					}
				}

				this.con_iva=newcon_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_impuesto(Boolean newcon_impuesto)throws Exception
	{
		try {
			if(this.con_impuesto!=newcon_impuesto) {
				if(newcon_impuesto==null) {
					//newcon_impuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna con_impuesto");
					}
				}

				this.con_impuesto=newcon_impuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_ice(Boolean newcon_ice)throws Exception
	{
		try {
			if(this.con_ice!=newcon_ice) {
				if(newcon_ice==null) {
					//newcon_ice=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna con_ice");
					}
				}

				this.con_ice=newcon_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_balanza(Boolean newcon_balanza)throws Exception
	{
		try {
			if(this.con_balanza!=newcon_balanza) {
				if(newcon_balanza==null) {
					//newcon_balanza=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna con_balanza");
					}
				}

				this.con_balanza=newcon_balanza;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_pedida(Integer newcantidad_pedida)throws Exception
	{
		try {
			if(this.cantidad_pedida!=newcantidad_pedida) {
				if(newcantidad_pedida==null) {
					//newcantidad_pedida=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna cantidad_pedida");
					}
				}

				this.cantidad_pedida=newcantidad_pedida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_fisica(Integer newcantidad_fisica)throws Exception
	{
		try {
			if(this.cantidad_fisica!=newcantidad_fisica) {
				if(newcantidad_fisica==null) {
					//newcantidad_fisica=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna cantidad_fisica");
					}
				}

				this.cantidad_fisica=newcantidad_fisica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_requerido(Integer newcantidad_requerido)throws Exception
	{
		try {
			if(this.cantidad_requerido!=newcantidad_requerido) {
				if(newcantidad_requerido==null) {
					//newcantidad_requerido=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna cantidad_requerido");
					}
				}

				this.cantidad_requerido=newcantidad_requerido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_costo(Double newprecio_costo)throws Exception
	{
		try {
			if(this.precio_costo!=newprecio_costo) {
				if(newprecio_costo==null) {
					//newprecio_costo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna precio_costo");
					}
				}

				this.precio_costo=newprecio_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_promedio(Double newprecio_promedio)throws Exception
	{
		try {
			if(this.precio_promedio!=newprecio_promedio) {
				if(newprecio_promedio==null) {
					//newprecio_promedio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna precio_promedio");
					}
				}

				this.precio_promedio=newprecio_promedio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_ingresos(Integer newtotal_ingresos)throws Exception
	{
		try {
			if(this.total_ingresos!=newtotal_ingresos) {
				if(newtotal_ingresos==null) {
					//newtotal_ingresos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna total_ingresos");
					}
				}

				this.total_ingresos=newtotal_ingresos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_egresos(Integer newtotal_egresos)throws Exception
	{
		try {
			if(this.total_egresos!=newtotal_egresos) {
				if(newtotal_egresos==null) {
					//newtotal_egresos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna total_egresos");
					}
				}

				this.total_egresos=newtotal_egresos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_provision(Double newtotal_provision)throws Exception
	{
		try {
			if(this.total_provision!=newtotal_provision) {
				if(newtotal_provision==null) {
					//newtotal_provision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna total_provision");
					}
				}

				this.total_provision=newtotal_provision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_proceso(Double newtotal_proceso)throws Exception
	{
		try {
			if(this.total_proceso!=newtotal_proceso) {
				if(newtotal_proceso==null) {
					//newtotal_proceso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna total_proceso");
					}
				}

				this.total_proceso=newtotal_proceso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_calculado(Double newcosto_calculado)throws Exception
	{
		try {
			if(this.costo_calculado!=newcosto_calculado) {
				if(newcosto_calculado==null) {
					//newcosto_calculado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna costo_calculado");
					}
				}

				this.costo_calculado=newcosto_calculado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_produccion(Double newdias_produccion)throws Exception
	{
		try {
			if(this.dias_produccion!=newdias_produccion) {
				if(newdias_produccion==null) {
					//newdias_produccion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna dias_produccion");
					}
				}

				this.dias_produccion=newdias_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_reposicion(Double newprecio_reposicion)throws Exception
	{
		try {
			if(this.precio_reposicion!=newprecio_reposicion) {
				if(newprecio_reposicion==null) {
					//newprecio_reposicion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna precio_reposicion");
					}
				}

				this.precio_reposicion=newprecio_reposicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_pedido(Date newfecha_ultimo_pedido)throws Exception
	{
		try {
			if(this.fecha_ultimo_pedido!=newfecha_ultimo_pedido) {
				if(newfecha_ultimo_pedido==null) {
					//newfecha_ultimo_pedido=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_ultimo_pedido");
					}
				}

				this.fecha_ultimo_pedido=newfecha_ultimo_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ingreso(Date newfecha_ingreso)throws Exception
	{
		try {
			if(this.fecha_ingreso!=newfecha_ingreso) {
				if(newfecha_ingreso==null) {
					//newfecha_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_ingreso");
					}
				}

				this.fecha_ingreso=newfecha_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_egreso(Date newfecha_egreso)throws Exception
	{
		try {
			if(this.fecha_egreso!=newfecha_egreso) {
				if(newfecha_egreso==null) {
					//newfecha_egreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_egreso");
					}
				}

				this.fecha_egreso=newfecha_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_compra(Date newfecha_ultima_compra)throws Exception
	{
		try {
			if(this.fecha_ultima_compra!=newfecha_ultima_compra) {
				if(newfecha_ultima_compra==null) {
					//newfecha_ultima_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_ultima_compra");
					}
				}

				this.fecha_ultima_compra=newfecha_ultima_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_venta(Date newfecha_ultima_venta)throws Exception
	{
		try {
			if(this.fecha_ultima_venta!=newfecha_ultima_venta) {
				if(newfecha_ultima_venta==null) {
					//newfecha_ultima_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_ultima_venta");
					}
				}

				this.fecha_ultima_venta=newfecha_ultima_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_devolucion(Date newfecha_ultima_devolucion)throws Exception
	{
		try {
			if(this.fecha_ultima_devolucion!=newfecha_ultima_devolucion) {
				if(newfecha_ultima_devolucion==null) {
					//newfecha_ultima_devolucion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna fecha_ultima_devolucion");
					}
				}

				this.fecha_ultima_devolucion=newfecha_ultima_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario(Long newid_cuenta_contable_inventario)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario!=newid_cuenta_contable_inventario) {
				if(newid_cuenta_contable_inventario==null) {
					//newid_cuenta_contable_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_inventario");
					}
				}

				this.id_cuenta_contable_inventario=newid_cuenta_contable_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_venta(Long newid_cuenta_contable_costo_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo_venta!=newid_cuenta_contable_costo_venta) {
				if(newid_cuenta_contable_costo_venta==null) {
					//newid_cuenta_contable_costo_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_costo_venta");
					}
				}

				this.id_cuenta_contable_costo_venta=newid_cuenta_contable_costo_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta(Long newid_cuenta_contable_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_venta!=newid_cuenta_contable_venta) {
				if(newid_cuenta_contable_venta==null) {
					//newid_cuenta_contable_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_venta");
					}
				}

				this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_descuento(Long newid_cuenta_contable_descuento)throws Exception
	{
		try {
			if(this.id_cuenta_contable_descuento!=newid_cuenta_contable_descuento) {
				if(newid_cuenta_contable_descuento==null) {
					//newid_cuenta_contable_descuento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_descuento");
					}
				}

				this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_produccion(Long newid_cuenta_contable_produccion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_produccion!=newid_cuenta_contable_produccion) {
				if(newid_cuenta_contable_produccion==null) {
					//newid_cuenta_contable_produccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_produccion");
					}
				}

				this.id_cuenta_contable_produccion=newid_cuenta_contable_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_devolucion(Long newid_cuenta_contable_devolucion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_devolucion!=newid_cuenta_contable_devolucion) {
				if(newid_cuenta_contable_devolucion==null) {
					//newid_cuenta_contable_devolucion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_devolucion");
					}
				}

				this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_ingreso_debito(Long newid_cuenta_contable_ingreso_debito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_ingreso_debito!=newid_cuenta_contable_ingreso_debito) {
				if(newid_cuenta_contable_ingreso_debito==null) {
					//newid_cuenta_contable_ingreso_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_ingreso_debito");
					}
				}

				this.id_cuenta_contable_ingreso_debito=newid_cuenta_contable_ingreso_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_ingreso_credito(Long newid_cuenta_contable_ingreso_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_ingreso_credito!=newid_cuenta_contable_ingreso_credito) {
				if(newid_cuenta_contable_ingreso_credito==null) {
					//newid_cuenta_contable_ingreso_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_ingreso_credito");
					}
				}

				this.id_cuenta_contable_ingreso_credito=newid_cuenta_contable_ingreso_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_resultado_debito(Long newid_cuenta_contable_resultado_debito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_resultado_debito!=newid_cuenta_contable_resultado_debito) {
				if(newid_cuenta_contable_resultado_debito==null) {
					//newid_cuenta_contable_resultado_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_resultado_debito");
					}
				}

				this.id_cuenta_contable_resultado_debito=newid_cuenta_contable_resultado_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_resultado_credito(Long newid_cuenta_contable_resultado_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_resultado_credito!=newid_cuenta_contable_resultado_credito) {
				if(newid_cuenta_contable_resultado_credito==null) {
					//newid_cuenta_contable_resultado_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("BodegaProducto:Valor nulo no permitido en columna id_cuenta_contable_resultado_credito");
					}
				}

				this.id_cuenta_contable_resultado_credito=newid_cuenta_contable_resultado_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public EstadoBodegaProducto getEstadoBodegaProducto() {
		return this.estadobodegaproducto;
	}

	public CuentaContable getCuentaContableInventario() {
		return this.cuentacontableinventario;
	}

	public CuentaContable getCuentaContableCostoVenta() {
		return this.cuentacontablecostoventa;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	public CuentaContable getCuentaContableDescuento() {
		return this.cuentacontabledescuento;
	}

	public CuentaContable getCuentaContableProduccion() {
		return this.cuentacontableproduccion;
	}

	public CuentaContable getCuentaContableDevolucion() {
		return this.cuentacontabledevolucion;
	}

	public CuentaContable getCuentaContableIngresoDebito() {
		return this.cuentacontableingresodebito;
	}

	public CuentaContable getCuentaContableIngresoCredito() {
		return this.cuentacontableingresocredito;
	}

	public CuentaContable getCuentaContableResultadoDebito() {
		return this.cuentacontableresultadodebito;
	}

	public CuentaContable getCuentaContableResultadoCredito() {
		return this.cuentacontableresultadocredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getestadobodegaproducto_descripcion() {
		return this.estadobodegaproducto_descripcion;
	}

	public String getcuentacontableinventario_descripcion() {
		return this.cuentacontableinventario_descripcion;
	}

	public String getcuentacontablecostoventa_descripcion() {
		return this.cuentacontablecostoventa_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	public String getcuentacontabledescuento_descripcion() {
		return this.cuentacontabledescuento_descripcion;
	}

	public String getcuentacontableproduccion_descripcion() {
		return this.cuentacontableproduccion_descripcion;
	}

	public String getcuentacontabledevolucion_descripcion() {
		return this.cuentacontabledevolucion_descripcion;
	}

	public String getcuentacontableingresodebito_descripcion() {
		return this.cuentacontableingresodebito_descripcion;
	}

	public String getcuentacontableingresocredito_descripcion() {
		return this.cuentacontableingresocredito_descripcion;
	}

	public String getcuentacontableresultadodebito_descripcion() {
		return this.cuentacontableresultadodebito_descripcion;
	}

	public String getcuentacontableresultadocredito_descripcion() {
		return this.cuentacontableresultadocredito_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoBodegaProducto(EstadoBodegaProducto estadobodegaproducto) {
		try {
			this.estadobodegaproducto=estadobodegaproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventario(CuentaContable cuentacontableinventario) {
		try {
			this.cuentacontableinventario=cuentacontableinventario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCostoVenta(CuentaContable cuentacontablecostoventa) {
		try {
			this.cuentacontablecostoventa=cuentacontablecostoventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVenta(CuentaContable cuentacontableventa) {
		try {
			this.cuentacontableventa=cuentacontableventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDescuento(CuentaContable cuentacontabledescuento) {
		try {
			this.cuentacontabledescuento=cuentacontabledescuento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableProduccion(CuentaContable cuentacontableproduccion) {
		try {
			this.cuentacontableproduccion=cuentacontableproduccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDevolucion(CuentaContable cuentacontabledevolucion) {
		try {
			this.cuentacontabledevolucion=cuentacontabledevolucion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngresoDebito(CuentaContable cuentacontableingresodebito) {
		try {
			this.cuentacontableingresodebito=cuentacontableingresodebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngresoCredito(CuentaContable cuentacontableingresocredito) {
		try {
			this.cuentacontableingresocredito=cuentacontableingresocredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableResultadoDebito(CuentaContable cuentacontableresultadodebito) {
		try {
			this.cuentacontableresultadodebito=cuentacontableresultadodebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableResultadoCredito(CuentaContable cuentacontableresultadocredito) {
		try {
			this.cuentacontableresultadocredito=cuentacontableresultadocredito;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadobodegaproducto_descripcion(String estadobodegaproducto_descripcion) {
		try {
			this.estadobodegaproducto_descripcion=estadobodegaproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventario_descripcion(String cuentacontableinventario_descripcion) {
		try {
			this.cuentacontableinventario_descripcion=cuentacontableinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecostoventa_descripcion(String cuentacontablecostoventa_descripcion) {
		try {
			this.cuentacontablecostoventa_descripcion=cuentacontablecostoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventa_descripcion(String cuentacontableventa_descripcion) {
		try {
			this.cuentacontableventa_descripcion=cuentacontableventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledescuento_descripcion(String cuentacontabledescuento_descripcion) {
		try {
			this.cuentacontabledescuento_descripcion=cuentacontabledescuento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableproduccion_descripcion(String cuentacontableproduccion_descripcion) {
		try {
			this.cuentacontableproduccion_descripcion=cuentacontableproduccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledevolucion_descripcion(String cuentacontabledevolucion_descripcion) {
		try {
			this.cuentacontabledevolucion_descripcion=cuentacontabledevolucion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingresodebito_descripcion(String cuentacontableingresodebito_descripcion) {
		try {
			this.cuentacontableingresodebito_descripcion=cuentacontableingresodebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingresocredito_descripcion(String cuentacontableingresocredito_descripcion) {
		try {
			this.cuentacontableingresocredito_descripcion=cuentacontableingresocredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableresultadodebito_descripcion(String cuentacontableresultadodebito_descripcion) {
		try {
			this.cuentacontableresultadodebito_descripcion=cuentacontableresultadodebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableresultadocredito_descripcion(String cuentacontableresultadocredito_descripcion) {
		try {
			this.cuentacontableresultadocredito_descripcion=cuentacontableresultadocredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_centro_costo_descripcion="";String id_estado_bodega_producto_descripcion="";String con_iva_descripcion="";String con_impuesto_descripcion="";String con_ice_descripcion="";String esta_activo_descripcion="";String con_balanza_descripcion="";String id_cuenta_contable_inventario_descripcion="";String id_cuenta_contable_costo_venta_descripcion="";String id_cuenta_contable_venta_descripcion="";String id_cuenta_contable_descuento_descripcion="";String id_cuenta_contable_produccion_descripcion="";String id_cuenta_contable_devolucion_descripcion="";String id_cuenta_contable_ingreso_debito_descripcion="";String id_cuenta_contable_ingreso_credito_descripcion="";String id_cuenta_contable_resultado_debito_descripcion="";String id_cuenta_contable_resultado_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_estado_bodega_producto_descripcion() {
		return id_estado_bodega_producto_descripcion;
	}
	public String getcon_iva_descripcion() {
		return con_iva_descripcion;
	}
	public String getcon_impuesto_descripcion() {
		return con_impuesto_descripcion;
	}
	public String getcon_ice_descripcion() {
		return con_ice_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	public String getcon_balanza_descripcion() {
		return con_balanza_descripcion;
	}
	public String getid_cuenta_contable_inventario_descripcion() {
		return id_cuenta_contable_inventario_descripcion;
	}
	public String getid_cuenta_contable_costo_venta_descripcion() {
		return id_cuenta_contable_costo_venta_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	public String getid_cuenta_contable_descuento_descripcion() {
		return id_cuenta_contable_descuento_descripcion;
	}
	public String getid_cuenta_contable_produccion_descripcion() {
		return id_cuenta_contable_produccion_descripcion;
	}
	public String getid_cuenta_contable_devolucion_descripcion() {
		return id_cuenta_contable_devolucion_descripcion;
	}
	public String getid_cuenta_contable_ingreso_debito_descripcion() {
		return id_cuenta_contable_ingreso_debito_descripcion;
	}
	public String getid_cuenta_contable_ingreso_credito_descripcion() {
		return id_cuenta_contable_ingreso_credito_descripcion;
	}
	public String getid_cuenta_contable_resultado_debito_descripcion() {
		return id_cuenta_contable_resultado_debito_descripcion;
	}
	public String getid_cuenta_contable_resultado_credito_descripcion() {
		return id_cuenta_contable_resultado_credito_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_bodega_producto_descripcion(String newid_estado_bodega_producto_descripcion)throws Exception {
		try {
			this.id_estado_bodega_producto_descripcion=newid_estado_bodega_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_iva_descripcion(String newcon_iva_descripcion)throws Exception {
		try {
			this.con_iva_descripcion=newcon_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_impuesto_descripcion(String newcon_impuesto_descripcion)throws Exception {
		try {
			this.con_impuesto_descripcion=newcon_impuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_ice_descripcion(String newcon_ice_descripcion)throws Exception {
		try {
			this.con_ice_descripcion=newcon_ice_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_balanza_descripcion(String newcon_balanza_descripcion)throws Exception {
		try {
			this.con_balanza_descripcion=newcon_balanza_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_descripcion(String newid_cuenta_contable_inventario_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_descripcion=newid_cuenta_contable_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_venta_descripcion(String newid_cuenta_contable_costo_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_venta_descripcion=newid_cuenta_contable_costo_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_descripcion(String newid_cuenta_contable_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_descripcion=newid_cuenta_contable_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descuento_descripcion(String newid_cuenta_contable_descuento_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descuento_descripcion=newid_cuenta_contable_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_produccion_descripcion(String newid_cuenta_contable_produccion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_produccion_descripcion=newid_cuenta_contable_produccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_devolucion_descripcion(String newid_cuenta_contable_devolucion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_devolucion_descripcion=newid_cuenta_contable_devolucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_ingreso_debito_descripcion(String newid_cuenta_contable_ingreso_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_ingreso_debito_descripcion=newid_cuenta_contable_ingreso_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_ingreso_credito_descripcion(String newid_cuenta_contable_ingreso_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_ingreso_credito_descripcion=newid_cuenta_contable_ingreso_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_resultado_debito_descripcion(String newid_cuenta_contable_resultado_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_resultado_debito_descripcion=newid_cuenta_contable_resultado_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_resultado_credito_descripcion(String newid_cuenta_contable_resultado_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_resultado_credito_descripcion=newid_cuenta_contable_resultado_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_centro_costo_descripcion="";this.id_estado_bodega_producto_descripcion="";this.con_iva_descripcion="";this.con_impuesto_descripcion="";this.con_ice_descripcion="";this.esta_activo_descripcion="";this.con_balanza_descripcion="";this.id_cuenta_contable_inventario_descripcion="";this.id_cuenta_contable_costo_venta_descripcion="";this.id_cuenta_contable_venta_descripcion="";this.id_cuenta_contable_descuento_descripcion="";this.id_cuenta_contable_produccion_descripcion="";this.id_cuenta_contable_devolucion_descripcion="";this.id_cuenta_contable_ingreso_debito_descripcion="";this.id_cuenta_contable_ingreso_credito_descripcion="";this.id_cuenta_contable_resultado_debito_descripcion="";this.id_cuenta_contable_resultado_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

