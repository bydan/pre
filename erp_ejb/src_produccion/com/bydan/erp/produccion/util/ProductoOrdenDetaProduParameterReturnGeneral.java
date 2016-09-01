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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoOrdenDetaProdu


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoOrdenDetaProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoOrdenDetaProdu productoordendetaprodu;	
	protected List<ProductoOrdenDetaProdu> productoordendetaprodus;
	
	
	public List<OrdenDetaProdu> ordendetaprodusForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoOrdenDetaProduParameterReturnGeneral () throws Exception {						
		super();
		this.productoordendetaprodus= new ArrayList<ProductoOrdenDetaProdu>();
		this.productoordendetaprodu= new ProductoOrdenDetaProdu();
		
		
		this.ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoOrdenDetaProdu getProductoOrdenDetaProdu() throws Exception {	
		return productoordendetaprodu;
	}
		
	public void setProductoOrdenDetaProdu(ProductoOrdenDetaProdu newProductoOrdenDetaProdu) {
		this.productoordendetaprodu = newProductoOrdenDetaProdu;
	}
	
	public List<ProductoOrdenDetaProdu> getProductoOrdenDetaProdus() throws Exception {		
		return productoordendetaprodus;
	}
	
	public void setProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> newProductoOrdenDetaProdus) {
		this.productoordendetaprodus = newProductoOrdenDetaProdus;
	}
	
	

	public List<OrdenDetaProdu> getordendetaprodusForeignKey() {
		return this.ordendetaprodusForeignKey;
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
	
	

	public void setordendetaprodusForeignKey(List<OrdenDetaProdu> ordendetaprodusForeignKey) {
		this.ordendetaprodusForeignKey=ordendetaprodusForeignKey;
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
}

