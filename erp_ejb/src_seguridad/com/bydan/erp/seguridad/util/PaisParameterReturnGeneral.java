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
import com.bydan.erp.seguridad.util.PaisConstantesFunciones;

import com.bydan.erp.seguridad.business.entity.*;//Pais


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class PaisParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Pais pais;	
	protected List<Pais> paiss;
	
	
	public List<Continente> continentesForeignKey;
	
	public PaisParameterReturnGeneral () throws Exception {						
		super();
		this.paiss= new ArrayList<Pais>();
		this.pais= new Pais();
		
		
		this.continentesForeignKey=new ArrayList<Continente>();
	} 
	
	public Pais getPais() throws Exception {	
		return pais;
	}
		
	public void setPais(Pais newPais) {
		this.pais = newPais;
	}
	
	public List<Pais> getPaiss() throws Exception {		
		return paiss;
	}
	
	public void setPaiss(List<Pais> newPaiss) {
		this.paiss = newPaiss;
	}
	
	

	public List<Continente> getcontinentesForeignKey() {
		return this.continentesForeignKey;
	}
	
	

	public void setcontinentesForeignKey(List<Continente> continentesForeignKey) {
		this.continentesForeignKey=continentesForeignKey;
	}
}

