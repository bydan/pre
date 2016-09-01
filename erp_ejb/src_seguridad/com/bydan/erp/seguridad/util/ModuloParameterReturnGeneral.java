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
import com.bydan.erp.seguridad.util.ModuloConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Modulo




@SuppressWarnings("unused")
public class ModuloParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Modulo modulo;	
	protected List<Modulo> modulos;
	
	
	public List<Sistema> sistemasForeignKey;
	public List<Paquete> paquetesForeignKey;
	public List<TipoTeclaMascara> tipoteclamascarasForeignKey;
	
	public ModuloParameterReturnGeneral () throws Exception {						
		super();
		this.modulos= new ArrayList<Modulo>();
		this.modulo= new Modulo();
		
		
		this.sistemasForeignKey=new ArrayList<Sistema>();
		this.paquetesForeignKey=new ArrayList<Paquete>();
		this.tipoteclamascarasForeignKey=new ArrayList<TipoTeclaMascara>();
	} 
	
	public Modulo getModulo() throws Exception {	
		return modulo;
	}
		
	public void setModulo(Modulo newModulo) {
		this.modulo = newModulo;
	}
	
	public List<Modulo> getModulos() throws Exception {		
		return modulos;
	}
	
	public void setModulos(List<Modulo> newModulos) {
		this.modulos = newModulos;
	}
	
	

	public List<Sistema> getsistemasForeignKey() {
		return this.sistemasForeignKey;
	}

	public List<Paquete> getpaquetesForeignKey() {
		return this.paquetesForeignKey;
	}

	public List<TipoTeclaMascara> gettipoteclamascarasForeignKey() {
		return this.tipoteclamascarasForeignKey;
	}
	
	

	public void setsistemasForeignKey(List<Sistema> sistemasForeignKey) {
		this.sistemasForeignKey=sistemasForeignKey;
	}

	public void setpaquetesForeignKey(List<Paquete> paquetesForeignKey) {
		this.paquetesForeignKey=paquetesForeignKey;
	}

	public void settipoteclamascarasForeignKey(List<TipoTeclaMascara> tipoteclamascarasForeignKey) {
		this.tipoteclamascarasForeignKey=tipoteclamascarasForeignKey;
	}
}

