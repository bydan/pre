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
import com.bydan.erp.contabilidad.util.TipoTributarioConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//TipoTributario


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


@SuppressWarnings("unused")
public class TipoTributarioParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoTributario tipotributario;	
	protected List<TipoTributario> tipotributarios;
	
	
	public List<Pais> paissForeignKey;
	
	public TipoTributarioParameterReturnGeneral () throws Exception {						
		super();
		this.tipotributarios= new ArrayList<TipoTributario>();
		this.tipotributario= new TipoTributario();
		
		
		this.paissForeignKey=new ArrayList<Pais>();
	} 
	
	public TipoTributario getTipoTributario() throws Exception {	
		return tipotributario;
	}
		
	public void setTipoTributario(TipoTributario newTipoTributario) {
		this.tipotributario = newTipoTributario;
	}
	
	public List<TipoTributario> getTipoTributarios() throws Exception {		
		return tipotributarios;
	}
	
	public void setTipoTributarios(List<TipoTributario> newTipoTributarios) {
		this.tipotributarios = newTipoTributarios;
	}
	
	

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}
	
	

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}
}

