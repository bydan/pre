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
package com.bydan.erp.seguridad.util;

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
import com.bydan.erp.seguridad.util.TipoTeclaMascaraConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//TipoTeclaMascara




@SuppressWarnings("unused")
public class TipoTeclaMascaraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoTeclaMascara tipoteclamascara;	
	protected List<TipoTeclaMascara> tipoteclamascaras;
	
	
	
	public TipoTeclaMascaraParameterReturnGeneral () throws Exception {						
		super();
		this.tipoteclamascaras= new ArrayList<TipoTeclaMascara>();
		this.tipoteclamascara= new TipoTeclaMascara();
		
		
	} 
	
	public TipoTeclaMascara getTipoTeclaMascara() throws Exception {	
		return tipoteclamascara;
	}
		
	public void setTipoTeclaMascara(TipoTeclaMascara newTipoTeclaMascara) {
		this.tipoteclamascara = newTipoTeclaMascara;
	}
	
	public List<TipoTeclaMascara> getTipoTeclaMascaras() throws Exception {		
		return tipoteclamascaras;
	}
	
	public void setTipoTeclaMascaras(List<TipoTeclaMascara> newTipoTeclaMascaras) {
		this.tipoteclamascaras = newTipoTeclaMascaras;
	}
	
	
	
	
}

