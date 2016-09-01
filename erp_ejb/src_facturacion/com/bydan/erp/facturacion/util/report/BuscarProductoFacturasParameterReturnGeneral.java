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
package com.bydan.erp.facturacion.util.report;

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
import com.bydan.erp.facturacion.util.report.BuscarProductoFacturasConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//BuscarProductoFacturas


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class BuscarProductoFacturasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected BuscarProductoFacturas buscarproductofacturas;	
	protected List<BuscarProductoFacturas> buscarproductofacturass;
	
	
	public List<Producto> productosForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public BuscarProductoFacturasParameterReturnGeneral () throws Exception {						
		super();
		this.buscarproductofacturass= new ArrayList<BuscarProductoFacturas>();
		this.buscarproductofacturas= new BuscarProductoFacturas();
		
		
		this.productosForeignKey=new ArrayList<Producto>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public BuscarProductoFacturas getBuscarProductoFacturas() throws Exception {	
		return buscarproductofacturas;
	}
		
	public void setBuscarProductoFacturas(BuscarProductoFacturas newBuscarProductoFacturas) {
		this.buscarproductofacturas = newBuscarProductoFacturas;
	}
	
	public List<BuscarProductoFacturas> getBuscarProductoFacturass() throws Exception {		
		return buscarproductofacturass;
	}
	
	public void setBuscarProductoFacturass(List<BuscarProductoFacturas> newBuscarProductoFacturass) {
		this.buscarproductofacturass = newBuscarProductoFacturass;
	}
	
	

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

