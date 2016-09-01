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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.TipoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//TipoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoActivoFijo tipoactivofijo;	
	protected List<TipoActivoFijo> tipoactivofijos;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.tipoactivofijos= new ArrayList<TipoActivoFijo>();
		this.tipoactivofijo= new TipoActivoFijo();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoActivoFijo getTipoActivoFijo() throws Exception {	
		return tipoactivofijo;
	}
		
	public void setTipoActivoFijo(TipoActivoFijo newTipoActivoFijo) {
		this.tipoactivofijo = newTipoActivoFijo;
	}
	
	public List<TipoActivoFijo> getTipoActivoFijos() throws Exception {		
		return tipoactivofijos;
	}
	
	public void setTipoActivoFijos(List<TipoActivoFijo> newTipoActivoFijos) {
		this.tipoactivofijos = newTipoActivoFijos;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

