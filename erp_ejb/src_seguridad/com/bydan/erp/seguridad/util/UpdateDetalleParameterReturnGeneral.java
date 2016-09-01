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
import com.bydan.erp.seguridad.util.UpdateDetalleConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//UpdateDetalle




@SuppressWarnings("unused")
public class UpdateDetalleParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected UpdateDetalle updatedetalle;	
	protected List<UpdateDetalle> updatedetalles;
	
	
	public List<Update> updatesForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public UpdateDetalleParameterReturnGeneral () throws Exception {						
		super();
		this.updatedetalles= new ArrayList<UpdateDetalle>();
		this.updatedetalle= new UpdateDetalle();
		
		
		this.updatesForeignKey=new ArrayList<Update>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public UpdateDetalle getUpdateDetalle() throws Exception {	
		return updatedetalle;
	}
		
	public void setUpdateDetalle(UpdateDetalle newUpdateDetalle) {
		this.updatedetalle = newUpdateDetalle;
	}
	
	public List<UpdateDetalle> getUpdateDetalles() throws Exception {		
		return updatedetalles;
	}
	
	public void setUpdateDetalles(List<UpdateDetalle> newUpdateDetalles) {
		this.updatedetalles = newUpdateDetalles;
	}
	
	

	public List<Update> getupdatesForeignKey() {
		return this.updatesForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setupdatesForeignKey(List<Update> updatesForeignKey) {
		this.updatesForeignKey=updatesForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

