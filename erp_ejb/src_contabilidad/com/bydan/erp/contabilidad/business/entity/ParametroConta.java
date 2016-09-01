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
//import com.bydan.erp.contabilidad.util.ParametroContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ParametroConta extends ParametroContaAdditional implements Serializable ,Cloneable {//ParametroContaAdditional,GeneralEntity
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
	
	private ParametroConta parametrocontaOriginal;
	
	private Map<String, Object> mapParametroConta;
			
	public Map<String, Object> getMapParametroConta() {
		return mapParametroConta;
	}

	public void setMapParametroConta(Map<String, Object> mapParametroConta) {
		this.mapParametroConta = mapParametroConta;
	}
	
	public void inicializarMapParametroConta() {
		this.mapParametroConta = new HashMap<String,Object>();
	}
	
	public void setMapParametroContaValue(String sKey,Object oValue) {
		this.mapParametroConta.put(sKey, oValue);
	}
	
	public Object getMapParametroContaValue(String sKey) {
		return this.mapParametroConta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda_extranjera;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mascara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_nivel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_presupuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_secuencial_automatico;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cuentas_niff;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_centro_costo_mascara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_centro_costo_nueva_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer centro_costo_numero_nivel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_pasivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_patrimonio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_egreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_resumen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_deudor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_acreedor;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_ingreso1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_ingreso2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_ingreso3;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_egreso1;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_egreso2;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_cuenta_contable_egreso3;
			
	
	public Empresa empresa;
	public Moneda moneda;
	public Moneda monedaextranjera;
	public CuentaContable cuentacontableactivo;
	public CuentaContable cuentacontablepasivo;
	public CuentaContable cuentacontablepatrimonio;
	public CuentaContable cuentacontableingreso;
	public CuentaContable cuentacontableegreso;
	public CuentaContable cuentacontableresumen;
	public CuentaContable cuentacontabledeudor;
	public CuentaContable cuentacontableacreedor;
	public CuentaContable cuentacontableingreso1;
	public CuentaContable cuentacontableingreso2;
	public CuentaContable cuentacontableingreso3;
	public CuentaContable cuentacontableegreso1;
	public CuentaContable cuentacontableegreso2;
	public CuentaContable cuentacontableegreso3;
	
	
	private String empresa_descripcion;
	private String moneda_descripcion;
	private String monedaextranjera_descripcion;
	private String cuentacontableactivo_descripcion;
	private String cuentacontablepasivo_descripcion;
	private String cuentacontablepatrimonio_descripcion;
	private String cuentacontableingreso_descripcion;
	private String cuentacontableegreso_descripcion;
	private String cuentacontableresumen_descripcion;
	private String cuentacontabledeudor_descripcion;
	private String cuentacontableacreedor_descripcion;
	private String cuentacontableingreso1_descripcion;
	private String cuentacontableingreso2_descripcion;
	private String cuentacontableingreso3_descripcion;
	private String cuentacontableegreso1_descripcion;
	private String cuentacontableegreso2_descripcion;
	private String cuentacontableegreso3_descripcion;
	
	
	public List<ParametroContaDetalle> parametrocontadetalles;
		
	public ParametroConta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrocontaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_moneda=-1L;
 		this.id_moneda_extranjera=-1L;
 		this.con_mascara=false;
 		this.numero_nivel=0;
 		this.es_presupuesto=false;
 		this.es_lote=false;
 		this.con_secuencial_automatico=false;
 		this.con_cuentas_niff=false;
 		this.con_centro_costo_mascara=false;
 		this.con_centro_costo_nueva_estructura=false;
 		this.centro_costo_numero_nivel=0;
 		this.id_cuenta_contable_activo=-1L;
 		this.id_cuenta_contable_pasivo=-1L;
 		this.id_cuenta_contable_patrimonio=-1L;
 		this.id_cuenta_contable_ingreso=-1L;
 		this.id_cuenta_contable_egreso=-1L;
 		this.id_cuenta_contable_resumen=-1L;
 		this.id_cuenta_contable_deudor=-1L;
 		this.id_cuenta_contable_acreedor=-1L;
 		this.id_cuenta_contable_ingreso1=null;
 		this.id_cuenta_contable_ingreso2=null;
 		this.id_cuenta_contable_ingreso3=null;
 		this.id_cuenta_contable_egreso1=null;
 		this.id_cuenta_contable_egreso2=null;
 		this.id_cuenta_contable_egreso3=null;
		
		
		this.empresa=null;
		this.moneda=null;
		this.monedaextranjera=null;
		this.cuentacontableactivo=null;
		this.cuentacontablepasivo=null;
		this.cuentacontablepatrimonio=null;
		this.cuentacontableingreso=null;
		this.cuentacontableegreso=null;
		this.cuentacontableresumen=null;
		this.cuentacontabledeudor=null;
		this.cuentacontableacreedor=null;
		this.cuentacontableingreso1=null;
		this.cuentacontableingreso2=null;
		this.cuentacontableingreso3=null;
		this.cuentacontableegreso1=null;
		this.cuentacontableegreso2=null;
		this.cuentacontableegreso3=null;
		
		
		this.empresa_descripcion="";
		this.moneda_descripcion="";
		this.monedaextranjera_descripcion="";
		this.cuentacontableactivo_descripcion="";
		this.cuentacontablepasivo_descripcion="";
		this.cuentacontablepatrimonio_descripcion="";
		this.cuentacontableingreso_descripcion="";
		this.cuentacontableegreso_descripcion="";
		this.cuentacontableresumen_descripcion="";
		this.cuentacontabledeudor_descripcion="";
		this.cuentacontableacreedor_descripcion="";
		this.cuentacontableingreso1_descripcion="";
		this.cuentacontableingreso2_descripcion="";
		this.cuentacontableingreso3_descripcion="";
		this.cuentacontableegreso1_descripcion="";
		this.cuentacontableegreso2_descripcion="";
		this.cuentacontableegreso3_descripcion="";
		
		
		this.parametrocontadetalles=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroConta (Long id,Date versionRow,Long id_empresa,Long id_moneda,Long id_moneda_extranjera,Boolean con_mascara,Integer numero_nivel,Boolean es_presupuesto,Boolean es_lote,Boolean con_secuencial_automatico,Boolean con_cuentas_niff,Boolean con_centro_costo_mascara,Boolean con_centro_costo_nueva_estructura,Integer centro_costo_numero_nivel,Long id_cuenta_contable_activo,Long id_cuenta_contable_pasivo,Long id_cuenta_contable_patrimonio,Long id_cuenta_contable_ingreso,Long id_cuenta_contable_egreso,Long id_cuenta_contable_resumen,Long id_cuenta_contable_deudor,Long id_cuenta_contable_acreedor,Long id_cuenta_contable_ingreso1,Long id_cuenta_contable_ingreso2,Long id_cuenta_contable_ingreso3,Long id_cuenta_contable_egreso1,Long id_cuenta_contable_egreso2,Long id_cuenta_contable_egreso3) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_moneda=id_moneda;
 		this.id_moneda_extranjera=id_moneda_extranjera;
 		this.con_mascara=con_mascara;
 		this.numero_nivel=numero_nivel;
 		this.es_presupuesto=es_presupuesto;
 		this.es_lote=es_lote;
 		this.con_secuencial_automatico=con_secuencial_automatico;
 		this.con_cuentas_niff=con_cuentas_niff;
 		this.con_centro_costo_mascara=con_centro_costo_mascara;
 		this.con_centro_costo_nueva_estructura=con_centro_costo_nueva_estructura;
 		this.centro_costo_numero_nivel=centro_costo_numero_nivel;
 		this.id_cuenta_contable_activo=id_cuenta_contable_activo;
 		this.id_cuenta_contable_pasivo=id_cuenta_contable_pasivo;
 		this.id_cuenta_contable_patrimonio=id_cuenta_contable_patrimonio;
 		this.id_cuenta_contable_ingreso=id_cuenta_contable_ingreso;
 		this.id_cuenta_contable_egreso=id_cuenta_contable_egreso;
 		this.id_cuenta_contable_resumen=id_cuenta_contable_resumen;
 		this.id_cuenta_contable_deudor=id_cuenta_contable_deudor;
 		this.id_cuenta_contable_acreedor=id_cuenta_contable_acreedor;
 		this.id_cuenta_contable_ingreso1=id_cuenta_contable_ingreso1;
 		this.id_cuenta_contable_ingreso2=id_cuenta_contable_ingreso2;
 		this.id_cuenta_contable_ingreso3=id_cuenta_contable_ingreso3;
 		this.id_cuenta_contable_egreso1=id_cuenta_contable_egreso1;
 		this.id_cuenta_contable_egreso2=id_cuenta_contable_egreso2;
 		this.id_cuenta_contable_egreso3=id_cuenta_contable_egreso3;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroConta (Long id_empresa,Long id_moneda,Long id_moneda_extranjera,Boolean con_mascara,Integer numero_nivel,Boolean es_presupuesto,Boolean es_lote,Boolean con_secuencial_automatico,Boolean con_cuentas_niff,Boolean con_centro_costo_mascara,Boolean con_centro_costo_nueva_estructura,Integer centro_costo_numero_nivel,Long id_cuenta_contable_activo,Long id_cuenta_contable_pasivo,Long id_cuenta_contable_patrimonio,Long id_cuenta_contable_ingreso,Long id_cuenta_contable_egreso,Long id_cuenta_contable_resumen,Long id_cuenta_contable_deudor,Long id_cuenta_contable_acreedor,Long id_cuenta_contable_ingreso1,Long id_cuenta_contable_ingreso2,Long id_cuenta_contable_ingreso3,Long id_cuenta_contable_egreso1,Long id_cuenta_contable_egreso2,Long id_cuenta_contable_egreso3) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrocontaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_moneda=id_moneda;
 		this.id_moneda_extranjera=id_moneda_extranjera;
 		this.con_mascara=con_mascara;
 		this.numero_nivel=numero_nivel;
 		this.es_presupuesto=es_presupuesto;
 		this.es_lote=es_lote;
 		this.con_secuencial_automatico=con_secuencial_automatico;
 		this.con_cuentas_niff=con_cuentas_niff;
 		this.con_centro_costo_mascara=con_centro_costo_mascara;
 		this.con_centro_costo_nueva_estructura=con_centro_costo_nueva_estructura;
 		this.centro_costo_numero_nivel=centro_costo_numero_nivel;
 		this.id_cuenta_contable_activo=id_cuenta_contable_activo;
 		this.id_cuenta_contable_pasivo=id_cuenta_contable_pasivo;
 		this.id_cuenta_contable_patrimonio=id_cuenta_contable_patrimonio;
 		this.id_cuenta_contable_ingreso=id_cuenta_contable_ingreso;
 		this.id_cuenta_contable_egreso=id_cuenta_contable_egreso;
 		this.id_cuenta_contable_resumen=id_cuenta_contable_resumen;
 		this.id_cuenta_contable_deudor=id_cuenta_contable_deudor;
 		this.id_cuenta_contable_acreedor=id_cuenta_contable_acreedor;
 		this.id_cuenta_contable_ingreso1=id_cuenta_contable_ingreso1;
 		this.id_cuenta_contable_ingreso2=id_cuenta_contable_ingreso2;
 		this.id_cuenta_contable_ingreso3=id_cuenta_contable_ingreso3;
 		this.id_cuenta_contable_egreso1=id_cuenta_contable_egreso1;
 		this.id_cuenta_contable_egreso2=id_cuenta_contable_egreso2;
 		this.id_cuenta_contable_egreso3=id_cuenta_contable_egreso3;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroConta parametrocontaLocal=null;
		
		if(object!=null) {
			parametrocontaLocal=(ParametroConta)object;
			
			if(parametrocontaLocal!=null) {
				if(this.getId()!=null && parametrocontaLocal.getId()!=null) {
					if(this.getId().equals(parametrocontaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroContaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroContaConstantesFunciones.getParametroContaDescripcion(this);
		} else {
			sDetalle=ParametroContaConstantesFunciones.getParametroContaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroConta getParametroContaOriginal() {
		return this.parametrocontaOriginal;
	}
	
	public void setParametroContaOriginal(ParametroConta parametroconta) {
		try {
			this.parametrocontaOriginal=parametroconta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroContaAdditional parametrocontaAdditional=null;
	
	public ParametroContaAdditional getParametroContaAdditional() {
		return this.parametrocontaAdditional;
	}
	
	public void setParametroContaAdditional(ParametroContaAdditional parametrocontaAdditional) {
		try {
			this.parametrocontaAdditional=parametrocontaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_moneda_extranjera() {
		return this.id_moneda_extranjera;
	}
    
	
	public Boolean getcon_mascara() {
		return this.con_mascara;
	}
    
	
	public Integer getnumero_nivel() {
		return this.numero_nivel;
	}
    
	
	public Boolean getes_presupuesto() {
		return this.es_presupuesto;
	}
    
	
	public Boolean getes_lote() {
		return this.es_lote;
	}
    
	
	public Boolean getcon_secuencial_automatico() {
		return this.con_secuencial_automatico;
	}
    
	
	public Boolean getcon_cuentas_niff() {
		return this.con_cuentas_niff;
	}
    
	
	public Boolean getcon_centro_costo_mascara() {
		return this.con_centro_costo_mascara;
	}
    
	
	public Boolean getcon_centro_costo_nueva_estructura() {
		return this.con_centro_costo_nueva_estructura;
	}
    
	
	public Integer getcentro_costo_numero_nivel() {
		return this.centro_costo_numero_nivel;
	}
    
	
	public Long getid_cuenta_contable_activo() {
		return this.id_cuenta_contable_activo;
	}
    
	
	public Long getid_cuenta_contable_pasivo() {
		return this.id_cuenta_contable_pasivo;
	}
    
	
	public Long getid_cuenta_contable_patrimonio() {
		return this.id_cuenta_contable_patrimonio;
	}
    
	
	public Long getid_cuenta_contable_ingreso() {
		return this.id_cuenta_contable_ingreso;
	}
    
	
	public Long getid_cuenta_contable_egreso() {
		return this.id_cuenta_contable_egreso;
	}
    
	
	public Long getid_cuenta_contable_resumen() {
		return this.id_cuenta_contable_resumen;
	}
    
	
	public Long getid_cuenta_contable_deudor() {
		return this.id_cuenta_contable_deudor;
	}
    
	
	public Long getid_cuenta_contable_acreedor() {
		return this.id_cuenta_contable_acreedor;
	}
    
	
	public Long getid_cuenta_contable_ingreso1() {
		return this.id_cuenta_contable_ingreso1;
	}
    
	
	public Long getid_cuenta_contable_ingreso2() {
		return this.id_cuenta_contable_ingreso2;
	}
    
	
	public Long getid_cuenta_contable_ingreso3() {
		return this.id_cuenta_contable_ingreso3;
	}
    
	
	public Long getid_cuenta_contable_egreso1() {
		return this.id_cuenta_contable_egreso1;
	}
    
	
	public Long getid_cuenta_contable_egreso2() {
		return this.id_cuenta_contable_egreso2;
	}
    
	
	public Long getid_cuenta_contable_egreso3() {
		return this.id_cuenta_contable_egreso3;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda_extranjera(Long newid_moneda_extranjera)throws Exception
	{
		try {
			if(this.id_moneda_extranjera!=newid_moneda_extranjera) {
				if(newid_moneda_extranjera==null) {
					//newid_moneda_extranjera=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_moneda_extranjera");
					}
				}

				this.id_moneda_extranjera=newid_moneda_extranjera;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mascara(Boolean newcon_mascara)throws Exception
	{
		try {
			if(this.con_mascara!=newcon_mascara) {
				if(newcon_mascara==null) {
					//newcon_mascara=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna con_mascara");
					}
				}

				this.con_mascara=newcon_mascara;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_nivel(Integer newnumero_nivel)throws Exception
	{
		try {
			if(this.numero_nivel!=newnumero_nivel) {
				if(newnumero_nivel==null) {
					//newnumero_nivel=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna numero_nivel");
					}
				}

				this.numero_nivel=newnumero_nivel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_presupuesto(Boolean newes_presupuesto)throws Exception
	{
		try {
			if(this.es_presupuesto!=newes_presupuesto) {
				if(newes_presupuesto==null) {
					//newes_presupuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna es_presupuesto");
					}
				}

				this.es_presupuesto=newes_presupuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_lote(Boolean newes_lote)throws Exception
	{
		try {
			if(this.es_lote!=newes_lote) {
				if(newes_lote==null) {
					//newes_lote=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna es_lote");
					}
				}

				this.es_lote=newes_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_secuencial_automatico(Boolean newcon_secuencial_automatico)throws Exception
	{
		try {
			if(this.con_secuencial_automatico!=newcon_secuencial_automatico) {
				if(newcon_secuencial_automatico==null) {
					//newcon_secuencial_automatico=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna con_secuencial_automatico");
					}
				}

				this.con_secuencial_automatico=newcon_secuencial_automatico;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cuentas_niff(Boolean newcon_cuentas_niff)throws Exception
	{
		try {
			if(this.con_cuentas_niff!=newcon_cuentas_niff) {
				if(newcon_cuentas_niff==null) {
					//newcon_cuentas_niff=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna con_cuentas_niff");
					}
				}

				this.con_cuentas_niff=newcon_cuentas_niff;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_centro_costo_mascara(Boolean newcon_centro_costo_mascara)throws Exception
	{
		try {
			if(this.con_centro_costo_mascara!=newcon_centro_costo_mascara) {
				if(newcon_centro_costo_mascara==null) {
					//newcon_centro_costo_mascara=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna con_centro_costo_mascara");
					}
				}

				this.con_centro_costo_mascara=newcon_centro_costo_mascara;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_centro_costo_nueva_estructura(Boolean newcon_centro_costo_nueva_estructura)throws Exception
	{
		try {
			if(this.con_centro_costo_nueva_estructura!=newcon_centro_costo_nueva_estructura) {
				if(newcon_centro_costo_nueva_estructura==null) {
					//newcon_centro_costo_nueva_estructura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna con_centro_costo_nueva_estructura");
					}
				}

				this.con_centro_costo_nueva_estructura=newcon_centro_costo_nueva_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcentro_costo_numero_nivel(Integer newcentro_costo_numero_nivel)throws Exception
	{
		try {
			if(this.centro_costo_numero_nivel!=newcentro_costo_numero_nivel) {
				if(newcentro_costo_numero_nivel==null) {
					//newcentro_costo_numero_nivel=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna centro_costo_numero_nivel");
					}
				}

				this.centro_costo_numero_nivel=newcentro_costo_numero_nivel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_activo(Long newid_cuenta_contable_activo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_activo!=newid_cuenta_contable_activo) {
				if(newid_cuenta_contable_activo==null) {
					//newid_cuenta_contable_activo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_activo");
					}
				}

				this.id_cuenta_contable_activo=newid_cuenta_contable_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_pasivo(Long newid_cuenta_contable_pasivo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_pasivo!=newid_cuenta_contable_pasivo) {
				if(newid_cuenta_contable_pasivo==null) {
					//newid_cuenta_contable_pasivo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_pasivo");
					}
				}

				this.id_cuenta_contable_pasivo=newid_cuenta_contable_pasivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_patrimonio(Long newid_cuenta_contable_patrimonio)throws Exception
	{
		try {
			if(this.id_cuenta_contable_patrimonio!=newid_cuenta_contable_patrimonio) {
				if(newid_cuenta_contable_patrimonio==null) {
					//newid_cuenta_contable_patrimonio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_patrimonio");
					}
				}

				this.id_cuenta_contable_patrimonio=newid_cuenta_contable_patrimonio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_ingreso(Long newid_cuenta_contable_ingreso)throws Exception
	{
		try {
			if(this.id_cuenta_contable_ingreso!=newid_cuenta_contable_ingreso) {
				if(newid_cuenta_contable_ingreso==null) {
					//newid_cuenta_contable_ingreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_ingreso");
					}
				}

				this.id_cuenta_contable_ingreso=newid_cuenta_contable_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_egreso(Long newid_cuenta_contable_egreso)throws Exception
	{
		try {
			if(this.id_cuenta_contable_egreso!=newid_cuenta_contable_egreso) {
				if(newid_cuenta_contable_egreso==null) {
					//newid_cuenta_contable_egreso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_egreso");
					}
				}

				this.id_cuenta_contable_egreso=newid_cuenta_contable_egreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_resumen(Long newid_cuenta_contable_resumen)throws Exception
	{
		try {
			if(this.id_cuenta_contable_resumen!=newid_cuenta_contable_resumen) {
				if(newid_cuenta_contable_resumen==null) {
					//newid_cuenta_contable_resumen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_resumen");
					}
				}

				this.id_cuenta_contable_resumen=newid_cuenta_contable_resumen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_deudor(Long newid_cuenta_contable_deudor)throws Exception
	{
		try {
			if(this.id_cuenta_contable_deudor!=newid_cuenta_contable_deudor) {
				if(newid_cuenta_contable_deudor==null) {
					//newid_cuenta_contable_deudor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_deudor");
					}
				}

				this.id_cuenta_contable_deudor=newid_cuenta_contable_deudor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_acreedor(Long newid_cuenta_contable_acreedor)throws Exception
	{
		try {
			if(this.id_cuenta_contable_acreedor!=newid_cuenta_contable_acreedor) {
				if(newid_cuenta_contable_acreedor==null) {
					//newid_cuenta_contable_acreedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroConta:Valor nulo no permitido en columna id_cuenta_contable_acreedor");
					}
				}

				this.id_cuenta_contable_acreedor=newid_cuenta_contable_acreedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_ingreso1(Long newid_cuenta_contable_ingreso1) {
		if(this.id_cuenta_contable_ingreso1==null&&newid_cuenta_contable_ingreso1!=null) {
			this.id_cuenta_contable_ingreso1=newid_cuenta_contable_ingreso1;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_ingreso1!=null&&!this.id_cuenta_contable_ingreso1.equals(newid_cuenta_contable_ingreso1)) {

			this.id_cuenta_contable_ingreso1=newid_cuenta_contable_ingreso1;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_ingreso2(Long newid_cuenta_contable_ingreso2) {
		if(this.id_cuenta_contable_ingreso2==null&&newid_cuenta_contable_ingreso2!=null) {
			this.id_cuenta_contable_ingreso2=newid_cuenta_contable_ingreso2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_ingreso2!=null&&!this.id_cuenta_contable_ingreso2.equals(newid_cuenta_contable_ingreso2)) {

			this.id_cuenta_contable_ingreso2=newid_cuenta_contable_ingreso2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_ingreso3(Long newid_cuenta_contable_ingreso3) {
		if(this.id_cuenta_contable_ingreso3==null&&newid_cuenta_contable_ingreso3!=null) {
			this.id_cuenta_contable_ingreso3=newid_cuenta_contable_ingreso3;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_ingreso3!=null&&!this.id_cuenta_contable_ingreso3.equals(newid_cuenta_contable_ingreso3)) {

			this.id_cuenta_contable_ingreso3=newid_cuenta_contable_ingreso3;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_egreso1(Long newid_cuenta_contable_egreso1) {
		if(this.id_cuenta_contable_egreso1==null&&newid_cuenta_contable_egreso1!=null) {
			this.id_cuenta_contable_egreso1=newid_cuenta_contable_egreso1;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_egreso1!=null&&!this.id_cuenta_contable_egreso1.equals(newid_cuenta_contable_egreso1)) {

			this.id_cuenta_contable_egreso1=newid_cuenta_contable_egreso1;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_egreso2(Long newid_cuenta_contable_egreso2) {
		if(this.id_cuenta_contable_egreso2==null&&newid_cuenta_contable_egreso2!=null) {
			this.id_cuenta_contable_egreso2=newid_cuenta_contable_egreso2;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_egreso2!=null&&!this.id_cuenta_contable_egreso2.equals(newid_cuenta_contable_egreso2)) {

			this.id_cuenta_contable_egreso2=newid_cuenta_contable_egreso2;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_egreso3(Long newid_cuenta_contable_egreso3) {
		if(this.id_cuenta_contable_egreso3==null&&newid_cuenta_contable_egreso3!=null) {
			this.id_cuenta_contable_egreso3=newid_cuenta_contable_egreso3;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_egreso3!=null&&!this.id_cuenta_contable_egreso3.equals(newid_cuenta_contable_egreso3)) {

			this.id_cuenta_contable_egreso3=newid_cuenta_contable_egreso3;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Moneda getMonedaExtranjera() {
		return this.monedaextranjera;
	}

	public CuentaContable getCuentaContableActivo() {
		return this.cuentacontableactivo;
	}

	public CuentaContable getCuentaContablePasivo() {
		return this.cuentacontablepasivo;
	}

	public CuentaContable getCuentaContablePatrimonio() {
		return this.cuentacontablepatrimonio;
	}

	public CuentaContable getCuentaContableIngreso() {
		return this.cuentacontableingreso;
	}

	public CuentaContable getCuentaContableEgreso() {
		return this.cuentacontableegreso;
	}

	public CuentaContable getCuentaContableResumen() {
		return this.cuentacontableresumen;
	}

	public CuentaContable getCuentaContableDeudor() {
		return this.cuentacontabledeudor;
	}

	public CuentaContable getCuentaContableAcreedor() {
		return this.cuentacontableacreedor;
	}

	public CuentaContable getCuentaContableIngreso1() {
		return this.cuentacontableingreso1;
	}

	public CuentaContable getCuentaContableIngreso2() {
		return this.cuentacontableingreso2;
	}

	public CuentaContable getCuentaContableIngreso3() {
		return this.cuentacontableingreso3;
	}

	public CuentaContable getCuentaContableEgreso1() {
		return this.cuentacontableegreso1;
	}

	public CuentaContable getCuentaContableEgreso2() {
		return this.cuentacontableegreso2;
	}

	public CuentaContable getCuentaContableEgreso3() {
		return this.cuentacontableegreso3;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getmonedaextranjera_descripcion() {
		return this.monedaextranjera_descripcion;
	}

	public String getcuentacontableactivo_descripcion() {
		return this.cuentacontableactivo_descripcion;
	}

	public String getcuentacontablepasivo_descripcion() {
		return this.cuentacontablepasivo_descripcion;
	}

	public String getcuentacontablepatrimonio_descripcion() {
		return this.cuentacontablepatrimonio_descripcion;
	}

	public String getcuentacontableingreso_descripcion() {
		return this.cuentacontableingreso_descripcion;
	}

	public String getcuentacontableegreso_descripcion() {
		return this.cuentacontableegreso_descripcion;
	}

	public String getcuentacontableresumen_descripcion() {
		return this.cuentacontableresumen_descripcion;
	}

	public String getcuentacontabledeudor_descripcion() {
		return this.cuentacontabledeudor_descripcion;
	}

	public String getcuentacontableacreedor_descripcion() {
		return this.cuentacontableacreedor_descripcion;
	}

	public String getcuentacontableingreso1_descripcion() {
		return this.cuentacontableingreso1_descripcion;
	}

	public String getcuentacontableingreso2_descripcion() {
		return this.cuentacontableingreso2_descripcion;
	}

	public String getcuentacontableingreso3_descripcion() {
		return this.cuentacontableingreso3_descripcion;
	}

	public String getcuentacontableegreso1_descripcion() {
		return this.cuentacontableegreso1_descripcion;
	}

	public String getcuentacontableegreso2_descripcion() {
		return this.cuentacontableegreso2_descripcion;
	}

	public String getcuentacontableegreso3_descripcion() {
		return this.cuentacontableegreso3_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setMonedaExtranjera(Moneda monedaextranjera) {
		try {
			this.monedaextranjera=monedaextranjera;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableActivo(CuentaContable cuentacontableactivo) {
		try {
			this.cuentacontableactivo=cuentacontableactivo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePasivo(CuentaContable cuentacontablepasivo) {
		try {
			this.cuentacontablepasivo=cuentacontablepasivo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContablePatrimonio(CuentaContable cuentacontablepatrimonio) {
		try {
			this.cuentacontablepatrimonio=cuentacontablepatrimonio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngreso(CuentaContable cuentacontableingreso) {
		try {
			this.cuentacontableingreso=cuentacontableingreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableEgreso(CuentaContable cuentacontableegreso) {
		try {
			this.cuentacontableegreso=cuentacontableegreso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableResumen(CuentaContable cuentacontableresumen) {
		try {
			this.cuentacontableresumen=cuentacontableresumen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDeudor(CuentaContable cuentacontabledeudor) {
		try {
			this.cuentacontabledeudor=cuentacontabledeudor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableAcreedor(CuentaContable cuentacontableacreedor) {
		try {
			this.cuentacontableacreedor=cuentacontableacreedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngreso1(CuentaContable cuentacontableingreso1) {
		try {
			this.cuentacontableingreso1=cuentacontableingreso1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngreso2(CuentaContable cuentacontableingreso2) {
		try {
			this.cuentacontableingreso2=cuentacontableingreso2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIngreso3(CuentaContable cuentacontableingreso3) {
		try {
			this.cuentacontableingreso3=cuentacontableingreso3;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableEgreso1(CuentaContable cuentacontableegreso1) {
		try {
			this.cuentacontableegreso1=cuentacontableegreso1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableEgreso2(CuentaContable cuentacontableegreso2) {
		try {
			this.cuentacontableegreso2=cuentacontableegreso2;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableEgreso3(CuentaContable cuentacontableegreso3) {
		try {
			this.cuentacontableegreso3=cuentacontableegreso3;
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


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmonedaextranjera_descripcion(String monedaextranjera_descripcion) {
		try {
			this.monedaextranjera_descripcion=monedaextranjera_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableactivo_descripcion(String cuentacontableactivo_descripcion) {
		try {
			this.cuentacontableactivo_descripcion=cuentacontableactivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepasivo_descripcion(String cuentacontablepasivo_descripcion) {
		try {
			this.cuentacontablepasivo_descripcion=cuentacontablepasivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablepatrimonio_descripcion(String cuentacontablepatrimonio_descripcion) {
		try {
			this.cuentacontablepatrimonio_descripcion=cuentacontablepatrimonio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingreso_descripcion(String cuentacontableingreso_descripcion) {
		try {
			this.cuentacontableingreso_descripcion=cuentacontableingreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableegreso_descripcion(String cuentacontableegreso_descripcion) {
		try {
			this.cuentacontableegreso_descripcion=cuentacontableegreso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableresumen_descripcion(String cuentacontableresumen_descripcion) {
		try {
			this.cuentacontableresumen_descripcion=cuentacontableresumen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledeudor_descripcion(String cuentacontabledeudor_descripcion) {
		try {
			this.cuentacontabledeudor_descripcion=cuentacontabledeudor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableacreedor_descripcion(String cuentacontableacreedor_descripcion) {
		try {
			this.cuentacontableacreedor_descripcion=cuentacontableacreedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingreso1_descripcion(String cuentacontableingreso1_descripcion) {
		try {
			this.cuentacontableingreso1_descripcion=cuentacontableingreso1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingreso2_descripcion(String cuentacontableingreso2_descripcion) {
		try {
			this.cuentacontableingreso2_descripcion=cuentacontableingreso2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableingreso3_descripcion(String cuentacontableingreso3_descripcion) {
		try {
			this.cuentacontableingreso3_descripcion=cuentacontableingreso3_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableegreso1_descripcion(String cuentacontableegreso1_descripcion) {
		try {
			this.cuentacontableegreso1_descripcion=cuentacontableegreso1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableegreso2_descripcion(String cuentacontableegreso2_descripcion) {
		try {
			this.cuentacontableegreso2_descripcion=cuentacontableegreso2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableegreso3_descripcion(String cuentacontableegreso3_descripcion) {
		try {
			this.cuentacontableegreso3_descripcion=cuentacontableegreso3_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ParametroContaDetalle> getParametroContaDetalles() {
		return this.parametrocontadetalles;
	}

	
	
	public  void  setParametroContaDetalles(List<ParametroContaDetalle> parametrocontadetalles) {
		try {
			this.parametrocontadetalles=parametrocontadetalles;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_moneda_descripcion="";String id_moneda_extranjera_descripcion="";String con_mascara_descripcion="";String es_presupuesto_descripcion="";String es_lote_descripcion="";String con_secuencial_automatico_descripcion="";String con_cuentas_niff_descripcion="";String con_centro_costo_mascara_descripcion="";String con_centro_costo_nueva_estructura_descripcion="";String id_cuenta_contable_activo_descripcion="";String id_cuenta_contable_pasivo_descripcion="";String id_cuenta_contable_patrimonio_descripcion="";String id_cuenta_contable_ingreso_descripcion="";String id_cuenta_contable_egreso_descripcion="";String id_cuenta_contable_resumen_descripcion="";String id_cuenta_contable_deudor_descripcion="";String id_cuenta_contable_acreedor_descripcion="";String id_cuenta_contable_ingreso1_descripcion="";String id_cuenta_contable_ingreso2_descripcion="";String id_cuenta_contable_ingreso3_descripcion="";String id_cuenta_contable_egreso1_descripcion="";String id_cuenta_contable_egreso2_descripcion="";String id_cuenta_contable_egreso3_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_moneda_extranjera_descripcion() {
		return id_moneda_extranjera_descripcion;
	}
	public String getcon_mascara_descripcion() {
		return con_mascara_descripcion;
	}
	public String getes_presupuesto_descripcion() {
		return es_presupuesto_descripcion;
	}
	public String getes_lote_descripcion() {
		return es_lote_descripcion;
	}
	public String getcon_secuencial_automatico_descripcion() {
		return con_secuencial_automatico_descripcion;
	}
	public String getcon_cuentas_niff_descripcion() {
		return con_cuentas_niff_descripcion;
	}
	public String getcon_centro_costo_mascara_descripcion() {
		return con_centro_costo_mascara_descripcion;
	}
	public String getcon_centro_costo_nueva_estructura_descripcion() {
		return con_centro_costo_nueva_estructura_descripcion;
	}
	public String getid_cuenta_contable_activo_descripcion() {
		return id_cuenta_contable_activo_descripcion;
	}
	public String getid_cuenta_contable_pasivo_descripcion() {
		return id_cuenta_contable_pasivo_descripcion;
	}
	public String getid_cuenta_contable_patrimonio_descripcion() {
		return id_cuenta_contable_patrimonio_descripcion;
	}
	public String getid_cuenta_contable_ingreso_descripcion() {
		return id_cuenta_contable_ingreso_descripcion;
	}
	public String getid_cuenta_contable_egreso_descripcion() {
		return id_cuenta_contable_egreso_descripcion;
	}
	public String getid_cuenta_contable_resumen_descripcion() {
		return id_cuenta_contable_resumen_descripcion;
	}
	public String getid_cuenta_contable_deudor_descripcion() {
		return id_cuenta_contable_deudor_descripcion;
	}
	public String getid_cuenta_contable_acreedor_descripcion() {
		return id_cuenta_contable_acreedor_descripcion;
	}
	public String getid_cuenta_contable_ingreso1_descripcion() {
		return id_cuenta_contable_ingreso1_descripcion;
	}
	public String getid_cuenta_contable_ingreso2_descripcion() {
		return id_cuenta_contable_ingreso2_descripcion;
	}
	public String getid_cuenta_contable_ingreso3_descripcion() {
		return id_cuenta_contable_ingreso3_descripcion;
	}
	public String getid_cuenta_contable_egreso1_descripcion() {
		return id_cuenta_contable_egreso1_descripcion;
	}
	public String getid_cuenta_contable_egreso2_descripcion() {
		return id_cuenta_contable_egreso2_descripcion;
	}
	public String getid_cuenta_contable_egreso3_descripcion() {
		return id_cuenta_contable_egreso3_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_moneda_extranjera_descripcion(String newid_moneda_extranjera_descripcion)throws Exception {
		try {
			this.id_moneda_extranjera_descripcion=newid_moneda_extranjera_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mascara_descripcion(String newcon_mascara_descripcion)throws Exception {
		try {
			this.con_mascara_descripcion=newcon_mascara_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_presupuesto_descripcion(String newes_presupuesto_descripcion)throws Exception {
		try {
			this.es_presupuesto_descripcion=newes_presupuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_lote_descripcion(String newes_lote_descripcion)throws Exception {
		try {
			this.es_lote_descripcion=newes_lote_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_secuencial_automatico_descripcion(String newcon_secuencial_automatico_descripcion)throws Exception {
		try {
			this.con_secuencial_automatico_descripcion=newcon_secuencial_automatico_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cuentas_niff_descripcion(String newcon_cuentas_niff_descripcion)throws Exception {
		try {
			this.con_cuentas_niff_descripcion=newcon_cuentas_niff_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_centro_costo_mascara_descripcion(String newcon_centro_costo_mascara_descripcion)throws Exception {
		try {
			this.con_centro_costo_mascara_descripcion=newcon_centro_costo_mascara_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_centro_costo_nueva_estructura_descripcion(String newcon_centro_costo_nueva_estructura_descripcion)throws Exception {
		try {
			this.con_centro_costo_nueva_estructura_descripcion=newcon_centro_costo_nueva_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_activo_descripcion(String newid_cuenta_contable_activo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_activo_descripcion=newid_cuenta_contable_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_pasivo_descripcion(String newid_cuenta_contable_pasivo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_pasivo_descripcion=newid_cuenta_contable_pasivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_patrimonio_descripcion(String newid_cuenta_contable_patrimonio_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_patrimonio_descripcion=newid_cuenta_contable_patrimonio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_ingreso_descripcion(String newid_cuenta_contable_ingreso_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_ingreso_descripcion=newid_cuenta_contable_ingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_egreso_descripcion(String newid_cuenta_contable_egreso_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_egreso_descripcion=newid_cuenta_contable_egreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_resumen_descripcion(String newid_cuenta_contable_resumen_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_resumen_descripcion=newid_cuenta_contable_resumen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_deudor_descripcion(String newid_cuenta_contable_deudor_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_deudor_descripcion=newid_cuenta_contable_deudor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_acreedor_descripcion(String newid_cuenta_contable_acreedor_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_acreedor_descripcion=newid_cuenta_contable_acreedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_ingreso1_descripcion(String newid_cuenta_contable_ingreso1_descripcion) {
		this.id_cuenta_contable_ingreso1_descripcion=newid_cuenta_contable_ingreso1_descripcion;
	}
	public void setid_cuenta_contable_ingreso2_descripcion(String newid_cuenta_contable_ingreso2_descripcion) {
		this.id_cuenta_contable_ingreso2_descripcion=newid_cuenta_contable_ingreso2_descripcion;
	}
	public void setid_cuenta_contable_ingreso3_descripcion(String newid_cuenta_contable_ingreso3_descripcion) {
		this.id_cuenta_contable_ingreso3_descripcion=newid_cuenta_contable_ingreso3_descripcion;
	}
	public void setid_cuenta_contable_egreso1_descripcion(String newid_cuenta_contable_egreso1_descripcion) {
		this.id_cuenta_contable_egreso1_descripcion=newid_cuenta_contable_egreso1_descripcion;
	}
	public void setid_cuenta_contable_egreso2_descripcion(String newid_cuenta_contable_egreso2_descripcion) {
		this.id_cuenta_contable_egreso2_descripcion=newid_cuenta_contable_egreso2_descripcion;
	}
	public void setid_cuenta_contable_egreso3_descripcion(String newid_cuenta_contable_egreso3_descripcion) {
		this.id_cuenta_contable_egreso3_descripcion=newid_cuenta_contable_egreso3_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_moneda_descripcion="";this.id_moneda_extranjera_descripcion="";this.con_mascara_descripcion="";this.es_presupuesto_descripcion="";this.es_lote_descripcion="";this.con_secuencial_automatico_descripcion="";this.con_cuentas_niff_descripcion="";this.con_centro_costo_mascara_descripcion="";this.con_centro_costo_nueva_estructura_descripcion="";this.id_cuenta_contable_activo_descripcion="";this.id_cuenta_contable_pasivo_descripcion="";this.id_cuenta_contable_patrimonio_descripcion="";this.id_cuenta_contable_ingreso_descripcion="";this.id_cuenta_contable_egreso_descripcion="";this.id_cuenta_contable_resumen_descripcion="";this.id_cuenta_contable_deudor_descripcion="";this.id_cuenta_contable_acreedor_descripcion="";this.id_cuenta_contable_ingreso1_descripcion="";this.id_cuenta_contable_ingreso2_descripcion="";this.id_cuenta_contable_ingreso3_descripcion="";this.id_cuenta_contable_egreso1_descripcion="";this.id_cuenta_contable_egreso2_descripcion="";this.id_cuenta_contable_egreso3_descripcion="";
	}
	
	
	Object parametrocontadetallesDescripcionReporte;
	
	
	public Object getparametrocontadetallesDescripcionReporte() {
		return parametrocontadetallesDescripcionReporte;
	}

	
	
	public  void  setparametrocontadetallesDescripcionReporte(Object parametrocontadetalles) {
		try {
			this.parametrocontadetallesDescripcionReporte=parametrocontadetalles;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

