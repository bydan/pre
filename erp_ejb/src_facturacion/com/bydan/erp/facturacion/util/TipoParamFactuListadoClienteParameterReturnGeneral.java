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
import com.bydan.erp.facturacion.util.TipoParamFactuListadoClienteConstantesFunciones;

import com.bydan.erp.facturacion.business.entity.*;//TipoParamFactuListadoCliente




@SuppressWarnings("unused")
public class TipoParamFactuListadoClienteParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoParamFactuListadoCliente tipoparamfactulistadocliente;	
	protected List<TipoParamFactuListadoCliente> tipoparamfactulistadoclientes;
	
	
	
	public TipoParamFactuListadoClienteParameterReturnGeneral () throws Exception {						
		super();
		this.tipoparamfactulistadoclientes= new ArrayList<TipoParamFactuListadoCliente>();
		this.tipoparamfactulistadocliente= new TipoParamFactuListadoCliente();
		
		
	} 
	
	public TipoParamFactuListadoCliente getTipoParamFactuListadoCliente() throws Exception {	
		return tipoparamfactulistadocliente;
	}
		
	public void setTipoParamFactuListadoCliente(TipoParamFactuListadoCliente newTipoParamFactuListadoCliente) {
		this.tipoparamfactulistadocliente = newTipoParamFactuListadoCliente;
	}
	
	public List<TipoParamFactuListadoCliente> getTipoParamFactuListadoClientes() throws Exception {		
		return tipoparamfactulistadoclientes;
	}
	
	public void setTipoParamFactuListadoClientes(List<TipoParamFactuListadoCliente> newTipoParamFactuListadoClientes) {
		this.tipoparamfactulistadoclientes = newTipoParamFactuListadoClientes;
	}
	
	
	
	
}

