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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.ClienteImagenConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ClienteImagen extends ClienteImagenAdditional implements Serializable ,Cloneable {//ClienteImagenAdditional,GeneralEntity
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
	
	private ClienteImagen clienteimagenOriginal;
	
	private Map<String, Object> mapClienteImagen;
			
	public Map<String, Object> getMapClienteImagen() {
		return mapClienteImagen;
	}

	public void setMapClienteImagen(Map<String, Object> mapClienteImagen) {
		this.mapClienteImagen = mapClienteImagen;
	}
	
	public void inicializarMapClienteImagen() {
		this.mapClienteImagen = new HashMap<String,Object>();
	}
	
	public void setMapClienteImagenValue(String sKey,Object oValue) {
		this.mapClienteImagen.put(sKey, oValue);
	}
	
	public Object getMapClienteImagenValue(String sKey) {
		return this.mapClienteImagen.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_imagen_persona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_imagen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteImagenConstantesFunciones.SREGEXNOMBRE,message=ClienteImagenConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private byte [] imagen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteImagenConstantesFunciones.SREGEXDESCRIPCION,message=ClienteImagenConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Cliente cliente;
	public TipoImagenPersona tipoimagenpersona;
	public TipoImagen tipoimagen;
	
	
	private String cliente_descripcion;
	private String tipoimagenpersona_descripcion;
	private String tipoimagen_descripcion;
	
	
		
	public ClienteImagen () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.clienteimagenOriginal=this;
		
 		this.id_cliente=-1L;
 		this.id_tipo_imagen_persona=-1L;
 		this.id_tipo_imagen=-1L;
 		this.nombre="";
 		this.imagen=null;
 		this.descripcion="";
		
		
		this.cliente=null;
		this.tipoimagenpersona=null;
		this.tipoimagen=null;
		
		
		this.cliente_descripcion="";
		this.tipoimagenpersona_descripcion="";
		this.tipoimagen_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ClienteImagen (Long id,Date versionRow,Long id_cliente,Long id_tipo_imagen_persona,Long id_tipo_imagen,String nombre,byte [] imagen,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteimagenOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_tipo_imagen_persona=id_tipo_imagen_persona;
 		this.id_tipo_imagen=id_tipo_imagen;
 		this.nombre=nombre;
 		this.imagen=imagen;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ClienteImagen (Long id_cliente,Long id_tipo_imagen_persona,Long id_tipo_imagen,String nombre,byte [] imagen,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clienteimagenOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_tipo_imagen_persona=id_tipo_imagen_persona;
 		this.id_tipo_imagen=id_tipo_imagen;
 		this.nombre=nombre;
 		this.imagen=imagen;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ClienteImagen clienteimagenLocal=null;
		
		if(object!=null) {
			clienteimagenLocal=(ClienteImagen)object;
			
			if(clienteimagenLocal!=null) {
				if(this.getId()!=null && clienteimagenLocal.getId()!=null) {
					if(this.getId().equals(clienteimagenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ClienteImagenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ClienteImagenConstantesFunciones.getClienteImagenDescripcion(this);
		} else {
			sDetalle=ClienteImagenConstantesFunciones.getClienteImagenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ClienteImagen getClienteImagenOriginal() {
		return this.clienteimagenOriginal;
	}
	
	public void setClienteImagenOriginal(ClienteImagen clienteimagen) {
		try {
			this.clienteimagenOriginal=clienteimagen;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ClienteImagenAdditional clienteimagenAdditional=null;
	
	public ClienteImagenAdditional getClienteImagenAdditional() {
		return this.clienteimagenAdditional;
	}
	
	public void setClienteImagenAdditional(ClienteImagenAdditional clienteimagenAdditional) {
		try {
			this.clienteimagenAdditional=clienteimagenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_imagen_persona() {
		return this.id_tipo_imagen_persona;
	}
    
	
	public Long getid_tipo_imagen() {
		return this.id_tipo_imagen;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public byte [] getimagen() {
		return this.imagen;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteImagen:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_imagen_persona(Long newid_tipo_imagen_persona)throws Exception
	{
		try {
			if(this.id_tipo_imagen_persona!=newid_tipo_imagen_persona) {
				if(newid_tipo_imagen_persona==null) {
					//newid_tipo_imagen_persona=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteImagen:Valor nulo no permitido en columna id_tipo_imagen_persona");
					}
				}

				this.id_tipo_imagen_persona=newid_tipo_imagen_persona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_imagen(Long newid_tipo_imagen)throws Exception
	{
		try {
			if(this.id_tipo_imagen!=newid_tipo_imagen) {
				if(newid_tipo_imagen==null) {
					//newid_tipo_imagen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteImagen:Valor nulo no permitido en columna id_tipo_imagen");
					}
				}

				this.id_tipo_imagen=newid_tipo_imagen;
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
						System.out.println("ClienteImagen:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("ClienteImagen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimagen(byte [] newimagen) {
		if(this.imagen==null&&newimagen!=null) {
			this.imagen=newimagen;
				this.setIsChanged(true);
		}

		if(this.imagen!=null&&!this.imagen.equals(newimagen)) {

			this.imagen=newimagen;
				this.setIsChanged(true);
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteImagen:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("ClienteImagen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoImagenPersona getTipoImagenPersona() {
		return this.tipoimagenpersona;
	}

	public TipoImagen getTipoImagen() {
		return this.tipoimagen;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoimagenpersona_descripcion() {
		return this.tipoimagenpersona_descripcion;
	}

	public String gettipoimagen_descripcion() {
		return this.tipoimagen_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoImagenPersona(TipoImagenPersona tipoimagenpersona) {
		try {
			this.tipoimagenpersona=tipoimagenpersona;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoImagen(TipoImagen tipoimagen) {
		try {
			this.tipoimagen=tipoimagen;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoimagenpersona_descripcion(String tipoimagenpersona_descripcion) {
		try {
			this.tipoimagenpersona_descripcion=tipoimagenpersona_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoimagen_descripcion(String tipoimagen_descripcion) {
		try {
			this.tipoimagen_descripcion=tipoimagen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cliente_descripcion="";String id_tipo_imagen_persona_descripcion="";String id_tipo_imagen_descripcion="";
	
	
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_imagen_persona_descripcion() {
		return id_tipo_imagen_persona_descripcion;
	}
	public String getid_tipo_imagen_descripcion() {
		return id_tipo_imagen_descripcion;
	}
	
	
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_imagen_persona_descripcion(String newid_tipo_imagen_persona_descripcion)throws Exception {
		try {
			this.id_tipo_imagen_persona_descripcion=newid_tipo_imagen_persona_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_imagen_descripcion(String newid_tipo_imagen_descripcion)throws Exception {
		try {
			this.id_tipo_imagen_descripcion=newid_tipo_imagen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cliente_descripcion="";this.id_tipo_imagen_persona_descripcion="";this.id_tipo_imagen_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

