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
//import com.bydan.erp.cartera.util.RutaConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class Ruta extends RutaAdditional implements Serializable ,Cloneable {//RutaAdditional,GeneralEntity
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
	
	private Ruta rutaOriginal;
	
	private Map<String, Object> mapRuta;
			
	public Map<String, Object> getMapRuta() {
		return mapRuta;
	}

	public void setMapRuta(Map<String, Object> mapRuta) {
		this.mapRuta = mapRuta;
	}
	
	public void inicializarMapRuta() {
		this.mapRuta = new HashMap<String,Object>();
	}
	
	public void setMapRutaValue(String sKey,Object oValue) {
		this.mapRuta.put(sKey, oValue);
	}
	
	public Object getMapRutaValue(String sKey) {
		return this.mapRuta.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sector_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sector_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaConstantesFunciones.SREGEXNOMBRE,message=RutaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaConstantesFunciones.SREGEXORIGEN,message=RutaConstantesFunciones.SMENSAJEREGEXORIGEN)
	private String origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaConstantesFunciones.SREGEXDESTINO,message=RutaConstantesFunciones.SMENSAJEREGEXDESTINO)
	private String destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RutaConstantesFunciones.SREGEXDIRECCION,message=RutaConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
			
	
	public Empresa empresa;
	public Pais pais;
	public Ciudad ciudad;
	public Sector sectororigen;
	public Sector sectordestino;
	
	
	private String empresa_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String sectororigen_descripcion;
	private String sectordestino_descripcion;
	
	
	public List<Cliente> clientes;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
		
	public Ruta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.rutaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_sector_origen=-1L;
 		this.id_sector_destino=-1L;
 		this.nombre="";
 		this.origen="";
 		this.destino="";
 		this.precio=0.0;
 		this.direccion="";
		
		
		this.empresa=null;
		this.pais=null;
		this.ciudad=null;
		this.sectororigen=null;
		this.sectordestino=null;
		
		
		this.empresa_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.sectororigen_descripcion="";
		this.sectordestino_descripcion="";
		
		
		this.clientes=null;
		this.parametrocarteradefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Ruta (Long id,Date versionRow,Long id_empresa,Long id_pais,Long id_ciudad,Long id_sector_origen,Long id_sector_destino,String nombre,String origen,String destino,Double precio,String direccion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rutaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_sector_origen=id_sector_origen;
 		this.id_sector_destino=id_sector_destino;
 		this.nombre=nombre;
 		this.origen=origen;
 		this.destino=destino;
 		this.precio=precio;
 		this.direccion=direccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Ruta (Long id_empresa,Long id_pais,Long id_ciudad,Long id_sector_origen,Long id_sector_destino,String nombre,String origen,String destino,Double precio,String direccion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rutaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_sector_origen=id_sector_origen;
 		this.id_sector_destino=id_sector_destino;
 		this.nombre=nombre;
 		this.origen=origen;
 		this.destino=destino;
 		this.precio=precio;
 		this.direccion=direccion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Ruta rutaLocal=null;
		
		if(object!=null) {
			rutaLocal=(Ruta)object;
			
			if(rutaLocal!=null) {
				if(this.getId()!=null && rutaLocal.getId()!=null) {
					if(this.getId().equals(rutaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RutaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RutaConstantesFunciones.getRutaDescripcion(this);
		} else {
			sDetalle=RutaConstantesFunciones.getRutaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Ruta getRutaOriginal() {
		return this.rutaOriginal;
	}
	
	public void setRutaOriginal(Ruta ruta) {
		try {
			this.rutaOriginal=ruta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RutaAdditional rutaAdditional=null;
	
	public RutaAdditional getRutaAdditional() {
		return this.rutaAdditional;
	}
	
	public void setRutaAdditional(RutaAdditional rutaAdditional) {
		try {
			this.rutaAdditional=rutaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_sector_origen() {
		return this.id_sector_origen;
	}
    
	
	public Long getid_sector_destino() {
		return this.id_sector_destino;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getorigen() {
		return this.origen;
	}
    
	
	public String getdestino() {
		return this.destino;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("Ruta:Valor nulo no permitido en columna id_pais");
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
						System.out.println("Ruta:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sector_origen(Long newid_sector_origen)throws Exception
	{
		try {
			if(this.id_sector_origen!=newid_sector_origen) {
				if(newid_sector_origen==null) {
					//newid_sector_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna id_sector_origen");
					}
				}

				this.id_sector_origen=newid_sector_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sector_destino(Long newid_sector_destino)throws Exception
	{
		try {
			if(this.id_sector_destino!=newid_sector_destino) {
				if(newid_sector_destino==null) {
					//newid_sector_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna id_sector_destino");
					}
				}

				this.id_sector_destino=newid_sector_destino;
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
						System.out.println("Ruta:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Ruta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorigen(String neworigen)throws Exception
	{
		try {
			if(this.origen!=neworigen) {
				if(neworigen==null) {
					//neworigen="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna origen");
					}
				}

				if(neworigen!=null&&neworigen.length()>150) {
					neworigen=neworigen.substring(0,148);
					System.out.println("Ruta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna origen");
				}

				this.origen=neworigen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdestino(String newdestino)throws Exception
	{
		try {
			if(this.destino!=newdestino) {
				if(newdestino==null) {
					//newdestino="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna destino");
					}
				}

				if(newdestino!=null&&newdestino.length()>150) {
					newdestino=newdestino.substring(0,148);
					System.out.println("Ruta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna destino");
				}

				this.destino=newdestino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Ruta:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
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
						System.out.println("Ruta:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>200) {
					newdireccion=newdireccion.substring(0,198);
					System.out.println("Ruta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Sector getSectorOrigen() {
		return this.sectororigen;
	}

	public Sector getSectorDestino() {
		return this.sectordestino;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getsectororigen_descripcion() {
		return this.sectororigen_descripcion;
	}

	public String getsectordestino_descripcion() {
		return this.sectordestino_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setSectorOrigen(Sector sectororigen) {
		try {
			this.sectororigen=sectororigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSectorDestino(Sector sectordestino) {
		try {
			this.sectordestino=sectordestino;
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


	public  void  setsectororigen_descripcion(String sectororigen_descripcion) {
		try {
			this.sectororigen_descripcion=sectororigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsectordestino_descripcion(String sectordestino_descripcion) {
		try {
			this.sectordestino_descripcion=sectordestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() {
		return this.parametrocarteradefectos;
	}

	
	
	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos) {
		try {
			this.parametrocarteradefectos=parametrocarteradefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_sector_origen_descripcion="";String id_sector_destino_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_sector_origen_descripcion() {
		return id_sector_origen_descripcion;
	}
	public String getid_sector_destino_descripcion() {
		return id_sector_destino_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_sector_origen_descripcion(String newid_sector_origen_descripcion)throws Exception {
		try {
			this.id_sector_origen_descripcion=newid_sector_origen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sector_destino_descripcion(String newid_sector_destino_descripcion)throws Exception {
		try {
			this.id_sector_destino_descripcion=newid_sector_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_sector_origen_descripcion="";this.id_sector_destino_descripcion="";
	}
	
	
	Object clientesDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	
	
	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getparametrocarteradefectosDescripcionReporte() {
		return parametrocarteradefectosDescripcionReporte;
	}

	
	
	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocarteradefectosDescripcionReporte(Object parametrocarteradefectos) {
		try {
			this.parametrocarteradefectosDescripcionReporte=parametrocarteradefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

