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
package com.bydan.erp.comisiones.util;

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
import com.bydan.erp.comisiones.util.TipoComisionConfigConstantesFunciones;

import com.bydan.erp.comisiones.business.entity.*;//TipoComisionConfig


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class TipoComisionConfigParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoComisionConfig tipocomisionconfig;	
	protected List<TipoComisionConfig> tipocomisionconfigs;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoComisionConfigParameterReturnGeneral () throws Exception {						
		super();
		this.tipocomisionconfigs= new ArrayList<TipoComisionConfig>();
		this.tipocomisionconfig= new TipoComisionConfig();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoComisionConfig getTipoComisionConfig() throws Exception {	
		return tipocomisionconfig;
	}
		
	public void setTipoComisionConfig(TipoComisionConfig newTipoComisionConfig) {
		this.tipocomisionconfig = newTipoComisionConfig;
	}
	
	public List<TipoComisionConfig> getTipoComisionConfigs() throws Exception {		
		return tipocomisionconfigs;
	}
	
	public void setTipoComisionConfigs(List<TipoComisionConfig> newTipoComisionConfigs) {
		this.tipocomisionconfigs = newTipoComisionConfigs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

