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
//import com.bydan.erp.seguridad.util.PerfilOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class PerfilOpcion extends PerfilOpcionAdditional implements Serializable ,Cloneable {//PerfilOpcionAdditional,GeneralEntity
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
	
	private PerfilOpcion perfilopcionOriginal;
	
	private Map<String, Object> mapPerfilOpcion;
			
	public Map<String, Object> getMapPerfilOpcion() {
		return mapPerfilOpcion;
	}

	public void setMapPerfilOpcion(Map<String, Object> mapPerfilOpcion) {
		this.mapPerfilOpcion = mapPerfilOpcion;
	}
	
	public void inicializarMapPerfilOpcion() {
		this.mapPerfilOpcion = new HashMap<String,Object>();
	}
	
	public void setMapPerfilOpcionValue(String sKey,Object oValue) {
		this.mapPerfilOpcion.put(sKey, oValue);
	}
	
	public Object getMapPerfilOpcionValue(String sKey) {
		return this.mapPerfilOpcion.get(sKey);
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
	private Long id_perfil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_opcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean todo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean modificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean eliminacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean guardar_cambios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean consulta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean busqueda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean reporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean paginacion_medio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean paginacion_alto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean paginacion_todo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean duplicar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean copiar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_precargar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Sistema sistema;
	public Modulo modulo;
	public GrupoOpcion grupoopcion;
	public Perfil perfil;
	public Opcion opcion;
	
	
	private String sistema_descripcion;
	private String modulo_descripcion;
	private String grupoopcion_descripcion;
	private String perfil_descripcion;
	private String opcion_descripcion;
	
	
		
	public PerfilOpcion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.perfilopcionOriginal=this;
		
 		this.id_sistema=-1L;
 		this.id_modulo=-1L;
 		this.id_grupo_opcion=null;
 		this.id_perfil=-1L;
 		this.id_opcion=-1L;
 		this.todo=false;
 		this.ingreso=false;
 		this.modificacion=false;
 		this.eliminacion=false;
 		this.guardar_cambios=false;
 		this.consulta=false;
 		this.busqueda=false;
 		this.reporte=false;
 		this.orden=false;
 		this.paginacion_medio=false;
 		this.paginacion_alto=false;
 		this.paginacion_todo=false;
 		this.duplicar=false;
 		this.copiar=false;
 		this.con_precargar=false;
 		this.estado=false;
		
		
		this.sistema=null;
		this.modulo=null;
		this.grupoopcion=null;
		this.perfil=null;
		this.opcion=null;
		
		
		this.sistema_descripcion="";
		this.modulo_descripcion="";
		this.grupoopcion_descripcion="";
		this.perfil_descripcion="";
		this.opcion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PerfilOpcion (Long id,Date versionRow,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil,Long id_opcion,Boolean todo,Boolean ingreso,Boolean modificacion,Boolean eliminacion,Boolean guardar_cambios,Boolean consulta,Boolean busqueda,Boolean reporte,Boolean orden,Boolean paginacion_medio,Boolean paginacion_alto,Boolean paginacion_todo,Boolean duplicar,Boolean copiar,Boolean con_precargar,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.perfilopcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_perfil=id_perfil;
 		this.id_opcion=id_opcion;
 		this.todo=todo;
 		this.ingreso=ingreso;
 		this.modificacion=modificacion;
 		this.eliminacion=eliminacion;
 		this.guardar_cambios=guardar_cambios;
 		this.consulta=consulta;
 		this.busqueda=busqueda;
 		this.reporte=reporte;
 		this.orden=orden;
 		this.paginacion_medio=paginacion_medio;
 		this.paginacion_alto=paginacion_alto;
 		this.paginacion_todo=paginacion_todo;
 		this.duplicar=duplicar;
 		this.copiar=copiar;
 		this.con_precargar=con_precargar;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PerfilOpcion (Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_perfil,Long id_opcion,Boolean todo,Boolean ingreso,Boolean modificacion,Boolean eliminacion,Boolean guardar_cambios,Boolean consulta,Boolean busqueda,Boolean reporte,Boolean orden,Boolean paginacion_medio,Boolean paginacion_alto,Boolean paginacion_todo,Boolean duplicar,Boolean copiar,Boolean con_precargar,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.perfilopcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_perfil=id_perfil;
 		this.id_opcion=id_opcion;
 		this.todo=todo;
 		this.ingreso=ingreso;
 		this.modificacion=modificacion;
 		this.eliminacion=eliminacion;
 		this.guardar_cambios=guardar_cambios;
 		this.consulta=consulta;
 		this.busqueda=busqueda;
 		this.reporte=reporte;
 		this.orden=orden;
 		this.paginacion_medio=paginacion_medio;
 		this.paginacion_alto=paginacion_alto;
 		this.paginacion_todo=paginacion_todo;
 		this.duplicar=duplicar;
 		this.copiar=copiar;
 		this.con_precargar=con_precargar;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PerfilOpcion perfilopcionLocal=null;
		
		if(object!=null) {
			perfilopcionLocal=(PerfilOpcion)object;
			
			if(perfilopcionLocal!=null) {
				if(this.getId()!=null && perfilopcionLocal.getId()!=null) {
					if(this.getId().equals(perfilopcionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PerfilOpcionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PerfilOpcionConstantesFunciones.getPerfilOpcionDescripcion(this);
		} else {
			sDetalle=PerfilOpcionConstantesFunciones.getPerfilOpcionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PerfilOpcion getPerfilOpcionOriginal() {
		return this.perfilopcionOriginal;
	}
	
	public void setPerfilOpcionOriginal(PerfilOpcion perfilopcion) {
		try {
			this.perfilopcionOriginal=perfilopcion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PerfilOpcionAdditional perfilopcionAdditional=null;
	
	public PerfilOpcionAdditional getPerfilOpcionAdditional() {
		return this.perfilopcionAdditional;
	}
	
	public void setPerfilOpcionAdditional(PerfilOpcionAdditional perfilopcionAdditional) {
		try {
			this.perfilopcionAdditional=perfilopcionAdditional;
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
    
	
	public Long getid_perfil() {
		return this.id_perfil;
	}
    
	
	public Long getid_opcion() {
		return this.id_opcion;
	}
    
	
	public Boolean gettodo() {
		return this.todo;
	}
    
	
	public Boolean getingreso() {
		return this.ingreso;
	}
    
	
	public Boolean getmodificacion() {
		return this.modificacion;
	}
    
	
	public Boolean geteliminacion() {
		return this.eliminacion;
	}
    
	
	public Boolean getguardar_cambios() {
		return this.guardar_cambios;
	}
    
	
	public Boolean getconsulta() {
		return this.consulta;
	}
    
	
	public Boolean getbusqueda() {
		return this.busqueda;
	}
    
	
	public Boolean getreporte() {
		return this.reporte;
	}
    
	
	public Boolean getorden() {
		return this.orden;
	}
    
	
	public Boolean getpaginacion_medio() {
		return this.paginacion_medio;
	}
    
	
	public Boolean getpaginacion_alto() {
		return this.paginacion_alto;
	}
    
	
	public Boolean getpaginacion_todo() {
		return this.paginacion_todo;
	}
    
	
	public Boolean getduplicar() {
		return this.duplicar;
	}
    
	
	public Boolean getcopiar() {
		return this.copiar;
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
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna id_sistema");
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
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna id_modulo");
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
    
	public void setid_perfil(Long newid_perfil)throws Exception
	{
		try {
			if(this.id_perfil!=newid_perfil) {
				if(newid_perfil==null) {
					//newid_perfil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna id_perfil");
					}
				}

				this.id_perfil=newid_perfil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_opcion(Long newid_opcion)throws Exception
	{
		try {
			if(this.id_opcion!=newid_opcion) {
				if(newid_opcion==null) {
					//newid_opcion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna id_opcion");
					}
				}

				this.id_opcion=newid_opcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settodo(Boolean newtodo)throws Exception
	{
		try {
			if(this.todo!=newtodo) {
				if(newtodo==null) {
					//newtodo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna todo");
					}
				}

				this.todo=newtodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso(Boolean newingreso)throws Exception
	{
		try {
			if(this.ingreso!=newingreso) {
				if(newingreso==null) {
					//newingreso=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna ingreso");
					}
				}

				this.ingreso=newingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmodificacion(Boolean newmodificacion)throws Exception
	{
		try {
			if(this.modificacion!=newmodificacion) {
				if(newmodificacion==null) {
					//newmodificacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna modificacion");
					}
				}

				this.modificacion=newmodificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void seteliminacion(Boolean neweliminacion)throws Exception
	{
		try {
			if(this.eliminacion!=neweliminacion) {
				if(neweliminacion==null) {
					//neweliminacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna eliminacion");
					}
				}

				this.eliminacion=neweliminacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setguardar_cambios(Boolean newguardar_cambios)throws Exception
	{
		try {
			if(this.guardar_cambios!=newguardar_cambios) {
				if(newguardar_cambios==null) {
					//newguardar_cambios=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna guardar_cambios");
					}
				}

				this.guardar_cambios=newguardar_cambios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setconsulta(Boolean newconsulta)throws Exception
	{
		try {
			if(this.consulta!=newconsulta) {
				if(newconsulta==null) {
					//newconsulta=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna consulta");
					}
				}

				this.consulta=newconsulta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbusqueda(Boolean newbusqueda)throws Exception
	{
		try {
			if(this.busqueda!=newbusqueda) {
				if(newbusqueda==null) {
					//newbusqueda=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna busqueda");
					}
				}

				this.busqueda=newbusqueda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreporte(Boolean newreporte)throws Exception
	{
		try {
			if(this.reporte!=newreporte) {
				if(newreporte==null) {
					//newreporte=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna reporte");
					}
				}

				this.reporte=newreporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Boolean neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpaginacion_medio(Boolean newpaginacion_medio)throws Exception
	{
		try {
			if(this.paginacion_medio!=newpaginacion_medio) {
				if(newpaginacion_medio==null) {
					//newpaginacion_medio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna paginacion_medio");
					}
				}

				this.paginacion_medio=newpaginacion_medio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpaginacion_alto(Boolean newpaginacion_alto)throws Exception
	{
		try {
			if(this.paginacion_alto!=newpaginacion_alto) {
				if(newpaginacion_alto==null) {
					//newpaginacion_alto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna paginacion_alto");
					}
				}

				this.paginacion_alto=newpaginacion_alto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpaginacion_todo(Boolean newpaginacion_todo)throws Exception
	{
		try {
			if(this.paginacion_todo!=newpaginacion_todo) {
				if(newpaginacion_todo==null) {
					//newpaginacion_todo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna paginacion_todo");
					}
				}

				this.paginacion_todo=newpaginacion_todo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setduplicar(Boolean newduplicar)throws Exception
	{
		try {
			if(this.duplicar!=newduplicar) {
				if(newduplicar==null) {
					//newduplicar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna duplicar");
					}
				}

				this.duplicar=newduplicar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcopiar(Boolean newcopiar)throws Exception
	{
		try {
			if(this.copiar!=newcopiar) {
				if(newcopiar==null) {
					//newcopiar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna copiar");
					}
				}

				this.copiar=newcopiar;
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
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna con_precargar");
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
						System.out.println("PerfilOpcion:Valor nulo no permitido en columna estado");
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

	public Perfil getPerfil() {
		return this.perfil;
	}

	public Opcion getOpcion() {
		return this.opcion;
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

	public String getperfil_descripcion() {
		return this.perfil_descripcion;
	}

	public String getopcion_descripcion() {
		return this.opcion_descripcion;
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


	public  void  setPerfil(Perfil perfil) {
		try {
			this.perfil=perfil;
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


	public  void  setperfil_descripcion(String perfil_descripcion) {
		try {
			this.perfil_descripcion=perfil_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_sistema_descripcion="";String id_modulo_descripcion="";String id_grupo_opcion_descripcion="";String id_perfil_descripcion="";String id_opcion_descripcion="";String todo_descripcion="";String ingreso_descripcion="";String modificacion_descripcion="";String eliminacion_descripcion="";String guardar_cambios_descripcion="";String consulta_descripcion="";String busqueda_descripcion="";String reporte_descripcion="";String orden_descripcion="";String paginacion_medio_descripcion="";String paginacion_alto_descripcion="";String paginacion_todo_descripcion="";String duplicar_descripcion="";String copiar_descripcion="";String con_precargar_descripcion="";String estado_descripcion="";
	
	
	public String getid_sistema_descripcion() {
		return id_sistema_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_grupo_opcion_descripcion() {
		return id_grupo_opcion_descripcion;
	}
	public String getid_perfil_descripcion() {
		return id_perfil_descripcion;
	}
	public String getid_opcion_descripcion() {
		return id_opcion_descripcion;
	}
	public String gettodo_descripcion() {
		return todo_descripcion;
	}
	public String getingreso_descripcion() {
		return ingreso_descripcion;
	}
	public String getmodificacion_descripcion() {
		return modificacion_descripcion;
	}
	public String geteliminacion_descripcion() {
		return eliminacion_descripcion;
	}
	public String getguardar_cambios_descripcion() {
		return guardar_cambios_descripcion;
	}
	public String getconsulta_descripcion() {
		return consulta_descripcion;
	}
	public String getbusqueda_descripcion() {
		return busqueda_descripcion;
	}
	public String getreporte_descripcion() {
		return reporte_descripcion;
	}
	public String getorden_descripcion() {
		return orden_descripcion;
	}
	public String getpaginacion_medio_descripcion() {
		return paginacion_medio_descripcion;
	}
	public String getpaginacion_alto_descripcion() {
		return paginacion_alto_descripcion;
	}
	public String getpaginacion_todo_descripcion() {
		return paginacion_todo_descripcion;
	}
	public String getduplicar_descripcion() {
		return duplicar_descripcion;
	}
	public String getcopiar_descripcion() {
		return copiar_descripcion;
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
	public void setid_perfil_descripcion(String newid_perfil_descripcion)throws Exception {
		try {
			this.id_perfil_descripcion=newid_perfil_descripcion;
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
	public void settodo_descripcion(String newtodo_descripcion)throws Exception {
		try {
			this.todo_descripcion=newtodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setingreso_descripcion(String newingreso_descripcion)throws Exception {
		try {
			this.ingreso_descripcion=newingreso_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setmodificacion_descripcion(String newmodificacion_descripcion)throws Exception {
		try {
			this.modificacion_descripcion=newmodificacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void seteliminacion_descripcion(String neweliminacion_descripcion)throws Exception {
		try {
			this.eliminacion_descripcion=neweliminacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setguardar_cambios_descripcion(String newguardar_cambios_descripcion)throws Exception {
		try {
			this.guardar_cambios_descripcion=newguardar_cambios_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setconsulta_descripcion(String newconsulta_descripcion)throws Exception {
		try {
			this.consulta_descripcion=newconsulta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setbusqueda_descripcion(String newbusqueda_descripcion)throws Exception {
		try {
			this.busqueda_descripcion=newbusqueda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setreporte_descripcion(String newreporte_descripcion)throws Exception {
		try {
			this.reporte_descripcion=newreporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setorden_descripcion(String neworden_descripcion)throws Exception {
		try {
			this.orden_descripcion=neworden_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpaginacion_medio_descripcion(String newpaginacion_medio_descripcion)throws Exception {
		try {
			this.paginacion_medio_descripcion=newpaginacion_medio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpaginacion_alto_descripcion(String newpaginacion_alto_descripcion)throws Exception {
		try {
			this.paginacion_alto_descripcion=newpaginacion_alto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpaginacion_todo_descripcion(String newpaginacion_todo_descripcion)throws Exception {
		try {
			this.paginacion_todo_descripcion=newpaginacion_todo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setduplicar_descripcion(String newduplicar_descripcion)throws Exception {
		try {
			this.duplicar_descripcion=newduplicar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcopiar_descripcion(String newcopiar_descripcion)throws Exception {
		try {
			this.copiar_descripcion=newcopiar_descripcion;
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
		this.id_sistema_descripcion="";this.id_modulo_descripcion="";this.id_grupo_opcion_descripcion="";this.id_perfil_descripcion="";this.id_opcion_descripcion="";this.todo_descripcion="";this.ingreso_descripcion="";this.modificacion_descripcion="";this.eliminacion_descripcion="";this.guardar_cambios_descripcion="";this.consulta_descripcion="";this.busqueda_descripcion="";this.reporte_descripcion="";this.orden_descripcion="";this.paginacion_medio_descripcion="";this.paginacion_alto_descripcion="";this.paginacion_todo_descripcion="";this.duplicar_descripcion="";this.copiar_descripcion="";this.con_precargar_descripcion="";this.estado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

