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
package com.bydan.erp.activosfijos.util.report;

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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorGruposConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//ActivosFijosPorGrupos


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ActivosFijosPorGruposParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ActivosFijosPorGrupos activosfijosporgrupos;	
	protected List<ActivosFijosPorGrupos> activosfijosporgruposs;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	
	public ActivosFijosPorGruposParameterReturnGeneral () throws Exception {						
		super();
		this.activosfijosporgruposs= new ArrayList<ActivosFijosPorGrupos>();
		this.activosfijosporgrupos= new ActivosFijosPorGrupos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
	} 
	
	public ActivosFijosPorGrupos getActivosFijosPorGrupos() throws Exception {	
		return activosfijosporgrupos;
	}
		
	public void setActivosFijosPorGrupos(ActivosFijosPorGrupos newActivosFijosPorGrupos) {
		this.activosfijosporgrupos = newActivosFijosPorGrupos;
	}
	
	public List<ActivosFijosPorGrupos> getActivosFijosPorGruposs() throws Exception {		
		return activosfijosporgruposs;
	}
	
	public void setActivosFijosPorGruposs(List<ActivosFijosPorGrupos> newActivosFijosPorGruposs) {
		this.activosfijosporgruposs = newActivosFijosPorGruposs;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}
}

