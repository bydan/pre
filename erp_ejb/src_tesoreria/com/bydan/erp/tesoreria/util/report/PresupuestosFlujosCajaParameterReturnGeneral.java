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
package com.bydan.erp.tesoreria.util.report;

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
import com.bydan.erp.tesoreria.util.report.PresupuestosFlujosCajaConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//PresupuestosFlujosCaja


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PresupuestosFlujosCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresupuestosFlujosCaja presupuestosflujoscaja;	
	protected List<PresupuestosFlujosCaja> presupuestosflujoscajas;
	
	
	public List<Empresa> empresasForeignKey;
	
	public PresupuestosFlujosCajaParameterReturnGeneral () throws Exception {						
		super();
		this.presupuestosflujoscajas= new ArrayList<PresupuestosFlujosCaja>();
		this.presupuestosflujoscaja= new PresupuestosFlujosCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public PresupuestosFlujosCaja getPresupuestosFlujosCaja() throws Exception {	
		return presupuestosflujoscaja;
	}
		
	public void setPresupuestosFlujosCaja(PresupuestosFlujosCaja newPresupuestosFlujosCaja) {
		this.presupuestosflujoscaja = newPresupuestosFlujosCaja;
	}
	
	public List<PresupuestosFlujosCaja> getPresupuestosFlujosCajas() throws Exception {		
		return presupuestosflujoscajas;
	}
	
	public void setPresupuestosFlujosCajas(List<PresupuestosFlujosCaja> newPresupuestosFlujosCajas) {
		this.presupuestosflujoscajas = newPresupuestosFlujosCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

