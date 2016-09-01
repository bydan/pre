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
import com.bydan.erp.nomina.util.DatoGeneralEmpleadoConstantesFunciones;

import com.bydan.erp.nomina.business.entity.*;//DatoGeneralEmpleado


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


@SuppressWarnings("unused")
public class DatoGeneralEmpleadoParameterReturnGeneral extends GeneralEntityParameterReturnGeneral implements Serializable {
	private static final long serialVersionUID=1L;
		
	protected DatoGeneralEmpleado datogeneralempleado;	
	protected List<DatoGeneralEmpleado> datogeneralempleados;
	
	
	public List<Empleado> empleadosForeignKey;
	public List<NumeroPatronal> numeropatronalsForeignKey;
	public List<TipoAfiliacion> tipoafiliacionsForeignKey;
	public List<Pais> paissForeignKey;
	public List<Provincia> provinciasForeignKey;
	public List<Canton> cantonsForeignKey;
	public List<Parroquia> parroquiasForeignKey;
	public List<Moneda> monedasForeignKey;
	public List<TipoContrato> tipocontratosForeignKey;
	public List<TipoLibretaMili> tipolibretamilisForeignKey;
	public List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey;
	public List<Banco> bancosForeignKey;
	public List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey;
	public List<TipoSangre> tiposangresForeignKey;
	
	public DatoGeneralEmpleadoParameterReturnGeneral () throws Exception {						
		super();
		this.datogeneralempleados= new ArrayList<DatoGeneralEmpleado>();
		this.datogeneralempleado= new DatoGeneralEmpleado();
		
		
		this.empleadosForeignKey=new ArrayList<Empleado>();
		this.numeropatronalsForeignKey=new ArrayList<NumeroPatronal>();
		this.tipoafiliacionsForeignKey=new ArrayList<TipoAfiliacion>();
		this.paissForeignKey=new ArrayList<Pais>();
		this.provinciasForeignKey=new ArrayList<Provincia>();
		this.cantonsForeignKey=new ArrayList<Canton>();
		this.parroquiasForeignKey=new ArrayList<Parroquia>();
		this.monedasForeignKey=new ArrayList<Moneda>();
		this.tipocontratosForeignKey=new ArrayList<TipoContrato>();
		this.tipolibretamilisForeignKey=new ArrayList<TipoLibretaMili>();
		this.tipogrupoformapagosForeignKey=new ArrayList<TipoGrupoFormaPago>();
		this.bancosForeignKey=new ArrayList<Banco>();
		this.tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
		this.tiposangresForeignKey=new ArrayList<TipoSangre>();
	} 
	
	public DatoGeneralEmpleado getDatoGeneralEmpleado() throws Exception {	
		return datogeneralempleado;
	}
		
	public void setDatoGeneralEmpleado(DatoGeneralEmpleado newDatoGeneralEmpleado) {
		this.datogeneralempleado = newDatoGeneralEmpleado;
	}
	
	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() throws Exception {		
		return datogeneralempleados;
	}
	
	public void setDatoGeneralEmpleados(List<DatoGeneralEmpleado> newDatoGeneralEmpleados) {
		this.datogeneralempleados = newDatoGeneralEmpleados;
	}
	
	

	public List<Empleado> getempleadosForeignKey() {
		return this.empleadosForeignKey;
	}

	public List<NumeroPatronal> getnumeropatronalsForeignKey() {
		return this.numeropatronalsForeignKey;
	}

	public List<TipoAfiliacion> gettipoafiliacionsForeignKey() {
		return this.tipoafiliacionsForeignKey;
	}

	public List<Pais> getpaissForeignKey() {
		return this.paissForeignKey;
	}

	public List<Provincia> getprovinciasForeignKey() {
		return this.provinciasForeignKey;
	}

	public List<Canton> getcantonsForeignKey() {
		return this.cantonsForeignKey;
	}

	public List<Parroquia> getparroquiasForeignKey() {
		return this.parroquiasForeignKey;
	}

	public List<Moneda> getmonedasForeignKey() {
		return this.monedasForeignKey;
	}

	public List<TipoContrato> gettipocontratosForeignKey() {
		return this.tipocontratosForeignKey;
	}

	public List<TipoLibretaMili> gettipolibretamilisForeignKey() {
		return this.tipolibretamilisForeignKey;
	}

	public List<TipoGrupoFormaPago> gettipogrupoformapagosForeignKey() {
		return this.tipogrupoformapagosForeignKey;
	}

	public List<Banco> getbancosForeignKey() {
		return this.bancosForeignKey;
	}

	public List<TipoCuentaBancoGlobal> gettipocuentabancoglobalsForeignKey() {
		return this.tipocuentabancoglobalsForeignKey;
	}

	public List<TipoSangre> gettiposangresForeignKey() {
		return this.tiposangresForeignKey;
	}
	
	

	public void setempleadosForeignKey(List<Empleado> empleadosForeignKey) {
		this.empleadosForeignKey=empleadosForeignKey;
	}

	public void setnumeropatronalsForeignKey(List<NumeroPatronal> numeropatronalsForeignKey) {
		this.numeropatronalsForeignKey=numeropatronalsForeignKey;
	}

	public void settipoafiliacionsForeignKey(List<TipoAfiliacion> tipoafiliacionsForeignKey) {
		this.tipoafiliacionsForeignKey=tipoafiliacionsForeignKey;
	}

	public void setpaissForeignKey(List<Pais> paissForeignKey) {
		this.paissForeignKey=paissForeignKey;
	}

	public void setprovinciasForeignKey(List<Provincia> provinciasForeignKey) {
		this.provinciasForeignKey=provinciasForeignKey;
	}

	public void setcantonsForeignKey(List<Canton> cantonsForeignKey) {
		this.cantonsForeignKey=cantonsForeignKey;
	}

	public void setparroquiasForeignKey(List<Parroquia> parroquiasForeignKey) {
		this.parroquiasForeignKey=parroquiasForeignKey;
	}

	public void setmonedasForeignKey(List<Moneda> monedasForeignKey) {
		this.monedasForeignKey=monedasForeignKey;
	}

	public void settipocontratosForeignKey(List<TipoContrato> tipocontratosForeignKey) {
		this.tipocontratosForeignKey=tipocontratosForeignKey;
	}

	public void settipolibretamilisForeignKey(List<TipoLibretaMili> tipolibretamilisForeignKey) {
		this.tipolibretamilisForeignKey=tipolibretamilisForeignKey;
	}

	public void settipogrupoformapagosForeignKey(List<TipoGrupoFormaPago> tipogrupoformapagosForeignKey) {
		this.tipogrupoformapagosForeignKey=tipogrupoformapagosForeignKey;
	}

	public void setbancosForeignKey(List<Banco> bancosForeignKey) {
		this.bancosForeignKey=bancosForeignKey;
	}

	public void settipocuentabancoglobalsForeignKey(List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey) {
		this.tipocuentabancoglobalsForeignKey=tipocuentabancoglobalsForeignKey;
	}

	public void settiposangresForeignKey(List<TipoSangre> tiposangresForeignKey) {
		this.tiposangresForeignKey=tiposangresForeignKey;
	}
}

