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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.PedidoCompraImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//PedidoCompraImpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class PedidoCompraImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PedidoCompraImpor pedidocompraimpor;	
	protected List<PedidoCompraImpor> pedidocompraimpors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Cliente> clienteproveedorsForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<TipoProrrateoImpor> tipoprorrateoimporsForeignKey;
	public List<Embarcador> embarcadorsForeignKey;
	public List<TipoViaTransporte> tipoviatransportesForeignKey;
	public List<Puerto> puertosForeignKey;
	public List<Puerto> puertodestinosForeignKey;
	public List<TipoTerminosImpor> tipoterminosimporsForeignKey;
	public List<EstadoPedidoCompra> estadopedidocomprasForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public PedidoCompraImporParameterReturnGeneral () throws Exception {						
		super();
		this.pedidocompraimpors= new ArrayList<PedidoCompraImpor>();
		this.pedidocompraimpor= new PedidoCompraImpor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.clienteproveedorsForeignKey=new ArrayList<Cliente>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.tipoprorrateoimporsForeignKey=new ArrayList<TipoProrrateoImpor>();
		this.embarcadorsForeignKey=new ArrayList<Embarcador>();
		this.tipoviatransportesForeignKey=new ArrayList<TipoViaTransporte>();
		this.puertosForeignKey=new ArrayList<Puerto>();
		this.puertodestinosForeignKey=new ArrayList<Puerto>();
		this.tipoterminosimporsForeignKey=new ArrayList<TipoTerminosImpor>();
		this.estadopedidocomprasForeignKey=new ArrayList<EstadoPedidoCompra>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public PedidoCompraImpor getPedidoCompraImpor() throws Exception {	
		return pedidocompraimpor;
	}
		
	public void setPedidoCompraImpor(PedidoCompraImpor newPedidoCompraImpor) {
		this.pedidocompraimpor = newPedidoCompraImpor;
	}
	
	public List<PedidoCompraImpor> getPedidoCompraImpors() throws Exception {		
		return pedidocompraimpors;
	}
	
	public void setPedidoCompraImpors(List<PedidoCompraImpor> newPedidoCompraImpors) {
		this.pedidocompraimpors = newPedidoCompraImpors;
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

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Cliente> getclienteproveedorsForeignKey() {
		return this.clienteproveedorsForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<TipoProrrateoImpor> gettipoprorrateoimporsForeignKey() {
		return this.tipoprorrateoimporsForeignKey;
	}

	public List<Embarcador> getembarcadorsForeignKey() {
		return this.embarcadorsForeignKey;
	}

	public List<TipoViaTransporte> gettipoviatransportesForeignKey() {
		return this.tipoviatransportesForeignKey;
	}

	public List<Puerto> getpuertosForeignKey() {
		return this.puertosForeignKey;
	}

	public List<Puerto> getpuertodestinosForeignKey() {
		return this.puertodestinosForeignKey;
	}

	public List<TipoTerminosImpor> gettipoterminosimporsForeignKey() {
		return this.tipoterminosimporsForeignKey;
	}

	public List<EstadoPedidoCompra> getestadopedidocomprasForeignKey() {
		return this.estadopedidocomprasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
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

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setclienteproveedorsForeignKey(List<Cliente> clienteproveedorsForeignKey) {
		this.clienteproveedorsForeignKey=clienteproveedorsForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void settipoprorrateoimporsForeignKey(List<TipoProrrateoImpor> tipoprorrateoimporsForeignKey) {
		this.tipoprorrateoimporsForeignKey=tipoprorrateoimporsForeignKey;
	}

	public void setembarcadorsForeignKey(List<Embarcador> embarcadorsForeignKey) {
		this.embarcadorsForeignKey=embarcadorsForeignKey;
	}

	public void settipoviatransportesForeignKey(List<TipoViaTransporte> tipoviatransportesForeignKey) {
		this.tipoviatransportesForeignKey=tipoviatransportesForeignKey;
	}

	public void setpuertosForeignKey(List<Puerto> puertosForeignKey) {
		this.puertosForeignKey=puertosForeignKey;
	}

	public void setpuertodestinosForeignKey(List<Puerto> puertodestinosForeignKey) {
		this.puertodestinosForeignKey=puertodestinosForeignKey;
	}

	public void settipoterminosimporsForeignKey(List<TipoTerminosImpor> tipoterminosimporsForeignKey) {
		this.tipoterminosimporsForeignKey=tipoterminosimporsForeignKey;
	}

	public void setestadopedidocomprasForeignKey(List<EstadoPedidoCompra> estadopedidocomprasForeignKey) {
		this.estadopedidocomprasForeignKey=estadopedidocomprasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

