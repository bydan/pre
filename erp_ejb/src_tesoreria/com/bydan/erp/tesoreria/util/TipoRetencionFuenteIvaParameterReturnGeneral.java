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
import com.bydan.erp.tesoreria.util.TipoRetencionFuenteIvaConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoRetencionFuenteIva


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoRetencionFuenteIvaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoRetencionFuenteIva tiporetencionfuenteiva;	
	protected List<TipoRetencionFuenteIva> tiporetencionfuenteivas;
	
	
	public List<Pais> paissForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CuentaContable> cuentacontablecreditosForeignKey;
	
	public TipoRetencionFuenteIvaParameterReturnGeneral () throws Exception {						
		super();
		this.tiporetencionfuenteivas= new ArrayList<TipoRetencionFuenteIva>();
		this.tiporetencionfuenteiva= new TipoRetencionFuenteIva();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TipoRetencionFuenteIva getTipoRetencionFuenteIva() throws Exception {	
		return tiporetencionfuenteiva;
	}
		
	public void setTipoRetencionFuenteIva(TipoRetencionFuenteIva newTipoRetencionFuenteIva) {
		this.tiporetencionfuenteiva = newTipoRetencionFuenteIva;
	}
	
	public List<TipoRetencionFuenteIva> getTipoRetencionFuenteIvas() throws Exception {		
		return tiporetencionfuenteivas;
	}
	
	public void setTipoRetencionFuenteIvas(List<TipoRetencionFuenteIva> newTipoRetencionFuenteIvas) {
		this.tiporetencionfuenteivas = newTipoRetencionFuenteIvas;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditosForeignKey() {
		return this.cuentacontablecreditosForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcuentacontablecreditosForeignKey(List<CuentaContable> cuentacontablecreditosForeignKey) {
		this.cuentacontablecreditosForeignKey=cuentacontablecreditosForeignKey;
	}
}

