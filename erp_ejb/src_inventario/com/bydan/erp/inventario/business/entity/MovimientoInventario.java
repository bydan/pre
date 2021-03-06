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
//import com.bydan.erp.inventario.util.MovimientoInventarioConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class MovimientoInventario extends MovimientoInventarioAdditional implements Serializable ,Cloneable {//MovimientoInventarioAdditional,GeneralEntity
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
	
	private MovimientoInventario movimientoinventarioOriginal;
	
	private Map<String, Object> mapMovimientoInventario;
			
	public Map<String, Object> getMapMovimientoInventario() {
		return mapMovimientoInventario;
	}

	public void setMapMovimientoInventario(Map<String, Object> mapMovimientoInventario) {
		this.mapMovimientoInventario = mapMovimientoInventario;
	}
	
	public void inicializarMapMovimientoInventario() {
		this.mapMovimientoInventario = new HashMap<String,Object>();
	}
	
	public void setMapMovimientoInventarioValue(String sKey,Object oValue) {
		this.mapMovimientoInventario.put(sKey, oValue);
	}
	
	public Object getMapMovimientoInventarioValue(String sKey) {
		return this.mapMovimientoInventario.get(sKey);
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
	private Long id_modulo;
	
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MovimientoInventarioConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=MovimientoInventarioConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_movimiento_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=MovimientoInventarioConstantesFunciones.SREGEXNUMERO_FACTURA,message=MovimientoInventarioConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_guia_remision;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_transportista;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=MovimientoInventarioConstantesFunciones.SREGEXDESCRIPCION,message=MovimientoInventarioConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double suman;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double stock;
	
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
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_items;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_transaccion_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_compra;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long generico_id;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=MovimientoInventarioConstantesFunciones.SREGEXTIPO_ID,message=MovimientoInventarioConstantesFunciones.SMENSAJEREGEXTIPO_ID)
	private String tipo_id;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=MovimientoInventarioConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=MovimientoInventarioConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Usuario usuario;
	public Transaccion transaccion;
	public Moneda moneda;
	public TipoCambio tipocambio;
	public EstadoMovimientoInventario estadomovimientoinventario;
	public Empleado empleado;
	public Formato formato;
	public Factura factura;
	public GuiaRemision guiaremision;
	public Transportista transportista;
	public TipoTransaccionModulo tipotransaccionmodulo;
	public Compra compra;
	public AsientoContable asientocontable;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String usuario_descripcion;
	private String transaccion_descripcion;
	private String moneda_descripcion;
	private String tipocambio_descripcion;
	private String estadomovimientoinventario_descripcion;
	private String empleado_descripcion;
	private String formato_descripcion;
	private String factura_descripcion;
	private String guiaremision_descripcion;
	private String transportista_descripcion;
	private String tipotransaccionmodulo_descripcion;
	private String compra_descripcion;
	private String asientocontable_descripcion;
	
	
	public List<DetalleMovimientoInventario> detallemovimientoinventarios;
		
	public MovimientoInventario () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.movimientoinventarioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_usuario=-1L;
 		this.id_transaccion=-1L;
 		this.fecha_emision=new Date();
 		this.fecha_entrega=new Date();
 		this.numero_secuencial="";
 		this.id_moneda=-1L;
 		this.id_tipo_cambio=null;
 		this.id_estado_movimiento_inventario=-1L;
 		this.id_empleado=-1L;
 		this.id_formato=-1L;
 		this.id_factura=null;
 		this.numero_factura="";
 		this.id_guia_remision=null;
 		this.id_transportista=null;
 		this.descripcion="";
 		this.porcentaje_descuento=0.0;
 		this.suman=0.0;
 		this.ice=0.0;
 		this.valor_descuento=0.0;
 		this.total_descuento=0.0;
 		this.iva=0.0;
 		this.stock=0.0;
 		this.sub_total=0.0;
 		this.total_otro=0.0;
 		this.ultimo_costo=0.0;
 		this.numero_items=0;
 		this.retencion=0.0;
 		this.total=0.0;
 		this.flete=0.0;
 		this.impuesto=0.0;
 		this.id_tipo_transaccion_modulo=null;
 		this.id_compra=null;
 		this.id_asiento_contable=null;
 		this.generico_id=0L;
 		this.tipo_id="";
 		this.numero_comprobante="";
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.usuario=null;
		this.transaccion=null;
		this.moneda=null;
		this.tipocambio=null;
		this.estadomovimientoinventario=null;
		this.empleado=null;
		this.formato=null;
		this.factura=null;
		this.guiaremision=null;
		this.transportista=null;
		this.tipotransaccionmodulo=null;
		this.compra=null;
		this.asientocontable=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.usuario_descripcion="";
		this.transaccion_descripcion="";
		this.moneda_descripcion="";
		this.tipocambio_descripcion="";
		this.estadomovimientoinventario_descripcion="";
		this.empleado_descripcion="";
		this.formato_descripcion="";
		this.factura_descripcion="";
		this.guiaremision_descripcion="";
		this.transportista_descripcion="";
		this.tipotransaccionmodulo_descripcion="";
		this.compra_descripcion="";
		this.asientocontable_descripcion="";
		
		
		this.detallemovimientoinventarios=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MovimientoInventario (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,Long id_transaccion,Date fecha_emision,Date fecha_entrega,String numero_secuencial,Long id_moneda,Long id_tipo_cambio,Long id_estado_movimiento_inventario,Long id_empleado,Long id_formato,Long id_factura,String numero_factura,Long id_guia_remision,Long id_transportista,String descripcion,Double porcentaje_descuento,Double suman,Double ice,Double valor_descuento,Double total_descuento,Double iva,Double stock,Double sub_total,Double total_otro,Double ultimo_costo,Integer numero_items,Double retencion,Double total,Double flete,Double impuesto,Long id_tipo_transaccion_modulo,Long id_compra,Long id_asiento_contable,Long generico_id,String tipo_id,String numero_comprobante,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientoinventarioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.id_transaccion=id_transaccion;
 		this.fecha_emision=fecha_emision;
 		this.fecha_entrega=fecha_entrega;
 		this.numero_secuencial=numero_secuencial;
 		this.id_moneda=id_moneda;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_estado_movimiento_inventario=id_estado_movimiento_inventario;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.id_guia_remision=id_guia_remision;
 		this.id_transportista=id_transportista;
 		this.descripcion=descripcion;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.suman=suman;
 		this.ice=ice;
 		this.valor_descuento=valor_descuento;
 		this.total_descuento=total_descuento;
 		this.iva=iva;
 		this.stock=stock;
 		this.sub_total=sub_total;
 		this.total_otro=total_otro;
 		this.ultimo_costo=ultimo_costo;
 		this.numero_items=numero_items;
 		this.retencion=retencion;
 		this.total=total;
 		this.flete=flete;
 		this.impuesto=impuesto;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_compra=id_compra;
 		this.id_asiento_contable=id_asiento_contable;
 		this.generico_id=generico_id;
 		this.tipo_id=tipo_id;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MovimientoInventario (Long id_empresa,Long id_sucursal,Long id_modulo,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_usuario,Long id_transaccion,Date fecha_emision,Date fecha_entrega,String numero_secuencial,Long id_moneda,Long id_tipo_cambio,Long id_estado_movimiento_inventario,Long id_empleado,Long id_formato,Long id_factura,String numero_factura,Long id_guia_remision,Long id_transportista,String descripcion,Double porcentaje_descuento,Double suman,Double ice,Double valor_descuento,Double total_descuento,Double iva,Double stock,Double sub_total,Double total_otro,Double ultimo_costo,Integer numero_items,Double retencion,Double total,Double flete,Double impuesto,Long id_tipo_transaccion_modulo,Long id_compra,Long id_asiento_contable,Long generico_id,String tipo_id,String numero_comprobante,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientoinventarioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_usuario=id_usuario;
 		this.id_transaccion=id_transaccion;
 		this.fecha_emision=fecha_emision;
 		this.fecha_entrega=fecha_entrega;
 		this.numero_secuencial=numero_secuencial;
 		this.id_moneda=id_moneda;
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_estado_movimiento_inventario=id_estado_movimiento_inventario;
 		this.id_empleado=id_empleado;
 		this.id_formato=id_formato;
 		this.id_factura=id_factura;
 		this.numero_factura=numero_factura;
 		this.id_guia_remision=id_guia_remision;
 		this.id_transportista=id_transportista;
 		this.descripcion=descripcion;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.suman=suman;
 		this.ice=ice;
 		this.valor_descuento=valor_descuento;
 		this.total_descuento=total_descuento;
 		this.iva=iva;
 		this.stock=stock;
 		this.sub_total=sub_total;
 		this.total_otro=total_otro;
 		this.ultimo_costo=ultimo_costo;
 		this.numero_items=numero_items;
 		this.retencion=retencion;
 		this.total=total;
 		this.flete=flete;
 		this.impuesto=impuesto;
 		this.id_tipo_transaccion_modulo=id_tipo_transaccion_modulo;
 		this.id_compra=id_compra;
 		this.id_asiento_contable=id_asiento_contable;
 		this.generico_id=generico_id;
 		this.tipo_id=tipo_id;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		MovimientoInventario movimientoinventarioLocal=null;
		
		if(object!=null) {
			movimientoinventarioLocal=(MovimientoInventario)object;
			
			if(movimientoinventarioLocal!=null) {
				if(this.getId()!=null && movimientoinventarioLocal.getId()!=null) {
					if(this.getId().equals(movimientoinventarioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!MovimientoInventarioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=MovimientoInventarioConstantesFunciones.getMovimientoInventarioDescripcion(this);
		} else {
			sDetalle=MovimientoInventarioConstantesFunciones.getMovimientoInventarioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public MovimientoInventario getMovimientoInventarioOriginal() {
		return this.movimientoinventarioOriginal;
	}
	
	public void setMovimientoInventarioOriginal(MovimientoInventario movimientoinventario) {
		try {
			this.movimientoinventarioOriginal=movimientoinventario;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MovimientoInventarioAdditional movimientoinventarioAdditional=null;
	
	public MovimientoInventarioAdditional getMovimientoInventarioAdditional() {
		return this.movimientoinventarioAdditional;
	}
	
	public void setMovimientoInventarioAdditional(MovimientoInventarioAdditional movimientoinventarioAdditional) {
		try {
			this.movimientoinventarioAdditional=movimientoinventarioAdditional;
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
    
	
	public Long getid_modulo() {
		return this.id_modulo;
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
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Long getid_estado_movimiento_inventario() {
		return this.id_estado_movimiento_inventario;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Long getid_guia_remision() {
		return this.id_guia_remision;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getporcentaje_descuento() {
		return this.porcentaje_descuento;
	}
    
	
	public Double getsuman() {
		return this.suman;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getvalor_descuento() {
		return this.valor_descuento;
	}
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getstock() {
		return this.stock;
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
    
	
	public Integer getnumero_items() {
		return this.numero_items;
	}
    
	
	public Double getretencion() {
		return this.retencion;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getflete() {
		return this.flete;
	}
    
	
	public Double getimpuesto() {
		return this.impuesto;
	}
    
	
	public Long getid_tipo_transaccion_modulo() {
		return this.id_tipo_transaccion_modulo;
	}
    
	
	public Long getid_compra() {
		return this.id_compra;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getgenerico_id() {
		return this.generico_id;
	}
    
	
	public String gettipo_id() {
		return this.tipo_id;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_periodo");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(Date newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuencial(String newnumero_secuencial)throws Exception
	{
		try {
			if(this.numero_secuencial!=newnumero_secuencial) {
				if(newnumero_secuencial==null) {
					//newnumero_secuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("MovimientoInventario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
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
    
	public void setid_estado_movimiento_inventario(Long newid_estado_movimiento_inventario)throws Exception
	{
		try {
			if(this.id_estado_movimiento_inventario!=newid_estado_movimiento_inventario) {
				if(newid_estado_movimiento_inventario==null) {
					//newid_estado_movimiento_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_estado_movimiento_inventario");
					}
				}

				this.id_estado_movimiento_inventario=newid_estado_movimiento_inventario;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_empleado");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("MovimientoInventario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_guia_remision(Long newid_guia_remision) {
		if(this.id_guia_remision==null&&newid_guia_remision!=null) {
			this.id_guia_remision=newid_guia_remision;
				this.setIsChanged(true);
		}

		if(this.id_guia_remision!=null&&!this.id_guia_remision.equals(newid_guia_remision)) {

			this.id_guia_remision=newid_guia_remision;
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
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("MovimientoInventario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna porcentaje_descuento");
					}
				}

				this.porcentaje_descuento=newporcentaje_descuento;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna suman");
					}
				}

				this.suman=newsuman;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_descuento(Double newvalor_descuento)throws Exception
	{
		try {
			if(this.valor_descuento!=newvalor_descuento) {
				if(newvalor_descuento==null) {
					//newvalor_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna valor_descuento");
					}
				}

				this.valor_descuento=newvalor_descuento;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setstock(Double newstock)throws Exception
	{
		try {
			if(this.stock!=newstock) {
				if(newstock==null) {
					//newstock=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna stock");
					}
				}

				this.stock=newstock;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna sub_total");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna total_otro");
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna ultimo_costo");
					}
				}

				this.ultimo_costo=newultimo_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_items(Integer newnumero_items)throws Exception
	{
		try {
			if(this.numero_items!=newnumero_items) {
				if(newnumero_items==null) {
					//newnumero_items=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna numero_items");
					}
				}

				this.numero_items=newnumero_items;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna retencion");
					}
				}

				this.retencion=newretencion;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna flete");
					}
				}

				this.flete=newflete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto(Double newimpuesto)throws Exception
	{
		try {
			if(this.impuesto!=newimpuesto) {
				if(newimpuesto==null) {
					//newimpuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna impuesto");
					}
				}

				this.impuesto=newimpuesto;
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
    
	public void setid_compra(Long newid_compra) {
		if(this.id_compra==null&&newid_compra!=null) {
			this.id_compra=newid_compra;
				this.setIsChanged(true);
		}

		if(this.id_compra!=null&&!this.id_compra.equals(newid_compra)) {

			this.id_compra=newid_compra;
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
    
	public void setgenerico_id(Long newgenerico_id)throws Exception
	{
		try {
			if(this.generico_id!=newgenerico_id) {
				if(newgenerico_id==null) {
					//newgenerico_id=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna generico_id");
					}
				}

				this.generico_id=newgenerico_id;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_id(String newtipo_id)throws Exception
	{
		try {
			if(this.tipo_id!=newtipo_id) {
				if(newtipo_id==null) {
					//newtipo_id="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna tipo_id");
					}
				}

				if(newtipo_id!=null&&newtipo_id.length()>25) {
					newtipo_id=newtipo_id.substring(0,23);
					System.out.println("MovimientoInventario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna tipo_id");
				}

				this.tipo_id=newtipo_id;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("MovimientoInventario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
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
						System.out.println("MovimientoInventario:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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

	public Modulo getModulo() {
		return this.modulo;
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

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public EstadoMovimientoInventario getEstadoMovimientoInventario() {
		return this.estadomovimientoinventario;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public GuiaRemision getGuiaRemision() {
		return this.guiaremision;
	}

	public Transportista getTransportista() {
		return this.transportista;
	}

	public TipoTransaccionModulo getTipoTransaccionModulo() {
		return this.tipotransaccionmodulo;
	}

	public Compra getCompra() {
		return this.compra;
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

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
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

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String getestadomovimientoinventario_descripcion() {
		return this.estadomovimientoinventario_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getguiaremision_descripcion() {
		return this.guiaremision_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
	}

	public String gettipotransaccionmodulo_descripcion() {
		return this.tipotransaccionmodulo_descripcion;
	}

	public String getcompra_descripcion() {
		return this.compra_descripcion;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  setTipoCambio(TipoCambio tipocambio) {
		try {
			this.tipocambio=tipocambio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoMovimientoInventario(EstadoMovimientoInventario estadomovimientoinventario) {
		try {
			this.estadomovimientoinventario=estadomovimientoinventario;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGuiaRemision(GuiaRemision guiaremision) {
		try {
			this.guiaremision=guiaremision;
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


	public  void  setTipoTransaccionModulo(TipoTransaccionModulo tipotransaccionmodulo) {
		try {
			this.tipotransaccionmodulo=tipotransaccionmodulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCompra(Compra compra) {
		try {
			this.compra=compra;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
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


	public  void  settipocambio_descripcion(String tipocambio_descripcion) {
		try {
			this.tipocambio_descripcion=tipocambio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadomovimientoinventario_descripcion(String estadomovimientoinventario_descripcion) {
		try {
			this.estadomovimientoinventario_descripcion=estadomovimientoinventario_descripcion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setguiaremision_descripcion(String guiaremision_descripcion) {
		try {
			this.guiaremision_descripcion=guiaremision_descripcion;
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


	public  void  settipotransaccionmodulo_descripcion(String tipotransaccionmodulo_descripcion) {
		try {
			this.tipotransaccionmodulo_descripcion=tipotransaccionmodulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcompra_descripcion(String compra_descripcion) {
		try {
			this.compra_descripcion=compra_descripcion;
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


	
	
	public List<DetalleMovimientoInventario> getDetalleMovimientoInventarios() {
		return this.detallemovimientoinventarios;
	}

	
	
	public  void  setDetalleMovimientoInventarios(List<DetalleMovimientoInventario> detallemovimientoinventarios) {
		try {
			this.detallemovimientoinventarios=detallemovimientoinventarios;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_usuario_descripcion="";String id_transaccion_descripcion="";String id_moneda_descripcion="";String id_tipo_cambio_descripcion="";String id_estado_movimiento_inventario_descripcion="";String id_empleado_descripcion="";String id_formato_descripcion="";String id_factura_descripcion="";String id_guia_remision_descripcion="";String id_transportista_descripcion="";String id_tipo_transaccion_modulo_descripcion="";String id_compra_descripcion="";String id_asiento_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
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
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_estado_movimiento_inventario_descripcion() {
		return id_estado_movimiento_inventario_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_guia_remision_descripcion() {
		return id_guia_remision_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
	}
	public String getid_tipo_transaccion_modulo_descripcion() {
		return id_tipo_transaccion_modulo_descripcion;
	}
	public String getid_compra_descripcion() {
		return id_compra_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
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
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
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
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion) {
		this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
	}
	public void setid_estado_movimiento_inventario_descripcion(String newid_estado_movimiento_inventario_descripcion)throws Exception {
		try {
			this.id_estado_movimiento_inventario_descripcion=newid_estado_movimiento_inventario_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion) {
		this.id_factura_descripcion=newid_factura_descripcion;
	}
	public void setid_guia_remision_descripcion(String newid_guia_remision_descripcion) {
		this.id_guia_remision_descripcion=newid_guia_remision_descripcion;
	}
	public void setid_transportista_descripcion(String newid_transportista_descripcion) {
		this.id_transportista_descripcion=newid_transportista_descripcion;
	}
	public void setid_tipo_transaccion_modulo_descripcion(String newid_tipo_transaccion_modulo_descripcion)throws Exception {
		try {
			this.id_tipo_transaccion_modulo_descripcion=newid_tipo_transaccion_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_compra_descripcion(String newid_compra_descripcion) {
		this.id_compra_descripcion=newid_compra_descripcion;
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_usuario_descripcion="";this.id_transaccion_descripcion="";this.id_moneda_descripcion="";this.id_tipo_cambio_descripcion="";this.id_estado_movimiento_inventario_descripcion="";this.id_empleado_descripcion="";this.id_formato_descripcion="";this.id_factura_descripcion="";this.id_guia_remision_descripcion="";this.id_transportista_descripcion="";this.id_tipo_transaccion_modulo_descripcion="";this.id_compra_descripcion="";this.id_asiento_contable_descripcion="";
	}
	
	
	Object detallemovimientoinventariosDescripcionReporte;
	
	
	public Object getdetallemovimientoinventariosDescripcionReporte() {
		return detallemovimientoinventariosDescripcionReporte;
	}

	
	
	public  void  setdetallemovimientoinventariosDescripcionReporte(Object detallemovimientoinventarios) {
		try {
			this.detallemovimientoinventariosDescripcionReporte=detallemovimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

