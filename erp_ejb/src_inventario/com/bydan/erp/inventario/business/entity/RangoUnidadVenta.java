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
//import com.bydan.erp.inventario.util.RangoUnidadVentaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class RangoUnidadVenta extends RangoUnidadVentaAdditional implements Serializable ,Cloneable {//RangoUnidadVentaAdditional,GeneralEntity
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
	
	private RangoUnidadVenta rangounidadventaOriginal;
	
	private Map<String, Object> mapRangoUnidadVenta;
			
	public Map<String, Object> getMapRangoUnidadVenta() {
		return mapRangoUnidadVenta;
	}

	public void setMapRangoUnidadVenta(Map<String, Object> mapRangoUnidadVenta) {
		this.mapRangoUnidadVenta = mapRangoUnidadVenta;
	}
	
	public void inicializarMapRangoUnidadVenta() {
		this.mapRangoUnidadVenta = new HashMap<String,Object>();
	}
	
	public void setMapRangoUnidadVentaValue(String sKey,Object oValue) {
		this.mapRangoUnidadVenta.put(sKey, oValue);
	}
	
	public Object getMapRangoUnidadVentaValue(String sKey) {
		return this.mapRangoUnidadVenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double rango_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double rango_final;
			
	
	public Empresa empresa;
	public Unidad unidad;
	
	
	private String empresa_descripcion;
	private String unidad_descripcion;
	
	
	public List<Precio> precios;
	public List<ParametroInventarioDefecto> parametroinventariodefectos;
		
	public RangoUnidadVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.rangounidadventaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_unidad=-1L;
 		this.rango_inicial=0.0;
 		this.rango_final=0.0;
		
		
		this.empresa=null;
		this.unidad=null;
		
		
		this.empresa_descripcion="";
		this.unidad_descripcion="";
		
		
		this.precios=null;
		this.parametroinventariodefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RangoUnidadVenta (Long id,Date versionRow,Long id_empresa,Long id_unidad,Double rango_inicial,Double rango_final) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rangounidadventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_unidad=id_unidad;
 		this.rango_inicial=rango_inicial;
 		this.rango_final=rango_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RangoUnidadVenta (Long id_empresa,Long id_unidad,Double rango_inicial,Double rango_final) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rangounidadventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_unidad=id_unidad;
 		this.rango_inicial=rango_inicial;
 		this.rango_final=rango_final;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RangoUnidadVenta rangounidadventaLocal=null;
		
		if(object!=null) {
			rangounidadventaLocal=(RangoUnidadVenta)object;
			
			if(rangounidadventaLocal!=null) {
				if(this.getId()!=null && rangounidadventaLocal.getId()!=null) {
					if(this.getId().equals(rangounidadventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RangoUnidadVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcion(this);
		} else {
			sDetalle=RangoUnidadVentaConstantesFunciones.getRangoUnidadVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RangoUnidadVenta getRangoUnidadVentaOriginal() {
		return this.rangounidadventaOriginal;
	}
	
	public void setRangoUnidadVentaOriginal(RangoUnidadVenta rangounidadventa) {
		try {
			this.rangounidadventaOriginal=rangounidadventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RangoUnidadVentaAdditional rangounidadventaAdditional=null;
	
	public RangoUnidadVentaAdditional getRangoUnidadVentaAdditional() {
		return this.rangounidadventaAdditional;
	}
	
	public void setRangoUnidadVentaAdditional(RangoUnidadVentaAdditional rangounidadventaAdditional) {
		try {
			this.rangounidadventaAdditional=rangounidadventaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Double getrango_inicial() {
		return this.rango_inicial;
	}
    
	
	public Double getrango_final() {
		return this.rango_final;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RangoUnidadVenta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RangoUnidadVenta:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrango_inicial(Double newrango_inicial)throws Exception
	{
		try {
			if(this.rango_inicial!=newrango_inicial) {
				if(newrango_inicial==null) {
					//newrango_inicial=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RangoUnidadVenta:Valor nulo no permitido en columna rango_inicial");
					}
				}

				this.rango_inicial=newrango_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrango_final(Double newrango_final)throws Exception
	{
		try {
			if(this.rango_final!=newrango_final) {
				if(newrango_final==null) {
					//newrango_final=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RangoUnidadVenta:Valor nulo no permitido en columna rango_final");
					}
				}

				this.rango_final=newrango_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
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


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<Precio> getPrecios() {
		return this.precios;
	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() {
		return this.parametroinventariodefectos;
	}

	
	
	public  void  setPrecios(List<Precio> precios) {
		try {
			this.precios=precios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos) {
		try {
			this.parametroinventariodefectos=parametroinventariodefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_unidad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_unidad_descripcion="";
	}
	
	
	Object preciosDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	
	
	public Object getpreciosDescripcionReporte() {
		return preciosDescripcionReporte;
	}

	public Object getparametroinventariodefectosDescripcionReporte() {
		return parametroinventariodefectosDescripcionReporte;
	}

	
	
	public  void  setpreciosDescripcionReporte(Object precios) {
		try {
			this.preciosDescripcionReporte=precios;
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

	/*PARA REPORTES FIN*/		
}

