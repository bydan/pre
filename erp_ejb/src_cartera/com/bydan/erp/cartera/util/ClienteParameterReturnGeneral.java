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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.ClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Cliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class ClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Cliente cliente;	
	protected List<Cliente> clientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<TituloCliente> tituloclientesForeignKey;
	public List<AreaCr> areacrsForeignKey;
	public List<EstadoCliente> estadoclientesForeignKey;
	public List<Pais> paissForeignKey;
	public List<Region> regionsForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	public List<Pais> paisnacionalidadsForeignKey;
	public List<TipoCargoLabo> tipocargolabosForeignKey;
	public List<TipoNivelEdu> tiponiveledusForeignKey;
	public List<Profesion> profesionsForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	public List<EstadoLegal> estadolegalsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Ruta> rutasForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<CentroActividad> centroactividadsForeignKey;
	public List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey;
	public List<CateTipoAfiliacion> catetipoafiliacionsForeignKey;
	public List<Dia> diasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<TipoListaPrecio> tipolistapreciosForeignKey;
	
	public ClienteParameterReturnGeneral () throws Exception {						
		super();
		this.clientes= new ArrayList<Cliente>();
		this.cliente= new Cliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.tituloclientesForeignKey=new ArrayList<TituloCliente>();
		this.areacrsForeignKey=new ArrayList<AreaCr>();
		this.estadoclientesForeignKey=new ArrayList<EstadoCliente>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.regionsForeignKey=new ArrayList<Region>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
		this.paisnacionalidadsForeignKey=new ArrayList<Pais>();
		this.tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
		this.tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
		this.profesionsForeignKey=new ArrayList<Profesion>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
		this.estadolegalsForeignKey=new ArrayList<EstadoLegal>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.rutasForeignKey=new ArrayList<Ruta>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.centroactividadsForeignKey=new ArrayList<CentroActividad>();
		this.tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
		this.catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
		this.diasForeignKey=new ArrayList<Dia>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
	} 
	
	public Cliente getCliente() throws Exception {	
		return cliente;
	}
		
	public void setCliente(Cliente newCliente) {
		this.cliente = newCliente;
	}
	
	public List<Cliente> getClientes() throws Exception {		
		return clientes;
	}
	
	public void setClientes(List<Cliente> newClientes) {
		this.clientes = newClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
	}

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<TituloCliente> gettituloclientesForeignKey() {
		return this.tituloclientesForeignKey;
	}

	public List<AreaCr> getareacrsForeignKey() {
		return this.areacrsForeignKey;
	}

	public List<EstadoCliente> getestadoclientesForeignKey() {
		return this.estadoclientesForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Region> getregionsForeignKey() {
		return this.regionsForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<Zona> getzonasForeignKey() {
		return this.zonasForeignKey;
	}

	public List<Pais> getpaisnacionalidadsForeignKey() {
		return this.paisnacionalidadsForeignKey;
	}

	public List<TipoCargoLabo> gettipocargolabosForeignKey() {
		return this.tipocargolabosForeignKey;
	}

	public List<TipoNivelEdu> gettiponiveledusForeignKey() {
		return this.tiponiveledusForeignKey;
	}

	public List<Profesion> getprofesionsForeignKey() {
		return this.profesionsForeignKey;
	}

	public List<TipoGenero> gettipogenerosForeignKey() {
		return this.tipogenerosForeignKey;
	}

	public List<EstadoCivil> getestadocivilsForeignKey() {
		return this.estadocivilsForeignKey;
	}

	public List<EstadoLegal> getestadolegalsForeignKey() {
		return this.estadolegalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Ruta> getrutasForeignKey() {
		return this.rutasForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<CentroActividad> getcentroactividadsForeignKey() {
		return this.centroactividadsForeignKey;
	}

	public List<TipoGarantiaEmpresa> gettipogarantiaempresasForeignKey() {
		return this.tipogarantiaempresasForeignKey;
	}

	public List<CateTipoAfiliacion> getcatetipoafiliacionsForeignKey() {
		return this.catetipoafiliacionsForeignKey;
	}

	public List<Dia> getdiasForeignKey() {
		return this.diasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<TipoListaPrecio> gettipolistapreciosForeignKey() {
		return this.tipolistapreciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
	}

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void settituloclientesForeignKey(List<TituloCliente> tituloclientesForeignKey) {
		this.tituloclientesForeignKey=tituloclientesForeignKey;
	}

	public void setareacrsForeignKey(List<AreaCr> areacrsForeignKey) {
		this.areacrsForeignKey=areacrsForeignKey;
	}

	public void setestadoclientesForeignKey(List<EstadoCliente> estadoclientesForeignKey) {
		this.estadoclientesForeignKey=estadoclientesForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setregionsForeignKey(List<Region> regionsForeignKey) {
		this.regionsForeignKey=regionsForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setzonasForeignKey(List<Zona> zonasForeignKey) {
		this.zonasForeignKey=zonasForeignKey;
	}

	public void setpaisnacionalidadsForeignKey(List<Pais> paisnacionalidadsForeignKey) {
		this.paisnacionalidadsForeignKey=paisnacionalidadsForeignKey;
	}

	public void settipocargolabosForeignKey(List<TipoCargoLabo> tipocargolabosForeignKey) {
		this.tipocargolabosForeignKey=tipocargolabosForeignKey;
	}

	public void settiponiveledusForeignKey(List<TipoNivelEdu> tiponiveledusForeignKey) {
		this.tiponiveledusForeignKey=tiponiveledusForeignKey;
	}

	public void setprofesionsForeignKey(List<Profesion> profesionsForeignKey) {
		this.profesionsForeignKey=profesionsForeignKey;
	}

	public void settipogenerosForeignKey(List<TipoGenero> tipogenerosForeignKey) {
		this.tipogenerosForeignKey=tipogenerosForeignKey;
	}

	public void setestadocivilsForeignKey(List<EstadoCivil> estadocivilsForeignKey) {
		this.estadocivilsForeignKey=estadocivilsForeignKey;
	}

	public void setestadolegalsForeignKey(List<EstadoLegal> estadolegalsForeignKey) {
		this.estadolegalsForeignKey=estadolegalsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setrutasForeignKey(List<Ruta> rutasForeignKey) {
		this.rutasForeignKey=rutasForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setcentroactividadsForeignKey(List<CentroActividad> centroactividadsForeignKey) {
		this.centroactividadsForeignKey=centroactividadsForeignKey;
	}

	public void settipogarantiaempresasForeignKey(List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey) {
		this.tipogarantiaempresasForeignKey=tipogarantiaempresasForeignKey;
	}

	public void setcatetipoafiliacionsForeignKey(List<CateTipoAfiliacion> catetipoafiliacionsForeignKey) {
		this.catetipoafiliacionsForeignKey=catetipoafiliacionsForeignKey;
	}

	public void setdiasForeignKey(List<Dia> diasForeignKey) {
		this.diasForeignKey=diasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void settipolistapreciosForeignKey(List<TipoListaPrecio> tipolistapreciosForeignKey) {
		this.tipolistapreciosForeignKey=tipolistapreciosForeignKey;
	}
}

