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
package com.bydan.erp.puntoventa.util;

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
import com.bydan.erp.puntoventa.util.ReciboPuntoVentaConstantesFunciones;

import com.bydan.erp.puntoventa.business.entity.*;//ReciboPuntoVenta


import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ReciboPuntoVentaParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ReciboPuntoVenta recibopuntoventa;	
	protected List<ReciboPuntoVenta> recibopuntoventas;
	
	
	public List<Cliente> clientesForeignKey;
	public List<Banco> bancosForeignKey;
	
	public ReciboPuntoVentaParameterReturnGeneral () throws Exception {						
		super();
		this.recibopuntoventas= new ArrayList<ReciboPuntoVenta>();
		this.recibopuntoventa= new ReciboPuntoVenta();
		
		
		this.clientesForeignKey=new ArrayList<Cliente>();
		this.bancosForeignKey=new ArrayList<Banco>();
	} 
	
	public ReciboPuntoVenta getReciboPuntoVenta() throws Exception {	
		return recibopuntoventa;
	}
		
	public void setReciboPuntoVenta(ReciboPuntoVenta newReciboPuntoVenta) {
		this.recibopuntoventa = newReciboPuntoVenta;
	}
	
	public List<ReciboPuntoVenta> getReciboPuntoVentas() throws Exception {		
		return recibopuntoventas;
	}
	
	public void setReciboPuntoVentas(List<ReciboPuntoVenta> newReciboPuntoVentas) {
		this.recibopuntoventas = newReciboPuntoVentas;
	}
	
	

	public List<Cliente> getclientesForeignKey() {
		return this.clientesForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}
	
	

	public void setclientesForeignKey(List<Cliente> clientesForeignKey) {
		this.clientesForeignKey=clientesForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}
}

