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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.EstadoPagoAutoConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//EstadoPagoAuto




@SuppressWarnings("unused")
public class EstadoPagoAutoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoPagoAuto estadopagoauto;	
	protected List<EstadoPagoAuto> estadopagoautos;
	
	
	
	public EstadoPagoAutoParameterReturnGeneral () throws Exception {						
		super();
		this.estadopagoautos= new ArrayList<EstadoPagoAuto>();
		this.estadopagoauto= new EstadoPagoAuto();
		
		
	} 
	
	public EstadoPagoAuto getEstadoPagoAuto() throws Exception {	
		return estadopagoauto;
	}
		
	public void setEstadoPagoAuto(EstadoPagoAuto newEstadoPagoAuto) {
		this.estadopagoauto = newEstadoPagoAuto;
	}
	
	public List<EstadoPagoAuto> getEstadoPagoAutos() throws Exception {		
		return estadopagoautos;
	}
	
	public void setEstadoPagoAutos(List<EstadoPagoAuto> newEstadoPagoAutos) {
		this.estadopagoautos = newEstadoPagoAutos;
	}
	
	
	
	
}

