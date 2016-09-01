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
import com.bydan.erp.nomina.util.RubroEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//RubroEmpleado


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RubroEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RubroEmpleado rubroempleado;	
	protected List<RubroEmpleado> rubroempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<EstadoRubro> estadorubrosForeignKey;
	
	public RubroEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.rubroempleados= new ArrayList<RubroEmpleado>();
		this.rubroempleado= new RubroEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.estadorubrosForeignKey=new ArrayList<EstadoRubro>();
	} 
	
	public RubroEmpleado getRubroEmpleado() throws Exception {	
		return rubroempleado;
	}
		
	public void setRubroEmpleado(RubroEmpleado newRubroEmpleado) {
		this.rubroempleado = newRubroEmpleado;
	}
	
	public List<RubroEmpleado> getRubroEmpleados() throws Exception {		
		return rubroempleados;
	}
	
	public void setRubroEmpleados(List<RubroEmpleado> newRubroEmpleados) {
		this.rubroempleados = newRubroEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<EstadoRubro> getestadorubrosForeignKey() {
		return this.estadorubrosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setestadorubrosForeignKey(List<EstadoRubro> estadorubrosForeignKey) {
		this.estadorubrosForeignKey=estadorubrosForeignKey;
	}
}

