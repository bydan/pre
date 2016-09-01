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
import com.bydan.erp.seguridad.util.GrupoOpcionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//GrupoOpcion




@SuppressWarnings("unused")
public class GrupoOpcionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GrupoOpcion grupoopcion;	
	protected List<GrupoOpcion> grupoopcions;
	
	
	public List<Modulo> modulosForeignKey;
	
	public GrupoOpcionParameterReturnGeneral () throws Exception {						
		super();
		this.grupoopcions= new ArrayList<GrupoOpcion>();
		this.grupoopcion= new GrupoOpcion();
		
		
		this.modulosForeignKey=new ArrayList<Modulo>();
	} 
	
	public GrupoOpcion getGrupoOpcion() throws Exception {	
		return grupoopcion;
	}
		
	public void setGrupoOpcion(GrupoOpcion newGrupoOpcion) {
		this.grupoopcion = newGrupoOpcion;
	}
	
	public List<GrupoOpcion> getGrupoOpcions() throws Exception {		
		return grupoopcions;
	}
	
	public void setGrupoOpcions(List<GrupoOpcion> newGrupoOpcions) {
		this.grupoopcions = newGrupoOpcions;
	}
	
	

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}
	
	

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}
}

