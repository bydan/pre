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
//import com.bydan.erp.seguridad.util.CantonConstantesFunciones;
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
public class Canton extends CantonAdditional implements Serializable ,Cloneable {//CantonAdditional,GeneralEntity
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
	
	private Canton cantonOriginal;
	
	private Map<String, Object> mapCanton;
			
	public Map<String, Object> getMapCanton() {
		return mapCanton;
	}

	public void setMapCanton(Map<String, Object> mapCanton) {
		this.mapCanton = mapCanton;
	}
	
	public void inicializarMapCanton() {
		this.mapCanton = new HashMap<String,Object>();
	}
	
	public void setMapCantonValue(String sKey,Object oValue) {
		this.mapCanton.put(sKey, oValue);
	}
	
	public Object getMapCantonValue(String sKey) {
		return this.mapCanton.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CantonConstantesFunciones.SREGEXCODIGO,message=CantonConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CantonConstantesFunciones.SREGEXNOMBRE,message=CantonConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_activo;
			
	
	public Provincia provincia;
	
	
	private String provincia_descripcion;
	
	
	public List<Barrio> barrios;
	public List<Parroquia> parroquias;
		
	public Canton () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cantonOriginal=this;
		
 		this.id_provincia=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.es_activo=false;
		
		
		this.provincia=null;
		
		
		this.provincia_descripcion="";
		
		
		this.barrios=null;
		this.parroquias=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Canton (Long id,Date versionRow,Long id_provincia,String codigo,String nombre,Boolean es_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cantonOriginal=this;
		
 		this.id_provincia=id_provincia;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Canton (Long id_provincia,String codigo,String nombre,Boolean es_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cantonOriginal=this;
		
 		this.id_provincia=id_provincia;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Canton cantonLocal=null;
		
		if(object!=null) {
			cantonLocal=(Canton)object;
			
			if(cantonLocal!=null) {
				if(this.getId()!=null && cantonLocal.getId()!=null) {
					if(this.getId().equals(cantonLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CantonConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CantonConstantesFunciones.getCantonDescripcion(this);
		} else {
			sDetalle=CantonConstantesFunciones.getCantonDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Canton getCantonOriginal() {
		return this.cantonOriginal;
	}
	
	public void setCantonOriginal(Canton canton) {
		try {
			this.cantonOriginal=canton;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CantonAdditional cantonAdditional=null;
	
	public CantonAdditional getCantonAdditional() {
		return this.cantonAdditional;
	}
	
	public void setCantonAdditional(CantonAdditional cantonAdditional) {
		try {
			this.cantonAdditional=cantonAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Boolean getes_activo() {
		return this.es_activo;
	}
	
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Canton:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
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
						System.out.println("Canton:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Canton:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Canton:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Canton:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_activo(Boolean newes_activo)throws Exception
	{
		try {
			if(this.es_activo!=newes_activo) {
				if(newes_activo==null) {
					//newes_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Canton:Valor nulo no permitido en columna es_activo");
					}
				}

				this.es_activo=newes_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Provincia getProvincia() {
		return this.provincia;
	}

	
	
	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	
	
	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
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


	
	
	public List<Barrio> getBarrios() {
		return this.barrios;
	}

	public List<Parroquia> getParroquias() {
		return this.parroquias;
	}

	
	
	public  void  setBarrios(List<Barrio> barrios) {
		try {
			this.barrios=barrios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParroquias(List<Parroquia> parroquias) {
		try {
			this.parroquias=parroquias;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_provincia_descripcion="";String es_activo_descripcion="";
	
	
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getes_activo_descripcion() {
		return es_activo_descripcion;
	}
	
	
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_activo_descripcion(String newes_activo_descripcion)throws Exception {
		try {
			this.es_activo_descripcion=newes_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_provincia_descripcion="";this.es_activo_descripcion="";
	}
	
	
	Object barriosDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object numeropatronalsDescripcionReporte;
	Object parroquiasDescripcionReporte;
	
	
	public Object getbarriosDescripcionReporte() {
		return barriosDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getnumeropatronalsDescripcionReporte() {
		return numeropatronalsDescripcionReporte;
	}

	public Object getparroquiasDescripcionReporte() {
		return parroquiasDescripcionReporte;
	}

	
	
	public  void  setbarriosDescripcionReporte(Object barrios) {
		try {
			this.barriosDescripcionReporte=barrios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnumeropatronalsDescripcionReporte(Object numeropatronals) {
		try {
			this.numeropatronalsDescripcionReporte=numeropatronals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparroquiasDescripcionReporte(Object parroquias) {
		try {
			this.parroquiasDescripcionReporte=parroquias;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

