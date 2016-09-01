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
import com.bydan.erp.inventario.util.BodegaConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Bodega


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class BodegaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Bodega bodega;	
	protected List<Bodega> bodegas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<GrupoBodega> grupobodegasForeignKey;
	public List<CalidadProducto> calidadproductosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<CuentaContable> cuentacontableinventariosForeignKey;
	public List<CuentaContable> cuentacontablecostosForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	public List<CuentaContable> cuentacontabledescuentosForeignKey;
	public List<CuentaContable> cuentacontabledevolucionsForeignKey;
	public List<CuentaContable> cuentacontabledebitosForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	public List<CuentaContable> cuentacontablebonificasForeignKey;
	public List<CuentaContable> cuentacontableproduccionsForeignKey;
	public List<CuentaContable> cuentacontablecostobonificasForeignKey;
	
	public BodegaParameterReturnGeneral () throws Exception {						
		super();
		this.bodegas= new ArrayList<Bodega>();
		this.bodega= new Bodega();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.grupobodegasForeignKey=new ArrayList<GrupoBodega>();
		this.calidadproductosForeignKey=new ArrayList<CalidadProducto>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public Bodega getBodega() throws Exception {	
		return bodega;
	}
		
	public void setBodega(Bodega newBodega) {
		this.bodega = newBodega;
	}
	
	public List<Bodega> getBodegas() throws Exception {		
		return bodegas;
	}
	
	public void setBodegas(List<Bodega> newBodegas) {
		this.bodegas = newBodegas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<GrupoBodega> getgrupobodegasForeignKey() {
		return this.grupobodegasForeignKey;
	}

	public List<CalidadProducto> getcalidadproductosForeignKey() {
		return this.calidadproductosForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariosForeignKey() {
		return this.cuentacontableinventariosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostosForeignKey() {
		return this.cuentacontablecostosForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledescuentosForeignKey() {
		return this.cuentacontabledescuentosForeignKey;
	}

	public List<CuentaContable> getcuentacontabledevolucionsForeignKey() {
		return this.cuentacontabledevolucionsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledebitosForeignKey() {
		return this.cuentacontabledebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}

	public List<CuentaContable> getcuentacontablebonificasForeignKey() {
		return this.cuentacontablebonificasForeignKey;
	}

	public List<CuentaContable> getcuentacontableproduccionsForeignKey() {
		return this.cuentacontableproduccionsForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostobonificasForeignKey() {
		return this.cuentacontablecostobonificasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setgrupobodegasForeignKey(List<GrupoBodega> grupobodegasForeignKey) {
		this.grupobodegasForeignKey=grupobodegasForeignKey;
	}

	public void setcalidadproductosForeignKey(List<CalidadProducto> calidadproductosForeignKey) {
		this.calidadproductosForeignKey=calidadproductosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setcuentacontableinventariosForeignKey(List<CuentaContable> cuentacontableinventariosForeignKey) {
		this.cuentacontableinventariosForeignKey=cuentacontableinventariosForeignKey;
	}

	public void setcuentacontablecostosForeignKey(List<CuentaContable> cuentacontablecostosForeignKey) {
		this.cuentacontablecostosForeignKey=cuentacontablecostosForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}

	public void setcuentacontabledescuentosForeignKey(List<CuentaContable> cuentacontabledescuentosForeignKey) {
		this.cuentacontabledescuentosForeignKey=cuentacontabledescuentosForeignKey;
	}

	public void setcuentacontabledevolucionsForeignKey(List<CuentaContable> cuentacontabledevolucionsForeignKey) {
		this.cuentacontabledevolucionsForeignKey=cuentacontabledevolucionsForeignKey;
	}

	public void setcuentacontabledebitosForeignKey(List<CuentaContable> cuentacontabledebitosForeignKey) {
		this.cuentacontabledebitosForeignKey=cuentacontabledebitosForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}

	public void setcuentacontablebonificasForeignKey(List<CuentaContable> cuentacontablebonificasForeignKey) {
		this.cuentacontablebonificasForeignKey=cuentacontablebonificasForeignKey;
	}

	public void setcuentacontableproduccionsForeignKey(List<CuentaContable> cuentacontableproduccionsForeignKey) {
		this.cuentacontableproduccionsForeignKey=cuentacontableproduccionsForeignKey;
	}

	public void setcuentacontablecostobonificasForeignKey(List<CuentaContable> cuentacontablecostobonificasForeignKey) {
		this.cuentacontablecostobonificasForeignKey=cuentacontablecostobonificasForeignKey;
	}
}

