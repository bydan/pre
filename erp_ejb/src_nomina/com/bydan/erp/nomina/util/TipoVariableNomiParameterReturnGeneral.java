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
import com.bydan.erp.nomina.util.TipoVariableNomiConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoVariableNomi




@SuppressWarnings("unused")
public class TipoVariableNomiParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoVariableNomi tipovariablenomi;	
	protected List<TipoVariableNomi> tipovariablenomis;
	
	
	
	public TipoVariableNomiParameterReturnGeneral () throws Exception {						
		super();
		this.tipovariablenomis= new ArrayList<TipoVariableNomi>();
		this.tipovariablenomi= new TipoVariableNomi();
		
		
	} 
	
	public TipoVariableNomi getTipoVariableNomi() throws Exception {	
		return tipovariablenomi;
	}
		
	public void setTipoVariableNomi(TipoVariableNomi newTipoVariableNomi) {
		this.tipovariablenomi = newTipoVariableNomi;
	}
	
	public List<TipoVariableNomi> getTipoVariableNomis() throws Exception {		
		return tipovariablenomis;
	}
	
	public void setTipoVariableNomis(List<TipoVariableNomi> newTipoVariableNomis) {
		this.tipovariablenomis = newTipoVariableNomis;
	}
	
	
	
	
}

