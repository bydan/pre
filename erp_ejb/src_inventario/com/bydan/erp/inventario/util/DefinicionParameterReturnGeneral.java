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
import com.bydan.erp.inventario.util.DefinicionConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Definicion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class DefinicionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Definicion definicion;	
	protected List<Definicion> definicions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoDefinicion> tipodefinicionsForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoIvaItem> tipoivaitemsForeignKey;
	public List<TipoGlobalCliente> tipoglobalclientesForeignKey;
	public List<TipoCosteoDefinicion> tipocosteodefinicionsForeignKey;
	public List<TipoCostoDefinicion> tipocostodefinicionsForeignKey;
	public List<Formato> formatosForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<LibroContable> librocontablesForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public DefinicionParameterReturnGeneral () throws Exception {						
		super();
		this.definicions= new ArrayList<Definicion>();
		this.definicion= new Definicion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipodefinicionsForeignKey=new ArrayList<TipoDefinicion>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipoivaitemsForeignKey=new ArrayList<TipoIvaItem>();
		this.tipoglobalclientesForeignKey=new ArrayList<TipoGlobalCliente>();
		this.tipocosteodefinicionsForeignKey=new ArrayList<TipoCosteoDefinicion>();
		this.tipocostodefinicionsForeignKey=new ArrayList<TipoCostoDefinicion>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.librocontablesForeignKey=new ArrayList<LibroContable>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public Definicion getDefinicion() throws Exception {	
		return definicion;
	}
		
	public void setDefinicion(Definicion newDefinicion) {
		this.definicion = newDefinicion;
	}
	
	public List<Definicion> getDefinicions() throws Exception {		
		return definicions;
	}
	
	public void setDefinicions(List<Definicion> newDefinicions) {
		this.definicions = newDefinicions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoDefinicion> gettipodefinicionsForeignKey() {
		return this.tipodefinicionsForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoIvaItem> gettipoivaitemsForeignKey() {
		return this.tipoivaitemsForeignKey;
	}

	public List<TipoGlobalCliente> gettipoglobalclientesForeignKey() {
		return this.tipoglobalclientesForeignKey;
	}

	public List<TipoCosteoDefinicion> gettipocosteodefinicionsForeignKey() {
		return this.tipocosteodefinicionsForeignKey;
	}

	public List<TipoCostoDefinicion> gettipocostodefinicionsForeignKey() {
		return this.tipocostodefinicionsForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<TipoTributario> gettipotributariosForeignKey() {
		return this.tipotributariosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<LibroContable> getlibrocontablesForeignKey() {
		return this.librocontablesForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipodefinicionsForeignKey(List<TipoDefinicion> tipodefinicionsForeignKey) {
		this.tipodefinicionsForeignKey=tipodefinicionsForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipoivaitemsForeignKey(List<TipoIvaItem> tipoivaitemsForeignKey) {
		this.tipoivaitemsForeignKey=tipoivaitemsForeignKey;
	}

	public void settipoglobalclientesForeignKey(List<TipoGlobalCliente> tipoglobalclientesForeignKey) {
		this.tipoglobalclientesForeignKey=tipoglobalclientesForeignKey;
	}

	public void settipocosteodefinicionsForeignKey(List<TipoCosteoDefinicion> tipocosteodefinicionsForeignKey) {
		this.tipocosteodefinicionsForeignKey=tipocosteodefinicionsForeignKey;
	}

	public void settipocostodefinicionsForeignKey(List<TipoCostoDefinicion> tipocostodefinicionsForeignKey) {
		this.tipocostodefinicionsForeignKey=tipocostodefinicionsForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void settipotributariosForeignKey(List<TipoTributario> tipotributariosForeignKey) {
		this.tipotributariosForeignKey=tipotributariosForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void setlibrocontablesForeignKey(List<LibroContable> librocontablesForeignKey) {
		this.librocontablesForeignKey=librocontablesForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

