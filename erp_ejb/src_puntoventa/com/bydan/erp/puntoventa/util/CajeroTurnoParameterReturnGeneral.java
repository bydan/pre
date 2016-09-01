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
import com.bydan.erp.puntoventa.util.CajeroTurnoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//CajeroTurno


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


@SuppressWarnings("unused")
public class CajeroTurnoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CajeroTurno cajeroturno;	
	protected List<CajeroTurno> cajeroturnos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Vendedor> vendedorsForeignKey;
	public List<Caja> cajasForeignKey;
	public List<Mesa> mesasForeignKey;
	public List<TurnoPunVen> turnopunvensForeignKey;
	
	public CajeroTurnoParameterReturnGeneral () throws Exception {						
		super();
		this.cajeroturnos= new ArrayList<CajeroTurno>();
		this.cajeroturno= new CajeroTurno();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.vendedorsForeignKey=new ArrayList<Vendedor>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.mesasForeignKey=new ArrayList<Mesa>();
		this.turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
	} 
	
	public CajeroTurno getCajeroTurno() throws Exception {	
		return cajeroturno;
	}
		
	public void setCajeroTurno(CajeroTurno newCajeroTurno) {
		this.cajeroturno = newCajeroTurno;
	}
	
	public List<CajeroTurno> getCajeroTurnos() throws Exception {		
		return cajeroturnos;
	}
	
	public void setCajeroTurnos(List<CajeroTurno> newCajeroTurnos) {
		this.cajeroturnos = newCajeroTurnos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Usuario> getusuariosForeignKey() {
		return this.usuariosForeignKey;
	}

	public List<Vendedor> getvendedorsForeignKey() {
		return this.vendedorsForeignKey;
	}

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
	}

	public List<Mesa> getmesasForeignKey() {
		return this.mesasForeignKey;
	}

	public List<TurnoPunVen> getturnopunvensForeignKey() {
		return this.turnopunvensForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setusuariosForeignKey(List<Usuario> usuariosForeignKey) {
		this.usuariosForeignKey=usuariosForeignKey;
	}

	public void setvendedorsForeignKey(List<Vendedor> vendedorsForeignKey) {
		this.vendedorsForeignKey=vendedorsForeignKey;
	}

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setmesasForeignKey(List<Mesa> mesasForeignKey) {
		this.mesasForeignKey=mesasForeignKey;
	}

	public void setturnopunvensForeignKey(List<TurnoPunVen> turnopunvensForeignKey) {
		this.turnopunvensForeignKey=turnopunvensForeignKey;
	}
}

