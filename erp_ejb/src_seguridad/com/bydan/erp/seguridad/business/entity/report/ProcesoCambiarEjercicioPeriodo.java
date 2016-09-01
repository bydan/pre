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
package com.bydan.erp.seguridad.business.entity.report;

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
//import com.bydan.erp.seguridad.util.ProcesoCambiarEjercicioPeriodoConstantesFunciones;
import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;






@SuppressWarnings("unused")
public class ProcesoCambiarEjercicioPeriodo extends ProcesoCambiarEjercicioPeriodoAdditional implements Serializable ,Cloneable {//ProcesoCambiarEjercicioPeriodoAdditional,GeneralEntity
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
	
	private ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodoOriginal;
	
	private Map<String, Object> mapProcesoCambiarEjercicioPeriodo;
			
	public Map<String, Object> getMapProcesoCambiarEjercicioPeriodo() {
		return mapProcesoCambiarEjercicioPeriodo;
	}

	public void setMapProcesoCambiarEjercicioPeriodo(Map<String, Object> mapProcesoCambiarEjercicioPeriodo) {
		this.mapProcesoCambiarEjercicioPeriodo = mapProcesoCambiarEjercicioPeriodo;
	}
	
	public void inicializarMapProcesoCambiarEjercicioPeriodo() {
		this.mapProcesoCambiarEjercicioPeriodo = new HashMap<String,Object>();
	}
	
	public void setMapProcesoCambiarEjercicioPeriodoValue(String sKey,Object oValue) {
		this.mapProcesoCambiarEjercicioPeriodo.put(sKey, oValue);
	}
	
	public Object getMapProcesoCambiarEjercicioPeriodoValue(String sKey) {
		return this.mapProcesoCambiarEjercicioPeriodo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_sistema;
			
	
	
	
	
	
		
	public ProcesoCambiarEjercicioPeriodo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesocambiarejercicioperiodoOriginal=this;
		
 		this.fecha_sistema=new Date();
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoCambiarEjercicioPeriodo getProcesoCambiarEjercicioPeriodoOriginal() {
		return this.procesocambiarejercicioperiodoOriginal;
	}
	
	public void setProcesoCambiarEjercicioPeriodoOriginal(ProcesoCambiarEjercicioPeriodo procesocambiarejercicioperiodo) {
		try {
			this.procesocambiarejercicioperiodoOriginal=procesocambiarejercicioperiodo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoCambiarEjercicioPeriodoAdditional procesocambiarejercicioperiodoAdditional=null;
	
	public ProcesoCambiarEjercicioPeriodoAdditional getProcesoCambiarEjercicioPeriodoAdditional() {
		return this.procesocambiarejercicioperiodoAdditional;
	}
	
	public void setProcesoCambiarEjercicioPeriodoAdditional(ProcesoCambiarEjercicioPeriodoAdditional procesocambiarejercicioperiodoAdditional) {
		try {
			this.procesocambiarejercicioperiodoAdditional=procesocambiarejercicioperiodoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Date getfecha_sistema() {
		return this.fecha_sistema;
	}
	
    
	public void setfecha_sistema(Date newfecha_sistema)throws Exception
	{
		try {
			if(this.fecha_sistema!=newfecha_sistema) {
				if(newfecha_sistema==null) {
					//newfecha_sistema=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCambiarEjercicioPeriodo:Valor nulo no permitido en columna fecha_sistema");
					}
				}

				this.fecha_sistema=newfecha_sistema;
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

