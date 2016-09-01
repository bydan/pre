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
import com.bydan.erp.seguridad.util.UsuarioOpcionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//UsuarioOpcion




@SuppressWarnings("unused")
public class UsuarioOpcionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected UsuarioOpcion usuarioopcion;	
	protected List<UsuarioOpcion> usuarioopcions;
	
	
	public List<Sistema> sistemasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<GrupoOpcion> grupoopcionsForeignKey;
	public List<Opcion> opcionsForeignKey;
	public List<Perfil> perfilsForeignKey;
	public List<Usuario> usuariosForeignKey;
	
	public UsuarioOpcionParameterReturnGeneral () throws Exception {						
		super();
		this.usuarioopcions= new ArrayList<UsuarioOpcion>();
		this.usuarioopcion= new UsuarioOpcion();
		
		
		this.sistemasForeignKey=new ArrayList<Sistema>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
		this.opcionsForeignKey=new ArrayList<Opcion>();
		this.perfilsForeignKey=new ArrayList<Perfil>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
	} 
	
	public UsuarioOpcion getUsuarioOpcion() throws Exception {	
		return usuarioopcion;
	}
		
	public void setUsuarioOpcion(UsuarioOpcion newUsuarioOpcion) {
		this.usuarioopcion = newUsuarioOpcion;
	}
	
	public List<UsuarioOpcion> getUsuarioOpcions() throws Exception {		
		return usuarioopcions;
	}
	
	public void setUsuarioOpcions(List<UsuarioOpcion> newUsuarioOpcions) {
		this.usuarioopcions = newUsuarioOpcions;
	}
	
	

	public List<Sistema> getsistemasForeignKey() {
		return this.sistemasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<GrupoOpcion> getgrupoopcionsForeignKey() {
		return this.grupoopcionsForeignKey;
	}

	public List<Opcion> getopcionsForeignKey() {
		return this.opcionsForeignKey;
	}

	public List<Perfil> getperfilsForeignKey() {
		return this.perfilsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}
	
	

	public void setsistemasForeignKey(List<Sistema> sistemasForeignKey) {
		this.sistemasForeignKey=sistemasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void setgrupoopcionsForeignKey(List<GrupoOpcion> grupoopcionsForeignKey) {
		this.grupoopcionsForeignKey=grupoopcionsForeignKey;
	}

	public void setopcionsForeignKey(List<Opcion> opcionsForeignKey) {
		this.opcionsForeignKey=opcionsForeignKey;
	}

	public void setperfilsForeignKey(List<Perfil> perfilsForeignKey) {
		this.perfilsForeignKey=perfilsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}
}

