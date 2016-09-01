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
import com.bydan.erp.puntoventa.util.TarjetaCreditoConexionConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//TarjetaCreditoConexion


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TarjetaCreditoConexionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TarjetaCreditoConexion tarjetacreditoconexion;	
	protected List<TarjetaCreditoConexion> tarjetacreditoconexions;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TarjetaCredito> tarjetacreditosForeignKey;
	public List<Conexion> conexionsForeignKey;
	
	public TarjetaCreditoConexionParameterReturnGeneral () throws Exception {						
		super();
		this.tarjetacreditoconexions= new ArrayList<TarjetaCreditoConexion>();
		this.tarjetacreditoconexion= new TarjetaCreditoConexion();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
		this.conexionsForeignKey=new ArrayList<Conexion>();
	} 
	
	public TarjetaCreditoConexion getTarjetaCreditoConexion() throws Exception {	
		return tarjetacreditoconexion;
	}
		
	public void setTarjetaCreditoConexion(TarjetaCreditoConexion newTarjetaCreditoConexion) {
		this.tarjetacreditoconexion = newTarjetaCreditoConexion;
	}
	
	public List<TarjetaCreditoConexion> getTarjetaCreditoConexions() throws Exception {		
		return tarjetacreditoconexions;
	}
	
	public void setTarjetaCreditoConexions(List<TarjetaCreditoConexion> newTarjetaCreditoConexions) {
		this.tarjetacreditoconexions = newTarjetaCreditoConexions;
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

	public List<Conexion> getconexionsForeignKey() {
		return this.conexionsForeignKey;
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

	public void setconexionsForeignKey(List<Conexion> conexionsForeignKey) {
		this.conexionsForeignKey=conexionsForeignKey;
	}
}

