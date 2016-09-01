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
import com.bydan.erp.cartera.util.ClienteImagenConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ClienteImagen


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ClienteImagenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ClienteImagen clienteimagen;	
	protected List<ClienteImagen> clienteimagens;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoImagenPersona> tipoimagenpersonasForeignKey;
	public List<TipoImagen> tipoimagensForeignKey;
	
	public ClienteImagenParameterReturnGeneral () throws Exception {						
		super();
		this.clienteimagens= new ArrayList<ClienteImagen>();
		this.clienteimagen= new ClienteImagen();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoimagenpersonasForeignKey=new ArrayList<TipoImagenPersona>();
		this.tipoimagensForeignKey=new ArrayList<TipoImagen>();
	} 
	
	public ClienteImagen getClienteImagen() throws Exception {	
		return clienteimagen;
	}
		
	public void setClienteImagen(ClienteImagen newClienteImagen) {
		this.clienteimagen = newClienteImagen;
	}
	
	public List<ClienteImagen> getClienteImagens() throws Exception {		
		return clienteimagens;
	}
	
	public void setClienteImagens(List<ClienteImagen> newClienteImagens) {
		this.clienteimagens = newClienteImagens;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoImagenPersona> gettipoimagenpersonasForeignKey() {
		return this.tipoimagenpersonasForeignKey;
	}

	public List<TipoImagen> gettipoimagensForeignKey() {
		return this.tipoimagensForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoimagenpersonasForeignKey(List<TipoImagenPersona> tipoimagenpersonasForeignKey) {
		this.tipoimagenpersonasForeignKey=tipoimagenpersonasForeignKey;
	}

	public void settipoimagensForeignKey(List<TipoImagen> tipoimagensForeignKey) {
		this.tipoimagensForeignKey=tipoimagensForeignKey;
	}
}

