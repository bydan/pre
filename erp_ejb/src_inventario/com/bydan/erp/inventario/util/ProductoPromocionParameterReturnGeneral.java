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
import com.bydan.erp.inventario.util.ProductoPromocionConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ProductoPromocion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProductoPromocionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoPromocion productopromocion;	
	protected List<ProductoPromocion> productopromocions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Bodega> bodegarelacionsForeignKey;
	public List<Producto> productorelacionsForeignKey;
	
	public ProductoPromocionParameterReturnGeneral () throws Exception {						
		super();
		this.productopromocions= new ArrayList<ProductoPromocion>();
		this.productopromocion= new ProductoPromocion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.bodegarelacionsForeignKey=new ArrayList<Bodega>();
		this.productorelacionsForeignKey=new ArrayList<Producto>();
	} 
	
	public ProductoPromocion getProductoPromocion() throws Exception {	
		return productopromocion;
	}
		
	public void setProductoPromocion(ProductoPromocion newProductoPromocion) {
		this.productopromocion = newProductoPromocion;
	}
	
	public List<ProductoPromocion> getProductoPromocions() throws Exception {		
		return productopromocions;
	}
	
	public void setProductoPromocions(List<ProductoPromocion> newProductoPromocions) {
		this.productopromocions = newProductoPromocions;
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

	public List<Bodega> getbodegarelacionsForeignKey() {
		return this.bodegarelacionsForeignKey;
	}

	public List<Producto> getproductorelacionsForeignKey() {
		return this.productorelacionsForeignKey;
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

	public void setbodegarelacionsForeignKey(List<Bodega> bodegarelacionsForeignKey) {
		this.bodegarelacionsForeignKey=bodegarelacionsForeignKey;
	}

	public void setproductorelacionsForeignKey(List<Producto> productorelacionsForeignKey) {
		this.productorelacionsForeignKey=productorelacionsForeignKey;
	}
}

