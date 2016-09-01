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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.DetalleRecapConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//DetalleRecap


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleRecapParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleRecap detallerecap;	
	protected List<DetalleRecap> detallerecaps;
	
	
	public List<Recap> recapsForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<DetalleCliente> detalleclientesForeignKey;
	public List<Cliente> clientesForeignKey;
	
	public DetalleRecapParameterReturnGeneral () throws Exception {						
		super();
		this.detallerecaps= new ArrayList<DetalleRecap>();
		this.detallerecap= new DetalleRecap();
		
		
		this.recapsForeignKey=new ArrayList<Recap>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.detalleclientesForeignKey=new ArrayList<DetalleCliente>();
		this.clientesForeignKey=new ArrayList<Cliente>();
	} 
	
	public DetalleRecap getDetalleRecap() throws Exception {	
		return detallerecap;
	}
		
	public void setDetalleRecap(DetalleRecap newDetalleRecap) {
		this.detallerecap = newDetalleRecap;
	}
	
	public List<DetalleRecap> getDetalleRecaps() throws Exception {		
		return detallerecaps;
	}
	
	public void setDetalleRecaps(List<DetalleRecap> newDetalleRecaps) {
		this.detallerecaps = newDetalleRecaps;
	}
	
	

	public List<Recap> getrecapsForeignKey() {
		return this.recapsForeignKey;
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

	public List<DetalleCliente> getdetalleclientesForeignKey() {
		return this.detalleclientesForeignKey;
	}

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}
	
	

	public void setrecapsForeignKey(List<Recap> recapsForeignKey) {
		this.recapsForeignKey=recapsForeignKey;
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

	public void setdetalleclientesForeignKey(List<DetalleCliente> detalleclientesForeignKey) {
		this.detalleclientesForeignKey=detalleclientesForeignKey;
	}

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}
}

