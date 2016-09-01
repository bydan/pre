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
import com.bydan.erp.activosfijos.util.TipoEstadoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//TipoEstadoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoEstadoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoEstadoActivoFijo tipoestadoactivofijo;	
	protected List<TipoEstadoActivoFijo> tipoestadoactivofijos;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoEstadoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.tipoestadoactivofijos= new ArrayList<TipoEstadoActivoFijo>();
		this.tipoestadoactivofijo= new TipoEstadoActivoFijo();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoEstadoActivoFijo getTipoEstadoActivoFijo() throws Exception {	
		return tipoestadoactivofijo;
	}
		
	public void setTipoEstadoActivoFijo(TipoEstadoActivoFijo newTipoEstadoActivoFijo) {
		this.tipoestadoactivofijo = newTipoEstadoActivoFijo;
	}
	
	public List<TipoEstadoActivoFijo> getTipoEstadoActivoFijos() throws Exception {		
		return tipoestadoactivofijos;
	}
	
	public void setTipoEstadoActivoFijos(List<TipoEstadoActivoFijo> newTipoEstadoActivoFijos) {
		this.tipoestadoactivofijos = newTipoEstadoActivoFijos;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

