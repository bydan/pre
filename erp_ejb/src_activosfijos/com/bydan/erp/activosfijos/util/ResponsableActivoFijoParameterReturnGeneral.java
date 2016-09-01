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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.ResponsableActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//ResponsableActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ResponsableActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ResponsableActivoFijo responsableactivofijo;	
	protected List<ResponsableActivoFijo> responsableactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empleado> empleadosForeignKey;
	
	public ResponsableActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.responsableactivofijos= new ArrayList<ResponsableActivoFijo>();
		this.responsableactivofijo= new ResponsableActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public ResponsableActivoFijo getResponsableActivoFijo() throws Exception {	
		return responsableactivofijo;
	}
		
	public void setResponsableActivoFijo(ResponsableActivoFijo newResponsableActivoFijo) {
		this.responsableactivofijo = newResponsableActivoFijo;
	}
	
	public List<ResponsableActivoFijo> getResponsableActivoFijos() throws Exception {		
		return responsableactivofijos;
	}
	
	public void setResponsableActivoFijos(List<ResponsableActivoFijo> newResponsableActivoFijos) {
		this.responsableactivofijos = newResponsableActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijosForeignKey() {
		return this.detalleactivofijosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setdetalleactivofijosForeignKey(List<DetalleActivoFijo> detalleactivofijosForeignKey) {
		this.detalleactivofijosForeignKey=detalleactivofijosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

