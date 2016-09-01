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
import com.bydan.erp.contabilidad.util.report.ProcesoCierreEjercicioAnualConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.report.*;//ProcesoCierreEjercicioAnual


import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCierreEjercicioAnualParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCierreEjercicioAnual procesocierreejercicioanual;	
	protected List<ProcesoCierreEjercicioAnual> procesocierreejercicioanuals;
	
	
	public List<TipoDocumento> tipodocumentosForeignKey;
	
	public ProcesoCierreEjercicioAnualParameterReturnGeneral () throws Exception {						
		super();
		this.procesocierreejercicioanuals= new ArrayList<ProcesoCierreEjercicioAnual>();
		this.procesocierreejercicioanual= new ProcesoCierreEjercicioAnual();
		
		
		this.tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
	} 
	
	public ProcesoCierreEjercicioAnual getProcesoCierreEjercicioAnual() throws Exception {	
		return procesocierreejercicioanual;
	}
		
	public void setProcesoCierreEjercicioAnual(ProcesoCierreEjercicioAnual newProcesoCierreEjercicioAnual) {
		this.procesocierreejercicioanual = newProcesoCierreEjercicioAnual;
	}
	
	public List<ProcesoCierreEjercicioAnual> getProcesoCierreEjercicioAnuals() throws Exception {		
		return procesocierreejercicioanuals;
	}
	
	public void setProcesoCierreEjercicioAnuals(List<ProcesoCierreEjercicioAnual> newProcesoCierreEjercicioAnuals) {
		this.procesocierreejercicioanuals = newProcesoCierreEjercicioAnuals;
	}
	
	

	public List<TipoDocumento> gettipodocumentosForeignKey() {
		return this.tipodocumentosForeignKey;
	}
	
	

	public void settipodocumentosForeignKey(List<TipoDocumento> tipodocumentosForeignKey) {
		this.tipodocumentosForeignKey=tipodocumentosForeignKey;
	}
}

