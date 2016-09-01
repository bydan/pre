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
import com.bydan.erp.nomina.util.AbonoPrestamoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//AbonoPrestamo




@SuppressWarnings("unused")
public class AbonoPrestamoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected AbonoPrestamo abonoprestamo;	
	protected List<AbonoPrestamo> abonoprestamos;
	
	
	public List<Prestamo> prestamosForeignKey;
	
	public AbonoPrestamoParameterReturnGeneral () throws Exception {						
		super();
		this.abonoprestamos= new ArrayList<AbonoPrestamo>();
		this.abonoprestamo= new AbonoPrestamo();
		
		
		this.prestamosForeignKey=new ArrayList<Prestamo>();
	} 
	
	public AbonoPrestamo getAbonoPrestamo() throws Exception {	
		return abonoprestamo;
	}
		
	public void setAbonoPrestamo(AbonoPrestamo newAbonoPrestamo) {
		this.abonoprestamo = newAbonoPrestamo;
	}
	
	public List<AbonoPrestamo> getAbonoPrestamos() throws Exception {		
		return abonoprestamos;
	}
	
	public void setAbonoPrestamos(List<AbonoPrestamo> newAbonoPrestamos) {
		this.abonoprestamos = newAbonoPrestamos;
	}
	
	

	public List<Prestamo> getprestamosForeignKey() {
		return this.prestamosForeignKey;
	}
	
	

	public void setprestamosForeignKey(List<Prestamo> prestamosForeignKey) {
		this.prestamosForeignKey=prestamosForeignKey;
	}
}

