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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.EstadoOrdenProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//EstadoOrdenProdu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class EstadoOrdenProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoOrdenProdu estadoordenprodu;	
	protected List<EstadoOrdenProdu> estadoordenprodus;
	
	
	
	public EstadoOrdenProduParameterReturnGeneral () throws Exception {						
		super();
		this.estadoordenprodus= new ArrayList<EstadoOrdenProdu>();
		this.estadoordenprodu= new EstadoOrdenProdu();
		
		
	} 
	
	public EstadoOrdenProdu getEstadoOrdenProdu() throws Exception {	
		return estadoordenprodu;
	}
		
	public void setEstadoOrdenProdu(EstadoOrdenProdu newEstadoOrdenProdu) {
		this.estadoordenprodu = newEstadoOrdenProdu;
	}
	
	public List<EstadoOrdenProdu> getEstadoOrdenProdus() throws Exception {		
		return estadoordenprodus;
	}
	
	public void setEstadoOrdenProdus(List<EstadoOrdenProdu> newEstadoOrdenProdus) {
		this.estadoordenprodus = newEstadoOrdenProdus;
	}
	
	
	
	
}

