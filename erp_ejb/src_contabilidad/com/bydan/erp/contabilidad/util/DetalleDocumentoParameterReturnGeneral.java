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
import com.bydan.erp.contabilidad.util.DetalleDocumentoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//DetalleDocumento


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class DetalleDocumentoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DetalleDocumento detalledocumento;	
	protected List<DetalleDocumento> detalledocumentos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey;
	public List<TipoDetalleDocumento> tipodetalledocumentosForeignKey;
	
	public DetalleDocumentoParameterReturnGeneral () throws Exception {						
		super();
		this.detalledocumentos= new ArrayList<DetalleDocumento>();
		this.detalledocumento= new DetalleDocumento();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
		this.tipodetalledocumentosForeignKey=new ArrayList<TipoDetalleDocumento>();
	} 
	
	public DetalleDocumento getDetalleDocumento() throws Exception {	
		return detalledocumento;
	}
		
	public void setDetalleDocumento(DetalleDocumento newDetalleDocumento) {
		this.detalledocumento = newDetalleDocumento;
	}
	
	public List<DetalleDocumento> getDetalleDocumentos() throws Exception {		
		return detalledocumentos;
	}
	
	public void setDetalleDocumentos(List<DetalleDocumento> newDetalleDocumentos) {
		this.detalledocumentos = newDetalleDocumentos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoTransaccionModulo> gettipotransaccionmodulosForeignKey() {
		return this.tipotransaccionmodulosForeignKey;
	}

	public List<TipoDetalleDocumento> gettipodetalledocumentosForeignKey() {
		return this.tipodetalledocumentosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipotransaccionmodulosForeignKey(List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey) {
		this.tipotransaccionmodulosForeignKey=tipotransaccionmodulosForeignKey;
	}

	public void settipodetalledocumentosForeignKey(List<TipoDetalleDocumento> tipodetalledocumentosForeignKey) {
		this.tipodetalledocumentosForeignKey=tipodetalledocumentosForeignKey;
	}
}

