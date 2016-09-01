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
import com.bydan.erp.nomina.util.Telefono_NMConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Telefono_NM


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class Telefono_NMParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Telefono_NM telefono_nm;	
	protected List<Telefono_NM> telefono_nms;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Empleado> empleadosForeignKey;
	
	public Telefono_NMParameterReturnGeneral () throws Exception {						
		super();
		this.telefono_nms= new ArrayList<Telefono_NM>();
		this.telefono_nm= new Telefono_NM();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.empleadosForeignKey=new ArrayList<Empleado>();
	} 
	
	public Telefono_NM getTelefono_NM() throws Exception {	
		return telefono_nm;
	}
		
	public void setTelefono_NM(Telefono_NM newTelefono_NM) {
		this.telefono_nm = newTelefono_NM;
	}
	
	public List<Telefono_NM> getTelefono_NMs() throws Exception {		
		return telefono_nms;
	}
	
	public void setTelefono_NMs(List<Telefono_NM> newTelefono_NMs) {
		this.telefono_nms = newTelefono_NMs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}
}

