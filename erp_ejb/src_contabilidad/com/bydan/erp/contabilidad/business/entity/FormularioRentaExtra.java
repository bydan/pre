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
//import com.bydan.erp.contabilidad.util.FormularioRentaExtraConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class FormularioRentaExtra extends FormularioRentaExtraAdditional implements Serializable ,Cloneable {//FormularioRentaExtraAdditional,GeneralEntity
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
	
	private FormularioRentaExtra formulariorentaextraOriginal;
	
	private Map<String, Object> mapFormularioRentaExtra;
			
	public Map<String, Object> getMapFormularioRentaExtra() {
		return mapFormularioRentaExtra;
	}

	public void setMapFormularioRentaExtra(Map<String, Object> mapFormularioRentaExtra) {
		this.mapFormularioRentaExtra = mapFormularioRentaExtra;
	}
	
	public void inicializarMapFormularioRentaExtra() {
		this.mapFormularioRentaExtra = new HashMap<String,Object>();
	}
	
	public void setMapFormularioRentaExtraValue(String sKey,Object oValue) {
		this.mapFormularioRentaExtra.put(sKey, oValue);
	}
	
	public Object getMapFormularioRentaExtraValue(String sKey) {
		return this.mapFormularioRentaExtra.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dato_formulario_renta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double pago_previo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double interes_mora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_multa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double forma_pago1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double forma_pago2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_NOTA_CREDITO1,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_NOTA_CREDITO1)
	private String numero_nota_credito1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_NOTA_CREDITO2,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_NOTA_CREDITO2)
	private String numero_nota_credito2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_NOTA_CREDITO3,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_NOTA_CREDITO3)
	private String numero_nota_credito3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_NOTA_CREDITO4,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_NOTA_CREDITO4)
	private String numero_nota_credito4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_nota_credito1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_nota_credito2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_nota_credito3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_nota_credito4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_COMPROBANTE1,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE1)
	private String numero_comprobante1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormularioRentaExtraConstantesFunciones.SREGEXNUMERO_COMPROBANTE2,message=FormularioRentaExtraConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE2)
	private String numero_comprobante2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comprobante1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_comprobante2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor301;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor303;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor305;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor307;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor351;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor355;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor357;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor359;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor361;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public DatoFormularioRenta datoformulariorenta;
	public FormaPago formapago;
	public Banco banco;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String datoformulariorenta_descripcion;
	private String formapago_descripcion;
	private String banco_descripcion;
	
	
		
	public FormularioRentaExtra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formulariorentaextraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_dato_formulario_renta=-1L;
 		this.id_forma_pago=-1L;
 		this.id_banco=-1L;
 		this.pago_previo=0.0;
 		this.interes_mora=0.0;
 		this.valor_multa=0.0;
 		this.forma_pago1=0.0;
 		this.forma_pago2=0.0;
 		this.numero_nota_credito1="";
 		this.numero_nota_credito2="";
 		this.numero_nota_credito3="";
 		this.numero_nota_credito4="";
 		this.valor_nota_credito1=0.0;
 		this.valor_nota_credito2=0.0;
 		this.valor_nota_credito3=0.0;
 		this.valor_nota_credito4=0.0;
 		this.numero_comprobante1="";
 		this.numero_comprobante2="";
 		this.valor_comprobante1=0.0;
 		this.valor_comprobante2=0.0;
 		this.valor301=0.0;
 		this.valor303=0.0;
 		this.valor305=0.0;
 		this.valor307=0.0;
 		this.valor351=0.0;
 		this.valor355=0.0;
 		this.valor357=0.0;
 		this.valor359=0.0;
 		this.valor361=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.datoformulariorenta=null;
		this.formapago=null;
		this.banco=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.datoformulariorenta_descripcion="";
		this.formapago_descripcion="";
		this.banco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormularioRentaExtra (Long id,Date versionRow,Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_renta,Long id_forma_pago,Long id_banco,Double pago_previo,Double interes_mora,Double valor_multa,Double forma_pago1,Double forma_pago2,String numero_nota_credito1,String numero_nota_credito2,String numero_nota_credito3,String numero_nota_credito4,Double valor_nota_credito1,Double valor_nota_credito2,Double valor_nota_credito3,Double valor_nota_credito4,String numero_comprobante1,String numero_comprobante2,Double valor_comprobante1,Double valor_comprobante2,Double valor301,Double valor303,Double valor305,Double valor307,Double valor351,Double valor355,Double valor357,Double valor359,Double valor361) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorentaextraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_renta=id_dato_formulario_renta;
 		this.id_forma_pago=id_forma_pago;
 		this.id_banco=id_banco;
 		this.pago_previo=pago_previo;
 		this.interes_mora=interes_mora;
 		this.valor_multa=valor_multa;
 		this.forma_pago1=forma_pago1;
 		this.forma_pago2=forma_pago2;
 		this.numero_nota_credito1=numero_nota_credito1;
 		this.numero_nota_credito2=numero_nota_credito2;
 		this.numero_nota_credito3=numero_nota_credito3;
 		this.numero_nota_credito4=numero_nota_credito4;
 		this.valor_nota_credito1=valor_nota_credito1;
 		this.valor_nota_credito2=valor_nota_credito2;
 		this.valor_nota_credito3=valor_nota_credito3;
 		this.valor_nota_credito4=valor_nota_credito4;
 		this.numero_comprobante1=numero_comprobante1;
 		this.numero_comprobante2=numero_comprobante2;
 		this.valor_comprobante1=valor_comprobante1;
 		this.valor_comprobante2=valor_comprobante2;
 		this.valor301=valor301;
 		this.valor303=valor303;
 		this.valor305=valor305;
 		this.valor307=valor307;
 		this.valor351=valor351;
 		this.valor355=valor355;
 		this.valor357=valor357;
 		this.valor359=valor359;
 		this.valor361=valor361;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormularioRentaExtra (Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_renta,Long id_forma_pago,Long id_banco,Double pago_previo,Double interes_mora,Double valor_multa,Double forma_pago1,Double forma_pago2,String numero_nota_credito1,String numero_nota_credito2,String numero_nota_credito3,String numero_nota_credito4,Double valor_nota_credito1,Double valor_nota_credito2,Double valor_nota_credito3,Double valor_nota_credito4,String numero_comprobante1,String numero_comprobante2,Double valor_comprobante1,Double valor_comprobante2,Double valor301,Double valor303,Double valor305,Double valor307,Double valor351,Double valor355,Double valor357,Double valor359,Double valor361) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulariorentaextraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_renta=id_dato_formulario_renta;
 		this.id_forma_pago=id_forma_pago;
 		this.id_banco=id_banco;
 		this.pago_previo=pago_previo;
 		this.interes_mora=interes_mora;
 		this.valor_multa=valor_multa;
 		this.forma_pago1=forma_pago1;
 		this.forma_pago2=forma_pago2;
 		this.numero_nota_credito1=numero_nota_credito1;
 		this.numero_nota_credito2=numero_nota_credito2;
 		this.numero_nota_credito3=numero_nota_credito3;
 		this.numero_nota_credito4=numero_nota_credito4;
 		this.valor_nota_credito1=valor_nota_credito1;
 		this.valor_nota_credito2=valor_nota_credito2;
 		this.valor_nota_credito3=valor_nota_credito3;
 		this.valor_nota_credito4=valor_nota_credito4;
 		this.numero_comprobante1=numero_comprobante1;
 		this.numero_comprobante2=numero_comprobante2;
 		this.valor_comprobante1=valor_comprobante1;
 		this.valor_comprobante2=valor_comprobante2;
 		this.valor301=valor301;
 		this.valor303=valor303;
 		this.valor305=valor305;
 		this.valor307=valor307;
 		this.valor351=valor351;
 		this.valor355=valor355;
 		this.valor357=valor357;
 		this.valor359=valor359;
 		this.valor361=valor361;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormularioRentaExtra formulariorentaextraLocal=null;
		
		if(object!=null) {
			formulariorentaextraLocal=(FormularioRentaExtra)object;
			
			if(formulariorentaextraLocal!=null) {
				if(this.getId()!=null && formulariorentaextraLocal.getId()!=null) {
					if(this.getId().equals(formulariorentaextraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormularioRentaExtraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormularioRentaExtraConstantesFunciones.getFormularioRentaExtraDescripcion(this);
		} else {
			sDetalle=FormularioRentaExtraConstantesFunciones.getFormularioRentaExtraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormularioRentaExtra getFormularioRentaExtraOriginal() {
		return this.formulariorentaextraOriginal;
	}
	
	public void setFormularioRentaExtraOriginal(FormularioRentaExtra formulariorentaextra) {
		try {
			this.formulariorentaextraOriginal=formulariorentaextra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormularioRentaExtraAdditional formulariorentaextraAdditional=null;
	
	public FormularioRentaExtraAdditional getFormularioRentaExtraAdditional() {
		return this.formulariorentaextraAdditional;
	}
	
	public void setFormularioRentaExtraAdditional(FormularioRentaExtraAdditional formulariorentaextraAdditional) {
		try {
			this.formulariorentaextraAdditional=formulariorentaextraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_dato_formulario_renta() {
		return this.id_dato_formulario_renta;
	}
    
	
	public Long getid_forma_pago() {
		return this.id_forma_pago;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Double getpago_previo() {
		return this.pago_previo;
	}
    
	
	public Double getinteres_mora() {
		return this.interes_mora;
	}
    
	
	public Double getvalor_multa() {
		return this.valor_multa;
	}
    
	
	public Double getforma_pago1() {
		return this.forma_pago1;
	}
    
	
	public Double getforma_pago2() {
		return this.forma_pago2;
	}
    
	
	public String getnumero_nota_credito1() {
		return this.numero_nota_credito1;
	}
    
	
	public String getnumero_nota_credito2() {
		return this.numero_nota_credito2;
	}
    
	
	public String getnumero_nota_credito3() {
		return this.numero_nota_credito3;
	}
    
	
	public String getnumero_nota_credito4() {
		return this.numero_nota_credito4;
	}
    
	
	public Double getvalor_nota_credito1() {
		return this.valor_nota_credito1;
	}
    
	
	public Double getvalor_nota_credito2() {
		return this.valor_nota_credito2;
	}
    
	
	public Double getvalor_nota_credito3() {
		return this.valor_nota_credito3;
	}
    
	
	public Double getvalor_nota_credito4() {
		return this.valor_nota_credito4;
	}
    
	
	public String getnumero_comprobante1() {
		return this.numero_comprobante1;
	}
    
	
	public String getnumero_comprobante2() {
		return this.numero_comprobante2;
	}
    
	
	public Double getvalor_comprobante1() {
		return this.valor_comprobante1;
	}
    
	
	public Double getvalor_comprobante2() {
		return this.valor_comprobante2;
	}
    
	
	public Double getvalor301() {
		return this.valor301;
	}
    
	
	public Double getvalor303() {
		return this.valor303;
	}
    
	
	public Double getvalor305() {
		return this.valor305;
	}
    
	
	public Double getvalor307() {
		return this.valor307;
	}
    
	
	public Double getvalor351() {
		return this.valor351;
	}
    
	
	public Double getvalor355() {
		return this.valor355;
	}
    
	
	public Double getvalor357() {
		return this.valor357;
	}
    
	
	public Double getvalor359() {
		return this.valor359;
	}
    
	
	public Double getvalor361() {
		return this.valor361;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dato_formulario_renta(Long newid_dato_formulario_renta)throws Exception
	{
		try {
			if(this.id_dato_formulario_renta!=newid_dato_formulario_renta) {
				if(newid_dato_formulario_renta==null) {
					//newid_dato_formulario_renta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_dato_formulario_renta");
					}
				}

				this.id_dato_formulario_renta=newid_dato_formulario_renta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_forma_pago(Long newid_forma_pago)throws Exception
	{
		try {
			if(this.id_forma_pago!=newid_forma_pago) {
				if(newid_forma_pago==null) {
					//newid_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_forma_pago");
					}
				}

				this.id_forma_pago=newid_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpago_previo(Double newpago_previo)throws Exception
	{
		try {
			if(this.pago_previo!=newpago_previo) {
				if(newpago_previo==null) {
					//newpago_previo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna pago_previo");
					}
				}

				this.pago_previo=newpago_previo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinteres_mora(Double newinteres_mora)throws Exception
	{
		try {
			if(this.interes_mora!=newinteres_mora) {
				if(newinteres_mora==null) {
					//newinteres_mora=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna interes_mora");
					}
				}

				this.interes_mora=newinteres_mora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_multa(Double newvalor_multa)throws Exception
	{
		try {
			if(this.valor_multa!=newvalor_multa) {
				if(newvalor_multa==null) {
					//newvalor_multa=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_multa");
					}
				}

				this.valor_multa=newvalor_multa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setforma_pago1(Double newforma_pago1)throws Exception
	{
		try {
			if(this.forma_pago1!=newforma_pago1) {
				if(newforma_pago1==null) {
					//newforma_pago1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna forma_pago1");
					}
				}

				this.forma_pago1=newforma_pago1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setforma_pago2(Double newforma_pago2)throws Exception
	{
		try {
			if(this.forma_pago2!=newforma_pago2) {
				if(newforma_pago2==null) {
					//newforma_pago2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna forma_pago2");
					}
				}

				this.forma_pago2=newforma_pago2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_nota_credito1(String newnumero_nota_credito1)throws Exception
	{
		try {
			if(this.numero_nota_credito1!=newnumero_nota_credito1) {
				if(newnumero_nota_credito1==null) {
					//newnumero_nota_credito1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_nota_credito1");
					}
				}

				if(newnumero_nota_credito1!=null&&newnumero_nota_credito1.length()>50) {
					newnumero_nota_credito1=newnumero_nota_credito1.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_nota_credito1");
				}

				this.numero_nota_credito1=newnumero_nota_credito1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_nota_credito2(String newnumero_nota_credito2)throws Exception
	{
		try {
			if(this.numero_nota_credito2!=newnumero_nota_credito2) {
				if(newnumero_nota_credito2==null) {
					//newnumero_nota_credito2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_nota_credito2");
					}
				}

				if(newnumero_nota_credito2!=null&&newnumero_nota_credito2.length()>50) {
					newnumero_nota_credito2=newnumero_nota_credito2.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_nota_credito2");
				}

				this.numero_nota_credito2=newnumero_nota_credito2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_nota_credito3(String newnumero_nota_credito3)throws Exception
	{
		try {
			if(this.numero_nota_credito3!=newnumero_nota_credito3) {
				if(newnumero_nota_credito3==null) {
					//newnumero_nota_credito3="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_nota_credito3");
					}
				}

				if(newnumero_nota_credito3!=null&&newnumero_nota_credito3.length()>50) {
					newnumero_nota_credito3=newnumero_nota_credito3.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_nota_credito3");
				}

				this.numero_nota_credito3=newnumero_nota_credito3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_nota_credito4(String newnumero_nota_credito4)throws Exception
	{
		try {
			if(this.numero_nota_credito4!=newnumero_nota_credito4) {
				if(newnumero_nota_credito4==null) {
					//newnumero_nota_credito4="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_nota_credito4");
					}
				}

				if(newnumero_nota_credito4!=null&&newnumero_nota_credito4.length()>50) {
					newnumero_nota_credito4=newnumero_nota_credito4.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_nota_credito4");
				}

				this.numero_nota_credito4=newnumero_nota_credito4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_nota_credito1(Double newvalor_nota_credito1)throws Exception
	{
		try {
			if(this.valor_nota_credito1!=newvalor_nota_credito1) {
				if(newvalor_nota_credito1==null) {
					//newvalor_nota_credito1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_nota_credito1");
					}
				}

				this.valor_nota_credito1=newvalor_nota_credito1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_nota_credito2(Double newvalor_nota_credito2)throws Exception
	{
		try {
			if(this.valor_nota_credito2!=newvalor_nota_credito2) {
				if(newvalor_nota_credito2==null) {
					//newvalor_nota_credito2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_nota_credito2");
					}
				}

				this.valor_nota_credito2=newvalor_nota_credito2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_nota_credito3(Double newvalor_nota_credito3)throws Exception
	{
		try {
			if(this.valor_nota_credito3!=newvalor_nota_credito3) {
				if(newvalor_nota_credito3==null) {
					//newvalor_nota_credito3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_nota_credito3");
					}
				}

				this.valor_nota_credito3=newvalor_nota_credito3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_nota_credito4(Double newvalor_nota_credito4)throws Exception
	{
		try {
			if(this.valor_nota_credito4!=newvalor_nota_credito4) {
				if(newvalor_nota_credito4==null) {
					//newvalor_nota_credito4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_nota_credito4");
					}
				}

				this.valor_nota_credito4=newvalor_nota_credito4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante1(String newnumero_comprobante1)throws Exception
	{
		try {
			if(this.numero_comprobante1!=newnumero_comprobante1) {
				if(newnumero_comprobante1==null) {
					//newnumero_comprobante1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_comprobante1");
					}
				}

				if(newnumero_comprobante1!=null&&newnumero_comprobante1.length()>50) {
					newnumero_comprobante1=newnumero_comprobante1.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante1");
				}

				this.numero_comprobante1=newnumero_comprobante1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante2(String newnumero_comprobante2)throws Exception
	{
		try {
			if(this.numero_comprobante2!=newnumero_comprobante2) {
				if(newnumero_comprobante2==null) {
					//newnumero_comprobante2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna numero_comprobante2");
					}
				}

				if(newnumero_comprobante2!=null&&newnumero_comprobante2.length()>50) {
					newnumero_comprobante2=newnumero_comprobante2.substring(0,48);
					System.out.println("FormularioRentaExtra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante2");
				}

				this.numero_comprobante2=newnumero_comprobante2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comprobante1(Double newvalor_comprobante1)throws Exception
	{
		try {
			if(this.valor_comprobante1!=newvalor_comprobante1) {
				if(newvalor_comprobante1==null) {
					//newvalor_comprobante1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_comprobante1");
					}
				}

				this.valor_comprobante1=newvalor_comprobante1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_comprobante2(Double newvalor_comprobante2)throws Exception
	{
		try {
			if(this.valor_comprobante2!=newvalor_comprobante2) {
				if(newvalor_comprobante2==null) {
					//newvalor_comprobante2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor_comprobante2");
					}
				}

				this.valor_comprobante2=newvalor_comprobante2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor301(Double newvalor301)throws Exception
	{
		try {
			if(this.valor301!=newvalor301) {
				if(newvalor301==null) {
					//newvalor301=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor301");
					}
				}

				this.valor301=newvalor301;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor303(Double newvalor303)throws Exception
	{
		try {
			if(this.valor303!=newvalor303) {
				if(newvalor303==null) {
					//newvalor303=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor303");
					}
				}

				this.valor303=newvalor303;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor305(Double newvalor305)throws Exception
	{
		try {
			if(this.valor305!=newvalor305) {
				if(newvalor305==null) {
					//newvalor305=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor305");
					}
				}

				this.valor305=newvalor305;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor307(Double newvalor307)throws Exception
	{
		try {
			if(this.valor307!=newvalor307) {
				if(newvalor307==null) {
					//newvalor307=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor307");
					}
				}

				this.valor307=newvalor307;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor351(Double newvalor351)throws Exception
	{
		try {
			if(this.valor351!=newvalor351) {
				if(newvalor351==null) {
					//newvalor351=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor351");
					}
				}

				this.valor351=newvalor351;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor355(Double newvalor355)throws Exception
	{
		try {
			if(this.valor355!=newvalor355) {
				if(newvalor355==null) {
					//newvalor355=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor355");
					}
				}

				this.valor355=newvalor355;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor357(Double newvalor357)throws Exception
	{
		try {
			if(this.valor357!=newvalor357) {
				if(newvalor357==null) {
					//newvalor357=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor357");
					}
				}

				this.valor357=newvalor357;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor359(Double newvalor359)throws Exception
	{
		try {
			if(this.valor359!=newvalor359) {
				if(newvalor359==null) {
					//newvalor359=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor359");
					}
				}

				this.valor359=newvalor359;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor361(Double newvalor361)throws Exception
	{
		try {
			if(this.valor361!=newvalor361) {
				if(newvalor361==null) {
					//newvalor361=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioRentaExtra:Valor nulo no permitido en columna valor361");
					}
				}

				this.valor361=newvalor361;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public DatoFormularioRenta getDatoFormularioRenta() {
		return this.datoformulariorenta;
	}

	public FormaPago getFormaPago() {
		return this.formapago;
	}

	public Banco getBanco() {
		return this.banco;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getdatoformulariorenta_descripcion() {
		return this.datoformulariorenta_descripcion;
	}

	public String getformapago_descripcion() {
		return this.formapago_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setDatoFormularioRenta(DatoFormularioRenta datoformulariorenta) {
		try {
			this.datoformulariorenta=datoformulariorenta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormaPago(FormaPago formapago) {
		try {
			this.formapago=formapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
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


	public  void  setdatoformulariorenta_descripcion(String datoformulariorenta_descripcion) {
		try {
			this.datoformulariorenta_descripcion=datoformulariorenta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformapago_descripcion(String formapago_descripcion) {
		try {
			this.formapago_descripcion=formapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_dato_formulario_renta_descripcion="";String id_forma_pago_descripcion="";String id_banco_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_dato_formulario_renta_descripcion() {
		return id_dato_formulario_renta_descripcion;
	}
	public String getid_forma_pago_descripcion() {
		return id_forma_pago_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_dato_formulario_renta_descripcion(String newid_dato_formulario_renta_descripcion)throws Exception {
		try {
			this.id_dato_formulario_renta_descripcion=newid_dato_formulario_renta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_forma_pago_descripcion(String newid_forma_pago_descripcion)throws Exception {
		try {
			this.id_forma_pago_descripcion=newid_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_dato_formulario_renta_descripcion="";this.id_forma_pago_descripcion="";this.id_banco_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

