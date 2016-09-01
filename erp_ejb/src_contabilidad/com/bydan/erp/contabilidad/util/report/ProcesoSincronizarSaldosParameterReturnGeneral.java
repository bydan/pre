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
import com.bydan.erp.contabilidad.util.report.ProcesoSincronizarSaldosConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//ProcesoSincronizarSaldos


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoSincronizarSaldosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoSincronizarSaldos procesosincronizarsaldos;	
	protected List<ProcesoSincronizarSaldos> procesosincronizarsaldoss;
	
	
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	
	public ProcesoSincronizarSaldosParameterReturnGeneral () throws Exception {						
		super();
		this.procesosincronizarsaldoss= new ArrayList<ProcesoSincronizarSaldos>();
		this.procesosincronizarsaldos= new ProcesoSincronizarSaldos();
		
		
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
	} 
	
	public ProcesoSincronizarSaldos getProcesoSincronizarSaldos() throws Exception {	
		return procesosincronizarsaldos;
	}
		
	public void setProcesoSincronizarSaldos(ProcesoSincronizarSaldos newProcesoSincronizarSaldos) {
		this.procesosincronizarsaldos = newProcesoSincronizarSaldos;
	}
	
	public List<ProcesoSincronizarSaldos> getProcesoSincronizarSaldoss() throws Exception {		
		return procesosincronizarsaldoss;
	}
	
	public void setProcesoSincronizarSaldoss(List<ProcesoSincronizarSaldos> newProcesoSincronizarSaldoss) {
		this.procesosincronizarsaldoss = newProcesoSincronizarSaldoss;
	}
	
	

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}
	
	

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}
}

