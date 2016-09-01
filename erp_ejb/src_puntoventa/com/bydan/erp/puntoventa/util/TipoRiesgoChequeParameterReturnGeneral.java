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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.TipoRiesgoChequeConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//TipoRiesgoCheque




@SuppressWarnings("unused")
public class TipoRiesgoChequeParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoRiesgoCheque tiporiesgocheque;	
	protected List<TipoRiesgoCheque> tiporiesgocheques;
	
	
	
	public TipoRiesgoChequeParameterReturnGeneral () throws Exception {						
		super();
		this.tiporiesgocheques= new ArrayList<TipoRiesgoCheque>();
		this.tiporiesgocheque= new TipoRiesgoCheque();
		
		
	} 
	
	public TipoRiesgoCheque getTipoRiesgoCheque() throws Exception {	
		return tiporiesgocheque;
	}
		
	public void setTipoRiesgoCheque(TipoRiesgoCheque newTipoRiesgoCheque) {
		this.tiporiesgocheque = newTipoRiesgoCheque;
	}
	
	public List<TipoRiesgoCheque> getTipoRiesgoCheques() throws Exception {		
		return tiporiesgocheques;
	}
	
	public void setTipoRiesgoCheques(List<TipoRiesgoCheque> newTipoRiesgoCheques) {
		this.tiporiesgocheques = newTipoRiesgoCheques;
	}
	
	
	
	
}

