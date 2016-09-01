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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduMaquinaConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoOrdenDetaProduMaquina


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoOrdenDetaProduMaquinaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoOrdenDetaProduMaquina productoordendetaprodumaquina;	
	protected List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas;
	
	
	public List<OrdenDetaProdu> ordendetaprodusForeignKey;
	public List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey;
	public List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey;
	public List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoOrdenDetaProduMaquinaParameterReturnGeneral () throws Exception {						
		super();
		this.productoordendetaprodumaquinas= new ArrayList<ProductoOrdenDetaProduMaquina>();
		this.productoordendetaprodumaquina= new ProductoOrdenDetaProduMaquina();
		
		
		this.ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
		this.tipoareaempresaprodusForeignKey=new ArrayList<TipoAreaEmpresaProdu>();
		this.tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
		this.tipomaquinaempresasForeignKey=new ArrayList<TipoMaquinaEmpresa>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoOrdenDetaProduMaquina getProductoOrdenDetaProduMaquina() throws Exception {	
		return productoordendetaprodumaquina;
	}
		
	public void setProductoOrdenDetaProduMaquina(ProductoOrdenDetaProduMaquina newProductoOrdenDetaProduMaquina) {
		this.productoordendetaprodumaquina = newProductoOrdenDetaProduMaquina;
	}
	
	public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas() throws Exception {		
		return productoordendetaprodumaquinas;
	}
	
	public void setProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> newProductoOrdenDetaProduMaquinas) {
		this.productoordendetaprodumaquinas = newProductoOrdenDetaProduMaquinas;
	}
	
	

	public List<OrdenDetaProdu> getordendetaprodusForeignKey() {
		return this.ordendetaprodusForeignKey;
	}

	public List<TipoAreaEmpresaProdu> gettipoareaempresaprodusForeignKey() {
		return this.tipoareaempresaprodusForeignKey;
	}

	public List<TipoProcesoEmpresaProdu> gettipoprocesoempresaprodusForeignKey() {
		return this.tipoprocesoempresaprodusForeignKey;
	}

	public List<TipoMaquinaEmpresa> gettipomaquinaempresasForeignKey() {
		return this.tipomaquinaempresasForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}
	
	

	public void setordendetaprodusForeignKey(List<OrdenDetaProdu> ordendetaprodusForeignKey) {
		this.ordendetaprodusForeignKey=ordendetaprodusForeignKey;
	}

	public void settipoareaempresaprodusForeignKey(List<TipoAreaEmpresaProdu> tipoareaempresaprodusForeignKey) {
		this.tipoareaempresaprodusForeignKey=tipoareaempresaprodusForeignKey;
	}

	public void settipoprocesoempresaprodusForeignKey(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey) {
		this.tipoprocesoempresaprodusForeignKey=tipoprocesoempresaprodusForeignKey;
	}

	public void settipomaquinaempresasForeignKey(List<TipoMaquinaEmpresa> tipomaquinaempresasForeignKey) {
		this.tipomaquinaempresasForeignKey=tipomaquinaempresasForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

