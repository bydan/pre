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
import com.bydan.erp.nomina.util.report.ProcesoCierreProvisionConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoCierreProvision


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCierreProvisionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCierreProvision procesocierreprovision;	
	protected List<ProcesoCierreProvision> procesocierreprovisions;
	
	
	public List<Anio> aniosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey;
	
	public ProcesoCierreProvisionParameterReturnGeneral () throws Exception {						
		super();
		this.procesocierreprovisions= new ArrayList<ProcesoCierreProvision>();
		this.procesocierreprovision= new ProcesoCierreProvision();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
	} 
	
	public ProcesoCierreProvision getProcesoCierreProvision() throws Exception {	
		return procesocierreprovision;
	}
		
	public void setProcesoCierreProvision(ProcesoCierreProvision newProcesoCierreProvision) {
		this.procesocierreprovision = newProcesoCierreProvision;
	}
	
	public List<ProcesoCierreProvision> getProcesoCierreProvisions() throws Exception {		
		return procesocierreprovisions;
	}
	
	public void setProcesoCierreProvisions(List<ProcesoCierreProvision> newProcesoCierreProvisions) {
		this.procesocierreprovisions = newProcesoCierreProvisions;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<DefiProvisionEmpleado> getdefiprovisionempleadosForeignKey() {
		return this.defiprovisionempleadosForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setdefiprovisionempleadosForeignKey(List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey) {
		this.defiprovisionempleadosForeignKey=defiprovisionempleadosForeignKey;
	}
}

