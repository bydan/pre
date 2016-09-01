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
import com.bydan.erp.nomina.util.EmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Empleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class EmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Empleado empleado;	
	protected List<Empleado> empleados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Religion> religionsForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<TipoEmpleado> tipoempleadosForeignKey;
	public List<TipoInstruccion> tipoinstruccionsForeignKey;
	public List<Cargo> cargosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Estructura> estructuraseccionsForeignKey;
	public List<EstadoEmpleado> estadoempleadosForeignKey;
	public List<TipoContrato> tipocontratosForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	
	public EmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.empleados= new ArrayList<Empleado>();
		this.empleado= new Empleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.religionsForeignKey=new ArrayList<Religion>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.tipoempleadosForeignKey=new ArrayList<TipoEmpleado>();
		this.tipoinstruccionsForeignKey=new ArrayList<TipoInstruccion>();
		this.cargosForeignKey=new ArrayList<Cargo>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.estructuraseccionsForeignKey=new ArrayList<Estructura>();
		this.estadoempleadosForeignKey=new ArrayList<EstadoEmpleado>();
		this.tipocontratosForeignKey=new ArrayList<TipoContrato>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
	} 
	
	public Empleado getEmpleado() throws Exception {	
		return empleado;
	}
		
	public void setEmpleado(Empleado newEmpleado) {
		this.empleado = newEmpleado;
	}
	
	public List<Empleado> getEmpleados() throws Exception {		
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> newEmpleados) {
		this.empleados = newEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Religion> getreligionsForeignKey() {
		return this.religionsForeignKey;
	}

	public List<EstadoCivil> getestadocivilsForeignKey() {
		return this.estadocivilsForeignKey;
	}

	public List<TipoGenero> gettipogenerosForeignKey() {
		return this.tipogenerosForeignKey;
	}

	public List<TipoEmpleado> gettipoempleadosForeignKey() {
		return this.tipoempleadosForeignKey;
	}

	public List<TipoInstruccion> gettipoinstruccionsForeignKey() {
		return this.tipoinstruccionsForeignKey;
	}

	public List<Cargo> getcargosForeignKey() {
		return this.cargosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Estructura> getestructuraseccionsForeignKey() {
		return this.estructuraseccionsForeignKey;
	}

	public List<EstadoEmpleado> getestadoempleadosForeignKey() {
		return this.estadoempleadosForeignKey;
	}

	public List<TipoContrato> gettipocontratosForeignKey() {
		return this.tipocontratosForeignKey;
	}

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setreligionsForeignKey(List<Religion> religionsForeignKey) {
		this.religionsForeignKey=religionsForeignKey;
	}

	public void setestadocivilsForeignKey(List<EstadoCivil> estadocivilsForeignKey) {
		this.estadocivilsForeignKey=estadocivilsForeignKey;
	}

	public void settipogenerosForeignKey(List<TipoGenero> tipogenerosForeignKey) {
		this.tipogenerosForeignKey=tipogenerosForeignKey;
	}

	public void settipoempleadosForeignKey(List<TipoEmpleado> tipoempleadosForeignKey) {
		this.tipoempleadosForeignKey=tipoempleadosForeignKey;
	}

	public void settipoinstruccionsForeignKey(List<TipoInstruccion> tipoinstruccionsForeignKey) {
		this.tipoinstruccionsForeignKey=tipoinstruccionsForeignKey;
	}

	public void setcargosForeignKey(List<Cargo> cargosForeignKey) {
		this.cargosForeignKey=cargosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setestructuraseccionsForeignKey(List<Estructura> estructuraseccionsForeignKey) {
		this.estructuraseccionsForeignKey=estructuraseccionsForeignKey;
	}

	public void setestadoempleadosForeignKey(List<EstadoEmpleado> estadoempleadosForeignKey) {
		this.estadoempleadosForeignKey=estadoempleadosForeignKey;
	}

	public void settipocontratosForeignKey(List<TipoContrato> tipocontratosForeignKey) {
		this.tipocontratosForeignKey=tipocontratosForeignKey;
	}

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}
}

