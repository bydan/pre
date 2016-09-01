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
package com.bydan.erp.produccion.util;

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
import com.bydan.erp.produccion.util.PedidoProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//PedidoProdu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class PedidoProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PedidoProdu pedidoprodu;	
	protected List<PedidoProdu> pedidoprodus;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey;
	public List<Empleado> empleadoresponsablesForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<EstadoOrdenProdu> estadoordenprodusForeignKey;
	
	public PedidoProduParameterReturnGeneral () throws Exception {						
		super();
		this.pedidoprodus= new ArrayList<PedidoProdu>();
		this.pedidoprodu= new PedidoProdu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.tipoprioridadempresaprodusForeignKey=new ArrayList<TipoPrioridadEmpresaProdu>();
		this.empleadoresponsablesForeignKey=new ArrayList<Empleado>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.estadoordenprodusForeignKey=new ArrayList<EstadoOrdenProdu>();
	} 
	
	public PedidoProdu getPedidoProdu() throws Exception {	
		return pedidoprodu;
	}
		
	public void setPedidoProdu(PedidoProdu newPedidoProdu) {
		this.pedidoprodu = newPedidoProdu;
	}
	
	public List<PedidoProdu> getPedidoProdus() throws Exception {		
		return pedidoprodus;
	}
	
	public void setPedidoProdus(List<PedidoProdu> newPedidoProdus) {
		this.pedidoprodus = newPedidoProdus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Ejercicio> getejerciciosForeignKey() {
		return this.ejerciciosForeignKey;
	}

	public List<Periodo> getperiodosForeignKey() {
		return this.periodosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<TipoPrioridadEmpresaProdu> gettipoprioridadempresaprodusForeignKey() {
		return this.tipoprioridadempresaprodusForeignKey;
	}

	public List<Empleado> getempleadoresponsablesForeignKey() {
		return this.empleadoresponsablesForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<EstadoOrdenProdu> getestadoordenprodusForeignKey() {
		return this.estadoordenprodusForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setejerciciosForeignKey(List<Ejercicio> ejerciciosForeignKey) {
		this.ejerciciosForeignKey=ejerciciosForeignKey;
	}

	public void setperiodosForeignKey(List<Periodo> periodosForeignKey) {
		this.periodosForeignKey=periodosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void settipoprioridadempresaprodusForeignKey(List<TipoPrioridadEmpresaProdu> tipoprioridadempresaprodusForeignKey) {
		this.tipoprioridadempresaprodusForeignKey=tipoprioridadempresaprodusForeignKey;
	}

	public void setempleadoresponsablesForeignKey(List<Empleado> empleadoresponsablesForeignKey) {
		this.empleadoresponsablesForeignKey=empleadoresponsablesForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setestadoordenprodusForeignKey(List<EstadoOrdenProdu> estadoordenprodusForeignKey) {
		this.estadoordenprodusForeignKey=estadoordenprodusForeignKey;
	}
}

