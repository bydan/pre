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
import com.bydan.erp.contabilidad.util.FacturaProveedorConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//FacturaProveedor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class FacturaProveedorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturaProveedor facturaproveedor;	
	protected List<FacturaProveedor> facturaproveedors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<PlantillaFactura> plantillafacturasForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<Factura> facturasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Empleado> empleadosolicitasForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoRetencion> tiporetencionfuente1sForeignKey;
	public List<TipoRetencion> tiporetencionfuente2sForeignKey;
	public List<TipoRetencion> tiporetencioniva1sForeignKey;
	public List<TipoRetencion> tiporetencioniva2sForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<CuentaContable> cuentacontablecreditofiscalbienessForeignKey;
	public List<ResponsableFondo> responsablefondosForeignKey;
	public List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey;
	public List<CuentaContable> cuentacontablegastosForeignKey;
	public List<CuentaContable> cuentacontablegasto2sForeignKey;
	public List<CuentaContable> cuentacontablecreditofinsForeignKey;
	public List<CuentaContable> cuentacontablecreditofin2sForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoMovimientoModulo> tipomovimientomodulosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	
	public FacturaProveedorParameterReturnGeneral () throws Exception {						
		super();
		this.facturaproveedors= new ArrayList<FacturaProveedor>();
		this.facturaproveedor= new FacturaProveedor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.plantillafacturasForeignKey=new ArrayList<PlantillaFactura>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.empleadosolicitasForeignKey=new ArrayList<Empleado>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionfuente2sForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencioniva2sForeignKey=new ArrayList<TipoRetencion>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.cuentacontablecreditofiscalbienessForeignKey=new ArrayList<CuentaContable>();
		this.responsablefondosForeignKey=new ArrayList<ResponsableFondo>();
		this.cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablegasto2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditofinsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditofin2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
	} 
	
	public FacturaProveedor getFacturaProveedor() throws Exception {	
		return facturaproveedor;
	}
		
	public void setFacturaProveedor(FacturaProveedor newFacturaProveedor) {
		this.facturaproveedor = newFacturaProveedor;
	}
	
	public List<FacturaProveedor> getFacturaProveedors() throws Exception {		
		return facturaproveedors;
	}
	
	public void setFacturaProveedors(List<FacturaProveedor> newFacturaProveedors) {
		this.facturaproveedors = newFacturaProveedors;
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

	public List<PlantillaFactura> getplantillafacturasForeignKey() {
		return this.plantillafacturasForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Empleado> getempleadosolicitasForeignKey() {
		return this.empleadosolicitasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuente1sForeignKey() {
		return this.tiporetencionfuente1sForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuente2sForeignKey() {
		return this.tiporetencionfuente2sForeignKey;
	}

	public List<TipoRetencion> gettiporetencioniva1sForeignKey() {
		return this.tiporetencioniva1sForeignKey;
	}

	public List<TipoRetencion> gettiporetencioniva2sForeignKey() {
		return this.tiporetencioniva2sForeignKey;
	}

	public List<TipoTributario> gettipotributariosForeignKey() {
		return this.tipotributariosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofiscalbienessForeignKey() {
		return this.cuentacontablecreditofiscalbienessForeignKey;
	}

	public List<ResponsableFondo> getresponsablefondosForeignKey() {
		return this.responsablefondosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofiscalserviciossForeignKey() {
		return this.cuentacontablecreditofiscalserviciossForeignKey;
	}

	public List<CuentaContable> getcuentacontablegastosForeignKey() {
		return this.cuentacontablegastosForeignKey;
	}

	public List<CuentaContable> getcuentacontablegasto2sForeignKey() {
		return this.cuentacontablegasto2sForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofinsForeignKey() {
		return this.cuentacontablecreditofinsForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditofin2sForeignKey() {
		return this.cuentacontablecreditofin2sForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
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

	public void setplantillafacturasForeignKey(List<PlantillaFactura> plantillafacturasForeignKey) {
		this.plantillafacturasForeignKey=plantillafacturasForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setempleadosolicitasForeignKey(List<Empleado> empleadosolicitasForeignKey) {
		this.empleadosolicitasForeignKey=empleadosolicitasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settiporetencionfuente1sForeignKey(List<TipoRetencion> tiporetencionfuente1sForeignKey) {
		this.tiporetencionfuente1sForeignKey=tiporetencionfuente1sForeignKey;
	}

	public void settiporetencionfuente2sForeignKey(List<TipoRetencion> tiporetencionfuente2sForeignKey) {
		this.tiporetencionfuente2sForeignKey=tiporetencionfuente2sForeignKey;
	}

	public void settiporetencioniva1sForeignKey(List<TipoRetencion> tiporetencioniva1sForeignKey) {
		this.tiporetencioniva1sForeignKey=tiporetencioniva1sForeignKey;
	}

	public void settiporetencioniva2sForeignKey(List<TipoRetencion> tiporetencioniva2sForeignKey) {
		this.tiporetencioniva2sForeignKey=tiporetencioniva2sForeignKey;
	}

	public void settipotributariosForeignKey(List<TipoTributario> tipotributariosForeignKey) {
		this.tipotributariosForeignKey=tipotributariosForeignKey;
	}

	public void setcuentacontablecreditofiscalbienessForeignKey(List<CuentaContable> cuentacontablecreditofiscalbienessForeignKey) {
		this.cuentacontablecreditofiscalbienessForeignKey=cuentacontablecreditofiscalbienessForeignKey;
	}

	public void setresponsablefondosForeignKey(List<ResponsableFondo> responsablefondosForeignKey) {
		this.responsablefondosForeignKey=responsablefondosForeignKey;
	}

	public void setcuentacontablecreditofiscalserviciossForeignKey(List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey) {
		this.cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciossForeignKey;
	}

	public void setcuentacontablegastosForeignKey(List<CuentaContable> cuentacontablegastosForeignKey) {
		this.cuentacontablegastosForeignKey=cuentacontablegastosForeignKey;
	}

	public void setcuentacontablegasto2sForeignKey(List<CuentaContable> cuentacontablegasto2sForeignKey) {
		this.cuentacontablegasto2sForeignKey=cuentacontablegasto2sForeignKey;
	}

	public void setcuentacontablecreditofinsForeignKey(List<CuentaContable> cuentacontablecreditofinsForeignKey) {
		this.cuentacontablecreditofinsForeignKey=cuentacontablecreditofinsForeignKey;
	}

	public void setcuentacontablecreditofin2sForeignKey(List<CuentaContable> cuentacontablecreditofin2sForeignKey) {
		this.cuentacontablecreditofin2sForeignKey=cuentacontablecreditofin2sForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
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

