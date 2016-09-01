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
import com.bydan.erp.tesoreria.util.BancoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//Banco


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class BancoParameterReturnGeneral extends BancoReturnGeneralAdditional implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Banco banco;	
	protected List<Banco> bancos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoBanco> tipobancosForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	public List<Formato> formato1sForeignKey;
	public List<Formato> formato2sForeignKey;
	
	public BancoParameterReturnGeneral () throws Exception {						
		super();
		this.bancos= new ArrayList<Banco>();
		this.banco= new Banco();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipobancosForeignKey=new ArrayList<TipoBanco>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
		this.formato1sForeignKey=new ArrayList<Formato>();
		this.formato2sForeignKey=new ArrayList<Formato>();
	} 
	
	public Banco getBanco() throws Exception {	
		return banco;
	}
		
	public void setBanco(Banco newBanco) {
		this.banco = newBanco;
	}
	
	public List<Banco> getBancos() throws Exception {		
		return bancos;
	}
	
	public void setBancos(List<Banco> newBancos) {
		this.bancos = newBancos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoBanco> gettipobancosForeignKey() {
		return this.tipobancosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}

	public List<Formato> getformato1sForeignKey() {
		return this.formato1sForeignKey;
	}

	public List<Formato> getformato2sForeignKey() {
		return this.formato2sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipobancosForeignKey(List<TipoBanco> tipobancosForeignKey) {
		this.tipobancosForeignKey=tipobancosForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}

	public void setformato1sForeignKey(List<Formato> formato1sForeignKey) {
		this.formato1sForeignKey=formato1sForeignKey;
	}

	public void setformato2sForeignKey(List<Formato> formato2sForeignKey) {
		this.formato2sForeignKey=formato2sForeignKey;
	}
}

