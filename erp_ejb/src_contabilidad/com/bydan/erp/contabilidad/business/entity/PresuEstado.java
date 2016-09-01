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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.PresuEstadoConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PresuEstado extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//PresuEstadoAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private PresuEstado presuestadoOriginal;
	
	private Map<String, Object> mapPresuEstado;
			
	public Map<String, Object> getMapPresuEstado() {
		return mapPresuEstado;
	}

	public void setMapPresuEstado(Map<String, Object> mapPresuEstado) {
		this.mapPresuEstado = mapPresuEstado;
	}
	
	public void inicializarMapPresuEstado() {
		this.mapPresuEstado = new HashMap<String,Object>();
	}
	
	public void setMapPresuEstadoValue(String sKey,Object oValue) {
		this.mapPresuEstado.put(sKey, oValue);
	}
	
	public Object getMapPresuEstadoValue(String sKey) {
		return this.mapPresuEstado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuEstadoConstantesFunciones.SREGEXNOMBRE,message=PresuEstadoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
		
	public PresuEstado () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presuestadoOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresuEstado (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuestadoOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresuEstado (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuestadoOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresuEstado presuestadoLocal=null;
		
		if(object!=null) {
			presuestadoLocal=(PresuEstado)object;
			
			if(presuestadoLocal!=null) {
				if(this.getId()!=null && presuestadoLocal.getId()!=null) {
					if(this.getId().equals(presuestadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresuEstadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresuEstadoConstantesFunciones.getPresuEstadoDescripcion(this);
		} else {
			sDetalle=PresuEstadoConstantesFunciones.getPresuEstadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresuEstado getPresuEstadoOriginal() {
		return this.presuestadoOriginal;
	}
	
	public void setPresuEstadoOriginal(PresuEstado presuestado) {
		try {
			this.presuestadoOriginal=presuestado;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuEstado:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("PresuEstado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object presuasignacionsDescripcionReporte;
	Object presuproyectosDescripcionReporte;
	Object presuproyectocuentasDescripcionReporte;
	
	
	public Object getpresuasignacionsDescripcionReporte() {
		return presuasignacionsDescripcionReporte;
	}

	public Object getpresuproyectosDescripcionReporte() {
		return presuproyectosDescripcionReporte;
	}

	public Object getpresuproyectocuentasDescripcionReporte() {
		return presuproyectocuentasDescripcionReporte;
	}

	
	
	public  void  setpresuasignacionsDescripcionReporte(Object presuasignacions) {
		try {
			this.presuasignacionsDescripcionReporte=presuasignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresuproyectosDescripcionReporte(Object presuproyectos) {
		try {
			this.presuproyectosDescripcionReporte=presuproyectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresuproyectocuentasDescripcionReporte(Object presuproyectocuentas) {
		try {
			this.presuproyectocuentasDescripcionReporte=presuproyectocuentas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

