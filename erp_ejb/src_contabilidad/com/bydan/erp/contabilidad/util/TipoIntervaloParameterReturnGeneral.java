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
import com.bydan.erp.contabilidad.util.TipoIntervaloConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoIntervalo


import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class TipoIntervaloParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoIntervalo tipointervalo;	
	protected List<TipoIntervalo> tipointervalos;
	
	
	
	public TipoIntervaloParameterReturnGeneral () throws Exception {						
		super();
		this.tipointervalos= new ArrayList<TipoIntervalo>();
		this.tipointervalo= new TipoIntervalo();
		
		
	} 
	
	public TipoIntervalo getTipoIntervalo() throws Exception {	
		return tipointervalo;
	}
		
	public void setTipoIntervalo(TipoIntervalo newTipoIntervalo) {
		this.tipointervalo = newTipoIntervalo;
	}
	
	public List<TipoIntervalo> getTipoIntervalos() throws Exception {		
		return tipointervalos;
	}
	
	public void setTipoIntervalos(List<TipoIntervalo> newTipoIntervalos) {
		this.tipointervalos = newTipoIntervalos;
	}
	
	
	
	
}

