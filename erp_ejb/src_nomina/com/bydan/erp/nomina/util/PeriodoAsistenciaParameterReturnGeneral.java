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
import com.bydan.erp.nomina.util.PeriodoAsistenciaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//PeriodoAsistencia


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class PeriodoAsistenciaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PeriodoAsistencia periodoasistencia;	
	protected List<PeriodoAsistencia> periodoasistencias;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	
	public PeriodoAsistenciaParameterReturnGeneral () throws Exception {						
		super();
		this.periodoasistencias= new ArrayList<PeriodoAsistencia>();
		this.periodoasistencia= new PeriodoAsistencia();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
	} 
	
	public PeriodoAsistencia getPeriodoAsistencia() throws Exception {	
		return periodoasistencia;
	}
		
	public void setPeriodoAsistencia(PeriodoAsistencia newPeriodoAsistencia) {
		this.periodoasistencia = newPeriodoAsistencia;
	}
	
	public List<PeriodoAsistencia> getPeriodoAsistencias() throws Exception {		
		return periodoasistencias;
	}
	
	public void setPeriodoAsistencias(List<PeriodoAsistencia> newPeriodoAsistencias) {
		this.periodoasistencias = newPeriodoAsistencias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
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

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}
}

