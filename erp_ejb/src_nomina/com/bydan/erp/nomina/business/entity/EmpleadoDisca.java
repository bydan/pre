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
//import com.bydan.erp.nomina.util.EmpleadoDiscaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoDisca extends EmpleadoDiscaAdditional implements Serializable ,Cloneable {//EmpleadoDiscaAdditional,GeneralEntity
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
	
	private EmpleadoDisca empleadodiscaOriginal;
	
	private Map<String, Object> mapEmpleadoDisca;
			
	public Map<String, Object> getMapEmpleadoDisca() {
		return mapEmpleadoDisca;
	}

	public void setMapEmpleadoDisca(Map<String, Object> mapEmpleadoDisca) {
		this.mapEmpleadoDisca = mapEmpleadoDisca;
	}
	
	public void inicializarMapEmpleadoDisca() {
		this.mapEmpleadoDisca = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoDiscaValue(String sKey,Object oValue) {
		this.mapEmpleadoDisca.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoDiscaValue(String sKey) {
		return this.mapEmpleadoDisca.get(sKey);
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
	private Long id_tipo_discapacidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoDiscaConstantesFunciones.SREGEXDESCRIPCION,message=EmpleadoDiscaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public TipoDiscapacidad tipodiscapacidad;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String tipodiscapacidad_descripcion;
	
	
		
	public EmpleadoDisca () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadodiscaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_tipo_discapacidad=-1L;
 		this.porcentaje_inicial=0.0;
 		this.porcentaje_final=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.tipodiscapacidad=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.tipodiscapacidad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoDisca (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_tipo_discapacidad,Double porcentaje_inicial,Double porcentaje_final,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadodiscaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_discapacidad=id_tipo_discapacidad;
 		this.porcentaje_inicial=porcentaje_inicial;
 		this.porcentaje_final=porcentaje_final;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoDisca (Long id_empresa,Long id_empleado,Long id_tipo_discapacidad,Double porcentaje_inicial,Double porcentaje_final,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadodiscaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_tipo_discapacidad=id_tipo_discapacidad;
 		this.porcentaje_inicial=porcentaje_inicial;
 		this.porcentaje_final=porcentaje_final;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoDisca empleadodiscaLocal=null;
		
		if(object!=null) {
			empleadodiscaLocal=(EmpleadoDisca)object;
			
			if(empleadodiscaLocal!=null) {
				if(this.getId()!=null && empleadodiscaLocal.getId()!=null) {
					if(this.getId().equals(empleadodiscaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoDiscaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoDiscaConstantesFunciones.getEmpleadoDiscaDescripcion(this);
		} else {
			sDetalle=EmpleadoDiscaConstantesFunciones.getEmpleadoDiscaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoDisca getEmpleadoDiscaOriginal() {
		return this.empleadodiscaOriginal;
	}
	
	public void setEmpleadoDiscaOriginal(EmpleadoDisca empleadodisca) {
		try {
			this.empleadodiscaOriginal=empleadodisca;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoDiscaAdditional empleadodiscaAdditional=null;
	
	public EmpleadoDiscaAdditional getEmpleadoDiscaAdditional() {
		return this.empleadodiscaAdditional;
	}
	
	public void setEmpleadoDiscaAdditional(EmpleadoDiscaAdditional empleadodiscaAdditional) {
		try {
			this.empleadodiscaAdditional=empleadodiscaAdditional;
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
    
	
	public Long getid_tipo_discapacidad() {
		return this.id_tipo_discapacidad;
	}
    
	
	public Double getporcentaje_inicial() {
		return this.porcentaje_inicial;
	}
    
	
	public Double getporcentaje_final() {
		return this.porcentaje_final;
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
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_discapacidad(Long newid_tipo_discapacidad)throws Exception
	{
		try {
			if(this.id_tipo_discapacidad!=newid_tipo_discapacidad) {
				if(newid_tipo_discapacidad==null) {
					//newid_tipo_discapacidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna id_tipo_discapacidad");
					}
				}

				this.id_tipo_discapacidad=newid_tipo_discapacidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_inicial(Double newporcentaje_inicial)throws Exception
	{
		try {
			if(this.porcentaje_inicial!=newporcentaje_inicial) {
				if(newporcentaje_inicial==null) {
					//newporcentaje_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna porcentaje_inicial");
					}
				}

				this.porcentaje_inicial=newporcentaje_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_final(Double newporcentaje_final)throws Exception
	{
		try {
			if(this.porcentaje_final!=newporcentaje_final) {
				if(newporcentaje_final==null) {
					//newporcentaje_final=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna porcentaje_final");
					}
				}

				this.porcentaje_final=newporcentaje_final;
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
						System.out.println("EmpleadoDisca:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("EmpleadoDisca:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public TipoDiscapacidad getTipoDiscapacidad() {
		return this.tipodiscapacidad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String gettipodiscapacidad_descripcion() {
		return this.tipodiscapacidad_descripcion;
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


	public  void  setTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad) {
		try {
			this.tipodiscapacidad=tipodiscapacidad;
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


	public  void  settipodiscapacidad_descripcion(String tipodiscapacidad_descripcion) {
		try {
			this.tipodiscapacidad_descripcion=tipodiscapacidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_tipo_discapacidad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_tipo_discapacidad_descripcion() {
		return id_tipo_discapacidad_descripcion;
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
	public void setid_tipo_discapacidad_descripcion(String newid_tipo_discapacidad_descripcion)throws Exception {
		try {
			this.id_tipo_discapacidad_descripcion=newid_tipo_discapacidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_tipo_discapacidad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

