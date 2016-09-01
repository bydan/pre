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
//import com.bydan.erp.seguridad.util.UsuarioOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class UsuarioOpcion extends UsuarioOpcionAdditional implements Serializable ,Cloneable {//UsuarioOpcionAdditional,GeneralEntity
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
	
	private UsuarioOpcion usuarioopcionOriginal;
	
	private Map<String, Object> mapUsuarioOpcion;
			
	public Map<String, Object> getMapUsuarioOpcion() {
		return mapUsuarioOpcion;
	}

	public void setMapUsuarioOpcion(Map<String, Object> mapUsuarioOpcion) {
		this.mapUsuarioOpcion = mapUsuarioOpcion;
	}
	
	public void inicializarMapUsuarioOpcion() {
		this.mapUsuarioOpcion = new HashMap<String,Object>();
	}
	
	public void setMapUsuarioOpcionValue(String sKey,Object oValue) {
		this.mapUsuarioOpcion.put(sKey, oValue);
	}
	
	public Object getMapUsuarioOpcionValue(String sKey) {
		return this.mapUsuarioOpcion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_opcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_opcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_perfil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precargar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Sistema sistema;
	public Modulo modulo;
	public GrupoOpcion grupoopcion;
	public Opcion opcion;
	public Perfil perfil;
	public Usuario usuario;
	
	
	private String sistema_descripcion;
	private String modulo_descripcion;
	private String grupoopcion_descripcion;
	private String opcion_descripcion;
	private String perfil_descripcion;
	private String usuario_descripcion;
	
	
		
	public UsuarioOpcion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.usuarioopcionOriginal=this;
		
 		this.id_sistema=-1L;
 		this.id_modulo=-1L;
 		this.id_grupo_opcion=null;
 		this.id_opcion=-1L;
 		this.id_perfil=-1L;
 		this.id_usuario=-1L;
 		this.con_precargar=false;
 		this.estado=false;
		
		
		this.sistema=null;
		this.modulo=null;
		this.grupoopcion=null;
		this.opcion=null;
		this.perfil=null;
		this.usuario=null;
		
		
		this.sistema_descripcion="";
		this.modulo_descripcion="";
		this.grupoopcion_descripcion="";
		this.opcion_descripcion="";
		this.perfil_descripcion="";
		this.usuario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public UsuarioOpcion (Long id,Date versionRow,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_opcion,Long id_perfil,Long id_usuario,Boolean con_precargar,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.usuarioopcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_opcion=id_opcion;
 		this.id_perfil=id_perfil;
 		this.id_usuario=id_usuario;
 		this.con_precargar=con_precargar;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public UsuarioOpcion (Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_opcion,Long id_perfil,Long id_usuario,Boolean con_precargar,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.usuarioopcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_opcion=id_opcion;
 		this.id_perfil=id_perfil;
 		this.id_usuario=id_usuario;
 		this.con_precargar=con_precargar;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		UsuarioOpcion usuarioopcionLocal=null;
		
		if(object!=null) {
			usuarioopcionLocal=(UsuarioOpcion)object;
			
			if(usuarioopcionLocal!=null) {
				if(this.getId()!=null && usuarioopcionLocal.getId()!=null) {
					if(this.getId().equals(usuarioopcionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UsuarioOpcionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UsuarioOpcionConstantesFunciones.getUsuarioOpcionDescripcion(this);
		} else {
			sDetalle=UsuarioOpcionConstantesFunciones.getUsuarioOpcionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public UsuarioOpcion getUsuarioOpcionOriginal() {
		return this.usuarioopcionOriginal;
	}
	
	public void setUsuarioOpcionOriginal(UsuarioOpcion usuarioopcion) {
		try {
			this.usuarioopcionOriginal=usuarioopcion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UsuarioOpcionAdditional usuarioopcionAdditional=null;
	
	public UsuarioOpcionAdditional getUsuarioOpcionAdditional() {
		return this.usuarioopcionAdditional;
	}
	
	public void setUsuarioOpcionAdditional(UsuarioOpcionAdditional usuarioopcionAdditional) {
		try {
			this.usuarioopcionAdditional=usuarioopcionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_sistema() {
		return this.id_sistema;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_grupo_opcion() {
		return this.id_grupo_opcion;
	}
    
	
	public Long getid_opcion() {
		return this.id_opcion;
	}
    
	
	public Long getid_perfil() {
		return this.id_perfil;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Boolean getcon_precargar() {
		return this.con_precargar;
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
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna id_sistema");
					}
				}

				this.id_sistema=newid_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_opcion(Long newid_grupo_opcion) {
		if(this.id_grupo_opcion==null&&newid_grupo_opcion!=null) {
			this.id_grupo_opcion=newid_grupo_opcion;
				this.setIsChanged(true);
		}

		if(this.id_grupo_opcion!=null&&!this.id_grupo_opcion.equals(newid_grupo_opcion)) {

			this.id_grupo_opcion=newid_grupo_opcion;
				this.setIsChanged(true);
		}
	}
    
	public void setid_opcion(Long newid_opcion)throws Exception
	{
		try {
			if(this.id_opcion!=newid_opcion) {
				if(newid_opcion==null) {
					//newid_opcion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna id_opcion");
					}
				}

				this.id_opcion=newid_opcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_perfil(Long newid_perfil)throws Exception
	{
		try {
			if(this.id_perfil!=newid_perfil) {
				if(newid_perfil==null) {
					//newid_perfil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna id_perfil");
					}
				}

				this.id_perfil=newid_perfil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_precargar(Boolean newcon_precargar)throws Exception
	{
		try {
			if(this.con_precargar!=newcon_precargar) {
				if(newcon_precargar==null) {
					//newcon_precargar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna con_precargar");
					}
				}

				this.con_precargar=newcon_precargar;
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
						System.out.println("UsuarioOpcion:Valor nulo no permitido en columna estado");
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

	public Modulo getModulo() {
		return this.modulo;
	}

	public GrupoOpcion getGrupoOpcion() {
		return this.grupoopcion;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	
	
	public String getsistema_descripcion() {
		return this.sistema_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getgrupoopcion_descripcion() {
		return this.grupoopcion_descripcion;
	}

	public String getopcion_descripcion() {
		return this.opcion_descripcion;
	}

	public String getperfil_descripcion() {
		return this.perfil_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	
	
	public  void  setSistema(Sistema sistema) {
		try {
			this.sistema=sistema;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoOpcion(GrupoOpcion grupoopcion) {
		try {
			this.grupoopcion=grupoopcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setOpcion(Opcion opcion) {
		try {
			this.opcion=opcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPerfil(Perfil perfil) {
		try {
			this.perfil=perfil;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupoopcion_descripcion(String grupoopcion_descripcion) {
		try {
			this.grupoopcion_descripcion=grupoopcion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setopcion_descripcion(String opcion_descripcion) {
		try {
			this.opcion_descripcion=opcion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperfil_descripcion(String perfil_descripcion) {
		try {
			this.perfil_descripcion=perfil_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_sistema_descripcion="";String id_modulo_descripcion="";String id_grupo_opcion_descripcion="";String id_opcion_descripcion="";String id_perfil_descripcion="";String id_usuario_descripcion="";String con_precargar_descripcion="";String estado_descripcion="";
	
	
	public String getid_sistema_descripcion() {
		return id_sistema_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_grupo_opcion_descripcion() {
		return id_grupo_opcion_descripcion;
	}
	public String getid_opcion_descripcion() {
		return id_opcion_descripcion;
	}
	public String getid_perfil_descripcion() {
		return id_perfil_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getcon_precargar_descripcion() {
		return con_precargar_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_opcion_descripcion(String newid_grupo_opcion_descripcion)throws Exception {
		try {
			this.id_grupo_opcion_descripcion=newid_grupo_opcion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_opcion_descripcion(String newid_opcion_descripcion)throws Exception {
		try {
			this.id_opcion_descripcion=newid_opcion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_perfil_descripcion(String newid_perfil_descripcion)throws Exception {
		try {
			this.id_perfil_descripcion=newid_perfil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_precargar_descripcion(String newcon_precargar_descripcion)throws Exception {
		try {
			this.con_precargar_descripcion=newcon_precargar_descripcion;
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
		this.id_sistema_descripcion="";this.id_modulo_descripcion="";this.id_grupo_opcion_descripcion="";this.id_opcion_descripcion="";this.id_perfil_descripcion="";this.id_usuario_descripcion="";this.con_precargar_descripcion="";this.estado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

