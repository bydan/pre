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
package com.bydan.erp.cartera.util.report;

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
import com.bydan.erp.cartera.util.report.CobrarSaldosVencidosConstantesFunciones;

import com.bydan.erp.cartera.business.entity.report.*;//CobrarSaldosVencidos


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


@SuppressWarnings("unused")
public class CobrarSaldosVencidosParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CobrarSaldosVencidos cobrarsaldosvencidos;	
	protected List<CobrarSaldosVencidos> cobrarsaldosvencidoss;
	
	
	public List<GrupoCliente> grupoclientesForeignKey;
	public List<Empresa> empresasForeignKey;
	
	public CobrarSaldosVencidosParameterReturnGeneral () throws Exception {						
		super();
		this.cobrarsaldosvencidoss= new ArrayList<CobrarSaldosVencidos>();
		this.cobrarsaldosvencidos= new CobrarSaldosVencidos();
		
		
		this.grupoclientesForeignKey=new ArrayList<GrupoCliente>();
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public CobrarSaldosVencidos getCobrarSaldosVencidos() throws Exception {	
		return cobrarsaldosvencidos;
	}
		
	public void setCobrarSaldosVencidos(CobrarSaldosVencidos newCobrarSaldosVencidos) {
		this.cobrarsaldosvencidos = newCobrarSaldosVencidos;
	}
	
	public List<CobrarSaldosVencidos> getCobrarSaldosVencidoss() throws Exception {		
		return cobrarsaldosvencidoss;
	}
	
	public void setCobrarSaldosVencidoss(List<CobrarSaldosVencidos> newCobrarSaldosVencidoss) {
		this.cobrarsaldosvencidoss = newCobrarSaldosVencidoss;
	}
	
	

	public List<GrupoCliente> getgrupoclientesForeignKey() {
		return this.grupoclientesForeignKey;
	}

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setgrupoclientesForeignKey(List<GrupoCliente> grupoclientesForeignKey) {
		this.grupoclientesForeignKey=grupoclientesForeignKey;
	}

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

