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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.facturacion.util.FacturaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class Factura extends FacturaAdditional implements Serializable ,Cloneable {//FacturaAdditional,GeneralEntity
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
	
	private Factura facturaOriginal;
	
	private Map<String, Object> mapFactura;
			
	public Map<String, Object> getMapFactura() {
		return mapFactura;
	}

	public void setMapFactura(Map<String, Object> mapFactura) {
		this.mapFactura = mapFactura;
	}
	
	public void inicializarMapFactura() {
		this.mapFactura = new HashMap<String,Object>();
	}
	
	public void setMapFacturaValue(String sKey,Object oValue) {
		this.mapFactura.put(sKey, oValue);
	}
	
	public Object getMapFacturaValue(String sKey) {
		return this.mapFactura.get(sKey);
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
	@Pattern(regex=FacturaConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=FacturaConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
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
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cotizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXDIRECCION,message=FacturaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXRUC,message=FacturaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXTELEFONO,message=FacturaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_sub_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transporte;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transportista;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXORDEN,message=FacturaConstantesFunciones.SMENSAJEREGEXORDEN)
	private String orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_llamada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXDESCRIPCION,message=FacturaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double documentos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_descuento;
	
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
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ultimo_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double margen_utilidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_valores;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_consumo_especial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_cliente;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_asiento_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_pedido;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_responsable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_estado_fisico_factura_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=FacturaConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXNUMERO_DAU,message=FacturaConstantesFunciones.SMENSAJEREGEXNUMERO_DAU)
	private String numero_dau;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXNUMERO_REFERENDO,message=FacturaConstantesFunciones.SMENSAJEREGEXNUMERO_REFERENDO)
	private String numero_referendo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_referendo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaConstantesFunciones.SREGEXAFORO_REFERENDO,message=FacturaConstantesFunciones.SMENSAJEREGEXAFORO_REFERENDO)
	private String aforo_referendo;
			
	
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
	public Cliente cliente;
	public TipoPrecio tipoprecio;
	public SubCliente subcliente;
	public Vendedor vendedor;
	public Transporte transporte;
	public Transportista transportista;
	public TipoLlamada tipollamada;
	public TipoFactura tipofactura;
	public TipoCambio tipocambio;
	public AsientoContable asientocontable;
	public Pedido pedido;
	public Responsable responsable;
	public EstadoFisicoFacturaEmpresa estadofisicofacturaempresa;
	
	
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
	private String cliente_descripcion;
	private String tipoprecio_descripcion;
	private String subcliente_descripcion;
	private String vendedor_descripcion;
	private String transporte_descripcion;
	private String transportista_descripcion;
	private String tipollamada_descripcion;
	private String tipofactura_descripcion;
	private String tipocambio_descripcion;
	private String asientocontable_descripcion;
	private String pedido_descripcion;
	private String responsable_descripcion;
	private String estadofisicofacturaempresa_descripcion;
	
	
	public List<DetaFormaPago> detaformapagos;
	public List<DetalleFactura> detallefacturas;
		
	public Factura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.facturaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_usuario=-1L;
 		this.numero_pre_impreso="";
 		this.fecha_emision=new Date();
 		this.numero_dias=0;
 		this.fecha_vencimiento=new Date();
 		this.id_moneda=-1L;
 		this.cotizacion=0.0;
 		this.id_empleado=-1L;
 		this.id_formato=-1L;
 		this.direccion="";
 		this.ruc="";
 		this.id_cliente=-1L;
 		this.id_tipo_precio=-1L;
 		this.telefono="";
 		this.id_sub_cliente=null;
 		this.id_vendedor=-1L;
 		this.id_transporte=null;
 		this.id_transportista=null;
 		this.orden="";
 		this.id_tipo_llamada=-1L;
 		this.hora_inicio=new Time((new Date()).getTime());
 		this.hora_fin=new Time((new Date()).getTime());
 		this.id_tipo_factura=-1L;
 		this.descripcion="";
 		this.cupo=0.0;
 		this.saldo=0.0;
 		this.documentos=0.0;
 		this.disponible=0.0;
 		this.porcentaje_descuento=0.0;
 		this.total_iva=0.0;
 		this.suman=0.0;
 		this.descuento_valor=0.0;
 		this.total_sin_iva=0.0;
 		this.total_descuento=0.0;
 		this.total_flete=0.0;
 		this.total=0.0;
 		this.sub_total=0.0;
 		this.total_otro=0.0;
 		this.ultimo_costo=0.0;
 		this.iva=0.0;
 		this.descuento=0.0;
 		this.financiamiento=0.0;
 		this.margen_utilidad=0.0;
 		this.ice=0.0;
 		this.anticipo=0.0;
 		this.otros_valores=0.0;
 		this.total_retencion=0.0;
 		this.total_consumo_especial=0.0;
 		this.retencion=0.0;
 		this.id_tipo_cambio=null;
 		this.es_cliente=false;
 		this.id_asiento_contable=null;
 		this.id_pedido=null;
 		this.id_responsable=null;
 		this.id_estado_fisico_factura_empresa=null;
 		this.fecha=new Date();
 		this.fecha_autorizacion=new Date();
 		this.fecha_cliente=new Date();
 		this.numero_documento="";
 		this.numero_dau="";
 		this.numero_referendo="";
 		this.fecha_referendo=new Date();
 		this.aforo_referendo="";
		
		
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
		this.cliente=null;
		this.tipoprecio=null;
		this.subcliente=null;
		this.vendedor=null;
		this.transporte=null;
		this.transportista=null;
		this.tipollamada=null;
		this.tipofactura=null;
		this.tipocambio=null;
		this.asientocontable=null;
		this.pedido=null;
		this.responsable=null;
		this.estadofisicofacturaempresa=null;
		
		
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
		this.cliente_descripcion="";
		this.tipoprecio_descripcion="";
		this.subcliente_descripcion="";
		this.vendedor_descripcion="";
		this.transporte_descripcion="";
		this.transportista_descripcion="";
		this.tipollamada_descripcion="";
		this.tipofactura_descripcion="";
		this.tipocambio_descripcion="";
		this.asientocontable_descripcion="";
		this.pedido_descripcion="";
		this.responsable_descripcion="";
		this.estadofisicofacturaempresa_descripcion="";
		
		
		this.detaformapagos=null;
		this.detallefacturas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Factura (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String numero_pre_impreso,Date fecha_emision,Integer numero_dias,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_formato,String direccion,String ruc,Long id_cliente,Long id_tipo_precio,String telefono,Long id_sub_cliente,Long id_vendedor,Long id_transporte,Long id_transportista,String orden,Long id_tipo_llamada,Time hora_inicio,Time hora_fin,Long id_tipo_factura,String descripcion,Double cupo,Double saldo,Double documentos,Double disponible,Double porcentaje_descuento,Double total_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double total_descuento,Double total_flete,Double total,Double sub_total,Double total_otro,Double ultimo_costo,Double iva,Double descuento,Double financiamiento,Double margen_utilidad,Double ice,Double anticipo,Double otros_valores,Double total_retencion,Double total_consumo_especial,Double retencion,Long id_tipo_cambio,Boolean es_cliente,Long id_asiento_contable,Long id_pedido,Long id_responsable,Long id_estado_fisico_factura_empresa,Date fecha,Date fecha_autorizacion,Date fecha_cliente,String numero_documento,String numero_dau,String numero_referendo,Date fecha_referendo,String aforo_referendo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.numero_dias=numero_dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.direccion=direccion;
 		this.ruc=ruc;
 		this.id_cliente=id_cliente;
 		this.id_tipo_precio=id_tipo_precio;
 		this.telefono=telefono;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_vendedor=id_vendedor;
 		this.id_transporte=id_transporte;
 		this.id_transportista=id_transportista;
 		this.orden=orden;
 		this.id_tipo_llamada=id_tipo_llamada;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_tipo_factura=id_tipo_factura;
 		this.descripcion=descripcion;
 		this.cupo=cupo;
 		this.saldo=saldo;
 		this.documentos=documentos;
 		this.disponible=disponible;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.total_iva=total_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.total_flete=total_flete;
 		this.total=total;
 		this.sub_total=sub_total;
 		this.total_otro=total_otro;
 		this.ultimo_costo=ultimo_costo;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.margen_utilidad=margen_utilidad;
 		this.ice=ice;
 		this.anticipo=anticipo;
 		this.otros_valores=otros_valores;
 		this.total_retencion=total_retencion;
 		this.total_consumo_especial=total_consumo_especial;
 		this.retencion=retencion;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.es_cliente=es_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_pedido=id_pedido;
 		this.id_responsable=id_responsable;
 		this.id_estado_fisico_factura_empresa=id_estado_fisico_factura_empresa;
 		this.fecha=fecha;
 		this.fecha_autorizacion=fecha_autorizacion;
 		this.fecha_cliente=fecha_cliente;
 		this.numero_documento=numero_documento;
 		this.numero_dau=numero_dau;
 		this.numero_referendo=numero_referendo;
 		this.fecha_referendo=fecha_referendo;
 		this.aforo_referendo=aforo_referendo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Factura (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,String numero_pre_impreso,Date fecha_emision,Integer numero_dias,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_formato,String direccion,String ruc,Long id_cliente,Long id_tipo_precio,String telefono,Long id_sub_cliente,Long id_vendedor,Long id_transporte,Long id_transportista,String orden,Long id_tipo_llamada,Time hora_inicio,Time hora_fin,Long id_tipo_factura,String descripcion,Double cupo,Double saldo,Double documentos,Double disponible,Double porcentaje_descuento,Double total_iva,Double suman,Double descuento_valor,Double total_sin_iva,Double total_descuento,Double total_flete,Double total,Double sub_total,Double total_otro,Double ultimo_costo,Double iva,Double descuento,Double financiamiento,Double margen_utilidad,Double ice,Double anticipo,Double otros_valores,Double total_retencion,Double total_consumo_especial,Double retencion,Long id_tipo_cambio,Boolean es_cliente,Long id_asiento_contable,Long id_pedido,Long id_responsable,Long id_estado_fisico_factura_empresa,Date fecha,Date fecha_autorizacion,Date fecha_cliente,String numero_documento,String numero_dau,String numero_referendo,Date fecha_referendo,String aforo_referendo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.numero_dias=numero_dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.direccion=direccion;
 		this.ruc=ruc;
 		this.id_cliente=id_cliente;
 		this.id_tipo_precio=id_tipo_precio;
 		this.telefono=telefono;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_vendedor=id_vendedor;
 		this.id_transporte=id_transporte;
 		this.id_transportista=id_transportista;
 		this.orden=orden;
 		this.id_tipo_llamada=id_tipo_llamada;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_tipo_factura=id_tipo_factura;
 		this.descripcion=descripcion;
 		this.cupo=cupo;
 		this.saldo=saldo;
 		this.documentos=documentos;
 		this.disponible=disponible;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.total_iva=total_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.total_sin_iva=total_sin_iva;
 		this.total_descuento=total_descuento;
 		this.total_flete=total_flete;
 		this.total=total;
 		this.sub_total=sub_total;
 		this.total_otro=total_otro;
 		this.ultimo_costo=ultimo_costo;
 		this.iva=iva;
 		this.descuento=descuento;
 		this.financiamiento=financiamiento;
 		this.margen_utilidad=margen_utilidad;
 		this.ice=ice;
 		this.anticipo=anticipo;
 		this.otros_valores=otros_valores;
 		this.total_retencion=total_retencion;
 		this.total_consumo_especial=total_consumo_especial;
 		this.retencion=retencion;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.es_cliente=es_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_pedido=id_pedido;
 		this.id_responsable=id_responsable;
 		this.id_estado_fisico_factura_empresa=id_estado_fisico_factura_empresa;
 		this.fecha=fecha;
 		this.fecha_autorizacion=fecha_autorizacion;
 		this.fecha_cliente=fecha_cliente;
 		this.numero_documento=numero_documento;
 		this.numero_dau=numero_dau;
 		this.numero_referendo=numero_referendo;
 		this.fecha_referendo=fecha_referendo;
 		this.aforo_referendo=aforo_referendo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Factura facturaLocal=null;
		
		if(object!=null) {
			facturaLocal=(Factura)object;
			
			if(facturaLocal!=null) {
				if(this.getId()!=null && facturaLocal.getId()!=null) {
					if(this.getId().equals(facturaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FacturaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FacturaConstantesFunciones.getFacturaDescripcion(this);
		} else {
			sDetalle=FacturaConstantesFunciones.getFacturaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Factura getFacturaOriginal() {
		return this.facturaOriginal;
	}
	
	public void setFacturaOriginal(Factura factura) {
		try {
			this.facturaOriginal=factura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FacturaAdditional facturaAdditional=null;
	
	public FacturaAdditional getFacturaAdditional() {
		return this.facturaAdditional;
	}
	
	public void setFacturaAdditional(FacturaAdditional facturaAdditional) {
		try {
			this.facturaAdditional=facturaAdditional;
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
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
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
    
	
	public Double getcotizacion() {
		return this.cotizacion;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Long getid_sub_cliente() {
		return this.id_sub_cliente;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
    
	
	public String getorden() {
		return this.orden;
	}
    
	
	public Long getid_tipo_llamada() {
		return this.id_tipo_llamada;
	}
    
	
	public Time gethora_inicio() {
		return this.hora_inicio;
	}
    
	
	public Time gethora_fin() {
		return this.hora_fin;
	}
    
	
	public Long getid_tipo_factura() {
		return this.id_tipo_factura;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getcupo() {
		return this.cupo;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
    
	
	public Double getdocumentos() {
		return this.documentos;
	}
    
	
	public Double getdisponible() {
		return this.disponible;
	}
    
	
	public Double getporcentaje_descuento() {
		return this.porcentaje_descuento;
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
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double gettotal_flete() {
		return this.total_flete;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double gettotal_otro() {
		return this.total_otro;
	}
    
	
	public Double getultimo_costo() {
		return this.ultimo_costo;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getmargen_utilidad() {
		return this.margen_utilidad;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getanticipo() {
		return this.anticipo;
	}
    
	
	public Double getotros_valores() {
		return this.otros_valores;
	}
    
	
	public Double gettotal_retencion() {
		return this.total_retencion;
	}
    
	
	public Double gettotal_consumo_especial() {
		return this.total_consumo_especial;
	}
    
	
	public Double getretencion() {
		return this.retencion;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Boolean getes_cliente() {
		return this.es_cliente;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_pedido() {
		return this.id_pedido;
	}
    
	
	public Long getid_responsable() {
		return this.id_responsable;
	}
    
	
	public Long getid_estado_fisico_factura_empresa() {
		return this.id_estado_fisico_factura_empresa;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_autorizacion() {
		return this.fecha_autorizacion;
	}
    
	
	public Date getfecha_cliente() {
		return this.fecha_cliente;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public String getnumero_dau() {
		return this.numero_dau;
	}
    
	
	public String getnumero_referendo() {
		return this.numero_referendo;
	}
    
	
	public Date getfecha_referendo() {
		return this.fecha_referendo;
	}
    
	
	public String getaforo_referendo() {
		return this.aforo_referendo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Factura:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("Factura:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("Factura:Valor nulo no permitido en columna id_periodo");
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
						System.out.println("Factura:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
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
						System.out.println("Factura:Valor nulo no permitido en columna fecha_emision");
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
						System.out.println("Factura:Valor nulo no permitido en columna numero_dias");
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
						System.out.println("Factura:Valor nulo no permitido en columna fecha_vencimiento");
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
						System.out.println("Factura:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
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
						System.out.println("Factura:Valor nulo no permitido en columna cotizacion");
					}
				}

				this.cotizacion=newcotizacion;
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
						System.out.println("Factura:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
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
						System.out.println("Factura:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("Factura:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
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
						System.out.println("Factura:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
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
						System.out.println("Factura:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_cliente(Long newid_sub_cliente) {
		if(this.id_sub_cliente==null&&newid_sub_cliente!=null) {
			this.id_sub_cliente=newid_sub_cliente;
				this.setIsChanged(true);
		}

		if(this.id_sub_cliente!=null&&!this.id_sub_cliente.equals(newid_sub_cliente)) {

			this.id_sub_cliente=newid_sub_cliente;
				this.setIsChanged(true);
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setorden(String neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna orden");
					}
				}

				if(neworden!=null&&neworden.length()>20) {
					neworden=neworden.substring(0,18);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna orden");
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_llamada(Long newid_tipo_llamada)throws Exception
	{
		try {
			if(this.id_tipo_llamada!=newid_tipo_llamada) {
				if(newid_tipo_llamada==null) {
					//newid_tipo_llamada=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_tipo_llamada");
					}
				}

				this.id_tipo_llamada=newid_tipo_llamada;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_inicio(Time newhora_inicio)throws Exception
	{
		try {
			if(this.hora_inicio!=newhora_inicio) {
				if(newhora_inicio==null) {
					//newhora_inicio=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna hora_inicio");
					}
				}

				this.hora_inicio=newhora_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_fin(Time newhora_fin)throws Exception
	{
		try {
			if(this.hora_fin!=newhora_fin) {
				if(newhora_fin==null) {
					//newhora_fin=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna hora_fin");
					}
				}

				this.hora_fin=newhora_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_factura(Long newid_tipo_factura)throws Exception
	{
		try {
			if(this.id_tipo_factura!=newid_tipo_factura) {
				if(newid_tipo_factura==null) {
					//newid_tipo_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna id_tipo_factura");
					}
				}

				this.id_tipo_factura=newid_tipo_factura;
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
						System.out.println("Factura:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcupo(Double newcupo)throws Exception
	{
		try {
			if(this.cupo!=newcupo) {
				if(newcupo==null) {
					//newcupo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna cupo");
					}
				}

				this.cupo=newcupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo(Double newsaldo)throws Exception
	{
		try {
			if(this.saldo!=newsaldo) {
				if(newsaldo==null) {
					//newsaldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdocumentos(Double newdocumentos)throws Exception
	{
		try {
			if(this.documentos!=newdocumentos) {
				if(newdocumentos==null) {
					//newdocumentos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna documentos");
					}
				}

				this.documentos=newdocumentos;
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
						System.out.println("Factura:Valor nulo no permitido en columna disponible");
					}
				}

				this.disponible=newdisponible;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_descuento(Double newporcentaje_descuento)throws Exception
	{
		try {
			if(this.porcentaje_descuento!=newporcentaje_descuento) {
				if(newporcentaje_descuento==null) {
					//newporcentaje_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna porcentaje_descuento");
					}
				}

				this.porcentaje_descuento=newporcentaje_descuento;
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
						System.out.println("Factura:Valor nulo no permitido en columna total_iva");
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
						System.out.println("Factura:Valor nulo no permitido en columna suman");
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
						System.out.println("Factura:Valor nulo no permitido en columna descuento_valor");
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
						System.out.println("Factura:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_descuento(Double newtotal_descuento)throws Exception
	{
		try {
			if(this.total_descuento!=newtotal_descuento) {
				if(newtotal_descuento==null) {
					//newtotal_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_flete(Double newtotal_flete)throws Exception
	{
		try {
			if(this.total_flete!=newtotal_flete) {
				if(newtotal_flete==null) {
					//newtotal_flete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna total_flete");
					}
				}

				this.total_flete=newtotal_flete;
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
						System.out.println("Factura:Valor nulo no permitido en columna total");
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
						System.out.println("Factura:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_otro(Double newtotal_otro)throws Exception
	{
		try {
			if(this.total_otro!=newtotal_otro) {
				if(newtotal_otro==null) {
					//newtotal_otro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna total_otro");
					}
				}

				this.total_otro=newtotal_otro;
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
						System.out.println("Factura:Valor nulo no permitido en columna ultimo_costo");
					}
				}

				this.ultimo_costo=newultimo_costo;
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
						System.out.println("Factura:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
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
						System.out.println("Factura:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
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
						System.out.println("Factura:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmargen_utilidad(Double newmargen_utilidad)throws Exception
	{
		try {
			if(this.margen_utilidad!=newmargen_utilidad) {
				if(newmargen_utilidad==null) {
					//newmargen_utilidad=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna margen_utilidad");
					}
				}

				this.margen_utilidad=newmargen_utilidad;
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
						System.out.println("Factura:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanticipo(Double newanticipo)throws Exception
	{
		try {
			if(this.anticipo!=newanticipo) {
				if(newanticipo==null) {
					//newanticipo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna anticipo");
					}
				}

				this.anticipo=newanticipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros_valores(Double newotros_valores)throws Exception
	{
		try {
			if(this.otros_valores!=newotros_valores) {
				if(newotros_valores==null) {
					//newotros_valores=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna otros_valores");
					}
				}

				this.otros_valores=newotros_valores;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_retencion(Double newtotal_retencion)throws Exception
	{
		try {
			if(this.total_retencion!=newtotal_retencion) {
				if(newtotal_retencion==null) {
					//newtotal_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna total_retencion");
					}
				}

				this.total_retencion=newtotal_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_consumo_especial(Double newtotal_consumo_especial)throws Exception
	{
		try {
			if(this.total_consumo_especial!=newtotal_consumo_especial) {
				if(newtotal_consumo_especial==null) {
					//newtotal_consumo_especial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna total_consumo_especial");
					}
				}

				this.total_consumo_especial=newtotal_consumo_especial;
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
						System.out.println("Factura:Valor nulo no permitido en columna retencion");
					}
				}

				this.retencion=newretencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setes_cliente(Boolean newes_cliente)throws Exception
	{
		try {
			if(this.es_cliente!=newes_cliente) {
				if(newes_cliente==null) {
					//newes_cliente=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna es_cliente");
					}
				}

				this.es_cliente=newes_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setid_pedido(Long newid_pedido) {
		if(this.id_pedido==null&&newid_pedido!=null) {
			this.id_pedido=newid_pedido;
				this.setIsChanged(true);
		}

		if(this.id_pedido!=null&&!this.id_pedido.equals(newid_pedido)) {

			this.id_pedido=newid_pedido;
				this.setIsChanged(true);
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
    
	public void setid_estado_fisico_factura_empresa(Long newid_estado_fisico_factura_empresa) {
		if(this.id_estado_fisico_factura_empresa==null&&newid_estado_fisico_factura_empresa!=null) {
			this.id_estado_fisico_factura_empresa=newid_estado_fisico_factura_empresa;
				this.setIsChanged(true);
		}

		if(this.id_estado_fisico_factura_empresa!=null&&!this.id_estado_fisico_factura_empresa.equals(newid_estado_fisico_factura_empresa)) {

			this.id_estado_fisico_factura_empresa=newid_estado_fisico_factura_empresa;
				this.setIsChanged(true);
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("Factura:Valor nulo no permitido en columna fecha_autorizacion");
					}
				}

				this.fecha_autorizacion=newfecha_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_cliente(Date newfecha_cliente)throws Exception
	{
		try {
			if(this.fecha_cliente!=newfecha_cliente) {
				if(newfecha_cliente==null) {
					//newfecha_cliente=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna fecha_cliente");
					}
				}

				this.fecha_cliente=newfecha_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento(String newnumero_documento)throws Exception
	{
		try {
			if(this.numero_documento!=newnumero_documento) {
				if(newnumero_documento==null) {
					//newnumero_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dau(String newnumero_dau)throws Exception
	{
		try {
			if(this.numero_dau!=newnumero_dau) {
				if(newnumero_dau==null) {
					//newnumero_dau="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna numero_dau");
					}
				}

				if(newnumero_dau!=null&&newnumero_dau.length()>50) {
					newnumero_dau=newnumero_dau.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_dau");
				}

				this.numero_dau=newnumero_dau;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_referendo(String newnumero_referendo)throws Exception
	{
		try {
			if(this.numero_referendo!=newnumero_referendo) {
				if(newnumero_referendo==null) {
					//newnumero_referendo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna numero_referendo");
					}
				}

				if(newnumero_referendo!=null&&newnumero_referendo.length()>50) {
					newnumero_referendo=newnumero_referendo.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_referendo");
				}

				this.numero_referendo=newnumero_referendo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_referendo(Date newfecha_referendo)throws Exception
	{
		try {
			if(this.fecha_referendo!=newfecha_referendo) {
				if(newfecha_referendo==null) {
					//newfecha_referendo=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna fecha_referendo");
					}
				}

				this.fecha_referendo=newfecha_referendo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setaforo_referendo(String newaforo_referendo)throws Exception
	{
		try {
			if(this.aforo_referendo!=newaforo_referendo) {
				if(newaforo_referendo==null) {
					//newaforo_referendo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Factura:Valor nulo no permitido en columna aforo_referendo");
					}
				}

				if(newaforo_referendo!=null&&newaforo_referendo.length()>50) {
					newaforo_referendo=newaforo_referendo.substring(0,48);
					System.out.println("Factura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna aforo_referendo");
				}

				this.aforo_referendo=newaforo_referendo;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public SubCliente getSubCliente() {
		return this.subcliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public Transportista getTransportista() {
		return this.transportista;
	}

	public TipoLlamada getTipoLlamada() {
		return this.tipollamada;
	}

	public TipoFactura getTipoFactura() {
		return this.tipofactura;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public Responsable getResponsable() {
		return this.responsable;
	}

	public EstadoFisicoFacturaEmpresa getEstadoFisicoFacturaEmpresa() {
		return this.estadofisicofacturaempresa;
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

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getsubcliente_descripcion() {
		return this.subcliente_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
	}

	public String gettipollamada_descripcion() {
		return this.tipollamada_descripcion;
	}

	public String gettipofactura_descripcion() {
		return this.tipofactura_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getpedido_descripcion() {
		return this.pedido_descripcion;
	}

	public String getresponsable_descripcion() {
		return this.responsable_descripcion;
	}

	public String getestadofisicofacturaempresa_descripcion() {
		return this.estadofisicofacturaempresa_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setSubCliente(SubCliente subcliente) {
		try {
			this.subcliente=subcliente;
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


	public  void  setTipoLlamada(TipoLlamada tipollamada) {
		try {
			this.tipollamada=tipollamada;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFactura(TipoFactura tipofactura) {
		try {
			this.tipofactura=tipofactura;
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


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPedido(Pedido pedido) {
		try {
			this.pedido=pedido;
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


	public  void  setEstadoFisicoFacturaEmpresa(EstadoFisicoFacturaEmpresa estadofisicofacturaempresa) {
		try {
			this.estadofisicofacturaempresa=estadofisicofacturaempresa;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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


	public  void  setsubcliente_descripcion(String subcliente_descripcion) {
		try {
			this.subcliente_descripcion=subcliente_descripcion;
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


	public  void  settipollamada_descripcion(String tipollamada_descripcion) {
		try {
			this.tipollamada_descripcion=tipollamada_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipofactura_descripcion(String tipofactura_descripcion) {
		try {
			this.tipofactura_descripcion=tipofactura_descripcion;
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


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpedido_descripcion(String pedido_descripcion) {
		try {
			this.pedido_descripcion=pedido_descripcion;
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


	public  void  setestadofisicofacturaempresa_descripcion(String estadofisicofacturaempresa_descripcion) {
		try {
			this.estadofisicofacturaempresa_descripcion=estadofisicofacturaempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetaFormaPago> getDetaFormaPagos() {
		return this.detaformapagos;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detallefacturas;
	}

	
	
	public  void  setDetaFormaPagos(List<DetaFormaPago> detaformapagos) {
		try {
			this.detaformapagos=detaformapagos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleFacturas(List<DetalleFactura> detallefacturas) {
		try {
			this.detallefacturas=detallefacturas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_usuario_descripcion="";String id_moneda_descripcion="";String id_empleado_descripcion="";String id_formato_descripcion="";String id_cliente_descripcion="";String id_tipo_precio_descripcion="";String id_sub_cliente_descripcion="";String id_vendedor_descripcion="";String id_transporte_descripcion="";String id_transportista_descripcion="";String id_tipo_llamada_descripcion="";String id_tipo_factura_descripcion="";String id_tipo_cambio_descripcion="";String es_cliente_descripcion="";String id_asiento_contable_descripcion="";String id_pedido_descripcion="";String id_responsable_descripcion="";String id_estado_fisico_factura_empresa_descripcion="";
	
	
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
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_sub_cliente_descripcion() {
		return id_sub_cliente_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
	}
	public String getid_tipo_llamada_descripcion() {
		return id_tipo_llamada_descripcion;
	}
	public String getid_tipo_factura_descripcion() {
		return id_tipo_factura_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getes_cliente_descripcion() {
		return es_cliente_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_pedido_descripcion() {
		return id_pedido_descripcion;
	}
	public String getid_responsable_descripcion() {
		return id_responsable_descripcion;
	}
	public String getid_estado_fisico_factura_empresa_descripcion() {
		return id_estado_fisico_factura_empresa_descripcion;
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
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
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
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sub_cliente_descripcion(String newid_sub_cliente_descripcion) {
		this.id_sub_cliente_descripcion=newid_sub_cliente_descripcion;
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
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
	public void setid_tipo_llamada_descripcion(String newid_tipo_llamada_descripcion)throws Exception {
		try {
			this.id_tipo_llamada_descripcion=newid_tipo_llamada_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_factura_descripcion(String newid_tipo_factura_descripcion)throws Exception {
		try {
			this.id_tipo_factura_descripcion=newid_tipo_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion) {
		this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
	}
	public void setes_cliente_descripcion(String newes_cliente_descripcion)throws Exception {
		try {
			this.es_cliente_descripcion=newes_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion) {
		this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
	}
	public void setid_pedido_descripcion(String newid_pedido_descripcion) {
		this.id_pedido_descripcion=newid_pedido_descripcion;
	}
	public void setid_responsable_descripcion(String newid_responsable_descripcion) {
		this.id_responsable_descripcion=newid_responsable_descripcion;
	}
	public void setid_estado_fisico_factura_empresa_descripcion(String newid_estado_fisico_factura_empresa_descripcion) {
		this.id_estado_fisico_factura_empresa_descripcion=newid_estado_fisico_factura_empresa_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_usuario_descripcion="";this.id_moneda_descripcion="";this.id_empleado_descripcion="";this.id_formato_descripcion="";this.id_cliente_descripcion="";this.id_tipo_precio_descripcion="";this.id_sub_cliente_descripcion="";this.id_vendedor_descripcion="";this.id_transporte_descripcion="";this.id_transportista_descripcion="";this.id_tipo_llamada_descripcion="";this.id_tipo_factura_descripcion="";this.id_tipo_cambio_descripcion="";this.es_cliente_descripcion="";this.id_asiento_contable_descripcion="";this.id_pedido_descripcion="";this.id_responsable_descripcion="";this.id_estado_fisico_factura_empresa_descripcion="";
	}
	
	
	Object detaformapagosDescripcionReporte;
	Object detallefacturasDescripcionReporte;
	
	
	public Object getdetaformapagosDescripcionReporte() {
		return detaformapagosDescripcionReporte;
	}

	public Object getdetallefacturasDescripcionReporte() {
		return detallefacturasDescripcionReporte;
	}

	
	
	public  void  setdetaformapagosDescripcionReporte(Object detaformapagos) {
		try {
			this.detaformapagosDescripcionReporte=detaformapagos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallefacturasDescripcionReporte(Object detallefacturas) {
		try {
			this.detallefacturasDescripcionReporte=detallefacturas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

