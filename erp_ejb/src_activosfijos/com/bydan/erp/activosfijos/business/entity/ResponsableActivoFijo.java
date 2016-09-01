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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.ResponsableActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class ResponsableActivoFijo extends ResponsableActivoFijoAdditional implements Serializable ,Cloneable {//ResponsableActivoFijoAdditional,GeneralEntity
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
	
	private ResponsableActivoFijo responsableactivofijoOriginal;
	
	private Map<String, Object> mapResponsableActivoFijo;
			
	public Map<String, Object> getMapResponsableActivoFijo() {
		return mapResponsableActivoFijo;
	}

	public void setMapResponsableActivoFijo(Map<String, Object> mapResponsableActivoFijo) {
		this.mapResponsableActivoFijo = mapResponsableActivoFijo;
	}
	
	public void inicializarMapResponsableActivoFijo() {
		this.mapResponsableActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapResponsableActivoFijoValue(String sKey,Object oValue) {
		this.mapResponsableActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapResponsableActivoFijoValue(String sKey) {
		return this.mapResponsableActivoFijo.get(sKey);
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
	private Long id_detalle_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ResponsableActivoFijoConstantesFunciones.SREGEXUBICACION,message=ResponsableActivoFijoConstantesFunciones.SMENSAJEREGEXUBICACION)
	private String ubicacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ResponsableActivoFijoConstantesFunciones.SREGEXDESCRIPCION,message=ResponsableActivoFijoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleActivoFijo detalleactivofijo;
	public Estructura estructura;
	public Empleado empleado;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detalleactivofijo_descripcion;
	private String estructura_descripcion;
	private String empleado_descripcion;
	
	
		
	public ResponsableActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.responsableactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_activo_fijo=-1L;
 		this.id_estructura=-1L;
 		this.id_empleado=-1L;
 		this.ubicacion="";
 		this.fecha=new Date();
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detalleactivofijo=null;
		this.estructura=null;
		this.empleado=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detalleactivofijo_descripcion="";
		this.estructura_descripcion="";
		this.empleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ResponsableActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_estructura,Long id_empleado,String ubicacion,Date fecha,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.responsableactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.ubicacion=ubicacion;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ResponsableActivoFijo (Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_estructura,Long id_empleado,String ubicacion,Date fecha,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.responsableactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.ubicacion=ubicacion;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ResponsableActivoFijo responsableactivofijoLocal=null;
		
		if(object!=null) {
			responsableactivofijoLocal=(ResponsableActivoFijo)object;
			
			if(responsableactivofijoLocal!=null) {
				if(this.getId()!=null && responsableactivofijoLocal.getId()!=null) {
					if(this.getId().equals(responsableactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ResponsableActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ResponsableActivoFijoConstantesFunciones.getResponsableActivoFijoDescripcion(this);
		} else {
			sDetalle=ResponsableActivoFijoConstantesFunciones.getResponsableActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ResponsableActivoFijo getResponsableActivoFijoOriginal() {
		return this.responsableactivofijoOriginal;
	}
	
	public void setResponsableActivoFijoOriginal(ResponsableActivoFijo responsableactivofijo) {
		try {
			this.responsableactivofijoOriginal=responsableactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ResponsableActivoFijoAdditional responsableactivofijoAdditional=null;
	
	public ResponsableActivoFijoAdditional getResponsableActivoFijoAdditional() {
		return this.responsableactivofijoAdditional;
	}
	
	public void setResponsableActivoFijoAdditional(ResponsableActivoFijoAdditional responsableactivofijoAdditional) {
		try {
			this.responsableactivofijoAdditional=responsableactivofijoAdditional;
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
    
	
	public Long getid_detalle_activo_fijo() {
		return this.id_detalle_activo_fijo;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public String getubicacion() {
		return this.ubicacion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo(Long newid_detalle_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_activo_fijo!=newid_detalle_activo_fijo) {
				if(newid_detalle_activo_fijo==null) {
					//newid_detalle_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna id_detalle_activo_fijo");
					}
				}

				this.id_detalle_activo_fijo=newid_detalle_activo_fijo;
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setubicacion(String newubicacion)throws Exception
	{
		try {
			if(this.ubicacion!=newubicacion) {
				if(newubicacion==null) {
					//newubicacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna ubicacion");
					}
				}

				if(newubicacion!=null&&newubicacion.length()>100) {
					newubicacion=newubicacion.substring(0,98);
					System.out.println("ResponsableActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna ubicacion");
				}

				this.ubicacion=newubicacion;
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("ResponsableActivoFijo:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("ResponsableActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public DetalleActivoFijo getDetalleActivoFijo() {
		return this.detalleactivofijo;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getdetalleactivofijo_descripcion() {
		return this.detalleactivofijo_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
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


	public  void  setDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) {
		try {
			this.detalleactivofijo=detalleactivofijo;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	public  void  setdetalleactivofijo_descripcion(String detalleactivofijo_descripcion) {
		try {
			this.detalleactivofijo_descripcion=detalleactivofijo_descripcion;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_activo_fijo_descripcion="";String id_estructura_descripcion="";String id_empleado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_activo_fijo_descripcion() {
		return id_detalle_activo_fijo_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
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
	public void setid_detalle_activo_fijo_descripcion(String newid_detalle_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_activo_fijo_descripcion=newid_detalle_activo_fijo_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_activo_fijo_descripcion="";this.id_estructura_descripcion="";this.id_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

