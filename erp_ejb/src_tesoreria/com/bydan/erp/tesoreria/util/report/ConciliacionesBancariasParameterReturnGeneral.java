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
import com.bydan.erp.tesoreria.util.report.ConciliacionesBancariasConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//ConciliacionesBancarias


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ConciliacionesBancariasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ConciliacionesBancarias conciliacionesbancarias;	
	protected List<ConciliacionesBancarias> conciliacionesbancariass;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public ConciliacionesBancariasParameterReturnGeneral () throws Exception {						
		super();
		this.conciliacionesbancariass= new ArrayList<ConciliacionesBancarias>();
		this.conciliacionesbancarias= new ConciliacionesBancarias();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ConciliacionesBancarias getConciliacionesBancarias() throws Exception {	
		return conciliacionesbancarias;
	}
		
	public void setConciliacionesBancarias(ConciliacionesBancarias newConciliacionesBancarias) {
		this.conciliacionesbancarias = newConciliacionesBancarias;
	}
	
	public List<ConciliacionesBancarias> getConciliacionesBancariass() throws Exception {		
		return conciliacionesbancariass;
	}
	
	public void setConciliacionesBancariass(List<ConciliacionesBancarias> newConciliacionesBancariass) {
		this.conciliacionesbancariass = newConciliacionesBancariass;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

