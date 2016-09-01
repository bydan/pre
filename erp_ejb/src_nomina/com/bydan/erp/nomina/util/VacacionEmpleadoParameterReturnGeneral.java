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
import com.bydan.erp.nomina.util.VacacionEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//VacacionEmpleado


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VacacionEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VacacionEmpleado vacacionempleado;	
	protected List<VacacionEmpleado> vacacionempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Anio> anioperiodo1sForeignKey;
	public List<Anio> anioperiodo2sForeignKey;
	
	public VacacionEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.vacacionempleados= new ArrayList<VacacionEmpleado>();
		this.vacacionempleado= new VacacionEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.anioperiodo1sForeignKey=new ArrayList<Anio>();
		this.anioperiodo2sForeignKey=new ArrayList<Anio>();
	} 
	
	public VacacionEmpleado getVacacionEmpleado() throws Exception {	
		return vacacionempleado;
	}
		
	public void setVacacionEmpleado(VacacionEmpleado newVacacionEmpleado) {
		this.vacacionempleado = newVacacionEmpleado;
	}
	
	public List<VacacionEmpleado> getVacacionEmpleados() throws Exception {		
		return vacacionempleados;
	}
	
	public void setVacacionEmpleados(List<VacacionEmpleado> newVacacionEmpleados) {
		this.vacacionempleados = newVacacionEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Anio> getanioperiodo1sForeignKey() {
		return this.anioperiodo1sForeignKey;
	}

	public List<Anio> getanioperiodo2sForeignKey() {
		return this.anioperiodo2sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setanioperiodo1sForeignKey(List<Anio> anioperiodo1sForeignKey) {
		this.anioperiodo1sForeignKey=anioperiodo1sForeignKey;
	}

	public void setanioperiodo2sForeignKey(List<Anio> anioperiodo2sForeignKey) {
		this.anioperiodo2sForeignKey=anioperiodo2sForeignKey;
	}
}

