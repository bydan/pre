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
package com.bydan.erp.cartera.util.report;

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
import com.bydan.erp.cartera.util.report.CobrarClientesHonomasticosConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//CobrarClientesHonomasticos


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CobrarClientesHonomasticosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CobrarClientesHonomasticos cobrarclienteshonomasticos;	
	protected List<CobrarClientesHonomasticos> cobrarclienteshonomasticoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Region> regionsForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	
	public CobrarClientesHonomasticosParameterReturnGeneral () throws Exception {						
		super();
		this.cobrarclienteshonomasticoss= new ArrayList<CobrarClientesHonomasticos>();
		this.cobrarclienteshonomasticos= new CobrarClientesHonomasticos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.regionsForeignKey=new ArrayList<Region>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
	} 
	
	public CobrarClientesHonomasticos getCobrarClientesHonomasticos() throws Exception {	
		return cobrarclienteshonomasticos;
	}
		
	public void setCobrarClientesHonomasticos(CobrarClientesHonomasticos newCobrarClientesHonomasticos) {
		this.cobrarclienteshonomasticos = newCobrarClientesHonomasticos;
	}
	
	public List<CobrarClientesHonomasticos> getCobrarClientesHonomasticoss() throws Exception {		
		return cobrarclienteshonomasticoss;
	}
	
	public void setCobrarClientesHonomasticoss(List<CobrarClientesHonomasticos> newCobrarClientesHonomasticoss) {
		this.cobrarclienteshonomasticoss = newCobrarClientesHonomasticoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Region> getregionsForeignKey() {
		return this.regionsForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
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

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setregionsForeignKey(List<Region> regionsForeignKey) {
		this.regionsForeignKey=regionsForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}
}

