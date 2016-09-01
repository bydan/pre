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
//import com.bydan.erp.seguridad.util.PerfilConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class Perfil extends PerfilAdditional implements Serializable ,Cloneable {//PerfilAdditional,GeneralEntity
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
	
	private Perfil perfilOriginal;
	
	private Map<String, Object> mapPerfil;
			
	public Map<String, Object> getMapPerfil() {
		return mapPerfil;
	}

	public void setMapPerfil(Map<String, Object> mapPerfil) {
		this.mapPerfil = mapPerfil;
	}
	
	public void inicializarMapPerfil() {
		this.mapPerfil = new HashMap<String,Object>();
	}
	
	public void setMapPerfilValue(String sKey,Object oValue) {
		this.mapPerfil.put(sKey, oValue);
	}
	
	public Object getMapPerfilValue(String sKey) {
		return this.mapPerfil.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PerfilConstantesFunciones.SREGEXCODIGO,message=PerfilConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PerfilConstantesFunciones.SREGEXNOMBRE,message=PerfilConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=400,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PerfilConstantesFunciones.SREGEXNOMBRE2,message=PerfilConstantesFunciones.SMENSAJEREGEXNOMBRE2)
	private String nombre2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Sistema sistema;
	
	
	private String sistema_descripcion;
	
	
	public List<UsuarioOpcion> usuarioopcions;
	public List<Usuario> usuarios;
	public List<PerfilUsuario> perfilusuarios;
	public List<PerfilOpcion> perfilopcions;
		
	public Perfil () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.perfilOriginal=this;
		
 		this.id_sistema=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.nombre2="";
 		this.estado=false;
		
		
		this.sistema=null;
		
		
		this.sistema_descripcion="";
		
		
		this.usuarioopcions=null;
		this.usuarios=null;
		this.perfilusuarios=null;
		this.perfilopcions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Perfil (Long id,Date versionRow,Long id_sistema,String codigo,String nombre,String nombre2,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.perfilOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre2=nombre2;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Perfil (Long id_sistema,String codigo,String nombre,String nombre2,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.perfilOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nombre2=nombre2;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Perfil perfilLocal=null;
		
		if(object!=null) {
			perfilLocal=(Perfil)object;
			
			if(perfilLocal!=null) {
				if(this.getId()!=null && perfilLocal.getId()!=null) {
					if(this.getId().equals(perfilLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PerfilConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PerfilConstantesFunciones.getPerfilDescripcion(this);
		} else {
			sDetalle=PerfilConstantesFunciones.getPerfilDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Perfil getPerfilOriginal() {
		return this.perfilOriginal;
	}
	
	public void setPerfilOriginal(Perfil perfil) {
		try {
			this.perfilOriginal=perfil;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PerfilAdditional perfilAdditional=null;
	
	public PerfilAdditional getPerfilAdditional() {
		return this.perfilAdditional;
	}
	
	public void setPerfilAdditional(PerfilAdditional perfilAdditional) {
		try {
			this.perfilAdditional=perfilAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_sistema() {
		return this.id_sistema;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnombre2() {
		return this.nombre2;
	}
    
	
	public Boolean getestado() {
		return this.estado;
	}
	
    
	public void setid_sistema(Long newid_sistema)throws Exception
	{
		try {
			if(this.id_sistema!=newid_sistema) {
				if(newid_sistema==null) {
					//newid_sistema=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Perfil:Valor nulo no permitido en columna id_sistema");
					}
				}

				this.id_sistema=newid_sistema;
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
						System.out.println("Perfil:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Perfil:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Perfil:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Perfil:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre2(String newnombre2)throws Exception
	{
		try {
			if(this.nombre2!=newnombre2) {
				if(newnombre2==null) {
					//newnombre2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Perfil:Valor nulo no permitido en columna nombre2");
					}
				}

				if(newnombre2!=null&&newnombre2.length()>400) {
					newnombre2=newnombre2.substring(0,398);
					System.out.println("Perfil:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=400 en columna nombre2");
				}

				this.nombre2=newnombre2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestado(Boolean newestado)throws Exception
	{
		try {
			if(this.estado!=newestado) {
				if(newestado==null) {
					//newestado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Perfil:Valor nulo no permitido en columna estado");
					}
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Sistema getSistema() {
		return this.sistema;
	}

	
	
	public String getsistema_descripcion() {
		return this.sistema_descripcion;
	}

	
	
	public  void  setSistema(Sistema sistema) {
		try {
			this.sistema=sistema;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setsistema_descripcion(String sistema_descripcion) {
		try {
			this.sistema_descripcion=sistema_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<UsuarioOpcion> getUsuarioOpcions() {
		return this.usuarioopcions;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public List<PerfilUsuario> getPerfilUsuarios() {
		return this.perfilusuarios;
	}

	public List<PerfilOpcion> getPerfilOpcions() {
		return this.perfilopcions;
	}

	
	
	public  void  setUsuarioOpcions(List<UsuarioOpcion> usuarioopcions) {
		try {
			this.usuarioopcions=usuarioopcions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setUsuarios(List<Usuario> usuarios) {
		try {
			this.usuarios=usuarios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPerfilUsuarios(List<PerfilUsuario> perfilusuarios) {
		try {
			this.perfilusuarios=perfilusuarios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPerfilOpcions(List<PerfilOpcion> perfilopcions) {
		try {
			this.perfilopcions=perfilopcions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_sistema_descripcion="";String estado_descripcion="";
	
	
	public String getid_sistema_descripcion() {
		return id_sistema_descripcion;
	}
	public String getestado_descripcion() {
		return estado_descripcion;
	}
	
	
	public void setid_sistema_descripcion(String newid_sistema_descripcion)throws Exception {
		try {
			this.id_sistema_descripcion=newid_sistema_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setestado_descripcion(String newestado_descripcion)throws Exception {
		try {
			this.estado_descripcion=newestado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_sistema_descripcion="";this.estado_descripcion="";
	}
	
	
	Object perfilaccionsDescripcionReporte;
	Object perfilcamposDescripcionReporte;
	Object accionsDescripcionReporte;
	Object perfilopcionsDescripcionReporte;
	Object perfilusuariosDescripcionReporte;
	Object camposDescripcionReporte;
	Object usuariosDescripcionReporte;
	Object usuarioopcionsDescripcionReporte;
	
	
	public Object getperfilaccionsDescripcionReporte() {
		return perfilaccionsDescripcionReporte;
	}

	public Object getperfilcamposDescripcionReporte() {
		return perfilcamposDescripcionReporte;
	}

	public Object getaccionsDescripcionReporte() {
		return accionsDescripcionReporte;
	}

	public Object getperfilopcionsDescripcionReporte() {
		return perfilopcionsDescripcionReporte;
	}

	public Object getperfilusuariosDescripcionReporte() {
		return perfilusuariosDescripcionReporte;
	}

	public Object getcamposDescripcionReporte() {
		return camposDescripcionReporte;
	}

	public Object getusuariosDescripcionReporte() {
		return usuariosDescripcionReporte;
	}

	public Object getusuarioopcionsDescripcionReporte() {
		return usuarioopcionsDescripcionReporte;
	}

	
	
	public  void  setperfilaccionsDescripcionReporte(Object perfilaccions) {
		try {
			this.perfilaccionsDescripcionReporte=perfilaccions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setperfilcamposDescripcionReporte(Object perfilcampos) {
		try {
			this.perfilcamposDescripcionReporte=perfilcampos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setaccionsDescripcionReporte(Object accions) {
		try {
			this.accionsDescripcionReporte=accions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setperfilopcionsDescripcionReporte(Object perfilopcions) {
		try {
			this.perfilopcionsDescripcionReporte=perfilopcions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setperfilusuariosDescripcionReporte(Object perfilusuarios) {
		try {
			this.perfilusuariosDescripcionReporte=perfilusuarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcamposDescripcionReporte(Object campos) {
		try {
			this.camposDescripcionReporte=campos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setusuariosDescripcionReporte(Object usuarios) {
		try {
			this.usuariosDescripcionReporte=usuarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setusuarioopcionsDescripcionReporte(Object usuarioopcions) {
		try {
			this.usuarioopcionsDescripcionReporte=usuarioopcions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

