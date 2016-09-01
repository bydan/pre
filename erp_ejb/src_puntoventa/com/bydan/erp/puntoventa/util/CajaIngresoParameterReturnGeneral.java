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
import com.bydan.erp.puntoventa.util.CajaIngresoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//CajaIngreso


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CajaIngresoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CajaIngreso cajaingreso;	
	protected List<CajaIngreso> cajaingresos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Usuario> usuariosForeignKey;
	public List<Caja> cajasForeignKey;
	public List<TurnoPunVen> turnopunvensForeignKey;
	
	public CajaIngresoParameterReturnGeneral () throws Exception {						
		super();
		this.cajaingresos= new ArrayList<CajaIngreso>();
		this.cajaingreso= new CajaIngreso();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.usuariosForeignKey=new ArrayList<Usuario>();
		this.cajasForeignKey=new ArrayList<Caja>();
		this.turnopunvensForeignKey=new ArrayList<TurnoPunVen>();
	} 
	
	public CajaIngreso getCajaIngreso() throws Exception {	
		return cajaingreso;
	}
		
	public void setCajaIngreso(CajaIngreso newCajaIngreso) {
		this.cajaingreso = newCajaIngreso;
	}
	
	public List<CajaIngreso> getCajaIngresos() throws Exception {		
		return cajaingresos;
	}
	
	public void setCajaIngresos(List<CajaIngreso> newCajaIngresos) {
		this.cajaingresos = newCajaIngresos;
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

	public List<Caja> getcajasForeignKey() {
		return this.cajasForeignKey;
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

	public void setcajasForeignKey(List<Caja> cajasForeignKey) {
		this.cajasForeignKey=cajasForeignKey;
	}

	public void setturnopunvensForeignKey(List<TurnoPunVen> turnopunvensForeignKey) {
		this.turnopunvensForeignKey=turnopunvensForeignKey;
	}
}

