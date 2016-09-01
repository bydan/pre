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
import com.bydan.erp.contabilidad.util.PresuProyectoCuentaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresuProyectoCuenta


import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PresuProyectoCuentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresuProyectoCuenta presuproyectocuenta;	
	protected List<PresuProyectoCuenta> presuproyectocuentas;
	
	
	public List<PresuProyecto> presuproyectosForeignKey;
	public List<PresuTipoCuentaProyecto> presutipocuentaproyectosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<PresuEstado> presuestadosForeignKey;
	
	public PresuProyectoCuentaParameterReturnGeneral () throws Exception {						
		super();
		this.presuproyectocuentas= new ArrayList<PresuProyectoCuenta>();
		this.presuproyectocuenta= new PresuProyectoCuenta();
		
		
		this.presuproyectosForeignKey=new ArrayList<PresuProyecto>();
		this.presutipocuentaproyectosForeignKey=new ArrayList<PresuTipoCuentaProyecto>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.presuestadosForeignKey=new ArrayList<PresuEstado>();
	} 
	
	public PresuProyectoCuenta getPresuProyectoCuenta() throws Exception {	
		return presuproyectocuenta;
	}
		
	public void setPresuProyectoCuenta(PresuProyectoCuenta newPresuProyectoCuenta) {
		this.presuproyectocuenta = newPresuProyectoCuenta;
	}
	
	public List<PresuProyectoCuenta> getPresuProyectoCuentas() throws Exception {		
		return presuproyectocuentas;
	}
	
	public void setPresuProyectoCuentas(List<PresuProyectoCuenta> newPresuProyectoCuentas) {
		this.presuproyectocuentas = newPresuProyectoCuentas;
	}
	
	

	public List<PresuProyecto> getpresuproyectosForeignKey() {
		return this.presuproyectosForeignKey;
	}

	public List<PresuTipoCuentaProyecto> getpresutipocuentaproyectosForeignKey() {
		return this.presutipocuentaproyectosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<PresuEstado> getpresuestadosForeignKey() {
		return this.presuestadosForeignKey;
	}
	
	

	public void setpresuproyectosForeignKey(List<PresuProyecto> presuproyectosForeignKey) {
		this.presuproyectosForeignKey=presuproyectosForeignKey;
	}

	public void setpresutipocuentaproyectosForeignKey(List<PresuTipoCuentaProyecto> presutipocuentaproyectosForeignKey) {
		this.presutipocuentaproyectosForeignKey=presutipocuentaproyectosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setpresuestadosForeignKey(List<PresuEstado> presuestadosForeignKey) {
		this.presuestadosForeignKey=presuestadosForeignKey;
	}
}

