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
import com.bydan.erp.nomina.util.RubroEstructuraConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//RubroEstructura


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class RubroEstructuraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected RubroEstructura rubroestructura;	
	protected List<RubroEstructura> rubroestructuras;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Estructura> estructurasForeignKey;
	public List<RubroEmplea> rubroempleasForeignKey;
	
	public RubroEstructuraParameterReturnGeneral () throws Exception {						
		super();
		this.rubroestructuras= new ArrayList<RubroEstructura>();
		this.rubroestructura= new RubroEstructura();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.estructurasForeignKey=new ArrayList<Estructura>();
		this.rubroempleasForeignKey=new ArrayList<RubroEmplea>();
	} 
	
	public RubroEstructura getRubroEstructura() throws Exception {	
		return rubroestructura;
	}
		
	public void setRubroEstructura(RubroEstructura newRubroEstructura) {
		this.rubroestructura = newRubroEstructura;
	}
	
	public List<RubroEstructura> getRubroEstructuras() throws Exception {		
		return rubroestructuras;
	}
	
	public void setRubroEstructuras(List<RubroEstructura> newRubroEstructuras) {
		this.rubroestructuras = newRubroEstructuras;
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

	public List<RubroEmplea> getrubroempleasForeignKey() {
		return this.rubroempleasForeignKey;
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

	public void setrubroempleasForeignKey(List<RubroEmplea> rubroempleasForeignKey) {
		this.rubroempleasForeignKey=rubroempleasForeignKey;
	}
}

