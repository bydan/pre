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
//import com.bydan.erp.contabilidad.util.ImportarExportarConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ImportarExportar extends ImportarExportarAdditional implements Serializable ,Cloneable {//ImportarExportarAdditional,GeneralEntity
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
	
	private ImportarExportar importarexportarOriginal;
	
	private Map<String, Object> mapImportarExportar;
			
	public Map<String, Object> getMapImportarExportar() {
		return mapImportarExportar;
	}

	public void setMapImportarExportar(Map<String, Object> mapImportarExportar) {
		this.mapImportarExportar = mapImportarExportar;
	}
	
	public void inicializarMapImportarExportar() {
		this.mapImportarExportar = new HashMap<String,Object>();
	}
	
	public void setMapImportarExportarValue(String sKey,Object oValue) {
		this.mapImportarExportar.put(sKey, oValue);
	}
	
	public Object getMapImportarExportarValue(String sKey) {
		return this.mapImportarExportar.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXRUC,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo_import_export;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_conta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_tipo_importacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXDOCUMENTO_TRANSPORTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXDOCUMENTO_TRANSPORTE)
	private String documento_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXNUMERO_REFERENCIA_COMPROBANTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXNUMERO_REFERENCIA_COMPROBANTE)
	private String numero_referencia_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tributario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXCODIGO_FISCAL,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXCODIGO_FISCAL)
	private String codigo_fiscal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_juridico;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_total_cif;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_comprobante_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_convenio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXNUMERO_SERIE_COMPROBANTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE_COMPROBANTE)
	private String numero_serie_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXNUMERO_AUTORIZACION_COMPROBANTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION_COMPROBANTE)
	private String numero_autorizacion_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImportarExportarConstantesFunciones.SREGEXNUMERO_SECUENCIAL_FUENTE,message=ImportarExportarConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL_FUENTE)
	private String numero_secuencial_fuente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_fob;
			
	
	public Modulo modulo;
	public AsientoContable asientocontable;
	public PeriodoImportExport periodoimportexport;
	public TransaccionConta transaccionconta;
	public TipoImportacion tipoimportacion;
	public TipoComprobante tipocomprobante;
	public TipoTributario tipotributario;
	public Cliente cliente;
	public TipoIva tipoiva;
	public TipoIce tipoice;
	public TipoBanco tipobanco;
	public TipoComprobante tipocomprobantebanco;
	
	
	private String modulo_descripcion;
	private String asientocontable_descripcion;
	private String periodoimportexport_descripcion;
	private String transaccionconta_descripcion;
	private String tipoimportacion_descripcion;
	private String tipocomprobante_descripcion;
	private String tipotributario_descripcion;
	private String cliente_descripcion;
	private String tipoiva_descripcion;
	private String tipoice_descripcion;
	private String tipobanco_descripcion;
	private String tipocomprobantebanco_descripcion;
	
	
		
	public ImportarExportar () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.importarexportarOriginal=this;
		
 		this.id_modulo=-1L;
 		this.id_asiento_contable=-1L;
 		this.ruc="";
 		this.id_periodo_import_export=-1L;
 		this.id_transaccion_conta=-1L;
 		this.fecha=new Date();
 		this.id_tipo_importacion=-1L;
 		this.id_tipo_comprobante=-1L;
 		this.numero_comprobante="";
 		this.documento_transporte="";
 		this.numero_referencia_comprobante="";
 		this.id_tipo_tributario=-1L;
 		this.codigo_fiscal="";
 		this.id_cliente=-1L;
 		this.es_juridico=false;
 		this.base0=0.0;
 		this.monto_total_cif=0.0;
 		this.monto_iva=0.0;
 		this.id_tipo_iva=-1L;
 		this.monto_ice=0.0;
 		this.id_tipo_ice=-1L;
 		this.base_general=0.0;
 		this.id_tipo_banco=-1L;
 		this.id_tipo_comprobante_banco=-1L;
 		this.con_convenio=false;
 		this.con_devolucion=false;
 		this.fecha_emision=new Date();
 		this.numero_serie_comprobante="";
 		this.numero_autorizacion_comprobante="";
 		this.numero_secuencial_fuente="";
 		this.valor_fob=0.0;
		
		
		this.modulo=null;
		this.asientocontable=null;
		this.periodoimportexport=null;
		this.transaccionconta=null;
		this.tipoimportacion=null;
		this.tipocomprobante=null;
		this.tipotributario=null;
		this.cliente=null;
		this.tipoiva=null;
		this.tipoice=null;
		this.tipobanco=null;
		this.tipocomprobantebanco=null;
		
		
		this.modulo_descripcion="";
		this.asientocontable_descripcion="";
		this.periodoimportexport_descripcion="";
		this.transaccionconta_descripcion="";
		this.tipoimportacion_descripcion="";
		this.tipocomprobante_descripcion="";
		this.tipotributario_descripcion="";
		this.cliente_descripcion="";
		this.tipoiva_descripcion="";
		this.tipoice_descripcion="";
		this.tipobanco_descripcion="";
		this.tipocomprobantebanco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ImportarExportar (Long id,Date versionRow,Long id_modulo,Long id_asiento_contable,String ruc,Long id_periodo_import_export,Long id_transaccion_conta,Date fecha,Long id_tipo_importacion,Long id_tipo_comprobante,String numero_comprobante,String documento_transporte,String numero_referencia_comprobante,Long id_tipo_tributario,String codigo_fiscal,Long id_cliente,Boolean es_juridico,Double base0,Double monto_total_cif,Double monto_iva,Long id_tipo_iva,Double monto_ice,Long id_tipo_ice,Double base_general,Long id_tipo_banco,Long id_tipo_comprobante_banco,Boolean con_convenio,Boolean con_devolucion,Date fecha_emision,String numero_serie_comprobante,String numero_autorizacion_comprobante,String numero_secuencial_fuente,Double valor_fob) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.importarexportarOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.id_asiento_contable=id_asiento_contable;
 		this.ruc=ruc;
 		this.id_periodo_import_export=id_periodo_import_export;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.fecha=fecha;
 		this.id_tipo_importacion=id_tipo_importacion;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.numero_comprobante=numero_comprobante;
 		this.documento_transporte=documento_transporte;
 		this.numero_referencia_comprobante=numero_referencia_comprobante;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.codigo_fiscal=codigo_fiscal;
 		this.id_cliente=id_cliente;
 		this.es_juridico=es_juridico;
 		this.base0=base0;
 		this.monto_total_cif=monto_total_cif;
 		this.monto_iva=monto_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.monto_ice=monto_ice;
 		this.id_tipo_ice=id_tipo_ice;
 		this.base_general=base_general;
 		this.id_tipo_banco=id_tipo_banco;
 		this.id_tipo_comprobante_banco=id_tipo_comprobante_banco;
 		this.con_convenio=con_convenio;
 		this.con_devolucion=con_devolucion;
 		this.fecha_emision=fecha_emision;
 		this.numero_serie_comprobante=numero_serie_comprobante;
 		this.numero_autorizacion_comprobante=numero_autorizacion_comprobante;
 		this.numero_secuencial_fuente=numero_secuencial_fuente;
 		this.valor_fob=valor_fob;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ImportarExportar (Long id_modulo,Long id_asiento_contable,String ruc,Long id_periodo_import_export,Long id_transaccion_conta,Date fecha,Long id_tipo_importacion,Long id_tipo_comprobante,String numero_comprobante,String documento_transporte,String numero_referencia_comprobante,Long id_tipo_tributario,String codigo_fiscal,Long id_cliente,Boolean es_juridico,Double base0,Double monto_total_cif,Double monto_iva,Long id_tipo_iva,Double monto_ice,Long id_tipo_ice,Double base_general,Long id_tipo_banco,Long id_tipo_comprobante_banco,Boolean con_convenio,Boolean con_devolucion,Date fecha_emision,String numero_serie_comprobante,String numero_autorizacion_comprobante,String numero_secuencial_fuente,Double valor_fob) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.importarexportarOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.id_asiento_contable=id_asiento_contable;
 		this.ruc=ruc;
 		this.id_periodo_import_export=id_periodo_import_export;
 		this.id_transaccion_conta=id_transaccion_conta;
 		this.fecha=fecha;
 		this.id_tipo_importacion=id_tipo_importacion;
 		this.id_tipo_comprobante=id_tipo_comprobante;
 		this.numero_comprobante=numero_comprobante;
 		this.documento_transporte=documento_transporte;
 		this.numero_referencia_comprobante=numero_referencia_comprobante;
 		this.id_tipo_tributario=id_tipo_tributario;
 		this.codigo_fiscal=codigo_fiscal;
 		this.id_cliente=id_cliente;
 		this.es_juridico=es_juridico;
 		this.base0=base0;
 		this.monto_total_cif=monto_total_cif;
 		this.monto_iva=monto_iva;
 		this.id_tipo_iva=id_tipo_iva;
 		this.monto_ice=monto_ice;
 		this.id_tipo_ice=id_tipo_ice;
 		this.base_general=base_general;
 		this.id_tipo_banco=id_tipo_banco;
 		this.id_tipo_comprobante_banco=id_tipo_comprobante_banco;
 		this.con_convenio=con_convenio;
 		this.con_devolucion=con_devolucion;
 		this.fecha_emision=fecha_emision;
 		this.numero_serie_comprobante=numero_serie_comprobante;
 		this.numero_autorizacion_comprobante=numero_autorizacion_comprobante;
 		this.numero_secuencial_fuente=numero_secuencial_fuente;
 		this.valor_fob=valor_fob;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ImportarExportar importarexportarLocal=null;
		
		if(object!=null) {
			importarexportarLocal=(ImportarExportar)object;
			
			if(importarexportarLocal!=null) {
				if(this.getId()!=null && importarexportarLocal.getId()!=null) {
					if(this.getId().equals(importarexportarLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ImportarExportarConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ImportarExportarConstantesFunciones.getImportarExportarDescripcion(this);
		} else {
			sDetalle=ImportarExportarConstantesFunciones.getImportarExportarDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ImportarExportar getImportarExportarOriginal() {
		return this.importarexportarOriginal;
	}
	
	public void setImportarExportarOriginal(ImportarExportar importarexportar) {
		try {
			this.importarexportarOriginal=importarexportar;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ImportarExportarAdditional importarexportarAdditional=null;
	
	public ImportarExportarAdditional getImportarExportarAdditional() {
		return this.importarexportarAdditional;
	}
	
	public void setImportarExportarAdditional(ImportarExportarAdditional importarexportarAdditional) {
		try {
			this.importarexportarAdditional=importarexportarAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public Long getid_periodo_import_export() {
		return this.id_periodo_import_export;
	}
    
	
	public Long getid_transaccion_conta() {
		return this.id_transaccion_conta;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_tipo_importacion() {
		return this.id_tipo_importacion;
	}
    
	
	public Long getid_tipo_comprobante() {
		return this.id_tipo_comprobante;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getdocumento_transporte() {
		return this.documento_transporte;
	}
    
	
	public String getnumero_referencia_comprobante() {
		return this.numero_referencia_comprobante;
	}
    
	
	public Long getid_tipo_tributario() {
		return this.id_tipo_tributario;
	}
    
	
	public String getcodigo_fiscal() {
		return this.codigo_fiscal;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Boolean getes_juridico() {
		return this.es_juridico;
	}
    
	
	public Double getbase0() {
		return this.base0;
	}
    
	
	public Double getmonto_total_cif() {
		return this.monto_total_cif;
	}
    
	
	public Double getmonto_iva() {
		return this.monto_iva;
	}
    
	
	public Long getid_tipo_iva() {
		return this.id_tipo_iva;
	}
    
	
	public Double getmonto_ice() {
		return this.monto_ice;
	}
    
	
	public Long getid_tipo_ice() {
		return this.id_tipo_ice;
	}
    
	
	public Double getbase_general() {
		return this.base_general;
	}
    
	
	public Long getid_tipo_banco() {
		return this.id_tipo_banco;
	}
    
	
	public Long getid_tipo_comprobante_banco() {
		return this.id_tipo_comprobante_banco;
	}
    
	
	public Boolean getcon_convenio() {
		return this.con_convenio;
	}
    
	
	public Boolean getcon_devolucion() {
		return this.con_devolucion;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnumero_serie_comprobante() {
		return this.numero_serie_comprobante;
	}
    
	
	public String getnumero_autorizacion_comprobante() {
		return this.numero_autorizacion_comprobante;
	}
    
	
	public String getnumero_secuencial_fuente() {
		return this.numero_secuencial_fuente;
	}
    
	
	public Double getvalor_fob() {
		return this.valor_fob;
	}
	
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo_import_export(Long newid_periodo_import_export)throws Exception
	{
		try {
			if(this.id_periodo_import_export!=newid_periodo_import_export) {
				if(newid_periodo_import_export==null) {
					//newid_periodo_import_export=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_periodo_import_export");
					}
				}

				this.id_periodo_import_export=newid_periodo_import_export;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_transaccion_conta");
					}
				}

				this.id_transaccion_conta=newid_transaccion_conta;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_importacion(Long newid_tipo_importacion)throws Exception
	{
		try {
			if(this.id_tipo_importacion!=newid_tipo_importacion) {
				if(newid_tipo_importacion==null) {
					//newid_tipo_importacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_importacion");
					}
				}

				this.id_tipo_importacion=newid_tipo_importacion;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_comprobante");
					}
				}

				this.id_tipo_comprobante=newid_tipo_comprobante;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdocumento_transporte(String newdocumento_transporte)throws Exception
	{
		try {
			if(this.documento_transporte!=newdocumento_transporte) {
				if(newdocumento_transporte==null) {
					//newdocumento_transporte="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna documento_transporte");
					}
				}

				if(newdocumento_transporte!=null&&newdocumento_transporte.length()>50) {
					newdocumento_transporte=newdocumento_transporte.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna documento_transporte");
				}

				this.documento_transporte=newdocumento_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_referencia_comprobante(String newnumero_referencia_comprobante)throws Exception
	{
		try {
			if(this.numero_referencia_comprobante!=newnumero_referencia_comprobante) {
				if(newnumero_referencia_comprobante==null) {
					//newnumero_referencia_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna numero_referencia_comprobante");
					}
				}

				if(newnumero_referencia_comprobante!=null&&newnumero_referencia_comprobante.length()>50) {
					newnumero_referencia_comprobante=newnumero_referencia_comprobante.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_referencia_comprobante");
				}

				this.numero_referencia_comprobante=newnumero_referencia_comprobante;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_tributario");
					}
				}

				this.id_tipo_tributario=newid_tipo_tributario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_fiscal(String newcodigo_fiscal)throws Exception
	{
		try {
			if(this.codigo_fiscal!=newcodigo_fiscal) {
				if(newcodigo_fiscal==null) {
					//newcodigo_fiscal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna codigo_fiscal");
					}
				}

				if(newcodigo_fiscal!=null&&newcodigo_fiscal.length()>20) {
					newcodigo_fiscal=newcodigo_fiscal.substring(0,18);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_fiscal");
				}

				this.codigo_fiscal=newcodigo_fiscal;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_juridico(Boolean newes_juridico)throws Exception
	{
		try {
			if(this.es_juridico!=newes_juridico) {
				if(newes_juridico==null) {
					//newes_juridico=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna es_juridico");
					}
				}

				this.es_juridico=newes_juridico;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase0(Double newbase0)throws Exception
	{
		try {
			if(this.base0!=newbase0) {
				if(newbase0==null) {
					//newbase0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna base0");
					}
				}

				this.base0=newbase0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_total_cif(Double newmonto_total_cif)throws Exception
	{
		try {
			if(this.monto_total_cif!=newmonto_total_cif) {
				if(newmonto_total_cif==null) {
					//newmonto_total_cif=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna monto_total_cif");
					}
				}

				this.monto_total_cif=newmonto_total_cif;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna monto_iva");
					}
				}

				this.monto_iva=newmonto_iva;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_iva");
					}
				}

				this.id_tipo_iva=newid_tipo_iva;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna monto_ice");
					}
				}

				this.monto_ice=newmonto_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_ice(Long newid_tipo_ice)throws Exception
	{
		try {
			if(this.id_tipo_ice!=newid_tipo_ice) {
				if(newid_tipo_ice==null) {
					//newid_tipo_ice=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_ice");
					}
				}

				this.id_tipo_ice=newid_tipo_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_general(Double newbase_general)throws Exception
	{
		try {
			if(this.base_general!=newbase_general) {
				if(newbase_general==null) {
					//newbase_general=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna base_general");
					}
				}

				this.base_general=newbase_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_banco(Long newid_tipo_banco)throws Exception
	{
		try {
			if(this.id_tipo_banco!=newid_tipo_banco) {
				if(newid_tipo_banco==null) {
					//newid_tipo_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_banco");
					}
				}

				this.id_tipo_banco=newid_tipo_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_comprobante_banco(Long newid_tipo_comprobante_banco)throws Exception
	{
		try {
			if(this.id_tipo_comprobante_banco!=newid_tipo_comprobante_banco) {
				if(newid_tipo_comprobante_banco==null) {
					//newid_tipo_comprobante_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna id_tipo_comprobante_banco");
					}
				}

				this.id_tipo_comprobante_banco=newid_tipo_comprobante_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_convenio(Boolean newcon_convenio)throws Exception
	{
		try {
			if(this.con_convenio!=newcon_convenio) {
				if(newcon_convenio==null) {
					//newcon_convenio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna con_convenio");
					}
				}

				this.con_convenio=newcon_convenio;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna con_devolucion");
					}
				}

				this.con_devolucion=newcon_devolucion;
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
						System.out.println("ImportarExportar:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_serie_comprobante(String newnumero_serie_comprobante)throws Exception
	{
		try {
			if(this.numero_serie_comprobante!=newnumero_serie_comprobante) {
				if(newnumero_serie_comprobante==null) {
					//newnumero_serie_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna numero_serie_comprobante");
					}
				}

				if(newnumero_serie_comprobante!=null&&newnumero_serie_comprobante.length()>50) {
					newnumero_serie_comprobante=newnumero_serie_comprobante.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_serie_comprobante");
				}

				this.numero_serie_comprobante=newnumero_serie_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion_comprobante(String newnumero_autorizacion_comprobante)throws Exception
	{
		try {
			if(this.numero_autorizacion_comprobante!=newnumero_autorizacion_comprobante) {
				if(newnumero_autorizacion_comprobante==null) {
					//newnumero_autorizacion_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna numero_autorizacion_comprobante");
					}
				}

				if(newnumero_autorizacion_comprobante!=null&&newnumero_autorizacion_comprobante.length()>50) {
					newnumero_autorizacion_comprobante=newnumero_autorizacion_comprobante.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_autorizacion_comprobante");
				}

				this.numero_autorizacion_comprobante=newnumero_autorizacion_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuencial_fuente(String newnumero_secuencial_fuente)throws Exception
	{
		try {
			if(this.numero_secuencial_fuente!=newnumero_secuencial_fuente) {
				if(newnumero_secuencial_fuente==null) {
					//newnumero_secuencial_fuente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna numero_secuencial_fuente");
					}
				}

				if(newnumero_secuencial_fuente!=null&&newnumero_secuencial_fuente.length()>50) {
					newnumero_secuencial_fuente=newnumero_secuencial_fuente.substring(0,48);
					System.out.println("ImportarExportar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial_fuente");
				}

				this.numero_secuencial_fuente=newnumero_secuencial_fuente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_fob(Double newvalor_fob)throws Exception
	{
		try {
			if(this.valor_fob!=newvalor_fob) {
				if(newvalor_fob==null) {
					//newvalor_fob=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImportarExportar:Valor nulo no permitido en columna valor_fob");
					}
				}

				this.valor_fob=newvalor_fob;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Modulo getModulo() {
		return this.modulo;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public PeriodoImportExport getPeriodoImportExport() {
		return this.periodoimportexport;
	}

	public TransaccionConta getTransaccionConta() {
		return this.transaccionconta;
	}

	public TipoImportacion getTipoImportacion() {
		return this.tipoimportacion;
	}

	public TipoComprobante getTipoComprobante() {
		return this.tipocomprobante;
	}

	public TipoTributario getTipoTributario() {
		return this.tipotributario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoIva getTipoIva() {
		return this.tipoiva;
	}

	public TipoIce getTipoIce() {
		return this.tipoice;
	}

	public TipoBanco getTipoBanco() {
		return this.tipobanco;
	}

	public TipoComprobante getTipoComprobanteBanco() {
		return this.tipocomprobantebanco;
	}

	
	
	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getperiodoimportexport_descripcion() {
		return this.periodoimportexport_descripcion;
	}

	public String gettransaccionconta_descripcion() {
		return this.transaccionconta_descripcion;
	}

	public String gettipoimportacion_descripcion() {
		return this.tipoimportacion_descripcion;
	}

	public String gettipocomprobante_descripcion() {
		return this.tipocomprobante_descripcion;
	}

	public String gettipotributario_descripcion() {
		return this.tipotributario_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoiva_descripcion() {
		return this.tipoiva_descripcion;
	}

	public String gettipoice_descripcion() {
		return this.tipoice_descripcion;
	}

	public String gettipobanco_descripcion() {
		return this.tipobanco_descripcion;
	}

	public String gettipocomprobantebanco_descripcion() {
		return this.tipocomprobantebanco_descripcion;
	}

	
	
	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setPeriodoImportExport(PeriodoImportExport periodoimportexport) {
		try {
			this.periodoimportexport=periodoimportexport;
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


	public  void  setTipoImportacion(TipoImportacion tipoimportacion) {
		try {
			this.tipoimportacion=tipoimportacion;
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


	public  void  setTipoIce(TipoIce tipoice) {
		try {
			this.tipoice=tipoice;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoBanco(TipoBanco tipobanco) {
		try {
			this.tipobanco=tipobanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoComprobanteBanco(TipoComprobante tipocomprobantebanco) {
		try {
			this.tipocomprobantebanco=tipocomprobantebanco;
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


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodoimportexport_descripcion(String periodoimportexport_descripcion) {
		try {
			this.periodoimportexport_descripcion=periodoimportexport_descripcion;
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


	public  void  settipoimportacion_descripcion(String tipoimportacion_descripcion) {
		try {
			this.tipoimportacion_descripcion=tipoimportacion_descripcion;
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


	public  void  settipoice_descripcion(String tipoice_descripcion) {
		try {
			this.tipoice_descripcion=tipoice_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipobanco_descripcion(String tipobanco_descripcion) {
		try {
			this.tipobanco_descripcion=tipobanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocomprobantebanco_descripcion(String tipocomprobantebanco_descripcion) {
		try {
			this.tipocomprobantebanco_descripcion=tipocomprobantebanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_modulo_descripcion="";String id_asiento_contable_descripcion="";String id_periodo_import_export_descripcion="";String id_transaccion_conta_descripcion="";String id_tipo_importacion_descripcion="";String id_tipo_comprobante_descripcion="";String id_tipo_tributario_descripcion="";String id_cliente_descripcion="";String es_juridico_descripcion="";String id_tipo_iva_descripcion="";String id_tipo_ice_descripcion="";String id_tipo_banco_descripcion="";String id_tipo_comprobante_banco_descripcion="";String con_convenio_descripcion="";String con_devolucion_descripcion="";
	
	
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_periodo_import_export_descripcion() {
		return id_periodo_import_export_descripcion;
	}
	public String getid_transaccion_conta_descripcion() {
		return id_transaccion_conta_descripcion;
	}
	public String getid_tipo_importacion_descripcion() {
		return id_tipo_importacion_descripcion;
	}
	public String getid_tipo_comprobante_descripcion() {
		return id_tipo_comprobante_descripcion;
	}
	public String getid_tipo_tributario_descripcion() {
		return id_tipo_tributario_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_juridico_descripcion() {
		return es_juridico_descripcion;
	}
	public String getid_tipo_iva_descripcion() {
		return id_tipo_iva_descripcion;
	}
	public String getid_tipo_ice_descripcion() {
		return id_tipo_ice_descripcion;
	}
	public String getid_tipo_banco_descripcion() {
		return id_tipo_banco_descripcion;
	}
	public String getid_tipo_comprobante_banco_descripcion() {
		return id_tipo_comprobante_banco_descripcion;
	}
	public String getcon_convenio_descripcion() {
		return con_convenio_descripcion;
	}
	public String getcon_devolucion_descripcion() {
		return con_devolucion_descripcion;
	}
	
	
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
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
	public void setid_periodo_import_export_descripcion(String newid_periodo_import_export_descripcion)throws Exception {
		try {
			this.id_periodo_import_export_descripcion=newid_periodo_import_export_descripcion;
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
	public void setid_tipo_importacion_descripcion(String newid_tipo_importacion_descripcion) {
		this.id_tipo_importacion_descripcion=newid_tipo_importacion_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_juridico_descripcion(String newes_juridico_descripcion)throws Exception {
		try {
			this.es_juridico_descripcion=newes_juridico_descripcion;
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
	public void setid_tipo_ice_descripcion(String newid_tipo_ice_descripcion)throws Exception {
		try {
			this.id_tipo_ice_descripcion=newid_tipo_ice_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_banco_descripcion(String newid_tipo_banco_descripcion)throws Exception {
		try {
			this.id_tipo_banco_descripcion=newid_tipo_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_comprobante_banco_descripcion(String newid_tipo_comprobante_banco_descripcion)throws Exception {
		try {
			this.id_tipo_comprobante_banco_descripcion=newid_tipo_comprobante_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_convenio_descripcion(String newcon_convenio_descripcion)throws Exception {
		try {
			this.con_convenio_descripcion=newcon_convenio_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_modulo_descripcion="";this.id_asiento_contable_descripcion="";this.id_periodo_import_export_descripcion="";this.id_transaccion_conta_descripcion="";this.id_tipo_importacion_descripcion="";this.id_tipo_comprobante_descripcion="";this.id_tipo_tributario_descripcion="";this.id_cliente_descripcion="";this.es_juridico_descripcion="";this.id_tipo_iva_descripcion="";this.id_tipo_ice_descripcion="";this.id_tipo_banco_descripcion="";this.id_tipo_comprobante_banco_descripcion="";this.con_convenio_descripcion="";this.con_devolucion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

