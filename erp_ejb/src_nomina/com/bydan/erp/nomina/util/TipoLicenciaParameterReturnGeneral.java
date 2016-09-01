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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.TipoLicenciaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoLicencia


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class TipoLicenciaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoLicencia tipolicencia;	
	protected List<TipoLicencia> tipolicencias;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoLicenciaParameterReturnGeneral () throws Exception {						
		super();
		this.tipolicencias= new ArrayList<TipoLicencia>();
		this.tipolicencia= new TipoLicencia();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoLicencia getTipoLicencia() throws Exception {	
		return tipolicencia;
	}
		
	public void setTipoLicencia(TipoLicencia newTipoLicencia) {
		this.tipolicencia = newTipoLicencia;
	}
	
	public List<TipoLicencia> getTipoLicencias() throws Exception {		
		return tipolicencias;
	}
	
	public void setTipoLicencias(List<TipoLicencia> newTipoLicencias) {
		this.tipolicencias = newTipoLicencias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

