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
import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//TipoGrupoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoGrupoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoGrupoActivoFijo tipogrupoactivofijo;	
	protected List<TipoGrupoActivoFijo> tipogrupoactivofijos;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoGrupoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.tipogrupoactivofijos= new ArrayList<TipoGrupoActivoFijo>();
		this.tipogrupoactivofijo= new TipoGrupoActivoFijo();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoGrupoActivoFijo getTipoGrupoActivoFijo() throws Exception {	
		return tipogrupoactivofijo;
	}
		
	public void setTipoGrupoActivoFijo(TipoGrupoActivoFijo newTipoGrupoActivoFijo) {
		this.tipogrupoactivofijo = newTipoGrupoActivoFijo;
	}
	
	public List<TipoGrupoActivoFijo> getTipoGrupoActivoFijos() throws Exception {		
		return tipogrupoactivofijos;
	}
	
	public void setTipoGrupoActivoFijos(List<TipoGrupoActivoFijo> newTipoGrupoActivoFijos) {
		this.tipogrupoactivofijos = newTipoGrupoActivoFijos;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

