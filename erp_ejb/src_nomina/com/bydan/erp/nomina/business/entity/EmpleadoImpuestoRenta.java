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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.EmpleadoImpuestoRentaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EmpleadoImpuestoRenta extends EmpleadoImpuestoRentaAdditional implements Serializable ,Cloneable {//EmpleadoImpuestoRentaAdditional,GeneralEntity
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
	
	private EmpleadoImpuestoRenta empleadoimpuestorentaOriginal;
	
	private Map<String, Object> mapEmpleadoImpuestoRenta;
			
	public Map<String, Object> getMapEmpleadoImpuestoRenta() {
		return mapEmpleadoImpuestoRenta;
	}

	public void setMapEmpleadoImpuestoRenta(Map<String, Object> mapEmpleadoImpuestoRenta) {
		this.mapEmpleadoImpuestoRenta = mapEmpleadoImpuestoRenta;
	}
	
	public void inicializarMapEmpleadoImpuestoRenta() {
		this.mapEmpleadoImpuestoRenta = new HashMap<String,Object>();
	}
	
	public void setMapEmpleadoImpuestoRentaValue(String sKey,Object oValue) {
		this.mapEmpleadoImpuestoRenta.put(sKey, oValue);
	}
	
	public Object getMapEmpleadoImpuestoRentaValue(String sKey) {
		return this.mapEmpleadoImpuestoRenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso_liquido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double aporte_iess;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Anio anio;
	public Mes mes;
	public Estructura estructura;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String estructura_descripcion;
	
	
		
	public EmpleadoImpuestoRenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empleadoimpuestorentaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_estructura=-1L;
 		this.fecha=new Date();
 		this.valor_pago=0.0;
 		this.ingreso_liquido=0.0;
 		this.aporte_iess=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.anio=null;
		this.mes=null;
		this.estructura=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.estructura_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EmpleadoImpuestoRenta (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_anio,Long id_mes,Long id_estructura,Date fecha,Double valor_pago,Double ingreso_liquido,Double aporte_iess) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoimpuestorentaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_estructura=id_estructura;
 		this.fecha=fecha;
 		this.valor_pago=valor_pago;
 		this.ingreso_liquido=ingreso_liquido;
 		this.aporte_iess=aporte_iess;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EmpleadoImpuestoRenta (Long id_empresa,Long id_empleado,Long id_anio,Long id_mes,Long id_estructura,Date fecha,Double valor_pago,Double ingreso_liquido,Double aporte_iess) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empleadoimpuestorentaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_estructura=id_estructura;
 		this.fecha=fecha;
 		this.valor_pago=valor_pago;
 		this.ingreso_liquido=ingreso_liquido;
 		this.aporte_iess=aporte_iess;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EmpleadoImpuestoRenta empleadoimpuestorentaLocal=null;
		
		if(object!=null) {
			empleadoimpuestorentaLocal=(EmpleadoImpuestoRenta)object;
			
			if(empleadoimpuestorentaLocal!=null) {
				if(this.getId()!=null && empleadoimpuestorentaLocal.getId()!=null) {
					if(this.getId().equals(empleadoimpuestorentaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpleadoImpuestoRentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpleadoImpuestoRentaConstantesFunciones.getEmpleadoImpuestoRentaDescripcion(this);
		} else {
			sDetalle=EmpleadoImpuestoRentaConstantesFunciones.getEmpleadoImpuestoRentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EmpleadoImpuestoRenta getEmpleadoImpuestoRentaOriginal() {
		return this.empleadoimpuestorentaOriginal;
	}
	
	public void setEmpleadoImpuestoRentaOriginal(EmpleadoImpuestoRenta empleadoimpuestorenta) {
		try {
			this.empleadoimpuestorentaOriginal=empleadoimpuestorenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpleadoImpuestoRentaAdditional empleadoimpuestorentaAdditional=null;
	
	public EmpleadoImpuestoRentaAdditional getEmpleadoImpuestoRentaAdditional() {
		return this.empleadoimpuestorentaAdditional;
	}
	
	public void setEmpleadoImpuestoRentaAdditional(EmpleadoImpuestoRentaAdditional empleadoimpuestorentaAdditional) {
		try {
			this.empleadoimpuestorentaAdditional=empleadoimpuestorentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor_pago() {
		return this.valor_pago;
	}
    
	
	public Double getingreso_liquido() {
		return this.ingreso_liquido;
	}
    
	
	public Double getaporte_iess() {
		return this.aporte_iess;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_pago(Double newvalor_pago)throws Exception
	{
		try {
			if(this.valor_pago!=newvalor_pago) {
				if(newvalor_pago==null) {
					//newvalor_pago=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna valor_pago");
					}
				}

				this.valor_pago=newvalor_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso_liquido(Double newingreso_liquido)throws Exception
	{
		try {
			if(this.ingreso_liquido!=newingreso_liquido) {
				if(newingreso_liquido==null) {
					//newingreso_liquido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna ingreso_liquido");
					}
				}

				this.ingreso_liquido=newingreso_liquido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setaporte_iess(Double newaporte_iess)throws Exception
	{
		try {
			if(this.aporte_iess!=newaporte_iess) {
				if(newaporte_iess==null) {
					//newaporte_iess=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EmpleadoImpuestoRenta:Valor nulo no permitido en columna aporte_iess");
					}
				}

				this.aporte_iess=newaporte_iess;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_estructura_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_estructura_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

