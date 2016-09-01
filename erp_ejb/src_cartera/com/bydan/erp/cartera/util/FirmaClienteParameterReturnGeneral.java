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
import com.bydan.erp.cartera.util.FirmaClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//FirmaCliente


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class FirmaClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FirmaCliente firmacliente;	
	protected List<FirmaCliente> firmaclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoImagen> tipoimagensForeignKey;
	
	public FirmaClienteParameterReturnGeneral () throws Exception {						
		super();
		this.firmaclientes= new ArrayList<FirmaCliente>();
		this.firmacliente= new FirmaCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoimagensForeignKey=new ArrayList<TipoImagen>();
	} 
	
	public FirmaCliente getFirmaCliente() throws Exception {	
		return firmacliente;
	}
		
	public void setFirmaCliente(FirmaCliente newFirmaCliente) {
		this.firmacliente = newFirmaCliente;
	}
	
	public List<FirmaCliente> getFirmaClientes() throws Exception {		
		return firmaclientes;
	}
	
	public void setFirmaClientes(List<FirmaCliente> newFirmaClientes) {
		this.firmaclientes = newFirmaClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoImagen> gettipoimagensForeignKey() {
		return this.tipoimagensForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoimagensForeignKey(List<TipoImagen> tipoimagensForeignKey) {
		this.tipoimagensForeignKey=tipoimagensForeignKey;
	}
}

