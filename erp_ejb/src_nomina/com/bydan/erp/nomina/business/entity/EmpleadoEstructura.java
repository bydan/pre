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
//import com.bydan.erp.nomina.util.EmpleadoEstructuraConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoEstructura extends EmpleadoEstructuraAdditional implements Serializable ,Cloneable {//EmpleadoEstructuraAdditional,GeneralEntity
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
	
	private EmpleadoEstructura empleadoestructuraOriginal;
	
	private Map<String, Object> mapEmpleadoEstructura;
			
	public Map<String, Object> getMapEmpleadoEstructura() {
		return mapEmpleadoEstructura;
	}

	public void setMapEmpleadoEstructura(Map<String, Object> mapEmpleadoEstructura) {
		this.mapEmpleadoEstructura = mapEmpleadoEstructura;
	}
	
	public void inicializarMapEmpleadoEstructura() {
		this.mapEmpleadoEstructura = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoEstructuraValue(String sKey,Object oValue) {
		this.mapEmpleadoEstructura.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoEstructuraValue(String sKey) {
		return this.mapEmpleadoEstructura.get(sKey);
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_salida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_reingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoEstructuraConstantesFunciones.SREGEXDESCRIPCION,message=EmpleadoEstructuraConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Empleado empleado;
	public Estructura estructura;
	public Cargo cargo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String empleado_descripcion;
	private String estructura_descripcion;
	private String cargo_descripcion;
	
	
		
	public EmpleadoEstructura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadoestructuraOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_empleado=-1L;
 		this.id_estructura=-1L;
 		this.id_cargo=-1L;
 		this.fecha_ingreso=new Date();
 		this.fecha_salida=new Date();
 		this.numero_reingreso=0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.empleado=null;
		this.estructura=null;
		this.cargo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.empleado_descripcion="";
		this.estructura_descripcion="";
		this.cargo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoEstructura (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_empleado,Long id_estructura,Long id_cargo,Date fecha_ingreso,Date fecha_salida,Integer numero_reingreso,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoestructuraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_cargo=id_cargo;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_salida=fecha_salida;
 		this.numero_reingreso=numero_reingreso;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoEstructura (Long id_empresa,Long id_sucursal,Long id_empleado,Long id_estructura,Long id_cargo,Date fecha_ingreso,Date fecha_salida,Integer numero_reingreso,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoestructuraOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_cargo=id_cargo;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_salida=fecha_salida;
 		this.numero_reingreso=numero_reingreso;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoEstructura empleadoestructuraLocal=null;
		
		if(object!=null) {
			empleadoestructuraLocal=(EmpleadoEstructura)object;
			
			if(empleadoestructuraLocal!=null) {
				if(this.getId()!=null && empleadoestructuraLocal.getId()!=null) {
					if(this.getId().equals(empleadoestructuraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoEstructuraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoEstructuraConstantesFunciones.getEmpleadoEstructuraDescripcion(this);
		} else {
			sDetalle=EmpleadoEstructuraConstantesFunciones.getEmpleadoEstructuraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoEstructura getEmpleadoEstructuraOriginal() {
		return this.empleadoestructuraOriginal;
	}
	
	public void setEmpleadoEstructuraOriginal(EmpleadoEstructura empleadoestructura) {
		try {
			this.empleadoestructuraOriginal=empleadoestructura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoEstructuraAdditional empleadoestructuraAdditional=null;
	
	public EmpleadoEstructuraAdditional getEmpleadoEstructuraAdditional() {
		return this.empleadoestructuraAdditional;
	}
	
	public void setEmpleadoEstructuraAdditional(EmpleadoEstructuraAdditional empleadoestructuraAdditional) {
		try {
			this.empleadoestructuraAdditional=empleadoestructuraAdditional;
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
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_cargo() {
		return this.id_cargo;
	}
    
	
	public Date getfecha_ingreso() {
		return this.fecha_ingreso;
	}
    
	
	public Date getfecha_salida() {
		return this.fecha_salida;
	}
    
	
	public Integer getnumero_reingreso() {
		return this.numero_reingreso;
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna id_empleado");
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna id_cargo");
					}
				}

				this.id_cargo=newid_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ingreso(Date newfecha_ingreso)throws Exception
	{
		try {
			if(this.fecha_ingreso!=newfecha_ingreso) {
				if(newfecha_ingreso==null) {
					//newfecha_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna fecha_ingreso");
					}
				}

				this.fecha_ingreso=newfecha_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_salida(Date newfecha_salida)throws Exception
	{
		try {
			if(this.fecha_salida!=newfecha_salida) {
				if(newfecha_salida==null) {
					//newfecha_salida=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna fecha_salida");
					}
				}

				this.fecha_salida=newfecha_salida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_reingreso(Integer newnumero_reingreso)throws Exception
	{
		try {
			if(this.numero_reingreso!=newnumero_reingreso) {
				if(newnumero_reingreso==null) {
					//newnumero_reingreso=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna numero_reingreso");
					}
				}

				this.numero_reingreso=newnumero_reingreso;
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
						System.out.println("EmpleadoEstructura:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("EmpleadoEstructura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Cargo getCargo() {
		return this.cargo;
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

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getcargo_descripcion() {
		return this.cargo_descripcion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_empleado_descripcion="";String id_estructura_descripcion="";String id_cargo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_cargo_descripcion() {
		return id_cargo_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_empleado_descripcion="";this.id_estructura_descripcion="";this.id_cargo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

