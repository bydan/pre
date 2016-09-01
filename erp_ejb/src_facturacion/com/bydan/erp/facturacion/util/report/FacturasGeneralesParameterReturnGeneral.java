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
import com.bydan.erp.facturacion.util.report.FacturasGeneralesConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//FacturasGenerales


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FacturasGeneralesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FacturasGenerales facturasgenerales;	
	protected List<FacturasGenerales> facturasgeneraless;
	
	
	public List<Zona> zonasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoFactura> tipofacturasForeignKey;
	
	public FacturasGeneralesParameterReturnGeneral () throws Exception {						
		super();
		this.facturasgeneraless= new ArrayList<FacturasGenerales>();
		this.facturasgenerales= new FacturasGenerales();
		
		
		this.zonasForeignKey=new ArrayList<Zona>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipofacturasForeignKey=new ArrayList<TipoFactura>();
	} 
	
	public FacturasGenerales getFacturasGenerales() throws Exception {	
		return facturasgenerales;
	}
		
	public void setFacturasGenerales(FacturasGenerales newFacturasGenerales) {
		this.facturasgenerales = newFacturasGenerales;
	}
	
	public List<FacturasGenerales> getFacturasGeneraless() throws Exception {		
		return facturasgeneraless;
	}
	
	public void setFacturasGeneraless(List<FacturasGenerales> newFacturasGeneraless) {
		this.facturasgeneraless = newFacturasGeneraless;
	}
	
	

	public List<Zona> getzonasForeignKey() {
		return this.zonasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoFactura> gettipofacturasForeignKey() {
		return this.tipofacturasForeignKey;
	}
	
	

	public void setzonasForeignKey(List<Zona> zonasForeignKey) {
		this.zonasForeignKey=zonasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipofacturasForeignKey(List<TipoFactura> tipofacturasForeignKey) {
		this.tipofacturasForeignKey=tipofacturasForeignKey;
	}
}

