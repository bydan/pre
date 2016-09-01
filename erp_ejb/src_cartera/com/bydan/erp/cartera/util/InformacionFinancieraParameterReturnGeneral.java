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
import com.bydan.erp.cartera.util.InformacionFinancieraConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//InformacionFinanciera


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class InformacionFinancieraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected InformacionFinanciera informacionfinanciera;	
	protected List<InformacionFinanciera> informacionfinancieras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoMoviFinan> tipomovifinansForeignKey;
	
	public InformacionFinancieraParameterReturnGeneral () throws Exception {						
		super();
		this.informacionfinancieras= new ArrayList<InformacionFinanciera>();
		this.informacionfinanciera= new InformacionFinanciera();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipomovifinansForeignKey=new ArrayList<TipoMoviFinan>();
	} 
	
	public InformacionFinanciera getInformacionFinanciera() throws Exception {	
		return informacionfinanciera;
	}
		
	public void setInformacionFinanciera(InformacionFinanciera newInformacionFinanciera) {
		this.informacionfinanciera = newInformacionFinanciera;
	}
	
	public List<InformacionFinanciera> getInformacionFinancieras() throws Exception {		
		return informacionfinancieras;
	}
	
	public void setInformacionFinancieras(List<InformacionFinanciera> newInformacionFinancieras) {
		this.informacionfinancieras = newInformacionFinancieras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoMoviFinan> gettipomovifinansForeignKey() {
		return this.tipomovifinansForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipomovifinansForeignKey(List<TipoMoviFinan> tipomovifinansForeignKey) {
		this.tipomovifinansForeignKey=tipomovifinansForeignKey;
	}
}

