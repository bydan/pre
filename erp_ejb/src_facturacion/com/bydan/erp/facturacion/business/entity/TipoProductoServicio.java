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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.TipoProductoServicioConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class TipoProductoServicio extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoProductoServicioAdditional,GeneralEntity
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
	
	private TipoProductoServicio tipoproductoservicioOriginal;
	
	private Map<String, Object> mapTipoProductoServicio;
			
	public Map<String, Object> getMapTipoProductoServicio() {
		return mapTipoProductoServicio;
	}

	public void setMapTipoProductoServicio(Map<String, Object> mapTipoProductoServicio) {
		this.mapTipoProductoServicio = mapTipoProductoServicio;
	}
	
	public void inicializarMapTipoProductoServicio() {
		this.mapTipoProductoServicio = new HashMap<String,Object>();
	}
	
	public void setMapTipoProductoServicioValue(String sKey,Object oValue) {
		this.mapTipoProductoServicio.put(sKey, oValue);
	}
	
	public Object getMapTipoProductoServicioValue(String sKey) {
		return this.mapTipoProductoServicio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoProductoServicioConstantesFunciones.SREGEXNOMBRE,message=TipoProductoServicioConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<CuentaContableTipo> cuentacontabletipos;
	public List<ParametroInventarioDefecto> parametroinventariodefectos;
		
	public TipoProductoServicio () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoproductoservicioOriginal=this;
		
 		this.nombre="";
		
		
		
		
		
		
		this.cuentacontabletipos=null;
		this.parametroinventariodefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoProductoServicio (Long id,Date versionRow,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoproductoservicioOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoProductoServicio (String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoproductoservicioOriginal=this;
		
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoProductoServicio tipoproductoservicioLocal=null;
		
		if(object!=null) {
			tipoproductoservicioLocal=(TipoProductoServicio)object;
			
			if(tipoproductoservicioLocal!=null) {
				if(this.getId()!=null && tipoproductoservicioLocal.getId()!=null) {
					if(this.getId().equals(tipoproductoservicioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoProductoServicioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcion(this);
		} else {
			sDetalle=TipoProductoServicioConstantesFunciones.getTipoProductoServicioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoProductoServicio getTipoProductoServicioOriginal() {
		return this.tipoproductoservicioOriginal;
	}
	
	public void setTipoProductoServicioOriginal(TipoProductoServicio tipoproductoservicio) {
		try {
			this.tipoproductoservicioOriginal=tipoproductoservicio;
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
						System.out.println("TipoProductoServicio:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoProductoServicio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<CuentaContableTipo> getCuentaContableTipos() {
		return this.cuentacontabletipos;
	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() {
		return this.parametroinventariodefectos;
	}

	
	
	public  void  setCuentaContableTipos(List<CuentaContableTipo> cuentacontabletipos) {
		try {
			this.cuentacontabletipos=cuentacontabletipos;
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
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object productosDescripcionReporte;
	Object cuentacontabletiposDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	
	
	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
	}

	public Object getcuentacontabletiposDescripcionReporte() {
		return cuentacontabletiposDescripcionReporte;
	}

	public Object getparametroinventariodefectosDescripcionReporte() {
		return parametroinventariodefectosDescripcionReporte;
	}

	
	
	public  void  setproductosDescripcionReporte(Object productos) {
		try {
			this.productosDescripcionReporte=productos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentacontabletiposDescripcionReporte(Object cuentacontabletipos) {
		try {
			this.cuentacontabletiposDescripcionReporte=cuentacontabletipos;
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

