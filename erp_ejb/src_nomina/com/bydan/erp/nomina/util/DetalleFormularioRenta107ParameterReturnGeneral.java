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
import com.bydan.erp.nomina.util.DetalleFormularioRenta107ConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DetalleFormularioRenta107


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleFormularioRenta107ParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleFormularioRenta107 detalleformulariorenta107;	
	protected List<DetalleFormularioRenta107> detalleformulariorenta107s;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<FormularioRenta107> formulariorenta107sForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	
	public DetalleFormularioRenta107ParameterReturnGeneral () throws Exception {						
		super();
		this.detalleformulariorenta107s= new ArrayList<DetalleFormularioRenta107>();
		this.detalleformulariorenta107= new DetalleFormularioRenta107();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.formulariorenta107sForeignKey=new ArrayList<FormularioRenta107>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
	} 
	
	public DetalleFormularioRenta107 getDetalleFormularioRenta107() throws Exception {	
		return detalleformulariorenta107;
	}
		
	public void setDetalleFormularioRenta107(DetalleFormularioRenta107 newDetalleFormularioRenta107) {
		this.detalleformulariorenta107 = newDetalleFormularioRenta107;
	}
	
	public List<DetalleFormularioRenta107> getDetalleFormularioRenta107s() throws Exception {		
		return detalleformulariorenta107s;
	}
	
	public void setDetalleFormularioRenta107s(List<DetalleFormularioRenta107> newDetalleFormularioRenta107s) {
		this.detalleformulariorenta107s = newDetalleFormularioRenta107s;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<FormularioRenta107> getformulariorenta107sForeignKey() {
		return this.formulariorenta107sForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setformulariorenta107sForeignKey(List<FormularioRenta107> formulariorenta107sForeignKey) {
		this.formulariorenta107sForeignKey=formulariorenta107sForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}
}

