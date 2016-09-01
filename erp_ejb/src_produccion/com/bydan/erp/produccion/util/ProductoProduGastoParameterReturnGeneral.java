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
import com.bydan.erp.produccion.util.ProductoProduGastoConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoProduGasto


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoProduGastoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoProduGasto productoprodugasto;	
	protected List<ProductoProduGasto> productoprodugastos;
	
	
	public List<ProductoDefiProdu> productodefiprodusForeignKey;
	public List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	public List<Cliente> clienteproveedorsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoProduGastoParameterReturnGeneral () throws Exception {						
		super();
		this.productoprodugastos= new ArrayList<ProductoProduGasto>();
		this.productoprodugasto= new ProductoProduGasto();
		
		
		this.productodefiprodusForeignKey=new ArrayList<ProductoDefiProdu>();
		this.tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
		this.clienteproveedorsForeignKey=new ArrayList<Cliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoProduGasto getProductoProduGasto() throws Exception {	
		return productoprodugasto;
	}
		
	public void setProductoProduGasto(ProductoProduGasto newProductoProduGasto) {
		this.productoprodugasto = newProductoProduGasto;
	}
	
	public List<ProductoProduGasto> getProductoProduGastos() throws Exception {		
		return productoprodugastos;
	}
	
	public void setProductoProduGastos(List<ProductoProduGasto> newProductoProduGastos) {
		this.productoprodugastos = newProductoProduGastos;
	}
	
	

	public List<ProductoDefiProdu> getproductodefiprodusForeignKey() {
		return this.productodefiprodusForeignKey;
	}

	public List<TipoGastoProduEmpresa> gettipogastoproduempresasForeignKey() {
		return this.tipogastoproduempresasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}

	public List<Cliente> getclienteproveedorsForeignKey() {
		return this.clienteproveedorsForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}
	
	

	public void setproductodefiprodusForeignKey(List<ProductoDefiProdu> productodefiprodusForeignKey) {
		this.productodefiprodusForeignKey=productodefiprodusForeignKey;
	}

	public void settipogastoproduempresasForeignKey(List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey) {
		this.tipogastoproduempresasForeignKey=tipogastoproduempresasForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}

	public void setclienteproveedorsForeignKey(List<Cliente> clienteproveedorsForeignKey) {
		this.clienteproveedorsForeignKey=clienteproveedorsForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

