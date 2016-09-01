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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.ReferenciaBancariaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ReferenciaBancaria


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ReferenciaBancariaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ReferenciaBancaria referenciabancaria;	
	protected List<ReferenciaBancaria> referenciabancarias;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoProduBanco> tipoprodubancosForeignKey;
	public List<TipoCuentaBanco> tipocuentabancosForeignKey;
	public List<TipoValoracion> tipovaloracionsForeignKey;
	
	public ReferenciaBancariaParameterReturnGeneral () throws Exception {						
		super();
		this.referenciabancarias= new ArrayList<ReferenciaBancaria>();
		this.referenciabancaria= new ReferenciaBancaria();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipoprodubancosForeignKey=new ArrayList<TipoProduBanco>();
		this.tipocuentabancosForeignKey=new ArrayList<TipoCuentaBanco>();
		this.tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
	} 
	
	public ReferenciaBancaria getReferenciaBancaria() throws Exception {	
		return referenciabancaria;
	}
		
	public void setReferenciaBancaria(ReferenciaBancaria newReferenciaBancaria) {
		this.referenciabancaria = newReferenciaBancaria;
	}
	
	public List<ReferenciaBancaria> getReferenciaBancarias() throws Exception {		
		return referenciabancarias;
	}
	
	public void setReferenciaBancarias(List<ReferenciaBancaria> newReferenciaBancarias) {
		this.referenciabancarias = newReferenciaBancarias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoProduBanco> gettipoprodubancosForeignKey() {
		return this.tipoprodubancosForeignKey;
	}

	public List<TipoCuentaBanco> gettipocuentabancosForeignKey() {
		return this.tipocuentabancosForeignKey;
	}

	public List<TipoValoracion> gettipovaloracionsForeignKey() {
		return this.tipovaloracionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settipoprodubancosForeignKey(List<TipoProduBanco> tipoprodubancosForeignKey) {
		this.tipoprodubancosForeignKey=tipoprodubancosForeignKey;
	}

	public void settipocuentabancosForeignKey(List<TipoCuentaBanco> tipocuentabancosForeignKey) {
		this.tipocuentabancosForeignKey=tipocuentabancosForeignKey;
	}

	public void settipovaloracionsForeignKey(List<TipoValoracion> tipovaloracionsForeignKey) {
		this.tipovaloracionsForeignKey=tipovaloracionsForeignKey;
	}
}

