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
import com.bydan.erp.inventario.util.DetalleAutoriConsepConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//DetalleAutoriConsep


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleAutoriConsepParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleAutoriConsep detalleautoriconsep;	
	protected List<DetalleAutoriConsep> detalleautoriconseps;
	
	
	public List<AutoriConsep> autoriconsepsForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Producto> productosForeignKey;
	public List<Unidad> unidadsForeignKey;
	public List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsForeignKey;
	
	public DetalleAutoriConsepParameterReturnGeneral () throws Exception {						
		super();
		this.detalleautoriconseps= new ArrayList<DetalleAutoriConsep>();
		this.detalleautoriconsep= new DetalleAutoriConsep();
		
		
		this.autoriconsepsForeignKey=new ArrayList<AutoriConsep>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.productosForeignKey=new ArrayList<Producto>();
		this.unidadsForeignKey=new ArrayList<Unidad>();
		this.estadodetalleautoriconsepsForeignKey=new ArrayList<EstadoDetalleAutoriConsep>();
	} 
	
	public DetalleAutoriConsep getDetalleAutoriConsep() throws Exception {	
		return detalleautoriconsep;
	}
		
	public void setDetalleAutoriConsep(DetalleAutoriConsep newDetalleAutoriConsep) {
		this.detalleautoriconsep = newDetalleAutoriConsep;
	}
	
	public List<DetalleAutoriConsep> getDetalleAutoriConseps() throws Exception {		
		return detalleautoriconseps;
	}
	
	public void setDetalleAutoriConseps(List<DetalleAutoriConsep> newDetalleAutoriConseps) {
		this.detalleautoriconseps = newDetalleAutoriConseps;
	}
	
	

	public List<AutoriConsep> getautoriconsepsForeignKey() {
		return this.autoriconsepsForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Producto> getproductosForeignKey() {
		return this.productosForeignKey;
	}

	public List<Unidad> getunidadsForeignKey() {
		return this.unidadsForeignKey;
	}

	public List<EstadoDetalleAutoriConsep> getestadodetalleautoriconsepsForeignKey() {
		return this.estadodetalleautoriconsepsForeignKey;
	}
	
	

	public void setautoriconsepsForeignKey(List<AutoriConsep> autoriconsepsForeignKey) {
		this.autoriconsepsForeignKey=autoriconsepsForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setproductosForeignKey(List<Producto> productosForeignKey) {
		this.productosForeignKey=productosForeignKey;
	}

	public void setunidadsForeignKey(List<Unidad> unidadsForeignKey) {
		this.unidadsForeignKey=unidadsForeignKey;
	}

	public void setestadodetalleautoriconsepsForeignKey(List<EstadoDetalleAutoriConsep> estadodetalleautoriconsepsForeignKey) {
		this.estadodetalleautoriconsepsForeignKey=estadodetalleautoriconsepsForeignKey;
	}
}

