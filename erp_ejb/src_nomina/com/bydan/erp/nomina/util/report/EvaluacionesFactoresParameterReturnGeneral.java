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
import com.bydan.erp.nomina.util.report.EvaluacionesFactoresConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//EvaluacionesFactores


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EvaluacionesFactoresParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EvaluacionesFactores evaluacionesfactores;	
	protected List<EvaluacionesFactores> evaluacionesfactoress;
	
	
	public List<TipoCalificacionEmpleado> tipocalificacionempleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey;
	
	public EvaluacionesFactoresParameterReturnGeneral () throws Exception {						
		super();
		this.evaluacionesfactoress= new ArrayList<EvaluacionesFactores>();
		this.evaluacionesfactores= new EvaluacionesFactores();
		
		
		this.tipocalificacionempleadosForeignKey=new ArrayList<TipoCalificacionEmpleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.formatonomipreguntanomisForeignKey=new ArrayList<FormatoNomiPreguntaNomi>();
	} 
	
	public EvaluacionesFactores getEvaluacionesFactores() throws Exception {	
		return evaluacionesfactores;
	}
		
	public void setEvaluacionesFactores(EvaluacionesFactores newEvaluacionesFactores) {
		this.evaluacionesfactores = newEvaluacionesFactores;
	}
	
	public List<EvaluacionesFactores> getEvaluacionesFactoress() throws Exception {		
		return evaluacionesfactoress;
	}
	
	public void setEvaluacionesFactoress(List<EvaluacionesFactores> newEvaluacionesFactoress) {
		this.evaluacionesfactoress = newEvaluacionesFactoress;
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

	public void setformatonomipreguntanomisForeignKey(List<FormatoNomiPreguntaNomi> formatonomipreguntanomisForeignKey) {
		this.formatonomipreguntanomisForeignKey=formatonomipreguntanomisForeignKey;
	}
}

