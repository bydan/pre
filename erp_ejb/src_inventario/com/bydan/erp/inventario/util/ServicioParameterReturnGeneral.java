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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.ServicioConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Servicio


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class ServicioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Servicio servicio;	
	protected List<Servicio> servicios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoServicio> tiposerviciosForeignKey;
	public List<EstadoServicio> estadoserviciosForeignKey;
	public List<CuentaContable> cuentacontablegastosForeignKey;
	public List<CuentaContable> cuentacontablefiscalsForeignKey;
	public List<CuentaContable> cuentacontablefiscal2sForeignKey;
	public List<CuentaContable> cuentacontableretencionsForeignKey;
	public List<CuentaContable> cuentacontableretencion2sForeignKey;
	public List<CuentaContable> cuentacontableivasForeignKey;
	public List<CuentaContable> cuentacontableiva2sForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public ServicioParameterReturnGeneral () throws Exception {						
		super();
		this.servicios= new ArrayList<Servicio>();
		this.servicio= new Servicio();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tiposerviciosForeignKey=new ArrayList<TipoServicio>();
		this.estadoserviciosForeignKey=new ArrayList<EstadoServicio>();
		this.cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefiscalsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablefiscal2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableretencionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableretencion2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableivasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableiva2sForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public Servicio getServicio() throws Exception {	
		return servicio;
	}
		
	public void setServicio(Servicio newServicio) {
		this.servicio = newServicio;
	}
	
	public List<Servicio> getServicios() throws Exception {		
		return servicios;
	}
	
	public void setServicios(List<Servicio> newServicios) {
		this.servicios = newServicios;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoServicio> gettiposerviciosForeignKey() {
		return this.tiposerviciosForeignKey;
	}

	public List<EstadoServicio> getestadoserviciosForeignKey() {
		return this.estadoserviciosForeignKey;
	}

	public List<CuentaContable> getcuentacontablegastosForeignKey() {
		return this.cuentacontablegastosForeignKey;
	}

	public List<CuentaContable> getcuentacontablefiscalsForeignKey() {
		return this.cuentacontablefiscalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablefiscal2sForeignKey() {
		return this.cuentacontablefiscal2sForeignKey;
	}

	public List<CuentaContable> getcuentacontableretencionsForeignKey() {
		return this.cuentacontableretencionsForeignKey;
	}

	public List<CuentaContable> getcuentacontableretencion2sForeignKey() {
		return this.cuentacontableretencion2sForeignKey;
	}

	public List<CuentaContable> getcuentacontableivasForeignKey() {
		return this.cuentacontableivasForeignKey;
	}

	public List<CuentaContable> getcuentacontableiva2sForeignKey() {
		return this.cuentacontableiva2sForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settiposerviciosForeignKey(List<TipoServicio> tiposerviciosForeignKey) {
		this.tiposerviciosForeignKey=tiposerviciosForeignKey;
	}

	public void setestadoserviciosForeignKey(List<EstadoServicio> estadoserviciosForeignKey) {
		this.estadoserviciosForeignKey=estadoserviciosForeignKey;
	}

	public void setcuentacontablegastosForeignKey(List<CuentaContable> cuentacontablegastosForeignKey) {
		this.cuentacontablegastosForeignKey=cuentacontablegastosForeignKey;
	}

	public void setcuentacontablefiscalsForeignKey(List<CuentaContable> cuentacontablefiscalsForeignKey) {
		this.cuentacontablefiscalsForeignKey=cuentacontablefiscalsForeignKey;
	}

	public void setcuentacontablefiscal2sForeignKey(List<CuentaContable> cuentacontablefiscal2sForeignKey) {
		this.cuentacontablefiscal2sForeignKey=cuentacontablefiscal2sForeignKey;
	}

	public void setcuentacontableretencionsForeignKey(List<CuentaContable> cuentacontableretencionsForeignKey) {
		this.cuentacontableretencionsForeignKey=cuentacontableretencionsForeignKey;
	}

	public void setcuentacontableretencion2sForeignKey(List<CuentaContable> cuentacontableretencion2sForeignKey) {
		this.cuentacontableretencion2sForeignKey=cuentacontableretencion2sForeignKey;
	}

	public void setcuentacontableivasForeignKey(List<CuentaContable> cuentacontableivasForeignKey) {
		this.cuentacontableivasForeignKey=cuentacontableivasForeignKey;
	}

	public void setcuentacontableiva2sForeignKey(List<CuentaContable> cuentacontableiva2sForeignKey) {
		this.cuentacontableiva2sForeignKey=cuentacontableiva2sForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

