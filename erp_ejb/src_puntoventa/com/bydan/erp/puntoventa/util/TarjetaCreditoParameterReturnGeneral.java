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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.TarjetaCreditoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//TarjetaCredito


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TarjetaCreditoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TarjetaCredito tarjetacredito;	
	protected List<TarjetaCredito> tarjetacreditos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<TipoRetencionIva> tiporetencionivasForeignKey;
	public List<CuentaContable> cuentacontablecomisionsForeignKey;
	public List<Formula> formulapagobancosForeignKey;
	public List<CuentaContable> cuentacontablediferenciasForeignKey;
	public List<Formula> formularetencionsForeignKey;
	public List<Formula> formulacomisionsForeignKey;
	
	public TarjetaCreditoParameterReturnGeneral () throws Exception {						
		super();
		this.tarjetacreditos= new ArrayList<TarjetaCredito>();
		this.tarjetacredito= new TarjetaCredito();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
		this.cuentacontablecomisionsForeignKey=new ArrayList<CuentaContable>();
		this.formulapagobancosForeignKey=new ArrayList<Formula>();
		this.cuentacontablediferenciasForeignKey=new ArrayList<CuentaContable>();
		this.formularetencionsForeignKey=new ArrayList<Formula>();
		this.formulacomisionsForeignKey=new ArrayList<Formula>();
	} 
	
	public TarjetaCredito getTarjetaCredito() throws Exception {	
		return tarjetacredito;
	}
		
	public void setTarjetaCredito(TarjetaCredito newTarjetaCredito) {
		this.tarjetacredito = newTarjetaCredito;
	}
	
	public List<TarjetaCredito> getTarjetaCreditos() throws Exception {		
		return tarjetacreditos;
	}
	
	public void setTarjetaCreditos(List<TarjetaCredito> newTarjetaCreditos) {
		this.tarjetacreditos = newTarjetaCreditos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<TipoRetencionIva> gettiporetencionivasForeignKey() {
		return this.tiporetencionivasForeignKey;
	}

	public List<CuentaContable> getcuentacontablecomisionsForeignKey() {
		return this.cuentacontablecomisionsForeignKey;
	}

	public List<Formula> getformulapagobancosForeignKey() {
		return this.formulapagobancosForeignKey;
	}

	public List<CuentaContable> getcuentacontablediferenciasForeignKey() {
		return this.cuentacontablediferenciasForeignKey;
	}

	public List<Formula> getformularetencionsForeignKey() {
		return this.formularetencionsForeignKey;
	}

	public List<Formula> getformulacomisionsForeignKey() {
		return this.formulacomisionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void settiporetencionivasForeignKey(List<TipoRetencionIva> tiporetencionivasForeignKey) {
		this.tiporetencionivasForeignKey=tiporetencionivasForeignKey;
	}

	public void setcuentacontablecomisionsForeignKey(List<CuentaContable> cuentacontablecomisionsForeignKey) {
		this.cuentacontablecomisionsForeignKey=cuentacontablecomisionsForeignKey;
	}

	public void setformulapagobancosForeignKey(List<Formula> formulapagobancosForeignKey) {
		this.formulapagobancosForeignKey=formulapagobancosForeignKey;
	}

	public void setcuentacontablediferenciasForeignKey(List<CuentaContable> cuentacontablediferenciasForeignKey) {
		this.cuentacontablediferenciasForeignKey=cuentacontablediferenciasForeignKey;
	}

	public void setformularetencionsForeignKey(List<Formula> formularetencionsForeignKey) {
		this.formularetencionsForeignKey=formularetencionsForeignKey;
	}

	public void setformulacomisionsForeignKey(List<Formula> formulacomisionsForeignKey) {
		this.formulacomisionsForeignKey=formulacomisionsForeignKey;
	}
}

