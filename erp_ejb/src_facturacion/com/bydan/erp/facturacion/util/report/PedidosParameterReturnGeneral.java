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
package com.bydan.erp.facturacion.util.report;

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
import com.bydan.erp.facturacion.util.report.PedidosConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.report.*;//Pedidos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class PedidosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Pedidos pedidos;	
	protected List<Pedidos> pedidoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<EstadoPedido> estadopedidosForeignKey;
	
	public PedidosParameterReturnGeneral () throws Exception {						
		super();
		this.pedidoss= new ArrayList<Pedidos>();
		this.pedidos= new Pedidos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.estadopedidosForeignKey=new ArrayList<EstadoPedido>();
	} 
	
	public Pedidos getPedidos() throws Exception {	
		return pedidos;
	}
		
	public void setPedidos(Pedidos newPedidos) {
		this.pedidos = newPedidos;
	}
	
	public List<Pedidos> getPedidoss() throws Exception {		
		return pedidoss;
	}
	
	public void setPedidoss(List<Pedidos> newPedidoss) {
		this.pedidoss = newPedidoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<EstadoPedido> getestadopedidosForeignKey() {
		return this.estadopedidosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setestadopedidosForeignKey(List<EstadoPedido> estadopedidosForeignKey) {
		this.estadopedidosForeignKey=estadopedidosForeignKey;
	}
}

