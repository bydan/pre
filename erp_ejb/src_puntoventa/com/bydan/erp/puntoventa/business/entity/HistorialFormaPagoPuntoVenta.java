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
//import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class HistorialFormaPagoPuntoVenta extends HistorialFormaPagoPuntoVentaAdditional implements Serializable ,Cloneable {//HistorialFormaPagoPuntoVentaAdditional,GeneralEntity
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
	
	private HistorialFormaPagoPuntoVenta historialformapagopuntoventaOriginal;
	
	private Map<String, Object> mapHistorialFormaPagoPuntoVenta;
			
	public Map<String, Object> getMapHistorialFormaPagoPuntoVenta() {
		return mapHistorialFormaPagoPuntoVenta;
	}

	public void setMapHistorialFormaPagoPuntoVenta(Map<String, Object> mapHistorialFormaPagoPuntoVenta) {
		this.mapHistorialFormaPagoPuntoVenta = mapHistorialFormaPagoPuntoVenta;
	}
	
	public void inicializarMapHistorialFormaPagoPuntoVenta() {
		this.mapHistorialFormaPagoPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapHistorialFormaPagoPuntoVentaValue(String sKey,Object oValue) {
		this.mapHistorialFormaPagoPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapHistorialFormaPagoPuntoVentaValue(String sKey) {
		return this.mapHistorialFormaPagoPuntoVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura_punto_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
			
	
	public FacturaPuntoVenta facturapuntoventa;
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String facturapuntoventa_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public HistorialFormaPagoPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.historialformapagopuntoventaOriginal=this;
		
 		this.id_factura_punto_venta=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
		
		
		this.facturapuntoventa=null;
		this.empresa=null;
		this.sucursal=null;
		
		
		this.facturapuntoventa_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public HistorialFormaPagoPuntoVenta (Long id,Date versionRow,Long id_factura_punto_venta,Long id_empresa,Long id_sucursal) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialformapagopuntoventaOriginal=this;
		
 		this.id_factura_punto_venta=id_factura_punto_venta;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public HistorialFormaPagoPuntoVenta (Long id_factura_punto_venta,Long id_empresa,Long id_sucursal) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialformapagopuntoventaOriginal=this;
		
 		this.id_factura_punto_venta=id_factura_punto_venta;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		HistorialFormaPagoPuntoVenta historialformapagopuntoventaLocal=null;
		
		if(object!=null) {
			historialformapagopuntoventaLocal=(HistorialFormaPagoPuntoVenta)object;
			
			if(historialformapagopuntoventaLocal!=null) {
				if(this.getId()!=null && historialformapagopuntoventaLocal.getId()!=null) {
					if(this.getId().equals(historialformapagopuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!HistorialFormaPagoPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=HistorialFormaPagoPuntoVentaConstantesFunciones.getHistorialFormaPagoPuntoVentaDescripcion(this);
		} else {
			sDetalle=HistorialFormaPagoPuntoVentaConstantesFunciones.getHistorialFormaPagoPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public HistorialFormaPagoPuntoVenta getHistorialFormaPagoPuntoVentaOriginal() {
		return this.historialformapagopuntoventaOriginal;
	}
	
	public void setHistorialFormaPagoPuntoVentaOriginal(HistorialFormaPagoPuntoVenta historialformapagopuntoventa) {
		try {
			this.historialformapagopuntoventaOriginal=historialformapagopuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected HistorialFormaPagoPuntoVentaAdditional historialformapagopuntoventaAdditional=null;
	
	public HistorialFormaPagoPuntoVentaAdditional getHistorialFormaPagoPuntoVentaAdditional() {
		return this.historialformapagopuntoventaAdditional;
	}
	
	public void setHistorialFormaPagoPuntoVentaAdditional(HistorialFormaPagoPuntoVentaAdditional historialformapagopuntoventaAdditional) {
		try {
			this.historialformapagopuntoventaAdditional=historialformapagopuntoventaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_factura_punto_venta() {
		return this.id_factura_punto_venta;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
	
    
	public void setid_factura_punto_venta(Long newid_factura_punto_venta)throws Exception
	{
		try {
			if(this.id_factura_punto_venta!=newid_factura_punto_venta) {
				if(newid_factura_punto_venta==null) {
					//newid_factura_punto_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialFormaPagoPuntoVenta:Valor nulo no permitido en columna id_factura_punto_venta");
					}
				}

				this.id_factura_punto_venta=newid_factura_punto_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialFormaPagoPuntoVenta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialFormaPagoPuntoVenta:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public FacturaPuntoVenta getFacturaPuntoVenta() {
		return this.facturapuntoventa;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String getfacturapuntoventa_descripcion() {
		return this.facturapuntoventa_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setFacturaPuntoVenta(FacturaPuntoVenta facturapuntoventa) {
		try {
			this.facturapuntoventa=facturapuntoventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setfacturapuntoventa_descripcion(String facturapuntoventa_descripcion) {
		try {
			this.facturapuntoventa_descripcion=facturapuntoventa_descripcion;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_factura_punto_venta_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_factura_punto_venta_descripcion() {
		return id_factura_punto_venta_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	
	
	public void setid_factura_punto_venta_descripcion(String newid_factura_punto_venta_descripcion)throws Exception {
		try {
			this.id_factura_punto_venta_descripcion=newid_factura_punto_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_factura_punto_venta_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

