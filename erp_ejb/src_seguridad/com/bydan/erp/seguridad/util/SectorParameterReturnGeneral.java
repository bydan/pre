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
import com.bydan.erp.seguridad.util.SectorConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Sector


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class SectorParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Sector sector;	
	protected List<Sector> sectors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public SectorParameterReturnGeneral () throws Exception {						
		super();
		this.sectors= new ArrayList<Sector>();
		this.sector= new Sector();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public Sector getSector() throws Exception {	
		return sector;
	}
		
	public void setSector(Sector newSector) {
		this.sector = newSector;
	}
	
	public List<Sector> getSectors() throws Exception {		
		return sectors;
	}
	
	public void setSectors(List<Sector> newSectors) {
		this.sectors = newSectors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

