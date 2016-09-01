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
//import com.bydan.erp.seguridad.util.UpdateConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class Update extends UpdateAdditional implements Serializable ,Cloneable {//UpdateAdditional,GeneralEntity
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
	
	private Update updateOriginal;
	
	private Map<String, Object> mapUpdate;
			
	public Map<String, Object> getMapUpdate() {
		return mapUpdate;
	}

	public void setMapUpdate(Map<String, Object> mapUpdate) {
		this.mapUpdate = mapUpdate;
	}
	
	public void inicializarMapUpdate() {
		this.mapUpdate = new HashMap<String,Object>();
	}
	
	public void setMapUpdateValue(String sKey,Object oValue) {
		this.mapUpdate.put(sKey, oValue);
	}
	
	public Object getMapUpdateValue(String sKey) {
		return this.mapUpdate.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UpdateConstantesFunciones.SREGEXCODIGO,message=UpdateConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UpdateConstantesFunciones.SREGEXCODIGO_PROCESO,message=UpdateConstantesFunciones.SMENSAJEREGEXCODIGO_PROCESO)
	private String codigo_proceso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UpdateConstantesFunciones.SREGEXQUERY_RESUMEN,message=UpdateConstantesFunciones.SMENSAJEREGEXQUERY_RESUMEN)
	private String query_resumen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_intento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_archivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean ejecutado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=UpdateConstantesFunciones.SREGEXDESCRIPCION,message=UpdateConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Anio anio;
	public Mes mes;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<UpdateDetalle> updatedetalles;
		
	public Update () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.updateOriginal=this;
		
 		this.id_anio=null;
 		this.id_mes=null;
 		this.codigo="";
 		this.codigo_proceso="";
 		this.query_resumen="";
 		this.numero_intento=0;
 		this.fecha=new Date();
 		this.fecha_archivo=new Date();
 		this.orden=0;
 		this.ejecutado=false;
 		this.esta_activo=false;
 		this.descripcion="";
		
		
		this.anio=null;
		this.mes=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.updatedetalles=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Update (Long id,Date versionRow,Long id_anio,Long id_mes,String codigo,String codigo_proceso,String query_resumen,Integer numero_intento,Date fecha,Date fecha_archivo,Integer orden,Boolean ejecutado,Boolean esta_activo,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.updateOriginal=this;
		
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.codigo=codigo;
 		this.codigo_proceso=codigo_proceso;
 		this.query_resumen=query_resumen;
 		this.numero_intento=numero_intento;
 		this.fecha=fecha;
 		this.fecha_archivo=fecha_archivo;
 		this.orden=orden;
 		this.ejecutado=ejecutado;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Update (Long id_anio,Long id_mes,String codigo,String codigo_proceso,String query_resumen,Integer numero_intento,Date fecha,Date fecha_archivo,Integer orden,Boolean ejecutado,Boolean esta_activo,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.updateOriginal=this;
		
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.codigo=codigo;
 		this.codigo_proceso=codigo_proceso;
 		this.query_resumen=query_resumen;
 		this.numero_intento=numero_intento;
 		this.fecha=fecha;
 		this.fecha_archivo=fecha_archivo;
 		this.orden=orden;
 		this.ejecutado=ejecutado;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Update updateLocal=null;
		
		if(object!=null) {
			updateLocal=(Update)object;
			
			if(updateLocal!=null) {
				if(this.getId()!=null && updateLocal.getId()!=null) {
					if(this.getId().equals(updateLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!UpdateConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=UpdateConstantesFunciones.getUpdateDescripcion(this);
		} else {
			sDetalle=UpdateConstantesFunciones.getUpdateDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Update getUpdateOriginal() {
		return this.updateOriginal;
	}
	
	public void setUpdateOriginal(Update update) {
		try {
			this.updateOriginal=update;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UpdateAdditional updateAdditional=null;
	
	public UpdateAdditional getUpdateAdditional() {
		return this.updateAdditional;
	}
	
	public void setUpdateAdditional(UpdateAdditional updateAdditional) {
		try {
			this.updateAdditional=updateAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getcodigo_proceso() {
		return this.codigo_proceso;
	}
    
	
	public String getquery_resumen() {
		return this.query_resumen;
	}
    
	
	public Integer getnumero_intento() {
		return this.numero_intento;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_archivo() {
		return this.fecha_archivo;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public Boolean getejecutado() {
		return this.ejecutado;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Update:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_proceso(String newcodigo_proceso)throws Exception
	{
		try {
			if(this.codigo_proceso!=newcodigo_proceso) {
				if(newcodigo_proceso==null) {
					//newcodigo_proceso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna codigo_proceso");
					}
				}

				if(newcodigo_proceso!=null&&newcodigo_proceso.length()>50) {
					newcodigo_proceso=newcodigo_proceso.substring(0,48);
					System.out.println("Update:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_proceso");
				}

				this.codigo_proceso=newcodigo_proceso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setquery_resumen(String newquery_resumen)throws Exception
	{
		try {
			if(this.query_resumen!=newquery_resumen) {
				if(newquery_resumen==null) {
					//newquery_resumen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna query_resumen");
					}
				}

				if(newquery_resumen!=null&&newquery_resumen.length()>250) {
					newquery_resumen=newquery_resumen.substring(0,248);
					System.out.println("Update:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna query_resumen");
				}

				this.query_resumen=newquery_resumen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_intento(Integer newnumero_intento)throws Exception
	{
		try {
			if(this.numero_intento!=newnumero_intento) {
				if(newnumero_intento==null) {
					//newnumero_intento=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna numero_intento");
					}
				}

				this.numero_intento=newnumero_intento;
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
						System.out.println("Update:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_archivo(Date newfecha_archivo)throws Exception
	{
		try {
			if(this.fecha_archivo!=newfecha_archivo) {
				if(newfecha_archivo==null) {
					//newfecha_archivo=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna fecha_archivo");
					}
				}

				this.fecha_archivo=newfecha_archivo;
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
						System.out.println("Update:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setejecutado(Boolean newejecutado)throws Exception
	{
		try {
			if(this.ejecutado!=newejecutado) {
				if(newejecutado==null) {
					//newejecutado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna ejecutado");
					}
				}

				this.ejecutado=newejecutado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Update:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
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
						System.out.println("Update:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("Update:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<UpdateDetalle> getUpdateDetalles() {
		return this.updatedetalles;
	}

	
	
	public  void  setUpdateDetalles(List<UpdateDetalle> updatedetalles) {
		try {
			this.updatedetalles=updatedetalles;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_anio_descripcion="";String id_mes_descripcion="";String ejecutado_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getejecutado_descripcion() {
		return ejecutado_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setejecutado_descripcion(String newejecutado_descripcion)throws Exception {
		try {
			this.ejecutado_descripcion=newejecutado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_mes_descripcion="";this.ejecutado_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	Object updatedetallesDescripcionReporte;
	
	
	public Object getupdatedetallesDescripcionReporte() {
		return updatedetallesDescripcionReporte;
	}

	
	
	public  void  setupdatedetallesDescripcionReporte(Object updatedetalles) {
		try {
			this.updatedetallesDescripcionReporte=updatedetalles;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

