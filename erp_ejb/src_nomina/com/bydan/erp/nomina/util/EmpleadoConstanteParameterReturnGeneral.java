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
import com.bydan.erp.nomina.util.EmpleadoConstanteConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoConstante


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoConstanteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoConstante empleadoconstante;	
	protected List<EmpleadoConstante> empleadoconstantes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<ConstanteNomi> constantenomisForeignKey;
	
	public EmpleadoConstanteParameterReturnGeneral () throws Exception {						
		super();
		this.empleadoconstantes= new ArrayList<EmpleadoConstante>();
		this.empleadoconstante= new EmpleadoConstante();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.constantenomisForeignKey=new ArrayList<ConstanteNomi>();
	} 
	
	public EmpleadoConstante getEmpleadoConstante() throws Exception {	
		return empleadoconstante;
	}
		
	public void setEmpleadoConstante(EmpleadoConstante newEmpleadoConstante) {
		this.empleadoconstante = newEmpleadoConstante;
	}
	
	public List<EmpleadoConstante> getEmpleadoConstantes() throws Exception {		
		return empleadoconstantes;
	}
	
	public void setEmpleadoConstantes(List<EmpleadoConstante> newEmpleadoConstantes) {
		this.empleadoconstantes = newEmpleadoConstantes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<ConstanteNomi> getconstantenomisForeignKey() {
		return this.constantenomisForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setconstantenomisForeignKey(List<ConstanteNomi> constantenomisForeignKey) {
		this.constantenomisForeignKey=constantenomisForeignKey;
	}
}

