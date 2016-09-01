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
import com.bydan.erp.contabilidad.util.report.TotalSaldosConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//TotalSaldos


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TotalSaldosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TotalSaldos totalsaldos;	
	protected List<TotalSaldos> totalsaldoss;
	
	
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public TotalSaldosParameterReturnGeneral () throws Exception {						
		super();
		this.totalsaldoss= new ArrayList<TotalSaldos>();
		this.totalsaldos= new TotalSaldos();
		
		
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TotalSaldos getTotalSaldos() throws Exception {	
		return totalsaldos;
	}
		
	public void setTotalSaldos(TotalSaldos newTotalSaldos) {
		this.totalsaldos = newTotalSaldos;
	}
	
	public List<TotalSaldos> getTotalSaldoss() throws Exception {		
		return totalsaldoss;
	}
	
	public void setTotalSaldoss(List<TotalSaldos> newTotalSaldoss) {
		this.totalsaldoss = newTotalSaldoss;
	}
	
	

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

