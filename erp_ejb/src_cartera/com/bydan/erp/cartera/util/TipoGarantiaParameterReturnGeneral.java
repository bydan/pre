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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.TipoGarantiaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoGarantia


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoGarantiaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoGarantia tipogarantia;	
	protected List<TipoGarantia> tipogarantias;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoGarantiaParameterReturnGeneral () throws Exception {						
		super();
		this.tipogarantias= new ArrayList<TipoGarantia>();
		this.tipogarantia= new TipoGarantia();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoGarantia getTipoGarantia() throws Exception {	
		return tipogarantia;
	}
		
	public void setTipoGarantia(TipoGarantia newTipoGarantia) {
		this.tipogarantia = newTipoGarantia;
	}
	
	public List<TipoGarantia> getTipoGarantias() throws Exception {		
		return tipogarantias;
	}
	
	public void setTipoGarantias(List<TipoGarantia> newTipoGarantias) {
		this.tipogarantias = newTipoGarantias;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

