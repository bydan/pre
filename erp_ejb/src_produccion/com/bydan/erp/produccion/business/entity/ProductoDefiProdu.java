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
package com.bydan.erp.produccion.business.entity;

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
//import com.bydan.erp.produccion.util.ProductoDefiProduConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ProductoDefiProdu extends ProductoDefiProduAdditional implements Serializable ,Cloneable {//ProductoDefiProduAdditional,GeneralEntity
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
	
	private ProductoDefiProdu productodefiproduOriginal;
	
	private Map<String, Object> mapProductoDefiProdu;
			
	public Map<String, Object> getMapProductoDefiProdu() {
		return mapProductoDefiProdu;
	}

	public void setMapProductoDefiProdu(Map<String, Object> mapProductoDefiProdu) {
		this.mapProductoDefiProdu = mapProductoDefiProdu;
	}
	
	public void inicializarMapProductoDefiProdu() {
		this.mapProductoDefiProdu = new HashMap<String,Object>();
	}
	
	public void setMapProductoDefiProduValue(String sKey,Object oValue) {
		this.mapProductoDefiProdu.put(sKey, oValue);
	}
	
	public Object getMapProductoDefiProduValue(String sKey) {
		return this.mapProductoDefiProdu.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_genera_sub_productos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProductoDefiProduConstantesFunciones.SREGEXDESCRIPCION,message=ProductoDefiProduConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	
	
	public List<ProductoProduMano> productoprodumanos;
	public List<ProductoProduMerma> productoprodumermas;
	public List<ProductoProduGasto> productoprodugastos;
	public List<ProductoProdu> productoprodus;
	public List<ProductoProduMaquina> productoprodumaquinas;
		
	public ProductoDefiProdu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productodefiproduOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.con_genera_sub_productos=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		
		
		this.productoprodumanos=null;
		this.productoprodumermas=null;
		this.productoprodugastos=null;
		this.productoprodus=null;
		this.productoprodumaquinas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductoDefiProdu (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Boolean con_genera_sub_productos,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productodefiproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.con_genera_sub_productos=con_genera_sub_productos;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductoDefiProdu (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_unidad,Boolean con_genera_sub_productos,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productodefiproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.con_genera_sub_productos=con_genera_sub_productos;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProductoDefiProdu productodefiproduLocal=null;
		
		if(object!=null) {
			productodefiproduLocal=(ProductoDefiProdu)object;
			
			if(productodefiproduLocal!=null) {
				if(this.getId()!=null && productodefiproduLocal.getId()!=null) {
					if(this.getId().equals(productodefiproduLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoDefiProduConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcion(this);
		} else {
			sDetalle=ProductoDefiProduConstantesFunciones.getProductoDefiProduDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProductoDefiProdu getProductoDefiProduOriginal() {
		return this.productodefiproduOriginal;
	}
	
	public void setProductoDefiProduOriginal(ProductoDefiProdu productodefiprodu) {
		try {
			this.productodefiproduOriginal=productodefiprodu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoDefiProduAdditional productodefiproduAdditional=null;
	
	public ProductoDefiProduAdditional getProductoDefiProduAdditional() {
		return this.productodefiproduAdditional;
	}
	
	public void setProductoDefiProduAdditional(ProductoDefiProduAdditional productodefiproduAdditional) {
		try {
			this.productodefiproduAdditional=productodefiproduAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Boolean getcon_genera_sub_productos() {
		return this.con_genera_sub_productos;
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
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
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
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_genera_sub_productos(Boolean newcon_genera_sub_productos)throws Exception
	{
		try {
			if(this.con_genera_sub_productos!=newcon_genera_sub_productos) {
				if(newcon_genera_sub_productos==null) {
					//newcon_genera_sub_productos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna con_genera_sub_productos");
					}
				}

				this.con_genera_sub_productos=newcon_genera_sub_productos;
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
						System.out.println("ProductoDefiProdu:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("ProductoDefiProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
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


	
	
	public List<ProductoProduMano> getProductoProduManos() {
		return this.productoprodumanos;
	}

	public List<ProductoProduMerma> getProductoProduMermas() {
		return this.productoprodumermas;
	}

	public List<ProductoProduGasto> getProductoProduGastos() {
		return this.productoprodugastos;
	}

	public List<ProductoProdu> getProductoProdus() {
		return this.productoprodus;
	}

	public List<ProductoProduMaquina> getProductoProduMaquinas() {
		return this.productoprodumaquinas;
	}

	
	
	public  void  setProductoProduManos(List<ProductoProduMano> productoprodumanos) {
		try {
			this.productoprodumanos=productoprodumanos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoProduMermas(List<ProductoProduMerma> productoprodumermas) {
		try {
			this.productoprodumermas=productoprodumermas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoProduGastos(List<ProductoProduGasto> productoprodugastos) {
		try {
			this.productoprodugastos=productoprodugastos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoProdus(List<ProductoProdu> productoprodus) {
		try {
			this.productoprodus=productoprodus;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoProduMaquinas(List<ProductoProduMaquina> productoprodumaquinas) {
		try {
			this.productoprodumaquinas=productoprodumaquinas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String con_genera_sub_productos_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getcon_genera_sub_productos_descripcion() {
		return con_genera_sub_productos_descripcion;
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
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
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
	public void setcon_genera_sub_productos_descripcion(String newcon_genera_sub_productos_descripcion)throws Exception {
		try {
			this.con_genera_sub_productos_descripcion=newcon_genera_sub_productos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.con_genera_sub_productos_descripcion="";
	}
	
	
	Object productoprodumanosDescripcionReporte;
	Object productoprodumermasDescripcionReporte;
	Object productoprodugastosDescripcionReporte;
	Object productoprodusDescripcionReporte;
	Object productoprodumaquinasDescripcionReporte;
	
	
	public Object getproductoprodumanosDescripcionReporte() {
		return productoprodumanosDescripcionReporte;
	}

	public Object getproductoprodumermasDescripcionReporte() {
		return productoprodumermasDescripcionReporte;
	}

	public Object getproductoprodugastosDescripcionReporte() {
		return productoprodugastosDescripcionReporte;
	}

	public Object getproductoprodusDescripcionReporte() {
		return productoprodusDescripcionReporte;
	}

	public Object getproductoprodumaquinasDescripcionReporte() {
		return productoprodumaquinasDescripcionReporte;
	}

	
	
	public  void  setproductoprodumanosDescripcionReporte(Object productoprodumanos) {
		try {
			this.productoprodumanosDescripcionReporte=productoprodumanos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodumermasDescripcionReporte(Object productoprodumermas) {
		try {
			this.productoprodumermasDescripcionReporte=productoprodumermas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodugastosDescripcionReporte(Object productoprodugastos) {
		try {
			this.productoprodugastosDescripcionReporte=productoprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodusDescripcionReporte(Object productoprodus) {
		try {
			this.productoprodusDescripcionReporte=productoprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodumaquinasDescripcionReporte(Object productoprodumaquinas) {
		try {
			this.productoprodumaquinasDescripcionReporte=productoprodumaquinas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

