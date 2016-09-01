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
package com.bydan.erp.facturacion.util.report;

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
import com.bydan.erp.facturacion.util.report.ProcesoRecibosConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//ProcesoRecibos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoRecibosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoRecibos procesorecibos;	
	protected List<ProcesoRecibos> procesoreciboss;
	
	
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	
	public ProcesoRecibosParameterReturnGeneral () throws Exception {						
		super();
		this.procesoreciboss= new ArrayList<ProcesoRecibos>();
		this.procesorecibos= new ProcesoRecibos();
		
		
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
	} 
	
	public ProcesoRecibos getProcesoRecibos() throws Exception {	
		return procesorecibos;
	}
		
	public void setProcesoRecibos(ProcesoRecibos newProcesoRecibos) {
		this.procesorecibos = newProcesoRecibos;
	}
	
	public List<ProcesoRecibos> getProcesoReciboss() throws Exception {		
		return procesoreciboss;
	}
	
	public void setProcesoReciboss(List<ProcesoRecibos> newProcesoReciboss) {
		this.procesoreciboss = newProcesoReciboss;
	}
	
	

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<Zona> getzonasForeignKey() {
		return this.zonasForeignKey;
	}

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}
	
	

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setzonasForeignKey(List<Zona> zonasForeignKey) {
		this.zonasForeignKey=zonasForeignKey;
	}

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}
}

