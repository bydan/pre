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
//import com.bydan.erp.cartera.util.ClienteArchivoConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ClienteArchivo extends ClienteArchivoAdditional implements Serializable ,Cloneable {//ClienteArchivoAdditional,GeneralEntity
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
	
	private ClienteArchivo clientearchivoOriginal;
	
	private Map<String, Object> mapClienteArchivo;
			
	public Map<String, Object> getMapClienteArchivo() {
		return mapClienteArchivo;
	}

	public void setMapClienteArchivo(Map<String, Object> mapClienteArchivo) {
		this.mapClienteArchivo = mapClienteArchivo;
	}
	
	public void inicializarMapClienteArchivo() {
		this.mapClienteArchivo = new HashMap<String,Object>();
	}
	
	public void setMapClienteArchivoValue(String sKey,Object oValue) {
		this.mapClienteArchivo.put(sKey, oValue);
	}
	
	public Object getMapClienteArchivoValue(String sKey) {
		return this.mapClienteArchivo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_archivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteArchivoConstantesFunciones.SREGEXNOMBRE,message=ClienteArchivoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private byte [] archivo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ClienteArchivoConstantesFunciones.SREGEXDESCRIPCION,message=ClienteArchivoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Cliente cliente;
	public TipoArchivo tipoarchivo;
	
	
	private String cliente_descripcion;
	private String tipoarchivo_descripcion;
	
	
		
	public ClienteArchivo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.clientearchivoOriginal=this;
		
 		this.id_cliente=-1L;
 		this.id_tipo_archivo=-1L;
 		this.nombre="";
 		this.archivo=null;
 		this.descripcion="";
		
		
		this.cliente=null;
		this.tipoarchivo=null;
		
		
		this.cliente_descripcion="";
		this.tipoarchivo_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ClienteArchivo (Long id,Date versionRow,Long id_cliente,Long id_tipo_archivo,String nombre,byte [] archivo,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clientearchivoOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_tipo_archivo=id_tipo_archivo;
 		this.nombre=nombre;
 		this.archivo=archivo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ClienteArchivo (Long id_cliente,Long id_tipo_archivo,String nombre,byte [] archivo,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.clientearchivoOriginal=this;
		
 		this.id_cliente=id_cliente;
 		this.id_tipo_archivo=id_tipo_archivo;
 		this.nombre=nombre;
 		this.archivo=archivo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ClienteArchivo clientearchivoLocal=null;
		
		if(object!=null) {
			clientearchivoLocal=(ClienteArchivo)object;
			
			if(clientearchivoLocal!=null) {
				if(this.getId()!=null && clientearchivoLocal.getId()!=null) {
					if(this.getId().equals(clientearchivoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ClienteArchivoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ClienteArchivoConstantesFunciones.getClienteArchivoDescripcion(this);
		} else {
			sDetalle=ClienteArchivoConstantesFunciones.getClienteArchivoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ClienteArchivo getClienteArchivoOriginal() {
		return this.clientearchivoOriginal;
	}
	
	public void setClienteArchivoOriginal(ClienteArchivo clientearchivo) {
		try {
			this.clientearchivoOriginal=clientearchivo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ClienteArchivoAdditional clientearchivoAdditional=null;
	
	public ClienteArchivoAdditional getClienteArchivoAdditional() {
		return this.clientearchivoAdditional;
	}
	
	public void setClienteArchivoAdditional(ClienteArchivoAdditional clientearchivoAdditional) {
		try {
			this.clientearchivoAdditional=clientearchivoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_archivo() {
		return this.id_tipo_archivo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public byte [] getarchivo() {
		return this.archivo;
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
						System.out.println("ClienteArchivo:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_archivo(Long newid_tipo_archivo)throws Exception
	{
		try {
			if(this.id_tipo_archivo!=newid_tipo_archivo) {
				if(newid_tipo_archivo==null) {
					//newid_tipo_archivo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ClienteArchivo:Valor nulo no permitido en columna id_tipo_archivo");
					}
				}

				this.id_tipo_archivo=newid_tipo_archivo;
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
						System.out.println("ClienteArchivo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("ClienteArchivo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarchivo(byte [] newarchivo) {
		if(this.archivo==null&&newarchivo!=null) {
			this.archivo=newarchivo;
				this.setIsChanged(true);
		}

		if(this.archivo!=null&&!this.archivo.equals(newarchivo)) {

			this.archivo=newarchivo;
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
						System.out.println("ClienteArchivo:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("ClienteArchivo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
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

	public TipoArchivo getTipoArchivo() {
		return this.tipoarchivo;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoarchivo_descripcion() {
		return this.tipoarchivo_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoArchivo(TipoArchivo tipoarchivo) {
		try {
			this.tipoarchivo=tipoarchivo;
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


	public  void  settipoarchivo_descripcion(String tipoarchivo_descripcion) {
		try {
			this.tipoarchivo_descripcion=tipoarchivo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_cliente_descripcion="";String id_tipo_archivo_descripcion="";
	
	
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_archivo_descripcion() {
		return id_tipo_archivo_descripcion;
	}
	
	
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_archivo_descripcion(String newid_tipo_archivo_descripcion)throws Exception {
		try {
			this.id_tipo_archivo_descripcion=newid_tipo_archivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_cliente_descripcion="";this.id_tipo_archivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

