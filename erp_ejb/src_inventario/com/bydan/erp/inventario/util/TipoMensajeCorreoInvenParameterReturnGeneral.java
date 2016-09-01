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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//TipoMensajeCorreoInven


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoMensajeCorreoInvenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoMensajeCorreoInven tipomensajecorreoinven;	
	protected List<TipoMensajeCorreoInven> tipomensajecorreoinvens;
	
	
	public List<Modulo> modulosForeignKey;
	
	public TipoMensajeCorreoInvenParameterReturnGeneral () throws Exception {						
		super();
		this.tipomensajecorreoinvens= new ArrayList<TipoMensajeCorreoInven>();
		this.tipomensajecorreoinven= new TipoMensajeCorreoInven();
		
		
		this.modulosForeignKey=new ArrayList<Modulo>();
	} 
	
	public TipoMensajeCorreoInven getTipoMensajeCorreoInven() throws Exception {	
		return tipomensajecorreoinven;
	}
		
	public void setTipoMensajeCorreoInven(TipoMensajeCorreoInven newTipoMensajeCorreoInven) {
		this.tipomensajecorreoinven = newTipoMensajeCorreoInven;
	}
	
	public List<TipoMensajeCorreoInven> getTipoMensajeCorreoInvens() throws Exception {		
		return tipomensajecorreoinvens;
	}
	
	public void setTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> newTipoMensajeCorreoInvens) {
		this.tipomensajecorreoinvens = newTipoMensajeCorreoInvens;
	}
	
	

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}
	
	

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}
}

