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
import com.bydan.erp.inventario.util.ColorProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//ColorProducto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ColorProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ColorProducto colorproducto;	
	protected List<ColorProducto> colorproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoProducto> tipoproductosForeignKey;
	public List<GrupoColor> grupocolorsForeignKey;
	
	public ColorProductoParameterReturnGeneral () throws Exception {						
		super();
		this.colorproductos= new ArrayList<ColorProducto>();
		this.colorproducto= new ColorProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoproductosForeignKey=new ArrayList<TipoProducto>();
		this.grupocolorsForeignKey=new ArrayList<GrupoColor>();
	} 
	
	public ColorProducto getColorProducto() throws Exception {	
		return colorproducto;
	}
		
	public void setColorProducto(ColorProducto newColorProducto) {
		this.colorproducto = newColorProducto;
	}
	
	public List<ColorProducto> getColorProductos() throws Exception {		
		return colorproductos;
	}
	
	public void setColorProductos(List<ColorProducto> newColorProductos) {
		this.colorproductos = newColorProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoProducto> gettipoproductosForeignKey() {
		return this.tipoproductosForeignKey;
	}

	public List<GrupoColor> getgrupocolorsForeignKey() {
		return this.grupocolorsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoproductosForeignKey(List<TipoProducto> tipoproductosForeignKey) {
		this.tipoproductosForeignKey=tipoproductosForeignKey;
	}

	public void setgrupocolorsForeignKey(List<GrupoColor> grupocolorsForeignKey) {
		this.grupocolorsForeignKey=grupocolorsForeignKey;
	}
}

