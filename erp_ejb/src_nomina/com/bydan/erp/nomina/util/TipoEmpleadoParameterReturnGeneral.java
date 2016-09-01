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
package com.bydan.erp.nomina.util;

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
import com.bydan.erp.nomina.util.TipoEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//TipoEmpleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class TipoEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TipoEmpleado tipoempleado;	
	protected List<TipoEmpleado> tipoempleados;
	
	
	public List<Empresa> empresasForeignKey;
	
	public TipoEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.tipoempleados= new ArrayList<TipoEmpleado>();
		this.tipoempleado= new TipoEmpleado();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public TipoEmpleado getTipoEmpleado() throws Exception {	
		return tipoempleado;
	}
		
	public void setTipoEmpleado(TipoEmpleado newTipoEmpleado) {
		this.tipoempleado = newTipoEmpleado;
	}
	
	public List<TipoEmpleado> getTipoEmpleados() throws Exception {		
		return tipoempleados;
	}
	
	public void setTipoEmpleados(List<TipoEmpleado> newTipoEmpleados) {
		this.tipoempleados = newTipoEmpleados;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

