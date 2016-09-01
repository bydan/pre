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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.DetalleEvaluacionProveedorConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//DetalleEvaluacionProveedor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleEvaluacionProveedorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleEvaluacionProveedor detalleevaluacionproveedor;	
	protected List<DetalleEvaluacionProveedor> detalleevaluacionproveedors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<EvaluacionProveedor> evaluacionproveedorsForeignKey;
	public List<PreguntaEvaluacion> preguntaevaluacionsForeignKey;
	public List<SubPreguntaEvaluacion> subpreguntaevaluacionsForeignKey;
	public List<SiNo> sinosForeignKey;
	
	public DetalleEvaluacionProveedorParameterReturnGeneral () throws Exception {						
		super();
		this.detalleevaluacionproveedors= new ArrayList<DetalleEvaluacionProveedor>();
		this.detalleevaluacionproveedor= new DetalleEvaluacionProveedor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.evaluacionproveedorsForeignKey=new ArrayList<EvaluacionProveedor>();
		this.preguntaevaluacionsForeignKey=new ArrayList<PreguntaEvaluacion>();
		this.subpreguntaevaluacionsForeignKey=new ArrayList<SubPreguntaEvaluacion>();
		this.sinosForeignKey=new ArrayList<SiNo>();
	} 
	
	public DetalleEvaluacionProveedor getDetalleEvaluacionProveedor() throws Exception {	
		return detalleevaluacionproveedor;
	}
		
	public void setDetalleEvaluacionProveedor(DetalleEvaluacionProveedor newDetalleEvaluacionProveedor) {
		this.detalleevaluacionproveedor = newDetalleEvaluacionProveedor;
	}
	
	public List<DetalleEvaluacionProveedor> getDetalleEvaluacionProveedors() throws Exception {		
		return detalleevaluacionproveedors;
	}
	
	public void setDetalleEvaluacionProveedors(List<DetalleEvaluacionProveedor> newDetalleEvaluacionProveedors) {
		this.detalleevaluacionproveedors = newDetalleEvaluacionProveedors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<EvaluacionProveedor> getevaluacionproveedorsForeignKey() {
		return this.evaluacionproveedorsForeignKey;
	}

	public List<PreguntaEvaluacion> getpreguntaevaluacionsForeignKey() {
		return this.preguntaevaluacionsForeignKey;
	}

	public List<SubPreguntaEvaluacion> getsubpreguntaevaluacionsForeignKey() {
		return this.subpreguntaevaluacionsForeignKey;
	}

	public List<SiNo> getsinosForeignKey() {
		return this.sinosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setevaluacionproveedorsForeignKey(List<EvaluacionProveedor> evaluacionproveedorsForeignKey) {
		this.evaluacionproveedorsForeignKey=evaluacionproveedorsForeignKey;
	}

	public void setpreguntaevaluacionsForeignKey(List<PreguntaEvaluacion> preguntaevaluacionsForeignKey) {
		this.preguntaevaluacionsForeignKey=preguntaevaluacionsForeignKey;
	}

	public void setsubpreguntaevaluacionsForeignKey(List<SubPreguntaEvaluacion> subpreguntaevaluacionsForeignKey) {
		this.subpreguntaevaluacionsForeignKey=subpreguntaevaluacionsForeignKey;
	}

	public void setsinosForeignKey(List<SiNo> sinosForeignKey) {
		this.sinosForeignKey=sinosForeignKey;
	}
}

