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
package com.bydan.erp.comisiones.util;

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
import com.bydan.erp.comisiones.util.VendedorConstantesFunciones;

import com.bydan.erp.comisiones.business.entity.*;//Vendedor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class VendedorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Vendedor vendedor;	
	protected List<Vendedor> vendedors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Empleado> empleadosoportesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	
	public VendedorParameterReturnGeneral () throws Exception {						
		super();
		this.vendedors= new ArrayList<Vendedor>();
		this.vendedor= new Vendedor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.empleadosoportesForeignKey=new ArrayList<Empleado>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
	} 
	
	public Vendedor getVendedor() throws Exception {	
		return vendedor;
	}
		
	public void setVendedor(Vendedor newVendedor) {
		this.vendedor = newVendedor;
	}
	
	public List<Vendedor> getVendedors() throws Exception {		
		return vendedors;
	}
	
	public void setVendedors(List<Vendedor> newVendedors) {
		this.vendedors = newVendedors;
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

	public List<Empleado> getempleadosoportesForeignKey() {
		return this.empleadosoportesForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<Zona> getzonasForeignKey() {
		return this.zonasForeignKey;
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

	public void setempleadosoportesForeignKey(List<Empleado> empleadosoportesForeignKey) {
		this.empleadosoportesForeignKey=empleadosoportesForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setzonasForeignKey(List<Zona> zonasForeignKey) {
		this.zonasForeignKey=zonasForeignKey;
	}
}

