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
import com.bydan.erp.inventario.util.TallaProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//TallaProducto


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class TallaProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TallaProducto tallaproducto;	
	protected List<TallaProducto> tallaproductos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoProducto> tipoproductosForeignKey;
	
	public TallaProductoParameterReturnGeneral () throws Exception {						
		super();
		this.tallaproductos= new ArrayList<TallaProducto>();
		this.tallaproducto= new TallaProducto();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipoproductosForeignKey=new ArrayList<TipoProducto>();
	} 
	
	public TallaProducto getTallaProducto() throws Exception {	
		return tallaproducto;
	}
		
	public void setTallaProducto(TallaProducto newTallaProducto) {
		this.tallaproducto = newTallaProducto;
	}
	
	public List<TallaProducto> getTallaProductos() throws Exception {		
		return tallaproductos;
	}
	
	public void setTallaProductos(List<TallaProducto> newTallaProductos) {
		this.tallaproductos = newTallaProductos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoProducto> gettipoproductosForeignKey() {
		return this.tipoproductosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipoproductosForeignKey(List<TipoProducto> tipoproductosForeignKey) {
		this.tipoproductosForeignKey=tipoproductosForeignKey;
	}
}

