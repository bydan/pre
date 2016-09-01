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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.SriRetencionesConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//SriRetenciones


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


@SuppressWarnings("unused")
public class SriRetencionesParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SriRetenciones sriretenciones;	
	protected List<SriRetenciones> sriretencioness;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	
	public SriRetencionesParameterReturnGeneral () throws Exception {						
		super();
		this.sriretencioness= new ArrayList<SriRetenciones>();
		this.sriretenciones= new SriRetenciones();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
	} 
	
	public SriRetenciones getSriRetenciones() throws Exception {	
		return sriretenciones;
	}
		
	public void setSriRetenciones(SriRetenciones newSriRetenciones) {
		this.sriretenciones = newSriRetenciones;
	}
	
	public List<SriRetenciones> getSriRetencioness() throws Exception {		
		return sriretencioness;
	}
	
	public void setSriRetencioness(List<SriRetenciones> newSriRetencioness) {
		this.sriretencioness = newSriRetencioness;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}
}

