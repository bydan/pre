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
import com.bydan.erp.inventario.util.DetalleCodigoBarraProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//DetalleCodigoBarraProducto


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleCodigoBarraProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleCodigoBarraProducto detallecodigobarraproducto;	
	protected List<DetalleCodigoBarraProducto> detallecodigobarraproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<Linea> lineamarcasForeignKey;
	
	public DetalleCodigoBarraProductoParameterReturnGeneral () throws Exception {						
		super();
		this.detallecodigobarraproductos= new ArrayList<DetalleCodigoBarraProducto>();
		this.detallecodigobarraproducto= new DetalleCodigoBarraProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.lineamarcasForeignKey=new ArrayList<Linea>();
	} 
	
	public DetalleCodigoBarraProducto getDetalleCodigoBarraProducto() throws Exception {	
		return detallecodigobarraproducto;
	}
		
	public void setDetalleCodigoBarraProducto(DetalleCodigoBarraProducto newDetalleCodigoBarraProducto) {
		this.detallecodigobarraproducto = newDetalleCodigoBarraProducto;
	}
	
	public List<DetalleCodigoBarraProducto> getDetalleCodigoBarraProductos() throws Exception {		
		return detallecodigobarraproductos;
	}
	
	public void setDetalleCodigoBarraProductos(List<DetalleCodigoBarraProducto> newDetalleCodigoBarraProductos) {
		this.detallecodigobarraproductos = newDetalleCodigoBarraProductos;
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

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}

	public List<Linea> getlineacategoriasForeignKey() {
		return this.lineacategoriasForeignKey;
	}

	public List<Linea> getlineamarcasForeignKey() {
		return this.lineamarcasForeignKey;
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

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}

	public void setlineacategoriasForeignKey(List<Linea> lineacategoriasForeignKey) {
		this.lineacategoriasForeignKey=lineacategoriasForeignKey;
	}

	public void setlineamarcasForeignKey(List<Linea> lineamarcasForeignKey) {
		this.lineamarcasForeignKey=lineamarcasForeignKey;
	}
}

