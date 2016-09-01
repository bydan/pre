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
package com.bydan.erp.sris.util;

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
import com.bydan.erp.sris.util.DocumentoAnuladoConstantesFunciones;

import com.bydan.erp.sris.business.entity.*;//DocumentoAnulado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


@SuppressWarnings("unused")
public class DocumentoAnuladoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DocumentoAnulado documentoanulado;	
	protected List<DocumentoAnulado> documentoanulados;
	
	
	public List<Empresa> empresasForeignKey;
	public List<PeriodoDeclara> periododeclarasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoComprobante> tipocomprobantesForeignKey;
	
	public DocumentoAnuladoParameterReturnGeneral () throws Exception {						
		super();
		this.documentoanulados= new ArrayList<DocumentoAnulado>();
		this.documentoanulado= new DocumentoAnulado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.periododeclarasForeignKey=new ArrayList<PeriodoDeclara>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
	} 
	
	public DocumentoAnulado getDocumentoAnulado() throws Exception {	
		return documentoanulado;
	}
		
	public void setDocumentoAnulado(DocumentoAnulado newDocumentoAnulado) {
		this.documentoanulado = newDocumentoAnulado;
	}
	
	public List<DocumentoAnulado> getDocumentoAnulados() throws Exception {		
		return documentoanulados;
	}
	
	public void setDocumentoAnulados(List<DocumentoAnulado> newDocumentoAnulados) {
		this.documentoanulados = newDocumentoAnulados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<PeriodoDeclara> getperiododeclarasForeignKey() {
		return this.periododeclarasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoComprobante> gettipocomprobantesForeignKey() {
		return this.tipocomprobantesForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setperiododeclarasForeignKey(List<PeriodoDeclara> periododeclarasForeignKey) {
		this.periododeclarasForeignKey=periododeclarasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipocomprobantesForeignKey(List<TipoComprobante> tipocomprobantesForeignKey) {
		this.tipocomprobantesForeignKey=tipocomprobantesForeignKey;
	}
}

