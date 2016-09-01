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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMermaConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoOrdenDetaProduMerma


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMermaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoOrdenDetaProduMerma productoordendetaprodumerma;	
	protected List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas;
	
	
	public List<OrdenDetaProdu> ordendetaprodusForeignKey;
	public List<TipoMermaEmpresa> tipomermaempresasForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoOrdenDetaProduMermaParameterReturnGeneral () throws Exception {						
		super();
		this.productoordendetaprodumermas= new ArrayList<ProductoOrdenDetaProduMerma>();
		this.productoordendetaprodumerma= new ProductoOrdenDetaProduMerma();
		
		
		this.ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
		this.tipomermaempresasForeignKey=new ArrayList<TipoMermaEmpresa>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoOrdenDetaProduMerma getProductoOrdenDetaProduMerma() throws Exception {	
		return productoordendetaprodumerma;
	}
		
	public void setProductoOrdenDetaProduMerma(ProductoOrdenDetaProduMerma newProductoOrdenDetaProduMerma) {
		this.productoordendetaprodumerma = newProductoOrdenDetaProduMerma;
	}
	
	public List<ProductoOrdenDetaProduMerma> getProductoOrdenDetaProduMermas() throws Exception {		
		return productoordendetaprodumermas;
	}
	
	public void setProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> newProductoOrdenDetaProduMermas) {
		this.productoordendetaprodumermas = newProductoOrdenDetaProduMermas;
	}
	
	

	public List<OrdenDetaProdu> getordendetaprodusForeignKey() {
		return this.ordendetaprodusForeignKey;
	}

	public List<TipoMermaEmpresa> gettipomermaempresasForeignKey() {
		return this.tipomermaempresasForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}
	
	

	public void setordendetaprodusForeignKey(List<OrdenDetaProdu> ordendetaprodusForeignKey) {
		this.ordendetaprodusForeignKey=ordendetaprodusForeignKey;
	}

	public void settipomermaempresasForeignKey(List<TipoMermaEmpresa> tipomermaempresasForeignKey) {
		this.tipomermaempresasForeignKey=tipomermaempresasForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

