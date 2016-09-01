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
import com.bydan.erp.nomina.util.report.ProcesoImpuestoRentaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoImpuestoRenta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoImpuestoRentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoImpuestoRenta procesoimpuestorenta;	
	protected List<ProcesoImpuestoRenta> procesoimpuestorentas;
	
	
	public List<Anio> aniosForeignKey;
	
	public ProcesoImpuestoRentaParameterReturnGeneral () throws Exception {						
		super();
		this.procesoimpuestorentas= new ArrayList<ProcesoImpuestoRenta>();
		this.procesoimpuestorenta= new ProcesoImpuestoRenta();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
	} 
	
	public ProcesoImpuestoRenta getProcesoImpuestoRenta() throws Exception {	
		return procesoimpuestorenta;
	}
		
	public void setProcesoImpuestoRenta(ProcesoImpuestoRenta newProcesoImpuestoRenta) {
		this.procesoimpuestorenta = newProcesoImpuestoRenta;
	}
	
	public List<ProcesoImpuestoRenta> getProcesoImpuestoRentas() throws Exception {		
		return procesoimpuestorentas;
	}
	
	public void setProcesoImpuestoRentas(List<ProcesoImpuestoRenta> newProcesoImpuestoRentas) {
		this.procesoimpuestorentas = newProcesoImpuestoRentas;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}
}

