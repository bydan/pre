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
import com.bydan.erp.contabilidad.util.PresuEstadoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PresuEstado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PresuEstadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PresuEstado presuestado;	
	protected List<PresuEstado> presuestados;
	
	
	
	public PresuEstadoParameterReturnGeneral () throws Exception {						
		super();
		this.presuestados= new ArrayList<PresuEstado>();
		this.presuestado= new PresuEstado();
		
		
	} 
	
	public PresuEstado getPresuEstado() throws Exception {	
		return presuestado;
	}
		
	public void setPresuEstado(PresuEstado newPresuEstado) {
		this.presuestado = newPresuEstado;
	}
	
	public List<PresuEstado> getPresuEstados() throws Exception {		
		return presuestados;
	}
	
	public void setPresuEstados(List<PresuEstado> newPresuEstados) {
		this.presuestados = newPresuEstados;
	}
	
	
	
	
}

