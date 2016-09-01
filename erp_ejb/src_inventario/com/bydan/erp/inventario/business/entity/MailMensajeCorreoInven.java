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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.MailMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class MailMensajeCorreoInven extends MailMensajeCorreoInvenAdditional implements Serializable ,Cloneable {//MailMensajeCorreoInvenAdditional,GeneralEntity
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
	
	private MailMensajeCorreoInven mailmensajecorreoinvenOriginal;
	
	private Map<String, Object> mapMailMensajeCorreoInven;
			
	public Map<String, Object> getMapMailMensajeCorreoInven() {
		return mapMailMensajeCorreoInven;
	}

	public void setMapMailMensajeCorreoInven(Map<String, Object> mapMailMensajeCorreoInven) {
		this.mapMailMensajeCorreoInven = mapMailMensajeCorreoInven;
	}
	
	public void inicializarMapMailMensajeCorreoInven() {
		this.mapMailMensajeCorreoInven = new HashMap<String,Object>();
	}
	
	public void setMapMailMensajeCorreoInvenValue(String sKey,Object oValue) {
		this.mapMailMensajeCorreoInven.put(sKey, oValue);
	}
	
	public Object getMapMailMensajeCorreoInvenValue(String sKey) {
		return this.mapMailMensajeCorreoInven.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mensaje_correo_inven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MailMensajeCorreoInvenConstantesFunciones.SREGEXMAIL,message=MailMensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXMAIL)
	private String mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public MensajeCorreoInven mensajecorreoinven;
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	
	
	private String mensajecorreoinven_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	
	
		
	public MailMensajeCorreoInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.mailmensajecorreoinvenOriginal=this;
		
 		this.id_mensaje_correo_inven=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.mail="";
 		this.esta_activo=false;
		
		
		this.mensajecorreoinven=null;
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		
		
		this.mensajecorreoinven_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MailMensajeCorreoInven (Long id,Date versionRow,Long id_mensaje_correo_inven,Long id_empresa,Long id_sucursal,Long id_modulo,String mail,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mailmensajecorreoinvenOriginal=this;
		
 		this.id_mensaje_correo_inven=id_mensaje_correo_inven;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.mail=mail;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MailMensajeCorreoInven (Long id_mensaje_correo_inven,Long id_empresa,Long id_sucursal,Long id_modulo,String mail,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mailmensajecorreoinvenOriginal=this;
		
 		this.id_mensaje_correo_inven=id_mensaje_correo_inven;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.mail=mail;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		MailMensajeCorreoInven mailmensajecorreoinvenLocal=null;
		
		if(object!=null) {
			mailmensajecorreoinvenLocal=(MailMensajeCorreoInven)object;
			
			if(mailmensajecorreoinvenLocal!=null) {
				if(this.getId()!=null && mailmensajecorreoinvenLocal.getId()!=null) {
					if(this.getId().equals(mailmensajecorreoinvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!MailMensajeCorreoInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=MailMensajeCorreoInvenConstantesFunciones.getMailMensajeCorreoInvenDescripcion(this);
		} else {
			sDetalle=MailMensajeCorreoInvenConstantesFunciones.getMailMensajeCorreoInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public MailMensajeCorreoInven getMailMensajeCorreoInvenOriginal() {
		return this.mailmensajecorreoinvenOriginal;
	}
	
	public void setMailMensajeCorreoInvenOriginal(MailMensajeCorreoInven mailmensajecorreoinven) {
		try {
			this.mailmensajecorreoinvenOriginal=mailmensajecorreoinven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MailMensajeCorreoInvenAdditional mailmensajecorreoinvenAdditional=null;
	
	public MailMensajeCorreoInvenAdditional getMailMensajeCorreoInvenAdditional() {
		return this.mailmensajecorreoinvenAdditional;
	}
	
	public void setMailMensajeCorreoInvenAdditional(MailMensajeCorreoInvenAdditional mailmensajecorreoinvenAdditional) {
		try {
			this.mailmensajecorreoinvenAdditional=mailmensajecorreoinvenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_mensaje_correo_inven() {
		return this.id_mensaje_correo_inven;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public String getmail() {
		return this.mail;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setid_mensaje_correo_inven(Long newid_mensaje_correo_inven)throws Exception
	{
		try {
			if(this.id_mensaje_correo_inven!=newid_mensaje_correo_inven) {
				if(newid_mensaje_correo_inven==null) {
					//newid_mensaje_correo_inven=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna id_mensaje_correo_inven");
					}
				}

				this.id_mensaje_correo_inven=newid_mensaje_correo_inven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna mail");
					}
				}

				if(newmail!=null&&newmail.length()>100) {
					newmail=newmail.substring(0,98);
					System.out.println("MailMensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna mail");
				}

				this.mail=newmail;
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
						System.out.println("MailMensajeCorreoInven:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public MensajeCorreoInven getMensajeCorreoInven() {
		return this.mensajecorreoinven;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	
	
	public String getmensajecorreoinven_descripcion() {
		return this.mensajecorreoinven_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	
	
	public  void  setMensajeCorreoInven(MensajeCorreoInven mensajecorreoinven) {
		try {
			this.mensajecorreoinven=mensajecorreoinven;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	
	
	public  void  setmensajecorreoinven_descripcion(String mensajecorreoinven_descripcion) {
		try {
			this.mensajecorreoinven_descripcion=mensajecorreoinven_descripcion;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_mensaje_correo_inven_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_mensaje_correo_inven_descripcion() {
		return id_mensaje_correo_inven_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_mensaje_correo_inven_descripcion(String newid_mensaje_correo_inven_descripcion)throws Exception {
		try {
			this.id_mensaje_correo_inven_descripcion=newid_mensaje_correo_inven_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_mensaje_correo_inven_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

