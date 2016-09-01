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
//import com.bydan.erp.seguridad.util.ParametroGeneralSgConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class ParametroGeneralSg extends ParametroGeneralSgAdditional implements Serializable ,Cloneable {//ParametroGeneralSgAdditional,GeneralEntity
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
	
	private ParametroGeneralSg parametrogeneralsgOriginal;
	
	private Map<String, Object> mapParametroGeneralSg;
			
	public Map<String, Object> getMapParametroGeneralSg() {
		return mapParametroGeneralSg;
	}

	public void setMapParametroGeneralSg(Map<String, Object> mapParametroGeneralSg) {
		this.mapParametroGeneralSg = mapParametroGeneralSg;
	}
	
	public void inicializarMapParametroGeneralSg() {
		this.mapParametroGeneralSg = new HashMap<String,Object>();
	}
	
	public void setMapParametroGeneralSgValue(String sKey,Object oValue) {
		this.mapParametroGeneralSg.put(sKey, oValue);
	}
	
	public Object getMapParametroGeneralSgValue(String sKey) {
		return this.mapParametroGeneralSg.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXNOMBRE_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXNOMBRE_SISTEMA)
	private String nombre_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXNOMBRE_SIMPLE_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXNOMBRE_SIMPLE_SISTEMA)
	private String nombre_simple_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXNOMBRE_EMPRESA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXNOMBRE_EMPRESA)
	private String nombre_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double version_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXSIGLAS_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXSIGLAS_SISTEMA)
	private String siglas_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXMAIL_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXMAIL_SISTEMA)
	private String mail_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXTELEFONO_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXTELEFONO_SISTEMA)
	private String telefono_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXFAX_SISTEMA,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXFAX_SISTEMA)
	private String fax_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXREPRESENTANTE_NOMBRE,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXREPRESENTANTE_NOMBRE)
	private String representante_nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParametroGeneralSgConstantesFunciones.SREGEXCODIGO_PROCESO_ACTUALIZACION,message=ParametroGeneralSgConstantesFunciones.SMENSAJEREGEXCODIGO_PROCESO_ACTUALIZACION)
	private String codigo_proceso_actualizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	
	
	
	
		
	public ParametroGeneralSg () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrogeneralsgOriginal=this;
		
 		this.nombre_sistema="";
 		this.nombre_simple_sistema="";
 		this.nombre_empresa="";
 		this.version_sistema=0.0;
 		this.siglas_sistema="";
 		this.mail_sistema="";
 		this.telefono_sistema="";
 		this.fax_sistema="";
 		this.representante_nombre="";
 		this.codigo_proceso_actualizacion="";
 		this.esta_activo=false;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroGeneralSg (Long id,Date versionRow,String nombre_sistema,String nombre_simple_sistema,String nombre_empresa,Double version_sistema,String siglas_sistema,String mail_sistema,String telefono_sistema,String fax_sistema,String representante_nombre,String codigo_proceso_actualizacion,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogeneralsgOriginal=this;
		
 		this.nombre_sistema=nombre_sistema;
 		this.nombre_simple_sistema=nombre_simple_sistema;
 		this.nombre_empresa=nombre_empresa;
 		this.version_sistema=version_sistema;
 		this.siglas_sistema=siglas_sistema;
 		this.mail_sistema=mail_sistema;
 		this.telefono_sistema=telefono_sistema;
 		this.fax_sistema=fax_sistema;
 		this.representante_nombre=representante_nombre;
 		this.codigo_proceso_actualizacion=codigo_proceso_actualizacion;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroGeneralSg (String nombre_sistema,String nombre_simple_sistema,String nombre_empresa,Double version_sistema,String siglas_sistema,String mail_sistema,String telefono_sistema,String fax_sistema,String representante_nombre,String codigo_proceso_actualizacion,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrogeneralsgOriginal=this;
		
 		this.nombre_sistema=nombre_sistema;
 		this.nombre_simple_sistema=nombre_simple_sistema;
 		this.nombre_empresa=nombre_empresa;
 		this.version_sistema=version_sistema;
 		this.siglas_sistema=siglas_sistema;
 		this.mail_sistema=mail_sistema;
 		this.telefono_sistema=telefono_sistema;
 		this.fax_sistema=fax_sistema;
 		this.representante_nombre=representante_nombre;
 		this.codigo_proceso_actualizacion=codigo_proceso_actualizacion;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroGeneralSg parametrogeneralsgLocal=null;
		
		if(object!=null) {
			parametrogeneralsgLocal=(ParametroGeneralSg)object;
			
			if(parametrogeneralsgLocal!=null) {
				if(this.getId()!=null && parametrogeneralsgLocal.getId()!=null) {
					if(this.getId().equals(parametrogeneralsgLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroGeneralSgConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroGeneralSgConstantesFunciones.getParametroGeneralSgDescripcion(this);
		} else {
			sDetalle=ParametroGeneralSgConstantesFunciones.getParametroGeneralSgDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroGeneralSg getParametroGeneralSgOriginal() {
		return this.parametrogeneralsgOriginal;
	}
	
	public void setParametroGeneralSgOriginal(ParametroGeneralSg parametrogeneralsg) {
		try {
			this.parametrogeneralsgOriginal=parametrogeneralsg;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroGeneralSgAdditional parametrogeneralsgAdditional=null;
	
	public ParametroGeneralSgAdditional getParametroGeneralSgAdditional() {
		return this.parametrogeneralsgAdditional;
	}
	
	public void setParametroGeneralSgAdditional(ParametroGeneralSgAdditional parametrogeneralsgAdditional) {
		try {
			this.parametrogeneralsgAdditional=parametrogeneralsgAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre_sistema() {
		return this.nombre_sistema;
	}
    
	
	public String getnombre_simple_sistema() {
		return this.nombre_simple_sistema;
	}
    
	
	public String getnombre_empresa() {
		return this.nombre_empresa;
	}
    
	
	public Double getversion_sistema() {
		return this.version_sistema;
	}
    
	
	public String getsiglas_sistema() {
		return this.siglas_sistema;
	}
    
	
	public String getmail_sistema() {
		return this.mail_sistema;
	}
    
	
	public String gettelefono_sistema() {
		return this.telefono_sistema;
	}
    
	
	public String getfax_sistema() {
		return this.fax_sistema;
	}
    
	
	public String getrepresentante_nombre() {
		return this.representante_nombre;
	}
    
	
	public String getcodigo_proceso_actualizacion() {
		return this.codigo_proceso_actualizacion;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setnombre_sistema(String newnombre_sistema)throws Exception
	{
		try {
			if(this.nombre_sistema!=newnombre_sistema) {
				if(newnombre_sistema==null) {
					//newnombre_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna nombre_sistema");
					}
				}

				if(newnombre_sistema!=null&&newnombre_sistema.length()>150) {
					newnombre_sistema=newnombre_sistema.substring(0,148);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sistema");
				}

				this.nombre_sistema=newnombre_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_simple_sistema(String newnombre_simple_sistema)throws Exception
	{
		try {
			if(this.nombre_simple_sistema!=newnombre_simple_sistema) {
				if(newnombre_simple_sistema==null) {
					//newnombre_simple_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna nombre_simple_sistema");
					}
				}

				if(newnombre_simple_sistema!=null&&newnombre_simple_sistema.length()>150) {
					newnombre_simple_sistema=newnombre_simple_sistema.substring(0,148);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_simple_sistema");
				}

				this.nombre_simple_sistema=newnombre_simple_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_empresa(String newnombre_empresa)throws Exception
	{
		try {
			if(this.nombre_empresa!=newnombre_empresa) {
				if(newnombre_empresa==null) {
					//newnombre_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna nombre_empresa");
					}
				}

				if(newnombre_empresa!=null&&newnombre_empresa.length()>150) {
					newnombre_empresa=newnombre_empresa.substring(0,148);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_empresa");
				}

				this.nombre_empresa=newnombre_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setversion_sistema(Double newversion_sistema)throws Exception
	{
		try {
			if(this.version_sistema!=newversion_sistema) {
				if(newversion_sistema==null) {
					//newversion_sistema=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna version_sistema");
					}
				}

				this.version_sistema=newversion_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsiglas_sistema(String newsiglas_sistema)throws Exception
	{
		try {
			if(this.siglas_sistema!=newsiglas_sistema) {
				if(newsiglas_sistema==null) {
					//newsiglas_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna siglas_sistema");
					}
				}

				if(newsiglas_sistema!=null&&newsiglas_sistema.length()>15) {
					newsiglas_sistema=newsiglas_sistema.substring(0,13);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna siglas_sistema");
				}

				this.siglas_sistema=newsiglas_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmail_sistema(String newmail_sistema)throws Exception
	{
		try {
			if(this.mail_sistema!=newmail_sistema) {
				if(newmail_sistema==null) {
					//newmail_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna mail_sistema");
					}
				}

				if(newmail_sistema!=null&&newmail_sistema.length()>100) {
					newmail_sistema=newmail_sistema.substring(0,98);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna mail_sistema");
				}

				this.mail_sistema=newmail_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_sistema(String newtelefono_sistema)throws Exception
	{
		try {
			if(this.telefono_sistema!=newtelefono_sistema) {
				if(newtelefono_sistema==null) {
					//newtelefono_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna telefono_sistema");
					}
				}

				if(newtelefono_sistema!=null&&newtelefono_sistema.length()>50) {
					newtelefono_sistema=newtelefono_sistema.substring(0,48);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono_sistema");
				}

				this.telefono_sistema=newtelefono_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfax_sistema(String newfax_sistema)throws Exception
	{
		try {
			if(this.fax_sistema!=newfax_sistema) {
				if(newfax_sistema==null) {
					//newfax_sistema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna fax_sistema");
					}
				}

				if(newfax_sistema!=null&&newfax_sistema.length()>50) {
					newfax_sistema=newfax_sistema.substring(0,48);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fax_sistema");
				}

				this.fax_sistema=newfax_sistema;
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
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna representante_nombre");
					}
				}

				if(newrepresentante_nombre!=null&&newrepresentante_nombre.length()>150) {
					newrepresentante_nombre=newrepresentante_nombre.substring(0,148);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna representante_nombre");
				}

				this.representante_nombre=newrepresentante_nombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_proceso_actualizacion(String newcodigo_proceso_actualizacion)throws Exception
	{
		try {
			if(this.codigo_proceso_actualizacion!=newcodigo_proceso_actualizacion) {
				if(newcodigo_proceso_actualizacion==null) {
					//newcodigo_proceso_actualizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna codigo_proceso_actualizacion");
					}
				}

				if(newcodigo_proceso_actualizacion!=null&&newcodigo_proceso_actualizacion.length()>50) {
					newcodigo_proceso_actualizacion=newcodigo_proceso_actualizacion.substring(0,48);
					System.out.println("ParametroGeneralSg:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_proceso_actualizacion");
				}

				this.codigo_proceso_actualizacion=newcodigo_proceso_actualizacion;
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
						System.out.println("ParametroGeneralSg:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	String esta_activo_descripcion="";
	
	
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

