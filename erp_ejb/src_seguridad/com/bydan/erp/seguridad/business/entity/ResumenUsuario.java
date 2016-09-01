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
//import com.bydan.erp.seguridad.util.ResumenUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class ResumenUsuario extends ResumenUsuarioAdditional implements Serializable ,Cloneable {//ResumenUsuarioAdditional,GeneralEntity
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
	
	private ResumenUsuario resumenusuarioOriginal;
	
	private Map<String, Object> mapResumenUsuario;
			
	public Map<String, Object> getMapResumenUsuario() {
		return mapResumenUsuario;
	}

	public void setMapResumenUsuario(Map<String, Object> mapResumenUsuario) {
		this.mapResumenUsuario = mapResumenUsuario;
	}
	
	public void inicializarMapResumenUsuario() {
		this.mapResumenUsuario = new HashMap<String,Object>();
	}
	
	public void setMapResumenUsuarioValue(String sKey,Object oValue) {
		this.mapResumenUsuario.put(sKey, oValue);
	}
	
	public Object getMapResumenUsuarioValue(String sKey) {
		return this.mapResumenUsuario.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_ingresos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_error_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_intentos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_cierres;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_reinicios;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long numero_ingreso_actual;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_error_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_intento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultimo_cierre;
			
	
	public Usuario usuario;
	
	
	private String usuario_descripcion;
	
	
		
	public ResumenUsuario () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.resumenusuarioOriginal=this;
		
 		this.id_usuario=-1L;
 		this.numero_ingresos=0L;
 		this.numero_error_ingreso=0L;
 		this.numero_intentos=0L;
 		this.numero_cierres=0L;
 		this.numero_reinicios=0L;
 		this.numero_ingreso_actual=0L;
 		this.fecha_ultimo_ingreso=new Date();
 		this.fecha_ultimo_error_ingreso=new Date();
 		this.fecha_ultimo_intento=new Date();
 		this.fecha_ultimo_cierre=new Date();
		
		
		this.usuario=null;
		
		
		this.usuario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ResumenUsuario (Long id,Date versionRow,Long id_usuario,Long numero_ingresos,Long numero_error_ingreso,Long numero_intentos,Long numero_cierres,Long numero_reinicios,Long numero_ingreso_actual,Date fecha_ultimo_ingreso,Date fecha_ultimo_error_ingreso,Date fecha_ultimo_intento,Date fecha_ultimo_cierre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.resumenusuarioOriginal=this;
		
 		this.id_usuario=id_usuario;
 		this.numero_ingresos=numero_ingresos;
 		this.numero_error_ingreso=numero_error_ingreso;
 		this.numero_intentos=numero_intentos;
 		this.numero_cierres=numero_cierres;
 		this.numero_reinicios=numero_reinicios;
 		this.numero_ingreso_actual=numero_ingreso_actual;
 		this.fecha_ultimo_ingreso=fecha_ultimo_ingreso;
 		this.fecha_ultimo_error_ingreso=fecha_ultimo_error_ingreso;
 		this.fecha_ultimo_intento=fecha_ultimo_intento;
 		this.fecha_ultimo_cierre=fecha_ultimo_cierre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ResumenUsuario (Long id_usuario,Long numero_ingresos,Long numero_error_ingreso,Long numero_intentos,Long numero_cierres,Long numero_reinicios,Long numero_ingreso_actual,Date fecha_ultimo_ingreso,Date fecha_ultimo_error_ingreso,Date fecha_ultimo_intento,Date fecha_ultimo_cierre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.resumenusuarioOriginal=this;
		
 		this.id_usuario=id_usuario;
 		this.numero_ingresos=numero_ingresos;
 		this.numero_error_ingreso=numero_error_ingreso;
 		this.numero_intentos=numero_intentos;
 		this.numero_cierres=numero_cierres;
 		this.numero_reinicios=numero_reinicios;
 		this.numero_ingreso_actual=numero_ingreso_actual;
 		this.fecha_ultimo_ingreso=fecha_ultimo_ingreso;
 		this.fecha_ultimo_error_ingreso=fecha_ultimo_error_ingreso;
 		this.fecha_ultimo_intento=fecha_ultimo_intento;
 		this.fecha_ultimo_cierre=fecha_ultimo_cierre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ResumenUsuario resumenusuarioLocal=null;
		
		if(object!=null) {
			resumenusuarioLocal=(ResumenUsuario)object;
			
			if(resumenusuarioLocal!=null) {
				if(this.getId()!=null && resumenusuarioLocal.getId()!=null) {
					if(this.getId().equals(resumenusuarioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ResumenUsuarioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ResumenUsuarioConstantesFunciones.getResumenUsuarioDescripcion(this);
		} else {
			sDetalle=ResumenUsuarioConstantesFunciones.getResumenUsuarioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ResumenUsuario getResumenUsuarioOriginal() {
		return this.resumenusuarioOriginal;
	}
	
	public void setResumenUsuarioOriginal(ResumenUsuario resumenusuario) {
		try {
			this.resumenusuarioOriginal=resumenusuario;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ResumenUsuarioAdditional resumenusuarioAdditional=null;
	
	public ResumenUsuarioAdditional getResumenUsuarioAdditional() {
		return this.resumenusuarioAdditional;
	}
	
	public void setResumenUsuarioAdditional(ResumenUsuarioAdditional resumenusuarioAdditional) {
		try {
			this.resumenusuarioAdditional=resumenusuarioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getnumero_ingresos() {
		return this.numero_ingresos;
	}
    
	
	public Long getnumero_error_ingreso() {
		return this.numero_error_ingreso;
	}
    
	
	public Long getnumero_intentos() {
		return this.numero_intentos;
	}
    
	
	public Long getnumero_cierres() {
		return this.numero_cierres;
	}
    
	
	public Long getnumero_reinicios() {
		return this.numero_reinicios;
	}
    
	
	public Long getnumero_ingreso_actual() {
		return this.numero_ingreso_actual;
	}
    
	
	public Date getfecha_ultimo_ingreso() {
		return this.fecha_ultimo_ingreso;
	}
    
	
	public Date getfecha_ultimo_error_ingreso() {
		return this.fecha_ultimo_error_ingreso;
	}
    
	
	public Date getfecha_ultimo_intento() {
		return this.fecha_ultimo_intento;
	}
    
	
	public Date getfecha_ultimo_cierre() {
		return this.fecha_ultimo_cierre;
	}
	
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_ingresos(Long newnumero_ingresos)throws Exception
	{
		try {
			if(this.numero_ingresos!=newnumero_ingresos) {
				if(newnumero_ingresos==null) {
					//newnumero_ingresos=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_ingresos");
					}
				}

				this.numero_ingresos=newnumero_ingresos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_error_ingreso(Long newnumero_error_ingreso)throws Exception
	{
		try {
			if(this.numero_error_ingreso!=newnumero_error_ingreso) {
				if(newnumero_error_ingreso==null) {
					//newnumero_error_ingreso=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_error_ingreso");
					}
				}

				this.numero_error_ingreso=newnumero_error_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_intentos(Long newnumero_intentos)throws Exception
	{
		try {
			if(this.numero_intentos!=newnumero_intentos) {
				if(newnumero_intentos==null) {
					//newnumero_intentos=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_intentos");
					}
				}

				this.numero_intentos=newnumero_intentos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cierres(Long newnumero_cierres)throws Exception
	{
		try {
			if(this.numero_cierres!=newnumero_cierres) {
				if(newnumero_cierres==null) {
					//newnumero_cierres=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_cierres");
					}
				}

				this.numero_cierres=newnumero_cierres;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_reinicios(Long newnumero_reinicios)throws Exception
	{
		try {
			if(this.numero_reinicios!=newnumero_reinicios) {
				if(newnumero_reinicios==null) {
					//newnumero_reinicios=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_reinicios");
					}
				}

				this.numero_reinicios=newnumero_reinicios;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_ingreso_actual(Long newnumero_ingreso_actual)throws Exception
	{
		try {
			if(this.numero_ingreso_actual!=newnumero_ingreso_actual) {
				if(newnumero_ingreso_actual==null) {
					//newnumero_ingreso_actual=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna numero_ingreso_actual");
					}
				}

				this.numero_ingreso_actual=newnumero_ingreso_actual;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_ingreso(Date newfecha_ultimo_ingreso)throws Exception
	{
		try {
			if(this.fecha_ultimo_ingreso!=newfecha_ultimo_ingreso) {
				if(newfecha_ultimo_ingreso==null) {
					//newfecha_ultimo_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna fecha_ultimo_ingreso");
					}
				}

				this.fecha_ultimo_ingreso=newfecha_ultimo_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_error_ingreso(Date newfecha_ultimo_error_ingreso)throws Exception
	{
		try {
			if(this.fecha_ultimo_error_ingreso!=newfecha_ultimo_error_ingreso) {
				if(newfecha_ultimo_error_ingreso==null) {
					//newfecha_ultimo_error_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna fecha_ultimo_error_ingreso");
					}
				}

				this.fecha_ultimo_error_ingreso=newfecha_ultimo_error_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_intento(Date newfecha_ultimo_intento)throws Exception
	{
		try {
			if(this.fecha_ultimo_intento!=newfecha_ultimo_intento) {
				if(newfecha_ultimo_intento==null) {
					//newfecha_ultimo_intento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna fecha_ultimo_intento");
					}
				}

				this.fecha_ultimo_intento=newfecha_ultimo_intento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultimo_cierre(Date newfecha_ultimo_cierre)throws Exception
	{
		try {
			if(this.fecha_ultimo_cierre!=newfecha_ultimo_cierre) {
				if(newfecha_ultimo_cierre==null) {
					//newfecha_ultimo_cierre=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ResumenUsuario:Valor nulo no permitido en columna fecha_ultimo_cierre");
					}
				}

				this.fecha_ultimo_cierre=newfecha_ultimo_cierre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	
	
	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	
	
	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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
	String id_usuario_descripcion="";
	
	
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	
	
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_usuario_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

