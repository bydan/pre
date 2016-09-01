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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.ParametroFactuEmpresaConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFactuEmpresa


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFactuEmpresaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFactuEmpresa parametrofactuempresa;	
	protected List<ParametroFactuEmpresa> parametrofactuempresas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empresa> empresaorigensForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Transaccion> transaccionorigensForeignKey;
	public List<Bodega> bodegaorigensForeignKey;
	public List<Cliente> clienteorigensForeignKey;
	public List<Empresa> empresadestinosForeignKey;
	public List<Sucursal> sucursaldestinosForeignKey;
	public List<Transaccion> transacciondestinosForeignKey;
	public List<Bodega> bodegadestinosForeignKey;
	public List<Cliente> clientedestinosForeignKey;
	public List<Empresa> empresamultidestinosForeignKey;
	public List<Sucursal> sucursalmultidestinosForeignKey;
	public List<Transaccion> transaccionmultidestinosForeignKey;
	public List<Bodega> bodegamultiorigensForeignKey;
	public List<Bodega> bodegamultidestinosForeignKey;
	
	public ParametroFactuEmpresaParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofactuempresas= new ArrayList<ParametroFactuEmpresa>();
		this.parametrofactuempresa= new ParametroFactuEmpresa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empresaorigensForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.transaccionorigensForeignKey=new ArrayList<Transaccion>();
		this.bodegaorigensForeignKey=new ArrayList<Bodega>();
		this.clienteorigensForeignKey=new ArrayList<Cliente>();
		this.empresadestinosForeignKey=new ArrayList<Empresa>();
		this.sucursaldestinosForeignKey=new ArrayList<Sucursal>();
		this.transacciondestinosForeignKey=new ArrayList<Transaccion>();
		this.bodegadestinosForeignKey=new ArrayList<Bodega>();
		this.clientedestinosForeignKey=new ArrayList<Cliente>();
		this.empresamultidestinosForeignKey=new ArrayList<Empresa>();
		this.sucursalmultidestinosForeignKey=new ArrayList<Sucursal>();
		this.transaccionmultidestinosForeignKey=new ArrayList<Transaccion>();
		this.bodegamultiorigensForeignKey=new ArrayList<Bodega>();
		this.bodegamultidestinosForeignKey=new ArrayList<Bodega>();
	} 
	
	public ParametroFactuEmpresa getParametroFactuEmpresa() throws Exception {	
		return parametrofactuempresa;
	}
		
	public void setParametroFactuEmpresa(ParametroFactuEmpresa newParametroFactuEmpresa) {
		this.parametrofactuempresa = newParametroFactuEmpresa;
	}
	
	public List<ParametroFactuEmpresa> getParametroFactuEmpresas() throws Exception {		
		return parametrofactuempresas;
	}
	
	public void setParametroFactuEmpresas(List<ParametroFactuEmpresa> newParametroFactuEmpresas) {
		this.parametrofactuempresas = newParametroFactuEmpresas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empresa> getempresaorigensForeignKey() {
		return this.empresaorigensForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Transaccion> gettransaccionorigensForeignKey() {
		return this.transaccionorigensForeignKey;
	}

	public List<Bodega> getbodegaorigensForeignKey() {
		return this.bodegaorigensForeignKey;
	}

	public List<Cliente> getclienteorigensForeignKey() {
		return this.clienteorigensForeignKey;
	}

	public List<Empresa> getempresadestinosForeignKey() {
		return this.empresadestinosForeignKey;
	}

	public List<Sucursal> getsucursaldestinosForeignKey() {
		return this.sucursaldestinosForeignKey;
	}

	public List<Transaccion> gettransacciondestinosForeignKey() {
		return this.transacciondestinosForeignKey;
	}

	public List<Bodega> getbodegadestinosForeignKey() {
		return this.bodegadestinosForeignKey;
	}

	public List<Cliente> getclientedestinosForeignKey() {
		return this.clientedestinosForeignKey;
	}

	public List<Empresa> getempresamultidestinosForeignKey() {
		return this.empresamultidestinosForeignKey;
	}

	public List<Sucursal> getsucursalmultidestinosForeignKey() {
		return this.sucursalmultidestinosForeignKey;
	}

	public List<Transaccion> gettransaccionmultidestinosForeignKey() {
		return this.transaccionmultidestinosForeignKey;
	}

	public List<Bodega> getbodegamultiorigensForeignKey() {
		return this.bodegamultiorigensForeignKey;
	}

	public List<Bodega> getbodegamultidestinosForeignKey() {
		return this.bodegamultidestinosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempresaorigensForeignKey(List<Empresa> empresaorigensForeignKey) {
		this.empresaorigensForeignKey=empresaorigensForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settransaccionorigensForeignKey(List<Transaccion> transaccionorigensForeignKey) {
		this.transaccionorigensForeignKey=transaccionorigensForeignKey;
	}

	public void setbodegaorigensForeignKey(List<Bodega> bodegaorigensForeignKey) {
		this.bodegaorigensForeignKey=bodegaorigensForeignKey;
	}

	public void setclienteorigensForeignKey(List<Cliente> clienteorigensForeignKey) {
		this.clienteorigensForeignKey=clienteorigensForeignKey;
	}

	public void setempresadestinosForeignKey(List<Empresa> empresadestinosForeignKey) {
		this.empresadestinosForeignKey=empresadestinosForeignKey;
	}

	public void setsucursaldestinosForeignKey(List<Sucursal> sucursaldestinosForeignKey) {
		this.sucursaldestinosForeignKey=sucursaldestinosForeignKey;
	}

	public void settransacciondestinosForeignKey(List<Transaccion> transacciondestinosForeignKey) {
		this.transacciondestinosForeignKey=transacciondestinosForeignKey;
	}

	public void setbodegadestinosForeignKey(List<Bodega> bodegadestinosForeignKey) {
		this.bodegadestinosForeignKey=bodegadestinosForeignKey;
	}

	public void setclientedestinosForeignKey(List<Cliente> clientedestinosForeignKey) {
		this.clientedestinosForeignKey=clientedestinosForeignKey;
	}

	public void setempresamultidestinosForeignKey(List<Empresa> empresamultidestinosForeignKey) {
		this.empresamultidestinosForeignKey=empresamultidestinosForeignKey;
	}

	public void setsucursalmultidestinosForeignKey(List<Sucursal> sucursalmultidestinosForeignKey) {
		this.sucursalmultidestinosForeignKey=sucursalmultidestinosForeignKey;
	}

	public void settransaccionmultidestinosForeignKey(List<Transaccion> transaccionmultidestinosForeignKey) {
		this.transaccionmultidestinosForeignKey=transaccionmultidestinosForeignKey;
	}

	public void setbodegamultiorigensForeignKey(List<Bodega> bodegamultiorigensForeignKey) {
		this.bodegamultiorigensForeignKey=bodegamultiorigensForeignKey;
	}

	public void setbodegamultidestinosForeignKey(List<Bodega> bodegamultidestinosForeignKey) {
		this.bodegamultidestinosForeignKey=bodegamultidestinosForeignKey;
	}
}

