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
import com.bydan.erp.facturacion.util.EstadoFactuImpreConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//EstadoFactuImpre




@SuppressWarnings("unused")
public class EstadoFactuImpreParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoFactuImpre estadofactuimpre;	
	protected List<EstadoFactuImpre> estadofactuimpres;
	
	
	
	public EstadoFactuImpreParameterReturnGeneral () throws Exception {						
		super();
		this.estadofactuimpres= new ArrayList<EstadoFactuImpre>();
		this.estadofactuimpre= new EstadoFactuImpre();
		
		
	} 
	
	public EstadoFactuImpre getEstadoFactuImpre() throws Exception {	
		return estadofactuimpre;
	}
		
	public void setEstadoFactuImpre(EstadoFactuImpre newEstadoFactuImpre) {
		this.estadofactuimpre = newEstadoFactuImpre;
	}
	
	public List<EstadoFactuImpre> getEstadoFactuImpres() throws Exception {		
		return estadofactuimpres;
	}
	
	public void setEstadoFactuImpres(List<EstadoFactuImpre> newEstadoFactuImpres) {
		this.estadofactuimpres = newEstadoFactuImpres;
	}
	
	
	
	
}

