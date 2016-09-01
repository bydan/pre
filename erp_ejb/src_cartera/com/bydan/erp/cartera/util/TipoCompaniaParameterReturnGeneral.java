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
import com.bydan.erp.cartera.util.TipoCompaniaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoCompania


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoCompaniaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCompania tipocompania;	
	protected List<TipoCompania> tipocompanias;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoCompaniaParameterReturnGeneral () throws Exception {						
		super();
		this.tipocompanias= new ArrayList<TipoCompania>();
		this.tipocompania= new TipoCompania();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoCompania getTipoCompania() throws Exception {	
		return tipocompania;
	}
		
	public void setTipoCompania(TipoCompania newTipoCompania) {
		this.tipocompania = newTipoCompania;
	}
	
	public List<TipoCompania> getTipoCompanias() throws Exception {		
		return tipocompanias;
	}
	
	public void setTipoCompanias(List<TipoCompania> newTipoCompanias) {
		this.tipocompanias = newTipoCompanias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

