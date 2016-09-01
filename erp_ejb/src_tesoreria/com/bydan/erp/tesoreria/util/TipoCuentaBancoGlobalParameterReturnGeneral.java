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
package com.bydan.erp.tesoreria.util;

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
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//TipoCuentaBancoGlobal


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TipoCuentaBancoGlobalParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoCuentaBancoGlobal tipocuentabancoglobal;	
	protected List<TipoCuentaBancoGlobal> tipocuentabancoglobals;
	
	
	
	public TipoCuentaBancoGlobalParameterReturnGeneral () throws Exception {						
		super();
		this.tipocuentabancoglobals= new ArrayList<TipoCuentaBancoGlobal>();
		this.tipocuentabancoglobal= new TipoCuentaBancoGlobal();
		
		
	} 
	
	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() throws Exception {	
		return tipocuentabancoglobal;
	}
		
	public void setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal newTipoCuentaBancoGlobal) {
		this.tipocuentabancoglobal = newTipoCuentaBancoGlobal;
	}
	
	public List<TipoCuentaBancoGlobal> getTipoCuentaBancoGlobals() throws Exception {		
		return tipocuentabancoglobals;
	}
	
	public void setTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> newTipoCuentaBancoGlobals) {
		this.tipocuentabancoglobals = newTipoCuentaBancoGlobals;
	}
	
	
	
	
}

