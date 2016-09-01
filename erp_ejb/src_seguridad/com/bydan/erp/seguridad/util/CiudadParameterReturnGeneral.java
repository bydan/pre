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
import com.bydan.erp.seguridad.util.CiudadConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Ciudad




@SuppressWarnings("unused")
public class CiudadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Ciudad ciudad;	
	protected List<Ciudad> ciudads;
	
	
	public List<Pais> paissForeignKey;
	public List<Provincia> provinciasForeignKey;
	
	public CiudadParameterReturnGeneral () throws Exception {						
		super();
		this.ciudads= new ArrayList<Ciudad>();
		this.ciudad= new Ciudad();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
	} 
	
	public Ciudad getCiudad() throws Exception {	
		return ciudad;
	}
		
	public void setCiudad(Ciudad newCiudad) {
		this.ciudad = newCiudad;
	}
	
	public List<Ciudad> getCiudads() throws Exception {		
		return ciudads;
	}
	
	public void setCiudads(List<Ciudad> newCiudads) {
		this.ciudads = newCiudads;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}
}

