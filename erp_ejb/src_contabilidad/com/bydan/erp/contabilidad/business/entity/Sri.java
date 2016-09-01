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
//import com.bydan.erp.contabilidad.util.SriConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.cartera.util.*;



import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class Sri extends SriAdditional implements Serializable ,Cloneable {//SriAdditional,GeneralEntity
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
	
	private Sri sriOriginal;
	
	private Map<String, Object> mapSri;
			
	public Map<String, Object> getMapSri() {
		return mapSri;
	}

	public void setMapSri(Map<String, Object> mapSri) {
		this.mapSri = mapSri;
	}
	
	public void inicializarMapSri() {
		this.mapSri = new HashMap<String,Object>();
	}
	
	public void setMapSriValue(String sKey,Object oValue) {
		this.mapSri.put(sKey, oValue);
	}
	
	public Object getMapSriValue(String sKey) {
		return this.mapSri.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_conta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SriConstantesFunciones.SREGEXRUC,message=SriConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SriConstantesFunciones.SREGEXRAZON_SOCIAL,message=SriConstantesFunciones.SMENSAJEREGEXRAZON_SOCIAL)
	private String razon_social;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_rise;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SriConstantesFunciones.SREGEXNUMERO_SERIE,message=SriConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SriConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=SriConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SriConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=SriConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_registro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long tipo_tributario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_tar12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_tar0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios_tar12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios_tar0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_impo_tar12;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_impo_tar0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva_bien;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva_bien;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion_iva_bien;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion_iva_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_movimiento;
			
	
	public AsientoContable asientocontable;
	public TransaccionConta transaccionconta;
	public Cliente cliente;
	public TipoComprobante tipocomprobante;
	public TipoTributario tipotributario;
	public TipoIva tipoiva;
	public TipoRetencionIva tiporetencionivabien;
	public TipoRetencionIva tiporetencionivaservicio;
	public TipoMovimiento tipomovimiento;
	
	
	private String asientocontable_descripcion;
	private String transaccionconta_descripcion;
	private String cliente_descripcion;
	private String tipocomprobante_descripcion;
	private String tipotributario_descripcion;
	private String tipoiva_descripcion;
	private String tiporetencionivabien_descripcion;
	private String tiporetencionivaservicio_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public Sri () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.sriOriginal=this;
		
 		this.id_asiento_contable=-1L;
 		this.id_transaccion_conta=-1L;
 		this.ruc="";
 		this.id_cliente=-1L;
 		this.razon_social="";
 		this.tipo_comprobante=-1L;
 		this.es_rise=false;
 		this.numero_serie="";
 		this.numero_autorizacion="";
 		this.numero_secuencial="";
 		this.fecha_emision=new Date();
 		this.fecha_registro_contable=new Date();
 		this.fecha_caducidad=new Date();
 		this.tipo_tributario=-1L;
 		this.bienes_tar12=0.0;
 		this.bienes_tar0=0.0;
 		this.id_tipo_iva=-1L;
 		this.servicios_tar12=0.0;
 		this.servicios_tar0=0.0;
 		this.monto_iva=0.0;
 		this.base_impo_tar12=0.0;
 		this.base_impo_tar0=0.0;
 		this.monto_ice=0.0;
 		this.monto_iva_bien=0.0;
 		this.monto_iva_servicio=0.0;
 		this.id_tipo_retencion_iva_bien=-1L;
 		this.id_tipo_retencion_iva_servicio=-1L;
 		this.retencion_iva_bien=0.0;
 		this.retencion_iva_servicio=0.0;
 		this.con_devolucion=false;
 		this.id_tipo_movimiento=-1L;
		
		
		this.asientocontable=null;
		this.transaccionconta=null;
		this.cliente=null;
		this.tipocomprobante=null;
		this.tipotributario=null;
		this.tipoiva=null;
		this.tiporetencionivabien=null;
		this.tiporetencionivaservicio=null;
		this.tipomovimiento=null;
		
		
		this.asientocontable_descripcion="";
		this.transaccionconta_descripcion="";
		this.cliente_descripcion="";
		this.tipocomprobante_descripcion="";
		this.tipotributario_descripcion="";
		this.tipoiva_descripcion="";
		this.tiporetencionivabien_descripcion="";
		this.tiporetencionivaservicio_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Sri (Long id,Date versionRow,Long id_asiento_contable,Long id_transaccion_conta,String ruc,Long id_cliente,String razon_social,Long tipo_comprobante,Boolean es_rise,String numero_serie,String numero_autorizacion,String numero_secuencial,Date fecha_emision,Date fecha_registro_contable,Date fecha_caducidad,Long tipo_tributario,Double bienes_tar12,Double bienes_tar0,Long id_tipo_iva,Double servicios_tar12,Double servicios_tar0,Double monto_iva,Double base_impo_tar12,Double base_impo_tar0,Double monto_ice,Double monto_iva_bien,Double monto_iva_servicio,Long id_tipo_retencion_iva_bien,Long id_tipo_retencion_iva_servicio,Double retencion_iva_bien,Double retencion_iva_servicio,Boolean con_devolucion,Long id_tipo_movimiento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sriOriginal=this;
		
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.ruc=ruc;
 		this.id_cliente=id_cliente;
 		this.razon_social=razon_social;
 		this.tipo_comprobante=tipo_comprobante;
 		this.es_rise=es_rise;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.fecha_caducidad=fecha_caducidad;
 		this.tipo_tributario=tipo_tributario;
 		this.bienes_tar12=bienes_tar12;
 		this.bienes_tar0=bienes_tar0;
 		this.id_tipo_iva=id_tipo_iva;
 		this.servicios_tar12=servicios_tar12;
 		this.servicios_tar0=servicios_tar0;
 		this.monto_iva=monto_iva;
 		this.base_impo_tar12=base_impo_tar12;
 		this.base_impo_tar0=base_impo_tar0;
 		this.monto_ice=monto_ice;
 		this.monto_iva_bien=monto_iva_bien;
 		this.monto_iva_servicio=monto_iva_servicio;
 		this.id_tipo_retencion_iva_bien=id_tipo_retencion_iva_bien;
 		this.id_tipo_retencion_iva_servicio=id_tipo_retencion_iva_servicio;
 		this.retencion_iva_bien=retencion_iva_bien;
 		this.retencion_iva_servicio=retencion_iva_servicio;
 		this.con_devolucion=con_devolucion;
 		this.id_tipo_movimiento=id_tipo_movimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Sri (Long id_asiento_contable,Long id_transaccion_conta,String ruc,Long id_cliente,String razon_social,Long tipo_comprobante,Boolean es_rise,String numero_serie,String numero_autorizacion,String numero_secuencial,Date fecha_emision,Date fecha_registro_contable,Date fecha_caducidad,Long tipo_tributario,Double bienes_tar12,Double bienes_tar0,Long id_tipo_iva,Double servicios_tar12,Double servicios_tar0,Double monto_iva,Double base_impo_tar12,Double base_impo_tar0,Double monto_ice,Double monto_iva_bien,Double monto_iva_servicio,Long id_tipo_retencion_iva_bien,Long id_tipo_retencion_iva_servicio,Double retencion_iva_bien,Double retencion_iva_servicio,Boolean con_devolucion,Long id_tipo_movimiento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sriOriginal=this;
		
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.ruc=ruc;
 		this.id_cliente=id_cliente;
 		this.razon_social=razon_social;
 		this.tipo_comprobante=tipo_comprobante;
 		this.es_rise=es_rise;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.fecha_caducidad=fecha_caducidad;
 		this.tipo_tributario=tipo_tributario;
 		this.bienes_tar12=bienes_tar12;
 		this.bienes_tar0=bienes_tar0;
 		this.id_tipo_iva=id_tipo_iva;
 		this.servicios_tar12=servicios_tar12;
 		this.servicios_tar0=servicios_tar0;
 		this.monto_iva=monto_iva;
 		this.base_impo_tar12=base_impo_tar12;
 		this.base_impo_tar0=base_impo_tar0;
 		this.monto_ice=monto_ice;
 		this.monto_iva_bien=monto_iva_bien;
 		this.monto_iva_servicio=monto_iva_servicio;
 		this.id_tipo_retencion_iva_bien=id_tipo_retencion_iva_bien;
 		this.id_tipo_retencion_iva_servicio=id_tipo_retencion_iva_servicio;
 		this.retencion_iva_bien=retencion_iva_bien;
 		this.retencion_iva_servicio=retencion_iva_servicio;
 		this.con_devolucion=con_devolucion;
 		this.id_tipo_movimiento=id_tipo_movimiento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Sri sriLocal=null;
		
		if(object!=null) {
			sriLocal=(Sri)object;
			
			if(sriLocal!=null) {
				if(this.getId()!=null && sriLocal.getId()!=null) {
					if(this.getId().equals(sriLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!SriConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=SriConstantesFunciones.getSriDescripcion(this);
		} else {
			sDetalle=SriConstantesFunciones.getSriDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Sri getSriOriginal() {
		return this.sriOriginal;
	}
	
	public void setSriOriginal(Sri sri) {
		try {
			this.sriOriginal=sri;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SriAdditional sriAdditional=null;
	
	public SriAdditional getSriAdditional() {
		return this.sriAdditional;
	}
	
	public void setSriAdditional(SriAdditional sriAdditional) {
		try {
			this.sriAdditional=sriAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_transaccion_conta() {
		return this.id_transaccion_conta;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getrazon_social() {
		return this.razon_social;
	}
    
	
	public Long gettipo_comprobante() {
		return this.tipo_comprobante;
	}
    
	
	public Boolean getes_rise() {
		return this.es_rise;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_registro_contable() {
		return this.fecha_registro_contable;
	}
    
	
	public Date getfecha_caducidad() {
		return this.fecha_caducidad;
	}
    
	
	public Long gettipo_tributario() {
		return this.tipo_tributario;
	}
    
	
	public Double getbienes_tar12() {
		return this.bienes_tar12;
	}
    
	
	public Double getbienes_tar0() {
		return this.bienes_tar0;
	}
    
	
	public Long getid_tipo_iva() {
		return this.id_tipo_iva;
	}
    
	
	public Double getservicios_tar12() {
		return this.servicios_tar12;
	}
    
	
	public Double getservicios_tar0() {
		return this.servicios_tar0;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public Double getbase_impo_tar12() {
		return this.base_impo_tar12;
	}
    
	
	public Double getbase_impo_tar0() {
		return this.base_impo_tar0;
	}
    
	
	public Double getmonto_ice() {
		return this.monto_ice;
	}
    
	
	public Double getmonto_iva_bien() {
		return this.monto_iva_bien;
	}
    
	
	public Double getmonto_iva_servicio() {
		return this.monto_iva_servicio;
	}
    
	
	public Long getid_tipo_retencion_iva_bien() {
		return this.id_tipo_retencion_iva_bien;
	}
    
	
	public Long getid_tipo_retencion_iva_servicio() {
		return this.id_tipo_retencion_iva_servicio;
	}
    
	
	public Double getretencion_iva_bien() {
		return this.retencion_iva_bien;
	}
    
	
	public Double getretencion_iva_servicio() {
		return this.retencion_iva_servicio;
	}
    
	
	public Boolean getcon_devolucion() {
		return this.con_devolucion;
	}
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
	
    
	public void setid_asiento_contable(Long newid_asiento_contable)throws Exception
	{
		try {
			if(this.id_asiento_contable!=newid_asiento_contable) {
				if(newid_asiento_contable==null) {
					//newid_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_conta(Long newid_transaccion_conta)throws Exception
	{
		try {
			if(this.id_transaccion_conta!=newid_transaccion_conta) {
				if(newid_transaccion_conta==null) {
					//newid_transaccion_conta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_transaccion_conta");
					}
				}

				this.id_transaccion_conta=newid_transaccion_conta;
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
						System.out.println("Sri:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("Sri:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
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
						System.out.println("Sri:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrazon_social(String newrazon_social)throws Exception
	{
		try {
			if(this.razon_social!=newrazon_social) {
				if(newrazon_social==null) {
					//newrazon_social="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna razon_social");
					}
				}

				if(newrazon_social!=null&&newrazon_social.length()>100) {
					newrazon_social=newrazon_social.substring(0,98);
					System.out.println("Sri:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna razon_social");
				}

				this.razon_social=newrazon_social;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_comprobante(Long newtipo_comprobante)throws Exception
	{
		try {
			if(this.tipo_comprobante!=newtipo_comprobante) {
				if(newtipo_comprobante==null) {
					//newtipo_comprobante=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna tipo_comprobante");
					}
				}

				this.tipo_comprobante=newtipo_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_rise(Boolean newes_rise)throws Exception
	{
		try {
			if(this.es_rise!=newes_rise) {
				if(newes_rise==null) {
					//newes_rise=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna es_rise");
					}
				}

				this.es_rise=newes_rise;
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
						System.out.println("Sri:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>20) {
					newnumero_serie=newnumero_serie.substring(0,18);
					System.out.println("Sri:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_serie");
				}

				this.numero_serie=newnumero_serie;
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
						System.out.println("Sri:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>20) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,18);
					System.out.println("Sri:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
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
						System.out.println("Sri:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>20) {
					newnumero_secuencial=newnumero_secuencial.substring(0,18);
					System.out.println("Sri:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
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
						System.out.println("Sri:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_registro_contable(Date newfecha_registro_contable)throws Exception
	{
		try {
			if(this.fecha_registro_contable!=newfecha_registro_contable) {
				if(newfecha_registro_contable==null) {
					//newfecha_registro_contable=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna fecha_registro_contable");
					}
				}

				this.fecha_registro_contable=newfecha_registro_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caducidad(Date newfecha_caducidad)throws Exception
	{
		try {
			if(this.fecha_caducidad!=newfecha_caducidad) {
				if(newfecha_caducidad==null) {
					//newfecha_caducidad=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna fecha_caducidad");
					}
				}

				this.fecha_caducidad=newfecha_caducidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_tributario(Long newtipo_tributario)throws Exception
	{
		try {
			if(this.tipo_tributario!=newtipo_tributario) {
				if(newtipo_tributario==null) {
					//newtipo_tributario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna tipo_tributario");
					}
				}

				this.tipo_tributario=newtipo_tributario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_tar12(Double newbienes_tar12)throws Exception
	{
		try {
			if(this.bienes_tar12!=newbienes_tar12) {
				if(newbienes_tar12==null) {
					//newbienes_tar12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna bienes_tar12");
					}
				}

				this.bienes_tar12=newbienes_tar12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_tar0(Double newbienes_tar0)throws Exception
	{
		try {
			if(this.bienes_tar0!=newbienes_tar0) {
				if(newbienes_tar0==null) {
					//newbienes_tar0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna bienes_tar0");
					}
				}

				this.bienes_tar0=newbienes_tar0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_iva(Long newid_tipo_iva)throws Exception
	{
		try {
			if(this.id_tipo_iva!=newid_tipo_iva) {
				if(newid_tipo_iva==null) {
					//newid_tipo_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_tipo_iva");
					}
				}

				this.id_tipo_iva=newid_tipo_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicios_tar12(Double newservicios_tar12)throws Exception
	{
		try {
			if(this.servicios_tar12!=newservicios_tar12) {
				if(newservicios_tar12==null) {
					//newservicios_tar12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna servicios_tar12");
					}
				}

				this.servicios_tar12=newservicios_tar12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicios_tar0(Double newservicios_tar0)throws Exception
	{
		try {
			if(this.servicios_tar0!=newservicios_tar0) {
				if(newservicios_tar0==null) {
					//newservicios_tar0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna servicios_tar0");
					}
				}

				this.servicios_tar0=newservicios_tar0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_iva(Double newmonto_iva)throws Exception
	{
		try {
			if(this.monto_iva!=newmonto_iva) {
				if(newmonto_iva==null) {
					//newmonto_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_impo_tar12(Double newbase_impo_tar12)throws Exception
	{
		try {
			if(this.base_impo_tar12!=newbase_impo_tar12) {
				if(newbase_impo_tar12==null) {
					//newbase_impo_tar12=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna base_impo_tar12");
					}
				}

				this.base_impo_tar12=newbase_impo_tar12;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_impo_tar0(Double newbase_impo_tar0)throws Exception
	{
		try {
			if(this.base_impo_tar0!=newbase_impo_tar0) {
				if(newbase_impo_tar0==null) {
					//newbase_impo_tar0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna base_impo_tar0");
					}
				}

				this.base_impo_tar0=newbase_impo_tar0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_ice(Double newmonto_ice)throws Exception
	{
		try {
			if(this.monto_ice!=newmonto_ice) {
				if(newmonto_ice==null) {
					//newmonto_ice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna monto_ice");
					}
				}

				this.monto_ice=newmonto_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_iva_bien(Double newmonto_iva_bien)throws Exception
	{
		try {
			if(this.monto_iva_bien!=newmonto_iva_bien) {
				if(newmonto_iva_bien==null) {
					//newmonto_iva_bien=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna monto_iva_bien");
					}
				}

				this.monto_iva_bien=newmonto_iva_bien;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_iva_servicio(Double newmonto_iva_servicio)throws Exception
	{
		try {
			if(this.monto_iva_servicio!=newmonto_iva_servicio) {
				if(newmonto_iva_servicio==null) {
					//newmonto_iva_servicio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna monto_iva_servicio");
					}
				}

				this.monto_iva_servicio=newmonto_iva_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva_bien(Long newid_tipo_retencion_iva_bien)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva_bien!=newid_tipo_retencion_iva_bien) {
				if(newid_tipo_retencion_iva_bien==null) {
					//newid_tipo_retencion_iva_bien=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_tipo_retencion_iva_bien");
					}
				}

				this.id_tipo_retencion_iva_bien=newid_tipo_retencion_iva_bien;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva_servicio(Long newid_tipo_retencion_iva_servicio)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva_servicio!=newid_tipo_retencion_iva_servicio) {
				if(newid_tipo_retencion_iva_servicio==null) {
					//newid_tipo_retencion_iva_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_tipo_retencion_iva_servicio");
					}
				}

				this.id_tipo_retencion_iva_servicio=newid_tipo_retencion_iva_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setretencion_iva_bien(Double newretencion_iva_bien)throws Exception
	{
		try {
			if(this.retencion_iva_bien!=newretencion_iva_bien) {
				if(newretencion_iva_bien==null) {
					//newretencion_iva_bien=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna retencion_iva_bien");
					}
				}

				this.retencion_iva_bien=newretencion_iva_bien;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setretencion_iva_servicio(Double newretencion_iva_servicio)throws Exception
	{
		try {
			if(this.retencion_iva_servicio!=newretencion_iva_servicio) {
				if(newretencion_iva_servicio==null) {
					//newretencion_iva_servicio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna retencion_iva_servicio");
					}
				}

				this.retencion_iva_servicio=newretencion_iva_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_devolucion(Boolean newcon_devolucion)throws Exception
	{
		try {
			if(this.con_devolucion!=newcon_devolucion) {
				if(newcon_devolucion==null) {
					//newcon_devolucion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna con_devolucion");
					}
				}

				this.con_devolucion=newcon_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Sri:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public TransaccionConta getTransaccionConta() {
		return this.transaccionconta;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoComprobante getTipoComprobante() {
		return this.tipocomprobante;
	}

	public TipoTributario getTipoTributario() {
		return this.tipotributario;
	}

	public TipoIva getTipoIva() {
		return this.tipoiva;
	}

	public TipoRetencionIva getTipoRetencionIvaBien() {
		return this.tiporetencionivabien;
	}

	public TipoRetencionIva getTipoRetencionIvaServicio() {
		return this.tiporetencionivaservicio;
	}

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
	}

	
	
	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String gettransaccionconta_descripcion() {
		return this.transaccionconta_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipocomprobante_descripcion() {
		return this.tipocomprobante_descripcion;
	}

	public String gettipotributario_descripcion() {
		return this.tipotributario_descripcion;
	}

	public String gettipoiva_descripcion() {
		return this.tipoiva_descripcion;
	}

	public String gettiporetencionivabien_descripcion() {
		return this.tiporetencionivabien_descripcion;
	}

	public String gettiporetencionivaservicio_descripcion() {
		return this.tiporetencionivaservicio_descripcion;
	}

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
	}

	
	
	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionConta(TransaccionConta transaccionconta) {
		try {
			this.transaccionconta=transaccionconta;
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


	public  void  setTipoComprobante(TipoComprobante tipocomprobante) {
		try {
			this.tipocomprobante=tipocomprobante;
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


	public  void  setTipoIva(TipoIva tipoiva) {
		try {
			this.tipoiva=tipoiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaBien(TipoRetencionIva tiporetencionivabien) {
		try {
			this.tiporetencionivabien=tiporetencionivabien;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaServicio(TipoRetencionIva tiporetencionivaservicio) {
		try {
			this.tiporetencionivaservicio=tiporetencionivaservicio;
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


	
	
	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionconta_descripcion(String transaccionconta_descripcion) {
		try {
			this.transaccionconta_descripcion=transaccionconta_descripcion;
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


	public  void  settipocomprobante_descripcion(String tipocomprobante_descripcion) {
		try {
			this.tipocomprobante_descripcion=tipocomprobante_descripcion;
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


	public  void  settipoiva_descripcion(String tipoiva_descripcion) {
		try {
			this.tipoiva_descripcion=tipoiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionivabien_descripcion(String tiporetencionivabien_descripcion) {
		try {
			this.tiporetencionivabien_descripcion=tiporetencionivabien_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionivaservicio_descripcion(String tiporetencionivaservicio_descripcion) {
		try {
			this.tiporetencionivaservicio_descripcion=tiporetencionivaservicio_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_asiento_contable_descripcion="";String id_transaccion_conta_descripcion="";String id_cliente_descripcion="";String tipo_comprobante_descripcion="";String es_rise_descripcion="";String tipo_tributario_descripcion="";String id_tipo_iva_descripcion="";String id_tipo_retencion_iva_bien_descripcion="";String id_tipo_retencion_iva_servicio_descripcion="";String con_devolucion_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_transaccion_conta_descripcion() {
		return id_transaccion_conta_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String gettipo_comprobante_descripcion() {
		return tipo_comprobante_descripcion;
	}
	public String getes_rise_descripcion() {
		return es_rise_descripcion;
	}
	public String gettipo_tributario_descripcion() {
		return tipo_tributario_descripcion;
	}
	public String getid_tipo_iva_descripcion() {
		return id_tipo_iva_descripcion;
	}
	public String getid_tipo_retencion_iva_bien_descripcion() {
		return id_tipo_retencion_iva_bien_descripcion;
	}
	public String getid_tipo_retencion_iva_servicio_descripcion() {
		return id_tipo_retencion_iva_servicio_descripcion;
	}
	public String getcon_devolucion_descripcion() {
		return con_devolucion_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
	}
	
	
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_conta_descripcion(String newid_transaccion_conta_descripcion)throws Exception {
		try {
			this.id_transaccion_conta_descripcion=newid_transaccion_conta_descripcion;
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
	public void settipo_comprobante_descripcion(String newtipo_comprobante_descripcion)throws Exception {
		try {
			this.tipo_comprobante_descripcion=newtipo_comprobante_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_rise_descripcion(String newes_rise_descripcion)throws Exception {
		try {
			this.es_rise_descripcion=newes_rise_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void settipo_tributario_descripcion(String newtipo_tributario_descripcion)throws Exception {
		try {
			this.tipo_tributario_descripcion=newtipo_tributario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_iva_descripcion(String newid_tipo_iva_descripcion)throws Exception {
		try {
			this.id_tipo_iva_descripcion=newid_tipo_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_iva_bien_descripcion(String newid_tipo_retencion_iva_bien_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva_bien_descripcion=newid_tipo_retencion_iva_bien_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_iva_servicio_descripcion(String newid_tipo_retencion_iva_servicio_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva_servicio_descripcion=newid_tipo_retencion_iva_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_devolucion_descripcion(String newcon_devolucion_descripcion)throws Exception {
		try {
			this.con_devolucion_descripcion=newcon_devolucion_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_asiento_contable_descripcion="";this.id_transaccion_conta_descripcion="";this.id_cliente_descripcion="";this.tipo_comprobante_descripcion="";this.es_rise_descripcion="";this.tipo_tributario_descripcion="";this.id_tipo_iva_descripcion="";this.id_tipo_retencion_iva_bien_descripcion="";this.id_tipo_retencion_iva_servicio_descripcion="";this.con_devolucion_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

