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
import com.bydan.erp.inventario.util.EstadoDetalleOrdenCompraConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//EstadoDetalleOrdenCompra




@SuppressWarnings("unused")
public class EstadoDetalleOrdenCompraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected EstadoDetalleOrdenCompra estadodetalleordencompra;	
	protected List<EstadoDetalleOrdenCompra> estadodetalleordencompras;
	
	
	
	public EstadoDetalleOrdenCompraParameterReturnGeneral () throws Exception {						
		super();
		this.estadodetalleordencompras= new ArrayList<EstadoDetalleOrdenCompra>();
		this.estadodetalleordencompra= new EstadoDetalleOrdenCompra();
		
		
	} 
	
	public EstadoDetalleOrdenCompra getEstadoDetalleOrdenCompra() throws Exception {	
		return estadodetalleordencompra;
	}
		
	public void setEstadoDetalleOrdenCompra(EstadoDetalleOrdenCompra newEstadoDetalleOrdenCompra) {
		this.estadodetalleordencompra = newEstadoDetalleOrdenCompra;
	}
	
	public List<EstadoDetalleOrdenCompra> getEstadoDetalleOrdenCompras() throws Exception {		
		return estadodetalleordencompras;
	}
	
	public void setEstadoDetalleOrdenCompras(List<EstadoDetalleOrdenCompra> newEstadoDetalleOrdenCompras) {
		this.estadodetalleordencompras = newEstadoDetalleOrdenCompras;
	}
	
	
	
	
}

