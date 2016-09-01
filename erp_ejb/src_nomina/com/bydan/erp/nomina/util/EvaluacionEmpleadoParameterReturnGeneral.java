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
import com.bydan.erp.nomina.util.EvaluacionEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EvaluacionEmpleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class EvaluacionEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EvaluacionEmpleado evaluacionempleado;	
	protected List<EvaluacionEmpleado> evaluacionempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Empleado> empleadoevaluasForeignKey;
	public List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Semestre> semestresForeignKey;
	public List<Trimestre> trimestresForeignKey;
	public List<Bimestre> bimestresForeignKey;
	public List<Mes> messForeignKey;
	
	public EvaluacionEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.evaluacionempleados= new ArrayList<EvaluacionEmpleado>();
		this.evaluacionempleado= new EvaluacionEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.empleadoevaluasForeignKey=new ArrayList<Empleado>();
		this.tipoevaluacionempleadosForeignKey=new ArrayList<TipoEvaluacionEmpleado>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.semestresForeignKey=new ArrayList<Semestre>();
		this.trimestresForeignKey=new ArrayList<Trimestre>();
		this.bimestresForeignKey=new ArrayList<Bimestre>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public EvaluacionEmpleado getEvaluacionEmpleado() throws Exception {	
		return evaluacionempleado;
	}
		
	public void setEvaluacionEmpleado(EvaluacionEmpleado newEvaluacionEmpleado) {
		this.evaluacionempleado = newEvaluacionEmpleado;
	}
	
	public List<EvaluacionEmpleado> getEvaluacionEmpleados() throws Exception {		
		return evaluacionempleados;
	}
	
	public void setEvaluacionEmpleados(List<EvaluacionEmpleado> newEvaluacionEmpleados) {
		this.evaluacionempleados = newEvaluacionEmpleados;
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

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Empleado> getempleadoevaluasForeignKey() {
		return this.empleadoevaluasForeignKey;
	}

	public List<TipoEvaluacionEmpleado> gettipoevaluacionempleadosForeignKey() {
		return this.tipoevaluacionempleadosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Semestre> getsemestresForeignKey() {
		return this.semestresForeignKey;
	}

	public List<Trimestre> gettrimestresForeignKey() {
		return this.trimestresForeignKey;
	}

	public List<Bimestre> getbimestresForeignKey() {
		return this.bimestresForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
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

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setempleadoevaluasForeignKey(List<Empleado> empleadoevaluasForeignKey) {
		this.empleadoevaluasForeignKey=empleadoevaluasForeignKey;
	}

	public void settipoevaluacionempleadosForeignKey(List<TipoEvaluacionEmpleado> tipoevaluacionempleadosForeignKey) {
		this.tipoevaluacionempleadosForeignKey=tipoevaluacionempleadosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setsemestresForeignKey(List<Semestre> semestresForeignKey) {
		this.semestresForeignKey=semestresForeignKey;
	}

	public void settrimestresForeignKey(List<Trimestre> trimestresForeignKey) {
		this.trimestresForeignKey=trimestresForeignKey;
	}

	public void setbimestresForeignKey(List<Bimestre> bimestresForeignKey) {
		this.bimestresForeignKey=bimestresForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

