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
import com.bydan.erp.nomina.util.PrestamoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Prestamo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class PrestamoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Prestamo prestamo;	
	protected List<Prestamo> prestamos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoPrestamo> tipoprestamosForeignKey;
	public List<TipoCuota> tipocuotasForeignKey;
	public List<AsientoContable> asientocontablesForeignKey;
	
	public PrestamoParameterReturnGeneral () throws Exception {						
		super();
		this.prestamos= new ArrayList<Prestamo>();
		this.prestamo= new Prestamo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tipoprestamosForeignKey=new ArrayList<TipoPrestamo>();
		this.tipocuotasForeignKey=new ArrayList<TipoCuota>();
		this.asientocontablesForeignKey=new ArrayList<AsientoContable>();
	} 
	
	public Prestamo getPrestamo() throws Exception {	
		return prestamo;
	}
		
	public void setPrestamo(Prestamo newPrestamo) {
		this.prestamo = newPrestamo;
	}
	
	public List<Prestamo> getPrestamos() throws Exception {		
		return prestamos;
	}
	
	public void setPrestamos(List<Prestamo> newPrestamos) {
		this.prestamos = newPrestamos;
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

	public List<TipoCuota> gettipocuotasForeignKey() {
		return this.tipocuotasForeignKey;
	}

	public List<AsientoContable> getasientocontablesForeignKey() {
		return this.asientocontablesForeignKey;
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

	public void settipocuotasForeignKey(List<TipoCuota> tipocuotasForeignKey) {
		this.tipocuotasForeignKey=tipocuotasForeignKey;
	}

	public void setasientocontablesForeignKey(List<AsientoContable> asientocontablesForeignKey) {
		this.asientocontablesForeignKey=asientocontablesForeignKey;
	}
}

