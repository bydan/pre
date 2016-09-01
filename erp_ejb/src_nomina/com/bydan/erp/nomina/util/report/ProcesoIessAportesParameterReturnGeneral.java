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
import com.bydan.erp.nomina.util.report.ProcesoIessAportesConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoIessAportes


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoIessAportesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoIessAportes procesoiessaportes;	
	protected List<ProcesoIessAportes> procesoiessaportess;
	
	
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	public List<TipoAfiliacion> tipoafiliacionsForeignKey;
	public List<NumeroPatronal> numeropatronalsForeignKey;
	
	public ProcesoIessAportesParameterReturnGeneral () throws Exception {						
		super();
		this.procesoiessaportess= new ArrayList<ProcesoIessAportes>();
		this.procesoiessaportes= new ProcesoIessAportes();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
		this.tipoafiliacionsForeignKey=new ArrayList<TipoAfiliacion>();
		this.numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
	} 
	
	public ProcesoIessAportes getProcesoIessAportes() throws Exception {	
		return procesoiessaportes;
	}
		
	public void setProcesoIessAportes(ProcesoIessAportes newProcesoIessAportes) {
		this.procesoiessaportes = newProcesoIessAportes;
	}
	
	public List<ProcesoIessAportes> getProcesoIessAportess() throws Exception {		
		return procesoiessaportess;
	}
	
	public void setProcesoIessAportess(List<ProcesoIessAportes> newProcesoIessAportess) {
		this.procesoiessaportess = newProcesoIessAportess;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<TipoAfiliacion> gettipoafiliacionsForeignKey() {
		return this.tipoafiliacionsForeignKey;
	}

	public List<NumeroPatronal> getnumeropatronalsForeignKey() {
		return this.numeropatronalsForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void settipoafiliacionsForeignKey(List<TipoAfiliacion> tipoafiliacionsForeignKey) {
		this.tipoafiliacionsForeignKey=tipoafiliacionsForeignKey;
	}

	public void setnumeropatronalsForeignKey(List<NumeroPatronal> numeropatronalsForeignKey) {
		this.numeropatronalsForeignKey=numeropatronalsForeignKey;
	}
}

