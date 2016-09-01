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
import com.bydan.erp.inventario.util.DescuentoTipoPrecioConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//DescuentoTipoPrecio


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DescuentoTipoPrecioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DescuentoTipoPrecio descuentotipoprecio;	
	protected List<DescuentoTipoPrecio> descuentotipoprecios;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<TipoPrecio> tipopreciosForeignKey;
	
	public DescuentoTipoPrecioParameterReturnGeneral () throws Exception {						
		super();
		this.descuentotipoprecios= new ArrayList<DescuentoTipoPrecio>();
		this.descuentotipoprecio= new DescuentoTipoPrecio();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.tipopreciosForeignKey=new ArrayList<TipoPrecio>();
	} 
	
	public DescuentoTipoPrecio getDescuentoTipoPrecio() throws Exception {	
		return descuentotipoprecio;
	}
		
	public void setDescuentoTipoPrecio(DescuentoTipoPrecio newDescuentoTipoPrecio) {
		this.descuentotipoprecio = newDescuentoTipoPrecio;
	}
	
	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios() throws Exception {		
		return descuentotipoprecios;
	}
	
	public void setDescuentoTipoPrecios(List<DescuentoTipoPrecio> newDescuentoTipoPrecios) {
		this.descuentotipoprecios = newDescuentoTipoPrecios;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<TipoPrecio> gettipopreciosForeignKey() {
		return this.tipopreciosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void settipopreciosForeignKey(List<TipoPrecio> tipopreciosForeignKey) {
		this.tipopreciosForeignKey=tipopreciosForeignKey;
	}
}

