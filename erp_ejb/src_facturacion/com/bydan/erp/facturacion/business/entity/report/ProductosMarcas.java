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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.ProductosMarcasConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ProductosMarcas extends ProductosMarcasAdditional implements Serializable ,Cloneable {//ProductosMarcasAdditional,GeneralEntity
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
	
	private ProductosMarcas productosmarcasOriginal;
	
	private Map<String, Object> mapProductosMarcas;
			
	public Map<String, Object> getMapProductosMarcas() {
		return mapProductosMarcas;
	}

	public void setMapProductosMarcas(Map<String, Object> mapProductosMarcas) {
		this.mapProductosMarcas = mapProductosMarcas;
	}
	
	public void inicializarMapProductosMarcas() {
		this.mapProductosMarcas = new HashMap<String,Object>();
	}
	
	public void setMapProductosMarcasValue(String sKey,Object oValue) {
		this.mapProductosMarcas.put(sKey, oValue);
	}
	
	public Object getMapProductosMarcasValue(String sKey) {
		return this.mapProductosMarcas.get(sKey);
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
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_UNIDAD,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_UNIDAD)
	private String nombre_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_PRODUCTO,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_PRODUCTO)
	private String nombre_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_LINEA,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA)
	private String nombre_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_LINEA_GRUPO,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_GRUPO)
	private String nombre_linea_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_LINEA_CATEGORIA,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA)
	private String nombre_linea_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXNOMBRE_LINEA_MARCA,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXNOMBRE_LINEA_MARCA)
	private String nombre_linea_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXCODIGO_PRODUCTO,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXCODIGO_PRODUCTO)
	private String codigo_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProductosMarcasConstantesFunciones.SREGEXTIPO,message=ProductosMarcasConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Producto producto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String producto_descripcion;
	
	
		
	public ProductosMarcas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productosmarcasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_producto=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_unidad="";
 		this.nombre_producto="";
 		this.nombre_linea="";
 		this.nombre_linea_grupo="";
 		this.nombre_linea_categoria="";
 		this.nombre_linea_marca="";
 		this.cantidad=0;
 		this.monto=0.0;
 		this.codigo_producto="";
 		this.tipo="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.producto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.producto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductosMarcas (Long id,Date versionRow,String nombre_unidad,String nombre_producto,String nombre_linea,String nombre_linea_grupo,String nombre_linea_categoria,String nombre_linea_marca,Integer cantidad,Double monto,String codigo_producto,String tipo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productosmarcasOriginal=this;
		
 		this.nombre_unidad=nombre_unidad;
 		this.nombre_producto=nombre_producto;
 		this.nombre_linea=nombre_linea;
 		this.nombre_linea_grupo=nombre_linea_grupo;
 		this.nombre_linea_categoria=nombre_linea_categoria;
 		this.nombre_linea_marca=nombre_linea_marca;
 		this.cantidad=cantidad;
 		this.monto=monto;
 		this.codigo_producto=codigo_producto;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductosMarcas (String nombre_unidad,String nombre_producto,String nombre_linea,String nombre_linea_grupo,String nombre_linea_categoria,String nombre_linea_marca,Integer cantidad,Double monto,String codigo_producto,String tipo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productosmarcasOriginal=this;
		
 		this.nombre_unidad=nombre_unidad;
 		this.nombre_producto=nombre_producto;
 		this.nombre_linea=nombre_linea;
 		this.nombre_linea_grupo=nombre_linea_grupo;
 		this.nombre_linea_categoria=nombre_linea_categoria;
 		this.nombre_linea_marca=nombre_linea_marca;
 		this.cantidad=cantidad;
 		this.monto=monto;
 		this.codigo_producto=codigo_producto;
 		this.tipo=tipo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ProductosMarcas getProductosMarcasOriginal() {
		return this.productosmarcasOriginal;
	}
	
	public void setProductosMarcasOriginal(ProductosMarcas productosmarcas) {
		try {
			this.productosmarcasOriginal=productosmarcas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductosMarcasAdditional productosmarcasAdditional=null;
	
	public ProductosMarcasAdditional getProductosMarcasAdditional() {
		return this.productosmarcasAdditional;
	}
	
	public void setProductosMarcasAdditional(ProductosMarcasAdditional productosmarcasAdditional) {
		try {
			this.productosmarcasAdditional=productosmarcasAdditional;
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
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_unidad() {
		return this.nombre_unidad;
	}
    
	
	public String getnombre_producto() {
		return this.nombre_producto;
	}
    
	
	public String getnombre_linea() {
		return this.nombre_linea;
	}
    
	
	public String getnombre_linea_grupo() {
		return this.nombre_linea_grupo;
	}
    
	
	public String getnombre_linea_categoria() {
		return this.nombre_linea_categoria;
	}
    
	
	public String getnombre_linea_marca() {
		return this.nombre_linea_marca;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public String getcodigo_producto() {
		return this.codigo_producto;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_unidad(String newnombre_unidad)throws Exception
	{
		try {
			if(this.nombre_unidad!=newnombre_unidad) {
				if(newnombre_unidad==null) {
					//newnombre_unidad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_unidad");
					}
				}

				if(newnombre_unidad!=null&&newnombre_unidad.length()>50) {
					newnombre_unidad=newnombre_unidad.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_unidad");
				}

				this.nombre_unidad=newnombre_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_producto(String newnombre_producto)throws Exception
	{
		try {
			if(this.nombre_producto!=newnombre_producto) {
				if(newnombre_producto==null) {
					//newnombre_producto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_producto");
					}
				}

				if(newnombre_producto!=null&&newnombre_producto.length()>150) {
					newnombre_producto=newnombre_producto.substring(0,148);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_producto");
				}

				this.nombre_producto=newnombre_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea(String newnombre_linea)throws Exception
	{
		try {
			if(this.nombre_linea!=newnombre_linea) {
				if(newnombre_linea==null) {
					//newnombre_linea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_linea");
					}
				}

				if(newnombre_linea!=null&&newnombre_linea.length()>50) {
					newnombre_linea=newnombre_linea.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_linea");
				}

				this.nombre_linea=newnombre_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_grupo(String newnombre_linea_grupo)throws Exception
	{
		try {
			if(this.nombre_linea_grupo!=newnombre_linea_grupo) {
				if(newnombre_linea_grupo==null) {
					//newnombre_linea_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_linea_grupo");
					}
				}

				if(newnombre_linea_grupo!=null&&newnombre_linea_grupo.length()>50) {
					newnombre_linea_grupo=newnombre_linea_grupo.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_linea_grupo");
				}

				this.nombre_linea_grupo=newnombre_linea_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_categoria(String newnombre_linea_categoria)throws Exception
	{
		try {
			if(this.nombre_linea_categoria!=newnombre_linea_categoria) {
				if(newnombre_linea_categoria==null) {
					//newnombre_linea_categoria="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_linea_categoria");
					}
				}

				if(newnombre_linea_categoria!=null&&newnombre_linea_categoria.length()>50) {
					newnombre_linea_categoria=newnombre_linea_categoria.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_linea_categoria");
				}

				this.nombre_linea_categoria=newnombre_linea_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_linea_marca(String newnombre_linea_marca)throws Exception
	{
		try {
			if(this.nombre_linea_marca!=newnombre_linea_marca) {
				if(newnombre_linea_marca==null) {
					//newnombre_linea_marca="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna nombre_linea_marca");
					}
				}

				if(newnombre_linea_marca!=null&&newnombre_linea_marca.length()>50) {
					newnombre_linea_marca=newnombre_linea_marca.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_linea_marca");
				}

				this.nombre_linea_marca=newnombre_linea_marca;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_producto(String newcodigo_producto)throws Exception
	{
		try {
			if(this.codigo_producto!=newcodigo_producto) {
				if(newcodigo_producto==null) {
					//newcodigo_producto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna codigo_producto");
					}
				}

				if(newcodigo_producto!=null&&newcodigo_producto.length()>50) {
					newcodigo_producto=newcodigo_producto.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_producto");
				}

				this.codigo_producto=newcodigo_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductosMarcas:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("ProductosMarcas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
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

	public Producto getProducto() {
		return this.producto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
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


	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
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


	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_producto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
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
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_producto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

