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
import com.bydan.erp.tesoreria.util.TipoBancoRetencionConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoBancoRetencion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoBancoRetencionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoBancoRetencion tipobancoretencion;	
	protected List<TipoBancoRetencion> tipobancoretencions;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoBancoRetencionParameterReturnGeneral () throws Exception {						
		super();
		this.tipobancoretencions= new ArrayList<TipoBancoRetencion>();
		this.tipobancoretencion= new TipoBancoRetencion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoBancoRetencion getTipoBancoRetencion() throws Exception {	
		return tipobancoretencion;
	}
		
	public void setTipoBancoRetencion(TipoBancoRetencion newTipoBancoRetencion) {
		this.tipobancoretencion = newTipoBancoRetencion;
	}
	
	public List<TipoBancoRetencion> getTipoBancoRetencions() throws Exception {		
		return tipobancoretencions;
	}
	
	public void setTipoBancoRetencions(List<TipoBancoRetencion> newTipoBancoRetencions) {
		this.tipobancoretencions = newTipoBancoRetencions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

