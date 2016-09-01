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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.CreditosDetalladosConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//CreditosDetallados


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CreditosDetalladosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CreditosDetallados creditosdetallados;	
	protected List<CreditosDetallados> creditosdetalladoss;
	
	
	public List<Cargo> cargosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoPrestamo> tipoprestamosForeignKey;
	
	public CreditosDetalladosParameterReturnGeneral () throws Exception {						
		super();
		this.creditosdetalladoss= new ArrayList<CreditosDetallados>();
		this.creditosdetallados= new CreditosDetallados();
		
		
		this.cargosForeignKey=new ArrayList<Cargo>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipoprestamosForeignKey=new ArrayList<TipoPrestamo>();
	} 
	
	public CreditosDetallados getCreditosDetallados() throws Exception {	
		return creditosdetallados;
	}
		
	public void setCreditosDetallados(CreditosDetallados newCreditosDetallados) {
		this.creditosdetallados = newCreditosDetallados;
	}
	
	public List<CreditosDetallados> getCreditosDetalladoss() throws Exception {		
		return creditosdetalladoss;
	}
	
	public void setCreditosDetalladoss(List<CreditosDetallados> newCreditosDetalladoss) {
		this.creditosdetalladoss = newCreditosDetalladoss;
	}
	
	

	public List<Cargo> getcargosForeignKey() {
		return this.cargosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoPrestamo> gettipoprestamosForeignKey() {
		return this.tipoprestamosForeignKey;
	}
	
	

	public void setcargosForeignKey(List<Cargo> cargosForeignKey) {
		this.cargosForeignKey=cargosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settipoprestamosForeignKey(List<TipoPrestamo> tipoprestamosForeignKey) {
		this.tipoprestamosForeignKey=tipoprestamosForeignKey;
	}
}

