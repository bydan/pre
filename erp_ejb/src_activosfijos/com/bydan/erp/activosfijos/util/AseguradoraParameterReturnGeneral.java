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
package com.bydan.erp.activosfijos.util;

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
import com.bydan.erp.activosfijos.util.AseguradoraConstantesFunciones;

import com.bydan.erp.activosfijos.business.entity.*;//Aseguradora


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


@SuppressWarnings("unused")
public class AseguradoraParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Aseguradora aseguradora;	
	protected List<Aseguradora> aseguradoras;
	
	
	public List<Empresa> empresasForeignKey;
	
	public AseguradoraParameterReturnGeneral () throws Exception {						
		super();
		this.aseguradoras= new ArrayList<Aseguradora>();
		this.aseguradora= new Aseguradora();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public Aseguradora getAseguradora() throws Exception {	
		return aseguradora;
	}
		
	public void setAseguradora(Aseguradora newAseguradora) {
		this.aseguradora = newAseguradora;
	}
	
	public List<Aseguradora> getAseguradoras() throws Exception {		
		return aseguradoras;
	}
	
	public void setAseguradoras(List<Aseguradora> newAseguradoras) {
		this.aseguradoras = newAseguradoras;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

