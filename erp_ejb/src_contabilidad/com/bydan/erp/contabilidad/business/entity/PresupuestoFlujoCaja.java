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
package com.bydan.erp.contabilidad.business.entity;

import java.io.Serializable;
import java.io.File;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.contabilidad.util.PresupuestoFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PresupuestoFlujoCaja extends PresupuestoFlujoCajaAdditional implements Serializable ,Cloneable {//PresupuestoFlujoCajaAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected boolean isNew;
	protected boolean isChanged;
	protected boolean isDeleted;
	protected boolean isSelected;
	protected Date versionRow;
	protected String sType;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		if(this.id!=newId) {
			this.isChanged=true;
		}
		
		this.id=newId;
		super.setId(newId);
	}
	
	
	
	public Date getVersionRow(){
		//ESTO SIEMPRE SE EJECUTA CUANDO SE CONSUME EJB
		return this.versionRow;
	}
	
	public void setVersionRow(Date newVersionRow){
		if(this.versionRow!=newVersionRow){
			//LE COMENTO PORQUE CUANDO HAGO GET SIEMPRE POR ESTO LE PONE isChanged=true
			//this.isChanged=true;
		}
		
		this.versionRow=newVersionRow;
		super.setVersionRow(newVersionRow);
	}
	
	
	public boolean getIsNew() {
		return this.isNew;
	}
	
	public void setIsNew(boolean newIsNew) {
		this.isNew=newIsNew;
		super.setIsNew(newIsNew);
	}
	
	public boolean getIsChanged() {
		return this.isChanged;
	}
	
	public void setIsChanged(boolean newIsChanged) {
		this.isChanged=newIsChanged;
		super.setIsChanged(newIsChanged);
	}
	
	public boolean getIsDeleted() {
		return this.isDeleted;
	}
	
	public void setIsDeleted(boolean newIsDeleted) {
		this.isDeleted=newIsDeleted;
		super.setIsDeleted(newIsDeleted);
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public void setIsSelected(boolean newIsSelected) {
		this.isSelected=newIsSelected;
		super.setIsSelected(newIsSelected);
	}
	
	public String getsType() {
		return this.sType;
	}
	
	public void setsType(String sType) {
		this.sType=sType;
		super.setsType(sType);
	}
	
	private PresupuestoFlujoCaja presupuestoflujocajaOriginal;
	
	private Map<String, Object> mapPresupuestoFlujoCaja;
			
	public Map<String, Object> getMapPresupuestoFlujoCaja() {
		return mapPresupuestoFlujoCaja;
	}

	public void setMapPresupuestoFlujoCaja(Map<String, Object> mapPresupuestoFlujoCaja) {
		this.mapPresupuestoFlujoCaja = mapPresupuestoFlujoCaja;
	}
	
	public void inicializarMapPresupuestoFlujoCaja() {
		this.mapPresupuestoFlujoCaja = new HashMap<String,Object>();
	}
	
	public void setMapPresupuestoFlujoCajaValue(String sKey,Object oValue) {
		this.mapPresupuestoFlujoCaja.put(sKey, oValue);
	}
	
	public Object getMapPresupuestoFlujoCajaValue(String sKey) {
		return this.mapPresupuestoFlujoCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_efectivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_presupuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_proceso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresupuestoFlujoCajaConstantesFunciones.SREGEXOBSERVACION,message=PresupuestoFlujoCajaConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public CuentaContable cuentacontable;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public CentroCosto centrocosto;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String cuentacontable_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String centrocosto_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public PresupuestoFlujoCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presupuestoflujocajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cuenta_contable=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_centro_costo=null;
 		this.valor=0.0;
 		this.valor_efectivo=0.0;
 		this.porcentaje=0.0;
 		this.fecha_presupuesto=new Date();
 		this.fecha_proceso=new Date();
 		this.observacion="";
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.cuentacontable=null;
		this.ejercicio=null;
		this.periodo=null;
		this.centrocosto=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.cuentacontable_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.centrocosto_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresupuestoFlujoCaja (Long id,Date versionRow,Long id_empresa,Long id_cuenta_contable,Long id_ejercicio,Long id_periodo,Long id_centro_costo,Double valor,Double valor_efectivo,Double porcentaje,Date fecha_presupuesto,Date fecha_proceso,String observacion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestoflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_centro_costo=id_centro_costo;
 		this.valor=valor;
 		this.valor_efectivo=valor_efectivo;
 		this.porcentaje=porcentaje;
 		this.fecha_presupuesto=fecha_presupuesto;
 		this.fecha_proceso=fecha_proceso;
 		this.observacion=observacion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresupuestoFlujoCaja (Long id_empresa,Long id_cuenta_contable,Long id_ejercicio,Long id_periodo,Long id_centro_costo,Double valor,Double valor_efectivo,Double porcentaje,Date fecha_presupuesto,Date fecha_proceso,String observacion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presupuestoflujocajaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_centro_costo=id_centro_costo;
 		this.valor=valor;
 		this.valor_efectivo=valor_efectivo;
 		this.porcentaje=porcentaje;
 		this.fecha_presupuesto=fecha_presupuesto;
 		this.fecha_proceso=fecha_proceso;
 		this.observacion=observacion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresupuestoFlujoCaja presupuestoflujocajaLocal=null;
		
		if(object!=null) {
			presupuestoflujocajaLocal=(PresupuestoFlujoCaja)object;
			
			if(presupuestoflujocajaLocal!=null) {
				if(this.getId()!=null && presupuestoflujocajaLocal.getId()!=null) {
					if(this.getId().equals(presupuestoflujocajaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresupuestoFlujoCajaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresupuestoFlujoCajaConstantesFunciones.getPresupuestoFlujoCajaDescripcion(this);
		} else {
			sDetalle=PresupuestoFlujoCajaConstantesFunciones.getPresupuestoFlujoCajaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresupuestoFlujoCaja getPresupuestoFlujoCajaOriginal() {
		return this.presupuestoflujocajaOriginal;
	}
	
	public void setPresupuestoFlujoCajaOriginal(PresupuestoFlujoCaja presupuestoflujocaja) {
		try {
			this.presupuestoflujocajaOriginal=presupuestoflujocaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresupuestoFlujoCajaAdditional presupuestoflujocajaAdditional=null;
	
	public PresupuestoFlujoCajaAdditional getPresupuestoFlujoCajaAdditional() {
		return this.presupuestoflujocajaAdditional;
	}
	
	public void setPresupuestoFlujoCajaAdditional(PresupuestoFlujoCajaAdditional presupuestoflujocajaAdditional) {
		try {
			this.presupuestoflujocajaAdditional=presupuestoflujocajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getvalor_efectivo() {
		return this.valor_efectivo;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Date getfecha_presupuesto() {
		return this.fecha_presupuesto;
	}
    
	
	public Date getfecha_proceso() {
		return this.fecha_proceso;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_efectivo(Double newvalor_efectivo)throws Exception
	{
		try {
			if(this.valor_efectivo!=newvalor_efectivo) {
				if(newvalor_efectivo==null) {
					//newvalor_efectivo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna valor_efectivo");
					}
				}

				this.valor_efectivo=newvalor_efectivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_presupuesto(Date newfecha_presupuesto)throws Exception
	{
		try {
			if(this.fecha_presupuesto!=newfecha_presupuesto) {
				if(newfecha_presupuesto==null) {
					//newfecha_presupuesto=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna fecha_presupuesto");
					}
				}

				this.fecha_presupuesto=newfecha_presupuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_proceso(Date newfecha_proceso)throws Exception
	{
		try {
			if(this.fecha_proceso!=newfecha_proceso) {
				if(newfecha_proceso==null) {
					//newfecha_proceso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna fecha_proceso");
					}
				}

				this.fecha_proceso=newfecha_proceso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresupuestoFlujoCaja:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>150) {
					newobservacion=newobservacion.substring(0,148);
					System.out.println("PresupuestoFlujoCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cuenta_contable_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_centro_costo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cuenta_contable_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_centro_costo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

