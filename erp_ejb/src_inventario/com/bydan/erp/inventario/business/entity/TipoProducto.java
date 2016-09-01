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
//import com.bydan.erp.inventario.util.TipoProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class TipoProducto extends TipoProductoAdditional implements Serializable ,Cloneable {//TipoProductoAdditional,GeneralEntity
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
	
	private TipoProducto tipoproductoOriginal;
	
	private Map<String, Object> mapTipoProducto;
			
	public Map<String, Object> getMapTipoProducto() {
		return mapTipoProducto;
	}

	public void setMapTipoProducto(Map<String, Object> mapTipoProducto) {
		this.mapTipoProducto = mapTipoProducto;
	}
	
	public void inicializarMapTipoProducto() {
		this.mapTipoProducto = new HashMap<String,Object>();
	}
	
	public void setMapTipoProductoValue(String sKey,Object oValue) {
		this.mapTipoProducto.put(sKey, oValue);
	}
	
	public Object getMapTipoProductoValue(String sKey) {
		return this.mapTipoProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoProductoConstantesFunciones.SREGEXCODIGO,message=TipoProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoProductoConstantesFunciones.SREGEXNOMBRE,message=TipoProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoProductoConstantesFunciones.SREGEXDESCRIPCION,message=TipoProductoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<ModeloProducto> modeloproductos;
	public List<MaterialProducto> materialproductos;
	public List<MarcaProducto> marcaproductos;
	public List<SegmentoProducto> segmentoproductos;
	public List<ColorProducto> colorproductos;
	public List<EfectoProducto> efectoproductos;
	public List<TallaProducto> tallaproductos;
	public List<ParametroInventarioDefecto> parametroinventariodefectos;
	public List<ClaseProducto> claseproductos;
	public List<Producto> productos;
		
	public TipoProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoproductoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.modeloproductos=null;
		this.materialproductos=null;
		this.marcaproductos=null;
		this.segmentoproductos=null;
		this.colorproductos=null;
		this.efectoproductos=null;
		this.tallaproductos=null;
		this.parametroinventariodefectos=null;
		this.claseproductos=null;
		this.productos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoProducto (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoProducto (Long id_empresa,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoProducto tipoproductoLocal=null;
		
		if(object!=null) {
			tipoproductoLocal=(TipoProducto)object;
			
			if(tipoproductoLocal!=null) {
				if(this.getId()!=null && tipoproductoLocal.getId()!=null) {
					if(this.getId().equals(tipoproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoProductoConstantesFunciones.getTipoProductoDescripcion(this);
		} else {
			sDetalle=TipoProductoConstantesFunciones.getTipoProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoProducto getTipoProductoOriginal() {
		return this.tipoproductoOriginal;
	}
	
	public void setTipoProductoOriginal(TipoProducto tipoproducto) {
		try {
			this.tipoproductoOriginal=tipoproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoProductoAdditional tipoproductoAdditional=null;
	
	public TipoProductoAdditional getTipoProductoAdditional() {
		return this.tipoproductoAdditional;
	}
	
	public void setTipoProductoAdditional(TipoProductoAdditional tipoproductoAdditional) {
		try {
			this.tipoproductoAdditional=tipoproductoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoProducto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("TipoProducto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
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
						System.out.println("TipoProducto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("TipoProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public List<ModeloProducto> getModeloProductos() {
		return this.modeloproductos;
	}

	public List<MaterialProducto> getMaterialProductos() {
		return this.materialproductos;
	}

	public List<MarcaProducto> getMarcaProductos() {
		return this.marcaproductos;
	}

	public List<SegmentoProducto> getSegmentoProductos() {
		return this.segmentoproductos;
	}

	public List<ColorProducto> getColorProductos() {
		return this.colorproductos;
	}

	public List<EfectoProducto> getEfectoProductos() {
		return this.efectoproductos;
	}

	public List<TallaProducto> getTallaProductos() {
		return this.tallaproductos;
	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() {
		return this.parametroinventariodefectos;
	}

	public List<ClaseProducto> getClaseProductos() {
		return this.claseproductos;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	
	
	public  void  setModeloProductos(List<ModeloProducto> modeloproductos) {
		try {
			this.modeloproductos=modeloproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMaterialProductos(List<MaterialProducto> materialproductos) {
		try {
			this.materialproductos=materialproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMarcaProductos(List<MarcaProducto> marcaproductos) {
		try {
			this.marcaproductos=marcaproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSegmentoProductos(List<SegmentoProducto> segmentoproductos) {
		try {
			this.segmentoproductos=segmentoproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setColorProductos(List<ColorProducto> colorproductos) {
		try {
			this.colorproductos=colorproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEfectoProductos(List<EfectoProducto> efectoproductos) {
		try {
			this.efectoproductos=efectoproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTallaProductos(List<TallaProducto> tallaproductos) {
		try {
			this.tallaproductos=tallaproductos;
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

	public  void  setClaseProductos(List<ClaseProducto> claseproductos) {
		try {
			this.claseproductos=claseproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductos(List<Producto> productos) {
		try {
			this.productos=productos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object modeloproductosDescripcionReporte;
	Object materialproductosDescripcionReporte;
	Object marcaproductosDescripcionReporte;
	Object segmentoproductosDescripcionReporte;
	Object colorproductosDescripcionReporte;
	Object efectoproductosDescripcionReporte;
	Object tallaproductosDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	Object claseproductosDescripcionReporte;
	Object productosDescripcionReporte;
	
	
	public Object getmodeloproductosDescripcionReporte() {
		return modeloproductosDescripcionReporte;
	}

	public Object getmaterialproductosDescripcionReporte() {
		return materialproductosDescripcionReporte;
	}

	public Object getmarcaproductosDescripcionReporte() {
		return marcaproductosDescripcionReporte;
	}

	public Object getsegmentoproductosDescripcionReporte() {
		return segmentoproductosDescripcionReporte;
	}

	public Object getcolorproductosDescripcionReporte() {
		return colorproductosDescripcionReporte;
	}

	public Object getefectoproductosDescripcionReporte() {
		return efectoproductosDescripcionReporte;
	}

	public Object gettallaproductosDescripcionReporte() {
		return tallaproductosDescripcionReporte;
	}

	public Object getparametroinventariodefectosDescripcionReporte() {
		return parametroinventariodefectosDescripcionReporte;
	}

	public Object getclaseproductosDescripcionReporte() {
		return claseproductosDescripcionReporte;
	}

	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
	}

	
	
	public  void  setmodeloproductosDescripcionReporte(Object modeloproductos) {
		try {
			this.modeloproductosDescripcionReporte=modeloproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmaterialproductosDescripcionReporte(Object materialproductos) {
		try {
			this.materialproductosDescripcionReporte=materialproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmarcaproductosDescripcionReporte(Object marcaproductos) {
		try {
			this.marcaproductosDescripcionReporte=marcaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsegmentoproductosDescripcionReporte(Object segmentoproductos) {
		try {
			this.segmentoproductosDescripcionReporte=segmentoproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcolorproductosDescripcionReporte(Object colorproductos) {
		try {
			this.colorproductosDescripcionReporte=colorproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setefectoproductosDescripcionReporte(Object efectoproductos) {
		try {
			this.efectoproductosDescripcionReporte=efectoproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settallaproductosDescripcionReporte(Object tallaproductos) {
		try {
			this.tallaproductosDescripcionReporte=tallaproductos;
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

	public  void  setclaseproductosDescripcionReporte(Object claseproductos) {
		try {
			this.claseproductosDescripcionReporte=claseproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductosDescripcionReporte(Object productos) {
		try {
			this.productosDescripcionReporte=productos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

