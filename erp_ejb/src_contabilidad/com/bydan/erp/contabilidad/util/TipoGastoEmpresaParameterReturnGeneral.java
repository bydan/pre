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
import com.bydan.erp.contabilidad.util.TipoGastoEmpresaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoGastoEmpresa


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoGastoEmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoGastoEmpresa tipogastoempresa;	
	protected List<TipoGastoEmpresa> tipogastoempresas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Formato> formatosForeignKey;
	public List<CuentaContable> cuentacontablegastosForeignKey;
	public List<CuentaContable> cuentacontablefiscalbiensForeignKey;
	public List<CuentaContable> cuentacontablefiscalserviciosForeignKey;
	public List<CuentaContable> cuentacontableretencionbiensForeignKey;
	public List<CuentaContable> cuentacontableretencionserviciosForeignKey;
	public List<CuentaContable> cuentacontableivabiensForeignKey;
	public List<CuentaContable> cuentacontableivaserviciosForeignKey;
	
	public TipoGastoEmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.tipogastoempresas= new ArrayList<TipoGastoEmpresa>();
		this.tipogastoempresa= new TipoGastoEmpresa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefiscalbiensForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefiscalserviciosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableretencionbiensForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableretencionserviciosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableivabiensForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableivaserviciosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TipoGastoEmpresa getTipoGastoEmpresa() throws Exception {	
		return tipogastoempresa;
	}
		
	public void setTipoGastoEmpresa(TipoGastoEmpresa newTipoGastoEmpresa) {
		this.tipogastoempresa = newTipoGastoEmpresa;
	}
	
	public List<TipoGastoEmpresa> getTipoGastoEmpresas() throws Exception {		
		return tipogastoempresas;
	}
	
	public void setTipoGastoEmpresas(List<TipoGastoEmpresa> newTipoGastoEmpresas) {
		this.tipogastoempresas = newTipoGastoEmpresas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<CuentaContable> getcuentacontablegastosForeignKey() {
		return this.cuentacontablegastosForeignKey;
	}

	public List<CuentaContable> getcuentacontablefiscalbiensForeignKey() {
		return this.cuentacontablefiscalbiensForeignKey;
	}

	public List<CuentaContable> getcuentacontablefiscalserviciosForeignKey() {
		return this.cuentacontablefiscalserviciosForeignKey;
	}

	public List<CuentaContable> getcuentacontableretencionbiensForeignKey() {
		return this.cuentacontableretencionbiensForeignKey;
	}

	public List<CuentaContable> getcuentacontableretencionserviciosForeignKey() {
		return this.cuentacontableretencionserviciosForeignKey;
	}

	public List<CuentaContable> getcuentacontableivabiensForeignKey() {
		return this.cuentacontableivabiensForeignKey;
	}

	public List<CuentaContable> getcuentacontableivaserviciosForeignKey() {
		return this.cuentacontableivaserviciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setcuentacontablegastosForeignKey(List<CuentaContable> cuentacontablegastosForeignKey) {
		this.cuentacontablegastosForeignKey=cuentacontablegastosForeignKey;
	}

	public void setcuentacontablefiscalbiensForeignKey(List<CuentaContable> cuentacontablefiscalbiensForeignKey) {
		this.cuentacontablefiscalbiensForeignKey=cuentacontablefiscalbiensForeignKey;
	}

	public void setcuentacontablefiscalserviciosForeignKey(List<CuentaContable> cuentacontablefiscalserviciosForeignKey) {
		this.cuentacontablefiscalserviciosForeignKey=cuentacontablefiscalserviciosForeignKey;
	}

	public void setcuentacontableretencionbiensForeignKey(List<CuentaContable> cuentacontableretencionbiensForeignKey) {
		this.cuentacontableretencionbiensForeignKey=cuentacontableretencionbiensForeignKey;
	}

	public void setcuentacontableretencionserviciosForeignKey(List<CuentaContable> cuentacontableretencionserviciosForeignKey) {
		this.cuentacontableretencionserviciosForeignKey=cuentacontableretencionserviciosForeignKey;
	}

	public void setcuentacontableivabiensForeignKey(List<CuentaContable> cuentacontableivabiensForeignKey) {
		this.cuentacontableivabiensForeignKey=cuentacontableivabiensForeignKey;
	}

	public void setcuentacontableivaserviciosForeignKey(List<CuentaContable> cuentacontableivaserviciosForeignKey) {
		this.cuentacontableivaserviciosForeignKey=cuentacontableivaserviciosForeignKey;
	}
}

