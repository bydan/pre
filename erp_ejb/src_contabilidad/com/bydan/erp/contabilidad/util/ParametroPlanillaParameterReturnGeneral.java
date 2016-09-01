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
import com.bydan.erp.contabilidad.util.ParametroPlanillaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroPlanilla


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroPlanillaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroPlanilla parametroplanilla;	
	protected List<ParametroPlanilla> parametroplanillas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontableinicialsForeignKey;
	public List<CuentaContable> cuentacontablefinalsForeignKey;
	
	public ParametroPlanillaParameterReturnGeneral () throws Exception {						
		super();
		this.parametroplanillas= new ArrayList<ParametroPlanilla>();
		this.parametroplanilla= new ParametroPlanilla();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontableinicialsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefinalsForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroPlanilla getParametroPlanilla() throws Exception {	
		return parametroplanilla;
	}
		
	public void setParametroPlanilla(ParametroPlanilla newParametroPlanilla) {
		this.parametroplanilla = newParametroPlanilla;
	}
	
	public List<ParametroPlanilla> getParametroPlanillas() throws Exception {		
		return parametroplanillas;
	}
	
	public void setParametroPlanillas(List<ParametroPlanilla> newParametroPlanillas) {
		this.parametroplanillas = newParametroPlanillas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontableinicialsForeignKey() {
		return this.cuentacontableinicialsForeignKey;
	}

	public List<CuentaContable> getcuentacontablefinalsForeignKey() {
		return this.cuentacontablefinalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontableinicialsForeignKey(List<CuentaContable> cuentacontableinicialsForeignKey) {
		this.cuentacontableinicialsForeignKey=cuentacontableinicialsForeignKey;
	}

	public void setcuentacontablefinalsForeignKey(List<CuentaContable> cuentacontablefinalsForeignKey) {
		this.cuentacontablefinalsForeignKey=cuentacontablefinalsForeignKey;
	}
}

