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
package com.bydan.erp.sris.business.entity;

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
//import com.bydan.erp.sris.util.AutoriRetencionConstantesFunciones;
import com.bydan.erp.sris.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class AutoriRetencion extends AutoriRetencionAdditional implements Serializable ,Cloneable {//AutoriRetencionAdditional,GeneralEntity
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
	
	private AutoriRetencion autoriretencionOriginal;
	
	private Map<String, Object> mapAutoriRetencion;
			
	public Map<String, Object> getMapAutoriRetencion() {
		return mapAutoriRetencion;
	}

	public void setMapAutoriRetencion(Map<String, Object> mapAutoriRetencion) {
		this.mapAutoriRetencion = mapAutoriRetencion;
	}
	
	public void inicializarMapAutoriRetencion() {
		this.mapAutoriRetencion = new HashMap<String,Object>();
	}
	
	public void setMapAutoriRetencionValue(String sKey,Object oValue) {
		this.mapAutoriRetencion.put(sKey, oValue);
	}
	
	public Object getMapAutoriRetencionValue(String sKey) {
		return this.mapAutoriRetencion.get(sKey);
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
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AutoriRetencionConstantesFunciones.SREGEXNUMERO_SERIE,message=AutoriRetencionConstantesFunciones.SMENSAJEREGEXNUMERO_SERIE)
	private String numero_serie;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AutoriRetencionConstantesFunciones.SREGEXNUMERO_AUTORIZACION,message=AutoriRetencionConstantesFunciones.SMENSAJEREGEXNUMERO_AUTORIZACION)
	private String numero_autorizacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AutoriRetencionConstantesFunciones.SREGEXNUMERO_INICIAL,message=AutoriRetencionConstantesFunciones.SMENSAJEREGEXNUMERO_INICIAL)
	private String numero_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=AutoriRetencionConstantesFunciones.SREGEXNUMERO_FINAL,message=AutoriRetencionConstantesFunciones.SMENSAJEREGEXNUMERO_FINAL)
	private String numero_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_caducidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	
	
		
	public AutoriRetencion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.autoriretencionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.numero_serie="";
 		this.numero_autorizacion="";
 		this.numero_inicial="";
 		this.numero_final="";
 		this.fecha_caducidad=new Date();
 		this.esta_activo=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AutoriRetencion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,String numero_serie,String numero_autorizacion,String numero_inicial,String numero_final,Date fecha_caducidad,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoriretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_inicial=numero_inicial;
 		this.numero_final=numero_final;
 		this.fecha_caducidad=fecha_caducidad;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AutoriRetencion (Long id_empresa,Long id_sucursal,Long id_usuario,String numero_serie,String numero_autorizacion,String numero_inicial,String numero_final,Date fecha_caducidad,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoriretencionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.numero_serie=numero_serie;
 		this.numero_autorizacion=numero_autorizacion;
 		this.numero_inicial=numero_inicial;
 		this.numero_final=numero_final;
 		this.fecha_caducidad=fecha_caducidad;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AutoriRetencion autoriretencionLocal=null;
		
		if(object!=null) {
			autoriretencionLocal=(AutoriRetencion)object;
			
			if(autoriretencionLocal!=null) {
				if(this.getId()!=null && autoriretencionLocal.getId()!=null) {
					if(this.getId().equals(autoriretencionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AutoriRetencionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AutoriRetencionConstantesFunciones.getAutoriRetencionDescripcion(this);
		} else {
			sDetalle=AutoriRetencionConstantesFunciones.getAutoriRetencionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AutoriRetencion getAutoriRetencionOriginal() {
		return this.autoriretencionOriginal;
	}
	
	public void setAutoriRetencionOriginal(AutoriRetencion autoriretencion) {
		try {
			this.autoriretencionOriginal=autoriretencion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AutoriRetencionAdditional autoriretencionAdditional=null;
	
	public AutoriRetencionAdditional getAutoriRetencionAdditional() {
		return this.autoriretencionAdditional;
	}
	
	public void setAutoriRetencionAdditional(AutoriRetencionAdditional autoriretencionAdditional) {
		try {
			this.autoriretencionAdditional=autoriretencionAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public String getnumero_serie() {
		return this.numero_serie;
	}
    
	
	public String getnumero_autorizacion() {
		return this.numero_autorizacion;
	}
    
	
	public String getnumero_inicial() {
		return this.numero_inicial;
	}
    
	
	public String getnumero_final() {
		return this.numero_final;
	}
    
	
	public Date getfecha_caducidad() {
		return this.fecha_caducidad;
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
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_serie(String newnumero_serie)throws Exception
	{
		try {
			if(this.numero_serie!=newnumero_serie) {
				if(newnumero_serie==null) {
					//newnumero_serie="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna numero_serie");
					}
				}

				if(newnumero_serie!=null&&newnumero_serie.length()>20) {
					newnumero_serie=newnumero_serie.substring(0,18);
					System.out.println("AutoriRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_serie");
				}

				this.numero_serie=newnumero_serie;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_autorizacion(String newnumero_autorizacion)throws Exception
	{
		try {
			if(this.numero_autorizacion!=newnumero_autorizacion) {
				if(newnumero_autorizacion==null) {
					//newnumero_autorizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna numero_autorizacion");
					}
				}

				if(newnumero_autorizacion!=null&&newnumero_autorizacion.length()>20) {
					newnumero_autorizacion=newnumero_autorizacion.substring(0,18);
					System.out.println("AutoriRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_autorizacion");
				}

				this.numero_autorizacion=newnumero_autorizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_inicial(String newnumero_inicial)throws Exception
	{
		try {
			if(this.numero_inicial!=newnumero_inicial) {
				if(newnumero_inicial==null) {
					//newnumero_inicial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna numero_inicial");
					}
				}

				if(newnumero_inicial!=null&&newnumero_inicial.length()>20) {
					newnumero_inicial=newnumero_inicial.substring(0,18);
					System.out.println("AutoriRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_inicial");
				}

				this.numero_inicial=newnumero_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_final(String newnumero_final)throws Exception
	{
		try {
			if(this.numero_final!=newnumero_final) {
				if(newnumero_final==null) {
					//newnumero_final="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna numero_final");
					}
				}

				if(newnumero_final!=null&&newnumero_final.length()>20) {
					newnumero_final=newnumero_final.substring(0,18);
					System.out.println("AutoriRetencion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna numero_final");
				}

				this.numero_final=newnumero_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_caducidad(Date newfecha_caducidad)throws Exception
	{
		try {
			if(this.fecha_caducidad!=newfecha_caducidad) {
				if(newfecha_caducidad==null) {
					//newfecha_caducidad=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna fecha_caducidad");
					}
				}

				this.fecha_caducidad=newfecha_caducidad;
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
						System.out.println("AutoriRetencion:Valor nulo no permitido en columna esta_activo");
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

