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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.EmpresaConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class Empresa extends EmpresaAdditional implements Serializable ,Cloneable {//EmpresaAdditional,GeneralEntity
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
	
	private Empresa empresaOriginal;
	
	private Map<String, Object> mapEmpresa;
			
	public Map<String, Object> getMapEmpresa() {
		return mapEmpresa;
	}

	public void setMapEmpresa(Map<String, Object> mapEmpresa) {
		this.mapEmpresa = mapEmpresa;
	}
	
	public void inicializarMapEmpresa() {
		this.mapEmpresa = new HashMap<String,Object>();
	}
	
	public void setMapEmpresaValue(String sKey,Object oValue) {
		this.mapEmpresa.put(sKey, oValue);
	}
	
	public Object getMapEmpresaValue(String sKey) {
		return this.mapEmpresa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXNOMBRE,message=EmpresaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXDIRECCION,message=EmpresaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXRUC,message=EmpresaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXMAIL,message=EmpresaConstantesFunciones.SMENSAJEREGEXMAIL)
	private String mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXTELEFONO,message=EmpresaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXFAX,message=EmpresaConstantesFunciones.SMENSAJEREGEXFAX)
	private String fax;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXCODIGO_POSTAL,message=EmpresaConstantesFunciones.SMENSAJEREGEXCODIGO_POSTAL)
	private String codigo_postal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXACTIVIDAD_PRINCIPAL,message=EmpresaConstantesFunciones.SMENSAJEREGEXACTIVIDAD_PRINCIPAL)
	private String actividad_principal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXACTIVIDAD_SECUNDARIA,message=EmpresaConstantesFunciones.SMENSAJEREGEXACTIVIDAD_SECUNDARIA)
	private String actividad_secundaria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXCONTADOR_NOMBRE,message=EmpresaConstantesFunciones.SMENSAJEREGEXCONTADOR_NOMBRE)
	private String contador_nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXCONTADOR_RUC,message=EmpresaConstantesFunciones.SMENSAJEREGEXCONTADOR_RUC)
	private String contador_ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXCONTADOR_LICENCIA,message=EmpresaConstantesFunciones.SMENSAJEREGEXCONTADOR_LICENCIA)
	private String contador_licencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXREPRESENTANTE_NOMBRE,message=EmpresaConstantesFunciones.SMENSAJEREGEXREPRESENTANTE_NOMBRE)
	private String representante_nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmpresaConstantesFunciones.SREGEXREPRESENTANTE_CEDULA,message=EmpresaConstantesFunciones.SMENSAJEREGEXREPRESENTANTE_CEDULA)
	private String representante_cedula;
			
	
	public Pais pais;
	public Ciudad ciudad;
	public TipoEmpresa tipoempresa;
	
	
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String tipoempresa_descripcion;
	
	
	public List<Sucursal> sucursals;
		
	public Empresa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.empresaOriginal=this;
		
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_tipo_empresa=-1L;
 		this.nombre="";
 		this.direccion="";
 		this.ruc="";
 		this.mail="";
 		this.telefono="";
 		this.fax="";
 		this.codigo_postal="";
 		this.iva=0.0;
 		this.actividad_principal="";
 		this.actividad_secundaria="";
 		this.contador_nombre="";
 		this.contador_ruc="";
 		this.contador_licencia="";
 		this.representante_nombre="";
 		this.representante_cedula="";
		
		
		this.pais=null;
		this.ciudad=null;
		this.tipoempresa=null;
		
		
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.tipoempresa_descripcion="";
		
		
		this.sucursals=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Empresa (Long id,Date versionRow,Long id_pais,Long id_ciudad,Long id_tipo_empresa,String nombre,String direccion,String ruc,String mail,String telefono,String fax,String codigo_postal,Double iva,String actividad_principal,String actividad_secundaria,String contador_nombre,String contador_ruc,String contador_licencia,String representante_nombre,String representante_cedula) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empresaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_tipo_empresa=id_tipo_empresa;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.ruc=ruc;
 		this.mail=mail;
 		this.telefono=telefono;
 		this.fax=fax;
 		this.codigo_postal=codigo_postal;
 		this.iva=iva;
 		this.actividad_principal=actividad_principal;
 		this.actividad_secundaria=actividad_secundaria;
 		this.contador_nombre=contador_nombre;
 		this.contador_ruc=contador_ruc;
 		this.contador_licencia=contador_licencia;
 		this.representante_nombre=representante_nombre;
 		this.representante_cedula=representante_cedula;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Empresa (Long id_pais,Long id_ciudad,Long id_tipo_empresa,String nombre,String direccion,String ruc,String mail,String telefono,String fax,String codigo_postal,Double iva,String actividad_principal,String actividad_secundaria,String contador_nombre,String contador_ruc,String contador_licencia,String representante_nombre,String representante_cedula) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.empresaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_tipo_empresa=id_tipo_empresa;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.ruc=ruc;
 		this.mail=mail;
 		this.telefono=telefono;
 		this.fax=fax;
 		this.codigo_postal=codigo_postal;
 		this.iva=iva;
 		this.actividad_principal=actividad_principal;
 		this.actividad_secundaria=actividad_secundaria;
 		this.contador_nombre=contador_nombre;
 		this.contador_ruc=contador_ruc;
 		this.contador_licencia=contador_licencia;
 		this.representante_nombre=representante_nombre;
 		this.representante_cedula=representante_cedula;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Empresa empresaLocal=null;
		
		if(object!=null) {
			empresaLocal=(Empresa)object;
			
			if(empresaLocal!=null) {
				if(this.getId()!=null && empresaLocal.getId()!=null) {
					if(this.getId().equals(empresaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmpresaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmpresaConstantesFunciones.getEmpresaDescripcion(this);
		} else {
			sDetalle=EmpresaConstantesFunciones.getEmpresaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Empresa getEmpresaOriginal() {
		return this.empresaOriginal;
	}
	
	public void setEmpresaOriginal(Empresa empresa) {
		try {
			this.empresaOriginal=empresa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmpresaAdditional empresaAdditional=null;
	
	public EmpresaAdditional getEmpresaAdditional() {
		return this.empresaAdditional;
	}
	
	public void setEmpresaAdditional(EmpresaAdditional empresaAdditional) {
		try {
			this.empresaAdditional=empresaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_tipo_empresa() {
		return this.id_tipo_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getmail() {
		return this.mail;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getfax() {
		return this.fax;
	}
    
	
	public String getcodigo_postal() {
		return this.codigo_postal;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public String getactividad_principal() {
		return this.actividad_principal;
	}
    
	
	public String getactividad_secundaria() {
		return this.actividad_secundaria;
	}
    
	
	public String getcontador_nombre() {
		return this.contador_nombre;
	}
    
	
	public String getcontador_ruc() {
		return this.contador_ruc;
	}
    
	
	public String getcontador_licencia() {
		return this.contador_licencia;
	}
    
	
	public String getrepresentante_nombre() {
		return this.representante_nombre;
	}
    
	
	public String getrepresentante_cedula() {
		return this.representante_cedula;
	}
	
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_empresa(Long newid_tipo_empresa)throws Exception
	{
		try {
			if(this.id_tipo_empresa!=newid_tipo_empresa) {
				if(newid_tipo_empresa==null) {
					//newid_tipo_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna id_tipo_empresa");
					}
				}

				this.id_tipo_empresa=newid_tipo_empresa;
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
						System.out.println("Empresa:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
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
						System.out.println("Empresa:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmail(String newmail)throws Exception
	{
		try {
			if(this.mail!=newmail) {
				if(newmail==null) {
					//newmail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna mail");
					}
				}

				if(newmail!=null&&newmail.length()>100) {
					newmail=newmail.substring(0,98);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna mail");
				}

				this.mail=newmail;
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
						System.out.println("Empresa:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfax(String newfax)throws Exception
	{
		try {
			if(this.fax!=newfax) {
				if(newfax==null) {
					//newfax="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna fax");
					}
				}

				if(newfax!=null&&newfax.length()>50) {
					newfax=newfax.substring(0,48);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fax");
				}

				this.fax=newfax;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_postal(String newcodigo_postal)throws Exception
	{
		try {
			if(this.codigo_postal!=newcodigo_postal) {
				if(newcodigo_postal==null) {
					//newcodigo_postal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna codigo_postal");
					}
				}

				if(newcodigo_postal!=null&&newcodigo_postal.length()>50) {
					newcodigo_postal=newcodigo_postal.substring(0,48);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_postal");
				}

				this.codigo_postal=newcodigo_postal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactividad_principal(String newactividad_principal)throws Exception
	{
		try {
			if(this.actividad_principal!=newactividad_principal) {
				if(newactividad_principal==null) {
					//newactividad_principal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna actividad_principal");
					}
				}

				if(newactividad_principal!=null&&newactividad_principal.length()>150) {
					newactividad_principal=newactividad_principal.substring(0,148);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna actividad_principal");
				}

				this.actividad_principal=newactividad_principal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactividad_secundaria(String newactividad_secundaria)throws Exception
	{
		try {
			if(this.actividad_secundaria!=newactividad_secundaria) {
				if(newactividad_secundaria==null) {
					//newactividad_secundaria="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna actividad_secundaria");
					}
				}

				if(newactividad_secundaria!=null&&newactividad_secundaria.length()>150) {
					newactividad_secundaria=newactividad_secundaria.substring(0,148);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna actividad_secundaria");
				}

				this.actividad_secundaria=newactividad_secundaria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontador_nombre(String newcontador_nombre)throws Exception
	{
		try {
			if(this.contador_nombre!=newcontador_nombre) {
				if(newcontador_nombre==null) {
					//newcontador_nombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna contador_nombre");
					}
				}

				if(newcontador_nombre!=null&&newcontador_nombre.length()>150) {
					newcontador_nombre=newcontador_nombre.substring(0,148);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna contador_nombre");
				}

				this.contador_nombre=newcontador_nombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontador_ruc(String newcontador_ruc)throws Exception
	{
		try {
			if(this.contador_ruc!=newcontador_ruc) {
				if(newcontador_ruc==null) {
					//newcontador_ruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna contador_ruc");
					}
				}

				if(newcontador_ruc!=null&&newcontador_ruc.length()>15) {
					newcontador_ruc=newcontador_ruc.substring(0,13);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna contador_ruc");
				}

				this.contador_ruc=newcontador_ruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontador_licencia(String newcontador_licencia)throws Exception
	{
		try {
			if(this.contador_licencia!=newcontador_licencia) {
				if(newcontador_licencia==null) {
					//newcontador_licencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna contador_licencia");
					}
				}

				if(newcontador_licencia!=null&&newcontador_licencia.length()>15) {
					newcontador_licencia=newcontador_licencia.substring(0,13);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna contador_licencia");
				}

				this.contador_licencia=newcontador_licencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrepresentante_nombre(String newrepresentante_nombre)throws Exception
	{
		try {
			if(this.representante_nombre!=newrepresentante_nombre) {
				if(newrepresentante_nombre==null) {
					//newrepresentante_nombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna representante_nombre");
					}
				}

				if(newrepresentante_nombre!=null&&newrepresentante_nombre.length()>150) {
					newrepresentante_nombre=newrepresentante_nombre.substring(0,148);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna representante_nombre");
				}

				this.representante_nombre=newrepresentante_nombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrepresentante_cedula(String newrepresentante_cedula)throws Exception
	{
		try {
			if(this.representante_cedula!=newrepresentante_cedula) {
				if(newrepresentante_cedula==null) {
					//newrepresentante_cedula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Empresa:Valor nulo no permitido en columna representante_cedula");
					}
				}

				if(newrepresentante_cedula!=null&&newrepresentante_cedula.length()>15) {
					newrepresentante_cedula=newrepresentante_cedula.substring(0,13);
					System.out.println("Empresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna representante_cedula");
				}

				this.representante_cedula=newrepresentante_cedula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public TipoEmpresa getTipoEmpresa() {
		return this.tipoempresa;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String gettipoempresa_descripcion() {
		return this.tipoempresa_descripcion;
	}

	
	
	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoEmpresa(TipoEmpresa tipoempresa) {
		try {
			this.tipoempresa=tipoempresa;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoempresa_descripcion(String tipoempresa_descripcion) {
		try {
			this.tipoempresa_descripcion=tipoempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<Sucursal> getSucursals() {
		return this.sucursals;
	}

	
	
	public  void  setSucursals(List<Sucursal> sucursals) {
		try {
			this.sucursals=sucursals;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_pais_descripcion="";String id_ciudad_descripcion="";String id_tipo_empresa_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_tipo_empresa_descripcion() {
		return id_tipo_empresa_descripcion;
	}
	
	
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_empresa_descripcion(String newid_tipo_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_empresa_descripcion=newid_tipo_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_tipo_empresa_descripcion="";
	}
	
	
	Object sucursalsDescripcionReporte;
	
	
	public Object getsucursalsDescripcionReporte() {
		return sucursalsDescripcionReporte;
	}

	
	
	public  void  setsucursalsDescripcionReporte(Object sucursals) {
		try {
			this.sucursalsDescripcionReporte=sucursals;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

