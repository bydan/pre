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
import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//CuentaContable


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaContableParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaContable cuentacontable;	
	protected List<CuentaContable> cuentacontables;
	
	
	public List<Empresa> empresasForeignKey;
	public List<NivelCuenta> nivelcuentasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<TipoIntervalo> tipointervalosForeignKey;
	public List<TipoFlujoEfectivo> tipoflujoefectivosForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public CuentaContableParameterReturnGeneral () throws Exception {						
		super();
		this.cuentacontables= new ArrayList<CuentaContable>();
		this.cuentacontable= new CuentaContable();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.nivelcuentasForeignKey=new ArrayList<NivelCuenta>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
		this.tipoflujoefectivosForeignKey=new ArrayList<TipoFlujoEfectivo>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public CuentaContable getCuentaContable() throws Exception {	
		return cuentacontable;
	}
		
	public void setCuentaContable(CuentaContable newCuentaContable) {
		this.cuentacontable = newCuentaContable;
	}
	
	public List<CuentaContable> getCuentaContables() throws Exception {		
		return cuentacontables;
	}
	
	public void setCuentaContables(List<CuentaContable> newCuentaContables) {
		this.cuentacontables = newCuentaContables;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<NivelCuenta> getnivelcuentasForeignKey() {
		return this.nivelcuentasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<TipoIntervalo> gettipointervalosForeignKey() {
		return this.tipointervalosForeignKey;
	}

	public List<TipoFlujoEfectivo> gettipoflujoefectivosForeignKey() {
		return this.tipoflujoefectivosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setnivelcuentasForeignKey(List<NivelCuenta> nivelcuentasForeignKey) {
		this.nivelcuentasForeignKey=nivelcuentasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void settipointervalosForeignKey(List<TipoIntervalo> tipointervalosForeignKey) {
		this.tipointervalosForeignKey=tipointervalosForeignKey;
	}

	public void settipoflujoefectivosForeignKey(List<TipoFlujoEfectivo> tipoflujoefectivosForeignKey) {
		this.tipoflujoefectivosForeignKey=tipoflujoefectivosForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

