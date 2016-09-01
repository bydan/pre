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
import com.bydan.erp.nomina.util.ProfesionEmpleaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//ProfesionEmplea


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProfesionEmpleaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProfesionEmplea profesionemplea;	
	protected List<ProfesionEmplea> profesionempleas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Profesion> profesionsForeignKey;
	
	public ProfesionEmpleaParameterReturnGeneral () throws Exception {						
		super();
		this.profesionempleas= new ArrayList<ProfesionEmplea>();
		this.profesionemplea= new ProfesionEmplea();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.profesionsForeignKey=new ArrayList<Profesion>();
	} 
	
	public ProfesionEmplea getProfesionEmplea() throws Exception {	
		return profesionemplea;
	}
		
	public void setProfesionEmplea(ProfesionEmplea newProfesionEmplea) {
		this.profesionemplea = newProfesionEmplea;
	}
	
	public List<ProfesionEmplea> getProfesionEmpleas() throws Exception {		
		return profesionempleas;
	}
	
	public void setProfesionEmpleas(List<ProfesionEmplea> newProfesionEmpleas) {
		this.profesionempleas = newProfesionEmpleas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Profesion> getprofesionsForeignKey() {
		return this.profesionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setprofesionsForeignKey(List<Profesion> profesionsForeignKey) {
		this.profesionsForeignKey=profesionsForeignKey;
	}
}

