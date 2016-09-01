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
import com.bydan.erp.contabilidad.util.DatoFormularioRentaConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DatoFormularioRenta


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DatoFormularioRentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DatoFormularioRenta datoformulariorenta;	
	protected List<DatoFormularioRenta> datoformulariorentas;
	
	
	public List<Anio> aniosForeignKey;
	public List<Mes> messForeignKey;
	
	public DatoFormularioRentaParameterReturnGeneral () throws Exception {						
		super();
		this.datoformulariorentas= new ArrayList<DatoFormularioRenta>();
		this.datoformulariorenta= new DatoFormularioRenta();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.messForeignKey=new ArrayList<Mes>();
	} 
	
	public DatoFormularioRenta getDatoFormularioRenta() throws Exception {	
		return datoformulariorenta;
	}
		
	public void setDatoFormularioRenta(DatoFormularioRenta newDatoFormularioRenta) {
		this.datoformulariorenta = newDatoFormularioRenta;
	}
	
	public List<DatoFormularioRenta> getDatoFormularioRentas() throws Exception {		
		return datoformulariorentas;
	}
	
	public void setDatoFormularioRentas(List<DatoFormularioRenta> newDatoFormularioRentas) {
		this.datoformulariorentas = newDatoFormularioRentas;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<Mes> getmessForeignKey() {
		return this.messForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setmessForeignKey(List<Mes> messForeignKey) {
		this.messForeignKey=messForeignKey;
	}
}

