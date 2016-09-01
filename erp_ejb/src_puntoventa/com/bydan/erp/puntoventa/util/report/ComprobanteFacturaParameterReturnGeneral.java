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
package com.bydan.erp.puntoventa.util.report;

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
import com.bydan.erp.puntoventa.util.report.ComprobanteFacturaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.report.*;//ComprobanteFactura


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class ComprobanteFacturaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ComprobanteFactura comprobantefactura;	
	protected List<ComprobanteFactura> comprobantefacturas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Caja> cajasForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public ComprobanteFacturaParameterReturnGeneral () throws Exception {						
		super();
		this.comprobantefacturas= new ArrayList<ComprobanteFactura>();
		this.comprobantefactura= new ComprobanteFactura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public ComprobanteFactura getComprobanteFactura() throws Exception {	
		return comprobantefactura;
	}
		
	public void setComprobanteFactura(ComprobanteFactura newComprobanteFactura) {
		this.comprobantefactura = newComprobanteFactura;
	}
	
	public List<ComprobanteFactura> getComprobanteFacturas() throws Exception {		
		return comprobantefacturas;
	}
	
	public void setComprobanteFacturas(List<ComprobanteFactura> newComprobanteFacturas) {
		this.comprobantefacturas = newComprobanteFacturas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

