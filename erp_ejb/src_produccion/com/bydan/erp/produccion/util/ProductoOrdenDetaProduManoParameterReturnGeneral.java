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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduManoConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoOrdenDetaProduMano


import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoOrdenDetaProduManoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoOrdenDetaProduMano productoordendetaprodumano;	
	protected List<ProductoOrdenDetaProduMano> productoordendetaprodumanos;
	
	
	public List<OrdenDetaProdu> ordendetaprodusForeignKey;
	public List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey;
	public List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoOrdenDetaProduManoParameterReturnGeneral () throws Exception {						
		super();
		this.productoordendetaprodumanos= new ArrayList<ProductoOrdenDetaProduMano>();
		this.productoordendetaprodumano= new ProductoOrdenDetaProduMano();
		
		
		this.ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
		this.tipomanoproduempresasForeignKey=new ArrayList<TipoManoProduEmpresa>();
		this.tipoprocesoempresaprodusForeignKey=new ArrayList<TipoProcesoEmpresaProdu>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoOrdenDetaProduMano getProductoOrdenDetaProduMano() throws Exception {	
		return productoordendetaprodumano;
	}
		
	public void setProductoOrdenDetaProduMano(ProductoOrdenDetaProduMano newProductoOrdenDetaProduMano) {
		this.productoordendetaprodumano = newProductoOrdenDetaProduMano;
	}
	
	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos() throws Exception {		
		return productoordendetaprodumanos;
	}
	
	public void setProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> newProductoOrdenDetaProduManos) {
		this.productoordendetaprodumanos = newProductoOrdenDetaProduManos;
	}
	
	

	public List<OrdenDetaProdu> getordendetaprodusForeignKey() {
		return this.ordendetaprodusForeignKey;
	}

	public List<TipoManoProduEmpresa> gettipomanoproduempresasForeignKey() {
		return this.tipomanoproduempresasForeignKey;
	}

	public List<TipoProcesoEmpresaProdu> gettipoprocesoempresaprodusForeignKey() {
		return this.tipoprocesoempresaprodusForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}
	
	

	public void setordendetaprodusForeignKey(List<OrdenDetaProdu> ordendetaprodusForeignKey) {
		this.ordendetaprodusForeignKey=ordendetaprodusForeignKey;
	}

	public void settipomanoproduempresasForeignKey(List<TipoManoProduEmpresa> tipomanoproduempresasForeignKey) {
		this.tipomanoproduempresasForeignKey=tipomanoproduempresasForeignKey;
	}

	public void settipoprocesoempresaprodusForeignKey(List<TipoProcesoEmpresaProdu> tipoprocesoempresaprodusForeignKey) {
		this.tipoprocesoempresaprodusForeignKey=tipoprocesoempresaprodusForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

