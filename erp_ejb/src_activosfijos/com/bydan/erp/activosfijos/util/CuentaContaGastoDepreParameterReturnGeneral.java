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
import com.bydan.erp.activosfijos.util.CuentaContaGastoDepreConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//CuentaContaGastoDepre


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaContaGastoDepreParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaContaGastoDepre cuentacontagastodepre;	
	protected List<CuentaContaGastoDepre> cuentacontagastodepres;
	
	
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<GastoDepreciacion> gastodepreciacionsForeignKey;
	
	public CuentaContaGastoDepreParameterReturnGeneral () throws Exception {						
		super();
		this.cuentacontagastodepres= new ArrayList<CuentaContaGastoDepre>();
		this.cuentacontagastodepre= new CuentaContaGastoDepre();
		
		
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.gastodepreciacionsForeignKey=new ArrayList<GastoDepreciacion>();
	} 
	
	public CuentaContaGastoDepre getCuentaContaGastoDepre() throws Exception {	
		return cuentacontagastodepre;
	}
		
	public void setCuentaContaGastoDepre(CuentaContaGastoDepre newCuentaContaGastoDepre) {
		this.cuentacontagastodepre = newCuentaContaGastoDepre;
	}
	
	public List<CuentaContaGastoDepre> getCuentaContaGastoDepres() throws Exception {		
		return cuentacontagastodepres;
	}
	
	public void setCuentaContaGastoDepres(List<CuentaContaGastoDepre> newCuentaContaGastoDepres) {
		this.cuentacontagastodepres = newCuentaContaGastoDepres;
	}
	
	

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<GastoDepreciacion> getgastodepreciacionsForeignKey() {
		return this.gastodepreciacionsForeignKey;
	}
	
	

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setgastodepreciacionsForeignKey(List<GastoDepreciacion> gastodepreciacionsForeignKey) {
		this.gastodepreciacionsForeignKey=gastodepreciacionsForeignKey;
	}
}

