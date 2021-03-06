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
import com.bydan.erp.facturacion.util.report.ProcesoFacturasProductosConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//ProcesoFacturasProductos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoFacturasProductosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoFacturasProductos procesofacturasproductos;	
	protected List<ProcesoFacturasProductos> procesofacturasproductoss;
	
	
	public List<Ciudad> ciudadsForeignKey;
	public List<Zona> zonasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	
	public ProcesoFacturasProductosParameterReturnGeneral () throws Exception {						
		super();
		this.procesofacturasproductoss= new ArrayList<ProcesoFacturasProductos>();
		this.procesofacturasproductos= new ProcesoFacturasProductos();
		
		
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.zonasForeignKey=new ArrayList<Zona>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
	} 
	
	public ProcesoFacturasProductos getProcesoFacturasProductos() throws Exception {	
		return procesofacturasproductos;
	}
		
	public void setProcesoFacturasProductos(ProcesoFacturasProductos newProcesoFacturasProductos) {
		this.procesofacturasproductos = newProcesoFacturasProductos;
	}
	
	public List<ProcesoFacturasProductos> getProcesoFacturasProductoss() throws Exception {		
		return procesofacturasproductoss;
	}
	
	public void setProcesoFacturasProductoss(List<ProcesoFacturasProductos> newProcesoFacturasProductoss) {
		this.procesofacturasproductoss = newProcesoFacturasProductoss;
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

