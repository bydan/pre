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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.DetalleFacturaProveedorConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class DetalleFacturaProveedor extends DetalleFacturaProveedorAdditional implements Serializable ,Cloneable {//DetalleFacturaProveedorAdditional,GeneralEntity
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
	
	private DetalleFacturaProveedor detallefacturaproveedorOriginal;
	
	private Map<String, Object> mapDetalleFacturaProveedor;
			
	public Map<String, Object> getMapDetalleFacturaProveedor() {
		return mapDetalleFacturaProveedor;
	}

	public void setMapDetalleFacturaProveedor(Map<String, Object> mapDetalleFacturaProveedor) {
		this.mapDetalleFacturaProveedor = mapDetalleFacturaProveedor;
	}
	
	public void inicializarMapDetalleFacturaProveedor() {
		this.mapDetalleFacturaProveedor = new HashMap<String,Object>();
	}
	
	public void setMapDetalleFacturaProveedorValue(String sKey,Object oValue) {
		this.mapDetalleFacturaProveedor.put(sKey, oValue);
	}
	
	public Object getMapDetalleFacturaProveedorValue(String sKey) {
		return this.mapDetalleFacturaProveedor.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura_proveedor;
	
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleFacturaProveedorConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=DetalleFacturaProveedorConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleFacturaProveedorConstantesFunciones.SREGEXLOTE,message=DetalleFacturaProveedorConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_elaboracion_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean costo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_unitario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleFacturaProveedorConstantesFunciones.SREGEXDESCRIPCION,message=DetalleFacturaProveedorConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_novedad_producto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_enviar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleFacturaProveedorConstantesFunciones.SREGEXLOTE_CLIENTE,message=DetalleFacturaProveedorConstantesFunciones.SMENSAJEREGEXLOTE_CLIENTE)
	private String lote_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleFacturaProveedorConstantesFunciones.SREGEXSERIE,message=DetalleFacturaProveedorConstantesFunciones.SMENSAJEREGEXSERIE)
	private String serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice_valor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public FacturaProveedor facturaproveedor;
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public NovedadProducto novedadproducto;
	public CentroCosto centrocosto;
	public CuentaContable cuentacontablecosto;
	public Bodega bodegaenviar;
	public Anio anio;
	public Mes mes;
	
	
	private String facturaproveedor_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String novedadproducto_descripcion;
	private String centrocosto_descripcion;
	private String cuentacontablecosto_descripcion;
	private String bodegaenviar_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public DetalleFacturaProveedor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallefacturaproveedorOriginal=this;
		
 		this.id_factura_proveedor=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.numero_comprobante="";
 		this.cantidad=0;
 		this.cantidad_auxiliar=0;
 		this.descuento=0.0;
 		this.iva=0.0;
 		this.lote="";
 		this.fecha_elaboracion_lote=new Date();
 		this.fecha_caducidad_lote=new Date();
 		this.costo_iva=false;
 		this.costo_unitario=0.0;
 		this.costo_total=0.0;
 		this.ice=0.0;
 		this.descuento1=0.0;
 		this.descuento2=0.0;
 		this.descripcion="";
 		this.precio_venta=0.0;
 		this.id_novedad_producto=-1L;
 		this.id_centro_costo=null;
 		this.id_cuenta_contable_costo=-1L;
 		this.id_bodega_enviar=-1L;
 		this.lote_cliente="";
 		this.disponible=0.0;
 		this.serie="";
 		this.ice_valor=0.0;
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.facturaproveedor=null;
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.ejercicio=null;
		this.periodo=null;
		this.novedadproducto=null;
		this.centrocosto=null;
		this.cuentacontablecosto=null;
		this.bodegaenviar=null;
		this.anio=null;
		this.mes=null;
		
		
		this.facturaproveedor_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.novedadproducto_descripcion="";
		this.centrocosto_descripcion="";
		this.cuentacontablecosto_descripcion="";
		this.bodegaenviar_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleFacturaProveedor (Long id,Date versionRow,Long id_factura_proveedor,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_ejercicio,Long id_periodo,String numero_comprobante,Integer cantidad,Integer cantidad_auxiliar,Double descuento,Double iva,String lote,Date fecha_elaboracion_lote,Date fecha_caducidad_lote,Boolean costo_iva,Double costo_unitario,Double costo_total,Double ice,Double descuento1,Double descuento2,String descripcion,Double precio_venta,Long id_novedad_producto,Long id_centro_costo,Long id_cuenta_contable_costo,Long id_bodega_enviar,String lote_cliente,Double disponible,String serie,Double ice_valor,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallefacturaproveedorOriginal=this;
		
 		this.id_factura_proveedor=id_factura_proveedor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.numero_comprobante=numero_comprobante;
 		this.cantidad=cantidad;
 		this.cantidad_auxiliar=cantidad_auxiliar;
 		this.descuento=descuento;
 		this.iva=iva;
 		this.lote=lote;
 		this.fecha_elaboracion_lote=fecha_elaboracion_lote;
 		this.fecha_caducidad_lote=fecha_caducidad_lote;
 		this.costo_iva=costo_iva;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.ice=ice;
 		this.descuento1=descuento1;
 		this.descuento2=descuento2;
 		this.descripcion=descripcion;
 		this.precio_venta=precio_venta;
 		this.id_novedad_producto=id_novedad_producto;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_bodega_enviar=id_bodega_enviar;
 		this.lote_cliente=lote_cliente;
 		this.disponible=disponible;
 		this.serie=serie;
 		this.ice_valor=ice_valor;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleFacturaProveedor (Long id_factura_proveedor,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Long id_ejercicio,Long id_periodo,String numero_comprobante,Integer cantidad,Integer cantidad_auxiliar,Double descuento,Double iva,String lote,Date fecha_elaboracion_lote,Date fecha_caducidad_lote,Boolean costo_iva,Double costo_unitario,Double costo_total,Double ice,Double descuento1,Double descuento2,String descripcion,Double precio_venta,Long id_novedad_producto,Long id_centro_costo,Long id_cuenta_contable_costo,Long id_bodega_enviar,String lote_cliente,Double disponible,String serie,Double ice_valor,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallefacturaproveedorOriginal=this;
		
 		this.id_factura_proveedor=id_factura_proveedor;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.numero_comprobante=numero_comprobante;
 		this.cantidad=cantidad;
 		this.cantidad_auxiliar=cantidad_auxiliar;
 		this.descuento=descuento;
 		this.iva=iva;
 		this.lote=lote;
 		this.fecha_elaboracion_lote=fecha_elaboracion_lote;
 		this.fecha_caducidad_lote=fecha_caducidad_lote;
 		this.costo_iva=costo_iva;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.ice=ice;
 		this.descuento1=descuento1;
 		this.descuento2=descuento2;
 		this.descripcion=descripcion;
 		this.precio_venta=precio_venta;
 		this.id_novedad_producto=id_novedad_producto;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_bodega_enviar=id_bodega_enviar;
 		this.lote_cliente=lote_cliente;
 		this.disponible=disponible;
 		this.serie=serie;
 		this.ice_valor=ice_valor;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleFacturaProveedor detallefacturaproveedorLocal=null;
		
		if(object!=null) {
			detallefacturaproveedorLocal=(DetalleFacturaProveedor)object;
			
			if(detallefacturaproveedorLocal!=null) {
				if(this.getId()!=null && detallefacturaproveedorLocal.getId()!=null) {
					if(this.getId().equals(detallefacturaproveedorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleFacturaProveedorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleFacturaProveedorConstantesFunciones.getDetalleFacturaProveedorDescripcion(this);
		} else {
			sDetalle=DetalleFacturaProveedorConstantesFunciones.getDetalleFacturaProveedorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleFacturaProveedor getDetalleFacturaProveedorOriginal() {
		return this.detallefacturaproveedorOriginal;
	}
	
	public void setDetalleFacturaProveedorOriginal(DetalleFacturaProveedor detallefacturaproveedor) {
		try {
			this.detallefacturaproveedorOriginal=detallefacturaproveedor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleFacturaProveedorAdditional detallefacturaproveedorAdditional=null;
	
	public DetalleFacturaProveedorAdditional getDetalleFacturaProveedorAdditional() {
		return this.detallefacturaproveedorAdditional;
	}
	
	public void setDetalleFacturaProveedorAdditional(DetalleFacturaProveedorAdditional detallefacturaproveedorAdditional) {
		try {
			this.detallefacturaproveedorAdditional=detallefacturaproveedorAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_factura_proveedor() {
		return this.id_factura_proveedor;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Integer getcantidad_auxiliar() {
		return this.cantidad_auxiliar;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Date getfecha_elaboracion_lote() {
		return this.fecha_elaboracion_lote;
	}
    
	
	public Date getfecha_caducidad_lote() {
		return this.fecha_caducidad_lote;
	}
    
	
	public Boolean getcosto_iva() {
		return this.costo_iva;
	}
    
	
	public Double getcosto_unitario() {
		return this.costo_unitario;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getdescuento1() {
		return this.descuento1;
	}
    
	
	public Double getdescuento2() {
		return this.descuento2;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getprecio_venta() {
		return this.precio_venta;
	}
    
	
	public Long getid_novedad_producto() {
		return this.id_novedad_producto;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_cuenta_contable_costo() {
		return this.id_cuenta_contable_costo;
	}
    
	
	public Long getid_bodega_enviar() {
		return this.id_bodega_enviar;
	}
    
	
	public String getlote_cliente() {
		return this.lote_cliente;
	}
    
	
	public Double getdisponible() {
		return this.disponible;
	}
    
	
	public String getserie() {
		return this.serie;
	}
    
	
	public Double getice_valor() {
		return this.ice_valor;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_factura_proveedor(Long newid_factura_proveedor)throws Exception
	{
		try {
			if(this.id_factura_proveedor!=newid_factura_proveedor) {
				if(newid_factura_proveedor==null) {
					//newid_factura_proveedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_factura_proveedor");
					}
				}

				this.id_factura_proveedor=newid_factura_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_producto");
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("DetalleFacturaProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_auxiliar(Integer newcantidad_auxiliar)throws Exception
	{
		try {
			if(this.cantidad_auxiliar!=newcantidad_auxiliar) {
				if(newcantidad_auxiliar==null) {
					//newcantidad_auxiliar=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna cantidad_auxiliar");
					}
				}

				this.cantidad_auxiliar=newcantidad_auxiliar;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("DetalleFacturaProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_elaboracion_lote(Date newfecha_elaboracion_lote)throws Exception
	{
		try {
			if(this.fecha_elaboracion_lote!=newfecha_elaboracion_lote) {
				if(newfecha_elaboracion_lote==null) {
					//newfecha_elaboracion_lote=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna fecha_elaboracion_lote");
					}
				}

				this.fecha_elaboracion_lote=newfecha_elaboracion_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caducidad_lote(Date newfecha_caducidad_lote)throws Exception
	{
		try {
			if(this.fecha_caducidad_lote!=newfecha_caducidad_lote) {
				if(newfecha_caducidad_lote==null) {
					//newfecha_caducidad_lote=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna fecha_caducidad_lote");
					}
				}

				this.fecha_caducidad_lote=newfecha_caducidad_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_iva(Boolean newcosto_iva)throws Exception
	{
		try {
			if(this.costo_iva!=newcosto_iva) {
				if(newcosto_iva==null) {
					//newcosto_iva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna costo_iva");
					}
				}

				this.costo_iva=newcosto_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_unitario(Double newcosto_unitario)throws Exception
	{
		try {
			if(this.costo_unitario!=newcosto_unitario) {
				if(newcosto_unitario==null) {
					//newcosto_unitario=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna costo_unitario");
					}
				}

				this.costo_unitario=newcosto_unitario;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento1(Double newdescuento1)throws Exception
	{
		try {
			if(this.descuento1!=newdescuento1) {
				if(newdescuento1==null) {
					//newdescuento1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna descuento1");
					}
				}

				this.descuento1=newdescuento1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento2(Double newdescuento2)throws Exception
	{
		try {
			if(this.descuento2!=newdescuento2) {
				if(newdescuento2==null) {
					//newdescuento2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna descuento2");
					}
				}

				this.descuento2=newdescuento2;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleFacturaProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio_venta(Double newprecio_venta)throws Exception
	{
		try {
			if(this.precio_venta!=newprecio_venta) {
				if(newprecio_venta==null) {
					//newprecio_venta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna precio_venta");
					}
				}

				this.precio_venta=newprecio_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_novedad_producto(Long newid_novedad_producto)throws Exception
	{
		try {
			if(this.id_novedad_producto!=newid_novedad_producto) {
				if(newid_novedad_producto==null) {
					//newid_novedad_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_novedad_producto");
					}
				}

				this.id_novedad_producto=newid_novedad_producto;
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
    
	public void setid_cuenta_contable_costo(Long newid_cuenta_contable_costo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo!=newid_cuenta_contable_costo) {
				if(newid_cuenta_contable_costo==null) {
					//newid_cuenta_contable_costo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_cuenta_contable_costo");
					}
				}

				this.id_cuenta_contable_costo=newid_cuenta_contable_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_enviar(Long newid_bodega_enviar)throws Exception
	{
		try {
			if(this.id_bodega_enviar!=newid_bodega_enviar) {
				if(newid_bodega_enviar==null) {
					//newid_bodega_enviar=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna id_bodega_enviar");
					}
				}

				this.id_bodega_enviar=newid_bodega_enviar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote_cliente(String newlote_cliente)throws Exception
	{
		try {
			if(this.lote_cliente!=newlote_cliente) {
				if(newlote_cliente==null) {
					//newlote_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna lote_cliente");
					}
				}

				if(newlote_cliente!=null&&newlote_cliente.length()>50) {
					newlote_cliente=newlote_cliente.substring(0,48);
					System.out.println("DetalleFacturaProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote_cliente");
				}

				this.lote_cliente=newlote_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdisponible(Double newdisponible)throws Exception
	{
		try {
			if(this.disponible!=newdisponible) {
				if(newdisponible==null) {
					//newdisponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna disponible");
					}
				}

				this.disponible=newdisponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie(String newserie)throws Exception
	{
		try {
			if(this.serie!=newserie) {
				if(newserie==null) {
					//newserie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna serie");
					}
				}

				if(newserie!=null&&newserie.length()>50) {
					newserie=newserie.substring(0,48);
					System.out.println("DetalleFacturaProveedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna serie");
				}

				this.serie=newserie;
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
						System.out.println("DetalleFacturaProveedor:Valor nulo no permitido en columna ice_valor");
					}
				}

				this.ice_valor=newice_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
	
	
	public FacturaProveedor getFacturaProveedor() {
		return this.facturaproveedor;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public NovedadProducto getNovedadProducto() {
		return this.novedadproducto;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public CuentaContable getCuentaContableCosto() {
		return this.cuentacontablecosto;
	}

	public Bodega getBodegaEnviar() {
		return this.bodegaenviar;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getfacturaproveedor_descripcion() {
		return this.facturaproveedor_descripcion;
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

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getnovedadproducto_descripcion() {
		return this.novedadproducto_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getcuentacontablecosto_descripcion() {
		return this.cuentacontablecosto_descripcion;
	}

	public String getbodegaenviar_descripcion() {
		return this.bodegaenviar_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setFacturaProveedor(FacturaProveedor facturaproveedor) {
		try {
			this.facturaproveedor=facturaproveedor;
		} catch(Exception e) {
			;
		}
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNovedadProducto(NovedadProducto novedadproducto) {
		try {
			this.novedadproducto=novedadproducto;
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


	public  void  setCuentaContableCosto(CuentaContable cuentacontablecosto) {
		try {
			this.cuentacontablecosto=cuentacontablecosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaEnviar(Bodega bodegaenviar) {
		try {
			this.bodegaenviar=bodegaenviar;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setfacturaproveedor_descripcion(String facturaproveedor_descripcion) {
		try {
			this.facturaproveedor_descripcion=facturaproveedor_descripcion;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnovedadproducto_descripcion(String novedadproducto_descripcion) {
		try {
			this.novedadproducto_descripcion=novedadproducto_descripcion;
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


	public  void  setcuentacontablecosto_descripcion(String cuentacontablecosto_descripcion) {
		try {
			this.cuentacontablecosto_descripcion=cuentacontablecosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegaenviar_descripcion(String bodegaenviar_descripcion) {
		try {
			this.bodegaenviar_descripcion=bodegaenviar_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_factura_proveedor_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String costo_iva_descripcion="";String id_novedad_producto_descripcion="";String id_centro_costo_descripcion="";String id_cuenta_contable_costo_descripcion="";String id_bodega_enviar_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_factura_proveedor_descripcion() {
		return id_factura_proveedor_descripcion;
	}
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
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getcosto_iva_descripcion() {
		return costo_iva_descripcion;
	}
	public String getid_novedad_producto_descripcion() {
		return id_novedad_producto_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_cuenta_contable_costo_descripcion() {
		return id_cuenta_contable_costo_descripcion;
	}
	public String getid_bodega_enviar_descripcion() {
		return id_bodega_enviar_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	
	
	public void setid_factura_proveedor_descripcion(String newid_factura_proveedor_descripcion)throws Exception {
		try {
			this.id_factura_proveedor_descripcion=newid_factura_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcosto_iva_descripcion(String newcosto_iva_descripcion)throws Exception {
		try {
			this.costo_iva_descripcion=newcosto_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_novedad_producto_descripcion(String newid_novedad_producto_descripcion)throws Exception {
		try {
			this.id_novedad_producto_descripcion=newid_novedad_producto_descripcion;
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
	public void setid_cuenta_contable_costo_descripcion(String newid_cuenta_contable_costo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_descripcion=newid_cuenta_contable_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_enviar_descripcion(String newid_bodega_enviar_descripcion)throws Exception {
		try {
			this.id_bodega_enviar_descripcion=newid_bodega_enviar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_factura_proveedor_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.costo_iva_descripcion="";this.id_novedad_producto_descripcion="";this.id_centro_costo_descripcion="";this.id_cuenta_contable_costo_descripcion="";this.id_bodega_enviar_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

