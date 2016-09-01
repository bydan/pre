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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DetalleAsientoContableCajaChica


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class DetalleAsientoContableCajaChicaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleAsientoContableCajaChica detalleasientocontablecajachica;	
	protected List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<AsientoContableCajaChica> asientocontablecajachicasForeignKey;
	public List<TipoGastoEmpresa> tipogastoempresasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	
	public DetalleAsientoContableCajaChicaParameterReturnGeneral () throws Exception {						
		super();
		this.detalleasientocontablecajachicas= new ArrayList<DetalleAsientoContableCajaChica>();
		this.detalleasientocontablecajachica= new DetalleAsientoContableCajaChica();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.asientocontablecajachicasForeignKey=new ArrayList<AsientoContableCajaChica>();
		this.tipogastoempresasForeignKey=new ArrayList<TipoGastoEmpresa>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
	} 
	
	public DetalleAsientoContableCajaChica getDetalleAsientoContableCajaChica() throws Exception {	
		return detalleasientocontablecajachica;
	}
		
	public void setDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica newDetalleAsientoContableCajaChica) {
		this.detalleasientocontablecajachica = newDetalleAsientoContableCajaChica;
	}
	
	public List<DetalleAsientoContableCajaChica> getDetalleAsientoContableCajaChicas() throws Exception {		
		return detalleasientocontablecajachicas;
	}
	
	public void setDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> newDetalleAsientoContableCajaChicas) {
		this.detalleasientocontablecajachicas = newDetalleAsientoContableCajaChicas;
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

	public List<AsientoContableCajaChica> getasientocontablecajachicasForeignKey() {
		return this.asientocontablecajachicasForeignKey;
	}

	public List<TipoGastoEmpresa> gettipogastoempresasForeignKey() {
		return this.tipogastoempresasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
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

	public void setasientocontablecajachicasForeignKey(List<AsientoContableCajaChica> asientocontablecajachicasForeignKey) {
		this.asientocontablecajachicasForeignKey=asientocontablecajachicasForeignKey;
	}

	public void settipogastoempresasForeignKey(List<TipoGastoEmpresa> tipogastoempresasForeignKey) {
		this.tipogastoempresasForeignKey=tipogastoempresasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}
}

