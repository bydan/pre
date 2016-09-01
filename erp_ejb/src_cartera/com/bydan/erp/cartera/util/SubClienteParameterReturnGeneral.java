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
import com.bydan.erp.cartera.util.SubClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//SubCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class SubClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SubCliente subcliente;	
	protected List<SubCliente> subclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	public List<Pais> paisnacionalidadsForeignKey;
	public List<TipoGenero> tipogenerosForeignKey;
	public List<EstadoCivil> estadocivilsForeignKey;
	public List<EstadoLegal> estadolegalsForeignKey;
	public List<TipoNivelEdu> tiponiveledusForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public SubClienteParameterReturnGeneral () throws Exception {						
		super();
		this.subclientes= new ArrayList<SubCliente>();
		this.subcliente= new SubCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
		this.paisnacionalidadsForeignKey=new ArrayList<Pais>();
		this.tipogenerosForeignKey=new ArrayList<TipoGenero>();
		this.estadocivilsForeignKey=new ArrayList<EstadoCivil>();
		this.estadolegalsForeignKey=new ArrayList<EstadoLegal>();
		this.tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public SubCliente getSubCliente() throws Exception {	
		return subcliente;
	}
		
	public void setSubCliente(SubCliente newSubCliente) {
		this.subcliente = newSubCliente;
	}
	
	public List<SubCliente> getSubClientes() throws Exception {		
		return subclientes;
	}
	
	public void setSubClientes(List<SubCliente> newSubClientes) {
		this.subclientes = newSubClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
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

	public List<TipoNivelEdu> gettiponiveledusForeignKey() {
		return this.tiponiveledusForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
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

	public void settiponiveledusForeignKey(List<TipoNivelEdu> tiponiveledusForeignKey) {
		this.tiponiveledusForeignKey=tiponiveledusForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

