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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.FormatoActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//FormatoActivoFijo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class FormatoActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected FormatoActivoFijo formatoactivofijo;	
	protected List<FormatoActivoFijo> formatoactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Formato> formatosForeignKey;
	public List<Formato> formato2sForeignKey;
	
	public FormatoActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.formatoactivofijos= new ArrayList<FormatoActivoFijo>();
		this.formatoactivofijo= new FormatoActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.formatosForeignKey=new ArrayList<Formato>();
		this.formato2sForeignKey=new ArrayList<Formato>();
	} 
	
	public FormatoActivoFijo getFormatoActivoFijo() throws Exception {	
		return formatoactivofijo;
	}
		
	public void setFormatoActivoFijo(FormatoActivoFijo newFormatoActivoFijo) {
		this.formatoactivofijo = newFormatoActivoFijo;
	}
	
	public List<FormatoActivoFijo> getFormatoActivoFijos() throws Exception {		
		return formatoactivofijos;
	}
	
	public void setFormatoActivoFijos(List<FormatoActivoFijo> newFormatoActivoFijos) {
		this.formatoactivofijos = newFormatoActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Formato> getformatosForeignKey() {
		return this.formatosForeignKey;
	}

	public List<Formato> getformato2sForeignKey() {
		return this.formato2sForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setformatosForeignKey(List<Formato> formatosForeignKey) {
		this.formatosForeignKey=formatosForeignKey;
	}

	public void setformato2sForeignKey(List<Formato> formato2sForeignKey) {
		this.formato2sForeignKey=formato2sForeignKey;
	}
}

