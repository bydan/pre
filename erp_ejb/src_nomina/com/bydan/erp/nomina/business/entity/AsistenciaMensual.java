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
//import com.bydan.erp.nomina.util.AsistenciaMensualConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class AsistenciaMensual extends AsistenciaMensualAdditional implements Serializable ,Cloneable {//AsistenciaMensualAdditional,GeneralEntity
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
	
	private AsistenciaMensual asistenciamensualOriginal;
	
	private Map<String, Object> mapAsistenciaMensual;
			
	public Map<String, Object> getMapAsistenciaMensual() {
		return mapAsistenciaMensual;
	}

	public void setMapAsistenciaMensual(Map<String, Object> mapAsistenciaMensual) {
		this.mapAsistenciaMensual = mapAsistenciaMensual;
	}
	
	public void inicializarMapAsistenciaMensual() {
		this.mapAsistenciaMensual = new HashMap<String,Object>();
	}
	
	public void setMapAsistenciaMensualValue(String sKey,Object oValue) {
		this.mapAsistenciaMensual.put(sKey, oValue);
	}
	
	public Object getMapAsistenciaMensualValue(String sKey) {
		return this.mapAsistenciaMensual.get(sKey);
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
	private Long id_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_atraso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_faltas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_permiso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_extra25;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_extra50;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_extra100;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_extra150;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_extra0;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_enfermo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_maternidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_vacacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_noches;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_feriados;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_trabajo;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Cargo cargo;
	public Estructura estructura;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String cargo_descripcion;
	private String estructura_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public AsistenciaMensual () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.asistenciamensualOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_cargo=-1L;
 		this.id_estructura=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.fecha=new Date();
 		this.horas_trabajo=0.0;
 		this.horas_atraso=0.0;
 		this.horas_faltas=0.0;
 		this.horas_permiso=0.0;
 		this.horas_extra25=0.0;
 		this.horas_extra50=0.0;
 		this.horas_extra100=0.0;
 		this.horas_extra150=0.0;
 		this.horas_extra0=0.0;
 		this.horas_enfermo=0.0;
 		this.horas_maternidad=0.0;
 		this.horas_vacacion=0.0;
 		this.numero_dias=0.0;
 		this.numero_noches=0.0;
 		this.numero_feriados=0.0;
 		this.numero_trabajo=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.cargo=null;
		this.estructura=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.cargo_descripcion="";
		this.estructura_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AsistenciaMensual (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_cargo,Long id_estructura,Long id_anio,Long id_mes,Date fecha,Double horas_trabajo,Double horas_atraso,Double horas_faltas,Double horas_permiso,Double horas_extra25,Double horas_extra50,Double horas_extra100,Double horas_extra150,Double horas_extra0,Double horas_enfermo,Double horas_maternidad,Double horas_vacacion,Double numero_dias,Double numero_noches,Double numero_feriados,Double numero_trabajo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciamensualOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_cargo=id_cargo;
 		this.id_estructura=id_estructura;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.horas_trabajo=horas_trabajo;
 		this.horas_atraso=horas_atraso;
 		this.horas_faltas=horas_faltas;
 		this.horas_permiso=horas_permiso;
 		this.horas_extra25=horas_extra25;
 		this.horas_extra50=horas_extra50;
 		this.horas_extra100=horas_extra100;
 		this.horas_extra150=horas_extra150;
 		this.horas_extra0=horas_extra0;
 		this.horas_enfermo=horas_enfermo;
 		this.horas_maternidad=horas_maternidad;
 		this.horas_vacacion=horas_vacacion;
 		this.numero_dias=numero_dias;
 		this.numero_noches=numero_noches;
 		this.numero_feriados=numero_feriados;
 		this.numero_trabajo=numero_trabajo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AsistenciaMensual (Long id_empresa,Long id_empleado,Long id_cargo,Long id_estructura,Long id_anio,Long id_mes,Date fecha,Double horas_trabajo,Double horas_atraso,Double horas_faltas,Double horas_permiso,Double horas_extra25,Double horas_extra50,Double horas_extra100,Double horas_extra150,Double horas_extra0,Double horas_enfermo,Double horas_maternidad,Double horas_vacacion,Double numero_dias,Double numero_noches,Double numero_feriados,Double numero_trabajo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciamensualOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_cargo=id_cargo;
 		this.id_estructura=id_estructura;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha=fecha;
 		this.horas_trabajo=horas_trabajo;
 		this.horas_atraso=horas_atraso;
 		this.horas_faltas=horas_faltas;
 		this.horas_permiso=horas_permiso;
 		this.horas_extra25=horas_extra25;
 		this.horas_extra50=horas_extra50;
 		this.horas_extra100=horas_extra100;
 		this.horas_extra150=horas_extra150;
 		this.horas_extra0=horas_extra0;
 		this.horas_enfermo=horas_enfermo;
 		this.horas_maternidad=horas_maternidad;
 		this.horas_vacacion=horas_vacacion;
 		this.numero_dias=numero_dias;
 		this.numero_noches=numero_noches;
 		this.numero_feriados=numero_feriados;
 		this.numero_trabajo=numero_trabajo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AsistenciaMensual asistenciamensualLocal=null;
		
		if(object!=null) {
			asistenciamensualLocal=(AsistenciaMensual)object;
			
			if(asistenciamensualLocal!=null) {
				if(this.getId()!=null && asistenciamensualLocal.getId()!=null) {
					if(this.getId().equals(asistenciamensualLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AsistenciaMensualConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AsistenciaMensualConstantesFunciones.getAsistenciaMensualDescripcion(this);
		} else {
			sDetalle=AsistenciaMensualConstantesFunciones.getAsistenciaMensualDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AsistenciaMensual getAsistenciaMensualOriginal() {
		return this.asistenciamensualOriginal;
	}
	
	public void setAsistenciaMensualOriginal(AsistenciaMensual asistenciamensual) {
		try {
			this.asistenciamensualOriginal=asistenciamensual;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AsistenciaMensualAdditional asistenciamensualAdditional=null;
	
	public AsistenciaMensualAdditional getAsistenciaMensualAdditional() {
		return this.asistenciamensualAdditional;
	}
	
	public void setAsistenciaMensualAdditional(AsistenciaMensualAdditional asistenciamensualAdditional) {
		try {
			this.asistenciamensualAdditional=asistenciamensualAdditional;
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
    
	
	public Long getid_cargo() {
		return this.id_cargo;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
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
    
	
	public Double gethoras_trabajo() {
		return this.horas_trabajo;
	}
    
	
	public Double gethoras_atraso() {
		return this.horas_atraso;
	}
    
	
	public Double gethoras_faltas() {
		return this.horas_faltas;
	}
    
	
	public Double gethoras_permiso() {
		return this.horas_permiso;
	}
    
	
	public Double gethoras_extra25() {
		return this.horas_extra25;
	}
    
	
	public Double gethoras_extra50() {
		return this.horas_extra50;
	}
    
	
	public Double gethoras_extra100() {
		return this.horas_extra100;
	}
    
	
	public Double gethoras_extra150() {
		return this.horas_extra150;
	}
    
	
	public Double gethoras_extra0() {
		return this.horas_extra0;
	}
    
	
	public Double gethoras_enfermo() {
		return this.horas_enfermo;
	}
    
	
	public Double gethoras_maternidad() {
		return this.horas_maternidad;
	}
    
	
	public Double gethoras_vacacion() {
		return this.horas_vacacion;
	}
    
	
	public Double getnumero_dias() {
		return this.numero_dias;
	}
    
	
	public Double getnumero_noches() {
		return this.numero_noches;
	}
    
	
	public Double getnumero_feriados() {
		return this.numero_feriados;
	}
    
	
	public Double getnumero_trabajo() {
		return this.numero_trabajo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cargo(Long newid_cargo)throws Exception
	{
		try {
			if(this.id_cargo!=newid_cargo) {
				if(newid_cargo==null) {
					//newid_cargo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna id_cargo");
					}
				}

				this.id_cargo=newid_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_trabajo(Double newhoras_trabajo)throws Exception
	{
		try {
			if(this.horas_trabajo!=newhoras_trabajo) {
				if(newhoras_trabajo==null) {
					//newhoras_trabajo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_trabajo");
					}
				}

				this.horas_trabajo=newhoras_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_atraso(Double newhoras_atraso)throws Exception
	{
		try {
			if(this.horas_atraso!=newhoras_atraso) {
				if(newhoras_atraso==null) {
					//newhoras_atraso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_atraso");
					}
				}

				this.horas_atraso=newhoras_atraso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_faltas(Double newhoras_faltas)throws Exception
	{
		try {
			if(this.horas_faltas!=newhoras_faltas) {
				if(newhoras_faltas==null) {
					//newhoras_faltas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_faltas");
					}
				}

				this.horas_faltas=newhoras_faltas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_permiso(Double newhoras_permiso)throws Exception
	{
		try {
			if(this.horas_permiso!=newhoras_permiso) {
				if(newhoras_permiso==null) {
					//newhoras_permiso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_permiso");
					}
				}

				this.horas_permiso=newhoras_permiso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_extra25(Double newhoras_extra25)throws Exception
	{
		try {
			if(this.horas_extra25!=newhoras_extra25) {
				if(newhoras_extra25==null) {
					//newhoras_extra25=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_extra25");
					}
				}

				this.horas_extra25=newhoras_extra25;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_extra50(Double newhoras_extra50)throws Exception
	{
		try {
			if(this.horas_extra50!=newhoras_extra50) {
				if(newhoras_extra50==null) {
					//newhoras_extra50=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_extra50");
					}
				}

				this.horas_extra50=newhoras_extra50;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_extra100(Double newhoras_extra100)throws Exception
	{
		try {
			if(this.horas_extra100!=newhoras_extra100) {
				if(newhoras_extra100==null) {
					//newhoras_extra100=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_extra100");
					}
				}

				this.horas_extra100=newhoras_extra100;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_extra150(Double newhoras_extra150)throws Exception
	{
		try {
			if(this.horas_extra150!=newhoras_extra150) {
				if(newhoras_extra150==null) {
					//newhoras_extra150=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_extra150");
					}
				}

				this.horas_extra150=newhoras_extra150;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_extra0(Double newhoras_extra0)throws Exception
	{
		try {
			if(this.horas_extra0!=newhoras_extra0) {
				if(newhoras_extra0==null) {
					//newhoras_extra0=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_extra0");
					}
				}

				this.horas_extra0=newhoras_extra0;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_enfermo(Double newhoras_enfermo)throws Exception
	{
		try {
			if(this.horas_enfermo!=newhoras_enfermo) {
				if(newhoras_enfermo==null) {
					//newhoras_enfermo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_enfermo");
					}
				}

				this.horas_enfermo=newhoras_enfermo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_maternidad(Double newhoras_maternidad)throws Exception
	{
		try {
			if(this.horas_maternidad!=newhoras_maternidad) {
				if(newhoras_maternidad==null) {
					//newhoras_maternidad=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_maternidad");
					}
				}

				this.horas_maternidad=newhoras_maternidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_vacacion(Double newhoras_vacacion)throws Exception
	{
		try {
			if(this.horas_vacacion!=newhoras_vacacion) {
				if(newhoras_vacacion==null) {
					//newhoras_vacacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna horas_vacacion");
					}
				}

				this.horas_vacacion=newhoras_vacacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Double newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_noches(Double newnumero_noches)throws Exception
	{
		try {
			if(this.numero_noches!=newnumero_noches) {
				if(newnumero_noches==null) {
					//newnumero_noches=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna numero_noches");
					}
				}

				this.numero_noches=newnumero_noches;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_feriados(Double newnumero_feriados)throws Exception
	{
		try {
			if(this.numero_feriados!=newnumero_feriados) {
				if(newnumero_feriados==null) {
					//newnumero_feriados=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna numero_feriados");
					}
				}

				this.numero_feriados=newnumero_feriados;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_trabajo(Double newnumero_trabajo)throws Exception
	{
		try {
			if(this.numero_trabajo!=newnumero_trabajo) {
				if(newnumero_trabajo==null) {
					//newnumero_trabajo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaMensual:Valor nulo no permitido en columna numero_trabajo");
					}
				}

				this.numero_trabajo=newnumero_trabajo;
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

	public Cargo getCargo() {
		return this.cargo;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getcargo_descripcion() {
		return this.cargo_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setCargo(Cargo cargo) {
		try {
			this.cargo=cargo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setcargo_descripcion(String cargo_descripcion) {
		try {
			this.cargo_descripcion=cargo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_cargo_descripcion="";String id_estructura_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_cargo_descripcion() {
		return id_cargo_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_cargo_descripcion(String newid_cargo_descripcion)throws Exception {
		try {
			this.id_cargo_descripcion=newid_cargo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_cargo_descripcion="";this.id_estructura_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

