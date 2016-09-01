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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//RubroEmpleaCuentaContable


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class RubroEmpleaCuentaContableParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RubroEmpleaCuentaContable rubroempleacuentacontable;	
	protected List<RubroEmpleaCuentaContable> rubroempleacuentacontables;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Estructura> estructurasForeignKey;
	
	public RubroEmpleaCuentaContableParameterReturnGeneral () throws Exception {						
		super();
		this.rubroempleacuentacontables= new ArrayList<RubroEmpleaCuentaContable>();
		this.rubroempleacuentacontable= new RubroEmpleaCuentaContable();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
	} 
	
	public RubroEmpleaCuentaContable getRubroEmpleaCuentaContable() throws Exception {	
		return rubroempleacuentacontable;
	}
		
	public void setRubroEmpleaCuentaContable(RubroEmpleaCuentaContable newRubroEmpleaCuentaContable) {
		this.rubroempleacuentacontable = newRubroEmpleaCuentaContable;
	}
	
	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables() throws Exception {		
		return rubroempleacuentacontables;
	}
	
	public void setRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> newRubroEmpleaCuentaContables) {
		this.rubroempleacuentacontables = newRubroEmpleaCuentaContables;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}
}

