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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.EvaluacionesPeriodosConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//EvaluacionesPeriodos


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class EvaluacionesPeriodosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EvaluacionesPeriodos evaluacionesperiodos;	
	protected List<EvaluacionesPeriodos> evaluacionesperiodoss;
	
	
	public List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey;
	public List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey;
	
	public EvaluacionesPeriodosParameterReturnGeneral () throws Exception {						
		super();
		this.evaluacionesperiodoss= new ArrayList<EvaluacionesPeriodos>();
		this.evaluacionesperiodos= new EvaluacionesPeriodos();
		
		
		this.tipocalificacionempleadosForeignKey=new ArrayList<TipoCalificacionEmpleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.tipoevaluacionempleadosForeignKey=new ArrayList<TipoEvaluacionEmpleado>();
		this.formatonomipreguntanomisForeignKey=new ArrayList<FormatoNomiPreguntaNomi>();
	} 
	
	public EvaluacionesPeriodos getEvaluacionesPeriodos() throws Exception {	
		return evaluacionesperiodos;
	}
		
	public void setEvaluacionesPeriodos(EvaluacionesPeriodos newEvaluacionesPeriodos) {
		this.evaluacionesperiodos = newEvaluacionesPeriodos;
	}
	
	public List<EvaluacionesPeriodos> getEvaluacionesPeriodoss() throws Exception {		
		return evaluacionesperiodoss;
	}
	
	public void setEvaluacionesPeriodoss(List<EvaluacionesPeriodos> newEvaluacionesPeriodoss) {
		this.evaluacionesperiodoss = newEvaluacionesPeriodoss;
	}
	
	

	public List<TipoCalificacionEmpleado> gettipocalificacionempleadosForeignKey() {
		return this.tipocalificacionempleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
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

	public List<TipoEvaluacionEmpleado> gettipoevaluacionempleadosForeignKey() {
		return this.tipoevaluacionempleadosForeignKey;
	}

	public List<FormatoNomiPreguntaNomi> getformatonomipreguntanomisForeignKey() {
		return this.formatonomipreguntanomisForeignKey;
	}
	
	

	public void settipocalificacionempleadosForeignKey(List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey) {
		this.tipocalificacionempleadosForeignKey=tipocalificacionempleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
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

	public void settipoevaluacionempleadosForeignKey(List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey) {
		this.tipoevaluacionempleadosForeignKey=tipoevaluacionempleadosForeignKey;
	}

	public void setformatonomipreguntanomisForeignKey(List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey) {
		this.formatonomipreguntanomisForeignKey=formatonomipreguntanomisForeignKey;
	}
}

