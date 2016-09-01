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
//import com.bydan.erp.cartera.util.ActividadEconomicaConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ActividadEconomica extends ActividadEconomicaAdditional implements Serializable ,Cloneable {//ActividadEconomicaAdditional,GeneralEntity
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
	
	private ActividadEconomica actividadeconomicaOriginal;
	
	private Map<String, Object> mapActividadEconomica;
			
	public Map<String, Object> getMapActividadEconomica() {
		return mapActividadEconomica;
	}

	public void setMapActividadEconomica(Map<String, Object> mapActividadEconomica) {
		this.mapActividadEconomica = mapActividadEconomica;
	}
	
	public void inicializarMapActividadEconomica() {
		this.mapActividadEconomica = new HashMap<String,Object>();
	}
	
	public void setMapActividadEconomicaValue(String sKey,Object oValue) {
		this.mapActividadEconomica.put(sKey, oValue);
	}
	
	public Object getMapActividadEconomicaValue(String sKey) {
		return this.mapActividadEconomica.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ActividadEconomicaConstantesFunciones.SREGEXNOMBRE_NEGOCIO,message=ActividadEconomicaConstantesFunciones.SMENSAJEREGEXNOMBRE_NEGOCIO)
	private String nombre_negocio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ActividadEconomicaConstantesFunciones.SREGEXACTIVIDAD,message=ActividadEconomicaConstantesFunciones.SMENSAJEREGEXACTIVIDAD)
	private String actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ActividadEconomicaConstantesFunciones.SREGEXDIRECCION,message=ActividadEconomicaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ActividadEconomicaConstantesFunciones.SREGEXTELEFONO,message=ActividadEconomicaConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso_neto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ingreso_bruto;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public Pais pais;
	public Ciudad ciudad;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	
	
		
	public ActividadEconomica () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.actividadeconomicaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.nombre_negocio="";
 		this.actividad="";
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.direccion="";
 		this.telefono="";
 		this.ingreso_neto=0.0;
 		this.ingreso_bruto=0.0;
		
		
		this.empresa=null;
		this.cliente=null;
		this.pais=null;
		this.ciudad=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ActividadEconomica (Long id,Date versionRow,Long id_empresa,Long id_cliente,String nombre_negocio,String actividad,Long id_pais,Long id_ciudad,String direccion,String telefono,Double ingreso_neto,Double ingreso_bruto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.actividadeconomicaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.nombre_negocio=nombre_negocio;
 		this.actividad=actividad;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ingreso_neto=ingreso_neto;
 		this.ingreso_bruto=ingreso_bruto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ActividadEconomica (Long id_empresa,Long id_cliente,String nombre_negocio,String actividad,Long id_pais,Long id_ciudad,String direccion,String telefono,Double ingreso_neto,Double ingreso_bruto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.actividadeconomicaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.nombre_negocio=nombre_negocio;
 		this.actividad=actividad;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.ingreso_neto=ingreso_neto;
 		this.ingreso_bruto=ingreso_bruto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ActividadEconomica actividadeconomicaLocal=null;
		
		if(object!=null) {
			actividadeconomicaLocal=(ActividadEconomica)object;
			
			if(actividadeconomicaLocal!=null) {
				if(this.getId()!=null && actividadeconomicaLocal.getId()!=null) {
					if(this.getId().equals(actividadeconomicaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ActividadEconomicaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ActividadEconomicaConstantesFunciones.getActividadEconomicaDescripcion(this);
		} else {
			sDetalle=ActividadEconomicaConstantesFunciones.getActividadEconomicaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ActividadEconomica getActividadEconomicaOriginal() {
		return this.actividadeconomicaOriginal;
	}
	
	public void setActividadEconomicaOriginal(ActividadEconomica actividadeconomica) {
		try {
			this.actividadeconomicaOriginal=actividadeconomica;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ActividadEconomicaAdditional actividadeconomicaAdditional=null;
	
	public ActividadEconomicaAdditional getActividadEconomicaAdditional() {
		return this.actividadeconomicaAdditional;
	}
	
	public void setActividadEconomicaAdditional(ActividadEconomicaAdditional actividadeconomicaAdditional) {
		try {
			this.actividadeconomicaAdditional=actividadeconomicaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getnombre_negocio() {
		return this.nombre_negocio;
	}
    
	
	public String getactividad() {
		return this.actividad;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Double getingreso_neto() {
		return this.ingreso_neto;
	}
    
	
	public Double getingreso_bruto() {
		return this.ingreso_bruto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_negocio(String newnombre_negocio)throws Exception
	{
		try {
			if(this.nombre_negocio!=newnombre_negocio) {
				if(newnombre_negocio==null) {
					//newnombre_negocio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna nombre_negocio");
					}
				}

				if(newnombre_negocio!=null&&newnombre_negocio.length()>150) {
					newnombre_negocio=newnombre_negocio.substring(0,148);
					System.out.println("ActividadEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_negocio");
				}

				this.nombre_negocio=newnombre_negocio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactividad(String newactividad)throws Exception
	{
		try {
			if(this.actividad!=newactividad) {
				if(newactividad==null) {
					//newactividad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna actividad");
					}
				}

				if(newactividad!=null&&newactividad.length()>150) {
					newactividad=newactividad.substring(0,148);
					System.out.println("ActividadEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna actividad");
				}

				this.actividad=newactividad;
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
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
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
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("ActividadEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
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
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>150) {
					newtelefono=newtelefono.substring(0,148);
					System.out.println("ActividadEconomica:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso_neto(Double newingreso_neto)throws Exception
	{
		try {
			if(this.ingreso_neto!=newingreso_neto) {
				if(newingreso_neto==null) {
					//newingreso_neto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna ingreso_neto");
					}
				}

				this.ingreso_neto=newingreso_neto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setingreso_bruto(Double newingreso_bruto)throws Exception
	{
		try {
			if(this.ingreso_bruto!=newingreso_bruto) {
				if(newingreso_bruto==null) {
					//newingreso_bruto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ActividadEconomica:Valor nulo no permitido en columna ingreso_bruto");
					}
				}

				this.ingreso_bruto=newingreso_bruto;
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
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
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
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

