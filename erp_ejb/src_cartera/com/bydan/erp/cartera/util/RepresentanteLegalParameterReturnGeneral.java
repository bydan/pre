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
import com.bydan.erp.cartera.util.RepresentanteLegalConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//RepresentanteLegal


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RepresentanteLegalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RepresentanteLegal representantelegal;	
	protected List<RepresentanteLegal> representantelegals;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoIdentificacion> tipoidentificacionsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public RepresentanteLegalParameterReturnGeneral () throws Exception {						
		super();
		this.representantelegals= new ArrayList<RepresentanteLegal>();
		this.representantelegal= new RepresentanteLegal();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public RepresentanteLegal getRepresentanteLegal() throws Exception {	
		return representantelegal;
	}
		
	public void setRepresentanteLegal(RepresentanteLegal newRepresentanteLegal) {
		this.representantelegal = newRepresentanteLegal;
	}
	
	public List<RepresentanteLegal> getRepresentanteLegals() throws Exception {		
		return representantelegals;
	}
	
	public void setRepresentanteLegals(List<RepresentanteLegal> newRepresentanteLegals) {
		this.representantelegals = newRepresentanteLegals;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoIdentificacion> gettipoidentificacionsForeignKey() {
		return this.tipoidentificacionsForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipoidentificacionsForeignKey(List<TipoIdentificacion> tipoidentificacionsForeignKey) {
		this.tipoidentificacionsForeignKey=tipoidentificacionsForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

