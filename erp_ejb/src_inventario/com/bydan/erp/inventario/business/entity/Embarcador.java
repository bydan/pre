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
//import com.bydan.erp.inventario.util.EmbarcadorConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class Embarcador extends EmbarcadorAdditional implements Serializable ,Cloneable {//EmbarcadorAdditional,GeneralEntity
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
	
	private Embarcador embarcadorOriginal;
	
	private Map<String, Object> mapEmbarcador;
			
	public Map<String, Object> getMapEmbarcador() {
		return mapEmbarcador;
	}

	public void setMapEmbarcador(Map<String, Object> mapEmbarcador) {
		this.mapEmbarcador = mapEmbarcador;
	}
	
	public void inicializarMapEmbarcador() {
		this.mapEmbarcador = new HashMap<String,Object>();
	}
	
	public void setMapEmbarcadorValue(String sKey,Object oValue) {
		this.mapEmbarcador.put(sKey, oValue);
	}
	
	public Object getMapEmbarcadorValue(String sKey) {
		return this.mapEmbarcador.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXNOMBRE,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXRUC,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXDIRECCION,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXTELEFONO,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXCONTACTO,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXCONTACTO)
	private String contacto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXE_MAIL,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXE_MAIL)
	private String e_mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=EmbarcadorConstantesFunciones.SREGEXFAX,message=EmbarcadorConstantesFunciones.SMENSAJEREGEXFAX)
	private String fax;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_via_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_puerto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_ciudad;
			
	
	public Empresa empresa;
	public TipoViaTransporte tipoviatransporte;
	public Puerto puerto;
	public Empleado empleado;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String empresa_descripcion;
	private String tipoviatransporte_descripcion;
	private String puerto_descripcion;
	private String empleado_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
	public List<PedidoCompraImpor> pedidocompraimpors;
	public List<ParametroCompra> parametrocompras;
		
	public Embarcador () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.embarcadorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.ruc="";
 		this.direccion="";
 		this.telefono="";
 		this.contacto="";
 		this.e_mail="";
 		this.fax="";
 		this.id_tipo_via_transporte=-1L;
 		this.id_puerto=-1L;
 		this.id_empleado=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=null;
		
		
		this.empresa=null;
		this.tipoviatransporte=null;
		this.puerto=null;
		this.empleado=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.empresa_descripcion="";
		this.tipoviatransporte_descripcion="";
		this.puerto_descripcion="";
		this.empleado_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		this.pedidocompraimpors=null;
		this.parametrocompras=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Embarcador (Long id,Date versionRow,Long id_empresa,String nombre,String ruc,String direccion,String telefono,String contacto,String e_mail,String fax,Long id_tipo_via_transporte,Long id_puerto,Long id_empleado,Long id_pais,Long id_ciudad) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.embarcadorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.contacto=contacto;
 		this.e_mail=e_mail;
 		this.fax=fax;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_puerto=id_puerto;
 		this.id_empleado=id_empleado;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Embarcador (Long id_empresa,String nombre,String ruc,String direccion,String telefono,String contacto,String e_mail,String fax,Long id_tipo_via_transporte,Long id_puerto,Long id_empleado,Long id_pais,Long id_ciudad) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.embarcadorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.contacto=contacto;
 		this.e_mail=e_mail;
 		this.fax=fax;
 		this.id_tipo_via_transporte=id_tipo_via_transporte;
 		this.id_puerto=id_puerto;
 		this.id_empleado=id_empleado;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Embarcador embarcadorLocal=null;
		
		if(object!=null) {
			embarcadorLocal=(Embarcador)object;
			
			if(embarcadorLocal!=null) {
				if(this.getId()!=null && embarcadorLocal.getId()!=null) {
					if(this.getId().equals(embarcadorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EmbarcadorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EmbarcadorConstantesFunciones.getEmbarcadorDescripcion(this);
		} else {
			sDetalle=EmbarcadorConstantesFunciones.getEmbarcadorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Embarcador getEmbarcadorOriginal() {
		return this.embarcadorOriginal;
	}
	
	public void setEmbarcadorOriginal(Embarcador embarcador) {
		try {
			this.embarcadorOriginal=embarcador;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EmbarcadorAdditional embarcadorAdditional=null;
	
	public EmbarcadorAdditional getEmbarcadorAdditional() {
		return this.embarcadorAdditional;
	}
	
	public void setEmbarcadorAdditional(EmbarcadorAdditional embarcadorAdditional) {
		try {
			this.embarcadorAdditional=embarcadorAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getcontacto() {
		return this.contacto;
	}
    
	
	public String gete_mail() {
		return this.e_mail;
	}
    
	
	public String getfax() {
		return this.fax;
	}
    
	
	public Long getid_tipo_via_transporte() {
		return this.id_tipo_via_transporte;
	}
    
	
	public Long getid_puerto() {
		return this.id_puerto;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("Embarcador:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>20) {
					newruc=newruc.substring(0,18);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc");
				}

				this.ruc=newruc;
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
						System.out.println("Embarcador:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
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
						System.out.println("Embarcador:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>50) {
					newtelefono=newtelefono.substring(0,48);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcontacto(String newcontacto)throws Exception
	{
		try {
			if(this.contacto!=newcontacto) {
				if(newcontacto==null) {
					//newcontacto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna contacto");
					}
				}

				if(newcontacto!=null&&newcontacto.length()>100) {
					newcontacto=newcontacto.substring(0,98);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna contacto");
				}

				this.contacto=newcontacto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sete_mail(String newe_mail)throws Exception
	{
		try {
			if(this.e_mail!=newe_mail) {
				if(newe_mail==null) {
					//newe_mail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna e_mail");
					}
				}

				if(newe_mail!=null&&newe_mail.length()>50) {
					newe_mail=newe_mail.substring(0,48);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna e_mail");
				}

				this.e_mail=newe_mail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfax(String newfax)throws Exception
	{
		try {
			if(this.fax!=newfax) {
				if(newfax==null) {
					//newfax="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna fax");
					}
				}

				if(newfax!=null&&newfax.length()>50) {
					newfax=newfax.substring(0,48);
					System.out.println("Embarcador:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna fax");
				}

				this.fax=newfax;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_via_transporte(Long newid_tipo_via_transporte)throws Exception
	{
		try {
			if(this.id_tipo_via_transporte!=newid_tipo_via_transporte) {
				if(newid_tipo_via_transporte==null) {
					//newid_tipo_via_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna id_tipo_via_transporte");
					}
				}

				this.id_tipo_via_transporte=newid_tipo_via_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_puerto(Long newid_puerto)throws Exception
	{
		try {
			if(this.id_puerto!=newid_puerto) {
				if(newid_puerto==null) {
					//newid_puerto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna id_puerto");
					}
				}

				this.id_puerto=newid_puerto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Embarcador:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("Embarcador:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad) {
		if(this.id_ciudad==null&&newid_ciudad!=null) {
			this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
		}

		if(this.id_ciudad!=null&&!this.id_ciudad.equals(newid_ciudad)) {

			this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoViaTransporte getTipoViaTransporte() {
		return this.tipoviatransporte;
	}

	public Puerto getPuerto() {
		return this.puerto;
	}

	public Empleado getEmpleado() {
		return this.empleado;
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

	public String gettipoviatransporte_descripcion() {
		return this.tipoviatransporte_descripcion;
	}

	public String getpuerto_descripcion() {
		return this.puerto_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
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


	public  void  setTipoViaTransporte(TipoViaTransporte tipoviatransporte) {
		try {
			this.tipoviatransporte=tipoviatransporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPuerto(Puerto puerto) {
		try {
			this.puerto=puerto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
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


	public  void  settipoviatransporte_descripcion(String tipoviatransporte_descripcion) {
		try {
			this.tipoviatransporte_descripcion=tipoviatransporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpuerto_descripcion(String puerto_descripcion) {
		try {
			this.puerto_descripcion=puerto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
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


	
	
	public List<PedidoCompraImpor> getPedidoCompraImpors() {
		return this.pedidocompraimpors;
	}

	public List<ParametroCompra> getParametroCompras() {
		return this.parametrocompras;
	}

	
	
	public  void  setPedidoCompraImpors(List<PedidoCompraImpor> pedidocompraimpors) {
		try {
			this.pedidocompraimpors=pedidocompraimpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroCompras(List<ParametroCompra> parametrocompras) {
		try {
			this.parametrocompras=parametrocompras;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_via_transporte_descripcion="";String id_puerto_descripcion="";String id_empleado_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_via_transporte_descripcion() {
		return id_tipo_via_transporte_descripcion;
	}
	public String getid_puerto_descripcion() {
		return id_puerto_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_via_transporte_descripcion(String newid_tipo_via_transporte_descripcion)throws Exception {
		try {
			this.id_tipo_via_transporte_descripcion=newid_tipo_via_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_puerto_descripcion(String newid_puerto_descripcion)throws Exception {
		try {
			this.id_puerto_descripcion=newid_puerto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
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
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion) {
		this.id_ciudad_descripcion=newid_ciudad_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_via_transporte_descripcion="";this.id_puerto_descripcion="";this.id_empleado_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";
	}
	
	
	Object pedidocompraimporsDescripcionReporte;
	Object parametrocomprasDescripcionReporte;
	
	
	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getparametrocomprasDescripcionReporte() {
		return parametrocomprasDescripcionReporte;
	}

	
	
	public  void  setpedidocompraimporsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocomprasDescripcionReporte(Object parametrocompras) {
		try {
			this.parametrocomprasDescripcionReporte=parametrocompras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

