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
import com.bydan.erp.inventario.util.ParametroInventarioDefectoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ParametroInventarioDefecto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ParametroInventarioDefectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroInventarioDefecto parametroinventariodefecto;	
	protected List<ParametroInventarioDefecto> parametroinventariodefectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<GrupoBodega> grupobodegasForeignKey;
	public List<CalidadProducto> calidadproductosForeignKey;
	public List<TipoServicio> tiposerviciosForeignKey;
	public List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey;
	public List<TipoProductoServicio> tipoproductoserviciosForeignKey;
	public List<TipoCosteo> tipocosteosForeignKey;
	public List<TipoProducto> tipoproductosForeignKey;
	public List<TipoViaTransporte> tipoviatransportesForeignKey;
	public List<RangoUnidadVenta> rangounidadventasForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<ColorProducto> colorproductosForeignKey;
	public List<ClaseProducto> claseproductosForeignKey;
	public List<EfectoProducto> efectoproductosForeignKey;
	public List<MarcaProducto> marcaproductosForeignKey;
	public List<ModeloProducto> modeloproductosForeignKey;
	public List<MaterialProducto> materialproductosForeignKey;
	public List<SegmentoProducto> segmentoproductosForeignKey;
	public List<TallaProducto> tallaproductosForeignKey;
	
	public ParametroInventarioDefectoParameterReturnGeneral () throws Exception {						
		super();
		this.parametroinventariodefectos= new ArrayList<ParametroInventarioDefecto>();
		this.parametroinventariodefecto= new ParametroInventarioDefecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.grupobodegasForeignKey=new ArrayList<GrupoBodega>();
		this.calidadproductosForeignKey=new ArrayList<CalidadProducto>();
		this.tiposerviciosForeignKey=new ArrayList<TipoServicio>();
		this.tipoproductoservicioinvensForeignKey=new ArrayList<TipoProductoServicioInven>();
		this.tipoproductoserviciosForeignKey=new ArrayList<TipoProductoServicio>();
		this.tipocosteosForeignKey=new ArrayList<TipoCosteo>();
		this.tipoproductosForeignKey=new ArrayList<TipoProducto>();
		this.tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
		this.rangounidadventasForeignKey=new ArrayList<RangoUnidadVenta>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.colorproductosForeignKey=new ArrayList<ColorProducto>();
		this.claseproductosForeignKey=new ArrayList<ClaseProducto>();
		this.efectoproductosForeignKey=new ArrayList<EfectoProducto>();
		this.marcaproductosForeignKey=new ArrayList<MarcaProducto>();
		this.modeloproductosForeignKey=new ArrayList<ModeloProducto>();
		this.materialproductosForeignKey=new ArrayList<MaterialProducto>();
		this.segmentoproductosForeignKey=new ArrayList<SegmentoProducto>();
		this.tallaproductosForeignKey=new ArrayList<TallaProducto>();
	} 
	
	public ParametroInventarioDefecto getParametroInventarioDefecto() throws Exception {	
		return parametroinventariodefecto;
	}
		
	public void setParametroInventarioDefecto(ParametroInventarioDefecto newParametroInventarioDefecto) {
		this.parametroinventariodefecto = newParametroInventarioDefecto;
	}
	
	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() throws Exception {		
		return parametroinventariodefectos;
	}
	
	public void setParametroInventarioDefectos(List<ParametroInventarioDefecto> newParametroInventarioDefectos) {
		this.parametroinventariodefectos = newParametroInventarioDefectos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<GrupoBodega> getgrupobodegasForeignKey() {
		return this.grupobodegasForeignKey;
	}

	public List<CalidadProducto> getcalidadproductosForeignKey() {
		return this.calidadproductosForeignKey;
	}

	public List<TipoServicio> gettiposerviciosForeignKey() {
		return this.tiposerviciosForeignKey;
	}

	public List<TipoProductoServicioInven> gettipoproductoservicioinvensForeignKey() {
		return this.tipoproductoservicioinvensForeignKey;
	}

	public List<TipoProductoServicio> gettipoproductoserviciosForeignKey() {
		return this.tipoproductoserviciosForeignKey;
	}

	public List<TipoCosteo> gettipocosteosForeignKey() {
		return this.tipocosteosForeignKey;
	}

	public List<TipoProducto> gettipoproductosForeignKey() {
		return this.tipoproductosForeignKey;
	}

	public List<TipoViaTransporte> gettipoviatransportesForeignKey() {
		return this.tipoviatransportesForeignKey;
	}

	public List<RangoUnidadVenta> getrangounidadventasForeignKey() {
		return this.rangounidadventasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
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

	public void setgrupobodegasForeignKey(List<GrupoBodega> grupobodegasForeignKey) {
		this.grupobodegasForeignKey=grupobodegasForeignKey;
	}

	public void setcalidadproductosForeignKey(List<CalidadProducto> calidadproductosForeignKey) {
		this.calidadproductosForeignKey=calidadproductosForeignKey;
	}

	public void settiposerviciosForeignKey(List<TipoServicio> tiposerviciosForeignKey) {
		this.tiposerviciosForeignKey=tiposerviciosForeignKey;
	}

	public void settipoproductoservicioinvensForeignKey(List<TipoProductoServicioInven> tipoproductoservicioinvensForeignKey) {
		this.tipoproductoservicioinvensForeignKey=tipoproductoservicioinvensForeignKey;
	}

	public void settipoproductoserviciosForeignKey(List<TipoProductoServicio> tipoproductoserviciosForeignKey) {
		this.tipoproductoserviciosForeignKey=tipoproductoserviciosForeignKey;
	}

	public void settipocosteosForeignKey(List<TipoCosteo> tipocosteosForeignKey) {
		this.tipocosteosForeignKey=tipocosteosForeignKey;
	}

	public void settipoproductosForeignKey(List<TipoProducto> tipoproductosForeignKey) {
		this.tipoproductosForeignKey=tipoproductosForeignKey;
	}

	public void settipoviatransportesForeignKey(List<TipoViaTransporte> tipoviatransportesForeignKey) {
		this.tipoviatransportesForeignKey=tipoviatransportesForeignKey;
	}

	public void setrangounidadventasForeignKey(List<RangoUnidadVenta> rangounidadventasForeignKey) {
		this.rangounidadventasForeignKey=rangounidadventasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
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

