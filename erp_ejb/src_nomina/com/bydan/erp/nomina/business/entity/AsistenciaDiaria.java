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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.nomina.util.AsistenciaDiariaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class AsistenciaDiaria extends AsistenciaDiariaAdditional implements Serializable ,Cloneable {//AsistenciaDiariaAdditional,GeneralEntity
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
	
	private AsistenciaDiaria asistenciadiariaOriginal;
	
	private Map<String, Object> mapAsistenciaDiaria;
			
	public Map<String, Object> getMapAsistenciaDiaria() {
		return mapAsistenciaDiaria;
	}

	public void setMapAsistenciaDiaria(Map<String, Object> mapAsistenciaDiaria) {
		this.mapAsistenciaDiaria = mapAsistenciaDiaria;
	}
	
	public void inicializarMapAsistenciaDiaria() {
		this.mapAsistenciaDiaria = new HashMap<String,Object>();
	}
	
	public void setMapAsistenciaDiariaValue(String sKey,Object oValue) {
		this.mapAsistenciaDiaria.put(sKey, oValue);
	}
	
	public Object getMapAsistenciaDiariaValue(String sKey) {
		return this.mapAsistenciaDiaria.get(sKey);
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura_seccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_atraso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double horas_falta;
	
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AsistenciaDiariaConstantesFunciones.SREGEXDESCRIPCION,message=AsistenciaDiariaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Estructura estructura;
	public Estructura estructuraseccion;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String estructura_descripcion;
	private String estructuraseccion_descripcion;
	
	
		
	public AsistenciaDiaria () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.asistenciadiariaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_estructura=-1L;
 		this.id_estructura_seccion=-1L;
 		this.fecha=new Date();
 		this.hora=new Time((new Date()).getTime());
 		this.horas_atraso=0.0;
 		this.horas_falta=0.0;
 		this.horas_permiso=0.0;
 		this.horas_extra25=0.0;
 		this.horas_extra50=0.0;
 		this.horas_extra100=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.estructura=null;
		this.estructuraseccion=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.estructura_descripcion="";
		this.estructuraseccion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AsistenciaDiaria (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_estructura,Long id_estructura_seccion,Date fecha,Time hora,Double horas_atraso,Double horas_falta,Double horas_permiso,Double horas_extra25,Double horas_extra50,Double horas_extra100,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciadiariaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.horas_atraso=horas_atraso;
 		this.horas_falta=horas_falta;
 		this.horas_permiso=horas_permiso;
 		this.horas_extra25=horas_extra25;
 		this.horas_extra50=horas_extra50;
 		this.horas_extra100=horas_extra100;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AsistenciaDiaria (Long id_empresa,Long id_empleado,Long id_estructura,Long id_estructura_seccion,Date fecha,Time hora,Double horas_atraso,Double horas_falta,Double horas_permiso,Double horas_extra25,Double horas_extra50,Double horas_extra100,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciadiariaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.horas_atraso=horas_atraso;
 		this.horas_falta=horas_falta;
 		this.horas_permiso=horas_permiso;
 		this.horas_extra25=horas_extra25;
 		this.horas_extra50=horas_extra50;
 		this.horas_extra100=horas_extra100;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AsistenciaDiaria asistenciadiariaLocal=null;
		
		if(object!=null) {
			asistenciadiariaLocal=(AsistenciaDiaria)object;
			
			if(asistenciadiariaLocal!=null) {
				if(this.getId()!=null && asistenciadiariaLocal.getId()!=null) {
					if(this.getId().equals(asistenciadiariaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AsistenciaDiariaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AsistenciaDiariaConstantesFunciones.getAsistenciaDiariaDescripcion(this);
		} else {
			sDetalle=AsistenciaDiariaConstantesFunciones.getAsistenciaDiariaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AsistenciaDiaria getAsistenciaDiariaOriginal() {
		return this.asistenciadiariaOriginal;
	}
	
	public void setAsistenciaDiariaOriginal(AsistenciaDiaria asistenciadiaria) {
		try {
			this.asistenciadiariaOriginal=asistenciadiaria;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AsistenciaDiariaAdditional asistenciadiariaAdditional=null;
	
	public AsistenciaDiariaAdditional getAsistenciaDiariaAdditional() {
		return this.asistenciadiariaAdditional;
	}
	
	public void setAsistenciaDiariaAdditional(AsistenciaDiariaAdditional asistenciadiariaAdditional) {
		try {
			this.asistenciadiariaAdditional=asistenciadiariaAdditional;
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
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_estructura_seccion() {
		return this.id_estructura_seccion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
    
	
	public Double gethoras_atraso() {
		return this.horas_atraso;
	}
    
	
	public Double gethoras_falta() {
		return this.horas_falta;
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
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura_seccion(Long newid_estructura_seccion)throws Exception
	{
		try {
			if(this.id_estructura_seccion!=newid_estructura_seccion) {
				if(newid_estructura_seccion==null) {
					//newid_estructura_seccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna id_estructura_seccion");
					}
				}

				this.id_estructura_seccion=newid_estructura_seccion;
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_atraso");
					}
				}

				this.horas_atraso=newhoras_atraso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethoras_falta(Double newhoras_falta)throws Exception
	{
		try {
			if(this.horas_falta!=newhoras_falta) {
				if(newhoras_falta==null) {
					//newhoras_falta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_falta");
					}
				}

				this.horas_falta=newhoras_falta;
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_permiso");
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_extra25");
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_extra50");
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
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna horas_extra100");
					}
				}

				this.horas_extra100=newhoras_extra100;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaDiaria:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>50) {
					newdescripcion=newdescripcion.substring(0,48);
					System.out.println("AsistenciaDiaria:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Estructura getEstructuraSeccion() {
		return this.estructuraseccion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getestructuraseccion_descripcion() {
		return this.estructuraseccion_descripcion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructuraSeccion(Estructura estructuraseccion) {
		try {
			this.estructuraseccion=estructuraseccion;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructuraseccion_descripcion(String estructuraseccion_descripcion) {
		try {
			this.estructuraseccion_descripcion=estructuraseccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_estructura_descripcion="";String id_estructura_seccion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_estructura_seccion_descripcion() {
		return id_estructura_seccion_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_seccion_descripcion(String newid_estructura_seccion_descripcion)throws Exception {
		try {
			this.id_estructura_seccion_descripcion=newid_estructura_seccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_estructura_descripcion="";this.id_estructura_seccion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

