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
import com.bydan.erp.cartera.util.RadioVenciClienteProveConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//RadioVenciClienteProve


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RadioVenciClienteProveParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RadioVenciClienteProve radiovenciclienteprove;	
	protected List<RadioVenciClienteProve> radiovenciclienteproves;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoRadioVenci> tiporadiovencisForeignKey;
	
	public RadioVenciClienteProveParameterReturnGeneral () throws Exception {						
		super();
		this.radiovenciclienteproves= new ArrayList<RadioVenciClienteProve>();
		this.radiovenciclienteprove= new RadioVenciClienteProve();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tiporadiovencisForeignKey=new ArrayList<TipoRadioVenci>();
	} 
	
	public RadioVenciClienteProve getRadioVenciClienteProve() throws Exception {	
		return radiovenciclienteprove;
	}
		
	public void setRadioVenciClienteProve(RadioVenciClienteProve newRadioVenciClienteProve) {
		this.radiovenciclienteprove = newRadioVenciClienteProve;
	}
	
	public List<RadioVenciClienteProve> getRadioVenciClienteProves() throws Exception {		
		return radiovenciclienteproves;
	}
	
	public void setRadioVenciClienteProves(List<RadioVenciClienteProve> newRadioVenciClienteProves) {
		this.radiovenciclienteproves = newRadioVenciClienteProves;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoRadioVenci> gettiporadiovencisForeignKey() {
		return this.tiporadiovencisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settiporadiovencisForeignKey(List<TipoRadioVenci> tiporadiovencisForeignKey) {
		this.tiporadiovencisForeignKey=tiporadiovencisForeignKey;
	}
}

