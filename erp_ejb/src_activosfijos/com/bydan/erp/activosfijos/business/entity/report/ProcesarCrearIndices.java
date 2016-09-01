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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.ProcesarCrearIndicesConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.activosfijos.business.entity.*;






@SuppressWarnings("unused")
public class ProcesarCrearIndices extends ProcesarCrearIndicesAdditional implements Serializable ,Cloneable {//ProcesarCrearIndicesAdditional,GeneralEntity
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
	
	private ProcesarCrearIndices procesarcrearindicesOriginal;
	
	private Map<String, Object> mapProcesarCrearIndices;
			
	public Map<String, Object> getMapProcesarCrearIndices() {
		return mapProcesarCrearIndices;
	}

	public void setMapProcesarCrearIndices(Map<String, Object> mapProcesarCrearIndices) {
		this.mapProcesarCrearIndices = mapProcesarCrearIndices;
	}
	
	public void inicializarMapProcesarCrearIndices() {
		this.mapProcesarCrearIndices = new HashMap<String,Object>();
	}
	
	public void setMapProcesarCrearIndicesValue(String sKey,Object oValue) {
		this.mapProcesarCrearIndices.put(sKey, oValue);
	}
	
	public Object getMapProcesarCrearIndicesValue(String sKey) {
		return this.mapProcesarCrearIndices.get(sKey);
	}
	
			
	
	
	
	
	
		
	public ProcesarCrearIndices () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesarcrearindicesOriginal=this;
		
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesarCrearIndices getProcesarCrearIndicesOriginal() {
		return this.procesarcrearindicesOriginal;
	}
	
	public void setProcesarCrearIndicesOriginal(ProcesarCrearIndices procesarcrearindices) {
		try {
			this.procesarcrearindicesOriginal=procesarcrearindices;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesarCrearIndicesAdditional procesarcrearindicesAdditional=null;
	
	public ProcesarCrearIndicesAdditional getProcesarCrearIndicesAdditional() {
		return this.procesarcrearindicesAdditional;
	}
	
	public void setProcesarCrearIndicesAdditional(ProcesarCrearIndicesAdditional procesarcrearindicesAdditional) {
		try {
			this.procesarcrearindicesAdditional=procesarcrearindicesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

