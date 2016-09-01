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
import com.bydan.erp.nomina.util.EmpleadoHerraConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoHerra


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoHerraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoHerra empleadoherra;	
	protected List<EmpleadoHerra> empleadoherras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Herramienta> herramientasForeignKey;
	
	public EmpleadoHerraParameterReturnGeneral () throws Exception {						
		super();
		this.empleadoherras= new ArrayList<EmpleadoHerra>();
		this.empleadoherra= new EmpleadoHerra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.herramientasForeignKey=new ArrayList<Herramienta>();
	} 
	
	public EmpleadoHerra getEmpleadoHerra() throws Exception {	
		return empleadoherra;
	}
		
	public void setEmpleadoHerra(EmpleadoHerra newEmpleadoHerra) {
		this.empleadoherra = newEmpleadoHerra;
	}
	
	public List<EmpleadoHerra> getEmpleadoHerras() throws Exception {		
		return empleadoherras;
	}
	
	public void setEmpleadoHerras(List<EmpleadoHerra> newEmpleadoHerras) {
		this.empleadoherras = newEmpleadoHerras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Herramienta> getherramientasForeignKey() {
		return this.herramientasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setherramientasForeignKey(List<Herramienta> herramientasForeignKey) {
		this.herramientasForeignKey=herramientasForeignKey;
	}
}

