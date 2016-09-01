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
import com.bydan.erp.nomina.util.report.ProcesoUtilidadesConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoUtilidades


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoUtilidadesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoUtilidades procesoutilidades;	
	protected List<ProcesoUtilidades> procesoutilidadess;
	
	
	public List<Anio> aniosForeignKey;
	
	public ProcesoUtilidadesParameterReturnGeneral () throws Exception {						
		super();
		this.procesoutilidadess= new ArrayList<ProcesoUtilidades>();
		this.procesoutilidades= new ProcesoUtilidades();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
	} 
	
	public ProcesoUtilidades getProcesoUtilidades() throws Exception {	
		return procesoutilidades;
	}
		
	public void setProcesoUtilidades(ProcesoUtilidades newProcesoUtilidades) {
		this.procesoutilidades = newProcesoUtilidades;
	}
	
	public List<ProcesoUtilidades> getProcesoUtilidadess() throws Exception {		
		return procesoutilidadess;
	}
	
	public void setProcesoUtilidadess(List<ProcesoUtilidades> newProcesoUtilidadess) {
		this.procesoutilidadess = newProcesoUtilidadess;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}
}

