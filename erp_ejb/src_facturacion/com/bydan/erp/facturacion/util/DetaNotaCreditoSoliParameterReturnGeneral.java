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
import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetaNotaCreditoSoli


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class DetaNotaCreditoSoliParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetaNotaCreditoSoli detanotacreditosoli;	
	protected List<DetaNotaCreditoSoli> detanotacreditosolis;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<NotaCreditoSoli> notacreditosolisForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<Empaque> empaquesForeignKey;
	public List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	
	public DetaNotaCreditoSoliParameterReturnGeneral () throws Exception {						
		super();
		this.detanotacreditosolis= new ArrayList<DetaNotaCreditoSoli>();
		this.detanotacreditosoli= new DetaNotaCreditoSoli();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.notacreditosolisForeignKey=new ArrayList<NotaCreditoSoli>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.empaquesForeignKey=new ArrayList<Empaque>();
		this.tipodevolucionempresasForeignKey=new ArrayList<TipoDevolucionEmpresa>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
	} 
	
	public DetaNotaCreditoSoli getDetaNotaCreditoSoli() throws Exception {	
		return detanotacreditosoli;
	}
		
	public void setDetaNotaCreditoSoli(DetaNotaCreditoSoli newDetaNotaCreditoSoli) {
		this.detanotacreditosoli = newDetaNotaCreditoSoli;
	}
	
	public List<DetaNotaCreditoSoli> getDetaNotaCreditoSolis() throws Exception {		
		return detanotacreditosolis;
	}
	
	public void setDetaNotaCreditoSolis(List<DetaNotaCreditoSoli> newDetaNotaCreditoSolis) {
		this.detanotacreditosolis = newDetaNotaCreditoSolis;
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

	public List<NotaCreditoSoli> getnotacreditosolisForeignKey() {
		return this.notacreditosolisForeignKey;
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

	public List<Empaque> getempaquesForeignKey() {
		return this.empaquesForeignKey;
	}

	public List<TipoDevolucionEmpresa> gettipodevolucionempresasForeignKey() {
		return this.tipodevolucionempresasForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
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

	public void setnotacreditosolisForeignKey(List<NotaCreditoSoli> notacreditosolisForeignKey) {
		this.notacreditosolisForeignKey=notacreditosolisForeignKey;
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

	public void setempaquesForeignKey(List<Empaque> empaquesForeignKey) {
		this.empaquesForeignKey=empaquesForeignKey;
	}

	public void settipodevolucionempresasForeignKey(List<TipoDevolucionEmpresa> tipodevolucionempresasForeignKey) {
		this.tipodevolucionempresasForeignKey=tipodevolucionempresasForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}
}

