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
import com.bydan.erp.cartera.util.ClienteArchivoConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ClienteArchivo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ClienteArchivoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ClienteArchivo clientearchivo;	
	protected List<ClienteArchivo> clientearchivos;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoArchivo> tipoarchivosForeignKey;
	
	public ClienteArchivoParameterReturnGeneral () throws Exception {						
		super();
		this.clientearchivos= new ArrayList<ClienteArchivo>();
		this.clientearchivo= new ClienteArchivo();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoarchivosForeignKey=new ArrayList<TipoArchivo>();
	} 
	
	public ClienteArchivo getClienteArchivo() throws Exception {	
		return clientearchivo;
	}
		
	public void setClienteArchivo(ClienteArchivo newClienteArchivo) {
		this.clientearchivo = newClienteArchivo;
	}
	
	public List<ClienteArchivo> getClienteArchivos() throws Exception {		
		return clientearchivos;
	}
	
	public void setClienteArchivos(List<ClienteArchivo> newClienteArchivos) {
		this.clientearchivos = newClienteArchivos;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoArchivo> gettipoarchivosForeignKey() {
		return this.tipoarchivosForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoarchivosForeignKey(List<TipoArchivo> tipoarchivosForeignKey) {
		this.tipoarchivosForeignKey=tipoarchivosForeignKey;
	}
}

