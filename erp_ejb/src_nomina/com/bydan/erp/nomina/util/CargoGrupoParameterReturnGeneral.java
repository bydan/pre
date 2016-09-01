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
import com.bydan.erp.nomina.util.CargoGrupoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//CargoGrupo


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


@SuppressWarnings("unused")
public class CargoGrupoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected CargoGrupo cargogrupo;	
	protected List<CargoGrupo> cargogrupos;
	
	
	public List<Empresa> empresasForeignKey;
	
	public CargoGrupoParameterReturnGeneral () throws Exception {						
		super();
		this.cargogrupos= new ArrayList<CargoGrupo>();
		this.cargogrupo= new CargoGrupo();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
	} 
	
	public CargoGrupo getCargoGrupo() throws Exception {	
		return cargogrupo;
	}
		
	public void setCargoGrupo(CargoGrupo newCargoGrupo) {
		this.cargogrupo = newCargoGrupo;
	}
	
	public List<CargoGrupo> getCargoGrupos() throws Exception {		
		return cargogrupos;
	}
	
	public void setCargoGrupos(List<CargoGrupo> newCargoGrupos) {
		this.cargogrupos = newCargoGrupos;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}
}

