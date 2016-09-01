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
import com.bydan.erp.inventario.util.CompoKitConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//CompoKit


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CompoKitParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CompoKit compokit;	
	protected List<CompoKit> compokits;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Kit> kitsForeignKey;
	public List<Unidad> unidadsForeignKey;
	
	public CompoKitParameterReturnGeneral () throws Exception {						
		super();
		this.compokits= new ArrayList<CompoKit>();
		this.compokit= new CompoKit();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.kitsForeignKey=new ArrayList<Kit>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
	} 
	
	public CompoKit getCompoKit() throws Exception {	
		return compokit;
	}
		
	public void setCompoKit(CompoKit newCompoKit) {
		this.compokit = newCompoKit;
	}
	
	public List<CompoKit> getCompoKits() throws Exception {		
		return compokits;
	}
	
	public void setCompoKits(List<CompoKit> newCompoKits) {
		this.compokits = newCompoKits;
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

	public List<Kit> getkitsForeignKey() {
		return this.kitsForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
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

	public void setkitsForeignKey(List<Kit> kitsForeignKey) {
		this.kitsForeignKey=kitsForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}
}

