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
//import com.bydan.erp.inventario.util.MensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class MensajeCorreoInven extends MensajeCorreoInvenAdditional implements Serializable ,Cloneable {//MensajeCorreoInvenAdditional,GeneralEntity
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
	
	private MensajeCorreoInven mensajecorreoinvenOriginal;
	
	private Map<String, Object> mapMensajeCorreoInven;
			
	public Map<String, Object> getMapMensajeCorreoInven() {
		return mapMensajeCorreoInven;
	}

	public void setMapMensajeCorreoInven(Map<String, Object> mapMensajeCorreoInven) {
		this.mapMensajeCorreoInven = mapMensajeCorreoInven;
	}
	
	public void inicializarMapMensajeCorreoInven() {
		this.mapMensajeCorreoInven = new HashMap<String,Object>();
	}
	
	public void setMapMensajeCorreoInvenValue(String sKey,Object oValue) {
		this.mapMensajeCorreoInven.put(sKey, oValue);
	}
	
	public Object getMapMensajeCorreoInvenValue(String sKey) {
		return this.mapMensajeCorreoInven.get(sKey);
	}
	
	
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
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_mensaje_correo_inven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MensajeCorreoInvenConstantesFunciones.SREGEXTEMA,message=MensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXTEMA)
	private String tema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MensajeCorreoInvenConstantesFunciones.SREGEXMENSAJE,message=MensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXMENSAJE)
	private String mensaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=MensajeCorreoInvenConstantesFunciones.SREGEXAVISO,message=MensajeCorreoInvenConstantesFunciones.SMENSAJEREGEXAVISO)
	private String aviso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Modulo modulo;
	public TipoMensajeCorreoInven tipomensajecorreoinven;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String modulo_descripcion;
	private String tipomensajecorreoinven_descripcion;
	
	
	public List<DetalleMensajeCorreoInven> detallemensajecorreoinvens;
	public List<MailMensajeCorreoInven> mailmensajecorreoinvens;
		
	public MensajeCorreoInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.mensajecorreoinvenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_mensaje_correo_inven=-1L;
 		this.tema="";
 		this.mensaje="";
 		this.aviso="";
 		this.esta_activo=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.modulo=null;
		this.tipomensajecorreoinven=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.modulo_descripcion="";
		this.tipomensajecorreoinven_descripcion="";
		
		
		this.detallemensajecorreoinvens=null;
		this.mailmensajecorreoinvens=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MensajeCorreoInven (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_mensaje_correo_inven,String tema,String mensaje,String aviso,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mensajecorreoinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_tipo_mensaje_correo_inven=id_tipo_mensaje_correo_inven;
 		this.tema=tema;
 		this.mensaje=mensaje;
 		this.aviso=aviso;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MensajeCorreoInven (Long id_empresa,Long id_sucursal,Long id_modulo,Long id_tipo_mensaje_correo_inven,String tema,String mensaje,String aviso,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mensajecorreoinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_modulo=id_modulo;
 		this.id_tipo_mensaje_correo_inven=id_tipo_mensaje_correo_inven;
 		this.tema=tema;
 		this.mensaje=mensaje;
 		this.aviso=aviso;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		MensajeCorreoInven mensajecorreoinvenLocal=null;
		
		if(object!=null) {
			mensajecorreoinvenLocal=(MensajeCorreoInven)object;
			
			if(mensajecorreoinvenLocal!=null) {
				if(this.getId()!=null && mensajecorreoinvenLocal.getId()!=null) {
					if(this.getId().equals(mensajecorreoinvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!MensajeCorreoInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcion(this);
		} else {
			sDetalle=MensajeCorreoInvenConstantesFunciones.getMensajeCorreoInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public MensajeCorreoInven getMensajeCorreoInvenOriginal() {
		return this.mensajecorreoinvenOriginal;
	}
	
	public void setMensajeCorreoInvenOriginal(MensajeCorreoInven mensajecorreoinven) {
		try {
			this.mensajecorreoinvenOriginal=mensajecorreoinven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MensajeCorreoInvenAdditional mensajecorreoinvenAdditional=null;
	
	public MensajeCorreoInvenAdditional getMensajeCorreoInvenAdditional() {
		return this.mensajecorreoinvenAdditional;
	}
	
	public void setMensajeCorreoInvenAdditional(MensajeCorreoInvenAdditional mensajecorreoinvenAdditional) {
		try {
			this.mensajecorreoinvenAdditional=mensajecorreoinvenAdditional;
		} catch(Exception e) {
			;
		}
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
    
	
	public Long getid_tipo_mensaje_correo_inven() {
		return this.id_tipo_mensaje_correo_inven;
	}
    
	
	public String gettema() {
		return this.tema;
	}
    
	
	public String getmensaje() {
		return this.mensaje;
	}
    
	
	public String getaviso() {
		return this.aviso;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_mensaje_correo_inven(Long newid_tipo_mensaje_correo_inven)throws Exception
	{
		try {
			if(this.id_tipo_mensaje_correo_inven!=newid_tipo_mensaje_correo_inven) {
				if(newid_tipo_mensaje_correo_inven==null) {
					//newid_tipo_mensaje_correo_inven=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna id_tipo_mensaje_correo_inven");
					}
				}

				this.id_tipo_mensaje_correo_inven=newid_tipo_mensaje_correo_inven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settema(String newtema)throws Exception
	{
		try {
			if(this.tema!=newtema) {
				if(newtema==null) {
					//newtema="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna tema");
					}
				}

				if(newtema!=null&&newtema.length()>150) {
					newtema=newtema.substring(0,148);
					System.out.println("MensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna tema");
				}

				this.tema=newtema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmensaje(String newmensaje)throws Exception
	{
		try {
			if(this.mensaje!=newmensaje) {
				if(newmensaje==null) {
					//newmensaje="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna mensaje");
					}
				}

				if(newmensaje!=null&&newmensaje.length()>250) {
					newmensaje=newmensaje.substring(0,248);
					System.out.println("MensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna mensaje");
				}

				this.mensaje=newmensaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setaviso(String newaviso)throws Exception
	{
		try {
			if(this.aviso!=newaviso) {
				if(newaviso==null) {
					//newaviso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna aviso");
					}
				}

				if(newaviso!=null&&newaviso.length()>150) {
					newaviso=newaviso.substring(0,148);
					System.out.println("MensajeCorreoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna aviso");
				}

				this.aviso=newaviso;
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
						System.out.println("MensajeCorreoInven:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
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

	public TipoMensajeCorreoInven getTipoMensajeCorreoInven() {
		return this.tipomensajecorreoinven;
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

	public String gettipomensajecorreoinven_descripcion() {
		return this.tipomensajecorreoinven_descripcion;
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


	public  void  setTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven) {
		try {
			this.tipomensajecorreoinven=tipomensajecorreoinven;
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


	public  void  settipomensajecorreoinven_descripcion(String tipomensajecorreoinven_descripcion) {
		try {
			this.tipomensajecorreoinven_descripcion=tipomensajecorreoinven_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleMensajeCorreoInven> getDetalleMensajeCorreoInvens() {
		return this.detallemensajecorreoinvens;
	}

	public List<MailMensajeCorreoInven> getMailMensajeCorreoInvens() {
		return this.mailmensajecorreoinvens;
	}

	
	
	public  void  setDetalleMensajeCorreoInvens(List<DetalleMensajeCorreoInven> detallemensajecorreoinvens) {
		try {
			this.detallemensajecorreoinvens=detallemensajecorreoinvens;
		} catch(Exception e) {
			;
		}
	}

	public  void  setMailMensajeCorreoInvens(List<MailMensajeCorreoInven> mailmensajecorreoinvens) {
		try {
			this.mailmensajecorreoinvens=mailmensajecorreoinvens;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_modulo_descripcion="";String id_tipo_mensaje_correo_inven_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_mensaje_correo_inven_descripcion() {
		return id_tipo_mensaje_correo_inven_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
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
	public void setid_tipo_mensaje_correo_inven_descripcion(String newid_tipo_mensaje_correo_inven_descripcion)throws Exception {
		try {
			this.id_tipo_mensaje_correo_inven_descripcion=newid_tipo_mensaje_correo_inven_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_modulo_descripcion="";this.id_tipo_mensaje_correo_inven_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	Object detallemensajecorreoinvensDescripcionReporte;
	Object mailmensajecorreoinvensDescripcionReporte;
	
	
	public Object getdetallemensajecorreoinvensDescripcionReporte() {
		return detallemensajecorreoinvensDescripcionReporte;
	}

	public Object getmailmensajecorreoinvensDescripcionReporte() {
		return mailmensajecorreoinvensDescripcionReporte;
	}

	
	
	public  void  setdetallemensajecorreoinvensDescripcionReporte(Object detallemensajecorreoinvens) {
		try {
			this.detallemensajecorreoinvensDescripcionReporte=detallemensajecorreoinvens;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmailmensajecorreoinvensDescripcionReporte(Object mailmensajecorreoinvens) {
		try {
			this.mailmensajecorreoinvensDescripcionReporte=mailmensajecorreoinvens;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

