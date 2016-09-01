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
//import com.bydan.erp.inventario.util.UnidadConstantesFunciones;
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
public class Unidad extends UnidadAdditional implements Serializable ,Cloneable {//UnidadAdditional,GeneralEntity
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
	
	private Unidad unidadOriginal;
	
	private Map<String, Object> mapUnidad;
			
	public Map<String, Object> getMapUnidad() {
		return mapUnidad;
	}

	public void setMapUnidad(Map<String, Object> mapUnidad) {
		this.mapUnidad = mapUnidad;
	}
	
	public void inicializarMapUnidad() {
		this.mapUnidad = new HashMap<String,Object>();
	}
	
	public void setMapUnidadValue(String sKey,Object oValue) {
		this.mapUnidad.put(sKey, oValue);
	}
	
	public Object getMapUnidadValue(String sKey) {
		return this.mapUnidad.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UnidadConstantesFunciones.SREGEXNOMBRE,message=UnidadConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UnidadConstantesFunciones.SREGEXSIGLAS,message=UnidadConstantesFunciones.SMENSAJEREGEXSIGLAS)
	private String siglas;
			
	
	public Empresa empresa;
	public TipoUnidad tipounidad;
	
	
	private String empresa_descripcion;
	private String tipounidad_descripcion;
	
	
	public List<Producto> productos;
	public List<ConversionInven> conversioninvenConversions;
	public List<RangoUnidadVenta> rangounidadventas;
	public List<ValorPorUnidad> valorporunidads;
		
	public Unidad () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.unidadOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_unidad=-1L;
 		this.nombre="";
 		this.siglas="";
		
		
		this.empresa=null;
		this.tipounidad=null;
		
		
		this.empresa_descripcion="";
		this.tipounidad_descripcion="";
		
		
		this.productos=null;
		this.conversioninvenConversions=null;
		this.rangounidadventas=null;
		this.valorporunidads=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Unidad (Long id,Date versionRow,Long id_empresa,Long id_tipo_unidad,String nombre,String siglas) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.unidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_unidad=id_tipo_unidad;
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Unidad (Long id_empresa,Long id_tipo_unidad,String nombre,String siglas) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.unidadOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_unidad=id_tipo_unidad;
 		this.nombre=nombre;
 		this.siglas=siglas;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Unidad unidadLocal=null;
		
		if(object!=null) {
			unidadLocal=(Unidad)object;
			
			if(unidadLocal!=null) {
				if(this.getId()!=null && unidadLocal.getId()!=null) {
					if(this.getId().equals(unidadLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UnidadConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UnidadConstantesFunciones.getUnidadDescripcion(this);
		} else {
			sDetalle=UnidadConstantesFunciones.getUnidadDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Unidad getUnidadOriginal() {
		return this.unidadOriginal;
	}
	
	public void setUnidadOriginal(Unidad unidad) {
		try {
			this.unidadOriginal=unidad;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UnidadAdditional unidadAdditional=null;
	
	public UnidadAdditional getUnidadAdditional() {
		return this.unidadAdditional;
	}
	
	public void setUnidadAdditional(UnidadAdditional unidadAdditional) {
		try {
			this.unidadAdditional=unidadAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_unidad() {
		return this.id_tipo_unidad;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsiglas() {
		return this.siglas;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Unidad:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_unidad(Long newid_tipo_unidad)throws Exception
	{
		try {
			if(this.id_tipo_unidad!=newid_tipo_unidad) {
				if(newid_tipo_unidad==null) {
					//newid_tipo_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Unidad:Valor nulo no permitido en columna id_tipo_unidad");
					}
				}

				this.id_tipo_unidad=newid_tipo_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Unidad:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Unidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
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
						System.out.println("Unidad:Valor nulo no permitido en columna siglas");
					}
				}

				if(newsiglas!=null&&newsiglas.length()>50) {
					newsiglas=newsiglas.substring(0,48);
					System.out.println("Unidad:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna siglas");
				}

				this.siglas=newsiglas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoUnidad getTipoUnidad() {
		return this.tipounidad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipounidad_descripcion() {
		return this.tipounidad_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoUnidad(TipoUnidad tipounidad) {
		try {
			this.tipounidad=tipounidad;
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


	public  void  settipounidad_descripcion(String tipounidad_descripcion) {
		try {
			this.tipounidad_descripcion=tipounidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<Producto> getProductos() {
		return this.productos;
	}

	public List<ConversionInven> getConversionInvenConversions() {
		return this.conversioninvenConversions;
	}

	public List<RangoUnidadVenta> getRangoUnidadVentas() {
		return this.rangounidadventas;
	}

	public List<ValorPorUnidad> getValorPorUnidads() {
		return this.valorporunidads;
	}

	
	
	public  void  setProductos(List<Producto> productos) {
		try {
			this.productos=productos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setConversionInvenConversions(List<ConversionInven> conversioninvenConversions) {
		try {
			this.conversioninvenConversions=conversioninvenConversions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRangoUnidadVentas(List<RangoUnidadVenta> rangounidadventas) {
		try {
			this.rangounidadventas=rangounidadventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setValorPorUnidads(List<ValorPorUnidad> valorporunidads) {
		try {
			this.valorporunidads=valorporunidads;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_unidad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_unidad_descripcion() {
		return id_tipo_unidad_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_unidad_descripcion(String newid_tipo_unidad_descripcion)throws Exception {
		try {
			this.id_tipo_unidad_descripcion=newid_tipo_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_unidad_descripcion="";
	}
	
	
	Object productosDescripcionReporte;
	Object conversioninvenConversionsDescripcionReporte;
	Object rangounidadventasDescripcionReporte;
	Object valorporunidadsDescripcionReporte;
	
	
	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
	}

	public Object getconversioninvenConversionsDescripcionReporte() {
		return conversioninvenConversionsDescripcionReporte;
	}

	public Object getrangounidadventasDescripcionReporte() {
		return rangounidadventasDescripcionReporte;
	}

	public Object getvalorporunidadsDescripcionReporte() {
		return valorporunidadsDescripcionReporte;
	}

	
	
	public  void  setproductosDescripcionReporte(Object productos) {
		try {
			this.productosDescripcionReporte=productos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconversioninvenConversionsDescripcionReporte(Object conversioninvens) {
		try {
			this.conversioninvenConversionsDescripcionReporte=conversioninvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrangounidadventasDescripcionReporte(Object rangounidadventas) {
		try {
			this.rangounidadventasDescripcionReporte=rangounidadventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvalorporunidadsDescripcionReporte(Object valorporunidads) {
		try {
			this.valorporunidadsDescripcionReporte=valorporunidads;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

