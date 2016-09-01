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
import com.bydan.erp.cartera.util.ReferenciaPersonalConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ReferenciaPersonal


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ReferenciaPersonalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ReferenciaPersonal referenciapersonal;	
	protected List<ReferenciaPersonal> referenciapersonals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoRefePerso> tiporefepersosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public ReferenciaPersonalParameterReturnGeneral () throws Exception {						
		super();
		this.referenciapersonals= new ArrayList<ReferenciaPersonal>();
		this.referenciapersonal= new ReferenciaPersonal();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tiporefepersosForeignKey=new ArrayList<TipoRefePerso>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public ReferenciaPersonal getReferenciaPersonal() throws Exception {	
		return referenciapersonal;
	}
		
	public void setReferenciaPersonal(ReferenciaPersonal newReferenciaPersonal) {
		this.referenciapersonal = newReferenciaPersonal;
	}
	
	public List<ReferenciaPersonal> getReferenciaPersonals() throws Exception {		
		return referenciapersonals;
	}
	
	public void setReferenciaPersonals(List<ReferenciaPersonal> newReferenciaPersonals) {
		this.referenciapersonals = newReferenciaPersonals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoRefePerso> gettiporefepersosForeignKey() {
		return this.tiporefepersosForeignKey;
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

	public void settiporefepersosForeignKey(List<TipoRefePerso> tiporefepersosForeignKey) {
		this.tiporefepersosForeignKey=tiporefepersosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

