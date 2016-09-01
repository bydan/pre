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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.TransaccionConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//Transaccion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


@SuppressWarnings("unused")
public class TransaccionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Transaccion transaccion;	
	protected List<Transaccion> transaccions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoTransa> tipotransasForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public TransaccionParameterReturnGeneral () throws Exception {						
		super();
		this.transaccions= new ArrayList<Transaccion>();
		this.transaccion= new Transaccion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipotransasForeignKey=new ArrayList<TipoTransa>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public Transaccion getTransaccion() throws Exception {	
		return transaccion;
	}
		
	public void setTransaccion(Transaccion newTransaccion) {
		this.transaccion = newTransaccion;
	}
	
	public List<Transaccion> getTransaccions() throws Exception {		
		return transaccions;
	}
	
	public void setTransaccions(List<Transaccion> newTransaccions) {
		this.transaccions = newTransaccions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoTransa> gettipotransasForeignKey() {
		return this.tipotransasForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantesForeignKey() {
		return this.tipocomprobantesForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipotransasForeignKey(List<TipoTransa> tipotransasForeignKey) {
		this.tipotransasForeignKey=tipotransasForeignKey;
	}

	public void settipocomprobantesForeignKey(List<TipoComprobante> tipocomprobantesForeignKey) {
		this.tipocomprobantesForeignKey=tipocomprobantesForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

