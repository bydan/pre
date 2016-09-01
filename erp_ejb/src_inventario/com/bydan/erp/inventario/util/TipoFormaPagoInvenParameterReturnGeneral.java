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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.TipoFormaPagoInvenConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//TipoFormaPagoInven


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoFormaPagoInvenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoFormaPagoInven tipoformapagoinven;	
	protected List<TipoFormaPagoInven> tipoformapagoinvens;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoFormaPagoInvenParameterReturnGeneral () throws Exception {						
		super();
		this.tipoformapagoinvens= new ArrayList<TipoFormaPagoInven>();
		this.tipoformapagoinven= new TipoFormaPagoInven();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoFormaPagoInven getTipoFormaPagoInven() throws Exception {	
		return tipoformapagoinven;
	}
		
	public void setTipoFormaPagoInven(TipoFormaPagoInven newTipoFormaPagoInven) {
		this.tipoformapagoinven = newTipoFormaPagoInven;
	}
	
	public List<TipoFormaPagoInven> getTipoFormaPagoInvens() throws Exception {		
		return tipoformapagoinvens;
	}
	
	public void setTipoFormaPagoInvens(List<TipoFormaPagoInven> newTipoFormaPagoInvens) {
		this.tipoformapagoinvens = newTipoFormaPagoInvens;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

