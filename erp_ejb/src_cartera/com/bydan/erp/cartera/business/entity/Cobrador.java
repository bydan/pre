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
//import com.bydan.erp.cartera.util.CobradorConstantesFunciones;
import com.bydan.erp.cartera.util.*;









@SuppressWarnings("unused")
public class Cobrador extends CobradorAdditional implements Serializable ,Cloneable {//CobradorAdditional,GeneralEntity
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
	
	private Cobrador cobradorOriginal;
	
	private Map<String, Object> mapCobrador;
			
	public Map<String, Object> getMapCobrador() {
		return mapCobrador;
	}

	public void setMapCobrador(Map<String, Object> mapCobrador) {
		this.mapCobrador = mapCobrador;
	}
	
	public void inicializarMapCobrador() {
		this.mapCobrador = new HashMap<String,Object>();
	}
	
	public void setMapCobradorValue(String sKey,Object oValue) {
		this.mapCobrador.put(sKey, oValue);
	}
	
	public Object getMapCobradorValue(String sKey) {
		return this.mapCobrador.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CobradorConstantesFunciones.SREGEXIDENTIFICACION,message=CobradorConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CobradorConstantesFunciones.SREGEXAPELLIDO,message=CobradorConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CobradorConstantesFunciones.SREGEXNOMBRE,message=CobradorConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CobradorConstantesFunciones.SREGEXDIRECCION,message=CobradorConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CobradorConstantesFunciones.SREGEXTELEFONO,message=CobradorConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
			
	
	public TipoIdentificacion tipoidentificacion;
	
	
	private String tipoidentificacion_descripcion;
	
	
		
	public Cobrador () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobradorOriginal=this;
		
 		this.id_tipo_identificacion=-1L;
 		this.identificacion="";
 		this.apellido="";
 		this.nombre="";
 		this.direccion="";
 		this.telefono="";
		
		
		this.tipoidentificacion=null;
		
		
		this.tipoidentificacion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Cobrador (Long id,Date versionRow,Long id_tipo_identificacion,String identificacion,String apellido,String nombre,String direccion,String telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobradorOriginal=this;
		
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Cobrador (Long id_tipo_identificacion,String identificacion,String apellido,String nombre,String direccion,String telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobradorOriginal=this;
		
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.apellido=apellido;
 		this.nombre=nombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Cobrador cobradorLocal=null;
		
		if(object!=null) {
			cobradorLocal=(Cobrador)object;
			
			if(cobradorLocal!=null) {
				if(this.getId()!=null && cobradorLocal.getId()!=null) {
					if(this.getId().equals(cobradorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CobradorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CobradorConstantesFunciones.getCobradorDescripcion(this);
		} else {
			sDetalle=CobradorConstantesFunciones.getCobradorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Cobrador getCobradorOriginal() {
		return this.cobradorOriginal;
	}
	
	public void setCobradorOriginal(Cobrador cobrador) {
		try {
			this.cobradorOriginal=cobrador;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobradorAdditional cobradorAdditional=null;
	
	public CobradorAdditional getCobradorAdditional() {
		return this.cobradorAdditional;
	}
	
	public void setCobradorAdditional(CobradorAdditional cobradorAdditional) {
		try {
			this.cobradorAdditional=cobradorAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_identificacion() {
		return this.id_tipo_identificacion;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
	
    
	public void setid_tipo_identificacion(Long newid_tipo_identificacion)throws Exception
	{
		try {
			if(this.id_tipo_identificacion!=newid_tipo_identificacion) {
				if(newid_tipo_identificacion==null) {
					//newid_tipo_identificacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cobrador:Valor nulo no permitido en columna id_tipo_identificacion");
					}
				}

				this.id_tipo_identificacion=newid_tipo_identificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cobrador:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("Cobrador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cobrador:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>50) {
					newapellido=newapellido.substring(0,48);
					System.out.println("Cobrador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("Cobrador:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Cobrador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cobrador:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Cobrador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Cobrador:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Cobrador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	
	
	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	
	
	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_identificacion_descripcion="";
	
	
	public String getid_tipo_identificacion_descripcion() {
		return id_tipo_identificacion_descripcion;
	}
	
	
	public void setid_tipo_identificacion_descripcion(String newid_tipo_identificacion_descripcion)throws Exception {
		try {
			this.id_tipo_identificacion_descripcion=newid_tipo_identificacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_identificacion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

