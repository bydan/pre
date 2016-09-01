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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//AutoriPagoOrdenCompra


import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class AutoriPagoOrdenCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AutoriPagoOrdenCompra autoripagoordencompra;	
	protected List<AutoriPagoOrdenCompra> autoripagoordencompras;
	
	
	public List<TipoCambio> tipocambiosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<OrdenCompra> ordencomprasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<Banco> bancosForeignKey;
	public List<CuentaBanco> cuentabancosForeignKey;
	
	public AutoriPagoOrdenCompraParameterReturnGeneral () throws Exception {						
		super();
		this.autoripagoordencompras= new ArrayList<AutoriPagoOrdenCompra>();
		this.autoripagoordencompra= new AutoriPagoOrdenCompra();
		
		
		this.tipocambiosForeignKey=new ArrayList<TipoCambio>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ordencomprasForeignKey=new ArrayList<OrdenCompra>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.cuentabancosForeignKey=new ArrayList<CuentaBanco>();
	} 
	
	public AutoriPagoOrdenCompra getAutoriPagoOrdenCompra() throws Exception {	
		return autoripagoordencompra;
	}
		
	public void setAutoriPagoOrdenCompra(AutoriPagoOrdenCompra newAutoriPagoOrdenCompra) {
		this.autoripagoordencompra = newAutoriPagoOrdenCompra;
	}
	
	public List<AutoriPagoOrdenCompra> getAutoriPagoOrdenCompras() throws Exception {		
		return autoripagoordencompras;
	}
	
	public void setAutoriPagoOrdenCompras(List<AutoriPagoOrdenCompra> newAutoriPagoOrdenCompras) {
		this.autoripagoordencompras = newAutoriPagoOrdenCompras;
	}
	
	

	public List<TipoCambio> gettipocambiosForeignKey() {
		return this.tipocambiosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<OrdenCompra> getordencomprasForeignKey() {
		return this.ordencomprasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<CuentaBanco> getcuentabancosForeignKey() {
		return this.cuentabancosForeignKey;
	}
	
	

	public void settipocambiosForeignKey(List<TipoCambio> tipocambiosForeignKey) {
		this.tipocambiosForeignKey=tipocambiosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setordencomprasForeignKey(List<OrdenCompra> ordencomprasForeignKey) {
		this.ordencomprasForeignKey=ordencomprasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void setcuentabancosForeignKey(List<CuentaBanco> cuentabancosForeignKey) {
		this.cuentabancosForeignKey=cuentabancosForeignKey;
	}
}

