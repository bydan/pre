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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.PresuProyectoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresuProyecto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PresuProyectoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresuProyecto presuproyecto;	
	protected List<PresuProyecto> presuproyectos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<PresuTipoProyecto> presutipoproyectosForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<PresuEstado> presuestadosForeignKey;
	
	public PresuProyectoParameterReturnGeneral () throws Exception {						
		super();
		this.presuproyectos= new ArrayList<PresuProyecto>();
		this.presuproyecto= new PresuProyecto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.presutipoproyectosForeignKey=new ArrayList<PresuTipoProyecto>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.presuestadosForeignKey=new ArrayList<PresuEstado>();
	} 
	
	public PresuProyecto getPresuProyecto() throws Exception {	
		return presuproyecto;
	}
		
	public void setPresuProyecto(PresuProyecto newPresuProyecto) {
		this.presuproyecto = newPresuProyecto;
	}
	
	public List<PresuProyecto> getPresuProyectos() throws Exception {		
		return presuproyectos;
	}
	
	public void setPresuProyectos(List<PresuProyecto> newPresuProyectos) {
		this.presuproyectos = newPresuProyectos;
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

	public List<PresuTipoProyecto> getpresutipoproyectosForeignKey() {
		return this.presutipoproyectosForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<PresuEstado> getpresuestadosForeignKey() {
		return this.presuestadosForeignKey;
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

	public void setpresutipoproyectosForeignKey(List<PresuTipoProyecto> presutipoproyectosForeignKey) {
		this.presutipoproyectosForeignKey=presutipoproyectosForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setpresuestadosForeignKey(List<PresuEstado> presuestadosForeignKey) {
		this.presuestadosForeignKey=presuestadosForeignKey;
	}
}

