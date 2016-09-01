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
//import com.bydan.erp.nomina.util.EnfermedadConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Enfermedad extends EnfermedadAdditional implements Serializable ,Cloneable {//EnfermedadAdditional,GeneralEntity
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
	
	private Enfermedad enfermedadOriginal;
	
	private Map<String, Object> mapEnfermedad;
			
	public Map<String, Object> getMapEnfermedad() {
		return mapEnfermedad;
	}

	public void setMapEnfermedad(Map<String, Object> mapEnfermedad) {
		this.mapEnfermedad = mapEnfermedad;
	}
	
	public void inicializarMapEnfermedad() {
		this.mapEnfermedad = new HashMap<String,Object>();
	}
	
	public void setMapEnfermedadValue(String sKey,Object oValue) {
		this.mapEnfermedad.put(sKey, oValue);
	}
	
	public Object getMapEnfermedadValue(String sKey) {
		return this.mapEnfermedad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_enfermedad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EnfermedadConstantesFunciones.SREGEXNOMBRE,message=EnfermedadConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EnfermedadConstantesFunciones.SREGEXDESCRIPCION,message=EnfermedadConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public TipoEnfermedad tipoenfermedad;
	
	
	private String empresa_descripcion;
	private String tipoenfermedad_descripcion;
	
	
	public List<EmpleadoEnfer> empleadoenfers;
		
	public Enfermedad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.enfermedadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_enfermedad=-1L;
 		this.nombre="";
 		this.descripcion="";
		
		
		this.empresa=null;
		this.tipoenfermedad=null;
		
		
		this.empresa_descripcion="";
		this.tipoenfermedad_descripcion="";
		
		
		this.empleadoenfers=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Enfermedad (Long id,Date versionRow,Long id_empresa,Long id_tipo_enfermedad,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.enfermedadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_enfermedad=id_tipo_enfermedad;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Enfermedad (Long id_empresa,Long id_tipo_enfermedad,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.enfermedadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_enfermedad=id_tipo_enfermedad;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Enfermedad enfermedadLocal=null;
		
		if(object!=null) {
			enfermedadLocal=(Enfermedad)object;
			
			if(enfermedadLocal!=null) {
				if(this.getId()!=null && enfermedadLocal.getId()!=null) {
					if(this.getId().equals(enfermedadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EnfermedadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EnfermedadConstantesFunciones.getEnfermedadDescripcion(this);
		} else {
			sDetalle=EnfermedadConstantesFunciones.getEnfermedadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Enfermedad getEnfermedadOriginal() {
		return this.enfermedadOriginal;
	}
	
	public void setEnfermedadOriginal(Enfermedad enfermedad) {
		try {
			this.enfermedadOriginal=enfermedad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EnfermedadAdditional enfermedadAdditional=null;
	
	public EnfermedadAdditional getEnfermedadAdditional() {
		return this.enfermedadAdditional;
	}
	
	public void setEnfermedadAdditional(EnfermedadAdditional enfermedadAdditional) {
		try {
			this.enfermedadAdditional=enfermedadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_enfermedad() {
		return this.id_tipo_enfermedad;
	}
    
	
	public String getnombre() {
		return this.nombre;
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
						System.out.println("Enfermedad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_enfermedad(Long newid_tipo_enfermedad)throws Exception
	{
		try {
			if(this.id_tipo_enfermedad!=newid_tipo_enfermedad) {
				if(newid_tipo_enfermedad==null) {
					//newid_tipo_enfermedad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Enfermedad:Valor nulo no permitido en columna id_tipo_enfermedad");
					}
				}

				this.id_tipo_enfermedad=newid_tipo_enfermedad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Enfermedad:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Enfermedad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("Enfermedad:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Enfermedad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public TipoEnfermedad getTipoEnfermedad() {
		return this.tipoenfermedad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoenfermedad_descripcion() {
		return this.tipoenfermedad_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoEnfermedad(TipoEnfermedad tipoenfermedad) {
		try {
			this.tipoenfermedad=tipoenfermedad;
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


	public  void  settipoenfermedad_descripcion(String tipoenfermedad_descripcion) {
		try {
			this.tipoenfermedad_descripcion=tipoenfermedad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<EmpleadoEnfer> getEmpleadoEnfers() {
		return this.empleadoenfers;
	}

	
	
	public  void  setEmpleadoEnfers(List<EmpleadoEnfer> empleadoenfers) {
		try {
			this.empleadoenfers=empleadoenfers;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_enfermedad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_enfermedad_descripcion() {
		return id_tipo_enfermedad_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_enfermedad_descripcion(String newid_tipo_enfermedad_descripcion)throws Exception {
		try {
			this.id_tipo_enfermedad_descripcion=newid_tipo_enfermedad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_enfermedad_descripcion="";
	}
	
	
	Object empleadoenfersDescripcionReporte;
	
	
	public Object getempleadoenfersDescripcionReporte() {
		return empleadoenfersDescripcionReporte;
	}

	
	
	public  void  setempleadoenfersDescripcionReporte(Object empleadoenfers) {
		try {
			this.empleadoenfersDescripcionReporte=empleadoenfers;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

