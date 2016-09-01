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
//import com.bydan.erp.nomina.util.GastoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class GastoEmpleado extends GastoEmpleadoAdditional implements Serializable ,Cloneable {//GastoEmpleadoAdditional,GeneralEntity
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
	
	private GastoEmpleado gastoempleadoOriginal;
	
	private Map<String, Object> mapGastoEmpleado;
			
	public Map<String, Object> getMapGastoEmpleado() {
		return mapGastoEmpleado;
	}

	public void setMapGastoEmpleado(Map<String, Object> mapGastoEmpleado) {
		this.mapGastoEmpleado = mapGastoEmpleado;
	}
	
	public void inicializarMapGastoEmpleado() {
		this.mapGastoEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapGastoEmpleadoValue(String sKey,Object oValue) {
		this.mapGastoEmpleado.put(sKey, oValue);
	}
	
	public Object getMapGastoEmpleadoValue(String sKey) {
		return this.mapGastoEmpleado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_gasto_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_ingreso_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_ingreso_otro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gasto_vivienda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gasto_educacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gasto_salud;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gasto_vestimenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gasto_alimentacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_gasto_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_gasto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_maximo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_maximo_porcentaje;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Empleado empleado;
	public Ejercicio ejercicio;
	public Pais pais;
	public Ciudad ciudad;
	public Anio anio;
	public Mes mes;
	public Usuario usuario;
	public EstadoGastoEmpleado estadogastoempleado;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String empleado_descripcion;
	private String ejercicio_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String usuario_descripcion;
	private String estadogastoempleado_descripcion;
	
	
		
	public GastoEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.gastoempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_empleado=-1L;
 		this.id_ejercicio=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.dia=0;
 		this.id_usuario=-1L;
 		this.id_estado_gasto_empleado=-1L;
 		this.total_ingreso_actual=0.0;
 		this.total_ingreso_otro=0.0;
 		this.total_ingreso=0.0;
 		this.gasto_vivienda=0.0;
 		this.gasto_educacion=0.0;
 		this.gasto_salud=0.0;
 		this.gasto_vestimenta=0.0;
 		this.gasto_alimentacion=0.0;
 		this.total_gasto_actual=0.0;
 		this.total_gasto=0.0;
 		this.fecha=new Date();
 		this.porcentaje=0.0;
 		this.valor_maximo=0.0;
 		this.valor_maximo_porcentaje=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.empleado=null;
		this.ejercicio=null;
		this.pais=null;
		this.ciudad=null;
		this.anio=null;
		this.mes=null;
		this.usuario=null;
		this.estadogastoempleado=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.empleado_descripcion="";
		this.ejercicio_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.usuario_descripcion="";
		this.estadogastoempleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GastoEmpleado (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_empleado,Long id_ejercicio,Long id_pais,Long id_ciudad,Long id_anio,Long id_mes,Integer dia,Long id_usuario,Long id_estado_gasto_empleado,Double total_ingreso_actual,Double total_ingreso_otro,Double total_ingreso,Double gasto_vivienda,Double gasto_educacion,Double gasto_salud,Double gasto_vestimenta,Double gasto_alimentacion,Double total_gasto_actual,Double total_gasto,Date fecha,Double porcentaje,Double valor_maximo,Double valor_maximo_porcentaje) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.gastoempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado=id_empleado;
 		this.id_ejercicio=id_ejercicio;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.dia=dia;
 		this.id_usuario=id_usuario;
 		this.id_estado_gasto_empleado=id_estado_gasto_empleado;
 		this.total_ingreso_actual=total_ingreso_actual;
 		this.total_ingreso_otro=total_ingreso_otro;
 		this.total_ingreso=total_ingreso;
 		this.gasto_vivienda=gasto_vivienda;
 		this.gasto_educacion=gasto_educacion;
 		this.gasto_salud=gasto_salud;
 		this.gasto_vestimenta=gasto_vestimenta;
 		this.gasto_alimentacion=gasto_alimentacion;
 		this.total_gasto_actual=total_gasto_actual;
 		this.total_gasto=total_gasto;
 		this.fecha=fecha;
 		this.porcentaje=porcentaje;
 		this.valor_maximo=valor_maximo;
 		this.valor_maximo_porcentaje=valor_maximo_porcentaje;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GastoEmpleado (Long id_empresa,Long id_sucursal,Long id_empleado,Long id_ejercicio,Long id_pais,Long id_ciudad,Long id_anio,Long id_mes,Integer dia,Long id_usuario,Long id_estado_gasto_empleado,Double total_ingreso_actual,Double total_ingreso_otro,Double total_ingreso,Double gasto_vivienda,Double gasto_educacion,Double gasto_salud,Double gasto_vestimenta,Double gasto_alimentacion,Double total_gasto_actual,Double total_gasto,Date fecha,Double porcentaje,Double valor_maximo,Double valor_maximo_porcentaje) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.gastoempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado=id_empleado;
 		this.id_ejercicio=id_ejercicio;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.dia=dia;
 		this.id_usuario=id_usuario;
 		this.id_estado_gasto_empleado=id_estado_gasto_empleado;
 		this.total_ingreso_actual=total_ingreso_actual;
 		this.total_ingreso_otro=total_ingreso_otro;
 		this.total_ingreso=total_ingreso;
 		this.gasto_vivienda=gasto_vivienda;
 		this.gasto_educacion=gasto_educacion;
 		this.gasto_salud=gasto_salud;
 		this.gasto_vestimenta=gasto_vestimenta;
 		this.gasto_alimentacion=gasto_alimentacion;
 		this.total_gasto_actual=total_gasto_actual;
 		this.total_gasto=total_gasto;
 		this.fecha=fecha;
 		this.porcentaje=porcentaje;
 		this.valor_maximo=valor_maximo;
 		this.valor_maximo_porcentaje=valor_maximo_porcentaje;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GastoEmpleado gastoempleadoLocal=null;
		
		if(object!=null) {
			gastoempleadoLocal=(GastoEmpleado)object;
			
			if(gastoempleadoLocal!=null) {
				if(this.getId()!=null && gastoempleadoLocal.getId()!=null) {
					if(this.getId().equals(gastoempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GastoEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GastoEmpleadoConstantesFunciones.getGastoEmpleadoDescripcion(this);
		} else {
			sDetalle=GastoEmpleadoConstantesFunciones.getGastoEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GastoEmpleado getGastoEmpleadoOriginal() {
		return this.gastoempleadoOriginal;
	}
	
	public void setGastoEmpleadoOriginal(GastoEmpleado gastoempleado) {
		try {
			this.gastoempleadoOriginal=gastoempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GastoEmpleadoAdditional gastoempleadoAdditional=null;
	
	public GastoEmpleadoAdditional getGastoEmpleadoAdditional() {
		return this.gastoempleadoAdditional;
	}
	
	public void setGastoEmpleadoAdditional(GastoEmpleadoAdditional gastoempleadoAdditional) {
		try {
			this.gastoempleadoAdditional=gastoempleadoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Integer getdia() {
		return this.dia;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_estado_gasto_empleado() {
		return this.id_estado_gasto_empleado;
	}
    
	
	public Double gettotal_ingreso_actual() {
		return this.total_ingreso_actual;
	}
    
	
	public Double gettotal_ingreso_otro() {
		return this.total_ingreso_otro;
	}
    
	
	public Double gettotal_ingreso() {
		return this.total_ingreso;
	}
    
	
	public Double getgasto_vivienda() {
		return this.gasto_vivienda;
	}
    
	
	public Double getgasto_educacion() {
		return this.gasto_educacion;
	}
    
	
	public Double getgasto_salud() {
		return this.gasto_salud;
	}
    
	
	public Double getgasto_vestimenta() {
		return this.gasto_vestimenta;
	}
    
	
	public Double getgasto_alimentacion() {
		return this.gasto_alimentacion;
	}
    
	
	public Double gettotal_gasto_actual() {
		return this.total_gasto_actual;
	}
    
	
	public Double gettotal_gasto() {
		return this.total_gasto;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor_maximo() {
		return this.valor_maximo;
	}
    
	
	public Double getvalor_maximo_porcentaje() {
		return this.valor_maximo_porcentaje;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
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
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
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
    
	public void setdia(Integer newdia)throws Exception
	{
		try {
			if(this.dia!=newdia) {
				if(newdia==null) {
					//newdia=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna dia");
					}
				}

				this.dia=newdia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_gasto_empleado(Long newid_estado_gasto_empleado)throws Exception
	{
		try {
			if(this.id_estado_gasto_empleado!=newid_estado_gasto_empleado) {
				if(newid_estado_gasto_empleado==null) {
					//newid_estado_gasto_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna id_estado_gasto_empleado");
					}
				}

				this.id_estado_gasto_empleado=newid_estado_gasto_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_ingreso_actual(Double newtotal_ingreso_actual)throws Exception
	{
		try {
			if(this.total_ingreso_actual!=newtotal_ingreso_actual) {
				if(newtotal_ingreso_actual==null) {
					//newtotal_ingreso_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna total_ingreso_actual");
					}
				}

				this.total_ingreso_actual=newtotal_ingreso_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_ingreso_otro(Double newtotal_ingreso_otro)throws Exception
	{
		try {
			if(this.total_ingreso_otro!=newtotal_ingreso_otro) {
				if(newtotal_ingreso_otro==null) {
					//newtotal_ingreso_otro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna total_ingreso_otro");
					}
				}

				this.total_ingreso_otro=newtotal_ingreso_otro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_ingreso(Double newtotal_ingreso)throws Exception
	{
		try {
			if(this.total_ingreso!=newtotal_ingreso) {
				if(newtotal_ingreso==null) {
					//newtotal_ingreso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna total_ingreso");
					}
				}

				this.total_ingreso=newtotal_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgasto_vivienda(Double newgasto_vivienda)throws Exception
	{
		try {
			if(this.gasto_vivienda!=newgasto_vivienda) {
				if(newgasto_vivienda==null) {
					//newgasto_vivienda=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna gasto_vivienda");
					}
				}

				this.gasto_vivienda=newgasto_vivienda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgasto_educacion(Double newgasto_educacion)throws Exception
	{
		try {
			if(this.gasto_educacion!=newgasto_educacion) {
				if(newgasto_educacion==null) {
					//newgasto_educacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna gasto_educacion");
					}
				}

				this.gasto_educacion=newgasto_educacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgasto_salud(Double newgasto_salud)throws Exception
	{
		try {
			if(this.gasto_salud!=newgasto_salud) {
				if(newgasto_salud==null) {
					//newgasto_salud=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna gasto_salud");
					}
				}

				this.gasto_salud=newgasto_salud;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgasto_vestimenta(Double newgasto_vestimenta)throws Exception
	{
		try {
			if(this.gasto_vestimenta!=newgasto_vestimenta) {
				if(newgasto_vestimenta==null) {
					//newgasto_vestimenta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna gasto_vestimenta");
					}
				}

				this.gasto_vestimenta=newgasto_vestimenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgasto_alimentacion(Double newgasto_alimentacion)throws Exception
	{
		try {
			if(this.gasto_alimentacion!=newgasto_alimentacion) {
				if(newgasto_alimentacion==null) {
					//newgasto_alimentacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna gasto_alimentacion");
					}
				}

				this.gasto_alimentacion=newgasto_alimentacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_gasto_actual(Double newtotal_gasto_actual)throws Exception
	{
		try {
			if(this.total_gasto_actual!=newtotal_gasto_actual) {
				if(newtotal_gasto_actual==null) {
					//newtotal_gasto_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna total_gasto_actual");
					}
				}

				this.total_gasto_actual=newtotal_gasto_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_gasto(Double newtotal_gasto)throws Exception
	{
		try {
			if(this.total_gasto!=newtotal_gasto) {
				if(newtotal_gasto==null) {
					//newtotal_gasto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna total_gasto");
					}
				}

				this.total_gasto=newtotal_gasto;
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
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_maximo(Double newvalor_maximo)throws Exception
	{
		try {
			if(this.valor_maximo!=newvalor_maximo) {
				if(newvalor_maximo==null) {
					//newvalor_maximo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna valor_maximo");
					}
				}

				this.valor_maximo=newvalor_maximo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_maximo_porcentaje(Double newvalor_maximo_porcentaje)throws Exception
	{
		try {
			if(this.valor_maximo_porcentaje!=newvalor_maximo_porcentaje) {
				if(newvalor_maximo_porcentaje==null) {
					//newvalor_maximo_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GastoEmpleado:Valor nulo no permitido en columna valor_maximo_porcentaje");
					}
				}

				this.valor_maximo_porcentaje=newvalor_maximo_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public EstadoGastoEmpleado getEstadoGastoEmpleado() {
		return this.estadogastoempleado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getestadogastoempleado_descripcion() {
		return this.estadogastoempleado_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
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


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoGastoEmpleado(EstadoGastoEmpleado estadogastoempleado) {
		try {
			this.estadogastoempleado=estadogastoempleado;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
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


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadogastoempleado_descripcion(String estadogastoempleado_descripcion) {
		try {
			this.estadogastoempleado_descripcion=estadogastoempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_empleado_descripcion="";String id_ejercicio_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_usuario_descripcion="";String id_estado_gasto_empleado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_estado_gasto_empleado_descripcion() {
		return id_estado_gasto_empleado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
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
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_gasto_empleado_descripcion(String newid_estado_gasto_empleado_descripcion)throws Exception {
		try {
			this.id_estado_gasto_empleado_descripcion=newid_estado_gasto_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_empleado_descripcion="";this.id_ejercicio_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_usuario_descripcion="";this.id_estado_gasto_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

