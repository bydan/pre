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
//import com.bydan.erp.contabilidad.util.PresuProyectoCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.nomina.util.*;



import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PresuProyectoCuenta extends PresuProyectoCuentaAdditional implements Serializable ,Cloneable {//PresuProyectoCuentaAdditional,GeneralEntity
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
	
	private PresuProyectoCuenta presuproyectocuentaOriginal;
	
	private Map<String, Object> mapPresuProyectoCuenta;
			
	public Map<String, Object> getMapPresuProyectoCuenta() {
		return mapPresuProyectoCuenta;
	}

	public void setMapPresuProyectoCuenta(Map<String, Object> mapPresuProyectoCuenta) {
		this.mapPresuProyectoCuenta = mapPresuProyectoCuenta;
	}
	
	public void inicializarMapPresuProyectoCuenta() {
		this.mapPresuProyectoCuenta = new HashMap<String,Object>();
	}
	
	public void setMapPresuProyectoCuentaValue(String sKey,Object oValue) {
		this.mapPresuProyectoCuenta.put(sKey, oValue);
	}
	
	public Object getMapPresuProyectoCuentaValue(String sKey) {
		return this.mapPresuProyectoCuenta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_proyecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_tipo_cuenta_proyecto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuProyectoCuentaConstantesFunciones.SREGEXCODIGO,message=PresuProyectoCuentaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuProyectoCuentaConstantesFunciones.SREGEXNOMBRE,message=PresuProyectoCuentaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuProyectoCuentaConstantesFunciones.SREGEXDESCRIPCION,message=PresuProyectoCuentaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public PresuProyecto presuproyecto;
	public PresuTipoCuentaProyecto presutipocuentaproyecto;
	public CuentaContable cuentacontable;
	public Empleado empleado;
	public PresuEstado presuestado;
	
	
	private String presuproyecto_descripcion;
	private String presutipocuentaproyecto_descripcion;
	private String cuentacontable_descripcion;
	private String empleado_descripcion;
	private String presuestado_descripcion;
	
	
	public List<PresuAsignacion> presuasignacions;
		
	public PresuProyectoCuenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presuproyectocuentaOriginal=this;
		
 		this.id_presu_proyecto=-1L;
 		this.id_presu_tipo_cuenta_proyecto=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_cuenta_contable=-1L;
 		this.id_empleado=-1L;
 		this.fecha=new Date();
 		this.valor=0.0;
 		this.orden=0;
 		this.id_presu_estado=-1L;
 		this.descripcion="";
		
		
		this.presuproyecto=null;
		this.presutipocuentaproyecto=null;
		this.cuentacontable=null;
		this.empleado=null;
		this.presuestado=null;
		
		
		this.presuproyecto_descripcion="";
		this.presutipocuentaproyecto_descripcion="";
		this.cuentacontable_descripcion="";
		this.empleado_descripcion="";
		this.presuestado_descripcion="";
		
		
		this.presuasignacions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresuProyectoCuenta (Long id,Date versionRow,Long id_presu_proyecto,Long id_presu_tipo_cuenta_proyecto,String codigo,String nombre,Long id_cuenta_contable,Long id_empleado,Date fecha,Double valor,Integer orden,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuproyectocuentaOriginal=this;
		
 		this.id_presu_proyecto=id_presu_proyecto;
 		this.id_presu_tipo_cuenta_proyecto=id_presu_tipo_cuenta_proyecto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.orden=orden;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresuProyectoCuenta (Long id_presu_proyecto,Long id_presu_tipo_cuenta_proyecto,String codigo,String nombre,Long id_cuenta_contable,Long id_empleado,Date fecha,Double valor,Integer orden,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuproyectocuentaOriginal=this;
		
 		this.id_presu_proyecto=id_presu_proyecto;
 		this.id_presu_tipo_cuenta_proyecto=id_presu_tipo_cuenta_proyecto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.valor=valor;
 		this.orden=orden;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresuProyectoCuenta presuproyectocuentaLocal=null;
		
		if(object!=null) {
			presuproyectocuentaLocal=(PresuProyectoCuenta)object;
			
			if(presuproyectocuentaLocal!=null) {
				if(this.getId()!=null && presuproyectocuentaLocal.getId()!=null) {
					if(this.getId().equals(presuproyectocuentaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresuProyectoCuentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaDescripcion(this);
		} else {
			sDetalle=PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresuProyectoCuenta getPresuProyectoCuentaOriginal() {
		return this.presuproyectocuentaOriginal;
	}
	
	public void setPresuProyectoCuentaOriginal(PresuProyectoCuenta presuproyectocuenta) {
		try {
			this.presuproyectocuentaOriginal=presuproyectocuenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresuProyectoCuentaAdditional presuproyectocuentaAdditional=null;
	
	public PresuProyectoCuentaAdditional getPresuProyectoCuentaAdditional() {
		return this.presuproyectocuentaAdditional;
	}
	
	public void setPresuProyectoCuentaAdditional(PresuProyectoCuentaAdditional presuproyectocuentaAdditional) {
		try {
			this.presuproyectocuentaAdditional=presuproyectocuentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_presu_proyecto() {
		return this.id_presu_proyecto;
	}
    
	
	public Long getid_presu_tipo_cuenta_proyecto() {
		return this.id_presu_tipo_cuenta_proyecto;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public Long getid_presu_estado() {
		return this.id_presu_estado;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_presu_proyecto(Long newid_presu_proyecto)throws Exception
	{
		try {
			if(this.id_presu_proyecto!=newid_presu_proyecto) {
				if(newid_presu_proyecto==null) {
					//newid_presu_proyecto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna id_presu_proyecto");
					}
				}

				this.id_presu_proyecto=newid_presu_proyecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_presu_tipo_cuenta_proyecto(Long newid_presu_tipo_cuenta_proyecto)throws Exception
	{
		try {
			if(this.id_presu_tipo_cuenta_proyecto!=newid_presu_tipo_cuenta_proyecto) {
				if(newid_presu_tipo_cuenta_proyecto==null) {
					//newid_presu_tipo_cuenta_proyecto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna id_presu_tipo_cuenta_proyecto");
					}
				}

				this.id_presu_tipo_cuenta_proyecto=newid_presu_tipo_cuenta_proyecto;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("PresuProyectoCuenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("PresuProyectoCuenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_presu_estado(Long newid_presu_estado)throws Exception
	{
		try {
			if(this.id_presu_estado!=newid_presu_estado) {
				if(newid_presu_estado==null) {
					//newid_presu_estado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna id_presu_estado");
					}
				}

				this.id_presu_estado=newid_presu_estado;
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
						System.out.println("PresuProyectoCuenta:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PresuProyectoCuenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public PresuProyecto getPresuProyecto() {
		return this.presuproyecto;
	}

	public PresuTipoCuentaProyecto getPresuTipoCuentaProyecto() {
		return this.presutipocuentaproyecto;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public PresuEstado getPresuEstado() {
		return this.presuestado;
	}

	
	
	public String getpresuproyecto_descripcion() {
		return this.presuproyecto_descripcion;
	}

	public String getpresutipocuentaproyecto_descripcion() {
		return this.presutipocuentaproyecto_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getpresuestado_descripcion() {
		return this.presuestado_descripcion;
	}

	
	
	public  void  setPresuProyecto(PresuProyecto presuproyecto) {
		try {
			this.presuproyecto=presuproyecto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto) {
		try {
			this.presutipocuentaproyecto=presutipocuentaproyecto;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPresuEstado(PresuEstado presuestado) {
		try {
			this.presuestado=presuestado;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpresuproyecto_descripcion(String presuproyecto_descripcion) {
		try {
			this.presuproyecto_descripcion=presuproyecto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpresutipocuentaproyecto_descripcion(String presutipocuentaproyecto_descripcion) {
		try {
			this.presutipocuentaproyecto_descripcion=presutipocuentaproyecto_descripcion;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpresuestado_descripcion(String presuestado_descripcion) {
		try {
			this.presuestado_descripcion=presuestado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PresuAsignacion> getPresuAsignacions() {
		return this.presuasignacions;
	}

	
	
	public  void  setPresuAsignacions(List<PresuAsignacion> presuasignacions) {
		try {
			this.presuasignacions=presuasignacions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_presu_proyecto_descripcion="";String id_presu_tipo_cuenta_proyecto_descripcion="";String id_cuenta_contable_descripcion="";String id_empleado_descripcion="";String id_presu_estado_descripcion="";
	
	
	public String getid_presu_proyecto_descripcion() {
		return id_presu_proyecto_descripcion;
	}
	public String getid_presu_tipo_cuenta_proyecto_descripcion() {
		return id_presu_tipo_cuenta_proyecto_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_presu_estado_descripcion() {
		return id_presu_estado_descripcion;
	}
	
	
	public void setid_presu_proyecto_descripcion(String newid_presu_proyecto_descripcion)throws Exception {
		try {
			this.id_presu_proyecto_descripcion=newid_presu_proyecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_presu_tipo_cuenta_proyecto_descripcion(String newid_presu_tipo_cuenta_proyecto_descripcion)throws Exception {
		try {
			this.id_presu_tipo_cuenta_proyecto_descripcion=newid_presu_tipo_cuenta_proyecto_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_presu_estado_descripcion(String newid_presu_estado_descripcion)throws Exception {
		try {
			this.id_presu_estado_descripcion=newid_presu_estado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_presu_proyecto_descripcion="";this.id_presu_tipo_cuenta_proyecto_descripcion="";this.id_cuenta_contable_descripcion="";this.id_empleado_descripcion="";this.id_presu_estado_descripcion="";
	}
	
	
	Object presuasignacionsDescripcionReporte;
	
	
	public Object getpresuasignacionsDescripcionReporte() {
		return presuasignacionsDescripcionReporte;
	}

	
	
	public  void  setpresuasignacionsDescripcionReporte(Object presuasignacions) {
		try {
			this.presuasignacionsDescripcionReporte=presuasignacions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

