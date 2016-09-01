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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.FormulaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//Formula


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FormulaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Formula formula;	
	protected List<Formula> formulas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoFormula> tipoformulasForeignKey;
	
	public FormulaParameterReturnGeneral () throws Exception {						
		super();
		this.formulas= new ArrayList<Formula>();
		this.formula= new Formula();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoformulasForeignKey=new ArrayList<TipoFormula>();
	} 
	
	public Formula getFormula() throws Exception {	
		return formula;
	}
		
	public void setFormula(Formula newFormula) {
		this.formula = newFormula;
	}
	
	public List<Formula> getFormulas() throws Exception {		
		return formulas;
	}
	
	public void setFormulas(List<Formula> newFormulas) {
		this.formulas = newFormulas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoFormula> gettipoformulasForeignKey() {
		return this.tipoformulasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoformulasForeignKey(List<TipoFormula> tipoformulasForeignKey) {
		this.tipoformulasForeignKey=tipoformulasForeignKey;
	}
}

