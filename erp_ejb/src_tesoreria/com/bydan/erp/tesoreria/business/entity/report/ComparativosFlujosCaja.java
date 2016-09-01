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
package com.bydan.erp.tesoreria.business.entity.report;

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
//import com.bydan.erp.tesoreria.util.ComparativosFlujosCajaConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ComparativosFlujosCaja extends ComparativosFlujosCajaAdditional implements Serializable ,Cloneable {//ComparativosFlujosCajaAdditional,GeneralEntity
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
	
	private ComparativosFlujosCaja comparativosflujoscajaOriginal;
	
	private Map<String, Object> mapComparativosFlujosCaja;
			
	public Map<String, Object> getMapComparativosFlujosCaja() {
		return mapComparativosFlujosCaja;
	}

	public void setMapComparativosFlujosCaja(Map<String, Object> mapComparativosFlujosCaja) {
		this.mapComparativosFlujosCaja = mapComparativosFlujosCaja;
	}
	
	public void inicializarMapComparativosFlujosCaja() {
		this.mapComparativosFlujosCaja = new HashMap<String,Object>();
	}
	
	public void setMapComparativosFlujosCajaValue(String sKey,Object oValue) {
		this.mapComparativosFlujosCaja.put(sKey, oValue);
	}
	
	public Object getMapComparativosFlujosCajaValue(String sKey) {
		return this.mapComparativosFlujosCaja.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComparativosFlujosCajaConstantesFunciones.SREGEXNOMBRE_CENTRO_ACTIVIDAD,message=ComparativosFlujosCajaConstantesFunciones.SMENSAJEREGEXNOMBRE_CENTRO_ACTIVIDAD)
	private String nombre_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ComparativosFlujosCajaConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=ComparativosFlujosCajaConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_acumulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_pres_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double saldo_pres_acumulado;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	
	
		
	public ComparativosFlujosCaja () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.comparativosflujoscajaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.nombre_centro_actividad="";
 		this.tipo_movimiento="";
 		this.saldo_actual=0.0;
 		this.saldo_acumulado=0.0;
 		this.saldo_pres_actual=0.0;
 		this.saldo_pres_acumulado=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ComparativosFlujosCaja (Long id,Date versionRow,String nombre_centro_actividad,String tipo_movimiento,Double saldo_actual,Double saldo_acumulado,Double saldo_pres_actual,Double saldo_pres_acumulado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comparativosflujoscajaOriginal=this;
		
 		this.nombre_centro_actividad=nombre_centro_actividad;
 		this.tipo_movimiento=tipo_movimiento;
 		this.saldo_actual=saldo_actual;
 		this.saldo_acumulado=saldo_acumulado;
 		this.saldo_pres_actual=saldo_pres_actual;
 		this.saldo_pres_acumulado=saldo_pres_acumulado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ComparativosFlujosCaja (String nombre_centro_actividad,String tipo_movimiento,Double saldo_actual,Double saldo_acumulado,Double saldo_pres_actual,Double saldo_pres_acumulado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.comparativosflujoscajaOriginal=this;
		
 		this.nombre_centro_actividad=nombre_centro_actividad;
 		this.tipo_movimiento=tipo_movimiento;
 		this.saldo_actual=saldo_actual;
 		this.saldo_acumulado=saldo_acumulado;
 		this.saldo_pres_actual=saldo_pres_actual;
 		this.saldo_pres_acumulado=saldo_pres_acumulado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ComparativosFlujosCaja getComparativosFlujosCajaOriginal() {
		return this.comparativosflujoscajaOriginal;
	}
	
	public void setComparativosFlujosCajaOriginal(ComparativosFlujosCaja comparativosflujoscaja) {
		try {
			this.comparativosflujoscajaOriginal=comparativosflujoscaja;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ComparativosFlujosCajaAdditional comparativosflujoscajaAdditional=null;
	
	public ComparativosFlujosCajaAdditional getComparativosFlujosCajaAdditional() {
		return this.comparativosflujoscajaAdditional;
	}
	
	public void setComparativosFlujosCajaAdditional(ComparativosFlujosCajaAdditional comparativosflujoscajaAdditional) {
		try {
			this.comparativosflujoscajaAdditional=comparativosflujoscajaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public String getnombre_centro_actividad() {
		return this.nombre_centro_actividad;
	}
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public Double getsaldo_actual() {
		return this.saldo_actual;
	}
    
	
	public Double getsaldo_acumulado() {
		return this.saldo_acumulado;
	}
    
	
	public Double getsaldo_pres_actual() {
		return this.saldo_pres_actual;
	}
    
	
	public Double getsaldo_pres_acumulado() {
		return this.saldo_pres_acumulado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_centro_actividad(String newnombre_centro_actividad)throws Exception
	{
		try {
			if(this.nombre_centro_actividad!=newnombre_centro_actividad) {
				if(newnombre_centro_actividad==null) {
					//newnombre_centro_actividad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna nombre_centro_actividad");
					}
				}

				if(newnombre_centro_actividad!=null&&newnombre_centro_actividad.length()>100) {
					newnombre_centro_actividad=newnombre_centro_actividad.substring(0,98);
					System.out.println("ComparativosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_centro_actividad");
				}

				this.nombre_centro_actividad=newnombre_centro_actividad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_movimiento(String newtipo_movimiento)throws Exception
	{
		try {
			if(this.tipo_movimiento!=newtipo_movimiento) {
				if(newtipo_movimiento==null) {
					//newtipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("ComparativosFlujosCaja:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_actual(Double newsaldo_actual)throws Exception
	{
		try {
			if(this.saldo_actual!=newsaldo_actual) {
				if(newsaldo_actual==null) {
					//newsaldo_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna saldo_actual");
					}
				}

				this.saldo_actual=newsaldo_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_acumulado(Double newsaldo_acumulado)throws Exception
	{
		try {
			if(this.saldo_acumulado!=newsaldo_acumulado) {
				if(newsaldo_acumulado==null) {
					//newsaldo_acumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna saldo_acumulado");
					}
				}

				this.saldo_acumulado=newsaldo_acumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_pres_actual(Double newsaldo_pres_actual)throws Exception
	{
		try {
			if(this.saldo_pres_actual!=newsaldo_pres_actual) {
				if(newsaldo_pres_actual==null) {
					//newsaldo_pres_actual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna saldo_pres_actual");
					}
				}

				this.saldo_pres_actual=newsaldo_pres_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsaldo_pres_acumulado(Double newsaldo_pres_acumulado)throws Exception
	{
		try {
			if(this.saldo_pres_acumulado!=newsaldo_pres_acumulado) {
				if(newsaldo_pres_acumulado==null) {
					//newsaldo_pres_acumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ComparativosFlujosCaja:Valor nulo no permitido en columna saldo_pres_acumulado");
					}
				}

				this.saldo_pres_acumulado=newsaldo_pres_acumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

