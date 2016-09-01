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
import com.bydan.erp.puntoventa.util.PedidoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//PedidoPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class PedidoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PedidoPuntoVenta pedidopuntoventa;	
	protected List<PedidoPuntoVenta> pedidopuntoventas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Caja> cajasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<Mesa> mesasForeignKey;
	public List<EstadoPedidoPuntoVenta> estadopedidopuntoventasForeignKey;
	
	public PedidoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.pedidopuntoventas= new ArrayList<PedidoPuntoVenta>();
		this.pedidopuntoventa= new PedidoPuntoVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.mesasForeignKey=new ArrayList<Mesa>();
		this.estadopedidopuntoventasForeignKey=new ArrayList<EstadoPedidoPuntoVenta>();
	} 
	
	public PedidoPuntoVenta getPedidoPuntoVenta() throws Exception {	
		return pedidopuntoventa;
	}
		
	public void setPedidoPuntoVenta(PedidoPuntoVenta newPedidoPuntoVenta) {
		this.pedidopuntoventa = newPedidoPuntoVenta;
	}
	
	public List<PedidoPuntoVenta> getPedidoPuntoVentas() throws Exception {		
		return pedidopuntoventas;
	}
	
	public void setPedidoPuntoVentas(List<PedidoPuntoVenta> newPedidoPuntoVentas) {
		this.pedidopuntoventas = newPedidoPuntoVentas;
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

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<Mesa> getmesasForeignKey() {
		return this.mesasForeignKey;
	}

	public List<EstadoPedidoPuntoVenta> getestadopedidopuntoventasForeignKey() {
		return this.estadopedidopuntoventasForeignKey;
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

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void setmesasForeignKey(List<Mesa> mesasForeignKey) {
		this.mesasForeignKey=mesasForeignKey;
	}

	public void setestadopedidopuntoventasForeignKey(List<EstadoPedidoPuntoVenta> estadopedidopuntoventasForeignKey) {
		this.estadopedidopuntoventasForeignKey=estadopedidopuntoventasForeignKey;
	}
}

