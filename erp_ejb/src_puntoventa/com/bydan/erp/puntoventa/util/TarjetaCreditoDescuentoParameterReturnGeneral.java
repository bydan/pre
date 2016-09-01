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
import com.bydan.erp.puntoventa.util.TarjetaCreditoDescuentoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//TarjetaCreditoDescuento


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TarjetaCreditoDescuentoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TarjetaCreditoDescuento tarjetacreditodescuento;	
	protected List<TarjetaCreditoDescuento> tarjetacreditodescuentos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TarjetaCredito> tarjetacreditosForeignKey;
	
	public TarjetaCreditoDescuentoParameterReturnGeneral () throws Exception {						
		super();
		this.tarjetacreditodescuentos= new ArrayList<TarjetaCreditoDescuento>();
		this.tarjetacreditodescuento= new TarjetaCreditoDescuento();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
	} 
	
	public TarjetaCreditoDescuento getTarjetaCreditoDescuento() throws Exception {	
		return tarjetacreditodescuento;
	}
		
	public void setTarjetaCreditoDescuento(TarjetaCreditoDescuento newTarjetaCreditoDescuento) {
		this.tarjetacreditodescuento = newTarjetaCreditoDescuento;
	}
	
	public List<TarjetaCreditoDescuento> getTarjetaCreditoDescuentos() throws Exception {		
		return tarjetacreditodescuentos;
	}
	
	public void setTarjetaCreditoDescuentos(List<TarjetaCreditoDescuento> newTarjetaCreditoDescuentos) {
		this.tarjetacreditodescuentos = newTarjetaCreditoDescuentos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TarjetaCredito> gettarjetacreditosForeignKey() {
		return this.tarjetacreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settarjetacreditosForeignKey(List<TarjetaCredito> tarjetacreditosForeignKey) {
		this.tarjetacreditosForeignKey=tarjetacreditosForeignKey;
	}
}

