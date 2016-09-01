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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.CajaIngresoDetalleConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//CajaIngresoDetalle


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class CajaIngresoDetalleParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CajaIngresoDetalle cajaingresodetalle;	
	protected List<CajaIngresoDetalle> cajaingresodetalles;
	
	
	public List<CajaIngreso> cajaingresosForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Factura> facturasForeignKey;
	
	public CajaIngresoDetalleParameterReturnGeneral () throws Exception {						
		super();
		this.cajaingresodetalles= new ArrayList<CajaIngresoDetalle>();
		this.cajaingresodetalle= new CajaIngresoDetalle();
		
		
		this.cajaingresosForeignKey=new ArrayList<CajaIngreso>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.facturasForeignKey=new ArrayList<Factura>();
	} 
	
	public CajaIngresoDetalle getCajaIngresoDetalle() throws Exception {	
		return cajaingresodetalle;
	}
		
	public void setCajaIngresoDetalle(CajaIngresoDetalle newCajaIngresoDetalle) {
		this.cajaingresodetalle = newCajaIngresoDetalle;
	}
	
	public List<CajaIngresoDetalle> getCajaIngresoDetalles() throws Exception {		
		return cajaingresodetalles;
	}
	
	public void setCajaIngresoDetalles(List<CajaIngresoDetalle> newCajaIngresoDetalles) {
		this.cajaingresodetalles = newCajaIngresoDetalles;
	}
	
	

	public List<CajaIngreso> getcajaingresosForeignKey() {
		return this.cajaingresosForeignKey;
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
	
	

	public void setcajaingresosForeignKey(List<CajaIngreso> cajaingresosForeignKey) {
		this.cajaingresosForeignKey=cajaingresosForeignKey;
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

