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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.EstadoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class EstadoFacturaPuntoVenta extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//EstadoFacturaPuntoVentaAdditional,GeneralEntity
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
	
	private EstadoFacturaPuntoVenta estadofacturapuntoventaOriginal;
	
	private Map<String, Object> mapEstadoFacturaPuntoVenta;
			
	public Map<String, Object> getMapEstadoFacturaPuntoVenta() {
		return mapEstadoFacturaPuntoVenta;
	}

	public void setMapEstadoFacturaPuntoVenta(Map<String, Object> mapEstadoFacturaPuntoVenta) {
		this.mapEstadoFacturaPuntoVenta = mapEstadoFacturaPuntoVenta;
	}
	
	public void inicializarMapEstadoFacturaPuntoVenta() {
		this.mapEstadoFacturaPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapEstadoFacturaPuntoVentaValue(String sKey,Object oValue) {
		this.mapEstadoFacturaPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapEstadoFacturaPuntoVentaValue(String sKey) {
		return this.mapEstadoFacturaPuntoVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoFacturaPuntoVentaConstantesFunciones.SREGEXNOMBRE,message=EstadoFacturaPuntoVentaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<FacturaPuntoVenta> facturapuntoventas;
		
	public EstadoFacturaPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadofacturapuntoventaOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.facturapuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoFacturaPuntoVenta (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadofacturapuntoventaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoFacturaPuntoVenta (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadofacturapuntoventaOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoFacturaPuntoVenta estadofacturapuntoventaLocal=null;
		
		if(object!=null) {
			estadofacturapuntoventaLocal=(EstadoFacturaPuntoVenta)object;
			
			if(estadofacturapuntoventaLocal!=null) {
				if(this.getId()!=null && estadofacturapuntoventaLocal.getId()!=null) {
					if(this.getId().equals(estadofacturapuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoFacturaPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaDescripcion(this);
		} else {
			sDetalle=EstadoFacturaPuntoVentaConstantesFunciones.getEstadoFacturaPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoFacturaPuntoVenta getEstadoFacturaPuntoVentaOriginal() {
		return this.estadofacturapuntoventaOriginal;
	}
	
	public void setEstadoFacturaPuntoVentaOriginal(EstadoFacturaPuntoVenta estadofacturapuntoventa) {
		try {
			this.estadofacturapuntoventaOriginal=estadofacturapuntoventa;
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
						System.out.println("EstadoFacturaPuntoVenta:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("EstadoFacturaPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<FacturaPuntoVenta> getFacturaPuntoVentas() {
		return this.facturapuntoventas;
	}

	
	
	public  void  setFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas) {
		try {
			this.facturapuntoventas=facturapuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object facturapuntoventasDescripcionReporte;
	
	
	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	
	
	public  void  setfacturapuntoventasDescripcionReporte(Object facturapuntoventas) {
		try {
			this.facturapuntoventasDescripcionReporte=facturapuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

