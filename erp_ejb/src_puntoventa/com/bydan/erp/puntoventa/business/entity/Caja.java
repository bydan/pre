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
//import com.bydan.erp.puntoventa.util.CajaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Caja extends GeneralEntity implements Serializable ,Cloneable {//CajaAdditional,GeneralEntity
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
	
	private Caja cajaOriginal;
	
	private Map<String, Object> mapCaja;
			
	public Map<String, Object> getMapCaja() {
		return mapCaja;
	}

	public void setMapCaja(Map<String, Object> mapCaja) {
		this.mapCaja = mapCaja;
	}
	
	public void inicializarMapCaja() {
		this.mapCaja = new HashMap<String,Object>();
	}
	
	public void setMapCajaValue(String sKey,Object oValue) {
		this.mapCaja.put(sKey, oValue);
	}
	
	public Object getMapCajaValue(String sKey) {
		return this.mapCaja.get(sKey);
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
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXNOMBRE,message=CajaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXNOMBRE_EQUIPO,message=CajaConstantesFunciones.SMENSAJEREGEXNOMBRE_EQUIPO)
	private String nombre_equipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXNOMBRE_IMPRESORA,message=CajaConstantesFunciones.SMENSAJEREGEXNOMBRE_IMPRESORA)
	private String nombre_impresora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long secuencial_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSECUENCIAL_PEDIDO_FORMATO,message=CajaConstantesFunciones.SMENSAJEREGEXSECUENCIAL_PEDIDO_FORMATO)
	private String secuencial_pedido_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=5,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXPUNTO_EMISION,message=CajaConstantesFunciones.SMENSAJEREGEXPUNTO_EMISION)
	private String punto_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=5,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXESTABLECIMIENTO,message=CajaConstantesFunciones.SMENSAJEREGEXESTABLECIMIENTO)
	private String establecimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXDESCRIPCION,message=CajaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long secuencial_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSECUENCIAL_FACTURA_FORMATO,message=CajaConstantesFunciones.SMENSAJEREGEXSECUENCIAL_FACTURA_FORMATO)
	private String secuencial_factura_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long secuencial_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSECUENCIAL_NOTA_VENTA_FORMATO,message=CajaConstantesFunciones.SMENSAJEREGEXSECUENCIAL_NOTA_VENTA_FORMATO)
	private String secuencial_nota_venta_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long secuencia_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSECUENCIA_NOTA_CREDITO_FORMATO,message=CajaConstantesFunciones.SMENSAJEREGEXSECUENCIA_NOTA_CREDITO_FORMATO)
	private String secuencia_nota_credito_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXAUTORIZACION_FACTURA,message=CajaConstantesFunciones.SMENSAJEREGEXAUTORIZACION_FACTURA)
	private String autorizacion_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXAUTORIZACION_NOTA_VENTA,message=CajaConstantesFunciones.SMENSAJEREGEXAUTORIZACION_NOTA_VENTA)
	private String autorizacion_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CajaConstantesFunciones.SREGEXAUTORIZACION_NOTA_CREDITO,message=CajaConstantesFunciones.SMENSAJEREGEXAUTORIZACION_NOTA_CREDITO)
	private String autorizacion_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caduca_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caduca_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caduca_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSERIE_FACTURA,message=CajaConstantesFunciones.SMENSAJEREGEXSERIE_FACTURA)
	private String serie_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSERIE_NOTA_VENTA,message=CajaConstantesFunciones.SMENSAJEREGEXSERIE_NOTA_VENTA)
	private String serie_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSERIE_NOTA_CREDITO,message=CajaConstantesFunciones.SMENSAJEREGEXSERIE_NOTA_CREDITO)
	private String serie_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_INICIAL_FACTURA,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_INICIAL_FACTURA)
	private String sec_inicial_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_INICIAL_NOTA_VENTA,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_INICIAL_NOTA_VENTA)
	private String sec_inicial_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_INICIAL_NOTA_CREDITO,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_INICIAL_NOTA_CREDITO)
	private String sec_inicial_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_FINAL_FACTURA,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_FINAL_FACTURA)
	private String sec_final_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_FINAL_NOTA_VENTA,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_FINAL_NOTA_VENTA)
	private String sec_final_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CajaConstantesFunciones.SREGEXSEC_FINAL_NOTA_CREDITO,message=CajaConstantesFunciones.SMENSAJEREGEXSEC_FINAL_NOTA_CREDITO)
	private String sec_final_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_zona;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Pais pais;
	public Ciudad ciudad;
	public Zona zona;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	
	
	public List<NotaCreditoPuntoVenta> notacreditopuntoventas;
	public List<CajaCierre> cajacierres;
	public List<FacturaPuntoVenta> facturapuntoventas;
	public List<CajaEgreso> cajaegresos;
	public List<CajeroTurno> cajeroturnos;
	public List<PresupuestoVentasPunVen> presupuestoventaspunvens;
	public List<PedidoPuntoVenta> pedidopuntoventas;
	public List<CajaIngreso> cajaingresos;
		
	public Caja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.nombre="";
 		this.nombre_equipo="";
 		this.nombre_impresora="";
 		this.secuencial_pedido=0L;
 		this.secuencial_pedido_formato="";
 		this.punto_emision="";
 		this.establecimiento="";
 		this.fecha_inicio=new Date();
 		this.fecha_final=new Date();
 		this.esta_activo=false;
 		this.descripcion="";
 		this.secuencial_factura=0L;
 		this.secuencial_factura_formato="";
 		this.secuencial_nota_venta=0L;
 		this.secuencial_nota_venta_formato="";
 		this.secuencia_nota_credito=0L;
 		this.secuencia_nota_credito_formato="";
 		this.autorizacion_factura="";
 		this.autorizacion_nota_venta="";
 		this.autorizacion_nota_credito="";
 		this.fecha_caduca_factura=new Date();
 		this.fecha_caduca_nota_venta=new Date();
 		this.fecha_caduca_nota_credito=new Date();
 		this.serie_factura="";
 		this.serie_nota_venta="";
 		this.serie_nota_credito="";
 		this.sec_inicial_factura="";
 		this.sec_inicial_nota_venta="";
 		this.sec_inicial_nota_credito="";
 		this.sec_final_factura="";
 		this.sec_final_nota_venta="";
 		this.sec_final_nota_credito="";
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.pais=null;
		this.ciudad=null;
		this.zona=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		
		
		this.notacreditopuntoventas=null;
		this.cajacierres=null;
		this.facturapuntoventas=null;
		this.cajaegresos=null;
		this.cajeroturnos=null;
		this.presupuestoventaspunvens=null;
		this.pedidopuntoventas=null;
		this.cajaingresos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Caja (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String nombre,String nombre_equipo,String nombre_impresora,Long secuencial_pedido,String secuencial_pedido_formato,String punto_emision,String establecimiento,Date fecha_inicio,Date fecha_final,Boolean esta_activo,String descripcion,Long secuencial_factura,String secuencial_factura_formato,Long secuencial_nota_venta,String secuencial_nota_venta_formato,Long secuencia_nota_credito,String secuencia_nota_credito_formato,String autorizacion_factura,String autorizacion_nota_venta,String autorizacion_nota_credito,Date fecha_caduca_factura,Date fecha_caduca_nota_venta,Date fecha_caduca_nota_credito,String serie_factura,String serie_nota_venta,String serie_nota_credito,String sec_inicial_factura,String sec_inicial_nota_venta,String sec_inicial_nota_credito,String sec_final_factura,String sec_final_nota_venta,String sec_final_nota_credito,Long id_pais,Long id_ciudad,Long id_zona) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.nombre=nombre;
 		this.nombre_equipo=nombre_equipo;
 		this.nombre_impresora=nombre_impresora;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_pedido_formato=secuencial_pedido_formato;
 		this.punto_emision=punto_emision;
 		this.establecimiento=establecimiento;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_final=fecha_final;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
 		this.secuencial_factura=secuencial_factura;
 		this.secuencial_factura_formato=secuencial_factura_formato;
 		this.secuencial_nota_venta=secuencial_nota_venta;
 		this.secuencial_nota_venta_formato=secuencial_nota_venta_formato;
 		this.secuencia_nota_credito=secuencia_nota_credito;
 		this.secuencia_nota_credito_formato=secuencia_nota_credito_formato;
 		this.autorizacion_factura=autorizacion_factura;
 		this.autorizacion_nota_venta=autorizacion_nota_venta;
 		this.autorizacion_nota_credito=autorizacion_nota_credito;
 		this.fecha_caduca_factura=fecha_caduca_factura;
 		this.fecha_caduca_nota_venta=fecha_caduca_nota_venta;
 		this.fecha_caduca_nota_credito=fecha_caduca_nota_credito;
 		this.serie_factura=serie_factura;
 		this.serie_nota_venta=serie_nota_venta;
 		this.serie_nota_credito=serie_nota_credito;
 		this.sec_inicial_factura=sec_inicial_factura;
 		this.sec_inicial_nota_venta=sec_inicial_nota_venta;
 		this.sec_inicial_nota_credito=sec_inicial_nota_credito;
 		this.sec_final_factura=sec_final_factura;
 		this.sec_final_nota_venta=sec_final_nota_venta;
 		this.sec_final_nota_credito=sec_final_nota_credito;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Caja (Long id_empresa,Long id_sucursal,String nombre,String nombre_equipo,String nombre_impresora,Long secuencial_pedido,String secuencial_pedido_formato,String punto_emision,String establecimiento,Date fecha_inicio,Date fecha_final,Boolean esta_activo,String descripcion,Long secuencial_factura,String secuencial_factura_formato,Long secuencial_nota_venta,String secuencial_nota_venta_formato,Long secuencia_nota_credito,String secuencia_nota_credito_formato,String autorizacion_factura,String autorizacion_nota_venta,String autorizacion_nota_credito,Date fecha_caduca_factura,Date fecha_caduca_nota_venta,Date fecha_caduca_nota_credito,String serie_factura,String serie_nota_venta,String serie_nota_credito,String sec_inicial_factura,String sec_inicial_nota_venta,String sec_inicial_nota_credito,String sec_final_factura,String sec_final_nota_venta,String sec_final_nota_credito,Long id_pais,Long id_ciudad,Long id_zona) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.nombre=nombre;
 		this.nombre_equipo=nombre_equipo;
 		this.nombre_impresora=nombre_impresora;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_pedido_formato=secuencial_pedido_formato;
 		this.punto_emision=punto_emision;
 		this.establecimiento=establecimiento;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_final=fecha_final;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
 		this.secuencial_factura=secuencial_factura;
 		this.secuencial_factura_formato=secuencial_factura_formato;
 		this.secuencial_nota_venta=secuencial_nota_venta;
 		this.secuencial_nota_venta_formato=secuencial_nota_venta_formato;
 		this.secuencia_nota_credito=secuencia_nota_credito;
 		this.secuencia_nota_credito_formato=secuencia_nota_credito_formato;
 		this.autorizacion_factura=autorizacion_factura;
 		this.autorizacion_nota_venta=autorizacion_nota_venta;
 		this.autorizacion_nota_credito=autorizacion_nota_credito;
 		this.fecha_caduca_factura=fecha_caduca_factura;
 		this.fecha_caduca_nota_venta=fecha_caduca_nota_venta;
 		this.fecha_caduca_nota_credito=fecha_caduca_nota_credito;
 		this.serie_factura=serie_factura;
 		this.serie_nota_venta=serie_nota_venta;
 		this.serie_nota_credito=serie_nota_credito;
 		this.sec_inicial_factura=sec_inicial_factura;
 		this.sec_inicial_nota_venta=sec_inicial_nota_venta;
 		this.sec_inicial_nota_credito=sec_inicial_nota_credito;
 		this.sec_final_factura=sec_final_factura;
 		this.sec_final_nota_venta=sec_final_nota_venta;
 		this.sec_final_nota_credito=sec_final_nota_credito;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Caja cajaLocal=null;
		
		if(object!=null) {
			cajaLocal=(Caja)object;
			
			if(cajaLocal!=null) {
				if(this.getId()!=null && cajaLocal.getId()!=null) {
					if(this.getId().equals(cajaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CajaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CajaConstantesFunciones.getCajaDescripcion(this);
		} else {
			sDetalle=CajaConstantesFunciones.getCajaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Caja getCajaOriginal() {
		return this.cajaOriginal;
	}
	
	public void setCajaOriginal(Caja caja) {
		try {
			this.cajaOriginal=caja;
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
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_equipo() {
		return this.nombre_equipo;
	}
    
	
	public String getnombre_impresora() {
		return this.nombre_impresora;
	}
    
	
	public Long getsecuencial_pedido() {
		return this.secuencial_pedido;
	}
    
	
	public String getsecuencial_pedido_formato() {
		return this.secuencial_pedido_formato;
	}
    
	
	public String getpunto_emision() {
		return this.punto_emision;
	}
    
	
	public String getestablecimiento() {
		return this.establecimiento;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_final() {
		return this.fecha_final;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getsecuencial_factura() {
		return this.secuencial_factura;
	}
    
	
	public String getsecuencial_factura_formato() {
		return this.secuencial_factura_formato;
	}
    
	
	public Long getsecuencial_nota_venta() {
		return this.secuencial_nota_venta;
	}
    
	
	public String getsecuencial_nota_venta_formato() {
		return this.secuencial_nota_venta_formato;
	}
    
	
	public Long getsecuencia_nota_credito() {
		return this.secuencia_nota_credito;
	}
    
	
	public String getsecuencia_nota_credito_formato() {
		return this.secuencia_nota_credito_formato;
	}
    
	
	public String getautorizacion_factura() {
		return this.autorizacion_factura;
	}
    
	
	public String getautorizacion_nota_venta() {
		return this.autorizacion_nota_venta;
	}
    
	
	public String getautorizacion_nota_credito() {
		return this.autorizacion_nota_credito;
	}
    
	
	public Date getfecha_caduca_factura() {
		return this.fecha_caduca_factura;
	}
    
	
	public Date getfecha_caduca_nota_venta() {
		return this.fecha_caduca_nota_venta;
	}
    
	
	public Date getfecha_caduca_nota_credito() {
		return this.fecha_caduca_nota_credito;
	}
    
	
	public String getserie_factura() {
		return this.serie_factura;
	}
    
	
	public String getserie_nota_venta() {
		return this.serie_nota_venta;
	}
    
	
	public String getserie_nota_credito() {
		return this.serie_nota_credito;
	}
    
	
	public String getsec_inicial_factura() {
		return this.sec_inicial_factura;
	}
    
	
	public String getsec_inicial_nota_venta() {
		return this.sec_inicial_nota_venta;
	}
    
	
	public String getsec_inicial_nota_credito() {
		return this.sec_inicial_nota_credito;
	}
    
	
	public String getsec_final_factura() {
		return this.sec_final_factura;
	}
    
	
	public String getsec_final_nota_venta() {
		return this.sec_final_nota_venta;
	}
    
	
	public String getsec_final_nota_credito() {
		return this.sec_final_nota_credito;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Caja:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_equipo(String newnombre_equipo)throws Exception
	{
		try {
			if(this.nombre_equipo!=newnombre_equipo) {
				if(newnombre_equipo==null) {
					//newnombre_equipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna nombre_equipo");
					}
				}

				if(newnombre_equipo!=null&&newnombre_equipo.length()>100) {
					newnombre_equipo=newnombre_equipo.substring(0,98);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_equipo");
				}

				this.nombre_equipo=newnombre_equipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_impresora(String newnombre_impresora)throws Exception
	{
		try {
			if(this.nombre_impresora!=newnombre_impresora) {
				if(newnombre_impresora==null) {
					//newnombre_impresora="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna nombre_impresora");
					}
				}

				if(newnombre_impresora!=null&&newnombre_impresora.length()>100) {
					newnombre_impresora=newnombre_impresora.substring(0,98);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_impresora");
				}

				this.nombre_impresora=newnombre_impresora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_pedido(Long newsecuencial_pedido)throws Exception
	{
		try {
			if(this.secuencial_pedido!=newsecuencial_pedido) {
				if(newsecuencial_pedido==null) {
					//newsecuencial_pedido=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_pedido");
					}
				}

				this.secuencial_pedido=newsecuencial_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_pedido_formato(String newsecuencial_pedido_formato)throws Exception
	{
		try {
			if(this.secuencial_pedido_formato!=newsecuencial_pedido_formato) {
				if(newsecuencial_pedido_formato==null) {
					//newsecuencial_pedido_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_pedido_formato");
					}
				}

				if(newsecuencial_pedido_formato!=null&&newsecuencial_pedido_formato.length()>50) {
					newsecuencial_pedido_formato=newsecuencial_pedido_formato.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_pedido_formato");
				}

				this.secuencial_pedido_formato=newsecuencial_pedido_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpunto_emision(String newpunto_emision)throws Exception
	{
		try {
			if(this.punto_emision!=newpunto_emision) {
				if(newpunto_emision==null) {
					//newpunto_emision="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna punto_emision");
					}
				}

				if(newpunto_emision!=null&&newpunto_emision.length()>5) {
					newpunto_emision=newpunto_emision.substring(0,3);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=5 en columna punto_emision");
				}

				this.punto_emision=newpunto_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestablecimiento(String newestablecimiento)throws Exception
	{
		try {
			if(this.establecimiento!=newestablecimiento) {
				if(newestablecimiento==null) {
					//newestablecimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna establecimiento");
					}
				}

				if(newestablecimiento!=null&&newestablecimiento.length()>5) {
					newestablecimiento=newestablecimiento.substring(0,3);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=5 en columna establecimiento");
				}

				this.establecimiento=newestablecimiento;
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
						System.out.println("Caja:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_final(Date newfecha_final)throws Exception
	{
		try {
			if(this.fecha_final!=newfecha_final) {
				if(newfecha_final==null) {
					//newfecha_final=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna fecha_final");
					}
				}

				this.fecha_final=newfecha_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
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
						System.out.println("Caja:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_factura(Long newsecuencial_factura)throws Exception
	{
		try {
			if(this.secuencial_factura!=newsecuencial_factura) {
				if(newsecuencial_factura==null) {
					//newsecuencial_factura=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_factura");
					}
				}

				this.secuencial_factura=newsecuencial_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_factura_formato(String newsecuencial_factura_formato)throws Exception
	{
		try {
			if(this.secuencial_factura_formato!=newsecuencial_factura_formato) {
				if(newsecuencial_factura_formato==null) {
					//newsecuencial_factura_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_factura_formato");
					}
				}

				if(newsecuencial_factura_formato!=null&&newsecuencial_factura_formato.length()>50) {
					newsecuencial_factura_formato=newsecuencial_factura_formato.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_factura_formato");
				}

				this.secuencial_factura_formato=newsecuencial_factura_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_nota_venta(Long newsecuencial_nota_venta)throws Exception
	{
		try {
			if(this.secuencial_nota_venta!=newsecuencial_nota_venta) {
				if(newsecuencial_nota_venta==null) {
					//newsecuencial_nota_venta=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_nota_venta");
					}
				}

				this.secuencial_nota_venta=newsecuencial_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_nota_venta_formato(String newsecuencial_nota_venta_formato)throws Exception
	{
		try {
			if(this.secuencial_nota_venta_formato!=newsecuencial_nota_venta_formato) {
				if(newsecuencial_nota_venta_formato==null) {
					//newsecuencial_nota_venta_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencial_nota_venta_formato");
					}
				}

				if(newsecuencial_nota_venta_formato!=null&&newsecuencial_nota_venta_formato.length()>50) {
					newsecuencial_nota_venta_formato=newsecuencial_nota_venta_formato.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial_nota_venta_formato");
				}

				this.secuencial_nota_venta_formato=newsecuencial_nota_venta_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencia_nota_credito(Long newsecuencia_nota_credito)throws Exception
	{
		try {
			if(this.secuencia_nota_credito!=newsecuencia_nota_credito) {
				if(newsecuencia_nota_credito==null) {
					//newsecuencia_nota_credito=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencia_nota_credito");
					}
				}

				this.secuencia_nota_credito=newsecuencia_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencia_nota_credito_formato(String newsecuencia_nota_credito_formato)throws Exception
	{
		try {
			if(this.secuencia_nota_credito_formato!=newsecuencia_nota_credito_formato) {
				if(newsecuencia_nota_credito_formato==null) {
					//newsecuencia_nota_credito_formato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna secuencia_nota_credito_formato");
					}
				}

				if(newsecuencia_nota_credito_formato!=null&&newsecuencia_nota_credito_formato.length()>50) {
					newsecuencia_nota_credito_formato=newsecuencia_nota_credito_formato.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencia_nota_credito_formato");
				}

				this.secuencia_nota_credito_formato=newsecuencia_nota_credito_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion_factura(String newautorizacion_factura)throws Exception
	{
		try {
			if(this.autorizacion_factura!=newautorizacion_factura) {
				if(newautorizacion_factura==null) {
					//newautorizacion_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna autorizacion_factura");
					}
				}

				if(newautorizacion_factura!=null&&newautorizacion_factura.length()>50) {
					newautorizacion_factura=newautorizacion_factura.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna autorizacion_factura");
				}

				this.autorizacion_factura=newautorizacion_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion_nota_venta(String newautorizacion_nota_venta)throws Exception
	{
		try {
			if(this.autorizacion_nota_venta!=newautorizacion_nota_venta) {
				if(newautorizacion_nota_venta==null) {
					//newautorizacion_nota_venta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna autorizacion_nota_venta");
					}
				}

				if(newautorizacion_nota_venta!=null&&newautorizacion_nota_venta.length()>50) {
					newautorizacion_nota_venta=newautorizacion_nota_venta.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna autorizacion_nota_venta");
				}

				this.autorizacion_nota_venta=newautorizacion_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setautorizacion_nota_credito(String newautorizacion_nota_credito)throws Exception
	{
		try {
			if(this.autorizacion_nota_credito!=newautorizacion_nota_credito) {
				if(newautorizacion_nota_credito==null) {
					//newautorizacion_nota_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna autorizacion_nota_credito");
					}
				}

				if(newautorizacion_nota_credito!=null&&newautorizacion_nota_credito.length()>50) {
					newautorizacion_nota_credito=newautorizacion_nota_credito.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna autorizacion_nota_credito");
				}

				this.autorizacion_nota_credito=newautorizacion_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caduca_factura(Date newfecha_caduca_factura)throws Exception
	{
		try {
			if(this.fecha_caduca_factura!=newfecha_caduca_factura) {
				if(newfecha_caduca_factura==null) {
					//newfecha_caduca_factura=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna fecha_caduca_factura");
					}
				}

				this.fecha_caduca_factura=newfecha_caduca_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caduca_nota_venta(Date newfecha_caduca_nota_venta)throws Exception
	{
		try {
			if(this.fecha_caduca_nota_venta!=newfecha_caduca_nota_venta) {
				if(newfecha_caduca_nota_venta==null) {
					//newfecha_caduca_nota_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna fecha_caduca_nota_venta");
					}
				}

				this.fecha_caduca_nota_venta=newfecha_caduca_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caduca_nota_credito(Date newfecha_caduca_nota_credito)throws Exception
	{
		try {
			if(this.fecha_caduca_nota_credito!=newfecha_caduca_nota_credito) {
				if(newfecha_caduca_nota_credito==null) {
					//newfecha_caduca_nota_credito=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna fecha_caduca_nota_credito");
					}
				}

				this.fecha_caduca_nota_credito=newfecha_caduca_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie_factura(String newserie_factura)throws Exception
	{
		try {
			if(this.serie_factura!=newserie_factura) {
				if(newserie_factura==null) {
					//newserie_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna serie_factura");
					}
				}

				if(newserie_factura!=null&&newserie_factura.length()>50) {
					newserie_factura=newserie_factura.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna serie_factura");
				}

				this.serie_factura=newserie_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie_nota_venta(String newserie_nota_venta)throws Exception
	{
		try {
			if(this.serie_nota_venta!=newserie_nota_venta) {
				if(newserie_nota_venta==null) {
					//newserie_nota_venta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna serie_nota_venta");
					}
				}

				if(newserie_nota_venta!=null&&newserie_nota_venta.length()>50) {
					newserie_nota_venta=newserie_nota_venta.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna serie_nota_venta");
				}

				this.serie_nota_venta=newserie_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setserie_nota_credito(String newserie_nota_credito)throws Exception
	{
		try {
			if(this.serie_nota_credito!=newserie_nota_credito) {
				if(newserie_nota_credito==null) {
					//newserie_nota_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna serie_nota_credito");
					}
				}

				if(newserie_nota_credito!=null&&newserie_nota_credito.length()>50) {
					newserie_nota_credito=newserie_nota_credito.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna serie_nota_credito");
				}

				this.serie_nota_credito=newserie_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_inicial_factura(String newsec_inicial_factura)throws Exception
	{
		try {
			if(this.sec_inicial_factura!=newsec_inicial_factura) {
				if(newsec_inicial_factura==null) {
					//newsec_inicial_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_inicial_factura");
					}
				}

				if(newsec_inicial_factura!=null&&newsec_inicial_factura.length()>50) {
					newsec_inicial_factura=newsec_inicial_factura.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_inicial_factura");
				}

				this.sec_inicial_factura=newsec_inicial_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_inicial_nota_venta(String newsec_inicial_nota_venta)throws Exception
	{
		try {
			if(this.sec_inicial_nota_venta!=newsec_inicial_nota_venta) {
				if(newsec_inicial_nota_venta==null) {
					//newsec_inicial_nota_venta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_inicial_nota_venta");
					}
				}

				if(newsec_inicial_nota_venta!=null&&newsec_inicial_nota_venta.length()>50) {
					newsec_inicial_nota_venta=newsec_inicial_nota_venta.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_inicial_nota_venta");
				}

				this.sec_inicial_nota_venta=newsec_inicial_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_inicial_nota_credito(String newsec_inicial_nota_credito)throws Exception
	{
		try {
			if(this.sec_inicial_nota_credito!=newsec_inicial_nota_credito) {
				if(newsec_inicial_nota_credito==null) {
					//newsec_inicial_nota_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_inicial_nota_credito");
					}
				}

				if(newsec_inicial_nota_credito!=null&&newsec_inicial_nota_credito.length()>50) {
					newsec_inicial_nota_credito=newsec_inicial_nota_credito.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_inicial_nota_credito");
				}

				this.sec_inicial_nota_credito=newsec_inicial_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_final_factura(String newsec_final_factura)throws Exception
	{
		try {
			if(this.sec_final_factura!=newsec_final_factura) {
				if(newsec_final_factura==null) {
					//newsec_final_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_final_factura");
					}
				}

				if(newsec_final_factura!=null&&newsec_final_factura.length()>50) {
					newsec_final_factura=newsec_final_factura.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_final_factura");
				}

				this.sec_final_factura=newsec_final_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_final_nota_venta(String newsec_final_nota_venta)throws Exception
	{
		try {
			if(this.sec_final_nota_venta!=newsec_final_nota_venta) {
				if(newsec_final_nota_venta==null) {
					//newsec_final_nota_venta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_final_nota_venta");
					}
				}

				if(newsec_final_nota_venta!=null&&newsec_final_nota_venta.length()>50) {
					newsec_final_nota_venta=newsec_final_nota_venta.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_final_nota_venta");
				}

				this.sec_final_nota_venta=newsec_final_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsec_final_nota_credito(String newsec_final_nota_credito)throws Exception
	{
		try {
			if(this.sec_final_nota_credito!=newsec_final_nota_credito) {
				if(newsec_final_nota_credito==null) {
					//newsec_final_nota_credito="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna sec_final_nota_credito");
					}
				}

				if(newsec_final_nota_credito!=null&&newsec_final_nota_credito.length()>50) {
					newsec_final_nota_credito=newsec_final_nota_credito.substring(0,48);
					System.out.println("Caja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sec_final_nota_credito");
				}

				this.sec_final_nota_credito=newsec_final_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_zona(Long newid_zona)throws Exception
	{
		try {
			if(this.id_zona!=newid_zona) {
				if(newid_zona==null) {
					//newid_zona=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Caja:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
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

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
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


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setZona(Zona zona) {
		try {
			this.zona=zona;
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


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setzona_descripcion(String zona_descripcion) {
		try {
			this.zona_descripcion=zona_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas() {
		return this.notacreditopuntoventas;
	}

	public List<CajaCierre> getCajaCierres() {
		return this.cajacierres;
	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas() {
		return this.facturapuntoventas;
	}

	public List<CajaEgreso> getCajaEgresos() {
		return this.cajaegresos;
	}

	public List<CajeroTurno> getCajeroTurnos() {
		return this.cajeroturnos;
	}

	public List<PresupuestoVentasPunVen> getPresupuestoVentasPunVens() {
		return this.presupuestoventaspunvens;
	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas() {
		return this.pedidopuntoventas;
	}

	public List<CajaIngreso> getCajaIngresos() {
		return this.cajaingresos;
	}

	
	
	public  void  setNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas) {
		try {
			this.notacreditopuntoventas=notacreditopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajaCierres(List<CajaCierre> cajacierres) {
		try {
			this.cajacierres=cajacierres;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas) {
		try {
			this.facturapuntoventas=facturapuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajaEgresos(List<CajaEgreso> cajaegresos) {
		try {
			this.cajaegresos=cajaegresos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajeroTurnos(List<CajeroTurno> cajeroturnos) {
		try {
			this.cajeroturnos=cajeroturnos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoVentasPunVens(List<PresupuestoVentasPunVen> presupuestoventaspunvens) {
		try {
			this.presupuestoventaspunvens=presupuestoventaspunvens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas) {
		try {
			this.pedidopuntoventas=pedidopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajaIngresos(List<CajaIngreso> cajaingresos) {
		try {
			this.cajaingresos=cajaingresos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String esta_activo_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
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
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_zona_descripcion(String newid_zona_descripcion)throws Exception {
		try {
			this.id_zona_descripcion=newid_zona_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.esta_activo_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";
	}
	
	
	Object notacreditopuntoventasDescripcionReporte;
	Object cajacierresDescripcionReporte;
	Object facturapuntoventasDescripcionReporte;
	Object cajaegresosDescripcionReporte;
	Object cajeroturnosDescripcionReporte;
	Object presupuestoventaspunvensDescripcionReporte;
	Object pedidopuntoventasDescripcionReporte;
	Object cajaingresosDescripcionReporte;
	
	
	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	public Object getcajacierresDescripcionReporte() {
		return cajacierresDescripcionReporte;
	}

	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	public Object getcajaegresosDescripcionReporte() {
		return cajaegresosDescripcionReporte;
	}

	public Object getcajeroturnosDescripcionReporte() {
		return cajeroturnosDescripcionReporte;
	}

	public Object getpresupuestoventaspunvensDescripcionReporte() {
		return presupuestoventaspunvensDescripcionReporte;
	}

	public Object getpedidopuntoventasDescripcionReporte() {
		return pedidopuntoventasDescripcionReporte;
	}

	public Object getcajaingresosDescripcionReporte() {
		return cajaingresosDescripcionReporte;
	}

	
	
	public  void  setnotacreditopuntoventasDescripcionReporte(Object notacreditopuntoventas) {
		try {
			this.notacreditopuntoventasDescripcionReporte=notacreditopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajacierresDescripcionReporte(Object cajacierres) {
		try {
			this.cajacierresDescripcionReporte=cajacierres;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturapuntoventasDescripcionReporte(Object facturapuntoventas) {
		try {
			this.facturapuntoventasDescripcionReporte=facturapuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaegresosDescripcionReporte(Object cajaegresos) {
		try {
			this.cajaegresosDescripcionReporte=cajaegresos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajeroturnosDescripcionReporte(Object cajeroturnos) {
		try {
			this.cajeroturnosDescripcionReporte=cajeroturnos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoventaspunvensDescripcionReporte(Object presupuestoventaspunvens) {
		try {
			this.presupuestoventaspunvensDescripcionReporte=presupuestoventaspunvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidopuntoventasDescripcionReporte(Object pedidopuntoventas) {
		try {
			this.pedidopuntoventasDescripcionReporte=pedidopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajaingresosDescripcionReporte(Object cajaingresos) {
		try {
			this.cajaingresosDescripcionReporte=cajaingresos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

