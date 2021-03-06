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
import com.bydan.erp.puntoventa.util.HistorialFormaPagoPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//HistorialFormaPagoPuntoVenta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class HistorialFormaPagoPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HistorialFormaPagoPuntoVenta historialformapagopuntoventa;	
	protected List<HistorialFormaPagoPuntoVenta> historialformapagopuntoventas;
	
	
	public List<FacturaPuntoVenta> facturapuntoventasForeignKey;
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	
	public HistorialFormaPagoPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.historialformapagopuntoventas= new ArrayList<HistorialFormaPagoPuntoVenta>();
		this.historialformapagopuntoventa= new HistorialFormaPagoPuntoVenta();
		
		
		this.facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
	} 
	
	public HistorialFormaPagoPuntoVenta getHistorialFormaPagoPuntoVenta() throws Exception {	
		return historialformapagopuntoventa;
	}
		
	public void setHistorialFormaPagoPuntoVenta(HistorialFormaPagoPuntoVenta newHistorialFormaPagoPuntoVenta) {
		this.historialformapagopuntoventa = newHistorialFormaPagoPuntoVenta;
	}
	
	public List<HistorialFormaPagoPuntoVenta> getHistorialFormaPagoPuntoVentas() throws Exception {		
		return historialformapagopuntoventas;
	}
	
	public void setHistorialFormaPagoPuntoVentas(List<HistorialFormaPagoPuntoVenta> newHistorialFormaPagoPuntoVentas) {
		this.historialformapagopuntoventas = newHistorialFormaPagoPuntoVentas;
	}
	
	

	public List<FacturaPuntoVenta> getfacturapuntoventasForeignKey() {
		return this.facturapuntoventasForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}
	
	

	public void setfacturapuntoventasForeignKey(List<FacturaPuntoVenta> facturapuntoventasForeignKey) {
		this.facturapuntoventasForeignKey=facturapuntoventasForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}
}

