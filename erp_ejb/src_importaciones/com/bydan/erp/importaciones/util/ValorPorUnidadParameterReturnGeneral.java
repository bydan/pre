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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.ValorPorUnidadConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//ValorPorUnidad


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ValorPorUnidadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ValorPorUnidad valorporunidad;	
	protected List<ValorPorUnidad> valorporunidads;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public ValorPorUnidadParameterReturnGeneral () throws Exception {						
		super();
		this.valorporunidads= new ArrayList<ValorPorUnidad>();
		this.valorporunidad= new ValorPorUnidad();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public ValorPorUnidad getValorPorUnidad() throws Exception {	
		return valorporunidad;
	}
		
	public void setValorPorUnidad(ValorPorUnidad newValorPorUnidad) {
		this.valorporunidad = newValorPorUnidad;
	}
	
	public List<ValorPorUnidad> getValorPorUnidads() throws Exception {		
		return valorporunidads;
	}
	
	public void setValorPorUnidads(List<ValorPorUnidad> newValorPorUnidads) {
		this.valorporunidads = newValorPorUnidads;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

