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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.DireccionConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Direccion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DireccionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Direccion direccion;	
	protected List<Direccion> direccions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<TipoDireccion> tipodireccionsForeignKey;
	public List<TipoVivienda> tipoviviendasForeignKey;
	
	public DireccionParameterReturnGeneral () throws Exception {						
		super();
		this.direccions= new ArrayList<Direccion>();
		this.direccion= new Direccion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.tipodireccionsForeignKey=new ArrayList<TipoDireccion>();
		this.tipoviviendasForeignKey=new ArrayList<TipoVivienda>();
	} 
	
	public Direccion getDireccion() throws Exception {	
		return direccion;
	}
		
	public void setDireccion(Direccion newDireccion) {
		this.direccion = newDireccion;
	}
	
	public List<Direccion> getDireccions() throws Exception {		
		return direccions;
	}
	
	public void setDireccions(List<Direccion> newDireccions) {
		this.direccions = newDireccions;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<TipoDireccion> gettipodireccionsForeignKey() {
		return this.tipodireccionsForeignKey;
	}

	public List<TipoVivienda> gettipoviviendasForeignKey() {
		return this.tipoviviendasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void settipodireccionsForeignKey(List<TipoDireccion> tipodireccionsForeignKey) {
		this.tipodireccionsForeignKey=tipodireccionsForeignKey;
	}

	public void settipoviviendasForeignKey(List<TipoVivienda> tipoviviendasForeignKey) {
		this.tipoviviendasForeignKey=tipoviviendasForeignKey;
	}
}

