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
import com.bydan.erp.seguridad.util.PlanetaSistemaSolarConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//PlanetaSistemaSolar




@SuppressWarnings("unused")
public class PlanetaSistemaSolarParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PlanetaSistemaSolar planetasistemasolar;	
	protected List<PlanetaSistemaSolar> planetasistemasolars;
	
	
	public List<TipoValoracion> tipovaloracionsForeignKey;
	
	public PlanetaSistemaSolarParameterReturnGeneral () throws Exception {						
		super();
		this.planetasistemasolars= new ArrayList<PlanetaSistemaSolar>();
		this.planetasistemasolar= new PlanetaSistemaSolar();
		
		
		this.tipovaloracionsForeignKey=new ArrayList<TipoValoracion>();
	} 
	
	public PlanetaSistemaSolar getPlanetaSistemaSolar() throws Exception {	
		return planetasistemasolar;
	}
		
	public void setPlanetaSistemaSolar(PlanetaSistemaSolar newPlanetaSistemaSolar) {
		this.planetasistemasolar = newPlanetaSistemaSolar;
	}
	
	public List<PlanetaSistemaSolar> getPlanetaSistemaSolars() throws Exception {		
		return planetasistemasolars;
	}
	
	public void setPlanetaSistemaSolars(List<PlanetaSistemaSolar> newPlanetaSistemaSolars) {
		this.planetasistemasolars = newPlanetaSistemaSolars;
	}
	
	

	public List<TipoValoracion> gettipovaloracionsForeignKey() {
		return this.tipovaloracionsForeignKey;
	}
	
	

	public void settipovaloracionsForeignKey(List<TipoValoracion> tipovaloracionsForeignKey) {
		this.tipovaloracionsForeignKey=tipovaloracionsForeignKey;
	}
}

