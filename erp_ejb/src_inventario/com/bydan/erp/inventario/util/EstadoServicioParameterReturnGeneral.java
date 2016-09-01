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
import com.bydan.erp.inventario.util.EstadoServicioConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//EstadoServicio


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class EstadoServicioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoServicio estadoservicio;	
	protected List<EstadoServicio> estadoservicios;
	
	
	
	public EstadoServicioParameterReturnGeneral () throws Exception {						
		super();
		this.estadoservicios= new ArrayList<EstadoServicio>();
		this.estadoservicio= new EstadoServicio();
		
		
	} 
	
	public EstadoServicio getEstadoServicio() throws Exception {	
		return estadoservicio;
	}
		
	public void setEstadoServicio(EstadoServicio newEstadoServicio) {
		this.estadoservicio = newEstadoServicio;
	}
	
	public List<EstadoServicio> getEstadoServicios() throws Exception {		
		return estadoservicios;
	}
	
	public void setEstadoServicios(List<EstadoServicio> newEstadoServicios) {
		this.estadoservicios = newEstadoServicios;
	}
	
	
	
	
}

