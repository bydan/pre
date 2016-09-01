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
//import com.bydan.erp.nomina.util.ReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Referencia extends ReferenciaAdditional implements Serializable ,Cloneable {//ReferenciaAdditional,GeneralEntity
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
	
	private Referencia referenciaOriginal;
	
	private Map<String, Object> mapReferencia;
			
	public Map<String, Object> getMapReferencia() {
		return mapReferencia;
	}

	public void setMapReferencia(Map<String, Object> mapReferencia) {
		this.mapReferencia = mapReferencia;
	}
	
	public void inicializarMapReferencia() {
		this.mapReferencia = new HashMap<String,Object>();
	}
	
	public void setMapReferenciaValue(String sKey,Object oValue) {
		this.mapReferencia.put(sKey, oValue);
	}
	
	public Object getMapReferenciaValue(String sKey) {
		return this.mapReferencia.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parentezco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_profesion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaConstantesFunciones.SREGEXCEDULA,message=ReferenciaConstantesFunciones.SMENSAJEREGEXCEDULA)
	private String cedula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaConstantesFunciones.SREGEXAPELLIDO,message=ReferenciaConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaConstantesFunciones.SREGEXNOMBRE,message=ReferenciaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaConstantesFunciones.SREGEXDIRECCION,message=ReferenciaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaConstantesFunciones.SREGEXTELEFONO,message=ReferenciaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Parentezco parentezco;
	public Profesion profesion;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String parentezco_descripcion;
	private String profesion_descripcion;
	
	
	public List<TelefonoReferencia> telefonoreferencias;
		
	public Referencia () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.referenciaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_parentezco=-1L;
 		this.id_profesion=-1L;
 		this.cedula="";
 		this.apellido="";
 		this.nombre="";
 		this.direccion="";
 		this.telefono="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.parentezco=null;
		this.profesion=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.parentezco_descripcion="";
		this.profesion_descripcion="";
		
		
		this.telefonoreferencias=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Referencia (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_parentezco,Long id_profesion,String cedula,String apellido,String nombre,String direccion,String telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_parentezco=id_parentezco;
 		this.id_profesion=id_profesion;
 		this.cedula=cedula;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Referencia (Long id_empresa,Long id_empleado,Long id_parentezco,Long id_profesion,String cedula,String apellido,String nombre,String direccion,String telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_parentezco=id_parentezco;
 		this.id_profesion=id_profesion;
 		this.cedula=cedula;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Referencia referenciaLocal=null;
		
		if(object!=null) {
			referenciaLocal=(Referencia)object;
			
			if(referenciaLocal!=null) {
				if(this.getId()!=null && referenciaLocal.getId()!=null) {
					if(this.getId().equals(referenciaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ReferenciaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ReferenciaConstantesFunciones.getReferenciaDescripcion(this);
		} else {
			sDetalle=ReferenciaConstantesFunciones.getReferenciaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Referencia getReferenciaOriginal() {
		return this.referenciaOriginal;
	}
	
	public void setReferenciaOriginal(Referencia referencia) {
		try {
			this.referenciaOriginal=referencia;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ReferenciaAdditional referenciaAdditional=null;
	
	public ReferenciaAdditional getReferenciaAdditional() {
		return this.referenciaAdditional;
	}
	
	public void setReferenciaAdditional(ReferenciaAdditional referenciaAdditional) {
		try {
			this.referenciaAdditional=referenciaAdditional;
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
    
	
	public Long getid_parentezco() {
		return this.id_parentezco;
	}
    
	
	public Long getid_profesion() {
		return this.id_profesion;
	}
    
	
	public String getcedula() {
		return this.cedula;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Referencia:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parentezco(Long newid_parentezco)throws Exception
	{
		try {
			if(this.id_parentezco!=newid_parentezco) {
				if(newid_parentezco==null) {
					//newid_parentezco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna id_parentezco");
					}
				}

				this.id_parentezco=newid_parentezco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_profesion(Long newid_profesion)throws Exception
	{
		try {
			if(this.id_profesion!=newid_profesion) {
				if(newid_profesion==null) {
					//newid_profesion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna id_profesion");
					}
				}

				this.id_profesion=newid_profesion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcedula(String newcedula)throws Exception
	{
		try {
			if(this.cedula!=newcedula) {
				if(newcedula==null) {
					//newcedula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna cedula");
					}
				}

				if(newcedula!=null&&newcedula.length()>15) {
					newcedula=newcedula.substring(0,13);
					System.out.println("Referencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna cedula");
				}

				this.cedula=newcedula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>50) {
					newapellido=newapellido.substring(0,48);
					System.out.println("Referencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("Referencia:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Referencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Referencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Referencia:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Referencia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
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

	public Parentezco getParentezco() {
		return this.parentezco;
	}

	public Profesion getProfesion() {
		return this.profesion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getparentezco_descripcion() {
		return this.parentezco_descripcion;
	}

	public String getprofesion_descripcion() {
		return this.profesion_descripcion;
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


	public  void  setParentezco(Parentezco parentezco) {
		try {
			this.parentezco=parentezco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProfesion(Profesion profesion) {
		try {
			this.profesion=profesion;
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


	public  void  setparentezco_descripcion(String parentezco_descripcion) {
		try {
			this.parentezco_descripcion=parentezco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprofesion_descripcion(String profesion_descripcion) {
		try {
			this.profesion_descripcion=profesion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<TelefonoReferencia> getTelefonoReferencias() {
		return this.telefonoreferencias;
	}

	
	
	public  void  setTelefonoReferencias(List<TelefonoReferencia> telefonoreferencias) {
		try {
			this.telefonoreferencias=telefonoreferencias;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_parentezco_descripcion="";String id_profesion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_parentezco_descripcion() {
		return id_parentezco_descripcion;
	}
	public String getid_profesion_descripcion() {
		return id_profesion_descripcion;
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
	public void setid_parentezco_descripcion(String newid_parentezco_descripcion)throws Exception {
		try {
			this.id_parentezco_descripcion=newid_parentezco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_profesion_descripcion(String newid_profesion_descripcion)throws Exception {
		try {
			this.id_profesion_descripcion=newid_profesion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_parentezco_descripcion="";this.id_profesion_descripcion="";
	}
	
	
	Object telefonoreferenciasDescripcionReporte;
	
	
	public Object gettelefonoreferenciasDescripcionReporte() {
		return telefonoreferenciasDescripcionReporte;
	}

	
	
	public  void  settelefonoreferenciasDescripcionReporte(Object telefonoreferencias) {
		try {
			this.telefonoreferenciasDescripcionReporte=telefonoreferencias;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

