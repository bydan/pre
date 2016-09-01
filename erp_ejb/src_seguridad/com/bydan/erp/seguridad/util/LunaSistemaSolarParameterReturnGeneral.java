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
import com.bydan.erp.seguridad.util.LunaSistemaSolarConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//LunaSistemaSolar




@SuppressWarnings("unused")
public class LunaSistemaSolarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected LunaSistemaSolar lunasistemasolar;	
	protected List<LunaSistemaSolar> lunasistemasolars;
	
	
	public List<TipoValoracion> tipovaloracionsForeignKey;
	
	public LunaSistemaSolarParameterReturnGeneral () throws Exception {						
		super();
		this.lunasistemasolars= new ArrayList<LunaSistemaSolar>();
		this.lunasistemasolar= new LunaSistemaSolar();
		
		
		this.tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
	} 
	
	public LunaSistemaSolar getLunaSistemaSolar() throws Exception {	
		return lunasistemasolar;
	}
		
	public void setLunaSistemaSolar(LunaSistemaSolar newLunaSistemaSolar) {
		this.lunasistemasolar = newLunaSistemaSolar;
	}
	
	public List<LunaSistemaSolar> getLunaSistemaSolars() throws Exception {		
		return lunasistemasolars;
	}
	
	public void setLunaSistemaSolars(List<LunaSistemaSolar> newLunaSistemaSolars) {
		this.lunasistemasolars = newLunaSistemaSolars;
	}
	
	

	public List<TipoValoracion> gettipovaloracionsForeignKey() {
		return this.tipovaloracionsForeignKey;
	}
	
	

	public void settipovaloracionsForeignKey(List<TipoValoracion> tipovaloracionsForeignKey) {
		this.tipovaloracionsForeignKey=tipovaloracionsForeignKey;
	}
}

