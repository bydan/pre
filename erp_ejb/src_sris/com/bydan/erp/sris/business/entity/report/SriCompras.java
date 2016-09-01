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
//import com.bydan.erp.sris.util.SriComprasConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class SriCompras extends SriComprasAdditional implements Serializable ,Cloneable {//SriComprasAdditional,GeneralEntity
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
	
	private SriCompras sricomprasOriginal;
	
	private Map<String, Object> mapSriCompras;
			
	public Map<String, Object> getMapSriCompras() {
		return mapSriCompras;
	}

	public void setMapSriCompras(Map<String, Object> mapSriCompras) {
		this.mapSriCompras = mapSriCompras;
	}
	
	public void inicializarMapSriCompras() {
		this.mapSriCompras = new HashMap<String,Object>();
	}
	
	public void setMapSriComprasValue(String sKey,Object oValue) {
		this.mapSriCompras.put(sKey, oValue);
	}
	
	public Object getMapSriComprasValue(String sKey) {
		return this.mapSriCompras.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXRUC,message=SriComprasConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNOMBRE_TIPO_COMPROBANTE,message=SriComprasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_COMPROBANTE)
	private String nombre_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=SriComprasConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXRUC_DATO,message=SriComprasConstantesFunciones.SMENSAJEREGEXRUC_DATO)
	private String ruc_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=SriComprasConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_registro_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNUMERO_SERIE,message=SriComprasConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=SriComprasConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bienes_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double servicios_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double transfe_iva_retener;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double transfe_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double presta_iva_retener;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion_iva_presta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double presta_iva_retenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXCODIGO_ASIENTO_CONTABLE,message=SriComprasConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO_CONTABLE)
	private String codigo_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=SriComprasConstantesFunciones.SREGEXNUMERO_DOCUMENTO_CONTABLE,message=SriComprasConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO_CONTABLE)
	private String numero_documento_contable;
			
	
	public Empresa empresa;
	public PeriodoDeclara periododeclara;
	public Cliente cliente;
	public TipoIva tipoiva;
	public TipoRetencion tiporetencioniva;
	public TipoRetencion tiporetencionivapresta;
	
	
	private String empresa_descripcion;
	private String periododeclara_descripcion;
	private String cliente_descripcion;
	private String tipoiva_descripcion;
	private String tiporetencioniva_descripcion;
	private String tiporetencionivapresta_descripcion;
	
	
		
	public SriCompras () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.sricomprasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_periodo_declara=-1L;
 		this.id_cliente=-1L;
 		this.ruc="";
 		this.nombre_tipo_comprobante="";
 		this.nombre_completo_cliente="";
 		this.ruc_dato="";
 		this.numero_documento="";
 		this.fecha_emision=new Date();
 		this.fecha_registro_contable=new Date();
 		this.numero_serie="";
 		this.numero_autorizacion="";
 		this.bienes_iva=0.0;
 		this.servicion_iva=0.0;
 		this.total_iva=0.0;
 		this.bienes_sin_iva=0.0;
 		this.servicios_sin_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.id_tipo_iva=-1L;
 		this.monto_iva=0.0;
 		this.monto_ice=0.0;
 		this.transfe_iva_retener=0.0;
 		this.id_tipo_retencion_iva=-1L;
 		this.transfe_iva_retenido=0.0;
 		this.presta_iva_retener=0.0;
 		this.id_tipo_retencion_iva_presta=-1L;
 		this.presta_iva_retenido=0.0;
 		this.fecha_caducidad=new Date();
 		this.codigo_asiento_contable="";
 		this.numero_documento_contable="";
		
		
		this.empresa=null;
		this.periododeclara=null;
		this.cliente=null;
		this.tipoiva=null;
		this.tiporetencioniva=null;
		this.tiporetencionivapresta=null;
		
		
		this.empresa_descripcion="";
		this.periododeclara_descripcion="";
		this.cliente_descripcion="";
		this.tipoiva_descripcion="";
		this.tiporetencioniva_descripcion="";
		this.tiporetencionivapresta_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SriCompras (Long id,Date versionRow,String nombre_tipo_comprobante,String nombre_completo_cliente,String ruc_dato,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,String numero_autorizacion,Double bienes_iva,Double servicion_iva,Double total_iva,Double bienes_sin_iva,Double servicios_sin_iva,Double total_sin_iva,Long id_tipo_iva,Double monto_iva,Double monto_ice,Double transfe_iva_retener,Long id_tipo_retencion_iva,Double transfe_iva_retenido,Double presta_iva_retener,Long id_tipo_retencion_iva_presta,Double presta_iva_retenido,Date fecha_caducidad,String codigo_asiento_contable,String numero_documento_contable) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sricomprasOriginal=this;
		
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.ruc_dato=ruc_dato;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.bienes_iva=bienes_iva;
 		this.servicion_iva=servicion_iva;
 		this.total_iva=total_iva;
 		this.bienes_sin_iva=bienes_sin_iva;
 		this.servicios_sin_iva=servicios_sin_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.monto_iva=monto_iva;
 		this.monto_ice=monto_ice;
 		this.transfe_iva_retener=transfe_iva_retener;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.presta_iva_retener=presta_iva_retener;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.fecha_caducidad=fecha_caducidad;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.numero_documento_contable=numero_documento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SriCompras (String nombre_tipo_comprobante,String nombre_completo_cliente,String ruc_dato,String numero_documento,Date fecha_emision,Date fecha_registro_contable,String numero_serie,String numero_autorizacion,Double bienes_iva,Double servicion_iva,Double total_iva,Double bienes_sin_iva,Double servicios_sin_iva,Double total_sin_iva,Long id_tipo_iva,Double monto_iva,Double monto_ice,Double transfe_iva_retener,Long id_tipo_retencion_iva,Double transfe_iva_retenido,Double presta_iva_retener,Long id_tipo_retencion_iva_presta,Double presta_iva_retenido,Date fecha_caducidad,String codigo_asiento_contable,String numero_documento_contable) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.sricomprasOriginal=this;
		
 		this.nombre_tipo_comprobante=nombre_tipo_comprobante;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.ruc_dato=ruc_dato;
 		this.numero_documento=numero_documento;
 		this.fecha_emision=fecha_emision;
 		this.fecha_registro_contable=fecha_registro_contable;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.bienes_iva=bienes_iva;
 		this.servicion_iva=servicion_iva;
 		this.total_iva=total_iva;
 		this.bienes_sin_iva=bienes_sin_iva;
 		this.servicios_sin_iva=servicios_sin_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.monto_iva=monto_iva;
 		this.monto_ice=monto_ice;
 		this.transfe_iva_retener=transfe_iva_retener;
 		this.id_tipo_retencion_iva=id_tipo_retencion_iva;
 		this.transfe_iva_retenido=transfe_iva_retenido;
 		this.presta_iva_retener=presta_iva_retener;
 		this.id_tipo_retencion_iva_presta=id_tipo_retencion_iva_presta;
 		this.presta_iva_retenido=presta_iva_retenido;
 		this.fecha_caducidad=fecha_caducidad;
 		this.codigo_asiento_contable=codigo_asiento_contable;
 		this.numero_documento_contable=numero_documento_contable;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public SriCompras getSriComprasOriginal() {
		return this.sricomprasOriginal;
	}
	
	public void setSriComprasOriginal(SriCompras sricompras) {
		try {
			this.sricomprasOriginal=sricompras;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SriComprasAdditional sricomprasAdditional=null;
	
	public SriComprasAdditional getSriComprasAdditional() {
		return this.sricomprasAdditional;
	}
	
	public void setSriComprasAdditional(SriComprasAdditional sricomprasAdditional) {
		try {
			this.sricomprasAdditional=sricomprasAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
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
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public Double getbienes_iva() {
		return this.bienes_iva;
	}
    
	
	public Double getservicion_iva() {
		return this.servicion_iva;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double getbienes_sin_iva() {
		return this.bienes_sin_iva;
	}
    
	
	public Double getservicios_sin_iva() {
		return this.servicios_sin_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Long getid_tipo_iva() {
		return this.id_tipo_iva;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public Double getmonto_ice() {
		return this.monto_ice;
	}
    
	
	public Double gettransfe_iva_retener() {
		return this.transfe_iva_retener;
	}
    
	
	public Long getid_tipo_retencion_iva() {
		return this.id_tipo_retencion_iva;
	}
    
	
	public Double gettransfe_iva_retenido() {
		return this.transfe_iva_retenido;
	}
    
	
	public Double getpresta_iva_retener() {
		return this.presta_iva_retener;
	}
    
	
	public Long getid_tipo_retencion_iva_presta() {
		return this.id_tipo_retencion_iva_presta;
	}
    
	
	public Double getpresta_iva_retenido() {
		return this.presta_iva_retenido;
	}
    
	
	public Date getfecha_caducidad() {
		return this.fecha_caducidad;
	}
    
	
	public String getcodigo_asiento_contable() {
		return this.codigo_asiento_contable;
	}
    
	
	public String getnumero_documento_contable() {
		return this.numero_documento_contable;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriCompras:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna id_periodo_declara");
					}
				}

				this.id_periodo_declara=newid_periodo_declara;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna id_cliente");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna nombre_tipo_comprobante");
					}
				}

				if(newnombre_tipo_comprobante!=null&&newnombre_tipo_comprobante.length()>100) {
					newnombre_tipo_comprobante=newnombre_tipo_comprobante.substring(0,98);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_comprobante");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna ruc_dato");
					}
				}

				if(newruc_dato!=null&&newruc_dato.length()>20) {
					newruc_dato=newruc_dato.substring(0,18);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc_dato");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna fecha_emision");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna fecha_registro_contable");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>50) {
					newnumero_serie=newnumero_serie.substring(0,48);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>20) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,18);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna bienes_iva");
					}
				}

				this.bienes_iva=newbienes_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setservicion_iva(Double newservicion_iva)throws Exception
	{
		try {
			if(this.servicion_iva!=newservicion_iva) {
				if(newservicion_iva==null) {
					//newservicion_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriCompras:Valor nulo no permitido en columna servicion_iva");
					}
				}

				this.servicion_iva=newservicion_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna bienes_sin_iva");
					}
				}

				this.bienes_sin_iva=newbienes_sin_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna servicios_sin_iva");
					}
				}

				this.servicios_sin_iva=newservicios_sin_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna total_sin_iva");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna id_tipo_iva");
					}
				}

				this.id_tipo_iva=newid_tipo_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna monto_ice");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna transfe_iva_retener");
					}
				}

				this.transfe_iva_retener=newtransfe_iva_retener;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna id_tipo_retencion_iva");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna transfe_iva_retenido");
					}
				}

				this.transfe_iva_retenido=newtransfe_iva_retenido;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna presta_iva_retener");
					}
				}

				this.presta_iva_retener=newpresta_iva_retener;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna id_tipo_retencion_iva_presta");
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
						System.out.println("SriCompras:Valor nulo no permitido en columna presta_iva_retenido");
					}
				}

				this.presta_iva_retenido=newpresta_iva_retenido;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna fecha_caducidad");
					}
				}

				this.fecha_caducidad=newfecha_caducidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_asiento_contable(String newcodigo_asiento_contable)throws Exception
	{
		try {
			if(this.codigo_asiento_contable!=newcodigo_asiento_contable) {
				if(newcodigo_asiento_contable==null) {
					//newcodigo_asiento_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SriCompras:Valor nulo no permitido en columna codigo_asiento_contable");
					}
				}

				if(newcodigo_asiento_contable!=null&&newcodigo_asiento_contable.length()>50) {
					newcodigo_asiento_contable=newcodigo_asiento_contable.substring(0,48);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento_contable");
				}

				this.codigo_asiento_contable=newcodigo_asiento_contable;
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
						System.out.println("SriCompras:Valor nulo no permitido en columna numero_documento_contable");
					}
				}

				if(newnumero_documento_contable!=null&&newnumero_documento_contable.length()>50) {
					newnumero_documento_contable=newnumero_documento_contable.substring(0,48);
					System.out.println("SriCompras:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento_contable");
				}

				this.numero_documento_contable=newnumero_documento_contable;
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

	public Cliente getCliente() {
		return this.cliente;
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

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
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
	String id_empresa_descripcion="";String id_periodo_declara_descripcion="";String id_cliente_descripcion="";String id_tipo_iva_descripcion="";String id_tipo_retencion_iva_descripcion="";String id_tipo_retencion_iva_presta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_periodo_declara_descripcion() {
		return id_periodo_declara_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
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
		this.id_empresa_descripcion="";this.id_periodo_declara_descripcion="";this.id_cliente_descripcion="";this.id_tipo_iva_descripcion="";this.id_tipo_retencion_iva_descripcion="";this.id_tipo_retencion_iva_presta_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

