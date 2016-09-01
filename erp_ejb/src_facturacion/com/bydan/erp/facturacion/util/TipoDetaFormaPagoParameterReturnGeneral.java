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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.TipoDetaFormaPagoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//TipoDetaFormaPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TipoDetaFormaPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoDetaFormaPago tipodetaformapago;	
	protected List<TipoDetaFormaPago> tipodetaformapagos;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoDetaFormaPagoParameterReturnGeneral () throws Exception {						
		super();
		this.tipodetaformapagos= new ArrayList<TipoDetaFormaPago>();
		this.tipodetaformapago= new TipoDetaFormaPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoDetaFormaPago getTipoDetaFormaPago() throws Exception {	
		return tipodetaformapago;
	}
		
	public void setTipoDetaFormaPago(TipoDetaFormaPago newTipoDetaFormaPago) {
		this.tipodetaformapago = newTipoDetaFormaPago;
	}
	
	public List<TipoDetaFormaPago> getTipoDetaFormaPagos() throws Exception {		
		return tipodetaformapagos;
	}
	
	public void setTipoDetaFormaPagos(List<TipoDetaFormaPago> newTipoDetaFormaPagos) {
		this.tipodetaformapagos = newTipoDetaFormaPagos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

