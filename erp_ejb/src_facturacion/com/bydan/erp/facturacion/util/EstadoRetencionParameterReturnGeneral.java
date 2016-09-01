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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.EstadoRetencionConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//EstadoRetencion


import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class EstadoRetencionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoRetencion estadoretencion;	
	protected List<EstadoRetencion> estadoretencions;
	
	
	
	public EstadoRetencionParameterReturnGeneral () throws Exception {						
		super();
		this.estadoretencions= new ArrayList<EstadoRetencion>();
		this.estadoretencion= new EstadoRetencion();
		
		
	} 
	
	public EstadoRetencion getEstadoRetencion() throws Exception {	
		return estadoretencion;
	}
		
	public void setEstadoRetencion(EstadoRetencion newEstadoRetencion) {
		this.estadoretencion = newEstadoRetencion;
	}
	
	public List<EstadoRetencion> getEstadoRetencions() throws Exception {		
		return estadoretencions;
	}
	
	public void setEstadoRetencions(List<EstadoRetencion> newEstadoRetencions) {
		this.estadoretencions = newEstadoRetencions;
	}
	
	
	
	
}

