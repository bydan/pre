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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.PresuAsignacionConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresuAsignacion


import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PresuAsignacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresuAsignacion presuasignacion;	
	protected List<PresuAsignacion> presuasignacions;
	
	
	public List<PresuProyectoCuenta> presuproyectocuentasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<PresuEstado> presuestadosForeignKey;
	
	public PresuAsignacionParameterReturnGeneral () throws Exception {						
		super();
		this.presuasignacions= new ArrayList<PresuAsignacion>();
		this.presuasignacion= new PresuAsignacion();
		
		
		this.presuproyectocuentasForeignKey=new ArrayList<PresuProyectoCuenta>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.presuestadosForeignKey=new ArrayList<PresuEstado>();
	} 
	
	public PresuAsignacion getPresuAsignacion() throws Exception {	
		return presuasignacion;
	}
		
	public void setPresuAsignacion(PresuAsignacion newPresuAsignacion) {
		this.presuasignacion = newPresuAsignacion;
	}
	
	public List<PresuAsignacion> getPresuAsignacions() throws Exception {		
		return presuasignacions;
	}
	
	public void setPresuAsignacions(List<PresuAsignacion> newPresuAsignacions) {
		this.presuasignacions = newPresuAsignacions;
	}
	
	

	public List<PresuProyectoCuenta> getpresuproyectocuentasForeignKey() {
		return this.presuproyectocuentasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<PresuEstado> getpresuestadosForeignKey() {
		return this.presuestadosForeignKey;
	}
	
	

	public void setpresuproyectocuentasForeignKey(List<PresuProyectoCuenta> presuproyectocuentasForeignKey) {
		this.presuproyectocuentasForeignKey=presuproyectocuentasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setpresuestadosForeignKey(List<PresuEstado> presuestadosForeignKey) {
		this.presuestadosForeignKey=presuestadosForeignKey;
	}
}

