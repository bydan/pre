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
import com.bydan.erp.nomina.util.EmpleadoHobbyConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoHobby


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoHobbyParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoHobby empleadohobby;	
	protected List<EmpleadoHobby> empleadohobbys;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Hobby> hobbysForeignKey;
	
	public EmpleadoHobbyParameterReturnGeneral () throws Exception {						
		super();
		this.empleadohobbys= new ArrayList<EmpleadoHobby>();
		this.empleadohobby= new EmpleadoHobby();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.hobbysForeignKey=new ArrayList<Hobby>();
	} 
	
	public EmpleadoHobby getEmpleadoHobby() throws Exception {	
		return empleadohobby;
	}
		
	public void setEmpleadoHobby(EmpleadoHobby newEmpleadoHobby) {
		this.empleadohobby = newEmpleadoHobby;
	}
	
	public List<EmpleadoHobby> getEmpleadoHobbys() throws Exception {		
		return empleadohobbys;
	}
	
	public void setEmpleadoHobbys(List<EmpleadoHobby> newEmpleadoHobbys) {
		this.empleadohobbys = newEmpleadoHobbys;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Hobby> gethobbysForeignKey() {
		return this.hobbysForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void sethobbysForeignKey(List<Hobby> hobbysForeignKey) {
		this.hobbysForeignKey=hobbysForeignKey;
	}
}

