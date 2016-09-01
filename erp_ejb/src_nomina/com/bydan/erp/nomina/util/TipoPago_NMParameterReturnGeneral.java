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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.TipoPago_NMConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoPago_NM


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class TipoPago_NMParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoPago_NM tipopago_nm;	
	protected List<TipoPago_NM> tipopago_nms;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoPago_NMParameterReturnGeneral () throws Exception {						
		super();
		this.tipopago_nms= new ArrayList<TipoPago_NM>();
		this.tipopago_nm= new TipoPago_NM();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoPago_NM getTipoPago_NM() throws Exception {	
		return tipopago_nm;
	}
		
	public void setTipoPago_NM(TipoPago_NM newTipoPago_NM) {
		this.tipopago_nm = newTipoPago_NM;
	}
	
	public List<TipoPago_NM> getTipoPago_NMs() throws Exception {		
		return tipopago_nms;
	}
	
	public void setTipoPago_NMs(List<TipoPago_NM> newTipoPago_NMs) {
		this.tipopago_nms = newTipoPago_NMs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

