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
package com.bydan.erp.seguridad.util;

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
import com.bydan.erp.seguridad.util.ParametroGeneralUsuarioConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//ParametroGeneralUsuario


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroGeneralUsuarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroGeneralUsuario parametrogeneralusuario;	
	protected List<ParametroGeneralUsuario> parametrogeneralusuarios;
	
	
	public List<Usuario> usuariosForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<TipoVisual> tipovisualsForeignKey;
	public List<TipoFondo> tipofondosForeignKey;
	public List<TipoFondo> tipofondobordesForeignKey;
	public List<TipoFondoControl> tipofondocontrolsForeignKey;
	public List<TipoFuente> tipofuentesForeignKey;
	public List<TipoTamanioControl> tipotamaniocontrolnormalsForeignKey;
	public List<TipoTamanioControl> tipotamaniocontrolrelacionsForeignKey;
	public List<TipoExportar> tipoexportarsForeignKey;
	public List<TipoDelimiter> tipodelimitersForeignKey;
	
	public ParametroGeneralUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.parametrogeneralusuarios= new ArrayList<ParametroGeneralUsuario>();
		this.parametrogeneralusuario= new ParametroGeneralUsuario();
		
		
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.tipovisualsForeignKey=new ArrayList<TipoVisual>();
		this.tipofondosForeignKey=new ArrayList<TipoFondo>();
		this.tipofondobordesForeignKey=new ArrayList<TipoFondo>();
		this.tipofondocontrolsForeignKey=new ArrayList<TipoFondoControl>();
		this.tipofuentesForeignKey=new ArrayList<TipoFuente>();
		this.tipotamaniocontrolnormalsForeignKey=new ArrayList<TipoTamanioControl>();
		this.tipotamaniocontrolrelacionsForeignKey=new ArrayList<TipoTamanioControl>();
		this.tipoexportarsForeignKey=new ArrayList<TipoExportar>();
		this.tipodelimitersForeignKey=new ArrayList<TipoDelimiter>();
	} 
	
	public ParametroGeneralUsuario getParametroGeneralUsuario() throws Exception {	
		return parametrogeneralusuario;
	}
		
	public void setParametroGeneralUsuario(ParametroGeneralUsuario newParametroGeneralUsuario) {
		this.parametrogeneralusuario = newParametroGeneralUsuario;
	}
	
	public List<ParametroGeneralUsuario> getParametroGeneralUsuarios() throws Exception {		
		return parametrogeneralusuarios;
	}
	
	public void setParametroGeneralUsuarios(List<ParametroGeneralUsuario> newParametroGeneralUsuarios) {
		this.parametrogeneralusuarios = newParametroGeneralUsuarios;
	}
	
	

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<TipoVisual> gettipovisualsForeignKey() {
		return this.tipovisualsForeignKey;
	}

	public List<TipoFondo> gettipofondosForeignKey() {
		return this.tipofondosForeignKey;
	}

	public List<TipoFondo> gettipofondobordesForeignKey() {
		return this.tipofondobordesForeignKey;
	}

	public List<TipoFondoControl> gettipofondocontrolsForeignKey() {
		return this.tipofondocontrolsForeignKey;
	}

	public List<TipoFuente> gettipofuentesForeignKey() {
		return this.tipofuentesForeignKey;
	}

	public List<TipoTamanioControl> gettipotamaniocontrolnormalsForeignKey() {
		return this.tipotamaniocontrolnormalsForeignKey;
	}

	public List<TipoTamanioControl> gettipotamaniocontrolrelacionsForeignKey() {
		return this.tipotamaniocontrolrelacionsForeignKey;
	}

	public List<TipoExportar> gettipoexportarsForeignKey() {
		return this.tipoexportarsForeignKey;
	}

	public List<TipoDelimiter> gettipodelimitersForeignKey() {
		return this.tipodelimitersForeignKey;
	}
	
	

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void settipovisualsForeignKey(List<TipoVisual> tipovisualsForeignKey) {
		this.tipovisualsForeignKey=tipovisualsForeignKey;
	}

	public void settipofondosForeignKey(List<TipoFondo> tipofondosForeignKey) {
		this.tipofondosForeignKey=tipofondosForeignKey;
	}

	public void settipofondobordesForeignKey(List<TipoFondo> tipofondobordesForeignKey) {
		this.tipofondobordesForeignKey=tipofondobordesForeignKey;
	}

	public void settipofondocontrolsForeignKey(List<TipoFondoControl> tipofondocontrolsForeignKey) {
		this.tipofondocontrolsForeignKey=tipofondocontrolsForeignKey;
	}

	public void settipofuentesForeignKey(List<TipoFuente> tipofuentesForeignKey) {
		this.tipofuentesForeignKey=tipofuentesForeignKey;
	}

	public void settipotamaniocontrolnormalsForeignKey(List<TipoTamanioControl> tipotamaniocontrolnormalsForeignKey) {
		this.tipotamaniocontrolnormalsForeignKey=tipotamaniocontrolnormalsForeignKey;
	}

	public void settipotamaniocontrolrelacionsForeignKey(List<TipoTamanioControl> tipotamaniocontrolrelacionsForeignKey) {
		this.tipotamaniocontrolrelacionsForeignKey=tipotamaniocontrolrelacionsForeignKey;
	}

	public void settipoexportarsForeignKey(List<TipoExportar> tipoexportarsForeignKey) {
		this.tipoexportarsForeignKey=tipoexportarsForeignKey;
	}

	public void settipodelimitersForeignKey(List<TipoDelimiter> tipodelimitersForeignKey) {
		this.tipodelimitersForeignKey=tipodelimitersForeignKey;
	}
}

