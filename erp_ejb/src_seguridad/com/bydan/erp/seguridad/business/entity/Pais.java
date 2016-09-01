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
//import com.bydan.erp.seguridad.util.PaisConstantesFunciones;
import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class Pais extends PaisAdditional implements Serializable ,Cloneable {//PaisAdditional,GeneralEntity
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
	
	private Pais paisOriginal;
	
	private Map<String, Object> mapPais;
			
	public Map<String, Object> getMapPais() {
		return mapPais;
	}

	public void setMapPais(Map<String, Object> mapPais) {
		this.mapPais = mapPais;
	}
	
	public void inicializarMapPais() {
		this.mapPais = new HashMap<String,Object>();
	}
	
	public void setMapPaisValue(String sKey,Object oValue) {
		this.mapPais.put(sKey, oValue);
	}
	
	public Object getMapPaisValue(String sKey) {
		return this.mapPais.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_continente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PaisConstantesFunciones.SREGEXCODIGO,message=PaisConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PaisConstantesFunciones.SREGEXNOMBRE,message=PaisConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PaisConstantesFunciones.SREGEXNACIONALIDAD,message=PaisConstantesFunciones.SMENSAJEREGEXNACIONALIDAD)
	private String nacionalidad;
			
	
	public Continente continente;
	
	
	private String continente_descripcion;
	
	
	public List<Ciudad> ciudads;
	public List<Provincia> provincias;
	public List<Region> regions;
		
	public Pais () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.paisOriginal=this;
		
 		this.id_continente=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.nacionalidad="";
		
		
		this.continente=null;
		
		
		this.continente_descripcion="";
		
		
		this.ciudads=null;
		this.provincias=null;
		this.regions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Pais (Long id,Date versionRow,Long id_continente,String codigo,String nombre,String nacionalidad) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.paisOriginal=this;
		
 		this.id_continente=id_continente;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nacionalidad=nacionalidad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Pais (Long id_continente,String codigo,String nombre,String nacionalidad) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.paisOriginal=this;
		
 		this.id_continente=id_continente;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.nacionalidad=nacionalidad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Pais paisLocal=null;
		
		if(object!=null) {
			paisLocal=(Pais)object;
			
			if(paisLocal!=null) {
				if(this.getId()!=null && paisLocal.getId()!=null) {
					if(this.getId().equals(paisLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PaisConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PaisConstantesFunciones.getPaisDescripcion(this);
		} else {
			sDetalle=PaisConstantesFunciones.getPaisDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Pais getPaisOriginal() {
		return this.paisOriginal;
	}
	
	public void setPaisOriginal(Pais pais) {
		try {
			this.paisOriginal=pais;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PaisAdditional paisAdditional=null;
	
	public PaisAdditional getPaisAdditional() {
		return this.paisAdditional;
	}
	
	public void setPaisAdditional(PaisAdditional paisAdditional) {
		try {
			this.paisAdditional=paisAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_continente() {
		return this.id_continente;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getnacionalidad() {
		return this.nacionalidad;
	}
	
    
	public void setid_continente(Long newid_continente)throws Exception
	{
		try {
			if(this.id_continente!=newid_continente) {
				if(newid_continente==null) {
					//newid_continente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Pais:Valor nulo no permitido en columna id_continente");
					}
				}

				this.id_continente=newid_continente;
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
						System.out.println("Pais:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Pais:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Pais:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Pais:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnacionalidad(String newnacionalidad)throws Exception
	{
		try {
			if(this.nacionalidad!=newnacionalidad) {
				if(newnacionalidad==null) {
					//newnacionalidad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Pais:Valor nulo no permitido en columna nacionalidad");
					}
				}

				if(newnacionalidad!=null&&newnacionalidad.length()>50) {
					newnacionalidad=newnacionalidad.substring(0,48);
					System.out.println("Pais:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nacionalidad");
				}

				this.nacionalidad=newnacionalidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Continente getContinente() {
		return this.continente;
	}

	
	
	public String getcontinente_descripcion() {
		return this.continente_descripcion;
	}

	
	
	public  void  setContinente(Continente continente) {
		try {
			this.continente=continente;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcontinente_descripcion(String continente_descripcion) {
		try {
			this.continente_descripcion=continente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public List<Provincia> getProvincias() {
		return this.provincias;
	}

	public List<Region> getRegions() {
		return this.regions;
	}

	
	
	public  void  setCiudads(List<Ciudad> ciudads) {
		try {
			this.ciudads=ciudads;
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

	public  void  setRegions(List<Region> regions) {
		try {
			this.regions=regions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_continente_descripcion="";
	
	
	public String getid_continente_descripcion() {
		return id_continente_descripcion;
	}
	
	
	public void setid_continente_descripcion(String newid_continente_descripcion)throws Exception {
		try {
			this.id_continente_descripcion=newid_continente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_continente_descripcion="";
	}
	
	
	Object ciudadsDescripcionReporte;
	Object provinciasDescripcionReporte;
	Object regionsDescripcionReporte;
	
	
	public Object getciudadsDescripcionReporte() {
		return ciudadsDescripcionReporte;
	}

	public Object getprovinciasDescripcionReporte() {
		return provinciasDescripcionReporte;
	}

	public Object getregionsDescripcionReporte() {
		return regionsDescripcionReporte;
	}

	
	
	public  void  setciudadsDescripcionReporte(Object ciudads) {
		try {
			this.ciudadsDescripcionReporte=ciudads;
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

	public  void  setregionsDescripcionReporte(Object regions) {
		try {
			this.regionsDescripcionReporte=regions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

