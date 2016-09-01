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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.SriConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//Sri


import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class SriParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Sri sri;	
	protected List<Sri> sris;
	
	
	public List<AsientoContable> asientocontablesForeignKey;
	public List<TransaccionConta> transaccioncontasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	public List<TipoTributario> tipotributariosForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoRetencionIva> tiporetencionivabiensForeignKey;
	public List<TipoRetencionIva> tiporetencionivaserviciosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	
	public SriParameterReturnGeneral () throws Exception {						
		super();
		this.sris= new ArrayList<Sri>();
		this.sri= new Sri();
		
		
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
		this.transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
		this.tipotributariosForeignKey=new ArrayList<TipoTributario>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tiporetencionivabiensForeignKey=new ArrayList<TipoRetencionIva>();
		this.tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencionIva>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
	} 
	
	public Sri getSri() throws Exception {	
		return sri;
	}
		
	public void setSri(Sri newSri) {
		this.sri = newSri;
	}
	
	public List<Sri> getSris() throws Exception {		
		return sris;
	}
	
	public void setSris(List<Sri> newSris) {
		this.sris = newSris;
	}
	
	

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
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

	public List<TipoIva> gettipoivasForeignKey() {
		return this.tipoivasForeignKey;
	}

	public List<TipoRetencionIva> gettiporetencionivabiensForeignKey() {
		return this.tiporetencionivabiensForeignKey;
	}

	public List<TipoRetencionIva> gettiporetencionivaserviciosForeignKey() {
		return this.tiporetencionivaserviciosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}
	
	

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
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

	public void settipoivasForeignKey(List<TipoIva> tipoivasForeignKey) {
		this.tipoivasForeignKey=tipoivasForeignKey;
	}

	public void settiporetencionivabiensForeignKey(List<TipoRetencionIva> tiporetencionivabiensForeignKey) {
		this.tiporetencionivabiensForeignKey=tiporetencionivabiensForeignKey;
	}

	public void settiporetencionivaserviciosForeignKey(List<TipoRetencionIva> tiporetencionivaserviciosForeignKey) {
		this.tiporetencionivaserviciosForeignKey=tiporetencionivaserviciosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}
}

