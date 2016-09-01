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
import com.bydan.erp.seguridad.util.PerfilOpcionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//PerfilOpcion




@SuppressWarnings("unused")
public class PerfilOpcionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PerfilOpcion perfilopcion;	
	protected List<PerfilOpcion> perfilopcions;
	
	
	public List<Sistema> sistemasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<GrupoOpcion> grupoopcionsForeignKey;
	public List<Perfil> perfilsForeignKey;
	public List<Opcion> opcionsForeignKey;
	
	public PerfilOpcionParameterReturnGeneral () throws Exception {						
		super();
		this.perfilopcions= new ArrayList<PerfilOpcion>();
		this.perfilopcion= new PerfilOpcion();
		
		
		this.sistemasForeignKey=new ArrayList<Sistema>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
		this.perfilsForeignKey=new ArrayList<Perfil>();
		this.opcionsForeignKey=new ArrayList<Opcion>();
	} 
	
	public PerfilOpcion getPerfilOpcion() throws Exception {	
		return perfilopcion;
	}
		
	public void setPerfilOpcion(PerfilOpcion newPerfilOpcion) {
		this.perfilopcion = newPerfilOpcion;
	}
	
	public List<PerfilOpcion> getPerfilOpcions() throws Exception {		
		return perfilopcions;
	}
	
	public void setPerfilOpcions(List<PerfilOpcion> newPerfilOpcions) {
		this.perfilopcions = newPerfilOpcions;
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

	public List<Perfil> getperfilsForeignKey() {
		return this.perfilsForeignKey;
	}

	public List<Opcion> getopcionsForeignKey() {
		return this.opcionsForeignKey;
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

	public void setperfilsForeignKey(List<Perfil> perfilsForeignKey) {
		this.perfilsForeignKey=perfilsForeignKey;
	}

	public void setopcionsForeignKey(List<Opcion> opcionsForeignKey) {
		this.opcionsForeignKey=opcionsForeignKey;
	}
}

