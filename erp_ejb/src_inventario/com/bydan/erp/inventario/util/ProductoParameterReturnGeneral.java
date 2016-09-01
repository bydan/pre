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
package com.bydan.erp.inventario.util;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.DeepLoadType;
import com.bydan.erp.inventario.util.ProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Producto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Producto producto;	
	protected List<Producto> productos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<Linea> lineamarcasForeignKey;
	public List<TipoProductoServicio> tipoproductoserviciosForeignKey;
	public List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey;
	public List<TipoCosteo> tipocosteosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<Unidad> unidadpesosForeignKey;
	public List<Arancel> arancelsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Cliente> clienteproveedordefectosForeignKey;
	public List<TipoProducto> tipoproductosForeignKey;
	public List<ColorProducto> colorproductosForeignKey;
	public List<ClaseProducto> claseproductosForeignKey;
	public List<EfectoProducto> efectoproductosForeignKey;
	public List<MarcaProducto> marcaproductosForeignKey;
	public List<ModeloProducto> modeloproductosForeignKey;
	public List<MaterialProducto> materialproductosForeignKey;
	public List<SegmentoProducto> segmentoproductosForeignKey;
	public List<TallaProducto> tallaproductosForeignKey;
	
	public ProductoParameterReturnGeneral () throws Exception {						
		super();
		this.productos= new ArrayList<Producto>();
		this.producto= new Producto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.lineamarcasForeignKey=new ArrayList<Linea>();
		this.tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
		this.tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
		this.tipocosteosForeignKey=new ArrayList<TipoCosteo>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.unidadpesosForeignKey=new ArrayList<Unidad>();
		this.arancelsForeignKey=new ArrayList<Arancel>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.clienteproveedordefectosForeignKey=new ArrayList<Cliente>();
		this.tipoproductosForeignKey=new ArrayList<TipoProducto>();
		this.colorproductosForeignKey=new ArrayList<ColorProducto>();
		this.claseproductosForeignKey=new ArrayList<ClaseProducto>();
		this.efectoproductosForeignKey=new ArrayList<EfectoProducto>();
		this.marcaproductosForeignKey=new ArrayList<MarcaProducto>();
		this.modeloproductosForeignKey=new ArrayList<ModeloProducto>();
		this.materialproductosForeignKey=new ArrayList<MaterialProducto>();
		this.segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
		this.tallaproductosForeignKey=new ArrayList<TallaProducto>();
	} 
	
	public Producto getProducto() throws Exception {	
		return producto;
	}
		
	public void setProducto(Producto newProducto) {
		this.producto = newProducto;
	}
	
	public List<Producto> getProductos() throws Exception {		
		return productos;
	}
	
	public void setProductos(List<Producto> newProductos) {
		this.productos = newProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}

	public List<Linea> getlineacategoriasForeignKey() {
		return this.lineacategoriasForeignKey;
	}

	public List<Linea> getlineamarcasForeignKey() {
		return this.lineamarcasForeignKey;
	}

	public List<TipoProductoServicio> gettipoproductoserviciosForeignKey() {
		return this.tipoproductoserviciosForeignKey;
	}

	public List<TipoProductoServicioInven> gettipoproductoservicioinvensForeignKey() {
		return this.tipoproductoservicioinvensForeignKey;
	}

	public List<TipoCosteo> gettipocosteosForeignKey() {
		return this.tipocosteosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<Unidad> getunidadpesosForeignKey() {
		return this.unidadpesosForeignKey;
	}

	public List<Arancel> getarancelsForeignKey() {
		return this.arancelsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Cliente> getclienteproveedordefectosForeignKey() {
		return this.clienteproveedordefectosForeignKey;
	}

	public List<TipoProducto> gettipoproductosForeignKey() {
		return this.tipoproductosForeignKey;
	}

	public List<ColorProducto> getcolorproductosForeignKey() {
		return this.colorproductosForeignKey;
	}

	public List<ClaseProducto> getclaseproductosForeignKey() {
		return this.claseproductosForeignKey;
	}

	public List<EfectoProducto> getefectoproductosForeignKey() {
		return this.efectoproductosForeignKey;
	}

	public List<MarcaProducto> getmarcaproductosForeignKey() {
		return this.marcaproductosForeignKey;
	}

	public List<ModeloProducto> getmodeloproductosForeignKey() {
		return this.modeloproductosForeignKey;
	}

	public List<MaterialProducto> getmaterialproductosForeignKey() {
		return this.materialproductosForeignKey;
	}

	public List<SegmentoProducto> getsegmentoproductosForeignKey() {
		return this.segmentoproductosForeignKey;
	}

	public List<TallaProducto> gettallaproductosForeignKey() {
		return this.tallaproductosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}

	public void setlineacategoriasForeignKey(List<Linea> lineacategoriasForeignKey) {
		this.lineacategoriasForeignKey=lineacategoriasForeignKey;
	}

	public void setlineamarcasForeignKey(List<Linea> lineamarcasForeignKey) {
		this.lineamarcasForeignKey=lineamarcasForeignKey;
	}

	public void settipoproductoserviciosForeignKey(List<TipoProductoServicio> tipoproductoserviciosForeignKey) {
		this.tipoproductoserviciosForeignKey=tipoproductoserviciosForeignKey;
	}

	public void settipoproductoservicioinvensForeignKey(List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey) {
		this.tipoproductoservicioinvensForeignKey=tipoproductoservicioinvensForeignKey;
	}

	public void settipocosteosForeignKey(List<TipoCosteo> tipocosteosForeignKey) {
		this.tipocosteosForeignKey=tipocosteosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setunidadpesosForeignKey(List<Unidad> unidadpesosForeignKey) {
		this.unidadpesosForeignKey=unidadpesosForeignKey;
	}

	public void setarancelsForeignKey(List<Arancel> arancelsForeignKey) {
		this.arancelsForeignKey=arancelsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setclienteproveedordefectosForeignKey(List<Cliente> clienteproveedordefectosForeignKey) {
		this.clienteproveedordefectosForeignKey=clienteproveedordefectosForeignKey;
	}

	public void settipoproductosForeignKey(List<TipoProducto> tipoproductosForeignKey) {
		this.tipoproductosForeignKey=tipoproductosForeignKey;
	}

	public void setcolorproductosForeignKey(List<ColorProducto> colorproductosForeignKey) {
		this.colorproductosForeignKey=colorproductosForeignKey;
	}

	public void setclaseproductosForeignKey(List<ClaseProducto> claseproductosForeignKey) {
		this.claseproductosForeignKey=claseproductosForeignKey;
	}

	public void setefectoproductosForeignKey(List<EfectoProducto> efectoproductosForeignKey) {
		this.efectoproductosForeignKey=efectoproductosForeignKey;
	}

	public void setmarcaproductosForeignKey(List<MarcaProducto> marcaproductosForeignKey) {
		this.marcaproductosForeignKey=marcaproductosForeignKey;
	}

	public void setmodeloproductosForeignKey(List<ModeloProducto> modeloproductosForeignKey) {
		this.modeloproductosForeignKey=modeloproductosForeignKey;
	}

	public void setmaterialproductosForeignKey(List<MaterialProducto> materialproductosForeignKey) {
		this.materialproductosForeignKey=materialproductosForeignKey;
	}

	public void setsegmentoproductosForeignKey(List<SegmentoProducto> segmentoproductosForeignKey) {
		this.segmentoproductosForeignKey=segmentoproductosForeignKey;
	}

	public void settallaproductosForeignKey(List<TallaProducto> tallaproductosForeignKey) {
		this.tallaproductosForeignKey=tallaproductosForeignKey;
	}
}

