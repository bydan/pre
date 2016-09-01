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
import com.bydan.erp.nomina.util.SolicitudVacacionConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//SolicitudVacacion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class SolicitudVacacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SolicitudVacacion solicitudvacacion;	
	protected List<SolicitudVacacion> solicitudvacacions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Empleado> empleadojefesForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey;
	public List<Formato> formatosForeignKey;
	
	public SolicitudVacacionParameterReturnGeneral () throws Exception {						
		super();
		this.solicitudvacacions= new ArrayList<SolicitudVacacion>();
		this.solicitudvacacion= new SolicitudVacacion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.empleadojefesForeignKey=new ArrayList<Empleado>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
		this.formatosForeignKey=new ArrayList<Formato>();
	} 
	
	public SolicitudVacacion getSolicitudVacacion() throws Exception {	
		return solicitudvacacion;
	}
		
	public void setSolicitudVacacion(SolicitudVacacion newSolicitudVacacion) {
		this.solicitudvacacion = newSolicitudVacacion;
	}
	
	public List<SolicitudVacacion> getSolicitudVacacions() throws Exception {		
		return solicitudvacacions;
	}
	
	public void setSolicitudVacacions(List<SolicitudVacacion> newSolicitudVacacions) {
		this.solicitudvacacions = newSolicitudVacacions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Empleado> getempleadojefesForeignKey() {
		return this.empleadojefesForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<EstadoSolicitudNomi> getestadosolicitudnomisForeignKey() {
		return this.estadosolicitudnomisForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setempleadojefesForeignKey(List<Empleado> empleadojefesForeignKey) {
		this.empleadojefesForeignKey=empleadojefesForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setestadosolicitudnomisForeignKey(List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey) {
		this.estadosolicitudnomisForeignKey=estadosolicitudnomisForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}
}

