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
import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ProductoOrdenDetaProduGasto


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductoOrdenDetaProduGastoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductoOrdenDetaProduGasto productoordendetaprodugasto;	
	protected List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos;
	
	
	public List<OrdenDetaProdu> ordendetaprodusForeignKey;
	public List<TipoGastoProduEmpresa> tipogastoproduempresasForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	public List<Cliente> clienteproveedorsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ProductoOrdenDetaProduGastoParameterReturnGeneral () throws Exception {						
		super();
		this.productoordendetaprodugastos= new ArrayList<ProductoOrdenDetaProduGasto>();
		this.productoordendetaprodugasto= new ProductoOrdenDetaProduGasto();
		
		
		this.ordendetaprodusForeignKey=new ArrayList<OrdenDetaProdu>();
		this.tipogastoproduempresasForeignKey=new ArrayList<TipoGastoProduEmpresa>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
		this.clienteproveedorsForeignKey=new ArrayList<Cliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ProductoOrdenDetaProduGasto getProductoOrdenDetaProduGasto() throws Exception {	
		return productoordendetaprodugasto;
	}
		
	public void setProductoOrdenDetaProduGasto(ProductoOrdenDetaProduGasto newProductoOrdenDetaProduGasto) {
		this.productoordendetaprodugasto = newProductoOrdenDetaProduGasto;
	}
	
	public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastos() throws Exception {		
		return productoordendetaprodugastos;
	}
	
	public void setProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> newProductoOrdenDetaProduGastos) {
		this.productoordendetaprodugastos = newProductoOrdenDetaProduGastos;
	}
	
	

	public List<OrdenDetaProdu> getordendetaprodusForeignKey() {
		return this.ordendetaprodusForeignKey;
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
	
	

	public void setordendetaprodusForeignKey(List<OrdenDetaProdu> ordendetaprodusForeignKey) {
		this.ordendetaprodusForeignKey=ordendetaprodusForeignKey;
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

