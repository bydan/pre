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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.RequisicionConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Requisicion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class RequisicionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Requisicion requisicion;	
	protected List<Requisicion> requisicions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoRequisicion> tiporequisicionsForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<EstadoRequisicion> estadorequisicionsForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Bodega> bodegasolicitarsForeignKey;
	public List<Bodega> bodegasolicitasForeignKey;
	
	public RequisicionParameterReturnGeneral () throws Exception {						
		super();
		this.requisicions= new ArrayList<Requisicion>();
		this.requisicion= new Requisicion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tiporequisicionsForeignKey=new ArrayList<TipoRequisicion>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estadorequisicionsForeignKey=new ArrayList<EstadoRequisicion>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.bodegasolicitarsForeignKey=new ArrayList<Bodega>();
		this.bodegasolicitasForeignKey=new ArrayList<Bodega>();
	} 
	
	public Requisicion getRequisicion() throws Exception {	
		return requisicion;
	}
		
	public void setRequisicion(Requisicion newRequisicion) {
		this.requisicion = newRequisicion;
	}
	
	public List<Requisicion> getRequisicions() throws Exception {		
		return requisicions;
	}
	
	public void setRequisicions(List<Requisicion> newRequisicions) {
		this.requisicions = newRequisicions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoRequisicion> gettiporequisicionsForeignKey() {
		return this.tiporequisicionsForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<EstadoRequisicion> getestadorequisicionsForeignKey() {
		return this.estadorequisicionsForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Bodega> getbodegasolicitarsForeignKey() {
		return this.bodegasolicitarsForeignKey;
	}

	public List<Bodega> getbodegasolicitasForeignKey() {
		return this.bodegasolicitasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settiporequisicionsForeignKey(List<TipoRequisicion> tiporequisicionsForeignKey) {
		this.tiporequisicionsForeignKey=tiporequisicionsForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestadorequisicionsForeignKey(List<EstadoRequisicion> estadorequisicionsForeignKey) {
		this.estadorequisicionsForeignKey=estadorequisicionsForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setbodegasolicitarsForeignKey(List<Bodega> bodegasolicitarsForeignKey) {
		this.bodegasolicitarsForeignKey=bodegasolicitarsForeignKey;
	}

	public void setbodegasolicitasForeignKey(List<Bodega> bodegasolicitasForeignKey) {
		this.bodegasolicitasForeignKey=bodegasolicitasForeignKey;
	}
}

