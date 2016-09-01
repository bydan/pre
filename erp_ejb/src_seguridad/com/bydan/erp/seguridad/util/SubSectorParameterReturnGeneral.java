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
package com.bydan.erp.seguridad.util;

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
import com.bydan.erp.seguridad.util.SubSectorConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//SubSector




@SuppressWarnings("unused")
public class SubSectorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected SubSector subsector;	
	protected List<SubSector> subsectors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sector> sectorsForeignKey;
	
	public SubSectorParameterReturnGeneral () throws Exception {						
		super();
		this.subsectors= new ArrayList<SubSector>();
		this.subsector= new SubSector();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sectorsForeignKey=new ArrayList<Sector>();
	} 
	
	public SubSector getSubSector() throws Exception {	
		return subsector;
	}
		
	public void setSubSector(SubSector newSubSector) {
		this.subsector = newSubSector;
	}
	
	public List<SubSector> getSubSectors() throws Exception {		
		return subsectors;
	}
	
	public void setSubSectors(List<SubSector> newSubSectors) {
		this.subsectors = newSubSectors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sector> getsectorsForeignKey() {
		return this.sectorsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsectorsForeignKey(List<Sector> sectorsForeignKey) {
		this.sectorsForeignKey=sectorsForeignKey;
	}
}

