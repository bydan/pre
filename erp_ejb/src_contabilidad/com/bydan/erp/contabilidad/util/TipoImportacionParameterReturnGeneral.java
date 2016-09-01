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
import com.bydan.erp.contabilidad.util.TipoImportacionConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoImportacion




@SuppressWarnings("unused")
public class TipoImportacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoImportacion tipoimportacion;	
	protected List<TipoImportacion> tipoimportacions;
	
	
	
	public TipoImportacionParameterReturnGeneral () throws Exception {						
		super();
		this.tipoimportacions= new ArrayList<TipoImportacion>();
		this.tipoimportacion= new TipoImportacion();
		
		
	} 
	
	public TipoImportacion getTipoImportacion() throws Exception {	
		return tipoimportacion;
	}
		
	public void setTipoImportacion(TipoImportacion newTipoImportacion) {
		this.tipoimportacion = newTipoImportacion;
	}
	
	public List<TipoImportacion> getTipoImportacions() throws Exception {		
		return tipoimportacions;
	}
	
	public void setTipoImportacions(List<TipoImportacion> newTipoImportacions) {
		this.tipoimportacions = newTipoImportacions;
	}
	
	
	
	
}

