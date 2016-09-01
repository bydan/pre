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
//import com.bydan.erp.cartera.util.RepresentanteLegalConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class RepresentanteLegal extends RepresentanteLegalAdditional implements Serializable ,Cloneable {//RepresentanteLegalAdditional,GeneralEntity
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
	
	private RepresentanteLegal representantelegalOriginal;
	
	private Map<String, Object> mapRepresentanteLegal;
			
	public Map<String, Object> getMapRepresentanteLegal() {
		return mapRepresentanteLegal;
	}

	public void setMapRepresentanteLegal(Map<String, Object> mapRepresentanteLegal) {
		this.mapRepresentanteLegal = mapRepresentanteLegal;
	}
	
	public void inicializarMapRepresentanteLegal() {
		this.mapRepresentanteLegal = new HashMap<String,Object>();
	}
	
	public void setMapRepresentanteLegalValue(String sKey,Object oValue) {
		this.mapRepresentanteLegal.put(sKey, oValue);
	}
	
	public Object getMapRepresentanteLegalValue(String sKey) {
		return this.mapRepresentanteLegal.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientedocumento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXIDENTIFICACION,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXAPELLIDOPATERNO,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXAPELLIDOPATERNO)
	private String apellidopaterno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXAPELLIDOMATERNO,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXAPELLIDOMATERNO)
	private String apellidomaterno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXPRIMERNOMBRE,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXPRIMERNOMBRE)
	private String primernombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXSEGUNDONOMBRE,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXSEGUNDONOMBRE)
	private String segundonombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXDIRECCION,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXTELEFONO,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXTELEFONOCODIGOAREA,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXTELEFONOCODIGOAREA)
	private String telefonocodigoarea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXEXTENSION,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXEXTENSION)
	private String extension;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXTELEFONOMOVIL,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXTELEFONOMOVIL)
	private String telefonomovil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double montoaurorizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RepresentanteLegalConstantesFunciones.SREGEXEMAIL,message=RepresentanteLegalConstantesFunciones.SMENSAJEREGEXEMAIL)
	private String email;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estaactivo;
			
	
	public Cliente cliente;
	public TipoIdentificacion tipoidentificacion;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String cliente_descripcion;
	private String tipoidentificacion_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
		
	public RepresentanteLegal () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.representantelegalOriginal=this;
		
 		this.idcliente=-1L;
 		this.idvalorclientedocumento=-1L;
 		this.id_pais=-1L;
 		this.idciudad=-1L;
 		this.identificacion="";
 		this.apellidopaterno="";
 		this.apellidomaterno="";
 		this.primernombre="";
 		this.segundonombre="";
 		this.direccion="";
 		this.telefono="";
 		this.telefonocodigoarea="";
 		this.extension="";
 		this.telefonomovil="";
 		this.montoaurorizado=0.0;
 		this.email="";
 		this.estaactivo=false;
		
		
		this.cliente=null;
		this.tipoidentificacion=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.cliente_descripcion="";
		this.tipoidentificacion_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RepresentanteLegal (Long id,Date versionRow,Long idcliente,Long idvalorclientedocumento,Long id_pais,Long idciudad,String identificacion,String apellidopaterno,String apellidomaterno,String primernombre,String segundonombre,String direccion,String telefono,String telefonocodigoarea,String extension,String telefonomovil,Double montoaurorizado,String email,Boolean estaactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.representantelegalOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientedocumento=idvalorclientedocumento;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.identificacion=identificacion;
 		this.apellidopaterno=apellidopaterno;
 		this.apellidomaterno=apellidomaterno;
 		this.primernombre=primernombre;
 		this.segundonombre=segundonombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.extension=extension;
 		this.telefonomovil=telefonomovil;
 		this.montoaurorizado=montoaurorizado;
 		this.email=email;
 		this.estaactivo=estaactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RepresentanteLegal (Long idcliente,Long idvalorclientedocumento,Long id_pais,Long idciudad,String identificacion,String apellidopaterno,String apellidomaterno,String primernombre,String segundonombre,String direccion,String telefono,String telefonocodigoarea,String extension,String telefonomovil,Double montoaurorizado,String email,Boolean estaactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.representantelegalOriginal=this;
		
 		this.idcliente=idcliente;
 		this.idvalorclientedocumento=idvalorclientedocumento;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.identificacion=identificacion;
 		this.apellidopaterno=apellidopaterno;
 		this.apellidomaterno=apellidomaterno;
 		this.primernombre=primernombre;
 		this.segundonombre=segundonombre;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.extension=extension;
 		this.telefonomovil=telefonomovil;
 		this.montoaurorizado=montoaurorizado;
 		this.email=email;
 		this.estaactivo=estaactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RepresentanteLegal representantelegalLocal=null;
		
		if(object!=null) {
			representantelegalLocal=(RepresentanteLegal)object;
			
			if(representantelegalLocal!=null) {
				if(this.getId()!=null && representantelegalLocal.getId()!=null) {
					if(this.getId().equals(representantelegalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RepresentanteLegalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RepresentanteLegalConstantesFunciones.getRepresentanteLegalDescripcion(this);
		} else {
			sDetalle=RepresentanteLegalConstantesFunciones.getRepresentanteLegalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RepresentanteLegal getRepresentanteLegalOriginal() {
		return this.representantelegalOriginal;
	}
	
	public void setRepresentanteLegalOriginal(RepresentanteLegal representantelegal) {
		try {
			this.representantelegalOriginal=representantelegal;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RepresentanteLegalAdditional representantelegalAdditional=null;
	
	public RepresentanteLegalAdditional getRepresentanteLegalAdditional() {
		return this.representantelegalAdditional;
	}
	
	public void setRepresentanteLegalAdditional(RepresentanteLegalAdditional representantelegalAdditional) {
		try {
			this.representantelegalAdditional=representantelegalAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientedocumento() {
		return this.idvalorclientedocumento;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getidciudad() {
		return this.idciudad;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getapellidopaterno() {
		return this.apellidopaterno;
	}
    
	
	public String getapellidomaterno() {
		return this.apellidomaterno;
	}
    
	
	public String getprimernombre() {
		return this.primernombre;
	}
    
	
	public String getsegundonombre() {
		return this.segundonombre;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gettelefonocodigoarea() {
		return this.telefonocodigoarea;
	}
    
	
	public String getextension() {
		return this.extension;
	}
    
	
	public String gettelefonomovil() {
		return this.telefonomovil;
	}
    
	
	public Double getmontoaurorizado() {
		return this.montoaurorizado;
	}
    
	
	public String getemail() {
		return this.email;
	}
    
	
	public Boolean getestaactivo() {
		return this.estaactivo;
	}
	
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientedocumento(Long newidvalorclientedocumento)throws Exception
	{
		try {
			if(this.idvalorclientedocumento!=newidvalorclientedocumento) {
				if(newidvalorclientedocumento==null) {
					//newidvalorclientedocumento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna idvalorclientedocumento");
					}
				}

				this.idvalorclientedocumento=newidvalorclientedocumento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidciudad(Long newidciudad)throws Exception
	{
		try {
			if(this.idciudad!=newidciudad) {
				if(newidciudad==null) {
					//newidciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna idciudad");
					}
				}

				this.idciudad=newidciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion.trim()!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellidopaterno(String newapellidopaterno)throws Exception
	{
		try {
			if(this.apellidopaterno!=newapellidopaterno) {
				if(newapellidopaterno==null) {
					//newapellidopaterno="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna apellidopaterno");
					}
				}

				if(newapellidopaterno!=null&&newapellidopaterno.length()>100) {
					newapellidopaterno=newapellidopaterno.substring(0,98);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellidopaterno");
				}

				this.apellidopaterno=newapellidopaterno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellidomaterno(String newapellidomaterno)throws Exception
	{
		try {
			if(this.apellidomaterno!=newapellidomaterno) {
				if(newapellidomaterno==null) {
					//newapellidomaterno="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna apellidomaterno");
					}
				}

				if(newapellidomaterno!=null&&newapellidomaterno.length()>100) {
					newapellidomaterno=newapellidomaterno.substring(0,98);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellidomaterno");
				}

				this.apellidomaterno=newapellidomaterno;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprimernombre(String newprimernombre)throws Exception
	{
		try {
			if(this.primernombre!=newprimernombre) {
				if(newprimernombre==null) {
					//newprimernombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna primernombre");
					}
				}

				if(newprimernombre!=null&&newprimernombre.length()>100) {
					newprimernombre=newprimernombre.substring(0,98);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna primernombre");
				}

				this.primernombre=newprimernombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsegundonombre(String newsegundonombre)throws Exception
	{
		try {
			if(this.segundonombre!=newsegundonombre) {
				if(newsegundonombre==null) {
					//newsegundonombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna segundonombre");
					}
				}

				if(newsegundonombre!=null&&newsegundonombre.length()>100) {
					newsegundonombre=newsegundonombre.substring(0,98);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna segundonombre");
				}

				this.segundonombre=newsegundonombre;
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
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
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
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>200) {
					newtelefono=newtelefono.substring(0,198);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefonocodigoarea(String newtelefonocodigoarea)throws Exception
	{
		try {
			if(this.telefonocodigoarea!=newtelefonocodigoarea) {
				if(newtelefonocodigoarea==null) {
					//newtelefonocodigoarea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna telefonocodigoarea");
					}
				}

				if(newtelefonocodigoarea!=null&&newtelefonocodigoarea.length()>50) {
					newtelefonocodigoarea=newtelefonocodigoarea.substring(0,48);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefonocodigoarea");
				}

				this.telefonocodigoarea=newtelefonocodigoarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setextension(String newextension)throws Exception
	{
		try {
			if(this.extension!=newextension) {
				if(newextension==null) {
					//newextension="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna extension");
					}
				}

				if(newextension!=null&&newextension.length()>50) {
					newextension=newextension.substring(0,48);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna extension");
				}

				this.extension=newextension;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefonomovil(String newtelefonomovil)throws Exception
	{
		try {
			if(this.telefonomovil!=newtelefonomovil) {
				if(newtelefonomovil==null) {
					//newtelefonomovil="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna telefonomovil");
					}
				}

				if(newtelefonomovil!=null&&newtelefonomovil.length()>200) {
					newtelefonomovil=newtelefonomovil.substring(0,198);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefonomovil");
				}

				this.telefonomovil=newtelefonomovil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmontoaurorizado(Double newmontoaurorizado)throws Exception
	{
		try {
			if(this.montoaurorizado!=newmontoaurorizado) {
				if(newmontoaurorizado==null) {
					//newmontoaurorizado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna montoaurorizado");
					}
				}

				this.montoaurorizado=newmontoaurorizado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setemail(String newemail)throws Exception
	{
		try {
			if(this.email!=newemail) {
				if(newemail==null) {
					//newemail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna email");
					}
				}

				if(newemail!=null&&newemail.length()>200) {
					newemail=newemail.substring(0,198);
					System.out.println("RepresentanteLegal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna email");
				}

				this.email=newemail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestaactivo(Boolean newestaactivo)throws Exception
	{
		try {
			if(this.estaactivo!=newestaactivo) {
				if(newestaactivo==null) {
					//newestaactivo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RepresentanteLegal:Valor nulo no permitido en columna estaactivo");
					}
				}

				this.estaactivo=newestaactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	
	
	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
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


	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String idcliente_descripcion="";String idvalorclientedocumento_descripcion="";String id_pais_descripcion="";String idciudad_descripcion="";String estaactivo_descripcion="";
	
	
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientedocumento_descripcion() {
		return idvalorclientedocumento_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getidciudad_descripcion() {
		return idciudad_descripcion;
	}
	public String getestaactivo_descripcion() {
		return estaactivo_descripcion;
	}
	
	
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientedocumento_descripcion(String newidvalorclientedocumento_descripcion)throws Exception {
		try {
			this.idvalorclientedocumento_descripcion=newidvalorclientedocumento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidciudad_descripcion(String newidciudad_descripcion)throws Exception {
		try {
			this.idciudad_descripcion=newidciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setestaactivo_descripcion(String newestaactivo_descripcion)throws Exception {
		try {
			this.estaactivo_descripcion=newestaactivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.idcliente_descripcion="";this.idvalorclientedocumento_descripcion="";this.id_pais_descripcion="";this.idciudad_descripcion="";this.estaactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

