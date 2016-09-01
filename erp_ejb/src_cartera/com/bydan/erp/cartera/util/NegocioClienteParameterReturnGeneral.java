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
import com.bydan.erp.cartera.util.NegocioClienteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//NegocioCliente


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class NegocioClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected NegocioCliente negociocliente;	
	protected List<NegocioCliente> negocioclientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoUbicacionNegocio> tipoubicacionnegociosForeignKey;
	
	public NegocioClienteParameterReturnGeneral () throws Exception {						
		super();
		this.negocioclientes= new ArrayList<NegocioCliente>();
		this.negociocliente= new NegocioCliente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoubicacionnegociosForeignKey=new ArrayList<TipoUbicacionNegocio>();
	} 
	
	public NegocioCliente getNegocioCliente() throws Exception {	
		return negociocliente;
	}
		
	public void setNegocioCliente(NegocioCliente newNegocioCliente) {
		this.negociocliente = newNegocioCliente;
	}
	
	public List<NegocioCliente> getNegocioClientes() throws Exception {		
		return negocioclientes;
	}
	
	public void setNegocioClientes(List<NegocioCliente> newNegocioClientes) {
		this.negocioclientes = newNegocioClientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoUbicacionNegocio> gettipoubicacionnegociosForeignKey() {
		return this.tipoubicacionnegociosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoubicacionnegociosForeignKey(List<TipoUbicacionNegocio> tipoubicacionnegociosForeignKey) {
		this.tipoubicacionnegociosForeignKey=tipoubicacionnegociosForeignKey;
	}
}

