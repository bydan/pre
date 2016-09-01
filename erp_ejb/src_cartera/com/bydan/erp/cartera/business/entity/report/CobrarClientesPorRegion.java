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
package com.bydan.erp.cartera.business.entity.report;

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
//import com.bydan.erp.cartera.util.CobrarClientesPorRegionConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarClientesPorRegion extends CobrarClientesPorRegionAdditional implements Serializable ,Cloneable {//CobrarClientesPorRegionAdditional,GeneralEntity
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
	
	private CobrarClientesPorRegion cobrarclientesporregionOriginal;
	
	private Map<String, Object> mapCobrarClientesPorRegion;
			
	public Map<String, Object> getMapCobrarClientesPorRegion() {
		return mapCobrarClientesPorRegion;
	}

	public void setMapCobrarClientesPorRegion(Map<String, Object> mapCobrarClientesPorRegion) {
		this.mapCobrarClientesPorRegion = mapCobrarClientesPorRegion;
	}
	
	public void inicializarMapCobrarClientesPorRegion() {
		this.mapCobrarClientesPorRegion = new HashMap<String,Object>();
	}
	
	public void setMapCobrarClientesPorRegionValue(String sKey,Object oValue) {
		this.mapCobrarClientesPorRegion.put(sKey, oValue);
	}
	
	public Object getMapCobrarClientesPorRegionValue(String sKey) {
		return this.mapCobrarClientesPorRegion.get(sKey);
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
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_region;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_REGION,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_REGION)
	private String nombre_region;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_PROVINCIA,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_PROVINCIA)
	private String nombre_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_CIUDAD,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_CIUDAD)
	private String nombre_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_ZONA,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_ZONA)
	private String nombre_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_RUTA,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_RUTA)
	private String nombre_ruta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE_VENDEDOR,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE_VENDEDOR)
	private String nombre_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXCODIGO,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXNOMBRE,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXAPELLIDO,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXDIRECCION_DIRECCION,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXDIRECCION_DIRECCION)
	private String direccion_direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarClientesPorRegionConstantesFunciones.SREGEXTELEFONO_TELEFONO,message=CobrarClientesPorRegionConstantesFunciones.SMENSAJEREGEXTELEFONO_TELEFONO)
	private String telefono_telefono;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Pais pais;
	public Region region;
	public Provincia provincia;
	public Ciudad ciudad;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String pais_descripcion;
	private String region_descripcion;
	private String provincia_descripcion;
	private String ciudad_descripcion;
	
	
		
	public CobrarClientesPorRegion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarclientesporregionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_pais=-1L;
 		this.id_region=-1L;
 		this.id_provincia=-1L;
 		this.id_ciudad=-1L;
 		this.nombre_region="";
 		this.nombre_provincia="";
 		this.nombre_ciudad="";
 		this.nombre_zona="";
 		this.nombre_ruta="";
 		this.nombre_vendedor="";
 		this.codigo="";
 		this.nombre="";
 		this.apellido="";
 		this.direccion_direccion="";
 		this.telefono_telefono="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.pais=null;
		this.region=null;
		this.provincia=null;
		this.ciudad=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.pais_descripcion="";
		this.region_descripcion="";
		this.provincia_descripcion="";
		this.ciudad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarClientesPorRegion (Long id,Date versionRow,String nombre_region,String nombre_provincia,String nombre_ciudad,String nombre_zona,String nombre_ruta,String nombre_vendedor,String codigo,String nombre,String apellido,String direccion_direccion,String telefono_telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientesporregionOriginal=this;
		
 		this.nombre_region=nombre_region;
 		this.nombre_provincia=nombre_provincia;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_ruta=nombre_ruta;
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarClientesPorRegion (String nombre_region,String nombre_provincia,String nombre_ciudad,String nombre_zona,String nombre_ruta,String nombre_vendedor,String codigo,String nombre,String apellido,String direccion_direccion,String telefono_telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarclientesporregionOriginal=this;
		
 		this.nombre_region=nombre_region;
 		this.nombre_provincia=nombre_provincia;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_ruta=nombre_ruta;
 		this.nombre_vendedor=nombre_vendedor;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarClientesPorRegion getCobrarClientesPorRegionOriginal() {
		return this.cobrarclientesporregionOriginal;
	}
	
	public void setCobrarClientesPorRegionOriginal(CobrarClientesPorRegion cobrarclientesporregion) {
		try {
			this.cobrarclientesporregionOriginal=cobrarclientesporregion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarClientesPorRegionAdditional cobrarclientesporregionAdditional=null;
	
	public CobrarClientesPorRegionAdditional getCobrarClientesPorRegionAdditional() {
		return this.cobrarclientesporregionAdditional;
	}
	
	public void setCobrarClientesPorRegionAdditional(CobrarClientesPorRegionAdditional cobrarclientesporregionAdditional) {
		try {
			this.cobrarclientesporregionAdditional=cobrarclientesporregionAdditional;
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
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_region() {
		return this.id_region;
	}
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public String getnombre_region() {
		return this.nombre_region;
	}
    
	
	public String getnombre_provincia() {
		return this.nombre_provincia;
	}
    
	
	public String getnombre_ciudad() {
		return this.nombre_ciudad;
	}
    
	
	public String getnombre_zona() {
		return this.nombre_zona;
	}
    
	
	public String getnombre_ruta() {
		return this.nombre_ruta;
	}
    
	
	public String getnombre_vendedor() {
		return this.nombre_vendedor;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getdireccion_direccion() {
		return this.direccion_direccion;
	}
    
	
	public String gettelefono_telefono() {
		return this.telefono_telefono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_region(Long newid_region)throws Exception
	{
		try {
			if(this.id_region!=newid_region) {
				if(newid_region==null) {
					//newid_region=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_region");
					}
				}

				this.id_region=newid_region;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
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
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_region(String newnombre_region)throws Exception
	{
		try {
			if(this.nombre_region!=newnombre_region) {
				if(newnombre_region==null) {
					//newnombre_region="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_region");
					}
				}

				if(newnombre_region!=null&&newnombre_region.length()>200) {
					newnombre_region=newnombre_region.substring(0,198);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_region");
				}

				this.nombre_region=newnombre_region;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_provincia(String newnombre_provincia)throws Exception
	{
		try {
			if(this.nombre_provincia!=newnombre_provincia) {
				if(newnombre_provincia==null) {
					//newnombre_provincia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_provincia");
					}
				}

				if(newnombre_provincia!=null&&newnombre_provincia.length()>200) {
					newnombre_provincia=newnombre_provincia.substring(0,198);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_provincia");
				}

				this.nombre_provincia=newnombre_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ciudad(String newnombre_ciudad)throws Exception
	{
		try {
			if(this.nombre_ciudad!=newnombre_ciudad) {
				if(newnombre_ciudad==null) {
					//newnombre_ciudad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_ciudad");
					}
				}

				if(newnombre_ciudad!=null&&newnombre_ciudad.length()>200) {
					newnombre_ciudad=newnombre_ciudad.substring(0,198);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_ciudad");
				}

				this.nombre_ciudad=newnombre_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_zona(String newnombre_zona)throws Exception
	{
		try {
			if(this.nombre_zona!=newnombre_zona) {
				if(newnombre_zona==null) {
					//newnombre_zona="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_zona");
					}
				}

				if(newnombre_zona!=null&&newnombre_zona.length()>50) {
					newnombre_zona=newnombre_zona.substring(0,48);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_zona");
				}

				this.nombre_zona=newnombre_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ruta(String newnombre_ruta)throws Exception
	{
		try {
			if(this.nombre_ruta!=newnombre_ruta) {
				if(newnombre_ruta==null) {
					//newnombre_ruta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_ruta");
					}
				}

				if(newnombre_ruta!=null&&newnombre_ruta.length()>150) {
					newnombre_ruta=newnombre_ruta.substring(0,148);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_ruta");
				}

				this.nombre_ruta=newnombre_ruta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_vendedor(String newnombre_vendedor)throws Exception
	{
		try {
			if(this.nombre_vendedor!=newnombre_vendedor) {
				if(newnombre_vendedor==null) {
					//newnombre_vendedor="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre_vendedor");
					}
				}

				if(newnombre_vendedor!=null&&newnombre_vendedor.length()>150) {
					newnombre_vendedor=newnombre_vendedor.substring(0,148);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_vendedor");
				}

				this.nombre_vendedor=newnombre_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_direccion(String newdireccion_direccion)throws Exception
	{
		try {
			if(this.direccion_direccion!=newdireccion_direccion) {
				if(newdireccion_direccion==null) {
					//newdireccion_direccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna direccion_direccion");
					}
				}

				if(newdireccion_direccion!=null&&newdireccion_direccion.length()>200) {
					newdireccion_direccion=newdireccion_direccion.substring(0,198);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion_direccion");
				}

				this.direccion_direccion=newdireccion_direccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_telefono(String newtelefono_telefono)throws Exception
	{
		try {
			if(this.telefono_telefono!=newtelefono_telefono) {
				if(newtelefono_telefono==null) {
					//newtelefono_telefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarClientesPorRegion:Valor nulo no permitido en columna telefono_telefono");
					}
				}

				if(newtelefono_telefono!=null&&newtelefono_telefono.length()>200) {
					newtelefono_telefono=newtelefono_telefono.substring(0,198);
					System.out.println("CobrarClientesPorRegion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_telefono");
				}

				this.telefono_telefono=newtelefono_telefono;
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

	public Pais getPais() {
		return this.pais;
	}

	public Region getRegion() {
		return this.region;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getregion_descripcion() {
		return this.region_descripcion;
	}

	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
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


	public  void  setRegion(Region region) {
		try {
			this.region=region;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  setregion_descripcion(String region_descripcion) {
		try {
			this.region_descripcion=region_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setprovincia_descripcion(String provincia_descripcion) {
		try {
			this.provincia_descripcion=provincia_descripcion;
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
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_pais_descripcion="";String id_region_descripcion="";String id_provincia_descripcion="";String id_ciudad_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_region_descripcion() {
		return id_region_descripcion;
	}
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
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
	public void setid_region_descripcion(String newid_region_descripcion)throws Exception {
		try {
			this.id_region_descripcion=newid_region_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
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
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_pais_descripcion="";this.id_region_descripcion="";this.id_provincia_descripcion="";this.id_ciudad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

