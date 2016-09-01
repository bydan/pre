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
package com.bydan.erp.importaciones.util;

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
import com.bydan.erp.importaciones.util.ParametroImporConstantesFunciones;

import com.bydan.erp.importaciones.business.entity.*;//ParametroImpor


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class ParametroImporParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected ParametroImpor parametroimpor;	
	protected List<ParametroImpor> parametroimpors;
	
	
	public List<Empresa> empresasForeignKey;
	public List<Pais> paissForeignKey;
	public List<Bodega> bodegasForeignKey;
	public List<CentroCosto> centrocostosForeignKey;
	public List<CuentaContable> cuentacontablesForeignKey;
	public List<Transaccion> transaccionordencomprasForeignKey;
	public List<Transaccion> transaccioningresosForeignKey;
	public List<Formato> formatoordencomprasForeignKey;
	public List<Formato> formatoingresosForeignKey;
	public List<Formato> formatopedidosForeignKey;
	public List<Formato> formatoliquidacionsForeignKey;
	
	public ParametroImporParameterReturnGeneral () throws Exception {						
		super();
		this.parametroimpors= new ArrayList<ParametroImpor>();
		this.parametroimpor= new ParametroImpor();
		
		
		this.empresasForeignKey=new ArrayList<Empresa>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.bodegasForeignKey=new ArrayList<Bodega>();
		this.centrocostosForeignKey=new ArrayList<CentroCosto>();
		this.cuentacontablesForeignKey=new ArrayList<CuentaContable>();
		this.transaccionordencomprasForeignKey=new ArrayList<Transaccion>();
		this.transaccioningresosForeignKey=new ArrayList<Transaccion>();
		this.formatoordencomprasForeignKey=new ArrayList<Formato>();
		this.formatoingresosForeignKey=new ArrayList<Formato>();
		this.formatopedidosForeignKey=new ArrayList<Formato>();
		this.formatoliquidacionsForeignKey=new ArrayList<Formato>();
	} 
	
	public ParametroImpor getParametroImpor() throws Exception {	
		return parametroimpor;
	}
		
	public void setParametroImpor(ParametroImpor newParametroImpor) {
		this.parametroimpor = newParametroImpor;
	}
	
	public List<ParametroImpor> getParametroImpors() throws Exception {		
		return parametroimpors;
	}
	
	public void setParametroImpors(List<ParametroImpor> newParametroImpors) {
		this.parametroimpors = newParametroImpors;
	}
	
	

	public List<Empresa> getempresasForeignKey() {
		return this.empresasForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Bodega> getbodegasForeignKey() {
		return this.bodegasForeignKey;
	}

	public List<CentroCosto> getcentrocostosForeignKey() {
		return this.centrocostosForeignKey;
	}

	public List<CuentaContable> getcuentacontablesForeignKey() {
		return this.cuentacontablesForeignKey;
	}

	public List<Transaccion> gettransaccionordencomprasForeignKey() {
		return this.transaccionordencomprasForeignKey;
	}

	public List<Transaccion> gettransaccioningresosForeignKey() {
		return this.transaccioningresosForeignKey;
	}

	public List<Formato> getformatoordencomprasForeignKey() {
		return this.formatoordencomprasForeignKey;
	}

	public List<Formato> getformatoingresosForeignKey() {
		return this.formatoingresosForeignKey;
	}

	public List<Formato> getformatopedidosForeignKey() {
		return this.formatopedidosForeignKey;
	}

	public List<Formato> getformatoliquidacionsForeignKey() {
		return this.formatoliquidacionsForeignKey;
	}
	
	

	public void setempresasForeignKey(List<Empresa> empresasForeignKey) {
		this.empresasForeignKey=empresasForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setbodegasForeignKey(List<Bodega> bodegasForeignKey) {
		this.bodegasForeignKey=bodegasForeignKey;
	}

	public void setcentrocostosForeignKey(List<CentroCosto> centrocostosForeignKey) {
		this.centrocostosForeignKey=centrocostosForeignKey;
	}

	public void setcuentacontablesForeignKey(List<CuentaContable> cuentacontablesForeignKey) {
		this.cuentacontablesForeignKey=cuentacontablesForeignKey;
	}

	public void settransaccionordencomprasForeignKey(List<Transaccion> transaccionordencomprasForeignKey) {
		this.transaccionordencomprasForeignKey=transaccionordencomprasForeignKey;
	}

	public void settransaccioningresosForeignKey(List<Transaccion> transaccioningresosForeignKey) {
		this.transaccioningresosForeignKey=transaccioningresosForeignKey;
	}

	public void setformatoordencomprasForeignKey(List<Formato> formatoordencomprasForeignKey) {
		this.formatoordencomprasForeignKey=formatoordencomprasForeignKey;
	}

	public void setformatoingresosForeignKey(List<Formato> formatoingresosForeignKey) {
		this.formatoingresosForeignKey=formatoingresosForeignKey;
	}

	public void setformatopedidosForeignKey(List<Formato> formatopedidosForeignKey) {
		this.formatopedidosForeignKey=formatopedidosForeignKey;
	}

	public void setformatoliquidacionsForeignKey(List<Formato> formatoliquidacionsForeignKey) {
		this.formatoliquidacionsForeignKey=formatoliquidacionsForeignKey;
	}
}

