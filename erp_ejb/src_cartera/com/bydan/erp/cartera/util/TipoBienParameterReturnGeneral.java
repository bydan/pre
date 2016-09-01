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
import com.bydan.erp.cartera.util.TipoBienConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoBien


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoBienParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoBien tipobien;	
	protected List<TipoBien> tipobiens;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoBienParameterReturnGeneral () throws Exception {						
		super();
		this.tipobiens= new ArrayList<TipoBien>();
		this.tipobien= new TipoBien();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoBien getTipoBien() throws Exception {	
		return tipobien;
	}
		
	public void setTipoBien(TipoBien newTipoBien) {
		this.tipobien = newTipoBien;
	}
	
	public List<TipoBien> getTipoBiens() throws Exception {		
		return tipobiens;
	}
	
	public void setTipoBiens(List<TipoBien> newTipoBiens) {
		this.tipobiens = newTipoBiens;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

