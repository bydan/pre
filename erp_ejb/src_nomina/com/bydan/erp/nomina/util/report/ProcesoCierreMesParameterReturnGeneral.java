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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.ProcesoCierreMesConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoCierreMes


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoCierreMesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoCierreMes procesocierremes;	
	protected List<ProcesoCierreMes> procesocierremess;
	
	
	public List<Mes> messForeignKey;
	public List<Estructura> estructurasForeignKey;
	
	public ProcesoCierreMesParameterReturnGeneral () throws Exception {						
		super();
		this.procesocierremess= new ArrayList<ProcesoCierreMes>();
		this.procesocierremes= new ProcesoCierreMes();
		
		
		this.messForeignKey=new ArrayList<Mes>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
	} 
	
	public ProcesoCierreMes getProcesoCierreMes() throws Exception {	
		return procesocierremes;
	}
		
	public void setProcesoCierreMes(ProcesoCierreMes newProcesoCierreMes) {
		this.procesocierremes = newProcesoCierreMes;
	}
	
	public List<ProcesoCierreMes> getProcesoCierreMess() throws Exception {		
		return procesocierremess;
	}
	
	public void setProcesoCierreMess(List<ProcesoCierreMes> newProcesoCierreMess) {
		this.procesocierremess = newProcesoCierreMess;
	}
	
	

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}
	
	

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}
}

