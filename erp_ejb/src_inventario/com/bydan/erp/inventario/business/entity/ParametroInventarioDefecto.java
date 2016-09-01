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
//import com.bydan.erp.inventario.util.ParametroInventarioDefectoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class ParametroInventarioDefecto extends ParametroInventarioDefectoAdditional implements Serializable ,Cloneable {//ParametroInventarioDefectoAdditional,GeneralEntity
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
	
	private ParametroInventarioDefecto parametroinventariodefectoOriginal;
	
	private Map<String, Object> mapParametroInventarioDefecto;
			
	public Map<String, Object> getMapParametroInventarioDefecto() {
		return mapParametroInventarioDefecto;
	}

	public void setMapParametroInventarioDefecto(Map<String, Object> mapParametroInventarioDefecto) {
		this.mapParametroInventarioDefecto = mapParametroInventarioDefecto;
	}
	
	public void inicializarMapParametroInventarioDefecto() {
		this.mapParametroInventarioDefecto = new HashMap<String,Object>();
	}
	
	public void setMapParametroInventarioDefectoValue(String sKey,Object oValue) {
		this.mapParametroInventarioDefecto.put(sKey, oValue);
	}
	
	public Object getMapParametroInventarioDefectoValue(String sKey) {
		return this.mapParametroInventarioDefecto.get(sKey);
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
	private Long id_grupo_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_calidad_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto_servicio_inven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_costeo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_rango_unidad_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_color_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_clase_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_efecto_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_marca_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modelo_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_material_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_segmento_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_talla_producto;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public GrupoBodega grupobodega;
	public CalidadProducto calidadproducto;
	public TipoServicio tiposervicio;
	public TipoProductoServicioInven tipoproductoservicioinven;
	public TipoProductoServicio tipoproductoservicio;
	public TipoCosteo tipocosteo;
	public TipoProducto tipoproducto;
	public TipoViaTransporte tipoviatransporte;
	public RangoUnidadVenta rangounidadventa;
	public Pais pais;
	public Ciudad ciudad;
	public ColorProducto colorproducto;
	public ClaseProducto claseproducto;
	public EfectoProducto efectoproducto;
	public MarcaProducto marcaproducto;
	public ModeloProducto modeloproducto;
	public MaterialProducto materialproducto;
	public SegmentoProducto segmentoproducto;
	public TallaProducto tallaproducto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String grupobodega_descripcion;
	private String calidadproducto_descripcion;
	private String tiposervicio_descripcion;
	private String tipoproductoservicioinven_descripcion;
	private String tipoproductoservicio_descripcion;
	private String tipocosteo_descripcion;
	private String tipoproducto_descripcion;
	private String tipoviatransporte_descripcion;
	private String rangounidadventa_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String colorproducto_descripcion;
	private String claseproducto_descripcion;
	private String efectoproducto_descripcion;
	private String marcaproducto_descripcion;
	private String modeloproducto_descripcion;
	private String materialproducto_descripcion;
	private String segmentoproducto_descripcion;
	private String tallaproducto_descripcion;
	
	
		
	public ParametroInventarioDefecto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametroinventariodefectoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_grupo_bodega=-1L;
 		this.id_calidad_producto=-1L;
 		this.id_tipo_servicio=-1L;
 		this.id_tipo_producto_servicio_inven=-1L;
 		this.id_tipo_producto_servicio=-1L;
 		this.id_tipo_costeo=-1L;
 		this.id_tipo_producto=-1L;
 		this.id_tipo_via_transporte=-1L;
 		this.id_rango_unidad_venta=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_color_producto=-1L;
 		this.id_clase_producto=-1L;
 		this.id_efecto_producto=-1L;
 		this.id_marca_producto=-1L;
 		this.id_modelo_producto=-1L;
 		this.id_material_producto=-1L;
 		this.id_segmento_producto=-1L;
 		this.id_talla_producto=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.grupobodega=null;
		this.calidadproducto=null;
		this.tiposervicio=null;
		this.tipoproductoservicioinven=null;
		this.tipoproductoservicio=null;
		this.tipocosteo=null;
		this.tipoproducto=null;
		this.tipoviatransporte=null;
		this.rangounidadventa=null;
		this.pais=null;
		this.ciudad=null;
		this.colorproducto=null;
		this.claseproducto=null;
		this.efectoproducto=null;
		this.marcaproducto=null;
		this.modeloproducto=null;
		this.materialproducto=null;
		this.segmentoproducto=null;
		this.tallaproducto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.grupobodega_descripcion="";
		this.calidadproducto_descripcion="";
		this.tiposervicio_descripcion="";
		this.tipoproductoservicioinven_descripcion="";
		this.tipoproductoservicio_descripcion="";
		this.tipocosteo_descripcion="";
		this.tipoproducto_descripcion="";
		this.tipoviatransporte_descripcion="";
		this.rangounidadventa_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.colorproducto_descripcion="";
		this.claseproducto_descripcion="";
		this.efectoproducto_descripcion="";
		this.marcaproducto_descripcion="";
		this.modeloproducto_descripcion="";
		this.materialproducto_descripcion="";
		this.segmentoproducto_descripcion="";
		this.tallaproducto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroInventarioDefecto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_grupo_bodega,Long id_calidad_producto,Long id_tipo_servicio,Long id_tipo_producto_servicio_inven,Long id_tipo_producto_servicio,Long id_tipo_costeo,Long id_tipo_producto,Long id_tipo_via_transporte,Long id_rango_unidad_venta,Long id_pais,Long id_ciudad,Long id_color_producto,Long id_clase_producto,Long id_efecto_producto,Long id_marca_producto,Long id_modelo_producto,Long id_material_producto,Long id_segmento_producto,Long id_talla_producto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroinventariodefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_grupo_bodega=id_grupo_bodega;
 		this.id_calidad_producto=id_calidad_producto;
 		this.id_tipo_servicio=id_tipo_servicio;
 		this.id_tipo_producto_servicio_inven=id_tipo_producto_servicio_inven;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_tipo_costeo=id_tipo_costeo;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_rango_unidad_venta=id_rango_unidad_venta;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_color_producto=id_color_producto;
 		this.id_clase_producto=id_clase_producto;
 		this.id_efecto_producto=id_efecto_producto;
 		this.id_marca_producto=id_marca_producto;
 		this.id_modelo_producto=id_modelo_producto;
 		this.id_material_producto=id_material_producto;
 		this.id_segmento_producto=id_segmento_producto;
 		this.id_talla_producto=id_talla_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroInventarioDefecto (Long id_empresa,Long id_sucursal,Long id_grupo_bodega,Long id_calidad_producto,Long id_tipo_servicio,Long id_tipo_producto_servicio_inven,Long id_tipo_producto_servicio,Long id_tipo_costeo,Long id_tipo_producto,Long id_tipo_via_transporte,Long id_rango_unidad_venta,Long id_pais,Long id_ciudad,Long id_color_producto,Long id_clase_producto,Long id_efecto_producto,Long id_marca_producto,Long id_modelo_producto,Long id_material_producto,Long id_segmento_producto,Long id_talla_producto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametroinventariodefectoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_grupo_bodega=id_grupo_bodega;
 		this.id_calidad_producto=id_calidad_producto;
 		this.id_tipo_servicio=id_tipo_servicio;
 		this.id_tipo_producto_servicio_inven=id_tipo_producto_servicio_inven;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_tipo_costeo=id_tipo_costeo;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_rango_unidad_venta=id_rango_unidad_venta;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_color_producto=id_color_producto;
 		this.id_clase_producto=id_clase_producto;
 		this.id_efecto_producto=id_efecto_producto;
 		this.id_marca_producto=id_marca_producto;
 		this.id_modelo_producto=id_modelo_producto;
 		this.id_material_producto=id_material_producto;
 		this.id_segmento_producto=id_segmento_producto;
 		this.id_talla_producto=id_talla_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroInventarioDefecto parametroinventariodefectoLocal=null;
		
		if(object!=null) {
			parametroinventariodefectoLocal=(ParametroInventarioDefecto)object;
			
			if(parametroinventariodefectoLocal!=null) {
				if(this.getId()!=null && parametroinventariodefectoLocal.getId()!=null) {
					if(this.getId().equals(parametroinventariodefectoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroInventarioDefectoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroInventarioDefectoConstantesFunciones.getParametroInventarioDefectoDescripcion(this);
		} else {
			sDetalle=ParametroInventarioDefectoConstantesFunciones.getParametroInventarioDefectoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroInventarioDefecto getParametroInventarioDefectoOriginal() {
		return this.parametroinventariodefectoOriginal;
	}
	
	public void setParametroInventarioDefectoOriginal(ParametroInventarioDefecto parametroinventariodefecto) {
		try {
			this.parametroinventariodefectoOriginal=parametroinventariodefecto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroInventarioDefectoAdditional parametroinventariodefectoAdditional=null;
	
	public ParametroInventarioDefectoAdditional getParametroInventarioDefectoAdditional() {
		return this.parametroinventariodefectoAdditional;
	}
	
	public void setParametroInventarioDefectoAdditional(ParametroInventarioDefectoAdditional parametroinventariodefectoAdditional) {
		try {
			this.parametroinventariodefectoAdditional=parametroinventariodefectoAdditional;
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
    
	
	public Long getid_grupo_bodega() {
		return this.id_grupo_bodega;
	}
    
	
	public Long getid_calidad_producto() {
		return this.id_calidad_producto;
	}
    
	
	public Long getid_tipo_servicio() {
		return this.id_tipo_servicio;
	}
    
	
	public Long getid_tipo_producto_servicio_inven() {
		return this.id_tipo_producto_servicio_inven;
	}
    
	
	public Long getid_tipo_producto_servicio() {
		return this.id_tipo_producto_servicio;
	}
    
	
	public Long getid_tipo_costeo() {
		return this.id_tipo_costeo;
	}
    
	
	public Long getid_tipo_producto() {
		return this.id_tipo_producto;
	}
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public Long getid_rango_unidad_venta() {
		return this.id_rango_unidad_venta;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_color_producto() {
		return this.id_color_producto;
	}
    
	
	public Long getid_clase_producto() {
		return this.id_clase_producto;
	}
    
	
	public Long getid_efecto_producto() {
		return this.id_efecto_producto;
	}
    
	
	public Long getid_marca_producto() {
		return this.id_marca_producto;
	}
    
	
	public Long getid_modelo_producto() {
		return this.id_modelo_producto;
	}
    
	
	public Long getid_material_producto() {
		return this.id_material_producto;
	}
    
	
	public Long getid_segmento_producto() {
		return this.id_segmento_producto;
	}
    
	
	public Long getid_talla_producto() {
		return this.id_talla_producto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_bodega(Long newid_grupo_bodega)throws Exception
	{
		try {
			if(this.id_grupo_bodega!=newid_grupo_bodega) {
				if(newid_grupo_bodega==null) {
					//newid_grupo_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_grupo_bodega");
					}
				}

				this.id_grupo_bodega=newid_grupo_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_calidad_producto(Long newid_calidad_producto)throws Exception
	{
		try {
			if(this.id_calidad_producto!=newid_calidad_producto) {
				if(newid_calidad_producto==null) {
					//newid_calidad_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_calidad_producto");
					}
				}

				this.id_calidad_producto=newid_calidad_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_servicio(Long newid_tipo_servicio)throws Exception
	{
		try {
			if(this.id_tipo_servicio!=newid_tipo_servicio) {
				if(newid_tipo_servicio==null) {
					//newid_tipo_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_servicio");
					}
				}

				this.id_tipo_servicio=newid_tipo_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_producto_servicio_inven(Long newid_tipo_producto_servicio_inven)throws Exception
	{
		try {
			if(this.id_tipo_producto_servicio_inven!=newid_tipo_producto_servicio_inven) {
				if(newid_tipo_producto_servicio_inven==null) {
					//newid_tipo_producto_servicio_inven=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_producto_servicio_inven");
					}
				}

				this.id_tipo_producto_servicio_inven=newid_tipo_producto_servicio_inven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_producto_servicio(Long newid_tipo_producto_servicio)throws Exception
	{
		try {
			if(this.id_tipo_producto_servicio!=newid_tipo_producto_servicio) {
				if(newid_tipo_producto_servicio==null) {
					//newid_tipo_producto_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_producto_servicio");
					}
				}

				this.id_tipo_producto_servicio=newid_tipo_producto_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_costeo(Long newid_tipo_costeo)throws Exception
	{
		try {
			if(this.id_tipo_costeo!=newid_tipo_costeo) {
				if(newid_tipo_costeo==null) {
					//newid_tipo_costeo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_costeo");
					}
				}

				this.id_tipo_costeo=newid_tipo_costeo;
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
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_producto");
					}
				}

				this.id_tipo_producto=newid_tipo_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_rango_unidad_venta(Long newid_rango_unidad_venta)throws Exception
	{
		try {
			if(this.id_rango_unidad_venta!=newid_rango_unidad_venta) {
				if(newid_rango_unidad_venta==null) {
					//newid_rango_unidad_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_rango_unidad_venta");
					}
				}

				this.id_rango_unidad_venta=newid_rango_unidad_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_color_producto(Long newid_color_producto)throws Exception
	{
		try {
			if(this.id_color_producto!=newid_color_producto) {
				if(newid_color_producto==null) {
					//newid_color_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_color_producto");
					}
				}

				this.id_color_producto=newid_color_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_clase_producto(Long newid_clase_producto)throws Exception
	{
		try {
			if(this.id_clase_producto!=newid_clase_producto) {
				if(newid_clase_producto==null) {
					//newid_clase_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_clase_producto");
					}
				}

				this.id_clase_producto=newid_clase_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_efecto_producto(Long newid_efecto_producto)throws Exception
	{
		try {
			if(this.id_efecto_producto!=newid_efecto_producto) {
				if(newid_efecto_producto==null) {
					//newid_efecto_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_efecto_producto");
					}
				}

				this.id_efecto_producto=newid_efecto_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_marca_producto(Long newid_marca_producto)throws Exception
	{
		try {
			if(this.id_marca_producto!=newid_marca_producto) {
				if(newid_marca_producto==null) {
					//newid_marca_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_marca_producto");
					}
				}

				this.id_marca_producto=newid_marca_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modelo_producto(Long newid_modelo_producto)throws Exception
	{
		try {
			if(this.id_modelo_producto!=newid_modelo_producto) {
				if(newid_modelo_producto==null) {
					//newid_modelo_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_modelo_producto");
					}
				}

				this.id_modelo_producto=newid_modelo_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_material_producto(Long newid_material_producto)throws Exception
	{
		try {
			if(this.id_material_producto!=newid_material_producto) {
				if(newid_material_producto==null) {
					//newid_material_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_material_producto");
					}
				}

				this.id_material_producto=newid_material_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_segmento_producto(Long newid_segmento_producto)throws Exception
	{
		try {
			if(this.id_segmento_producto!=newid_segmento_producto) {
				if(newid_segmento_producto==null) {
					//newid_segmento_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_segmento_producto");
					}
				}

				this.id_segmento_producto=newid_segmento_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_talla_producto(Long newid_talla_producto)throws Exception
	{
		try {
			if(this.id_talla_producto!=newid_talla_producto) {
				if(newid_talla_producto==null) {
					//newid_talla_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroInventarioDefecto:Valor nulo no permitido en columna id_talla_producto");
					}
				}

				this.id_talla_producto=newid_talla_producto;
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

	public GrupoBodega getGrupoBodega() {
		return this.grupobodega;
	}

	public CalidadProducto getCalidadProducto() {
		return this.calidadproducto;
	}

	public TipoServicio getTipoServicio() {
		return this.tiposervicio;
	}

	public TipoProductoServicioInven getTipoProductoServicioInven() {
		return this.tipoproductoservicioinven;
	}

	public TipoProductoServicio getTipoProductoServicio() {
		return this.tipoproductoservicio;
	}

	public TipoCosteo getTipoCosteo() {
		return this.tipocosteo;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoproducto;
	}

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	public RangoUnidadVenta getRangoUnidadVenta() {
		return this.rangounidadventa;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public ColorProducto getColorProducto() {
		return this.colorproducto;
	}

	public ClaseProducto getClaseProducto() {
		return this.claseproducto;
	}

	public EfectoProducto getEfectoProducto() {
		return this.efectoproducto;
	}

	public MarcaProducto getMarcaProducto() {
		return this.marcaproducto;
	}

	public ModeloProducto getModeloProducto() {
		return this.modeloproducto;
	}

	public MaterialProducto getMaterialProducto() {
		return this.materialproducto;
	}

	public SegmentoProducto getSegmentoProducto() {
		return this.segmentoproducto;
	}

	public TallaProducto getTallaProducto() {
		return this.tallaproducto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getgrupobodega_descripcion() {
		return this.grupobodega_descripcion;
	}

	public String getcalidadproducto_descripcion() {
		return this.calidadproducto_descripcion;
	}

	public String gettiposervicio_descripcion() {
		return this.tiposervicio_descripcion;
	}

	public String gettipoproductoservicioinven_descripcion() {
		return this.tipoproductoservicioinven_descripcion;
	}

	public String gettipoproductoservicio_descripcion() {
		return this.tipoproductoservicio_descripcion;
	}

	public String gettipocosteo_descripcion() {
		return this.tipocosteo_descripcion;
	}

	public String gettipoproducto_descripcion() {
		return this.tipoproducto_descripcion;
	}

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
	}

	public String getrangounidadventa_descripcion() {
		return this.rangounidadventa_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getcolorproducto_descripcion() {
		return this.colorproducto_descripcion;
	}

	public String getclaseproducto_descripcion() {
		return this.claseproducto_descripcion;
	}

	public String getefectoproducto_descripcion() {
		return this.efectoproducto_descripcion;
	}

	public String getmarcaproducto_descripcion() {
		return this.marcaproducto_descripcion;
	}

	public String getmodeloproducto_descripcion() {
		return this.modeloproducto_descripcion;
	}

	public String getmaterialproducto_descripcion() {
		return this.materialproducto_descripcion;
	}

	public String getsegmentoproducto_descripcion() {
		return this.segmentoproducto_descripcion;
	}

	public String gettallaproducto_descripcion() {
		return this.tallaproducto_descripcion;
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


	public  void  setGrupoBodega(GrupoBodega grupobodega) {
		try {
			this.grupobodega=grupobodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCalidadProducto(CalidadProducto calidadproducto) {
		try {
			this.calidadproducto=calidadproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoServicio(TipoServicio tiposervicio) {
		try {
			this.tiposervicio=tiposervicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven) {
		try {
			this.tipoproductoservicioinven=tipoproductoservicioinven;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProductoServicio(TipoProductoServicio tipoproductoservicio) {
		try {
			this.tipoproductoservicio=tipoproductoservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCosteo(TipoCosteo tipocosteo) {
		try {
			this.tipocosteo=tipocosteo;
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


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setRangoUnidadVenta(RangoUnidadVenta rangounidadventa) {
		try {
			this.rangounidadventa=rangounidadventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setColorProducto(ColorProducto colorproducto) {
		try {
			this.colorproducto=colorproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClaseProducto(ClaseProducto claseproducto) {
		try {
			this.claseproducto=claseproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEfectoProducto(EfectoProducto efectoproducto) {
		try {
			this.efectoproducto=efectoproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMarcaProducto(MarcaProducto marcaproducto) {
		try {
			this.marcaproducto=marcaproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModeloProducto(ModeloProducto modeloproducto) {
		try {
			this.modeloproducto=modeloproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMaterialProducto(MaterialProducto materialproducto) {
		try {
			this.materialproducto=materialproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSegmentoProducto(SegmentoProducto segmentoproducto) {
		try {
			this.segmentoproducto=segmentoproducto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTallaProducto(TallaProducto tallaproducto) {
		try {
			this.tallaproducto=tallaproducto;
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


	public  void  setgrupobodega_descripcion(String grupobodega_descripcion) {
		try {
			this.grupobodega_descripcion=grupobodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcalidadproducto_descripcion(String calidadproducto_descripcion) {
		try {
			this.calidadproducto_descripcion=calidadproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiposervicio_descripcion(String tiposervicio_descripcion) {
		try {
			this.tiposervicio_descripcion=tiposervicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoproductoservicioinven_descripcion(String tipoproductoservicioinven_descripcion) {
		try {
			this.tipoproductoservicioinven_descripcion=tipoproductoservicioinven_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoproductoservicio_descripcion(String tipoproductoservicio_descripcion) {
		try {
			this.tipoproductoservicio_descripcion=tipoproductoservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocosteo_descripcion(String tipocosteo_descripcion) {
		try {
			this.tipocosteo_descripcion=tipocosteo_descripcion;
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


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setrangounidadventa_descripcion(String rangounidadventa_descripcion) {
		try {
			this.rangounidadventa_descripcion=rangounidadventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcolorproducto_descripcion(String colorproducto_descripcion) {
		try {
			this.colorproducto_descripcion=colorproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclaseproducto_descripcion(String claseproducto_descripcion) {
		try {
			this.claseproducto_descripcion=claseproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setefectoproducto_descripcion(String efectoproducto_descripcion) {
		try {
			this.efectoproducto_descripcion=efectoproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmarcaproducto_descripcion(String marcaproducto_descripcion) {
		try {
			this.marcaproducto_descripcion=marcaproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmodeloproducto_descripcion(String modeloproducto_descripcion) {
		try {
			this.modeloproducto_descripcion=modeloproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmaterialproducto_descripcion(String materialproducto_descripcion) {
		try {
			this.materialproducto_descripcion=materialproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsegmentoproducto_descripcion(String segmentoproducto_descripcion) {
		try {
			this.segmentoproducto_descripcion=segmentoproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settallaproducto_descripcion(String tallaproducto_descripcion) {
		try {
			this.tallaproducto_descripcion=tallaproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_grupo_bodega_descripcion="";String id_calidad_producto_descripcion="";String id_tipo_servicio_descripcion="";String id_tipo_producto_servicio_inven_descripcion="";String id_tipo_producto_servicio_descripcion="";String id_tipo_costeo_descripcion="";String id_tipo_producto_descripcion="";String id_tipo_via_transporte_descripcion="";String id_rango_unidad_venta_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_color_producto_descripcion="";String id_clase_producto_descripcion="";String id_efecto_producto_descripcion="";String id_marca_producto_descripcion="";String id_modelo_producto_descripcion="";String id_material_producto_descripcion="";String id_segmento_producto_descripcion="";String id_talla_producto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_grupo_bodega_descripcion() {
		return id_grupo_bodega_descripcion;
	}
	public String getid_calidad_producto_descripcion() {
		return id_calidad_producto_descripcion;
	}
	public String getid_tipo_servicio_descripcion() {
		return id_tipo_servicio_descripcion;
	}
	public String getid_tipo_producto_servicio_inven_descripcion() {
		return id_tipo_producto_servicio_inven_descripcion;
	}
	public String getid_tipo_producto_servicio_descripcion() {
		return id_tipo_producto_servicio_descripcion;
	}
	public String getid_tipo_costeo_descripcion() {
		return id_tipo_costeo_descripcion;
	}
	public String getid_tipo_producto_descripcion() {
		return id_tipo_producto_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
	}
	public String getid_rango_unidad_venta_descripcion() {
		return id_rango_unidad_venta_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_color_producto_descripcion() {
		return id_color_producto_descripcion;
	}
	public String getid_clase_producto_descripcion() {
		return id_clase_producto_descripcion;
	}
	public String getid_efecto_producto_descripcion() {
		return id_efecto_producto_descripcion;
	}
	public String getid_marca_producto_descripcion() {
		return id_marca_producto_descripcion;
	}
	public String getid_modelo_producto_descripcion() {
		return id_modelo_producto_descripcion;
	}
	public String getid_material_producto_descripcion() {
		return id_material_producto_descripcion;
	}
	public String getid_segmento_producto_descripcion() {
		return id_segmento_producto_descripcion;
	}
	public String getid_talla_producto_descripcion() {
		return id_talla_producto_descripcion;
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
	public void setid_grupo_bodega_descripcion(String newid_grupo_bodega_descripcion)throws Exception {
		try {
			this.id_grupo_bodega_descripcion=newid_grupo_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_calidad_producto_descripcion(String newid_calidad_producto_descripcion)throws Exception {
		try {
			this.id_calidad_producto_descripcion=newid_calidad_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_servicio_descripcion(String newid_tipo_servicio_descripcion)throws Exception {
		try {
			this.id_tipo_servicio_descripcion=newid_tipo_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_producto_servicio_inven_descripcion(String newid_tipo_producto_servicio_inven_descripcion)throws Exception {
		try {
			this.id_tipo_producto_servicio_inven_descripcion=newid_tipo_producto_servicio_inven_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_producto_servicio_descripcion(String newid_tipo_producto_servicio_descripcion)throws Exception {
		try {
			this.id_tipo_producto_servicio_descripcion=newid_tipo_producto_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_costeo_descripcion(String newid_tipo_costeo_descripcion)throws Exception {
		try {
			this.id_tipo_costeo_descripcion=newid_tipo_costeo_descripcion;
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
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_rango_unidad_venta_descripcion(String newid_rango_unidad_venta_descripcion)throws Exception {
		try {
			this.id_rango_unidad_venta_descripcion=newid_rango_unidad_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_color_producto_descripcion(String newid_color_producto_descripcion)throws Exception {
		try {
			this.id_color_producto_descripcion=newid_color_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_clase_producto_descripcion(String newid_clase_producto_descripcion)throws Exception {
		try {
			this.id_clase_producto_descripcion=newid_clase_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_efecto_producto_descripcion(String newid_efecto_producto_descripcion)throws Exception {
		try {
			this.id_efecto_producto_descripcion=newid_efecto_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_marca_producto_descripcion(String newid_marca_producto_descripcion)throws Exception {
		try {
			this.id_marca_producto_descripcion=newid_marca_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modelo_producto_descripcion(String newid_modelo_producto_descripcion)throws Exception {
		try {
			this.id_modelo_producto_descripcion=newid_modelo_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_material_producto_descripcion(String newid_material_producto_descripcion)throws Exception {
		try {
			this.id_material_producto_descripcion=newid_material_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_segmento_producto_descripcion(String newid_segmento_producto_descripcion)throws Exception {
		try {
			this.id_segmento_producto_descripcion=newid_segmento_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_talla_producto_descripcion(String newid_talla_producto_descripcion)throws Exception {
		try {
			this.id_talla_producto_descripcion=newid_talla_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_grupo_bodega_descripcion="";this.id_calidad_producto_descripcion="";this.id_tipo_servicio_descripcion="";this.id_tipo_producto_servicio_inven_descripcion="";this.id_tipo_producto_servicio_descripcion="";this.id_tipo_costeo_descripcion="";this.id_tipo_producto_descripcion="";this.id_tipo_via_transporte_descripcion="";this.id_rango_unidad_venta_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_color_producto_descripcion="";this.id_clase_producto_descripcion="";this.id_efecto_producto_descripcion="";this.id_marca_producto_descripcion="";this.id_modelo_producto_descripcion="";this.id_material_producto_descripcion="";this.id_segmento_producto_descripcion="";this.id_talla_producto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

