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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class FormaPagoPuntoVenta extends FormaPagoPuntoVentaAdditional implements Serializable ,Cloneable {//FormaPagoPuntoVentaAdditional,GeneralEntity
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
	
	private FormaPagoPuntoVenta formapagopuntoventaOriginal;
	
	private Map<String, Object> mapFormaPagoPuntoVenta;
			
	public Map<String, Object> getMapFormaPagoPuntoVenta() {
		return mapFormaPagoPuntoVenta;
	}

	public void setMapFormaPagoPuntoVenta(Map<String, Object> mapFormaPagoPuntoVenta) {
		this.mapFormaPagoPuntoVenta = mapFormaPagoPuntoVenta;
	}
	
	public void inicializarMapFormaPagoPuntoVenta() {
		this.mapFormaPagoPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapFormaPagoPuntoVentaValue(String sKey,Object oValue) {
		this.mapFormaPagoPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapFormaPagoPuntoVentaValue(String sKey) {
		return this.mapFormaPagoPuntoVenta.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura_punto_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXDESCRIPCION,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias_plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_banco;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_banco_pun_ven;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_riesgo_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXNUMERO_CUENTA,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXNUMERO_CHEQUE,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_CHEQUE)
	private String numero_cheque;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXGIRADOR,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXGIRADOR)
	private String girador;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_banco_tarjeta;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tarjeta_credito;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_interes_tarjeta;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_pago_tarjeta;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_conexion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXNUMERO,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXTARJETA_HABIENTE,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXTARJETA_HABIENTE)
	private String tarjeta_habiente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXAUTORIZACION,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXAUTORIZACION)
	private String autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXVOUCHER,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXVOUCHER)
	private String voucher;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXLOTE,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cuota;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_calculado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cancelado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_difiere;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXNUMERO_RETENCION,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormaPagoPuntoVentaConstantesFunciones.SREGEXNUMERO_LIQUIDACION,message=FormaPagoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_LIQUIDACION)
	private String numero_liquidacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_asiento_contable;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public FacturaPuntoVenta facturapuntoventa;
	public TipoFormaPago tipoformapago;
	public Banco banco;
	public CuentaBancoPunVen cuentabancopunven;
	public TipoRiesgoCheque tiporiesgocheque;
	public Banco bancotarjeta;
	public TarjetaCredito tarjetacredito;
	public TipoInteresTarjeta tipointerestarjeta;
	public TipoPagoTarjeta tipopagotarjeta;
	public Conexion conexion;
	public Mes mes;
	public Anio anio;
	public CuentaContable cuentacontable;
	public AsientoContable asientocontable;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String facturapuntoventa_descripcion;
	private String tipoformapago_descripcion;
	private String banco_descripcion;
	private String cuentabancopunven_descripcion;
	private String tiporiesgocheque_descripcion;
	private String bancotarjeta_descripcion;
	private String tarjetacredito_descripcion;
	private String tipointerestarjeta_descripcion;
	private String tipopagotarjeta_descripcion;
	private String conexion_descripcion;
	private String mes_descripcion;
	private String anio_descripcion;
	private String cuentacontable_descripcion;
	private String asientocontable_descripcion;
	
	
		
	public FormaPagoPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formapagopuntoventaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_factura_punto_venta=-1L;
 		this.id_tipo_forma_pago=-1L;
 		this.porcentaje=0.0;
 		this.valor=0.0;
 		this.fecha=new Date();
 		this.descripcion="";
 		this.fecha_inicio=new Date();
 		this.numero_dias_plazo=0;
 		this.fecha_fin=new Date();
 		this.id_banco=null;
 		this.id_cuenta_banco_pun_ven=null;
 		this.id_tipo_riesgo_cheque=null;
 		this.numero_cuenta="";
 		this.numero_cheque="";
 		this.girador="";
 		this.id_banco_tarjeta=null;
 		this.id_tarjeta_credito=null;
 		this.id_tipo_interes_tarjeta=null;
 		this.id_tipo_pago_tarjeta=null;
 		this.id_conexion=null;
 		this.id_mes=null;
 		this.numero="";
 		this.tarjeta_habiente="";
 		this.autorizacion="";
 		this.voucher="";
 		this.lote="";
 		this.cuota=0;
 		this.valor_retencion=0.0;
 		this.valor_comision=0.0;
 		this.valor_calculado=0.0;
 		this.valor_cancelado=0.0;
 		this.valor_difiere=0.0;
 		this.numero_retencion="";
 		this.numero_liquidacion="";
 		this.id_anio=null;
 		this.id_cuenta_contable=null;
 		this.id_asiento_contable=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.facturapuntoventa=null;
		this.tipoformapago=null;
		this.banco=null;
		this.cuentabancopunven=null;
		this.tiporiesgocheque=null;
		this.bancotarjeta=null;
		this.tarjetacredito=null;
		this.tipointerestarjeta=null;
		this.tipopagotarjeta=null;
		this.conexion=null;
		this.mes=null;
		this.anio=null;
		this.cuentacontable=null;
		this.asientocontable=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.facturapuntoventa_descripcion="";
		this.tipoformapago_descripcion="";
		this.banco_descripcion="";
		this.cuentabancopunven_descripcion="";
		this.tiporiesgocheque_descripcion="";
		this.bancotarjeta_descripcion="";
		this.tarjetacredito_descripcion="";
		this.tipointerestarjeta_descripcion="";
		this.tipopagotarjeta_descripcion="";
		this.conexion_descripcion="";
		this.mes_descripcion="";
		this.anio_descripcion="";
		this.cuentacontable_descripcion="";
		this.asientocontable_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormaPagoPuntoVenta (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura_punto_venta,Long id_tipo_forma_pago,Double porcentaje,Double valor,Date fecha,String descripcion,Date fecha_inicio,Integer numero_dias_plazo,Date fecha_fin,Long id_banco,Long id_cuenta_banco_pun_ven,Long id_tipo_riesgo_cheque,String numero_cuenta,String numero_cheque,String girador,Long id_banco_tarjeta,Long id_tarjeta_credito,Long id_tipo_interes_tarjeta,Long id_tipo_pago_tarjeta,Long id_conexion,Long id_mes,String numero,String tarjeta_habiente,String autorizacion,String voucher,String lote,Integer cuota,Double valor_retencion,Double valor_comision,Double valor_calculado,Double valor_cancelado,Double valor_difiere,String numero_retencion,String numero_liquidacion,Long id_anio,Long id_cuenta_contable,Long id_asiento_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formapagopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura_punto_venta=id_factura_punto_venta;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.fecha_inicio=fecha_inicio;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.fecha_fin=fecha_fin;
 		this.id_banco=id_banco;
 		this.id_cuenta_banco_pun_ven=id_cuenta_banco_pun_ven;
 		this.id_tipo_riesgo_cheque=id_tipo_riesgo_cheque;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.girador=girador;
 		this.id_banco_tarjeta=id_banco_tarjeta;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.id_tipo_interes_tarjeta=id_tipo_interes_tarjeta;
 		this.id_tipo_pago_tarjeta=id_tipo_pago_tarjeta;
 		this.id_conexion=id_conexion;
 		this.id_mes=id_mes;
 		this.numero=numero;
 		this.tarjeta_habiente=tarjeta_habiente;
 		this.autorizacion=autorizacion;
 		this.voucher=voucher;
 		this.lote=lote;
 		this.cuota=cuota;
 		this.valor_retencion=valor_retencion;
 		this.valor_comision=valor_comision;
 		this.valor_calculado=valor_calculado;
 		this.valor_cancelado=valor_cancelado;
 		this.valor_difiere=valor_difiere;
 		this.numero_retencion=numero_retencion;
 		this.numero_liquidacion=numero_liquidacion;
 		this.id_anio=id_anio;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_asiento_contable=id_asiento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormaPagoPuntoVenta (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura_punto_venta,Long id_tipo_forma_pago,Double porcentaje,Double valor,Date fecha,String descripcion,Date fecha_inicio,Integer numero_dias_plazo,Date fecha_fin,Long id_banco,Long id_cuenta_banco_pun_ven,Long id_tipo_riesgo_cheque,String numero_cuenta,String numero_cheque,String girador,Long id_banco_tarjeta,Long id_tarjeta_credito,Long id_tipo_interes_tarjeta,Long id_tipo_pago_tarjeta,Long id_conexion,Long id_mes,String numero,String tarjeta_habiente,String autorizacion,String voucher,String lote,Integer cuota,Double valor_retencion,Double valor_comision,Double valor_calculado,Double valor_cancelado,Double valor_difiere,String numero_retencion,String numero_liquidacion,Long id_anio,Long id_cuenta_contable,Long id_asiento_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formapagopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura_punto_venta=id_factura_punto_venta;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.porcentaje=porcentaje;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.fecha_inicio=fecha_inicio;
 		this.numero_dias_plazo=numero_dias_plazo;
 		this.fecha_fin=fecha_fin;
 		this.id_banco=id_banco;
 		this.id_cuenta_banco_pun_ven=id_cuenta_banco_pun_ven;
 		this.id_tipo_riesgo_cheque=id_tipo_riesgo_cheque;
 		this.numero_cuenta=numero_cuenta;
 		this.numero_cheque=numero_cheque;
 		this.girador=girador;
 		this.id_banco_tarjeta=id_banco_tarjeta;
 		this.id_tarjeta_credito=id_tarjeta_credito;
 		this.id_tipo_interes_tarjeta=id_tipo_interes_tarjeta;
 		this.id_tipo_pago_tarjeta=id_tipo_pago_tarjeta;
 		this.id_conexion=id_conexion;
 		this.id_mes=id_mes;
 		this.numero=numero;
 		this.tarjeta_habiente=tarjeta_habiente;
 		this.autorizacion=autorizacion;
 		this.voucher=voucher;
 		this.lote=lote;
 		this.cuota=cuota;
 		this.valor_retencion=valor_retencion;
 		this.valor_comision=valor_comision;
 		this.valor_calculado=valor_calculado;
 		this.valor_cancelado=valor_cancelado;
 		this.valor_difiere=valor_difiere;
 		this.numero_retencion=numero_retencion;
 		this.numero_liquidacion=numero_liquidacion;
 		this.id_anio=id_anio;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_asiento_contable=id_asiento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormaPagoPuntoVenta formapagopuntoventaLocal=null;
		
		if(object!=null) {
			formapagopuntoventaLocal=(FormaPagoPuntoVenta)object;
			
			if(formapagopuntoventaLocal!=null) {
				if(this.getId()!=null && formapagopuntoventaLocal.getId()!=null) {
					if(this.getId().equals(formapagopuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormaPagoPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormaPagoPuntoVentaConstantesFunciones.getFormaPagoPuntoVentaDescripcion(this);
		} else {
			sDetalle=FormaPagoPuntoVentaConstantesFunciones.getFormaPagoPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormaPagoPuntoVenta getFormaPagoPuntoVentaOriginal() {
		return this.formapagopuntoventaOriginal;
	}
	
	public void setFormaPagoPuntoVentaOriginal(FormaPagoPuntoVenta formapagopuntoventa) {
		try {
			this.formapagopuntoventaOriginal=formapagopuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormaPagoPuntoVentaAdditional formapagopuntoventaAdditional=null;
	
	public FormaPagoPuntoVentaAdditional getFormaPagoPuntoVentaAdditional() {
		return this.formapagopuntoventaAdditional;
	}
	
	public void setFormaPagoPuntoVentaAdditional(FormaPagoPuntoVentaAdditional formapagopuntoventaAdditional) {
		try {
			this.formapagopuntoventaAdditional=formapagopuntoventaAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_factura_punto_venta() {
		return this.id_factura_punto_venta;
	}
    
	
	public Long getid_tipo_forma_pago() {
		return this.id_tipo_forma_pago;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Integer getnumero_dias_plazo() {
		return this.numero_dias_plazo;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_cuenta_banco_pun_ven() {
		return this.id_cuenta_banco_pun_ven;
	}
    
	
	public Long getid_tipo_riesgo_cheque() {
		return this.id_tipo_riesgo_cheque;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public String getnumero_cheque() {
		return this.numero_cheque;
	}
    
	
	public String getgirador() {
		return this.girador;
	}
    
	
	public Long getid_banco_tarjeta() {
		return this.id_banco_tarjeta;
	}
    
	
	public Long getid_tarjeta_credito() {
		return this.id_tarjeta_credito;
	}
    
	
	public Long getid_tipo_interes_tarjeta() {
		return this.id_tipo_interes_tarjeta;
	}
    
	
	public Long getid_tipo_pago_tarjeta() {
		return this.id_tipo_pago_tarjeta;
	}
    
	
	public Long getid_conexion() {
		return this.id_conexion;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String gettarjeta_habiente() {
		return this.tarjeta_habiente;
	}
    
	
	public String getautorizacion() {
		return this.autorizacion;
	}
    
	
	public String getvoucher() {
		return this.voucher;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Integer getcuota() {
		return this.cuota;
	}
    
	
	public Double getvalor_retencion() {
		return this.valor_retencion;
	}
    
	
	public Double getvalor_comision() {
		return this.valor_comision;
	}
    
	
	public Double getvalor_calculado() {
		return this.valor_calculado;
	}
    
	
	public Double getvalor_cancelado() {
		return this.valor_cancelado;
	}
    
	
	public Double getvalor_difiere() {
		return this.valor_difiere;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public String getnumero_liquidacion() {
		return this.numero_liquidacion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura_punto_venta(Long newid_factura_punto_venta)throws Exception
	{
		try {
			if(this.id_factura_punto_venta!=newid_factura_punto_venta) {
				if(newid_factura_punto_venta==null) {
					//newid_factura_punto_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_factura_punto_venta");
					}
				}

				this.id_factura_punto_venta=newid_factura_punto_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_forma_pago(Long newid_tipo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_forma_pago!=newid_tipo_forma_pago) {
				if(newid_tipo_forma_pago==null) {
					//newid_tipo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna id_tipo_forma_pago");
					}
				}

				this.id_tipo_forma_pago=newid_tipo_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias_plazo(Integer newnumero_dias_plazo)throws Exception
	{
		try {
			if(this.numero_dias_plazo!=newnumero_dias_plazo) {
				if(newnumero_dias_plazo==null) {
					//newnumero_dias_plazo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero_dias_plazo");
					}
				}

				this.numero_dias_plazo=newnumero_dias_plazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco) {
		if(this.id_banco==null&&newid_banco!=null) {
			this.id_banco=newid_banco;
				this.setIsChanged(true);
		}

		if(this.id_banco!=null&&!this.id_banco.equals(newid_banco)) {

			this.id_banco=newid_banco;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_banco_pun_ven(Long newid_cuenta_banco_pun_ven) {
		if(this.id_cuenta_banco_pun_ven==null&&newid_cuenta_banco_pun_ven!=null) {
			this.id_cuenta_banco_pun_ven=newid_cuenta_banco_pun_ven;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_banco_pun_ven!=null&&!this.id_cuenta_banco_pun_ven.equals(newid_cuenta_banco_pun_ven)) {

			this.id_cuenta_banco_pun_ven=newid_cuenta_banco_pun_ven;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_riesgo_cheque(Long newid_tipo_riesgo_cheque) {
		if(this.id_tipo_riesgo_cheque==null&&newid_tipo_riesgo_cheque!=null) {
			this.id_tipo_riesgo_cheque=newid_tipo_riesgo_cheque;
				this.setIsChanged(true);
		}

		if(this.id_tipo_riesgo_cheque!=null&&!this.id_tipo_riesgo_cheque.equals(newid_tipo_riesgo_cheque)) {

			this.id_tipo_riesgo_cheque=newid_tipo_riesgo_cheque;
				this.setIsChanged(true);
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cheque(String newnumero_cheque)throws Exception
	{
		try {
			if(this.numero_cheque!=newnumero_cheque) {
				if(newnumero_cheque==null) {
					//newnumero_cheque="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero_cheque");
					}
				}

				if(newnumero_cheque!=null&&newnumero_cheque.length()>50) {
					newnumero_cheque=newnumero_cheque.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cheque");
				}

				this.numero_cheque=newnumero_cheque;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgirador(String newgirador)throws Exception
	{
		try {
			if(this.girador!=newgirador) {
				if(newgirador==null) {
					//newgirador="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna girador");
					}
				}

				if(newgirador!=null&&newgirador.length()>100) {
					newgirador=newgirador.substring(0,98);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna girador");
				}

				this.girador=newgirador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco_tarjeta(Long newid_banco_tarjeta) {
		if(this.id_banco_tarjeta==null&&newid_banco_tarjeta!=null) {
			this.id_banco_tarjeta=newid_banco_tarjeta;
				this.setIsChanged(true);
		}

		if(this.id_banco_tarjeta!=null&&!this.id_banco_tarjeta.equals(newid_banco_tarjeta)) {

			this.id_banco_tarjeta=newid_banco_tarjeta;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tarjeta_credito(Long newid_tarjeta_credito) {
		if(this.id_tarjeta_credito==null&&newid_tarjeta_credito!=null) {
			this.id_tarjeta_credito=newid_tarjeta_credito;
				this.setIsChanged(true);
		}

		if(this.id_tarjeta_credito!=null&&!this.id_tarjeta_credito.equals(newid_tarjeta_credito)) {

			this.id_tarjeta_credito=newid_tarjeta_credito;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_interes_tarjeta(Long newid_tipo_interes_tarjeta) {
		if(this.id_tipo_interes_tarjeta==null&&newid_tipo_interes_tarjeta!=null) {
			this.id_tipo_interes_tarjeta=newid_tipo_interes_tarjeta;
				this.setIsChanged(true);
		}

		if(this.id_tipo_interes_tarjeta!=null&&!this.id_tipo_interes_tarjeta.equals(newid_tipo_interes_tarjeta)) {

			this.id_tipo_interes_tarjeta=newid_tipo_interes_tarjeta;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_pago_tarjeta(Long newid_tipo_pago_tarjeta) {
		if(this.id_tipo_pago_tarjeta==null&&newid_tipo_pago_tarjeta!=null) {
			this.id_tipo_pago_tarjeta=newid_tipo_pago_tarjeta;
				this.setIsChanged(true);
		}

		if(this.id_tipo_pago_tarjeta!=null&&!this.id_tipo_pago_tarjeta.equals(newid_tipo_pago_tarjeta)) {

			this.id_tipo_pago_tarjeta=newid_tipo_pago_tarjeta;
				this.setIsChanged(true);
		}
	}
    
	public void setid_conexion(Long newid_conexion) {
		if(this.id_conexion==null&&newid_conexion!=null) {
			this.id_conexion=newid_conexion;
				this.setIsChanged(true);
		}

		if(this.id_conexion!=null&&!this.id_conexion.equals(newid_conexion)) {

			this.id_conexion=newid_conexion;
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
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settarjeta_habiente(String newtarjeta_habiente)throws Exception
	{
		try {
			if(this.tarjeta_habiente!=newtarjeta_habiente) {
				if(newtarjeta_habiente==null) {
					//newtarjeta_habiente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna tarjeta_habiente");
					}
				}

				if(newtarjeta_habiente!=null&&newtarjeta_habiente.length()>100) {
					newtarjeta_habiente=newtarjeta_habiente.substring(0,98);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tarjeta_habiente");
				}

				this.tarjeta_habiente=newtarjeta_habiente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion(String newautorizacion)throws Exception
	{
		try {
			if(this.autorizacion!=newautorizacion) {
				if(newautorizacion==null) {
					//newautorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna autorizacion");
					}
				}

				if(newautorizacion!=null&&newautorizacion.length()>100) {
					newautorizacion=newautorizacion.substring(0,98);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna autorizacion");
				}

				this.autorizacion=newautorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvoucher(String newvoucher)throws Exception
	{
		try {
			if(this.voucher!=newvoucher) {
				if(newvoucher==null) {
					//newvoucher="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna voucher");
					}
				}

				if(newvoucher!=null&&newvoucher.length()>50) {
					newvoucher=newvoucher.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna voucher");
				}

				this.voucher=newvoucher;
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
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcuota(Integer newcuota)throws Exception
	{
		try {
			if(this.cuota!=newcuota) {
				if(newcuota==null) {
					//newcuota=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna cuota");
					}
				}

				this.cuota=newcuota;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_retencion(Double newvalor_retencion)throws Exception
	{
		try {
			if(this.valor_retencion!=newvalor_retencion) {
				if(newvalor_retencion==null) {
					//newvalor_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor_retencion");
					}
				}

				this.valor_retencion=newvalor_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comision(Double newvalor_comision)throws Exception
	{
		try {
			if(this.valor_comision!=newvalor_comision) {
				if(newvalor_comision==null) {
					//newvalor_comision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor_comision");
					}
				}

				this.valor_comision=newvalor_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_calculado(Double newvalor_calculado)throws Exception
	{
		try {
			if(this.valor_calculado!=newvalor_calculado) {
				if(newvalor_calculado==null) {
					//newvalor_calculado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor_calculado");
					}
				}

				this.valor_calculado=newvalor_calculado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cancelado(Double newvalor_cancelado)throws Exception
	{
		try {
			if(this.valor_cancelado!=newvalor_cancelado) {
				if(newvalor_cancelado==null) {
					//newvalor_cancelado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor_cancelado");
					}
				}

				this.valor_cancelado=newvalor_cancelado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_difiere(Double newvalor_difiere)throws Exception
	{
		try {
			if(this.valor_difiere!=newvalor_difiere) {
				if(newvalor_difiere==null) {
					//newvalor_difiere=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna valor_difiere");
					}
				}

				this.valor_difiere=newvalor_difiere;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion(String newnumero_retencion)throws Exception
	{
		try {
			if(this.numero_retencion!=newnumero_retencion) {
				if(newnumero_retencion==null) {
					//newnumero_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_liquidacion(String newnumero_liquidacion)throws Exception
	{
		try {
			if(this.numero_liquidacion!=newnumero_liquidacion) {
				if(newnumero_liquidacion==null) {
					//newnumero_liquidacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormaPagoPuntoVenta:Valor nulo no permitido en columna numero_liquidacion");
					}
				}

				if(newnumero_liquidacion!=null&&newnumero_liquidacion.length()>50) {
					newnumero_liquidacion=newnumero_liquidacion.substring(0,48);
					System.out.println("FormaPagoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_liquidacion");
				}

				this.numero_liquidacion=newnumero_liquidacion;
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
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable) {
		if(this.id_asiento_contable==null&&newid_asiento_contable!=null) {
			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}

		if(this.id_asiento_contable!=null&&!this.id_asiento_contable.equals(newid_asiento_contable)) {

			this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public FacturaPuntoVenta getFacturaPuntoVenta() {
		return this.facturapuntoventa;
	}

	public TipoFormaPago getTipoFormaPago() {
		return this.tipoformapago;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public CuentaBancoPunVen getCuentaBancoPunVen() {
		return this.cuentabancopunven;
	}

	public TipoRiesgoCheque getTipoRiesgoCheque() {
		return this.tiporiesgocheque;
	}

	public Banco getBancoTarjeta() {
		return this.bancotarjeta;
	}

	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetacredito;
	}

	public TipoInteresTarjeta getTipoInteresTarjeta() {
		return this.tipointerestarjeta;
	}

	public TipoPagoTarjeta getTipoPagoTarjeta() {
		return this.tipopagotarjeta;
	}

	public Conexion getConexion() {
		return this.conexion;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getfacturapuntoventa_descripcion() {
		return this.facturapuntoventa_descripcion;
	}

	public String gettipoformapago_descripcion() {
		return this.tipoformapago_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String getcuentabancopunven_descripcion() {
		return this.cuentabancopunven_descripcion;
	}

	public String gettiporiesgocheque_descripcion() {
		return this.tiporiesgocheque_descripcion;
	}

	public String getbancotarjeta_descripcion() {
		return this.bancotarjeta_descripcion;
	}

	public String gettarjetacredito_descripcion() {
		return this.tarjetacredito_descripcion;
	}

	public String gettipointerestarjeta_descripcion() {
		return this.tipointerestarjeta_descripcion;
	}

	public String gettipopagotarjeta_descripcion() {
		return this.tipopagotarjeta_descripcion;
	}

	public String getconexion_descripcion() {
		return this.conexion_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
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


	public  void  setFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa) {
		try {
			this.facturapuntoventa=facturapuntoventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFormaPago(TipoFormaPago tipoformapago) {
		try {
			this.tipoformapago=tipoformapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven) {
		try {
			this.cuentabancopunven=cuentabancopunven;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRiesgoCheque(TipoRiesgoCheque tiporiesgocheque) {
		try {
			this.tiporiesgocheque=tiporiesgocheque;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBancoTarjeta(Banco bancotarjeta) {
		try {
			this.bancotarjeta=bancotarjeta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTarjetaCredito(TarjetaCredito tarjetacredito) {
		try {
			this.tarjetacredito=tarjetacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoInteresTarjeta(TipoInteresTarjeta tipointerestarjeta) {
		try {
			this.tipointerestarjeta=tipointerestarjeta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPagoTarjeta(TipoPagoTarjeta tipopagotarjeta) {
		try {
			this.tipopagotarjeta=tipopagotarjeta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConexion(Conexion conexion) {
		try {
			this.conexion=conexion;
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


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
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


	public  void  setfacturapuntoventa_descripcion(String facturapuntoventa_descripcion) {
		try {
			this.facturapuntoventa_descripcion=facturapuntoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoformapago_descripcion(String tipoformapago_descripcion) {
		try {
			this.tipoformapago_descripcion=tipoformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentabancopunven_descripcion(String cuentabancopunven_descripcion) {
		try {
			this.cuentabancopunven_descripcion=cuentabancopunven_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporiesgocheque_descripcion(String tiporiesgocheque_descripcion) {
		try {
			this.tiporiesgocheque_descripcion=tiporiesgocheque_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbancotarjeta_descripcion(String bancotarjeta_descripcion) {
		try {
			this.bancotarjeta_descripcion=bancotarjeta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settarjetacredito_descripcion(String tarjetacredito_descripcion) {
		try {
			this.tarjetacredito_descripcion=tarjetacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipointerestarjeta_descripcion(String tipointerestarjeta_descripcion) {
		try {
			this.tipointerestarjeta_descripcion=tipointerestarjeta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipopagotarjeta_descripcion(String tipopagotarjeta_descripcion) {
		try {
			this.tipopagotarjeta_descripcion=tipopagotarjeta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconexion_descripcion(String conexion_descripcion) {
		try {
			this.conexion_descripcion=conexion_descripcion;
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


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_factura_punto_venta_descripcion="";String id_tipo_forma_pago_descripcion="";String id_banco_descripcion="";String id_cuenta_banco_pun_ven_descripcion="";String id_tipo_riesgo_cheque_descripcion="";String id_banco_tarjeta_descripcion="";String id_tarjeta_credito_descripcion="";String id_tipo_interes_tarjeta_descripcion="";String id_tipo_pago_tarjeta_descripcion="";String id_conexion_descripcion="";String id_mes_descripcion="";String id_anio_descripcion="";String id_cuenta_contable_descripcion="";String id_asiento_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_factura_punto_venta_descripcion() {
		return id_factura_punto_venta_descripcion;
	}
	public String getid_tipo_forma_pago_descripcion() {
		return id_tipo_forma_pago_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_cuenta_banco_pun_ven_descripcion() {
		return id_cuenta_banco_pun_ven_descripcion;
	}
	public String getid_tipo_riesgo_cheque_descripcion() {
		return id_tipo_riesgo_cheque_descripcion;
	}
	public String getid_banco_tarjeta_descripcion() {
		return id_banco_tarjeta_descripcion;
	}
	public String getid_tarjeta_credito_descripcion() {
		return id_tarjeta_credito_descripcion;
	}
	public String getid_tipo_interes_tarjeta_descripcion() {
		return id_tipo_interes_tarjeta_descripcion;
	}
	public String getid_tipo_pago_tarjeta_descripcion() {
		return id_tipo_pago_tarjeta_descripcion;
	}
	public String getid_conexion_descripcion() {
		return id_conexion_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
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
	public void setid_factura_punto_venta_descripcion(String newid_factura_punto_venta_descripcion)throws Exception {
		try {
			this.id_factura_punto_venta_descripcion=newid_factura_punto_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_forma_pago_descripcion(String newid_tipo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_forma_pago_descripcion=newid_tipo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_banco_descripcion(String newid_banco_descripcion) {
		this.id_banco_descripcion=newid_banco_descripcion;
	}
	public void setid_cuenta_banco_pun_ven_descripcion(String newid_cuenta_banco_pun_ven_descripcion) {
		this.id_cuenta_banco_pun_ven_descripcion=newid_cuenta_banco_pun_ven_descripcion;
	}
	public void setid_tipo_riesgo_cheque_descripcion(String newid_tipo_riesgo_cheque_descripcion) {
		this.id_tipo_riesgo_cheque_descripcion=newid_tipo_riesgo_cheque_descripcion;
	}
	public void setid_banco_tarjeta_descripcion(String newid_banco_tarjeta_descripcion) {
		this.id_banco_tarjeta_descripcion=newid_banco_tarjeta_descripcion;
	}
	public void setid_tarjeta_credito_descripcion(String newid_tarjeta_credito_descripcion) {
		this.id_tarjeta_credito_descripcion=newid_tarjeta_credito_descripcion;
	}
	public void setid_tipo_interes_tarjeta_descripcion(String newid_tipo_interes_tarjeta_descripcion) {
		this.id_tipo_interes_tarjeta_descripcion=newid_tipo_interes_tarjeta_descripcion;
	}
	public void setid_tipo_pago_tarjeta_descripcion(String newid_tipo_pago_tarjeta_descripcion) {
		this.id_tipo_pago_tarjeta_descripcion=newid_tipo_pago_tarjeta_descripcion;
	}
	public void setid_conexion_descripcion(String newid_conexion_descripcion) {
		this.id_conexion_descripcion=newid_conexion_descripcion;
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
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
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion) {
		this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion) {
		this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_factura_punto_venta_descripcion="";this.id_tipo_forma_pago_descripcion="";this.id_banco_descripcion="";this.id_cuenta_banco_pun_ven_descripcion="";this.id_tipo_riesgo_cheque_descripcion="";this.id_banco_tarjeta_descripcion="";this.id_tarjeta_credito_descripcion="";this.id_tipo_interes_tarjeta_descripcion="";this.id_tipo_pago_tarjeta_descripcion="";this.id_conexion_descripcion="";this.id_mes_descripcion="";this.id_anio_descripcion="";this.id_cuenta_contable_descripcion="";this.id_asiento_contable_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

