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
import com.bydan.erp.nomina.util.CargoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Cargo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class CargoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Cargo cargo;	
	protected List<Cargo> cargos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cargo> cargosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<NumeroPatronal> numeropatronalsForeignKey;
	public List<TipoPago_NM> tipopago_nmsForeignKey;
	public List<CargoGrupo> cargogruposForeignKey;
	
	public CargoParameterReturnGeneral () throws Exception {						
		super();
		this.cargos= new ArrayList<Cargo>();
		this.cargo= new Cargo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cargosForeignKey=new ArrayList<Cargo>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
		this.tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
		this.cargogruposForeignKey=new ArrayList<CargoGrupo>();
	} 
	
	public Cargo getCargo() throws Exception {	
		return cargo;
	}
		
	public void setCargo(Cargo newCargo) {
		this.cargo = newCargo;
	}
	
	public List<Cargo> getCargos() throws Exception {		
		return cargos;
	}
	
	public void setCargos(List<Cargo> newCargos) {
		this.cargos = newCargos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cargo> getcargosForeignKey() {
		return this.cargosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<NumeroPatronal> getnumeropatronalsForeignKey() {
		return this.numeropatronalsForeignKey;
	}

	public List<TipoPago_NM> gettipopago_nmsForeignKey() {
		return this.tipopago_nmsForeignKey;
	}

	public List<CargoGrupo> getcargogruposForeignKey() {
		return this.cargogruposForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcargosForeignKey(List<Cargo> cargosForeignKey) {
		this.cargosForeignKey=cargosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setnumeropatronalsForeignKey(List<NumeroPatronal> numeropatronalsForeignKey) {
		this.numeropatronalsForeignKey=numeropatronalsForeignKey;
	}

	public void settipopago_nmsForeignKey(List<TipoPago_NM> tipopago_nmsForeignKey) {
		this.tipopago_nmsForeignKey=tipopago_nmsForeignKey;
	}

	public void setcargogruposForeignKey(List<CargoGrupo> cargogruposForeignKey) {
		this.cargogruposForeignKey=cargogruposForeignKey;
	}
}

