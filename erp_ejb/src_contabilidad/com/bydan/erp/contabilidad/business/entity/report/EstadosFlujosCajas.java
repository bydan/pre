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
package com.bydan.erp.contabilidad.business.entity.report;

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
//import com.bydan.erp.contabilidad.util.EstadosFlujosCajasConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;

import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class EstadosFlujosCajas extends EstadosFlujosCajasAdditional implements Serializable ,Cloneable {//EstadosFlujosCajasAdditional,GeneralEntity
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
	
	private EstadosFlujosCajas estadosflujoscajasOriginal;
	
	private Map<String, Object> mapEstadosFlujosCajas;
			
	public Map<String, Object> getMapEstadosFlujosCajas() {
		return mapEstadosFlujosCajas;
	}

	public void setMapEstadosFlujosCajas(Map<String, Object> mapEstadosFlujosCajas) {
		this.mapEstadosFlujosCajas = mapEstadosFlujosCajas;
	}
	
	public void inicializarMapEstadosFlujosCajas() {
		this.mapEstadosFlujosCajas = new HashMap<String,Object>();
	}
	
	public void setMapEstadosFlujosCajasValue(String sKey,Object oValue) {
		this.mapEstadosFlujosCajas.put(sKey, oValue);
	}
	
	public Object getMapEstadosFlujosCajasValue(String sKey) {
		return this.mapEstadosFlujosCajas.get(sKey);
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EstadosFlujosCajasConstantesFunciones.SREGEXNOMBRE_CENTRO_ACTIVIDAD,message=EstadosFlujosCajasConstantesFunciones.SMENSAJEREGEXNOMBRE_CENTRO_ACTIVIDAD)
	private String nombre_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EstadosFlujosCajasConstantesFunciones.SREGEXCODIGO_CENTRO_ACTIVIDAD,message=EstadosFlujosCajasConstantesFunciones.SMENSAJEREGEXCODIGO_CENTRO_ACTIVIDAD)
	private String codigo_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double mensual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double acumulado;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public CentroActividad centroactividad;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String centroactividad_descripcion;
	
	
		
	public EstadosFlujosCajas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadosflujoscajasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_centro_actividad=-1L;
 		this.nombre_centro_actividad="";
 		this.codigo_centro_actividad="";
 		this.mensual=0.0;
 		this.acumulado=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.centroactividad=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.centroactividad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadosFlujosCajas (Long id,Date versionRow,Long id_periodo,String nombre_centro_actividad,String codigo_centro_actividad,Double mensual,Double acumulado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosflujoscajasOriginal=this;
		
 		this.id_periodo=id_periodo;
 		this.nombre_centro_actividad=nombre_centro_actividad;
 		this.codigo_centro_actividad=codigo_centro_actividad;
 		this.mensual=mensual;
 		this.acumulado=acumulado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadosFlujosCajas (Long id_periodo,String nombre_centro_actividad,String codigo_centro_actividad,Double mensual,Double acumulado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosflujoscajasOriginal=this;
		
 		this.id_periodo=id_periodo;
 		this.nombre_centro_actividad=nombre_centro_actividad;
 		this.codigo_centro_actividad=codigo_centro_actividad;
 		this.mensual=mensual;
 		this.acumulado=acumulado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public EstadosFlujosCajas getEstadosFlujosCajasOriginal() {
		return this.estadosflujoscajasOriginal;
	}
	
	public void setEstadosFlujosCajasOriginal(EstadosFlujosCajas estadosflujoscajas) {
		try {
			this.estadosflujoscajasOriginal=estadosflujoscajas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstadosFlujosCajasAdditional estadosflujoscajasAdditional=null;
	
	public EstadosFlujosCajasAdditional getEstadosFlujosCajasAdditional() {
		return this.estadosflujoscajasAdditional;
	}
	
	public void setEstadosFlujosCajasAdditional(EstadosFlujosCajasAdditional estadosflujoscajasAdditional) {
		try {
			this.estadosflujoscajasAdditional=estadosflujoscajasAdditional;
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
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_centro_actividad() {
		return this.id_centro_actividad;
	}
    
	
	public String getnombre_centro_actividad() {
		return this.nombre_centro_actividad;
	}
    
	
	public String getcodigo_centro_actividad() {
		return this.codigo_centro_actividad;
	}
    
	
	public Double getmensual() {
		return this.mensual;
	}
    
	
	public Double getacumulado() {
		return this.acumulado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_actividad(Long newid_centro_actividad)throws Exception
	{
		try {
			if(this.id_centro_actividad!=newid_centro_actividad) {
				if(newid_centro_actividad==null) {
					//newid_centro_actividad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna id_centro_actividad");
					}
				}

				this.id_centro_actividad=newid_centro_actividad;
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
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna nombre_centro_actividad");
					}
				}

				if(newnombre_centro_actividad!=null&&newnombre_centro_actividad.length()>100) {
					newnombre_centro_actividad=newnombre_centro_actividad.substring(0,98);
					System.out.println("EstadosFlujosCajas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_centro_actividad");
				}

				this.nombre_centro_actividad=newnombre_centro_actividad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_centro_actividad(String newcodigo_centro_actividad)throws Exception
	{
		try {
			if(this.codigo_centro_actividad!=newcodigo_centro_actividad) {
				if(newcodigo_centro_actividad==null) {
					//newcodigo_centro_actividad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna codigo_centro_actividad");
					}
				}

				if(newcodigo_centro_actividad!=null&&newcodigo_centro_actividad.length()>50) {
					newcodigo_centro_actividad=newcodigo_centro_actividad.substring(0,48);
					System.out.println("EstadosFlujosCajas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_centro_actividad");
				}

				this.codigo_centro_actividad=newcodigo_centro_actividad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmensual(Double newmensual)throws Exception
	{
		try {
			if(this.mensual!=newmensual) {
				if(newmensual==null) {
					//newmensual=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna mensual");
					}
				}

				this.mensual=newmensual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacumulado(Double newacumulado)throws Exception
	{
		try {
			if(this.acumulado!=newacumulado) {
				if(newacumulado==null) {
					//newacumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadosFlujosCajas:Valor nulo no permitido en columna acumulado");
					}
				}

				this.acumulado=newacumulado;
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

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public CentroActividad getCentroActividad() {
		return this.centroactividad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getcentroactividad_descripcion() {
		return this.centroactividad_descripcion;
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


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroActividad(CentroActividad centroactividad) {
		try {
			this.centroactividad=centroactividad;
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


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentroactividad_descripcion(String centroactividad_descripcion) {
		try {
			this.centroactividad_descripcion=centroactividad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_centro_actividad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_centro_actividad_descripcion() {
		return id_centro_actividad_descripcion;
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
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_actividad_descripcion(String newid_centro_actividad_descripcion)throws Exception {
		try {
			this.id_centro_actividad_descripcion=newid_centro_actividad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_centro_actividad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

