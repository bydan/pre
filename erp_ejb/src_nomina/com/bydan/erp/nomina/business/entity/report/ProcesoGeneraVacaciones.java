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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.ProcesoGeneraVacacionesConstantesFunciones;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.nomina.business.entity.*;






@SuppressWarnings("unused")
public class ProcesoGeneraVacaciones extends ProcesoGeneraVacacionesAdditional implements Serializable ,Cloneable {//ProcesoGeneraVacacionesAdditional,GeneralEntity
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
	
	private ProcesoGeneraVacaciones procesogeneravacacionesOriginal;
	
	private Map<String, Object> mapProcesoGeneraVacaciones;
			
	public Map<String, Object> getMapProcesoGeneraVacaciones() {
		return mapProcesoGeneraVacaciones;
	}

	public void setMapProcesoGeneraVacaciones(Map<String, Object> mapProcesoGeneraVacaciones) {
		this.mapProcesoGeneraVacaciones = mapProcesoGeneraVacaciones;
	}
	
	public void inicializarMapProcesoGeneraVacaciones() {
		this.mapProcesoGeneraVacaciones = new HashMap<String,Object>();
	}
	
	public void setMapProcesoGeneraVacacionesValue(String sKey,Object oValue) {
		this.mapProcesoGeneraVacaciones.put(sKey, oValue);
	}
	
	public Object getMapProcesoGeneraVacacionesValue(String sKey) {
		return this.mapProcesoGeneraVacaciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	
	
	
	
		
	public ProcesoGeneraVacaciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesogeneravacacionesOriginal=this;
		
 		this.fecha=new Date();
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoGeneraVacaciones getProcesoGeneraVacacionesOriginal() {
		return this.procesogeneravacacionesOriginal;
	}
	
	public void setProcesoGeneraVacacionesOriginal(ProcesoGeneraVacaciones procesogeneravacaciones) {
		try {
			this.procesogeneravacacionesOriginal=procesogeneravacaciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoGeneraVacacionesAdditional procesogeneravacacionesAdditional=null;
	
	public ProcesoGeneraVacacionesAdditional getProcesoGeneraVacacionesAdditional() {
		return this.procesogeneravacacionesAdditional;
	}
	
	public void setProcesoGeneraVacacionesAdditional(ProcesoGeneraVacacionesAdditional procesogeneravacacionesAdditional) {
		try {
			this.procesogeneravacacionesAdditional=procesogeneravacacionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoGeneraVacaciones:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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

