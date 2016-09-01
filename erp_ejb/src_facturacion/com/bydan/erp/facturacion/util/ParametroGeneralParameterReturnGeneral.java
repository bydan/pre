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
package com.bydan.erp.facturacion.util;

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
import com.bydan.erp.facturacion.util.ParametroGeneralConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//ParametroGeneral


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroGeneralParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroGeneral parametrogeneral;	
	protected List<ParametroGeneral> parametrogenerals;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey;
	
	public ParametroGeneralParameterReturnGeneral () throws Exception {						
		super();
		this.parametrogenerals= new ArrayList<ParametroGeneral>();
		this.parametrogeneral= new ParametroGeneral();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tipodocumentogeneralsForeignKey=new ArrayList<TipoDocumentoGeneral>();
	} 
	
	public ParametroGeneral getParametroGeneral() throws Exception {	
		return parametrogeneral;
	}
		
	public void setParametroGeneral(ParametroGeneral newParametroGeneral) {
		this.parametrogeneral = newParametroGeneral;
	}
	
	public List<ParametroGeneral> getParametroGenerals() throws Exception {		
		return parametrogenerals;
	}
	
	public void setParametroGenerals(List<ParametroGeneral> newParametroGenerals) {
		this.parametrogenerals = newParametroGenerals;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TipoDocumentoGeneral> gettipodocumentogeneralsForeignKey() {
		return this.tipodocumentogeneralsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settipodocumentogeneralsForeignKey(List<TipoDocumentoGeneral> tipodocumentogeneralsForeignKey) {
		this.tipodocumentogeneralsForeignKey=tipodocumentogeneralsForeignKey;
	}
}

