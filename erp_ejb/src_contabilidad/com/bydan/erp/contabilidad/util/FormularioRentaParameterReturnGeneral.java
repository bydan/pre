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
import com.bydan.erp.contabilidad.util.FormularioRentaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//FormularioRenta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FormularioRentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormularioRenta formulariorenta;	
	protected List<FormularioRenta> formulariorentas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<DatoFormularioRenta> datoformulariorentasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	public List<ParametroFormularioIva> parametroformularioivasForeignKey;
	public List<Pais> paissForeignKey;
	
	public FormularioRentaParameterReturnGeneral () throws Exception {						
		super();
		this.formulariorentas= new ArrayList<FormularioRenta>();
		this.formulariorenta= new FormularioRenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
		this.parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public FormularioRenta getFormularioRenta() throws Exception {	
		return formulariorenta;
	}
		
	public void setFormularioRenta(FormularioRenta newFormularioRenta) {
		this.formulariorenta = newFormularioRenta;
	}
	
	public List<FormularioRenta> getFormularioRentas() throws Exception {		
		return formulariorentas;
	}
	
	public void setFormularioRentas(List<FormularioRenta> newFormularioRentas) {
		this.formulariorentas = newFormularioRentas;
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

	public List<DatoFormularioRenta> getdatoformulariorentasForeignKey() {
		return this.datoformulariorentasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
	}

	public List<ParametroFormularioIva> getparametroformularioivasForeignKey() {
		return this.parametroformularioivasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
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

	public void setdatoformulariorentasForeignKey(List<DatoFormularioRenta> datoformulariorentasForeignKey) {
		this.datoformulariorentasForeignKey=datoformulariorentasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}

	public void setparametroformularioivasForeignKey(List<ParametroFormularioIva> parametroformularioivasForeignKey) {
		this.parametroformularioivasForeignKey=parametroformularioivasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

