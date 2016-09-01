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
import com.bydan.erp.seguridad.util.OpcionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Opcion




@SuppressWarnings("unused")
public class OpcionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Opcion opcion;	
	protected List<Opcion> opcions;
	
	
	public List<Sistema> sistemasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<GrupoOpcion> grupoopcionsForeignKey;
	public List<Opcion> opcionsForeignKey;
	public List<TipoTeclaMascara> tipoteclamascarasForeignKey;
	
	public OpcionParameterReturnGeneral () throws Exception {						
		super();
		this.opcions= new ArrayList<Opcion>();
		this.opcion= new Opcion();
		
		
		this.sistemasForeignKey=new ArrayList<Sistema>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
		this.opcionsForeignKey=new ArrayList<Opcion>();
		this.tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
	} 
	
	public Opcion getOpcion() throws Exception {	
		return opcion;
	}
		
	public void setOpcion(Opcion newOpcion) {
		this.opcion = newOpcion;
	}
	
	public List<Opcion> getOpcions() throws Exception {		
		return opcions;
	}
	
	public void setOpcions(List<Opcion> newOpcions) {
		this.opcions = newOpcions;
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

	public List<TipoTeclaMascara> gettipoteclamascarasForeignKey() {
		return this.tipoteclamascarasForeignKey;
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

	public void settipoteclamascarasForeignKey(List<TipoTeclaMascara> tipoteclamascarasForeignKey) {
		this.tipoteclamascarasForeignKey=tipoteclamascarasForeignKey;
	}
}

