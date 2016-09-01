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
//import com.bydan.erp.nomina.util.VacacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VacacionEmpleado extends VacacionEmpleadoAdditional implements Serializable ,Cloneable {//VacacionEmpleadoAdditional,GeneralEntity
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
	
	private VacacionEmpleado vacacionempleadoOriginal;
	
	private Map<String, Object> mapVacacionEmpleado;
			
	public Map<String, Object> getMapVacacionEmpleado() {
		return mapVacacionEmpleado;
	}

	public void setMapVacacionEmpleado(Map<String, Object> mapVacacionEmpleado) {
		this.mapVacacionEmpleado = mapVacacionEmpleado;
	}
	
	public void inicializarMapVacacionEmpleado() {
		this.mapVacacionEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapVacacionEmpleadoValue(String sKey,Object oValue) {
		this.mapVacacionEmpleado.put(sKey, oValue);
	}
	
	public Object getMapVacacionEmpleadoValue(String sKey) {
		return this.mapVacacionEmpleado.get(sKey);
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
	private Long id_anio_periodo1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio_periodo2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_veces;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_estimada;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_vacaciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_tomados;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_pagados;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_adicionales;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Anio anioperiodo1;
	public Anio anioperiodo2;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String anioperiodo1_descripcion;
	private String anioperiodo2_descripcion;
	
	
		
	public VacacionEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.vacacionempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_anio_periodo1=-1L;
 		this.id_anio_periodo2=-1L;
 		this.numero_veces=0;
 		this.fecha_estimada=new Date();
 		this.horas_vacaciones=0.0;
 		this.horas_tomados=0.0;
 		this.horas_pagados=0.0;
 		this.horas_adicionales=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.anioperiodo1=null;
		this.anioperiodo2=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.anioperiodo1_descripcion="";
		this.anioperiodo2_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VacacionEmpleado (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_anio_periodo1,Long id_anio_periodo2,Integer numero_veces,Date fecha_estimada,Double horas_vacaciones,Double horas_tomados,Double horas_pagados,Double horas_adicionales) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vacacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio_periodo1=id_anio_periodo1;
 		this.id_anio_periodo2=id_anio_periodo2;
 		this.numero_veces=numero_veces;
 		this.fecha_estimada=fecha_estimada;
 		this.horas_vacaciones=horas_vacaciones;
 		this.horas_tomados=horas_tomados;
 		this.horas_pagados=horas_pagados;
 		this.horas_adicionales=horas_adicionales;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VacacionEmpleado (Long id_empresa,Long id_empleado,Long id_anio_periodo1,Long id_anio_periodo2,Integer numero_veces,Date fecha_estimada,Double horas_vacaciones,Double horas_tomados,Double horas_pagados,Double horas_adicionales) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vacacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio_periodo1=id_anio_periodo1;
 		this.id_anio_periodo2=id_anio_periodo2;
 		this.numero_veces=numero_veces;
 		this.fecha_estimada=fecha_estimada;
 		this.horas_vacaciones=horas_vacaciones;
 		this.horas_tomados=horas_tomados;
 		this.horas_pagados=horas_pagados;
 		this.horas_adicionales=horas_adicionales;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		VacacionEmpleado vacacionempleadoLocal=null;
		
		if(object!=null) {
			vacacionempleadoLocal=(VacacionEmpleado)object;
			
			if(vacacionempleadoLocal!=null) {
				if(this.getId()!=null && vacacionempleadoLocal.getId()!=null) {
					if(this.getId().equals(vacacionempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VacacionEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VacacionEmpleadoConstantesFunciones.getVacacionEmpleadoDescripcion(this);
		} else {
			sDetalle=VacacionEmpleadoConstantesFunciones.getVacacionEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public VacacionEmpleado getVacacionEmpleadoOriginal() {
		return this.vacacionempleadoOriginal;
	}
	
	public void setVacacionEmpleadoOriginal(VacacionEmpleado vacacionempleado) {
		try {
			this.vacacionempleadoOriginal=vacacionempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VacacionEmpleadoAdditional vacacionempleadoAdditional=null;
	
	public VacacionEmpleadoAdditional getVacacionEmpleadoAdditional() {
		return this.vacacionempleadoAdditional;
	}
	
	public void setVacacionEmpleadoAdditional(VacacionEmpleadoAdditional vacacionempleadoAdditional) {
		try {
			this.vacacionempleadoAdditional=vacacionempleadoAdditional;
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
    
	
	public Long getid_anio_periodo1() {
		return this.id_anio_periodo1;
	}
    
	
	public Long getid_anio_periodo2() {
		return this.id_anio_periodo2;
	}
    
	
	public Integer getnumero_veces() {
		return this.numero_veces;
	}
    
	
	public Date getfecha_estimada() {
		return this.fecha_estimada;
	}
    
	
	public Double gethoras_vacaciones() {
		return this.horas_vacaciones;
	}
    
	
	public Double gethoras_tomados() {
		return this.horas_tomados;
	}
    
	
	public Double gethoras_pagados() {
		return this.horas_pagados;
	}
    
	
	public Double gethoras_adicionales() {
		return this.horas_adicionales;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio_periodo1(Long newid_anio_periodo1)throws Exception
	{
		try {
			if(this.id_anio_periodo1!=newid_anio_periodo1) {
				if(newid_anio_periodo1==null) {
					//newid_anio_periodo1=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna id_anio_periodo1");
					}
				}

				this.id_anio_periodo1=newid_anio_periodo1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio_periodo2(Long newid_anio_periodo2)throws Exception
	{
		try {
			if(this.id_anio_periodo2!=newid_anio_periodo2) {
				if(newid_anio_periodo2==null) {
					//newid_anio_periodo2=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna id_anio_periodo2");
					}
				}

				this.id_anio_periodo2=newid_anio_periodo2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_veces(Integer newnumero_veces)throws Exception
	{
		try {
			if(this.numero_veces!=newnumero_veces) {
				if(newnumero_veces==null) {
					//newnumero_veces=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna numero_veces");
					}
				}

				this.numero_veces=newnumero_veces;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_estimada(Date newfecha_estimada)throws Exception
	{
		try {
			if(this.fecha_estimada!=newfecha_estimada) {
				if(newfecha_estimada==null) {
					//newfecha_estimada=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna fecha_estimada");
					}
				}

				this.fecha_estimada=newfecha_estimada;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_vacaciones(Double newhoras_vacaciones)throws Exception
	{
		try {
			if(this.horas_vacaciones!=newhoras_vacaciones) {
				if(newhoras_vacaciones==null) {
					//newhoras_vacaciones=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna horas_vacaciones");
					}
				}

				this.horas_vacaciones=newhoras_vacaciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_tomados(Double newhoras_tomados)throws Exception
	{
		try {
			if(this.horas_tomados!=newhoras_tomados) {
				if(newhoras_tomados==null) {
					//newhoras_tomados=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna horas_tomados");
					}
				}

				this.horas_tomados=newhoras_tomados;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_pagados(Double newhoras_pagados)throws Exception
	{
		try {
			if(this.horas_pagados!=newhoras_pagados) {
				if(newhoras_pagados==null) {
					//newhoras_pagados=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna horas_pagados");
					}
				}

				this.horas_pagados=newhoras_pagados;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_adicionales(Double newhoras_adicionales)throws Exception
	{
		try {
			if(this.horas_adicionales!=newhoras_adicionales) {
				if(newhoras_adicionales==null) {
					//newhoras_adicionales=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VacacionEmpleado:Valor nulo no permitido en columna horas_adicionales");
					}
				}

				this.horas_adicionales=newhoras_adicionales;
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

	public Anio getAnioPeriodo1() {
		return this.anioperiodo1;
	}

	public Anio getAnioPeriodo2() {
		return this.anioperiodo2;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getanioperiodo1_descripcion() {
		return this.anioperiodo1_descripcion;
	}

	public String getanioperiodo2_descripcion() {
		return this.anioperiodo2_descripcion;
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


	public  void  setAnioPeriodo1(Anio anioperiodo1) {
		try {
			this.anioperiodo1=anioperiodo1;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnioPeriodo2(Anio anioperiodo2) {
		try {
			this.anioperiodo2=anioperiodo2;
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


	public  void  setanioperiodo1_descripcion(String anioperiodo1_descripcion) {
		try {
			this.anioperiodo1_descripcion=anioperiodo1_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanioperiodo2_descripcion(String anioperiodo2_descripcion) {
		try {
			this.anioperiodo2_descripcion=anioperiodo2_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_anio_periodo1_descripcion="";String id_anio_periodo2_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_anio_periodo1_descripcion() {
		return id_anio_periodo1_descripcion;
	}
	public String getid_anio_periodo2_descripcion() {
		return id_anio_periodo2_descripcion;
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
	public void setid_anio_periodo1_descripcion(String newid_anio_periodo1_descripcion)throws Exception {
		try {
			this.id_anio_periodo1_descripcion=newid_anio_periodo1_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_periodo2_descripcion(String newid_anio_periodo2_descripcion)throws Exception {
		try {
			this.id_anio_periodo2_descripcion=newid_anio_periodo2_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_anio_periodo1_descripcion="";this.id_anio_periodo2_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

