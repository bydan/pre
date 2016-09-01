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
import com.bydan.erp.inventario.util.DetalleSerieProductoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//DetalleSerieProducto




@SuppressWarnings("unused")
public class DetalleSerieProductoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleSerieProducto detalleserieproducto;	
	protected List<DetalleSerieProducto> detalleserieproductos;
	
	
	public List<SerieProducto> serieproductosForeignKey;
	
	public DetalleSerieProductoParameterReturnGeneral () throws Exception {						
		super();
		this.detalleserieproductos= new ArrayList<DetalleSerieProducto>();
		this.detalleserieproducto= new DetalleSerieProducto();
		
		
		this.serieproductosForeignKey=new ArrayList<SerieProducto>();
	} 
	
	public DetalleSerieProducto getDetalleSerieProducto() throws Exception {	
		return detalleserieproducto;
	}
		
	public void setDetalleSerieProducto(DetalleSerieProducto newDetalleSerieProducto) {
		this.detalleserieproducto = newDetalleSerieProducto;
	}
	
	public List<DetalleSerieProducto> getDetalleSerieProductos() throws Exception {		
		return detalleserieproductos;
	}
	
	public void setDetalleSerieProductos(List<DetalleSerieProducto> newDetalleSerieProductos) {
		this.detalleserieproductos = newDetalleSerieProductos;
	}
	
	

	public List<SerieProducto> getserieproductosForeignKey() {
		return this.serieproductosForeignKey;
	}
	
	

	public void setserieproductosForeignKey(List<SerieProducto> serieproductosForeignKey) {
		this.serieproductosForeignKey=serieproductosForeignKey;
	}
}

