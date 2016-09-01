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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.DetaNotaCreditoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetaNotaCredito


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetaNotaCreditoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetaNotaCredito detanotacredito;	
	protected List<DetaNotaCredito> detanotacreditos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<NotaCredito> notacreditosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<TipoDetaNotaCredito> tipodetanotacreditosForeignKey;
	public List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Empaque> empaquesForeignKey;
	
	public DetaNotaCreditoParameterReturnGeneral () throws Exception {						
		super();
		this.detanotacreditos= new ArrayList<DetaNotaCredito>();
		this.detanotacredito= new DetaNotaCredito();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.notacreditosForeignKey=new ArrayList<NotaCredito>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.tipodetanotacreditosForeignKey=new ArrayList<TipoDetaNotaCredito>();
		this.tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.empaquesForeignKey=new ArrayList<Empaque>();
	} 
	
	public DetaNotaCredito getDetaNotaCredito() throws Exception {	
		return detanotacredito;
	}
		
	public void setDetaNotaCredito(DetaNotaCredito newDetaNotaCredito) {
		this.detanotacredito = newDetaNotaCredito;
	}
	
	public List<DetaNotaCredito> getDetaNotaCreditos() throws Exception {		
		return detanotacreditos;
	}
	
	public void setDetaNotaCreditos(List<DetaNotaCredito> newDetaNotaCreditos) {
		this.detanotacreditos = newDetaNotaCreditos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<NotaCredito> getnotacreditosForeignKey() {
		return this.notacreditosForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<TipoDetaNotaCredito> gettipodetanotacreditosForeignKey() {
		return this.tipodetanotacreditosForeignKey;
	}

	public List<TipoDevolucionEmpresa> gettipodevolucionempresasForeignKey() {
		return this.tipodevolucionempresasForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Empaque> getempaquesForeignKey() {
		return this.empaquesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setnotacreditosForeignKey(List<NotaCredito> notacreditosForeignKey) {
		this.notacreditosForeignKey=notacreditosForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void settipodetanotacreditosForeignKey(List<TipoDetaNotaCredito> tipodetanotacreditosForeignKey) {
		this.tipodetanotacreditosForeignKey=tipodetanotacreditosForeignKey;
	}

	public void settipodevolucionempresasForeignKey(List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey) {
		this.tipodevolucionempresasForeignKey=tipodevolucionempresasForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setempaquesForeignKey(List<Empaque> empaquesForeignKey) {
		this.empaquesForeignKey=empaquesForeignKey;
	}
}

