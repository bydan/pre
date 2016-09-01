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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.DetalleProveConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class DetalleProve extends DetalleProveAdditional implements Serializable ,Cloneable {//DetalleProveAdditional,GeneralEntity
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
	
	private DetalleProve detalleproveOriginal;
	
	private Map<String, Object> mapDetalleProve;
			
	public Map<String, Object> getMapDetalleProve() {
		return mapDetalleProve;
	}

	public void setMapDetalleProve(Map<String, Object> mapDetalleProve) {
		this.mapDetalleProve = mapDetalleProve;
	}
	
	public void inicializarMapDetalleProve() {
		this.mapDetalleProve = new HashMap<String,Object>();
	}
	
	public void setMapDetalleProveValue(String sKey,Object oValue) {
		this.mapDetalleProve.put(sKey, oValue);
	}
	
	public Object getMapDetalleProveValue(String sKey) {
		return this.mapDetalleProve.get(sKey);
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
	private Long id_sucursal_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_detalle_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_mone_extra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProveConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=DetalleProveConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProveConstantesFunciones.SREGEXNUMERO_FACTURA,message=DetalleProveConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_mone_extra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_mone_extra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProveConstantesFunciones.SREGEXDESCRIPCION,message=DetalleProveConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Sucursal sucursalmovimiento;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Modulo modulo;
	public Moneda moneda;
	public Cliente cliente;
	public Transaccion transaccion;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public AsientoContable asientocontable;
	public Factura factura;
	public OrdenCompra ordencompra;
	public EstadoDetalleCliente estadodetallecliente;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String sucursalmovimiento_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String modulo_descripcion;
	private String moneda_descripcion;
	private String cliente_descripcion;
	private String transaccion_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String asientocontable_descripcion;
	private String factura_descripcion;
	private String ordencompra_descripcion;
	private String estadodetallecliente_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<PagoAuto> pagoautos;
	public List<AutoriPago> autoripagos;
		
	public DetalleProve () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleproveOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_sucursal_movimiento=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_modulo=-1L;
 		this.id_moneda=-1L;
 		this.id_cliente=-1L;
 		this.id_transaccion=-1L;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_asiento_contable=-1L;
 		this.id_factura=-1L;
 		this.id_orden_compra=null;
 		this.id_estado_detalle_cliente=-1L;
 		this.fecha_venta=new Date();
 		this.fecha_emision=new Date();
 		this.fecha_pago=new Date();
 		this.fecha_vencimiento=new Date();
 		this.monto_mone_local=0.0;
 		this.monto_mone_extra=0.0;
 		this.numero_comprobante="";
 		this.numero_factura="";
 		this.debito_mone_local=0.0;
 		this.credito_mone_local=0.0;
 		this.debito_mone_extra=0.0;
 		this.credito_mone_extra=0.0;
 		this.descripcion="";
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.sucursalmovimiento=null;
		this.ejercicio=null;
		this.periodo=null;
		this.modulo=null;
		this.moneda=null;
		this.cliente=null;
		this.transaccion=null;
		this.tipotransaccionmodulo=null;
		this.asientocontable=null;
		this.factura=null;
		this.ordencompra=null;
		this.estadodetallecliente=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.sucursalmovimiento_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.modulo_descripcion="";
		this.moneda_descripcion="";
		this.cliente_descripcion="";
		this.transaccion_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.asientocontable_descripcion="";
		this.factura_descripcion="";
		this.ordencompra_descripcion="";
		this.estadodetallecliente_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.pagoautos=null;
		this.autoripagos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleProve (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_sucursal_movimiento,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_moneda,Long id_cliente,Long id_transaccion,Long id_tipo_transaccion_modulo,Long id_asiento_contable,Long id_factura,Long id_orden_compra,Long id_estado_detalle_cliente,Date fecha_venta,Date fecha_emision,Date fecha_pago,Date fecha_vencimiento,Double monto_mone_local,Double monto_mone_extra,String numero_comprobante,String numero_factura,Double debito_mone_local,Double credito_mone_local,Double debito_mone_extra,Double credito_mone_extra,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleproveOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_sucursal_movimiento=id_sucursal_movimiento;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_modulo=id_modulo;
 		this.id_moneda=id_moneda;
 		this.id_cliente=id_cliente;
 		this.id_transaccion=id_transaccion;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_factura=id_factura;
 		this.id_orden_compra=id_orden_compra;
 		this.id_estado_detalle_cliente=id_estado_detalle_cliente;
 		this.fecha_venta=fecha_venta;
 		this.fecha_emision=fecha_emision;
 		this.fecha_pago=fecha_pago;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.monto_mone_local=monto_mone_local;
 		this.monto_mone_extra=monto_mone_extra;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
 		this.credito_mone_extra=credito_mone_extra;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleProve (Long id_empresa,Long id_sucursal,Long id_sucursal_movimiento,Long id_ejercicio,Long id_periodo,Long id_modulo,Long id_moneda,Long id_cliente,Long id_transaccion,Long id_tipo_transaccion_modulo,Long id_asiento_contable,Long id_factura,Long id_orden_compra,Long id_estado_detalle_cliente,Date fecha_venta,Date fecha_emision,Date fecha_pago,Date fecha_vencimiento,Double monto_mone_local,Double monto_mone_extra,String numero_comprobante,String numero_factura,Double debito_mone_local,Double credito_mone_local,Double debito_mone_extra,Double credito_mone_extra,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleproveOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_sucursal_movimiento=id_sucursal_movimiento;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_modulo=id_modulo;
 		this.id_moneda=id_moneda;
 		this.id_cliente=id_cliente;
 		this.id_transaccion=id_transaccion;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_factura=id_factura;
 		this.id_orden_compra=id_orden_compra;
 		this.id_estado_detalle_cliente=id_estado_detalle_cliente;
 		this.fecha_venta=fecha_venta;
 		this.fecha_emision=fecha_emision;
 		this.fecha_pago=fecha_pago;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.monto_mone_local=monto_mone_local;
 		this.monto_mone_extra=monto_mone_extra;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
 		this.credito_mone_extra=credito_mone_extra;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleProve detalleproveLocal=null;
		
		if(object!=null) {
			detalleproveLocal=(DetalleProve)object;
			
			if(detalleproveLocal!=null) {
				if(this.getId()!=null && detalleproveLocal.getId()!=null) {
					if(this.getId().equals(detalleproveLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleProveConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleProveConstantesFunciones.getDetalleProveDescripcion(this);
		} else {
			sDetalle=DetalleProveConstantesFunciones.getDetalleProveDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleProve getDetalleProveOriginal() {
		return this.detalleproveOriginal;
	}
	
	public void setDetalleProveOriginal(DetalleProve detalleprove) {
		try {
			this.detalleproveOriginal=detalleprove;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleProveAdditional detalleproveAdditional=null;
	
	public DetalleProveAdditional getDetalleProveAdditional() {
		return this.detalleproveAdditional;
	}
	
	public void setDetalleProveAdditional(DetalleProveAdditional detalleproveAdditional) {
		try {
			this.detalleproveAdditional=detalleproveAdditional;
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
    
	
	public Long getid_sucursal_movimiento() {
		return this.id_sucursal_movimiento;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_orden_compra() {
		return this.id_orden_compra;
	}
    
	
	public Long getid_estado_detalle_cliente() {
		return this.id_estado_detalle_cliente;
	}
    
	
	public Date getfecha_venta() {
		return this.fecha_venta;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_pago() {
		return this.fecha_pago;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Double getmonto_mone_local() {
		return this.monto_mone_local;
	}
    
	
	public Double getmonto_mone_extra() {
		return this.monto_mone_extra;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Double getdebito_mone_local() {
		return this.debito_mone_local;
	}
    
	
	public Double getcredito_mone_local() {
		return this.credito_mone_local;
	}
    
	
	public Double getdebito_mone_extra() {
		return this.debito_mone_extra;
	}
    
	
	public Double getcredito_mone_extra() {
		return this.credito_mone_extra;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal_movimiento(Long newid_sucursal_movimiento)throws Exception
	{
		try {
			if(this.id_sucursal_movimiento!=newid_sucursal_movimiento) {
				if(newid_sucursal_movimiento==null) {
					//newid_sucursal_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_sucursal_movimiento");
					}
				}

				this.id_sucursal_movimiento=newid_sucursal_movimiento;
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
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_transaccion_modulo(Long newid_tipo_transaccion_modulo) {
		if(this.id_tipo_transaccion_modulo==null&&newid_tipo_transaccion_modulo!=null) {
			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_transaccion_modulo!=null&&!this.id_tipo_transaccion_modulo.equals(newid_tipo_transaccion_modulo)) {

			this.id_tipo_transaccion_modulo=newid_tipo_transaccion_modulo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable)throws Exception
	{
		try {
			if(this.id_asiento_contable!=newid_asiento_contable) {
				if(newid_asiento_contable==null) {
					//newid_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_orden_compra(Long newid_orden_compra) {
		if(this.id_orden_compra==null&&newid_orden_compra!=null) {
			this.id_orden_compra=newid_orden_compra;
				this.setIsChanged(true);
		}

		if(this.id_orden_compra!=null&&!this.id_orden_compra.equals(newid_orden_compra)) {

			this.id_orden_compra=newid_orden_compra;
				this.setIsChanged(true);
		}
	}
    
	public void setid_estado_detalle_cliente(Long newid_estado_detalle_cliente)throws Exception
	{
		try {
			if(this.id_estado_detalle_cliente!=newid_estado_detalle_cliente) {
				if(newid_estado_detalle_cliente==null) {
					//newid_estado_detalle_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna id_estado_detalle_cliente");
					}
				}

				this.id_estado_detalle_cliente=newid_estado_detalle_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_venta(Date newfecha_venta)throws Exception
	{
		try {
			if(this.fecha_venta!=newfecha_venta) {
				if(newfecha_venta==null) {
					//newfecha_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna fecha_venta");
					}
				}

				this.fecha_venta=newfecha_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pago(Date newfecha_pago)throws Exception
	{
		try {
			if(this.fecha_pago!=newfecha_pago) {
				if(newfecha_pago==null) {
					//newfecha_pago=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna fecha_pago");
					}
				}

				this.fecha_pago=newfecha_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_mone_local(Double newmonto_mone_local)throws Exception
	{
		try {
			if(this.monto_mone_local!=newmonto_mone_local) {
				if(newmonto_mone_local==null) {
					//newmonto_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna monto_mone_local");
					}
				}

				this.monto_mone_local=newmonto_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_mone_extra(Double newmonto_mone_extra)throws Exception
	{
		try {
			if(this.monto_mone_extra!=newmonto_mone_extra) {
				if(newmonto_mone_extra==null) {
					//newmonto_mone_extra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna monto_mone_extra");
					}
				}

				this.monto_mone_extra=newmonto_mone_extra;
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
						System.out.println("DetalleProve:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("DetalleProve:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("DetalleProve:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_mone_local(Double newdebito_mone_local)throws Exception
	{
		try {
			if(this.debito_mone_local!=newdebito_mone_local) {
				if(newdebito_mone_local==null) {
					//newdebito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna debito_mone_local");
					}
				}

				this.debito_mone_local=newdebito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_mone_local(Double newcredito_mone_local)throws Exception
	{
		try {
			if(this.credito_mone_local!=newcredito_mone_local) {
				if(newcredito_mone_local==null) {
					//newcredito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna credito_mone_local");
					}
				}

				this.credito_mone_local=newcredito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_mone_extra(Double newdebito_mone_extra)throws Exception
	{
		try {
			if(this.debito_mone_extra!=newdebito_mone_extra) {
				if(newdebito_mone_extra==null) {
					//newdebito_mone_extra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna debito_mone_extra");
					}
				}

				this.debito_mone_extra=newdebito_mone_extra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_mone_extra(Double newcredito_mone_extra)throws Exception
	{
		try {
			if(this.credito_mone_extra!=newcredito_mone_extra) {
				if(newcredito_mone_extra==null) {
					//newcredito_mone_extra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProve:Valor nulo no permitido en columna credito_mone_extra");
					}
				}

				this.credito_mone_extra=newcredito_mone_extra;
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
						System.out.println("DetalleProve:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleProve:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Sucursal getSucursalMovimiento() {
		return this.sucursalmovimiento;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public OrdenCompra getOrdenCompra() {
		return this.ordencompra;
	}

	public EstadoDetalleCliente getEstadoDetalleCliente() {
		return this.estadodetallecliente;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getsucursalmovimiento_descripcion() {
		return this.sucursalmovimiento_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getordencompra_descripcion() {
		return this.ordencompra_descripcion;
	}

	public String getestadodetallecliente_descripcion() {
		return this.estadodetallecliente_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setSucursalMovimiento(Sucursal sucursalmovimiento) {
		try {
			this.sucursalmovimiento=sucursalmovimiento;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setOrdenCompra(OrdenCompra ordencompra) {
		try {
			this.ordencompra=ordencompra;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente) {
		try {
			this.estadodetallecliente=estadodetallecliente;
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


	public  void  setsucursalmovimiento_descripcion(String sucursalmovimiento_descripcion) {
		try {
			this.sucursalmovimiento_descripcion=sucursalmovimiento_descripcion;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setordencompra_descripcion(String ordencompra_descripcion) {
		try {
			this.ordencompra_descripcion=ordencompra_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadodetallecliente_descripcion(String estadodetallecliente_descripcion) {
		try {
			this.estadodetallecliente_descripcion=estadodetallecliente_descripcion;
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


	
	
	public List<PagoAuto> getPagoAutos() {
		return this.pagoautos;
	}

	public List<AutoriPago> getAutoriPagos() {
		return this.autoripagos;
	}

	
	
	public  void  setPagoAutos(List<PagoAuto> pagoautos) {
		try {
			this.pagoautos=pagoautos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAutoriPagos(List<AutoriPago> autoripagos) {
		try {
			this.autoripagos=autoripagos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_sucursal_movimiento_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_modulo_descripcion="";String id_moneda_descripcion="";String id_cliente_descripcion="";String id_transaccion_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_asiento_contable_descripcion="";String id_factura_descripcion="";String id_orden_compra_descripcion="";String id_estado_detalle_cliente_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_sucursal_movimiento_descripcion() {
		return id_sucursal_movimiento_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_orden_compra_descripcion() {
		return id_orden_compra_descripcion;
	}
	public String getid_estado_detalle_cliente_descripcion() {
		return id_estado_detalle_cliente_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_sucursal_movimiento_descripcion(String newid_sucursal_movimiento_descripcion)throws Exception {
		try {
			this.id_sucursal_movimiento_descripcion=newid_sucursal_movimiento_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_orden_compra_descripcion(String newid_orden_compra_descripcion)throws Exception {
		try {
			this.id_orden_compra_descripcion=newid_orden_compra_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_detalle_cliente_descripcion(String newid_estado_detalle_cliente_descripcion)throws Exception {
		try {
			this.id_estado_detalle_cliente_descripcion=newid_estado_detalle_cliente_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_sucursal_movimiento_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_modulo_descripcion="";this.id_moneda_descripcion="";this.id_cliente_descripcion="";this.id_transaccion_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_asiento_contable_descripcion="";this.id_factura_descripcion="";this.id_orden_compra_descripcion="";this.id_estado_detalle_cliente_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	Object pagoautosDescripcionReporte;
	Object autoripagosDescripcionReporte;
	
	
	public Object getpagoautosDescripcionReporte() {
		return pagoautosDescripcionReporte;
	}

	public Object getautoripagosDescripcionReporte() {
		return autoripagosDescripcionReporte;
	}

	
	
	public  void  setpagoautosDescripcionReporte(Object pagoautos) {
		try {
			this.pagoautosDescripcionReporte=pagoautos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagosDescripcionReporte(Object autoripagos) {
		try {
			this.autoripagosDescripcionReporte=autoripagos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

