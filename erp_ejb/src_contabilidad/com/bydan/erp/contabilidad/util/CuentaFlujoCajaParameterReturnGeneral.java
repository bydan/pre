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
import com.bydan.erp.contabilidad.util.CuentaFlujoCajaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//CuentaFlujoCaja


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CuentaFlujoCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CuentaFlujoCaja cuentaflujocaja;	
	protected List<CuentaFlujoCaja> cuentaflujocajas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Mes> messForeignKey;
	public List<Dia> diasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public CuentaFlujoCajaParameterReturnGeneral () throws Exception {						
		super();
		this.cuentaflujocajas= new ArrayList<CuentaFlujoCaja>();
		this.cuentaflujocaja= new CuentaFlujoCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.messForeignKey=new ArrayList<Mes>();
		this.diasForeignKey=new ArrayList<Dia>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public CuentaFlujoCaja getCuentaFlujoCaja() throws Exception {	
		return cuentaflujocaja;
	}
		
	public void setCuentaFlujoCaja(CuentaFlujoCaja newCuentaFlujoCaja) {
		this.cuentaflujocaja = newCuentaFlujoCaja;
	}
	
	public List<CuentaFlujoCaja> getCuentaFlujoCajas() throws Exception {		
		return cuentaflujocajas;
	}
	
	public void setCuentaFlujoCajas(List<CuentaFlujoCaja> newCuentaFlujoCajas) {
		this.cuentaflujocajas = newCuentaFlujoCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}

	public List<Dia> getdiasForeignKey() {
		return this.diasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}

	public void setdiasForeignKey(List<Dia> diasForeignKey) {
		this.diasForeignKey=diasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

