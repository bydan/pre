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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.VariableNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//VariableNomi


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VariableNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VariableNomi variablenomi;	
	protected List<VariableNomi> variablenomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoVariableNomi> tipovariablenomisForeignKey;
	public List<TipoValorVariableNomi> tipovalorvariablenomisForeignKey;
	
	public VariableNomiParameterReturnGeneral () throws Exception {						
		super();
		this.variablenomis= new ArrayList<VariableNomi>();
		this.variablenomi= new VariableNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipovariablenomisForeignKey=new ArrayList<TipoVariableNomi>();
		this.tipovalorvariablenomisForeignKey=new ArrayList<TipoValorVariableNomi>();
	} 
	
	public VariableNomi getVariableNomi() throws Exception {	
		return variablenomi;
	}
		
	public void setVariableNomi(VariableNomi newVariableNomi) {
		this.variablenomi = newVariableNomi;
	}
	
	public List<VariableNomi> getVariableNomis() throws Exception {		
		return variablenomis;
	}
	
	public void setVariableNomis(List<VariableNomi> newVariableNomis) {
		this.variablenomis = newVariableNomis;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoVariableNomi> gettipovariablenomisForeignKey() {
		return this.tipovariablenomisForeignKey;
	}

	public List<TipoValorVariableNomi> gettipovalorvariablenomisForeignKey() {
		return this.tipovalorvariablenomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipovariablenomisForeignKey(List<TipoVariableNomi> tipovariablenomisForeignKey) {
		this.tipovariablenomisForeignKey=tipovariablenomisForeignKey;
	}

	public void settipovalorvariablenomisForeignKey(List<TipoValorVariableNomi> tipovalorvariablenomisForeignKey) {
		this.tipovalorvariablenomisForeignKey=tipovalorvariablenomisForeignKey;
	}
}

