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
//import com.bydan.erp.nomina.util.ProcesoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoImpuestoRenta extends ProcesoImpuestoRentaAdditional implements Serializable ,Cloneable {//ProcesoImpuestoRentaAdditional,GeneralEntity
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
	
	private ProcesoImpuestoRenta procesoimpuestorentaOriginal;
	
	private Map<String, Object> mapProcesoImpuestoRenta;
			
	public Map<String, Object> getMapProcesoImpuestoRenta() {
		return mapProcesoImpuestoRenta;
	}

	public void setMapProcesoImpuestoRenta(Map<String, Object> mapProcesoImpuestoRenta) {
		this.mapProcesoImpuestoRenta = mapProcesoImpuestoRenta;
	}
	
	public void inicializarMapProcesoImpuestoRenta() {
		this.mapProcesoImpuestoRenta = new HashMap<String,Object>();
	}
	
	public void setMapProcesoImpuestoRentaValue(String sKey,Object oValue) {
		this.mapProcesoImpuestoRenta.put(sKey, oValue);
	}
	
	public Object getMapProcesoImpuestoRentaValue(String sKey) {
		return this.mapProcesoImpuestoRenta.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
			
	
	public Anio anio;
	
	
	private String anio_descripcion;
	
	
		
	public ProcesoImpuestoRenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesoimpuestorentaOriginal=this;
		
 		this.id_anio=null;
		
		
		this.anio=null;
		
		
		this.anio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoImpuestoRenta getProcesoImpuestoRentaOriginal() {
		return this.procesoimpuestorentaOriginal;
	}
	
	public void setProcesoImpuestoRentaOriginal(ProcesoImpuestoRenta procesoimpuestorenta) {
		try {
			this.procesoimpuestorentaOriginal=procesoimpuestorenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoImpuestoRentaAdditional procesoimpuestorentaAdditional=null;
	
	public ProcesoImpuestoRentaAdditional getProcesoImpuestoRentaAdditional() {
		return this.procesoimpuestorentaAdditional;
	}
	
	public void setProcesoImpuestoRentaAdditional(ProcesoImpuestoRentaAdditional procesoimpuestorentaAdditional) {
		try {
			this.procesoimpuestorentaAdditional=procesoimpuestorentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
	
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	
	
	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_anio_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	
	
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

