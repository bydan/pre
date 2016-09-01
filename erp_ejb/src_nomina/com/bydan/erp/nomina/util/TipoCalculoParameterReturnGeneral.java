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
import com.bydan.erp.nomina.util.TipoCalculoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoCalculo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class TipoCalculoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCalculo tipocalculo;	
	protected List<TipoCalculo> tipocalculos;
	
	
	
	public TipoCalculoParameterReturnGeneral () throws Exception {						
		super();
		this.tipocalculos= new ArrayList<TipoCalculo>();
		this.tipocalculo= new TipoCalculo();
		
		
	} 
	
	public TipoCalculo getTipoCalculo() throws Exception {	
		return tipocalculo;
	}
		
	public void setTipoCalculo(TipoCalculo newTipoCalculo) {
		this.tipocalculo = newTipoCalculo;
	}
	
	public List<TipoCalculo> getTipoCalculos() throws Exception {		
		return tipocalculos;
	}
	
	public void setTipoCalculos(List<TipoCalculo> newTipoCalculos) {
		this.tipocalculos = newTipoCalculos;
	}
	
	
	
	
}

