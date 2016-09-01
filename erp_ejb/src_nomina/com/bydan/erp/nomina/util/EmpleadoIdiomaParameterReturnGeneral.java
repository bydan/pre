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
import com.bydan.erp.nomina.util.EmpleadoIdiomaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoIdioma


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoIdiomaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoIdioma empleadoidioma;	
	protected List<EmpleadoIdioma> empleadoidiomas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Idioma> idiomasForeignKey;
	
	public EmpleadoIdiomaParameterReturnGeneral () throws Exception {						
		super();
		this.empleadoidiomas= new ArrayList<EmpleadoIdioma>();
		this.empleadoidioma= new EmpleadoIdioma();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.idiomasForeignKey=new ArrayList<Idioma>();
	} 
	
	public EmpleadoIdioma getEmpleadoIdioma() throws Exception {	
		return empleadoidioma;
	}
		
	public void setEmpleadoIdioma(EmpleadoIdioma newEmpleadoIdioma) {
		this.empleadoidioma = newEmpleadoIdioma;
	}
	
	public List<EmpleadoIdioma> getEmpleadoIdiomas() throws Exception {		
		return empleadoidiomas;
	}
	
	public void setEmpleadoIdiomas(List<EmpleadoIdioma> newEmpleadoIdiomas) {
		this.empleadoidiomas = newEmpleadoIdiomas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Idioma> getidiomasForeignKey() {
		return this.idiomasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setidiomasForeignKey(List<Idioma> idiomasForeignKey) {
		this.idiomasForeignKey=idiomasForeignKey;
	}
}

