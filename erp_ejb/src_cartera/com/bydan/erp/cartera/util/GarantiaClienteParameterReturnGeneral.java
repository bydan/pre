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
import com.bydan.erp.cartera.util.GarantiaClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//GarantiaCliente


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class GarantiaClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GarantiaCliente garantiacliente;	
	protected List<GarantiaCliente> garantiaclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey;
	public List<EstadoGarantiaCliente> estadogarantiaclientesForeignKey;
	
	public GarantiaClienteParameterReturnGeneral () throws Exception {						
		super();
		this.garantiaclientes= new ArrayList<GarantiaCliente>();
		this.garantiacliente= new GarantiaCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
		this.estadogarantiaclientesForeignKey=new ArrayList<EstadoGarantiaCliente>();
	} 
	
	public GarantiaCliente getGarantiaCliente() throws Exception {	
		return garantiacliente;
	}
		
	public void setGarantiaCliente(GarantiaCliente newGarantiaCliente) {
		this.garantiacliente = newGarantiaCliente;
	}
	
	public List<GarantiaCliente> getGarantiaClientes() throws Exception {		
		return garantiaclientes;
	}
	
	public void setGarantiaClientes(List<GarantiaCliente> newGarantiaClientes) {
		this.garantiaclientes = newGarantiaClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoGarantiaEmpresa> gettipogarantiaempresasForeignKey() {
		return this.tipogarantiaempresasForeignKey;
	}

	public List<EstadoGarantiaCliente> getestadogarantiaclientesForeignKey() {
		return this.estadogarantiaclientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipogarantiaempresasForeignKey(List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey) {
		this.tipogarantiaempresasForeignKey=tipogarantiaempresasForeignKey;
	}

	public void setestadogarantiaclientesForeignKey(List<EstadoGarantiaCliente> estadogarantiaclientesForeignKey) {
		this.estadogarantiaclientesForeignKey=estadogarantiaclientesForeignKey;
	}
}

