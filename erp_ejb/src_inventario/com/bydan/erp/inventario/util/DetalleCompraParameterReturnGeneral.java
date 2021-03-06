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
import com.bydan.erp.inventario.util.DetalleCompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//DetalleCompra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleCompra detallecompra;	
	protected List<DetalleCompra> detallecompras;
	
	
	public List<Compra> comprasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<EstadoDetalleInventario> estadodetalleinventariosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<NovedadProducto> novedadproductosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CuentaContable> cuentacontablecostosForeignKey;
	
	public DetalleCompraParameterReturnGeneral () throws Exception {						
		super();
		this.detallecompras= new ArrayList<DetalleCompra>();
		this.detallecompra= new DetalleCompra();
		
		
		this.comprasForeignKey=new ArrayList<Compra>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.estadodetalleinventariosForeignKey=new ArrayList<EstadoDetalleInventario>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.novedadproductosForeignKey=new ArrayList<NovedadProducto>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public DetalleCompra getDetalleCompra() throws Exception {	
		return detallecompra;
	}
		
	public void setDetalleCompra(DetalleCompra newDetalleCompra) {
		this.detallecompra = newDetalleCompra;
	}
	
	public List<DetalleCompra> getDetalleCompras() throws Exception {		
		return detallecompras;
	}
	
	public void setDetalleCompras(List<DetalleCompra> newDetalleCompras) {
		this.detallecompras = newDetalleCompras;
	}
	
	

	public List<Compra> getcomprasForeignKey() {
		return this.comprasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<EstadoDetalleInventario> getestadodetalleinventariosForeignKey() {
		return this.estadodetalleinventariosForeignKey;
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

	public List<NovedadProducto> getnovedadproductosForeignKey() {
		return this.novedadproductosForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostosForeignKey() {
		return this.cuentacontablecostosForeignKey;
	}
	
	

	public void setcomprasForeignKey(List<Compra> comprasForeignKey) {
		this.comprasForeignKey=comprasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setestadodetalleinventariosForeignKey(List<EstadoDetalleInventario> estadodetalleinventariosForeignKey) {
		this.estadodetalleinventariosForeignKey=estadodetalleinventariosForeignKey;
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

	public void setnovedadproductosForeignKey(List<NovedadProducto> novedadproductosForeignKey) {
		this.novedadproductosForeignKey=novedadproductosForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setcuentacontablecostosForeignKey(List<CuentaContable> cuentacontablecostosForeignKey) {
		this.cuentacontablecostosForeignKey=cuentacontablecostosForeignKey;
	}
}

