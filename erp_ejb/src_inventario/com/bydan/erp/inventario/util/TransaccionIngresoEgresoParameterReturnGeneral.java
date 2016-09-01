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
import com.bydan.erp.inventario.util.TransaccionIngresoEgresoConstantesFunciones;

import com.bydan.erp.inventario.business.entity.*;//TransaccionIngresoEgreso


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class TransaccionIngresoEgresoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TransaccionIngresoEgreso transaccioningresoegreso;	
	protected List<TransaccionIngresoEgreso> transaccioningresoegresos;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Modulo> modulosForeignKey;
	public List<Transaccion> transaccionsForeignKey;
	
	public TransaccionIngresoEgresoParameterReturnGeneral () throws Exception {						
		super();
		this.transaccioningresoegresos= new ArrayList<TransaccionIngresoEgreso>();
		this.transaccioningresoegreso= new TransaccionIngresoEgreso();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.modulosForeignKey=new ArrayList<Modulo>();
		this.transaccionsForeignKey=new ArrayList<Transaccion>();
	} 
	
	public TransaccionIngresoEgreso getTransaccionIngresoEgreso() throws Exception {	
		return transaccioningresoegreso;
	}
		
	public void setTransaccionIngresoEgreso(TransaccionIngresoEgreso newTransaccionIngresoEgreso) {
		this.transaccioningresoegreso = newTransaccionIngresoEgreso;
	}
	
	public List<TransaccionIngresoEgreso> getTransaccionIngresoEgresos() throws Exception {		
		return transaccioningresoegresos;
	}
	
	public void setTransaccionIngresoEgresos(List<TransaccionIngresoEgreso> newTransaccionIngresoEgresos) {
		this.transaccioningresoegresos = newTransaccionIngresoEgresos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Modulo> getmodulosForeignKey() {
		return this.modulosForeignKey;
	}

	public List<Transaccion> gettransaccionsForeignKey() {
		return this.transaccionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setmodulosForeignKey(List<Modulo> modulosForeignKey) {
		this.modulosForeignKey=modulosForeignKey;
	}

	public void settransaccionsForeignKey(List<Transaccion> transaccionsForeignKey) {
		this.transaccionsForeignKey=transaccionsForeignKey;
	}
}

