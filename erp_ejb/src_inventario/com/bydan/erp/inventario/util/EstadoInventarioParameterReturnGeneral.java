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
import com.bydan.erp.inventario.util.EstadoInventarioConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//EstadoInventario


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class EstadoInventarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoInventario estadoinventario;	
	protected List<EstadoInventario> estadoinventarios;
	
	
	
	public EstadoInventarioParameterReturnGeneral () throws Exception {						
		super();
		this.estadoinventarios= new ArrayList<EstadoInventario>();
		this.estadoinventario= new EstadoInventario();
		
		
	} 
	
	public EstadoInventario getEstadoInventario() throws Exception {	
		return estadoinventario;
	}
		
	public void setEstadoInventario(EstadoInventario newEstadoInventario) {
		this.estadoinventario = newEstadoInventario;
	}
	
	public List<EstadoInventario> getEstadoInventarios() throws Exception {		
		return estadoinventarios;
	}
	
	public void setEstadoInventarios(List<EstadoInventario> newEstadoInventarios) {
		this.estadoinventarios = newEstadoInventarios;
	}
	
	
	
	
}

