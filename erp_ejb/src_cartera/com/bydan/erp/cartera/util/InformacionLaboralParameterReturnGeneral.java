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
import com.bydan.erp.cartera.util.InformacionLaboralConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//InformacionLaboral


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class InformacionLaboralParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected InformacionLaboral informacionlaboral;	
	protected List<InformacionLaboral> informacionlaborals;
	
	
	public List<Cliente> clientesForeignKey;
	public List<TipoEmpresa> tipoempresasForeignKey;
	public List<TipoRelaLabo> tiporelalabosForeignKey;
	public List<TipoAreaLabo> tipoarealabosForeignKey;
	public List<TipoCargoLabo> tipocargolabosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public InformacionLaboralParameterReturnGeneral () throws Exception {						
		super();
		this.informacionlaborals= new ArrayList<InformacionLaboral>();
		this.informacionlaboral= new InformacionLaboral();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoempresasForeignKey=new ArrayList<TipoEmpresa>();
		this.tiporelalabosForeignKey=new ArrayList<TipoRelaLabo>();
		this.tipoarealabosForeignKey=new ArrayList<TipoAreaLabo>();
		this.tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public InformacionLaboral getInformacionLaboral() throws Exception {	
		return informacionlaboral;
	}
		
	public void setInformacionLaboral(InformacionLaboral newInformacionLaboral) {
		this.informacionlaboral = newInformacionLaboral;
	}
	
	public List<InformacionLaboral> getInformacionLaborals() throws Exception {		
		return informacionlaborals;
	}
	
	public void setInformacionLaborals(List<InformacionLaboral> newInformacionLaborals) {
		this.informacionlaborals = newInformacionLaborals;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoEmpresa> gettipoempresasForeignKey() {
		return this.tipoempresasForeignKey;
	}

	public List<TipoRelaLabo> gettiporelalabosForeignKey() {
		return this.tiporelalabosForeignKey;
	}

	public List<TipoAreaLabo> gettipoarealabosForeignKey() {
		return this.tipoarealabosForeignKey;
	}

	public List<TipoCargoLabo> gettipocargolabosForeignKey() {
		return this.tipocargolabosForeignKey;
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

	public void settipoempresasForeignKey(List<TipoEmpresa> tipoempresasForeignKey) {
		this.tipoempresasForeignKey=tipoempresasForeignKey;
	}

	public void settiporelalabosForeignKey(List<TipoRelaLabo> tiporelalabosForeignKey) {
		this.tiporelalabosForeignKey=tiporelalabosForeignKey;
	}

	public void settipoarealabosForeignKey(List<TipoAreaLabo> tipoarealabosForeignKey) {
		this.tipoarealabosForeignKey=tipoarealabosForeignKey;
	}

	public void settipocargolabosForeignKey(List<TipoCargoLabo> tipocargolabosForeignKey) {
		this.tipocargolabosForeignKey=tipocargolabosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

