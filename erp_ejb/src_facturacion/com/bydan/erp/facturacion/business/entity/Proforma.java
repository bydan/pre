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
//import com.bydan.erp.facturacion.util.ProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class Proforma extends ProformaAdditional implements Serializable ,Cloneable {//ProformaAdditional,GeneralEntity
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
	
	private Proforma proformaOriginal;
	
	private Map<String, Object> mapProforma;
			
	public Map<String, Object> getMapProforma() {
		return mapProforma;
	}

	public void setMapProforma(Map<String, Object> mapProforma) {
		this.mapProforma = mapProforma;
	}
	
	public void inicializarMapProforma() {
		this.mapProforma = new HashMap<String,Object>();
	}
	
	public void setMapProformaValue(String sKey,Object oValue) {
		this.mapProforma.put(sKey, oValue);
	}
	
	public Object getMapProformaValue(String sKey) {
		return this.mapProforma.get(sKey);
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
	private Long id_usuario;
	
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProformaConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=ProformaConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias;
	
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
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProformaConstantesFunciones.SREGEXDIRECCION,message=ProformaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProformaConstantesFunciones.SREGEXRUC,message=ProformaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_oferta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProformaConstantesFunciones.SREGEXTELEFONO,message=ProformaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_vendedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_sub_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ruta_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProformaConstantesFunciones.SREGEXDESCRIPCION,message=ProformaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_con_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double suman;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ultimo_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double subtotal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_cargos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double margen_utilidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double financiamiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double otros_valores;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_servidor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_fin;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_consignatario;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_cambio;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Moneda moneda;
	public Empleado empleado;
	public Formato formato;
	public EstadoProforma estadoproforma;
	public Cliente cliente;
	public TipoPrecio tipoprecio;
	public Vendedor vendedor;
	public SubCliente subcliente;
	public TipoViaTransporte tipoviatransporte;
	public Transporte transporte;
	public RutaTransporte rutatransporte;
	public CentroCosto centrocosto;
	public TipoProforma tipoproforma;
	public Consignatario consignatario;
	public TipoCambio tipocambio;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String moneda_descripcion;
	private String empleado_descripcion;
	private String formato_descripcion;
	private String estadoproforma_descripcion;
	private String cliente_descripcion;
	private String tipoprecio_descripcion;
	private String vendedor_descripcion;
	private String subcliente_descripcion;
	private String tipoviatransporte_descripcion;
	private String transporte_descripcion;
	private String rutatransporte_descripcion;
	private String centrocosto_descripcion;
	private String tipoproforma_descripcion;
	private String consignatario_descripcion;
	private String tipocambio_descripcion;
	
	
	public List<TerminoProforma> terminoproformas;
	public List<DetalleProforma> detalleproformas;
		
	public Proforma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.proformaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.numero_pre_impreso="";
 		this.fecha_emision=new Date();
 		this.dias=0;
 		this.fecha_vencimiento=new Date();
 		this.id_moneda=-1L;
 		this.cotizacion=0.0;
 		this.id_empleado=-1L;
 		this.id_formato=null;
 		this.id_estado_proforma=-1L;
 		this.direccion="";
 		this.id_cliente=-1L;
 		this.ruc="";
 		this.es_oferta=false;
 		this.telefono="";
 		this.id_tipo_precio=-1L;
 		this.id_vendedor=null;
 		this.id_sub_cliente=null;
 		this.id_tipo_via_transporte=-1L;
 		this.id_transporte=-1L;
 		this.id_ruta_transporte=-1L;
 		this.descripcion="";
 		this.descuento_porcentaje=0.0;
 		this.monto_con_iva=0.0;
 		this.suman=0.0;
 		this.descuento_valor=0.0;
 		this.monto_sin_iva=0.0;
 		this.descuento_general=0.0;
 		this.flete=0.0;
 		this.ultimo_costo=0.0;
 		this.subtotal=0.0;
 		this.otros_cargos=0.0;
 		this.margen_utilidad=0.0;
 		this.iva=0.0;
 		this.financiamiento=0.0;
 		this.total=0.0;
 		this.otros_valores=0.0;
 		this.anticipo=0.0;
 		this.ice=0.0;
 		this.monto_retencion=0.0;
 		this.fecha=new Date();
 		this.fecha_servidor=new Date();
 		this.hora_inicio=new Time((new Date()).getTime());
 		this.hora_fin=new Time((new Date()).getTime());
 		this.id_centro_costo=null;
 		this.id_tipo_proforma=-1L;
 		this.id_consignatario=-1L;
 		this.id_tipo_cambio=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.moneda=null;
		this.empleado=null;
		this.formato=null;
		this.estadoproforma=null;
		this.cliente=null;
		this.tipoprecio=null;
		this.vendedor=null;
		this.subcliente=null;
		this.tipoviatransporte=null;
		this.transporte=null;
		this.rutatransporte=null;
		this.centrocosto=null;
		this.tipoproforma=null;
		this.consignatario=null;
		this.tipocambio=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.moneda_descripcion="";
		this.empleado_descripcion="";
		this.formato_descripcion="";
		this.estadoproforma_descripcion="";
		this.cliente_descripcion="";
		this.tipoprecio_descripcion="";
		this.vendedor_descripcion="";
		this.subcliente_descripcion="";
		this.tipoviatransporte_descripcion="";
		this.transporte_descripcion="";
		this.rutatransporte_descripcion="";
		this.centrocosto_descripcion="";
		this.tipoproforma_descripcion="";
		this.consignatario_descripcion="";
		this.tipocambio_descripcion="";
		
		
		this.terminoproformas=null;
		this.detalleproformas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Proforma (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,String numero_pre_impreso,Date fecha_emision,Integer dias,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_formato,Long id_estado_proforma,String direccion,Long id_cliente,String ruc,Boolean es_oferta,String telefono,Long id_tipo_precio,Long id_vendedor,Long id_sub_cliente,Long id_tipo_via_transporte,Long id_transporte,Long id_ruta_transporte,String descripcion,Double descuento_porcentaje,Double monto_con_iva,Double suman,Double descuento_valor,Double monto_sin_iva,Double descuento_general,Double flete,Double ultimo_costo,Double subtotal,Double otros_cargos,Double margen_utilidad,Double iva,Double financiamiento,Double total,Double otros_valores,Double anticipo,Double ice,Double monto_retencion,Date fecha,Date fecha_servidor,Time hora_inicio,Time hora_fin,Long id_centro_costo,Long id_tipo_proforma,Long id_consignatario,Long id_tipo_cambio) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.proformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.dias=dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.id_estado_proforma=id_estado_proforma;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.ruc=ruc;
 		this.es_oferta=es_oferta;
 		this.telefono=telefono;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_vendedor=id_vendedor;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_transporte=id_transporte;
 		this.id_ruta_transporte=id_ruta_transporte;
 		this.descripcion=descripcion;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.monto_con_iva=monto_con_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.monto_sin_iva=monto_sin_iva;
 		this.descuento_general=descuento_general;
 		this.flete=flete;
 		this.ultimo_costo=ultimo_costo;
 		this.subtotal=subtotal;
 		this.otros_cargos=otros_cargos;
 		this.margen_utilidad=margen_utilidad;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.total=total;
 		this.otros_valores=otros_valores;
 		this.anticipo=anticipo;
 		this.ice=ice;
 		this.monto_retencion=monto_retencion;
 		this.fecha=fecha;
 		this.fecha_servidor=fecha_servidor;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_centro_costo=id_centro_costo;
 		this.id_tipo_proforma=id_tipo_proforma;
 		this.id_consignatario=id_consignatario;
 		this.id_tipo_cambio=id_tipo_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Proforma (Long id_empresa,Long id_sucursal,Long id_usuario,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,String numero_pre_impreso,Date fecha_emision,Integer dias,Date fecha_vencimiento,Long id_moneda,Double cotizacion,Long id_empleado,Long id_formato,Long id_estado_proforma,String direccion,Long id_cliente,String ruc,Boolean es_oferta,String telefono,Long id_tipo_precio,Long id_vendedor,Long id_sub_cliente,Long id_tipo_via_transporte,Long id_transporte,Long id_ruta_transporte,String descripcion,Double descuento_porcentaje,Double monto_con_iva,Double suman,Double descuento_valor,Double monto_sin_iva,Double descuento_general,Double flete,Double ultimo_costo,Double subtotal,Double otros_cargos,Double margen_utilidad,Double iva,Double financiamiento,Double total,Double otros_valores,Double anticipo,Double ice,Double monto_retencion,Date fecha,Date fecha_servidor,Time hora_inicio,Time hora_fin,Long id_centro_costo,Long id_tipo_proforma,Long id_consignatario,Long id_tipo_cambio) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.proformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.dias=dias;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.id_moneda=id_moneda;
 		this.cotizacion=cotizacion;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.id_estado_proforma=id_estado_proforma;
 		this.direccion=direccion;
 		this.id_cliente=id_cliente;
 		this.ruc=ruc;
 		this.es_oferta=es_oferta;
 		this.telefono=telefono;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_vendedor=id_vendedor;
 		this.id_sub_cliente=id_sub_cliente;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_transporte=id_transporte;
 		this.id_ruta_transporte=id_ruta_transporte;
 		this.descripcion=descripcion;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.monto_con_iva=monto_con_iva;
 		this.suman=suman;
 		this.descuento_valor=descuento_valor;
 		this.monto_sin_iva=monto_sin_iva;
 		this.descuento_general=descuento_general;
 		this.flete=flete;
 		this.ultimo_costo=ultimo_costo;
 		this.subtotal=subtotal;
 		this.otros_cargos=otros_cargos;
 		this.margen_utilidad=margen_utilidad;
 		this.iva=iva;
 		this.financiamiento=financiamiento;
 		this.total=total;
 		this.otros_valores=otros_valores;
 		this.anticipo=anticipo;
 		this.ice=ice;
 		this.monto_retencion=monto_retencion;
 		this.fecha=fecha;
 		this.fecha_servidor=fecha_servidor;
 		this.hora_inicio=hora_inicio;
 		this.hora_fin=hora_fin;
 		this.id_centro_costo=id_centro_costo;
 		this.id_tipo_proforma=id_tipo_proforma;
 		this.id_consignatario=id_consignatario;
 		this.id_tipo_cambio=id_tipo_cambio;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Proforma proformaLocal=null;
		
		if(object!=null) {
			proformaLocal=(Proforma)object;
			
			if(proformaLocal!=null) {
				if(this.getId()!=null && proformaLocal.getId()!=null) {
					if(this.getId().equals(proformaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProformaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProformaConstantesFunciones.getProformaDescripcion(this);
		} else {
			sDetalle=ProformaConstantesFunciones.getProformaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Proforma getProformaOriginal() {
		return this.proformaOriginal;
	}
	
	public void setProformaOriginal(Proforma proforma) {
		try {
			this.proformaOriginal=proforma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProformaAdditional proformaAdditional=null;
	
	public ProformaAdditional getProformaAdditional() {
		return this.proformaAdditional;
	}
	
	public void setProformaAdditional(ProformaAdditional proformaAdditional) {
		try {
			this.proformaAdditional=proformaAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
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
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Integer getdias() {
		return this.dias;
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
    
	
	public Long getid_estado_proforma() {
		return this.id_estado_proforma;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Boolean getes_oferta() {
		return this.es_oferta;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_sub_cliente() {
		return this.id_sub_cliente;
	}
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Long getid_ruta_transporte() {
		return this.id_ruta_transporte;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getdescuento_porcentaje() {
		return this.descuento_porcentaje;
	}
    
	
	public Double getmonto_con_iva() {
		return this.monto_con_iva;
	}
    
	
	public Double getsuman() {
		return this.suman;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public Double getmonto_sin_iva() {
		return this.monto_sin_iva;
	}
    
	
	public Double getdescuento_general() {
		return this.descuento_general;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getultimo_costo() {
		return this.ultimo_costo;
	}
    
	
	public Double getsubtotal() {
		return this.subtotal;
	}
    
	
	public Double getotros_cargos() {
		return this.otros_cargos;
	}
    
	
	public Double getmargen_utilidad() {
		return this.margen_utilidad;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getfinanciamiento() {
		return this.financiamiento;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getotros_valores() {
		return this.otros_valores;
	}
    
	
	public Double getanticipo() {
		return this.anticipo;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getmonto_retencion() {
		return this.monto_retencion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_servidor() {
		return this.fecha_servidor;
	}
    
	
	public Time gethora_inicio() {
		return this.hora_inicio;
	}
    
	
	public Time gethora_fin() {
		return this.hora_fin;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_tipo_proforma() {
		return this.id_tipo_proforma;
	}
    
	
	public Long getid_consignatario() {
		return this.id_consignatario;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_periodo");
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
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("Proforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
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
						System.out.println("Proforma:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias(Integer newdias)throws Exception
	{
		try {
			if(this.dias!=newdias) {
				if(newdias==null) {
					//newdias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna dias");
					}
				}

				this.dias=newdias;
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
						System.out.println("Proforma:Valor nulo no permitido en columna fecha_vencimiento");
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_moneda");
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
						System.out.println("Proforma:Valor nulo no permitido en columna cotizacion");
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
    
	public void setid_estado_proforma(Long newid_estado_proforma)throws Exception
	{
		try {
			if(this.id_estado_proforma!=newid_estado_proforma) {
				if(newid_estado_proforma==null) {
					//newid_estado_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_estado_proforma");
					}
				}

				this.id_estado_proforma=newid_estado_proforma;
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
						System.out.println("Proforma:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Proforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("Proforma:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("Proforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_oferta(Boolean newes_oferta)throws Exception
	{
		try {
			if(this.es_oferta!=newes_oferta) {
				if(newes_oferta==null) {
					//newes_oferta=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna es_oferta");
					}
				}

				this.es_oferta=newes_oferta;
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
						System.out.println("Proforma:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Proforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
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
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
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
						System.out.println("Proforma:Valor nulo no permitido en columna id_transporte");
					}
				}

				this.id_transporte=newid_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ruta_transporte(Long newid_ruta_transporte)throws Exception
	{
		try {
			if(this.id_ruta_transporte!=newid_ruta_transporte) {
				if(newid_ruta_transporte==null) {
					//newid_ruta_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_ruta_transporte");
					}
				}

				this.id_ruta_transporte=newid_ruta_transporte;
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
						System.out.println("Proforma:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Proforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("Proforma:Valor nulo no permitido en columna descuento_porcentaje");
					}
				}

				this.descuento_porcentaje=newdescuento_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_con_iva(Double newmonto_con_iva)throws Exception
	{
		try {
			if(this.monto_con_iva!=newmonto_con_iva) {
				if(newmonto_con_iva==null) {
					//newmonto_con_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna monto_con_iva");
					}
				}

				this.monto_con_iva=newmonto_con_iva;
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
						System.out.println("Proforma:Valor nulo no permitido en columna suman");
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
						System.out.println("Proforma:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_sin_iva(Double newmonto_sin_iva)throws Exception
	{
		try {
			if(this.monto_sin_iva!=newmonto_sin_iva) {
				if(newmonto_sin_iva==null) {
					//newmonto_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna monto_sin_iva");
					}
				}

				this.monto_sin_iva=newmonto_sin_iva;
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
						System.out.println("Proforma:Valor nulo no permitido en columna descuento_general");
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
						System.out.println("Proforma:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
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
						System.out.println("Proforma:Valor nulo no permitido en columna ultimo_costo");
					}
				}

				this.ultimo_costo=newultimo_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsubtotal(Double newsubtotal)throws Exception
	{
		try {
			if(this.subtotal!=newsubtotal) {
				if(newsubtotal==null) {
					//newsubtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna subtotal");
					}
				}

				this.subtotal=newsubtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setotros_cargos(Double newotros_cargos)throws Exception
	{
		try {
			if(this.otros_cargos!=newotros_cargos) {
				if(newotros_cargos==null) {
					//newotros_cargos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna otros_cargos");
					}
				}

				this.otros_cargos=newotros_cargos;
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
						System.out.println("Proforma:Valor nulo no permitido en columna margen_utilidad");
					}
				}

				this.margen_utilidad=newmargen_utilidad;
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
						System.out.println("Proforma:Valor nulo no permitido en columna iva");
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
						System.out.println("Proforma:Valor nulo no permitido en columna financiamiento");
					}
				}

				this.financiamiento=newfinanciamiento;
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
						System.out.println("Proforma:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("Proforma:Valor nulo no permitido en columna otros_valores");
					}
				}

				this.otros_valores=newotros_valores;
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
						System.out.println("Proforma:Valor nulo no permitido en columna anticipo");
					}
				}

				this.anticipo=newanticipo;
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
						System.out.println("Proforma:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("Proforma:Valor nulo no permitido en columna monto_retencion");
					}
				}

				this.monto_retencion=newmonto_retencion;
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
						System.out.println("Proforma:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_servidor(Date newfecha_servidor)throws Exception
	{
		try {
			if(this.fecha_servidor!=newfecha_servidor) {
				if(newfecha_servidor==null) {
					//newfecha_servidor=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna fecha_servidor");
					}
				}

				this.fecha_servidor=newfecha_servidor;
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
						System.out.println("Proforma:Valor nulo no permitido en columna hora_inicio");
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
						System.out.println("Proforma:Valor nulo no permitido en columna hora_fin");
					}
				}

				this.hora_fin=newhora_fin;
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
    
	public void setid_tipo_proforma(Long newid_tipo_proforma)throws Exception
	{
		try {
			if(this.id_tipo_proforma!=newid_tipo_proforma) {
				if(newid_tipo_proforma==null) {
					//newid_tipo_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_tipo_proforma");
					}
				}

				this.id_tipo_proforma=newid_tipo_proforma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_consignatario(Long newid_consignatario)throws Exception
	{
		try {
			if(this.id_consignatario!=newid_consignatario) {
				if(newid_consignatario==null) {
					//newid_consignatario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Proforma:Valor nulo no permitido en columna id_consignatario");
					}
				}

				this.id_consignatario=newid_consignatario;
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
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Usuario getUsuario() {
		return this.usuario;
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

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public EstadoProforma getEstadoProforma() {
		return this.estadoproforma;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public SubCliente getSubCliente() {
		return this.subcliente;
	}

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public RutaTransporte getRutaTransporte() {
		return this.rutatransporte;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public TipoProforma getTipoProforma() {
		return this.tipoproforma;
	}

	public Consignatario getConsignatario() {
		return this.consignatario;
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

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
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

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getestadoproforma_descripcion() {
		return this.estadoproforma_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getsubcliente_descripcion() {
		return this.subcliente_descripcion;
	}

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String getrutatransporte_descripcion() {
		return this.rutatransporte_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String gettipoproforma_descripcion() {
		return this.tipoproforma_descripcion;
	}

	public String getconsignatario_descripcion() {
		return this.consignatario_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setEstadoProforma(EstadoProforma estadoproforma) {
		try {
			this.estadoproforma=estadoproforma;
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


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
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


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
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


	public  void  setRutaTransporte(RutaTransporte rutatransporte) {
		try {
			this.rutatransporte=rutatransporte;
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


	public  void  setTipoProforma(TipoProforma tipoproforma) {
		try {
			this.tipoproforma=tipoproforma;
		} catch(Exception e) {
			;
		}
	}


	public  void  setConsignatario(Consignatario consignatario) {
		try {
			this.consignatario=consignatario;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setestadoproforma_descripcion(String estadoproforma_descripcion) {
		try {
			this.estadoproforma_descripcion=estadoproforma_descripcion;
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


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
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


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
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


	public  void  setrutatransporte_descripcion(String rutatransporte_descripcion) {
		try {
			this.rutatransporte_descripcion=rutatransporte_descripcion;
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


	public  void  settipoproforma_descripcion(String tipoproforma_descripcion) {
		try {
			this.tipoproforma_descripcion=tipoproforma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setconsignatario_descripcion(String consignatario_descripcion) {
		try {
			this.consignatario_descripcion=consignatario_descripcion;
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


	
	
	public List<TerminoProforma> getTerminoProformas() {
		return this.terminoproformas;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleproformas;
	}

	
	
	public  void  setTerminoProformas(List<TerminoProforma> terminoproformas) {
		try {
			this.terminoproformas=terminoproformas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleProformas(List<DetalleProforma> detalleproformas) {
		try {
			this.detalleproformas=detalleproformas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_moneda_descripcion="";String id_empleado_descripcion="";String id_formato_descripcion="";String id_estado_proforma_descripcion="";String id_cliente_descripcion="";String es_oferta_descripcion="";String id_tipo_precio_descripcion="";String id_vendedor_descripcion="";String id_sub_cliente_descripcion="";String id_tipo_via_transporte_descripcion="";String id_transporte_descripcion="";String id_ruta_transporte_descripcion="";String id_centro_costo_descripcion="";String id_tipo_proforma_descripcion="";String id_consignatario_descripcion="";String id_tipo_cambio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
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
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_estado_proforma_descripcion() {
		return id_estado_proforma_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_oferta_descripcion() {
		return es_oferta_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_sub_cliente_descripcion() {
		return id_sub_cliente_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_ruta_transporte_descripcion() {
		return id_ruta_transporte_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_tipo_proforma_descripcion() {
		return id_tipo_proforma_descripcion;
	}
	public String getid_consignatario_descripcion() {
		return id_consignatario_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_estado_proforma_descripcion(String newid_estado_proforma_descripcion)throws Exception {
		try {
			this.id_estado_proforma_descripcion=newid_estado_proforma_descripcion;
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
	public void setes_oferta_descripcion(String newes_oferta_descripcion)throws Exception {
		try {
			this.es_oferta_descripcion=newes_oferta_descripcion;
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
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
	}
	public void setid_sub_cliente_descripcion(String newid_sub_cliente_descripcion) {
		this.id_sub_cliente_descripcion=newid_sub_cliente_descripcion;
	}
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
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
	public void setid_ruta_transporte_descripcion(String newid_ruta_transporte_descripcion)throws Exception {
		try {
			this.id_ruta_transporte_descripcion=newid_ruta_transporte_descripcion;
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
	public void setid_tipo_proforma_descripcion(String newid_tipo_proforma_descripcion)throws Exception {
		try {
			this.id_tipo_proforma_descripcion=newid_tipo_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_consignatario_descripcion(String newid_consignatario_descripcion)throws Exception {
		try {
			this.id_consignatario_descripcion=newid_consignatario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion) {
		this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_moneda_descripcion="";this.id_empleado_descripcion="";this.id_formato_descripcion="";this.id_estado_proforma_descripcion="";this.id_cliente_descripcion="";this.es_oferta_descripcion="";this.id_tipo_precio_descripcion="";this.id_vendedor_descripcion="";this.id_sub_cliente_descripcion="";this.id_tipo_via_transporte_descripcion="";this.id_transporte_descripcion="";this.id_ruta_transporte_descripcion="";this.id_centro_costo_descripcion="";this.id_tipo_proforma_descripcion="";this.id_consignatario_descripcion="";this.id_tipo_cambio_descripcion="";
	}
	
	
	Object terminoproformasDescripcionReporte;
	Object detalleproformasDescripcionReporte;
	
	
	public Object getterminoproformasDescripcionReporte() {
		return terminoproformasDescripcionReporte;
	}

	public Object getdetalleproformasDescripcionReporte() {
		return detalleproformasDescripcionReporte;
	}

	
	
	public  void  setterminoproformasDescripcionReporte(Object terminoproformas) {
		try {
			this.terminoproformasDescripcionReporte=terminoproformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleproformasDescripcionReporte(Object detalleproformas) {
		try {
			this.detalleproformasDescripcionReporte=detalleproformas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

