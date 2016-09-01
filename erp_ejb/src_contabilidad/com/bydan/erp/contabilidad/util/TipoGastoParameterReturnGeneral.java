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
import com.bydan.erp.contabilidad.util.TipoGastoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoGasto


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoGastoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoGasto tipogasto;	
	protected List<TipoGasto> tipogastos;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoGastoParameterReturnGeneral () throws Exception {						
		super();
		this.tipogastos= new ArrayList<TipoGasto>();
		this.tipogasto= new TipoGasto();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoGasto getTipoGasto() throws Exception {	
		return tipogasto;
	}
		
	public void setTipoGasto(TipoGasto newTipoGasto) {
		this.tipogasto = newTipoGasto;
	}
	
	public List<TipoGasto> getTipoGastos() throws Exception {		
		return tipogastos;
	}
	
	public void setTipoGastos(List<TipoGasto> newTipoGastos) {
		this.tipogastos = newTipoGastos;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

