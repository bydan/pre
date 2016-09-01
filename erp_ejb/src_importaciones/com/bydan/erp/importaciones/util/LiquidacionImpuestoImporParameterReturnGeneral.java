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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.LiquidacionImpuestoImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//LiquidacionImpuestoImpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class LiquidacionImpuestoImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected LiquidacionImpuestoImpor liquidacionimpuestoimpor;	
	protected List<LiquidacionImpuestoImpor> liquidacionimpuestoimpors;
	
	
	public List<PedidoCompraImpor> pedidocompraimporsForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Factura> facturasForeignKey;
	
	public LiquidacionImpuestoImporParameterReturnGeneral () throws Exception {						
		super();
		this.liquidacionimpuestoimpors= new ArrayList<LiquidacionImpuestoImpor>();
		this.liquidacionimpuestoimpor= new LiquidacionImpuestoImpor();
		
		
		this.pedidocompraimporsForeignKey=new ArrayList<PedidoCompraImpor>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
	} 
	
	public LiquidacionImpuestoImpor getLiquidacionImpuestoImpor() throws Exception {	
		return liquidacionimpuestoimpor;
	}
		
	public void setLiquidacionImpuestoImpor(LiquidacionImpuestoImpor newLiquidacionImpuestoImpor) {
		this.liquidacionimpuestoimpor = newLiquidacionImpuestoImpor;
	}
	
	public List<LiquidacionImpuestoImpor> getLiquidacionImpuestoImpors() throws Exception {		
		return liquidacionimpuestoimpors;
	}
	
	public void setLiquidacionImpuestoImpors(List<LiquidacionImpuestoImpor> newLiquidacionImpuestoImpors) {
		this.liquidacionimpuestoimpors = newLiquidacionImpuestoImpors;
	}
	
	

	public List<PedidoCompraImpor> getpedidocompraimporsForeignKey() {
		return this.pedidocompraimporsForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}
	
	

	public void setpedidocompraimporsForeignKey(List<PedidoCompraImpor> pedidocompraimporsForeignKey) {
		this.pedidocompraimporsForeignKey=pedidocompraimporsForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}
}

