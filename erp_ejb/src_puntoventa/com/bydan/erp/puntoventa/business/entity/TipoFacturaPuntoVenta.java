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
//import com.bydan.erp.puntoventa.util.TipoFacturaPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class TipoFacturaPuntoVenta extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoFacturaPuntoVentaAdditional,GeneralEntity
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
	
	private TipoFacturaPuntoVenta tipofacturapuntoventaOriginal;
	
	private Map<String, Object> mapTipoFacturaPuntoVenta;
			
	public Map<String, Object> getMapTipoFacturaPuntoVenta() {
		return mapTipoFacturaPuntoVenta;
	}

	public void setMapTipoFacturaPuntoVenta(Map<String, Object> mapTipoFacturaPuntoVenta) {
		this.mapTipoFacturaPuntoVenta = mapTipoFacturaPuntoVenta;
	}
	
	public void inicializarMapTipoFacturaPuntoVenta() {
		this.mapTipoFacturaPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapTipoFacturaPuntoVentaValue(String sKey,Object oValue) {
		this.mapTipoFacturaPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapTipoFacturaPuntoVentaValue(String sKey) {
		return this.mapTipoFacturaPuntoVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoFacturaPuntoVentaConstantesFunciones.SREGEXNOMBRE,message=TipoFacturaPuntoVentaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoFacturaPuntoVentaConstantesFunciones.SREGEXDESCRIPCION,message=TipoFacturaPuntoVentaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	
	
	
	
	public List<FacturaPuntoVenta> facturapuntoventas;
	public List<NotaCreditoPuntoVenta> notacreditopuntoventas;
		
	public TipoFacturaPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipofacturapuntoventaOriginal=this;
		
 		this.nombre="";
 		this.descripcion="";
		
		
		
		
		
		
		this.facturapuntoventas=null;
		this.notacreditopuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoFacturaPuntoVenta (Long id,Date versionRow,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipofacturapuntoventaOriginal=this;
		
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoFacturaPuntoVenta (String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipofacturapuntoventaOriginal=this;
		
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoFacturaPuntoVenta tipofacturapuntoventaLocal=null;
		
		if(object!=null) {
			tipofacturapuntoventaLocal=(TipoFacturaPuntoVenta)object;
			
			if(tipofacturapuntoventaLocal!=null) {
				if(this.getId()!=null && tipofacturapuntoventaLocal.getId()!=null) {
					if(this.getId().equals(tipofacturapuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoFacturaPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcion(this);
		} else {
			sDetalle=TipoFacturaPuntoVentaConstantesFunciones.getTipoFacturaPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoFacturaPuntoVenta getTipoFacturaPuntoVentaOriginal() {
		return this.tipofacturapuntoventaOriginal;
	}
	
	public void setTipoFacturaPuntoVentaOriginal(TipoFacturaPuntoVenta tipofacturapuntoventa) {
		try {
			this.tipofacturapuntoventaOriginal=tipofacturapuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoFacturaPuntoVenta:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoFacturaPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("TipoFacturaPuntoVenta:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("TipoFacturaPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<FacturaPuntoVenta> getFacturaPuntoVentas() {
		return this.facturapuntoventas;
	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas() {
		return this.notacreditopuntoventas;
	}

	
	
	public  void  setFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas) {
		try {
			this.facturapuntoventas=facturapuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas) {
		try {
			this.notacreditopuntoventas=notacreditopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object facturapuntoventasDescripcionReporte;
	Object notacreditopuntoventasDescripcionReporte;
	
	
	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	
	
	public  void  setfacturapuntoventasDescripcionReporte(Object facturapuntoventas) {
		try {
			this.facturapuntoventasDescripcionReporte=facturapuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditopuntoventasDescripcionReporte(Object notacreditopuntoventas) {
		try {
			this.notacreditopuntoventasDescripcionReporte=notacreditopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

