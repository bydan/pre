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
import com.bydan.erp.sris.util.report.SriComprasConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//SriCompras


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SriComprasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SriCompras sricompras;	
	protected List<SriCompras> sricomprass;
	
	
	public List<Empresa> empresasForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoRetencion> tiporetencionivasForeignKey;
	public List<TipoRetencion> tiporetencionivaprestasForeignKey;
	
	public SriComprasParameterReturnGeneral () throws Exception {						
		super();
		this.sricomprass= new ArrayList<SriCompras>();
		this.sricompras= new SriCompras();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tiporetencionivasForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencion>();
	} 
	
	public SriCompras getSriCompras() throws Exception {	
		return sricompras;
	}
		
	public void setSriCompras(SriCompras newSriCompras) {
		this.sricompras = newSriCompras;
	}
	
	public List<SriCompras> getSriComprass() throws Exception {		
		return sricomprass;
	}
	
	public void setSriComprass(List<SriCompras> newSriComprass) {
		this.sricomprass = newSriComprass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
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
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
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

