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
//import com.bydan.erp.seguridad.util.DatoGeneralUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class DatoGeneralUsuario extends DatoGeneralUsuarioAdditional implements Serializable ,Cloneable {//DatoGeneralUsuarioAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private DatoGeneralUsuario datogeneralusuarioOriginal;
	
	private Map<String, Object> mapDatoGeneralUsuario;
			
	public Map<String, Object> getMapDatoGeneralUsuario() {
		return mapDatoGeneralUsuario;
	}

	public void setMapDatoGeneralUsuario(Map<String, Object> mapDatoGeneralUsuario) {
		this.mapDatoGeneralUsuario = mapDatoGeneralUsuario;
	}
	
	public void inicializarMapDatoGeneralUsuario() {
		this.mapDatoGeneralUsuario = new HashMap<String,Object>();
	}
	
	public void setMapDatoGeneralUsuarioValue(String sKey,Object oValue) {
		this.mapDatoGeneralUsuario.put(sKey, oValue);
	}
	
	public Object getMapDatoGeneralUsuarioValue(String sKey) {
		return this.mapDatoGeneralUsuario.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXCEDULA,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXCEDULA)
	private String cedula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXAPELLIDOS,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXAPELLIDOS)
	private String apellidos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXNOMBRES,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXNOMBRES)
	private String nombres;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXTELEFONO,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXTELEFONO_MOVIL,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXTELEFONO_MOVIL)
	private String telefono_movil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXE_MAIL,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXE_MAIL)
	private String e_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXURL,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXURL)
	private String url;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoGeneralUsuarioConstantesFunciones.SREGEXDIRECCION,message=DatoGeneralUsuarioConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
			
	
	public Usuario usuario;
	public Pais pais;
	public Provincia provincia;
	public Ciudad ciudad;
	
	
	private String usuario_descripcion;
	private String pais_descripcion;
	private String provincia_descripcion;
	private String ciudad_descripcion;
	
	
		
	public DatoGeneralUsuario () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.datogeneralusuarioOriginal=this;
		
 		this.id_pais=-1L;
 		this.id_provincia=-1L;
 		this.id_ciudad=-1L;
 		this.cedula="";
 		this.apellidos="";
 		this.nombres="";
 		this.telefono="";
 		this.telefono_movil="";
 		this.e_mail="";
 		this.url="";
 		this.fecha_nacimiento=new Date();
 		this.direccion="";
		
		
		this.usuario=null;
		this.pais=null;
		this.provincia=null;
		this.ciudad=null;
		
		
		this.usuario_descripcion="";
		this.pais_descripcion="";
		this.provincia_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DatoGeneralUsuario (Long id,Date versionRow,Long id_pais,Long id_provincia,Long id_ciudad,String cedula,String apellidos,String nombres,String telefono,String telefono_movil,String e_mail,String url,Date fecha_nacimiento,String direccion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datogeneralusuarioOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.cedula=cedula;
 		this.apellidos=apellidos;
 		this.nombres=nombres;
 		this.telefono=telefono;
 		this.telefono_movil=telefono_movil;
 		this.e_mail=e_mail;
 		this.url=url;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.direccion=direccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DatoGeneralUsuario (Long id_pais,Long id_provincia,Long id_ciudad,String cedula,String apellidos,String nombres,String telefono,String telefono_movil,String e_mail,String url,Date fecha_nacimiento,String direccion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datogeneralusuarioOriginal=this;
		
 		
 		this.id_pais=id_pais;
 		this.id_provincia=id_provincia;
 		this.id_ciudad=id_ciudad;
 		this.cedula=cedula;
 		this.apellidos=apellidos;
 		this.nombres=nombres;
 		this.telefono=telefono;
 		this.telefono_movil=telefono_movil;
 		this.e_mail=e_mail;
 		this.url=url;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.direccion=direccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DatoGeneralUsuario datogeneralusuarioLocal=null;
		
		if(object!=null) {
			datogeneralusuarioLocal=(DatoGeneralUsuario)object;
			
			if(datogeneralusuarioLocal!=null) {
				if(this.getId()!=null && datogeneralusuarioLocal.getId()!=null) {
					if(this.getId().equals(datogeneralusuarioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DatoGeneralUsuarioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DatoGeneralUsuarioConstantesFunciones.getDatoGeneralUsuarioDescripcion(this);
		} else {
			sDetalle=DatoGeneralUsuarioConstantesFunciones.getDatoGeneralUsuarioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DatoGeneralUsuario getDatoGeneralUsuarioOriginal() {
		return this.datogeneralusuarioOriginal;
	}
	
	public void setDatoGeneralUsuarioOriginal(DatoGeneralUsuario datogeneralusuario) {
		try {
			this.datogeneralusuarioOriginal=datogeneralusuario;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DatoGeneralUsuarioAdditional datogeneralusuarioAdditional=null;
	
	public DatoGeneralUsuarioAdditional getDatoGeneralUsuarioAdditional() {
		return this.datogeneralusuarioAdditional;
	}
	
	public void setDatoGeneralUsuarioAdditional(DatoGeneralUsuarioAdditional datogeneralusuarioAdditional) {
		try {
			this.datogeneralusuarioAdditional=datogeneralusuarioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_usuario() {
		this.id_usuario=this.id;

		return this.id_usuario;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public String getcedula() {
		return this.cedula;
	}
    
	
	public String getapellidos() {
		return this.apellidos;
	}
    
	
	public String getnombres() {
		return this.nombres;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gettelefono_movil() {
		return this.telefono_movil;
	}
    
	
	public String gete_mail() {
		return this.e_mail;
	}
    
	
	public String geturl() {
		return this.url;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
	
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=null && this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			} else if(this.id_usuario==null && newid_usuario!=null) {
				this.id_usuario=newid_usuario;
				this.id=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
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
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcedula(String newcedula)throws Exception
	{
		try {
			if(this.cedula.trim()!=newcedula) {
				if(newcedula==null) {
					//newcedula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna cedula");
					}
				}

				if(newcedula!=null&&newcedula.length()>20) {
					newcedula=newcedula.substring(0,18);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna cedula");
				}

				this.cedula=newcedula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellidos(String newapellidos)throws Exception
	{
		try {
			if(this.apellidos!=newapellidos) {
				if(newapellidos==null) {
					//newapellidos="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna apellidos");
					}
				}

				if(newapellidos!=null&&newapellidos.length()>200) {
					newapellidos=newapellidos.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna apellidos");
				}

				this.apellidos=newapellidos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombres(String newnombres)throws Exception
	{
		try {
			if(this.nombres!=newnombres) {
				if(newnombres==null) {
					//newnombres="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna nombres");
					}
				}

				if(newnombres!=null&&newnombres.length()>200) {
					newnombres=newnombres.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombres");
				}

				this.nombres=newnombres;
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
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>200) {
					newtelefono=newtelefono.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_movil(String newtelefono_movil)throws Exception
	{
		try {
			if(this.telefono_movil!=newtelefono_movil) {
				if(newtelefono_movil==null) {
					//newtelefono_movil="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna telefono_movil");
					}
				}

				if(newtelefono_movil!=null&&newtelefono_movil.length()>200) {
					newtelefono_movil=newtelefono_movil.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_movil");
				}

				this.telefono_movil=newtelefono_movil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sete_mail(String newe_mail)throws Exception
	{
		try {
			if(this.e_mail!=newe_mail) {
				if(newe_mail==null) {
					//newe_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna e_mail");
					}
				}

				if(newe_mail!=null&&newe_mail.length()>200) {
					newe_mail=newe_mail.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna e_mail");
				}

				this.e_mail=newe_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void seturl(String newurl)throws Exception
	{
		try {
			if(this.url!=newurl) {
				if(newurl==null) {
					//newurl="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna url");
					}
				}

				if(newurl!=null&&newurl.length()>200) {
					newurl=newurl.substring(0,198);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna url");
				}

				this.url=newurl;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
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
						System.out.println("DatoGeneralUsuario:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("DatoGeneralUsuario:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	
	
	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
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


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_usuarioUsuario_descripcion="";String id_pais_descripcion="";String id_provincia_descripcion="";String id_ciudad_descripcion="";
	
	
	public String getid_usuarioUsuario_descripcion() {
		return id_usuarioUsuario_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	
	
	public void setid_usuarioUsuario_descripcion(String newid_usuarioUsuario_descripcion)throws Exception {
		try {
			this.id_usuarioUsuario_descripcion=newid_usuarioUsuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
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
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";this.id_provincia_descripcion="";this.id_ciudad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

