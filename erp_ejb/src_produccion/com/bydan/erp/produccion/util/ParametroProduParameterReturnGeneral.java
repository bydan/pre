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
import com.bydan.erp.produccion.util.ParametroProduConstantesFunciones;

import com.bydan.erp.produccion.business.entity.*;//ParametroProdu


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ParametroProduParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroProdu parametroprodu;	
	protected List<ParametroProdu> parametroprodus;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<Bodega> bodegamateriaprimasForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<Transaccion> transaccionegresosForeignKey;
	
	public ParametroProduParameterReturnGeneral () throws Exception {						
		super();
		this.parametroprodus= new ArrayList<ParametroProdu>();
		this.parametroprodu= new ParametroProdu();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.bodegamateriaprimasForeignKey=new ArrayList<Bodega>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.transaccionegresosForeignKey=new ArrayList<Transaccion>();
	} 
	
	public ParametroProdu getParametroProdu() throws Exception {	
		return parametroprodu;
	}
		
	public void setParametroProdu(ParametroProdu newParametroProdu) {
		this.parametroprodu = newParametroProdu;
	}
	
	public List<ParametroProdu> getParametroProdus() throws Exception {		
		return parametroprodus;
	}
	
	public void setParametroProdus(List<ParametroProdu> newParametroProdus) {
		this.parametroprodus = newParametroProdus;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<Bodega> getbodegamateriaprimasForeignKey() {
		return this.bodegamateriaprimasForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<Transaccion> gettransaccionegresosForeignKey() {
		return this.transaccionegresosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setbodegamateriaprimasForeignKey(List<Bodega> bodegamateriaprimasForeignKey) {
		this.bodegamateriaprimasForeignKey=bodegamateriaprimasForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void settransaccionegresosForeignKey(List<Transaccion> transaccionegresosForeignKey) {
		this.transaccionegresosForeignKey=transaccionegresosForeignKey;
	}
}

