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
//import com.bydan.erp.inventario.util.ProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class Producto extends ProductoAdditional implements Serializable ,Cloneable {//ProductoAdditional,GeneralEntity
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
	
	private Producto productoOriginal;
	
	private Map<String, Object> mapProducto;
			
	public Map<String, Object> getMapProducto() {
		return mapProducto;
	}

	public void setMapProducto(Map<String, Object> mapProducto) {
		this.mapProducto = mapProducto;
	}
	
	public void inicializarMapProducto() {
		this.mapProducto = new HashMap<String,Object>();
	}
	
	public void setMapProductoValue(String sKey,Object oValue) {
		this.mapProducto.put(sKey, oValue);
	}
	
	public Object getMapProductoValue(String sKey) {
		return this.mapProducto.get(sKey);
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXCODIGO,message=ProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXNOMBRE,message=ProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXNOMBRE_EXTRANJERO,message=ProductoConstantesFunciones.SMENSAJEREGEXNOMBRE_EXTRANJERO)
	private String nombre_extranjero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXRESUMEN_DETALLE,message=ProductoConstantesFunciones.SMENSAJEREGEXRESUMEN_DETALLE)
	private String resumen_detalle;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXCODIGO_BARRA,message=ProductoConstantesFunciones.SMENSAJEREGEXCODIGO_BARRA)
	private String codigo_barra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_grupo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_categoria;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto_servicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto_servicio_inven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_costeo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad_peso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_arancel;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_proveedor_defecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXDESCRIPCION,message=ProductoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double arancel_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double arancel_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double comision_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double dias_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_stock_negativo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precio_minimo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_confirmacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_presupuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_importacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_consep;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_balanza;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ancho;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double largo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double volumen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double peso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double gramos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double unidades_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double margen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double factor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double fob2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto;
	
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXGRUPO,message=ProductoConstantesFunciones.SMENSAJEREGEXGRUPO)
	private String grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXREFERENCIA,message=ProductoConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXAPLICACION,message=ProductoConstantesFunciones.SMENSAJEREGEXAPLICACION)
	private String aplicacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ProductoConstantesFunciones.SREGEXPROCEDENCIA,message=ProductoConstantesFunciones.SMENSAJEREGEXPROCEDENCIA)
	private String procedencia;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public Linea lineamarca;
	public TipoProductoServicio tipoproductoservicio;
	public TipoProductoServicioInven tipoproductoservicioinven;
	public TipoCosteo tipocosteo;
	public Unidad unidad;
	public Unidad unidadpeso;
	public Arancel arancel;
	public Cliente cliente;
	public Cliente clienteproveedordefecto;
	public TipoProducto tipoproducto;
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
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String lineamarca_descripcion;
	private String tipoproductoservicio_descripcion;
	private String tipoproductoservicioinven_descripcion;
	private String tipocosteo_descripcion;
	private String unidad_descripcion;
	private String unidadpeso_descripcion;
	private String arancel_descripcion;
	private String cliente_descripcion;
	private String clienteproveedordefecto_descripcion;
	private String tipoproducto_descripcion;
	private String colorproducto_descripcion;
	private String claseproducto_descripcion;
	private String efectoproducto_descripcion;
	private String marcaproducto_descripcion;
	private String modeloproducto_descripcion;
	private String materialproducto_descripcion;
	private String segmentoproducto_descripcion;
	private String tallaproducto_descripcion;
	
	
	public List<ProveedorProducto> proveedorproductos;
	public List<Precio> precios;
	public List<DetalleImpuestoInven> detalleimpuestoinvens;
	public List<PresupuestoVentas> presupuestoventass;
	public List<PoliticaProducto> politicaproductos;
	public List<SerieProducto> serieproductos;
	public List<UbicacionProdu> ubicacionprodus;
	public List<ParametroProducto> parametroproductos;
	public List<ProductoUnidad> productounidads;
	public List<Ingrediente> ingredienteRelacions;
	public List<ProductoCarac> productocaracs;
	public List<ServicioCliente> servicioclientes;
	public List<ProductoPromocion> productopromocionRelacions;
	public List<ProductoEspeci> productoespecis;
	public List<ProductoReempla> productoreemplas;
	public List<ProductoEstadistica> productoestadisticas;
	public List<PoliticaFactu> politicafactus;
	public List<ProductoCuentaContable> productocuentacontables;
	public List<BodegaProducto> bodegaproductos;
	public List<PresupuestoProducto> presupuestoproductos;
	public List<SaldoMesProducto> saldomesproductos;
		
	public Producto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.nombre_extranjero="";
 		this.resumen_detalle="";
 		this.codigo_barra="";
 		this.id_linea=-1L;
 		this.id_linea_grupo=null;
 		this.id_linea_categoria=null;
 		this.id_linea_marca=null;
 		this.id_tipo_producto_servicio=-1L;
 		this.id_tipo_producto_servicio_inven=-1L;
 		this.id_tipo_costeo=-1L;
 		this.id_unidad=-1L;
 		this.id_unidad_peso=-1L;
 		this.id_arancel=-1L;
 		this.id_cliente=-1L;
 		this.id_cliente_proveedor_defecto=-1L;
 		this.esta_activo=false;
 		this.descripcion="";
 		this.precio=0.0;
 		this.iva=0.0;
 		this.iva_valor=0.0;
 		this.ice=0.0;
 		this.ice_valor=0.0;
 		this.descuento=0.0;
 		this.descuento_valor=0.0;
 		this.arancel_porcentaje=0.0;
 		this.arancel_valor=0.0;
 		this.comision=0.0;
 		this.comision_valor=0.0;
 		this.dias_produccion=0.0;
 		this.con_stock_negativo=false;
 		this.con_precio_minimo=false;
 		this.con_lote=false;
 		this.con_confirmacion=false;
 		this.con_presupuesto=false;
 		this.con_importacion=false;
 		this.con_final=false;
 		this.con_consep=false;
 		this.con_serie=false;
 		this.con_balanza=false;
 		this.alto=0.0;
 		this.ancho=0.0;
 		this.largo=0.0;
 		this.volumen=0.0;
 		this.peso=0.0;
 		this.gramos=0.0;
 		this.unidades_caja=0.0;
 		this.margen=0.0;
 		this.factor=0.0;
 		this.fob=0.0;
 		this.fob2=0.0;
 		this.id_tipo_producto=-1L;
 		this.id_color_producto=-1L;
 		this.id_clase_producto=-1L;
 		this.id_efecto_producto=-1L;
 		this.id_marca_producto=-1L;
 		this.id_modelo_producto=-1L;
 		this.id_material_producto=-1L;
 		this.id_segmento_producto=-1L;
 		this.id_talla_producto=-1L;
 		this.grupo="";
 		this.referencia="";
 		this.aplicacion="";
 		this.procedencia="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.lineamarca=null;
		this.tipoproductoservicio=null;
		this.tipoproductoservicioinven=null;
		this.tipocosteo=null;
		this.unidad=null;
		this.unidadpeso=null;
		this.arancel=null;
		this.cliente=null;
		this.clienteproveedordefecto=null;
		this.tipoproducto=null;
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
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.lineamarca_descripcion="";
		this.tipoproductoservicio_descripcion="";
		this.tipoproductoservicioinven_descripcion="";
		this.tipocosteo_descripcion="";
		this.unidad_descripcion="";
		this.unidadpeso_descripcion="";
		this.arancel_descripcion="";
		this.cliente_descripcion="";
		this.clienteproveedordefecto_descripcion="";
		this.tipoproducto_descripcion="";
		this.colorproducto_descripcion="";
		this.claseproducto_descripcion="";
		this.efectoproducto_descripcion="";
		this.marcaproducto_descripcion="";
		this.modeloproducto_descripcion="";
		this.materialproducto_descripcion="";
		this.segmentoproducto_descripcion="";
		this.tallaproducto_descripcion="";
		
		
		this.proveedorproductos=null;
		this.precios=null;
		this.detalleimpuestoinvens=null;
		this.presupuestoventass=null;
		this.politicaproductos=null;
		this.serieproductos=null;
		this.ubicacionprodus=null;
		this.parametroproductos=null;
		this.productounidads=null;
		this.ingredienteRelacions=null;
		this.productocaracs=null;
		this.servicioclientes=null;
		this.productopromocionRelacions=null;
		this.productoespecis=null;
		this.productoreemplas=null;
		this.productoestadisticas=null;
		this.politicafactus=null;
		this.productocuentacontables=null;
		this.bodegaproductos=null;
		this.presupuestoproductos=null;
		this.saldomesproductos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Producto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,String nombre,String nombre_extranjero,String resumen_detalle,String codigo_barra,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Long id_tipo_producto_servicio_inven,Long id_tipo_costeo,Long id_unidad,Long id_unidad_peso,Long id_arancel,Long id_cliente,Long id_cliente_proveedor_defecto,Boolean esta_activo,String descripcion,Double precio,Double iva,Double iva_valor,Double ice,Double ice_valor,Double descuento,Double descuento_valor,Double arancel_porcentaje,Double arancel_valor,Double comision,Double comision_valor,Double dias_produccion,Boolean con_stock_negativo,Boolean con_precio_minimo,Boolean con_lote,Boolean con_confirmacion,Boolean con_presupuesto,Boolean con_importacion,Boolean con_final,Boolean con_consep,Boolean con_serie,Boolean con_balanza,Double alto,Double ancho,Double largo,Double volumen,Double peso,Double gramos,Double unidades_caja,Double margen,Double factor,Double fob,Double fob2,Long id_tipo_producto,Long id_color_producto,Long id_clase_producto,Long id_efecto_producto,Long id_marca_producto,Long id_modelo_producto,Long id_material_producto,Long id_segmento_producto,Long id_talla_producto,String grupo,String referencia,String aplicacion,String procedencia) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_extranjero=nombre_extranjero;
 		this.resumen_detalle=resumen_detalle;
 		this.codigo_barra=codigo_barra;
 		this.id_linea=id_linea;
 		this.id_linea_grupo=id_linea_grupo;
 		this.id_linea_categoria=id_linea_categoria;
 		this.id_linea_marca=id_linea_marca;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_tipo_producto_servicio_inven=id_tipo_producto_servicio_inven;
 		this.id_tipo_costeo=id_tipo_costeo;
 		this.id_unidad=id_unidad;
 		this.id_unidad_peso=id_unidad_peso;
 		this.id_arancel=id_arancel;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor_defecto=id_cliente_proveedor_defecto;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
 		this.precio=precio;
 		this.iva=iva;
 		this.iva_valor=iva_valor;
 		this.ice=ice;
 		this.ice_valor=ice_valor;
 		this.descuento=descuento;
 		this.descuento_valor=descuento_valor;
 		this.arancel_porcentaje=arancel_porcentaje;
 		this.arancel_valor=arancel_valor;
 		this.comision=comision;
 		this.comision_valor=comision_valor;
 		this.dias_produccion=dias_produccion;
 		this.con_stock_negativo=con_stock_negativo;
 		this.con_precio_minimo=con_precio_minimo;
 		this.con_lote=con_lote;
 		this.con_confirmacion=con_confirmacion;
 		this.con_presupuesto=con_presupuesto;
 		this.con_importacion=con_importacion;
 		this.con_final=con_final;
 		this.con_consep=con_consep;
 		this.con_serie=con_serie;
 		this.con_balanza=con_balanza;
 		this.alto=alto;
 		this.ancho=ancho;
 		this.largo=largo;
 		this.volumen=volumen;
 		this.peso=peso;
 		this.gramos=gramos;
 		this.unidades_caja=unidades_caja;
 		this.margen=margen;
 		this.factor=factor;
 		this.fob=fob;
 		this.fob2=fob2;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_color_producto=id_color_producto;
 		this.id_clase_producto=id_clase_producto;
 		this.id_efecto_producto=id_efecto_producto;
 		this.id_marca_producto=id_marca_producto;
 		this.id_modelo_producto=id_modelo_producto;
 		this.id_material_producto=id_material_producto;
 		this.id_segmento_producto=id_segmento_producto;
 		this.id_talla_producto=id_talla_producto;
 		this.grupo=grupo;
 		this.referencia=referencia;
 		this.aplicacion=aplicacion;
 		this.procedencia=procedencia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Producto (Long id_empresa,Long id_sucursal,String codigo,String nombre,String nombre_extranjero,String resumen_detalle,String codigo_barra,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Long id_tipo_producto_servicio,Long id_tipo_producto_servicio_inven,Long id_tipo_costeo,Long id_unidad,Long id_unidad_peso,Long id_arancel,Long id_cliente,Long id_cliente_proveedor_defecto,Boolean esta_activo,String descripcion,Double precio,Double iva,Double iva_valor,Double ice,Double ice_valor,Double descuento,Double descuento_valor,Double arancel_porcentaje,Double arancel_valor,Double comision,Double comision_valor,Double dias_produccion,Boolean con_stock_negativo,Boolean con_precio_minimo,Boolean con_lote,Boolean con_confirmacion,Boolean con_presupuesto,Boolean con_importacion,Boolean con_final,Boolean con_consep,Boolean con_serie,Boolean con_balanza,Double alto,Double ancho,Double largo,Double volumen,Double peso,Double gramos,Double unidades_caja,Double margen,Double factor,Double fob,Double fob2,Long id_tipo_producto,Long id_color_producto,Long id_clase_producto,Long id_efecto_producto,Long id_marca_producto,Long id_modelo_producto,Long id_material_producto,Long id_segmento_producto,Long id_talla_producto,String grupo,String referencia,String aplicacion,String procedencia) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre_extranjero=nombre_extranjero;
 		this.resumen_detalle=resumen_detalle;
 		this.codigo_barra=codigo_barra;
 		this.id_linea=id_linea;
 		this.id_linea_grupo=id_linea_grupo;
 		this.id_linea_categoria=id_linea_categoria;
 		this.id_linea_marca=id_linea_marca;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_tipo_producto_servicio_inven=id_tipo_producto_servicio_inven;
 		this.id_tipo_costeo=id_tipo_costeo;
 		this.id_unidad=id_unidad;
 		this.id_unidad_peso=id_unidad_peso;
 		this.id_arancel=id_arancel;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor_defecto=id_cliente_proveedor_defecto;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
 		this.precio=precio;
 		this.iva=iva;
 		this.iva_valor=iva_valor;
 		this.ice=ice;
 		this.ice_valor=ice_valor;
 		this.descuento=descuento;
 		this.descuento_valor=descuento_valor;
 		this.arancel_porcentaje=arancel_porcentaje;
 		this.arancel_valor=arancel_valor;
 		this.comision=comision;
 		this.comision_valor=comision_valor;
 		this.dias_produccion=dias_produccion;
 		this.con_stock_negativo=con_stock_negativo;
 		this.con_precio_minimo=con_precio_minimo;
 		this.con_lote=con_lote;
 		this.con_confirmacion=con_confirmacion;
 		this.con_presupuesto=con_presupuesto;
 		this.con_importacion=con_importacion;
 		this.con_final=con_final;
 		this.con_consep=con_consep;
 		this.con_serie=con_serie;
 		this.con_balanza=con_balanza;
 		this.alto=alto;
 		this.ancho=ancho;
 		this.largo=largo;
 		this.volumen=volumen;
 		this.peso=peso;
 		this.gramos=gramos;
 		this.unidades_caja=unidades_caja;
 		this.margen=margen;
 		this.factor=factor;
 		this.fob=fob;
 		this.fob2=fob2;
 		this.id_tipo_producto=id_tipo_producto;
 		this.id_color_producto=id_color_producto;
 		this.id_clase_producto=id_clase_producto;
 		this.id_efecto_producto=id_efecto_producto;
 		this.id_marca_producto=id_marca_producto;
 		this.id_modelo_producto=id_modelo_producto;
 		this.id_material_producto=id_material_producto;
 		this.id_segmento_producto=id_segmento_producto;
 		this.id_talla_producto=id_talla_producto;
 		this.grupo=grupo;
 		this.referencia=referencia;
 		this.aplicacion=aplicacion;
 		this.procedencia=procedencia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Producto productoLocal=null;
		
		if(object!=null) {
			productoLocal=(Producto)object;
			
			if(productoLocal!=null) {
				if(this.getId()!=null && productoLocal.getId()!=null) {
					if(this.getId().equals(productoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoConstantesFunciones.getProductoDescripcion(this);
		} else {
			sDetalle=ProductoConstantesFunciones.getProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Producto getProductoOriginal() {
		return this.productoOriginal;
	}
	
	public void setProductoOriginal(Producto producto) {
		try {
			this.productoOriginal=producto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoAdditional productoAdditional=null;
	
	public ProductoAdditional getProductoAdditional() {
		return this.productoAdditional;
	}
	
	public void setProductoAdditional(ProductoAdditional productoAdditional) {
		try {
			this.productoAdditional=productoAdditional;
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
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre_extranjero() {
		return this.nombre_extranjero;
	}
    
	
	public String getresumen_detalle() {
		return this.resumen_detalle;
	}
    
	
	public String getcodigo_barra() {
		return this.codigo_barra;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_linea_grupo() {
		return this.id_linea_grupo;
	}
    
	
	public Long getid_linea_categoria() {
		return this.id_linea_categoria;
	}
    
	
	public Long getid_linea_marca() {
		return this.id_linea_marca;
	}
    
	
	public Long getid_tipo_producto_servicio() {
		return this.id_tipo_producto_servicio;
	}
    
	
	public Long getid_tipo_producto_servicio_inven() {
		return this.id_tipo_producto_servicio_inven;
	}
    
	
	public Long getid_tipo_costeo() {
		return this.id_tipo_costeo;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Long getid_unidad_peso() {
		return this.id_unidad_peso;
	}
    
	
	public Long getid_arancel() {
		return this.id_arancel;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_cliente_proveedor_defecto() {
		return this.id_cliente_proveedor_defecto;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getiva_valor() {
		return this.iva_valor;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getice_valor() {
		return this.ice_valor;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public Double getarancel_porcentaje() {
		return this.arancel_porcentaje;
	}
    
	
	public Double getarancel_valor() {
		return this.arancel_valor;
	}
    
	
	public Double getcomision() {
		return this.comision;
	}
    
	
	public Double getcomision_valor() {
		return this.comision_valor;
	}
    
	
	public Double getdias_produccion() {
		return this.dias_produccion;
	}
    
	
	public Boolean getcon_stock_negativo() {
		return this.con_stock_negativo;
	}
    
	
	public Boolean getcon_precio_minimo() {
		return this.con_precio_minimo;
	}
    
	
	public Boolean getcon_lote() {
		return this.con_lote;
	}
    
	
	public Boolean getcon_confirmacion() {
		return this.con_confirmacion;
	}
    
	
	public Boolean getcon_presupuesto() {
		return this.con_presupuesto;
	}
    
	
	public Boolean getcon_importacion() {
		return this.con_importacion;
	}
    
	
	public Boolean getcon_final() {
		return this.con_final;
	}
    
	
	public Boolean getcon_consep() {
		return this.con_consep;
	}
    
	
	public Boolean getcon_serie() {
		return this.con_serie;
	}
    
	
	public Boolean getcon_balanza() {
		return this.con_balanza;
	}
    
	
	public Double getalto() {
		return this.alto;
	}
    
	
	public Double getancho() {
		return this.ancho;
	}
    
	
	public Double getlargo() {
		return this.largo;
	}
    
	
	public Double getvolumen() {
		return this.volumen;
	}
    
	
	public Double getpeso() {
		return this.peso;
	}
    
	
	public Double getgramos() {
		return this.gramos;
	}
    
	
	public Double getunidades_caja() {
		return this.unidades_caja;
	}
    
	
	public Double getmargen() {
		return this.margen;
	}
    
	
	public Double getfactor() {
		return this.factor;
	}
    
	
	public Double getfob() {
		return this.fob;
	}
    
	
	public Double getfob2() {
		return this.fob2;
	}
    
	
	public Long getid_tipo_producto() {
		return this.id_tipo_producto;
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
    
	
	public String getgrupo() {
		return this.grupo;
	}
    
	
	public String getreferencia() {
		return this.referencia;
	}
    
	
	public String getaplicacion() {
		return this.aplicacion;
	}
    
	
	public String getprocedencia() {
		return this.procedencia;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("Producto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Producto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_extranjero(String newnombre_extranjero)throws Exception
	{
		try {
			if(this.nombre_extranjero!=newnombre_extranjero) {
				if(newnombre_extranjero==null) {
					//newnombre_extranjero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna nombre_extranjero");
					}
				}

				if(newnombre_extranjero!=null&&newnombre_extranjero.length()>150) {
					newnombre_extranjero=newnombre_extranjero.substring(0,148);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_extranjero");
				}

				this.nombre_extranjero=newnombre_extranjero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresumen_detalle(String newresumen_detalle)throws Exception
	{
		try {
			if(this.resumen_detalle!=newresumen_detalle) {
				if(newresumen_detalle==null) {
					//newresumen_detalle="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna resumen_detalle");
					}
				}

				if(newresumen_detalle!=null&&newresumen_detalle.length()>200) {
					newresumen_detalle=newresumen_detalle.substring(0,198);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna resumen_detalle");
				}

				this.resumen_detalle=newresumen_detalle;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_barra(String newcodigo_barra)throws Exception
	{
		try {
			if(this.codigo_barra!=newcodigo_barra) {
				if(newcodigo_barra==null) {
					//newcodigo_barra="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna codigo_barra");
					}
				}

				if(newcodigo_barra!=null&&newcodigo_barra.length()>50) {
					newcodigo_barra=newcodigo_barra.substring(0,48);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_barra");
				}

				this.codigo_barra=newcodigo_barra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_grupo(Long newid_linea_grupo) {
		if(this.id_linea_grupo==null&&newid_linea_grupo!=null) {
			this.id_linea_grupo=newid_linea_grupo;
				this.setIsChanged(true);
		}

		if(this.id_linea_grupo!=null&&!this.id_linea_grupo.equals(newid_linea_grupo)) {

			this.id_linea_grupo=newid_linea_grupo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_linea_categoria(Long newid_linea_categoria) {
		if(this.id_linea_categoria==null&&newid_linea_categoria!=null) {
			this.id_linea_categoria=newid_linea_categoria;
				this.setIsChanged(true);
		}

		if(this.id_linea_categoria!=null&&!this.id_linea_categoria.equals(newid_linea_categoria)) {

			this.id_linea_categoria=newid_linea_categoria;
				this.setIsChanged(true);
		}
	}
    
	public void setid_linea_marca(Long newid_linea_marca) {
		if(this.id_linea_marca==null&&newid_linea_marca!=null) {
			this.id_linea_marca=newid_linea_marca;
				this.setIsChanged(true);
		}

		if(this.id_linea_marca!=null&&!this.id_linea_marca.equals(newid_linea_marca)) {

			this.id_linea_marca=newid_linea_marca;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_producto_servicio(Long newid_tipo_producto_servicio)throws Exception
	{
		try {
			if(this.id_tipo_producto_servicio!=newid_tipo_producto_servicio) {
				if(newid_tipo_producto_servicio==null) {
					//newid_tipo_producto_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_tipo_producto_servicio");
					}
				}

				this.id_tipo_producto_servicio=newid_tipo_producto_servicio;
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
						System.out.println("Producto:Valor nulo no permitido en columna id_tipo_producto_servicio_inven");
					}
				}

				this.id_tipo_producto_servicio_inven=newid_tipo_producto_servicio_inven;
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
						System.out.println("Producto:Valor nulo no permitido en columna id_tipo_costeo");
					}
				}

				this.id_tipo_costeo=newid_tipo_costeo;
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
						System.out.println("Producto:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad_peso(Long newid_unidad_peso)throws Exception
	{
		try {
			if(this.id_unidad_peso!=newid_unidad_peso) {
				if(newid_unidad_peso==null) {
					//newid_unidad_peso=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_unidad_peso");
					}
				}

				this.id_unidad_peso=newid_unidad_peso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_arancel(Long newid_arancel)throws Exception
	{
		try {
			if(this.id_arancel!=newid_arancel) {
				if(newid_arancel==null) {
					//newid_arancel=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_arancel");
					}
				}

				this.id_arancel=newid_arancel;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_proveedor_defecto(Long newid_cliente_proveedor_defecto)throws Exception
	{
		try {
			if(this.id_cliente_proveedor_defecto!=newid_cliente_proveedor_defecto) {
				if(newid_cliente_proveedor_defecto==null) {
					//newid_cliente_proveedor_defecto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna id_cliente_proveedor_defecto");
					}
				}

				this.id_cliente_proveedor_defecto=newid_cliente_proveedor_defecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
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
						System.out.println("Producto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva_valor(Double newiva_valor)throws Exception
	{
		try {
			if(this.iva_valor!=newiva_valor) {
				if(newiva_valor==null) {
					//newiva_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna iva_valor");
					}
				}

				this.iva_valor=newiva_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice_valor(Double newice_valor)throws Exception
	{
		try {
			if(this.ice_valor!=newice_valor) {
				if(newice_valor==null) {
					//newice_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna ice_valor");
					}
				}

				this.ice_valor=newice_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_valor(Double newdescuento_valor)throws Exception
	{
		try {
			if(this.descuento_valor!=newdescuento_valor) {
				if(newdescuento_valor==null) {
					//newdescuento_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarancel_porcentaje(Double newarancel_porcentaje)throws Exception
	{
		try {
			if(this.arancel_porcentaje!=newarancel_porcentaje) {
				if(newarancel_porcentaje==null) {
					//newarancel_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna arancel_porcentaje");
					}
				}

				this.arancel_porcentaje=newarancel_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarancel_valor(Double newarancel_valor)throws Exception
	{
		try {
			if(this.arancel_valor!=newarancel_valor) {
				if(newarancel_valor==null) {
					//newarancel_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna arancel_valor");
					}
				}

				this.arancel_valor=newarancel_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcomision(Double newcomision)throws Exception
	{
		try {
			if(this.comision!=newcomision) {
				if(newcomision==null) {
					//newcomision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna comision");
					}
				}

				this.comision=newcomision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcomision_valor(Double newcomision_valor)throws Exception
	{
		try {
			if(this.comision_valor!=newcomision_valor) {
				if(newcomision_valor==null) {
					//newcomision_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna comision_valor");
					}
				}

				this.comision_valor=newcomision_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_produccion(Double newdias_produccion)throws Exception
	{
		try {
			if(this.dias_produccion!=newdias_produccion) {
				if(newdias_produccion==null) {
					//newdias_produccion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna dias_produccion");
					}
				}

				this.dias_produccion=newdias_produccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_stock_negativo(Boolean newcon_stock_negativo)throws Exception
	{
		try {
			if(this.con_stock_negativo!=newcon_stock_negativo) {
				if(newcon_stock_negativo==null) {
					//newcon_stock_negativo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_stock_negativo");
					}
				}

				this.con_stock_negativo=newcon_stock_negativo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precio_minimo(Boolean newcon_precio_minimo)throws Exception
	{
		try {
			if(this.con_precio_minimo!=newcon_precio_minimo) {
				if(newcon_precio_minimo==null) {
					//newcon_precio_minimo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_precio_minimo");
					}
				}

				this.con_precio_minimo=newcon_precio_minimo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lote(Boolean newcon_lote)throws Exception
	{
		try {
			if(this.con_lote!=newcon_lote) {
				if(newcon_lote==null) {
					//newcon_lote=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_lote");
					}
				}

				this.con_lote=newcon_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_confirmacion(Boolean newcon_confirmacion)throws Exception
	{
		try {
			if(this.con_confirmacion!=newcon_confirmacion) {
				if(newcon_confirmacion==null) {
					//newcon_confirmacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_confirmacion");
					}
				}

				this.con_confirmacion=newcon_confirmacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_presupuesto(Boolean newcon_presupuesto)throws Exception
	{
		try {
			if(this.con_presupuesto!=newcon_presupuesto) {
				if(newcon_presupuesto==null) {
					//newcon_presupuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_presupuesto");
					}
				}

				this.con_presupuesto=newcon_presupuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_importacion(Boolean newcon_importacion)throws Exception
	{
		try {
			if(this.con_importacion!=newcon_importacion) {
				if(newcon_importacion==null) {
					//newcon_importacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_importacion");
					}
				}

				this.con_importacion=newcon_importacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_final(Boolean newcon_final)throws Exception
	{
		try {
			if(this.con_final!=newcon_final) {
				if(newcon_final==null) {
					//newcon_final=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_final");
					}
				}

				this.con_final=newcon_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_consep(Boolean newcon_consep)throws Exception
	{
		try {
			if(this.con_consep!=newcon_consep) {
				if(newcon_consep==null) {
					//newcon_consep=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_consep");
					}
				}

				this.con_consep=newcon_consep;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_serie(Boolean newcon_serie)throws Exception
	{
		try {
			if(this.con_serie!=newcon_serie) {
				if(newcon_serie==null) {
					//newcon_serie=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_serie");
					}
				}

				this.con_serie=newcon_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_balanza(Boolean newcon_balanza)throws Exception
	{
		try {
			if(this.con_balanza!=newcon_balanza) {
				if(newcon_balanza==null) {
					//newcon_balanza=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna con_balanza");
					}
				}

				this.con_balanza=newcon_balanza;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setalto(Double newalto)throws Exception
	{
		try {
			if(this.alto!=newalto) {
				if(newalto==null) {
					//newalto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna alto");
					}
				}

				this.alto=newalto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setancho(Double newancho)throws Exception
	{
		try {
			if(this.ancho!=newancho) {
				if(newancho==null) {
					//newancho=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna ancho");
					}
				}

				this.ancho=newancho;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlargo(Double newlargo)throws Exception
	{
		try {
			if(this.largo!=newlargo) {
				if(newlargo==null) {
					//newlargo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna largo");
					}
				}

				this.largo=newlargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvolumen(Double newvolumen)throws Exception
	{
		try {
			if(this.volumen!=newvolumen) {
				if(newvolumen==null) {
					//newvolumen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna volumen");
					}
				}

				this.volumen=newvolumen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpeso(Double newpeso)throws Exception
	{
		try {
			if(this.peso!=newpeso) {
				if(newpeso==null) {
					//newpeso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna peso");
					}
				}

				this.peso=newpeso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgramos(Double newgramos)throws Exception
	{
		try {
			if(this.gramos!=newgramos) {
				if(newgramos==null) {
					//newgramos=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna gramos");
					}
				}

				this.gramos=newgramos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setunidades_caja(Double newunidades_caja)throws Exception
	{
		try {
			if(this.unidades_caja!=newunidades_caja) {
				if(newunidades_caja==null) {
					//newunidades_caja=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna unidades_caja");
					}
				}

				this.unidades_caja=newunidades_caja;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmargen(Double newmargen)throws Exception
	{
		try {
			if(this.margen!=newmargen) {
				if(newmargen==null) {
					//newmargen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna margen");
					}
				}

				this.margen=newmargen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfactor(Double newfactor)throws Exception
	{
		try {
			if(this.factor!=newfactor) {
				if(newfactor==null) {
					//newfactor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna factor");
					}
				}

				this.factor=newfactor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfob(Double newfob)throws Exception
	{
		try {
			if(this.fob!=newfob) {
				if(newfob==null) {
					//newfob=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna fob");
					}
				}

				this.fob=newfob;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfob2(Double newfob2)throws Exception
	{
		try {
			if(this.fob2!=newfob2) {
				if(newfob2==null) {
					//newfob2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna fob2");
					}
				}

				this.fob2=newfob2;
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
						System.out.println("Producto:Valor nulo no permitido en columna id_tipo_producto");
					}
				}

				this.id_tipo_producto=newid_tipo_producto;
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
						System.out.println("Producto:Valor nulo no permitido en columna id_color_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_clase_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_efecto_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_marca_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_modelo_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_material_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_segmento_producto");
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
						System.out.println("Producto:Valor nulo no permitido en columna id_talla_producto");
					}
				}

				this.id_talla_producto=newid_talla_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setgrupo(String newgrupo)throws Exception
	{
		try {
			if(this.grupo!=newgrupo) {
				if(newgrupo==null) {
					//newgrupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna grupo");
					}
				}

				if(newgrupo!=null&&newgrupo.length()>100) {
					newgrupo=newgrupo.substring(0,98);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna grupo");
				}

				this.grupo=newgrupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreferencia(String newreferencia)throws Exception
	{
		try {
			if(this.referencia!=newreferencia) {
				if(newreferencia==null) {
					//newreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>100) {
					newreferencia=newreferencia.substring(0,98);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna referencia");
				}

				this.referencia=newreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setaplicacion(String newaplicacion)throws Exception
	{
		try {
			if(this.aplicacion!=newaplicacion) {
				if(newaplicacion==null) {
					//newaplicacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna aplicacion");
					}
				}

				if(newaplicacion!=null&&newaplicacion.length()>100) {
					newaplicacion=newaplicacion.substring(0,98);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna aplicacion");
				}

				this.aplicacion=newaplicacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprocedencia(String newprocedencia)throws Exception
	{
		try {
			if(this.procedencia!=newprocedencia) {
				if(newprocedencia==null) {
					//newprocedencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Producto:Valor nulo no permitido en columna procedencia");
					}
				}

				if(newprocedencia!=null&&newprocedencia.length()>100) {
					newprocedencia=newprocedencia.substring(0,98);
					System.out.println("Producto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna procedencia");
				}

				this.procedencia=newprocedencia;
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

	public Linea getLinea() {
		return this.linea;
	}

	public Linea getLineaGrupo() {
		return this.lineagrupo;
	}

	public Linea getLineaCategoria() {
		return this.lineacategoria;
	}

	public Linea getLineaMarca() {
		return this.lineamarca;
	}

	public TipoProductoServicio getTipoProductoServicio() {
		return this.tipoproductoservicio;
	}

	public TipoProductoServicioInven getTipoProductoServicioInven() {
		return this.tipoproductoservicioinven;
	}

	public TipoCosteo getTipoCosteo() {
		return this.tipocosteo;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public Unidad getUnidadPeso() {
		return this.unidadpeso;
	}

	public Arancel getArancel() {
		return this.arancel;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Cliente getClienteProveedorDefecto() {
		return this.clienteproveedordefecto;
	}

	public TipoProducto getTipoProducto() {
		return this.tipoproducto;
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

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getlineagrupo_descripcion() {
		return this.lineagrupo_descripcion;
	}

	public String getlineacategoria_descripcion() {
		return this.lineacategoria_descripcion;
	}

	public String getlineamarca_descripcion() {
		return this.lineamarca_descripcion;
	}

	public String gettipoproductoservicio_descripcion() {
		return this.tipoproductoservicio_descripcion;
	}

	public String gettipoproductoservicioinven_descripcion() {
		return this.tipoproductoservicioinven_descripcion;
	}

	public String gettipocosteo_descripcion() {
		return this.tipocosteo_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getunidadpeso_descripcion() {
		return this.unidadpeso_descripcion;
	}

	public String getarancel_descripcion() {
		return this.arancel_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getclienteproveedordefecto_descripcion() {
		return this.clienteproveedordefecto_descripcion;
	}

	public String gettipoproducto_descripcion() {
		return this.tipoproducto_descripcion;
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


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaGrupo(Linea lineagrupo) {
		try {
			this.lineagrupo=lineagrupo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaCategoria(Linea lineacategoria) {
		try {
			this.lineacategoria=lineacategoria;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaMarca(Linea lineamarca) {
		try {
			this.lineamarca=lineamarca;
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


	public  void  setTipoProductoServicioInven(TipoProductoServicioInven tipoproductoservicioinven) {
		try {
			this.tipoproductoservicioinven=tipoproductoservicioinven;
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


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidadPeso(Unidad unidadpeso) {
		try {
			this.unidadpeso=unidadpeso;
		} catch(Exception e) {
			;
		}
	}


	public  void  setArancel(Arancel arancel) {
		try {
			this.arancel=arancel;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteProveedorDefecto(Cliente clienteproveedordefecto) {
		try {
			this.clienteproveedordefecto=clienteproveedordefecto;
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


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineagrupo_descripcion(String lineagrupo_descripcion) {
		try {
			this.lineagrupo_descripcion=lineagrupo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineacategoria_descripcion(String lineacategoria_descripcion) {
		try {
			this.lineacategoria_descripcion=lineacategoria_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineamarca_descripcion(String lineamarca_descripcion) {
		try {
			this.lineamarca_descripcion=lineamarca_descripcion;
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


	public  void  settipoproductoservicioinven_descripcion(String tipoproductoservicioinven_descripcion) {
		try {
			this.tipoproductoservicioinven_descripcion=tipoproductoservicioinven_descripcion;
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


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidadpeso_descripcion(String unidadpeso_descripcion) {
		try {
			this.unidadpeso_descripcion=unidadpeso_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setarancel_descripcion(String arancel_descripcion) {
		try {
			this.arancel_descripcion=arancel_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclienteproveedordefecto_descripcion(String clienteproveedordefecto_descripcion) {
		try {
			this.clienteproveedordefecto_descripcion=clienteproveedordefecto_descripcion;
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


	
	
	public List<ProveedorProducto> getProveedorProductos() {
		return this.proveedorproductos;
	}

	public List<Precio> getPrecios() {
		return this.precios;
	}

	public List<DetalleImpuestoInven> getDetalleImpuestoInvens() {
		return this.detalleimpuestoinvens;
	}

	public List<PresupuestoVentas> getPresupuestoVentass() {
		return this.presupuestoventass;
	}

	public List<PoliticaProducto> getPoliticaProductos() {
		return this.politicaproductos;
	}

	public List<SerieProducto> getSerieProductos() {
		return this.serieproductos;
	}

	public List<UbicacionProdu> getUbicacionProdus() {
		return this.ubicacionprodus;
	}

	public List<ParametroProducto> getParametroProductos() {
		return this.parametroproductos;
	}

	public List<ProductoUnidad> getProductoUnidads() {
		return this.productounidads;
	}

	public List<Ingrediente> getIngredienteRelacions() {
		return this.ingredienteRelacions;
	}

	public List<ProductoCarac> getProductoCaracs() {
		return this.productocaracs;
	}

	public List<ServicioCliente> getServicioClientes() {
		return this.servicioclientes;
	}

	public List<ProductoPromocion> getProductoPromocionRelacions() {
		return this.productopromocionRelacions;
	}

	public List<ProductoEspeci> getProductoEspecis() {
		return this.productoespecis;
	}

	public List<ProductoReempla> getProductoReemplas() {
		return this.productoreemplas;
	}

	public List<ProductoEstadistica> getProductoEstadisticas() {
		return this.productoestadisticas;
	}

	public List<PoliticaFactu> getPoliticaFactus() {
		return this.politicafactus;
	}

	public List<ProductoCuentaContable> getProductoCuentaContables() {
		return this.productocuentacontables;
	}

	public List<BodegaProducto> getBodegaProductos() {
		return this.bodegaproductos;
	}

	public List<PresupuestoProducto> getPresupuestoProductos() {
		return this.presupuestoproductos;
	}

	public List<SaldoMesProducto> getSaldoMesProductos() {
		return this.saldomesproductos;
	}

	
	
	public  void  setProveedorProductos(List<ProveedorProducto> proveedorproductos) {
		try {
			this.proveedorproductos=proveedorproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPrecios(List<Precio> precios) {
		try {
			this.precios=precios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens) {
		try {
			this.detalleimpuestoinvens=detalleimpuestoinvens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoVentass(List<PresupuestoVentas> presupuestoventass) {
		try {
			this.presupuestoventass=presupuestoventass;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticaProductos(List<PoliticaProducto> politicaproductos) {
		try {
			this.politicaproductos=politicaproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSerieProductos(List<SerieProducto> serieproductos) {
		try {
			this.serieproductos=serieproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setUbicacionProdus(List<UbicacionProdu> ubicacionprodus) {
		try {
			this.ubicacionprodus=ubicacionprodus;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroProductos(List<ParametroProducto> parametroproductos) {
		try {
			this.parametroproductos=parametroproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoUnidads(List<ProductoUnidad> productounidads) {
		try {
			this.productounidads=productounidads;
		} catch(Exception e) {
			;
		}
	}

	public  void  setIngredienteRelacions(List<Ingrediente> ingredienteRelacions) {
		try {
			this.ingredienteRelacions=ingredienteRelacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoCaracs(List<ProductoCarac> productocaracs) {
		try {
			this.productocaracs=productocaracs;
		} catch(Exception e) {
			;
		}
	}

	public  void  setServicioClientes(List<ServicioCliente> servicioclientes) {
		try {
			this.servicioclientes=servicioclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoPromocionRelacions(List<ProductoPromocion> productopromocionRelacions) {
		try {
			this.productopromocionRelacions=productopromocionRelacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoEspecis(List<ProductoEspeci> productoespecis) {
		try {
			this.productoespecis=productoespecis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoReemplas(List<ProductoReempla> productoreemplas) {
		try {
			this.productoreemplas=productoreemplas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoEstadisticas(List<ProductoEstadistica> productoestadisticas) {
		try {
			this.productoestadisticas=productoestadisticas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticaFactus(List<PoliticaFactu> politicafactus) {
		try {
			this.politicafactus=politicafactus;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoCuentaContables(List<ProductoCuentaContable> productocuentacontables) {
		try {
			this.productocuentacontables=productocuentacontables;
		} catch(Exception e) {
			;
		}
	}

	public  void  setBodegaProductos(List<BodegaProducto> bodegaproductos) {
		try {
			this.bodegaproductos=bodegaproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoProductos(List<PresupuestoProducto> presupuestoproductos) {
		try {
			this.presupuestoproductos=presupuestoproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSaldoMesProductos(List<SaldoMesProducto> saldomesproductos) {
		try {
			this.saldomesproductos=saldomesproductos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_linea_marca_descripcion="";String id_tipo_producto_servicio_descripcion="";String id_tipo_producto_servicio_inven_descripcion="";String id_tipo_costeo_descripcion="";String id_unidad_descripcion="";String id_unidad_peso_descripcion="";String id_arancel_descripcion="";String id_cliente_descripcion="";String id_cliente_proveedor_defecto_descripcion="";String esta_activo_descripcion="";String con_stock_negativo_descripcion="";String con_precio_minimo_descripcion="";String con_lote_descripcion="";String con_confirmacion_descripcion="";String con_presupuesto_descripcion="";String con_importacion_descripcion="";String con_final_descripcion="";String con_consep_descripcion="";String con_serie_descripcion="";String con_balanza_descripcion="";String id_tipo_producto_descripcion="";String id_color_producto_descripcion="";String id_clase_producto_descripcion="";String id_efecto_producto_descripcion="";String id_marca_producto_descripcion="";String id_modelo_producto_descripcion="";String id_material_producto_descripcion="";String id_segmento_producto_descripcion="";String id_talla_producto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_linea_grupo_descripcion() {
		return id_linea_grupo_descripcion;
	}
	public String getid_linea_categoria_descripcion() {
		return id_linea_categoria_descripcion;
	}
	public String getid_linea_marca_descripcion() {
		return id_linea_marca_descripcion;
	}
	public String getid_tipo_producto_servicio_descripcion() {
		return id_tipo_producto_servicio_descripcion;
	}
	public String getid_tipo_producto_servicio_inven_descripcion() {
		return id_tipo_producto_servicio_inven_descripcion;
	}
	public String getid_tipo_costeo_descripcion() {
		return id_tipo_costeo_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_unidad_peso_descripcion() {
		return id_unidad_peso_descripcion;
	}
	public String getid_arancel_descripcion() {
		return id_arancel_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_cliente_proveedor_defecto_descripcion() {
		return id_cliente_proveedor_defecto_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	public String getcon_stock_negativo_descripcion() {
		return con_stock_negativo_descripcion;
	}
	public String getcon_precio_minimo_descripcion() {
		return con_precio_minimo_descripcion;
	}
	public String getcon_lote_descripcion() {
		return con_lote_descripcion;
	}
	public String getcon_confirmacion_descripcion() {
		return con_confirmacion_descripcion;
	}
	public String getcon_presupuesto_descripcion() {
		return con_presupuesto_descripcion;
	}
	public String getcon_importacion_descripcion() {
		return con_importacion_descripcion;
	}
	public String getcon_final_descripcion() {
		return con_final_descripcion;
	}
	public String getcon_consep_descripcion() {
		return con_consep_descripcion;
	}
	public String getcon_serie_descripcion() {
		return con_serie_descripcion;
	}
	public String getcon_balanza_descripcion() {
		return con_balanza_descripcion;
	}
	public String getid_tipo_producto_descripcion() {
		return id_tipo_producto_descripcion;
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
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_grupo_descripcion(String newid_linea_grupo_descripcion)throws Exception {
		try {
			this.id_linea_grupo_descripcion=newid_linea_grupo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_categoria_descripcion(String newid_linea_categoria_descripcion)throws Exception {
		try {
			this.id_linea_categoria_descripcion=newid_linea_categoria_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_marca_descripcion(String newid_linea_marca_descripcion)throws Exception {
		try {
			this.id_linea_marca_descripcion=newid_linea_marca_descripcion;
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
	public void setid_tipo_producto_servicio_inven_descripcion(String newid_tipo_producto_servicio_inven_descripcion)throws Exception {
		try {
			this.id_tipo_producto_servicio_inven_descripcion=newid_tipo_producto_servicio_inven_descripcion;
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
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_peso_descripcion(String newid_unidad_peso_descripcion)throws Exception {
		try {
			this.id_unidad_peso_descripcion=newid_unidad_peso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_arancel_descripcion(String newid_arancel_descripcion)throws Exception {
		try {
			this.id_arancel_descripcion=newid_arancel_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_proveedor_defecto_descripcion(String newid_cliente_proveedor_defecto_descripcion)throws Exception {
		try {
			this.id_cliente_proveedor_defecto_descripcion=newid_cliente_proveedor_defecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_stock_negativo_descripcion(String newcon_stock_negativo_descripcion)throws Exception {
		try {
			this.con_stock_negativo_descripcion=newcon_stock_negativo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precio_minimo_descripcion(String newcon_precio_minimo_descripcion)throws Exception {
		try {
			this.con_precio_minimo_descripcion=newcon_precio_minimo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lote_descripcion(String newcon_lote_descripcion)throws Exception {
		try {
			this.con_lote_descripcion=newcon_lote_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_confirmacion_descripcion(String newcon_confirmacion_descripcion)throws Exception {
		try {
			this.con_confirmacion_descripcion=newcon_confirmacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_presupuesto_descripcion(String newcon_presupuesto_descripcion)throws Exception {
		try {
			this.con_presupuesto_descripcion=newcon_presupuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_importacion_descripcion(String newcon_importacion_descripcion)throws Exception {
		try {
			this.con_importacion_descripcion=newcon_importacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_final_descripcion(String newcon_final_descripcion)throws Exception {
		try {
			this.con_final_descripcion=newcon_final_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_consep_descripcion(String newcon_consep_descripcion)throws Exception {
		try {
			this.con_consep_descripcion=newcon_consep_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_serie_descripcion(String newcon_serie_descripcion)throws Exception {
		try {
			this.con_serie_descripcion=newcon_serie_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_balanza_descripcion(String newcon_balanza_descripcion)throws Exception {
		try {
			this.con_balanza_descripcion=newcon_balanza_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_linea_marca_descripcion="";this.id_tipo_producto_servicio_descripcion="";this.id_tipo_producto_servicio_inven_descripcion="";this.id_tipo_costeo_descripcion="";this.id_unidad_descripcion="";this.id_unidad_peso_descripcion="";this.id_arancel_descripcion="";this.id_cliente_descripcion="";this.id_cliente_proveedor_defecto_descripcion="";this.esta_activo_descripcion="";this.con_stock_negativo_descripcion="";this.con_precio_minimo_descripcion="";this.con_lote_descripcion="";this.con_confirmacion_descripcion="";this.con_presupuesto_descripcion="";this.con_importacion_descripcion="";this.con_final_descripcion="";this.con_consep_descripcion="";this.con_serie_descripcion="";this.con_balanza_descripcion="";this.id_tipo_producto_descripcion="";this.id_color_producto_descripcion="";this.id_clase_producto_descripcion="";this.id_efecto_producto_descripcion="";this.id_marca_producto_descripcion="";this.id_modelo_producto_descripcion="";this.id_material_producto_descripcion="";this.id_segmento_producto_descripcion="";this.id_talla_producto_descripcion="";
	}
	
	
	Object proveedorproductosDescripcionReporte;
	Object preciosDescripcionReporte;
	Object detalleimpuestoinvensDescripcionReporte;
	Object presupuestoventassDescripcionReporte;
	Object politicaproductosDescripcionReporte;
	Object serieproductosDescripcionReporte;
	Object ubicacionprodusDescripcionReporte;
	Object parametroproductosDescripcionReporte;
	Object productounidadsDescripcionReporte;
	Object ingredienteRelacionsDescripcionReporte;
	Object productocaracsDescripcionReporte;
	Object servicioclientesDescripcionReporte;
	Object productopromocionRelacionsDescripcionReporte;
	Object productoespecisDescripcionReporte;
	Object productoreemplasDescripcionReporte;
	Object productoestadisticasDescripcionReporte;
	Object politicafactusDescripcionReporte;
	Object productocuentacontablesDescripcionReporte;
	Object bodegaproductosDescripcionReporte;
	Object presupuestoproductosDescripcionReporte;
	Object saldomesproductosDescripcionReporte;
	
	
	public Object getproveedorproductosDescripcionReporte() {
		return proveedorproductosDescripcionReporte;
	}

	public Object getpreciosDescripcionReporte() {
		return preciosDescripcionReporte;
	}

	public Object getdetalleimpuestoinvensDescripcionReporte() {
		return detalleimpuestoinvensDescripcionReporte;
	}

	public Object getpresupuestoventassDescripcionReporte() {
		return presupuestoventassDescripcionReporte;
	}

	public Object getpoliticaproductosDescripcionReporte() {
		return politicaproductosDescripcionReporte;
	}

	public Object getserieproductosDescripcionReporte() {
		return serieproductosDescripcionReporte;
	}

	public Object getubicacionprodusDescripcionReporte() {
		return ubicacionprodusDescripcionReporte;
	}

	public Object getparametroproductosDescripcionReporte() {
		return parametroproductosDescripcionReporte;
	}

	public Object getproductounidadsDescripcionReporte() {
		return productounidadsDescripcionReporte;
	}

	public Object getingredienteRelacionsDescripcionReporte() {
		return ingredienteRelacionsDescripcionReporte;
	}

	public Object getproductocaracsDescripcionReporte() {
		return productocaracsDescripcionReporte;
	}

	public Object getservicioclientesDescripcionReporte() {
		return servicioclientesDescripcionReporte;
	}

	public Object getproductopromocionRelacionsDescripcionReporte() {
		return productopromocionRelacionsDescripcionReporte;
	}

	public Object getproductoespecisDescripcionReporte() {
		return productoespecisDescripcionReporte;
	}

	public Object getproductoreemplasDescripcionReporte() {
		return productoreemplasDescripcionReporte;
	}

	public Object getproductoestadisticasDescripcionReporte() {
		return productoestadisticasDescripcionReporte;
	}

	public Object getpoliticafactusDescripcionReporte() {
		return politicafactusDescripcionReporte;
	}

	public Object getproductocuentacontablesDescripcionReporte() {
		return productocuentacontablesDescripcionReporte;
	}

	public Object getbodegaproductosDescripcionReporte() {
		return bodegaproductosDescripcionReporte;
	}

	public Object getpresupuestoproductosDescripcionReporte() {
		return presupuestoproductosDescripcionReporte;
	}

	public Object getsaldomesproductosDescripcionReporte() {
		return saldomesproductosDescripcionReporte;
	}

	
	
	public  void  setproveedorproductosDescripcionReporte(Object proveedorproductos) {
		try {
			this.proveedorproductosDescripcionReporte=proveedorproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpreciosDescripcionReporte(Object precios) {
		try {
			this.preciosDescripcionReporte=precios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleimpuestoinvensDescripcionReporte(Object detalleimpuestoinvens) {
		try {
			this.detalleimpuestoinvensDescripcionReporte=detalleimpuestoinvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoventassDescripcionReporte(Object presupuestoventass) {
		try {
			this.presupuestoventassDescripcionReporte=presupuestoventass;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticaproductosDescripcionReporte(Object politicaproductos) {
		try {
			this.politicaproductosDescripcionReporte=politicaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setserieproductosDescripcionReporte(Object serieproductos) {
		try {
			this.serieproductosDescripcionReporte=serieproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setubicacionprodusDescripcionReporte(Object ubicacionprodus) {
		try {
			this.ubicacionprodusDescripcionReporte=ubicacionprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroproductosDescripcionReporte(Object parametroproductos) {
		try {
			this.parametroproductosDescripcionReporte=parametroproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductounidadsDescripcionReporte(Object productounidads) {
		try {
			this.productounidadsDescripcionReporte=productounidads;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setingredienteRelacionsDescripcionReporte(Object ingredientes) {
		try {
			this.ingredienteRelacionsDescripcionReporte=ingredientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductocaracsDescripcionReporte(Object productocaracs) {
		try {
			this.productocaracsDescripcionReporte=productocaracs;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setservicioclientesDescripcionReporte(Object servicioclientes) {
		try {
			this.servicioclientesDescripcionReporte=servicioclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductopromocionRelacionsDescripcionReporte(Object productopromocions) {
		try {
			this.productopromocionRelacionsDescripcionReporte=productopromocions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoespecisDescripcionReporte(Object productoespecis) {
		try {
			this.productoespecisDescripcionReporte=productoespecis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoreemplasDescripcionReporte(Object productoreemplas) {
		try {
			this.productoreemplasDescripcionReporte=productoreemplas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoestadisticasDescripcionReporte(Object productoestadisticas) {
		try {
			this.productoestadisticasDescripcionReporte=productoestadisticas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticafactusDescripcionReporte(Object politicafactus) {
		try {
			this.politicafactusDescripcionReporte=politicafactus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductocuentacontablesDescripcionReporte(Object productocuentacontables) {
		try {
			this.productocuentacontablesDescripcionReporte=productocuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbodegaproductosDescripcionReporte(Object bodegaproductos) {
		try {
			this.bodegaproductosDescripcionReporte=bodegaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoproductosDescripcionReporte(Object presupuestoproductos) {
		try {
			this.presupuestoproductosDescripcionReporte=presupuestoproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsaldomesproductosDescripcionReporte(Object saldomesproductos) {
		try {
			this.saldomesproductosDescripcionReporte=saldomesproductos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

