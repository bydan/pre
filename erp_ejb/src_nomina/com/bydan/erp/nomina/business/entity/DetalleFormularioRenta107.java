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
//import com.bydan.erp.nomina.util.DetalleFormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleFormularioRenta107 extends DetalleFormularioRenta107Additional implements Serializable ,Cloneable {//DetalleFormularioRenta107Additional,GeneralEntity
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
	
	private DetalleFormularioRenta107 detalleformulariorenta107Original;
	
	private Map<String, Object> mapDetalleFormularioRenta107;
			
	public Map<String, Object> getMapDetalleFormularioRenta107() {
		return mapDetalleFormularioRenta107;
	}

	public void setMapDetalleFormularioRenta107(Map<String, Object> mapDetalleFormularioRenta107) {
		this.mapDetalleFormularioRenta107 = mapDetalleFormularioRenta107;
	}
	
	public void inicializarMapDetalleFormularioRenta107() {
		this.mapDetalleFormularioRenta107 = new HashMap<String,Object>();
	}
	
	public void setMapDetalleFormularioRenta107Value(String sKey,Object oValue) {
		this.mapDetalleFormularioRenta107.put(sKey, oValue);
	}
	
	public Object getMapDetalleFormularioRenta107Value(String sKey) {
		return this.mapDetalleFormularioRenta107.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formulario_renta107;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sueldos_301;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sobre_sueldos_303;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double decimo_tercero_305;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double decimo_cuarto_307;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fondo_reserva_309;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidades_311;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double desahucio_313;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iess_personal_315;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_vivienda_317;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_salud_319;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_educacion_321;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_alimentacion_323;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gastos_vestimenta_325;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_discapacidad_327;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_tercera_edad_329;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double asume_empleador_331;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_empleador_351;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_meses_trabajados_353;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso_otros_empleadores_401;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double deduccion_gastos_otros_empleadores_403;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double rebajas_otros_empleadores_405;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_imponible_anual_407;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto_causado_409;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto_retenido_empleador_411;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto_retenido_otros_empleadores_413;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public FormularioRenta107 formulariorenta107;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String formulariorenta107_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public DetalleFormularioRenta107 () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleformulariorenta107Original=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_formulario_renta107=-1L;
 		this.id_ejercicio=-1L;
 		this.sueldos_301=0.0;
 		this.sobre_sueldos_303=0.0;
 		this.decimo_tercero_305=0.0;
 		this.decimo_cuarto_307=0.0;
 		this.fondo_reserva_309=0.0;
 		this.utilidades_311=0.0;
 		this.desahucio_313=0.0;
 		this.iess_personal_315=0.0;
 		this.gastos_vivienda_317=0.0;
 		this.gastos_salud_319=0.0;
 		this.gastos_educacion_321=0.0;
 		this.gastos_alimentacion_323=0.0;
 		this.gastos_vestimenta_325=0.0;
 		this.descuento_discapacidad_327=0.0;
 		this.descuento_tercera_edad_329=0.0;
 		this.asume_empleador_331=0.0;
 		this.sub_empleador_351=0.0;
 		this.numero_meses_trabajados_353=0;
 		this.ingreso_otros_empleadores_401=0.0;
 		this.deduccion_gastos_otros_empleadores_403=0.0;
 		this.rebajas_otros_empleadores_405=0.0;
 		this.base_imponible_anual_407=0.0;
 		this.impuesto_causado_409=0.0;
 		this.impuesto_retenido_empleador_411=0.0;
 		this.impuesto_retenido_otros_empleadores_413=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.formulariorenta107=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.formulariorenta107_descripcion="";
		this.ejercicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleFormularioRenta107 (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_formulario_renta107,Long id_ejercicio,Double sueldos_301,Double sobre_sueldos_303,Double decimo_tercero_305,Double decimo_cuarto_307,Double fondo_reserva_309,Double utilidades_311,Double desahucio_313,Double iess_personal_315,Double gastos_vivienda_317,Double gastos_salud_319,Double gastos_educacion_321,Double gastos_alimentacion_323,Double gastos_vestimenta_325,Double descuento_discapacidad_327,Double descuento_tercera_edad_329,Double asume_empleador_331,Double sub_empleador_351,Integer numero_meses_trabajados_353,Double ingreso_otros_empleadores_401,Double deduccion_gastos_otros_empleadores_403,Double rebajas_otros_empleadores_405,Double base_imponible_anual_407,Double impuesto_causado_409,Double impuesto_retenido_empleador_411,Double impuesto_retenido_otros_empleadores_413) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleformulariorenta107Original=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_formulario_renta107=id_formulario_renta107;
 		this.id_ejercicio=id_ejercicio;
 		this.sueldos_301=sueldos_301;
 		this.sobre_sueldos_303=sobre_sueldos_303;
 		this.decimo_tercero_305=decimo_tercero_305;
 		this.decimo_cuarto_307=decimo_cuarto_307;
 		this.fondo_reserva_309=fondo_reserva_309;
 		this.utilidades_311=utilidades_311;
 		this.desahucio_313=desahucio_313;
 		this.iess_personal_315=iess_personal_315;
 		this.gastos_vivienda_317=gastos_vivienda_317;
 		this.gastos_salud_319=gastos_salud_319;
 		this.gastos_educacion_321=gastos_educacion_321;
 		this.gastos_alimentacion_323=gastos_alimentacion_323;
 		this.gastos_vestimenta_325=gastos_vestimenta_325;
 		this.descuento_discapacidad_327=descuento_discapacidad_327;
 		this.descuento_tercera_edad_329=descuento_tercera_edad_329;
 		this.asume_empleador_331=asume_empleador_331;
 		this.sub_empleador_351=sub_empleador_351;
 		this.numero_meses_trabajados_353=numero_meses_trabajados_353;
 		this.ingreso_otros_empleadores_401=ingreso_otros_empleadores_401;
 		this.deduccion_gastos_otros_empleadores_403=deduccion_gastos_otros_empleadores_403;
 		this.rebajas_otros_empleadores_405=rebajas_otros_empleadores_405;
 		this.base_imponible_anual_407=base_imponible_anual_407;
 		this.impuesto_causado_409=impuesto_causado_409;
 		this.impuesto_retenido_empleador_411=impuesto_retenido_empleador_411;
 		this.impuesto_retenido_otros_empleadores_413=impuesto_retenido_otros_empleadores_413;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleFormularioRenta107 (Long id_empresa,Long id_empleado,Long id_formulario_renta107,Long id_ejercicio,Double sueldos_301,Double sobre_sueldos_303,Double decimo_tercero_305,Double decimo_cuarto_307,Double fondo_reserva_309,Double utilidades_311,Double desahucio_313,Double iess_personal_315,Double gastos_vivienda_317,Double gastos_salud_319,Double gastos_educacion_321,Double gastos_alimentacion_323,Double gastos_vestimenta_325,Double descuento_discapacidad_327,Double descuento_tercera_edad_329,Double asume_empleador_331,Double sub_empleador_351,Integer numero_meses_trabajados_353,Double ingreso_otros_empleadores_401,Double deduccion_gastos_otros_empleadores_403,Double rebajas_otros_empleadores_405,Double base_imponible_anual_407,Double impuesto_causado_409,Double impuesto_retenido_empleador_411,Double impuesto_retenido_otros_empleadores_413) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleformulariorenta107Original=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_formulario_renta107=id_formulario_renta107;
 		this.id_ejercicio=id_ejercicio;
 		this.sueldos_301=sueldos_301;
 		this.sobre_sueldos_303=sobre_sueldos_303;
 		this.decimo_tercero_305=decimo_tercero_305;
 		this.decimo_cuarto_307=decimo_cuarto_307;
 		this.fondo_reserva_309=fondo_reserva_309;
 		this.utilidades_311=utilidades_311;
 		this.desahucio_313=desahucio_313;
 		this.iess_personal_315=iess_personal_315;
 		this.gastos_vivienda_317=gastos_vivienda_317;
 		this.gastos_salud_319=gastos_salud_319;
 		this.gastos_educacion_321=gastos_educacion_321;
 		this.gastos_alimentacion_323=gastos_alimentacion_323;
 		this.gastos_vestimenta_325=gastos_vestimenta_325;
 		this.descuento_discapacidad_327=descuento_discapacidad_327;
 		this.descuento_tercera_edad_329=descuento_tercera_edad_329;
 		this.asume_empleador_331=asume_empleador_331;
 		this.sub_empleador_351=sub_empleador_351;
 		this.numero_meses_trabajados_353=numero_meses_trabajados_353;
 		this.ingreso_otros_empleadores_401=ingreso_otros_empleadores_401;
 		this.deduccion_gastos_otros_empleadores_403=deduccion_gastos_otros_empleadores_403;
 		this.rebajas_otros_empleadores_405=rebajas_otros_empleadores_405;
 		this.base_imponible_anual_407=base_imponible_anual_407;
 		this.impuesto_causado_409=impuesto_causado_409;
 		this.impuesto_retenido_empleador_411=impuesto_retenido_empleador_411;
 		this.impuesto_retenido_otros_empleadores_413=impuesto_retenido_otros_empleadores_413;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleFormularioRenta107 detalleformulariorenta107Local=null;
		
		if(object!=null) {
			detalleformulariorenta107Local=(DetalleFormularioRenta107)object;
			
			if(detalleformulariorenta107Local!=null) {
				if(this.getId()!=null && detalleformulariorenta107Local.getId()!=null) {
					if(this.getId().equals(detalleformulariorenta107Local.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleFormularioRenta107ConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleFormularioRenta107ConstantesFunciones.getDetalleFormularioRenta107Descripcion(this);
		} else {
			sDetalle=DetalleFormularioRenta107ConstantesFunciones.getDetalleFormularioRenta107DescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleFormularioRenta107 getDetalleFormularioRenta107Original() {
		return this.detalleformulariorenta107Original;
	}
	
	public void setDetalleFormularioRenta107Original(DetalleFormularioRenta107 detalleformulariorenta107) {
		try {
			this.detalleformulariorenta107Original=detalleformulariorenta107;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleFormularioRenta107Additional detalleformulariorenta107Additional=null;
	
	public DetalleFormularioRenta107Additional getDetalleFormularioRenta107Additional() {
		return this.detalleformulariorenta107Additional;
	}
	
	public void setDetalleFormularioRenta107Additional(DetalleFormularioRenta107Additional detalleformulariorenta107Additional) {
		try {
			this.detalleformulariorenta107Additional=detalleformulariorenta107Additional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_formulario_renta107() {
		return this.id_formulario_renta107;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Double getsueldos_301() {
		return this.sueldos_301;
	}
    
	
	public Double getsobre_sueldos_303() {
		return this.sobre_sueldos_303;
	}
    
	
	public Double getdecimo_tercero_305() {
		return this.decimo_tercero_305;
	}
    
	
	public Double getdecimo_cuarto_307() {
		return this.decimo_cuarto_307;
	}
    
	
	public Double getfondo_reserva_309() {
		return this.fondo_reserva_309;
	}
    
	
	public Double getutilidades_311() {
		return this.utilidades_311;
	}
    
	
	public Double getdesahucio_313() {
		return this.desahucio_313;
	}
    
	
	public Double getiess_personal_315() {
		return this.iess_personal_315;
	}
    
	
	public Double getgastos_vivienda_317() {
		return this.gastos_vivienda_317;
	}
    
	
	public Double getgastos_salud_319() {
		return this.gastos_salud_319;
	}
    
	
	public Double getgastos_educacion_321() {
		return this.gastos_educacion_321;
	}
    
	
	public Double getgastos_alimentacion_323() {
		return this.gastos_alimentacion_323;
	}
    
	
	public Double getgastos_vestimenta_325() {
		return this.gastos_vestimenta_325;
	}
    
	
	public Double getdescuento_discapacidad_327() {
		return this.descuento_discapacidad_327;
	}
    
	
	public Double getdescuento_tercera_edad_329() {
		return this.descuento_tercera_edad_329;
	}
    
	
	public Double getasume_empleador_331() {
		return this.asume_empleador_331;
	}
    
	
	public Double getsub_empleador_351() {
		return this.sub_empleador_351;
	}
    
	
	public Integer getnumero_meses_trabajados_353() {
		return this.numero_meses_trabajados_353;
	}
    
	
	public Double getingreso_otros_empleadores_401() {
		return this.ingreso_otros_empleadores_401;
	}
    
	
	public Double getdeduccion_gastos_otros_empleadores_403() {
		return this.deduccion_gastos_otros_empleadores_403;
	}
    
	
	public Double getrebajas_otros_empleadores_405() {
		return this.rebajas_otros_empleadores_405;
	}
    
	
	public Double getbase_imponible_anual_407() {
		return this.base_imponible_anual_407;
	}
    
	
	public Double getimpuesto_causado_409() {
		return this.impuesto_causado_409;
	}
    
	
	public Double getimpuesto_retenido_empleador_411() {
		return this.impuesto_retenido_empleador_411;
	}
    
	
	public Double getimpuesto_retenido_otros_empleadores_413() {
		return this.impuesto_retenido_otros_empleadores_413;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formulario_renta107(Long newid_formulario_renta107)throws Exception
	{
		try {
			if(this.id_formulario_renta107!=newid_formulario_renta107) {
				if(newid_formulario_renta107==null) {
					//newid_formulario_renta107=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna id_formulario_renta107");
					}
				}

				this.id_formulario_renta107=newid_formulario_renta107;
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
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsueldos_301(Double newsueldos_301)throws Exception
	{
		try {
			if(this.sueldos_301!=newsueldos_301) {
				if(newsueldos_301==null) {
					//newsueldos_301=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna sueldos_301");
					}
				}

				this.sueldos_301=newsueldos_301;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsobre_sueldos_303(Double newsobre_sueldos_303)throws Exception
	{
		try {
			if(this.sobre_sueldos_303!=newsobre_sueldos_303) {
				if(newsobre_sueldos_303==null) {
					//newsobre_sueldos_303=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna sobre_sueldos_303");
					}
				}

				this.sobre_sueldos_303=newsobre_sueldos_303;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdecimo_tercero_305(Double newdecimo_tercero_305)throws Exception
	{
		try {
			if(this.decimo_tercero_305!=newdecimo_tercero_305) {
				if(newdecimo_tercero_305==null) {
					//newdecimo_tercero_305=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna decimo_tercero_305");
					}
				}

				this.decimo_tercero_305=newdecimo_tercero_305;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdecimo_cuarto_307(Double newdecimo_cuarto_307)throws Exception
	{
		try {
			if(this.decimo_cuarto_307!=newdecimo_cuarto_307) {
				if(newdecimo_cuarto_307==null) {
					//newdecimo_cuarto_307=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna decimo_cuarto_307");
					}
				}

				this.decimo_cuarto_307=newdecimo_cuarto_307;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfondo_reserva_309(Double newfondo_reserva_309)throws Exception
	{
		try {
			if(this.fondo_reserva_309!=newfondo_reserva_309) {
				if(newfondo_reserva_309==null) {
					//newfondo_reserva_309=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna fondo_reserva_309");
					}
				}

				this.fondo_reserva_309=newfondo_reserva_309;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidades_311(Double newutilidades_311)throws Exception
	{
		try {
			if(this.utilidades_311!=newutilidades_311) {
				if(newutilidades_311==null) {
					//newutilidades_311=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna utilidades_311");
					}
				}

				this.utilidades_311=newutilidades_311;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdesahucio_313(Double newdesahucio_313)throws Exception
	{
		try {
			if(this.desahucio_313!=newdesahucio_313) {
				if(newdesahucio_313==null) {
					//newdesahucio_313=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna desahucio_313");
					}
				}

				this.desahucio_313=newdesahucio_313;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiess_personal_315(Double newiess_personal_315)throws Exception
	{
		try {
			if(this.iess_personal_315!=newiess_personal_315) {
				if(newiess_personal_315==null) {
					//newiess_personal_315=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna iess_personal_315");
					}
				}

				this.iess_personal_315=newiess_personal_315;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_vivienda_317(Double newgastos_vivienda_317)throws Exception
	{
		try {
			if(this.gastos_vivienda_317!=newgastos_vivienda_317) {
				if(newgastos_vivienda_317==null) {
					//newgastos_vivienda_317=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna gastos_vivienda_317");
					}
				}

				this.gastos_vivienda_317=newgastos_vivienda_317;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_salud_319(Double newgastos_salud_319)throws Exception
	{
		try {
			if(this.gastos_salud_319!=newgastos_salud_319) {
				if(newgastos_salud_319==null) {
					//newgastos_salud_319=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna gastos_salud_319");
					}
				}

				this.gastos_salud_319=newgastos_salud_319;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_educacion_321(Double newgastos_educacion_321)throws Exception
	{
		try {
			if(this.gastos_educacion_321!=newgastos_educacion_321) {
				if(newgastos_educacion_321==null) {
					//newgastos_educacion_321=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna gastos_educacion_321");
					}
				}

				this.gastos_educacion_321=newgastos_educacion_321;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_alimentacion_323(Double newgastos_alimentacion_323)throws Exception
	{
		try {
			if(this.gastos_alimentacion_323!=newgastos_alimentacion_323) {
				if(newgastos_alimentacion_323==null) {
					//newgastos_alimentacion_323=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna gastos_alimentacion_323");
					}
				}

				this.gastos_alimentacion_323=newgastos_alimentacion_323;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgastos_vestimenta_325(Double newgastos_vestimenta_325)throws Exception
	{
		try {
			if(this.gastos_vestimenta_325!=newgastos_vestimenta_325) {
				if(newgastos_vestimenta_325==null) {
					//newgastos_vestimenta_325=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna gastos_vestimenta_325");
					}
				}

				this.gastos_vestimenta_325=newgastos_vestimenta_325;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_discapacidad_327(Double newdescuento_discapacidad_327)throws Exception
	{
		try {
			if(this.descuento_discapacidad_327!=newdescuento_discapacidad_327) {
				if(newdescuento_discapacidad_327==null) {
					//newdescuento_discapacidad_327=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna descuento_discapacidad_327");
					}
				}

				this.descuento_discapacidad_327=newdescuento_discapacidad_327;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_tercera_edad_329(Double newdescuento_tercera_edad_329)throws Exception
	{
		try {
			if(this.descuento_tercera_edad_329!=newdescuento_tercera_edad_329) {
				if(newdescuento_tercera_edad_329==null) {
					//newdescuento_tercera_edad_329=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna descuento_tercera_edad_329");
					}
				}

				this.descuento_tercera_edad_329=newdescuento_tercera_edad_329;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setasume_empleador_331(Double newasume_empleador_331)throws Exception
	{
		try {
			if(this.asume_empleador_331!=newasume_empleador_331) {
				if(newasume_empleador_331==null) {
					//newasume_empleador_331=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna asume_empleador_331");
					}
				}

				this.asume_empleador_331=newasume_empleador_331;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_empleador_351(Double newsub_empleador_351)throws Exception
	{
		try {
			if(this.sub_empleador_351!=newsub_empleador_351) {
				if(newsub_empleador_351==null) {
					//newsub_empleador_351=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna sub_empleador_351");
					}
				}

				this.sub_empleador_351=newsub_empleador_351;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_meses_trabajados_353(Integer newnumero_meses_trabajados_353)throws Exception
	{
		try {
			if(this.numero_meses_trabajados_353!=newnumero_meses_trabajados_353) {
				if(newnumero_meses_trabajados_353==null) {
					//newnumero_meses_trabajados_353=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna numero_meses_trabajados_353");
					}
				}

				this.numero_meses_trabajados_353=newnumero_meses_trabajados_353;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso_otros_empleadores_401(Double newingreso_otros_empleadores_401)throws Exception
	{
		try {
			if(this.ingreso_otros_empleadores_401!=newingreso_otros_empleadores_401) {
				if(newingreso_otros_empleadores_401==null) {
					//newingreso_otros_empleadores_401=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna ingreso_otros_empleadores_401");
					}
				}

				this.ingreso_otros_empleadores_401=newingreso_otros_empleadores_401;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdeduccion_gastos_otros_empleadores_403(Double newdeduccion_gastos_otros_empleadores_403)throws Exception
	{
		try {
			if(this.deduccion_gastos_otros_empleadores_403!=newdeduccion_gastos_otros_empleadores_403) {
				if(newdeduccion_gastos_otros_empleadores_403==null) {
					//newdeduccion_gastos_otros_empleadores_403=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna deduccion_gastos_otros_empleadores_403");
					}
				}

				this.deduccion_gastos_otros_empleadores_403=newdeduccion_gastos_otros_empleadores_403;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrebajas_otros_empleadores_405(Double newrebajas_otros_empleadores_405)throws Exception
	{
		try {
			if(this.rebajas_otros_empleadores_405!=newrebajas_otros_empleadores_405) {
				if(newrebajas_otros_empleadores_405==null) {
					//newrebajas_otros_empleadores_405=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna rebajas_otros_empleadores_405");
					}
				}

				this.rebajas_otros_empleadores_405=newrebajas_otros_empleadores_405;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_imponible_anual_407(Double newbase_imponible_anual_407)throws Exception
	{
		try {
			if(this.base_imponible_anual_407!=newbase_imponible_anual_407) {
				if(newbase_imponible_anual_407==null) {
					//newbase_imponible_anual_407=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna base_imponible_anual_407");
					}
				}

				this.base_imponible_anual_407=newbase_imponible_anual_407;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto_causado_409(Double newimpuesto_causado_409)throws Exception
	{
		try {
			if(this.impuesto_causado_409!=newimpuesto_causado_409) {
				if(newimpuesto_causado_409==null) {
					//newimpuesto_causado_409=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna impuesto_causado_409");
					}
				}

				this.impuesto_causado_409=newimpuesto_causado_409;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto_retenido_empleador_411(Double newimpuesto_retenido_empleador_411)throws Exception
	{
		try {
			if(this.impuesto_retenido_empleador_411!=newimpuesto_retenido_empleador_411) {
				if(newimpuesto_retenido_empleador_411==null) {
					//newimpuesto_retenido_empleador_411=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna impuesto_retenido_empleador_411");
					}
				}

				this.impuesto_retenido_empleador_411=newimpuesto_retenido_empleador_411;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto_retenido_otros_empleadores_413(Double newimpuesto_retenido_otros_empleadores_413)throws Exception
	{
		try {
			if(this.impuesto_retenido_otros_empleadores_413!=newimpuesto_retenido_otros_empleadores_413) {
				if(newimpuesto_retenido_otros_empleadores_413==null) {
					//newimpuesto_retenido_otros_empleadores_413=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleFormularioRenta107:Valor nulo no permitido en columna impuesto_retenido_otros_empleadores_413");
					}
				}

				this.impuesto_retenido_otros_empleadores_413=newimpuesto_retenido_otros_empleadores_413;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public FormularioRenta107 getFormularioRenta107() {
		return this.formulariorenta107;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getformulariorenta107_descripcion() {
		return this.formulariorenta107_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormularioRenta107(FormularioRenta107 formulariorenta107) {
		try {
			this.formulariorenta107=formulariorenta107;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	public  void  setformulariorenta107_descripcion(String formulariorenta107_descripcion) {
		try {
			this.formulariorenta107_descripcion=formulariorenta107_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_formulario_renta107_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_formulario_renta107_descripcion() {
		return id_formulario_renta107_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formulario_renta107_descripcion(String newid_formulario_renta107_descripcion)throws Exception {
		try {
			this.id_formulario_renta107_descripcion=newid_formulario_renta107_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_formulario_renta107_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

