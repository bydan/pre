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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.SubPreguntaEvaluacionConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//SubPreguntaEvaluacion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SubPreguntaEvaluacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SubPreguntaEvaluacion subpreguntaevaluacion;	
	protected List<SubPreguntaEvaluacion> subpreguntaevaluacions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<PreguntaEvaluacion> preguntaevaluacionsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	
	public SubPreguntaEvaluacionParameterReturnGeneral () throws Exception {						
		super();
		this.subpreguntaevaluacions= new ArrayList<SubPreguntaEvaluacion>();
		this.subpreguntaevaluacion= new SubPreguntaEvaluacion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
	} 
	
	public SubPreguntaEvaluacion getSubPreguntaEvaluacion() throws Exception {	
		return subpreguntaevaluacion;
	}
		
	public void setSubPreguntaEvaluacion(SubPreguntaEvaluacion newSubPreguntaEvaluacion) {
		this.subpreguntaevaluacion = newSubPreguntaEvaluacion;
	}
	
	public List<SubPreguntaEvaluacion> getSubPreguntaEvaluacions() throws Exception {		
		return subpreguntaevaluacions;
	}
	
	public void setSubPreguntaEvaluacions(List<SubPreguntaEvaluacion> newSubPreguntaEvaluacions) {
		this.subpreguntaevaluacions = newSubPreguntaEvaluacions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<PreguntaEvaluacion> getpreguntaevaluacionsForeignKey() {
		return this.preguntaevaluacionsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setpreguntaevaluacionsForeignKey(List<PreguntaEvaluacion> preguntaevaluacionsForeignKey) {
		this.preguntaevaluacionsForeignKey=preguntaevaluacionsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}
}

