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
//import com.bydan.erp.contabilidad.util.EmpresaEspecialConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;









@SuppressWarnings("unused")
public class EmpresaEspecial extends EmpresaEspecialAdditional implements Serializable ,Cloneable {//EmpresaEspecialAdditional,GeneralEntity
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
	
	private EmpresaEspecial empresaespecialOriginal;
	
	private Map<String, Object> mapEmpresaEspecial;
			
	public Map<String, Object> getMapEmpresaEspecial() {
		return mapEmpresaEspecial;
	}

	public void setMapEmpresaEspecial(Map<String, Object> mapEmpresaEspecial) {
		this.mapEmpresaEspecial = mapEmpresaEspecial;
	}
	
	public void inicializarMapEmpresaEspecial() {
		this.mapEmpresaEspecial = new HashMap<String,Object>();
	}
	
	public void setMapEmpresaEspecialValue(String sKey,Object oValue) {
		this.mapEmpresaEspecial.put(sKey, oValue);
	}
	
	public Object getMapEmpresaEspecialValue(String sKey) {
		return this.mapEmpresaEspecial.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaEspecialConstantesFunciones.SREGEXNUMERO_RESOLUCION,message=EmpresaEspecialConstantesFunciones.SMENSAJEREGEXNUMERO_RESOLUCION)
	private String numero_resolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_resolucion;
			
	
	
	
	
	
		
	public EmpresaEspecial () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empresaespecialOriginal=this;
		
 		this.numero_resolucion="";
 		this.fecha_resolucion=new Date();
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpresaEspecial (Long id,Date versionRow,String numero_resolucion,Date fecha_resolucion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empresaespecialOriginal=this;
		
 		this.numero_resolucion=numero_resolucion;
 		this.fecha_resolucion=fecha_resolucion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpresaEspecial (String numero_resolucion,Date fecha_resolucion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empresaespecialOriginal=this;
		
 		this.numero_resolucion=numero_resolucion;
 		this.fecha_resolucion=fecha_resolucion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpresaEspecial empresaespecialLocal=null;
		
		if(object!=null) {
			empresaespecialLocal=(EmpresaEspecial)object;
			
			if(empresaespecialLocal!=null) {
				if(this.getId()!=null && empresaespecialLocal.getId()!=null) {
					if(this.getId().equals(empresaespecialLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpresaEspecialConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpresaEspecialConstantesFunciones.getEmpresaEspecialDescripcion(this);
		} else {
			sDetalle=EmpresaEspecialConstantesFunciones.getEmpresaEspecialDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpresaEspecial getEmpresaEspecialOriginal() {
		return this.empresaespecialOriginal;
	}
	
	public void setEmpresaEspecialOriginal(EmpresaEspecial empresaespecial) {
		try {
			this.empresaespecialOriginal=empresaespecial;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpresaEspecialAdditional empresaespecialAdditional=null;
	
	public EmpresaEspecialAdditional getEmpresaEspecialAdditional() {
		return this.empresaespecialAdditional;
	}
	
	public void setEmpresaEspecialAdditional(EmpresaEspecialAdditional empresaespecialAdditional) {
		try {
			this.empresaespecialAdditional=empresaespecialAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnumero_resolucion() {
		return this.numero_resolucion;
	}
    
	
	public Date getfecha_resolucion() {
		return this.fecha_resolucion;
	}
	
    
	public void setnumero_resolucion(String newnumero_resolucion)throws Exception
	{
		try {
			if(this.numero_resolucion!=newnumero_resolucion) {
				if(newnumero_resolucion==null) {
					//newnumero_resolucion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpresaEspecial:Valor nulo no permitido en columna numero_resolucion");
					}
				}

				if(newnumero_resolucion!=null&&newnumero_resolucion.length()>50) {
					newnumero_resolucion=newnumero_resolucion.substring(0,48);
					System.out.println("EmpresaEspecial:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_resolucion");
				}

				this.numero_resolucion=newnumero_resolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_resolucion(Date newfecha_resolucion)throws Exception
	{
		try {
			if(this.fecha_resolucion!=newfecha_resolucion) {
				if(newfecha_resolucion==null) {
					//newfecha_resolucion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpresaEspecial:Valor nulo no permitido en columna fecha_resolucion");
					}
				}

				this.fecha_resolucion=newfecha_resolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

