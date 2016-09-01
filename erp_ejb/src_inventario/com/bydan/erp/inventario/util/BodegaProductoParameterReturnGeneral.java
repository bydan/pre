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
import com.bydan.erp.inventario.util.BodegaProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//BodegaProducto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class BodegaProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected BodegaProducto bodegaproducto;	
	protected List<BodegaProducto> bodegaproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<EstadoBodegaProducto> estadobodegaproductosForeignKey;
	public List<CuentaContable> cuentacontableinventariosForeignKey;
	public List<CuentaContable> cuentacontablecostoventasForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	public List<CuentaContable> cuentacontabledescuentosForeignKey;
	public List<CuentaContable> cuentacontableproduccionsForeignKey;
	public List<CuentaContable> cuentacontabledevolucionsForeignKey;
	public List<CuentaContable> cuentacontableingresodebitosForeignKey;
	public List<CuentaContable> cuentacontableingresocreditosForeignKey;
	public List<CuentaContable> cuentacontableresultadodebitosForeignKey;
	public List<CuentaContable> cuentacontableresultadocreditosForeignKey;
	
	public BodegaProductoParameterReturnGeneral () throws Exception {						
		super();
		this.bodegaproductos= new ArrayList<BodegaProducto>();
		this.bodegaproducto= new BodegaProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.estadobodegaproductosForeignKey=new ArrayList<EstadoBodegaProducto>();
		this.cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingresodebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingresocreditosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableresultadodebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableresultadocreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public BodegaProducto getBodegaProducto() throws Exception {	
		return bodegaproducto;
	}
		
	public void setBodegaProducto(BodegaProducto newBodegaProducto) {
		this.bodegaproducto = newBodegaProducto;
	}
	
	public List<BodegaProducto> getBodegaProductos() throws Exception {		
		return bodegaproductos;
	}
	
	public void setBodegaProductos(List<BodegaProducto> newBodegaProductos) {
		this.bodegaproductos = newBodegaProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<EstadoBodegaProducto> getestadobodegaproductosForeignKey() {
		return this.estadobodegaproductosForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariosForeignKey() {
		return this.cuentacontableinventariosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostoventasForeignKey() {
		return this.cuentacontablecostoventasForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledescuentosForeignKey() {
		return this.cuentacontabledescuentosForeignKey;
	}

	public List<CuentaContable> getcuentacontableproduccionsForeignKey() {
		return this.cuentacontableproduccionsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledevolucionsForeignKey() {
		return this.cuentacontabledevolucionsForeignKey;
	}

	public List<CuentaContable> getcuentacontableingresodebitosForeignKey() {
		return this.cuentacontableingresodebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontableingresocreditosForeignKey() {
		return this.cuentacontableingresocreditosForeignKey;
	}

	public List<CuentaContable> getcuentacontableresultadodebitosForeignKey() {
		return this.cuentacontableresultadodebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontableresultadocreditosForeignKey() {
		return this.cuentacontableresultadocreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setestadobodegaproductosForeignKey(List<EstadoBodegaProducto> estadobodegaproductosForeignKey) {
		this.estadobodegaproductosForeignKey=estadobodegaproductosForeignKey;
	}

	public void setcuentacontableinventariosForeignKey(List<CuentaContable> cuentacontableinventariosForeignKey) {
		this.cuentacontableinventariosForeignKey=cuentacontableinventariosForeignKey;
	}

	public void setcuentacontablecostoventasForeignKey(List<CuentaContable> cuentacontablecostoventasForeignKey) {
		this.cuentacontablecostoventasForeignKey=cuentacontablecostoventasForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}

	public void setcuentacontabledescuentosForeignKey(List<CuentaContable> cuentacontabledescuentosForeignKey) {
		this.cuentacontabledescuentosForeignKey=cuentacontabledescuentosForeignKey;
	}

	public void setcuentacontableproduccionsForeignKey(List<CuentaContable> cuentacontableproduccionsForeignKey) {
		this.cuentacontableproduccionsForeignKey=cuentacontableproduccionsForeignKey;
	}

	public void setcuentacontabledevolucionsForeignKey(List<CuentaContable> cuentacontabledevolucionsForeignKey) {
		this.cuentacontabledevolucionsForeignKey=cuentacontabledevolucionsForeignKey;
	}

	public void setcuentacontableingresodebitosForeignKey(List<CuentaContable> cuentacontableingresodebitosForeignKey) {
		this.cuentacontableingresodebitosForeignKey=cuentacontableingresodebitosForeignKey;
	}

	public void setcuentacontableingresocreditosForeignKey(List<CuentaContable> cuentacontableingresocreditosForeignKey) {
		this.cuentacontableingresocreditosForeignKey=cuentacontableingresocreditosForeignKey;
	}

	public void setcuentacontableresultadodebitosForeignKey(List<CuentaContable> cuentacontableresultadodebitosForeignKey) {
		this.cuentacontableresultadodebitosForeignKey=cuentacontableresultadodebitosForeignKey;
	}

	public void setcuentacontableresultadocreditosForeignKey(List<CuentaContable> cuentacontableresultadocreditosForeignKey) {
		this.cuentacontableresultadocreditosForeignKey=cuentacontableresultadocreditosForeignKey;
	}
}

