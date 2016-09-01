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
//import com.bydan.erp.nomina.util.EvaluacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class EvaluacionEmpleado extends EvaluacionEmpleadoAdditional implements Serializable ,Cloneable {//EvaluacionEmpleadoAdditional,GeneralEntity
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
	
	private EvaluacionEmpleado evaluacionempleadoOriginal;
	
	private Map<String, Object> mapEvaluacionEmpleado;
			
	public Map<String, Object> getMapEvaluacionEmpleado() {
		return mapEvaluacionEmpleado;
	}

	public void setMapEvaluacionEmpleado(Map<String, Object> mapEvaluacionEmpleado) {
		this.mapEvaluacionEmpleado = mapEvaluacionEmpleado;
	}
	
	public void inicializarMapEvaluacionEmpleado() {
		this.mapEvaluacionEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapEvaluacionEmpleadoValue(String sKey,Object oValue) {
		this.mapEvaluacionEmpleado.put(sKey, oValue);
	}
	
	public Object getMapEvaluacionEmpleadoValue(String sKey) {
		return this.mapEvaluacionEmpleado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
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
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado_evalua;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_evaluacion_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_evaluado;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_semestre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_trimestre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bimestre;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionEmpleadoConstantesFunciones.SREGEXOBSERVACION1,message=EvaluacionEmpleadoConstantesFunciones.SMENSAJEREGEXOBSERVACION1)
	private String observacion1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionEmpleadoConstantesFunciones.SREGEXOBSERVACION2,message=EvaluacionEmpleadoConstantesFunciones.SMENSAJEREGEXOBSERVACION2)
	private String observacion2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionEmpleadoConstantesFunciones.SREGEXOBSERVACION3,message=EvaluacionEmpleadoConstantesFunciones.SMENSAJEREGEXOBSERVACION3)
	private String observacion3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionEmpleadoConstantesFunciones.SREGEXOBSERVACION4,message=EvaluacionEmpleadoConstantesFunciones.SMENSAJEREGEXOBSERVACION4)
	private String observacion4;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Estructura estructura;
	public Empleado empleado;
	public Empleado empleadoevalua;
	public TipoEvaluacionEmpleado tipoevaluacionempleado;
	public Anio anio;
	public Semestre semestre;
	public Trimestre trimestre;
	public Bimestre bimestre;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String estructura_descripcion;
	private String empleado_descripcion;
	private String empleadoevalua_descripcion;
	private String tipoevaluacionempleado_descripcion;
	private String anio_descripcion;
	private String semestre_descripcion;
	private String trimestre_descripcion;
	private String bimestre_descripcion;
	private String mes_descripcion;
	
	
	public List<CalificacionEmpleado> calificacionempleados;
		
	public EvaluacionEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.evaluacionempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_estructura=-1L;
 		this.id_empleado=-1L;
 		this.id_empleado_evalua=-1L;
 		this.id_tipo_evaluacion_empleado=-1L;
 		this.fecha=new Date();
 		this.esta_evaluado=false;
 		this.id_anio=null;
 		this.id_semestre=-1L;
 		this.id_trimestre=-1L;
 		this.id_bimestre=-1L;
 		this.id_mes=null;
 		this.observacion1="";
 		this.observacion2="";
 		this.observacion3="";
 		this.observacion4="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.estructura=null;
		this.empleado=null;
		this.empleadoevalua=null;
		this.tipoevaluacionempleado=null;
		this.anio=null;
		this.semestre=null;
		this.trimestre=null;
		this.bimestre=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.estructura_descripcion="";
		this.empleado_descripcion="";
		this.empleadoevalua_descripcion="";
		this.tipoevaluacionempleado_descripcion="";
		this.anio_descripcion="";
		this.semestre_descripcion="";
		this.trimestre_descripcion="";
		this.bimestre_descripcion="";
		this.mes_descripcion="";
		
		
		this.calificacionempleados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EvaluacionEmpleado (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_estructura,Long id_empleado,Long id_empleado_evalua,Long id_tipo_evaluacion_empleado,Date fecha,Boolean esta_evaluado,Long id_anio,Long id_semestre,Long id_trimestre,Long id_bimestre,Long id_mes,String observacion1,String observacion2,String observacion3,String observacion4) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.id_empleado_evalua=id_empleado_evalua;
 		this.id_tipo_evaluacion_empleado=id_tipo_evaluacion_empleado;
 		this.fecha=fecha;
 		this.esta_evaluado=esta_evaluado;
 		this.id_anio=id_anio;
 		this.id_semestre=id_semestre;
 		this.id_trimestre=id_trimestre;
 		this.id_bimestre=id_bimestre;
 		this.id_mes=id_mes;
 		this.observacion1=observacion1;
 		this.observacion2=observacion2;
 		this.observacion3=observacion3;
 		this.observacion4=observacion4;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EvaluacionEmpleado (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_estructura,Long id_empleado,Long id_empleado_evalua,Long id_tipo_evaluacion_empleado,Date fecha,Boolean esta_evaluado,Long id_anio,Long id_semestre,Long id_trimestre,Long id_bimestre,Long id_mes,String observacion1,String observacion2,String observacion3,String observacion4) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.id_empleado_evalua=id_empleado_evalua;
 		this.id_tipo_evaluacion_empleado=id_tipo_evaluacion_empleado;
 		this.fecha=fecha;
 		this.esta_evaluado=esta_evaluado;
 		this.id_anio=id_anio;
 		this.id_semestre=id_semestre;
 		this.id_trimestre=id_trimestre;
 		this.id_bimestre=id_bimestre;
 		this.id_mes=id_mes;
 		this.observacion1=observacion1;
 		this.observacion2=observacion2;
 		this.observacion3=observacion3;
 		this.observacion4=observacion4;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EvaluacionEmpleado evaluacionempleadoLocal=null;
		
		if(object!=null) {
			evaluacionempleadoLocal=(EvaluacionEmpleado)object;
			
			if(evaluacionempleadoLocal!=null) {
				if(this.getId()!=null && evaluacionempleadoLocal.getId()!=null) {
					if(this.getId().equals(evaluacionempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EvaluacionEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoDescripcion(this);
		} else {
			sDetalle=EvaluacionEmpleadoConstantesFunciones.getEvaluacionEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EvaluacionEmpleado getEvaluacionEmpleadoOriginal() {
		return this.evaluacionempleadoOriginal;
	}
	
	public void setEvaluacionEmpleadoOriginal(EvaluacionEmpleado evaluacionempleado) {
		try {
			this.evaluacionempleadoOriginal=evaluacionempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EvaluacionEmpleadoAdditional evaluacionempleadoAdditional=null;
	
	public EvaluacionEmpleadoAdditional getEvaluacionEmpleadoAdditional() {
		return this.evaluacionempleadoAdditional;
	}
	
	public void setEvaluacionEmpleadoAdditional(EvaluacionEmpleadoAdditional evaluacionempleadoAdditional) {
		try {
			this.evaluacionempleadoAdditional=evaluacionempleadoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_empleado_evalua() {
		return this.id_empleado_evalua;
	}
    
	
	public Long getid_tipo_evaluacion_empleado() {
		return this.id_tipo_evaluacion_empleado;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Boolean getesta_evaluado() {
		return this.esta_evaluado;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_semestre() {
		return this.id_semestre;
	}
    
	
	public Long getid_trimestre() {
		return this.id_trimestre;
	}
    
	
	public Long getid_bimestre() {
		return this.id_bimestre;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public String getobservacion1() {
		return this.observacion1;
	}
    
	
	public String getobservacion2() {
		return this.observacion2;
	}
    
	
	public String getobservacion3() {
		return this.observacion3;
	}
    
	
	public String getobservacion4() {
		return this.observacion4;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_evalua(Long newid_empleado_evalua)throws Exception
	{
		try {
			if(this.id_empleado_evalua!=newid_empleado_evalua) {
				if(newid_empleado_evalua==null) {
					//newid_empleado_evalua=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_empleado_evalua");
					}
				}

				this.id_empleado_evalua=newid_empleado_evalua;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_evaluacion_empleado(Long newid_tipo_evaluacion_empleado)throws Exception
	{
		try {
			if(this.id_tipo_evaluacion_empleado!=newid_tipo_evaluacion_empleado) {
				if(newid_tipo_evaluacion_empleado==null) {
					//newid_tipo_evaluacion_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_tipo_evaluacion_empleado");
					}
				}

				this.id_tipo_evaluacion_empleado=newid_tipo_evaluacion_empleado;
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
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_evaluado(Boolean newesta_evaluado)throws Exception
	{
		try {
			if(this.esta_evaluado!=newesta_evaluado) {
				if(newesta_evaluado==null) {
					//newesta_evaluado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna esta_evaluado");
					}
				}

				this.esta_evaluado=newesta_evaluado;
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
    
	public void setid_semestre(Long newid_semestre)throws Exception
	{
		try {
			if(this.id_semestre!=newid_semestre) {
				if(newid_semestre==null) {
					//newid_semestre=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_semestre");
					}
				}

				this.id_semestre=newid_semestre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_trimestre(Long newid_trimestre)throws Exception
	{
		try {
			if(this.id_trimestre!=newid_trimestre) {
				if(newid_trimestre==null) {
					//newid_trimestre=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_trimestre");
					}
				}

				this.id_trimestre=newid_trimestre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bimestre(Long newid_bimestre)throws Exception
	{
		try {
			if(this.id_bimestre!=newid_bimestre) {
				if(newid_bimestre==null) {
					//newid_bimestre=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna id_bimestre");
					}
				}

				this.id_bimestre=newid_bimestre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setobservacion1(String newobservacion1)throws Exception
	{
		try {
			if(this.observacion1!=newobservacion1) {
				if(newobservacion1==null) {
					//newobservacion1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna observacion1");
					}
				}

				if(newobservacion1!=null&&newobservacion1.length()>250) {
					newobservacion1=newobservacion1.substring(0,248);
					System.out.println("EvaluacionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion1");
				}

				this.observacion1=newobservacion1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion2(String newobservacion2)throws Exception
	{
		try {
			if(this.observacion2!=newobservacion2) {
				if(newobservacion2==null) {
					//newobservacion2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna observacion2");
					}
				}

				if(newobservacion2!=null&&newobservacion2.length()>250) {
					newobservacion2=newobservacion2.substring(0,248);
					System.out.println("EvaluacionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion2");
				}

				this.observacion2=newobservacion2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion3(String newobservacion3)throws Exception
	{
		try {
			if(this.observacion3!=newobservacion3) {
				if(newobservacion3==null) {
					//newobservacion3="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna observacion3");
					}
				}

				if(newobservacion3!=null&&newobservacion3.length()>250) {
					newobservacion3=newobservacion3.substring(0,248);
					System.out.println("EvaluacionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion3");
				}

				this.observacion3=newobservacion3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion4(String newobservacion4)throws Exception
	{
		try {
			if(this.observacion4!=newobservacion4) {
				if(newobservacion4==null) {
					//newobservacion4="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionEmpleado:Valor nulo no permitido en columna observacion4");
					}
				}

				if(newobservacion4!=null&&newobservacion4.length()>250) {
					newobservacion4=newobservacion4.substring(0,248);
					System.out.println("EvaluacionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion4");
				}

				this.observacion4=newobservacion4;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Empleado getEmpleadoEvalua() {
		return this.empleadoevalua;
	}

	public TipoEvaluacionEmpleado getTipoEvaluacionEmpleado() {
		return this.tipoevaluacionempleado;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Semestre getSemestre() {
		return this.semestre;
	}

	public Trimestre getTrimestre() {
		return this.trimestre;
	}

	public Bimestre getBimestre() {
		return this.bimestre;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getempleadoevalua_descripcion() {
		return this.empleadoevalua_descripcion;
	}

	public String gettipoevaluacionempleado_descripcion() {
		return this.tipoevaluacionempleado_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getsemestre_descripcion() {
		return this.semestre_descripcion;
	}

	public String gettrimestre_descripcion() {
		return this.trimestre_descripcion;
	}

	public String getbimestre_descripcion() {
		return this.bimestre_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setEmpleadoEvalua(Empleado empleadoevalua) {
		try {
			this.empleadoevalua=empleadoevalua;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado) {
		try {
			this.tipoevaluacionempleado=tipoevaluacionempleado;
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


	public  void  setSemestre(Semestre semestre) {
		try {
			this.semestre=semestre;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTrimestre(Trimestre trimestre) {
		try {
			this.trimestre=trimestre;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBimestre(Bimestre bimestre) {
		try {
			this.bimestre=bimestre;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	public  void  setempleadoevalua_descripcion(String empleadoevalua_descripcion) {
		try {
			this.empleadoevalua_descripcion=empleadoevalua_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoevaluacionempleado_descripcion(String tipoevaluacionempleado_descripcion) {
		try {
			this.tipoevaluacionempleado_descripcion=tipoevaluacionempleado_descripcion;
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


	public  void  setsemestre_descripcion(String semestre_descripcion) {
		try {
			this.semestre_descripcion=semestre_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settrimestre_descripcion(String trimestre_descripcion) {
		try {
			this.trimestre_descripcion=trimestre_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbimestre_descripcion(String bimestre_descripcion) {
		try {
			this.bimestre_descripcion=bimestre_descripcion;
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


	
	
	public List<CalificacionEmpleado> getCalificacionEmpleados() {
		return this.calificacionempleados;
	}

	
	
	public  void  setCalificacionEmpleados(List<CalificacionEmpleado> calificacionempleados) {
		try {
			this.calificacionempleados=calificacionempleados;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_estructura_descripcion="";String id_empleado_descripcion="";String id_empleado_evalua_descripcion="";String id_tipo_evaluacion_empleado_descripcion="";String esta_evaluado_descripcion="";String id_anio_descripcion="";String id_semestre_descripcion="";String id_trimestre_descripcion="";String id_bimestre_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_empleado_evalua_descripcion() {
		return id_empleado_evalua_descripcion;
	}
	public String getid_tipo_evaluacion_empleado_descripcion() {
		return id_tipo_evaluacion_empleado_descripcion;
	}
	public String getesta_evaluado_descripcion() {
		return esta_evaluado_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_semestre_descripcion() {
		return id_semestre_descripcion;
	}
	public String getid_trimestre_descripcion() {
		return id_trimestre_descripcion;
	}
	public String getid_bimestre_descripcion() {
		return id_bimestre_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
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
	public void setid_empleado_evalua_descripcion(String newid_empleado_evalua_descripcion)throws Exception {
		try {
			this.id_empleado_evalua_descripcion=newid_empleado_evalua_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_evaluacion_empleado_descripcion(String newid_tipo_evaluacion_empleado_descripcion)throws Exception {
		try {
			this.id_tipo_evaluacion_empleado_descripcion=newid_tipo_evaluacion_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_evaluado_descripcion(String newesta_evaluado_descripcion)throws Exception {
		try {
			this.esta_evaluado_descripcion=newesta_evaluado_descripcion;
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
	public void setid_semestre_descripcion(String newid_semestre_descripcion)throws Exception {
		try {
			this.id_semestre_descripcion=newid_semestre_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_trimestre_descripcion(String newid_trimestre_descripcion)throws Exception {
		try {
			this.id_trimestre_descripcion=newid_trimestre_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bimestre_descripcion(String newid_bimestre_descripcion)throws Exception {
		try {
			this.id_bimestre_descripcion=newid_bimestre_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_estructura_descripcion="";this.id_empleado_descripcion="";this.id_empleado_evalua_descripcion="";this.id_tipo_evaluacion_empleado_descripcion="";this.esta_evaluado_descripcion="";this.id_anio_descripcion="";this.id_semestre_descripcion="";this.id_trimestre_descripcion="";this.id_bimestre_descripcion="";this.id_mes_descripcion="";
	}
	
	
	Object calificacionempleadosDescripcionReporte;
	
	
	public Object getcalificacionempleadosDescripcionReporte() {
		return calificacionempleadosDescripcionReporte;
	}

	
	
	public  void  setcalificacionempleadosDescripcionReporte(Object calificacionempleados) {
		try {
			this.calificacionempleadosDescripcionReporte=calificacionempleados;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

