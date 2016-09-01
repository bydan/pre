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
import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//FormaPagoPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class FormaPagoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormaPagoPuntoVenta formapagopuntoventa;	
	protected List<FormaPagoPuntoVenta> formapagopuntoventas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<FacturaPuntoVenta> facturapuntoventasForeignKey;
	public List<TipoFormaPago> tipoformapagosForeignKey;
	public List<Banco> bancosForeignKey;
	public List<CuentaBancoPunVen> cuentabancopunvensForeignKey;
	public List<TipoRiesgoCheque> tiporiesgochequesForeignKey;
	public List<Banco> bancotarjetasForeignKey;
	public List<TarjetaCredito> tarjetacreditosForeignKey;
	public List<TipoInteresTarjeta> tipointerestarjetasForeignKey;
	public List<TipoPagoTarjeta> tipopagotarjetasForeignKey;
	public List<Conexion> conexionsForeignKey;
	public List<Mes> messForeignKey;
	public List<Anio> aniosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	
	public FormaPagoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();
		this.formapagopuntoventa= new FormaPagoPuntoVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
		this.tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.cuentabancopunvensForeignKey=new ArrayList<CuentaBancoPunVen>();
		this.tiporiesgochequesForeignKey=new ArrayList<TipoRiesgoCheque>();
		this.bancotarjetasForeignKey=new ArrayList<Banco>();
		this.tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
		this.tipointerestarjetasForeignKey=new ArrayList<TipoInteresTarjeta>();
		this.tipopagotarjetasForeignKey=new ArrayList<TipoPagoTarjeta>();
		this.conexionsForeignKey=new ArrayList<Conexion>();
		this.messForeignKey=new ArrayList<Mes>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
	} 
	
	public FormaPagoPuntoVenta getFormaPagoPuntoVenta() throws Exception {	
		return formapagopuntoventa;
	}
		
	public void setFormaPagoPuntoVenta(FormaPagoPuntoVenta newFormaPagoPuntoVenta) {
		this.formapagopuntoventa = newFormaPagoPuntoVenta;
	}
	
	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() throws Exception {		
		return formapagopuntoventas;
	}
	
	public void setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> newFormaPagoPuntoVentas) {
		this.formapagopuntoventas = newFormaPagoPuntoVentas;
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

	public List<FacturaPuntoVenta> getfacturapuntoventasForeignKey() {
		return this.facturapuntoventasForeignKey;
	}

	public List<TipoFormaPago> gettipoformapagosForeignKey() {
		return this.tipoformapagosForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<CuentaBancoPunVen> getcuentabancopunvensForeignKey() {
		return this.cuentabancopunvensForeignKey;
	}

	public List<TipoRiesgoCheque> gettiporiesgochequesForeignKey() {
		return this.tiporiesgochequesForeignKey;
	}

	public List<Banco> getbancotarjetasForeignKey() {
		return this.bancotarjetasForeignKey;
	}

	public List<TarjetaCredito> gettarjetacreditosForeignKey() {
		return this.tarjetacreditosForeignKey;
	}

	public List<TipoInteresTarjeta> gettipointerestarjetasForeignKey() {
		return this.tipointerestarjetasForeignKey;
	}

	public List<TipoPagoTarjeta> gettipopagotarjetasForeignKey() {
		return this.tipopagotarjetasForeignKey;
	}

	public List<Conexion> getconexionsForeignKey() {
		return this.conexionsForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
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

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setfacturapuntoventasForeignKey(List<FacturaPuntoVenta> facturapuntoventasForeignKey) {
		this.facturapuntoventasForeignKey=facturapuntoventasForeignKey;
	}

	public void settipoformapagosForeignKey(List<TipoFormaPago> tipoformapagosForeignKey) {
		this.tipoformapagosForeignKey=tipoformapagosForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void setcuentabancopunvensForeignKey(List<CuentaBancoPunVen> cuentabancopunvensForeignKey) {
		this.cuentabancopunvensForeignKey=cuentabancopunvensForeignKey;
	}

	public void settiporiesgochequesForeignKey(List<TipoRiesgoCheque> tiporiesgochequesForeignKey) {
		this.tiporiesgochequesForeignKey=tiporiesgochequesForeignKey;
	}

	public void setbancotarjetasForeignKey(List<Banco> bancotarjetasForeignKey) {
		this.bancotarjetasForeignKey=bancotarjetasForeignKey;
	}

	public void settarjetacreditosForeignKey(List<TarjetaCredito> tarjetacreditosForeignKey) {
		this.tarjetacreditosForeignKey=tarjetacreditosForeignKey;
	}

	public void settipointerestarjetasForeignKey(List<TipoInteresTarjeta> tipointerestarjetasForeignKey) {
		this.tipointerestarjetasForeignKey=tipointerestarjetasForeignKey;
	}

	public void settipopagotarjetasForeignKey(List<TipoPagoTarjeta> tipopagotarjetasForeignKey) {
		this.tipopagotarjetasForeignKey=tipopagotarjetasForeignKey;
	}

	public void setconexionsForeignKey(List<Conexion> conexionsForeignKey) {
		this.conexionsForeignKey=conexionsForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}
}

