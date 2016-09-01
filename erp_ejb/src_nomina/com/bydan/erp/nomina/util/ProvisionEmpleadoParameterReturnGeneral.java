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
import com.bydan.erp.nomina.util.ProvisionEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//ProvisionEmpleado


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProvisionEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProvisionEmpleado provisionempleado;	
	protected List<ProvisionEmpleado> provisionempleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<TipoProvisionEmpleado> tipoprovisionempleadosForeignKey;
	public List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public ProvisionEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.provisionempleados= new ArrayList<ProvisionEmpleado>();
		this.provisionempleado= new ProvisionEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.tipoprovisionempleadosForeignKey=new ArrayList<TipoProvisionEmpleado>();
		this.defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public ProvisionEmpleado getProvisionEmpleado() throws Exception {	
		return provisionempleado;
	}
		
	public void setProvisionEmpleado(ProvisionEmpleado newProvisionEmpleado) {
		this.provisionempleado = newProvisionEmpleado;
	}
	
	public List<ProvisionEmpleado> getProvisionEmpleados() throws Exception {		
		return provisionempleados;
	}
	
	public void setProvisionEmpleados(List<ProvisionEmpleado> newProvisionEmpleados) {
		this.provisionempleados = newProvisionEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<TipoProvisionEmpleado> gettipoprovisionempleadosForeignKey() {
		return this.tipoprovisionempleadosForeignKey;
	}

	public List<DefiProvisionEmpleado> getdefiprovisionempleadosForeignKey() {
		return this.defiprovisionempleadosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void settipoprovisionempleadosForeignKey(List<TipoProvisionEmpleado> tipoprovisionempleadosForeignKey) {
		this.tipoprovisionempleadosForeignKey=tipoprovisionempleadosForeignKey;
	}

	public void setdefiprovisionempleadosForeignKey(List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey) {
		this.defiprovisionempleadosForeignKey=defiprovisionempleadosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

