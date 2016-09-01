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
import com.bydan.erp.nomina.util.EmpleadoEstructuraConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EmpleadoEstructura


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoEstructuraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpleadoEstructura empleadoestructura;	
	protected List<EmpleadoEstructura> empleadoestructuras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Cargo> cargosForeignKey;
	
	public EmpleadoEstructuraParameterReturnGeneral () throws Exception {						
		super();
		this.empleadoestructuras= new ArrayList<EmpleadoEstructura>();
		this.empleadoestructura= new EmpleadoEstructura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.cargosForeignKey=new ArrayList<Cargo>();
	} 
	
	public EmpleadoEstructura getEmpleadoEstructura() throws Exception {	
		return empleadoestructura;
	}
		
	public void setEmpleadoEstructura(EmpleadoEstructura newEmpleadoEstructura) {
		this.empleadoestructura = newEmpleadoEstructura;
	}
	
	public List<EmpleadoEstructura> getEmpleadoEstructuras() throws Exception {		
		return empleadoestructuras;
	}
	
	public void setEmpleadoEstructuras(List<EmpleadoEstructura> newEmpleadoEstructuras) {
		this.empleadoestructuras = newEmpleadoEstructuras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Cargo> getcargosForeignKey() {
		return this.cargosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setcargosForeignKey(List<Cargo> cargosForeignKey) {
		this.cargosForeignKey=cargosForeignKey;
	}
}

