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
package com.bydan.erp.activosfijos.util.report;

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
import com.bydan.erp.activosfijos.util.report.TransferenciasConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//Transferencias


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TransferenciasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Transferencias transferencias;	
	protected List<Transferencias> transferenciass;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TransferenciasParameterReturnGeneral () throws Exception {						
		super();
		this.transferenciass= new ArrayList<Transferencias>();
		this.transferencias= new Transferencias();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public Transferencias getTransferencias() throws Exception {	
		return transferencias;
	}
		
	public void setTransferencias(Transferencias newTransferencias) {
		this.transferencias = newTransferencias;
	}
	
	public List<Transferencias> getTransferenciass() throws Exception {		
		return transferenciass;
	}
	
	public void setTransferenciass(List<Transferencias> newTransferenciass) {
		this.transferenciass = newTransferenciass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

