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
package com.bydan.erp.activosfijos.util.report;

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
import com.bydan.erp.activosfijos.util.report.ResponsablesConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//Responsables


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ResponsablesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Responsables responsables;	
	protected List<Responsables> responsabless;
	
	
	public List<Empresa> empresasForeignKey;
	
	public ResponsablesParameterReturnGeneral () throws Exception {						
		super();
		this.responsabless= new ArrayList<Responsables>();
		this.responsables= new Responsables();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public Responsables getResponsables() throws Exception {	
		return responsables;
	}
		
	public void setResponsables(Responsables newResponsables) {
		this.responsables = newResponsables;
	}
	
	public List<Responsables> getResponsabless() throws Exception {		
		return responsabless;
	}
	
	public void setResponsabless(List<Responsables> newResponsabless) {
		this.responsabless = newResponsabless;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

