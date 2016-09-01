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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.TipoViaTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.comisiones.util.*;



import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class TipoViaTransporte extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoViaTransporteAdditional,GeneralEntity
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
	
	private TipoViaTransporte tipoviatransporteOriginal;
	
	private Map<String, Object> mapTipoViaTransporte;
			
	public Map<String, Object> getMapTipoViaTransporte() {
		return mapTipoViaTransporte;
	}

	public void setMapTipoViaTransporte(Map<String, Object> mapTipoViaTransporte) {
		this.mapTipoViaTransporte = mapTipoViaTransporte;
	}
	
	public void inicializarMapTipoViaTransporte() {
		this.mapTipoViaTransporte = new HashMap<String,Object>();
	}
	
	public void setMapTipoViaTransporteValue(String sKey,Object oValue) {
		this.mapTipoViaTransporte.put(sKey, oValue);
	}
	
	public Object getMapTipoViaTransporteValue(String sKey) {
		return this.mapTipoViaTransporte.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoViaTransporteConstantesFunciones.SREGEXNOMBRE,message=TipoViaTransporteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
		
	public TipoViaTransporte () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoviatransporteOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoViaTransporte (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoviatransporteOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoViaTransporte (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoviatransporteOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoViaTransporte tipoviatransporteLocal=null;
		
		if(object!=null) {
			tipoviatransporteLocal=(TipoViaTransporte)object;
			
			if(tipoviatransporteLocal!=null) {
				if(this.getId()!=null && tipoviatransporteLocal.getId()!=null) {
					if(this.getId().equals(tipoviatransporteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoViaTransporteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcion(this);
		} else {
			sDetalle=TipoViaTransporteConstantesFunciones.getTipoViaTransporteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoViaTransporte getTipoViaTransporteOriginal() {
		return this.tipoviatransporteOriginal;
	}
	
	public void setTipoViaTransporteOriginal(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporteOriginal=tipoviatransporte;
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
						System.out.println("TipoViaTransporte:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoViaTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object pedidocompraimporsDescripcionReporte;
	Object proformasDescripcionReporte;
	Object transportesDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	Object embarcadorsDescripcionReporte;
	Object transportistasDescripcionReporte;
	Object parametrofacturaciondefectosDescripcionReporte;
	
	
	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object gettransportesDescripcionReporte() {
		return transportesDescripcionReporte;
	}

	public Object getparametroinventariodefectosDescripcionReporte() {
		return parametroinventariodefectosDescripcionReporte;
	}

	public Object getembarcadorsDescripcionReporte() {
		return embarcadorsDescripcionReporte;
	}

	public Object gettransportistasDescripcionReporte() {
		return transportistasDescripcionReporte;
	}

	public Object getparametrofacturaciondefectosDescripcionReporte() {
		return parametrofacturaciondefectosDescripcionReporte;
	}

	
	
	public  void  setpedidocompraimporsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransportesDescripcionReporte(Object transportes) {
		try {
			this.transportesDescripcionReporte=transportes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroinventariodefectosDescripcionReporte(Object parametroinventariodefectos) {
		try {
			this.parametroinventariodefectosDescripcionReporte=parametroinventariodefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setembarcadorsDescripcionReporte(Object embarcadors) {
		try {
			this.embarcadorsDescripcionReporte=embarcadors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransportistasDescripcionReporte(Object transportistas) {
		try {
			this.transportistasDescripcionReporte=transportistas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrofacturaciondefectosDescripcionReporte(Object parametrofacturaciondefectos) {
		try {
			this.parametrofacturaciondefectosDescripcionReporte=parametrofacturaciondefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

