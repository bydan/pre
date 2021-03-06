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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.TipoRiesgoChequeConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;









@SuppressWarnings("unused")
public class TipoRiesgoCheque extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoRiesgoChequeAdditional,GeneralEntity
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
	
	private TipoRiesgoCheque tiporiesgochequeOriginal;
	
	private Map<String, Object> mapTipoRiesgoCheque;
			
	public Map<String, Object> getMapTipoRiesgoCheque() {
		return mapTipoRiesgoCheque;
	}

	public void setMapTipoRiesgoCheque(Map<String, Object> mapTipoRiesgoCheque) {
		this.mapTipoRiesgoCheque = mapTipoRiesgoCheque;
	}
	
	public void inicializarMapTipoRiesgoCheque() {
		this.mapTipoRiesgoCheque = new HashMap<String,Object>();
	}
	
	public void setMapTipoRiesgoChequeValue(String sKey,Object oValue) {
		this.mapTipoRiesgoCheque.put(sKey, oValue);
	}
	
	public Object getMapTipoRiesgoChequeValue(String sKey) {
		return this.mapTipoRiesgoCheque.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoRiesgoChequeConstantesFunciones.SREGEXNOMBRE,message=TipoRiesgoChequeConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoRiesgoChequeConstantesFunciones.SREGEXDESCRIPCION,message=TipoRiesgoChequeConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	
	
	
	
	public List<FormaPagoPuntoVenta> formapagopuntoventas;
		
	public TipoRiesgoCheque () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tiporiesgochequeOriginal=this;
		
 		this.nombre="";
 		this.descripcion="";
		
		
		
		
		
		
		this.formapagopuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoRiesgoCheque (Long id,Date versionRow,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporiesgochequeOriginal=this;
		
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoRiesgoCheque (String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporiesgochequeOriginal=this;
		
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoRiesgoCheque tiporiesgochequeLocal=null;
		
		if(object!=null) {
			tiporiesgochequeLocal=(TipoRiesgoCheque)object;
			
			if(tiporiesgochequeLocal!=null) {
				if(this.getId()!=null && tiporiesgochequeLocal.getId()!=null) {
					if(this.getId().equals(tiporiesgochequeLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoRiesgoChequeConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeDescripcion(this);
		} else {
			sDetalle=TipoRiesgoChequeConstantesFunciones.getTipoRiesgoChequeDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoRiesgoCheque getTipoRiesgoChequeOriginal() {
		return this.tiporiesgochequeOriginal;
	}
	
	public void setTipoRiesgoChequeOriginal(TipoRiesgoCheque tiporiesgocheque) {
		try {
			this.tiporiesgochequeOriginal=tiporiesgocheque;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRiesgoCheque:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoRiesgoCheque:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("TipoRiesgoCheque:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("TipoRiesgoCheque:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() {
		return this.formapagopuntoventas;
	}

	
	
	public  void  setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> formapagopuntoventas) {
		try {
			this.formapagopuntoventas=formapagopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object formapagopuntoventasDescripcionReporte;
	
	
	public Object getformapagopuntoventasDescripcionReporte() {
		return formapagopuntoventasDescripcionReporte;
	}

	
	
	public  void  setformapagopuntoventasDescripcionReporte(Object formapagopuntoventas) {
		try {
			this.formapagopuntoventasDescripcionReporte=formapagopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

