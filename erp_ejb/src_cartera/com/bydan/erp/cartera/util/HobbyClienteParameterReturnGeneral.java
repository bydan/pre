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
import com.bydan.erp.cartera.util.HobbyClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//HobbyCliente


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class HobbyClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HobbyCliente hobbycliente;	
	protected List<HobbyCliente> hobbyclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Hobby> hobbysForeignKey;
	
	public HobbyClienteParameterReturnGeneral () throws Exception {						
		super();
		this.hobbyclientes= new ArrayList<HobbyCliente>();
		this.hobbycliente= new HobbyCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.hobbysForeignKey=new ArrayList<Hobby>();
	} 
	
	public HobbyCliente getHobbyCliente() throws Exception {	
		return hobbycliente;
	}
		
	public void setHobbyCliente(HobbyCliente newHobbyCliente) {
		this.hobbycliente = newHobbyCliente;
	}
	
	public List<HobbyCliente> getHobbyClientes() throws Exception {		
		return hobbyclientes;
	}
	
	public void setHobbyClientes(List<HobbyCliente> newHobbyClientes) {
		this.hobbyclientes = newHobbyClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Hobby> gethobbysForeignKey() {
		return this.hobbysForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void sethobbysForeignKey(List<Hobby> hobbysForeignKey) {
		this.hobbysForeignKey=hobbysForeignKey;
	}
}

