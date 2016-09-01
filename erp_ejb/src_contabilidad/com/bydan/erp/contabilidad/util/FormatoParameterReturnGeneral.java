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
import com.bydan.erp.contabilidad.util.FormatoConstantesFunciones;

import com.bydan.erp.contabilidad.business.entity.*;//Formato


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


@SuppressWarnings("unused")
public class FormatoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Formato formato;	
	protected List<Formato> formatos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<TipoMovimiento> tipomovimientosForeignKey;
	public List<TipoFormato> tipoformatosForeignKey;
	
	public FormatoParameterReturnGeneral () throws Exception {						
		super();
		this.formatos= new ArrayList<Formato>();
		this.formato= new Formato();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
		this.tipoformatosForeignKey=new ArrayList<TipoFormato>();
	} 
	
	public Formato getFormato() throws Exception {	
		return formato;
	}
		
	public void setFormato(Formato newFormato) {
		this.formato = newFormato;
	}
	
	public List<Formato> getFormatos() throws Exception {		
		return formatos;
	}
	
	public void setFormatos(List<Formato> newFormatos) {
		this.formatos = newFormatos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<TipoMovimiento> gettipomovimientosForeignKey() {
		return this.tipomovimientosForeignKey;
	}

	public List<TipoFormato> gettipoformatosForeignKey() {
		return this.tipoformatosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settipomovimientosForeignKey(List<TipoMovimiento> tipomovimientosForeignKey) {
		this.tipomovimientosForeignKey=tipomovimientosForeignKey;
	}

	public void settipoformatosForeignKey(List<TipoFormato> tipoformatosForeignKey) {
		this.tipoformatosForeignKey=tipoformatosForeignKey;
	}
}

