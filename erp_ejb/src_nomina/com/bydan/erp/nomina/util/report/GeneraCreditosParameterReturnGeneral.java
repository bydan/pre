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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.GeneraCreditosConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//GeneraCreditos


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class GeneraCreditosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GeneraCreditos generacreditos;	
	protected List<GeneraCreditos> generacreditoss;
	
	
	public List<Empresa> empresasForeignKey;
	
	public GeneraCreditosParameterReturnGeneral () throws Exception {						
		super();
		this.generacreditoss= new ArrayList<GeneraCreditos>();
		this.generacreditos= new GeneraCreditos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public GeneraCreditos getGeneraCreditos() throws Exception {	
		return generacreditos;
	}
		
	public void setGeneraCreditos(GeneraCreditos newGeneraCreditos) {
		this.generacreditos = newGeneraCreditos;
	}
	
	public List<GeneraCreditos> getGeneraCreditoss() throws Exception {		
		return generacreditoss;
	}
	
	public void setGeneraCreditoss(List<GeneraCreditos> newGeneraCreditoss) {
		this.generacreditoss = newGeneraCreditoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

