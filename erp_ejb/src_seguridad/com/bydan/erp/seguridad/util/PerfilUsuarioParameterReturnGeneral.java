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
import com.bydan.erp.seguridad.util.PerfilUsuarioConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//PerfilUsuario




@SuppressWarnings("unused")
public class PerfilUsuarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PerfilUsuario perfilusuario;	
	protected List<PerfilUsuario> perfilusuarios;
	
	
	public List<Perfil> perfilsForeignKey;
	public List<Usuario> usuariosForeignKey;
	
	public PerfilUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.perfilusuarios= new ArrayList<PerfilUsuario>();
		this.perfilusuario= new PerfilUsuario();
		
		
		this.perfilsForeignKey=new ArrayList<Perfil>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
	} 
	
	public PerfilUsuario getPerfilUsuario() throws Exception {	
		return perfilusuario;
	}
		
	public void setPerfilUsuario(PerfilUsuario newPerfilUsuario) {
		this.perfilusuario = newPerfilUsuario;
	}
	
	public List<PerfilUsuario> getPerfilUsuarios() throws Exception {		
		return perfilusuarios;
	}
	
	public void setPerfilUsuarios(List<PerfilUsuario> newPerfilUsuarios) {
		this.perfilusuarios = newPerfilUsuarios;
	}
	
	

	public List<Perfil> getperfilsForeignKey() {
		return this.perfilsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}
	
	

	public void setperfilsForeignKey(List<Perfil> perfilsForeignKey) {
		this.perfilsForeignKey=perfilsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}
}

