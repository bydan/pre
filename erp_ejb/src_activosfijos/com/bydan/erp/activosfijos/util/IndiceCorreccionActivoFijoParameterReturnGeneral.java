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
import com.bydan.erp.activosfijos.util.IndiceCorreccionActivoFijoConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//IndiceCorreccionActivoFijo


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class IndiceCorreccionActivoFijoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected IndiceCorreccionActivoFijo indicecorreccionactivofijo;	
	protected List<IndiceCorreccionActivoFijo> indicecorreccionactivofijos;
	
	
	public List<Empresa> empresasForeignKey;
	
	public IndiceCorreccionActivoFijoParameterReturnGeneral () throws Exception {						
		super();
		this.indicecorreccionactivofijos= new ArrayList<IndiceCorreccionActivoFijo>();
		this.indicecorreccionactivofijo= new IndiceCorreccionActivoFijo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public IndiceCorreccionActivoFijo getIndiceCorreccionActivoFijo() throws Exception {	
		return indicecorreccionactivofijo;
	}
		
	public void setIndiceCorreccionActivoFijo(IndiceCorreccionActivoFijo newIndiceCorreccionActivoFijo) {
		this.indicecorreccionactivofijo = newIndiceCorreccionActivoFijo;
	}
	
	public List<IndiceCorreccionActivoFijo> getIndiceCorreccionActivoFijos() throws Exception {		
		return indicecorreccionactivofijos;
	}
	
	public void setIndiceCorreccionActivoFijos(List<IndiceCorreccionActivoFijo> newIndiceCorreccionActivoFijos) {
		this.indicecorreccionactivofijos = newIndiceCorreccionActivoFijos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

