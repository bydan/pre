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
package com.bydan.erp.sris.business.entity.report;

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
//import com.bydan.erp.sris.util.SriFacturasProveedoresIva012ConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class SriFacturasProveedoresIva012 extends SriFacturasProveedoresIva012Additional implements Serializable ,Cloneable {//SriFacturasProveedoresIva012Additional,GeneralEntity
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
	
	private SriFacturasProveedoresIva012 srifacturasproveedoresiva012Original;
	
	private Map<String, Object> mapSriFacturasProveedoresIva012;
			
	public Map<String, Object> getMapSriFacturasProveedoresIva012() {
		return mapSriFacturasProveedoresIva012;
	}

	public void setMapSriFacturasProveedoresIva012(Map<String, Object> mapSriFacturasProveedoresIva012) {
		this.mapSriFacturasProveedoresIva012 = mapSriFacturasProveedoresIva012;
	}
	
	public void inicializarMapSriFacturasProveedoresIva012() {
		this.mapSriFacturasProveedoresIva012 = new HashMap<String,Object>();
	}
	
	public void setMapSriFacturasProveedoresIva012Value(String sKey,Object oValue) {
		this.mapSriFacturasProveedoresIva012.put(sKey, oValue);
	}
	
	public Object getMapSriFacturasProveedoresIva012Value(String sKey) {
		return this.mapSriFacturasProveedoresIva012.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_declara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXRUC,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_TIPO_COMPROBANTE,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE)
	private String nombre_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXRUC_DATO,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXRUC_DATO)
	private String ruc_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_registro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNUMERO_SERIE,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double transfe_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva_presta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double presta_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_TIPO_RETENCION_FUENTE1,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE1)
	private String nombre_tipo_retencion_fuente1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_fuente1_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_fuente1_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_TIPO_RETENCION_FUENTE2,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RETENCION_FUENTE2)
	private String nombre_tipo_retencion_fuente2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_fuente2_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_fuente2_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_TIPO_RETENCION_IVA1,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RETENCION_IVA1)
	private String nombre_tipo_retencion_iva1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_iva_bien_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_iva_bien_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriFacturasProveedoresIva012ConstantesFunciones.SREGEXNOMBRE_TIPO_RETENCION_IVA2,message=SriFacturasProveedoresIva012ConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_RETENCION_IVA2)
	private String nombre_tipo_retencion_iva2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_iva_servicio_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ret_iva_servicio_retenido;
			
	
	public Empresa empresa;
	public PeriodoDeclara periododeclara;
	public TipoIva tipoiva;
	public TipoRetencion tiporetencioniva;
	public TipoRetencion tiporetencionivapresta;
	
	
	private String empresa_descripcion;
	private String periododeclara_descripcion;
	private String tipoiva_descripcion;
	private String tiporetencioniva_descripcion;
	private String tiporetencionivapresta_descripcion;
	
	
		
	public SriFacturasProveedoresIva012 () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.srifacturasproveedoresiva012Original=this;
		
 		this.id_empresa=-1L;
 		this.id_periodo_declara=-1L;
 		this.ruc="";
 		this.nombre_tipo_comprobante="";
 		this.nombre_completo_cliente="";
 		this.ruc_dato="";
 		this.numero_documento="";
 		this.fecha_emision=new Date();
 		this.fecha_registro_contable=new Date();
 		this.numero_serie="";
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.id_tipo_iva=-1L;
 		this.id_tipo_retencion_iva=-1L;
 		this.transfe_iva_retenido=0.0;
 		this.id_tipo_retencion_iva_presta=-1L;
 		this.presta_iva_retenido=0.0;
 		this.nombre_tipo_retencion_fuente1="";
 		this.ret_fuente1_porcentaje=0.0;
 		this.ret_fuente1_retenido=0.0;
 		this.nombre_tipo_retencion_fuente2="";
 		this.ret_fuente2_porcentaje=0.0;
 		this.ret_fuente2_retenido=0.0;
 		this.nombre_tipo_retencion_iva1="";
 		this.ret_iva_bien_porcentaje=0.0;
 		this.ret_iva_bien_retenido=0.0;
 		this.nombre_tipo_retencion_iva2="";
 		this.ret_iva_servicio_porcentaje=0.0;
 		this.ret_iva_servicio_retenido=0.0;
		
		
		this.empresa=null;
		this.periododeclara=null;
		this.tipoiva=null;
		this.tiporetencioniva=null;
		this.tiporetencionivapresta=null;
		
		
		this.empresa_descripcion="";
		this.periododeclara_descripcion="";
		this.tipoiva_descripcion="";
		this.tiporetencioniva_descripcion="";
		this.tiporetencionivapresta_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SriFacturasProveedoresIva012 (Long id,Date versionRow,String nombre_tipo_comprobante,String nombre_completo_cliente,String ruc_dato,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,Double total_iva,Double total_sin_iva,Long id_tipo_iva,Long id_tipo_retencion_iva,Double transfe_iva_retenido,Long id_tipo_retencion_iva_presta,Double presta_iva_retenido,String nombre_tipo_retencion_fuente1,Double ret_fuente1_porcentaje,Double ret_fuente1_retenido,String nombre_tipo_retencion_fuente2,Double ret_fuente2_porcentaje,Double ret_fuente2_retenido,String nombre_tipo_retencion_iva1,Double ret_iva_bien_porcentaje,Double ret_iva_bien_retenido,String nombre_tipo_retencion_iva2,Double ret_iva_servicio_porcentaje,Double ret_iva_servicio_retenido) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.srifacturasproveedoresiva012Original=this;
		
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.ruc_dato=ruc_dato;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.nombre_tipo_retencion_fuente1=nombre_tipo_retencion_fuente1;
 		this.ret_fuente1_porcentaje=ret_fuente1_porcentaje;
 		this.ret_fuente1_retenido=ret_fuente1_retenido;
 		this.nombre_tipo_retencion_fuente2=nombre_tipo_retencion_fuente2;
 		this.ret_fuente2_porcentaje=ret_fuente2_porcentaje;
 		this.ret_fuente2_retenido=ret_fuente2_retenido;
 		this.nombre_tipo_retencion_iva1=nombre_tipo_retencion_iva1;
 		this.ret_iva_bien_porcentaje=ret_iva_bien_porcentaje;
 		this.ret_iva_bien_retenido=ret_iva_bien_retenido;
 		this.nombre_tipo_retencion_iva2=nombre_tipo_retencion_iva2;
 		this.ret_iva_servicio_porcentaje=ret_iva_servicio_porcentaje;
 		this.ret_iva_servicio_retenido=ret_iva_servicio_retenido;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SriFacturasProveedoresIva012 (String nombre_tipo_comprobante,String nombre_completo_cliente,String ruc_dato,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,Double total_iva,Double total_sin_iva,Long id_tipo_iva,Long id_tipo_retencion_iva,Double transfe_iva_retenido,Long id_tipo_retencion_iva_presta,Double presta_iva_retenido,String nombre_tipo_retencion_fuente1,Double ret_fuente1_porcentaje,Double ret_fuente1_retenido,String nombre_tipo_retencion_fuente2,Double ret_fuente2_porcentaje,Double ret_fuente2_retenido,String nombre_tipo_retencion_iva1,Double ret_iva_bien_porcentaje,Double ret_iva_bien_retenido,String nombre_tipo_retencion_iva2,Double ret_iva_servicio_porcentaje,Double ret_iva_servicio_retenido) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.srifacturasproveedoresiva012Original=this;
		
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.ruc_dato=ruc_dato;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.nombre_tipo_retencion_fuente1=nombre_tipo_retencion_fuente1;
 		this.ret_fuente1_porcentaje=ret_fuente1_porcentaje;
 		this.ret_fuente1_retenido=ret_fuente1_retenido;
 		this.nombre_tipo_retencion_fuente2=nombre_tipo_retencion_fuente2;
 		this.ret_fuente2_porcentaje=ret_fuente2_porcentaje;
 		this.ret_fuente2_retenido=ret_fuente2_retenido;
 		this.nombre_tipo_retencion_iva1=nombre_tipo_retencion_iva1;
 		this.ret_iva_bien_porcentaje=ret_iva_bien_porcentaje;
 		this.ret_iva_bien_retenido=ret_iva_bien_retenido;
 		this.nombre_tipo_retencion_iva2=nombre_tipo_retencion_iva2;
 		this.ret_iva_servicio_porcentaje=ret_iva_servicio_porcentaje;
 		this.ret_iva_servicio_retenido=ret_iva_servicio_retenido;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public SriFacturasProveedoresIva012 getSriFacturasProveedoresIva012Original() {
		return this.srifacturasproveedoresiva012Original;
	}
	
	public void setSriFacturasProveedoresIva012Original(SriFacturasProveedoresIva012 srifacturasproveedoresiva012) {
		try {
			this.srifacturasproveedoresiva012Original=srifacturasproveedoresiva012;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SriFacturasProveedoresIva012Additional srifacturasproveedoresiva012Additional=null;
	
	public SriFacturasProveedoresIva012Additional getSriFacturasProveedoresIva012Additional() {
		return this.srifacturasproveedoresiva012Additional;
	}
	
	public void setSriFacturasProveedoresIva012Additional(SriFacturasProveedoresIva012Additional srifacturasproveedoresiva012Additional) {
		try {
			this.srifacturasproveedoresiva012Additional=srifacturasproveedoresiva012Additional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_periodo_declara() {
		return this.id_periodo_declara;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre_tipo_comprobante() {
		return this.nombre_tipo_comprobante;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getruc_dato() {
		return this.ruc_dato;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_registro_contable() {
		return this.fecha_registro_contable;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Long getid_tipo_iva() {
		return this.id_tipo_iva;
	}
    
	
	public Long getid_tipo_retencion_iva() {
		return this.id_tipo_retencion_iva;
	}
    
	
	public Double gettransfe_iva_retenido() {
		return this.transfe_iva_retenido;
	}
    
	
	public Long getid_tipo_retencion_iva_presta() {
		return this.id_tipo_retencion_iva_presta;
	}
    
	
	public Double getpresta_iva_retenido() {
		return this.presta_iva_retenido;
	}
    
	
	public String getnombre_tipo_retencion_fuente1() {
		return this.nombre_tipo_retencion_fuente1;
	}
    
	
	public Double getret_fuente1_porcentaje() {
		return this.ret_fuente1_porcentaje;
	}
    
	
	public Double getret_fuente1_retenido() {
		return this.ret_fuente1_retenido;
	}
    
	
	public String getnombre_tipo_retencion_fuente2() {
		return this.nombre_tipo_retencion_fuente2;
	}
    
	
	public Double getret_fuente2_porcentaje() {
		return this.ret_fuente2_porcentaje;
	}
    
	
	public Double getret_fuente2_retenido() {
		return this.ret_fuente2_retenido;
	}
    
	
	public String getnombre_tipo_retencion_iva1() {
		return this.nombre_tipo_retencion_iva1;
	}
    
	
	public Double getret_iva_bien_porcentaje() {
		return this.ret_iva_bien_porcentaje;
	}
    
	
	public Double getret_iva_bien_retenido() {
		return this.ret_iva_bien_retenido;
	}
    
	
	public String getnombre_tipo_retencion_iva2() {
		return this.nombre_tipo_retencion_iva2;
	}
    
	
	public Double getret_iva_servicio_porcentaje() {
		return this.ret_iva_servicio_porcentaje;
	}
    
	
	public Double getret_iva_servicio_retenido() {
		return this.ret_iva_servicio_retenido;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_comprobante(String newnombre_tipo_comprobante)throws Exception
	{
		try {
			if(this.nombre_tipo_comprobante!=newnombre_tipo_comprobante) {
				if(newnombre_tipo_comprobante==null) {
					//newnombre_tipo_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_tipo_comprobante");
					}
				}

				if(newnombre_tipo_comprobante!=null&&newnombre_tipo_comprobante.length()>100) {
					newnombre_tipo_comprobante=newnombre_tipo_comprobante.substring(0,98);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_comprobante");
				}

				this.nombre_tipo_comprobante=newnombre_tipo_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_dato(String newruc_dato)throws Exception
	{
		try {
			if(this.ruc_dato!=newruc_dato) {
				if(newruc_dato==null) {
					//newruc_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ruc_dato");
					}
				}

				if(newruc_dato!=null&&newruc_dato.length()>20) {
					newruc_dato=newruc_dato.substring(0,18);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc_dato");
				}

				this.ruc_dato=newruc_dato;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna fecha_emision");
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna fecha_registro_contable");
					}
				}

				this.fecha_registro_contable=newfecha_registro_contable;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>50) {
					newnumero_serie=newnumero_serie.substring(0,48);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie");
				}

				this.numero_serie=newnumero_serie;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna total_iva");
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna id_tipo_iva");
					}
				}

				this.id_tipo_iva=newid_tipo_iva;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna id_tipo_retencion_iva");
					}
				}

				this.id_tipo_retencion_iva=newid_tipo_retencion_iva;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna transfe_iva_retenido");
					}
				}

				this.transfe_iva_retenido=newtransfe_iva_retenido;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna id_tipo_retencion_iva_presta");
					}
				}

				this.id_tipo_retencion_iva_presta=newid_tipo_retencion_iva_presta;
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
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna presta_iva_retenido");
					}
				}

				this.presta_iva_retenido=newpresta_iva_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_retencion_fuente1(String newnombre_tipo_retencion_fuente1)throws Exception
	{
		try {
			if(this.nombre_tipo_retencion_fuente1!=newnombre_tipo_retencion_fuente1) {
				if(newnombre_tipo_retencion_fuente1==null) {
					//newnombre_tipo_retencion_fuente1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_tipo_retencion_fuente1");
					}
				}

				if(newnombre_tipo_retencion_fuente1!=null&&newnombre_tipo_retencion_fuente1.length()>100) {
					newnombre_tipo_retencion_fuente1=newnombre_tipo_retencion_fuente1.substring(0,98);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_retencion_fuente1");
				}

				this.nombre_tipo_retencion_fuente1=newnombre_tipo_retencion_fuente1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_fuente1_porcentaje(Double newret_fuente1_porcentaje)throws Exception
	{
		try {
			if(this.ret_fuente1_porcentaje!=newret_fuente1_porcentaje) {
				if(newret_fuente1_porcentaje==null) {
					//newret_fuente1_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_fuente1_porcentaje");
					}
				}

				this.ret_fuente1_porcentaje=newret_fuente1_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_fuente1_retenido(Double newret_fuente1_retenido)throws Exception
	{
		try {
			if(this.ret_fuente1_retenido!=newret_fuente1_retenido) {
				if(newret_fuente1_retenido==null) {
					//newret_fuente1_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_fuente1_retenido");
					}
				}

				this.ret_fuente1_retenido=newret_fuente1_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_retencion_fuente2(String newnombre_tipo_retencion_fuente2)throws Exception
	{
		try {
			if(this.nombre_tipo_retencion_fuente2!=newnombre_tipo_retencion_fuente2) {
				if(newnombre_tipo_retencion_fuente2==null) {
					//newnombre_tipo_retencion_fuente2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_tipo_retencion_fuente2");
					}
				}

				if(newnombre_tipo_retencion_fuente2!=null&&newnombre_tipo_retencion_fuente2.length()>100) {
					newnombre_tipo_retencion_fuente2=newnombre_tipo_retencion_fuente2.substring(0,98);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_retencion_fuente2");
				}

				this.nombre_tipo_retencion_fuente2=newnombre_tipo_retencion_fuente2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_fuente2_porcentaje(Double newret_fuente2_porcentaje)throws Exception
	{
		try {
			if(this.ret_fuente2_porcentaje!=newret_fuente2_porcentaje) {
				if(newret_fuente2_porcentaje==null) {
					//newret_fuente2_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_fuente2_porcentaje");
					}
				}

				this.ret_fuente2_porcentaje=newret_fuente2_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_fuente2_retenido(Double newret_fuente2_retenido)throws Exception
	{
		try {
			if(this.ret_fuente2_retenido!=newret_fuente2_retenido) {
				if(newret_fuente2_retenido==null) {
					//newret_fuente2_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_fuente2_retenido");
					}
				}

				this.ret_fuente2_retenido=newret_fuente2_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_retencion_iva1(String newnombre_tipo_retencion_iva1)throws Exception
	{
		try {
			if(this.nombre_tipo_retencion_iva1!=newnombre_tipo_retencion_iva1) {
				if(newnombre_tipo_retencion_iva1==null) {
					//newnombre_tipo_retencion_iva1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_tipo_retencion_iva1");
					}
				}

				if(newnombre_tipo_retencion_iva1!=null&&newnombre_tipo_retencion_iva1.length()>100) {
					newnombre_tipo_retencion_iva1=newnombre_tipo_retencion_iva1.substring(0,98);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_retencion_iva1");
				}

				this.nombre_tipo_retencion_iva1=newnombre_tipo_retencion_iva1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_iva_bien_porcentaje(Double newret_iva_bien_porcentaje)throws Exception
	{
		try {
			if(this.ret_iva_bien_porcentaje!=newret_iva_bien_porcentaje) {
				if(newret_iva_bien_porcentaje==null) {
					//newret_iva_bien_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_iva_bien_porcentaje");
					}
				}

				this.ret_iva_bien_porcentaje=newret_iva_bien_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_iva_bien_retenido(Double newret_iva_bien_retenido)throws Exception
	{
		try {
			if(this.ret_iva_bien_retenido!=newret_iva_bien_retenido) {
				if(newret_iva_bien_retenido==null) {
					//newret_iva_bien_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_iva_bien_retenido");
					}
				}

				this.ret_iva_bien_retenido=newret_iva_bien_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_retencion_iva2(String newnombre_tipo_retencion_iva2)throws Exception
	{
		try {
			if(this.nombre_tipo_retencion_iva2!=newnombre_tipo_retencion_iva2) {
				if(newnombre_tipo_retencion_iva2==null) {
					//newnombre_tipo_retencion_iva2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna nombre_tipo_retencion_iva2");
					}
				}

				if(newnombre_tipo_retencion_iva2!=null&&newnombre_tipo_retencion_iva2.length()>100) {
					newnombre_tipo_retencion_iva2=newnombre_tipo_retencion_iva2.substring(0,98);
					System.out.println("SriFacturasProveedoresIva012:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_retencion_iva2");
				}

				this.nombre_tipo_retencion_iva2=newnombre_tipo_retencion_iva2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_iva_servicio_porcentaje(Double newret_iva_servicio_porcentaje)throws Exception
	{
		try {
			if(this.ret_iva_servicio_porcentaje!=newret_iva_servicio_porcentaje) {
				if(newret_iva_servicio_porcentaje==null) {
					//newret_iva_servicio_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_iva_servicio_porcentaje");
					}
				}

				this.ret_iva_servicio_porcentaje=newret_iva_servicio_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setret_iva_servicio_retenido(Double newret_iva_servicio_retenido)throws Exception
	{
		try {
			if(this.ret_iva_servicio_retenido!=newret_iva_servicio_retenido) {
				if(newret_iva_servicio_retenido==null) {
					//newret_iva_servicio_retenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriFacturasProveedoresIva012:Valor nulo no permitido en columna ret_iva_servicio_retenido");
					}
				}

				this.ret_iva_servicio_retenido=newret_iva_servicio_retenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public PeriodoDeclara getPeriodoDeclara() {
		return this.periododeclara;
	}

	public TipoIva getTipoIva() {
		return this.tipoiva;
	}

	public TipoRetencion getTipoRetencionIva() {
		return this.tiporetencioniva;
	}

	public TipoRetencion getTipoRetencionIvaPresta() {
		return this.tiporetencionivapresta;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getperiododeclara_descripcion() {
		return this.periododeclara_descripcion;
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

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setTipoIva(TipoIva tipoiva) {
		try {
			this.tipoiva=tipoiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIva(TipoRetencion tiporetencioniva) {
		try {
			this.tiporetencioniva=tiporetencioniva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencionIvaPresta(TipoRetencion tiporetencionivapresta) {
		try {
			this.tiporetencionivapresta=tiporetencionivapresta;
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


	public  void  setperiododeclara_descripcion(String periododeclara_descripcion) {
		try {
			this.periododeclara_descripcion=periododeclara_descripcion;
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
	String id_empresa_descripcion="";String id_periodo_declara_descripcion="";String id_tipo_iva_descripcion="";String id_tipo_retencion_iva_descripcion="";String id_tipo_retencion_iva_presta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
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
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_declara_descripcion(String newid_periodo_declara_descripcion)throws Exception {
		try {
			this.id_periodo_declara_descripcion=newid_periodo_declara_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_periodo_declara_descripcion="";this.id_tipo_iva_descripcion="";this.id_tipo_retencion_iva_descripcion="";this.id_tipo_retencion_iva_presta_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

