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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.PresuTransferenciaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresuTransferencia


import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PresuTransferenciaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresuTransferencia presutransferencia;	
	protected List<PresuTransferencia> presutransferencias;
	
	
	public List<PresuProyecto> presuproyectosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<CuentaContable> cuentacontabledestinosForeignKey;
	public List<Empleado> empleadosForeignKey;
	
	public PresuTransferenciaParameterReturnGeneral () throws Exception {						
		super();
		this.presutransferencias= new ArrayList<PresuTransferencia>();
		this.presutransferencia= new PresuTransferencia();
		
		
		this.presuproyectosForeignKey=new ArrayList<PresuProyecto>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontabledestinosForeignKey=new ArrayList<CuentaContable>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public PresuTransferencia getPresuTransferencia() throws Exception {	
		return presutransferencia;
	}
		
	public void setPresuTransferencia(PresuTransferencia newPresuTransferencia) {
		this.presutransferencia = newPresuTransferencia;
	}
	
	public List<PresuTransferencia> getPresuTransferencias() throws Exception {		
		return presutransferencias;
	}
	
	public void setPresuTransferencias(List<PresuTransferencia> newPresuTransferencias) {
		this.presutransferencias = newPresuTransferencias;
	}
	
	

	public List<PresuProyecto> getpresuproyectosForeignKey() {
		return this.presuproyectosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<CuentaContable> getcuentacontabledestinosForeignKey() {
		return this.cuentacontabledestinosForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setpresuproyectosForeignKey(List<PresuProyecto> presuproyectosForeignKey) {
		this.presuproyectosForeignKey=presuproyectosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setcuentacontabledestinosForeignKey(List<CuentaContable> cuentacontabledestinosForeignKey) {
		this.cuentacontabledestinosForeignKey=cuentacontabledestinosForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

