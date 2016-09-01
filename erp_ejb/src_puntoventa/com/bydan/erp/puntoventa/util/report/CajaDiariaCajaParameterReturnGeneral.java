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
package com.bydan.erp.puntoventa.util.report;

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
import com.bydan.erp.puntoventa.util.report.CajaDiariaCajaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.report.*;//CajaDiariaCaja


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class CajaDiariaCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CajaDiariaCaja cajadiariacaja;	
	protected List<CajaDiariaCaja> cajadiariacajas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Caja> cajasForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public CajaDiariaCajaParameterReturnGeneral () throws Exception {						
		super();
		this.cajadiariacajas= new ArrayList<CajaDiariaCaja>();
		this.cajadiariacaja= new CajaDiariaCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public CajaDiariaCaja getCajaDiariaCaja() throws Exception {	
		return cajadiariacaja;
	}
		
	public void setCajaDiariaCaja(CajaDiariaCaja newCajaDiariaCaja) {
		this.cajadiariacaja = newCajaDiariaCaja;
	}
	
	public List<CajaDiariaCaja> getCajaDiariaCajas() throws Exception {		
		return cajadiariacajas;
	}
	
	public void setCajaDiariaCajas(List<CajaDiariaCaja> newCajaDiariaCajas) {
		this.cajadiariacajas = newCajaDiariaCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

