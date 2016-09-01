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
import com.bydan.erp.cartera.util.PoliticasClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//PoliticasCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class PoliticasClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PoliticasCliente politicascliente;	
	protected List<PoliticasCliente> politicasclientes;
	
	
	public List<Cliente> clientesForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	public List<Transporte> transportesForeignKey;
	public List<LineaNegocio> lineanegociosForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	public List<EstadoPoliticasCliente> estadopoliticasclientesForeignKey;
	
	public PoliticasClienteParameterReturnGeneral () throws Exception {						
		super();
		this.politicasclientes= new ArrayList<PoliticasCliente>();
		this.politicascliente= new PoliticasCliente();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
		this.transportesForeignKey=new ArrayList<Transporte>();
		this.lineanegociosForeignKey=new ArrayList<LineaNegocio>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
		this.estadopoliticasclientesForeignKey=new ArrayList<EstadoPoliticasCliente>();
	} 
	
	public PoliticasCliente getPoliticasCliente() throws Exception {	
		return politicascliente;
	}
		
	public void setPoliticasCliente(PoliticasCliente newPoliticasCliente) {
		this.politicascliente = newPoliticasCliente;
	}
	
	public List<PoliticasCliente> getPoliticasClientes() throws Exception {		
		return politicasclientes;
	}
	
	public void setPoliticasClientes(List<PoliticasCliente> newPoliticasClientes) {
		this.politicasclientes = newPoliticasClientes;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}

	public List<Transporte> gettransportesForeignKey() {
		return this.transportesForeignKey;
	}

	public List<LineaNegocio> getlineanegociosForeignKey() {
		return this.lineanegociosForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}

	public List<EstadoPoliticasCliente> getestadopoliticasclientesForeignKey() {
		return this.estadopoliticasclientesForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}

	public void settransportesForeignKey(List<Transporte> transportesForeignKey) {
		this.transportesForeignKey=transportesForeignKey;
	}

	public void setlineanegociosForeignKey(List<LineaNegocio> lineanegociosForeignKey) {
		this.lineanegociosForeignKey=lineanegociosForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}

	public void setestadopoliticasclientesForeignKey(List<EstadoPoliticasCliente> estadopoliticasclientesForeignKey) {
		this.estadopoliticasclientesForeignKey=estadopoliticasclientesForeignKey;
	}
}

