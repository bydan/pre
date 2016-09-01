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
import com.bydan.erp.nomina.util.EmpleadoEnferConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoEnfer


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoEnferParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoEnfer empleadoenfer;	
	protected List<EmpleadoEnfer> empleadoenfers;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Enfermedad> enfermedadsForeignKey;
	
	public EmpleadoEnferParameterReturnGeneral () throws Exception {						
		super();
		this.empleadoenfers= new ArrayList<EmpleadoEnfer>();
		this.empleadoenfer= new EmpleadoEnfer();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.enfermedadsForeignKey=new ArrayList<Enfermedad>();
	} 
	
	public EmpleadoEnfer getEmpleadoEnfer() throws Exception {	
		return empleadoenfer;
	}
		
	public void setEmpleadoEnfer(EmpleadoEnfer newEmpleadoEnfer) {
		this.empleadoenfer = newEmpleadoEnfer;
	}
	
	public List<EmpleadoEnfer> getEmpleadoEnfers() throws Exception {		
		return empleadoenfers;
	}
	
	public void setEmpleadoEnfers(List<EmpleadoEnfer> newEmpleadoEnfers) {
		this.empleadoenfers = newEmpleadoEnfers;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Enfermedad> getenfermedadsForeignKey() {
		return this.enfermedadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setenfermedadsForeignKey(List<Enfermedad> enfermedadsForeignKey) {
		this.enfermedadsForeignKey=enfermedadsForeignKey;
	}
}

