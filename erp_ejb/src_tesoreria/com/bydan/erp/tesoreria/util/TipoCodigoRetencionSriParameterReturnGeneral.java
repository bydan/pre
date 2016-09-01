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
import com.bydan.erp.tesoreria.util.TipoCodigoRetencionSriConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoCodigoRetencionSri


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoCodigoRetencionSriParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCodigoRetencionSri tipocodigoretencionsri;	
	protected List<TipoCodigoRetencionSri> tipocodigoretencionsris;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoCodigoRetencionSriParameterReturnGeneral () throws Exception {						
		super();
		this.tipocodigoretencionsris= new ArrayList<TipoCodigoRetencionSri>();
		this.tipocodigoretencionsri= new TipoCodigoRetencionSri();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoCodigoRetencionSri getTipoCodigoRetencionSri() throws Exception {	
		return tipocodigoretencionsri;
	}
		
	public void setTipoCodigoRetencionSri(TipoCodigoRetencionSri newTipoCodigoRetencionSri) {
		this.tipocodigoretencionsri = newTipoCodigoRetencionSri;
	}
	
	public List<TipoCodigoRetencionSri> getTipoCodigoRetencionSris() throws Exception {		
		return tipocodigoretencionsris;
	}
	
	public void setTipoCodigoRetencionSris(List<TipoCodigoRetencionSri> newTipoCodigoRetencionSris) {
		this.tipocodigoretencionsris = newTipoCodigoRetencionSris;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

