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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.EmpaqueConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Empaque extends EmpaqueAdditional implements Serializable ,Cloneable {//EmpaqueAdditional,GeneralEntity
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
	
	private Empaque empaqueOriginal;
	
	private Map<String, Object> mapEmpaque;
			
	public Map<String, Object> getMapEmpaque() {
		return mapEmpaque;
	}

	public void setMapEmpaque(Map<String, Object> mapEmpaque) {
		this.mapEmpaque = mapEmpaque;
	}
	
	public void inicializarMapEmpaque() {
		this.mapEmpaque = new HashMap<String,Object>();
	}
	
	public void setMapEmpaqueValue(String sKey,Object oValue) {
		this.mapEmpaque.put(sKey, oValue);
	}
	
	public Object getMapEmpaqueValue(String sKey) {
		return this.mapEmpaque.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmpaqueConstantesFunciones.SREGEXDESCRIPCION,message=EmpaqueConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<DetaNotaCreditoSoli> detanotacreditosolis;
	public List<DetalleProforma> detalleproformas;
		
	public Empaque () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empaqueOriginal=this;
		
 		this.id_empresa=-1L;
 		this.valor=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.detanotacreditosolis=null;
		this.detalleproformas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Empaque (Long id,Date versionRow,Long id_empresa,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empaqueOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Empaque (Long id_empresa,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empaqueOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Empaque empaqueLocal=null;
		
		if(object!=null) {
			empaqueLocal=(Empaque)object;
			
			if(empaqueLocal!=null) {
				if(this.getId()!=null && empaqueLocal.getId()!=null) {
					if(this.getId().equals(empaqueLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpaqueConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpaqueConstantesFunciones.getEmpaqueDescripcion(this);
		} else {
			sDetalle=EmpaqueConstantesFunciones.getEmpaqueDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Empaque getEmpaqueOriginal() {
		return this.empaqueOriginal;
	}
	
	public void setEmpaqueOriginal(Empaque empaque) {
		try {
			this.empaqueOriginal=empaque;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpaqueAdditional empaqueAdditional=null;
	
	public EmpaqueAdditional getEmpaqueAdditional() {
		return this.empaqueAdditional;
	}
	
	public void setEmpaqueAdditional(EmpaqueAdditional empaqueAdditional) {
		try {
			this.empaqueAdditional=empaqueAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empaque:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empaque:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("Empaque:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("Empaque:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis() {
		return this.detanotacreditosolis;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleproformas;
	}

	
	
	public  void  setDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> detanotacreditosolis) {
		try {
			this.detanotacreditosolis=detanotacreditosolis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleProformas(List<DetalleProforma> detalleproformas) {
		try {
			this.detalleproformas=detalleproformas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object detanotacreditosDescripcionReporte;
	Object detalleproformasDescripcionReporte;
	Object detanotacreditosolisDescripcionReporte;
	
	
	public Object getdetanotacreditosDescripcionReporte() {
		return detanotacreditosDescripcionReporte;
	}

	public Object getdetalleproformasDescripcionReporte() {
		return detalleproformasDescripcionReporte;
	}

	public Object getdetanotacreditosolisDescripcionReporte() {
		return detanotacreditosolisDescripcionReporte;
	}

	
	
	public  void  setdetanotacreditosDescripcionReporte(Object detanotacreditos) {
		try {
			this.detanotacreditosDescripcionReporte=detanotacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleproformasDescripcionReporte(Object detalleproformas) {
		try {
			this.detalleproformasDescripcionReporte=detalleproformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetanotacreditosolisDescripcionReporte(Object detanotacreditosolis) {
		try {
			this.detanotacreditosolisDescripcionReporte=detanotacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

