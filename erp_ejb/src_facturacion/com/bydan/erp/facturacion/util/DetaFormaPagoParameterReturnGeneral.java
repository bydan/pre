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
import com.bydan.erp.facturacion.util.DetaFormaPagoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//DetaFormaPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class DetaFormaPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetaFormaPago detaformapago;	
	protected List<DetaFormaPago> detaformapagos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Ejercicio> ejerciciosForeignKey;
	public List<Periodo> periodosForeignKey;
	public List<Factura> facturasForeignKey;
	public List<TipoFormaPago> tipoformapagosForeignKey;
	public List<TipoDetaFormaPago> tipodetaformapagosForeignKey;
	public List<DetaFormaPagoFactu> detaformapagofactusForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<TipoRetencion> tiporetencionsForeignKey;
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public DetaFormaPagoParameterReturnGeneral () throws Exception {						
		super();
		this.detaformapagos= new ArrayList<DetaFormaPago>();
		this.detaformapago= new DetaFormaPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.ejerciciosForeignKey=new ArrayList<Ejercicio>();
		this.periodosForeignKey=new ArrayList<Periodo>();
		this.facturasForeignKey=new ArrayList<Factura>();
		this.tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
		this.tipodetaformapagosForeignKey=new ArrayList<TipoDetaFormaPago>();
		this.detaformapagofactusForeignKey=new ArrayList<DetaFormaPagoFactu>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public DetaFormaPago getDetaFormaPago() throws Exception {	
		return detaformapago;
	}
		
	public void setDetaFormaPago(DetaFormaPago newDetaFormaPago) {
		this.detaformapago = newDetaFormaPago;
	}
	
	public List<DetaFormaPago> getDetaFormaPagos() throws Exception {		
		return detaformapagos;
	}
	
	public void setDetaFormaPagos(List<DetaFormaPago> newDetaFormaPagos) {
		this.detaformapagos = newDetaFormaPagos;
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

	public List<TipoDetaFormaPago> gettipodetaformapagosForeignKey() {
		return this.tipodetaformapagosForeignKey;
	}

	public List<DetaFormaPagoFactu> getdetaformapagofactusForeignKey() {
		return this.detaformapagofactusForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<TipoRetencion> gettiporetencionsForeignKey() {
		return this.tiporetencionsForeignKey;
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

	public void settipodetaformapagosForeignKey(List<TipoDetaFormaPago> tipodetaformapagosForeignKey) {
		this.tipodetaformapagosForeignKey=tipodetaformapagosForeignKey;
	}

	public void setdetaformapagofactusForeignKey(List<DetaFormaPagoFactu> detaformapagofactusForeignKey) {
		this.detaformapagofactusForeignKey=detaformapagofactusForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void settiporetencionsForeignKey(List<TipoRetencion> tiporetencionsForeignKey) {
		this.tiporetencionsForeignKey=tiporetencionsForeignKey;
	}

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

