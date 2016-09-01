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
import com.bydan.erp.contabilidad.util.FormularioIvaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//FormularioIva


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FormularioIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormularioIva formularioiva;	
	protected List<FormularioIva> formularioivas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<DatoFormularioIva> datoformularioivasForeignKey;
	public List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey;
	public List<ParametroFormularioIva> parametroformularioivasForeignKey;
	
	public FormularioIvaParameterReturnGeneral () throws Exception {						
		super();
		this.formularioivas= new ArrayList<FormularioIva>();
		this.formularioiva= new FormularioIva();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.datoformularioivasForeignKey=new ArrayList<DatoFormularioIva>();
		this.grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
		this.parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
	} 
	
	public FormularioIva getFormularioIva() throws Exception {	
		return formularioiva;
	}
		
	public void setFormularioIva(FormularioIva newFormularioIva) {
		this.formularioiva = newFormularioIva;
	}
	
	public List<FormularioIva> getFormularioIvas() throws Exception {		
		return formularioivas;
	}
	
	public void setFormularioIvas(List<FormularioIva> newFormularioIvas) {
		this.formularioivas = newFormularioIvas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<DatoFormularioIva> getdatoformularioivasForeignKey() {
		return this.datoformularioivasForeignKey;
	}

	public List<GrupoParametroFormularioIva> getgrupoparametroformularioivasForeignKey() {
		return this.grupoparametroformularioivasForeignKey;
	}

	public List<ParametroFormularioIva> getparametroformularioivasForeignKey() {
		return this.parametroformularioivasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setdatoformularioivasForeignKey(List<DatoFormularioIva> datoformularioivasForeignKey) {
		this.datoformularioivasForeignKey=datoformularioivasForeignKey;
	}

	public void setgrupoparametroformularioivasForeignKey(List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey) {
		this.grupoparametroformularioivasForeignKey=grupoparametroformularioivasForeignKey;
	}

	public void setparametroformularioivasForeignKey(List<ParametroFormularioIva> parametroformularioivasForeignKey) {
		this.parametroformularioivasForeignKey=parametroformularioivasForeignKey;
	}
}

