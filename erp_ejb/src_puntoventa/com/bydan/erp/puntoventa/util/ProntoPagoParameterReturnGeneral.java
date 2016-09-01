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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.ProntoPagoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//ProntoPago


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ProntoPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProntoPago prontopago;	
	protected List<ProntoPago> prontopagos;
	
	
	public List<Empresa> empresasForeignKey;
	
	public ProntoPagoParameterReturnGeneral () throws Exception {						
		super();
		this.prontopagos= new ArrayList<ProntoPago>();
		this.prontopago= new ProntoPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public ProntoPago getProntoPago() throws Exception {	
		return prontopago;
	}
		
	public void setProntoPago(ProntoPago newProntoPago) {
		this.prontopago = newProntoPago;
	}
	
	public List<ProntoPago> getProntoPagos() throws Exception {		
		return prontopagos;
	}
	
	public void setProntoPagos(List<ProntoPago> newProntoPagos) {
		this.prontopagos = newProntoPagos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}
