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
import com.bydan.erp.activosfijos.util.report.ActivosFijosPorRamosConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.report.*;//ActivosFijosPorRamos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class ActivosFijosPorRamosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ActivosFijosPorRamos activosfijosporramos;	
	protected List<ActivosFijosPorRamos> activosfijosporramoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey;
	
	public ActivosFijosPorRamosParameterReturnGeneral () throws Exception {						
		super();
		this.activosfijosporramoss= new ArrayList<ActivosFijosPorRamos>();
		this.activosfijosporramos= new ActivosFijosPorRamos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.tiporamoactivofijosForeignKey=new ArrayList<TipoRamoActivoFijo>();
	} 
	
	public ActivosFijosPorRamos getActivosFijosPorRamos() throws Exception {	
		return activosfijosporramos;
	}
		
	public void setActivosFijosPorRamos(ActivosFijosPorRamos newActivosFijosPorRamos) {
		this.activosfijosporramos = newActivosFijosPorRamos;
	}
	
	public List<ActivosFijosPorRamos> getActivosFijosPorRamoss() throws Exception {		
		return activosfijosporramoss;
	}
	
	public void setActivosFijosPorRamoss(List<ActivosFijosPorRamos> newActivosFijosPorRamoss) {
		this.activosfijosporramoss = newActivosFijosPorRamoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<TipoRamoActivoFijo> gettiporamoactivofijosForeignKey() {
		return this.tiporamoactivofijosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settiporamoactivofijosForeignKey(List<TipoRamoActivoFijo> tiporamoactivofijosForeignKey) {
		this.tiporamoactivofijosForeignKey=tiporamoactivofijosForeignKey;
	}
}

