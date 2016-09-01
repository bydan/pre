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
package com.bydan.erp.inventario.util;

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
import com.bydan.erp.inventario.util.LineaConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//Linea


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class LineaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Linea linea;	
	protected List<Linea> lineas;
	
	
	public List<Empresa> empresasForeignKey;
	public List<NivelLinea> nivellineasForeignKey;
	public List<Linea> lineasForeignKey;
	
	public LineaParameterReturnGeneral () throws Exception {						
		super();
		this.lineas= new ArrayList<Linea>();
		this.linea= new Linea();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.nivellineasForeignKey=new ArrayList<NivelLinea>();
		this.lineasForeignKey=new ArrayList<Linea>();
	} 
	
	public Linea getLinea() throws Exception {	
		return linea;
	}
		
	public void setLinea(Linea newLinea) {
		this.linea = newLinea;
	}
	
	public List<Linea> getLineas() throws Exception {		
		return lineas;
	}
	
	public void setLineas(List<Linea> newLineas) {
		this.lineas = newLineas;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<NivelLinea> getnivellineasForeignKey() {
		return this.nivellineasForeignKey;
	}

	public List<Linea> getlineasForeignKey() {
		return this.lineasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setnivellineasForeignKey(List<NivelLinea> nivellineasForeignKey) {
		this.nivellineasForeignKey=nivellineasForeignKey;
	}

	public void setlineasForeignKey(List<Linea> lineasForeignKey) {
		this.lineasForeignKey=lineasForeignKey;
	}
}

