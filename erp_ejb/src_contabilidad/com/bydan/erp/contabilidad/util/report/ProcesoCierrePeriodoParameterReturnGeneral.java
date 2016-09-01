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
package com.bydan.erp.contabilidad.util.report;

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
import com.bydan.erp.contabilidad.util.report.ProcesoCierrePeriodoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//ProcesoCierrePeriodo


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCierrePeriodoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCierrePeriodo procesocierreperiodo;	
	protected List<ProcesoCierrePeriodo> procesocierreperiodos;
	
	
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<EstadoPeriodo> estadoperiodosForeignKey;
	
	public ProcesoCierrePeriodoParameterReturnGeneral () throws Exception {						
		super();
		this.procesocierreperiodos= new ArrayList<ProcesoCierrePeriodo>();
		this.procesocierreperiodo= new ProcesoCierrePeriodo();
		
		
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.estadoperiodosForeignKey=new ArrayList<EstadoPeriodo>();
	} 
	
	public ProcesoCierrePeriodo getProcesoCierrePeriodo() throws Exception {	
		return procesocierreperiodo;
	}
		
	public void setProcesoCierrePeriodo(ProcesoCierrePeriodo newProcesoCierrePeriodo) {
		this.procesocierreperiodo = newProcesoCierrePeriodo;
	}
	
	public List<ProcesoCierrePeriodo> getProcesoCierrePeriodos() throws Exception {		
		return procesocierreperiodos;
	}
	
	public void setProcesoCierrePeriodos(List<ProcesoCierrePeriodo> newProcesoCierrePeriodos) {
		this.procesocierreperiodos = newProcesoCierrePeriodos;
	}
	
	

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<EstadoPeriodo> getestadoperiodosForeignKey() {
		return this.estadoperiodosForeignKey;
	}
	
	

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setestadoperiodosForeignKey(List<EstadoPeriodo> estadoperiodosForeignKey) {
		this.estadoperiodosForeignKey=estadoperiodosForeignKey;
	}
}

