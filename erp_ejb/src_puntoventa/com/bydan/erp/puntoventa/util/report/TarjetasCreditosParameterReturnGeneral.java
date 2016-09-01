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
package com.bydan.erp.puntoventa.util.report;

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
import com.bydan.erp.puntoventa.util.report.TarjetasCreditosConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.report.*;//TarjetasCreditos


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;


@SuppressWarnings("unused")
public class TarjetasCreditosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected TarjetasCreditos tarjetascreditos;	
	protected List<TarjetasCreditos> tarjetascreditoss;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Sucursal> sucursalsForeignKey;
	public List<TarjetaCredito> tarjetacreditosForeignKey;
	
	public TarjetasCreditosParameterReturnGeneral () throws Exception {						
		super();
		this.tarjetascreditoss= new ArrayList<TarjetasCreditos>();
		this.tarjetascreditos= new TarjetasCreditos();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.sucursalsForeignKey=new ArrayList<Sucursal>();
		this.tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
	} 
	
	public TarjetasCreditos getTarjetasCreditos() throws Exception {	
		return tarjetascreditos;
	}
		
	public void setTarjetasCreditos(TarjetasCreditos newTarjetasCreditos) {
		this.tarjetascreditos = newTarjetasCreditos;
	}
	
	public List<TarjetasCreditos> getTarjetasCreditoss() throws Exception {		
		return tarjetascreditoss;
	}
	
	public void setTarjetasCreditoss(List<TarjetasCreditos> newTarjetasCreditoss) {
		this.tarjetascreditoss = newTarjetasCreditoss;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Sucursal> getsucursalsForeignKey() {
		return this.sucursalsForeignKey;
	}

	public List<TarjetaCredito> gettarjetacreditosForeignKey() {
		return this.tarjetacreditosForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setsucursalsForeignKey(List<Sucursal> sucursalsForeignKey) {
		this.sucursalsForeignKey=sucursalsForeignKey;
	}

	public void settarjetacreditosForeignKey(List<TarjetaCredito> tarjetacreditosForeignKey) {
		this.tarjetacreditosForeignKey=tarjetacreditosForeignKey;
	}
}

