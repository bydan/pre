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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.DetalleConsignacionConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetalleConsignacion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetalleConsignacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleConsignacion detalleconsignacion;	
	protected List<DetalleConsignacion> detalleconsignacions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Consignacion> consignacionsForeignKey;
	public List<Producto> productosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<EstadoDetallePedido> estadodetallepedidosForeignKey;
	
	public DetalleConsignacionParameterReturnGeneral () throws Exception {						
		super();
		this.detalleconsignacions= new ArrayList<DetalleConsignacion>();
		this.detalleconsignacion= new DetalleConsignacion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.consignacionsForeignKey=new ArrayList<Consignacion>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.estadodetallepedidosForeignKey=new ArrayList<EstadoDetallePedido>();
	} 
	
	public DetalleConsignacion getDetalleConsignacion() throws Exception {	
		return detalleconsignacion;
	}
		
	public void setDetalleConsignacion(DetalleConsignacion newDetalleConsignacion) {
		this.detalleconsignacion = newDetalleConsignacion;
	}
	
	public List<DetalleConsignacion> getDetalleConsignacions() throws Exception {		
		return detalleconsignacions;
	}
	
	public void setDetalleConsignacions(List<DetalleConsignacion> newDetalleConsignacions) {
		this.detalleconsignacions = newDetalleConsignacions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Consignacion> getconsignacionsForeignKey() {
		return this.consignacionsForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<EstadoDetallePedido> getestadodetallepedidosForeignKey() {
		return this.estadodetallepedidosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setconsignacionsForeignKey(List<Consignacion> consignacionsForeignKey) {
		this.consignacionsForeignKey=consignacionsForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setestadodetallepedidosForeignKey(List<EstadoDetallePedido> estadodetallepedidosForeignKey) {
		this.estadodetallepedidosForeignKey=estadodetallepedidosForeignKey;
	}
}

