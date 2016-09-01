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
package com.bydan.erp.cartera.util.report;

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
import com.bydan.erp.cartera.util.report.ControlProveedoresConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//ControlProveedores


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ControlProveedoresParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ControlProveedores controlproveedores;	
	protected List<ControlProveedores> controlproveedoress;
	
	
	public List<Empresa> empresasForeignKey;
	
	public ControlProveedoresParameterReturnGeneral () throws Exception {						
		super();
		this.controlproveedoress= new ArrayList<ControlProveedores>();
		this.controlproveedores= new ControlProveedores();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public ControlProveedores getControlProveedores() throws Exception {	
		return controlproveedores;
	}
		
	public void setControlProveedores(ControlProveedores newControlProveedores) {
		this.controlproveedores = newControlProveedores;
	}
	
	public List<ControlProveedores> getControlProveedoress() throws Exception {		
		return controlproveedoress;
	}
	
	public void setControlProveedoress(List<ControlProveedores> newControlProveedoress) {
		this.controlproveedoress = newControlProveedoress;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

