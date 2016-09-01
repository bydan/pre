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
package com.bydan.erp.sris.business.entity;

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
//import com.bydan.erp.sris.util.TransaccionLocalConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class TransaccionLocal extends TransaccionLocalAdditional implements Serializable ,Cloneable {//TransaccionLocalAdditional,GeneralEntity
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
	
	private TransaccionLocal transaccionlocalOriginal;
	
	private Map<String, Object> mapTransaccionLocal;
			
	public Map<String, Object> getMapTransaccionLocal() {
		return mapTransaccionLocal;
	}

	public void setMapTransaccionLocal(Map<String, Object> mapTransaccionLocal) {
		this.mapTransaccionLocal = mapTransaccionLocal;
	}
	
	public void inicializarMapTransaccionLocal() {
		this.mapTransaccionLocal = new HashMap<String,Object>();
	}
	
	public void setMapTransaccionLocalValue(String sKey,Object oValue) {
		this.mapTransaccionLocal.put(sKey, oValue);
	}
	
	public Object getMapTransaccionLocalValue(String sKey) {
		return this.mapTransaccionLocal.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXRUC,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXRAZON_SOCIAL,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXRAZON_SOCIAL)
	private String razon_social;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_declara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_conta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXIDENTIFICACION,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_registro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXNUMERO_SERIE,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tributario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TransaccionLocalConstantesFunciones.SREGEXNUMERO_DOCUMENTO_CONTABLE,message=TransaccionLocalConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE)
	private String numero_documento_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_rise;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double transfe_iva_retener;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double presta_iva_retener;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva_presta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double transfe_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double presta_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean permite_devolucion;
			
	
	public Compra compra;
	public PeriodoDeclara periododeclara;
	public TransaccionConta transaccionconta;
	public Cliente cliente;
	public TipoComprobante tipocomprobante;
	public TipoTributario tipotributario;
	public AsientoContable asientocontable;
	public TipoIva tipoiva;
	public TipoRetencionIva tiporetencioniva;
	public TipoRetencionIva tiporetencionivapresta;
	
	
	private String compra_descripcion;
	private String periododeclara_descripcion;
	private String transaccionconta_descripcion;
	private String cliente_descripcion;
	private String tipocomprobante_descripcion;
	private String tipotributario_descripcion;
	private String asientocontable_descripcion;
	private String tipoiva_descripcion;
	private String tiporetencioniva_descripcion;
	private String tiporetencionivapresta_descripcion;
	
	
		
	public TransaccionLocal () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.transaccionlocalOriginal=this;
		
 		this.id_compra=null;
 		this.ruc="";
 		this.razon_social="";
 		this.id_periodo_declara=-1L;
 		this.id_transaccion_conta=-1L;
 		this.id_cliente=-1L;
 		this.identificacion="";
 		this.id_tipo_comprobante=-1L;
 		this.fecha_emision=new Date();
 		this.fecha_registro_contable=new Date();
 		this.numero_secuencial="";
 		this.numero_serie="";
 		this.numero_autorizacion="";
 		this.fecha_caducidad=new Date();
 		this.id_tipo_tributario=-1L;
 		this.numero_documento_contable="";
 		this.id_asiento_contable=null;
 		this.es_rise=false;
 		this.bienes_iva=0.0;
 		this.bienes_sin_iva=0.0;
 		this.id_tipo_iva=-1L;
 		this.servicios_iva=0.0;
 		this.servicios_sin_iva=0.0;
 		this.monto_iva=0.0;
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.monto_ice=0.0;
 		this.transfe_iva_retener=0.0;
 		this.presta_iva_retener=0.0;
 		this.id_tipo_retencion_iva=-1L;
 		this.id_tipo_retencion_iva_presta=-1L;
 		this.transfe_iva_retenido=0.0;
 		this.presta_iva_retenido=0.0;
 		this.permite_devolucion=false;
		
		
		this.compra=null;
		this.periododeclara=null;
		this.transaccionconta=null;
		this.cliente=null;
		this.tipocomprobante=null;
		this.tipotributario=null;
		this.asientocontable=null;
		this.tipoiva=null;
		this.tiporetencioniva=null;
		this.tiporetencionivapresta=null;
		
		
		this.compra_descripcion="";
		this.periododeclara_descripcion="";
		this.transaccionconta_descripcion="";
		this.cliente_descripcion="";
		this.tipocomprobante_descripcion="";
		this.tipotributario_descripcion="";
		this.asientocontable_descripcion="";
		this.tipoiva_descripcion="";
		this.tiporetencioniva_descripcion="";
		this.tiporetencionivapresta_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TransaccionLocal (Long id,Date versionRow,Long id_compra,String ruc,String razon_social,Long id_periodo_declara,Long id_transaccion_conta,Long id_cliente,String identificacion,Long id_tipo_comprobante,Date fecha_emision,Date fecha_registro_contable,String numero_secuencial,String numero_serie,String numero_autorizacion,Date fecha_caducidad,Long id_tipo_tributario,String numero_documento_contable,Long id_asiento_contable,Boolean es_rise,Double bienes_iva,Double bienes_sin_iva,Long id_tipo_iva,Double servicios_iva,Double servicios_sin_iva,Double monto_iva,Double total_iva,Double total_sin_iva,Double monto_ice,Double transfe_iva_retener,Double presta_iva_retener,Long id_tipo_retencion_iva,Long id_tipo_retencion_iva_presta,Double transfe_iva_retenido,Double presta_iva_retenido,Boolean permite_devolucion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionlocalOriginal=this;
		
 		this.id_compra=id_compra;
 		this.ruc=ruc;
 		this.razon_social=razon_social;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.id_cliente=id_cliente;
 		this.identificacion=identificacion;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_secuencial=numero_secuencial;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.fecha_caducidad=fecha_caducidad;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.numero_documento_contable=numero_documento_contable;
 		this.id_asiento_contable=id_asiento_contable;
 		this.es_rise=es_rise;
 		this.bienes_iva=bienes_iva;
 		this.bienes_sin_iva=bienes_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.servicios_iva=servicios_iva;
 		this.servicios_sin_iva=servicios_sin_iva;
 		this.monto_iva=monto_iva;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.monto_ice=monto_ice;
 		this.transfe_iva_retener=transfe_iva_retener;
 		this.presta_iva_retener=presta_iva_retener;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.permite_devolucion=permite_devolucion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TransaccionLocal (Long id_compra,String ruc,String razon_social,Long id_periodo_declara,Long id_transaccion_conta,Long id_cliente,String identificacion,Long id_tipo_comprobante,Date fecha_emision,Date fecha_registro_contable,String numero_secuencial,String numero_serie,String numero_autorizacion,Date fecha_caducidad,Long id_tipo_tributario,String numero_documento_contable,Long id_asiento_contable,Boolean es_rise,Double bienes_iva,Double bienes_sin_iva,Long id_tipo_iva,Double servicios_iva,Double servicios_sin_iva,Double monto_iva,Double total_iva,Double total_sin_iva,Double monto_ice,Double transfe_iva_retener,Double presta_iva_retener,Long id_tipo_retencion_iva,Long id_tipo_retencion_iva_presta,Double transfe_iva_retenido,Double presta_iva_retenido,Boolean permite_devolucion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.transaccionlocalOriginal=this;
		
 		this.id_compra=id_compra;
 		this.ruc=ruc;
 		this.razon_social=razon_social;
 		this.id_periodo_declara=id_periodo_declara;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.id_cliente=id_cliente;
 		this.identificacion=identificacion;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_secuencial=numero_secuencial;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.fecha_caducidad=fecha_caducidad;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.numero_documento_contable=numero_documento_contable;
 		this.id_asiento_contable=id_asiento_contable;
 		this.es_rise=es_rise;
 		this.bienes_iva=bienes_iva;
 		this.bienes_sin_iva=bienes_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.servicios_iva=servicios_iva;
 		this.servicios_sin_iva=servicios_sin_iva;
 		this.monto_iva=monto_iva;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.monto_ice=monto_ice;
 		this.transfe_iva_retener=transfe_iva_retener;
 		this.presta_iva_retener=presta_iva_retener;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.permite_devolucion=permite_devolucion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TransaccionLocal transaccionlocalLocal=null;
		
		if(object!=null) {
			transaccionlocalLocal=(TransaccionLocal)object;
			
			if(transaccionlocalLocal!=null) {
				if(this.getId()!=null && transaccionlocalLocal.getId()!=null) {
					if(this.getId().equals(transaccionlocalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TransaccionLocalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TransaccionLocalConstantesFunciones.getTransaccionLocalDescripcion(this);
		} else {
			sDetalle=TransaccionLocalConstantesFunciones.getTransaccionLocalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TransaccionLocal getTransaccionLocalOriginal() {
		return this.transaccionlocalOriginal;
	}
	
	public void setTransaccionLocalOriginal(TransaccionLocal transaccionlocal) {
		try {
			this.transaccionlocalOriginal=transaccionlocal;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TransaccionLocalAdditional transaccionlocalAdditional=null;
	
	public TransaccionLocalAdditional getTransaccionLocalAdditional() {
		return this.transaccionlocalAdditional;
	}
	
	public void setTransaccionLocalAdditional(TransaccionLocalAdditional transaccionlocalAdditional) {
		try {
			this.transaccionlocalAdditional=transaccionlocalAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_compra() {
		return this.id_compra;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getrazon_social() {
		return this.razon_social;
	}
    
	
	public Long getid_periodo_declara() {
		return this.id_periodo_declara;
	}
    
	
	public Long getid_transaccion_conta() {
		return this.id_transaccion_conta;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public Long getid_tipo_comprobante() {
		return this.id_tipo_comprobante;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_registro_contable() {
		return this.fecha_registro_contable;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public Date getfecha_caducidad() {
		return this.fecha_caducidad;
	}
    
	
	public Long getid_tipo_tributario() {
		return this.id_tipo_tributario;
	}
    
	
	public String getnumero_documento_contable() {
		return this.numero_documento_contable;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Boolean getes_rise() {
		return this.es_rise;
	}
    
	
	public Double getbienes_iva() {
		return this.bienes_iva;
	}
    
	
	public Double getbienes_sin_iva() {
		return this.bienes_sin_iva;
	}
    
	
	public Long getid_tipo_iva() {
		return this.id_tipo_iva;
	}
    
	
	public Double getservicios_iva() {
		return this.servicios_iva;
	}
    
	
	public Double getservicios_sin_iva() {
		return this.servicios_sin_iva;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double getmonto_ice() {
		return this.monto_ice;
	}
    
	
	public Double gettransfe_iva_retener() {
		return this.transfe_iva_retener;
	}
    
	
	public Double getpresta_iva_retener() {
		return this.presta_iva_retener;
	}
    
	
	public Long getid_tipo_retencion_iva() {
		return this.id_tipo_retencion_iva;
	}
    
	
	public Long getid_tipo_retencion_iva_presta() {
		return this.id_tipo_retencion_iva_presta;
	}
    
	
	public Double gettransfe_iva_retenido() {
		return this.transfe_iva_retenido;
	}
    
	
	public Double getpresta_iva_retenido() {
		return this.presta_iva_retenido;
	}
    
	
	public Boolean getpermite_devolucion() {
		return this.permite_devolucion;
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
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna razon_social");
					}
				}

				if(newrazon_social!=null&&newrazon_social.length()>150) {
					newrazon_social=newrazon_social.substring(0,148);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna razon_social");
				}

				this.razon_social=newrazon_social;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo_declara(Long newid_periodo_declara)throws Exception
	{
		try {
			if(this.id_periodo_declara!=newid_periodo_declara) {
				if(newid_periodo_declara==null) {
					//newid_periodo_declara=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_transaccion_conta");
					}
				}

				this.id_transaccion_conta=newid_transaccion_conta;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_comprobante(Long newid_tipo_comprobante)throws Exception
	{
		try {
			if(this.id_tipo_comprobante!=newid_tipo_comprobante) {
				if(newid_tipo_comprobante==null) {
					//newid_tipo_comprobante=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_tipo_comprobante");
					}
				}

				this.id_tipo_comprobante=newid_tipo_comprobante;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna fecha_emision");
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna fecha_registro_contable");
					}
				}

				this.fecha_registro_contable=newfecha_registro_contable;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>50) {
					newnumero_serie=newnumero_serie.substring(0,48);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie");
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>20) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,18);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna fecha_caducidad");
					}
				}

				this.fecha_caducidad=newfecha_caducidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tributario(Long newid_tipo_tributario)throws Exception
	{
		try {
			if(this.id_tipo_tributario!=newid_tipo_tributario) {
				if(newid_tipo_tributario==null) {
					//newid_tipo_tributario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_tipo_tributario");
					}
				}

				this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento_contable(String newnumero_documento_contable)throws Exception
	{
		try {
			if(this.numero_documento_contable!=newnumero_documento_contable) {
				if(newnumero_documento_contable==null) {
					//newnumero_documento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna numero_documento_contable");
					}
				}

				if(newnumero_documento_contable!=null&&newnumero_documento_contable.length()>50) {
					newnumero_documento_contable=newnumero_documento_contable.substring(0,48);
					System.out.println("TransaccionLocal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento_contable");
				}

				this.numero_documento_contable=newnumero_documento_contable;
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
    
	public void setes_rise(Boolean newes_rise)throws Exception
	{
		try {
			if(this.es_rise!=newes_rise) {
				if(newes_rise==null) {
					//newes_rise=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna es_rise");
					}
				}

				this.es_rise=newes_rise;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_iva(Double newbienes_iva)throws Exception
	{
		try {
			if(this.bienes_iva!=newbienes_iva) {
				if(newbienes_iva==null) {
					//newbienes_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna bienes_iva");
					}
				}

				this.bienes_iva=newbienes_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbienes_sin_iva(Double newbienes_sin_iva)throws Exception
	{
		try {
			if(this.bienes_sin_iva!=newbienes_sin_iva) {
				if(newbienes_sin_iva==null) {
					//newbienes_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna bienes_sin_iva");
					}
				}

				this.bienes_sin_iva=newbienes_sin_iva;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_tipo_iva");
					}
				}

				this.id_tipo_iva=newid_tipo_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicios_iva(Double newservicios_iva)throws Exception
	{
		try {
			if(this.servicios_iva!=newservicios_iva) {
				if(newservicios_iva==null) {
					//newservicios_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna servicios_iva");
					}
				}

				this.servicios_iva=newservicios_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicios_sin_iva(Double newservicios_sin_iva)throws Exception
	{
		try {
			if(this.servicios_sin_iva!=newservicios_sin_iva) {
				if(newservicios_sin_iva==null) {
					//newservicios_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna servicios_sin_iva");
					}
				}

				this.servicios_sin_iva=newservicios_sin_iva;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna total_iva");
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
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
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna monto_ice");
					}
				}

				this.monto_ice=newmonto_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settransfe_iva_retener(Double newtransfe_iva_retener)throws Exception
	{
		try {
			if(this.transfe_iva_retener!=newtransfe_iva_retener) {
				if(newtransfe_iva_retener==null) {
					//newtransfe_iva_retener=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna transfe_iva_retener");
					}
				}

				this.transfe_iva_retener=newtransfe_iva_retener;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpresta_iva_retener(Double newpresta_iva_retener)throws Exception
	{
		try {
			if(this.presta_iva_retener!=newpresta_iva_retener) {
				if(newpresta_iva_retener==null) {
					//newpresta_iva_retener=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna presta_iva_retener");
					}
				}

				this.presta_iva_retener=newpresta_iva_retener;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva(Long newid_tipo_retencion_iva)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva!=newid_tipo_retencion_iva) {
				if(newid_tipo_retencion_iva==null) {
					//newid_tipo_retencion_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_tipo_retencion_iva");
					}
				}

				this.id_tipo_retencion_iva=newid_tipo_retencion_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_retencion_iva_presta(Long newid_tipo_retencion_iva_presta)throws Exception
	{
		try {
			if(this.id_tipo_retencion_iva_presta!=newid_tipo_retencion_iva_presta) {
				if(newid_tipo_retencion_iva_presta==null) {
					//newid_tipo_retencion_iva_presta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna id_tipo_retencion_iva_presta");
					}
				}

				this.id_tipo_retencion_iva_presta=newid_tipo_retencion_iva_presta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settransfe_iva_retenido(Double newtransfe_iva_retenido)throws Exception
	{
		try {
			if(this.transfe_iva_retenido!=newtransfe_iva_retenido) {
				if(newtransfe_iva_retenido==null) {
					//newtransfe_iva_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna transfe_iva_retenido");
					}
				}

				this.transfe_iva_retenido=newtransfe_iva_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpresta_iva_retenido(Double newpresta_iva_retenido)throws Exception
	{
		try {
			if(this.presta_iva_retenido!=newpresta_iva_retenido) {
				if(newpresta_iva_retenido==null) {
					//newpresta_iva_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna presta_iva_retenido");
					}
				}

				this.presta_iva_retenido=newpresta_iva_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpermite_devolucion(Boolean newpermite_devolucion)throws Exception
	{
		try {
			if(this.permite_devolucion!=newpermite_devolucion) {
				if(newpermite_devolucion==null) {
					//newpermite_devolucion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TransaccionLocal:Valor nulo no permitido en columna permite_devolucion");
					}
				}

				this.permite_devolucion=newpermite_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Compra getCompra() {
		return this.compra;
	}

	public PeriodoDeclara getPeriodoDeclara() {
		return this.periododeclara;
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

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public TipoIva getTipoIva() {
		return this.tipoiva;
	}

	public TipoRetencionIva getTipoRetencionIva() {
		return this.tiporetencioniva;
	}

	public TipoRetencionIva getTipoRetencionIvaPresta() {
		return this.tiporetencionivapresta;
	}

	
	
	public String getcompra_descripcion() {
		return this.compra_descripcion;
	}

	public String getperiododeclara_descripcion() {
		return this.periododeclara_descripcion;
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

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String gettipoiva_descripcion() {
		return this.tipoiva_descripcion;
	}

	public String gettiporetencioniva_descripcion() {
		return this.tiporetencioniva_descripcion;
	}

	public String gettiporetencionivapresta_descripcion() {
		return this.tiporetencionivapresta_descripcion;
	}

	
	
	public  void  setCompra(Compra compra) {
		try {
			this.compra=compra;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodoDeclara(PeriodoDeclara periododeclara) {
		try {
			this.periododeclara=periododeclara;
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


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
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


	public  void  setTipoRetencionIva(TipoRetencionIva tiporetencioniva) {
		try {
			this.tiporetencioniva=tiporetencioniva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaPresta(TipoRetencionIva tiporetencionivapresta) {
		try {
			this.tiporetencionivapresta=tiporetencionivapresta;
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


	public  void  setperiododeclara_descripcion(String periododeclara_descripcion) {
		try {
			this.periododeclara_descripcion=periododeclara_descripcion;
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


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
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


	public  void  settiporetencioniva_descripcion(String tiporetencioniva_descripcion) {
		try {
			this.tiporetencioniva_descripcion=tiporetencioniva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencionivapresta_descripcion(String tiporetencionivapresta_descripcion) {
		try {
			this.tiporetencionivapresta_descripcion=tiporetencionivapresta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_compra_descripcion="";String id_periodo_declara_descripcion="";String id_transaccion_conta_descripcion="";String id_cliente_descripcion="";String id_tipo_comprobante_descripcion="";String id_tipo_tributario_descripcion="";String id_asiento_contable_descripcion="";String es_rise_descripcion="";String id_tipo_iva_descripcion="";String id_tipo_retencion_iva_descripcion="";String id_tipo_retencion_iva_presta_descripcion="";String permite_devolucion_descripcion="";
	
	
	public String getid_compra_descripcion() {
		return id_compra_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
	}
	public String getid_transaccion_conta_descripcion() {
		return id_transaccion_conta_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_comprobante_descripcion() {
		return id_tipo_comprobante_descripcion;
	}
	public String getid_tipo_tributario_descripcion() {
		return id_tipo_tributario_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getes_rise_descripcion() {
		return es_rise_descripcion;
	}
	public String getid_tipo_iva_descripcion() {
		return id_tipo_iva_descripcion;
	}
	public String getid_tipo_retencion_iva_descripcion() {
		return id_tipo_retencion_iva_descripcion;
	}
	public String getid_tipo_retencion_iva_presta_descripcion() {
		return id_tipo_retencion_iva_presta_descripcion;
	}
	public String getpermite_devolucion_descripcion() {
		return permite_devolucion_descripcion;
	}
	
	
	public void setid_compra_descripcion(String newid_compra_descripcion) {
		this.id_compra_descripcion=newid_compra_descripcion;
	}
	public void setid_periodo_declara_descripcion(String newid_periodo_declara_descripcion)throws Exception {
		try {
			this.id_periodo_declara_descripcion=newid_periodo_declara_descripcion;
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
	public void setid_tipo_comprobante_descripcion(String newid_tipo_comprobante_descripcion)throws Exception {
		try {
			this.id_tipo_comprobante_descripcion=newid_tipo_comprobante_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tributario_descripcion(String newid_tipo_tributario_descripcion)throws Exception {
		try {
			this.id_tipo_tributario_descripcion=newid_tipo_tributario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion) {
		this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
	}
	public void setes_rise_descripcion(String newes_rise_descripcion)throws Exception {
		try {
			this.es_rise_descripcion=newes_rise_descripcion;
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
	public void setid_tipo_retencion_iva_descripcion(String newid_tipo_retencion_iva_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva_descripcion=newid_tipo_retencion_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_iva_presta_descripcion(String newid_tipo_retencion_iva_presta_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_iva_presta_descripcion=newid_tipo_retencion_iva_presta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpermite_devolucion_descripcion(String newpermite_devolucion_descripcion)throws Exception {
		try {
			this.permite_devolucion_descripcion=newpermite_devolucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_compra_descripcion="";this.id_periodo_declara_descripcion="";this.id_transaccion_conta_descripcion="";this.id_cliente_descripcion="";this.id_tipo_comprobante_descripcion="";this.id_tipo_tributario_descripcion="";this.id_asiento_contable_descripcion="";this.es_rise_descripcion="";this.id_tipo_iva_descripcion="";this.id_tipo_retencion_iva_descripcion="";this.id_tipo_retencion_iva_presta_descripcion="";this.permite_devolucion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

