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
import com.bydan.erp.nomina.util.CuotaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//Cuota




@SuppressWarnings("unused")
public class CuotaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected Cuota cuota;	
	protected List<Cuota> cuotas;
	
	
	public List<Prestamo> prestamosForeignKey;
	public List<EstadoCuota> estadocuotasForeignKey;
	public List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey;
	
	public CuotaParameterReturnGeneral () throws Exception {						
		super();
		this.cuotas= new ArrayList<Cuota>();
		this.cuota= new Cuota();
		
		
		this.prestamosForeignKey=new ArrayList<Prestamo>();
		this.estadocuotasForeignKey=new ArrayList<EstadoCuota>();
		this.defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
	} 
	
	public Cuota getCuota() throws Exception {	
		return cuota;
	}
		
	public void setCuota(Cuota newCuota) {
		this.cuota = newCuota;
	}
	
	public List<Cuota> getCuotas() throws Exception {		
		return cuotas;
	}
	
	public void setCuotas(List<Cuota> newCuotas) {
		this.cuotas = newCuotas;
	}
	
	

	public List<Prestamo> getprestamosForeignKey() {
		return this.prestamosForeignKey;
	}

	public List<EstadoCuota> getestadocuotasForeignKey() {
		return this.estadocuotasForeignKey;
	}

	public List<DefiProvisionEmpleado> getdefiprovisionempleadosForeignKey() {
		return this.defiprovisionempleadosForeignKey;
	}
	
	

	public void setprestamosForeignKey(List<Prestamo> prestamosForeignKey) {
		this.prestamosForeignKey=prestamosForeignKey;
	}

	public void setestadocuotasForeignKey(List<EstadoCuota> estadocuotasForeignKey) {
		this.estadocuotasForeignKey=estadocuotasForeignKey;
	}

	public void setdefiprovisionempleadosForeignKey(List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey) {
		this.defiprovisionempleadosForeignKey=defiprovisionempleadosForeignKey;
	}
}

