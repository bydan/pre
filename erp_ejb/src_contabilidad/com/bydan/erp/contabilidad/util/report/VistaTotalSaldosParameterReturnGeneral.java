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
package com.bydan.erp.contabilidad.util.report;

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
import com.bydan.erp.contabilidad.util.report.VistaTotalSaldosConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//VistaTotalSaldos


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class VistaTotalSaldosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected VistaTotalSaldos vistatotalsaldos;	
	protected List<VistaTotalSaldos> vistatotalsaldoss;
	
	
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public VistaTotalSaldosParameterReturnGeneral () throws Exception {						
		super();
		this.vistatotalsaldoss= new ArrayList<VistaTotalSaldos>();
		this.vistatotalsaldos= new VistaTotalSaldos();
		
		
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public VistaTotalSaldos getVistaTotalSaldos() throws Exception {	
		return vistatotalsaldos;
	}
		
	public void setVistaTotalSaldos(VistaTotalSaldos newVistaTotalSaldos) {
		this.vistatotalsaldos = newVistaTotalSaldos;
	}
	
	public List<VistaTotalSaldos> getVistaTotalSaldoss() throws Exception {		
		return vistatotalsaldoss;
	}
	
	public void setVistaTotalSaldoss(List<VistaTotalSaldos> newVistaTotalSaldoss) {
		this.vistatotalsaldoss = newVistaTotalSaldoss;
	}
	
	

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

