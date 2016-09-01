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
import com.bydan.erp.seguridad.util.AccionConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Accion




@SuppressWarnings("unused")
public class AccionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Accion accion;	
	protected List<Accion> accions;
	
	
	public List<Opcion> opcionsForeignKey;
	
	public AccionParameterReturnGeneral () throws Exception {						
		super();
		this.accions= new ArrayList<Accion>();
		this.accion= new Accion();
		
		
		this.opcionsForeignKey=new ArrayList<Opcion>();
	} 
	
	public Accion getAccion() throws Exception {	
		return accion;
	}
		
	public void setAccion(Accion newAccion) {
		this.accion = newAccion;
	}
	
	public List<Accion> getAccions() throws Exception {		
		return accions;
	}
	
	public void setAccions(List<Accion> newAccions) {
		this.accions = newAccions;
	}
	
	

	public List<Opcion> getopcionsForeignKey() {
		return this.opcionsForeignKey;
	}
	
	

	public void setopcionsForeignKey(List<Opcion> opcionsForeignKey) {
		this.opcionsForeignKey=opcionsForeignKey;
	}
}

