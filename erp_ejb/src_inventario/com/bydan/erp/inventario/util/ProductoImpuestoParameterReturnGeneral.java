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
import com.bydan.erp.inventario.util.ProductoImpuestoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ProductoImpuesto


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProductoImpuestoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoImpuesto productoimpuesto;	
	protected List<ProductoImpuesto> productoimpuestos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<ImpuestoInven> impuestoinvensForeignKey;
	
	public ProductoImpuestoParameterReturnGeneral () throws Exception {						
		super();
		this.productoimpuestos= new ArrayList<ProductoImpuesto>();
		this.productoimpuesto= new ProductoImpuesto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.impuestoinvensForeignKey=new ArrayList<ImpuestoInven>();
	} 
	
	public ProductoImpuesto getProductoImpuesto() throws Exception {	
		return productoimpuesto;
	}
		
	public void setProductoImpuesto(ProductoImpuesto newProductoImpuesto) {
		this.productoimpuesto = newProductoImpuesto;
	}
	
	public List<ProductoImpuesto> getProductoImpuestos() throws Exception {		
		return productoimpuestos;
	}
	
	public void setProductoImpuestos(List<ProductoImpuesto> newProductoImpuestos) {
		this.productoimpuestos = newProductoImpuestos;
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

	public List<ImpuestoInven> getimpuestoinvensForeignKey() {
		return this.impuestoinvensForeignKey;
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

	public void setimpuestoinvensForeignKey(List<ImpuestoInven> impuestoinvensForeignKey) {
		this.impuestoinvensForeignKey=impuestoinvensForeignKey;
	}
}

