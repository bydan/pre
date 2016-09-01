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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.NotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class NotaCreditoSoli extends NotaCreditoSoliAdditional implements Serializable ,Cloneable {//NotaCreditoSoliAdditional,GeneralEntity
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
	
	private NotaCreditoSoli notacreditosoliOriginal;
	
	private Map<String, Object> mapNotaCreditoSoli;
			
	public Map<String, Object> getMapNotaCreditoSoli() {
		return mapNotaCreditoSoli;
	}

	public void setMapNotaCreditoSoli(Map<String, Object> mapNotaCreditoSoli) {
		this.mapNotaCreditoSoli = mapNotaCreditoSoli;
	}
	
	public void inicializarMapNotaCreditoSoli() {
		this.mapNotaCreditoSoli = new HashMap<String,Object>();
	}
	
	public void setMapNotaCreditoSoliValue(String sKey,Object oValue) {
		this.mapNotaCreditoSoli.put(sKey, oValue);
	}
	
	public Object getMapNotaCreditoSoliValue(String sKey) {
		return this.mapNotaCreditoSoli.get(sKey);
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
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXCODIGO,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXNUMERO,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cotizacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXDIRECCION,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXTELEFONO,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXRUC,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_nota_credito_soli;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=NotaCreditoSoliConstantesFunciones.SREGEXDESCRIPCION,message=NotaCreditoSoliConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean penalizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double suman;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otro_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_vendedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cambio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transporte;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transportista;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_autorizacion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Usuario usuario;
	public Moneda moneda;
	public Empleado empleado;
	public Formato formato;
	public TipoPrecio tipoprecio;
	public Cliente cliente;
	public Factura factura;
	public TipoNotaCreditoSoli tiponotacreditosoli;
	public Responsable responsable;
	public EstadoNotaCredito estadonotacreditosoli;
	public CentroCosto centrocosto;
	public Vendedor vendedor;
	public TipoCambio tipocambio;
	public Transporte transporte;
	public Transportista transportista;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String usuario_descripcion;
	private String moneda_descripcion;
	private String empleado_descripcion;
	private String formato_descripcion;
	private String tipoprecio_descripcion;
	private String cliente_descripcion;
	private String factura_descripcion;
	private String tiponotacreditosoli_descripcion;
	private String responsable_descripcion;
	private String estadonotacreditosoli_descripcion;
	private String centrocosto_descripcion;
	private String vendedor_descripcion;
	private String tipocambio_descripcion;
	private String transporte_descripcion;
	private String transportista_descripcion;
	
	
	public List<DetaNotaCreditoSoli> detanotacreditosolis;
		
	public NotaCreditoSoli () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.notacreditosoliOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_usuario=-1L;
 		this.codigo="";
 		this.numero="";
 		this.fecha_emision=new Date();
 		this.numero_dias=0;
 		this.fecha_vencimiento=new Date();
 		this.id_moneda=-1L;
 		this.id_empleado=-1L;
 		this.cotizacion=0.0;
 		this.id_formato=null;
 		this.id_tipo_precio=-1L;
 		this.id_cliente=-1L;
 		this.id_factura=-1L;
 		this.direccion="";
 		this.telefono="";
 		this.ruc="";
 		this.id_tipo_nota_credito_soli=-1L;
 		this.id_responsable=null;
 		this.id_estado_nota_credito=-1L;
 		this.descripcion="";
 		this.penalizado=false;
 		this.descuento_porcentaje=0.0;
 		this.total_iva=0.0;
 		this.suman=0.0;
 		this.descuento_valor=0.0;
 		this.total_sin_iva=0.0;
 		this.descuento_general=0.0;
 		this.flete=0.0;
 		this.total=0.0;
 		this.sub_total=0.0;
 		this.otro=0.0;
 		this.iva=0.0;
 		this.financiamiento=0.0;
 		this.otro_valor=0.0;
 		this.retencion=0.0;
 		this.ice=0.0;
 		this.fecha=new Date();
 		this.id_centro_costo=null;
 		this.id_vendedor=null;
 		this.id_tipo_cambio=null;
 		this.id_transporte=null;
 		this.id_transportista=null;
 		this.fecha_cliente=new Date();
 		this.fecha_autorizacion=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.usuario=null;
		this.moneda=null;
		this.empleado=null;
		this.formato=null;
		this.tipoprecio=null;
		this.cliente=null;
		this.factura=null;
		this.tiponotacreditosoli=null;
		this.responsable=null;
		this.estadonotacreditosoli=null;
		this.centrocosto=null;
		this.vendedor=null;
		this.tipocambio=null;
		this.transporte=null;
		this.transportista=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.usuario_descripcion="";
		this.moneda_descripcion="";
		this.empleado_descripcion="";
		this.formato_descripcion="";
		this.tipoprecio_descripcion="";
		this.cliente_descripcion="";
		this.factura_descripcion="";
		this.tiponotacreditosoli_descripcion="";
		this.responsable_descripcion="";
		this.estadonotacreditosoli_descripcion="";
		this.centrocosto_descripcion="";
		this.vendedor_descripcion="";
		this.tipocambio_descripcion="";
		this.transporte_descripcion="";
		this.transportista_descripcion="";
		
		
		this.detanotacreditosolis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NotaCreditoSoli (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String codigo,String numero,Date fecha_emision,Integer numero_dias,Date fecha_vencimiento,Long id_moneda,Long id_empleado,Double cotizacion,Long id_formato,Long id_tipo_precio,Long id_cliente,Long id_factura,String direccion,String telefono,String ruc,Long id_tipo_nota_credito_soli,Long id_responsable,Long id_estado_nota_credito,String descripcion,Boolean penalizado,Double descuento_porcentaje,Double total_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double descuento_general,Double flete,Double total,Double sub_total,Double otro,Double iva,Double financiamiento,Double otro_valor,Double retencion,Double ice,Date fecha,Long id_centro_costo,Long id_vendedor,Long id_tipo_cambio,Long id_transporte,Long id_transportista,Date fecha_cliente,Date fecha_autorizacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.notacreditosoliOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.codigo=codigo;
 		this.numero=numero;
 		this.fecha_emision=fecha_emision;
 		this.numero_dias=numero_dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.id_empleado=id_empleado;
 		this.cotizacion=cotizacion;
 		this.id_formato=id_formato;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.id_tipo_nota_credito_soli=id_tipo_nota_credito_soli;
 		this.id_responsable=id_responsable;
 		this.id_estado_nota_credito=id_estado_nota_credito;
 		this.descripcion=descripcion;
 		this.penalizado=penalizado;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.total_iva=total_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.descuento_general=descuento_general;
 		this.flete=flete;
 		this.total=total;
 		this.sub_total=sub_total;
 		this.otro=otro;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.otro_valor=otro_valor;
 		this.retencion=retencion;
 		this.ice=ice;
 		this.fecha=fecha;
 		this.id_centro_costo=id_centro_costo;
 		this.id_vendedor=id_vendedor;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_transporte=id_transporte;
 		this.id_transportista=id_transportista;
 		this.fecha_cliente=fecha_cliente;
 		this.fecha_autorizacion=fecha_autorizacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NotaCreditoSoli (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String codigo,String numero,Date fecha_emision,Integer numero_dias,Date fecha_vencimiento,Long id_moneda,Long id_empleado,Double cotizacion,Long id_formato,Long id_tipo_precio,Long id_cliente,Long id_factura,String direccion,String telefono,String ruc,Long id_tipo_nota_credito_soli,Long id_responsable,Long id_estado_nota_credito,String descripcion,Boolean penalizado,Double descuento_porcentaje,Double total_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double descuento_general,Double flete,Double total,Double sub_total,Double otro,Double iva,Double financiamiento,Double otro_valor,Double retencion,Double ice,Date fecha,Long id_centro_costo,Long id_vendedor,Long id_tipo_cambio,Long id_transporte,Long id_transportista,Date fecha_cliente,Date fecha_autorizacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.notacreditosoliOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.codigo=codigo;
 		this.numero=numero;
 		this.fecha_emision=fecha_emision;
 		this.numero_dias=numero_dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.id_empleado=id_empleado;
 		this.cotizacion=cotizacion;
 		this.id_formato=id_formato;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ruc=ruc;
 		this.id_tipo_nota_credito_soli=id_tipo_nota_credito_soli;
 		this.id_responsable=id_responsable;
 		this.id_estado_nota_credito=id_estado_nota_credito;
 		this.descripcion=descripcion;
 		this.penalizado=penalizado;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.total_iva=total_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.descuento_general=descuento_general;
 		this.flete=flete;
 		this.total=total;
 		this.sub_total=sub_total;
 		this.otro=otro;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.otro_valor=otro_valor;
 		this.retencion=retencion;
 		this.ice=ice;
 		this.fecha=fecha;
 		this.id_centro_costo=id_centro_costo;
 		this.id_vendedor=id_vendedor;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_transporte=id_transporte;
 		this.id_transportista=id_transportista;
 		this.fecha_cliente=fecha_cliente;
 		this.fecha_autorizacion=fecha_autorizacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NotaCreditoSoli notacreditosoliLocal=null;
		
		if(object!=null) {
			notacreditosoliLocal=(NotaCreditoSoli)object;
			
			if(notacreditosoliLocal!=null) {
				if(this.getId()!=null && notacreditosoliLocal.getId()!=null) {
					if(this.getId().equals(notacreditosoliLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NotaCreditoSoliConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliDescripcion(this);
		} else {
			sDetalle=NotaCreditoSoliConstantesFunciones.getNotaCreditoSoliDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NotaCreditoSoli getNotaCreditoSoliOriginal() {
		return this.notacreditosoliOriginal;
	}
	
	public void setNotaCreditoSoliOriginal(NotaCreditoSoli notacreditosoli) {
		try {
			this.notacreditosoliOriginal=notacreditosoli;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NotaCreditoSoliAdditional notacreditosoliAdditional=null;
	
	public NotaCreditoSoliAdditional getNotaCreditoSoliAdditional() {
		return this.notacreditosoliAdditional;
	}
	
	public void setNotaCreditoSoliAdditional(NotaCreditoSoliAdditional notacreditosoliAdditional) {
		try {
			this.notacreditosoliAdditional=notacreditosoliAdditional;
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
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Double getcotizacion() {
		return this.cotizacion;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_tipo_nota_credito_soli() {
		return this.id_tipo_nota_credito_soli;
	}
    
	
	public Long getid_responsable() {
		return this.id_responsable;
	}
    
	
	public Long getid_estado_nota_credito() {
		return this.id_estado_nota_credito;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Boolean getpenalizado() {
		return this.penalizado;
	}
    
	
	public Double getdescuento_porcentaje() {
		return this.descuento_porcentaje;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double getsuman() {
		return this.suman;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double getdescuento_general() {
		return this.descuento_general;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double getotro() {
		return this.otro;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getotro_valor() {
		return this.otro_valor;
	}
    
	
	public Double getretencion() {
		return this.retencion;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
    
	
	public Date getfecha_cliente() {
		return this.fecha_cliente;
	}
    
	
	public Date getfecha_autorizacion() {
		return this.fecha_autorizacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcotizacion(Double newcotizacion)throws Exception
	{
		try {
			if(this.cotizacion!=newcotizacion) {
				if(newcotizacion==null) {
					//newcotizacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna cotizacion");
					}
				}

				this.cotizacion=newcotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato) {
		if(this.id_formato==null&&newid_formato!=null) {
			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}

		if(this.id_formato!=null&&!this.id_formato.equals(newid_formato)) {

			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_nota_credito_soli(Long newid_tipo_nota_credito_soli)throws Exception
	{
		try {
			if(this.id_tipo_nota_credito_soli!=newid_tipo_nota_credito_soli) {
				if(newid_tipo_nota_credito_soli==null) {
					//newid_tipo_nota_credito_soli=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_tipo_nota_credito_soli");
					}
				}

				this.id_tipo_nota_credito_soli=newid_tipo_nota_credito_soli;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_responsable(Long newid_responsable) {
		if(this.id_responsable==null&&newid_responsable!=null) {
			this.id_responsable=newid_responsable;
				this.setIsChanged(true);
		}

		if(this.id_responsable!=null&&!this.id_responsable.equals(newid_responsable)) {

			this.id_responsable=newid_responsable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_estado_nota_credito(Long newid_estado_nota_credito)throws Exception
	{
		try {
			if(this.id_estado_nota_credito!=newid_estado_nota_credito) {
				if(newid_estado_nota_credito==null) {
					//newid_estado_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna id_estado_nota_credito");
					}
				}

				this.id_estado_nota_credito=newid_estado_nota_credito;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("NotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpenalizado(Boolean newpenalizado)throws Exception
	{
		try {
			if(this.penalizado!=newpenalizado) {
				if(newpenalizado==null) {
					//newpenalizado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna penalizado");
					}
				}

				this.penalizado=newpenalizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_porcentaje(Double newdescuento_porcentaje)throws Exception
	{
		try {
			if(this.descuento_porcentaje!=newdescuento_porcentaje) {
				if(newdescuento_porcentaje==null) {
					//newdescuento_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna descuento_porcentaje");
					}
				}

				this.descuento_porcentaje=newdescuento_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_iva(Double newtotal_iva)throws Exception
	{
		try {
			if(this.total_iva!=newtotal_iva) {
				if(newtotal_iva==null) {
					//newtotal_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsuman(Double newsuman)throws Exception
	{
		try {
			if(this.suman!=newsuman) {
				if(newsuman==null) {
					//newsuman=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna suman");
					}
				}

				this.suman=newsuman;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_sin_iva(Double newtotal_sin_iva)throws Exception
	{
		try {
			if(this.total_sin_iva!=newtotal_sin_iva) {
				if(newtotal_sin_iva==null) {
					//newtotal_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_general(Double newdescuento_general)throws Exception
	{
		try {
			if(this.descuento_general!=newdescuento_general) {
				if(newdescuento_general==null) {
					//newdescuento_general=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna descuento_general");
					}
				}

				this.descuento_general=newdescuento_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setflete(Double newflete)throws Exception
	{
		try {
			if(this.flete!=newflete) {
				if(newflete==null) {
					//newflete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_total(Double newsub_total)throws Exception
	{
		try {
			if(this.sub_total!=newsub_total) {
				if(newsub_total==null) {
					//newsub_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotro(Double newotro)throws Exception
	{
		try {
			if(this.otro!=newotro) {
				if(newotro==null) {
					//newotro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna otro");
					}
				}

				this.otro=newotro;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfinanciamiento(Double newfinanciamiento)throws Exception
	{
		try {
			if(this.financiamiento!=newfinanciamiento) {
				if(newfinanciamiento==null) {
					//newfinanciamiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotro_valor(Double newotro_valor)throws Exception
	{
		try {
			if(this.otro_valor!=newotro_valor) {
				if(newotro_valor==null) {
					//newotro_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna otro_valor");
					}
				}

				this.otro_valor=newotro_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setretencion(Double newretencion)throws Exception
	{
		try {
			if(this.retencion!=newretencion) {
				if(newretencion==null) {
					//newretencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna retencion");
					}
				}

				this.retencion=newretencion;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
    
	public void setid_vendedor(Long newid_vendedor) {
		if(this.id_vendedor==null&&newid_vendedor!=null) {
			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}

		if(this.id_vendedor!=null&&!this.id_vendedor.equals(newid_vendedor)) {

			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_cambio(Long newid_tipo_cambio) {
		if(this.id_tipo_cambio==null&&newid_tipo_cambio!=null) {
			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}

		if(this.id_tipo_cambio!=null&&!this.id_tipo_cambio.equals(newid_tipo_cambio)) {

			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transporte(Long newid_transporte) {
		if(this.id_transporte==null&&newid_transporte!=null) {
			this.id_transporte=newid_transporte;
				this.setIsChanged(true);
		}

		if(this.id_transporte!=null&&!this.id_transporte.equals(newid_transporte)) {

			this.id_transporte=newid_transporte;
				this.setIsChanged(true);
		}
	}
    
	public void setid_transportista(Long newid_transportista) {
		if(this.id_transportista==null&&newid_transportista!=null) {
			this.id_transportista=newid_transportista;
				this.setIsChanged(true);
		}

		if(this.id_transportista!=null&&!this.id_transportista.equals(newid_transportista)) {

			this.id_transportista=newid_transportista;
				this.setIsChanged(true);
		}
	}
    
	public void setfecha_cliente(Date newfecha_cliente)throws Exception
	{
		try {
			if(this.fecha_cliente!=newfecha_cliente) {
				if(newfecha_cliente==null) {
					//newfecha_cliente=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna fecha_cliente");
					}
				}

				this.fecha_cliente=newfecha_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_autorizacion(Date newfecha_autorizacion)throws Exception
	{
		try {
			if(this.fecha_autorizacion!=newfecha_autorizacion) {
				if(newfecha_autorizacion==null) {
					//newfecha_autorizacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("NotaCreditoSoli:Valor nulo no permitido en columna fecha_autorizacion");
					}
				}

				this.fecha_autorizacion=newfecha_autorizacion;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public TipoNotaCreditoSoli getTipoNotaCreditoSoli() {
		return this.tiponotacreditosoli;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public EstadoNotaCredito getEstadoNotaCreditoSoli() {
		return this.estadonotacreditosoli;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public Transportista getTransportista() {
		return this.transportista;
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

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String gettiponotacreditosoli_descripcion() {
		return this.tiponotacreditosoli_descripcion;
	}

	public String getresponsable_descripcion() {
		return this.responsable_descripcion;
	}

	public String getestadonotacreditosoli_descripcion() {
		return this.estadonotacreditosoli_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoNotaCreditoSoli(TipoNotaCreditoSoli tiponotacreditosoli) {
		try {
			this.tiponotacreditosoli=tiponotacreditosoli;
		} catch(Exception e) {
			;
		}
	}


	public  void  setResponsable(Responsable responsable) {
		try {
			this.responsable=responsable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoNotaCreditoSoli(EstadoNotaCredito estadonotacreditosoli) {
		try {
			this.estadonotacreditosoli=estadonotacreditosoli;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCambio(TipoCambio tipocambio) {
		try {
			this.tipocambio=tipocambio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransporte(Transporte transporte) {
		try {
			this.transporte=transporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransportista(Transportista transportista) {
		try {
			this.transportista=transportista;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiponotacreditosoli_descripcion(String tiponotacreditosoli_descripcion) {
		try {
			this.tiponotacreditosoli_descripcion=tiponotacreditosoli_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setresponsable_descripcion(String responsable_descripcion) {
		try {
			this.responsable_descripcion=responsable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadonotacreditosoli_descripcion(String estadonotacreditosoli_descripcion) {
		try {
			this.estadonotacreditosoli_descripcion=estadonotacreditosoli_descripcion;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocambio_descripcion(String tipocambio_descripcion) {
		try {
			this.tipocambio_descripcion=tipocambio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransporte_descripcion(String transporte_descripcion) {
		try {
			this.transporte_descripcion=transporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransportista_descripcion(String transportista_descripcion) {
		try {
			this.transportista_descripcion=transportista_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis() {
		return this.detanotacreditosolis;
	}

	
	
	public  void  setDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis) {
		try {
			this.detanotacreditosolis=detanotacreditosolis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_usuario_descripcion="";String id_moneda_descripcion="";String id_empleado_descripcion="";String id_formato_descripcion="";String id_tipo_precio_descripcion="";String id_cliente_descripcion="";String id_factura_descripcion="";String id_tipo_nota_credito_soli_descripcion="";String id_responsable_descripcion="";String id_estado_nota_credito_descripcion="";String penalizado_descripcion="";String id_centro_costo_descripcion="";String id_vendedor_descripcion="";String id_tipo_cambio_descripcion="";String id_transporte_descripcion="";String id_transportista_descripcion="";
	
	
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
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_tipo_nota_credito_soli_descripcion() {
		return id_tipo_nota_credito_soli_descripcion;
	}
	public String getid_responsable_descripcion() {
		return id_responsable_descripcion;
	}
	public String getid_estado_nota_credito_descripcion() {
		return id_estado_nota_credito_descripcion;
	}
	public String getpenalizado_descripcion() {
		return penalizado_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion) {
		this.id_formato_descripcion=newid_formato_descripcion;
	}
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_nota_credito_soli_descripcion(String newid_tipo_nota_credito_soli_descripcion)throws Exception {
		try {
			this.id_tipo_nota_credito_soli_descripcion=newid_tipo_nota_credito_soli_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_responsable_descripcion(String newid_responsable_descripcion) {
		this.id_responsable_descripcion=newid_responsable_descripcion;
	}
	public void setid_estado_nota_credito_descripcion(String newid_estado_nota_credito_descripcion)throws Exception {
		try {
			this.id_estado_nota_credito_descripcion=newid_estado_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpenalizado_descripcion(String newpenalizado_descripcion)throws Exception {
		try {
			this.penalizado_descripcion=newpenalizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion)throws Exception {
		try {
			this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transporte_descripcion(String newid_transporte_descripcion) {
		this.id_transporte_descripcion=newid_transporte_descripcion;
	}
	public void setid_transportista_descripcion(String newid_transportista_descripcion) {
		this.id_transportista_descripcion=newid_transportista_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_usuario_descripcion="";this.id_moneda_descripcion="";this.id_empleado_descripcion="";this.id_formato_descripcion="";this.id_tipo_precio_descripcion="";this.id_cliente_descripcion="";this.id_factura_descripcion="";this.id_tipo_nota_credito_soli_descripcion="";this.id_responsable_descripcion="";this.id_estado_nota_credito_descripcion="";this.penalizado_descripcion="";this.id_centro_costo_descripcion="";this.id_vendedor_descripcion="";this.id_tipo_cambio_descripcion="";this.id_transporte_descripcion="";this.id_transportista_descripcion="";
	}
	
	
	Object detanotacreditosolisDescripcionReporte;
	
	
	public Object getdetanotacreditosolisDescripcionReporte() {
		return detanotacreditosolisDescripcionReporte;
	}

	
	
	public  void  setdetanotacreditosolisDescripcionReporte(Object detanotacreditosolis) {
		try {
			this.detanotacreditosolisDescripcionReporte=detanotacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

