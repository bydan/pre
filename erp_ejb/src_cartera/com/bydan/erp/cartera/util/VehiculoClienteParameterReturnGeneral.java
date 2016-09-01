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
import com.bydan.erp.cartera.util.VehiculoClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//VehiculoCliente


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VehiculoClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VehiculoCliente vehiculocliente;	
	protected List<VehiculoCliente> vehiculoclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public VehiculoClienteParameterReturnGeneral () throws Exception {						
		super();
		this.vehiculoclientes= new ArrayList<VehiculoCliente>();
		this.vehiculocliente= new VehiculoCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public VehiculoCliente getVehiculoCliente() throws Exception {	
		return vehiculocliente;
	}
		
	public void setVehiculoCliente(VehiculoCliente newVehiculoCliente) {
		this.vehiculocliente = newVehiculoCliente;
	}
	
	public List<VehiculoCliente> getVehiculoClientes() throws Exception {		
		return vehiculoclientes;
	}
	
	public void setVehiculoClientes(List<VehiculoCliente> newVehiculoClientes) {
		this.vehiculoclientes = newVehiculoClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

