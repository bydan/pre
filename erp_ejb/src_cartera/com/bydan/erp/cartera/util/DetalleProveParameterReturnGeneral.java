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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.DetalleProveConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//DetalleProve


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetalleProveParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleProve detalleprove;	
	protected List<DetalleProve> detalleproves;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Sucursal> sucursalmovimientosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<Factura> facturasForeignKey;
	public List<OrdenCompra> ordencomprasForeignKey;
	public List<EstadoDetalleCliente> estadodetalleclientesForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public DetalleProveParameterReturnGeneral () throws Exception {						
		super();
		this.detalleproves= new ArrayList<DetalleProve>();
		this.detalleprove= new DetalleProve();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.ordencomprasForeignKey=new ArrayList<OrdenCompra>();
		this.estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public DetalleProve getDetalleProve() throws Exception {	
		return detalleprove;
	}
		
	public void setDetalleProve(DetalleProve newDetalleProve) {
		this.detalleprove = newDetalleProve;
	}
	
	public List<DetalleProve> getDetalleProves() throws Exception {		
		return detalleproves;
	}
	
	public void setDetalleProves(List<DetalleProve> newDetalleProves) {
		this.detalleproves = newDetalleProves;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Sucursal> getsucursalmovimientosForeignKey() {
		return this.sucursalmovimientosForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<OrdenCompra> getordencomprasForeignKey() {
		return this.ordencomprasForeignKey;
	}

	public List<EstadoDetalleCliente> getestadodetalleclientesForeignKey() {
		return this.estadodetalleclientesForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setsucursalmovimientosForeignKey(List<Sucursal> sucursalmovimientosForeignKey) {
		this.sucursalmovimientosForeignKey=sucursalmovimientosForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setordencomprasForeignKey(List<OrdenCompra> ordencomprasForeignKey) {
		this.ordencomprasForeignKey=ordencomprasForeignKey;
	}

	public void setestadodetalleclientesForeignKey(List<EstadoDetalleCliente> estadodetalleclientesForeignKey) {
		this.estadodetalleclientesForeignKey=estadodetalleclientesForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

