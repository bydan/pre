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
package com.bydan.erp.sris.util;

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
import com.bydan.erp.sris.util.TransaccionLocalConstantesFunciones;

import com.bydan.erp.sris.business.entity.*;//TransaccionLocal


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class TransaccionLocalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TransaccionLocal transaccionlocal;	
	protected List<TransaccionLocal> transaccionlocals;
	
	
	public List<Compra> comprasForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<TransaccionConta> transaccioncontasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoRetencionIva> tiporetencionivasForeignKey;
	public List<TipoRetencionIva> tiporetencionivaprestasForeignKey;
	
	public TransaccionLocalParameterReturnGeneral () throws Exception {						
		super();
		this.transaccionlocals= new ArrayList<TransaccionLocal>();
		this.transaccionlocal= new TransaccionLocal();
		
		
		this.comprasForeignKey=new ArrayList<Compra>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tiporetencionivasForeignKey=new ArrayList<TipoRetencionIva>();
		this.tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencionIva>();
	} 
	
	public TransaccionLocal getTransaccionLocal() throws Exception {	
		return transaccionlocal;
	}
		
	public void setTransaccionLocal(TransaccionLocal newTransaccionLocal) {
		this.transaccionlocal = newTransaccionLocal;
	}
	
	public List<TransaccionLocal> getTransaccionLocals() throws Exception {		
		return transaccionlocals;
	}
	
	public void setTransaccionLocals(List<TransaccionLocal> newTransaccionLocals) {
		this.transaccionlocals = newTransaccionLocals;
	}
	
	

	public List<Compra> getcomprasForeignKey() {
		return this.comprasForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<TransaccionConta> gettransaccioncontasForeignKey() {
		return this.transaccioncontasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantesForeignKey() {
		return this.tipocomprobantesForeignKey;
	}

	public List<TipoTributario> gettipotributariosForeignKey() {
		return this.tipotributariosForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
	}

	public List<TipoIva> gettipoivasForeignKey() {
		return this.tipoivasForeignKey;
	}

	public List<TipoRetencionIva> gettiporetencionivasForeignKey() {
		return this.tiporetencionivasForeignKey;
	}

	public List<TipoRetencionIva> gettiporetencionivaprestasForeignKey() {
		return this.tiporetencionivaprestasForeignKey;
	}
	
	

	public void setcomprasForeignKey(List<Compra> comprasForeignKey) {
		this.comprasForeignKey=comprasForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void settransaccioncontasForeignKey(List<TransaccionConta> transaccioncontasForeignKey) {
		this.transaccioncontasForeignKey=transaccioncontasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipocomprobantesForeignKey(List<TipoComprobante> tipocomprobantesForeignKey) {
		this.tipocomprobantesForeignKey=tipocomprobantesForeignKey;
	}

	public void settipotributariosForeignKey(List<TipoTributario> tipotributariosForeignKey) {
		this.tipotributariosForeignKey=tipotributariosForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}

	public void settipoivasForeignKey(List<TipoIva> tipoivasForeignKey) {
		this.tipoivasForeignKey=tipoivasForeignKey;
	}

	public void settiporetencionivasForeignKey(List<TipoRetencionIva> tiporetencionivasForeignKey) {
		this.tiporetencionivasForeignKey=tiporetencionivasForeignKey;
	}

	public void settiporetencionivaprestasForeignKey(List<TipoRetencionIva> tiporetencionivaprestasForeignKey) {
		this.tiporetencionivaprestasForeignKey=tiporetencionivaprestasForeignKey;
	}
}

