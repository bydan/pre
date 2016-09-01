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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class IndiceCorreccionActivoFijo extends IndiceCorreccionActivoFijoAdditional implements Serializable ,Cloneable {//IndiceCorreccionActivoFijoAdditional,GeneralEntity
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
	
	private IndiceCorreccionActivoFijo indicecorreccionactivofijoOriginal;
	
	private Map<String, Object> mapIndiceCorreccionActivoFijo;
			
	public Map<String, Object> getMapIndiceCorreccionActivoFijo() {
		return mapIndiceCorreccionActivoFijo;
	}

	public void setMapIndiceCorreccionActivoFijo(Map<String, Object> mapIndiceCorreccionActivoFijo) {
		this.mapIndiceCorreccionActivoFijo = mapIndiceCorreccionActivoFijo;
	}
	
	public void inicializarMapIndiceCorreccionActivoFijo() {
		this.mapIndiceCorreccionActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapIndiceCorreccionActivoFijoValue(String sKey,Object oValue) {
		this.mapIndiceCorreccionActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapIndiceCorreccionActivoFijoValue(String sKey) {
		return this.mapIndiceCorreccionActivoFijo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public IndiceCorreccionActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.indicecorreccionactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.anio=0;
 		this.valor=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public IndiceCorreccionActivoFijo (Long id,Date versionRow,Long id_empresa,Integer anio,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.indicecorreccionactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.anio=anio;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public IndiceCorreccionActivoFijo (Long id_empresa,Integer anio,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.indicecorreccionactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.anio=anio;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		IndiceCorreccionActivoFijo indicecorreccionactivofijoLocal=null;
		
		if(object!=null) {
			indicecorreccionactivofijoLocal=(IndiceCorreccionActivoFijo)object;
			
			if(indicecorreccionactivofijoLocal!=null) {
				if(this.getId()!=null && indicecorreccionactivofijoLocal.getId()!=null) {
					if(this.getId().equals(indicecorreccionactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!IndiceCorreccionActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=IndiceCorreccionActivoFijoConstantesFunciones.getIndiceCorreccionActivoFijoDescripcion(this);
		} else {
			sDetalle=IndiceCorreccionActivoFijoConstantesFunciones.getIndiceCorreccionActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public IndiceCorreccionActivoFijo getIndiceCorreccionActivoFijoOriginal() {
		return this.indicecorreccionactivofijoOriginal;
	}
	
	public void setIndiceCorreccionActivoFijoOriginal(IndiceCorreccionActivoFijo indicecorreccionactivofijo) {
		try {
			this.indicecorreccionactivofijoOriginal=indicecorreccionactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected IndiceCorreccionActivoFijoAdditional indicecorreccionactivofijoAdditional=null;
	
	public IndiceCorreccionActivoFijoAdditional getIndiceCorreccionActivoFijoAdditional() {
		return this.indicecorreccionactivofijoAdditional;
	}
	
	public void setIndiceCorreccionActivoFijoAdditional(IndiceCorreccionActivoFijoAdditional indicecorreccionactivofijoAdditional) {
		try {
			this.indicecorreccionactivofijoAdditional=indicecorreccionactivofijoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Integer getanio() {
		return this.anio;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("IndiceCorreccionActivoFijo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setanio(Integer newanio)throws Exception
	{
		try {
			if(this.anio!=newanio) {
				if(newanio==null) {
					//newanio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("IndiceCorreccionActivoFijo:Valor nulo no permitido en columna anio");
					}
				}

				this.anio=newanio;
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
						System.out.println("IndiceCorreccionActivoFijo:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

