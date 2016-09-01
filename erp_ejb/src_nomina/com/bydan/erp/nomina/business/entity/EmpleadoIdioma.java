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
//import com.bydan.erp.nomina.util.EmpleadoIdiomaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoIdioma extends EmpleadoIdiomaAdditional implements Serializable ,Cloneable {//EmpleadoIdiomaAdditional,GeneralEntity
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
	
	private EmpleadoIdioma empleadoidiomaOriginal;
	
	private Map<String, Object> mapEmpleadoIdioma;
			
	public Map<String, Object> getMapEmpleadoIdioma() {
		return mapEmpleadoIdioma;
	}

	public void setMapEmpleadoIdioma(Map<String, Object> mapEmpleadoIdioma) {
		this.mapEmpleadoIdioma = mapEmpleadoIdioma;
	}
	
	public void inicializarMapEmpleadoIdioma() {
		this.mapEmpleadoIdioma = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoIdiomaValue(String sKey,Object oValue) {
		this.mapEmpleadoIdioma.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoIdiomaValue(String sKey) {
		return this.mapEmpleadoIdioma.get(sKey);
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
	private Long id_idioma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_materna;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_tecnico;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer porcen_tecnico;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_lectura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer porcen_lectura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_escrito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer porcen_escrito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_hablado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer porcen_hablado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpleadoIdiomaConstantesFunciones.SREGEXDESCRIPCION,message=EmpleadoIdiomaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Idioma idioma;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String idioma_descripcion;
	
	
		
	public EmpleadoIdioma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadoidiomaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_idioma=-1L;
 		this.es_materna=false;
 		this.es_tecnico=false;
 		this.porcen_tecnico=0;
 		this.es_lectura=false;
 		this.porcen_lectura=0;
 		this.es_escrito=false;
 		this.porcen_escrito=0;
 		this.es_hablado=false;
 		this.porcen_hablado=0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.idioma=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.idioma_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoIdioma (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_idioma,Boolean es_materna,Boolean es_tecnico,Integer porcen_tecnico,Boolean es_lectura,Integer porcen_lectura,Boolean es_escrito,Integer porcen_escrito,Boolean es_hablado,Integer porcen_hablado,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoidiomaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_idioma=id_idioma;
 		this.es_materna=es_materna;
 		this.es_tecnico=es_tecnico;
 		this.porcen_tecnico=porcen_tecnico;
 		this.es_lectura=es_lectura;
 		this.porcen_lectura=porcen_lectura;
 		this.es_escrito=es_escrito;
 		this.porcen_escrito=porcen_escrito;
 		this.es_hablado=es_hablado;
 		this.porcen_hablado=porcen_hablado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoIdioma (Long id_empresa,Long id_empleado,Long id_idioma,Boolean es_materna,Boolean es_tecnico,Integer porcen_tecnico,Boolean es_lectura,Integer porcen_lectura,Boolean es_escrito,Integer porcen_escrito,Boolean es_hablado,Integer porcen_hablado,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoidiomaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_idioma=id_idioma;
 		this.es_materna=es_materna;
 		this.es_tecnico=es_tecnico;
 		this.porcen_tecnico=porcen_tecnico;
 		this.es_lectura=es_lectura;
 		this.porcen_lectura=porcen_lectura;
 		this.es_escrito=es_escrito;
 		this.porcen_escrito=porcen_escrito;
 		this.es_hablado=es_hablado;
 		this.porcen_hablado=porcen_hablado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoIdioma empleadoidiomaLocal=null;
		
		if(object!=null) {
			empleadoidiomaLocal=(EmpleadoIdioma)object;
			
			if(empleadoidiomaLocal!=null) {
				if(this.getId()!=null && empleadoidiomaLocal.getId()!=null) {
					if(this.getId().equals(empleadoidiomaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoIdiomaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoIdiomaConstantesFunciones.getEmpleadoIdiomaDescripcion(this);
		} else {
			sDetalle=EmpleadoIdiomaConstantesFunciones.getEmpleadoIdiomaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoIdioma getEmpleadoIdiomaOriginal() {
		return this.empleadoidiomaOriginal;
	}
	
	public void setEmpleadoIdiomaOriginal(EmpleadoIdioma empleadoidioma) {
		try {
			this.empleadoidiomaOriginal=empleadoidioma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoIdiomaAdditional empleadoidiomaAdditional=null;
	
	public EmpleadoIdiomaAdditional getEmpleadoIdiomaAdditional() {
		return this.empleadoidiomaAdditional;
	}
	
	public void setEmpleadoIdiomaAdditional(EmpleadoIdiomaAdditional empleadoidiomaAdditional) {
		try {
			this.empleadoidiomaAdditional=empleadoidiomaAdditional;
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
    
	
	public Long getid_idioma() {
		return this.id_idioma;
	}
    
	
	public Boolean getes_materna() {
		return this.es_materna;
	}
    
	
	public Boolean getes_tecnico() {
		return this.es_tecnico;
	}
    
	
	public Integer getporcen_tecnico() {
		return this.porcen_tecnico;
	}
    
	
	public Boolean getes_lectura() {
		return this.es_lectura;
	}
    
	
	public Integer getporcen_lectura() {
		return this.porcen_lectura;
	}
    
	
	public Boolean getes_escrito() {
		return this.es_escrito;
	}
    
	
	public Integer getporcen_escrito() {
		return this.porcen_escrito;
	}
    
	
	public Boolean getes_hablado() {
		return this.es_hablado;
	}
    
	
	public Integer getporcen_hablado() {
		return this.porcen_hablado;
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
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_idioma(Long newid_idioma)throws Exception
	{
		try {
			if(this.id_idioma!=newid_idioma) {
				if(newid_idioma==null) {
					//newid_idioma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna id_idioma");
					}
				}

				this.id_idioma=newid_idioma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_materna(Boolean newes_materna)throws Exception
	{
		try {
			if(this.es_materna!=newes_materna) {
				if(newes_materna==null) {
					//newes_materna=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna es_materna");
					}
				}

				this.es_materna=newes_materna;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_tecnico(Boolean newes_tecnico)throws Exception
	{
		try {
			if(this.es_tecnico!=newes_tecnico) {
				if(newes_tecnico==null) {
					//newes_tecnico=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna es_tecnico");
					}
				}

				this.es_tecnico=newes_tecnico;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_tecnico(Integer newporcen_tecnico)throws Exception
	{
		try {
			if(this.porcen_tecnico!=newporcen_tecnico) {
				if(newporcen_tecnico==null) {
					//newporcen_tecnico=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna porcen_tecnico");
					}
				}

				this.porcen_tecnico=newporcen_tecnico;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_lectura(Boolean newes_lectura)throws Exception
	{
		try {
			if(this.es_lectura!=newes_lectura) {
				if(newes_lectura==null) {
					//newes_lectura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna es_lectura");
					}
				}

				this.es_lectura=newes_lectura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_lectura(Integer newporcen_lectura)throws Exception
	{
		try {
			if(this.porcen_lectura!=newporcen_lectura) {
				if(newporcen_lectura==null) {
					//newporcen_lectura=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna porcen_lectura");
					}
				}

				this.porcen_lectura=newporcen_lectura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_escrito(Boolean newes_escrito)throws Exception
	{
		try {
			if(this.es_escrito!=newes_escrito) {
				if(newes_escrito==null) {
					//newes_escrito=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna es_escrito");
					}
				}

				this.es_escrito=newes_escrito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_escrito(Integer newporcen_escrito)throws Exception
	{
		try {
			if(this.porcen_escrito!=newporcen_escrito) {
				if(newporcen_escrito==null) {
					//newporcen_escrito=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna porcen_escrito");
					}
				}

				this.porcen_escrito=newporcen_escrito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_hablado(Boolean newes_hablado)throws Exception
	{
		try {
			if(this.es_hablado!=newes_hablado) {
				if(newes_hablado==null) {
					//newes_hablado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna es_hablado");
					}
				}

				this.es_hablado=newes_hablado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_hablado(Integer newporcen_hablado)throws Exception
	{
		try {
			if(this.porcen_hablado!=newporcen_hablado) {
				if(newporcen_hablado==null) {
					//newporcen_hablado=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna porcen_hablado");
					}
				}

				this.porcen_hablado=newporcen_hablado;
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
						System.out.println("EmpleadoIdioma:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("EmpleadoIdioma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public Idioma getIdioma() {
		return this.idioma;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getidioma_descripcion() {
		return this.idioma_descripcion;
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


	public  void  setIdioma(Idioma idioma) {
		try {
			this.idioma=idioma;
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


	public  void  setidioma_descripcion(String idioma_descripcion) {
		try {
			this.idioma_descripcion=idioma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_idioma_descripcion="";String es_materna_descripcion="";String es_tecnico_descripcion="";String es_lectura_descripcion="";String es_escrito_descripcion="";String es_hablado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_idioma_descripcion() {
		return id_idioma_descripcion;
	}
	public String getes_materna_descripcion() {
		return es_materna_descripcion;
	}
	public String getes_tecnico_descripcion() {
		return es_tecnico_descripcion;
	}
	public String getes_lectura_descripcion() {
		return es_lectura_descripcion;
	}
	public String getes_escrito_descripcion() {
		return es_escrito_descripcion;
	}
	public String getes_hablado_descripcion() {
		return es_hablado_descripcion;
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
	public void setid_idioma_descripcion(String newid_idioma_descripcion)throws Exception {
		try {
			this.id_idioma_descripcion=newid_idioma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_materna_descripcion(String newes_materna_descripcion)throws Exception {
		try {
			this.es_materna_descripcion=newes_materna_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_tecnico_descripcion(String newes_tecnico_descripcion)throws Exception {
		try {
			this.es_tecnico_descripcion=newes_tecnico_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_lectura_descripcion(String newes_lectura_descripcion)throws Exception {
		try {
			this.es_lectura_descripcion=newes_lectura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_escrito_descripcion(String newes_escrito_descripcion)throws Exception {
		try {
			this.es_escrito_descripcion=newes_escrito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_hablado_descripcion(String newes_hablado_descripcion)throws Exception {
		try {
			this.es_hablado_descripcion=newes_hablado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_idioma_descripcion="";this.es_materna_descripcion="";this.es_tecnico_descripcion="";this.es_lectura_descripcion="";this.es_escrito_descripcion="";this.es_hablado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

