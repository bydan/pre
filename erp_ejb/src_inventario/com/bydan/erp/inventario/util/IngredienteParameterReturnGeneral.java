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
import com.bydan.erp.inventario.util.IngredienteConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Ingrediente


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class IngredienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Ingrediente ingrediente;	
	protected List<Ingrediente> ingredientes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Bodega> bodegarelacionsForeignKey;
	public List<Producto> productosForeignKey;
	public List<Producto> productorelacionsForeignKey;
	
	public IngredienteParameterReturnGeneral () throws Exception {						
		super();
		this.ingredientes= new ArrayList<Ingrediente>();
		this.ingrediente= new Ingrediente();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.bodegarelacionsForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.productorelacionsForeignKey=new ArrayList<Producto>();
	} 
	
	public Ingrediente getIngrediente() throws Exception {	
		return ingrediente;
	}
		
	public void setIngrediente(Ingrediente newIngrediente) {
		this.ingrediente = newIngrediente;
	}
	
	public List<Ingrediente> getIngredientes() throws Exception {		
		return ingredientes;
	}
	
	public void setIngredientes(List<Ingrediente> newIngredientes) {
		this.ingredientes = newIngredientes;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Bodega> getbodegarelacionsForeignKey() {
		return this.bodegarelacionsForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Producto> getproductorelacionsForeignKey() {
		return this.productorelacionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setbodegarelacionsForeignKey(List<Bodega> bodegarelacionsForeignKey) {
		this.bodegarelacionsForeignKey=bodegarelacionsForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setproductorelacionsForeignKey(List<Producto> productorelacionsForeignKey) {
		this.productorelacionsForeignKey=productorelacionsForeignKey;
	}
}

