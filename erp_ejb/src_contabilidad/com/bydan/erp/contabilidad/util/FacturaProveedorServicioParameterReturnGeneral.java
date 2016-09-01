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
import com.bydan.erp.contabilidad.util.FacturaProveedorServicioConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//FacturaProveedorServicio


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class FacturaProveedorServicioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturaProveedorServicio facturaproveedorservicio;	
	protected List<FacturaProveedorServicio> facturaproveedorservicios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<Empleado> empleadosolicitasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<TipoRetencion> tiporetencionfuente1sForeignKey;
	public List<TipoRetencion> tiporetencioniva1sForeignKey;
	public List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoMovimientoModulo> tipomovimientomodulosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	
	public FacturaProveedorServicioParameterReturnGeneral () throws Exception {						
		super();
		this.facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();
		this.facturaproveedorservicio= new FacturaProveedorServicio();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.empleadosolicitasForeignKey=new ArrayList<Empleado>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
		this.cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
	} 
	
	public FacturaProveedorServicio getFacturaProveedorServicio() throws Exception {	
		return facturaproveedorservicio;
	}
		
	public void setFacturaProveedorServicio(FacturaProveedorServicio newFacturaProveedorServicio) {
		this.facturaproveedorservicio = newFacturaProveedorServicio;
	}
	
	public List<FacturaProveedorServicio> getFacturaProveedorServicios() throws Exception {		
		return facturaproveedorservicios;
	}
	
	public void setFacturaProveedorServicios(List<FacturaProveedorServicio> newFacturaProveedorServicios) {
		this.facturaproveedorservicios = newFacturaProveedorServicios;
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

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<Empleado> getempleadosolicitasForeignKey() {
		return this.empleadosolicitasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoTributario> gettipotributariosForeignKey() {
		return this.tipotributariosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuente1sForeignKey() {
		return this.tiporetencionfuente1sForeignKey;
	}

	public List<TipoRetencion> gettiporetencioniva1sForeignKey() {
		return this.tiporetencioniva1sForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofiscalserviciossForeignKey() {
		return this.cuentacontablecreditofiscalserviciossForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<TipoMovimientoModulo> gettipomovimientomodulosForeignKey() {
		return this.tipomovimientomodulosForeignKey;
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

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void setempleadosolicitasForeignKey(List<Empleado> empleadosolicitasForeignKey) {
		this.empleadosolicitasForeignKey=empleadosolicitasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settipotributariosForeignKey(List<TipoTributario> tipotributariosForeignKey) {
		this.tipotributariosForeignKey=tipotributariosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void settiporetencionfuente1sForeignKey(List<TipoRetencion> tiporetencionfuente1sForeignKey) {
		this.tiporetencionfuente1sForeignKey=tiporetencionfuente1sForeignKey;
	}

	public void settiporetencioniva1sForeignKey(List<TipoRetencion> tiporetencioniva1sForeignKey) {
		this.tiporetencioniva1sForeignKey=tiporetencioniva1sForeignKey;
	}

	public void setcuentacontablecreditofiscalserviciossForeignKey(List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey) {
		this.cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciossForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void settipomovimientomodulosForeignKey(List<TipoMovimientoModulo> tipomovimientomodulosForeignKey) {
		this.tipomovimientomodulosForeignKey=tipomovimientomodulosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}
}

