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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.SriDetalladosIvaConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//SriDetalladosIva


import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SriDetalladosIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SriDetalladosIva sridetalladosiva;	
	protected List<SriDetalladosIva> sridetalladosivas;
	
	
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoRetencion> tiporetencionivasForeignKey;
	public List<TipoRetencion> tiporetencionivaprestasForeignKey;
	
	public SriDetalladosIvaParameterReturnGeneral () throws Exception {						
		super();
		this.sridetalladosivas= new ArrayList<SriDetalladosIva>();
		this.sridetalladosiva= new SriDetalladosIva();
		
		
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tiporetencionivasForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencion>();
	} 
	
	public SriDetalladosIva getSriDetalladosIva() throws Exception {	
		return sridetalladosiva;
	}
		
	public void setSriDetalladosIva(SriDetalladosIva newSriDetalladosIva) {
		this.sridetalladosiva = newSriDetalladosIva;
	}
	
	public List<SriDetalladosIva> getSriDetalladosIvas() throws Exception {		
		return sridetalladosivas;
	}
	
	public void setSriDetalladosIvas(List<SriDetalladosIva> newSriDetalladosIvas) {
		this.sridetalladosivas = newSriDetalladosIvas;
	}
	
	

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantesForeignKey() {
		return this.tipocomprobantesForeignKey;
	}

	public List<TipoIva> gettipoivasForeignKey() {
		return this.tipoivasForeignKey;
	}

	public List<TipoRetencion> gettiporetencionivasForeignKey() {
		return this.tiporetencionivasForeignKey;
	}

	public List<TipoRetencion> gettiporetencionivaprestasForeignKey() {
		return this.tiporetencionivaprestasForeignKey;
	}
	
	

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void settipocomprobantesForeignKey(List<TipoComprobante> tipocomprobantesForeignKey) {
		this.tipocomprobantesForeignKey=tipocomprobantesForeignKey;
	}

	public void settipoivasForeignKey(List<TipoIva> tipoivasForeignKey) {
		this.tipoivasForeignKey=tipoivasForeignKey;
	}

	public void settiporetencionivasForeignKey(List<TipoRetencion> tiporetencionivasForeignKey) {
		this.tiporetencionivasForeignKey=tiporetencionivasForeignKey;
	}

	public void settiporetencionivaprestasForeignKey(List<TipoRetencion> tiporetencionivaprestasForeignKey) {
		this.tiporetencionivaprestasForeignKey=tiporetencionivaprestasForeignKey;
	}
}

