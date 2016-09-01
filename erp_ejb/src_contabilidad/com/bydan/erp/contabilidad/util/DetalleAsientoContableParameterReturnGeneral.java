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
import com.bydan.erp.contabilidad.util.DetalleAsientoContableConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DetalleAsientoContable


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleAsientoContableParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleAsientoContable detalleasientocontable;	
	protected List<DetalleAsientoContable> detalleasientocontables;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CentroActividad> centroactividadsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<TipoCambio> tipocambiosForeignKey;
	
	public DetalleAsientoContableParameterReturnGeneral () throws Exception {						
		super();
		this.detalleasientocontables= new ArrayList<DetalleAsientoContable>();
		this.detalleasientocontable= new DetalleAsientoContable();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.centroactividadsForeignKey=new ArrayList<CentroActividad>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
	} 
	
	public DetalleAsientoContable getDetalleAsientoContable() throws Exception {	
		return detalleasientocontable;
	}
		
	public void setDetalleAsientoContable(DetalleAsientoContable newDetalleAsientoContable) {
		this.detalleasientocontable = newDetalleAsientoContable;
	}
	
	public List<DetalleAsientoContable> getDetalleAsientoContables() throws Exception {		
		return detalleasientocontables;
	}
	
	public void setDetalleAsientoContables(List<DetalleAsientoContable> newDetalleAsientoContables) {
		this.detalleasientocontables = newDetalleAsientoContables;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
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

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CentroActividad> getcentroactividadsForeignKey() {
		return this.centroactividadsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
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

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
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

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcentroactividadsForeignKey(List<CentroActividad> centroactividadsForeignKey) {
		this.centroactividadsForeignKey=centroactividadsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}
}

