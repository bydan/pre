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
import com.bydan.erp.nomina.util.RasgoPersonalConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//RasgoPersonal


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RasgoPersonalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RasgoPersonal rasgopersonal;	
	protected List<RasgoPersonal> rasgopersonals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<TipoRasgoPersonal> tiporasgopersonalsForeignKey;
	
	public RasgoPersonalParameterReturnGeneral () throws Exception {						
		super();
		this.rasgopersonals= new ArrayList<RasgoPersonal>();
		this.rasgopersonal= new RasgoPersonal();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.tiporasgopersonalsForeignKey=new ArrayList<TipoRasgoPersonal>();
	} 
	
	public RasgoPersonal getRasgoPersonal() throws Exception {	
		return rasgopersonal;
	}
		
	public void setRasgoPersonal(RasgoPersonal newRasgoPersonal) {
		this.rasgopersonal = newRasgoPersonal;
	}
	
	public List<RasgoPersonal> getRasgoPersonals() throws Exception {		
		return rasgopersonals;
	}
	
	public void setRasgoPersonals(List<RasgoPersonal> newRasgoPersonals) {
		this.rasgopersonals = newRasgoPersonals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<TipoRasgoPersonal> gettiporasgopersonalsForeignKey() {
		return this.tiporasgopersonalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void settiporasgopersonalsForeignKey(List<TipoRasgoPersonal> tiporasgopersonalsForeignKey) {
		this.tiporasgopersonalsForeignKey=tiporasgopersonalsForeignKey;
	}
}

