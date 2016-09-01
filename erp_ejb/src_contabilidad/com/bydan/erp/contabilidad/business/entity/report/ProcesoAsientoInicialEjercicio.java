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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.ProcesoAsientoInicialEjercicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoAsientoInicialEjercicio extends ProcesoAsientoInicialEjercicioAdditional implements Serializable ,Cloneable {//ProcesoAsientoInicialEjercicioAdditional,GeneralEntity
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
	
	private ProcesoAsientoInicialEjercicio procesoasientoinicialejercicioOriginal;
	
	private Map<String, Object> mapProcesoAsientoInicialEjercicio;
			
	public Map<String, Object> getMapProcesoAsientoInicialEjercicio() {
		return mapProcesoAsientoInicialEjercicio;
	}

	public void setMapProcesoAsientoInicialEjercicio(Map<String, Object> mapProcesoAsientoInicialEjercicio) {
		this.mapProcesoAsientoInicialEjercicio = mapProcesoAsientoInicialEjercicio;
	}
	
	public void inicializarMapProcesoAsientoInicialEjercicio() {
		this.mapProcesoAsientoInicialEjercicio = new HashMap<String,Object>();
	}
	
	public void setMapProcesoAsientoInicialEjercicioValue(String sKey,Object oValue) {
		this.mapProcesoAsientoInicialEjercicio.put(sKey, oValue);
	}
	
	public Object getMapProcesoAsientoInicialEjercicioValue(String sKey) {
		return this.mapProcesoAsientoInicialEjercicio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
			
	
	public TipoDocumento tipodocumento;
	
	
	private String tipodocumento_descripcion;
	
	
		
	public ProcesoAsientoInicialEjercicio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesoasientoinicialejercicioOriginal=this;
		
 		this.id_tipo_documento=-1L;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
		
		
		this.tipodocumento=null;
		
		
		this.tipodocumento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	
	public ProcesoAsientoInicialEjercicio getProcesoAsientoInicialEjercicioOriginal() {
		return this.procesoasientoinicialejercicioOriginal;
	}
	
	public void setProcesoAsientoInicialEjercicioOriginal(ProcesoAsientoInicialEjercicio procesoasientoinicialejercicio) {
		try {
			this.procesoasientoinicialejercicioOriginal=procesoasientoinicialejercicio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoAsientoInicialEjercicioAdditional procesoasientoinicialejercicioAdditional=null;
	
	public ProcesoAsientoInicialEjercicioAdditional getProcesoAsientoInicialEjercicioAdditional() {
		return this.procesoasientoinicialejercicioAdditional;
	}
	
	public void setProcesoAsientoInicialEjercicioAdditional(ProcesoAsientoInicialEjercicioAdditional procesoasientoinicialejercicioAdditional) {
		try {
			this.procesoasientoinicialejercicioAdditional=procesoasientoinicialejercicioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_documento() {
		return this.id_tipo_documento;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
	
    
	public void setid_tipo_documento(Long newid_tipo_documento)throws Exception
	{
		try {
			if(this.id_tipo_documento!=newid_tipo_documento) {
				if(newid_tipo_documento==null) {
					//newid_tipo_documento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoAsientoInicialEjercicio:Valor nulo no permitido en columna id_tipo_documento");
					}
				}

				this.id_tipo_documento=newid_tipo_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoAsientoInicialEjercicio:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoAsientoInicialEjercicio:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoDocumento getTipoDocumento() {
		return this.tipodocumento;
	}

	
	
	public String gettipodocumento_descripcion() {
		return this.tipodocumento_descripcion;
	}

	
	
	public  void  setTipoDocumento(TipoDocumento tipodocumento) {
		try {
			this.tipodocumento=tipodocumento;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipodocumento_descripcion(String tipodocumento_descripcion) {
		try {
			this.tipodocumento_descripcion=tipodocumento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_documento_descripcion="";
	
	
	public String getid_tipo_documento_descripcion() {
		return id_tipo_documento_descripcion;
	}
	
	
	public void setid_tipo_documento_descripcion(String newid_tipo_documento_descripcion)throws Exception {
		try {
			this.id_tipo_documento_descripcion=newid_tipo_documento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_documento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

