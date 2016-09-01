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
package com.bydan.erp.contabilidad.util;

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
import com.bydan.erp.contabilidad.util.PlantillaFacturaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//PlantillaFactura


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class PlantillaFacturaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected PlantillaFactura plantillafactura;	
	protected List<PlantillaFactura> plantillafacturas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<CuentaContable> cuentacontableaplicadasForeignKey;
	public List<CuentaContable> cuentacontablecreditobiensForeignKey;
	public List<CuentaContable> cuentacontablecreditoserviciosForeignKey;
	public List<TipoRetencion> tiporetencionfuentebiensForeignKey;
	public List<TipoRetencion> tiporetencionfuenteserviciosForeignKey;
	public List<TipoRetencion> tiporetencionivabiensForeignKey;
	public List<TipoRetencion> tiporetencionivaserviciosForeignKey;
	public List<CuentaContable> cuentacontablegastosForeignKey;
	
	public PlantillaFacturaParameterReturnGeneral () throws Exception {						
		super();
		this.plantillafacturas= new ArrayList<PlantillaFactura>();
		this.plantillafactura= new PlantillaFactura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.cuentacontableaplicadasForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditobiensForeignKey=new ArrayList<CuentaContable>();
		this.cuentacontablecreditoserviciosForeignKey=new ArrayList<CuentaContable>();
		this.tiporetencionfuentebiensForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionfuenteserviciosForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionivabiensForeignKey=new ArrayList<TipoRetencion>();
		this.tiporetencionivaserviciosForeignKey=new ArrayList<TipoRetencion>();
		this.cuentacontablegastosForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public PlantillaFactura getPlantillaFactura() throws Exception {	
		return plantillafactura;
	}
		
	public void setPlantillaFactura(PlantillaFactura newPlantillaFactura) {
		this.plantillafactura = newPlantillaFactura;
	}
	
	public List<PlantillaFactura> getPlantillaFacturas() throws Exception {		
		return plantillafacturas;
	}
	
	public void setPlantillaFacturas(List<PlantillaFactura> newPlantillaFacturas) {
		this.plantillafacturas = newPlantillaFacturas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<CuentaContable> getcuentacontableaplicadasForeignKey() {
		return this.cuentacontableaplicadasForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditobiensForeignKey() {
		return this.cuentacontablecreditobiensForeignKey;
	}

	public List<CuentaContable> getcuentacontablecreditoserviciosForeignKey() {
		return this.cuentacontablecreditoserviciosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuentebiensForeignKey() {
		return this.tiporetencionfuentebiensForeignKey;
	}

	public List<TipoRetencion> gettiporetencionfuenteserviciosForeignKey() {
		return this.tiporetencionfuenteserviciosForeignKey;
	}

	public List<TipoRetencion> gettiporetencionivabiensForeignKey() {
		return this.tiporetencionivabiensForeignKey;
	}

	public List<TipoRetencion> gettiporetencionivaserviciosForeignKey() {
		return this.tiporetencionivaserviciosForeignKey;
	}

	public List<CuentaContable> getcuentacontablegastosForeignKey() {
		return this.cuentacontablegastosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setcuentacontableaplicadasForeignKey(List<CuentaContable> cuentacontableaplicadasForeignKey) {
		this.cuentacontableaplicadasForeignKey=cuentacontableaplicadasForeignKey;
	}

	public void setcuentacontablecreditobiensForeignKey(List<CuentaContable> cuentacontablecreditobiensForeignKey) {
		this.cuentacontablecreditobiensForeignKey=cuentacontablecreditobiensForeignKey;
	}

	public void setcuentacontablecreditoserviciosForeignKey(List<CuentaContable> cuentacontablecreditoserviciosForeignKey) {
		this.cuentacontablecreditoserviciosForeignKey=cuentacontablecreditoserviciosForeignKey;
	}

	public void settiporetencionfuentebiensForeignKey(List<TipoRetencion> tiporetencionfuentebiensForeignKey) {
		this.tiporetencionfuentebiensForeignKey=tiporetencionfuentebiensForeignKey;
	}

	public void settiporetencionfuenteserviciosForeignKey(List<TipoRetencion> tiporetencionfuenteserviciosForeignKey) {
		this.tiporetencionfuenteserviciosForeignKey=tiporetencionfuenteserviciosForeignKey;
	}

	public void settiporetencionivabiensForeignKey(List<TipoRetencion> tiporetencionivabiensForeignKey) {
		this.tiporetencionivabiensForeignKey=tiporetencionivabiensForeignKey;
	}

	public void settiporetencionivaserviciosForeignKey(List<TipoRetencion> tiporetencionivaserviciosForeignKey) {
		this.tiporetencionivaserviciosForeignKey=tiporetencionivaserviciosForeignKey;
	}

	public void setcuentacontablegastosForeignKey(List<CuentaContable> cuentacontablegastosForeignKey) {
		this.cuentacontablegastosForeignKey=cuentacontablegastosForeignKey;
	}
}

