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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.HistorialFormaPagoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//HistorialFormaPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class HistorialFormaPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected HistorialFormaPago historialformapago;	
	protected List<HistorialFormaPago> historialformapagos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Factura> facturasForeignKey;
	public List<TipoFormaPago> tipoformapagosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public HistorialFormaPagoParameterReturnGeneral () throws Exception {						
		super();
		this.historialformapagos= new ArrayList<HistorialFormaPago>();
		this.historialformapago= new HistorialFormaPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public HistorialFormaPago getHistorialFormaPago() throws Exception {	
		return historialformapago;
	}
		
	public void setHistorialFormaPago(HistorialFormaPago newHistorialFormaPago) {
		this.historialformapago = newHistorialFormaPago;
	}
	
	public List<HistorialFormaPago> getHistorialFormaPagos() throws Exception {		
		return historialformapagos;
	}
	
	public void setHistorialFormaPagos(List<HistorialFormaPago> newHistorialFormaPagos) {
		this.historialformapagos = newHistorialFormaPagos;
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

	public List<Factura> getfacturasForeignKey() {
		return this.facturasForeignKey;
	}

	public List<TipoFormaPago> gettipoformapagosForeignKey() {
		return this.tipoformapagosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
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

	public void setfacturasForeignKey(List<Factura> facturasForeignKey) {
		this.facturasForeignKey=facturasForeignKey;
	}

	public void settipoformapagosForeignKey(List<TipoFormaPago> tipoformapagosForeignKey) {
		this.tipoformapagosForeignKey=tipoformapagosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

