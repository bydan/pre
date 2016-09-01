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
import com.bydan.erp.facturacion.util.DetaFormaPagoFactuConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetaFormaPagoFactu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class DetaFormaPagoFactuParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetaFormaPagoFactu detaformapagofactu;	
	protected List<DetaFormaPagoFactu> detaformapagofactus;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoFormaPago> tipoformapagosForeignKey;
	
	public DetaFormaPagoFactuParameterReturnGeneral () throws Exception {						
		super();
		this.detaformapagofactus= new ArrayList<DetaFormaPagoFactu>();
		this.detaformapagofactu= new DetaFormaPagoFactu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
	} 
	
	public DetaFormaPagoFactu getDetaFormaPagoFactu() throws Exception {	
		return detaformapagofactu;
	}
		
	public void setDetaFormaPagoFactu(DetaFormaPagoFactu newDetaFormaPagoFactu) {
		this.detaformapagofactu = newDetaFormaPagoFactu;
	}
	
	public List<DetaFormaPagoFactu> getDetaFormaPagoFactus() throws Exception {		
		return detaformapagofactus;
	}
	
	public void setDetaFormaPagoFactus(List<DetaFormaPagoFactu> newDetaFormaPagoFactus) {
		this.detaformapagofactus = newDetaFormaPagoFactus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoFormaPago> gettipoformapagosForeignKey() {
		return this.tipoformapagosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoformapagosForeignKey(List<TipoFormaPago> tipoformapagosForeignKey) {
		this.tipoformapagosForeignKey=tipoformapagosForeignKey;
	}
}

