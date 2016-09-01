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
import com.bydan.erp.facturacion.util.ParametroFactuPrincipalConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFactuPrincipal


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFactuPrincipalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFactuPrincipal parametrofactuprincipal;	
	protected List<ParametroFactuPrincipal> parametrofactuprincipals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoParamFactuDescuento> tipoparamfactudescuentosForeignKey;
	public List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesForeignKey;
	public List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosForeignKey;
	public List<TipoDocumento> tipodocumentofacturasForeignKey;
	public List<TipoDocumento> tipodocumentonotacreditosForeignKey;
	public List<TipoDocumento> tipodocumentonotadebitosForeignKey;
	public List<LibroContable> librocontablesForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Formato> formatosForeignKey;
	public List<CuentaContable> cuentacontablefleteventasForeignKey;
	public List<CuentaContable> cuentacontableotrocargosForeignKey;
	public List<CuentaContable> cuentacontablefinansForeignKey;
	public List<CuentaContable> cuentacontablebonisForeignKey;
	public List<CuentaContable> cuentacontablebonidevolsForeignKey;
	public List<CuentaContable> cuentacontableicesForeignKey;
	
	public ParametroFactuPrincipalParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofactuprincipals= new ArrayList<ParametroFactuPrincipal>();
		this.parametrofactuprincipal= new ParametroFactuPrincipal();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipoparamfactudescuentosForeignKey=new ArrayList<TipoParamFactuDescuento>();
		this.tipoparamfactulistadoclientesForeignKey=new ArrayList<TipoParamFactuListadoCliente>();
		this.tipoparamfactusecuenciatrabajosForeignKey=new ArrayList<TipoParamFactuSecuenciaTrabajo>();
		this.tipodocumentofacturasForeignKey=new ArrayList<TipoDocumento>();
		this.tipodocumentonotacreditosForeignKey=new ArrayList<TipoDocumento>();
		this.tipodocumentonotadebitosForeignKey=new ArrayList<TipoDocumento>();
		this.librocontablesForeignKey=new ArrayList<LibroContable>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.cuentacontablefleteventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableotrocargosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefinansForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablebonisForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablebonidevolsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableicesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroFactuPrincipal getParametroFactuPrincipal() throws Exception {	
		return parametrofactuprincipal;
	}
		
	public void setParametroFactuPrincipal(ParametroFactuPrincipal newParametroFactuPrincipal) {
		this.parametrofactuprincipal = newParametroFactuPrincipal;
	}
	
	public List<ParametroFactuPrincipal> getParametroFactuPrincipals() throws Exception {		
		return parametrofactuprincipals;
	}
	
	public void setParametroFactuPrincipals(List<ParametroFactuPrincipal> newParametroFactuPrincipals) {
		this.parametrofactuprincipals = newParametroFactuPrincipals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoParamFactuDescuento> gettipoparamfactudescuentosForeignKey() {
		return this.tipoparamfactudescuentosForeignKey;
	}

	public List<TipoParamFactuListadoCliente> gettipoparamfactulistadoclientesForeignKey() {
		return this.tipoparamfactulistadoclientesForeignKey;
	}

	public List<TipoParamFactuSecuenciaTrabajo> gettipoparamfactusecuenciatrabajosForeignKey() {
		return this.tipoparamfactusecuenciatrabajosForeignKey;
	}

	public List<TipoDocumento> gettipodocumentofacturasForeignKey() {
		return this.tipodocumentofacturasForeignKey;
	}

	public List<TipoDocumento> gettipodocumentonotacreditosForeignKey() {
		return this.tipodocumentonotacreditosForeignKey;
	}

	public List<TipoDocumento> gettipodocumentonotadebitosForeignKey() {
		return this.tipodocumentonotadebitosForeignKey;
	}

	public List<LibroContable> getlibrocontablesForeignKey() {
		return this.librocontablesForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<CuentaContable> getcuentacontablefleteventasForeignKey() {
		return this.cuentacontablefleteventasForeignKey;
	}

	public List<CuentaContable> getcuentacontableotrocargosForeignKey() {
		return this.cuentacontableotrocargosForeignKey;
	}

	public List<CuentaContable> getcuentacontablefinansForeignKey() {
		return this.cuentacontablefinansForeignKey;
	}

	public List<CuentaContable> getcuentacontablebonisForeignKey() {
		return this.cuentacontablebonisForeignKey;
	}

	public List<CuentaContable> getcuentacontablebonidevolsForeignKey() {
		return this.cuentacontablebonidevolsForeignKey;
	}

	public List<CuentaContable> getcuentacontableicesForeignKey() {
		return this.cuentacontableicesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipoparamfactudescuentosForeignKey(List<TipoParamFactuDescuento> tipoparamfactudescuentosForeignKey) {
		this.tipoparamfactudescuentosForeignKey=tipoparamfactudescuentosForeignKey;
	}

	public void settipoparamfactulistadoclientesForeignKey(List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientesForeignKey) {
		this.tipoparamfactulistadoclientesForeignKey=tipoparamfactulistadoclientesForeignKey;
	}

	public void settipoparamfactusecuenciatrabajosForeignKey(List<TipoParamFactuSecuenciaTrabajo> tipoparamfactusecuenciatrabajosForeignKey) {
		this.tipoparamfactusecuenciatrabajosForeignKey=tipoparamfactusecuenciatrabajosForeignKey;
	}

	public void settipodocumentofacturasForeignKey(List<TipoDocumento> tipodocumentofacturasForeignKey) {
		this.tipodocumentofacturasForeignKey=tipodocumentofacturasForeignKey;
	}

	public void settipodocumentonotacreditosForeignKey(List<TipoDocumento> tipodocumentonotacreditosForeignKey) {
		this.tipodocumentonotacreditosForeignKey=tipodocumentonotacreditosForeignKey;
	}

	public void settipodocumentonotadebitosForeignKey(List<TipoDocumento> tipodocumentonotadebitosForeignKey) {
		this.tipodocumentonotadebitosForeignKey=tipodocumentonotadebitosForeignKey;
	}

	public void setlibrocontablesForeignKey(List<LibroContable> librocontablesForeignKey) {
		this.librocontablesForeignKey=librocontablesForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setcuentacontablefleteventasForeignKey(List<CuentaContable> cuentacontablefleteventasForeignKey) {
		this.cuentacontablefleteventasForeignKey=cuentacontablefleteventasForeignKey;
	}

	public void setcuentacontableotrocargosForeignKey(List<CuentaContable> cuentacontableotrocargosForeignKey) {
		this.cuentacontableotrocargosForeignKey=cuentacontableotrocargosForeignKey;
	}

	public void setcuentacontablefinansForeignKey(List<CuentaContable> cuentacontablefinansForeignKey) {
		this.cuentacontablefinansForeignKey=cuentacontablefinansForeignKey;
	}

	public void setcuentacontablebonisForeignKey(List<CuentaContable> cuentacontablebonisForeignKey) {
		this.cuentacontablebonisForeignKey=cuentacontablebonisForeignKey;
	}

	public void setcuentacontablebonidevolsForeignKey(List<CuentaContable> cuentacontablebonidevolsForeignKey) {
		this.cuentacontablebonidevolsForeignKey=cuentacontablebonidevolsForeignKey;
	}

	public void setcuentacontableicesForeignKey(List<CuentaContable> cuentacontableicesForeignKey) {
		this.cuentacontableicesForeignKey=cuentacontableicesForeignKey;
	}
}

