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
package com.bydan.erp.nomina.util.report;

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
import com.bydan.erp.nomina.util.report.ProcesoIessFondoReservaConstantesFunciones;

import com.bydan.erp.nomina.business.entity.report.*;//ProcesoIessFondoReserva


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


@SuppressWarnings("unused")
public class ProcesoIessFondoReservaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ProcesoIessFondoReserva procesoiessfondoreserva;	
	protected List<ProcesoIessFondoReserva> procesoiessfondoreservas;
	
	
	public List<Anio> aniosForeignKey;
	public List<NumeroPatronal> numeropatronalsForeignKey;
	
	public ProcesoIessFondoReservaParameterReturnGeneral () throws Exception {						
		super();
		this.procesoiessfondoreservas= new ArrayList<ProcesoIessFondoReserva>();
		this.procesoiessfondoreserva= new ProcesoIessFondoReserva();
		
		
		this.aniosForeignKey=new ArrayList<Anio>();
		this.numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
	} 
	
	public ProcesoIessFondoReserva getProcesoIessFondoReserva() throws Exception {	
		return procesoiessfondoreserva;
	}
		
	public void setProcesoIessFondoReserva(ProcesoIessFondoReserva newProcesoIessFondoReserva) {
		this.procesoiessfondoreserva = newProcesoIessFondoReserva;
	}
	
	public List<ProcesoIessFondoReserva> getProcesoIessFondoReservas() throws Exception {		
		return procesoiessfondoreservas;
	}
	
	public void setProcesoIessFondoReservas(List<ProcesoIessFondoReserva> newProcesoIessFondoReservas) {
		this.procesoiessfondoreservas = newProcesoIessFondoReservas;
	}
	
	

	public List<Anio> getaniosForeignKey() {
		return this.aniosForeignKey;
	}

	public List<NumeroPatronal> getnumeropatronalsForeignKey() {
		return this.numeropatronalsForeignKey;
	}
	
	

	public void setaniosForeignKey(List<Anio> aniosForeignKey) {
		this.aniosForeignKey=aniosForeignKey;
	}

	public void setnumeropatronalsForeignKey(List<NumeroPatronal> numeropatronalsForeignKey) {
		this.numeropatronalsForeignKey=numeropatronalsForeignKey;
	}
}

