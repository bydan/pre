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
import com.bydan.erp.seguridad.util.ProvinciaConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Provincia


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class ProvinciaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Provincia provincia;	
	protected List<Provincia> provincias;
	
	
	public List<Pais> paissForeignKey;
	public List<Region> regionsForeignKey;
	
	public ProvinciaParameterReturnGeneral () throws Exception {						
		super();
		this.provincias= new ArrayList<Provincia>();
		this.provincia= new Provincia();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
		this.regionsForeignKey=new ArrayList<Region>();
	} 
	
	public Provincia getProvincia() throws Exception {	
		return provincia;
	}
		
	public void setProvincia(Provincia newProvincia) {
		this.provincia = newProvincia;
	}
	
	public List<Provincia> getProvincias() throws Exception {		
		return provincias;
	}
	
	public void setProvincias(List<Provincia> newProvincias) {
		this.provincias = newProvincias;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Region> getregionsForeignKey() {
		return this.regionsForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setregionsForeignKey(List<Region> regionsForeignKey) {
		this.regionsForeignKey=regionsForeignKey;
	}
}

