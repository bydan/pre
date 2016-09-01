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
import com.bydan.erp.tesoreria.util.CuentaBancoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//CuentaBanco


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaBancoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaBanco cuentabanco;	
	protected List<CuentaBanco> cuentabancos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<EstadoCuentaBanco> estadocuentabancosForeignKey;
	public List<Formato> formatoingresosForeignKey;
	public List<Formato> formatoegresosForeignKey;
	public List<Formato> formatodiariosForeignKey;
	public List<Formato> formatochequesForeignKey;
	public List<Formato> formatoretencionsForeignKey;
	public List<Formato> formatoretencionivasForeignKey;
	
	public CuentaBancoParameterReturnGeneral () throws Exception {						
		super();
		this.cuentabancos= new ArrayList<CuentaBanco>();
		this.cuentabanco= new CuentaBanco();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.estadocuentabancosForeignKey=new ArrayList<EstadoCuentaBanco>();
		this.formatoingresosForeignKey=new ArrayList<Formato>();
		this.formatoegresosForeignKey=new ArrayList<Formato>();
		this.formatodiariosForeignKey=new ArrayList<Formato>();
		this.formatochequesForeignKey=new ArrayList<Formato>();
		this.formatoretencionsForeignKey=new ArrayList<Formato>();
		this.formatoretencionivasForeignKey=new ArrayList<Formato>();
	} 
	
	public CuentaBanco getCuentaBanco() throws Exception {	
		return cuentabanco;
	}
		
	public void setCuentaBanco(CuentaBanco newCuentaBanco) {
		this.cuentabanco = newCuentaBanco;
	}
	
	public List<CuentaBanco> getCuentaBancos() throws Exception {		
		return cuentabancos;
	}
	
	public void setCuentaBancos(List<CuentaBanco> newCuentaBancos) {
		this.cuentabancos = newCuentaBancos;
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

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<EstadoCuentaBanco> getestadocuentabancosForeignKey() {
		return this.estadocuentabancosForeignKey;
	}

	public List<Formato> getformatoingresosForeignKey() {
		return this.formatoingresosForeignKey;
	}

	public List<Formato> getformatoegresosForeignKey() {
		return this.formatoegresosForeignKey;
	}

	public List<Formato> getformatodiariosForeignKey() {
		return this.formatodiariosForeignKey;
	}

	public List<Formato> getformatochequesForeignKey() {
		return this.formatochequesForeignKey;
	}

	public List<Formato> getformatoretencionsForeignKey() {
		return this.formatoretencionsForeignKey;
	}

	public List<Formato> getformatoretencionivasForeignKey() {
		return this.formatoretencionivasForeignKey;
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

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setestadocuentabancosForeignKey(List<EstadoCuentaBanco> estadocuentabancosForeignKey) {
		this.estadocuentabancosForeignKey=estadocuentabancosForeignKey;
	}

	public void setformatoingresosForeignKey(List<Formato> formatoingresosForeignKey) {
		this.formatoingresosForeignKey=formatoingresosForeignKey;
	}

	public void setformatoegresosForeignKey(List<Formato> formatoegresosForeignKey) {
		this.formatoegresosForeignKey=formatoegresosForeignKey;
	}

	public void setformatodiariosForeignKey(List<Formato> formatodiariosForeignKey) {
		this.formatodiariosForeignKey=formatodiariosForeignKey;
	}

	public void setformatochequesForeignKey(List<Formato> formatochequesForeignKey) {
		this.formatochequesForeignKey=formatochequesForeignKey;
	}

	public void setformatoretencionsForeignKey(List<Formato> formatoretencionsForeignKey) {
		this.formatoretencionsForeignKey=formatoretencionsForeignKey;
	}

	public void setformatoretencionivasForeignKey(List<Formato> formatoretencionivasForeignKey) {
		this.formatoretencionivasForeignKey=formatoretencionivasForeignKey;
	}
}

