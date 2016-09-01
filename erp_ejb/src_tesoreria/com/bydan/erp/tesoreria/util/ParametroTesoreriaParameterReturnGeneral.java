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
import com.bydan.erp.tesoreria.util.ParametroTesoreriaConstantesFunciones;

import com.bydan.erp.tesoreria.business.entity.*;//ParametroTesoreria


import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class ParametroTesoreriaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroTesoreria parametrotesoreria;	
	protected List<ParametroTesoreria> parametrotesorerias;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Transaccion> transaccioncobrarpagosForeignKey;
	public List<Transaccion> transaccioncobrardebitosForeignKey;
	public List<Transaccion> transaccioncobrarcreditosForeignKey;
	public List<Transaccion> transaccionpagarpagosForeignKey;
	public List<Transaccion> transaccionpagardebitosForeignKey;
	public List<Transaccion> transaccionpagarcreditosForeignKey;
	
	public ParametroTesoreriaParameterReturnGeneral () throws Exception {						
		super();
		this.parametrotesorerias= new ArrayList<ParametroTesoreria>();
		this.parametrotesoreria= new ParametroTesoreria();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.transaccioncobrarpagosForeignKey=new ArrayList<Transaccion>();
		this.transaccioncobrardebitosForeignKey=new ArrayList<Transaccion>();
		this.transaccioncobrarcreditosForeignKey=new ArrayList<Transaccion>();
		this.transaccionpagarpagosForeignKey=new ArrayList<Transaccion>();
		this.transaccionpagardebitosForeignKey=new ArrayList<Transaccion>();
		this.transaccionpagarcreditosForeignKey=new ArrayList<Transaccion>();
	} 
	
	public ParametroTesoreria getParametroTesoreria() throws Exception {	
		return parametrotesoreria;
	}
		
	public void setParametroTesoreria(ParametroTesoreria newParametroTesoreria) {
		this.parametrotesoreria = newParametroTesoreria;
	}
	
	public List<ParametroTesoreria> getParametroTesorerias() throws Exception {		
		return parametrotesorerias;
	}
	
	public void setParametroTesorerias(List<ParametroTesoreria> newParametroTesorerias) {
		this.parametrotesorerias = newParametroTesorerias;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Transaccion> gettransaccioncobrarpagosForeignKey() {
		return this.transaccioncobrarpagosForeignKey;
	}

	public List<Transaccion> gettransaccioncobrardebitosForeignKey() {
		return this.transaccioncobrardebitosForeignKey;
	}

	public List<Transaccion> gettransaccioncobrarcreditosForeignKey() {
		return this.transaccioncobrarcreditosForeignKey;
	}

	public List<Transaccion> gettransaccionpagarpagosForeignKey() {
		return this.transaccionpagarpagosForeignKey;
	}

	public List<Transaccion> gettransaccionpagardebitosForeignKey() {
		return this.transaccionpagardebitosForeignKey;
	}

	public List<Transaccion> gettransaccionpagarcreditosForeignKey() {
		return this.transaccionpagarcreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void settransaccioncobrarpagosForeignKey(List<Transaccion> transaccioncobrarpagosForeignKey) {
		this.transaccioncobrarpagosForeignKey=transaccioncobrarpagosForeignKey;
	}

	public void settransaccioncobrardebitosForeignKey(List<Transaccion> transaccioncobrardebitosForeignKey) {
		this.transaccioncobrardebitosForeignKey=transaccioncobrardebitosForeignKey;
	}

	public void settransaccioncobrarcreditosForeignKey(List<Transaccion> transaccioncobrarcreditosForeignKey) {
		this.transaccioncobrarcreditosForeignKey=transaccioncobrarcreditosForeignKey;
	}

	public void settransaccionpagarpagosForeignKey(List<Transaccion> transaccionpagarpagosForeignKey) {
		this.transaccionpagarpagosForeignKey=transaccionpagarpagosForeignKey;
	}

	public void settransaccionpagardebitosForeignKey(List<Transaccion> transaccionpagardebitosForeignKey) {
		this.transaccionpagardebitosForeignKey=transaccionpagardebitosForeignKey;
	}

	public void settransaccionpagarcreditosForeignKey(List<Transaccion> transaccionpagarcreditosForeignKey) {
		this.transaccionpagarcreditosForeignKey=transaccionpagarcreditosForeignKey;
	}
}

