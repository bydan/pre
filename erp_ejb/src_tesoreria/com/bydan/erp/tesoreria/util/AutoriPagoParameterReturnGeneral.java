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
import com.bydan.erp.tesoreria.util.AutoriPagoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//AutoriPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class AutoriPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AutoriPago autoripago;	
	protected List<AutoriPago> autoripagos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Factura> facturasForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CentroActividad> centroactividadsForeignKey;
	public List<Banco> bancosForeignKey;
	public List<CuentaBanco> cuentabancosForeignKey;
	public List<DetalleProve> detalleprovesForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	
	public AutoriPagoParameterReturnGeneral () throws Exception {						
		super();
		this.autoripagos= new ArrayList<AutoriPago>();
		this.autoripago= new AutoriPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.centroactividadsForeignKey=new ArrayList<CentroActividad>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.cuentabancosForeignKey=new ArrayList<CuentaBanco>();
		this.detalleprovesForeignKey=new ArrayList<DetalleProve>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
	} 
	
	public AutoriPago getAutoriPago() throws Exception {	
		return autoripago;
	}
		
	public void setAutoriPago(AutoriPago newAutoriPago) {
		this.autoripago = newAutoriPago;
	}
	
	public List<AutoriPago> getAutoriPagos() throws Exception {		
		return autoripagos;
	}
	
	public void setAutoriPagos(List<AutoriPago> newAutoriPagos) {
		this.autoripagos = newAutoriPagos;
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

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
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

	public List<CentroActividad> getcentroactividadsForeignKey() {
		return this.centroactividadsForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<CuentaBanco> getcuentabancosForeignKey() {
		return this.cuentabancosForeignKey;
	}

	public List<DetalleProve> getdetalleprovesForeignKey() {
		return this.detalleprovesForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
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

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
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

	public void setcentroactividadsForeignKey(List<CentroActividad> centroactividadsForeignKey) {
		this.centroactividadsForeignKey=centroactividadsForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void setcuentabancosForeignKey(List<CuentaBanco> cuentabancosForeignKey) {
		this.cuentabancosForeignKey=cuentabancosForeignKey;
	}

	public void setdetalleprovesForeignKey(List<DetalleProve> detalleprovesForeignKey) {
		this.detalleprovesForeignKey=detalleprovesForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}
}

