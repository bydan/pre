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
//import com.bydan.erp.cartera.util.ClienteRetencionConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ClienteRetencion extends ClienteRetencionAdditional implements Serializable ,Cloneable {//ClienteRetencionAdditional,GeneralEntity
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
	
	private ClienteRetencion clienteretencionOriginal;
	
	private Map<String, Object> mapClienteRetencion;
			
	public Map<String, Object> getMapClienteRetencion() {
		return mapClienteRetencion;
	}

	public void setMapClienteRetencion(Map<String, Object> mapClienteRetencion) {
		this.mapClienteRetencion = mapClienteRetencion;
	}
	
	public void inicializarMapClienteRetencion() {
		this.mapClienteRetencion = new HashMap<String,Object>();
	}
	
	public void setMapClienteRetencionValue(String sKey,Object oValue) {
		this.mapClienteRetencion.put(sKey, oValue);
	}
	
	public Object getMapClienteRetencionValue(String sKey) {
		return this.mapClienteRetencion.get(sKey);
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
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXNUMERO_RETENCION,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXDESCRIPCION,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_tipo_cambio;
	
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
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXBENEFICIARIO,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXBENEFICIARIO)
	private String beneficiario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXNOMBRE_BENEF,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXNOMBRE_BENEF)
	private String nombre_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXDIRECCION_BENEF,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXDIRECCION_BENEF)
	private String direccion_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXTELEFONO_BENEF,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXTELEFONO_BENEF)
	private String telefono_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ClienteRetencionConstantesFunciones.SREGEXRUC_BENEF,message=ClienteRetencionConstantesFunciones.SMENSAJEREGEXRUC_BENEF)
	private String ruc_benef;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_retencion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Cliente cliente;
	public Factura factura;
	public Transaccion transaccion;
	public TipoRetencion tiporetencion;
	public AsientoContable asientocontable;
	public CuentaContable cuentacontableclienteretencion;
	public EstadoRetencion estadoretencion;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String cliente_descripcion;
	private String factura_descripcion;
	private String transaccion_descripcion;
	private String tiporetencion_descripcion;
	private String asientocontable_descripcion;
	private String cuentacontableclienteretencion_descripcion;
	private String estadoretencion_descripcion;
	
	
		
	public ClienteRetencion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.clienteretencionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.fecha=new Date();
 		this.id_cliente=-1L;
 		this.id_factura=null;
 		this.id_transaccion=-1L;
 		this.id_tipo_retencion=-1L;
 		this.porcentaje=0.0;
 		this.base_imponible=0.0;
 		this.valor=0.0;
 		this.numero_retencion="";
 		this.descripcion="";
 		this.id_asiento_contable=-1L;
 		this.id_cuenta_contable_retencion=-1L;
 		this.valor_tipo_cambio=0.0;
 		this.debito_mone_local=0.0;
 		this.credito_mone_local=0.0;
 		this.debito_mone_extra=0.0;
 		this.credito_mone_extra=0.0;
 		this.beneficiario="";
 		this.nombre_benef="";
 		this.direccion_benef="";
 		this.telefono_benef="";
 		this.ruc_benef="";
 		this.id_estado_retencion=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.cliente=null;
		this.factura=null;
		this.transaccion=null;
		this.tiporetencion=null;
		this.asientocontable=null;
		this.cuentacontableclienteretencion=null;
		this.estadoretencion=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.cliente_descripcion="";
		this.factura_descripcion="";
		this.transaccion_descripcion="";
		this.tiporetencion_descripcion="";
		this.asientocontable_descripcion="";
		this.cuentacontableclienteretencion_descripcion="";
		this.estadoretencion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ClienteRetencion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Date fecha,Long id_cliente,Long id_factura,Long id_transaccion,Long id_tipo_retencion,Double porcentaje,Double base_imponible,Double valor,String numero_retencion,String descripcion,Long id_asiento_contable,Long id_cuenta_contable_retencion,Double valor_tipo_cambio,Double debito_mone_local,Double credito_mone_local,Double debito_mone_extra,Double credito_mone_extra,String beneficiario,String nombre_benef,String direccion_benef,String telefono_benef,String ruc_benef,Long id_estado_retencion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.id_transaccion=id_transaccion;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero_retencion=numero_retencion;
 		this.descripcion=descripcion;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_cuenta_contable_retencion=id_cuenta_contable_retencion;
 		this.valor_tipo_cambio=valor_tipo_cambio;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
 		this.credito_mone_extra=credito_mone_extra;
 		this.beneficiario=beneficiario;
 		this.nombre_benef=nombre_benef;
 		this.direccion_benef=direccion_benef;
 		this.telefono_benef=telefono_benef;
 		this.ruc_benef=ruc_benef;
 		this.id_estado_retencion=id_estado_retencion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ClienteRetencion (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Date fecha,Long id_cliente,Long id_factura,Long id_transaccion,Long id_tipo_retencion,Double porcentaje,Double base_imponible,Double valor,String numero_retencion,String descripcion,Long id_asiento_contable,Long id_cuenta_contable_retencion,Double valor_tipo_cambio,Double debito_mone_local,Double credito_mone_local,Double debito_mone_extra,Double credito_mone_extra,String beneficiario,String nombre_benef,String direccion_benef,String telefono_benef,String ruc_benef,Long id_estado_retencion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.id_cliente=id_cliente;
 		this.id_factura=id_factura;
 		this.id_transaccion=id_transaccion;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.porcentaje=porcentaje;
 		this.base_imponible=base_imponible;
 		this.valor=valor;
 		this.numero_retencion=numero_retencion;
 		this.descripcion=descripcion;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_cuenta_contable_retencion=id_cuenta_contable_retencion;
 		this.valor_tipo_cambio=valor_tipo_cambio;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.debito_mone_extra=debito_mone_extra;
 		this.credito_mone_extra=credito_mone_extra;
 		this.beneficiario=beneficiario;
 		this.nombre_benef=nombre_benef;
 		this.direccion_benef=direccion_benef;
 		this.telefono_benef=telefono_benef;
 		this.ruc_benef=ruc_benef;
 		this.id_estado_retencion=id_estado_retencion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ClienteRetencion clienteretencionLocal=null;
		
		if(object!=null) {
			clienteretencionLocal=(ClienteRetencion)object;
			
			if(clienteretencionLocal!=null) {
				if(this.getId()!=null && clienteretencionLocal.getId()!=null) {
					if(this.getId().equals(clienteretencionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ClienteRetencionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ClienteRetencionConstantesFunciones.getClienteRetencionDescripcion(this);
		} else {
			sDetalle=ClienteRetencionConstantesFunciones.getClienteRetencionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ClienteRetencion getClienteRetencionOriginal() {
		return this.clienteretencionOriginal;
	}
	
	public void setClienteRetencionOriginal(ClienteRetencion clienteretencion) {
		try {
			this.clienteretencionOriginal=clienteretencion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ClienteRetencionAdditional clienteretencionAdditional=null;
	
	public ClienteRetencionAdditional getClienteRetencionAdditional() {
		return this.clienteretencionAdditional;
	}
	
	public void setClienteRetencionAdditional(ClienteRetencionAdditional clienteretencionAdditional) {
		try {
			this.clienteretencionAdditional=clienteretencionAdditional;
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
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getbase_imponible() {
		return this.base_imponible;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_cuenta_contable_retencion() {
		return this.id_cuenta_contable_retencion;
	}
    
	
	public Double getvalor_tipo_cambio() {
		return this.valor_tipo_cambio;
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
    
	
	public String getbeneficiario() {
		return this.beneficiario;
	}
    
	
	public String getnombre_benef() {
		return this.nombre_benef;
	}
    
	
	public String getdireccion_benef() {
		return this.direccion_benef;
	}
    
	
	public String gettelefono_benef() {
		return this.telefono_benef;
	}
    
	
	public String getruc_benef() {
		return this.ruc_benef;
	}
    
	
	public Long getid_estado_retencion() {
		return this.id_estado_retencion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_periodo");
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
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion(Long newid_tipo_retencion)throws Exception
	{
		try {
			if(this.id_tipo_retencion!=newid_tipo_retencion) {
				if(newid_tipo_retencion==null) {
					//newid_tipo_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_imponible(Double newbase_imponible)throws Exception
	{
		try {
			if(this.base_imponible!=newbase_imponible) {
				if(newbase_imponible==null) {
					//newbase_imponible=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna base_imponible");
					}
				}

				this.base_imponible=newbase_imponible;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable)throws Exception
	{
		try {
			if(this.id_asiento_contable!=newid_asiento_contable) {
				if(newid_asiento_contable==null) {
					//newid_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_retencion(Long newid_cuenta_contable_retencion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_retencion!=newid_cuenta_contable_retencion) {
				if(newid_cuenta_contable_retencion==null) {
					//newid_cuenta_contable_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_cuenta_contable_retencion");
					}
				}

				this.id_cuenta_contable_retencion=newid_cuenta_contable_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_tipo_cambio(Double newvalor_tipo_cambio)throws Exception
	{
		try {
			if(this.valor_tipo_cambio!=newvalor_tipo_cambio) {
				if(newvalor_tipo_cambio==null) {
					//newvalor_tipo_cambio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna valor_tipo_cambio");
					}
				}

				this.valor_tipo_cambio=newvalor_tipo_cambio;
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna debito_mone_local");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna credito_mone_local");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna debito_mone_extra");
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
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna credito_mone_extra");
					}
				}

				this.credito_mone_extra=newcredito_mone_extra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbeneficiario(String newbeneficiario)throws Exception
	{
		try {
			if(this.beneficiario!=newbeneficiario) {
				if(newbeneficiario==null) {
					//newbeneficiario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna beneficiario");
					}
				}

				if(newbeneficiario!=null&&newbeneficiario.length()>200) {
					newbeneficiario=newbeneficiario.substring(0,198);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna beneficiario");
				}

				this.beneficiario=newbeneficiario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_benef(String newnombre_benef)throws Exception
	{
		try {
			if(this.nombre_benef!=newnombre_benef) {
				if(newnombre_benef==null) {
					//newnombre_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna nombre_benef");
					}
				}

				if(newnombre_benef!=null&&newnombre_benef.length()>150) {
					newnombre_benef=newnombre_benef.substring(0,148);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_benef");
				}

				this.nombre_benef=newnombre_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_benef(String newdireccion_benef)throws Exception
	{
		try {
			if(this.direccion_benef!=newdireccion_benef) {
				if(newdireccion_benef==null) {
					//newdireccion_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna direccion_benef");
					}
				}

				if(newdireccion_benef!=null&&newdireccion_benef.length()>150) {
					newdireccion_benef=newdireccion_benef.substring(0,148);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_benef");
				}

				this.direccion_benef=newdireccion_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_benef(String newtelefono_benef)throws Exception
	{
		try {
			if(this.telefono_benef!=newtelefono_benef) {
				if(newtelefono_benef==null) {
					//newtelefono_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna telefono_benef");
					}
				}

				if(newtelefono_benef!=null&&newtelefono_benef.length()>100) {
					newtelefono_benef=newtelefono_benef.substring(0,98);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono_benef");
				}

				this.telefono_benef=newtelefono_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_benef(String newruc_benef)throws Exception
	{
		try {
			if(this.ruc_benef!=newruc_benef) {
				if(newruc_benef==null) {
					//newruc_benef="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna ruc_benef");
					}
				}

				if(newruc_benef!=null&&newruc_benef.length()>15) {
					newruc_benef=newruc_benef.substring(0,13);
					System.out.println("ClienteRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc_benef");
				}

				this.ruc_benef=newruc_benef;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_retencion(Long newid_estado_retencion)throws Exception
	{
		try {
			if(this.id_estado_retencion!=newid_estado_retencion) {
				if(newid_estado_retencion==null) {
					//newid_estado_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteRetencion:Valor nulo no permitido en columna id_estado_retencion");
					}
				}

				this.id_estado_retencion=newid_estado_retencion;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public CuentaContable getCuentaContableClienteRetencion() {
		return this.cuentacontableclienteretencion;
	}

	public EstadoRetencion getEstadoRetencion() {
		return this.estadoretencion;
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

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getcuentacontableclienteretencion_descripcion() {
		return this.cuentacontableclienteretencion_descripcion;
	}

	public String getestadoretencion_descripcion() {
		return this.estadoretencion_descripcion;
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


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
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


	public  void  setCuentaContableClienteRetencion(CuentaContable cuentacontableclienteretencion) {
		try {
			this.cuentacontableclienteretencion=cuentacontableclienteretencion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoRetencion(EstadoRetencion estadoretencion) {
		try {
			this.estadoretencion=estadoretencion;
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


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
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


	public  void  setcuentacontableclienteretencion_descripcion(String cuentacontableclienteretencion_descripcion) {
		try {
			this.cuentacontableclienteretencion_descripcion=cuentacontableclienteretencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadoretencion_descripcion(String estadoretencion_descripcion) {
		try {
			this.estadoretencion_descripcion=estadoretencion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_cliente_descripcion="";String id_factura_descripcion="";String id_transaccion_descripcion="";String id_tipo_retencion_descripcion="";String id_asiento_contable_descripcion="";String id_cuenta_contable_retencion_descripcion="";String id_estado_retencion_descripcion="";
	
	
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
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_cuenta_contable_retencion_descripcion() {
		return id_cuenta_contable_retencion_descripcion;
	}
	public String getid_estado_retencion_descripcion() {
		return id_estado_retencion_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factura_descripcion(String newid_factura_descripcion) {
		this.id_factura_descripcion=newid_factura_descripcion;
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
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
	public void setid_cuenta_contable_retencion_descripcion(String newid_cuenta_contable_retencion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_retencion_descripcion=newid_cuenta_contable_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_retencion_descripcion(String newid_estado_retencion_descripcion)throws Exception {
		try {
			this.id_estado_retencion_descripcion=newid_estado_retencion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_cliente_descripcion="";this.id_factura_descripcion="";this.id_transaccion_descripcion="";this.id_tipo_retencion_descripcion="";this.id_asiento_contable_descripcion="";this.id_cuenta_contable_retencion_descripcion="";this.id_estado_retencion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

