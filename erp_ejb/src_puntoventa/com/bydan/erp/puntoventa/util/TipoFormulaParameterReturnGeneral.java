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
import com.bydan.erp.puntoventa.util.TipoFormulaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//TipoFormula


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoFormulaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoFormula tipoformula;	
	protected List<TipoFormula> tipoformulas;
	
	
	
	public TipoFormulaParameterReturnGeneral () throws Exception {						
		super();
		this.tipoformulas= new ArrayList<TipoFormula>();
		this.tipoformula= new TipoFormula();
		
		
	} 
	
	public TipoFormula getTipoFormula() throws Exception {	
		return tipoformula;
	}
		
	public void setTipoFormula(TipoFormula newTipoFormula) {
		this.tipoformula = newTipoFormula;
	}
	
	public List<TipoFormula> getTipoFormulas() throws Exception {		
		return tipoformulas;
	}
	
	public void setTipoFormulas(List<TipoFormula> newTipoFormulas) {
		this.tipoformulas = newTipoFormulas;
	}
	
	
	
	
}

