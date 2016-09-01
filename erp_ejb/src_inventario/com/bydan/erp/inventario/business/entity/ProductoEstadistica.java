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
//import com.bydan.erp.inventario.util.ProductoEstadisticaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ProductoEstadistica extends ProductoEstadisticaAdditional implements Serializable ,Cloneable {//ProductoEstadisticaAdditional,GeneralEntity
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
	
	private ProductoEstadistica productoestadisticaOriginal;
	
	private Map<String, Object> mapProductoEstadistica;
			
	public Map<String, Object> getMapProductoEstadistica() {
		return mapProductoEstadistica;
	}

	public void setMapProductoEstadistica(Map<String, Object> mapProductoEstadistica) {
		this.mapProductoEstadistica = mapProductoEstadistica;
	}
	
	public void inicializarMapProductoEstadistica() {
		this.mapProductoEstadistica = new HashMap<String,Object>();
	}
	
	public void setMapProductoEstadisticaValue(String sKey,Object oValue) {
		this.mapProductoEstadistica.put(sKey, oValue);
	}
	
	public Object getMapProductoEstadisticaValue(String sKey) {
		return this.mapProductoEstadistica.get(sKey);
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
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_ultima_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_ultima_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_ultima_cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_ultima_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_reservada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_demanda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_maximo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_fisica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_pedida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_producido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_devuelto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_ultimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_produccion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	
	
		
	public ProductoEstadistica () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productoestadisticaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.precio_ultima_compra=0.0;
 		this.precio_ultima_venta=0.0;
 		this.precio_ultima_cotizacion=0.0;
 		this.precio_ultima_proforma=0.0;
 		this.cantidad_disponible=0;
 		this.cantidad_reservada=0.0;
 		this.cantidad_demanda=0.0;
 		this.cantidad_maximo=0;
 		this.cantidad_minimo=0;
 		this.cantidad_fisica=0.0;
 		this.cantidad_orden_compra=0.0;
 		this.cantidad_pedida=0.0;
 		this.cantidad_requisicion=0.0;
 		this.fecha_ultima_ingreso=new Date();
 		this.fecha_ultima_egreso=new Date();
 		this.fecha_ultima_produccion=new Date();
 		this.fecha_ultima_compra=new Date();
 		this.fecha_ultima_venta=new Date();
 		this.fecha_ultima_devolucion=new Date();
 		this.fecha_ultima_orden_compra=new Date();
 		this.fecha_ultima_pedido=new Date();
 		this.fecha_ultima_requisicion=new Date();
 		this.total_ingreso=0.0;
 		this.total_egreso=0.0;
 		this.total_compra=0.0;
 		this.total_venta=0.0;
 		this.total_producido=0.0;
 		this.total_devuelto=0.0;
 		this.costo_ultimo=0.0;
 		this.costo_total=0.0;
 		this.costo_produccion=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductoEstadistica (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Double precio_ultima_compra,Double precio_ultima_venta,Double precio_ultima_cotizacion,Double precio_ultima_proforma,Integer cantidad_disponible,Double cantidad_reservada,Double cantidad_demanda,Integer cantidad_maximo,Integer cantidad_minimo,Double cantidad_fisica,Double cantidad_orden_compra,Double cantidad_pedida,Double cantidad_requisicion,Date fecha_ultima_ingreso,Date fecha_ultima_egreso,Date fecha_ultima_produccion,Date fecha_ultima_compra,Date fecha_ultima_venta,Date fecha_ultima_devolucion,Date fecha_ultima_orden_compra,Date fecha_ultima_pedido,Date fecha_ultima_requisicion,Double total_ingreso,Double total_egreso,Double total_compra,Double total_venta,Double total_producido,Double total_devuelto,Double costo_ultimo,Double costo_total,Double costo_produccion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoestadisticaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.precio_ultima_compra=precio_ultima_compra;
 		this.precio_ultima_venta=precio_ultima_venta;
 		this.precio_ultima_cotizacion=precio_ultima_cotizacion;
 		this.precio_ultima_proforma=precio_ultima_proforma;
 		this.cantidad_disponible=cantidad_disponible;
 		this.cantidad_reservada=cantidad_reservada;
 		this.cantidad_demanda=cantidad_demanda;
 		this.cantidad_maximo=cantidad_maximo;
 		this.cantidad_minimo=cantidad_minimo;
 		this.cantidad_fisica=cantidad_fisica;
 		this.cantidad_orden_compra=cantidad_orden_compra;
 		this.cantidad_pedida=cantidad_pedida;
 		this.cantidad_requisicion=cantidad_requisicion;
 		this.fecha_ultima_ingreso=fecha_ultima_ingreso;
 		this.fecha_ultima_egreso=fecha_ultima_egreso;
 		this.fecha_ultima_produccion=fecha_ultima_produccion;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.fecha_ultima_devolucion=fecha_ultima_devolucion;
 		this.fecha_ultima_orden_compra=fecha_ultima_orden_compra;
 		this.fecha_ultima_pedido=fecha_ultima_pedido;
 		this.fecha_ultima_requisicion=fecha_ultima_requisicion;
 		this.total_ingreso=total_ingreso;
 		this.total_egreso=total_egreso;
 		this.total_compra=total_compra;
 		this.total_venta=total_venta;
 		this.total_producido=total_producido;
 		this.total_devuelto=total_devuelto;
 		this.costo_ultimo=costo_ultimo;
 		this.costo_total=costo_total;
 		this.costo_produccion=costo_produccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductoEstadistica (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Double precio_ultima_compra,Double precio_ultima_venta,Double precio_ultima_cotizacion,Double precio_ultima_proforma,Integer cantidad_disponible,Double cantidad_reservada,Double cantidad_demanda,Integer cantidad_maximo,Integer cantidad_minimo,Double cantidad_fisica,Double cantidad_orden_compra,Double cantidad_pedida,Double cantidad_requisicion,Date fecha_ultima_ingreso,Date fecha_ultima_egreso,Date fecha_ultima_produccion,Date fecha_ultima_compra,Date fecha_ultima_venta,Date fecha_ultima_devolucion,Date fecha_ultima_orden_compra,Date fecha_ultima_pedido,Date fecha_ultima_requisicion,Double total_ingreso,Double total_egreso,Double total_compra,Double total_venta,Double total_producido,Double total_devuelto,Double costo_ultimo,Double costo_total,Double costo_produccion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoestadisticaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.precio_ultima_compra=precio_ultima_compra;
 		this.precio_ultima_venta=precio_ultima_venta;
 		this.precio_ultima_cotizacion=precio_ultima_cotizacion;
 		this.precio_ultima_proforma=precio_ultima_proforma;
 		this.cantidad_disponible=cantidad_disponible;
 		this.cantidad_reservada=cantidad_reservada;
 		this.cantidad_demanda=cantidad_demanda;
 		this.cantidad_maximo=cantidad_maximo;
 		this.cantidad_minimo=cantidad_minimo;
 		this.cantidad_fisica=cantidad_fisica;
 		this.cantidad_orden_compra=cantidad_orden_compra;
 		this.cantidad_pedida=cantidad_pedida;
 		this.cantidad_requisicion=cantidad_requisicion;
 		this.fecha_ultima_ingreso=fecha_ultima_ingreso;
 		this.fecha_ultima_egreso=fecha_ultima_egreso;
 		this.fecha_ultima_produccion=fecha_ultima_produccion;
 		this.fecha_ultima_compra=fecha_ultima_compra;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.fecha_ultima_devolucion=fecha_ultima_devolucion;
 		this.fecha_ultima_orden_compra=fecha_ultima_orden_compra;
 		this.fecha_ultima_pedido=fecha_ultima_pedido;
 		this.fecha_ultima_requisicion=fecha_ultima_requisicion;
 		this.total_ingreso=total_ingreso;
 		this.total_egreso=total_egreso;
 		this.total_compra=total_compra;
 		this.total_venta=total_venta;
 		this.total_producido=total_producido;
 		this.total_devuelto=total_devuelto;
 		this.costo_ultimo=costo_ultimo;
 		this.costo_total=costo_total;
 		this.costo_produccion=costo_produccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProductoEstadistica productoestadisticaLocal=null;
		
		if(object!=null) {
			productoestadisticaLocal=(ProductoEstadistica)object;
			
			if(productoestadisticaLocal!=null) {
				if(this.getId()!=null && productoestadisticaLocal.getId()!=null) {
					if(this.getId().equals(productoestadisticaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoEstadisticaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoEstadisticaConstantesFunciones.getProductoEstadisticaDescripcion(this);
		} else {
			sDetalle=ProductoEstadisticaConstantesFunciones.getProductoEstadisticaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProductoEstadistica getProductoEstadisticaOriginal() {
		return this.productoestadisticaOriginal;
	}
	
	public void setProductoEstadisticaOriginal(ProductoEstadistica productoestadistica) {
		try {
			this.productoestadisticaOriginal=productoestadistica;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoEstadisticaAdditional productoestadisticaAdditional=null;
	
	public ProductoEstadisticaAdditional getProductoEstadisticaAdditional() {
		return this.productoestadisticaAdditional;
	}
	
	public void setProductoEstadisticaAdditional(ProductoEstadisticaAdditional productoestadisticaAdditional) {
		try {
			this.productoestadisticaAdditional=productoestadisticaAdditional;
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
    
	
	public Double getprecio_ultima_compra() {
		return this.precio_ultima_compra;
	}
    
	
	public Double getprecio_ultima_venta() {
		return this.precio_ultima_venta;
	}
    
	
	public Double getprecio_ultima_cotizacion() {
		return this.precio_ultima_cotizacion;
	}
    
	
	public Double getprecio_ultima_proforma() {
		return this.precio_ultima_proforma;
	}
    
	
	public Integer getcantidad_disponible() {
		return this.cantidad_disponible;
	}
    
	
	public Double getcantidad_reservada() {
		return this.cantidad_reservada;
	}
    
	
	public Double getcantidad_demanda() {
		return this.cantidad_demanda;
	}
    
	
	public Integer getcantidad_maximo() {
		return this.cantidad_maximo;
	}
    
	
	public Integer getcantidad_minimo() {
		return this.cantidad_minimo;
	}
    
	
	public Double getcantidad_fisica() {
		return this.cantidad_fisica;
	}
    
	
	public Double getcantidad_orden_compra() {
		return this.cantidad_orden_compra;
	}
    
	
	public Double getcantidad_pedida() {
		return this.cantidad_pedida;
	}
    
	
	public Double getcantidad_requisicion() {
		return this.cantidad_requisicion;
	}
    
	
	public Date getfecha_ultima_ingreso() {
		return this.fecha_ultima_ingreso;
	}
    
	
	public Date getfecha_ultima_egreso() {
		return this.fecha_ultima_egreso;
	}
    
	
	public Date getfecha_ultima_produccion() {
		return this.fecha_ultima_produccion;
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
    
	
	public Date getfecha_ultima_orden_compra() {
		return this.fecha_ultima_orden_compra;
	}
    
	
	public Date getfecha_ultima_pedido() {
		return this.fecha_ultima_pedido;
	}
    
	
	public Date getfecha_ultima_requisicion() {
		return this.fecha_ultima_requisicion;
	}
    
	
	public Double gettotal_ingreso() {
		return this.total_ingreso;
	}
    
	
	public Double gettotal_egreso() {
		return this.total_egreso;
	}
    
	
	public Double gettotal_compra() {
		return this.total_compra;
	}
    
	
	public Double gettotal_venta() {
		return this.total_venta;
	}
    
	
	public Double gettotal_producido() {
		return this.total_producido;
	}
    
	
	public Double gettotal_devuelto() {
		return this.total_devuelto;
	}
    
	
	public Double getcosto_ultimo() {
		return this.costo_ultimo;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
	}
    
	
	public Double getcosto_produccion() {
		return this.costo_produccion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_ultima_compra(Double newprecio_ultima_compra)throws Exception
	{
		try {
			if(this.precio_ultima_compra!=newprecio_ultima_compra) {
				if(newprecio_ultima_compra==null) {
					//newprecio_ultima_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna precio_ultima_compra");
					}
				}

				this.precio_ultima_compra=newprecio_ultima_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_ultima_venta(Double newprecio_ultima_venta)throws Exception
	{
		try {
			if(this.precio_ultima_venta!=newprecio_ultima_venta) {
				if(newprecio_ultima_venta==null) {
					//newprecio_ultima_venta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna precio_ultima_venta");
					}
				}

				this.precio_ultima_venta=newprecio_ultima_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_ultima_cotizacion(Double newprecio_ultima_cotizacion)throws Exception
	{
		try {
			if(this.precio_ultima_cotizacion!=newprecio_ultima_cotizacion) {
				if(newprecio_ultima_cotizacion==null) {
					//newprecio_ultima_cotizacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna precio_ultima_cotizacion");
					}
				}

				this.precio_ultima_cotizacion=newprecio_ultima_cotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_ultima_proforma(Double newprecio_ultima_proforma)throws Exception
	{
		try {
			if(this.precio_ultima_proforma!=newprecio_ultima_proforma) {
				if(newprecio_ultima_proforma==null) {
					//newprecio_ultima_proforma=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna precio_ultima_proforma");
					}
				}

				this.precio_ultima_proforma=newprecio_ultima_proforma;
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_disponible");
					}
				}

				this.cantidad_disponible=newcantidad_disponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_reservada(Double newcantidad_reservada)throws Exception
	{
		try {
			if(this.cantidad_reservada!=newcantidad_reservada) {
				if(newcantidad_reservada==null) {
					//newcantidad_reservada=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_reservada");
					}
				}

				this.cantidad_reservada=newcantidad_reservada;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_demanda(Double newcantidad_demanda)throws Exception
	{
		try {
			if(this.cantidad_demanda!=newcantidad_demanda) {
				if(newcantidad_demanda==null) {
					//newcantidad_demanda=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_demanda");
					}
				}

				this.cantidad_demanda=newcantidad_demanda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_maximo(Integer newcantidad_maximo)throws Exception
	{
		try {
			if(this.cantidad_maximo!=newcantidad_maximo) {
				if(newcantidad_maximo==null) {
					//newcantidad_maximo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_maximo");
					}
				}

				this.cantidad_maximo=newcantidad_maximo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_minimo(Integer newcantidad_minimo)throws Exception
	{
		try {
			if(this.cantidad_minimo!=newcantidad_minimo) {
				if(newcantidad_minimo==null) {
					//newcantidad_minimo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_minimo");
					}
				}

				this.cantidad_minimo=newcantidad_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_fisica(Double newcantidad_fisica)throws Exception
	{
		try {
			if(this.cantidad_fisica!=newcantidad_fisica) {
				if(newcantidad_fisica==null) {
					//newcantidad_fisica=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_fisica");
					}
				}

				this.cantidad_fisica=newcantidad_fisica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_orden_compra(Double newcantidad_orden_compra)throws Exception
	{
		try {
			if(this.cantidad_orden_compra!=newcantidad_orden_compra) {
				if(newcantidad_orden_compra==null) {
					//newcantidad_orden_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_orden_compra");
					}
				}

				this.cantidad_orden_compra=newcantidad_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_pedida(Double newcantidad_pedida)throws Exception
	{
		try {
			if(this.cantidad_pedida!=newcantidad_pedida) {
				if(newcantidad_pedida==null) {
					//newcantidad_pedida=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_pedida");
					}
				}

				this.cantidad_pedida=newcantidad_pedida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_requisicion(Double newcantidad_requisicion)throws Exception
	{
		try {
			if(this.cantidad_requisicion!=newcantidad_requisicion) {
				if(newcantidad_requisicion==null) {
					//newcantidad_requisicion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna cantidad_requisicion");
					}
				}

				this.cantidad_requisicion=newcantidad_requisicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_ingreso(Date newfecha_ultima_ingreso)throws Exception
	{
		try {
			if(this.fecha_ultima_ingreso!=newfecha_ultima_ingreso) {
				if(newfecha_ultima_ingreso==null) {
					//newfecha_ultima_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_ingreso");
					}
				}

				this.fecha_ultima_ingreso=newfecha_ultima_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_egreso(Date newfecha_ultima_egreso)throws Exception
	{
		try {
			if(this.fecha_ultima_egreso!=newfecha_ultima_egreso) {
				if(newfecha_ultima_egreso==null) {
					//newfecha_ultima_egreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_egreso");
					}
				}

				this.fecha_ultima_egreso=newfecha_ultima_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_produccion(Date newfecha_ultima_produccion)throws Exception
	{
		try {
			if(this.fecha_ultima_produccion!=newfecha_ultima_produccion) {
				if(newfecha_ultima_produccion==null) {
					//newfecha_ultima_produccion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_produccion");
					}
				}

				this.fecha_ultima_produccion=newfecha_ultima_produccion;
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_compra");
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_venta");
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
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_devolucion");
					}
				}

				this.fecha_ultima_devolucion=newfecha_ultima_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_orden_compra(Date newfecha_ultima_orden_compra)throws Exception
	{
		try {
			if(this.fecha_ultima_orden_compra!=newfecha_ultima_orden_compra) {
				if(newfecha_ultima_orden_compra==null) {
					//newfecha_ultima_orden_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_orden_compra");
					}
				}

				this.fecha_ultima_orden_compra=newfecha_ultima_orden_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_pedido(Date newfecha_ultima_pedido)throws Exception
	{
		try {
			if(this.fecha_ultima_pedido!=newfecha_ultima_pedido) {
				if(newfecha_ultima_pedido==null) {
					//newfecha_ultima_pedido=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_pedido");
					}
				}

				this.fecha_ultima_pedido=newfecha_ultima_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_requisicion(Date newfecha_ultima_requisicion)throws Exception
	{
		try {
			if(this.fecha_ultima_requisicion!=newfecha_ultima_requisicion) {
				if(newfecha_ultima_requisicion==null) {
					//newfecha_ultima_requisicion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna fecha_ultima_requisicion");
					}
				}

				this.fecha_ultima_requisicion=newfecha_ultima_requisicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_ingreso(Double newtotal_ingreso)throws Exception
	{
		try {
			if(this.total_ingreso!=newtotal_ingreso) {
				if(newtotal_ingreso==null) {
					//newtotal_ingreso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_ingreso");
					}
				}

				this.total_ingreso=newtotal_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_egreso(Double newtotal_egreso)throws Exception
	{
		try {
			if(this.total_egreso!=newtotal_egreso) {
				if(newtotal_egreso==null) {
					//newtotal_egreso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_egreso");
					}
				}

				this.total_egreso=newtotal_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_compra(Double newtotal_compra)throws Exception
	{
		try {
			if(this.total_compra!=newtotal_compra) {
				if(newtotal_compra==null) {
					//newtotal_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_compra");
					}
				}

				this.total_compra=newtotal_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_venta(Double newtotal_venta)throws Exception
	{
		try {
			if(this.total_venta!=newtotal_venta) {
				if(newtotal_venta==null) {
					//newtotal_venta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_venta");
					}
				}

				this.total_venta=newtotal_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_producido(Double newtotal_producido)throws Exception
	{
		try {
			if(this.total_producido!=newtotal_producido) {
				if(newtotal_producido==null) {
					//newtotal_producido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_producido");
					}
				}

				this.total_producido=newtotal_producido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_devuelto(Double newtotal_devuelto)throws Exception
	{
		try {
			if(this.total_devuelto!=newtotal_devuelto) {
				if(newtotal_devuelto==null) {
					//newtotal_devuelto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna total_devuelto");
					}
				}

				this.total_devuelto=newtotal_devuelto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_ultimo(Double newcosto_ultimo)throws Exception
	{
		try {
			if(this.costo_ultimo!=newcosto_ultimo) {
				if(newcosto_ultimo==null) {
					//newcosto_ultimo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna costo_ultimo");
					}
				}

				this.costo_ultimo=newcosto_ultimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_total(Double newcosto_total)throws Exception
	{
		try {
			if(this.costo_total!=newcosto_total) {
				if(newcosto_total==null) {
					//newcosto_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_produccion(Double newcosto_produccion)throws Exception
	{
		try {
			if(this.costo_produccion!=newcosto_produccion) {
				if(newcosto_produccion==null) {
					//newcosto_produccion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoEstadistica:Valor nulo no permitido en columna costo_produccion");
					}
				}

				this.costo_produccion=newcosto_produccion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";
	
	
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

