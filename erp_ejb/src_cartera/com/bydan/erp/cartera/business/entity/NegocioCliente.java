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
//import com.bydan.erp.cartera.util.NegocioClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class NegocioCliente extends NegocioClienteAdditional implements Serializable ,Cloneable {//NegocioClienteAdditional,GeneralEntity
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
	
	private NegocioCliente negocioclienteOriginal;
	
	private Map<String, Object> mapNegocioCliente;
			
	public Map<String, Object> getMapNegocioCliente() {
		return mapNegocioCliente;
	}

	public void setMapNegocioCliente(Map<String, Object> mapNegocioCliente) {
		this.mapNegocioCliente = mapNegocioCliente;
	}
	
	public void inicializarMapNegocioCliente() {
		this.mapNegocioCliente = new HashMap<String,Object>();
	}
	
	public void setMapNegocioClienteValue(String sKey,Object oValue) {
		this.mapNegocioCliente.put(sKey, oValue);
	}
	
	public Object getMapNegocioClienteValue(String sKey) {
		return this.mapNegocioCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXNOMBRE_QUIEN_SE_FACTURA,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_QUIEN_SE_FACTURA)
	private String nombre_quien_se_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXFAX,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXFAX)
	private String fax;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXRUC,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXTELEFONO,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXNOMBRE_LOCAL,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_LOCAL)
	private String nombre_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXE_MAIL,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXE_MAIL)
	private String e_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXDIRECCION,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_local_propio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_anios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_meses;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_ubicacion_negocio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer empleados_fijos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer empleado_temporales;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer empleados_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_ventas_contado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_ventas_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer plazo_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_clientes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_maximo_ventas_mensual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_minimo_ventas_mensual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_enero_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_febrero_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_marzo_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_abril_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_mayo_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_junio_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_julio_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_agosto_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_septiembre_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_octubre_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_noviembre_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_diciembre_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_enero_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_febrero_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_marzo_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_abril_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_mayo_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_junio_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_julio_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_agosto_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_septiembre_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_octubre_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_noviembre_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_diciembre_bajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NegocioClienteConstantesFunciones.SREGEXDESCRIPCION,message=NegocioClienteConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoUbicacionNegocio tipoubicacionnegocio;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tipoubicacionnegocio_descripcion;
	
	
		
	public NegocioCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.negocioclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.nombre_quien_se_factura="";
 		this.fax="";
 		this.ruc="";
 		this.telefono="";
 		this.nombre_local="";
 		this.e_mail="";
 		this.direccion="";
 		this.es_local_propio=false;
 		this.numero_anios=0;
 		this.numero_meses=0;
 		this.id_tipo_ubicacion_negocio=-1L;
 		this.empleados_fijos=0;
 		this.empleado_temporales=0;
 		this.empleados_total=0;
 		this.porcentaje_ventas_contado=0.0;
 		this.porcentaje_ventas_credito=0.0;
 		this.plazo_dias=0;
 		this.numero_clientes=0;
 		this.monto_maximo_ventas_mensual=0.0;
 		this.monto_minimo_ventas_mensual=0.0;
 		this.es_enero_alto=false;
 		this.es_febrero_alto=false;
 		this.es_marzo_alto=false;
 		this.es_abril_alto=false;
 		this.es_mayo_alto=false;
 		this.es_junio_alto=false;
 		this.es_julio_alto=false;
 		this.es_agosto_alto=false;
 		this.es_septiembre_alto=false;
 		this.es_octubre_alto=false;
 		this.es_noviembre_alto=false;
 		this.es_diciembre_alto=false;
 		this.es_enero_bajo=false;
 		this.es_febrero_bajo=false;
 		this.es_marzo_bajo=false;
 		this.es_abril_bajo=false;
 		this.es_mayo_bajo=false;
 		this.es_junio_bajo=false;
 		this.es_julio_bajo=false;
 		this.es_agosto_bajo=false;
 		this.es_septiembre_bajo=false;
 		this.es_octubre_bajo=false;
 		this.es_noviembre_bajo=false;
 		this.es_diciembre_bajo=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.cliente=null;
		this.tipoubicacionnegocio=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tipoubicacionnegocio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NegocioCliente (Long id,Date versionRow,Long id_empresa,Long id_cliente,String nombre_quien_se_factura,String fax,String ruc,String telefono,String nombre_local,String e_mail,String direccion,Boolean es_local_propio,Integer numero_anios,Integer numero_meses,Long id_tipo_ubicacion_negocio,Integer empleados_fijos,Integer empleado_temporales,Integer empleados_total,Double porcentaje_ventas_contado,Double porcentaje_ventas_credito,Integer plazo_dias,Integer numero_clientes,Double monto_maximo_ventas_mensual,Double monto_minimo_ventas_mensual,Boolean es_enero_alto,Boolean es_febrero_alto,Boolean es_marzo_alto,Boolean es_abril_alto,Boolean es_mayo_alto,Boolean es_junio_alto,Boolean es_julio_alto,Boolean es_agosto_alto,Boolean es_septiembre_alto,Boolean es_octubre_alto,Boolean es_noviembre_alto,Boolean es_diciembre_alto,Boolean es_enero_bajo,Boolean es_febrero_bajo,Boolean es_marzo_bajo,Boolean es_abril_bajo,Boolean es_mayo_bajo,Boolean es_junio_bajo,Boolean es_julio_bajo,Boolean es_agosto_bajo,Boolean es_septiembre_bajo,Boolean es_octubre_bajo,Boolean es_noviembre_bajo,Boolean es_diciembre_bajo,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.negocioclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.nombre_quien_se_factura=nombre_quien_se_factura;
 		this.fax=fax;
 		this.ruc=ruc;
 		this.telefono=telefono;
 		this.nombre_local=nombre_local;
 		this.e_mail=e_mail;
 		this.direccion=direccion;
 		this.es_local_propio=es_local_propio;
 		this.numero_anios=numero_anios;
 		this.numero_meses=numero_meses;
 		this.id_tipo_ubicacion_negocio=id_tipo_ubicacion_negocio;
 		this.empleados_fijos=empleados_fijos;
 		this.empleado_temporales=empleado_temporales;
 		this.empleados_total=empleados_total;
 		this.porcentaje_ventas_contado=porcentaje_ventas_contado;
 		this.porcentaje_ventas_credito=porcentaje_ventas_credito;
 		this.plazo_dias=plazo_dias;
 		this.numero_clientes=numero_clientes;
 		this.monto_maximo_ventas_mensual=monto_maximo_ventas_mensual;
 		this.monto_minimo_ventas_mensual=monto_minimo_ventas_mensual;
 		this.es_enero_alto=es_enero_alto;
 		this.es_febrero_alto=es_febrero_alto;
 		this.es_marzo_alto=es_marzo_alto;
 		this.es_abril_alto=es_abril_alto;
 		this.es_mayo_alto=es_mayo_alto;
 		this.es_junio_alto=es_junio_alto;
 		this.es_julio_alto=es_julio_alto;
 		this.es_agosto_alto=es_agosto_alto;
 		this.es_septiembre_alto=es_septiembre_alto;
 		this.es_octubre_alto=es_octubre_alto;
 		this.es_noviembre_alto=es_noviembre_alto;
 		this.es_diciembre_alto=es_diciembre_alto;
 		this.es_enero_bajo=es_enero_bajo;
 		this.es_febrero_bajo=es_febrero_bajo;
 		this.es_marzo_bajo=es_marzo_bajo;
 		this.es_abril_bajo=es_abril_bajo;
 		this.es_mayo_bajo=es_mayo_bajo;
 		this.es_junio_bajo=es_junio_bajo;
 		this.es_julio_bajo=es_julio_bajo;
 		this.es_agosto_bajo=es_agosto_bajo;
 		this.es_septiembre_bajo=es_septiembre_bajo;
 		this.es_octubre_bajo=es_octubre_bajo;
 		this.es_noviembre_bajo=es_noviembre_bajo;
 		this.es_diciembre_bajo=es_diciembre_bajo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NegocioCliente (Long id_empresa,Long id_cliente,String nombre_quien_se_factura,String fax,String ruc,String telefono,String nombre_local,String e_mail,String direccion,Boolean es_local_propio,Integer numero_anios,Integer numero_meses,Long id_tipo_ubicacion_negocio,Integer empleados_fijos,Integer empleado_temporales,Integer empleados_total,Double porcentaje_ventas_contado,Double porcentaje_ventas_credito,Integer plazo_dias,Integer numero_clientes,Double monto_maximo_ventas_mensual,Double monto_minimo_ventas_mensual,Boolean es_enero_alto,Boolean es_febrero_alto,Boolean es_marzo_alto,Boolean es_abril_alto,Boolean es_mayo_alto,Boolean es_junio_alto,Boolean es_julio_alto,Boolean es_agosto_alto,Boolean es_septiembre_alto,Boolean es_octubre_alto,Boolean es_noviembre_alto,Boolean es_diciembre_alto,Boolean es_enero_bajo,Boolean es_febrero_bajo,Boolean es_marzo_bajo,Boolean es_abril_bajo,Boolean es_mayo_bajo,Boolean es_junio_bajo,Boolean es_julio_bajo,Boolean es_agosto_bajo,Boolean es_septiembre_bajo,Boolean es_octubre_bajo,Boolean es_noviembre_bajo,Boolean es_diciembre_bajo,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.negocioclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.nombre_quien_se_factura=nombre_quien_se_factura;
 		this.fax=fax;
 		this.ruc=ruc;
 		this.telefono=telefono;
 		this.nombre_local=nombre_local;
 		this.e_mail=e_mail;
 		this.direccion=direccion;
 		this.es_local_propio=es_local_propio;
 		this.numero_anios=numero_anios;
 		this.numero_meses=numero_meses;
 		this.id_tipo_ubicacion_negocio=id_tipo_ubicacion_negocio;
 		this.empleados_fijos=empleados_fijos;
 		this.empleado_temporales=empleado_temporales;
 		this.empleados_total=empleados_total;
 		this.porcentaje_ventas_contado=porcentaje_ventas_contado;
 		this.porcentaje_ventas_credito=porcentaje_ventas_credito;
 		this.plazo_dias=plazo_dias;
 		this.numero_clientes=numero_clientes;
 		this.monto_maximo_ventas_mensual=monto_maximo_ventas_mensual;
 		this.monto_minimo_ventas_mensual=monto_minimo_ventas_mensual;
 		this.es_enero_alto=es_enero_alto;
 		this.es_febrero_alto=es_febrero_alto;
 		this.es_marzo_alto=es_marzo_alto;
 		this.es_abril_alto=es_abril_alto;
 		this.es_mayo_alto=es_mayo_alto;
 		this.es_junio_alto=es_junio_alto;
 		this.es_julio_alto=es_julio_alto;
 		this.es_agosto_alto=es_agosto_alto;
 		this.es_septiembre_alto=es_septiembre_alto;
 		this.es_octubre_alto=es_octubre_alto;
 		this.es_noviembre_alto=es_noviembre_alto;
 		this.es_diciembre_alto=es_diciembre_alto;
 		this.es_enero_bajo=es_enero_bajo;
 		this.es_febrero_bajo=es_febrero_bajo;
 		this.es_marzo_bajo=es_marzo_bajo;
 		this.es_abril_bajo=es_abril_bajo;
 		this.es_mayo_bajo=es_mayo_bajo;
 		this.es_junio_bajo=es_junio_bajo;
 		this.es_julio_bajo=es_julio_bajo;
 		this.es_agosto_bajo=es_agosto_bajo;
 		this.es_septiembre_bajo=es_septiembre_bajo;
 		this.es_octubre_bajo=es_octubre_bajo;
 		this.es_noviembre_bajo=es_noviembre_bajo;
 		this.es_diciembre_bajo=es_diciembre_bajo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NegocioCliente negocioclienteLocal=null;
		
		if(object!=null) {
			negocioclienteLocal=(NegocioCliente)object;
			
			if(negocioclienteLocal!=null) {
				if(this.getId()!=null && negocioclienteLocal.getId()!=null) {
					if(this.getId().equals(negocioclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NegocioClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NegocioClienteConstantesFunciones.getNegocioClienteDescripcion(this);
		} else {
			sDetalle=NegocioClienteConstantesFunciones.getNegocioClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NegocioCliente getNegocioClienteOriginal() {
		return this.negocioclienteOriginal;
	}
	
	public void setNegocioClienteOriginal(NegocioCliente negociocliente) {
		try {
			this.negocioclienteOriginal=negociocliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NegocioClienteAdditional negocioclienteAdditional=null;
	
	public NegocioClienteAdditional getNegocioClienteAdditional() {
		return this.negocioclienteAdditional;
	}
	
	public void setNegocioClienteAdditional(NegocioClienteAdditional negocioclienteAdditional) {
		try {
			this.negocioclienteAdditional=negocioclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getnombre_quien_se_factura() {
		return this.nombre_quien_se_factura;
	}
    
	
	public String getfax() {
		return this.fax;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getnombre_local() {
		return this.nombre_local;
	}
    
	
	public String gete_mail() {
		return this.e_mail;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public Boolean getes_local_propio() {
		return this.es_local_propio;
	}
    
	
	public Integer getnumero_anios() {
		return this.numero_anios;
	}
    
	
	public Integer getnumero_meses() {
		return this.numero_meses;
	}
    
	
	public Long getid_tipo_ubicacion_negocio() {
		return this.id_tipo_ubicacion_negocio;
	}
    
	
	public Integer getempleados_fijos() {
		return this.empleados_fijos;
	}
    
	
	public Integer getempleado_temporales() {
		return this.empleado_temporales;
	}
    
	
	public Integer getempleados_total() {
		return this.empleados_total;
	}
    
	
	public Double getporcentaje_ventas_contado() {
		return this.porcentaje_ventas_contado;
	}
    
	
	public Double getporcentaje_ventas_credito() {
		return this.porcentaje_ventas_credito;
	}
    
	
	public Integer getplazo_dias() {
		return this.plazo_dias;
	}
    
	
	public Integer getnumero_clientes() {
		return this.numero_clientes;
	}
    
	
	public Double getmonto_maximo_ventas_mensual() {
		return this.monto_maximo_ventas_mensual;
	}
    
	
	public Double getmonto_minimo_ventas_mensual() {
		return this.monto_minimo_ventas_mensual;
	}
    
	
	public Boolean getes_enero_alto() {
		return this.es_enero_alto;
	}
    
	
	public Boolean getes_febrero_alto() {
		return this.es_febrero_alto;
	}
    
	
	public Boolean getes_marzo_alto() {
		return this.es_marzo_alto;
	}
    
	
	public Boolean getes_abril_alto() {
		return this.es_abril_alto;
	}
    
	
	public Boolean getes_mayo_alto() {
		return this.es_mayo_alto;
	}
    
	
	public Boolean getes_junio_alto() {
		return this.es_junio_alto;
	}
    
	
	public Boolean getes_julio_alto() {
		return this.es_julio_alto;
	}
    
	
	public Boolean getes_agosto_alto() {
		return this.es_agosto_alto;
	}
    
	
	public Boolean getes_septiembre_alto() {
		return this.es_septiembre_alto;
	}
    
	
	public Boolean getes_octubre_alto() {
		return this.es_octubre_alto;
	}
    
	
	public Boolean getes_noviembre_alto() {
		return this.es_noviembre_alto;
	}
    
	
	public Boolean getes_diciembre_alto() {
		return this.es_diciembre_alto;
	}
    
	
	public Boolean getes_enero_bajo() {
		return this.es_enero_bajo;
	}
    
	
	public Boolean getes_febrero_bajo() {
		return this.es_febrero_bajo;
	}
    
	
	public Boolean getes_marzo_bajo() {
		return this.es_marzo_bajo;
	}
    
	
	public Boolean getes_abril_bajo() {
		return this.es_abril_bajo;
	}
    
	
	public Boolean getes_mayo_bajo() {
		return this.es_mayo_bajo;
	}
    
	
	public Boolean getes_junio_bajo() {
		return this.es_junio_bajo;
	}
    
	
	public Boolean getes_julio_bajo() {
		return this.es_julio_bajo;
	}
    
	
	public Boolean getes_agosto_bajo() {
		return this.es_agosto_bajo;
	}
    
	
	public Boolean getes_septiembre_bajo() {
		return this.es_septiembre_bajo;
	}
    
	
	public Boolean getes_octubre_bajo() {
		return this.es_octubre_bajo;
	}
    
	
	public Boolean getes_noviembre_bajo() {
		return this.es_noviembre_bajo;
	}
    
	
	public Boolean getes_diciembre_bajo() {
		return this.es_diciembre_bajo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("NegocioCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_quien_se_factura(String newnombre_quien_se_factura)throws Exception
	{
		try {
			if(this.nombre_quien_se_factura!=newnombre_quien_se_factura) {
				if(newnombre_quien_se_factura==null) {
					//newnombre_quien_se_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna nombre_quien_se_factura");
					}
				}

				if(newnombre_quien_se_factura!=null&&newnombre_quien_se_factura.length()>100) {
					newnombre_quien_se_factura=newnombre_quien_se_factura.substring(0,98);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_quien_se_factura");
				}

				this.nombre_quien_se_factura=newnombre_quien_se_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfax(String newfax)throws Exception
	{
		try {
			if(this.fax!=newfax) {
				if(newfax==null) {
					//newfax="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna fax");
					}
				}

				if(newfax!=null&&newfax.length()>50) {
					newfax=newfax.substring(0,48);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fax");
				}

				this.fax=newfax;
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
						System.out.println("NegocioCliente:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
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
						System.out.println("NegocioCliente:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_local(String newnombre_local)throws Exception
	{
		try {
			if(this.nombre_local!=newnombre_local) {
				if(newnombre_local==null) {
					//newnombre_local="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna nombre_local");
					}
				}

				if(newnombre_local!=null&&newnombre_local.length()>150) {
					newnombre_local=newnombre_local.substring(0,148);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_local");
				}

				this.nombre_local=newnombre_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sete_mail(String newe_mail)throws Exception
	{
		try {
			if(this.e_mail!=newe_mail) {
				if(newe_mail==null) {
					//newe_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna e_mail");
					}
				}

				if(newe_mail!=null&&newe_mail.length()>50) {
					newe_mail=newe_mail.substring(0,48);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna e_mail");
				}

				this.e_mail=newe_mail;
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
						System.out.println("NegocioCliente:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_local_propio(Boolean newes_local_propio)throws Exception
	{
		try {
			if(this.es_local_propio!=newes_local_propio) {
				if(newes_local_propio==null) {
					//newes_local_propio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_local_propio");
					}
				}

				this.es_local_propio=newes_local_propio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_anios(Integer newnumero_anios)throws Exception
	{
		try {
			if(this.numero_anios!=newnumero_anios) {
				if(newnumero_anios==null) {
					//newnumero_anios=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna numero_anios");
					}
				}

				this.numero_anios=newnumero_anios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_meses(Integer newnumero_meses)throws Exception
	{
		try {
			if(this.numero_meses!=newnumero_meses) {
				if(newnumero_meses==null) {
					//newnumero_meses=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna numero_meses");
					}
				}

				this.numero_meses=newnumero_meses;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_ubicacion_negocio(Long newid_tipo_ubicacion_negocio)throws Exception
	{
		try {
			if(this.id_tipo_ubicacion_negocio!=newid_tipo_ubicacion_negocio) {
				if(newid_tipo_ubicacion_negocio==null) {
					//newid_tipo_ubicacion_negocio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna id_tipo_ubicacion_negocio");
					}
				}

				this.id_tipo_ubicacion_negocio=newid_tipo_ubicacion_negocio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempleados_fijos(Integer newempleados_fijos)throws Exception
	{
		try {
			if(this.empleados_fijos!=newempleados_fijos) {
				if(newempleados_fijos==null) {
					//newempleados_fijos=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna empleados_fijos");
					}
				}

				this.empleados_fijos=newempleados_fijos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempleado_temporales(Integer newempleado_temporales)throws Exception
	{
		try {
			if(this.empleado_temporales!=newempleado_temporales) {
				if(newempleado_temporales==null) {
					//newempleado_temporales=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna empleado_temporales");
					}
				}

				this.empleado_temporales=newempleado_temporales;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempleados_total(Integer newempleados_total)throws Exception
	{
		try {
			if(this.empleados_total!=newempleados_total) {
				if(newempleados_total==null) {
					//newempleados_total=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna empleados_total");
					}
				}

				this.empleados_total=newempleados_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_ventas_contado(Double newporcentaje_ventas_contado)throws Exception
	{
		try {
			if(this.porcentaje_ventas_contado!=newporcentaje_ventas_contado) {
				if(newporcentaje_ventas_contado==null) {
					//newporcentaje_ventas_contado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna porcentaje_ventas_contado");
					}
				}

				this.porcentaje_ventas_contado=newporcentaje_ventas_contado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_ventas_credito(Double newporcentaje_ventas_credito)throws Exception
	{
		try {
			if(this.porcentaje_ventas_credito!=newporcentaje_ventas_credito) {
				if(newporcentaje_ventas_credito==null) {
					//newporcentaje_ventas_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna porcentaje_ventas_credito");
					}
				}

				this.porcentaje_ventas_credito=newporcentaje_ventas_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplazo_dias(Integer newplazo_dias)throws Exception
	{
		try {
			if(this.plazo_dias!=newplazo_dias) {
				if(newplazo_dias==null) {
					//newplazo_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna plazo_dias");
					}
				}

				this.plazo_dias=newplazo_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_clientes(Integer newnumero_clientes)throws Exception
	{
		try {
			if(this.numero_clientes!=newnumero_clientes) {
				if(newnumero_clientes==null) {
					//newnumero_clientes=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna numero_clientes");
					}
				}

				this.numero_clientes=newnumero_clientes;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_maximo_ventas_mensual(Double newmonto_maximo_ventas_mensual)throws Exception
	{
		try {
			if(this.monto_maximo_ventas_mensual!=newmonto_maximo_ventas_mensual) {
				if(newmonto_maximo_ventas_mensual==null) {
					//newmonto_maximo_ventas_mensual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna monto_maximo_ventas_mensual");
					}
				}

				this.monto_maximo_ventas_mensual=newmonto_maximo_ventas_mensual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_minimo_ventas_mensual(Double newmonto_minimo_ventas_mensual)throws Exception
	{
		try {
			if(this.monto_minimo_ventas_mensual!=newmonto_minimo_ventas_mensual) {
				if(newmonto_minimo_ventas_mensual==null) {
					//newmonto_minimo_ventas_mensual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna monto_minimo_ventas_mensual");
					}
				}

				this.monto_minimo_ventas_mensual=newmonto_minimo_ventas_mensual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_enero_alto(Boolean newes_enero_alto)throws Exception
	{
		try {
			if(this.es_enero_alto!=newes_enero_alto) {
				if(newes_enero_alto==null) {
					//newes_enero_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_enero_alto");
					}
				}

				this.es_enero_alto=newes_enero_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_febrero_alto(Boolean newes_febrero_alto)throws Exception
	{
		try {
			if(this.es_febrero_alto!=newes_febrero_alto) {
				if(newes_febrero_alto==null) {
					//newes_febrero_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_febrero_alto");
					}
				}

				this.es_febrero_alto=newes_febrero_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_marzo_alto(Boolean newes_marzo_alto)throws Exception
	{
		try {
			if(this.es_marzo_alto!=newes_marzo_alto) {
				if(newes_marzo_alto==null) {
					//newes_marzo_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_marzo_alto");
					}
				}

				this.es_marzo_alto=newes_marzo_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_abril_alto(Boolean newes_abril_alto)throws Exception
	{
		try {
			if(this.es_abril_alto!=newes_abril_alto) {
				if(newes_abril_alto==null) {
					//newes_abril_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_abril_alto");
					}
				}

				this.es_abril_alto=newes_abril_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_mayo_alto(Boolean newes_mayo_alto)throws Exception
	{
		try {
			if(this.es_mayo_alto!=newes_mayo_alto) {
				if(newes_mayo_alto==null) {
					//newes_mayo_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_mayo_alto");
					}
				}

				this.es_mayo_alto=newes_mayo_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_junio_alto(Boolean newes_junio_alto)throws Exception
	{
		try {
			if(this.es_junio_alto!=newes_junio_alto) {
				if(newes_junio_alto==null) {
					//newes_junio_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_junio_alto");
					}
				}

				this.es_junio_alto=newes_junio_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_julio_alto(Boolean newes_julio_alto)throws Exception
	{
		try {
			if(this.es_julio_alto!=newes_julio_alto) {
				if(newes_julio_alto==null) {
					//newes_julio_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_julio_alto");
					}
				}

				this.es_julio_alto=newes_julio_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_agosto_alto(Boolean newes_agosto_alto)throws Exception
	{
		try {
			if(this.es_agosto_alto!=newes_agosto_alto) {
				if(newes_agosto_alto==null) {
					//newes_agosto_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_agosto_alto");
					}
				}

				this.es_agosto_alto=newes_agosto_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_septiembre_alto(Boolean newes_septiembre_alto)throws Exception
	{
		try {
			if(this.es_septiembre_alto!=newes_septiembre_alto) {
				if(newes_septiembre_alto==null) {
					//newes_septiembre_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_septiembre_alto");
					}
				}

				this.es_septiembre_alto=newes_septiembre_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_octubre_alto(Boolean newes_octubre_alto)throws Exception
	{
		try {
			if(this.es_octubre_alto!=newes_octubre_alto) {
				if(newes_octubre_alto==null) {
					//newes_octubre_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_octubre_alto");
					}
				}

				this.es_octubre_alto=newes_octubre_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_noviembre_alto(Boolean newes_noviembre_alto)throws Exception
	{
		try {
			if(this.es_noviembre_alto!=newes_noviembre_alto) {
				if(newes_noviembre_alto==null) {
					//newes_noviembre_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_noviembre_alto");
					}
				}

				this.es_noviembre_alto=newes_noviembre_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_diciembre_alto(Boolean newes_diciembre_alto)throws Exception
	{
		try {
			if(this.es_diciembre_alto!=newes_diciembre_alto) {
				if(newes_diciembre_alto==null) {
					//newes_diciembre_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_diciembre_alto");
					}
				}

				this.es_diciembre_alto=newes_diciembre_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_enero_bajo(Boolean newes_enero_bajo)throws Exception
	{
		try {
			if(this.es_enero_bajo!=newes_enero_bajo) {
				if(newes_enero_bajo==null) {
					//newes_enero_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_enero_bajo");
					}
				}

				this.es_enero_bajo=newes_enero_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_febrero_bajo(Boolean newes_febrero_bajo)throws Exception
	{
		try {
			if(this.es_febrero_bajo!=newes_febrero_bajo) {
				if(newes_febrero_bajo==null) {
					//newes_febrero_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_febrero_bajo");
					}
				}

				this.es_febrero_bajo=newes_febrero_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_marzo_bajo(Boolean newes_marzo_bajo)throws Exception
	{
		try {
			if(this.es_marzo_bajo!=newes_marzo_bajo) {
				if(newes_marzo_bajo==null) {
					//newes_marzo_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_marzo_bajo");
					}
				}

				this.es_marzo_bajo=newes_marzo_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_abril_bajo(Boolean newes_abril_bajo)throws Exception
	{
		try {
			if(this.es_abril_bajo!=newes_abril_bajo) {
				if(newes_abril_bajo==null) {
					//newes_abril_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_abril_bajo");
					}
				}

				this.es_abril_bajo=newes_abril_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_mayo_bajo(Boolean newes_mayo_bajo)throws Exception
	{
		try {
			if(this.es_mayo_bajo!=newes_mayo_bajo) {
				if(newes_mayo_bajo==null) {
					//newes_mayo_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_mayo_bajo");
					}
				}

				this.es_mayo_bajo=newes_mayo_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_junio_bajo(Boolean newes_junio_bajo)throws Exception
	{
		try {
			if(this.es_junio_bajo!=newes_junio_bajo) {
				if(newes_junio_bajo==null) {
					//newes_junio_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_junio_bajo");
					}
				}

				this.es_junio_bajo=newes_junio_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_julio_bajo(Boolean newes_julio_bajo)throws Exception
	{
		try {
			if(this.es_julio_bajo!=newes_julio_bajo) {
				if(newes_julio_bajo==null) {
					//newes_julio_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_julio_bajo");
					}
				}

				this.es_julio_bajo=newes_julio_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_agosto_bajo(Boolean newes_agosto_bajo)throws Exception
	{
		try {
			if(this.es_agosto_bajo!=newes_agosto_bajo) {
				if(newes_agosto_bajo==null) {
					//newes_agosto_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_agosto_bajo");
					}
				}

				this.es_agosto_bajo=newes_agosto_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_septiembre_bajo(Boolean newes_septiembre_bajo)throws Exception
	{
		try {
			if(this.es_septiembre_bajo!=newes_septiembre_bajo) {
				if(newes_septiembre_bajo==null) {
					//newes_septiembre_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_septiembre_bajo");
					}
				}

				this.es_septiembre_bajo=newes_septiembre_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_octubre_bajo(Boolean newes_octubre_bajo)throws Exception
	{
		try {
			if(this.es_octubre_bajo!=newes_octubre_bajo) {
				if(newes_octubre_bajo==null) {
					//newes_octubre_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_octubre_bajo");
					}
				}

				this.es_octubre_bajo=newes_octubre_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_noviembre_bajo(Boolean newes_noviembre_bajo)throws Exception
	{
		try {
			if(this.es_noviembre_bajo!=newes_noviembre_bajo) {
				if(newes_noviembre_bajo==null) {
					//newes_noviembre_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_noviembre_bajo");
					}
				}

				this.es_noviembre_bajo=newes_noviembre_bajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_diciembre_bajo(Boolean newes_diciembre_bajo)throws Exception
	{
		try {
			if(this.es_diciembre_bajo!=newes_diciembre_bajo) {
				if(newes_diciembre_bajo==null) {
					//newes_diciembre_bajo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NegocioCliente:Valor nulo no permitido en columna es_diciembre_bajo");
					}
				}

				this.es_diciembre_bajo=newes_diciembre_bajo;
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
						System.out.println("NegocioCliente:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("NegocioCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoUbicacionNegocio getTipoUbicacionNegocio() {
		return this.tipoubicacionnegocio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoubicacionnegocio_descripcion() {
		return this.tipoubicacionnegocio_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio) {
		try {
			this.tipoubicacionnegocio=tipoubicacionnegocio;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoubicacionnegocio_descripcion(String tipoubicacionnegocio_descripcion) {
		try {
			this.tipoubicacionnegocio_descripcion=tipoubicacionnegocio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String es_local_propio_descripcion="";String id_tipo_ubicacion_negocio_descripcion="";String es_enero_alto_descripcion="";String es_febrero_alto_descripcion="";String es_marzo_alto_descripcion="";String es_abril_alto_descripcion="";String es_mayo_alto_descripcion="";String es_junio_alto_descripcion="";String es_julio_alto_descripcion="";String es_agosto_alto_descripcion="";String es_septiembre_alto_descripcion="";String es_octubre_alto_descripcion="";String es_noviembre_alto_descripcion="";String es_diciembre_alto_descripcion="";String es_enero_bajo_descripcion="";String es_febrero_bajo_descripcion="";String es_marzo_bajo_descripcion="";String es_abril_bajo_descripcion="";String es_mayo_bajo_descripcion="";String es_junio_bajo_descripcion="";String es_julio_bajo_descripcion="";String es_agosto_bajo_descripcion="";String es_septiembre_bajo_descripcion="";String es_octubre_bajo_descripcion="";String es_noviembre_bajo_descripcion="";String es_diciembre_bajo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_local_propio_descripcion() {
		return es_local_propio_descripcion;
	}
	public String getid_tipo_ubicacion_negocio_descripcion() {
		return id_tipo_ubicacion_negocio_descripcion;
	}
	public String getes_enero_alto_descripcion() {
		return es_enero_alto_descripcion;
	}
	public String getes_febrero_alto_descripcion() {
		return es_febrero_alto_descripcion;
	}
	public String getes_marzo_alto_descripcion() {
		return es_marzo_alto_descripcion;
	}
	public String getes_abril_alto_descripcion() {
		return es_abril_alto_descripcion;
	}
	public String getes_mayo_alto_descripcion() {
		return es_mayo_alto_descripcion;
	}
	public String getes_junio_alto_descripcion() {
		return es_junio_alto_descripcion;
	}
	public String getes_julio_alto_descripcion() {
		return es_julio_alto_descripcion;
	}
	public String getes_agosto_alto_descripcion() {
		return es_agosto_alto_descripcion;
	}
	public String getes_septiembre_alto_descripcion() {
		return es_septiembre_alto_descripcion;
	}
	public String getes_octubre_alto_descripcion() {
		return es_octubre_alto_descripcion;
	}
	public String getes_noviembre_alto_descripcion() {
		return es_noviembre_alto_descripcion;
	}
	public String getes_diciembre_alto_descripcion() {
		return es_diciembre_alto_descripcion;
	}
	public String getes_enero_bajo_descripcion() {
		return es_enero_bajo_descripcion;
	}
	public String getes_febrero_bajo_descripcion() {
		return es_febrero_bajo_descripcion;
	}
	public String getes_marzo_bajo_descripcion() {
		return es_marzo_bajo_descripcion;
	}
	public String getes_abril_bajo_descripcion() {
		return es_abril_bajo_descripcion;
	}
	public String getes_mayo_bajo_descripcion() {
		return es_mayo_bajo_descripcion;
	}
	public String getes_junio_bajo_descripcion() {
		return es_junio_bajo_descripcion;
	}
	public String getes_julio_bajo_descripcion() {
		return es_julio_bajo_descripcion;
	}
	public String getes_agosto_bajo_descripcion() {
		return es_agosto_bajo_descripcion;
	}
	public String getes_septiembre_bajo_descripcion() {
		return es_septiembre_bajo_descripcion;
	}
	public String getes_octubre_bajo_descripcion() {
		return es_octubre_bajo_descripcion;
	}
	public String getes_noviembre_bajo_descripcion() {
		return es_noviembre_bajo_descripcion;
	}
	public String getes_diciembre_bajo_descripcion() {
		return es_diciembre_bajo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setes_local_propio_descripcion(String newes_local_propio_descripcion)throws Exception {
		try {
			this.es_local_propio_descripcion=newes_local_propio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_ubicacion_negocio_descripcion(String newid_tipo_ubicacion_negocio_descripcion)throws Exception {
		try {
			this.id_tipo_ubicacion_negocio_descripcion=newid_tipo_ubicacion_negocio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_enero_alto_descripcion(String newes_enero_alto_descripcion)throws Exception {
		try {
			this.es_enero_alto_descripcion=newes_enero_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_febrero_alto_descripcion(String newes_febrero_alto_descripcion)throws Exception {
		try {
			this.es_febrero_alto_descripcion=newes_febrero_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_marzo_alto_descripcion(String newes_marzo_alto_descripcion)throws Exception {
		try {
			this.es_marzo_alto_descripcion=newes_marzo_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_abril_alto_descripcion(String newes_abril_alto_descripcion)throws Exception {
		try {
			this.es_abril_alto_descripcion=newes_abril_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_mayo_alto_descripcion(String newes_mayo_alto_descripcion)throws Exception {
		try {
			this.es_mayo_alto_descripcion=newes_mayo_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_junio_alto_descripcion(String newes_junio_alto_descripcion)throws Exception {
		try {
			this.es_junio_alto_descripcion=newes_junio_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_julio_alto_descripcion(String newes_julio_alto_descripcion)throws Exception {
		try {
			this.es_julio_alto_descripcion=newes_julio_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_agosto_alto_descripcion(String newes_agosto_alto_descripcion)throws Exception {
		try {
			this.es_agosto_alto_descripcion=newes_agosto_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_septiembre_alto_descripcion(String newes_septiembre_alto_descripcion)throws Exception {
		try {
			this.es_septiembre_alto_descripcion=newes_septiembre_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_octubre_alto_descripcion(String newes_octubre_alto_descripcion)throws Exception {
		try {
			this.es_octubre_alto_descripcion=newes_octubre_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_noviembre_alto_descripcion(String newes_noviembre_alto_descripcion)throws Exception {
		try {
			this.es_noviembre_alto_descripcion=newes_noviembre_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_diciembre_alto_descripcion(String newes_diciembre_alto_descripcion)throws Exception {
		try {
			this.es_diciembre_alto_descripcion=newes_diciembre_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_enero_bajo_descripcion(String newes_enero_bajo_descripcion)throws Exception {
		try {
			this.es_enero_bajo_descripcion=newes_enero_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_febrero_bajo_descripcion(String newes_febrero_bajo_descripcion)throws Exception {
		try {
			this.es_febrero_bajo_descripcion=newes_febrero_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_marzo_bajo_descripcion(String newes_marzo_bajo_descripcion)throws Exception {
		try {
			this.es_marzo_bajo_descripcion=newes_marzo_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_abril_bajo_descripcion(String newes_abril_bajo_descripcion)throws Exception {
		try {
			this.es_abril_bajo_descripcion=newes_abril_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_mayo_bajo_descripcion(String newes_mayo_bajo_descripcion)throws Exception {
		try {
			this.es_mayo_bajo_descripcion=newes_mayo_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_junio_bajo_descripcion(String newes_junio_bajo_descripcion)throws Exception {
		try {
			this.es_junio_bajo_descripcion=newes_junio_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_julio_bajo_descripcion(String newes_julio_bajo_descripcion)throws Exception {
		try {
			this.es_julio_bajo_descripcion=newes_julio_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_agosto_bajo_descripcion(String newes_agosto_bajo_descripcion)throws Exception {
		try {
			this.es_agosto_bajo_descripcion=newes_agosto_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_septiembre_bajo_descripcion(String newes_septiembre_bajo_descripcion)throws Exception {
		try {
			this.es_septiembre_bajo_descripcion=newes_septiembre_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_octubre_bajo_descripcion(String newes_octubre_bajo_descripcion)throws Exception {
		try {
			this.es_octubre_bajo_descripcion=newes_octubre_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_noviembre_bajo_descripcion(String newes_noviembre_bajo_descripcion)throws Exception {
		try {
			this.es_noviembre_bajo_descripcion=newes_noviembre_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_diciembre_bajo_descripcion(String newes_diciembre_bajo_descripcion)throws Exception {
		try {
			this.es_diciembre_bajo_descripcion=newes_diciembre_bajo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.es_local_propio_descripcion="";this.id_tipo_ubicacion_negocio_descripcion="";this.es_enero_alto_descripcion="";this.es_febrero_alto_descripcion="";this.es_marzo_alto_descripcion="";this.es_abril_alto_descripcion="";this.es_mayo_alto_descripcion="";this.es_junio_alto_descripcion="";this.es_julio_alto_descripcion="";this.es_agosto_alto_descripcion="";this.es_septiembre_alto_descripcion="";this.es_octubre_alto_descripcion="";this.es_noviembre_alto_descripcion="";this.es_diciembre_alto_descripcion="";this.es_enero_bajo_descripcion="";this.es_febrero_bajo_descripcion="";this.es_marzo_bajo_descripcion="";this.es_abril_bajo_descripcion="";this.es_mayo_bajo_descripcion="";this.es_junio_bajo_descripcion="";this.es_julio_bajo_descripcion="";this.es_agosto_bajo_descripcion="";this.es_septiembre_bajo_descripcion="";this.es_octubre_bajo_descripcion="";this.es_noviembre_bajo_descripcion="";this.es_diciembre_bajo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

