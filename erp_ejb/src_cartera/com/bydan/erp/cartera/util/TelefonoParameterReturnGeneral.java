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
import com.bydan.erp.cartera.util.TelefonoConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Telefono


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TelefonoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Telefono telefono;	
	protected List<Telefono> telefonos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoTelefo> tipotelefosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public TelefonoParameterReturnGeneral () throws Exception {						
		super();
		this.telefonos= new ArrayList<Telefono>();
		this.telefono= new Telefono();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipotelefosForeignKey=new ArrayList<TipoTelefo>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public Telefono getTelefono() throws Exception {	
		return telefono;
	}
		
	public void setTelefono(Telefono newTelefono) {
		this.telefono = newTelefono;
	}
	
	public List<Telefono> getTelefonos() throws Exception {		
		return telefonos;
	}
	
	public void setTelefonos(List<Telefono> newTelefonos) {
		this.telefonos = newTelefonos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoTelefo> gettipotelefosForeignKey() {
		return this.tipotelefosForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipotelefosForeignKey(List<TipoTelefo> tipotelefosForeignKey) {
		this.tipotelefosForeignKey=tipotelefosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

