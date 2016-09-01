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
//import com.bydan.erp.nomina.util.CalificacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CalificacionEmpleado extends CalificacionEmpleadoAdditional implements Serializable ,Cloneable {//CalificacionEmpleadoAdditional,GeneralEntity
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
	
	private CalificacionEmpleado calificacionempleadoOriginal;
	
	private Map<String, Object> mapCalificacionEmpleado;
			
	public Map<String, Object> getMapCalificacionEmpleado() {
		return mapCalificacionEmpleado;
	}

	public void setMapCalificacionEmpleado(Map<String, Object> mapCalificacionEmpleado) {
		this.mapCalificacionEmpleado = mapCalificacionEmpleado;
	}
	
	public void inicializarMapCalificacionEmpleado() {
		this.mapCalificacionEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapCalificacionEmpleadoValue(String sKey,Object oValue) {
		this.mapCalificacionEmpleado.put(sKey, oValue);
	}
	
	public Object getMapCalificacionEmpleadoValue(String sKey) {
		return this.mapCalificacionEmpleado.get(sKey);
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
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_evaluacion_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nomi_factor_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nomi_pregunta_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_calificacion_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_conocimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_eficiencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_obtenido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_peso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean verificado;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Empleado empleado;
	public EvaluacionEmpleado evaluacionempleado;
	public FormatoNomiFactorNomi formatonomifactornomi;
	public FormatoNomiPreguntaNomi formatonomipreguntanomi;
	public TipoCalificacionEmpleado tipocalificacionempleado;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String empleado_descripcion;
	private String evaluacionempleado_descripcion;
	private String formatonomifactornomi_descripcion;
	private String formatonomipreguntanomi_descripcion;
	private String tipocalificacionempleado_descripcion;
	
	
		
	public CalificacionEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.calificacionempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_empleado=-1L;
 		this.id_evaluacion_empleado=-1L;
 		this.id_formato_nomi_factor_nomi=-1L;
 		this.id_formato_nomi_pregunta_nomi=-1L;
 		this.id_tipo_calificacion_empleado=-1L;
 		this.valor_conocimiento=0.0;
 		this.valor_eficiencia=0.0;
 		this.valor_obtenido=0.0;
 		this.valor_peso=0.0;
 		this.verificado=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.empleado=null;
		this.evaluacionempleado=null;
		this.formatonomifactornomi=null;
		this.formatonomipreguntanomi=null;
		this.tipocalificacionempleado=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.empleado_descripcion="";
		this.evaluacionempleado_descripcion="";
		this.formatonomifactornomi_descripcion="";
		this.formatonomipreguntanomi_descripcion="";
		this.tipocalificacionempleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CalificacionEmpleado (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_evaluacion_empleado,Long id_formato_nomi_factor_nomi,Long id_formato_nomi_pregunta_nomi,Long id_tipo_calificacion_empleado,Double valor_conocimiento,Double valor_eficiencia,Double valor_obtenido,Double valor_peso,Boolean verificado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.calificacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_evaluacion_empleado=id_evaluacion_empleado;
 		this.id_formato_nomi_factor_nomi=id_formato_nomi_factor_nomi;
 		this.id_formato_nomi_pregunta_nomi=id_formato_nomi_pregunta_nomi;
 		this.id_tipo_calificacion_empleado=id_tipo_calificacion_empleado;
 		this.valor_conocimiento=valor_conocimiento;
 		this.valor_eficiencia=valor_eficiencia;
 		this.valor_obtenido=valor_obtenido;
 		this.valor_peso=valor_peso;
 		this.verificado=verificado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CalificacionEmpleado (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_evaluacion_empleado,Long id_formato_nomi_factor_nomi,Long id_formato_nomi_pregunta_nomi,Long id_tipo_calificacion_empleado,Double valor_conocimiento,Double valor_eficiencia,Double valor_obtenido,Double valor_peso,Boolean verificado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.calificacionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_evaluacion_empleado=id_evaluacion_empleado;
 		this.id_formato_nomi_factor_nomi=id_formato_nomi_factor_nomi;
 		this.id_formato_nomi_pregunta_nomi=id_formato_nomi_pregunta_nomi;
 		this.id_tipo_calificacion_empleado=id_tipo_calificacion_empleado;
 		this.valor_conocimiento=valor_conocimiento;
 		this.valor_eficiencia=valor_eficiencia;
 		this.valor_obtenido=valor_obtenido;
 		this.valor_peso=valor_peso;
 		this.verificado=verificado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CalificacionEmpleado calificacionempleadoLocal=null;
		
		if(object!=null) {
			calificacionempleadoLocal=(CalificacionEmpleado)object;
			
			if(calificacionempleadoLocal!=null) {
				if(this.getId()!=null && calificacionempleadoLocal.getId()!=null) {
					if(this.getId().equals(calificacionempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CalificacionEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CalificacionEmpleadoConstantesFunciones.getCalificacionEmpleadoDescripcion(this);
		} else {
			sDetalle=CalificacionEmpleadoConstantesFunciones.getCalificacionEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CalificacionEmpleado getCalificacionEmpleadoOriginal() {
		return this.calificacionempleadoOriginal;
	}
	
	public void setCalificacionEmpleadoOriginal(CalificacionEmpleado calificacionempleado) {
		try {
			this.calificacionempleadoOriginal=calificacionempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CalificacionEmpleadoAdditional calificacionempleadoAdditional=null;
	
	public CalificacionEmpleadoAdditional getCalificacionEmpleadoAdditional() {
		return this.calificacionempleadoAdditional;
	}
	
	public void setCalificacionEmpleadoAdditional(CalificacionEmpleadoAdditional calificacionempleadoAdditional) {
		try {
			this.calificacionempleadoAdditional=calificacionempleadoAdditional;
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
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_evaluacion_empleado() {
		return this.id_evaluacion_empleado;
	}
    
	
	public Long getid_formato_nomi_factor_nomi() {
		return this.id_formato_nomi_factor_nomi;
	}
    
	
	public Long getid_formato_nomi_pregunta_nomi() {
		return this.id_formato_nomi_pregunta_nomi;
	}
    
	
	public Long getid_tipo_calificacion_empleado() {
		return this.id_tipo_calificacion_empleado;
	}
    
	
	public Double getvalor_conocimiento() {
		return this.valor_conocimiento;
	}
    
	
	public Double getvalor_eficiencia() {
		return this.valor_eficiencia;
	}
    
	
	public Double getvalor_obtenido() {
		return this.valor_obtenido;
	}
    
	
	public Double getvalor_peso() {
		return this.valor_peso;
	}
    
	
	public Boolean getverificado() {
		return this.verificado;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_evaluacion_empleado(Long newid_evaluacion_empleado)throws Exception
	{
		try {
			if(this.id_evaluacion_empleado!=newid_evaluacion_empleado) {
				if(newid_evaluacion_empleado==null) {
					//newid_evaluacion_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_evaluacion_empleado");
					}
				}

				this.id_evaluacion_empleado=newid_evaluacion_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nomi_factor_nomi(Long newid_formato_nomi_factor_nomi)throws Exception
	{
		try {
			if(this.id_formato_nomi_factor_nomi!=newid_formato_nomi_factor_nomi) {
				if(newid_formato_nomi_factor_nomi==null) {
					//newid_formato_nomi_factor_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_formato_nomi_factor_nomi");
					}
				}

				this.id_formato_nomi_factor_nomi=newid_formato_nomi_factor_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nomi_pregunta_nomi(Long newid_formato_nomi_pregunta_nomi)throws Exception
	{
		try {
			if(this.id_formato_nomi_pregunta_nomi!=newid_formato_nomi_pregunta_nomi) {
				if(newid_formato_nomi_pregunta_nomi==null) {
					//newid_formato_nomi_pregunta_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_formato_nomi_pregunta_nomi");
					}
				}

				this.id_formato_nomi_pregunta_nomi=newid_formato_nomi_pregunta_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_calificacion_empleado(Long newid_tipo_calificacion_empleado)throws Exception
	{
		try {
			if(this.id_tipo_calificacion_empleado!=newid_tipo_calificacion_empleado) {
				if(newid_tipo_calificacion_empleado==null) {
					//newid_tipo_calificacion_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna id_tipo_calificacion_empleado");
					}
				}

				this.id_tipo_calificacion_empleado=newid_tipo_calificacion_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_conocimiento(Double newvalor_conocimiento)throws Exception
	{
		try {
			if(this.valor_conocimiento!=newvalor_conocimiento) {
				if(newvalor_conocimiento==null) {
					//newvalor_conocimiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna valor_conocimiento");
					}
				}

				this.valor_conocimiento=newvalor_conocimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_eficiencia(Double newvalor_eficiencia)throws Exception
	{
		try {
			if(this.valor_eficiencia!=newvalor_eficiencia) {
				if(newvalor_eficiencia==null) {
					//newvalor_eficiencia=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna valor_eficiencia");
					}
				}

				this.valor_eficiencia=newvalor_eficiencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_obtenido(Double newvalor_obtenido)throws Exception
	{
		try {
			if(this.valor_obtenido!=newvalor_obtenido) {
				if(newvalor_obtenido==null) {
					//newvalor_obtenido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna valor_obtenido");
					}
				}

				this.valor_obtenido=newvalor_obtenido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_peso(Double newvalor_peso)throws Exception
	{
		try {
			if(this.valor_peso!=newvalor_peso) {
				if(newvalor_peso==null) {
					//newvalor_peso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna valor_peso");
					}
				}

				this.valor_peso=newvalor_peso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setverificado(Boolean newverificado)throws Exception
	{
		try {
			if(this.verificado!=newverificado) {
				if(newverificado==null) {
					//newverificado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CalificacionEmpleado:Valor nulo no permitido en columna verificado");
					}
				}

				this.verificado=newverificado;
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

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public EvaluacionEmpleado getEvaluacionEmpleado() {
		return this.evaluacionempleado;
	}

	public FormatoNomiFactorNomi getFormatoNomiFactorNomi() {
		return this.formatonomifactornomi;
	}

	public FormatoNomiPreguntaNomi getFormatoNomiPreguntaNomi() {
		return this.formatonomipreguntanomi;
	}

	public TipoCalificacionEmpleado getTipoCalificacionEmpleado() {
		return this.tipocalificacionempleado;
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

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getevaluacionempleado_descripcion() {
		return this.evaluacionempleado_descripcion;
	}

	public String getformatonomifactornomi_descripcion() {
		return this.formatonomifactornomi_descripcion;
	}

	public String getformatonomipreguntanomi_descripcion() {
		return this.formatonomipreguntanomi_descripcion;
	}

	public String gettipocalificacionempleado_descripcion() {
		return this.tipocalificacionempleado_descripcion;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEvaluacionEmpleado(EvaluacionEmpleado evaluacionempleado) {
		try {
			this.evaluacionempleado=evaluacionempleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNomiFactorNomi(FormatoNomiFactorNomi formatonomifactornomi) {
		try {
			this.formatonomifactornomi=formatonomifactornomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNomiPreguntaNomi(FormatoNomiPreguntaNomi formatonomipreguntanomi) {
		try {
			this.formatonomipreguntanomi=formatonomipreguntanomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado) {
		try {
			this.tipocalificacionempleado=tipocalificacionempleado;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setevaluacionempleado_descripcion(String evaluacionempleado_descripcion) {
		try {
			this.evaluacionempleado_descripcion=evaluacionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonomifactornomi_descripcion(String formatonomifactornomi_descripcion) {
		try {
			this.formatonomifactornomi_descripcion=formatonomifactornomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonomipreguntanomi_descripcion(String formatonomipreguntanomi_descripcion) {
		try {
			this.formatonomipreguntanomi_descripcion=formatonomipreguntanomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipocalificacionempleado_descripcion(String tipocalificacionempleado_descripcion) {
		try {
			this.tipocalificacionempleado_descripcion=tipocalificacionempleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_empleado_descripcion="";String id_evaluacion_empleado_descripcion="";String id_formato_nomi_factor_nomi_descripcion="";String id_formato_nomi_pregunta_nomi_descripcion="";String id_tipo_calificacion_empleado_descripcion="";String verificado_descripcion="";
	
	
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
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_evaluacion_empleado_descripcion() {
		return id_evaluacion_empleado_descripcion;
	}
	public String getid_formato_nomi_factor_nomi_descripcion() {
		return id_formato_nomi_factor_nomi_descripcion;
	}
	public String getid_formato_nomi_pregunta_nomi_descripcion() {
		return id_formato_nomi_pregunta_nomi_descripcion;
	}
	public String getid_tipo_calificacion_empleado_descripcion() {
		return id_tipo_calificacion_empleado_descripcion;
	}
	public String getverificado_descripcion() {
		return verificado_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_evaluacion_empleado_descripcion(String newid_evaluacion_empleado_descripcion)throws Exception {
		try {
			this.id_evaluacion_empleado_descripcion=newid_evaluacion_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nomi_factor_nomi_descripcion(String newid_formato_nomi_factor_nomi_descripcion)throws Exception {
		try {
			this.id_formato_nomi_factor_nomi_descripcion=newid_formato_nomi_factor_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nomi_pregunta_nomi_descripcion(String newid_formato_nomi_pregunta_nomi_descripcion)throws Exception {
		try {
			this.id_formato_nomi_pregunta_nomi_descripcion=newid_formato_nomi_pregunta_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_calificacion_empleado_descripcion(String newid_tipo_calificacion_empleado_descripcion)throws Exception {
		try {
			this.id_tipo_calificacion_empleado_descripcion=newid_tipo_calificacion_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setverificado_descripcion(String newverificado_descripcion)throws Exception {
		try {
			this.verificado_descripcion=newverificado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_empleado_descripcion="";this.id_evaluacion_empleado_descripcion="";this.id_formato_nomi_factor_nomi_descripcion="";this.id_formato_nomi_pregunta_nomi_descripcion="";this.id_tipo_calificacion_empleado_descripcion="";this.verificado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

