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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.EstadoAsientoContableConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//EstadoAsientoContable


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class EstadoAsientoContableParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoAsientoContable estadoasientocontable;	
	protected List<EstadoAsientoContable> estadoasientocontables;
	
	
	public List<ColorGeneral> colorgeneralsForeignKey;
	
	public EstadoAsientoContableParameterReturnGeneral () throws Exception {						
		super();
		this.estadoasientocontables= new ArrayList<EstadoAsientoContable>();
		this.estadoasientocontable= new EstadoAsientoContable();
		
		
		this.colorgeneralsForeignKey=new ArrayList<ColorGeneral>();
	} 
	
	public EstadoAsientoContable getEstadoAsientoContable() throws Exception {	
		return estadoasientocontable;
	}
		
	public void setEstadoAsientoContable(EstadoAsientoContable newEstadoAsientoContable) {
		this.estadoasientocontable = newEstadoAsientoContable;
	}
	
	public List<EstadoAsientoContable> getEstadoAsientoContables() throws Exception {		
		return estadoasientocontables;
	}
	
	public void setEstadoAsientoContables(List<EstadoAsientoContable> newEstadoAsientoContables) {
		this.estadoasientocontables = newEstadoAsientoContables;
	}
	
	

	public List<ColorGeneral> getcolorgeneralsForeignKey() {
		return this.colorgeneralsForeignKey;
	}
	
	

	public void setcolorgeneralsForeignKey(List<ColorGeneral> colorgeneralsForeignKey) {
		this.colorgeneralsForeignKey=colorgeneralsForeignKey;
	}
}

