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
import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//BancoTipoCuentaBancoGlobal


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class BancoTipoCuentaBancoGlobalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal;	
	protected List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral () throws Exception {						
		super();
		this.bancotipocuentabancoglobals= new ArrayList<BancoTipoCuentaBancoGlobal>();
		this.bancotipocuentabancoglobal= new BancoTipoCuentaBancoGlobal();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
	} 
	
	public BancoTipoCuentaBancoGlobal getBancoTipoCuentaBancoGlobal() throws Exception {	
		return bancotipocuentabancoglobal;
	}
		
	public void setBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal newBancoTipoCuentaBancoGlobal) {
		this.bancotipocuentabancoglobal = newBancoTipoCuentaBancoGlobal;
	}
	
	public List<BancoTipoCuentaBancoGlobal> getBancoTipoCuentaBancoGlobals() throws Exception {		
		return bancotipocuentabancoglobals;
	}
	
	public void setBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> newBancoTipoCuentaBancoGlobals) {
		this.bancotipocuentabancoglobals = newBancoTipoCuentaBancoGlobals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}
}

