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
import com.bydan.erp.nomina.util.report.RubrosVariablesConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//RubrosVariables


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RubrosVariablesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RubrosVariables rubrosvariables;	
	protected List<RubrosVariables> rubrosvariabless;
	
	
	public List<TipoContrato> tipocontratosForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	
	public RubrosVariablesParameterReturnGeneral () throws Exception {						
		super();
		this.rubrosvariabless= new ArrayList<RubrosVariables>();
		this.rubrosvariables= new RubrosVariables();
		
		
		this.tipocontratosForeignKey=new ArrayList<TipoContrato>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
	} 
	
	public RubrosVariables getRubrosVariables() throws Exception {	
		return rubrosvariables;
	}
		
	public void setRubrosVariables(RubrosVariables newRubrosVariables) {
		this.rubrosvariables = newRubrosVariables;
	}
	
	public List<RubrosVariables> getRubrosVariabless() throws Exception {		
		return rubrosvariabless;
	}
	
	public void setRubrosVariabless(List<RubrosVariables> newRubrosVariabless) {
		this.rubrosvariabless = newRubrosVariabless;
	}
	
	

	public List<TipoContrato> gettipocontratosForeignKey() {
		return this.tipocontratosForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}
	
	

	public void settipocontratosForeignKey(List<TipoContrato> tipocontratosForeignKey) {
		this.tipocontratosForeignKey=tipocontratosForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}
}

