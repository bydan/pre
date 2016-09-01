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
import com.bydan.erp.contabilidad.util.FormularioRentaExtraConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//FormularioRentaExtra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class FormularioRentaExtraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormularioRentaExtra formulariorentaextra;	
	protected List<FormularioRentaExtra> formulariorentaextras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<DatoFormularioRenta> datoformulariorentasForeignKey;
	public List<FormaPago> formapagosForeignKey;
	public List<Banco> bancosForeignKey;
	
	public FormularioRentaExtraParameterReturnGeneral () throws Exception {						
		super();
		this.formulariorentaextras= new ArrayList<FormularioRentaExtra>();
		this.formulariorentaextra= new FormularioRentaExtra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
		this.formapagosForeignKey=new ArrayList<FormaPago>();
		this.bancosForeignKey=new ArrayList<Banco>();
	} 
	
	public FormularioRentaExtra getFormularioRentaExtra() throws Exception {	
		return formulariorentaextra;
	}
		
	public void setFormularioRentaExtra(FormularioRentaExtra newFormularioRentaExtra) {
		this.formulariorentaextra = newFormularioRentaExtra;
	}
	
	public List<FormularioRentaExtra> getFormularioRentaExtras() throws Exception {		
		return formulariorentaextras;
	}
	
	public void setFormularioRentaExtras(List<FormularioRentaExtra> newFormularioRentaExtras) {
		this.formulariorentaextras = newFormularioRentaExtras;
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

	public List<FormaPago> getformapagosForeignKey() {
		return this.formapagosForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
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

	public void setformapagosForeignKey(List<FormaPago> formapagosForeignKey) {
		this.formapagosForeignKey=formapagosForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}
}

