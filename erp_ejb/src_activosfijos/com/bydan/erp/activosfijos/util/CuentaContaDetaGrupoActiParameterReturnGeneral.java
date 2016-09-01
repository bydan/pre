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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.CuentaContaDetaGrupoActiConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//CuentaContaDetaGrupoActi


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaContaDetaGrupoActiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaContaDetaGrupoActi cuentacontadetagrupoacti;	
	protected List<CuentaContaDetaGrupoActi> cuentacontadetagrupoactis;
	
	
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey;
	
	public CuentaContaDetaGrupoActiParameterReturnGeneral () throws Exception {						
		super();
		this.cuentacontadetagrupoactis= new ArrayList<CuentaContaDetaGrupoActi>();
		this.cuentacontadetagrupoacti= new CuentaContaDetaGrupoActi();
		
		
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
	} 
	
	public CuentaContaDetaGrupoActi getCuentaContaDetaGrupoActi() throws Exception {	
		return cuentacontadetagrupoacti;
	}
		
	public void setCuentaContaDetaGrupoActi(CuentaContaDetaGrupoActi newCuentaContaDetaGrupoActi) {
		this.cuentacontadetagrupoacti = newCuentaContaDetaGrupoActi;
	}
	
	public List<CuentaContaDetaGrupoActi> getCuentaContaDetaGrupoActis() throws Exception {		
		return cuentacontadetagrupoactis;
	}
	
	public void setCuentaContaDetaGrupoActis(List<CuentaContaDetaGrupoActi> newCuentaContaDetaGrupoActis) {
		this.cuentacontadetagrupoactis = newCuentaContaDetaGrupoActis;
	}
	
	

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<DetalleGrupoActivoFijo> getdetallegrupoactivofijosForeignKey() {
		return this.detallegrupoactivofijosForeignKey;
	}
	
	

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setdetallegrupoactivofijosForeignKey(List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey) {
		this.detallegrupoactivofijosForeignKey=detallegrupoactivofijosForeignKey;
	}
}

