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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.RegionConstantesFunciones;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class Region extends RegionAdditional implements Serializable ,Cloneable {//RegionAdditional,GeneralEntity
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
	
	private Region regionOriginal;
	
	private Map<String, Object> mapRegion;
			
	public Map<String, Object> getMapRegion() {
		return mapRegion;
	}

	public void setMapRegion(Map<String, Object> mapRegion) {
		this.mapRegion = mapRegion;
	}
	
	public void inicializarMapRegion() {
		this.mapRegion = new HashMap<String,Object>();
	}
	
	public void setMapRegionValue(String sKey,Object oValue) {
		this.mapRegion.put(sKey, oValue);
	}
	
	public Object getMapRegionValue(String sKey) {
		return this.mapRegion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RegionConstantesFunciones.SREGEXCODIGO,message=RegionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RegionConstantesFunciones.SREGEXNOMBRE,message=RegionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Pais pais;
	
	
	private String pais_descripcion;
	
	
	public List<Cliente> clientes;
	public List<Provincia> provincias;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
		
	public Region () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.regionOriginal=this;
		
 		this.id_pais=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.pais=null;
		
		
		this.pais_descripcion="";
		
		
		this.clientes=null;
		this.provincias=null;
		this.parametrocarteradefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Region (Long id,Date versionRow,Long id_pais,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.regionOriginal=this;
		
 		this.id_pais=id_pais;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Region (Long id_pais,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.regionOriginal=this;
		
 		this.id_pais=id_pais;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Region regionLocal=null;
		
		if(object!=null) {
			regionLocal=(Region)object;
			
			if(regionLocal!=null) {
				if(this.getId()!=null && regionLocal.getId()!=null) {
					if(this.getId().equals(regionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RegionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RegionConstantesFunciones.getRegionDescripcion(this);
		} else {
			sDetalle=RegionConstantesFunciones.getRegionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Region getRegionOriginal() {
		return this.regionOriginal;
	}
	
	public void setRegionOriginal(Region region) {
		try {
			this.regionOriginal=region;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RegionAdditional regionAdditional=null;
	
	public RegionAdditional getRegionAdditional() {
		return this.regionAdditional;
	}
	
	public void setRegionAdditional(RegionAdditional regionAdditional) {
		try {
			this.regionAdditional=regionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Region:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
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
						System.out.println("Region:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Region:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Region:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Region:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Pais getPais() {
		return this.pais;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	
	
	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
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


	
	
	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<Provincia> getProvincias() {
		return this.provincias;
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

	public  void  setProvincias(List<Provincia> provincias) {
		try {
			this.provincias=provincias;
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
	String id_pais_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	
	
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";
	}
	
	
	Object clientesDescripcionReporte;
	Object provinciasDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	
	
	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getprovinciasDescripcionReporte() {
		return provinciasDescripcionReporte;
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

	public  void  setprovinciasDescripcionReporte(Object provincias) {
		try {
			this.provinciasDescripcionReporte=provincias;
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

