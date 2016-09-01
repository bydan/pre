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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.TipoIntervaloConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class TipoIntervalo extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoIntervaloAdditional,GeneralEntity
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
	
	private TipoIntervalo tipointervaloOriginal;
	
	private Map<String, Object> mapTipoIntervalo;
			
	public Map<String, Object> getMapTipoIntervalo() {
		return mapTipoIntervalo;
	}

	public void setMapTipoIntervalo(Map<String, Object> mapTipoIntervalo) {
		this.mapTipoIntervalo = mapTipoIntervalo;
	}
	
	public void inicializarMapTipoIntervalo() {
		this.mapTipoIntervalo = new HashMap<String,Object>();
	}
	
	public void setMapTipoIntervaloValue(String sKey,Object oValue) {
		this.mapTipoIntervalo.put(sKey, oValue);
	}
	
	public Object getMapTipoIntervaloValue(String sKey) {
		return this.mapTipoIntervalo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoIntervaloConstantesFunciones.SREGEXNOMBRE,message=TipoIntervaloConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<ParametroContabilidadDefecto> parametrocontabilidaddefectos;
	public List<TablaAmortiDetalle> tablaamortidetalles;
		
	public TipoIntervalo () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipointervaloOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.parametrocontabilidaddefectos=null;
		this.tablaamortidetalles=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoIntervalo (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipointervaloOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoIntervalo (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipointervaloOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoIntervalo tipointervaloLocal=null;
		
		if(object!=null) {
			tipointervaloLocal=(TipoIntervalo)object;
			
			if(tipointervaloLocal!=null) {
				if(this.getId()!=null && tipointervaloLocal.getId()!=null) {
					if(this.getId().equals(tipointervaloLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoIntervaloConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcion(this);
		} else {
			sDetalle=TipoIntervaloConstantesFunciones.getTipoIntervaloDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoIntervalo getTipoIntervaloOriginal() {
		return this.tipointervaloOriginal;
	}
	
	public void setTipoIntervaloOriginal(TipoIntervalo tipointervalo) {
		try {
			this.tipointervaloOriginal=tipointervalo;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoIntervalo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoIntervalo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos() {
		return this.parametrocontabilidaddefectos;
	}

	public List<TablaAmortiDetalle> getTablaAmortiDetalles() {
		return this.tablaamortidetalles;
	}

	
	
	public  void  setParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectos=parametrocontabilidaddefectos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTablaAmortiDetalles(List<TablaAmortiDetalle> tablaamortidetalles) {
		try {
			this.tablaamortidetalles=tablaamortidetalles;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object cuentacontablesDescripcionReporte;
	Object parametrocontabilidaddefectosDescripcionReporte;
	Object tablaamortidetallesDescripcionReporte;
	
	
	public Object getcuentacontablesDescripcionReporte() {
		return cuentacontablesDescripcionReporte;
	}

	public Object getparametrocontabilidaddefectosDescripcionReporte() {
		return parametrocontabilidaddefectosDescripcionReporte;
	}

	public Object gettablaamortidetallesDescripcionReporte() {
		return tablaamortidetallesDescripcionReporte;
	}

	
	
	public  void  setcuentacontablesDescripcionReporte(Object cuentacontables) {
		try {
			this.cuentacontablesDescripcionReporte=cuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocontabilidaddefectosDescripcionReporte(Object parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectosDescripcionReporte=parametrocontabilidaddefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settablaamortidetallesDescripcionReporte(Object tablaamortidetalles) {
		try {
			this.tablaamortidetallesDescripcionReporte=tablaamortidetalles;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

