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
import com.bydan.erp.facturacion.util.ParametroGenericoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroGenerico


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroGenericoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroGenerico parametrogenerico;	
	protected List<ParametroGenerico> parametrogenericos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Transaccion> transaccionrecibosForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Servicio> serviciosForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Formato> formatorecibosForeignKey;
	
	public ParametroGenericoParameterReturnGeneral () throws Exception {						
		super();
		this.parametrogenericos= new ArrayList<ParametroGenerico>();
		this.parametrogenerico= new ParametroGenerico();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.transaccionrecibosForeignKey=new ArrayList<Transaccion>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.serviciosForeignKey=new ArrayList<Servicio>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.formatorecibosForeignKey=new ArrayList<Formato>();
	} 
	
	public ParametroGenerico getParametroGenerico() throws Exception {	
		return parametrogenerico;
	}
		
	public void setParametroGenerico(ParametroGenerico newParametroGenerico) {
		this.parametrogenerico = newParametroGenerico;
	}
	
	public List<ParametroGenerico> getParametroGenericos() throws Exception {		
		return parametrogenericos;
	}
	
	public void setParametroGenericos(List<ParametroGenerico> newParametroGenericos) {
		this.parametrogenericos = newParametroGenericos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Transaccion> gettransaccionrecibosForeignKey() {
		return this.transaccionrecibosForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Servicio> getserviciosForeignKey() {
		return this.serviciosForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Formato> getformatorecibosForeignKey() {
		return this.formatorecibosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void settransaccionrecibosForeignKey(List<Transaccion> transaccionrecibosForeignKey) {
		this.transaccionrecibosForeignKey=transaccionrecibosForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setserviciosForeignKey(List<Servicio> serviciosForeignKey) {
		this.serviciosForeignKey=serviciosForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setformatorecibosForeignKey(List<Formato> formatorecibosForeignKey) {
		this.formatorecibosForeignKey=formatorecibosForeignKey;
	}
}

