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
import com.bydan.erp.tesoreria.util.report.HistorialConciliacionesBancariasConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.report.*;//HistorialConciliacionesBancarias


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class HistorialConciliacionesBancariasParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HistorialConciliacionesBancarias historialconciliacionesbancarias;	
	protected List<HistorialConciliacionesBancarias> historialconciliacionesbancariass;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public HistorialConciliacionesBancariasParameterReturnGeneral () throws Exception {						
		super();
		this.historialconciliacionesbancariass= new ArrayList<HistorialConciliacionesBancarias>();
		this.historialconciliacionesbancarias= new HistorialConciliacionesBancarias();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public HistorialConciliacionesBancarias getHistorialConciliacionesBancarias() throws Exception {	
		return historialconciliacionesbancarias;
	}
		
	public void setHistorialConciliacionesBancarias(HistorialConciliacionesBancarias newHistorialConciliacionesBancarias) {
		this.historialconciliacionesbancarias = newHistorialConciliacionesBancarias;
	}
	
	public List<HistorialConciliacionesBancarias> getHistorialConciliacionesBancariass() throws Exception {		
		return historialconciliacionesbancariass;
	}
	
	public void setHistorialConciliacionesBancariass(List<HistorialConciliacionesBancarias> newHistorialConciliacionesBancariass) {
		this.historialconciliacionesbancariass = newHistorialConciliacionesBancariass;
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

