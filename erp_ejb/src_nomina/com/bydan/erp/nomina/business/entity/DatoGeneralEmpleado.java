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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.DatoGeneralEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class DatoGeneralEmpleado extends DatoGeneralEmpleadoAdditional implements Serializable ,Cloneable {//DatoGeneralEmpleadoAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private DatoGeneralEmpleado datogeneralempleadoOriginal;
	
	private Map<String, Object> mapDatoGeneralEmpleado;
			
	public Map<String, Object> getMapDatoGeneralEmpleado() {
		return mapDatoGeneralEmpleado;
	}

	public void setMapDatoGeneralEmpleado(Map<String, Object> mapDatoGeneralEmpleado) {
		this.mapDatoGeneralEmpleado = mapDatoGeneralEmpleado;
	}
	
	public void inicializarMapDatoGeneralEmpleado() {
		this.mapDatoGeneralEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapDatoGeneralEmpleadoValue(String sKey,Object oValue) {
		this.mapDatoGeneralEmpleado.put(sKey, oValue);
	}
	
	public Object getMapDatoGeneralEmpleadoValue(String sKey) {
		return this.mapDatoGeneralEmpleado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_numero_patronal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_afiliacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralEmpleadoConstantesFunciones.SREGEXCARNET_IESS,message=DatoGeneralEmpleadoConstantesFunciones.SMENSAJEREGEXCARNET_IESS)
	private String carnet_iess;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralEmpleadoConstantesFunciones.SREGEXSECTORIAL_IESS,message=DatoGeneralEmpleadoConstantesFunciones.SMENSAJEREGEXSECTORIAL_IESS)
	private String sectorial_iess;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_canton;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parroquia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fallece;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_evaluacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_horas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double salario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralEmpleadoConstantesFunciones.SREGEXNUMERO_CONTRATO,message=DatoGeneralEmpleadoConstantesFunciones.SMENSAJEREGEXNUMERO_CONTRATO)
	private String numero_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor4;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor6;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_aporta_seguro_social;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_recibe_horas_extras;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_descuento_impuestos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double pension_alimenticia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_pago_por_horas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_anticipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_libreta_mili;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralEmpleadoConstantesFunciones.SREGEXLIBRETA_MILITAR,message=DatoGeneralEmpleadoConstantesFunciones.SMENSAJEREGEXLIBRETA_MILITAR)
	private String libreta_militar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco_global;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralEmpleadoConstantesFunciones.SREGEXNUMERO_CUENTA,message=DatoGeneralEmpleadoConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_sangre;
			
	
	public Empleado empleado;
	public NumeroPatronal numeropatronal;
	public TipoAfiliacion tipoafiliacion;
	public Pais pais;
	public Provincia provincia;
	public Canton canton;
	public Parroquia parroquia;
	public Moneda moneda;
	public TipoContrato tipocontrato;
	public TipoLibretaMili tipolibretamili;
	public TipoGrupoFormaPago tipogrupoformapago;
	public Banco banco;
	public TipoCuentaBancoGlobal tipocuentabancoglobal;
	public TipoSangre tiposangre;
	
	
	private String empleado_descripcion;
	private String numeropatronal_descripcion;
	private String tipoafiliacion_descripcion;
	private String pais_descripcion;
	private String provincia_descripcion;
	private String canton_descripcion;
	private String parroquia_descripcion;
	private String moneda_descripcion;
	private String tipocontrato_descripcion;
	private String tipolibretamili_descripcion;
	private String tipogrupoformapago_descripcion;
	private String banco_descripcion;
	private String tipocuentabancoglobal_descripcion;
	private String tiposangre_descripcion;
	
	
		
	public DatoGeneralEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.datogeneralempleadoOriginal=this;
		
 		this.id_numero_patronal=-1L;
 		this.id_tipo_afiliacion=-1L;
 		this.carnet_iess="";
 		this.sectorial_iess="";
 		this.id_pais=-1L;
 		this.id_provincia=-1L;
 		this.id_canton=-1L;
 		this.id_parroquia=-1L;
 		this.fecha_nacimiento=new Date();
 		this.fecha_fallece=new Date();
 		this.valor_evaluacion=0.0;
 		this.numero_horas=0.0;
 		this.valor_hora=0.0;
 		this.salario=0.0;
 		this.id_moneda=-1L;
 		this.numero_contrato="";
 		this.id_tipo_contrato=-1L;
 		this.valor1=0.0;
 		this.valor2=0.0;
 		this.valor3=0.0;
 		this.valor4=0.0;
 		this.valor5=0.0;
 		this.valor6=0.0;
 		this.con_aporta_seguro_social=false;
 		this.con_recibe_horas_extras=false;
 		this.con_descuento_impuestos=false;
 		this.pension_alimenticia=0.0;
 		this.con_pago_por_horas=false;
 		this.con_anticipo=false;
 		this.id_tipo_libreta_mili=-1L;
 		this.libreta_militar="";
 		this.id_tipo_grupo_forma_pago=-1L;
 		this.id_banco=-1L;
 		this.id_tipo_cuenta_banco_global=-1L;
 		this.numero_cuenta="";
 		this.id_tipo_sangre=-1L;
		
		
		this.empleado=null;
		this.numeropatronal=null;
		this.tipoafiliacion=null;
		this.pais=null;
		this.provincia=null;
		this.canton=null;
		this.parroquia=null;
		this.moneda=null;
		this.tipocontrato=null;
		this.tipolibretamili=null;
		this.tipogrupoformapago=null;
		this.banco=null;
		this.tipocuentabancoglobal=null;
		this.tiposangre=null;
		
		
		this.empleado_descripcion="";
		this.numeropatronal_descripcion="";
		this.tipoafiliacion_descripcion="";
		this.pais_descripcion="";
		this.provincia_descripcion="";
		this.canton_descripcion="";
		this.parroquia_descripcion="";
		this.moneda_descripcion="";
		this.tipocontrato_descripcion="";
		this.tipolibretamili_descripcion="";
		this.tipogrupoformapago_descripcion="";
		this.banco_descripcion="";
		this.tipocuentabancoglobal_descripcion="";
		this.tiposangre_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DatoGeneralEmpleado (Long id,Date versionRow,Long id_numero_patronal,Long id_tipo_afiliacion,String carnet_iess,String sectorial_iess,Long id_pais,Long id_provincia,Long id_canton,Long id_parroquia,Date fecha_nacimiento,Date fecha_fallece,Double valor_evaluacion,Double numero_horas,Double valor_hora,Double salario,Long id_moneda,String numero_contrato,Long id_tipo_contrato,Double valor1,Double valor2,Double valor3,Double valor4,Double valor5,Double valor6,Boolean con_aporta_seguro_social,Boolean con_recibe_horas_extras,Boolean con_descuento_impuestos,Double pension_alimenticia,Boolean con_pago_por_horas,Boolean con_anticipo,Long id_tipo_libreta_mili,String libreta_militar,Long id_tipo_grupo_forma_pago,Long id_banco,Long id_tipo_cuenta_banco_global,String numero_cuenta,Long id_tipo_sangre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datogeneralempleadoOriginal=this;
		
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_tipo_afiliacion=id_tipo_afiliacion;
 		this.carnet_iess=carnet_iess;
 		this.sectorial_iess=sectorial_iess;
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.fecha_fallece=fecha_fallece;
 		this.valor_evaluacion=valor_evaluacion;
 		this.numero_horas=numero_horas;
 		this.valor_hora=valor_hora;
 		this.salario=salario;
 		this.id_moneda=id_moneda;
 		this.numero_contrato=numero_contrato;
 		this.id_tipo_contrato=id_tipo_contrato;
 		this.valor1=valor1;
 		this.valor2=valor2;
 		this.valor3=valor3;
 		this.valor4=valor4;
 		this.valor5=valor5;
 		this.valor6=valor6;
 		this.con_aporta_seguro_social=con_aporta_seguro_social;
 		this.con_recibe_horas_extras=con_recibe_horas_extras;
 		this.con_descuento_impuestos=con_descuento_impuestos;
 		this.pension_alimenticia=pension_alimenticia;
 		this.con_pago_por_horas=con_pago_por_horas;
 		this.con_anticipo=con_anticipo;
 		this.id_tipo_libreta_mili=id_tipo_libreta_mili;
 		this.libreta_militar=libreta_militar;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.id_tipo_sangre=id_tipo_sangre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DatoGeneralEmpleado (Long id_numero_patronal,Long id_tipo_afiliacion,String carnet_iess,String sectorial_iess,Long id_pais,Long id_provincia,Long id_canton,Long id_parroquia,Date fecha_nacimiento,Date fecha_fallece,Double valor_evaluacion,Double numero_horas,Double valor_hora,Double salario,Long id_moneda,String numero_contrato,Long id_tipo_contrato,Double valor1,Double valor2,Double valor3,Double valor4,Double valor5,Double valor6,Boolean con_aporta_seguro_social,Boolean con_recibe_horas_extras,Boolean con_descuento_impuestos,Double pension_alimenticia,Boolean con_pago_por_horas,Boolean con_anticipo,Long id_tipo_libreta_mili,String libreta_militar,Long id_tipo_grupo_forma_pago,Long id_banco,Long id_tipo_cuenta_banco_global,String numero_cuenta,Long id_tipo_sangre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datogeneralempleadoOriginal=this;
		
 		
 		this.id_numero_patronal=id_numero_patronal;
 		this.id_tipo_afiliacion=id_tipo_afiliacion;
 		this.carnet_iess=carnet_iess;
 		this.sectorial_iess=sectorial_iess;
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.fecha_fallece=fecha_fallece;
 		this.valor_evaluacion=valor_evaluacion;
 		this.numero_horas=numero_horas;
 		this.valor_hora=valor_hora;
 		this.salario=salario;
 		this.id_moneda=id_moneda;
 		this.numero_contrato=numero_contrato;
 		this.id_tipo_contrato=id_tipo_contrato;
 		this.valor1=valor1;
 		this.valor2=valor2;
 		this.valor3=valor3;
 		this.valor4=valor4;
 		this.valor5=valor5;
 		this.valor6=valor6;
 		this.con_aporta_seguro_social=con_aporta_seguro_social;
 		this.con_recibe_horas_extras=con_recibe_horas_extras;
 		this.con_descuento_impuestos=con_descuento_impuestos;
 		this.pension_alimenticia=pension_alimenticia;
 		this.con_pago_por_horas=con_pago_por_horas;
 		this.con_anticipo=con_anticipo;
 		this.id_tipo_libreta_mili=id_tipo_libreta_mili;
 		this.libreta_militar=libreta_militar;
 		this.id_tipo_grupo_forma_pago=id_tipo_grupo_forma_pago;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.id_tipo_sangre=id_tipo_sangre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DatoGeneralEmpleado datogeneralempleadoLocal=null;
		
		if(object!=null) {
			datogeneralempleadoLocal=(DatoGeneralEmpleado)object;
			
			if(datogeneralempleadoLocal!=null) {
				if(this.getId()!=null && datogeneralempleadoLocal.getId()!=null) {
					if(this.getId().equals(datogeneralempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DatoGeneralEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DatoGeneralEmpleadoConstantesFunciones.getDatoGeneralEmpleadoDescripcion(this);
		} else {
			sDetalle=DatoGeneralEmpleadoConstantesFunciones.getDatoGeneralEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DatoGeneralEmpleado getDatoGeneralEmpleadoOriginal() {
		return this.datogeneralempleadoOriginal;
	}
	
	public void setDatoGeneralEmpleadoOriginal(DatoGeneralEmpleado datogeneralempleado) {
		try {
			this.datogeneralempleadoOriginal=datogeneralempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DatoGeneralEmpleadoAdditional datogeneralempleadoAdditional=null;
	
	public DatoGeneralEmpleadoAdditional getDatoGeneralEmpleadoAdditional() {
		return this.datogeneralempleadoAdditional;
	}
	
	public void setDatoGeneralEmpleadoAdditional(DatoGeneralEmpleadoAdditional datogeneralempleadoAdditional) {
		try {
			this.datogeneralempleadoAdditional=datogeneralempleadoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empleado() {
		this.id_empleado=this.id;

		return this.id_empleado;
	}
    
	
	public Long getid_numero_patronal() {
		return this.id_numero_patronal;
	}
    
	
	public Long getid_tipo_afiliacion() {
		return this.id_tipo_afiliacion;
	}
    
	
	public String getcarnet_iess() {
		return this.carnet_iess;
	}
    
	
	public String getsectorial_iess() {
		return this.sectorial_iess;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_canton() {
		return this.id_canton;
	}
    
	
	public Long getid_parroquia() {
		return this.id_parroquia;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public Date getfecha_fallece() {
		return this.fecha_fallece;
	}
    
	
	public Double getvalor_evaluacion() {
		return this.valor_evaluacion;
	}
    
	
	public Double getnumero_horas() {
		return this.numero_horas;
	}
    
	
	public Double getvalor_hora() {
		return this.valor_hora;
	}
    
	
	public Double getsalario() {
		return this.salario;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public String getnumero_contrato() {
		return this.numero_contrato;
	}
    
	
	public Long getid_tipo_contrato() {
		return this.id_tipo_contrato;
	}
    
	
	public Double getvalor1() {
		return this.valor1;
	}
    
	
	public Double getvalor2() {
		return this.valor2;
	}
    
	
	public Double getvalor3() {
		return this.valor3;
	}
    
	
	public Double getvalor4() {
		return this.valor4;
	}
    
	
	public Double getvalor5() {
		return this.valor5;
	}
    
	
	public Double getvalor6() {
		return this.valor6;
	}
    
	
	public Boolean getcon_aporta_seguro_social() {
		return this.con_aporta_seguro_social;
	}
    
	
	public Boolean getcon_recibe_horas_extras() {
		return this.con_recibe_horas_extras;
	}
    
	
	public Boolean getcon_descuento_impuestos() {
		return this.con_descuento_impuestos;
	}
    
	
	public Double getpension_alimenticia() {
		return this.pension_alimenticia;
	}
    
	
	public Boolean getcon_pago_por_horas() {
		return this.con_pago_por_horas;
	}
    
	
	public Boolean getcon_anticipo() {
		return this.con_anticipo;
	}
    
	
	public Long getid_tipo_libreta_mili() {
		return this.id_tipo_libreta_mili;
	}
    
	
	public String getlibreta_militar() {
		return this.libreta_militar;
	}
    
	
	public Long getid_tipo_grupo_forma_pago() {
		return this.id_tipo_grupo_forma_pago;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_tipo_cuenta_banco_global() {
		return this.id_tipo_cuenta_banco_global;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public Long getid_tipo_sangre() {
		return this.id_tipo_sangre;
	}
	
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=null && this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			} else if(this.id_empleado==null && newid_empleado!=null) {
				this.id_empleado=newid_empleado;
				this.id=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_numero_patronal(Long newid_numero_patronal)throws Exception
	{
		try {
			if(this.id_numero_patronal!=newid_numero_patronal) {
				if(newid_numero_patronal==null) {
					//newid_numero_patronal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_numero_patronal");
					}
				}

				this.id_numero_patronal=newid_numero_patronal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_afiliacion(Long newid_tipo_afiliacion)throws Exception
	{
		try {
			if(this.id_tipo_afiliacion!=newid_tipo_afiliacion) {
				if(newid_tipo_afiliacion==null) {
					//newid_tipo_afiliacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_afiliacion");
					}
				}

				this.id_tipo_afiliacion=newid_tipo_afiliacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcarnet_iess(String newcarnet_iess)throws Exception
	{
		try {
			if(this.carnet_iess!=newcarnet_iess) {
				if(newcarnet_iess==null) {
					//newcarnet_iess="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna carnet_iess");
					}
				}

				if(newcarnet_iess!=null&&newcarnet_iess.length()>25) {
					newcarnet_iess=newcarnet_iess.substring(0,23);
					System.out.println("DatoGeneralEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna carnet_iess");
				}

				this.carnet_iess=newcarnet_iess;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsectorial_iess(String newsectorial_iess)throws Exception
	{
		try {
			if(this.sectorial_iess!=newsectorial_iess) {
				if(newsectorial_iess==null) {
					//newsectorial_iess="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna sectorial_iess");
					}
				}

				if(newsectorial_iess!=null&&newsectorial_iess.length()>20) {
					newsectorial_iess=newsectorial_iess.substring(0,18);
					System.out.println("DatoGeneralEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna sectorial_iess");
				}

				this.sectorial_iess=newsectorial_iess;
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
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_canton(Long newid_canton)throws Exception
	{
		try {
			if(this.id_canton!=newid_canton) {
				if(newid_canton==null) {
					//newid_canton=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_canton");
					}
				}

				this.id_canton=newid_canton;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parroquia(Long newid_parroquia)throws Exception
	{
		try {
			if(this.id_parroquia!=newid_parroquia) {
				if(newid_parroquia==null) {
					//newid_parroquia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_parroquia");
					}
				}

				this.id_parroquia=newid_parroquia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fallece(Date newfecha_fallece)throws Exception
	{
		try {
			if(this.fecha_fallece!=newfecha_fallece) {
				if(newfecha_fallece==null) {
					//newfecha_fallece=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna fecha_fallece");
					}
				}

				this.fecha_fallece=newfecha_fallece;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_evaluacion(Double newvalor_evaluacion)throws Exception
	{
		try {
			if(this.valor_evaluacion!=newvalor_evaluacion) {
				if(newvalor_evaluacion==null) {
					//newvalor_evaluacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor_evaluacion");
					}
				}

				this.valor_evaluacion=newvalor_evaluacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_horas(Double newnumero_horas)throws Exception
	{
		try {
			if(this.numero_horas!=newnumero_horas) {
				if(newnumero_horas==null) {
					//newnumero_horas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna numero_horas");
					}
				}

				this.numero_horas=newnumero_horas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_hora(Double newvalor_hora)throws Exception
	{
		try {
			if(this.valor_hora!=newvalor_hora) {
				if(newvalor_hora==null) {
					//newvalor_hora=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor_hora");
					}
				}

				this.valor_hora=newvalor_hora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsalario(Double newsalario)throws Exception
	{
		try {
			if(this.salario!=newsalario) {
				if(newsalario==null) {
					//newsalario=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna salario");
					}
				}

				this.salario=newsalario;
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
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_contrato(String newnumero_contrato)throws Exception
	{
		try {
			if(this.numero_contrato!=newnumero_contrato) {
				if(newnumero_contrato==null) {
					//newnumero_contrato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna numero_contrato");
					}
				}

				if(newnumero_contrato!=null&&newnumero_contrato.length()>20) {
					newnumero_contrato=newnumero_contrato.substring(0,18);
					System.out.println("DatoGeneralEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_contrato");
				}

				this.numero_contrato=newnumero_contrato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_contrato(Long newid_tipo_contrato)throws Exception
	{
		try {
			if(this.id_tipo_contrato!=newid_tipo_contrato) {
				if(newid_tipo_contrato==null) {
					//newid_tipo_contrato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_contrato");
					}
				}

				this.id_tipo_contrato=newid_tipo_contrato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor1(Double newvalor1)throws Exception
	{
		try {
			if(this.valor1!=newvalor1) {
				if(newvalor1==null) {
					//newvalor1=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor1");
					}
				}

				this.valor1=newvalor1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor2(Double newvalor2)throws Exception
	{
		try {
			if(this.valor2!=newvalor2) {
				if(newvalor2==null) {
					//newvalor2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor2");
					}
				}

				this.valor2=newvalor2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor3(Double newvalor3)throws Exception
	{
		try {
			if(this.valor3!=newvalor3) {
				if(newvalor3==null) {
					//newvalor3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor3");
					}
				}

				this.valor3=newvalor3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor4(Double newvalor4)throws Exception
	{
		try {
			if(this.valor4!=newvalor4) {
				if(newvalor4==null) {
					//newvalor4=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor4");
					}
				}

				this.valor4=newvalor4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor5(Double newvalor5)throws Exception
	{
		try {
			if(this.valor5!=newvalor5) {
				if(newvalor5==null) {
					//newvalor5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor5");
					}
				}

				this.valor5=newvalor5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor6(Double newvalor6)throws Exception
	{
		try {
			if(this.valor6!=newvalor6) {
				if(newvalor6==null) {
					//newvalor6=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna valor6");
					}
				}

				this.valor6=newvalor6;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_aporta_seguro_social(Boolean newcon_aporta_seguro_social)throws Exception
	{
		try {
			if(this.con_aporta_seguro_social!=newcon_aporta_seguro_social) {
				if(newcon_aporta_seguro_social==null) {
					//newcon_aporta_seguro_social=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna con_aporta_seguro_social");
					}
				}

				this.con_aporta_seguro_social=newcon_aporta_seguro_social;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_recibe_horas_extras(Boolean newcon_recibe_horas_extras)throws Exception
	{
		try {
			if(this.con_recibe_horas_extras!=newcon_recibe_horas_extras) {
				if(newcon_recibe_horas_extras==null) {
					//newcon_recibe_horas_extras=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna con_recibe_horas_extras");
					}
				}

				this.con_recibe_horas_extras=newcon_recibe_horas_extras;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_descuento_impuestos(Boolean newcon_descuento_impuestos)throws Exception
	{
		try {
			if(this.con_descuento_impuestos!=newcon_descuento_impuestos) {
				if(newcon_descuento_impuestos==null) {
					//newcon_descuento_impuestos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna con_descuento_impuestos");
					}
				}

				this.con_descuento_impuestos=newcon_descuento_impuestos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpension_alimenticia(Double newpension_alimenticia)throws Exception
	{
		try {
			if(this.pension_alimenticia!=newpension_alimenticia) {
				if(newpension_alimenticia==null) {
					//newpension_alimenticia=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna pension_alimenticia");
					}
				}

				this.pension_alimenticia=newpension_alimenticia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_pago_por_horas(Boolean newcon_pago_por_horas)throws Exception
	{
		try {
			if(this.con_pago_por_horas!=newcon_pago_por_horas) {
				if(newcon_pago_por_horas==null) {
					//newcon_pago_por_horas=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna con_pago_por_horas");
					}
				}

				this.con_pago_por_horas=newcon_pago_por_horas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_anticipo(Boolean newcon_anticipo)throws Exception
	{
		try {
			if(this.con_anticipo!=newcon_anticipo) {
				if(newcon_anticipo==null) {
					//newcon_anticipo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna con_anticipo");
					}
				}

				this.con_anticipo=newcon_anticipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_libreta_mili(Long newid_tipo_libreta_mili)throws Exception
	{
		try {
			if(this.id_tipo_libreta_mili!=newid_tipo_libreta_mili) {
				if(newid_tipo_libreta_mili==null) {
					//newid_tipo_libreta_mili=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_libreta_mili");
					}
				}

				this.id_tipo_libreta_mili=newid_tipo_libreta_mili;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlibreta_militar(String newlibreta_militar)throws Exception
	{
		try {
			if(this.libreta_militar!=newlibreta_militar) {
				if(newlibreta_militar==null) {
					//newlibreta_militar="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna libreta_militar");
					}
				}

				if(newlibreta_militar!=null&&newlibreta_militar.length()>20) {
					newlibreta_militar=newlibreta_militar.substring(0,18);
					System.out.println("DatoGeneralEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna libreta_militar");
				}

				this.libreta_militar=newlibreta_militar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_grupo_forma_pago(Long newid_tipo_grupo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_grupo_forma_pago!=newid_tipo_grupo_forma_pago) {
				if(newid_tipo_grupo_forma_pago==null) {
					//newid_tipo_grupo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_grupo_forma_pago");
					}
				}

				this.id_tipo_grupo_forma_pago=newid_tipo_grupo_forma_pago;
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
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco_global(Long newid_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco_global!=newid_tipo_cuenta_banco_global) {
				if(newid_tipo_cuenta_banco_global==null) {
					//newid_tipo_cuenta_banco_global=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_cuenta_banco_global");
					}
				}

				this.id_tipo_cuenta_banco_global=newid_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>20) {
					newnumero_cuenta=newnumero_cuenta.substring(0,18);
					System.out.println("DatoGeneralEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_sangre(Long newid_tipo_sangre)throws Exception
	{
		try {
			if(this.id_tipo_sangre!=newid_tipo_sangre) {
				if(newid_tipo_sangre==null) {
					//newid_tipo_sangre=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralEmpleado:Valor nulo no permitido en columna id_tipo_sangre");
					}
				}

				this.id_tipo_sangre=newid_tipo_sangre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empleado getEmpleado() {
		return this.empleado;
	}

	public NumeroPatronal getNumeroPatronal() {
		return this.numeropatronal;
	}

	public TipoAfiliacion getTipoAfiliacion() {
		return this.tipoafiliacion;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public Parroquia getParroquia() {
		return this.parroquia;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public TipoContrato getTipoContrato() {
		return this.tipocontrato;
	}

	public TipoLibretaMili getTipoLibretaMili() {
		return this.tipolibretamili;
	}

	public TipoGrupoFormaPago getTipoGrupoFormaPago() {
		return this.tipogrupoformapago;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() {
		return this.tipocuentabancoglobal;
	}

	public TipoSangre getTipoSangre() {
		return this.tiposangre;
	}

	
	
	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getnumeropatronal_descripcion() {
		return this.numeropatronal_descripcion;
	}

	public String gettipoafiliacion_descripcion() {
		return this.tipoafiliacion_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getcanton_descripcion() {
		return this.canton_descripcion;
	}

	public String getparroquia_descripcion() {
		return this.parroquia_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String gettipocontrato_descripcion() {
		return this.tipocontrato_descripcion;
	}

	public String gettipolibretamili_descripcion() {
		return this.tipolibretamili_descripcion;
	}

	public String gettipogrupoformapago_descripcion() {
		return this.tipogrupoformapago_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettipocuentabancoglobal_descripcion() {
		return this.tipocuentabancoglobal_descripcion;
	}

	public String gettiposangre_descripcion() {
		return this.tiposangre_descripcion;
	}

	
	
	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNumeroPatronal(NumeroPatronal numeropatronal) {
		try {
			this.numeropatronal=numeropatronal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoAfiliacion(TipoAfiliacion tipoafiliacion) {
		try {
			this.tipoafiliacion=tipoafiliacion;
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


	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCanton(Canton canton) {
		try {
			this.canton=canton;
		} catch(Exception e) {
			;
		}
	}


	public  void  setParroquia(Parroquia parroquia) {
		try {
			this.parroquia=parroquia;
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


	public  void  setTipoContrato(TipoContrato tipocontrato) {
		try {
			this.tipocontrato=tipocontrato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoLibretaMili(TipoLibretaMili tipolibretamili) {
		try {
			this.tipolibretamili=tipolibretamili;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGrupoFormaPago(TipoGrupoFormaPago tipogrupoformapago) {
		try {
			this.tipogrupoformapago=tipogrupoformapago;
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


	public  void  setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobal=tipocuentabancoglobal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoSangre(TipoSangre tiposangre) {
		try {
			this.tiposangre=tiposangre;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setnumeropatronal_descripcion(String numeropatronal_descripcion) {
		try {
			this.numeropatronal_descripcion=numeropatronal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoafiliacion_descripcion(String tipoafiliacion_descripcion) {
		try {
			this.tipoafiliacion_descripcion=tipoafiliacion_descripcion;
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


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcanton_descripcion(String canton_descripcion) {
		try {
			this.canton_descripcion=canton_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setparroquia_descripcion(String parroquia_descripcion) {
		try {
			this.parroquia_descripcion=parroquia_descripcion;
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


	public  void  settipocontrato_descripcion(String tipocontrato_descripcion) {
		try {
			this.tipocontrato_descripcion=tipocontrato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipolibretamili_descripcion(String tipolibretamili_descripcion) {
		try {
			this.tipolibretamili_descripcion=tipolibretamili_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogrupoformapago_descripcion(String tipogrupoformapago_descripcion) {
		try {
			this.tipogrupoformapago_descripcion=tipogrupoformapago_descripcion;
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


	public  void  settipocuentabancoglobal_descripcion(String tipocuentabancoglobal_descripcion) {
		try {
			this.tipocuentabancoglobal_descripcion=tipocuentabancoglobal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiposangre_descripcion(String tiposangre_descripcion) {
		try {
			this.tiposangre_descripcion=tiposangre_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empleadoNONE_descripcion="";String id_numero_patronal_descripcion="";String id_tipo_afiliacion_descripcion="";String id_pais_descripcion="";String id_provincia_descripcion="";String id_canton_descripcion="";String id_parroquia_descripcion="";String id_moneda_descripcion="";String id_tipo_contrato_descripcion="";String con_aporta_seguro_social_descripcion="";String con_recibe_horas_extras_descripcion="";String con_descuento_impuestos_descripcion="";String con_pago_por_horas_descripcion="";String con_anticipo_descripcion="";String id_tipo_libreta_mili_descripcion="";String id_tipo_grupo_forma_pago_descripcion="";String id_banco_descripcion="";String id_tipo_cuenta_banco_global_descripcion="";String id_tipo_sangre_descripcion="";
	
	
	public String getid_empleadoNONE_descripcion() {
		return id_empleadoNONE_descripcion;
	}
	public String getid_numero_patronal_descripcion() {
		return id_numero_patronal_descripcion;
	}
	public String getid_tipo_afiliacion_descripcion() {
		return id_tipo_afiliacion_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_canton_descripcion() {
		return id_canton_descripcion;
	}
	public String getid_parroquia_descripcion() {
		return id_parroquia_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_tipo_contrato_descripcion() {
		return id_tipo_contrato_descripcion;
	}
	public String getcon_aporta_seguro_social_descripcion() {
		return con_aporta_seguro_social_descripcion;
	}
	public String getcon_recibe_horas_extras_descripcion() {
		return con_recibe_horas_extras_descripcion;
	}
	public String getcon_descuento_impuestos_descripcion() {
		return con_descuento_impuestos_descripcion;
	}
	public String getcon_pago_por_horas_descripcion() {
		return con_pago_por_horas_descripcion;
	}
	public String getcon_anticipo_descripcion() {
		return con_anticipo_descripcion;
	}
	public String getid_tipo_libreta_mili_descripcion() {
		return id_tipo_libreta_mili_descripcion;
	}
	public String getid_tipo_grupo_forma_pago_descripcion() {
		return id_tipo_grupo_forma_pago_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_tipo_cuenta_banco_global_descripcion() {
		return id_tipo_cuenta_banco_global_descripcion;
	}
	public String getid_tipo_sangre_descripcion() {
		return id_tipo_sangre_descripcion;
	}
	
	
	public void setid_empleadoNONE_descripcion(String newid_empleadoNONE_descripcion)throws Exception {
		try {
			this.id_empleadoNONE_descripcion=newid_empleadoNONE_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_numero_patronal_descripcion(String newid_numero_patronal_descripcion)throws Exception {
		try {
			this.id_numero_patronal_descripcion=newid_numero_patronal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_afiliacion_descripcion(String newid_tipo_afiliacion_descripcion)throws Exception {
		try {
			this.id_tipo_afiliacion_descripcion=newid_tipo_afiliacion_descripcion;
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
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_canton_descripcion(String newid_canton_descripcion)throws Exception {
		try {
			this.id_canton_descripcion=newid_canton_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_parroquia_descripcion(String newid_parroquia_descripcion)throws Exception {
		try {
			this.id_parroquia_descripcion=newid_parroquia_descripcion;
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
	public void setid_tipo_contrato_descripcion(String newid_tipo_contrato_descripcion)throws Exception {
		try {
			this.id_tipo_contrato_descripcion=newid_tipo_contrato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_aporta_seguro_social_descripcion(String newcon_aporta_seguro_social_descripcion)throws Exception {
		try {
			this.con_aporta_seguro_social_descripcion=newcon_aporta_seguro_social_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_recibe_horas_extras_descripcion(String newcon_recibe_horas_extras_descripcion)throws Exception {
		try {
			this.con_recibe_horas_extras_descripcion=newcon_recibe_horas_extras_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_descuento_impuestos_descripcion(String newcon_descuento_impuestos_descripcion)throws Exception {
		try {
			this.con_descuento_impuestos_descripcion=newcon_descuento_impuestos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_pago_por_horas_descripcion(String newcon_pago_por_horas_descripcion)throws Exception {
		try {
			this.con_pago_por_horas_descripcion=newcon_pago_por_horas_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_anticipo_descripcion(String newcon_anticipo_descripcion)throws Exception {
		try {
			this.con_anticipo_descripcion=newcon_anticipo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_libreta_mili_descripcion(String newid_tipo_libreta_mili_descripcion)throws Exception {
		try {
			this.id_tipo_libreta_mili_descripcion=newid_tipo_libreta_mili_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_grupo_forma_pago_descripcion(String newid_tipo_grupo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_forma_pago_descripcion=newid_tipo_grupo_forma_pago_descripcion;
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
	public void setid_tipo_cuenta_banco_global_descripcion(String newid_tipo_cuenta_banco_global_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_global_descripcion=newid_tipo_cuenta_banco_global_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_sangre_descripcion(String newid_tipo_sangre_descripcion)throws Exception {
		try {
			this.id_tipo_sangre_descripcion=newid_tipo_sangre_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_numero_patronal_descripcion="";this.id_tipo_afiliacion_descripcion="";this.id_pais_descripcion="";this.id_provincia_descripcion="";this.id_canton_descripcion="";this.id_parroquia_descripcion="";this.id_moneda_descripcion="";this.id_tipo_contrato_descripcion="";this.con_aporta_seguro_social_descripcion="";this.con_recibe_horas_extras_descripcion="";this.con_descuento_impuestos_descripcion="";this.con_pago_por_horas_descripcion="";this.con_anticipo_descripcion="";this.id_tipo_libreta_mili_descripcion="";this.id_tipo_grupo_forma_pago_descripcion="";this.id_banco_descripcion="";this.id_tipo_cuenta_banco_global_descripcion="";this.id_tipo_sangre_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

