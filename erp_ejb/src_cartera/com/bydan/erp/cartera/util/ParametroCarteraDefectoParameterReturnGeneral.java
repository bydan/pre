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
import com.bydan.erp.cartera.util.ParametroCarteraDefectoConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ParametroCarteraDefecto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ParametroCarteraDefectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroCarteraDefecto parametrocarteradefecto;	
	protected List<ParametroCarteraDefecto> parametrocarteradefectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Region> regionsForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	public List<TipoNivelEdu> tiponiveledusForeignKey;
	public List<Pais> paisnacionalidadsForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	public List<EstadoLegal> estadolegalsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Ruta> rutasForeignKey;
	public List<Dia> diasForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<TipoListaPrecio> tipolistapreciosForeignKey;
	
	public ParametroCarteraDefectoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocarteradefectos= new ArrayList<ParametroCarteraDefecto>();
		this.parametrocarteradefecto= new ParametroCarteraDefecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.regionsForeignKey=new ArrayList<Region>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
		this.tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
		this.paisnacionalidadsForeignKey=new ArrayList<Pais>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
		this.estadolegalsForeignKey=new ArrayList<EstadoLegal>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.rutasForeignKey=new ArrayList<Ruta>();
		this.diasForeignKey=new ArrayList<Dia>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
	} 
	
	public ParametroCarteraDefecto getParametroCarteraDefecto() throws Exception {	
		return parametrocarteradefecto;
	}
		
	public void setParametroCarteraDefecto(ParametroCarteraDefecto newParametroCarteraDefecto) {
		this.parametrocarteradefecto = newParametroCarteraDefecto;
	}
	
	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() throws Exception {		
		return parametrocarteradefectos;
	}
	
	public void setParametroCarteraDefectos(List<ParametroCarteraDefecto> newParametroCarteraDefectos) {
		this.parametrocarteradefectos = newParametroCarteraDefectos;
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

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
	}

	public List<TipoNivelEdu> gettiponiveledusForeignKey() {
		return this.tiponiveledusForeignKey;
	}

	public List<Pais> getpaisnacionalidadsForeignKey() {
		return this.paisnacionalidadsForeignKey;
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

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Ruta> getrutasForeignKey() {
		return this.rutasForeignKey;
	}

	public List<Dia> getdiasForeignKey() {
		return this.diasForeignKey;
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

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
	}

	public void settiponiveledusForeignKey(List<TipoNivelEdu> tiponiveledusForeignKey) {
		this.tiponiveledusForeignKey=tiponiveledusForeignKey;
	}

	public void setpaisnacionalidadsForeignKey(List<Pais> paisnacionalidadsForeignKey) {
		this.paisnacionalidadsForeignKey=paisnacionalidadsForeignKey;
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

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setrutasForeignKey(List<Ruta> rutasForeignKey) {
		this.rutasForeignKey=rutasForeignKey;
	}

	public void setdiasForeignKey(List<Dia> diasForeignKey) {
		this.diasForeignKey=diasForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void settipolistapreciosForeignKey(List<TipoListaPrecio> tipolistapreciosForeignKey) {
		this.tipolistapreciosForeignKey=tipolistapreciosForeignKey;
	}
}

