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
import com.bydan.erp.nomina.util.VisaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Visa


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class VisaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Visa visa;	
	protected List<Visa> visas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Pais> paissForeignKey;
	public List<Empleado> empleadosForeignKey;
	
	public VisaParameterReturnGeneral () throws Exception {						
		super();
		this.visas= new ArrayList<Visa>();
		this.visa= new Visa();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public Visa getVisa() throws Exception {	
		return visa;
	}
		
	public void setVisa(Visa newVisa) {
		this.visa = newVisa;
	}
	
	public List<Visa> getVisas() throws Exception {		
		return visas;
	}
	
	public void setVisas(List<Visa> newVisas) {
		this.visas = newVisas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

