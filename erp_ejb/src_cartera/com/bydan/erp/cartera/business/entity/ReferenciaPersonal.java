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
//import com.bydan.erp.cartera.util.ReferenciaPersonalConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ReferenciaPersonal extends ReferenciaPersonalAdditional implements Serializable ,Cloneable {//ReferenciaPersonalAdditional,GeneralEntity
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
	
	private ReferenciaPersonal referenciapersonalOriginal;
	
	private Map<String, Object> mapReferenciaPersonal;
			
	public Map<String, Object> getMapReferenciaPersonal() {
		return mapReferenciaPersonal;
	}

	public void setMapReferenciaPersonal(Map<String, Object> mapReferenciaPersonal) {
		this.mapReferenciaPersonal = mapReferenciaPersonal;
	}
	
	public void inicializarMapReferenciaPersonal() {
		this.mapReferenciaPersonal = new HashMap<String,Object>();
	}
	
	public void setMapReferenciaPersonalValue(String sKey,Object oValue) {
		this.mapReferenciaPersonal.put(sKey, oValue);
	}
	
	public Object getMapReferenciaPersonalValue(String sKey) {
		return this.mapReferenciaPersonal.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idcliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idvalorclientereferenciapersonal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long idciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXNOMBRE,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXIDENTIFICACION,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXDIRECCION,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXTELEFONO,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXTELEFONOMOVIL,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXTELEFONOMOVIL)
	private String telefonomovil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXTELEFONOCODIGOAREA,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXTELEFONOCODIGOAREA)
	private String telefonocodigoarea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXPREFERENCIA,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXPREFERENCIA)
	private String preferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXEMAIL,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXEMAIL)
	private String email;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=400,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXOBSERVACION,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_trabajando;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXEMPRESA_TRABAJO,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXEMPRESA_TRABAJO)
	private String empresa_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXDIRECCION_TRABAJO,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXDIRECCION_TRABAJO)
	private String direccion_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ReferenciaPersonalConstantesFunciones.SREGEXTELEFONO_TRABAJO,message=ReferenciaPersonalConstantesFunciones.SMENSAJEREGEXTELEFONO_TRABAJO)
	private String telefono_trabajo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esactivo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public TipoRefePerso tiporefeperso;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String tiporefeperso_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
		
	public ReferenciaPersonal () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.referenciapersonalOriginal=this;
		
 		this.id_empresa=-1L;
 		this.idcliente=-1L;
 		this.idvalorclientereferenciapersonal=-1L;
 		this.id_pais=-1L;
 		this.idciudad=-1L;
 		this.nombre="";
 		this.identificacion="";
 		this.fecha_nacimiento=new Date();
 		this.direccion="";
 		this.telefono="";
 		this.telefonomovil="";
 		this.telefonocodigoarea="";
 		this.preferencia="";
 		this.email="";
 		this.observacion="";
 		this.esta_trabajando=false;
 		this.empresa_trabajo="";
 		this.direccion_trabajo="";
 		this.telefono_trabajo="";
 		this.esactivo=false;
		
		
		this.empresa=null;
		this.cliente=null;
		this.tiporefeperso=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.tiporefeperso_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ReferenciaPersonal (Long id,Date versionRow,Long id_empresa,Long idcliente,Long idvalorclientereferenciapersonal,Long id_pais,Long idciudad,String nombre,String identificacion,Date fecha_nacimiento,String direccion,String telefono,String telefonomovil,String telefonocodigoarea,String preferencia,String email,String observacion,Boolean esta_trabajando,String empresa_trabajo,String direccion_trabajo,String telefono_trabajo,Boolean esactivo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciapersonalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientereferenciapersonal=idvalorclientereferenciapersonal;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.nombre=nombre;
 		this.identificacion=identificacion;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonomovil=telefonomovil;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.preferencia=preferencia;
 		this.email=email;
 		this.observacion=observacion;
 		this.esta_trabajando=esta_trabajando;
 		this.empresa_trabajo=empresa_trabajo;
 		this.direccion_trabajo=direccion_trabajo;
 		this.telefono_trabajo=telefono_trabajo;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ReferenciaPersonal (Long id_empresa,Long idcliente,Long idvalorclientereferenciapersonal,Long id_pais,Long idciudad,String nombre,String identificacion,Date fecha_nacimiento,String direccion,String telefono,String telefonomovil,String telefonocodigoarea,String preferencia,String email,String observacion,Boolean esta_trabajando,String empresa_trabajo,String direccion_trabajo,String telefono_trabajo,Boolean esactivo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.referenciapersonalOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.idcliente=idcliente;
 		this.idvalorclientereferenciapersonal=idvalorclientereferenciapersonal;
 		this.id_pais=id_pais;
 		this.idciudad=idciudad;
 		this.nombre=nombre;
 		this.identificacion=identificacion;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.telefonomovil=telefonomovil;
 		this.telefonocodigoarea=telefonocodigoarea;
 		this.preferencia=preferencia;
 		this.email=email;
 		this.observacion=observacion;
 		this.esta_trabajando=esta_trabajando;
 		this.empresa_trabajo=empresa_trabajo;
 		this.direccion_trabajo=direccion_trabajo;
 		this.telefono_trabajo=telefono_trabajo;
 		this.esactivo=esactivo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ReferenciaPersonal referenciapersonalLocal=null;
		
		if(object!=null) {
			referenciapersonalLocal=(ReferenciaPersonal)object;
			
			if(referenciapersonalLocal!=null) {
				if(this.getId()!=null && referenciapersonalLocal.getId()!=null) {
					if(this.getId().equals(referenciapersonalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ReferenciaPersonalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ReferenciaPersonalConstantesFunciones.getReferenciaPersonalDescripcion(this);
		} else {
			sDetalle=ReferenciaPersonalConstantesFunciones.getReferenciaPersonalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ReferenciaPersonal getReferenciaPersonalOriginal() {
		return this.referenciapersonalOriginal;
	}
	
	public void setReferenciaPersonalOriginal(ReferenciaPersonal referenciapersonal) {
		try {
			this.referenciapersonalOriginal=referenciapersonal;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ReferenciaPersonalAdditional referenciapersonalAdditional=null;
	
	public ReferenciaPersonalAdditional getReferenciaPersonalAdditional() {
		return this.referenciapersonalAdditional;
	}
	
	public void setReferenciaPersonalAdditional(ReferenciaPersonalAdditional referenciapersonalAdditional) {
		try {
			this.referenciapersonalAdditional=referenciapersonalAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getidcliente() {
		return this.idcliente;
	}
    
	
	public Long getidvalorclientereferenciapersonal() {
		return this.idvalorclientereferenciapersonal;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getidciudad() {
		return this.idciudad;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String gettelefonomovil() {
		return this.telefonomovil;
	}
    
	
	public String gettelefonocodigoarea() {
		return this.telefonocodigoarea;
	}
    
	
	public String getpreferencia() {
		return this.preferencia;
	}
    
	
	public String getemail() {
		return this.email;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
    
	
	public Boolean getesta_trabajando() {
		return this.esta_trabajando;
	}
    
	
	public String getempresa_trabajo() {
		return this.empresa_trabajo;
	}
    
	
	public String getdireccion_trabajo() {
		return this.direccion_trabajo;
	}
    
	
	public String gettelefono_trabajo() {
		return this.telefono_trabajo;
	}
    
	
	public Boolean getesactivo() {
		return this.esactivo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidcliente(Long newidcliente)throws Exception
	{
		try {
			if(this.idcliente!=newidcliente) {
				if(newidcliente==null) {
					//newidcliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna idcliente");
					}
				}

				this.idcliente=newidcliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidvalorclientereferenciapersonal(Long newidvalorclientereferenciapersonal)throws Exception
	{
		try {
			if(this.idvalorclientereferenciapersonal!=newidvalorclientereferenciapersonal) {
				if(newidvalorclientereferenciapersonal==null) {
					//newidvalorclientereferenciapersonal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna idvalorclientereferenciapersonal");
					}
				}

				this.idvalorclientereferenciapersonal=newidvalorclientereferenciapersonal;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna id_pais");
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna idciudad");
					}
				}

				this.idciudad=newidciudad;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>20) {
					newidentificacion=newidentificacion.substring(0,18);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna identificacion");
				}

				this.identificacion=newidentificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>250) {
					newdireccion=newdireccion.substring(0,248);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion");
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>200) {
					newtelefono=newtelefono.substring(0,198);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono");
				}

				this.telefono=newtelefono;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna telefonomovil");
					}
				}

				if(newtelefonomovil!=null&&newtelefonomovil.length()>200) {
					newtelefonomovil=newtelefonomovil.substring(0,198);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefonomovil");
				}

				this.telefonomovil=newtelefonomovil;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna telefonocodigoarea");
					}
				}

				if(newtelefonocodigoarea!=null&&newtelefonocodigoarea.length()>50) {
					newtelefonocodigoarea=newtelefonocodigoarea.substring(0,48);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefonocodigoarea");
				}

				this.telefonocodigoarea=newtelefonocodigoarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpreferencia(String newpreferencia)throws Exception
	{
		try {
			if(this.preferencia!=newpreferencia) {
				if(newpreferencia==null) {
					//newpreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna preferencia");
					}
				}

				if(newpreferencia!=null&&newpreferencia.length()>150) {
					newpreferencia=newpreferencia.substring(0,148);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna preferencia");
				}

				this.preferencia=newpreferencia;
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
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna email");
					}
				}

				if(newemail!=null&&newemail.length()>200) {
					newemail=newemail.substring(0,198);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna email");
				}

				this.email=newemail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>400) {
					newobservacion=newobservacion.substring(0,398);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=400 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_trabajando(Boolean newesta_trabajando)throws Exception
	{
		try {
			if(this.esta_trabajando!=newesta_trabajando) {
				if(newesta_trabajando==null) {
					//newesta_trabajando=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna esta_trabajando");
					}
				}

				this.esta_trabajando=newesta_trabajando;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setempresa_trabajo(String newempresa_trabajo)throws Exception
	{
		try {
			if(this.empresa_trabajo!=newempresa_trabajo) {
				if(newempresa_trabajo==null) {
					//newempresa_trabajo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna empresa_trabajo");
					}
				}

				if(newempresa_trabajo!=null&&newempresa_trabajo.length()>100) {
					newempresa_trabajo=newempresa_trabajo.substring(0,98);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna empresa_trabajo");
				}

				this.empresa_trabajo=newempresa_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_trabajo(String newdireccion_trabajo)throws Exception
	{
		try {
			if(this.direccion_trabajo!=newdireccion_trabajo) {
				if(newdireccion_trabajo==null) {
					//newdireccion_trabajo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna direccion_trabajo");
					}
				}

				if(newdireccion_trabajo!=null&&newdireccion_trabajo.length()>250) {
					newdireccion_trabajo=newdireccion_trabajo.substring(0,248);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna direccion_trabajo");
				}

				this.direccion_trabajo=newdireccion_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_trabajo(String newtelefono_trabajo)throws Exception
	{
		try {
			if(this.telefono_trabajo!=newtelefono_trabajo) {
				if(newtelefono_trabajo==null) {
					//newtelefono_trabajo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna telefono_trabajo");
					}
				}

				if(newtelefono_trabajo!=null&&newtelefono_trabajo.length()>200) {
					newtelefono_trabajo=newtelefono_trabajo.substring(0,198);
					System.out.println("ReferenciaPersonal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_trabajo");
				}

				this.telefono_trabajo=newtelefono_trabajo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesactivo(Boolean newesactivo)throws Exception
	{
		try {
			if(this.esactivo!=newesactivo) {
				if(newesactivo==null) {
					//newesactivo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ReferenciaPersonal:Valor nulo no permitido en columna esactivo");
					}
				}

				this.esactivo=newesactivo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoRefePerso getTipoRefePerso() {
		return this.tiporefeperso;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettiporefeperso_descripcion() {
		return this.tiporefeperso_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRefePerso(TipoRefePerso tiporefeperso) {
		try {
			this.tiporefeperso=tiporefeperso;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	public  void  settiporefeperso_descripcion(String tiporefeperso_descripcion) {
		try {
			this.tiporefeperso_descripcion=tiporefeperso_descripcion;
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
	String id_empresa_descripcion="";String idcliente_descripcion="";String idvalorclientereferenciapersonal_descripcion="";String id_pais_descripcion="";String idciudad_descripcion="";String esta_trabajando_descripcion="";String esactivo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getidcliente_descripcion() {
		return idcliente_descripcion;
	}
	public String getidvalorclientereferenciapersonal_descripcion() {
		return idvalorclientereferenciapersonal_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getidciudad_descripcion() {
		return idciudad_descripcion;
	}
	public String getesta_trabajando_descripcion() {
		return esta_trabajando_descripcion;
	}
	public String getesactivo_descripcion() {
		return esactivo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidcliente_descripcion(String newidcliente_descripcion)throws Exception {
		try {
			this.idcliente_descripcion=newidcliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setidvalorclientereferenciapersonal_descripcion(String newidvalorclientereferenciapersonal_descripcion)throws Exception {
		try {
			this.idvalorclientereferenciapersonal_descripcion=newidvalorclientereferenciapersonal_descripcion;
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
	public void setesta_trabajando_descripcion(String newesta_trabajando_descripcion)throws Exception {
		try {
			this.esta_trabajando_descripcion=newesta_trabajando_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesactivo_descripcion(String newesactivo_descripcion)throws Exception {
		try {
			this.esactivo_descripcion=newesactivo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.idcliente_descripcion="";this.idvalorclientereferenciapersonal_descripcion="";this.id_pais_descripcion="";this.idciudad_descripcion="";this.esta_trabajando_descripcion="";this.esactivo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

