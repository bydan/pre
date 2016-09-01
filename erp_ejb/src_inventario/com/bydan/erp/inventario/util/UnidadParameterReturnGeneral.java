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
import com.bydan.erp.inventario.util.UnidadConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Unidad


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;


@SuppressWarnings("unused")
public class UnidadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Unidad unidad;	
	protected List<Unidad> unidads;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoUnidad> tipounidadsForeignKey;
	
	public UnidadParameterReturnGeneral () throws Exception {						
		super();
		this.unidads= new ArrayList<Unidad>();
		this.unidad= new Unidad();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipounidadsForeignKey=new ArrayList<TipoUnidad>();
	} 
	
	public Unidad getUnidad() throws Exception {	
		return unidad;
	}
		
	public void setUnidad(Unidad newUnidad) {
		this.unidad = newUnidad;
	}
	
	public List<Unidad> getUnidads() throws Exception {		
		return unidads;
	}
	
	public void setUnidads(List<Unidad> newUnidads) {
		this.unidads = newUnidads;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoUnidad> gettipounidadsForeignKey() {
		return this.tipounidadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipounidadsForeignKey(List<TipoUnidad> tipounidadsForeignKey) {
		this.tipounidadsForeignKey=tipounidadsForeignKey;
	}
}

