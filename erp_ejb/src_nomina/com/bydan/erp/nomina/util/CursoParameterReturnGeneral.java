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
import com.bydan.erp.nomina.util.CursoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Curso


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CursoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Curso curso;	
	protected List<Curso> cursos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoCurso> tipocursosForeignKey;
	public List<TipoInstitucion> tipoinstitucionsForeignKey;
	
	public CursoParameterReturnGeneral () throws Exception {						
		super();
		this.cursos= new ArrayList<Curso>();
		this.curso= new Curso();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipocursosForeignKey=new ArrayList<TipoCurso>();
		this.tipoinstitucionsForeignKey=new ArrayList<TipoInstitucion>();
	} 
	
	public Curso getCurso() throws Exception {	
		return curso;
	}
		
	public void setCurso(Curso newCurso) {
		this.curso = newCurso;
	}
	
	public List<Curso> getCursos() throws Exception {		
		return cursos;
	}
	
	public void setCursos(List<Curso> newCursos) {
		this.cursos = newCursos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoCurso> gettipocursosForeignKey() {
		return this.tipocursosForeignKey;
	}

	public List<TipoInstitucion> gettipoinstitucionsForeignKey() {
		return this.tipoinstitucionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settipocursosForeignKey(List<TipoCurso> tipocursosForeignKey) {
		this.tipocursosForeignKey=tipocursosForeignKey;
	}

	public void settipoinstitucionsForeignKey(List<TipoInstitucion> tipoinstitucionsForeignKey) {
		this.tipoinstitucionsForeignKey=tipoinstitucionsForeignKey;
	}
}

