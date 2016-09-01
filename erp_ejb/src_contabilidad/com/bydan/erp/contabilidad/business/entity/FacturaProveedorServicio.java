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
//import com.bydan.erp.contabilidad.util.FacturaProveedorServicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class FacturaProveedorServicio extends FacturaProveedorServicioAdditional implements Serializable ,Cloneable {//FacturaProveedorServicioAdditional,GeneralEntity
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
	
	private FacturaProveedorServicio facturaproveedorservicioOriginal;
	
	private Map<String, Object> mapFacturaProveedorServicio;
			
	public Map<String, Object> getMapFacturaProveedorServicio() {
		return mapFacturaProveedorServicio;
	}

	public void setMapFacturaProveedorServicio(Map<String, Object> mapFacturaProveedorServicio) {
		this.mapFacturaProveedorServicio = mapFacturaProveedorServicio;
	}
	
	public void inicializarMapFacturaProveedorServicio() {
		this.mapFacturaProveedorServicio = new HashMap<String,Object>();
	}
	
	public void setMapFacturaProveedorServicioValue(String sKey,Object oValue) {
		this.mapFacturaProveedorServicio.put(sKey, oValue);
	}
	
	public Object getMapFacturaProveedorServicioValue(String sKey) {
		return this.mapFacturaProveedorServicio.get(sKey);
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
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXNUMERO_FACTURA,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXRUC,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer plazo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_rise;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado_solicita;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXDETALLE,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXDETALLE)
	private String detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXNUMERO_RETENCION,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXNUMERO_SERIE,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_tributario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_validez;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXANEXO_FACTURA_INICIO,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXANEXO_FACTURA_INICIO)
	private String anexo_factura_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXANEXO_FACTURA_FIN,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXANEXO_FACTURA_FIN)
	private String anexo_factura_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_servicios0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXNUMERO_MAYOR,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXNUMERO_MAYOR)
	private String numero_mayor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXCODIGO_ASIENTO,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO)
	private String codigo_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_fuente1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXANEXO_NUMERO_AUTORIZACION,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXANEXO_NUMERO_AUTORIZACION)
	private String anexo_numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXANEXO_NUMESO_SERIE,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXANEXO_NUMESO_SERIE)
	private String anexo_numeso_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date anexo_fecha_validez;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito_fiscal_servicios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FacturaProveedorServicioConstantesFunciones.SREGEXDESCRIPCION,message=FacturaProveedorServicioConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Modulo modulo;
	public Transaccion transaccion;
	public Factura factura;
	public Cliente cliente;
	public TipoDocumento tipodocumento;
	public Empleado empleadosolicita;
	public Empleado empleado;
	public TipoTributario tipotributario;
	public Moneda moneda;
	public TipoRetencion tiporetencionfuente1;
	public TipoRetencion tiporetencioniva1;
	public CuentaContable cuentacontablecreditofiscalservicios;
	public TipoMovimiento tipomovimiento;
	public TipoMovimientoModulo tipomovimientomodulo;
	public TipoTransaccionModulo tipotransaccionmodulo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String modulo_descripcion;
	private String transaccion_descripcion;
	private String factura_descripcion;
	private String cliente_descripcion;
	private String tipodocumento_descripcion;
	private String empleadosolicita_descripcion;
	private String empleado_descripcion;
	private String tipotributario_descripcion;
	private String moneda_descripcion;
	private String tiporetencionfuente1_descripcion;
	private String tiporetencioniva1_descripcion;
	private String cuentacontablecreditofiscalservicios_descripcion;
	private String tipomovimiento_descripcion;
	private String tipomovimientomodulo_descripcion;
	private String tipotransaccionmodulo_descripcion;
	
	
		
	public FacturaProveedorServicio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.facturaproveedorservicioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_modulo=-1L;
 		this.id_transaccion=-1L;
 		this.id_factura=null;
 		this.numero_factura="";
 		this.id_cliente=-1L;
 		this.ruc="";
 		this.id_tipo_documento=-1L;
 		this.plazo=0;
 		this.con_rise=false;
 		this.fecha_emision=new Date();
 		this.fecha_vence=new Date();
 		this.id_empleado_solicita=-1L;
 		this.id_empleado=null;
 		this.detalle="";
 		this.numero_retencion="";
 		this.numero_autorizacion="";
 		this.numero_serie="";
 		this.id_tipo_tributario=null;
 		this.fecha_validez=new Date();
 		this.anexo_factura_inicio="";
 		this.anexo_factura_fin="";
 		this.id_moneda=-1L;
 		this.valor_servicios0=0.0;
 		this.total_iva=0.0;
 		this.iva_porcentaje=0.0;
 		this.total=0.0;
 		this.numero_mayor="";
 		this.codigo_asiento="";
 		this.id_tipo_retencion_fuente1=-1L;
 		this.id_tipo_retencion_iva1=-1L;
 		this.anexo_numero_autorizacion="";
 		this.anexo_numeso_serie="";
 		this.anexo_fecha_validez=new Date();
 		this.id_cuenta_contable_credito_fiscal_servicios=-1L;
 		this.descripcion="";
 		this.id_tipo_movimiento=null;
 		this.id_tipo_movimiento_modulo=null;
 		this.id_tipo_transaccion_modulo=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.modulo=null;
		this.transaccion=null;
		this.factura=null;
		this.cliente=null;
		this.tipodocumento=null;
		this.empleadosolicita=null;
		this.empleado=null;
		this.tipotributario=null;
		this.moneda=null;
		this.tiporetencionfuente1=null;
		this.tiporetencioniva1=null;
		this.cuentacontablecreditofiscalservicios=null;
		this.tipomovimiento=null;
		this.tipomovimientomodulo=null;
		this.tipotransaccionmodulo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.modulo_descripcion="";
		this.transaccion_descripcion="";
		this.factura_descripcion="";
		this.cliente_descripcion="";
		this.tipodocumento_descripcion="";
		this.empleadosolicita_descripcion="";
		this.empleado_descripcion="";
		this.tipotributario_descripcion="";
		this.moneda_descripcion="";
		this.tiporetencionfuente1_descripcion="";
		this.tiporetencioniva1_descripcion="";
		this.cuentacontablecreditofiscalservicios_descripcion="";
		this.tipomovimiento_descripcion="";
		this.tipomovimientomodulo_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FacturaProveedorServicio (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_transaccion,Long id_factura,String numero_factura,Long id_cliente,String ruc,Long id_tipo_documento,Integer plazo,Boolean con_rise,Date fecha_emision,Date fecha_vence,Long id_empleado_solicita,Long id_empleado,String detalle,String numero_retencion,String numero_autorizacion,String numero_serie,Long id_tipo_tributario,Date fecha_validez,String anexo_factura_inicio,String anexo_factura_fin,Long id_moneda,Double valor_servicios0,Double total_iva,Double iva_porcentaje,Double total,String numero_mayor,String codigo_asiento,Long id_tipo_retencion_fuente1,Long id_tipo_retencion_iva1,String anexo_numero_autorizacion,String anexo_numeso_serie,Date anexo_fecha_validez,Long id_cuenta_contable_credito_fiscal_servicios,String descripcion,Long id_tipo_movimiento,Long id_tipo_movimiento_modulo,Long id_tipo_transaccion_modulo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturaproveedorservicioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_transaccion=id_transaccion;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.id_cliente=id_cliente;
 		this.ruc=ruc;
 		this.id_tipo_documento=id_tipo_documento;
 		this.plazo=plazo;
 		this.con_rise=con_rise;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vence=fecha_vence;
 		this.id_empleado_solicita=id_empleado_solicita;
 		this.id_empleado=id_empleado;
 		this.detalle=detalle;
 		this.numero_retencion=numero_retencion;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_serie=numero_serie;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.fecha_validez=fecha_validez;
 		this.anexo_factura_inicio=anexo_factura_inicio;
 		this.anexo_factura_fin=anexo_factura_fin;
 		this.id_moneda=id_moneda;
 		this.valor_servicios0=valor_servicios0;
 		this.total_iva=total_iva;
 		this.iva_porcentaje=iva_porcentaje;
 		this.total=total;
 		this.numero_mayor=numero_mayor;
 		this.codigo_asiento=codigo_asiento;
 		this.id_tipo_retencion_fuente1=id_tipo_retencion_fuente1;
 		this.id_tipo_retencion_iva1=id_tipo_retencion_iva1;
 		this.anexo_numero_autorizacion=anexo_numero_autorizacion;
 		this.anexo_numeso_serie=anexo_numeso_serie;
 		this.anexo_fecha_validez=anexo_fecha_validez;
 		this.id_cuenta_contable_credito_fiscal_servicios=id_cuenta_contable_credito_fiscal_servicios;
 		this.descripcion=descripcion;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FacturaProveedorServicio (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_modulo,Long id_transaccion,Long id_factura,String numero_factura,Long id_cliente,String ruc,Long id_tipo_documento,Integer plazo,Boolean con_rise,Date fecha_emision,Date fecha_vence,Long id_empleado_solicita,Long id_empleado,String detalle,String numero_retencion,String numero_autorizacion,String numero_serie,Long id_tipo_tributario,Date fecha_validez,String anexo_factura_inicio,String anexo_factura_fin,Long id_moneda,Double valor_servicios0,Double total_iva,Double iva_porcentaje,Double total,String numero_mayor,String codigo_asiento,Long id_tipo_retencion_fuente1,Long id_tipo_retencion_iva1,String anexo_numero_autorizacion,String anexo_numeso_serie,Date anexo_fecha_validez,Long id_cuenta_contable_credito_fiscal_servicios,String descripcion,Long id_tipo_movimiento,Long id_tipo_movimiento_modulo,Long id_tipo_transaccion_modulo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.facturaproveedorservicioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_modulo=id_modulo;
 		this.id_transaccion=id_transaccion;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.id_cliente=id_cliente;
 		this.ruc=ruc;
 		this.id_tipo_documento=id_tipo_documento;
 		this.plazo=plazo;
 		this.con_rise=con_rise;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vence=fecha_vence;
 		this.id_empleado_solicita=id_empleado_solicita;
 		this.id_empleado=id_empleado;
 		this.detalle=detalle;
 		this.numero_retencion=numero_retencion;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_serie=numero_serie;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.fecha_validez=fecha_validez;
 		this.anexo_factura_inicio=anexo_factura_inicio;
 		this.anexo_factura_fin=anexo_factura_fin;
 		this.id_moneda=id_moneda;
 		this.valor_servicios0=valor_servicios0;
 		this.total_iva=total_iva;
 		this.iva_porcentaje=iva_porcentaje;
 		this.total=total;
 		this.numero_mayor=numero_mayor;
 		this.codigo_asiento=codigo_asiento;
 		this.id_tipo_retencion_fuente1=id_tipo_retencion_fuente1;
 		this.id_tipo_retencion_iva1=id_tipo_retencion_iva1;
 		this.anexo_numero_autorizacion=anexo_numero_autorizacion;
 		this.anexo_numeso_serie=anexo_numeso_serie;
 		this.anexo_fecha_validez=anexo_fecha_validez;
 		this.id_cuenta_contable_credito_fiscal_servicios=id_cuenta_contable_credito_fiscal_servicios;
 		this.descripcion=descripcion;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.id_tipo_movimiento_modulo=id_tipo_movimiento_modulo;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FacturaProveedorServicio facturaproveedorservicioLocal=null;
		
		if(object!=null) {
			facturaproveedorservicioLocal=(FacturaProveedorServicio)object;
			
			if(facturaproveedorservicioLocal!=null) {
				if(this.getId()!=null && facturaproveedorservicioLocal.getId()!=null) {
					if(this.getId().equals(facturaproveedorservicioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FacturaProveedorServicioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FacturaProveedorServicioConstantesFunciones.getFacturaProveedorServicioDescripcion(this);
		} else {
			sDetalle=FacturaProveedorServicioConstantesFunciones.getFacturaProveedorServicioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FacturaProveedorServicio getFacturaProveedorServicioOriginal() {
		return this.facturaproveedorservicioOriginal;
	}
	
	public void setFacturaProveedorServicioOriginal(FacturaProveedorServicio facturaproveedorservicio) {
		try {
			this.facturaproveedorservicioOriginal=facturaproveedorservicio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FacturaProveedorServicioAdditional facturaproveedorservicioAdditional=null;
	
	public FacturaProveedorServicioAdditional getFacturaProveedorServicioAdditional() {
		return this.facturaproveedorservicioAdditional;
	}
	
	public void setFacturaProveedorServicioAdditional(FacturaProveedorServicioAdditional facturaproveedorservicioAdditional) {
		try {
			this.facturaproveedorservicioAdditional=facturaproveedorservicioAdditional;
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
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Integer getplazo() {
		return this.plazo;
	}
    
	
	public Boolean getcon_rise() {
		return this.con_rise;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vence() {
		return this.fecha_vence;
	}
    
	
	public Long getid_empleado_solicita() {
		return this.id_empleado_solicita;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public String getdetalle() {
		return this.detalle;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public Long getid_tipo_tributario() {
		return this.id_tipo_tributario;
	}
    
	
	public Date getfecha_validez() {
		return this.fecha_validez;
	}
    
	
	public String getanexo_factura_inicio() {
		return this.anexo_factura_inicio;
	}
    
	
	public String getanexo_factura_fin() {
		return this.anexo_factura_fin;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Double getvalor_servicios0() {
		return this.valor_servicios0;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double getiva_porcentaje() {
		return this.iva_porcentaje;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String getnumero_mayor() {
		return this.numero_mayor;
	}
    
	
	public String getcodigo_asiento() {
		return this.codigo_asiento;
	}
    
	
	public Long getid_tipo_retencion_fuente1() {
		return this.id_tipo_retencion_fuente1;
	}
    
	
	public Long getid_tipo_retencion_iva1() {
		return this.id_tipo_retencion_iva1;
	}
    
	
	public String getanexo_numero_autorizacion() {
		return this.anexo_numero_autorizacion;
	}
    
	
	public String getanexo_numeso_serie() {
		return this.anexo_numeso_serie;
	}
    
	
	public Date getanexo_fecha_validez() {
		return this.anexo_fecha_validez;
	}
    
	
	public Long getid_cuenta_contable_credito_fiscal_servicios() {
		return this.id_cuenta_contable_credito_fiscal_servicios;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public Long getid_tipo_movimiento_modulo() {
		return this.id_tipo_movimiento_modulo;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_periodo");
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
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_cliente");
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplazo(Integer newplazo)throws Exception
	{
		try {
			if(this.plazo!=newplazo) {
				if(newplazo==null) {
					//newplazo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna plazo");
					}
				}

				this.plazo=newplazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_rise(Boolean newcon_rise)throws Exception
	{
		try {
			if(this.con_rise!=newcon_rise) {
				if(newcon_rise==null) {
					//newcon_rise=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna con_rise");
					}
				}

				this.con_rise=newcon_rise;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence(Date newfecha_vence)throws Exception
	{
		try {
			if(this.fecha_vence!=newfecha_vence) {
				if(newfecha_vence==null) {
					//newfecha_vence=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna fecha_vence");
					}
				}

				this.fecha_vence=newfecha_vence;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_solicita(Long newid_empleado_solicita)throws Exception
	{
		try {
			if(this.id_empleado_solicita!=newid_empleado_solicita) {
				if(newid_empleado_solicita==null) {
					//newid_empleado_solicita=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_empleado_solicita");
					}
				}

				this.id_empleado_solicita=newid_empleado_solicita;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado) {
		if(this.id_empleado==null&&newid_empleado!=null) {
			this.id_empleado=newid_empleado;
				this.setIsChanged(true);
		}

		if(this.id_empleado!=null&&!this.id_empleado.equals(newid_empleado)) {

			this.id_empleado=newid_empleado;
				this.setIsChanged(true);
		}
	}
    
	public void setdetalle(String newdetalle)throws Exception
	{
		try {
			if(this.detalle!=newdetalle) {
				if(newdetalle==null) {
					//newdetalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna detalle");
					}
				}

				if(newdetalle!=null&&newdetalle.length()>150) {
					newdetalle=newdetalle.substring(0,148);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna detalle");
				}

				this.detalle=newdetalle;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion(String newnumero_autorizacion)throws Exception
	{
		try {
			if(this.numero_autorizacion!=newnumero_autorizacion) {
				if(newnumero_autorizacion==null) {
					//newnumero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>50) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_serie(String newnumero_serie)throws Exception
	{
		try {
			if(this.numero_serie!=newnumero_serie) {
				if(newnumero_serie==null) {
					//newnumero_serie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>50) {
					newnumero_serie=newnumero_serie.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie");
				}

				this.numero_serie=newnumero_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tributario(Long newid_tipo_tributario) {
		if(this.id_tipo_tributario==null&&newid_tipo_tributario!=null) {
			this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
		}

		if(this.id_tipo_tributario!=null&&!this.id_tipo_tributario.equals(newid_tipo_tributario)) {

			this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
		}
	}
    
	public void setfecha_validez(Date newfecha_validez)throws Exception
	{
		try {
			if(this.fecha_validez!=newfecha_validez) {
				if(newfecha_validez==null) {
					//newfecha_validez=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna fecha_validez");
					}
				}

				this.fecha_validez=newfecha_validez;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanexo_factura_inicio(String newanexo_factura_inicio)throws Exception
	{
		try {
			if(this.anexo_factura_inicio!=newanexo_factura_inicio) {
				if(newanexo_factura_inicio==null) {
					//newanexo_factura_inicio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna anexo_factura_inicio");
					}
				}

				if(newanexo_factura_inicio!=null&&newanexo_factura_inicio.length()>50) {
					newanexo_factura_inicio=newanexo_factura_inicio.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna anexo_factura_inicio");
				}

				this.anexo_factura_inicio=newanexo_factura_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanexo_factura_fin(String newanexo_factura_fin)throws Exception
	{
		try {
			if(this.anexo_factura_fin!=newanexo_factura_fin) {
				if(newanexo_factura_fin==null) {
					//newanexo_factura_fin="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna anexo_factura_fin");
					}
				}

				if(newanexo_factura_fin!=null&&newanexo_factura_fin.length()>50) {
					newanexo_factura_fin=newanexo_factura_fin.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna anexo_factura_fin");
				}

				this.anexo_factura_fin=newanexo_factura_fin;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_servicios0(Double newvalor_servicios0)throws Exception
	{
		try {
			if(this.valor_servicios0!=newvalor_servicios0) {
				if(newvalor_servicios0==null) {
					//newvalor_servicios0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna valor_servicios0");
					}
				}

				this.valor_servicios0=newvalor_servicios0;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva_porcentaje(Double newiva_porcentaje)throws Exception
	{
		try {
			if(this.iva_porcentaje!=newiva_porcentaje) {
				if(newiva_porcentaje==null) {
					//newiva_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna iva_porcentaje");
					}
				}

				this.iva_porcentaje=newiva_porcentaje;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_mayor(String newnumero_mayor)throws Exception
	{
		try {
			if(this.numero_mayor!=newnumero_mayor) {
				if(newnumero_mayor==null) {
					//newnumero_mayor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna numero_mayor");
					}
				}

				if(newnumero_mayor!=null&&newnumero_mayor.length()>50) {
					newnumero_mayor=newnumero_mayor.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_mayor");
				}

				this.numero_mayor=newnumero_mayor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_asiento(String newcodigo_asiento)throws Exception
	{
		try {
			if(this.codigo_asiento!=newcodigo_asiento) {
				if(newcodigo_asiento==null) {
					//newcodigo_asiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna codigo_asiento");
					}
				}

				if(newcodigo_asiento!=null&&newcodigo_asiento.length()>50) {
					newcodigo_asiento=newcodigo_asiento.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento");
				}

				this.codigo_asiento=newcodigo_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_fuente1(Long newid_tipo_retencion_fuente1)throws Exception
	{
		try {
			if(this.id_tipo_retencion_fuente1!=newid_tipo_retencion_fuente1) {
				if(newid_tipo_retencion_fuente1==null) {
					//newid_tipo_retencion_fuente1=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_tipo_retencion_fuente1");
					}
				}

				this.id_tipo_retencion_fuente1=newid_tipo_retencion_fuente1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva1(Long newid_tipo_retencion_iva1)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva1!=newid_tipo_retencion_iva1) {
				if(newid_tipo_retencion_iva1==null) {
					//newid_tipo_retencion_iva1=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_tipo_retencion_iva1");
					}
				}

				this.id_tipo_retencion_iva1=newid_tipo_retencion_iva1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanexo_numero_autorizacion(String newanexo_numero_autorizacion)throws Exception
	{
		try {
			if(this.anexo_numero_autorizacion!=newanexo_numero_autorizacion) {
				if(newanexo_numero_autorizacion==null) {
					//newanexo_numero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna anexo_numero_autorizacion");
					}
				}

				if(newanexo_numero_autorizacion!=null&&newanexo_numero_autorizacion.length()>50) {
					newanexo_numero_autorizacion=newanexo_numero_autorizacion.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna anexo_numero_autorizacion");
				}

				this.anexo_numero_autorizacion=newanexo_numero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanexo_numeso_serie(String newanexo_numeso_serie)throws Exception
	{
		try {
			if(this.anexo_numeso_serie!=newanexo_numeso_serie) {
				if(newanexo_numeso_serie==null) {
					//newanexo_numeso_serie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna anexo_numeso_serie");
					}
				}

				if(newanexo_numeso_serie!=null&&newanexo_numeso_serie.length()>50) {
					newanexo_numeso_serie=newanexo_numeso_serie.substring(0,48);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna anexo_numeso_serie");
				}

				this.anexo_numeso_serie=newanexo_numeso_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanexo_fecha_validez(Date newanexo_fecha_validez)throws Exception
	{
		try {
			if(this.anexo_fecha_validez!=newanexo_fecha_validez) {
				if(newanexo_fecha_validez==null) {
					//newanexo_fecha_validez=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna anexo_fecha_validez");
					}
				}

				this.anexo_fecha_validez=newanexo_fecha_validez;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_credito_fiscal_servicios(Long newid_cuenta_contable_credito_fiscal_servicios)throws Exception
	{
		try {
			if(this.id_cuenta_contable_credito_fiscal_servicios!=newid_cuenta_contable_credito_fiscal_servicios) {
				if(newid_cuenta_contable_credito_fiscal_servicios==null) {
					//newid_cuenta_contable_credito_fiscal_servicios=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna id_cuenta_contable_credito_fiscal_servicios");
					}
				}

				this.id_cuenta_contable_credito_fiscal_servicios=newid_cuenta_contable_credito_fiscal_servicios;
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
						System.out.println("FacturaProveedorServicio:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("FacturaProveedorServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento) {
		if(this.id_tipo_movimiento==null&&newid_tipo_movimiento!=null) {
			this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
		}

		if(this.id_tipo_movimiento!=null&&!this.id_tipo_movimiento.equals(newid_tipo_movimiento)) {

			this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_movimiento_modulo(Long newid_tipo_movimiento_modulo) {
		if(this.id_tipo_movimiento_modulo==null&&newid_tipo_movimiento_modulo!=null) {
			this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
				this.setIsChanged(true);
		}

		if(this.id_tipo_movimiento_modulo!=null&&!this.id_tipo_movimiento_modulo.equals(newid_tipo_movimiento_modulo)) {

			this.id_tipo_movimiento_modulo=newid_tipo_movimiento_modulo;
				this.setIsChanged(true);
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

	public Modulo getModulo() {
		return this.modulo;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	public Empleado getEmpleadoSolicita() {
		return this.empleadosolicita;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public TipoTributario getTipoTributario() {
		return this.tipotributario;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public TipoRetencion getTipoRetencionFuente1() {
		return this.tiporetencionfuente1;
	}

	public TipoRetencion getTipoRetencionIva1() {
		return this.tiporetencioniva1;
	}

	public CuentaContable getCuentaContableCreditoFiscalServicios() {
		return this.cuentacontablecreditofiscalservicios;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	public TipoMovimientoModulo getTipoMovimientoModulo() {
		return this.tipomovimientomodulo;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
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

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	public String getempleadosolicita_descripcion() {
		return this.empleadosolicita_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipotributario_descripcion() {
		return this.tipotributario_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String gettiporetencionfuente1_descripcion() {
		return this.tiporetencionfuente1_descripcion;
	}

	public String gettiporetencioniva1_descripcion() {
		return this.tiporetencioniva1_descripcion;
	}

	public String getcuentacontablecreditofiscalservicios_descripcion() {
		return this.cuentacontablecreditofiscalservicios_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	public String gettipomovimientomodulo_descripcion() {
		return this.tipomovimientomodulo_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
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


	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleadoSolicita(Empleado empleadosolicita) {
		try {
			this.empleadosolicita=empleadosolicita;
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


	public  void  setTipoTributario(TipoTributario tipotributario) {
		try {
			this.tipotributario=tipotributario;
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


	public  void  setTipoRetencionFuente1(TipoRetencion tiporetencionfuente1) {
		try {
			this.tiporetencionfuente1=tiporetencionfuente1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIva1(TipoRetencion tiporetencioniva1) {
		try {
			this.tiporetencioniva1=tiporetencioniva1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCreditoFiscalServicios(CuentaContable cuentacontablecreditofiscalservicios) {
		try {
			this.cuentacontablecreditofiscalservicios=cuentacontablecreditofiscalservicios;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoMovimientoModulo(TipoMovimientoModulo tipomovimientomodulo) {
		try {
			this.tipomovimientomodulo=tipomovimientomodulo;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
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


	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleadosolicita_descripcion(String empleadosolicita_descripcion) {
		try {
			this.empleadosolicita_descripcion=empleadosolicita_descripcion;
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


	public  void  settipotributario_descripcion(String tipotributario_descripcion) {
		try {
			this.tipotributario_descripcion=tipotributario_descripcion;
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


	public  void  settiporetencionfuente1_descripcion(String tiporetencionfuente1_descripcion) {
		try {
			this.tiporetencionfuente1_descripcion=tiporetencionfuente1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencioniva1_descripcion(String tiporetencioniva1_descripcion) {
		try {
			this.tiporetencioniva1_descripcion=tiporetencioniva1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecreditofiscalservicios_descripcion(String cuentacontablecreditofiscalservicios_descripcion) {
		try {
			this.cuentacontablecreditofiscalservicios_descripcion=cuentacontablecreditofiscalservicios_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipomovimientomodulo_descripcion(String tipomovimientomodulo_descripcion) {
		try {
			this.tipomovimientomodulo_descripcion=tipomovimientomodulo_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_modulo_descripcion="";String id_transaccion_descripcion="";String id_factura_descripcion="";String id_cliente_descripcion="";String id_tipo_documento_descripcion="";String con_rise_descripcion="";String id_empleado_solicita_descripcion="";String id_empleado_descripcion="";String id_tipo_tributario_descripcion="";String id_moneda_descripcion="";String id_tipo_retencion_fuente1_descripcion="";String id_tipo_retencion_iva1_descripcion="";String id_cuenta_contable_credito_fiscal_servicios_descripcion="";String id_tipo_movimiento_descripcion="";String id_tipo_movimiento_modulo_descripcion="";String id_tipo_transaccion_modulo_descripcion="";
	
	
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
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	public String getcon_rise_descripcion() {
		return con_rise_descripcion;
	}
	public String getid_empleado_solicita_descripcion() {
		return id_empleado_solicita_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_tipo_tributario_descripcion() {
		return id_tipo_tributario_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_tipo_retencion_fuente1_descripcion() {
		return id_tipo_retencion_fuente1_descripcion;
	}
	public String getid_tipo_retencion_iva1_descripcion() {
		return id_tipo_retencion_iva1_descripcion;
	}
	public String getid_cuenta_contable_credito_fiscal_servicios_descripcion() {
		return id_cuenta_contable_credito_fiscal_servicios_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	public String getid_tipo_movimiento_modulo_descripcion() {
		return id_tipo_movimiento_modulo_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
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
	public void setid_anio_descripcion(String newid_anio_descripcion) {
		this.id_anio_descripcion=newid_anio_descripcion;
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
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
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factura_descripcion(String newid_factura_descripcion) {
		this.id_factura_descripcion=newid_factura_descripcion;
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_rise_descripcion(String newcon_rise_descripcion)throws Exception {
		try {
			this.con_rise_descripcion=newcon_rise_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_solicita_descripcion(String newid_empleado_solicita_descripcion)throws Exception {
		try {
			this.id_empleado_solicita_descripcion=newid_empleado_solicita_descripcion;
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
	public void setid_tipo_tributario_descripcion(String newid_tipo_tributario_descripcion) {
		this.id_tipo_tributario_descripcion=newid_tipo_tributario_descripcion;
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_fuente1_descripcion(String newid_tipo_retencion_fuente1_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_fuente1_descripcion=newid_tipo_retencion_fuente1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_iva1_descripcion(String newid_tipo_retencion_iva1_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva1_descripcion=newid_tipo_retencion_iva1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_fiscal_servicios_descripcion(String newid_cuenta_contable_credito_fiscal_servicios_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_fiscal_servicios_descripcion=newid_cuenta_contable_credito_fiscal_servicios_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_movimiento_modulo_descripcion(String newid_tipo_movimiento_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_modulo_descripcion=newid_tipo_movimiento_modulo_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_modulo_descripcion="";this.id_transaccion_descripcion="";this.id_factura_descripcion="";this.id_cliente_descripcion="";this.id_tipo_documento_descripcion="";this.con_rise_descripcion="";this.id_empleado_solicita_descripcion="";this.id_empleado_descripcion="";this.id_tipo_tributario_descripcion="";this.id_moneda_descripcion="";this.id_tipo_retencion_fuente1_descripcion="";this.id_tipo_retencion_iva1_descripcion="";this.id_cuenta_contable_credito_fiscal_servicios_descripcion="";this.id_tipo_movimiento_descripcion="";this.id_tipo_movimiento_modulo_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

