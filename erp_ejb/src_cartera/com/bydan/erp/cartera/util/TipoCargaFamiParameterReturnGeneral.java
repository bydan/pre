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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.TipoCargaFamiConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoCargaFami


import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class TipoCargaFamiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCargaFami tipocargafami;	
	protected List<TipoCargaFami> tipocargafamis;
	
	
	
	public TipoCargaFamiParameterReturnGeneral () throws Exception {						
		super();
		this.tipocargafamis= new ArrayList<TipoCargaFami>();
		this.tipocargafami= new TipoCargaFami();
		
		
	} 
	
	public TipoCargaFami getTipoCargaFami() throws Exception {	
		return tipocargafami;
	}
		
	public void setTipoCargaFami(TipoCargaFami newTipoCargaFami) {
		this.tipocargafami = newTipoCargaFami;
	}
	
	public List<TipoCargaFami> getTipoCargaFamis() throws Exception {		
		return tipocargafamis;
	}
	
	public void setTipoCargaFamis(List<TipoCargaFami> newTipoCargaFamis) {
		this.tipocargafamis = newTipoCargaFamis;
	}
	
	
	
	
}

