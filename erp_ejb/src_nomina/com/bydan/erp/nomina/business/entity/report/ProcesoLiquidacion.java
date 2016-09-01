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
//import com.bydan.erp.nomina.util.ProcesoLiquidacionConstantesFunciones;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.nomina.business.entity.*;






@SuppressWarnings("unused")
public class ProcesoLiquidacion extends ProcesoLiquidacionAdditional implements Serializable ,Cloneable {//ProcesoLiquidacionAdditional,GeneralEntity
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
	
	private ProcesoLiquidacion procesoliquidacionOriginal;
	
	private Map<String, Object> mapProcesoLiquidacion;
			
	public Map<String, Object> getMapProcesoLiquidacion() {
		return mapProcesoLiquidacion;
	}

	public void setMapProcesoLiquidacion(Map<String, Object> mapProcesoLiquidacion) {
		this.mapProcesoLiquidacion = mapProcesoLiquidacion;
	}
	
	public void inicializarMapProcesoLiquidacion() {
		this.mapProcesoLiquidacion = new HashMap<String,Object>();
	}
	
	public void setMapProcesoLiquidacionValue(String sKey,Object oValue) {
		this.mapProcesoLiquidacion.put(sKey, oValue);
	}
	
	public Object getMapProcesoLiquidacionValue(String sKey) {
		return this.mapProcesoLiquidacion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_reversar;
			
	
	
	
	
	
		
	public ProcesoLiquidacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesoliquidacionOriginal=this;
		
 		this.fecha=new Date();
 		this.es_reversar=false;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoLiquidacion getProcesoLiquidacionOriginal() {
		return this.procesoliquidacionOriginal;
	}
	
	public void setProcesoLiquidacionOriginal(ProcesoLiquidacion procesoliquidacion) {
		try {
			this.procesoliquidacionOriginal=procesoliquidacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoLiquidacionAdditional procesoliquidacionAdditional=null;
	
	public ProcesoLiquidacionAdditional getProcesoLiquidacionAdditional() {
		return this.procesoliquidacionAdditional;
	}
	
	public void setProcesoLiquidacionAdditional(ProcesoLiquidacionAdditional procesoliquidacionAdditional) {
		try {
			this.procesoliquidacionAdditional=procesoliquidacionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Boolean getes_reversar() {
		return this.es_reversar;
	}
	
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoLiquidacion:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_reversar(Boolean newes_reversar)throws Exception
	{
		try {
			if(this.es_reversar!=newes_reversar) {
				if(newes_reversar==null) {
					//newes_reversar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoLiquidacion:Valor nulo no permitido en columna es_reversar");
					}
				}

				this.es_reversar=newes_reversar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	String es_reversar_descripcion="";
	
	
	public String getes_reversar_descripcion() {
		return es_reversar_descripcion;
	}
	
	
	public void setes_reversar_descripcion(String newes_reversar_descripcion)throws Exception {
		try {
			this.es_reversar_descripcion=newes_reversar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.es_reversar_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

