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
import com.bydan.erp.sris.util.RetencionVentaConstantesFunciones;

import com.bydan.erp.sris.business.entity.*;//RetencionVenta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class RetencionVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RetencionVenta retencionventa;	
	protected List<RetencionVenta> retencionventas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	
	public RetencionVentaParameterReturnGeneral () throws Exception {						
		super();
		this.retencionventas= new ArrayList<RetencionVenta>();
		this.retencionventa= new RetencionVenta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
	} 
	
	public RetencionVenta getRetencionVenta() throws Exception {	
		return retencionventa;
	}
		
	public void setRetencionVenta(RetencionVenta newRetencionVenta) {
		this.retencionventa = newRetencionVenta;
	}
	
	public List<RetencionVenta> getRetencionVentas() throws Exception {		
		return retencionventas;
	}
	
	public void setRetencionVentas(List<RetencionVenta> newRetencionVentas) {
		this.retencionventas = newRetencionVentas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}
}

