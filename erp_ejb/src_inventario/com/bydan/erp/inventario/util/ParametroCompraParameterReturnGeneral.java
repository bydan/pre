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
import com.bydan.erp.inventario.util.ParametroCompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ParametroCompra


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class ParametroCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroCompra parametrocompra;	
	protected List<ParametroCompra> parametrocompras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoDocumento> tipodocumentosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Bodega> bodegareservasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Embarcador> embarcadorsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoMovimientoModulo> tipomovimientomodulosForeignKey;
	public List<Formato> formatopedidosForeignKey;
	public List<EstadoPedido> estadopedidopendientesForeignKey;
	public List<Formato> formatocotizacionsForeignKey;
	public List<EstadoPedido> estadopedidocotizadosForeignKey;
	public List<Formato> formatoautorizacionsForeignKey;
	public List<EstadoPedido> estadopedidoautorizadosForeignKey;
	public List<Formato> formatoitemsForeignKey;
	public List<EstadoPedido> estadopedidoanuladosForeignKey;
	public List<PrioridadPedido> prioridadpedidosForeignKey;
	public List<EstadoPedido> estadopedidosuspendidosForeignKey;
	public List<EstadoPedido> estadopedidoregularizadosForeignKey;
	
	public ParametroCompraParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocompras= new ArrayList<ParametroCompra>();
		this.parametrocompra= new ParametroCompra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.bodegareservasForeignKey=new ArrayList<Bodega>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.embarcadorsForeignKey=new ArrayList<Embarcador>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
		this.formatopedidosForeignKey=new ArrayList<Formato>();
		this.estadopedidopendientesForeignKey=new ArrayList<EstadoPedido>();
		this.formatocotizacionsForeignKey=new ArrayList<Formato>();
		this.estadopedidocotizadosForeignKey=new ArrayList<EstadoPedido>();
		this.formatoautorizacionsForeignKey=new ArrayList<Formato>();
		this.estadopedidoautorizadosForeignKey=new ArrayList<EstadoPedido>();
		this.formatoitemsForeignKey=new ArrayList<Formato>();
		this.estadopedidoanuladosForeignKey=new ArrayList<EstadoPedido>();
		this.prioridadpedidosForeignKey=new ArrayList<PrioridadPedido>();
		this.estadopedidosuspendidosForeignKey=new ArrayList<EstadoPedido>();
		this.estadopedidoregularizadosForeignKey=new ArrayList<EstadoPedido>();
	} 
	
	public ParametroCompra getParametroCompra() throws Exception {	
		return parametrocompra;
	}
		
	public void setParametroCompra(ParametroCompra newParametroCompra) {
		this.parametrocompra = newParametroCompra;
	}
	
	public List<ParametroCompra> getParametroCompras() throws Exception {		
		return parametrocompras;
	}
	
	public void setParametroCompras(List<ParametroCompra> newParametroCompras) {
		this.parametrocompras = newParametroCompras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Bodega> getbodegareservasForeignKey() {
		return this.bodegareservasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Embarcador> getembarcadorsForeignKey() {
		return this.embarcadorsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoMovimientoModulo> gettipomovimientomodulosForeignKey() {
		return this.tipomovimientomodulosForeignKey;
	}

	public List<Formato> getformatopedidosForeignKey() {
		return this.formatopedidosForeignKey;
	}

	public List<EstadoPedido> getestadopedidopendientesForeignKey() {
		return this.estadopedidopendientesForeignKey;
	}

	public List<Formato> getformatocotizacionsForeignKey() {
		return this.formatocotizacionsForeignKey;
	}

	public List<EstadoPedido> getestadopedidocotizadosForeignKey() {
		return this.estadopedidocotizadosForeignKey;
	}

	public List<Formato> getformatoautorizacionsForeignKey() {
		return this.formatoautorizacionsForeignKey;
	}

	public List<EstadoPedido> getestadopedidoautorizadosForeignKey() {
		return this.estadopedidoautorizadosForeignKey;
	}

	public List<Formato> getformatoitemsForeignKey() {
		return this.formatoitemsForeignKey;
	}

	public List<EstadoPedido> getestadopedidoanuladosForeignKey() {
		return this.estadopedidoanuladosForeignKey;
	}

	public List<PrioridadPedido> getprioridadpedidosForeignKey() {
		return this.prioridadpedidosForeignKey;
	}

	public List<EstadoPedido> getestadopedidosuspendidosForeignKey() {
		return this.estadopedidosuspendidosForeignKey;
	}

	public List<EstadoPedido> getestadopedidoregularizadosForeignKey() {
		return this.estadopedidoregularizadosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setbodegareservasForeignKey(List<Bodega> bodegareservasForeignKey) {
		this.bodegareservasForeignKey=bodegareservasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setembarcadorsForeignKey(List<Embarcador> embarcadorsForeignKey) {
		this.embarcadorsForeignKey=embarcadorsForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipomovimientomodulosForeignKey(List<TipoMovimientoModulo> tipomovimientomodulosForeignKey) {
		this.tipomovimientomodulosForeignKey=tipomovimientomodulosForeignKey;
	}

	public void setformatopedidosForeignKey(List<Formato> formatopedidosForeignKey) {
		this.formatopedidosForeignKey=formatopedidosForeignKey;
	}

	public void setestadopedidopendientesForeignKey(List<EstadoPedido> estadopedidopendientesForeignKey) {
		this.estadopedidopendientesForeignKey=estadopedidopendientesForeignKey;
	}

	public void setformatocotizacionsForeignKey(List<Formato> formatocotizacionsForeignKey) {
		this.formatocotizacionsForeignKey=formatocotizacionsForeignKey;
	}

	public void setestadopedidocotizadosForeignKey(List<EstadoPedido> estadopedidocotizadosForeignKey) {
		this.estadopedidocotizadosForeignKey=estadopedidocotizadosForeignKey;
	}

	public void setformatoautorizacionsForeignKey(List<Formato> formatoautorizacionsForeignKey) {
		this.formatoautorizacionsForeignKey=formatoautorizacionsForeignKey;
	}

	public void setestadopedidoautorizadosForeignKey(List<EstadoPedido> estadopedidoautorizadosForeignKey) {
		this.estadopedidoautorizadosForeignKey=estadopedidoautorizadosForeignKey;
	}

	public void setformatoitemsForeignKey(List<Formato> formatoitemsForeignKey) {
		this.formatoitemsForeignKey=formatoitemsForeignKey;
	}

	public void setestadopedidoanuladosForeignKey(List<EstadoPedido> estadopedidoanuladosForeignKey) {
		this.estadopedidoanuladosForeignKey=estadopedidoanuladosForeignKey;
	}

	public void setprioridadpedidosForeignKey(List<PrioridadPedido> prioridadpedidosForeignKey) {
		this.prioridadpedidosForeignKey=prioridadpedidosForeignKey;
	}

	public void setestadopedidosuspendidosForeignKey(List<EstadoPedido> estadopedidosuspendidosForeignKey) {
		this.estadopedidosuspendidosForeignKey=estadopedidosuspendidosForeignKey;
	}

	public void setestadopedidoregularizadosForeignKey(List<EstadoPedido> estadopedidoregularizadosForeignKey) {
		this.estadopedidoregularizadosForeignKey=estadopedidoregularizadosForeignKey;
	}
}

