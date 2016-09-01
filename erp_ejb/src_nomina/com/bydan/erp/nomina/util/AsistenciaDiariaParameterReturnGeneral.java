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
import com.bydan.erp.nomina.util.AsistenciaDiariaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//AsistenciaDiaria


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class AsistenciaDiariaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AsistenciaDiaria asistenciadiaria;	
	protected List<AsistenciaDiaria> asistenciadiarias;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<Estructura> estructuraseccionsForeignKey;
	
	public AsistenciaDiariaParameterReturnGeneral () throws Exception {						
		super();
		this.asistenciadiarias= new ArrayList<AsistenciaDiaria>();
		this.asistenciadiaria= new AsistenciaDiaria();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.estructuraseccionsForeignKey=new ArrayList<Estructura>();
	} 
	
	public AsistenciaDiaria getAsistenciaDiaria() throws Exception {	
		return asistenciadiaria;
	}
		
	public void setAsistenciaDiaria(AsistenciaDiaria newAsistenciaDiaria) {
		this.asistenciadiaria = newAsistenciaDiaria;
	}
	
	public List<AsistenciaDiaria> getAsistenciaDiarias() throws Exception {		
		return asistenciadiarias;
	}
	
	public void setAsistenciaDiarias(List<AsistenciaDiaria> newAsistenciaDiarias) {
		this.asistenciadiarias = newAsistenciaDiarias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<Estructura> getestructuraseccionsForeignKey() {
		return this.estructuraseccionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void setestructuraseccionsForeignKey(List<Estructura> estructuraseccionsForeignKey) {
		this.estructuraseccionsForeignKey=estructuraseccionsForeignKey;
	}
}

