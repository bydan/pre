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
import com.bydan.erp.nomina.util.ReferenciaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Referencia


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ReferenciaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Referencia referencia;	
	protected List<Referencia> referencias;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	public List<Parentezco> parentezcosForeignKey;
	public List<Profesion> profesionsForeignKey;
	
	public ReferenciaParameterReturnGeneral () throws Exception {						
		super();
		this.referencias= new ArrayList<Referencia>();
		this.referencia= new Referencia();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.parentezcosForeignKey=new ArrayList<Parentezco>();
		this.profesionsForeignKey=new ArrayList<Profesion>();
	} 
	
	public Referencia getReferencia() throws Exception {	
		return referencia;
	}
		
	public void setReferencia(Referencia newReferencia) {
		this.referencia = newReferencia;
	}
	
	public List<Referencia> getReferencias() throws Exception {		
		return referencias;
	}
	
	public void setReferencias(List<Referencia> newReferencias) {
		this.referencias = newReferencias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<Parentezco> getparentezcosForeignKey() {
		return this.parentezcosForeignKey;
	}

	public List<Profesion> getprofesionsForeignKey() {
		return this.profesionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setparentezcosForeignKey(List<Parentezco> parentezcosForeignKey) {
		this.parentezcosForeignKey=parentezcosForeignKey;
	}

	public void setprofesionsForeignKey(List<Profesion> profesionsForeignKey) {
		this.profesionsForeignKey=profesionsForeignKey;
	}
}

