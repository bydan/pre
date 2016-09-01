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
import com.bydan.erp.seguridad.util.ResumenUsuarioConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//ResumenUsuario




@SuppressWarnings("unused")
public class ResumenUsuarioParameterReturnGeneral extends ResumenUsuarioReturnGeneralAdditional implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ResumenUsuario resumenusuario;	
	protected List<ResumenUsuario> resumenusuarios;
	
	
	public List<Usuario> usuariosForeignKey;
	
	public ResumenUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.resumenusuarios= new ArrayList<ResumenUsuario>();
		this.resumenusuario= new ResumenUsuario();
		
		
		this.usuariosForeignKey=new ArrayList<Usuario>();
	} 
	
	public ResumenUsuario getResumenUsuario() throws Exception {	
		return resumenusuario;
	}
		
	public void setResumenUsuario(ResumenUsuario newResumenUsuario) {
		this.resumenusuario = newResumenUsuario;
	}
	
	public List<ResumenUsuario> getResumenUsuarios() throws Exception {		
		return resumenusuarios;
	}
	
	public void setResumenUsuarios(List<ResumenUsuario> newResumenUsuarios) {
		this.resumenusuarios = newResumenUsuarios;
	}
	
	

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}
	
	

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}
}

