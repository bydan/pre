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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.ConversionUnidadConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ConversionUnidad


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ConversionUnidadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ConversionUnidad conversionunidad;	
	protected List<ConversionUnidad> conversionunidads;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Unidad> unidaddesdesForeignKey;
	public List<Unidad> unidadhastasForeignKey;
	
	public ConversionUnidadParameterReturnGeneral () throws Exception {						
		super();
		this.conversionunidads= new ArrayList<ConversionUnidad>();
		this.conversionunidad= new ConversionUnidad();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.unidaddesdesForeignKey=new ArrayList<Unidad>();
		this.unidadhastasForeignKey=new ArrayList<Unidad>();
	} 
	
	public ConversionUnidad getConversionUnidad() throws Exception {	
		return conversionunidad;
	}
		
	public void setConversionUnidad(ConversionUnidad newConversionUnidad) {
		this.conversionunidad = newConversionUnidad;
	}
	
	public List<ConversionUnidad> getConversionUnidads() throws Exception {		
		return conversionunidads;
	}
	
	public void setConversionUnidads(List<ConversionUnidad> newConversionUnidads) {
		this.conversionunidads = newConversionUnidads;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Unidad> getunidaddesdesForeignKey() {
		return this.unidaddesdesForeignKey;
	}

	public List<Unidad> getunidadhastasForeignKey() {
		return this.unidadhastasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setunidaddesdesForeignKey(List<Unidad> unidaddesdesForeignKey) {
		this.unidaddesdesForeignKey=unidaddesdesForeignKey;
	}

	public void setunidadhastasForeignKey(List<Unidad> unidadhastasForeignKey) {
		this.unidadhastasForeignKey=unidadhastasForeignKey;
	}
}

