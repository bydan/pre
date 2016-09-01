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
//import com.bydan.erp.inventario.util.ColorProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class ColorProducto extends ColorProductoAdditional implements Serializable ,Cloneable {//ColorProductoAdditional,GeneralEntity
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
	
	private ColorProducto colorproductoOriginal;
	
	private Map<String, Object> mapColorProducto;
			
	public Map<String, Object> getMapColorProducto() {
		return mapColorProducto;
	}

	public void setMapColorProducto(Map<String, Object> mapColorProducto) {
		this.mapColorProducto = mapColorProducto;
	}
	
	public void inicializarMapColorProducto() {
		this.mapColorProducto = new HashMap<String,Object>();
	}
	
	public void setMapColorProductoValue(String sKey,Object oValue) {
		this.mapColorProducto.put(sKey, oValue);
	}
	
	public Object getMapColorProductoValue(String sKey) {
		return this.mapColorProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_color;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ColorProductoConstantesFunciones.SREGEXCODIGO,message=ColorProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ColorProductoConstantesFunciones.SREGEXNOMBRE,message=ColorProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	public TipoProducto tipoproducto;
	public GrupoColor grupocolor;
	
	
	private String empresa_descripcion;
	private String tipoproducto_descripcion;
	private String grupocolor_descripcion;
	
	
	public List<ParametroInventarioDefecto> parametroinventariodefectos;
		
	public ColorProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.colorproductoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_producto=-1L;
 		this.id_grupo_color=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.empresa=null;
		this.tipoproducto=null;
		this.grupocolor=null;
		
		
		this.empresa_descripcion="";
		this.tipoproducto_descripcion="";
		this.grupocolor_descripcion="";
		
		
		this.parametroinventariodefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ColorProducto (Long id,Date versionRow,Long id_empresa,Long id_tipo_producto,Long id_grupo_color,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.colorproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_grupo_color=id_grupo_color;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ColorProducto (Long id_empresa,Long id_tipo_producto,Long id_grupo_color,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.colorproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_grupo_color=id_grupo_color;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ColorProducto colorproductoLocal=null;
		
		if(object!=null) {
			colorproductoLocal=(ColorProducto)object;
			
			if(colorproductoLocal!=null) {
				if(this.getId()!=null && colorproductoLocal.getId()!=null) {
					if(this.getId().equals(colorproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ColorProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ColorProductoConstantesFunciones.getColorProductoDescripcion(this);
		} else {
			sDetalle=ColorProductoConstantesFunciones.getColorProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ColorProducto getColorProductoOriginal() {
		return this.colorproductoOriginal;
	}
	
	public void setColorProductoOriginal(ColorProducto colorproducto) {
		try {
			this.colorproductoOriginal=colorproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ColorProductoAdditional colorproductoAdditional=null;
	
	public ColorProductoAdditional getColorProductoAdditional() {
		return this.colorproductoAdditional;
	}
	
	public void setColorProductoAdditional(ColorProductoAdditional colorproductoAdditional) {
		try {
			this.colorproductoAdditional=colorproductoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_producto() {
		return this.id_tipo_producto;
	}
    
	
	public Long getid_grupo_color() {
		return this.id_grupo_color;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ColorProducto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_producto(Long newid_tipo_producto)throws Exception
	{
		try {
			if(this.id_tipo_producto!=newid_tipo_producto) {
				if(newid_tipo_producto==null) {
					//newid_tipo_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ColorProducto:Valor nulo no permitido en columna id_tipo_producto");
					}
				}

				this.id_tipo_producto=newid_tipo_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_color(Long newid_grupo_color)throws Exception
	{
		try {
			if(this.id_grupo_color!=newid_grupo_color) {
				if(newid_grupo_color==null) {
					//newid_grupo_color=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ColorProducto:Valor nulo no permitido en columna id_grupo_color");
					}
				}

				this.id_grupo_color=newid_grupo_color;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ColorProducto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ColorProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("ColorProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("ColorProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoproducto;
	}

	public GrupoColor getGrupoColor() {
		return this.grupocolor;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoproducto_descripcion() {
		return this.tipoproducto_descripcion;
	}

	public String getgrupocolor_descripcion() {
		return this.grupocolor_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProducto(TipoProducto tipoproducto) {
		try {
			this.tipoproducto=tipoproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoColor(GrupoColor grupocolor) {
		try {
			this.grupocolor=grupocolor;
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


	public  void  settipoproducto_descripcion(String tipoproducto_descripcion) {
		try {
			this.tipoproducto_descripcion=tipoproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupocolor_descripcion(String grupocolor_descripcion) {
		try {
			this.grupocolor_descripcion=grupocolor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() {
		return this.parametroinventariodefectos;
	}

	
	
	public  void  setParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos) {
		try {
			this.parametroinventariodefectos=parametroinventariodefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_producto_descripcion="";String id_grupo_color_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_producto_descripcion() {
		return id_tipo_producto_descripcion;
	}
	public String getid_grupo_color_descripcion() {
		return id_grupo_color_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_producto_descripcion(String newid_tipo_producto_descripcion)throws Exception {
		try {
			this.id_tipo_producto_descripcion=newid_tipo_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_color_descripcion(String newid_grupo_color_descripcion)throws Exception {
		try {
			this.id_grupo_color_descripcion=newid_grupo_color_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_producto_descripcion="";this.id_grupo_color_descripcion="";
	}
	
	
	Object productosDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	
	
	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
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

	public  void  setparametroinventariodefectosDescripcionReporte(Object parametroinventariodefectos) {
		try {
			this.parametroinventariodefectosDescripcionReporte=parametroinventariodefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

