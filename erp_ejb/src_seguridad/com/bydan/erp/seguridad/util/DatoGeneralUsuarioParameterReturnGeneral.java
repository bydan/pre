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
import com.bydan.erp.seguridad.util.DatoGeneralUsuarioConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//DatoGeneralUsuario




@SuppressWarnings("unused")
public class DatoGeneralUsuarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DatoGeneralUsuario datogeneralusuario;	
	protected List<DatoGeneralUsuario> datogeneralusuarios;
	
	
	public List<Usuario> usuariosForeignKey;
	public List<Pais> paissForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public DatoGeneralUsuarioParameterReturnGeneral () throws Exception {						
		super();
		this.datogeneralusuarios= new ArrayList<DatoGeneralUsuario>();
		this.datogeneralusuario= new DatoGeneralUsuario();
		
		
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public DatoGeneralUsuario getDatoGeneralUsuario() throws Exception {	
		return datogeneralusuario;
	}
		
	public void setDatoGeneralUsuario(DatoGeneralUsuario newDatoGeneralUsuario) {
		this.datogeneralusuario = newDatoGeneralUsuario;
	}
	
	public List<DatoGeneralUsuario> getDatoGeneralUsuarios() throws Exception {		
		return datogeneralusuarios;
	}
	
	public void setDatoGeneralUsuarios(List<DatoGeneralUsuario> newDatoGeneralUsuarios) {
		this.datogeneralusuarios = newDatoGeneralUsuarios;
	}
	
	

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}
	
	

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

