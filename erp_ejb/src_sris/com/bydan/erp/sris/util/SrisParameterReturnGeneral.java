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
package com.bydan.erp.sris.util;

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
import com.bydan.erp.sris.util.SrisConstantesFunciones;

import com.bydan.erp.sris.business.entity.*;//Sris




@SuppressWarnings("unused")
public class SrisParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Sris sris;	
	protected List<Sris> sriss;
	
	
	
	public SrisParameterReturnGeneral () throws Exception {						
		super();
		this.sriss= new ArrayList<Sris>();
		this.sris= new Sris();
		
		
	} 
	
	public Sris getSris() throws Exception {	
		return sris;
	}
		
	public void setSris(Sris newSris) {
		this.sris = newSris;
	}
	
	public List<Sris> getSriss() throws Exception {		
		return sriss;
	}
	
	public void setSriss(List<Sris> newSriss) {
		this.sriss = newSriss;
	}
	
	
	
	
}

