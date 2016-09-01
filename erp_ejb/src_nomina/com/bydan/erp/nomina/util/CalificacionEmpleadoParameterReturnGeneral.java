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
import com.bydan.erp.nomina.util.CalificacionEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//CalificacionEmpleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CalificacionEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CalificacionEmpleado calificacionempleado;	
	protected List<CalificacionEmpleado> calificacionempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<EvaluacionEmpleado> evaluacionempleadosForeignKey;
	public List<FormatoNomiFactorNomi> formatonomifactornomisForeignKey;
	public List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey;
	public List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey;
	
	public CalificacionEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.calificacionempleados= new ArrayList<CalificacionEmpleado>();
		this.calificacionempleado= new CalificacionEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.evaluacionempleadosForeignKey=new ArrayList<EvaluacionEmpleado>();
		this.formatonomifactornomisForeignKey=new ArrayList<FormatoNomiFactorNomi>();
		this.formatonomipreguntanomisForeignKey=new ArrayList<FormatoNomiPreguntaNomi>();
		this.tipocalificacionempleadosForeignKey=new ArrayList<TipoCalificacionEmpleado>();
	} 
	
	public CalificacionEmpleado getCalificacionEmpleado() throws Exception {	
		return calificacionempleado;
	}
		
	public void setCalificacionEmpleado(CalificacionEmpleado newCalificacionEmpleado) {
		this.calificacionempleado = newCalificacionEmpleado;
	}
	
	public List<CalificacionEmpleado> getCalificacionEmpleados() throws Exception {		
		return calificacionempleados;
	}
	
	public void setCalificacionEmpleados(List<CalificacionEmpleado> newCalificacionEmpleados) {
		this.calificacionempleados = newCalificacionEmpleados;
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

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<EvaluacionEmpleado> getevaluacionempleadosForeignKey() {
		return this.evaluacionempleadosForeignKey;
	}

	public List<FormatoNomiFactorNomi> getformatonomifactornomisForeignKey() {
		return this.formatonomifactornomisForeignKey;
	}

	public List<FormatoNomiPreguntaNomi> getformatonomipreguntanomisForeignKey() {
		return this.formatonomipreguntanomisForeignKey;
	}

	public List<TipoCalificacionEmpleado> gettipocalificacionempleadosForeignKey() {
		return this.tipocalificacionempleadosForeignKey;
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

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setevaluacionempleadosForeignKey(List<EvaluacionEmpleado> evaluacionempleadosForeignKey) {
		this.evaluacionempleadosForeignKey=evaluacionempleadosForeignKey;
	}

	public void setformatonomifactornomisForeignKey(List<FormatoNomiFactorNomi> formatonomifactornomisForeignKey) {
		this.formatonomifactornomisForeignKey=formatonomifactornomisForeignKey;
	}

	public void setformatonomipreguntanomisForeignKey(List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey) {
		this.formatonomipreguntanomisForeignKey=formatonomipreguntanomisForeignKey;
	}

	public void settipocalificacionempleadosForeignKey(List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey) {
		this.tipocalificacionempleadosForeignKey=tipocalificacionempleadosForeignKey;
	}
}

