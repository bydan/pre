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
import com.bydan.erp.seguridad.util.PerfilAccionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//PerfilAccion




@SuppressWarnings("unused")
public class PerfilAccionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PerfilAccion perfilaccion;	
	protected List<PerfilAccion> perfilaccions;
	
	
	public List<Perfil> perfilsForeignKey;
	public List<Accion> accionsForeignKey;
	
	public PerfilAccionParameterReturnGeneral () throws Exception {						
		super();
		this.perfilaccions= new ArrayList<PerfilAccion>();
		this.perfilaccion= new PerfilAccion();
		
		
		this.perfilsForeignKey=new ArrayList<Perfil>();
		this.accionsForeignKey=new ArrayList<Accion>();
	} 
	
	public PerfilAccion getPerfilAccion() throws Exception {	
		return perfilaccion;
	}
		
	public void setPerfilAccion(PerfilAccion newPerfilAccion) {
		this.perfilaccion = newPerfilAccion;
	}
	
	public List<PerfilAccion> getPerfilAccions() throws Exception {		
		return perfilaccions;
	}
	
	public void setPerfilAccions(List<PerfilAccion> newPerfilAccions) {
		this.perfilaccions = newPerfilAccions;
	}
	
	

	public List<Perfil> getperfilsForeignKey() {
		return this.perfilsForeignKey;
	}

	public List<Accion> getaccionsForeignKey() {
		return this.accionsForeignKey;
	}
	
	

	public void setperfilsForeignKey(List<Perfil> perfilsForeignKey) {
		this.perfilsForeignKey=perfilsForeignKey;
	}

	public void setaccionsForeignKey(List<Accion> accionsForeignKey) {
		this.accionsForeignKey=accionsForeignKey;
	}
}

