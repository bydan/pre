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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.CentroCostoGrupoProductoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//CentroCostoGrupoProducto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class CentroCostoGrupoProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CentroCostoGrupoProducto centrocostogrupoproducto;	
	protected List<CentroCostoGrupoProducto> centrocostogrupoproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<Linea> lineasForeignKey;
	public List<Linea> lineagruposForeignKey;
	
	public CentroCostoGrupoProductoParameterReturnGeneral () throws Exception {						
		super();
		this.centrocostogrupoproductos= new ArrayList<CentroCostoGrupoProducto>();
		this.centrocostogrupoproducto= new CentroCostoGrupoProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.lineasForeignKey=new ArrayList<Linea>();
		this.lineagruposForeignKey=new ArrayList<Linea>();
	} 
	
	public CentroCostoGrupoProducto getCentroCostoGrupoProducto() throws Exception {	
		return centrocostogrupoproducto;
	}
		
	public void setCentroCostoGrupoProducto(CentroCostoGrupoProducto newCentroCostoGrupoProducto) {
		this.centrocostogrupoproducto = newCentroCostoGrupoProducto;
	}
	
	public List<CentroCostoGrupoProducto> getCentroCostoGrupoProductos() throws Exception {		
		return centrocostogrupoproductos;
	}
	
	public void setCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> newCentroCostoGrupoProductos) {
		this.centrocostogrupoproductos = newCentroCostoGrupoProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}

	public List<Linea> getlineagruposForeignKey() {
		return this.lineagruposForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}

	public void setlineagruposForeignKey(List<Linea> lineagruposForeignKey) {
		this.lineagruposForeignKey=lineagruposForeignKey;
	}
}

