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
import com.bydan.erp.inventario.util.ProductoCuentaContableConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ProductoCuentaContable


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProductoCuentaContableParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoCuentaContable productocuentacontable;	
	protected List<ProductoCuentaContable> productocuentacontables;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CuentaContable> cuentacontableinventariosForeignKey;
	public List<CuentaContable> cuentacontablecostosForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	public List<CuentaContable> cuentacontabledescuentosForeignKey;
	public List<CuentaContable> cuentacontabledevolucionsForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public ProductoCuentaContableParameterReturnGeneral () throws Exception {						
		super();
		this.productocuentacontables= new ArrayList<ProductoCuentaContable>();
		this.productocuentacontable= new ProductoCuentaContable();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ProductoCuentaContable getProductoCuentaContable() throws Exception {	
		return productocuentacontable;
	}
		
	public void setProductoCuentaContable(ProductoCuentaContable newProductoCuentaContable) {
		this.productocuentacontable = newProductoCuentaContable;
	}
	
	public List<ProductoCuentaContable> getProductoCuentaContables() throws Exception {		
		return productocuentacontables;
	}
	
	public void setProductoCuentaContables(List<ProductoCuentaContable> newProductoCuentaContables) {
		this.productocuentacontables = newProductoCuentaContables;
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

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariosForeignKey() {
		return this.cuentacontableinventariosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostosForeignKey() {
		return this.cuentacontablecostosForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledescuentosForeignKey() {
		return this.cuentacontabledescuentosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledevolucionsForeignKey() {
		return this.cuentacontabledevolucionsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
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

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setcuentacontableinventariosForeignKey(List<CuentaContable> cuentacontableinventariosForeignKey) {
		this.cuentacontableinventariosForeignKey=cuentacontableinventariosForeignKey;
	}

	public void setcuentacontablecostosForeignKey(List<CuentaContable> cuentacontablecostosForeignKey) {
		this.cuentacontablecostosForeignKey=cuentacontablecostosForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}

	public void setcuentacontabledescuentosForeignKey(List<CuentaContable> cuentacontabledescuentosForeignKey) {
		this.cuentacontabledescuentosForeignKey=cuentacontabledescuentosForeignKey;
	}

	public void setcuentacontabledevolucionsForeignKey(List<CuentaContable> cuentacontabledevolucionsForeignKey) {
		this.cuentacontabledevolucionsForeignKey=cuentacontabledevolucionsForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

