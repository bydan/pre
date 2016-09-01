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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.EstadoCivilConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//EstadoCivil


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class EstadoCivilParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoCivil estadocivil;	
	protected List<EstadoCivil> estadocivils;
	
	
	
	public EstadoCivilParameterReturnGeneral () throws Exception {						
		super();
		this.estadocivils= new ArrayList<EstadoCivil>();
		this.estadocivil= new EstadoCivil();
		
		
	} 
	
	public EstadoCivil getEstadoCivil() throws Exception {	
		return estadocivil;
	}
		
	public void setEstadoCivil(EstadoCivil newEstadoCivil) {
		this.estadocivil = newEstadoCivil;
	}
	
	public List<EstadoCivil> getEstadoCivils() throws Exception {		
		return estadocivils;
	}
	
	public void setEstadoCivils(List<EstadoCivil> newEstadoCivils) {
		this.estadocivils = newEstadoCivils;
	}
	
	
	
	
}

