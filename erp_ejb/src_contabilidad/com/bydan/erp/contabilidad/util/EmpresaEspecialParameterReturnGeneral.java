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
import com.bydan.erp.contabilidad.util.EmpresaEspecialConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//EmpresaEspecial




@SuppressWarnings("unused")
public class EmpresaEspecialParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EmpresaEspecial empresaespecial;	
	protected List<EmpresaEspecial> empresaespecials;
	
	
	
	public EmpresaEspecialParameterReturnGeneral () throws Exception {						
		super();
		this.empresaespecials= new ArrayList<EmpresaEspecial>();
		this.empresaespecial= new EmpresaEspecial();
		
		
	} 
	
	public EmpresaEspecial getEmpresaEspecial() throws Exception {	
		return empresaespecial;
	}
		
	public void setEmpresaEspecial(EmpresaEspecial newEmpresaEspecial) {
		this.empresaespecial = newEmpresaEspecial;
	}
	
	public List<EmpresaEspecial> getEmpresaEspecials() throws Exception {		
		return empresaespecials;
	}
	
	public void setEmpresaEspecials(List<EmpresaEspecial> newEmpresaEspecials) {
		this.empresaespecials = newEmpresaEspecials;
	}
	
	
	
	
}

