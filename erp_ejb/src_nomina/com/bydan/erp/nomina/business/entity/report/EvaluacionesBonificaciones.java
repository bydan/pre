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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.EvaluacionesBonificacionesConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class EvaluacionesBonificaciones extends EvaluacionesBonificacionesAdditional implements Serializable ,Cloneable {//EvaluacionesBonificacionesAdditional,GeneralEntity
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
	
	private EvaluacionesBonificaciones evaluacionesbonificacionesOriginal;
	
	private Map<String, Object> mapEvaluacionesBonificaciones;
			
	public Map<String, Object> getMapEvaluacionesBonificaciones() {
		return mapEvaluacionesBonificaciones;
	}

	public void setMapEvaluacionesBonificaciones(Map<String, Object> mapEvaluacionesBonificaciones) {
		this.mapEvaluacionesBonificaciones = mapEvaluacionesBonificaciones;
	}
	
	public void inicializarMapEvaluacionesBonificaciones() {
		this.mapEvaluacionesBonificaciones = new HashMap<String,Object>();
	}
	
	public void setMapEvaluacionesBonificacionesValue(String sKey,Object oValue) {
		this.mapEvaluacionesBonificaciones.put(sKey, oValue);
	}
	
	public Object getMapEvaluacionesBonificacionesValue(String sKey) {
		return this.mapEvaluacionesBonificaciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_calificacion_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean verificado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EvaluacionesBonificacionesConstantesFunciones.SREGEXCODIGO,message=EvaluacionesBonificacionesConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EvaluacionesBonificacionesConstantesFunciones.SREGEXCODIGO_DATO,message=EvaluacionesBonificacionesConstantesFunciones.SMENSAJEREGEXCODIGO_DATO)
	private String codigo_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=EvaluacionesBonificacionesConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=EvaluacionesBonificacionesConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sueldo;
	
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
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double bonificacion;
			
	
	public TipoCalificacionEmpleado tipocalificacionempleado;
	public Estructura estructura;
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String tipocalificacionempleado_descripcion;
	private String estructura_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public EvaluacionesBonificaciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.evaluacionesbonificacionesOriginal=this;
		
 		this.id_tipo_calificacion_empleado=-1L;
 		this.verificado=false;
 		this.id_estructura=-1L;
 		this.codigo="";
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo_dato="";
 		this.nombre_completo="";
 		this.sueldo=0.0;
 		this.valor_conocimiento=0.0;
 		this.valor_eficiencia=0.0;
 		this.valor_obtenido=0.0;
 		this.valor_peso=0.0;
 		this.bonificacion=0.0;
		
		
		this.tipocalificacionempleado=null;
		this.estructura=null;
		this.empresa=null;
		this.sucursal=null;
		
		
		this.tipocalificacionempleado_descripcion="";
		this.estructura_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EvaluacionesBonificaciones (Long id,Date versionRow,String codigo_dato,String nombre_completo,Double sueldo,Double valor_conocimiento,Double valor_eficiencia,Double valor_obtenido,Double valor_peso,Double bonificacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionesbonificacionesOriginal=this;
		
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo=nombre_completo;
 		this.sueldo=sueldo;
 		this.valor_conocimiento=valor_conocimiento;
 		this.valor_eficiencia=valor_eficiencia;
 		this.valor_obtenido=valor_obtenido;
 		this.valor_peso=valor_peso;
 		this.bonificacion=bonificacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EvaluacionesBonificaciones (String codigo_dato,String nombre_completo,Double sueldo,Double valor_conocimiento,Double valor_eficiencia,Double valor_obtenido,Double valor_peso,Double bonificacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionesbonificacionesOriginal=this;
		
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo=nombre_completo;
 		this.sueldo=sueldo;
 		this.valor_conocimiento=valor_conocimiento;
 		this.valor_eficiencia=valor_eficiencia;
 		this.valor_obtenido=valor_obtenido;
 		this.valor_peso=valor_peso;
 		this.bonificacion=bonificacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public EvaluacionesBonificaciones getEvaluacionesBonificacionesOriginal() {
		return this.evaluacionesbonificacionesOriginal;
	}
	
	public void setEvaluacionesBonificacionesOriginal(EvaluacionesBonificaciones evaluacionesbonificaciones) {
		try {
			this.evaluacionesbonificacionesOriginal=evaluacionesbonificaciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EvaluacionesBonificacionesAdditional evaluacionesbonificacionesAdditional=null;
	
	public EvaluacionesBonificacionesAdditional getEvaluacionesBonificacionesAdditional() {
		return this.evaluacionesbonificacionesAdditional;
	}
	
	public void setEvaluacionesBonificacionesAdditional(EvaluacionesBonificacionesAdditional evaluacionesbonificacionesAdditional) {
		try {
			this.evaluacionesbonificacionesAdditional=evaluacionesbonificacionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_calificacion_empleado() {
		return this.id_tipo_calificacion_empleado;
	}
    
	
	public Boolean getverificado() {
		return this.verificado;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public String getcodigo_dato() {
		return this.codigo_dato;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public Double getsueldo() {
		return this.sueldo;
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
    
	
	public Double getbonificacion() {
		return this.bonificacion;
	}
	
    
	public void setid_tipo_calificacion_empleado(Long newid_tipo_calificacion_empleado)throws Exception
	{
		try {
			if(this.id_tipo_calificacion_empleado!=newid_tipo_calificacion_empleado) {
				if(newid_tipo_calificacion_empleado==null) {
					//newid_tipo_calificacion_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna id_tipo_calificacion_empleado");
					}
				}

				this.id_tipo_calificacion_empleado=newid_tipo_calificacion_empleado;
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna verificado");
					}
				}

				this.verificado=newverificado;
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EvaluacionesBonificaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_dato(String newcodigo_dato)throws Exception
	{
		try {
			if(this.codigo_dato!=newcodigo_dato) {
				if(newcodigo_dato==null) {
					//newcodigo_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna codigo_dato");
					}
				}

				if(newcodigo_dato!=null&&newcodigo_dato.length()>50) {
					newcodigo_dato=newcodigo_dato.substring(0,48);
					System.out.println("EvaluacionesBonificaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_dato");
				}

				this.codigo_dato=newcodigo_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("EvaluacionesBonificaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsueldo(Double newsueldo)throws Exception
	{
		try {
			if(this.sueldo!=newsueldo) {
				if(newsueldo==null) {
					//newsueldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna sueldo");
					}
				}

				this.sueldo=newsueldo;
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna valor_conocimiento");
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna valor_eficiencia");
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna valor_obtenido");
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
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna valor_peso");
					}
				}

				this.valor_peso=newvalor_peso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbonificacion(Double newbonificacion)throws Exception
	{
		try {
			if(this.bonificacion!=newbonificacion) {
				if(newbonificacion==null) {
					//newbonificacion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionesBonificaciones:Valor nulo no permitido en columna bonificacion");
					}
				}

				this.bonificacion=newbonificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoCalificacionEmpleado getTipoCalificacionEmpleado() {
		return this.tipocalificacionempleado;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String gettipocalificacionempleado_descripcion() {
		return this.tipocalificacionempleado_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado) {
		try {
			this.tipocalificacionempleado=tipocalificacionempleado;
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


	
	
	public  void  settipocalificacionempleado_descripcion(String tipocalificacionempleado_descripcion) {
		try {
			this.tipocalificacionempleado_descripcion=tipocalificacionempleado_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_calificacion_empleado_descripcion="";String verificado_descripcion="";String id_estructura_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_tipo_calificacion_empleado_descripcion() {
		return id_tipo_calificacion_empleado_descripcion;
	}
	public String getverificado_descripcion() {
		return verificado_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_calificacion_empleado_descripcion="";this.verificado_descripcion="";this.id_estructura_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

