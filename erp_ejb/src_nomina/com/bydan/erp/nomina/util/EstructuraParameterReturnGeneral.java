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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.EstructuraConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Estructura


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class EstructuraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Estructura estructura;	
	protected List<Estructura> estructuras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<TipoPago_NM> tipopago_nmsForeignKey;
	public List<NumeroPatronal> numeropatronalsForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<TipoEstructura> tipoestructurasForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public EstructuraParameterReturnGeneral () throws Exception {						
		super();
		this.estructuras= new ArrayList<Estructura>();
		this.estructura= new Estructura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.tipopago_nmsForeignKey=new ArrayList<TipoPago_NM>();
		this.numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.tipoestructurasForeignKey=new ArrayList<TipoEstructura>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public Estructura getEstructura() throws Exception {	
		return estructura;
	}
		
	public void setEstructura(Estructura newEstructura) {
		this.estructura = newEstructura;
	}
	
	public List<Estructura> getEstructuras() throws Exception {		
		return estructuras;
	}
	
	public void setEstructuras(List<Estructura> newEstructuras) {
		this.estructuras = newEstructuras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Estructura> getestructurasForeignKey() {
		return this.estructurasForeignKey;
	}

	public List<TipoPago_NM> gettipopago_nmsForeignKey() {
		return this.tipopago_nmsForeignKey;
	}

	public List<NumeroPatronal> getnumeropatronalsForeignKey() {
		return this.numeropatronalsForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<TipoEstructura> gettipoestructurasForeignKey() {
		return this.tipoestructurasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void setestructurasForeignKey(List<Estructura> estructurasForeignKey) {
		this.estructurasForeignKey=estructurasForeignKey;
	}

	public void settipopago_nmsForeignKey(List<TipoPago_NM> tipopago_nmsForeignKey) {
		this.tipopago_nmsForeignKey=tipopago_nmsForeignKey;
	}

	public void setnumeropatronalsForeignKey(List<NumeroPatronal> numeropatronalsForeignKey) {
		this.numeropatronalsForeignKey=numeropatronalsForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void settipoestructurasForeignKey(List<TipoEstructura> tipoestructurasForeignKey) {
		this.tipoestructurasForeignKey=tipoestructurasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

