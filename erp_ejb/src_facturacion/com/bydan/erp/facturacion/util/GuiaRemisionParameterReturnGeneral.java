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
import com.bydan.erp.facturacion.util.GuiaRemisionConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//GuiaRemision


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class GuiaRemisionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GuiaRemision guiaremision;	
	protected List<GuiaRemision> guiaremisions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Transportista> transportistasForeignKey;
	public List<Consultor> consultorsForeignKey;
	public List<Transporte> transportesForeignKey;
	public List<SubCliente> subclientesForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Ciudad> ciudadorigensForeignKey;
	public List<Ciudad> ciudaddestinosForeignKey;
	public List<TipoLlamada> tipollamadasForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	
	public GuiaRemisionParameterReturnGeneral () throws Exception {						
		super();
		this.guiaremisions= new ArrayList<GuiaRemision>();
		this.guiaremision= new GuiaRemision();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.transportistasForeignKey=new ArrayList<Transportista>();
		this.consultorsForeignKey=new ArrayList<Consultor>();
		this.transportesForeignKey=new ArrayList<Transporte>();
		this.subclientesForeignKey=new ArrayList<SubCliente>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.ciudadorigensForeignKey=new ArrayList<Ciudad>();
		this.ciudaddestinosForeignKey=new ArrayList<Ciudad>();
		this.tipollamadasForeignKey=new ArrayList<TipoLlamada>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
	} 
	
	public GuiaRemision getGuiaRemision() throws Exception {	
		return guiaremision;
	}
		
	public void setGuiaRemision(GuiaRemision newGuiaRemision) {
		this.guiaremision = newGuiaRemision;
	}
	
	public List<GuiaRemision> getGuiaRemisions() throws Exception {		
		return guiaremisions;
	}
	
	public void setGuiaRemisions(List<GuiaRemision> newGuiaRemisions) {
		this.guiaremisions = newGuiaRemisions;
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

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<Transportista> gettransportistasForeignKey() {
		return this.transportistasForeignKey;
	}

	public List<Consultor> getconsultorsForeignKey() {
		return this.consultorsForeignKey;
	}

	public List<Transporte> gettransportesForeignKey() {
		return this.transportesForeignKey;
	}

	public List<SubCliente> getsubclientesForeignKey() {
		return this.subclientesForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Ciudad> getciudadorigensForeignKey() {
		return this.ciudadorigensForeignKey;
	}

	public List<Ciudad> getciudaddestinosForeignKey() {
		return this.ciudaddestinosForeignKey;
	}

	public List<TipoLlamada> gettipollamadasForeignKey() {
		return this.tipollamadasForeignKey;
	}

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
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

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void settransportistasForeignKey(List<Transportista> transportistasForeignKey) {
		this.transportistasForeignKey=transportistasForeignKey;
	}

	public void setconsultorsForeignKey(List<Consultor> consultorsForeignKey) {
		this.consultorsForeignKey=consultorsForeignKey;
	}

	public void settransportesForeignKey(List<Transporte> transportesForeignKey) {
		this.transportesForeignKey=transportesForeignKey;
	}

	public void setsubclientesForeignKey(List<SubCliente> subclientesForeignKey) {
		this.subclientesForeignKey=subclientesForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setciudadorigensForeignKey(List<Ciudad> ciudadorigensForeignKey) {
		this.ciudadorigensForeignKey=ciudadorigensForeignKey;
	}

	public void setciudaddestinosForeignKey(List<Ciudad> ciudaddestinosForeignKey) {
		this.ciudaddestinosForeignKey=ciudaddestinosForeignKey;
	}

	public void settipollamadasForeignKey(List<TipoLlamada> tipollamadasForeignKey) {
		this.tipollamadasForeignKey=tipollamadasForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}
}

