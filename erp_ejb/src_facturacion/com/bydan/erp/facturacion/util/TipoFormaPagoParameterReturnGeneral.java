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
import com.bydan.erp.facturacion.util.TipoFormaPagoConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//TipoFormaPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class TipoFormaPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoFormaPago tipoformapago;	
	protected List<TipoFormaPago> tipoformapagos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public TipoFormaPagoParameterReturnGeneral () throws Exception {						
		super();
		this.tipoformapagos= new ArrayList<TipoFormaPago>();
		this.tipoformapago= new TipoFormaPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public TipoFormaPago getTipoFormaPago() throws Exception {	
		return tipoformapago;
	}
		
	public void setTipoFormaPago(TipoFormaPago newTipoFormaPago) {
		this.tipoformapago = newTipoFormaPago;
	}
	
	public List<TipoFormaPago> getTipoFormaPagos() throws Exception {		
		return tipoformapagos;
	}
	
	public void setTipoFormaPagos(List<TipoFormaPago> newTipoFormaPagos) {
		this.tipoformapagos = newTipoFormaPagos;
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

	public List<TipoGrupoFormaPago> gettipogrupoformapagosForeignKey() {
		return this.tipogrupoformapagosForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
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

	public void settipogrupoformapagosForeignKey(List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey) {
		this.tipogrupoformapagosForeignKey=tipogrupoformapagosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

