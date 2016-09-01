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
import com.bydan.erp.cartera.util.ServicioTransporteConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//ServicioTransporte


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class ServicioTransporteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ServicioTransporte serviciotransporte;	
	protected List<ServicioTransporte> serviciotransportes;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Cliente> clientesForeignKey;
	public List<Cliente> clienteproveedorsForeignKey;
	public List<Transportista> transportistasForeignKey;
	public List<Vehiculo> vehiculosForeignKey;
	public List<RutaTransporte> rutatransportesForeignKey;
	public List<DetalleActivoFijo> detalleactivofijosForeignKey;
	
	public ServicioTransporteParameterReturnGeneral () throws Exception {						
		super();
		this.serviciotransportes= new ArrayList<ServicioTransporte>();
		this.serviciotransporte= new ServicioTransporte();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.clienteproveedorsForeignKey=new ArrayList<Cliente>();
		this.transportistasForeignKey=new ArrayList<Transportista>();
		this.vehiculosForeignKey=new ArrayList<Vehiculo>();
		this.rutatransportesForeignKey=new ArrayList<RutaTransporte>();
		this.detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
	} 
	
	public ServicioTransporte getServicioTransporte() throws Exception {	
		return serviciotransporte;
	}
		
	public void setServicioTransporte(ServicioTransporte newServicioTransporte) {
		this.serviciotransporte = newServicioTransporte;
	}
	
	public List<ServicioTransporte> getServicioTransportes() throws Exception {		
		return serviciotransportes;
	}
	
	public void setServicioTransportes(List<ServicioTransporte> newServicioTransportes) {
		this.serviciotransportes = newServicioTransportes;
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

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Cliente> getclienteproveedorsForeignKey() {
		return this.clienteproveedorsForeignKey;
	}

	public List<Transportista> gettransportistasForeignKey() {
		return this.transportistasForeignKey;
	}

	public List<Vehiculo> getvehiculosForeignKey() {
		return this.vehiculosForeignKey;
	}

	public List<RutaTransporte> getrutatransportesForeignKey() {
		return this.rutatransportesForeignKey;
	}

	public List<DetalleActivoFijo> getdetalleactivofijosForeignKey() {
		return this.detalleactivofijosForeignKey;
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

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setclienteproveedorsForeignKey(List<Cliente> clienteproveedorsForeignKey) {
		this.clienteproveedorsForeignKey=clienteproveedorsForeignKey;
	}

	public void settransportistasForeignKey(List<Transportista> transportistasForeignKey) {
		this.transportistasForeignKey=transportistasForeignKey;
	}

	public void setvehiculosForeignKey(List<Vehiculo> vehiculosForeignKey) {
		this.vehiculosForeignKey=vehiculosForeignKey;
	}

	public void setrutatransportesForeignKey(List<RutaTransporte> rutatransportesForeignKey) {
		this.rutatransportesForeignKey=rutatransportesForeignKey;
	}

	public void setdetalleactivofijosForeignKey(List<DetalleActivoFijo> detalleactivofijosForeignKey) {
		this.detalleactivofijosForeignKey=detalleactivofijosForeignKey;
	}
}

