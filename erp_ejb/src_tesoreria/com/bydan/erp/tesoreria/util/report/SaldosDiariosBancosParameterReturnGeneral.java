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
package com.bydan.erp.tesoreria.util.report;

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
import com.bydan.erp.tesoreria.util.report.SaldosDiariosBancosConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//SaldosDiariosBancos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SaldosDiariosBancosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SaldosDiariosBancos saldosdiariosbancos;	
	protected List<SaldosDiariosBancos> saldosdiariosbancoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	
	public SaldosDiariosBancosParameterReturnGeneral () throws Exception {						
		super();
		this.saldosdiariosbancoss= new ArrayList<SaldosDiariosBancos>();
		this.saldosdiariosbancos= new SaldosDiariosBancos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
	} 
	
	public SaldosDiariosBancos getSaldosDiariosBancos() throws Exception {	
		return saldosdiariosbancos;
	}
		
	public void setSaldosDiariosBancos(SaldosDiariosBancos newSaldosDiariosBancos) {
		this.saldosdiariosbancos = newSaldosDiariosBancos;
	}
	
	public List<SaldosDiariosBancos> getSaldosDiariosBancoss() throws Exception {		
		return saldosdiariosbancoss;
	}
	
	public void setSaldosDiariosBancoss(List<SaldosDiariosBancos> newSaldosDiariosBancoss) {
		this.saldosdiariosbancoss = newSaldosDiariosBancoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}
}

