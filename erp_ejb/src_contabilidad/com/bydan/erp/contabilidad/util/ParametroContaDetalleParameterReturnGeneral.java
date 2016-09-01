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
import com.bydan.erp.contabilidad.util.ParametroContaDetalleConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//ParametroContaDetalle




@SuppressWarnings("unused")
public class ParametroContaDetalleParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroContaDetalle parametrocontadetalle;	
	protected List<ParametroContaDetalle> parametrocontadetalles;
	
	
	public List<ParametroConta> parametrocontasForeignKey;
	public List<TipoParametroConta> tipoparametrocontasForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	
	public ParametroContaDetalleParameterReturnGeneral () throws Exception {						
		super();
		this.parametrocontadetalles= new ArrayList<ParametroContaDetalle>();
		this.parametrocontadetalle= new ParametroContaDetalle();
		
		
		this.parametrocontasForeignKey=new ArrayList<ParametroConta>();
		this.tipoparametrocontasForeignKey=new ArrayList<TipoParametroConta>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
	} 
	
	public ParametroContaDetalle getParametroContaDetalle() throws Exception {	
		return parametrocontadetalle;
	}
		
	public void setParametroContaDetalle(ParametroContaDetalle newParametroContaDetalle) {
		this.parametrocontadetalle = newParametroContaDetalle;
	}
	
	public List<ParametroContaDetalle> getParametroContaDetalles() throws Exception {		
		return parametrocontadetalles;
	}
	
	public void setParametroContaDetalles(List<ParametroContaDetalle> newParametroContaDetalles) {
		this.parametrocontadetalles = newParametroContaDetalles;
	}
	
	

	public List<ParametroConta> getparametrocontasForeignKey() {
		return this.parametrocontasForeignKey;
	}

	public List<TipoParametroConta> gettipoparametrocontasForeignKey() {
		return this.tipoparametrocontasForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}
	
	

	public void setparametrocontasForeignKey(List<ParametroConta> parametrocontasForeignKey) {
		this.parametrocontasForeignKey=parametrocontasForeignKey;
	}

	public void settipoparametrocontasForeignKey(List<TipoParametroConta> tipoparametrocontasForeignKey) {
		this.tipoparametrocontasForeignKey=tipoparametrocontasForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}
}

