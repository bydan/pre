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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.ProductoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//ProductoPuntoVenta


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoPuntoVenta productopuntoventa;	
	protected List<ProductoPuntoVenta> productopuntoventas;
	
	
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<Linea> lineamarcasForeignKey;
	public List<Producto> productosForeignKey;
	
	public ProductoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.productopuntoventas= new ArrayList<ProductoPuntoVenta>();
		this.productopuntoventa= new ProductoPuntoVenta();
		
		
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.lineamarcasForeignKey=new ArrayList<Linea>();
		this.productosForeignKey=new ArrayList<Producto>();
	} 
	
	public ProductoPuntoVenta getProductoPuntoVenta() throws Exception {	
		return productopuntoventa;
	}
		
	public void setProductoPuntoVenta(ProductoPuntoVenta newProductoPuntoVenta) {
		this.productopuntoventa = newProductoPuntoVenta;
	}
	
	public List<ProductoPuntoVenta> getProductoPuntoVentas() throws Exception {		
		return productopuntoventas;
	}
	
	public void setProductoPuntoVentas(List<ProductoPuntoVenta> newProductoPuntoVentas) {
		this.productopuntoventas = newProductoPuntoVentas;
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

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
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

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}
}

