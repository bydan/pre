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
import com.bydan.erp.puntoventa.util.FacturaPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//FacturaPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FacturaPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturaPuntoVenta facturapuntoventa;	
	protected List<FacturaPuntoVenta> facturapuntoventas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Caja> cajasForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<Mesa> mesasForeignKey;
	public List<Formato> formatosForeignKey;
	public List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey;
	public List<EstadoFacturaPuntoVenta> estadofacturapuntoventasForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	
	public FacturaPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.facturapuntoventas= new ArrayList<FacturaPuntoVenta>();
		this.facturapuntoventa= new FacturaPuntoVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.mesasForeignKey=new ArrayList<Mesa>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.tipofacturapuntoventasForeignKey=new ArrayList<TipoFacturaPuntoVenta>();
		this.estadofacturapuntoventasForeignKey=new ArrayList<EstadoFacturaPuntoVenta>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
	} 
	
	public FacturaPuntoVenta getFacturaPuntoVenta() throws Exception {	
		return facturapuntoventa;
	}
		
	public void setFacturaPuntoVenta(FacturaPuntoVenta newFacturaPuntoVenta) {
		this.facturapuntoventa = newFacturaPuntoVenta;
	}
	
	public List<FacturaPuntoVenta> getFacturaPuntoVentas() throws Exception {		
		return facturapuntoventas;
	}
	
	public void setFacturaPuntoVentas(List<FacturaPuntoVenta> newFacturaPuntoVentas) {
		this.facturapuntoventas = newFacturaPuntoVentas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<Mesa> getmesasForeignKey() {
		return this.mesasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<TipoFacturaPuntoVenta> gettipofacturapuntoventasForeignKey() {
		return this.tipofacturapuntoventasForeignKey;
	}

	public List<EstadoFacturaPuntoVenta> getestadofacturapuntoventasForeignKey() {
		return this.estadofacturapuntoventasForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void setmesasForeignKey(List<Mesa> mesasForeignKey) {
		this.mesasForeignKey=mesasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void settipofacturapuntoventasForeignKey(List<TipoFacturaPuntoVenta> tipofacturapuntoventasForeignKey) {
		this.tipofacturapuntoventasForeignKey=tipofacturapuntoventasForeignKey;
	}

	public void setestadofacturapuntoventasForeignKey(List<EstadoFacturaPuntoVenta> estadofacturapuntoventasForeignKey) {
		this.estadofacturapuntoventasForeignKey=estadofacturapuntoventasForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}
}

