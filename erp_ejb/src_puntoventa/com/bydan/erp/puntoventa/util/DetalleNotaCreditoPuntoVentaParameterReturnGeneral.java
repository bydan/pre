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
import com.bydan.erp.puntoventa.util.DetalleNotaCreditoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//DetalleNotaCreditoPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetalleNotaCreditoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleNotaCreditoPuntoVenta detallenotacreditopuntoventa;	
	protected List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas;
	
	
	public List<NotaCreditoPuntoVenta> notacreditopuntoventasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public DetalleNotaCreditoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.detallenotacreditopuntoventas= new ArrayList<DetalleNotaCreditoPuntoVenta>();
		this.detallenotacreditopuntoventa= new DetalleNotaCreditoPuntoVenta();
		
		
		this.notacreditopuntoventasForeignKey=new ArrayList<NotaCreditoPuntoVenta>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public DetalleNotaCreditoPuntoVenta getDetalleNotaCreditoPuntoVenta() throws Exception {	
		return detallenotacreditopuntoventa;
	}
		
	public void setDetalleNotaCreditoPuntoVenta(DetalleNotaCreditoPuntoVenta newDetalleNotaCreditoPuntoVenta) {
		this.detallenotacreditopuntoventa = newDetalleNotaCreditoPuntoVenta;
	}
	
	public List<DetalleNotaCreditoPuntoVenta> getDetalleNotaCreditoPuntoVentas() throws Exception {		
		return detallenotacreditopuntoventas;
	}
	
	public void setDetalleNotaCreditoPuntoVentas(List<DetalleNotaCreditoPuntoVenta> newDetalleNotaCreditoPuntoVentas) {
		this.detallenotacreditopuntoventas = newDetalleNotaCreditoPuntoVentas;
	}
	
	

	public List<NotaCreditoPuntoVenta> getnotacreditopuntoventasForeignKey() {
		return this.notacreditopuntoventasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
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
	
	

	public void setnotacreditopuntoventasForeignKey(List<NotaCreditoPuntoVenta> notacreditopuntoventasForeignKey) {
		this.notacreditopuntoventasForeignKey=notacreditopuntoventasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
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

