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
package com.bydan.erp.cartera.util;

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
import com.bydan.erp.cartera.util.TipoIdentificacionConstantesFunciones;

import com.bydan.erp.cartera.business.entity.*;//TipoIdentificacion


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TipoIdentificacionParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoIdentificacion tipoidentificacion;	
	protected List<TipoIdentificacion> tipoidentificacions;
	
	
	
	public TipoIdentificacionParameterReturnGeneral () throws Exception {						
		super();
		this.tipoidentificacions= new ArrayList<TipoIdentificacion>();
		this.tipoidentificacion= new TipoIdentificacion();
		
		
	} 
	
	public TipoIdentificacion getTipoIdentificacion() throws Exception {	
		return tipoidentificacion;
	}
		
	public void setTipoIdentificacion(TipoIdentificacion newTipoIdentificacion) {
		this.tipoidentificacion = newTipoIdentificacion;
	}
	
	public List<TipoIdentificacion> getTipoIdentificacions() throws Exception {		
		return tipoidentificacions;
	}
	
	public void setTipoIdentificacions(List<TipoIdentificacion> newTipoIdentificacions) {
		this.tipoidentificacions = newTipoIdentificacions;
	}
	
	
	
	
}

