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
import com.bydan.erp.puntoventa.util.DetallePedidoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//DetallePedidoPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetallePedidoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetallePedidoPuntoVenta detallepedidopuntoventa;	
	protected List<DetallePedidoPuntoVenta> detallepedidopuntoventas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<PedidoPuntoVenta> pedidopuntoventasForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public DetallePedidoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.detallepedidopuntoventas= new ArrayList<DetallePedidoPuntoVenta>();
		this.detallepedidopuntoventa= new DetallePedidoPuntoVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.pedidopuntoventasForeignKey=new ArrayList<PedidoPuntoVenta>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public DetallePedidoPuntoVenta getDetallePedidoPuntoVenta() throws Exception {	
		return detallepedidopuntoventa;
	}
		
	public void setDetallePedidoPuntoVenta(DetallePedidoPuntoVenta newDetallePedidoPuntoVenta) {
		this.detallepedidopuntoventa = newDetallePedidoPuntoVenta;
	}
	
	public List<DetallePedidoPuntoVenta> getDetallePedidoPuntoVentas() throws Exception {		
		return detallepedidopuntoventas;
	}
	
	public void setDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> newDetallePedidoPuntoVentas) {
		this.detallepedidopuntoventas = newDetallePedidoPuntoVentas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<PedidoPuntoVenta> getpedidopuntoventasForeignKey() {
		return this.pedidopuntoventasForeignKey;
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
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setpedidopuntoventasForeignKey(List<PedidoPuntoVenta> pedidopuntoventasForeignKey) {
		this.pedidopuntoventasForeignKey=pedidopuntoventasForeignKey;
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

