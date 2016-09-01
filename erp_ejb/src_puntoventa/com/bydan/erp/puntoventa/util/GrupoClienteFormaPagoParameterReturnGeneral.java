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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.GrupoClienteFormaPagoConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//GrupoClienteFormaPago


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


@SuppressWarnings("unused")
public class GrupoClienteFormaPagoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected GrupoClienteFormaPago grupoclienteformapago;	
	protected List<GrupoClienteFormaPago> grupoclienteformapagos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<TipoFormaPago> tipoformapagosForeignKey;
	
	public GrupoClienteFormaPagoParameterReturnGeneral () throws Exception {						
		super();
		this.grupoclienteformapagos= new ArrayList<GrupoClienteFormaPago>();
		this.grupoclienteformapago= new GrupoClienteFormaPago();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
	} 
	
	public GrupoClienteFormaPago getGrupoClienteFormaPago() throws Exception {	
		return grupoclienteformapago;
	}
		
	public void setGrupoClienteFormaPago(GrupoClienteFormaPago newGrupoClienteFormaPago) {
		this.grupoclienteformapago = newGrupoClienteFormaPago;
	}
	
	public List<GrupoClienteFormaPago> getGrupoClienteFormaPagos() throws Exception {		
		return grupoclienteformapagos;
	}
	
	public void setGrupoClienteFormaPagos(List<GrupoClienteFormaPago> newGrupoClienteFormaPagos) {
		this.grupoclienteformapagos = newGrupoClienteFormaPagos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<TipoFormaPago> gettipoformapagosForeignKey() {
		return this.tipoformapagosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void settipoformapagosForeignKey(List<TipoFormaPago> tipoformapagosForeignKey) {
		this.tipoformapagosForeignKey=tipoformapagosForeignKey;
	}
}

