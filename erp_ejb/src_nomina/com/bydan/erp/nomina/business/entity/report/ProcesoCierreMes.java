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
//import com.bydan.erp.nomina.util.ProcesoCierreMesConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoCierreMes extends ProcesoCierreMesAdditional implements Serializable ,Cloneable {//ProcesoCierreMesAdditional,GeneralEntity
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
	
	private ProcesoCierreMes procesocierremesOriginal;
	
	private Map<String, Object> mapProcesoCierreMes;
			
	public Map<String, Object> getMapProcesoCierreMes() {
		return mapProcesoCierreMes;
	}

	public void setMapProcesoCierreMes(Map<String, Object> mapProcesoCierreMes) {
		this.mapProcesoCierreMes = mapProcesoCierreMes;
	}
	
	public void inicializarMapProcesoCierreMes() {
		this.mapProcesoCierreMes = new HashMap<String,Object>();
	}
	
	public void setMapProcesoCierreMesValue(String sKey,Object oValue) {
		this.mapProcesoCierreMes.put(sKey, oValue);
	}
	
	public Object getMapProcesoCierreMesValue(String sKey) {
		return this.mapProcesoCierreMes.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_reversion;
			
	
	public Mes mes;
	public Estructura estructura;
	
	
	private String mes_descripcion;
	private String estructura_descripcion;
	
	
		
	public ProcesoCierreMes () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesocierremesOriginal=this;
		
 		this.id_mes=null;
 		this.id_estructura=-1L;
 		this.es_para_reversion=false;
		
		
		this.mes=null;
		this.estructura=null;
		
		
		this.mes_descripcion="";
		this.estructura_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoCierreMes getProcesoCierreMesOriginal() {
		return this.procesocierremesOriginal;
	}
	
	public void setProcesoCierreMesOriginal(ProcesoCierreMes procesocierremes) {
		try {
			this.procesocierremesOriginal=procesocierremes;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoCierreMesAdditional procesocierremesAdditional=null;
	
	public ProcesoCierreMesAdditional getProcesoCierreMesAdditional() {
		return this.procesocierremesAdditional;
	}
	
	public void setProcesoCierreMesAdditional(ProcesoCierreMesAdditional procesocierremesAdditional) {
		try {
			this.procesocierremesAdditional=procesocierremesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Boolean getes_para_reversion() {
		return this.es_para_reversion;
	}
	
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierreMes:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_reversion(Boolean newes_para_reversion)throws Exception
	{
		try {
			if(this.es_para_reversion!=newes_para_reversion) {
				if(newes_para_reversion==null) {
					//newes_para_reversion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoCierreMes:Valor nulo no permitido en columna es_para_reversion");
					}
				}

				this.es_para_reversion=newes_para_reversion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Mes getMes() {
		return this.mes;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	
	
	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	
	
	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_mes_descripcion="";String id_estructura_descripcion="";String es_para_reversion_descripcion="";
	
	
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getes_para_reversion_descripcion() {
		return es_para_reversion_descripcion;
	}
	
	
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_reversion_descripcion(String newes_para_reversion_descripcion)throws Exception {
		try {
			this.es_para_reversion_descripcion=newes_para_reversion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_mes_descripcion="";this.id_estructura_descripcion="";this.es_para_reversion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

