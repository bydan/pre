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
import com.bydan.erp.nomina.util.PlaniVacacionConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//PlaniVacacion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class PlaniVacacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PlaniVacacion planivacacion;	
	protected List<PlaniVacacion> planivacacions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Estructura> estructuraseccionsForeignKey;
	public List<Estructura> estructuracargosForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Mes> messForeignKey;
	
	public PlaniVacacionParameterReturnGeneral () throws Exception {						
		super();
		this.planivacacions= new ArrayList<PlaniVacacion>();
		this.planivacacion= new PlaniVacacion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.estructuraseccionsForeignKey=new ArrayList<Estructura>();
		this.estructuracargosForeignKey=new ArrayList<Estructura>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public PlaniVacacion getPlaniVacacion() throws Exception {	
		return planivacacion;
	}
		
	public void setPlaniVacacion(PlaniVacacion newPlaniVacacion) {
		this.planivacacion = newPlaniVacacion;
	}
	
	public List<PlaniVacacion> getPlaniVacacions() throws Exception {		
		return planivacacions;
	}
	
	public void setPlaniVacacions(List<PlaniVacacion> newPlaniVacacions) {
		this.planivacacions = newPlaniVacacions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Estructura> getestructuraseccionsForeignKey() {
		return this.estructuraseccionsForeignKey;
	}

	public List<Estructura> getestructuracargosForeignKey() {
		return this.estructuracargosForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setestructuraseccionsForeignKey(List<Estructura> estructuraseccionsForeignKey) {
		this.estructuraseccionsForeignKey=estructuraseccionsForeignKey;
	}

	public void setestructuracargosForeignKey(List<Estructura> estructuracargosForeignKey) {
		this.estructuracargosForeignKey=estructuracargosForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

