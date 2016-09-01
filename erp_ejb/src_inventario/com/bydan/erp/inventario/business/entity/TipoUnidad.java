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
//import com.bydan.erp.inventario.util.TipoUnidadConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.importaciones.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;




@SuppressWarnings("unused")
public class TipoUnidad extends TipoUnidadAdditional implements Serializable ,Cloneable {//TipoUnidadAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoUnidad tipounidadOriginal;
	
	private Map<String, Object> mapTipoUnidad;
			
	public Map<String, Object> getMapTipoUnidad() {
		return mapTipoUnidad;
	}

	public void setMapTipoUnidad(Map<String, Object> mapTipoUnidad) {
		this.mapTipoUnidad = mapTipoUnidad;
	}
	
	public void inicializarMapTipoUnidad() {
		this.mapTipoUnidad = new HashMap<String,Object>();
	}
	
	public void setMapTipoUnidadValue(String sKey,Object oValue) {
		this.mapTipoUnidad.put(sKey, oValue);
	}
	
	public Object getMapTipoUnidadValue(String sKey) {
		return this.mapTipoUnidad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoUnidadConstantesFunciones.SREGEXNOMBRE,message=TipoUnidadConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoUnidadConstantesFunciones.SREGEXSIGLAS,message=TipoUnidadConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
			
	
	
	
	
	
	public List<Unidad> unidads;
		
	public TipoUnidad () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipounidadOriginal=this;
		
 		this.nombre="";
 		this.siglas="";
		
		
		
		
		
		
		this.unidads=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoUnidad (Long id,Date versionRow,String nombre,String siglas) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipounidadOriginal=this;
		
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoUnidad (String nombre,String siglas) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipounidadOriginal=this;
		
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoUnidad tipounidadLocal=null;
		
		if(object!=null) {
			tipounidadLocal=(TipoUnidad)object;
			
			if(tipounidadLocal!=null) {
				if(this.getId()!=null && tipounidadLocal.getId()!=null) {
					if(this.getId().equals(tipounidadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoUnidadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoUnidadConstantesFunciones.getTipoUnidadDescripcion(this);
		} else {
			sDetalle=TipoUnidadConstantesFunciones.getTipoUnidadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoUnidad getTipoUnidadOriginal() {
		return this.tipounidadOriginal;
	}
	
	public void setTipoUnidadOriginal(TipoUnidad tipounidad) {
		try {
			this.tipounidadOriginal=tipounidad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoUnidadAdditional tipounidadAdditional=null;
	
	public TipoUnidadAdditional getTipoUnidadAdditional() {
		return this.tipounidadAdditional;
	}
	
	public void setTipoUnidadAdditional(TipoUnidadAdditional tipounidadAdditional) {
		try {
			this.tipounidadAdditional=tipounidadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoUnidad:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("TipoUnidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas(String newsiglas)throws Exception
	{
		try {
			if(this.siglas!=newsiglas) {
				if(newsiglas==null) {
					//newsiglas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoUnidad:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>50) {
					newsiglas=newsiglas.substring(0,48);
					System.out.println("TipoUnidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Unidad> getUnidads() {
		return this.unidads;
	}

	
	
	public  void  setUnidads(List<Unidad> unidads) {
		try {
			this.unidads=unidads;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object unidadsDescripcionReporte;
	
	
	public Object getunidadsDescripcionReporte() {
		return unidadsDescripcionReporte;
	}

	
	
	public  void  setunidadsDescripcionReporte(Object unidads) {
		try {
			this.unidadsDescripcionReporte=unidads;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

