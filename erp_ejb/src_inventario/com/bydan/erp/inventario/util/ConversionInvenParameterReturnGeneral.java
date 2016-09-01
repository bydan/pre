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
import com.bydan.erp.inventario.util.ConversionInvenConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ConversionInven


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ConversionInvenParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ConversionInven conversioninven;	
	protected List<ConversionInven> conversioninvens;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoConversionInven> tipoconversioninvensForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<Unidad> unidadconversionsForeignKey;
	
	public ConversionInvenParameterReturnGeneral () throws Exception {						
		super();
		this.conversioninvens= new ArrayList<ConversionInven>();
		this.conversioninven= new ConversionInven();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoconversioninvensForeignKey=new ArrayList<TipoConversionInven>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.unidadconversionsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ConversionInven getConversionInven() throws Exception {	
		return conversioninven;
	}
		
	public void setConversionInven(ConversionInven newConversionInven) {
		this.conversioninven = newConversionInven;
	}
	
	public List<ConversionInven> getConversionInvens() throws Exception {		
		return conversioninvens;
	}
	
	public void setConversionInvens(List<ConversionInven> newConversionInvens) {
		this.conversioninvens = newConversionInvens;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoConversionInven> gettipoconversioninvensForeignKey() {
		return this.tipoconversioninvensForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<Unidad> getunidadconversionsForeignKey() {
		return this.unidadconversionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoconversioninvensForeignKey(List<TipoConversionInven> tipoconversioninvensForeignKey) {
		this.tipoconversioninvensForeignKey=tipoconversioninvensForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setunidadconversionsForeignKey(List<Unidad> unidadconversionsForeignKey) {
		this.unidadconversionsForeignKey=unidadconversionsForeignKey;
	}
}

