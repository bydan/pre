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
import com.bydan.erp.nomina.util.EvaluacionNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EvaluacionNomi


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class EvaluacionNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EvaluacionNomi evaluacionnomi;	
	protected List<EvaluacionNomi> evaluacionnomis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Empleado> empleadoevaluadorsForeignKey;
	public List<FormatoNomi> formatonomisForeignKey;
	public List<Estructura> estructurasForeignKey;
	
	public EvaluacionNomiParameterReturnGeneral () throws Exception {						
		super();
		this.evaluacionnomis= new ArrayList<EvaluacionNomi>();
		this.evaluacionnomi= new EvaluacionNomi();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.empleadoevaluadorsForeignKey=new ArrayList<Empleado>();
		this.formatonomisForeignKey=new ArrayList<FormatoNomi>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
	} 
	
	public EvaluacionNomi getEvaluacionNomi() throws Exception {	
		return evaluacionnomi;
	}
		
	public void setEvaluacionNomi(EvaluacionNomi newEvaluacionNomi) {
		this.evaluacionnomi = newEvaluacionNomi;
	}
	
	public List<EvaluacionNomi> getEvaluacionNomis() throws Exception {		
		return evaluacionnomis;
	}
	
	public void setEvaluacionNomis(List<EvaluacionNomi> newEvaluacionNomis) {
		this.evaluacionnomis = newEvaluacionNomis;
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

	public List<Empleado> getempleadoevaluadorsForeignKey() {
		return this.empleadoevaluadorsForeignKey;
	}

	public List<FormatoNomi> getformatonomisForeignKey() {
		return this.formatonomisForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
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

	public void setempleadoevaluadorsForeignKey(List<Empleado> empleadoevaluadorsForeignKey) {
		this.empleadoevaluadorsForeignKey=empleadoevaluadorsForeignKey;
	}

	public void setformatonomisForeignKey(List<FormatoNomi> formatonomisForeignKey) {
		this.formatonomisForeignKey=formatonomisForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}
}

