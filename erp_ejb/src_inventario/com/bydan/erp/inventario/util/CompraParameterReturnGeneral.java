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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.CompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Compra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class CompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Compra compra;	
	protected List<Compra> compras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	public List<EstadoInventario> estadoinventariosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Transportista> transportistasForeignKey;
	public List<OrdenCompra> ordencomprasForeignKey;
	public List<PedidoCompra> pedidocomprasForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	
	public CompraParameterReturnGeneral () throws Exception {						
		super();
		this.compras= new ArrayList<Compra>();
		this.compra= new Compra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
		this.estadoinventariosForeignKey=new ArrayList<EstadoInventario>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.transportistasForeignKey=new ArrayList<Transportista>();
		this.ordencomprasForeignKey=new ArrayList<OrdenCompra>();
		this.pedidocomprasForeignKey=new ArrayList<PedidoCompra>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
	} 
	
	public Compra getCompra() throws Exception {	
		return compra;
	}
		
	public void setCompra(Compra newCompra) {
		this.compra = newCompra;
	}
	
	public List<Compra> getCompras() throws Exception {		
		return compras;
	}
	
	public void setCompras(List<Compra> newCompras) {
		this.compras = newCompras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
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

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
	}

	public List<EstadoInventario> getestadoinventariosForeignKey() {
		return this.estadoinventariosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Transportista> gettransportistasForeignKey() {
		return this.transportistasForeignKey;
	}

	public List<OrdenCompra> getordencomprasForeignKey() {
		return this.ordencomprasForeignKey;
	}

	public List<PedidoCompra> getpedidocomprasForeignKey() {
		return this.pedidocomprasForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
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

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
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

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}

	public void setestadoinventariosForeignKey(List<EstadoInventario> estadoinventariosForeignKey) {
		this.estadoinventariosForeignKey=estadoinventariosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settransportistasForeignKey(List<Transportista> transportistasForeignKey) {
		this.transportistasForeignKey=transportistasForeignKey;
	}

	public void setordencomprasForeignKey(List<OrdenCompra> ordencomprasForeignKey) {
		this.ordencomprasForeignKey=ordencomprasForeignKey;
	}

	public void setpedidocomprasForeignKey(List<PedidoCompra> pedidocomprasForeignKey) {
		this.pedidocomprasForeignKey=pedidocomprasForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}
}

