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
import com.bydan.erp.contabilidad.util.PeriodoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//Periodo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PeriodoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Periodo periodo;	
	protected List<Periodo> periodos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Mes> messForeignKey;
	public List<EstadoPeriodo> estadoperiodosForeignKey;
	
	public PeriodoParameterReturnGeneral () throws Exception {						
		super();
		this.periodos= new ArrayList<Periodo>();
		this.periodo= new Periodo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.estadoperiodosForeignKey=new ArrayList<EstadoPeriodo>();
	} 
	
	public Periodo getPeriodo() throws Exception {	
		return periodo;
	}
		
	public void setPeriodo(Periodo newPeriodo) {
		this.periodo = newPeriodo;
	}
	
	public List<Periodo> getPeriodos() throws Exception {		
		return periodos;
	}
	
	public void setPeriodos(List<Periodo> newPeriodos) {
		this.periodos = newPeriodos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<EstadoPeriodo> getestadoperiodosForeignKey() {
		return this.estadoperiodosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setestadoperiodosForeignKey(List<EstadoPeriodo> estadoperiodosForeignKey) {
		this.estadoperiodosForeignKey=estadoperiodosForeignKey;
	}
}

