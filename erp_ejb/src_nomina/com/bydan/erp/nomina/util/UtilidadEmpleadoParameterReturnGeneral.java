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
import com.bydan.erp.nomina.util.UtilidadEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//UtilidadEmpleado


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class UtilidadEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected UtilidadEmpleado utilidadempleado;	
	protected List<UtilidadEmpleado> utilidadempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Anio> aniosForeignKey;
	
	public UtilidadEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.utilidadempleados= new ArrayList<UtilidadEmpleado>();
		this.utilidadempleado= new UtilidadEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.aniosForeignKey=new ArrayList<Anio>();
	} 
	
	public UtilidadEmpleado getUtilidadEmpleado() throws Exception {	
		return utilidadempleado;
	}
		
	public void setUtilidadEmpleado(UtilidadEmpleado newUtilidadEmpleado) {
		this.utilidadempleado = newUtilidadEmpleado;
	}
	
	public List<UtilidadEmpleado> getUtilidadEmpleados() throws Exception {		
		return utilidadempleados;
	}
	
	public void setUtilidadEmpleados(List<UtilidadEmpleado> newUtilidadEmpleados) {
		this.utilidadempleados = newUtilidadEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}
}

