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
package com.bydan.erp.inventario.util.report;

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
import com.bydan.erp.inventario.util.report.ProductosServiciosPreciosSinRangosConstantesFunciones;

import com.bydan.erp.inventario.business.entity.report.*;//ProductosServiciosPreciosSinRangos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class ProductosServiciosPreciosSinRangosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProductosServiciosPreciosSinRangos productosserviciospreciossinrangos;	
	protected List<ProductosServiciosPreciosSinRangos> productosserviciospreciossinrangoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	public List<Linea> lineacategoriasForeignKey;
	public List<Linea> lineamarcasForeignKey;
	
	public ProductosServiciosPreciosSinRangosParameterReturnGeneral () throws Exception {						
		super();
		this.productosserviciospreciossinrangoss= new ArrayList<ProductosServiciosPreciosSinRangos>();
		this.productosserviciospreciossinrangos= new ProductosServiciosPreciosSinRangos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
		this.lineacategoriasForeignKey=new ArrayList<Linea>();
		this.lineamarcasForeignKey=new ArrayList<Linea>();
	} 
	
	public ProductosServiciosPreciosSinRangos getProductosServiciosPreciosSinRangos() throws Exception {	
		return productosserviciospreciossinrangos;
	}
		
	public void setProductosServiciosPreciosSinRangos(ProductosServiciosPreciosSinRangos newProductosServiciosPreciosSinRangos) {
		this.productosserviciospreciossinrangos = newProductosServiciosPreciosSinRangos;
	}
	
	public List<ProductosServiciosPreciosSinRangos> getProductosServiciosPreciosSinRangoss() throws Exception {		
		return productosserviciospreciossinrangoss;
	}
	
	public void setProductosServiciosPreciosSinRangoss(List<ProductosServiciosPreciosSinRangos> newProductosServiciosPreciosSinRangoss) {
		this.productosserviciospreciossinrangoss = newProductosServiciosPreciosSinRangoss;
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

