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
//import com.bydan.erp.nomina.util.NumeroPatronalConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class NumeroPatronal extends NumeroPatronalAdditional implements Serializable ,Cloneable {//NumeroPatronalAdditional,GeneralEntity
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
	
	private NumeroPatronal numeropatronalOriginal;
	
	private Map<String, Object> mapNumeroPatronal;
			
	public Map<String, Object> getMapNumeroPatronal() {
		return mapNumeroPatronal;
	}

	public void setMapNumeroPatronal(Map<String, Object> mapNumeroPatronal) {
		this.mapNumeroPatronal = mapNumeroPatronal;
	}
	
	public void inicializarMapNumeroPatronal() {
		this.mapNumeroPatronal = new HashMap<String,Object>();
	}
	
	public void setMapNumeroPatronalValue(String sKey,Object oValue) {
		this.mapNumeroPatronal.put(sKey, oValue);
	}
	
	public Object getMapNumeroPatronalValue(String sKey) {
		return this.mapNumeroPatronal.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_canton;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parroquia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXNUMERO,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXNUMERO)
	private String numero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXCODIGO_ACTIVIDAD,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXCODIGO_ACTIVIDAD)
	private String codigo_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXAPELLIDO,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXNOMBRE,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXCEDULA,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXCEDULA)
	private String cedula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXTELEFONO,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=NumeroPatronalConstantesFunciones.SREGEXDESCRIPCION,message=NumeroPatronalConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Provincia provincia;
	public Canton canton;
	public Parroquia parroquia;
	
	
	private String empresa_descripcion;
	private String provincia_descripcion;
	private String canton_descripcion;
	private String parroquia_descripcion;
	
	
	public List<DatoGeneralEmpleado> datogeneralempleados;
	public List<Estructura> estructuras;
	public List<Cargo> cargos;
		
	public NumeroPatronal () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.numeropatronalOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_provincia=-1L;
 		this.id_canton=-1L;
 		this.id_parroquia=-1L;
 		this.numero="";
 		this.codigo_actividad="";
 		this.apellido="";
 		this.nombre="";
 		this.cedula="";
 		this.telefono="";
 		this.descripcion="";
		
		
		this.empresa=null;
		this.provincia=null;
		this.canton=null;
		this.parroquia=null;
		
		
		this.empresa_descripcion="";
		this.provincia_descripcion="";
		this.canton_descripcion="";
		this.parroquia_descripcion="";
		
		
		this.datogeneralempleados=null;
		this.estructuras=null;
		this.cargos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public NumeroPatronal (Long id,Date versionRow,Long id_empresa,Long id_provincia,Long id_canton,Long id_parroquia,String numero,String codigo_actividad,String apellido,String nombre,String cedula,String telefono,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.numeropatronalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.numero=numero;
 		this.codigo_actividad=codigo_actividad;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.cedula=cedula;
 		this.telefono=telefono;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public NumeroPatronal (Long id_empresa,Long id_provincia,Long id_canton,Long id_parroquia,String numero,String codigo_actividad,String apellido,String nombre,String cedula,String telefono,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.numeropatronalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.numero=numero;
 		this.codigo_actividad=codigo_actividad;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.cedula=cedula;
 		this.telefono=telefono;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		NumeroPatronal numeropatronalLocal=null;
		
		if(object!=null) {
			numeropatronalLocal=(NumeroPatronal)object;
			
			if(numeropatronalLocal!=null) {
				if(this.getId()!=null && numeropatronalLocal.getId()!=null) {
					if(this.getId().equals(numeropatronalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!NumeroPatronalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcion(this);
		} else {
			sDetalle=NumeroPatronalConstantesFunciones.getNumeroPatronalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public NumeroPatronal getNumeroPatronalOriginal() {
		return this.numeropatronalOriginal;
	}
	
	public void setNumeroPatronalOriginal(NumeroPatronal numeropatronal) {
		try {
			this.numeropatronalOriginal=numeropatronal;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected NumeroPatronalAdditional numeropatronalAdditional=null;
	
	public NumeroPatronalAdditional getNumeroPatronalAdditional() {
		return this.numeropatronalAdditional;
	}
	
	public void setNumeroPatronalAdditional(NumeroPatronalAdditional numeropatronalAdditional) {
		try {
			this.numeropatronalAdditional=numeropatronalAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_canton() {
		return this.id_canton;
	}
    
	
	public Long getid_parroquia() {
		return this.id_parroquia;
	}
    
	
	public String getnumero() {
		return this.numero;
	}
    
	
	public String getcodigo_actividad() {
		return this.codigo_actividad;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcedula() {
		return this.cedula;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_canton(Long newid_canton)throws Exception
	{
		try {
			if(this.id_canton!=newid_canton) {
				if(newid_canton==null) {
					//newid_canton=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna id_canton");
					}
				}

				this.id_canton=newid_canton;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parroquia(Long newid_parroquia)throws Exception
	{
		try {
			if(this.id_parroquia!=newid_parroquia) {
				if(newid_parroquia==null) {
					//newid_parroquia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna id_parroquia");
					}
				}

				this.id_parroquia=newid_parroquia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero(String newnumero)throws Exception
	{
		try {
			if(this.numero!=newnumero) {
				if(newnumero==null) {
					//newnumero="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna numero");
					}
				}

				if(newnumero!=null&&newnumero.length()>50) {
					newnumero=newnumero.substring(0,48);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero");
				}

				this.numero=newnumero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_actividad(String newcodigo_actividad)throws Exception
	{
		try {
			if(this.codigo_actividad!=newcodigo_actividad) {
				if(newcodigo_actividad==null) {
					//newcodigo_actividad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna codigo_actividad");
					}
				}

				if(newcodigo_actividad!=null&&newcodigo_actividad.length()>50) {
					newcodigo_actividad=newcodigo_actividad.substring(0,48);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_actividad");
				}

				this.codigo_actividad=newcodigo_actividad;
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
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>150) {
					newapellido=newapellido.substring(0,148);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna apellido");
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
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna cedula");
					}
				}

				if(newcedula!=null&&newcedula.length()>20) {
					newcedula=newcedula.substring(0,18);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna cedula");
				}

				this.cedula=newcedula;
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
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
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
						System.out.println("NumeroPatronal:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("NumeroPatronal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public Parroquia getParroquia() {
		return this.parroquia;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getcanton_descripcion() {
		return this.canton_descripcion;
	}

	public String getparroquia_descripcion() {
		return this.parroquia_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCanton(Canton canton) {
		try {
			this.canton=canton;
		} catch(Exception e) {
			;
		}
	}


	public  void  setParroquia(Parroquia parroquia) {
		try {
			this.parroquia=parroquia;
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


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcanton_descripcion(String canton_descripcion) {
		try {
			this.canton_descripcion=canton_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setparroquia_descripcion(String parroquia_descripcion) {
		try {
			this.parroquia_descripcion=parroquia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	public List<Estructura> getEstructuras() {
		return this.estructuras;
	}

	public List<Cargo> getCargos() {
		return this.cargos;
	}

	
	
	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEstructuras(List<Estructura> estructuras) {
		try {
			this.estructuras=estructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCargos(List<Cargo> cargos) {
		try {
			this.cargos=cargos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_provincia_descripcion="";String id_canton_descripcion="";String id_parroquia_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_canton_descripcion() {
		return id_canton_descripcion;
	}
	public String getid_parroquia_descripcion() {
		return id_parroquia_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_canton_descripcion(String newid_canton_descripcion)throws Exception {
		try {
			this.id_canton_descripcion=newid_canton_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_parroquia_descripcion(String newid_parroquia_descripcion)throws Exception {
		try {
			this.id_parroquia_descripcion=newid_parroquia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_provincia_descripcion="";this.id_canton_descripcion="";this.id_parroquia_descripcion="";
	}
	
	
	Object datogeneralempleadosDescripcionReporte;
	Object estructurasDescripcionReporte;
	Object cargosDescripcionReporte;
	
	
	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getestructurasDescripcionReporte() {
		return estructurasDescripcionReporte;
	}

	public Object getcargosDescripcionReporte() {
		return cargosDescripcionReporte;
	}

	
	
	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setestructurasDescripcionReporte(Object estructuras) {
		try {
			this.estructurasDescripcionReporte=estructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcargosDescripcionReporte(Object cargos) {
		try {
			this.cargosDescripcionReporte=cargos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

