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
//import com.bydan.erp.seguridad.util.GrupoOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class GrupoOpcion extends GrupoOpcionAdditional implements Serializable ,Cloneable {//GrupoOpcionAdditional,GeneralEntity
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
	
	private GrupoOpcion grupoopcionOriginal;
	
	private Map<String, Object> mapGrupoOpcion;
			
	public Map<String, Object> getMapGrupoOpcion() {
		return mapGrupoOpcion;
	}

	public void setMapGrupoOpcion(Map<String, Object> mapGrupoOpcion) {
		this.mapGrupoOpcion = mapGrupoOpcion;
	}
	
	public void inicializarMapGrupoOpcion() {
		this.mapGrupoOpcion = new HashMap<String,Object>();
	}
	
	public void setMapGrupoOpcionValue(String sKey,Object oValue) {
		this.mapGrupoOpcion.put(sKey, oValue);
	}
	
	public Object getMapGrupoOpcionValue(String sKey) {
		return this.mapGrupoOpcion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=GrupoOpcionConstantesFunciones.SREGEXCODIGO,message=GrupoOpcionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=GrupoOpcionConstantesFunciones.SREGEXNOMBRE_PRINCIPAL,message=GrupoOpcionConstantesFunciones.SMENSAJEREGEXNOMBRE_PRINCIPAL)
	private String nombre_principal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Modulo modulo;
	
	
	private String modulo_descripcion;
	
	
	public List<UsuarioOpcion> usuarioopcions;
	public List<Opcion> opcions;
	public List<PerfilOpcion> perfilopcions;
		
	public GrupoOpcion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.grupoopcionOriginal=this;
		
 		this.id_modulo=-1L;
 		this.codigo="";
 		this.nombre_principal="";
 		this.orden=0;
 		this.estado=false;
		
		
		this.modulo=null;
		
		
		this.modulo_descripcion="";
		
		
		this.usuarioopcions=null;
		this.opcions=null;
		this.perfilopcions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public GrupoOpcion (Long id,Date versionRow,Long id_modulo,String codigo,String nombre_principal,Integer orden,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.grupoopcionOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre_principal=nombre_principal;
 		this.orden=orden;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public GrupoOpcion (Long id_modulo,String codigo,String nombre_principal,Integer orden,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.grupoopcionOriginal=this;
		
 		this.id_modulo=id_modulo;
 		this.codigo=codigo;
 		this.nombre_principal=nombre_principal;
 		this.orden=orden;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		GrupoOpcion grupoopcionLocal=null;
		
		if(object!=null) {
			grupoopcionLocal=(GrupoOpcion)object;
			
			if(grupoopcionLocal!=null) {
				if(this.getId()!=null && grupoopcionLocal.getId()!=null) {
					if(this.getId().equals(grupoopcionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!GrupoOpcionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcion(this);
		} else {
			sDetalle=GrupoOpcionConstantesFunciones.getGrupoOpcionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public GrupoOpcion getGrupoOpcionOriginal() {
		return this.grupoopcionOriginal;
	}
	
	public void setGrupoOpcionOriginal(GrupoOpcion grupoopcion) {
		try {
			this.grupoopcionOriginal=grupoopcion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected GrupoOpcionAdditional grupoopcionAdditional=null;
	
	public GrupoOpcionAdditional getGrupoOpcionAdditional() {
		return this.grupoopcionAdditional;
	}
	
	public void setGrupoOpcionAdditional(GrupoOpcionAdditional grupoopcionAdditional) {
		try {
			this.grupoopcionAdditional=grupoopcionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_principal() {
		return this.nombre_principal;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public Boolean getestado() {
		return this.estado;
	}
	
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("GrupoOpcion:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("GrupoOpcion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("GrupoOpcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_principal(String newnombre_principal)throws Exception
	{
		try {
			if(this.nombre_principal!=newnombre_principal) {
				if(newnombre_principal==null) {
					//newnombre_principal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("GrupoOpcion:Valor nulo no permitido en columna nombre_principal");
					}
				}

				if(newnombre_principal!=null&&newnombre_principal.length()>100) {
					newnombre_principal=newnombre_principal.substring(0,98);
					System.out.println("GrupoOpcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_principal");
				}

				this.nombre_principal=newnombre_principal;
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
						System.out.println("GrupoOpcion:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
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
						System.out.println("GrupoOpcion:Valor nulo no permitido en columna estado");
					}
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Modulo getModulo() {
		return this.modulo;
	}

	
	
	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	
	
	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	
	
	public List<UsuarioOpcion> getUsuarioOpcions() {
		return this.usuarioopcions;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
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

	public  void  setOpcions(List<Opcion> opcions) {
		try {
			this.opcions=opcions;
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
	String id_modulo_descripcion="";String estado_descripcion="";
	
	
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getestado_descripcion() {
		return estado_descripcion;
	}
	
	
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
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
		this.id_modulo_descripcion="";this.estado_descripcion="";
	}
	
	
	Object usuarioopcionsDescripcionReporte;
	Object opcionsDescripcionReporte;
	Object perfilopcionsDescripcionReporte;
	
	
	public Object getusuarioopcionsDescripcionReporte() {
		return usuarioopcionsDescripcionReporte;
	}

	public Object getopcionsDescripcionReporte() {
		return opcionsDescripcionReporte;
	}

	public Object getperfilopcionsDescripcionReporte() {
		return perfilopcionsDescripcionReporte;
	}

	
	
	public  void  setusuarioopcionsDescripcionReporte(Object usuarioopcions) {
		try {
			this.usuarioopcionsDescripcionReporte=usuarioopcions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setopcionsDescripcionReporte(Object opcions) {
		try {
			this.opcionsDescripcionReporte=opcions;
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

	/*PARA REPORTES FIN*/		
}

