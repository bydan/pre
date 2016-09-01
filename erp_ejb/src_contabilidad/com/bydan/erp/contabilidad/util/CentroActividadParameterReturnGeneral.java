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
import com.bydan.erp.contabilidad.util.CentroActividadConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//CentroActividad


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class CentroActividadParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CentroActividad centroactividad;	
	protected List<CentroActividad> centroactividads;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey;
	
	public CentroActividadParameterReturnGeneral () throws Exception {						
		super();
		this.centroactividads= new ArrayList<CentroActividad>();
		this.centroactividad= new CentroActividad();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
	} 
	
	public CentroActividad getCentroActividad() throws Exception {	
		return centroactividad;
	}
		
	public void setCentroActividad(CentroActividad newCentroActividad) {
		this.centroactividad = newCentroActividad;
	}
	
	public List<CentroActividad> getCentroActividads() throws Exception {		
		return centroactividads;
	}
	
	public void setCentroActividads(List<CentroActividad> newCentroActividads) {
		this.centroactividads = newCentroActividads;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<TipoGrupoFlujoCaja> gettipogrupoflujocajasForeignKey() {
		return this.tipogrupoflujocajasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void settipogrupoflujocajasForeignKey(List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey) {
		this.tipogrupoflujocajasForeignKey=tipogrupoflujocajasForeignKey;
	}
}

