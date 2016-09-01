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
import com.bydan.erp.nomina.util.SolicitudReemplazoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//SolicitudReemplazo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class SolicitudReemplazoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SolicitudReemplazo solicitudreemplazo;	
	protected List<SolicitudReemplazo> solicitudreemplazos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Empleado> empleadojefesForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Empleado> empleadoreemplazosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey;
	
	public SolicitudReemplazoParameterReturnGeneral () throws Exception {						
		super();
		this.solicitudreemplazos= new ArrayList<SolicitudReemplazo>();
		this.solicitudreemplazo= new SolicitudReemplazo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.empleadojefesForeignKey=new ArrayList<Empleado>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.empleadoreemplazosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
	} 
	
	public SolicitudReemplazo getSolicitudReemplazo() throws Exception {	
		return solicitudreemplazo;
	}
		
	public void setSolicitudReemplazo(SolicitudReemplazo newSolicitudReemplazo) {
		this.solicitudreemplazo = newSolicitudReemplazo;
	}
	
	public List<SolicitudReemplazo> getSolicitudReemplazos() throws Exception {		
		return solicitudreemplazos;
	}
	
	public void setSolicitudReemplazos(List<SolicitudReemplazo> newSolicitudReemplazos) {
		this.solicitudreemplazos = newSolicitudReemplazos;
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

	public List<Empleado> getempleadoreemplazosForeignKey() {
		return this.empleadoreemplazosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<EstadoSolicitudNomi> getestadosolicitudnomisForeignKey() {
		return this.estadosolicitudnomisForeignKey;
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

	public void setempleadoreemplazosForeignKey(List<Empleado> empleadoreemplazosForeignKey) {
		this.empleadoreemplazosForeignKey=empleadoreemplazosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setestadosolicitudnomisForeignKey(List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey) {
		this.estadosolicitudnomisForeignKey=estadosolicitudnomisForeignKey;
	}
}

