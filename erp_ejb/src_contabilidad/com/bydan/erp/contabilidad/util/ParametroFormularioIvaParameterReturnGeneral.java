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
import com.bydan.erp.contabilidad.util.ParametroFormularioIvaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroFormularioIva


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFormularioIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFormularioIva parametroformularioiva;	
	protected List<ParametroFormularioIva> parametroformularioivas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoParametroFormularioIva> tipoparametroformularioivasForeignKey;
	public List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey;
	public List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasForeignKey;
	public List<CuentaContable> cuentacontable1sForeignKey;
	public List<CuentaContable> cuentacontable2sForeignKey;
	public List<CuentaContable> cuentacontable3sForeignKey;
	public List<CuentaContable> cuentacontable4sForeignKey;
	public List<CuentaContable> cuentacontable5sForeignKey;
	
	public ParametroFormularioIvaParameterReturnGeneral () throws Exception {						
		super();
		this.parametroformularioivas= new ArrayList<ParametroFormularioIva>();
		this.parametroformularioiva= new ParametroFormularioIva();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoparametroformularioivasForeignKey=new ArrayList<TipoParametroFormularioIva>();
		this.grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
		this.subgrupoparametroformularioivasForeignKey=new ArrayList<SubGrupoParametroFormularioIva>();
		this.cuentacontable1sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontable2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontable3sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontable4sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontable5sForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroFormularioIva getParametroFormularioIva() throws Exception {	
		return parametroformularioiva;
	}
		
	public void setParametroFormularioIva(ParametroFormularioIva newParametroFormularioIva) {
		this.parametroformularioiva = newParametroFormularioIva;
	}
	
	public List<ParametroFormularioIva> getParametroFormularioIvas() throws Exception {		
		return parametroformularioivas;
	}
	
	public void setParametroFormularioIvas(List<ParametroFormularioIva> newParametroFormularioIvas) {
		this.parametroformularioivas = newParametroFormularioIvas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoParametroFormularioIva> gettipoparametroformularioivasForeignKey() {
		return this.tipoparametroformularioivasForeignKey;
	}

	public List<GrupoParametroFormularioIva> getgrupoparametroformularioivasForeignKey() {
		return this.grupoparametroformularioivasForeignKey;
	}

	public List<SubGrupoParametroFormularioIva> getsubgrupoparametroformularioivasForeignKey() {
		return this.subgrupoparametroformularioivasForeignKey;
	}

	public List<CuentaContable> getcuentacontable1sForeignKey() {
		return this.cuentacontable1sForeignKey;
	}

	public List<CuentaContable> getcuentacontable2sForeignKey() {
		return this.cuentacontable2sForeignKey;
	}

	public List<CuentaContable> getcuentacontable3sForeignKey() {
		return this.cuentacontable3sForeignKey;
	}

	public List<CuentaContable> getcuentacontable4sForeignKey() {
		return this.cuentacontable4sForeignKey;
	}

	public List<CuentaContable> getcuentacontable5sForeignKey() {
		return this.cuentacontable5sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoparametroformularioivasForeignKey(List<TipoParametroFormularioIva> tipoparametroformularioivasForeignKey) {
		this.tipoparametroformularioivasForeignKey=tipoparametroformularioivasForeignKey;
	}

	public void setgrupoparametroformularioivasForeignKey(List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey) {
		this.grupoparametroformularioivasForeignKey=grupoparametroformularioivasForeignKey;
	}

	public void setsubgrupoparametroformularioivasForeignKey(List<SubGrupoParametroFormularioIva> subgrupoparametroformularioivasForeignKey) {
		this.subgrupoparametroformularioivasForeignKey=subgrupoparametroformularioivasForeignKey;
	}

	public void setcuentacontable1sForeignKey(List<CuentaContable> cuentacontable1sForeignKey) {
		this.cuentacontable1sForeignKey=cuentacontable1sForeignKey;
	}

	public void setcuentacontable2sForeignKey(List<CuentaContable> cuentacontable2sForeignKey) {
		this.cuentacontable2sForeignKey=cuentacontable2sForeignKey;
	}

	public void setcuentacontable3sForeignKey(List<CuentaContable> cuentacontable3sForeignKey) {
		this.cuentacontable3sForeignKey=cuentacontable3sForeignKey;
	}

	public void setcuentacontable4sForeignKey(List<CuentaContable> cuentacontable4sForeignKey) {
		this.cuentacontable4sForeignKey=cuentacontable4sForeignKey;
	}

	public void setcuentacontable5sForeignKey(List<CuentaContable> cuentacontable5sForeignKey) {
		this.cuentacontable5sForeignKey=cuentacontable5sForeignKey;
	}
}

