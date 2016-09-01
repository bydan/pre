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
//import com.bydan.erp.facturacion.util.GuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class GuiaRemision extends GuiaRemisionAdditional implements Serializable ,Cloneable {//GuiaRemisionAdditional,GeneralEntity
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
	
	private GuiaRemision guiaremisionOriginal;
	
	private Map<String, Object> mapGuiaRemision;
			
	public Map<String, Object> getMapGuiaRemision() {
		return mapGuiaRemision;
	}

	public void setMapGuiaRemision(Map<String, Object> mapGuiaRemision) {
		this.mapGuiaRemision = mapGuiaRemision;
	}
	
	public void inicializarMapGuiaRemision() {
		this.mapGuiaRemision = new HashMap<String,Object>();
	}
	
	public void setMapGuiaRemisionValue(String sKey,Object oValue) {
		this.mapGuiaRemision.put(sKey, oValue);
	}
	
	public Object getMapGuiaRemisionValue(String sKey) {
		return this.mapGuiaRemision.get(sKey);
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
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXSECUENCIAL,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXNUMERO_CAMION,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXNUMERO_CAMION)
	private String numero_camion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_vendedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_factura;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transportista;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXIDENTIFICACION,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXTRANSPORTE_CODIGO,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXTRANSPORTE_CODIGO)
	private String transporte_codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_bultos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_consultor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sub_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_ciudad_origen;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_ciudad_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_llamada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double disponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXDESCRIPCION,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_retencion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXRUC_CLIENTE,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXRUC_CLIENTE)
	private String ruc_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXTELEFONO_CLIENTE,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXTELEFONO_CLIENTE)
	private String telefono_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXDIRECCION_CLIENTE,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXDIRECCION_CLIENTE)
	private String direccion_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=GuiaRemisionConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=GuiaRemisionConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double peso_bruto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Usuario usuario;
	public Formato formato;
	public TipoPrecio tipoprecio;
	public Moneda moneda;
	public Cliente cliente;
	public Vendedor vendedor;
	public Factura factura;
	public Transportista transportista;
	public Consultor consultor;
	public Transporte transporte;
	public SubCliente subcliente;
	public Empleado empleado;
	public Ciudad ciudadorigen;
	public Ciudad ciudaddestino;
	public TipoLlamada tipollamada;
	public TipoCambio tipocambio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String usuario_descripcion;
	private String formato_descripcion;
	private String tipoprecio_descripcion;
	private String moneda_descripcion;
	private String cliente_descripcion;
	private String vendedor_descripcion;
	private String factura_descripcion;
	private String transportista_descripcion;
	private String consultor_descripcion;
	private String transporte_descripcion;
	private String subcliente_descripcion;
	private String empleado_descripcion;
	private String ciudadorigen_descripcion;
	private String ciudaddestino_descripcion;
	private String tipollamada_descripcion;
	private String tipocambio_descripcion;
	
	
	public List<DetalleGuiaRemision> detalleguiaremisions;
		
	public GuiaRemision () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.guiaremisionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_usuario=-1L;
 		this.secuencial="";
 		this.fecha_emision=new Date();
 		this.id_formato=null;
 		this.id_tipo_precio=-1L;
 		this.id_moneda=-1L;
 		this.numero_camion="";
 		this.id_cliente=-1L;
 		this.id_vendedor=null;
 		this.id_factura=null;
 		this.id_transportista=null;
 		this.identificacion="";
 		this.fecha_origen=new Date();
 		this.fecha_destino=new Date();
 		this.transporte_codigo="";
 		this.cantidad_bultos=0;
 		this.id_consultor=-1L;
 		this.id_transporte=-1L;
 		this.id_sub_cliente=-1L;
 		this.id_empleado=-1L;
 		this.id_ciudad_origen=null;
 		this.id_ciudad_destino=null;
 		this.id_tipo_llamada=-1L;
 		this.hora_inicio=new Time((new Date()).getTime());
 		this.hora_fin=new Time((new Date()).getTime());
 		this.cupo=0.0;
 		this.saldo=0.0;
 		this.documento=0.0;
 		this.disponible=0.0;
 		this.descripcion="";
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.descuento=0.0;
 		this.flete=0.0;
 		this.otro=0.0;
 		this.financiamiento=0.0;
 		this.iva=0.0;
 		this.total=0.0;
 		this.monto_retencion=0.0;
 		this.id_tipo_cambio=null;
 		this.fecha=new Date();
 		this.ruc_cliente="";
 		this.nombre_cliente="";
 		this.telefono_cliente="";
 		this.direccion_cliente="";
 		this.numero_pre_impreso="";
 		this.peso_bruto=0.0;
 		this.fecha_autorizacion=new Date();
 		this.fecha_vencimiento=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.usuario=null;
		this.formato=null;
		this.tipoprecio=null;
		this.moneda=null;
		this.cliente=null;
		this.vendedor=null;
		this.factura=null;
		this.transportista=null;
		this.consultor=null;
		this.transporte=null;
		this.subcliente=null;
		this.empleado=null;
		this.ciudadorigen=null;
		this.ciudaddestino=null;
		this.tipollamada=null;
		this.tipocambio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.usuario_descripcion="";
		this.formato_descripcion="";
		this.tipoprecio_descripcion="";
		this.moneda_descripcion="";
		this.cliente_descripcion="";
		this.vendedor_descripcion="";
		this.factura_descripcion="";
		this.transportista_descripcion="";
		this.consultor_descripcion="";
		this.transporte_descripcion="";
		this.subcliente_descripcion="";
		this.empleado_descripcion="";
		this.ciudadorigen_descripcion="";
		this.ciudaddestino_descripcion="";
		this.tipollamada_descripcion="";
		this.tipocambio_descripcion="";
		
		
		this.detalleguiaremisions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GuiaRemision (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_usuario,String secuencial,Date fecha_emision,Long id_formato,Long id_tipo_precio,Long id_moneda,String numero_camion,Long id_cliente,Long id_vendedor,Long id_factura,Long id_transportista,String identificacion,Date fecha_origen,Date fecha_destino,String transporte_codigo,Integer cantidad_bultos,Long id_consultor,Long id_transporte,Long id_sub_cliente,Long id_empleado,Long id_ciudad_origen,Long id_ciudad_destino,Long id_tipo_llamada,Time hora_inicio,Time hora_fin,Double cupo,Double saldo,Double documento,Double disponible,String descripcion,Double total_iva,Double total_sin_iva,Double descuento,Double flete,Double otro,Double financiamiento,Double iva,Double total,Double monto_retencion,Long id_tipo_cambio,Date fecha,String ruc_cliente,String nombre_cliente,String telefono_cliente,String direccion_cliente,String numero_pre_impreso,Double peso_bruto,Date fecha_autorizacion,Date fecha_vencimiento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.guiaremisionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_usuario=id_usuario;
 		this.secuencial=secuencial;
 		this.fecha_emision=fecha_emision;
 		this.id_formato=id_formato;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_moneda=id_moneda;
 		this.numero_camion=numero_camion;
 		this.id_cliente=id_cliente;
 		this.id_vendedor=id_vendedor;
 		this.id_factura=id_factura;
 		this.id_transportista=id_transportista;
 		this.identificacion=identificacion;
 		this.fecha_origen=fecha_origen;
 		this.fecha_destino=fecha_destino;
 		this.transporte_codigo=transporte_codigo;
 		this.cantidad_bultos=cantidad_bultos;
 		this.id_consultor=id_consultor;
 		this.id_transporte=id_transporte;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_empleado=id_empleado;
 		this.id_ciudad_origen=id_ciudad_origen;
 		this.id_ciudad_destino=id_ciudad_destino;
 		this.id_tipo_llamada=id_tipo_llamada;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.cupo=cupo;
 		this.saldo=saldo;
 		this.documento=documento;
 		this.disponible=disponible;
 		this.descripcion=descripcion;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.descuento=descuento;
 		this.flete=flete;
 		this.otro=otro;
 		this.financiamiento=financiamiento;
 		this.iva=iva;
 		this.total=total;
 		this.monto_retencion=monto_retencion;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.fecha=fecha;
 		this.ruc_cliente=ruc_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.peso_bruto=peso_bruto;
 		this.fecha_autorizacion=fecha_autorizacion;
 		this.fecha_vencimiento=fecha_vencimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GuiaRemision (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_usuario,String secuencial,Date fecha_emision,Long id_formato,Long id_tipo_precio,Long id_moneda,String numero_camion,Long id_cliente,Long id_vendedor,Long id_factura,Long id_transportista,String identificacion,Date fecha_origen,Date fecha_destino,String transporte_codigo,Integer cantidad_bultos,Long id_consultor,Long id_transporte,Long id_sub_cliente,Long id_empleado,Long id_ciudad_origen,Long id_ciudad_destino,Long id_tipo_llamada,Time hora_inicio,Time hora_fin,Double cupo,Double saldo,Double documento,Double disponible,String descripcion,Double total_iva,Double total_sin_iva,Double descuento,Double flete,Double otro,Double financiamiento,Double iva,Double total,Double monto_retencion,Long id_tipo_cambio,Date fecha,String ruc_cliente,String nombre_cliente,String telefono_cliente,String direccion_cliente,String numero_pre_impreso,Double peso_bruto,Date fecha_autorizacion,Date fecha_vencimiento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.guiaremisionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_usuario=id_usuario;
 		this.secuencial=secuencial;
 		this.fecha_emision=fecha_emision;
 		this.id_formato=id_formato;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_moneda=id_moneda;
 		this.numero_camion=numero_camion;
 		this.id_cliente=id_cliente;
 		this.id_vendedor=id_vendedor;
 		this.id_factura=id_factura;
 		this.id_transportista=id_transportista;
 		this.identificacion=identificacion;
 		this.fecha_origen=fecha_origen;
 		this.fecha_destino=fecha_destino;
 		this.transporte_codigo=transporte_codigo;
 		this.cantidad_bultos=cantidad_bultos;
 		this.id_consultor=id_consultor;
 		this.id_transporte=id_transporte;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_empleado=id_empleado;
 		this.id_ciudad_origen=id_ciudad_origen;
 		this.id_ciudad_destino=id_ciudad_destino;
 		this.id_tipo_llamada=id_tipo_llamada;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.cupo=cupo;
 		this.saldo=saldo;
 		this.documento=documento;
 		this.disponible=disponible;
 		this.descripcion=descripcion;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.descuento=descuento;
 		this.flete=flete;
 		this.otro=otro;
 		this.financiamiento=financiamiento;
 		this.iva=iva;
 		this.total=total;
 		this.monto_retencion=monto_retencion;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.fecha=fecha;
 		this.ruc_cliente=ruc_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.peso_bruto=peso_bruto;
 		this.fecha_autorizacion=fecha_autorizacion;
 		this.fecha_vencimiento=fecha_vencimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GuiaRemision guiaremisionLocal=null;
		
		if(object!=null) {
			guiaremisionLocal=(GuiaRemision)object;
			
			if(guiaremisionLocal!=null) {
				if(this.getId()!=null && guiaremisionLocal.getId()!=null) {
					if(this.getId().equals(guiaremisionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GuiaRemisionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcion(this);
		} else {
			sDetalle=GuiaRemisionConstantesFunciones.getGuiaRemisionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GuiaRemision getGuiaRemisionOriginal() {
		return this.guiaremisionOriginal;
	}
	
	public void setGuiaRemisionOriginal(GuiaRemision guiaremision) {
		try {
			this.guiaremisionOriginal=guiaremision;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GuiaRemisionAdditional guiaremisionAdditional=null;
	
	public GuiaRemisionAdditional getGuiaRemisionAdditional() {
		return this.guiaremisionAdditional;
	}
	
	public void setGuiaRemisionAdditional(GuiaRemisionAdditional guiaremisionAdditional) {
		try {
			this.guiaremisionAdditional=guiaremisionAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public String getnumero_camion() {
		return this.numero_camion;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public Date getfecha_origen() {
		return this.fecha_origen;
	}
    
	
	public Date getfecha_destino() {
		return this.fecha_destino;
	}
    
	
	public String gettransporte_codigo() {
		return this.transporte_codigo;
	}
    
	
	public Integer getcantidad_bultos() {
		return this.cantidad_bultos;
	}
    
	
	public Long getid_consultor() {
		return this.id_consultor;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Long getid_sub_cliente() {
		return this.id_sub_cliente;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_ciudad_origen() {
		return this.id_ciudad_origen;
	}
    
	
	public Long getid_ciudad_destino() {
		return this.id_ciudad_destino;
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
    
	
	public Double getcupo() {
		return this.cupo;
	}
    
	
	public Double getsaldo() {
		return this.saldo;
	}
    
	
	public Double getdocumento() {
		return this.documento;
	}
    
	
	public Double getdisponible() {
		return this.disponible;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getotro() {
		return this.otro;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getmonto_retencion() {
		return this.monto_retencion;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getruc_cliente() {
		return this.ruc_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String gettelefono_cliente() {
		return this.telefono_cliente;
	}
    
	
	public String getdireccion_cliente() {
		return this.direccion_cliente;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Double getpeso_bruto() {
		return this.peso_bruto;
	}
    
	
	public Date getfecha_autorizacion() {
		return this.fecha_autorizacion;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_camion(String newnumero_camion)throws Exception
	{
		try {
			if(this.numero_camion!=newnumero_camion) {
				if(newnumero_camion==null) {
					//newnumero_camion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna numero_camion");
					}
				}

				if(newnumero_camion!=null&&newnumero_camion.length()>50) {
					newnumero_camion=newnumero_camion.substring(0,48);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_camion");
				}

				this.numero_camion=newnumero_camion;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setid_factura(Long newid_factura) {
		if(this.id_factura==null&&newid_factura!=null) {
			this.id_factura=newid_factura;
				this.setIsChanged(true);
		}

		if(this.id_factura!=null&&!this.id_factura.equals(newid_factura)) {

			this.id_factura=newid_factura;
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
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_origen(Date newfecha_origen)throws Exception
	{
		try {
			if(this.fecha_origen!=newfecha_origen) {
				if(newfecha_origen==null) {
					//newfecha_origen=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha_origen");
					}
				}

				this.fecha_origen=newfecha_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_destino(Date newfecha_destino)throws Exception
	{
		try {
			if(this.fecha_destino!=newfecha_destino) {
				if(newfecha_destino==null) {
					//newfecha_destino=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha_destino");
					}
				}

				this.fecha_destino=newfecha_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settransporte_codigo(String newtransporte_codigo)throws Exception
	{
		try {
			if(this.transporte_codigo!=newtransporte_codigo) {
				if(newtransporte_codigo==null) {
					//newtransporte_codigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna transporte_codigo");
					}
				}

				if(newtransporte_codigo!=null&&newtransporte_codigo.length()>100) {
					newtransporte_codigo=newtransporte_codigo.substring(0,98);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna transporte_codigo");
				}

				this.transporte_codigo=newtransporte_codigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_bultos(Integer newcantidad_bultos)throws Exception
	{
		try {
			if(this.cantidad_bultos!=newcantidad_bultos) {
				if(newcantidad_bultos==null) {
					//newcantidad_bultos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna cantidad_bultos");
					}
				}

				this.cantidad_bultos=newcantidad_bultos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_consultor(Long newid_consultor)throws Exception
	{
		try {
			if(this.id_consultor!=newid_consultor) {
				if(newid_consultor==null) {
					//newid_consultor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_consultor");
					}
				}

				this.id_consultor=newid_consultor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transporte(Long newid_transporte)throws Exception
	{
		try {
			if(this.id_transporte!=newid_transporte) {
				if(newid_transporte==null) {
					//newid_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_transporte");
					}
				}

				this.id_transporte=newid_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sub_cliente(Long newid_sub_cliente)throws Exception
	{
		try {
			if(this.id_sub_cliente!=newid_sub_cliente) {
				if(newid_sub_cliente==null) {
					//newid_sub_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_sub_cliente");
					}
				}

				this.id_sub_cliente=newid_sub_cliente;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad_origen(Long newid_ciudad_origen) {
		if(this.id_ciudad_origen==null&&newid_ciudad_origen!=null) {
			this.id_ciudad_origen=newid_ciudad_origen;
				this.setIsChanged(true);
		}

		if(this.id_ciudad_origen!=null&&!this.id_ciudad_origen.equals(newid_ciudad_origen)) {

			this.id_ciudad_origen=newid_ciudad_origen;
				this.setIsChanged(true);
		}
	}
    
	public void setid_ciudad_destino(Long newid_ciudad_destino) {
		if(this.id_ciudad_destino==null&&newid_ciudad_destino!=null) {
			this.id_ciudad_destino=newid_ciudad_destino;
				this.setIsChanged(true);
		}

		if(this.id_ciudad_destino!=null&&!this.id_ciudad_destino.equals(newid_ciudad_destino)) {

			this.id_ciudad_destino=newid_ciudad_destino;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_llamada(Long newid_tipo_llamada)throws Exception
	{
		try {
			if(this.id_tipo_llamada!=newid_tipo_llamada) {
				if(newid_tipo_llamada==null) {
					//newid_tipo_llamada=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna id_tipo_llamada");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna hora_inicio");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna hora_fin");
					}
				}

				this.hora_fin=newhora_fin;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna cupo");
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna saldo");
					}
				}

				this.saldo=newsaldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdocumento(Double newdocumento)throws Exception
	{
		try {
			if(this.documento!=newdocumento) {
				if(newdocumento==null) {
					//newdocumento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna documento");
					}
				}

				this.documento=newdocumento;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna disponible");
					}
				}

				this.disponible=newdisponible;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna otro");
					}
				}

				this.otro=newotro;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_retencion(Double newmonto_retencion)throws Exception
	{
		try {
			if(this.monto_retencion!=newmonto_retencion) {
				if(newmonto_retencion==null) {
					//newmonto_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna monto_retencion");
					}
				}

				this.monto_retencion=newmonto_retencion;
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
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_cliente(String newruc_cliente)throws Exception
	{
		try {
			if(this.ruc_cliente!=newruc_cliente) {
				if(newruc_cliente==null) {
					//newruc_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna ruc_cliente");
					}
				}

				if(newruc_cliente!=null&&newruc_cliente.length()>20) {
					newruc_cliente=newruc_cliente.substring(0,18);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc_cliente");
				}

				this.ruc_cliente=newruc_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_cliente(String newtelefono_cliente)throws Exception
	{
		try {
			if(this.telefono_cliente!=newtelefono_cliente) {
				if(newtelefono_cliente==null) {
					//newtelefono_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna telefono_cliente");
					}
				}

				if(newtelefono_cliente!=null&&newtelefono_cliente.length()>100) {
					newtelefono_cliente=newtelefono_cliente.substring(0,98);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono_cliente");
				}

				this.telefono_cliente=newtelefono_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_cliente(String newdireccion_cliente)throws Exception
	{
		try {
			if(this.direccion_cliente!=newdireccion_cliente) {
				if(newdireccion_cliente==null) {
					//newdireccion_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna direccion_cliente");
					}
				}

				if(newdireccion_cliente!=null&&newdireccion_cliente.length()>150) {
					newdireccion_cliente=newdireccion_cliente.substring(0,148);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_cliente");
				}

				this.direccion_cliente=newdireccion_cliente;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("GuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpeso_bruto(Double newpeso_bruto)throws Exception
	{
		try {
			if(this.peso_bruto!=newpeso_bruto) {
				if(newpeso_bruto==null) {
					//newpeso_bruto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GuiaRemision:Valor nulo no permitido en columna peso_bruto");
					}
				}

				this.peso_bruto=newpeso_bruto;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha_autorizacion");
					}
				}

				this.fecha_autorizacion=newfecha_autorizacion;
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
						System.out.println("GuiaRemision:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public Transportista getTransportista() {
		return this.transportista;
	}

	public Consultor getConsultor() {
		return this.consultor;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public SubCliente getSubCliente() {
		return this.subcliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Ciudad getCiudadOrigen() {
		return this.ciudadorigen;
	}

	public Ciudad getCiudadDestino() {
		return this.ciudaddestino;
	}

	public TipoLlamada getTipoLlamada() {
		return this.tipollamada;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
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

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
	}

	public String getconsultor_descripcion() {
		return this.consultor_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String getsubcliente_descripcion() {
		return this.subcliente_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getciudadorigen_descripcion() {
		return this.ciudadorigen_descripcion;
	}

	public String getciudaddestino_descripcion() {
		return this.ciudaddestino_descripcion;
	}

	public String gettipollamada_descripcion() {
		return this.tipollamada_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
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


	public  void  setTransportista(Transportista transportista) {
		try {
			this.transportista=transportista;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConsultor(Consultor consultor) {
		try {
			this.consultor=consultor;
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


	public  void  setSubCliente(SubCliente subcliente) {
		try {
			this.subcliente=subcliente;
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


	public  void  setCiudadOrigen(Ciudad ciudadorigen) {
		try {
			this.ciudadorigen=ciudadorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudadDestino(Ciudad ciudaddestino) {
		try {
			this.ciudaddestino=ciudaddestino;
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


	public  void  setTipoCambio(TipoCambio tipocambio) {
		try {
			this.tipocambio=tipocambio;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
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


	public  void  settransportista_descripcion(String transportista_descripcion) {
		try {
			this.transportista_descripcion=transportista_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconsultor_descripcion(String consultor_descripcion) {
		try {
			this.consultor_descripcion=consultor_descripcion;
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


	public  void  setsubcliente_descripcion(String subcliente_descripcion) {
		try {
			this.subcliente_descripcion=subcliente_descripcion;
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


	public  void  setciudadorigen_descripcion(String ciudadorigen_descripcion) {
		try {
			this.ciudadorigen_descripcion=ciudadorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudaddestino_descripcion(String ciudaddestino_descripcion) {
		try {
			this.ciudaddestino_descripcion=ciudaddestino_descripcion;
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


	public  void  settipocambio_descripcion(String tipocambio_descripcion) {
		try {
			this.tipocambio_descripcion=tipocambio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleGuiaRemision> getDetalleGuiaRemisions() {
		return this.detalleguiaremisions;
	}

	
	
	public  void  setDetalleGuiaRemisions(List<DetalleGuiaRemision> detalleguiaremisions) {
		try {
			this.detalleguiaremisions=detalleguiaremisions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_usuario_descripcion="";String id_formato_descripcion="";String id_tipo_precio_descripcion="";String id_moneda_descripcion="";String id_cliente_descripcion="";String id_vendedor_descripcion="";String id_factura_descripcion="";String id_transportista_descripcion="";String id_consultor_descripcion="";String id_transporte_descripcion="";String id_sub_cliente_descripcion="";String id_empleado_descripcion="";String id_ciudad_origen_descripcion="";String id_ciudad_destino_descripcion="";String id_tipo_llamada_descripcion="";String id_tipo_cambio_descripcion="";
	
	
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
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
	}
	public String getid_consultor_descripcion() {
		return id_consultor_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_sub_cliente_descripcion() {
		return id_sub_cliente_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_ciudad_origen_descripcion() {
		return id_ciudad_origen_descripcion;
	}
	public String getid_ciudad_destino_descripcion() {
		return id_ciudad_destino_descripcion;
	}
	public String getid_tipo_llamada_descripcion() {
		return id_tipo_llamada_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
	}
	public void setid_factura_descripcion(String newid_factura_descripcion) {
		this.id_factura_descripcion=newid_factura_descripcion;
	}
	public void setid_transportista_descripcion(String newid_transportista_descripcion) {
		this.id_transportista_descripcion=newid_transportista_descripcion;
	}
	public void setid_consultor_descripcion(String newid_consultor_descripcion)throws Exception {
		try {
			this.id_consultor_descripcion=newid_consultor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transporte_descripcion(String newid_transporte_descripcion)throws Exception {
		try {
			this.id_transporte_descripcion=newid_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sub_cliente_descripcion(String newid_sub_cliente_descripcion)throws Exception {
		try {
			this.id_sub_cliente_descripcion=newid_sub_cliente_descripcion;
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
	public void setid_ciudad_origen_descripcion(String newid_ciudad_origen_descripcion) {
		this.id_ciudad_origen_descripcion=newid_ciudad_origen_descripcion;
	}
	public void setid_ciudad_destino_descripcion(String newid_ciudad_destino_descripcion) {
		this.id_ciudad_destino_descripcion=newid_ciudad_destino_descripcion;
	}
	public void setid_tipo_llamada_descripcion(String newid_tipo_llamada_descripcion)throws Exception {
		try {
			this.id_tipo_llamada_descripcion=newid_tipo_llamada_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion)throws Exception {
		try {
			this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_usuario_descripcion="";this.id_formato_descripcion="";this.id_tipo_precio_descripcion="";this.id_moneda_descripcion="";this.id_cliente_descripcion="";this.id_vendedor_descripcion="";this.id_factura_descripcion="";this.id_transportista_descripcion="";this.id_consultor_descripcion="";this.id_transporte_descripcion="";this.id_sub_cliente_descripcion="";this.id_empleado_descripcion="";this.id_ciudad_origen_descripcion="";this.id_ciudad_destino_descripcion="";this.id_tipo_llamada_descripcion="";this.id_tipo_cambio_descripcion="";
	}
	
	
	Object movimientoinventariosDescripcionReporte;
	Object detalleguiaremisionsDescripcionReporte;
	
	
	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getdetalleguiaremisionsDescripcionReporte() {
		return detalleguiaremisionsDescripcionReporte;
	}

	
	
	public  void  setmovimientoinventariosDescripcionReporte(Object movimientoinventarios) {
		try {
			this.movimientoinventariosDescripcionReporte=movimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleguiaremisionsDescripcionReporte(Object detalleguiaremisions) {
		try {
			this.detalleguiaremisionsDescripcionReporte=detalleguiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

