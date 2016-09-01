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
import com.bydan.erp.facturacion.util.PedidoExporConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//PedidoExpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class PedidoExporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PedidoExpor pedidoexpor;	
	protected List<PedidoExpor> pedidoexpors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Pais> paissForeignKey;
	public List<Transporte> transportesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<SubCliente> subclientesForeignKey;
	public List<Consignatario> consignatariosForeignKey;
	public List<Consultor> consultorsForeignKey;
	public List<EstadoPedido> estadopedidoexporsForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Responsable> responsablesForeignKey;
	public List<Transportista> transportistasForeignKey;
	
	public PedidoExporParameterReturnGeneral () throws Exception {						
		super();
		this.pedidoexpors= new ArrayList<PedidoExpor>();
		this.pedidoexpor= new PedidoExpor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.transportesForeignKey=new ArrayList<Transporte>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.subclientesForeignKey=new ArrayList<SubCliente>();
		this.consignatariosForeignKey=new ArrayList<Consignatario>();
		this.consultorsForeignKey=new ArrayList<Consultor>();
		this.estadopedidoexporsForeignKey=new ArrayList<EstadoPedido>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.responsablesForeignKey=new ArrayList<Responsable>();
		this.transportistasForeignKey=new ArrayList<Transportista>();
	} 
	
	public PedidoExpor getPedidoExpor() throws Exception {	
		return pedidoexpor;
	}
		
	public void setPedidoExpor(PedidoExpor newPedidoExpor) {
		this.pedidoexpor = newPedidoExpor;
	}
	
	public List<PedidoExpor> getPedidoExpors() throws Exception {		
		return pedidoexpors;
	}
	
	public void setPedidoExpors(List<PedidoExpor> newPedidoExpors) {
		this.pedidoexpors = newPedidoExpors;
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

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Transporte> gettransportesForeignKey() {
		return this.transportesForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<SubCliente> getsubclientesForeignKey() {
		return this.subclientesForeignKey;
	}

	public List<Consignatario> getconsignatariosForeignKey() {
		return this.consignatariosForeignKey;
	}

	public List<Consultor> getconsultorsForeignKey() {
		return this.consultorsForeignKey;
	}

	public List<EstadoPedido> getestadopedidoexporsForeignKey() {
		return this.estadopedidoexporsForeignKey;
	}

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Responsable> getresponsablesForeignKey() {
		return this.responsablesForeignKey;
	}

	public List<Transportista> gettransportistasForeignKey() {
		return this.transportistasForeignKey;
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

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void settransportesForeignKey(List<Transporte> transportesForeignKey) {
		this.transportesForeignKey=transportesForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setsubclientesForeignKey(List<SubCliente> subclientesForeignKey) {
		this.subclientesForeignKey=subclientesForeignKey;
	}

	public void setconsignatariosForeignKey(List<Consignatario> consignatariosForeignKey) {
		this.consignatariosForeignKey=consignatariosForeignKey;
	}

	public void setconsultorsForeignKey(List<Consultor> consultorsForeignKey) {
		this.consultorsForeignKey=consultorsForeignKey;
	}

	public void setestadopedidoexporsForeignKey(List<EstadoPedido> estadopedidoexporsForeignKey) {
		this.estadopedidoexporsForeignKey=estadopedidoexporsForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setresponsablesForeignKey(List<Responsable> responsablesForeignKey) {
		this.responsablesForeignKey=responsablesForeignKey;
	}

	public void settransportistasForeignKey(List<Transportista> transportistasForeignKey) {
		this.transportistasForeignKey=transportistasForeignKey;
	}
}

