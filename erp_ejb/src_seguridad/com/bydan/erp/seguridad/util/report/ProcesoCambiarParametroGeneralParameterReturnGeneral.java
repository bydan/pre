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
package com.bydan.erp.seguridad.util.report;

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
import com.bydan.erp.seguridad.util.report.ProcesoCambiarParametroGeneralConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.report.*;//ProcesoCambiarParametroGeneral


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCambiarParametroGeneralParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCambiarParametroGeneral procesocambiarparametrogeneral;	
	protected List<ProcesoCambiarParametroGeneral> procesocambiarparametrogenerals;
	
	
	public List<TipoVisual> tipovisualsForeignKey;
	public List<TipoFondo> tipofondosForeignKey;
	public List<TipoFondo> tipofondobordesForeignKey;
	public List<TipoFondoControl> tipofondocontrolsForeignKey;
	public List<TipoTamanioControl> tipotamaniocontrolsForeignKey;
	public List<TipoExportar> tipoexportarsForeignKey;
	public List<TipoDelimiter> tipodelimitersForeignKey;
	
	public ProcesoCambiarParametroGeneralParameterReturnGeneral () throws Exception {						
		super();
		this.procesocambiarparametrogenerals= new ArrayList<ProcesoCambiarParametroGeneral>();
		this.procesocambiarparametrogeneral= new ProcesoCambiarParametroGeneral();
		
		
		this.tipovisualsForeignKey=new ArrayList<TipoVisual>();
		this.tipofondosForeignKey=new ArrayList<TipoFondo>();
		this.tipofondobordesForeignKey=new ArrayList<TipoFondo>();
		this.tipofondocontrolsForeignKey=new ArrayList<TipoFondoControl>();
		this.tipotamaniocontrolsForeignKey=new ArrayList<TipoTamanioControl>();
		this.tipoexportarsForeignKey=new ArrayList<TipoExportar>();
		this.tipodelimitersForeignKey=new ArrayList<TipoDelimiter>();
	} 
	
	public ProcesoCambiarParametroGeneral getProcesoCambiarParametroGeneral() throws Exception {	
		return procesocambiarparametrogeneral;
	}
		
	public void setProcesoCambiarParametroGeneral(ProcesoCambiarParametroGeneral newProcesoCambiarParametroGeneral) {
		this.procesocambiarparametrogeneral = newProcesoCambiarParametroGeneral;
	}
	
	public List<ProcesoCambiarParametroGeneral> getProcesoCambiarParametroGenerals() throws Exception {		
		return procesocambiarparametrogenerals;
	}
	
	public void setProcesoCambiarParametroGenerals(List<ProcesoCambiarParametroGeneral> newProcesoCambiarParametroGenerals) {
		this.procesocambiarparametrogenerals = newProcesoCambiarParametroGenerals;
	}
	
	

	public List<TipoVisual> gettipovisualsForeignKey() {
		return this.tipovisualsForeignKey;
	}

	public List<TipoFondo> gettipofondosForeignKey() {
		return this.tipofondosForeignKey;
	}

	public List<TipoFondo> gettipofondobordesForeignKey() {
		return this.tipofondobordesForeignKey;
	}

	public List<TipoFondoControl> gettipofondocontrolsForeignKey() {
		return this.tipofondocontrolsForeignKey;
	}

	public List<TipoTamanioControl> gettipotamaniocontrolsForeignKey() {
		return this.tipotamaniocontrolsForeignKey;
	}

	public List<TipoExportar> gettipoexportarsForeignKey() {
		return this.tipoexportarsForeignKey;
	}

	public List<TipoDelimiter> gettipodelimitersForeignKey() {
		return this.tipodelimitersForeignKey;
	}
	
	

	public void settipovisualsForeignKey(List<TipoVisual> tipovisualsForeignKey) {
		this.tipovisualsForeignKey=tipovisualsForeignKey;
	}

	public void settipofondosForeignKey(List<TipoFondo> tipofondosForeignKey) {
		this.tipofondosForeignKey=tipofondosForeignKey;
	}

	public void settipofondobordesForeignKey(List<TipoFondo> tipofondobordesForeignKey) {
		this.tipofondobordesForeignKey=tipofondobordesForeignKey;
	}

	public void settipofondocontrolsForeignKey(List<TipoFondoControl> tipofondocontrolsForeignKey) {
		this.tipofondocontrolsForeignKey=tipofondocontrolsForeignKey;
	}

	public void settipotamaniocontrolsForeignKey(List<TipoTamanioControl> tipotamaniocontrolsForeignKey) {
		this.tipotamaniocontrolsForeignKey=tipotamaniocontrolsForeignKey;
	}

	public void settipoexportarsForeignKey(List<TipoExportar> tipoexportarsForeignKey) {
		this.tipoexportarsForeignKey=tipoexportarsForeignKey;
	}

	public void settipodelimitersForeignKey(List<TipoDelimiter> tipodelimitersForeignKey) {
		this.tipodelimitersForeignKey=tipodelimitersForeignKey;
	}
}

