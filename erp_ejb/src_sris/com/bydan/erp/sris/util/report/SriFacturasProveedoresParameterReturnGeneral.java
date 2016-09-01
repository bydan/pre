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
package com.bydan.erp.sris.util.report;

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
import com.bydan.erp.sris.util.report.SriFacturasProveedoresConstantesFunciones;

import com.bydan.erp.sris.business.entity.report.*;//SriFacturasProveedores


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class SriFacturasProveedoresParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SriFacturasProveedores srifacturasproveedores;	
	protected List<SriFacturasProveedores> srifacturasproveedoress;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	
	public SriFacturasProveedoresParameterReturnGeneral () throws Exception {						
		super();
		this.srifacturasproveedoress= new ArrayList<SriFacturasProveedores>();
		this.srifacturasproveedores= new SriFacturasProveedores();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
	} 
	
	public SriFacturasProveedores getSriFacturasProveedores() throws Exception {	
		return srifacturasproveedores;
	}
		
	public void setSriFacturasProveedores(SriFacturasProveedores newSriFacturasProveedores) {
		this.srifacturasproveedores = newSriFacturasProveedores;
	}
	
	public List<SriFacturasProveedores> getSriFacturasProveedoress() throws Exception {		
		return srifacturasproveedoress;
	}
	
	public void setSriFacturasProveedoress(List<SriFacturasProveedores> newSriFacturasProveedoress) {
		this.srifacturasproveedoress = newSriFacturasProveedoress;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}
}

