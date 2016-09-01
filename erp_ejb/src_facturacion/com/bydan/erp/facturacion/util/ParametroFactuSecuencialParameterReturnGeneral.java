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
import com.bydan.erp.facturacion.util.ParametroFactuSecuencialConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroFactuSecuencial


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ParametroFactuSecuencialParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroFactuSecuencial parametrofactusecuencial;	
	protected List<ParametroFactuSecuencial> parametrofactusecuencials;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<TipoParamFactuPlazo> tipoparamfactuplazosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Bodega> bodegatransferenciasForeignKey;
	public List<Transaccion> transacciontransferenciasForeignKey;
	
	public ParametroFactuSecuencialParameterReturnGeneral () throws Exception {						
		super();
		this.parametrofactusecuencials= new ArrayList<ParametroFactuSecuencial>();
		this.parametrofactusecuencial= new ParametroFactuSecuencial();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.tipoparamfactuplazosForeignKey=new ArrayList<TipoParamFactuPlazo>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.bodegatransferenciasForeignKey=new ArrayList<Bodega>();
		this.transacciontransferenciasForeignKey=new ArrayList<Transaccion>();
	} 
	
	public ParametroFactuSecuencial getParametroFactuSecuencial() throws Exception {	
		return parametrofactusecuencial;
	}
		
	public void setParametroFactuSecuencial(ParametroFactuSecuencial newParametroFactuSecuencial) {
		this.parametrofactusecuencial = newParametroFactuSecuencial;
	}
	
	public List<ParametroFactuSecuencial> getParametroFactuSecuencials() throws Exception {		
		return parametrofactusecuencials;
	}
	
	public void setParametroFactuSecuencials(List<ParametroFactuSecuencial> newParametroFactuSecuencials) {
		this.parametrofactusecuencials = newParametroFactuSecuencials;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoDocumentoGeneral> gettipodocumentogeneralsForeignKey() {
		return this.tipodocumentogeneralsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<TipoParamFactuPlazo> gettipoparamfactuplazosForeignKey() {
		return this.tipoparamfactuplazosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Bodega> getbodegatransferenciasForeignKey() {
		return this.bodegatransferenciasForeignKey;
	}

	public List<Transaccion> gettransacciontransferenciasForeignKey() {
		return this.transacciontransferenciasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipodocumentogeneralsForeignKey(List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey) {
		this.tipodocumentogeneralsForeignKey=tipodocumentogeneralsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void settipoparamfactuplazosForeignKey(List<TipoParamFactuPlazo> tipoparamfactuplazosForeignKey) {
		this.tipoparamfactuplazosForeignKey=tipoparamfactuplazosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setbodegatransferenciasForeignKey(List<Bodega> bodegatransferenciasForeignKey) {
		this.bodegatransferenciasForeignKey=bodegatransferenciasForeignKey;
	}

	public void settransacciontransferenciasForeignKey(List<Transaccion> transacciontransferenciasForeignKey) {
		this.transacciontransferenciasForeignKey=transacciontransferenciasForeignKey;
	}
}

