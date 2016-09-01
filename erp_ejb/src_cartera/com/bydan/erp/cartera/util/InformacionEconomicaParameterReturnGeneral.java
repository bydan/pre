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
import com.bydan.erp.cartera.util.InformacionEconomicaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//InformacionEconomica




@SuppressWarnings("unused")
public class InformacionEconomicaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected InformacionEconomica informacioneconomica;	
	protected List<InformacionEconomica> informacioneconomicas;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoVinculacion> tipovinculacionsForeignKey;
	
	public InformacionEconomicaParameterReturnGeneral () throws Exception {						
		super();
		this.informacioneconomicas= new ArrayList<InformacionEconomica>();
		this.informacioneconomica= new InformacionEconomica();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipovinculacionsForeignKey=new ArrayList<TipoVinculacion>();
	} 
	
	public InformacionEconomica getInformacionEconomica() throws Exception {	
		return informacioneconomica;
	}
		
	public void setInformacionEconomica(InformacionEconomica newInformacionEconomica) {
		this.informacioneconomica = newInformacionEconomica;
	}
	
	public List<InformacionEconomica> getInformacionEconomicas() throws Exception {		
		return informacioneconomicas;
	}
	
	public void setInformacionEconomicas(List<InformacionEconomica> newInformacionEconomicas) {
		this.informacioneconomicas = newInformacionEconomicas;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoVinculacion> gettipovinculacionsForeignKey() {
		return this.tipovinculacionsForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipovinculacionsForeignKey(List<TipoVinculacion> tipovinculacionsForeignKey) {
		this.tipovinculacionsForeignKey=tipovinculacionsForeignKey;
	}
}

