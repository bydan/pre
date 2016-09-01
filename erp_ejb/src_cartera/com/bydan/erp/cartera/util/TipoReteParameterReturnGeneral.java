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
import com.bydan.erp.cartera.util.TipoReteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoRete


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoReteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoRete tiporete;	
	protected List<TipoRete> tiporetes;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoReteParameterReturnGeneral () throws Exception {						
		super();
		this.tiporetes= new ArrayList<TipoRete>();
		this.tiporete= new TipoRete();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoRete getTipoRete() throws Exception {	
		return tiporete;
	}
		
	public void setTipoRete(TipoRete newTipoRete) {
		this.tiporete = newTipoRete;
	}
	
	public List<TipoRete> getTipoRetes() throws Exception {		
		return tiporetes;
	}
	
	public void setTipoRetes(List<TipoRete> newTipoRetes) {
		this.tiporetes = newTipoRetes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

