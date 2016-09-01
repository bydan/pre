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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.EstadoDetalleAutoriConsepConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//EstadoDetalleAutoriConsep




@SuppressWarnings("unused")
public class EstadoDetalleAutoriConsepParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoDetalleAutoriConsep estadodetalleautoriconsep;	
	protected List<EstadoDetalleAutoriConsep> estadodetalleautoriconseps;
	
	
	
	public EstadoDetalleAutoriConsepParameterReturnGeneral () throws Exception {						
		super();
		this.estadodetalleautoriconseps= new ArrayList<EstadoDetalleAutoriConsep>();
		this.estadodetalleautoriconsep= new EstadoDetalleAutoriConsep();
		
		
	} 
	
	public EstadoDetalleAutoriConsep getEstadoDetalleAutoriConsep() throws Exception {	
		return estadodetalleautoriconsep;
	}
		
	public void setEstadoDetalleAutoriConsep(EstadoDetalleAutoriConsep newEstadoDetalleAutoriConsep) {
		this.estadodetalleautoriconsep = newEstadoDetalleAutoriConsep;
	}
	
	public List<EstadoDetalleAutoriConsep> getEstadoDetalleAutoriConseps() throws Exception {		
		return estadodetalleautoriconseps;
	}
	
	public void setEstadoDetalleAutoriConseps(List<EstadoDetalleAutoriConsep> newEstadoDetalleAutoriConseps) {
		this.estadodetalleautoriconseps = newEstadoDetalleAutoriConseps;
	}
	
	
	
	
}

