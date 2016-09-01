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
//import com.bydan.erp.nomina.util.UtilidadEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class UtilidadEmpleado extends UtilidadEmpleadoAdditional implements Serializable ,Cloneable {//UtilidadEmpleadoAdditional,GeneralEntity
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
	
	private UtilidadEmpleado utilidadempleadoOriginal;
	
	private Map<String, Object> mapUtilidadEmpleado;
			
	public Map<String, Object> getMapUtilidadEmpleado() {
		return mapUtilidadEmpleado;
	}

	public void setMapUtilidadEmpleado(Map<String, Object> mapUtilidadEmpleado) {
		this.mapUtilidadEmpleado = mapUtilidadEmpleado;
	}
	
	public void inicializarMapUtilidadEmpleado() {
		this.mapUtilidadEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapUtilidadEmpleadoValue(String sKey,Object oValue) {
		this.mapUtilidadEmpleado.put(sKey, oValue);
	}
	
	public Object getMapUtilidadEmpleadoValue(String sKey) {
		return this.mapUtilidadEmpleado.get(sKey);
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_salida;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cargas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_factor10;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_factor10;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad_factor10;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double numero_factor5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_factor5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad_factor5;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Anio anio;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String anio_descripcion;
	
	
		
	public UtilidadEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.utilidadempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_anio=null;
 		this.fecha_ingreso=new Date();
 		this.fecha_salida=new Date();
 		this.valor=0.0;
 		this.numero_dias=0;
 		this.numero_cargas=0;
 		this.numero_factor10=0.0;
 		this.valor_factor10=0.0;
 		this.utilidad_factor10=0.0;
 		this.numero_factor5=0.0;
 		this.valor_factor5=0.0;
 		this.utilidad_factor5=0.0;
 		this.total=0.0;
		
		
		this.empresa=null;
		this.empleado=null;
		this.anio=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.anio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public UtilidadEmpleado (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_anio,Date fecha_ingreso,Date fecha_salida,Double valor,Integer numero_dias,Integer numero_cargas,Double numero_factor10,Double valor_factor10,Double utilidad_factor10,Double numero_factor5,Double valor_factor5,Double utilidad_factor5,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.utilidadempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio=id_anio;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_salida=fecha_salida;
 		this.valor=valor;
 		this.numero_dias=numero_dias;
 		this.numero_cargas=numero_cargas;
 		this.numero_factor10=numero_factor10;
 		this.valor_factor10=valor_factor10;
 		this.utilidad_factor10=utilidad_factor10;
 		this.numero_factor5=numero_factor5;
 		this.valor_factor5=valor_factor5;
 		this.utilidad_factor5=utilidad_factor5;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public UtilidadEmpleado (Long id_empresa,Long id_empleado,Long id_anio,Date fecha_ingreso,Date fecha_salida,Double valor,Integer numero_dias,Integer numero_cargas,Double numero_factor10,Double valor_factor10,Double utilidad_factor10,Double numero_factor5,Double valor_factor5,Double utilidad_factor5,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.utilidadempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_anio=id_anio;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_salida=fecha_salida;
 		this.valor=valor;
 		this.numero_dias=numero_dias;
 		this.numero_cargas=numero_cargas;
 		this.numero_factor10=numero_factor10;
 		this.valor_factor10=valor_factor10;
 		this.utilidad_factor10=utilidad_factor10;
 		this.numero_factor5=numero_factor5;
 		this.valor_factor5=valor_factor5;
 		this.utilidad_factor5=utilidad_factor5;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		UtilidadEmpleado utilidadempleadoLocal=null;
		
		if(object!=null) {
			utilidadempleadoLocal=(UtilidadEmpleado)object;
			
			if(utilidadempleadoLocal!=null) {
				if(this.getId()!=null && utilidadempleadoLocal.getId()!=null) {
					if(this.getId().equals(utilidadempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UtilidadEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UtilidadEmpleadoConstantesFunciones.getUtilidadEmpleadoDescripcion(this);
		} else {
			sDetalle=UtilidadEmpleadoConstantesFunciones.getUtilidadEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public UtilidadEmpleado getUtilidadEmpleadoOriginal() {
		return this.utilidadempleadoOriginal;
	}
	
	public void setUtilidadEmpleadoOriginal(UtilidadEmpleado utilidadempleado) {
		try {
			this.utilidadempleadoOriginal=utilidadempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UtilidadEmpleadoAdditional utilidadempleadoAdditional=null;
	
	public UtilidadEmpleadoAdditional getUtilidadEmpleadoAdditional() {
		return this.utilidadempleadoAdditional;
	}
	
	public void setUtilidadEmpleadoAdditional(UtilidadEmpleadoAdditional utilidadempleadoAdditional) {
		try {
			this.utilidadempleadoAdditional=utilidadempleadoAdditional;
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
    
	
	public Date getfecha_ingreso() {
		return this.fecha_ingreso;
	}
    
	
	public Date getfecha_salida() {
		return this.fecha_salida;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
    
	
	public Integer getnumero_cargas() {
		return this.numero_cargas;
	}
    
	
	public Double getnumero_factor10() {
		return this.numero_factor10;
	}
    
	
	public Double getvalor_factor10() {
		return this.valor_factor10;
	}
    
	
	public Double getutilidad_factor10() {
		return this.utilidad_factor10;
	}
    
	
	public Double getnumero_factor5() {
		return this.numero_factor5;
	}
    
	
	public Double getvalor_factor5() {
		return this.valor_factor5;
	}
    
	
	public Double getutilidad_factor5() {
		return this.utilidad_factor5;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna id_empleado");
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
    
	public void setfecha_ingreso(Date newfecha_ingreso)throws Exception
	{
		try {
			if(this.fecha_ingreso!=newfecha_ingreso) {
				if(newfecha_ingreso==null) {
					//newfecha_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna fecha_ingreso");
					}
				}

				this.fecha_ingreso=newfecha_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_salida(Date newfecha_salida)throws Exception
	{
		try {
			if(this.fecha_salida!=newfecha_salida) {
				if(newfecha_salida==null) {
					//newfecha_salida=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna fecha_salida");
					}
				}

				this.fecha_salida=newfecha_salida;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cargas(Integer newnumero_cargas)throws Exception
	{
		try {
			if(this.numero_cargas!=newnumero_cargas) {
				if(newnumero_cargas==null) {
					//newnumero_cargas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna numero_cargas");
					}
				}

				this.numero_cargas=newnumero_cargas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factor10(Double newnumero_factor10)throws Exception
	{
		try {
			if(this.numero_factor10!=newnumero_factor10) {
				if(newnumero_factor10==null) {
					//newnumero_factor10=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna numero_factor10");
					}
				}

				this.numero_factor10=newnumero_factor10;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_factor10(Double newvalor_factor10)throws Exception
	{
		try {
			if(this.valor_factor10!=newvalor_factor10) {
				if(newvalor_factor10==null) {
					//newvalor_factor10=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna valor_factor10");
					}
				}

				this.valor_factor10=newvalor_factor10;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad_factor10(Double newutilidad_factor10)throws Exception
	{
		try {
			if(this.utilidad_factor10!=newutilidad_factor10) {
				if(newutilidad_factor10==null) {
					//newutilidad_factor10=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna utilidad_factor10");
					}
				}

				this.utilidad_factor10=newutilidad_factor10;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factor5(Double newnumero_factor5)throws Exception
	{
		try {
			if(this.numero_factor5!=newnumero_factor5) {
				if(newnumero_factor5==null) {
					//newnumero_factor5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna numero_factor5");
					}
				}

				this.numero_factor5=newnumero_factor5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_factor5(Double newvalor_factor5)throws Exception
	{
		try {
			if(this.valor_factor5!=newvalor_factor5) {
				if(newvalor_factor5==null) {
					//newvalor_factor5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna valor_factor5");
					}
				}

				this.valor_factor5=newvalor_factor5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad_factor5(Double newutilidad_factor5)throws Exception
	{
		try {
			if(this.utilidad_factor5!=newutilidad_factor5) {
				if(newutilidad_factor5==null) {
					//newutilidad_factor5=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna utilidad_factor5");
					}
				}

				this.utilidad_factor5=newutilidad_factor5;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadEmpleado:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_anio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_anio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

