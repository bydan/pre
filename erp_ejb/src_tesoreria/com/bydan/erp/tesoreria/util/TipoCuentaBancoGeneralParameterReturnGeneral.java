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
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGeneralConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoCuentaBancoGeneral


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoCuentaBancoGeneralParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCuentaBancoGeneral tipocuentabancogeneral;	
	protected List<TipoCuentaBancoGeneral> tipocuentabancogenerals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoCuentaBanco> tipocuentabancosForeignKey;
	
	public TipoCuentaBancoGeneralParameterReturnGeneral () throws Exception {						
		super();
		this.tipocuentabancogenerals= new ArrayList<TipoCuentaBancoGeneral>();
		this.tipocuentabancogeneral= new TipoCuentaBancoGeneral();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
	} 
	
	public TipoCuentaBancoGeneral getTipoCuentaBancoGeneral() throws Exception {	
		return tipocuentabancogeneral;
	}
		
	public void setTipoCuentaBancoGeneral(TipoCuentaBancoGeneral newTipoCuentaBancoGeneral) {
		this.tipocuentabancogeneral = newTipoCuentaBancoGeneral;
	}
	
	public List<TipoCuentaBancoGeneral> getTipoCuentaBancoGenerals() throws Exception {		
		return tipocuentabancogenerals;
	}
	
	public void setTipoCuentaBancoGenerals(List<TipoCuentaBancoGeneral> newTipoCuentaBancoGenerals) {
		this.tipocuentabancogenerals = newTipoCuentaBancoGenerals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoCuentaBanco> gettipocuentabancosForeignKey() {
		return this.tipocuentabancosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settipocuentabancosForeignKey(List<TipoCuentaBanco> tipocuentabancosForeignKey) {
		this.tipocuentabancosForeignKey=tipocuentabancosForeignKey;
	}
}

