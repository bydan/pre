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
import com.bydan.erp.cartera.util.ReferenciaComercialConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ReferenciaComercial


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ReferenciaComercialParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ReferenciaComercial referenciacomercial;	
	protected List<ReferenciaComercial> referenciacomercials;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoSectorEcono> tiposectoreconosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<TipoValoracion> tipovaloracionsForeignKey;
	
	public ReferenciaComercialParameterReturnGeneral () throws Exception {						
		super();
		this.referenciacomercials= new ArrayList<ReferenciaComercial>();
		this.referenciacomercial= new ReferenciaComercial();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tiposectoreconosForeignKey=new ArrayList<TipoSectorEcono>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
	} 
	
	public ReferenciaComercial getReferenciaComercial() throws Exception {	
		return referenciacomercial;
	}
		
	public void setReferenciaComercial(ReferenciaComercial newReferenciaComercial) {
		this.referenciacomercial = newReferenciaComercial;
	}
	
	public List<ReferenciaComercial> getReferenciaComercials() throws Exception {		
		return referenciacomercials;
	}
	
	public void setReferenciaComercials(List<ReferenciaComercial> newReferenciaComercials) {
		this.referenciacomercials = newReferenciaComercials;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoSectorEcono> gettiposectoreconosForeignKey() {
		return this.tiposectoreconosForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<TipoValoracion> gettipovaloracionsForeignKey() {
		return this.tipovaloracionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settiposectoreconosForeignKey(List<TipoSectorEcono> tiposectoreconosForeignKey) {
		this.tiposectoreconosForeignKey=tiposectoreconosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void settipovaloracionsForeignKey(List<TipoValoracion> tipovaloracionsForeignKey) {
		this.tipovaloracionsForeignKey=tipovaloracionsForeignKey;
	}
}

