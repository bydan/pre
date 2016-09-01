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
import com.bydan.erp.nomina.util.SolicitudHoraExtraConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//SolicitudHoraExtra


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class SolicitudHoraExtraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SolicitudHoraExtra solicitudhoraextra;	
	protected List<SolicitudHoraExtra> solicitudhoraextras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Empleado> empleadojefesForeignKey;
	public List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey;
	public List<Empleado> empleadoreemplazosForeignKey;
	
	public SolicitudHoraExtraParameterReturnGeneral () throws Exception {						
		super();
		this.solicitudhoraextras= new ArrayList<SolicitudHoraExtra>();
		this.solicitudhoraextra= new SolicitudHoraExtra();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.empleadojefesForeignKey=new ArrayList<Empleado>();
		this.estadosolicitudnomisForeignKey=new ArrayList<EstadoSolicitudNomi>();
		this.empleadoreemplazosForeignKey=new ArrayList<Empleado>();
	} 
	
	public SolicitudHoraExtra getSolicitudHoraExtra() throws Exception {	
		return solicitudhoraextra;
	}
		
	public void setSolicitudHoraExtra(SolicitudHoraExtra newSolicitudHoraExtra) {
		this.solicitudhoraextra = newSolicitudHoraExtra;
	}
	
	public List<SolicitudHoraExtra> getSolicitudHoraExtras() throws Exception {		
		return solicitudhoraextras;
	}
	
	public void setSolicitudHoraExtras(List<SolicitudHoraExtra> newSolicitudHoraExtras) {
		this.solicitudhoraextras = newSolicitudHoraExtras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Empleado> getempleadojefesForeignKey() {
		return this.empleadojefesForeignKey;
	}

	public List<EstadoSolicitudNomi> getestadosolicitudnomisForeignKey() {
		return this.estadosolicitudnomisForeignKey;
	}

	public List<Empleado> getempleadoreemplazosForeignKey() {
		return this.empleadoreemplazosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setempleadojefesForeignKey(List<Empleado> empleadojefesForeignKey) {
		this.empleadojefesForeignKey=empleadojefesForeignKey;
	}

	public void setestadosolicitudnomisForeignKey(List<EstadoSolicitudNomi> estadosolicitudnomisForeignKey) {
		this.estadosolicitudnomisForeignKey=estadosolicitudnomisForeignKey;
	}

	public void setempleadoreemplazosForeignKey(List<Empleado> empleadoreemplazosForeignKey) {
		this.empleadoreemplazosForeignKey=empleadoreemplazosForeignKey;
	}
}

