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
import com.bydan.erp.contabilidad.util.ParametroContaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroConta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroContaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroConta parametroconta;	
	protected List<ParametroConta> parametrocontas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Moneda> monedaextranjerasForeignKey;
	public List<CuentaContable> cuentacontableactivosForeignKey;
	public List<CuentaContable> cuentacontablepasivosForeignKey;
	public List<CuentaContable> cuentacontablepatrimoniosForeignKey;
	public List<CuentaContable> cuentacontableingresosForeignKey;
	public List<CuentaContable> cuentacontableegresosForeignKey;
	public List<CuentaContable> cuentacontableresumensForeignKey;
	public List<CuentaContable> cuentacontabledeudorsForeignKey;
	public List<CuentaContable> cuentacontableacreedorsForeignKey;
	public List<CuentaContable> cuentacontableingreso1sForeignKey;
	public List<CuentaContable> cuentacontableingreso2sForeignKey;
	public List<CuentaContable> cuentacontableingreso3sForeignKey;
	public List<CuentaContable> cuentacontableegreso1sForeignKey;
	public List<CuentaContable> cuentacontableegreso2sForeignKey;
	public List<CuentaContable> cuentacontableegreso3sForeignKey;
	
	public ParametroContaParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocontas= new ArrayList<ParametroConta>();
		this.parametroconta= new ParametroConta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.monedaextranjerasForeignKey=new ArrayList<Moneda>();
		this.cuentacontableactivosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepasivosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablepatrimoniosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingresosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableegresosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableresumensForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledeudorsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableacreedorsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingreso1sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingreso2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableingreso3sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableegreso1sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableegreso2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableegreso3sForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroConta getParametroConta() throws Exception {	
		return parametroconta;
	}
		
	public void setParametroConta(ParametroConta newParametroConta) {
		this.parametroconta = newParametroConta;
	}
	
	public List<ParametroConta> getParametroContas() throws Exception {		
		return parametrocontas;
	}
	
	public void setParametroContas(List<ParametroConta> newParametroContas) {
		this.parametrocontas = newParametroContas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Moneda> getmonedaextranjerasForeignKey() {
		return this.monedaextranjerasForeignKey;
	}

	public List<CuentaContable> getcuentacontableactivosForeignKey() {
		return this.cuentacontableactivosForeignKey;
	}

	public List<CuentaContable> getcuentacontablepasivosForeignKey() {
		return this.cuentacontablepasivosForeignKey;
	}

	public List<CuentaContable> getcuentacontablepatrimoniosForeignKey() {
		return this.cuentacontablepatrimoniosForeignKey;
	}

	public List<CuentaContable> getcuentacontableingresosForeignKey() {
		return this.cuentacontableingresosForeignKey;
	}

	public List<CuentaContable> getcuentacontableegresosForeignKey() {
		return this.cuentacontableegresosForeignKey;
	}

	public List<CuentaContable> getcuentacontableresumensForeignKey() {
		return this.cuentacontableresumensForeignKey;
	}

	public List<CuentaContable> getcuentacontabledeudorsForeignKey() {
		return this.cuentacontabledeudorsForeignKey;
	}

	public List<CuentaContable> getcuentacontableacreedorsForeignKey() {
		return this.cuentacontableacreedorsForeignKey;
	}

	public List<CuentaContable> getcuentacontableingreso1sForeignKey() {
		return this.cuentacontableingreso1sForeignKey;
	}

	public List<CuentaContable> getcuentacontableingreso2sForeignKey() {
		return this.cuentacontableingreso2sForeignKey;
	}

	public List<CuentaContable> getcuentacontableingreso3sForeignKey() {
		return this.cuentacontableingreso3sForeignKey;
	}

	public List<CuentaContable> getcuentacontableegreso1sForeignKey() {
		return this.cuentacontableegreso1sForeignKey;
	}

	public List<CuentaContable> getcuentacontableegreso2sForeignKey() {
		return this.cuentacontableegreso2sForeignKey;
	}

	public List<CuentaContable> getcuentacontableegreso3sForeignKey() {
		return this.cuentacontableegreso3sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setmonedaextranjerasForeignKey(List<Moneda> monedaextranjerasForeignKey) {
		this.monedaextranjerasForeignKey=monedaextranjerasForeignKey;
	}

	public void setcuentacontableactivosForeignKey(List<CuentaContable> cuentacontableactivosForeignKey) {
		this.cuentacontableactivosForeignKey=cuentacontableactivosForeignKey;
	}

	public void setcuentacontablepasivosForeignKey(List<CuentaContable> cuentacontablepasivosForeignKey) {
		this.cuentacontablepasivosForeignKey=cuentacontablepasivosForeignKey;
	}

	public void setcuentacontablepatrimoniosForeignKey(List<CuentaContable> cuentacontablepatrimoniosForeignKey) {
		this.cuentacontablepatrimoniosForeignKey=cuentacontablepatrimoniosForeignKey;
	}

	public void setcuentacontableingresosForeignKey(List<CuentaContable> cuentacontableingresosForeignKey) {
		this.cuentacontableingresosForeignKey=cuentacontableingresosForeignKey;
	}

	public void setcuentacontableegresosForeignKey(List<CuentaContable> cuentacontableegresosForeignKey) {
		this.cuentacontableegresosForeignKey=cuentacontableegresosForeignKey;
	}

	public void setcuentacontableresumensForeignKey(List<CuentaContable> cuentacontableresumensForeignKey) {
		this.cuentacontableresumensForeignKey=cuentacontableresumensForeignKey;
	}

	public void setcuentacontabledeudorsForeignKey(List<CuentaContable> cuentacontabledeudorsForeignKey) {
		this.cuentacontabledeudorsForeignKey=cuentacontabledeudorsForeignKey;
	}

	public void setcuentacontableacreedorsForeignKey(List<CuentaContable> cuentacontableacreedorsForeignKey) {
		this.cuentacontableacreedorsForeignKey=cuentacontableacreedorsForeignKey;
	}

	public void setcuentacontableingreso1sForeignKey(List<CuentaContable> cuentacontableingreso1sForeignKey) {
		this.cuentacontableingreso1sForeignKey=cuentacontableingreso1sForeignKey;
	}

	public void setcuentacontableingreso2sForeignKey(List<CuentaContable> cuentacontableingreso2sForeignKey) {
		this.cuentacontableingreso2sForeignKey=cuentacontableingreso2sForeignKey;
	}

	public void setcuentacontableingreso3sForeignKey(List<CuentaContable> cuentacontableingreso3sForeignKey) {
		this.cuentacontableingreso3sForeignKey=cuentacontableingreso3sForeignKey;
	}

	public void setcuentacontableegreso1sForeignKey(List<CuentaContable> cuentacontableegreso1sForeignKey) {
		this.cuentacontableegreso1sForeignKey=cuentacontableegreso1sForeignKey;
	}

	public void setcuentacontableegreso2sForeignKey(List<CuentaContable> cuentacontableegreso2sForeignKey) {
		this.cuentacontableegreso2sForeignKey=cuentacontableegreso2sForeignKey;
	}

	public void setcuentacontableegreso3sForeignKey(List<CuentaContable> cuentacontableegreso3sForeignKey) {
		this.cuentacontableegreso3sForeignKey=cuentacontableegreso3sForeignKey;
	}
}

