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
import com.bydan.erp.inventario.util.CuentasContablesLineaProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//CuentasContablesLineaProducto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentasContablesLineaProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentasContablesLineaProducto cuentascontableslineaproducto;	
	protected List<CuentasContablesLineaProducto> cuentascontableslineaproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<CuentaContable> cuentacontableinventariosForeignKey;
	public List<CuentaContable> cuentacontablecostoventasForeignKey;
	public List<CuentaContable> cuentacontableventasForeignKey;
	public List<CuentaContable> cuentacontabledescuentosForeignKey;
	public List<CuentaContable> cuentacontableproduccionsForeignKey;
	public List<CuentaContable> cuentacontabledevolucionsForeignKey;
	public List<CuentaContable> cuentacontableivadebitosForeignKey;
	public List<CuentaContable> cuentacontableivacreditosForeignKey;
	public List<CuentaContable> cuentacontablebonificasForeignKey;
	public List<CuentaContable> cuentacontablecostobonificasForeignKey;
	
	public CuentasContablesLineaProductoParameterReturnGeneral () throws Exception {						
		super();
		this.cuentascontableslineaproductos= new ArrayList<CuentasContablesLineaProducto>();
		this.cuentascontableslineaproducto= new CuentasContablesLineaProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.cuentacontableinventariosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostoventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableventasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledescuentosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableproduccionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledevolucionsForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableivadebitosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontableivacreditosForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablebonificasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecostobonificasForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public CuentasContablesLineaProducto getCuentasContablesLineaProducto() throws Exception {	
		return cuentascontableslineaproducto;
	}
		
	public void setCuentasContablesLineaProducto(CuentasContablesLineaProducto newCuentasContablesLineaProducto) {
		this.cuentascontableslineaproducto = newCuentasContablesLineaProducto;
	}
	
	public List<CuentasContablesLineaProducto> getCuentasContablesLineaProductos() throws Exception {		
		return cuentascontableslineaproductos;
	}
	
	public void setCuentasContablesLineaProductos(List<CuentasContablesLineaProducto> newCuentasContablesLineaProductos) {
		this.cuentascontableslineaproductos = newCuentasContablesLineaProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}

	public List<Linea> getlineacategoriasForeignKey() {
		return this.lineacategoriasForeignKey;
	}

	public List<CuentaContable> getcuentacontableinventariosForeignKey() {
		return this.cuentacontableinventariosForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostoventasForeignKey() {
		return this.cuentacontablecostoventasForeignKey;
	}

	public List<CuentaContable> getcuentacontableventasForeignKey() {
		return this.cuentacontableventasForeignKey;
	}

	public List<CuentaContable> getcuentacontabledescuentosForeignKey() {
		return this.cuentacontabledescuentosForeignKey;
	}

	public List<CuentaContable> getcuentacontableproduccionsForeignKey() {
		return this.cuentacontableproduccionsForeignKey;
	}

	public List<CuentaContable> getcuentacontabledevolucionsForeignKey() {
		return this.cuentacontabledevolucionsForeignKey;
	}

	public List<CuentaContable> getcuentacontableivadebitosForeignKey() {
		return this.cuentacontableivadebitosForeignKey;
	}

	public List<CuentaContable> getcuentacontableivacreditosForeignKey() {
		return this.cuentacontableivacreditosForeignKey;
	}

	public List<CuentaContable> getcuentacontablebonificasForeignKey() {
		return this.cuentacontablebonificasForeignKey;
	}

	public List<CuentaContable> getcuentacontablecostobonificasForeignKey() {
		return this.cuentacontablecostobonificasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}

	public void setlineacategoriasForeignKey(List<Linea> lineacategoriasForeignKey) {
		this.lineacategoriasForeignKey=lineacategoriasForeignKey;
	}

	public void setcuentacontableinventariosForeignKey(List<CuentaContable> cuentacontableinventariosForeignKey) {
		this.cuentacontableinventariosForeignKey=cuentacontableinventariosForeignKey;
	}

	public void setcuentacontablecostoventasForeignKey(List<CuentaContable> cuentacontablecostoventasForeignKey) {
		this.cuentacontablecostoventasForeignKey=cuentacontablecostoventasForeignKey;
	}

	public void setcuentacontableventasForeignKey(List<CuentaContable> cuentacontableventasForeignKey) {
		this.cuentacontableventasForeignKey=cuentacontableventasForeignKey;
	}

	public void setcuentacontabledescuentosForeignKey(List<CuentaContable> cuentacontabledescuentosForeignKey) {
		this.cuentacontabledescuentosForeignKey=cuentacontabledescuentosForeignKey;
	}

	public void setcuentacontableproduccionsForeignKey(List<CuentaContable> cuentacontableproduccionsForeignKey) {
		this.cuentacontableproduccionsForeignKey=cuentacontableproduccionsForeignKey;
	}

	public void setcuentacontabledevolucionsForeignKey(List<CuentaContable> cuentacontabledevolucionsForeignKey) {
		this.cuentacontabledevolucionsForeignKey=cuentacontabledevolucionsForeignKey;
	}

	public void setcuentacontableivadebitosForeignKey(List<CuentaContable> cuentacontableivadebitosForeignKey) {
		this.cuentacontableivadebitosForeignKey=cuentacontableivadebitosForeignKey;
	}

	public void setcuentacontableivacreditosForeignKey(List<CuentaContable> cuentacontableivacreditosForeignKey) {
		this.cuentacontableivacreditosForeignKey=cuentacontableivacreditosForeignKey;
	}

	public void setcuentacontablebonificasForeignKey(List<CuentaContable> cuentacontablebonificasForeignKey) {
		this.cuentacontablebonificasForeignKey=cuentacontablebonificasForeignKey;
	}

	public void setcuentacontablecostobonificasForeignKey(List<CuentaContable> cuentacontablecostobonificasForeignKey) {
		this.cuentacontablecostobonificasForeignKey=cuentacontablecostobonificasForeignKey;
	}
}

