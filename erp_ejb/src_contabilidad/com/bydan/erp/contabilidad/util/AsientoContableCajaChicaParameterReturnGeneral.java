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
import com.bydan.erp.contabilidad.util.AsientoContableCajaChicaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//AsientoContableCajaChica


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class AsientoContableCajaChicaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AsientoContableCajaChica asientocontablecajachica;	
	protected List<AsientoContableCajaChica> asientocontablecajachicas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<TipoMovimientoModulo> tipomovimientomodulosForeignKey;
	
	public AsientoContableCajaChicaParameterReturnGeneral () throws Exception {						
		super();
		this.asientocontablecajachicas= new ArrayList<AsientoContableCajaChica>();
		this.asientocontablecajachica= new AsientoContableCajaChica();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estadoasientocontablecajachicasForeignKey=new ArrayList<EstadoAsientoContableCajaChica>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
	} 
	
	public AsientoContableCajaChica getAsientoContableCajaChica() throws Exception {	
		return asientocontablecajachica;
	}
		
	public void setAsientoContableCajaChica(AsientoContableCajaChica newAsientoContableCajaChica) {
		this.asientocontablecajachica = newAsientoContableCajaChica;
	}
	
	public List<AsientoContableCajaChica> getAsientoContableCajaChicas() throws Exception {		
		return asientocontablecajachicas;
	}
	
	public void setAsientoContableCajaChicas(List<AsientoContableCajaChica> newAsientoContableCajaChicas) {
		this.asientocontablecajachicas = newAsientoContableCajaChicas;
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

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<EstadoAsientoContableCajaChica> getestadoasientocontablecajachicasForeignKey() {
		return this.estadoasientocontablecajachicasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<TipoMovimientoModulo> gettipomovimientomodulosForeignKey() {
		return this.tipomovimientomodulosForeignKey;
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

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestadoasientocontablecajachicasForeignKey(List<EstadoAsientoContableCajaChica> estadoasientocontablecajachicasForeignKey) {
		this.estadoasientocontablecajachicasForeignKey=estadoasientocontablecajachicasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void settipomovimientomodulosForeignKey(List<TipoMovimientoModulo> tipomovimientomodulosForeignKey) {
		this.tipomovimientomodulosForeignKey=tipomovimientomodulosForeignKey;
	}
}

