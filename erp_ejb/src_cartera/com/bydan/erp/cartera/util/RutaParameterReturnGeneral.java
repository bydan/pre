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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.RutaConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//Ruta


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class RutaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Ruta ruta;	
	protected List<Ruta> rutas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Pais> paissForeignKey;
	public List<Ciudad> ciudadsForeignKey;
	public List<Sector> sectororigensForeignKey;
	public List<Sector> sectordestinosForeignKey;
	
	public RutaParameterReturnGeneral () throws Exception {						
		super();
		this.rutas= new ArrayList<Ruta>();
		this.ruta= new Ruta();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.ciudadsForeignKey=new ArrayList<Ciudad>();
		this.sectororigensForeignKey=new ArrayList<Sector>();
		this.sectordestinosForeignKey=new ArrayList<Sector>();
	} 
	
	public Ruta getRuta() throws Exception {	
		return ruta;
	}
		
	public void setRuta(Ruta newRuta) {
		this.ruta = newRuta;
	}
	
	public List<Ruta> getRutas() throws Exception {		
		return rutas;
	}
	
	public void setRutas(List<Ruta> newRutas) {
		this.rutas = newRutas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Ciudad> getciudadsForeignKey() {
		return this.ciudadsForeignKey;
	}

	public List<Sector> getsectororigensForeignKey() {
		return this.sectororigensForeignKey;
	}

	public List<Sector> getsectordestinosForeignKey() {
		return this.sectordestinosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setciudadsForeignKey(List<Ciudad> ciudadsForeignKey) {
		this.ciudadsForeignKey=ciudadsForeignKey;
	}

	public void setsectororigensForeignKey(List<Sector> sectororigensForeignKey) {
		this.sectororigensForeignKey=sectororigensForeignKey;
	}

	public void setsectordestinosForeignKey(List<Sector> sectordestinosForeignKey) {
		this.sectordestinosForeignKey=sectordestinosForeignKey;
	}
}

