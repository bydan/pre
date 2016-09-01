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
//import com.bydan.erp.nomina.util.EvaluacionNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class EvaluacionNomi extends EvaluacionNomiAdditional implements Serializable ,Cloneable {//EvaluacionNomiAdditional,GeneralEntity
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
	
	private EvaluacionNomi evaluacionnomiOriginal;
	
	private Map<String, Object> mapEvaluacionNomi;
			
	public Map<String, Object> getMapEvaluacionNomi() {
		return mapEvaluacionNomi;
	}

	public void setMapEvaluacionNomi(Map<String, Object> mapEvaluacionNomi) {
		this.mapEvaluacionNomi = mapEvaluacionNomi;
	}
	
	public void inicializarMapEvaluacionNomi() {
		this.mapEvaluacionNomi = new HashMap<String,Object>();
	}
	
	public void setMapEvaluacionNomiValue(String sKey,Object oValue) {
		this.mapEvaluacionNomi.put(sKey, oValue);
	}
	
	public Object getMapEvaluacionNomiValue(String sKey) {
		return this.mapEvaluacionNomi.get(sKey);
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
	private Long id_empleado_evaluador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionNomiConstantesFunciones.SREGEXINSTRUCCIONES,message=EvaluacionNomiConstantesFunciones.SMENSAJEREGEXINSTRUCCIONES)
	private String instrucciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionNomiConstantesFunciones.SREGEXDESCRIPCION,message=EvaluacionNomiConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionNomiConstantesFunciones.SREGEXDESCRIPCION2,message=EvaluacionNomiConstantesFunciones.SMENSAJEREGEXDESCRIPCION2)
	private String descripcion2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionNomiConstantesFunciones.SREGEXDESCRIPCION3,message=EvaluacionNomiConstantesFunciones.SMENSAJEREGEXDESCRIPCION3)
	private String descripcion3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EvaluacionNomiConstantesFunciones.SREGEXDESCRIPCION4,message=EvaluacionNomiConstantesFunciones.SMENSAJEREGEXDESCRIPCION4)
	private String descripcion4;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Empleado empleado;
	public Empleado empleadoevaluador;
	public FormatoNomi formatonomi;
	public Estructura estructura;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String empleado_descripcion;
	private String empleadoevaluador_descripcion;
	private String formatonomi_descripcion;
	private String estructura_descripcion;
	
	
	public List<DetalleEvaluacionNomi> detalleevaluacionnomis;
		
	public EvaluacionNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.evaluacionnomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_empleado=-1L;
 		this.id_empleado_evaluador=-1L;
 		this.id_formato_nomi=-1L;
 		this.id_estructura=-1L;
 		this.fecha=new Date();
 		this.instrucciones="";
 		this.descripcion="";
 		this.descripcion2="";
 		this.descripcion3="";
 		this.descripcion4="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.empleado=null;
		this.empleadoevaluador=null;
		this.formatonomi=null;
		this.estructura=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.empleado_descripcion="";
		this.empleadoevaluador_descripcion="";
		this.formatonomi_descripcion="";
		this.estructura_descripcion="";
		
		
		this.detalleevaluacionnomis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EvaluacionNomi (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_empleado_evaluador,Long id_formato_nomi,Long id_estructura,Date fecha,String instrucciones,String descripcion,String descripcion2,String descripcion3,String descripcion4) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_empleado_evaluador=id_empleado_evaluador;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_estructura=id_estructura;
 		this.fecha=fecha;
 		this.instrucciones=instrucciones;
 		this.descripcion=descripcion;
 		this.descripcion2=descripcion2;
 		this.descripcion3=descripcion3;
 		this.descripcion4=descripcion4;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EvaluacionNomi (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_empleado,Long id_empleado_evaluador,Long id_formato_nomi,Long id_estructura,Date fecha,String instrucciones,String descripcion,String descripcion2,String descripcion3,String descripcion4) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.evaluacionnomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_empleado=id_empleado;
 		this.id_empleado_evaluador=id_empleado_evaluador;
 		this.id_formato_nomi=id_formato_nomi;
 		this.id_estructura=id_estructura;
 		this.fecha=fecha;
 		this.instrucciones=instrucciones;
 		this.descripcion=descripcion;
 		this.descripcion2=descripcion2;
 		this.descripcion3=descripcion3;
 		this.descripcion4=descripcion4;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EvaluacionNomi evaluacionnomiLocal=null;
		
		if(object!=null) {
			evaluacionnomiLocal=(EvaluacionNomi)object;
			
			if(evaluacionnomiLocal!=null) {
				if(this.getId()!=null && evaluacionnomiLocal.getId()!=null) {
					if(this.getId().equals(evaluacionnomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EvaluacionNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EvaluacionNomiConstantesFunciones.getEvaluacionNomiDescripcion(this);
		} else {
			sDetalle=EvaluacionNomiConstantesFunciones.getEvaluacionNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EvaluacionNomi getEvaluacionNomiOriginal() {
		return this.evaluacionnomiOriginal;
	}
	
	public void setEvaluacionNomiOriginal(EvaluacionNomi evaluacionnomi) {
		try {
			this.evaluacionnomiOriginal=evaluacionnomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EvaluacionNomiAdditional evaluacionnomiAdditional=null;
	
	public EvaluacionNomiAdditional getEvaluacionNomiAdditional() {
		return this.evaluacionnomiAdditional;
	}
	
	public void setEvaluacionNomiAdditional(EvaluacionNomiAdditional evaluacionnomiAdditional) {
		try {
			this.evaluacionnomiAdditional=evaluacionnomiAdditional;
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
    
	
	public Long getid_empleado_evaluador() {
		return this.id_empleado_evaluador;
	}
    
	
	public Long getid_formato_nomi() {
		return this.id_formato_nomi;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getinstrucciones() {
		return this.instrucciones;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public String getdescripcion2() {
		return this.descripcion2;
	}
    
	
	public String getdescripcion3() {
		return this.descripcion3;
	}
    
	
	public String getdescripcion4() {
		return this.descripcion4;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_periodo");
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_evaluador(Long newid_empleado_evaluador)throws Exception
	{
		try {
			if(this.id_empleado_evaluador!=newid_empleado_evaluador) {
				if(newid_empleado_evaluador==null) {
					//newid_empleado_evaluador=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_empleado_evaluador");
					}
				}

				this.id_empleado_evaluador=newid_empleado_evaluador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato_nomi(Long newid_formato_nomi)throws Exception
	{
		try {
			if(this.id_formato_nomi!=newid_formato_nomi) {
				if(newid_formato_nomi==null) {
					//newid_formato_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_formato_nomi");
					}
				}

				this.id_formato_nomi=newid_formato_nomi;
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna id_estructura");
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
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinstrucciones(String newinstrucciones)throws Exception
	{
		try {
			if(this.instrucciones!=newinstrucciones) {
				if(newinstrucciones==null) {
					//newinstrucciones="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna instrucciones");
					}
				}

				if(newinstrucciones!=null&&newinstrucciones.length()>250) {
					newinstrucciones=newinstrucciones.substring(0,248);
					System.out.println("EvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna instrucciones");
				}

				this.instrucciones=newinstrucciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("EvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion2(String newdescripcion2)throws Exception
	{
		try {
			if(this.descripcion2!=newdescripcion2) {
				if(newdescripcion2==null) {
					//newdescripcion2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna descripcion2");
					}
				}

				if(newdescripcion2!=null&&newdescripcion2.length()>250) {
					newdescripcion2=newdescripcion2.substring(0,248);
					System.out.println("EvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion2");
				}

				this.descripcion2=newdescripcion2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion3(String newdescripcion3)throws Exception
	{
		try {
			if(this.descripcion3!=newdescripcion3) {
				if(newdescripcion3==null) {
					//newdescripcion3="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna descripcion3");
					}
				}

				if(newdescripcion3!=null&&newdescripcion3.length()>250) {
					newdescripcion3=newdescripcion3.substring(0,248);
					System.out.println("EvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion3");
				}

				this.descripcion3=newdescripcion3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion4(String newdescripcion4)throws Exception
	{
		try {
			if(this.descripcion4!=newdescripcion4) {
				if(newdescripcion4==null) {
					//newdescripcion4="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EvaluacionNomi:Valor nulo no permitido en columna descripcion4");
					}
				}

				if(newdescripcion4!=null&&newdescripcion4.length()>250) {
					newdescripcion4=newdescripcion4.substring(0,248);
					System.out.println("EvaluacionNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion4");
				}

				this.descripcion4=newdescripcion4;
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

	public Empleado getEmpleadoEvaluador() {
		return this.empleadoevaluador;
	}

	public FormatoNomi getFormatoNomi() {
		return this.formatonomi;
	}

	public Estructura getEstructura() {
		return this.estructura;
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

	public String getempleadoevaluador_descripcion() {
		return this.empleadoevaluador_descripcion;
	}

	public String getformatonomi_descripcion() {
		return this.formatonomi_descripcion;
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


	public  void  setEmpleadoEvaluador(Empleado empleadoevaluador) {
		try {
			this.empleadoevaluador=empleadoevaluador;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormatoNomi(FormatoNomi formatonomi) {
		try {
			this.formatonomi=formatonomi;
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


	public  void  setempleadoevaluador_descripcion(String empleadoevaluador_descripcion) {
		try {
			this.empleadoevaluador_descripcion=empleadoevaluador_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformatonomi_descripcion(String formatonomi_descripcion) {
		try {
			this.formatonomi_descripcion=formatonomi_descripcion;
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


	
	
	public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis() {
		return this.detalleevaluacionnomis;
	}

	
	
	public  void  setDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomis=detalleevaluacionnomis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_empleado_descripcion="";String id_empleado_evaluador_descripcion="";String id_formato_nomi_descripcion="";String id_estructura_descripcion="";
	
	
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
	public String getid_empleado_evaluador_descripcion() {
		return id_empleado_evaluador_descripcion;
	}
	public String getid_formato_nomi_descripcion() {
		return id_formato_nomi_descripcion;
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
	public void setid_empleado_evaluador_descripcion(String newid_empleado_evaluador_descripcion)throws Exception {
		try {
			this.id_empleado_evaluador_descripcion=newid_empleado_evaluador_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_nomi_descripcion(String newid_formato_nomi_descripcion)throws Exception {
		try {
			this.id_formato_nomi_descripcion=newid_formato_nomi_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_empleado_descripcion="";this.id_empleado_evaluador_descripcion="";this.id_formato_nomi_descripcion="";this.id_estructura_descripcion="";
	}
	
	
	Object detalleevaluacionnomisDescripcionReporte;
	
	
	public Object getdetalleevaluacionnomisDescripcionReporte() {
		return detalleevaluacionnomisDescripcionReporte;
	}

	
	
	public  void  setdetalleevaluacionnomisDescripcionReporte(Object detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomisDescripcionReporte=detalleevaluacionnomis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

