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
import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresupuestoFlujoCaja


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PresupuestoFlujoCajaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresupuestoFlujoCaja presupuestoflujocaja;	
	protected List<PresupuestoFlujoCaja> presupuestoflujocajas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public PresupuestoFlujoCajaParameterReturnGeneral () throws Exception {						
		super();
		this.presupuestoflujocajas= new ArrayList<PresupuestoFlujoCaja>();
		this.presupuestoflujocaja= new PresupuestoFlujoCaja();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public PresupuestoFlujoCaja getPresupuestoFlujoCaja() throws Exception {	
		return presupuestoflujocaja;
	}
		
	public void setPresupuestoFlujoCaja(PresupuestoFlujoCaja newPresupuestoFlujoCaja) {
		this.presupuestoflujocaja = newPresupuestoFlujoCaja;
	}
	
	public List<PresupuestoFlujoCaja> getPresupuestoFlujoCajas() throws Exception {		
		return presupuestoflujocajas;
	}
	
	public void setPresupuestoFlujoCajas(List<PresupuestoFlujoCaja> newPresupuestoFlujoCajas) {
		this.presupuestoflujocajas = newPresupuestoFlujoCajas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

