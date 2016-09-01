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
//import com.bydan.erp.nomina.util.DetalleCursoConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class DetalleCurso extends DetalleCursoAdditional implements Serializable ,Cloneable {//DetalleCursoAdditional,GeneralEntity
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
	
	private DetalleCurso detallecursoOriginal;
	
	private Map<String, Object> mapDetalleCurso;
			
	public Map<String, Object> getMapDetalleCurso() {
		return mapDetalleCurso;
	}

	public void setMapDetalleCurso(Map<String, Object> mapDetalleCurso) {
		this.mapDetalleCurso = mapDetalleCurso;
	}
	
	public void inicializarMapDetalleCurso() {
		this.mapDetalleCurso = new HashMap<String,Object>();
	}
	
	public void setMapDetalleCursoValue(String sKey,Object oValue) {
		this.mapDetalleCurso.put(sKey, oValue);
	}
	
	public Object getMapDetalleCursoValue(String sKey) {
		return this.mapDetalleCurso.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_curso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleCursoConstantesFunciones.SREGEXNOMBRE,message=DetalleCursoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleCursoConstantesFunciones.SREGEXDESCRIPCION,message=DetalleCursoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Curso curso;
	
	
	private String curso_descripcion;
	
	
		
	public DetalleCurso () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallecursoOriginal=this;
		
 		this.id_curso=-1L;
 		this.nombre="";
 		this.descripcion="";
		
		
		this.curso=null;
		
		
		this.curso_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleCurso (Long id,Date versionRow,Long id_curso,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallecursoOriginal=this;
		
 		this.id_curso=id_curso;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleCurso (Long id_curso,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallecursoOriginal=this;
		
 		this.id_curso=id_curso;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleCurso detallecursoLocal=null;
		
		if(object!=null) {
			detallecursoLocal=(DetalleCurso)object;
			
			if(detallecursoLocal!=null) {
				if(this.getId()!=null && detallecursoLocal.getId()!=null) {
					if(this.getId().equals(detallecursoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleCursoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleCursoConstantesFunciones.getDetalleCursoDescripcion(this);
		} else {
			sDetalle=DetalleCursoConstantesFunciones.getDetalleCursoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleCurso getDetalleCursoOriginal() {
		return this.detallecursoOriginal;
	}
	
	public void setDetalleCursoOriginal(DetalleCurso detallecurso) {
		try {
			this.detallecursoOriginal=detallecurso;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleCursoAdditional detallecursoAdditional=null;
	
	public DetalleCursoAdditional getDetalleCursoAdditional() {
		return this.detallecursoAdditional;
	}
	
	public void setDetalleCursoAdditional(DetalleCursoAdditional detallecursoAdditional) {
		try {
			this.detallecursoAdditional=detallecursoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_curso() {
		return this.id_curso;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_curso(Long newid_curso)throws Exception
	{
		try {
			if(this.id_curso!=newid_curso) {
				if(newid_curso==null) {
					//newid_curso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleCurso:Valor nulo no permitido en columna id_curso");
					}
				}

				this.id_curso=newid_curso;
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
						System.out.println("DetalleCurso:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("DetalleCurso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
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
						System.out.println("DetalleCurso:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleCurso:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Curso getCurso() {
		return this.curso;
	}

	
	
	public String getcurso_descripcion() {
		return this.curso_descripcion;
	}

	
	
	public  void  setCurso(Curso curso) {
		try {
			this.curso=curso;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcurso_descripcion(String curso_descripcion) {
		try {
			this.curso_descripcion=curso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_curso_descripcion="";
	
	
	public String getid_curso_descripcion() {
		return id_curso_descripcion;
	}
	
	
	public void setid_curso_descripcion(String newid_curso_descripcion)throws Exception {
		try {
			this.id_curso_descripcion=newid_curso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_curso_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

