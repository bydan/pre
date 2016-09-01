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
import com.bydan.erp.sris.util.report.SriFacturasProveedoresIva012ConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//SriFacturasProveedoresIva012


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SriFacturasProveedoresIva012ParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SriFacturasProveedoresIva012 srifacturasproveedoresiva012;	
	protected List<SriFacturasProveedoresIva012> srifacturasproveedoresiva012s;
	
	
	public List<Empresa> empresasForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<TipoIva> tipoivasForeignKey;
	public List<TipoRetencion> tiporetencionivasForeignKey;
	public List<TipoRetencion> tiporetencionivaprestasForeignKey;
	
	public SriFacturasProveedoresIva012ParameterReturnGeneral () throws Exception {						
		super();
		this.srifacturasproveedoresiva012s= new ArrayList<SriFacturasProveedoresIva012>();
		this.srifacturasproveedoresiva012= new SriFacturasProveedoresIva012();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.tipoivasForeignKey=new ArrayList<TipoIva>();
		this.tiporetencionivasForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionivaprestasForeignKey=new ArrayList<TipoRetencion>();
	} 
	
	public SriFacturasProveedoresIva012 getSriFacturasProveedoresIva012() throws Exception {	
		return srifacturasproveedoresiva012;
	}
		
	public void setSriFacturasProveedoresIva012(SriFacturasProveedoresIva012 newSriFacturasProveedoresIva012) {
		this.srifacturasproveedoresiva012 = newSriFacturasProveedoresIva012;
	}
	
	public List<SriFacturasProveedoresIva012> getSriFacturasProveedoresIva012s() throws Exception {		
		return srifacturasproveedoresiva012s;
	}
	
	public void setSriFacturasProveedoresIva012s(List<SriFacturasProveedoresIva012> newSriFacturasProveedoresIva012s) {
		this.srifacturasproveedoresiva012s = newSriFacturasProveedoresIva012s;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
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

