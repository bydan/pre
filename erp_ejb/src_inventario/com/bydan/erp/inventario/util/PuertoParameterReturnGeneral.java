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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.PuertoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Puerto


import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class PuertoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Puerto puerto;	
	protected List<Puerto> puertos;
	
	
	public List<TipoPuerto> tipopuertosForeignKey;
	public List<Pais> paissForeignKey;
	
	public PuertoParameterReturnGeneral () throws Exception {						
		super();
		this.puertos= new ArrayList<Puerto>();
		this.puerto= new Puerto();
		
		
		this.tipopuertosForeignKey=new ArrayList<TipoPuerto>();
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public Puerto getPuerto() throws Exception {	
		return puerto;
	}
		
	public void setPuerto(Puerto newPuerto) {
		this.puerto = newPuerto;
	}
	
	public List<Puerto> getPuertos() throws Exception {		
		return puertos;
	}
	
	public void setPuertos(List<Puerto> newPuertos) {
		this.puertos = newPuertos;
	}
	
	

	public List<TipoPuerto> gettipopuertosForeignKey() {
		return this.tipopuertosForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void settipopuertosForeignKey(List<TipoPuerto> tipopuertosForeignKey) {
		this.tipopuertosForeignKey=tipopuertosForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

