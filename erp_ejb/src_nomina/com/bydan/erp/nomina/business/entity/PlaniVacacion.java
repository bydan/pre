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
//import com.bydan.erp.nomina.util.PlaniVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PlaniVacacion extends PlaniVacacionAdditional implements Serializable ,Cloneable {//PlaniVacacionAdditional,GeneralEntity
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
	
	private PlaniVacacion planivacacionOriginal;
	
	private Map<String, Object> mapPlaniVacacion;
			
	public Map<String, Object> getMapPlaniVacacion() {
		return mapPlaniVacacion;
	}

	public void setMapPlaniVacacion(Map<String, Object> mapPlaniVacacion) {
		this.mapPlaniVacacion = mapPlaniVacacion;
	}
	
	public void inicializarMapPlaniVacacion() {
		this.mapPlaniVacacion = new HashMap<String,Object>();
	}
	
	public void setMapPlaniVacacionValue(String sKey,Object oValue) {
		this.mapPlaniVacacion.put(sKey, oValue);
	}
	
	public Object getMapPlaniVacacionValue(String sKey) {
		return this.mapPlaniVacacion.get(sKey);
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura_seccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_realizadas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_pendiente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_tomados;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_anticipadas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlaniVacacionConstantesFunciones.SREGEXDESCRIPCION,message=PlaniVacacionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Estructura estructura;
	public Estructura estructuraseccion;
	public Estructura estructuracargo;
	public Empleado empleado;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String estructura_descripcion;
	private String estructuraseccion_descripcion;
	private String estructuracargo_descripcion;
	private String empleado_descripcion;
	private String mes_descripcion;
	
	
		
	public PlaniVacacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.planivacacionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_estructura=-1L;
 		this.id_estructura_seccion=-1L;
 		this.id_estructura_cargo=-1L;
 		this.id_empleado=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.id_mes=null;
 		this.dias_anio=0.0;
 		this.dias_realizadas=0.0;
 		this.dias_pendiente=0.0;
 		this.dias_tomados=0.0;
 		this.dias_anticipadas=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.estructura=null;
		this.estructuraseccion=null;
		this.estructuracargo=null;
		this.empleado=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.estructura_descripcion="";
		this.estructuraseccion_descripcion="";
		this.estructuracargo_descripcion="";
		this.empleado_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PlaniVacacion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_estructura,Long id_estructura_seccion,Long id_estructura_cargo,Long id_empleado,Date fecha_inicio,Date fecha_fin,Long id_mes,Double dias_anio,Double dias_realizadas,Double dias_pendiente,Double dias_tomados,Double dias_anticipadas,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planivacacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.id_estructura_cargo=id_estructura_cargo;
 		this.id_empleado=id_empleado;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.id_mes=id_mes;
 		this.dias_anio=dias_anio;
 		this.dias_realizadas=dias_realizadas;
 		this.dias_pendiente=dias_pendiente;
 		this.dias_tomados=dias_tomados;
 		this.dias_anticipadas=dias_anticipadas;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PlaniVacacion (Long id_empresa,Long id_sucursal,Long id_estructura,Long id_estructura_seccion,Long id_estructura_cargo,Long id_empleado,Date fecha_inicio,Date fecha_fin,Long id_mes,Double dias_anio,Double dias_realizadas,Double dias_pendiente,Double dias_tomados,Double dias_anticipadas,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planivacacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_estructura=id_estructura;
 		this.id_estructura_seccion=id_estructura_seccion;
 		this.id_estructura_cargo=id_estructura_cargo;
 		this.id_empleado=id_empleado;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.id_mes=id_mes;
 		this.dias_anio=dias_anio;
 		this.dias_realizadas=dias_realizadas;
 		this.dias_pendiente=dias_pendiente;
 		this.dias_tomados=dias_tomados;
 		this.dias_anticipadas=dias_anticipadas;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PlaniVacacion planivacacionLocal=null;
		
		if(object!=null) {
			planivacacionLocal=(PlaniVacacion)object;
			
			if(planivacacionLocal!=null) {
				if(this.getId()!=null && planivacacionLocal.getId()!=null) {
					if(this.getId().equals(planivacacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PlaniVacacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PlaniVacacionConstantesFunciones.getPlaniVacacionDescripcion(this);
		} else {
			sDetalle=PlaniVacacionConstantesFunciones.getPlaniVacacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PlaniVacacion getPlaniVacacionOriginal() {
		return this.planivacacionOriginal;
	}
	
	public void setPlaniVacacionOriginal(PlaniVacacion planivacacion) {
		try {
			this.planivacacionOriginal=planivacacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PlaniVacacionAdditional planivacacionAdditional=null;
	
	public PlaniVacacionAdditional getPlaniVacacionAdditional() {
		return this.planivacacionAdditional;
	}
	
	public void setPlaniVacacionAdditional(PlaniVacacionAdditional planivacacionAdditional) {
		try {
			this.planivacacionAdditional=planivacacionAdditional;
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
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_estructura_seccion() {
		return this.id_estructura_seccion;
	}
    
	
	public Long getid_estructura_cargo() {
		return this.id_estructura_cargo;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Double getdias_anio() {
		return this.dias_anio;
	}
    
	
	public Double getdias_realizadas() {
		return this.dias_realizadas;
	}
    
	
	public Double getdias_pendiente() {
		return this.dias_pendiente;
	}
    
	
	public Double getdias_tomados() {
		return this.dias_tomados;
	}
    
	
	public Double getdias_anticipadas() {
		return this.dias_anticipadas;
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_estructura");
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_estructura_seccion");
					}
				}

				this.id_estructura_seccion=newid_estructura_seccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura_cargo(Long newid_estructura_cargo)throws Exception
	{
		try {
			if(this.id_estructura_cargo!=newid_estructura_cargo) {
				if(newid_estructura_cargo==null) {
					//newid_estructura_cargo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_estructura_cargo");
					}
				}

				this.id_estructura_cargo=newid_estructura_cargo;
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setdias_anio(Double newdias_anio)throws Exception
	{
		try {
			if(this.dias_anio!=newdias_anio) {
				if(newdias_anio==null) {
					//newdias_anio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna dias_anio");
					}
				}

				this.dias_anio=newdias_anio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_realizadas(Double newdias_realizadas)throws Exception
	{
		try {
			if(this.dias_realizadas!=newdias_realizadas) {
				if(newdias_realizadas==null) {
					//newdias_realizadas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna dias_realizadas");
					}
				}

				this.dias_realizadas=newdias_realizadas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_pendiente(Double newdias_pendiente)throws Exception
	{
		try {
			if(this.dias_pendiente!=newdias_pendiente) {
				if(newdias_pendiente==null) {
					//newdias_pendiente=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna dias_pendiente");
					}
				}

				this.dias_pendiente=newdias_pendiente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_tomados(Double newdias_tomados)throws Exception
	{
		try {
			if(this.dias_tomados!=newdias_tomados) {
				if(newdias_tomados==null) {
					//newdias_tomados=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna dias_tomados");
					}
				}

				this.dias_tomados=newdias_tomados;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_anticipadas(Double newdias_anticipadas)throws Exception
	{
		try {
			if(this.dias_anticipadas!=newdias_anticipadas) {
				if(newdias_anticipadas==null) {
					//newdias_anticipadas=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna dias_anticipadas");
					}
				}

				this.dias_anticipadas=newdias_anticipadas;
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
						System.out.println("PlaniVacacion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PlaniVacacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Estructura getEstructuraSeccion() {
		return this.estructuraseccion;
	}

	public Estructura getEstructuraCargo() {
		return this.estructuracargo;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getestructuraseccion_descripcion() {
		return this.estructuraseccion_descripcion;
	}

	public String getestructuracargo_descripcion() {
		return this.estructuracargo_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setEstructuraCargo(Estructura estructuracargo) {
		try {
			this.estructuracargo=estructuracargo;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  setestructuracargo_descripcion(String estructuracargo_descripcion) {
		try {
			this.estructuracargo_descripcion=estructuracargo_descripcion;
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


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_estructura_descripcion="";String id_estructura_seccion_descripcion="";String id_estructura_cargo_descripcion="";String id_empleado_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_estructura_seccion_descripcion() {
		return id_estructura_seccion_descripcion;
	}
	public String getid_estructura_cargo_descripcion() {
		return id_estructura_cargo_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
	public void setid_estructura_cargo_descripcion(String newid_estructura_cargo_descripcion)throws Exception {
		try {
			this.id_estructura_cargo_descripcion=newid_estructura_cargo_descripcion;
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
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_estructura_descripcion="";this.id_estructura_seccion_descripcion="";this.id_estructura_cargo_descripcion="";this.id_empleado_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

