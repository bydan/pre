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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.IdiomaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Idioma




@SuppressWarnings("unused")
public class IdiomaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Idioma idioma;	
	protected List<Idioma> idiomas;
	
	
	
	public IdiomaParameterReturnGeneral () throws Exception {						
		super();
		this.idiomas= new ArrayList<Idioma>();
		this.idioma= new Idioma();
		
		
	} 
	
	public Idioma getIdioma() throws Exception {	
		return idioma;
	}
		
	public void setIdioma(Idioma newIdioma) {
		this.idioma = newIdioma;
	}
	
	public List<Idioma> getIdiomas() throws Exception {		
		return idiomas;
	}
	
	public void setIdiomas(List<Idioma> newIdiomas) {
		this.idiomas = newIdiomas;
	}
	
	
	
	
}

