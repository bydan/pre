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
//import com.bydan.erp.inventario.util.NivelLineaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class NivelLinea extends NivelLineaAdditional implements Serializable ,Cloneable {//NivelLineaAdditional,GeneralEntity
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
	
	private NivelLinea nivellineaOriginal;
	
	private Map<String, Object> mapNivelLinea;
			
	public Map<String, Object> getMapNivelLinea() {
		return mapNivelLinea;
	}

	public void setMapNivelLinea(Map<String, Object> mapNivelLinea) {
		this.mapNivelLinea = mapNivelLinea;
	}
	
	public void inicializarMapNivelLinea() {
		this.mapNivelLinea = new HashMap<String,Object>();
	}
	
	public void setMapNivelLineaValue(String sKey,Object oValue) {
		this.mapNivelLinea.put(sKey, oValue);
	}
	
	public Object getMapNivelLineaValue(String sKey) {
		return this.mapNivelLinea.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NivelLineaConstantesFunciones.SREGEXNOMBRE,message=NivelLineaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<Linea> lineas;
	public List<ComisionConfig> comisionconfigs;
		
	public NivelLinea () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.nivellineaOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.lineas=null;
		this.comisionconfigs=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NivelLinea (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivellineaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NivelLinea (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.nivellineaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NivelLinea nivellineaLocal=null;
		
		if(object!=null) {
			nivellineaLocal=(NivelLinea)object;
			
			if(nivellineaLocal!=null) {
				if(this.getId()!=null && nivellineaLocal.getId()!=null) {
					if(this.getId().equals(nivellineaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NivelLineaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NivelLineaConstantesFunciones.getNivelLineaDescripcion(this);
		} else {
			sDetalle=NivelLineaConstantesFunciones.getNivelLineaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NivelLinea getNivelLineaOriginal() {
		return this.nivellineaOriginal;
	}
	
	public void setNivelLineaOriginal(NivelLinea nivellinea) {
		try {
			this.nivellineaOriginal=nivellinea;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NivelLineaAdditional nivellineaAdditional=null;
	
	public NivelLineaAdditional getNivelLineaAdditional() {
		return this.nivellineaAdditional;
	}
	
	public void setNivelLineaAdditional(NivelLineaAdditional nivellineaAdditional) {
		try {
			this.nivellineaAdditional=nivellineaAdditional;
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
						System.out.println("NivelLinea:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("NivelLinea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Linea> getLineas() {
		return this.lineas;
	}

	public List<ComisionConfig> getComisionConfigs() {
		return this.comisionconfigs;
	}

	
	
	public  void  setLineas(List<Linea> lineas) {
		try {
			this.lineas=lineas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionConfigs(List<ComisionConfig> comisionconfigs) {
		try {
			this.comisionconfigs=comisionconfigs;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object lineasDescripcionReporte;
	Object comisionconfigsDescripcionReporte;
	
	
	public Object getlineasDescripcionReporte() {
		return lineasDescripcionReporte;
	}

	public Object getcomisionconfigsDescripcionReporte() {
		return comisionconfigsDescripcionReporte;
	}

	
	
	public  void  setlineasDescripcionReporte(Object lineas) {
		try {
			this.lineasDescripcionReporte=lineas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionconfigsDescripcionReporte(Object comisionconfigs) {
		try {
			this.comisionconfigsDescripcionReporte=comisionconfigs;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

