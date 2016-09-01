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
//import com.bydan.erp.seguridad.util.ProvinciaConstantesFunciones;
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
public class Provincia extends ProvinciaAdditional implements Serializable ,Cloneable {//ProvinciaAdditional,GeneralEntity
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
	
	private Provincia provinciaOriginal;
	
	private Map<String, Object> mapProvincia;
			
	public Map<String, Object> getMapProvincia() {
		return mapProvincia;
	}

	public void setMapProvincia(Map<String, Object> mapProvincia) {
		this.mapProvincia = mapProvincia;
	}
	
	public void inicializarMapProvincia() {
		this.mapProvincia = new HashMap<String,Object>();
	}
	
	public void setMapProvinciaValue(String sKey,Object oValue) {
		this.mapProvincia.put(sKey, oValue);
	}
	
	public Object getMapProvinciaValue(String sKey) {
		return this.mapProvincia.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_region;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProvinciaConstantesFunciones.SREGEXCODIGO,message=ProvinciaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProvinciaConstantesFunciones.SREGEXNOMBRE,message=ProvinciaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Pais pais;
	public Region region;
	
	
	private String pais_descripcion;
	private String region_descripcion;
	
	
	public List<Ciudad> ciudads;
	public List<Cliente> clientes;
	public List<Canton> cantons;
	public List<Barrio> barrios;
	public List<Empleado> empleados;
	public List<DatoGeneralEmpleado> datogeneralempleados;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
		
	public Provincia () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.provinciaOriginal=this;
		
 		this.id_pais=-1L;
 		this.id_region=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.pais=null;
		this.region=null;
		
		
		this.pais_descripcion="";
		this.region_descripcion="";
		
		
		this.ciudads=null;
		this.clientes=null;
		this.cantons=null;
		this.barrios=null;
		this.empleados=null;
		this.datogeneralempleados=null;
		this.parametrocarteradefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Provincia (Long id,Date versionRow,Long id_pais,Long id_region,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.provinciaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Provincia (Long id_pais,Long id_region,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.provinciaOriginal=this;
		
 		this.id_pais=id_pais;
 		this.id_region=id_region;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Provincia provinciaLocal=null;
		
		if(object!=null) {
			provinciaLocal=(Provincia)object;
			
			if(provinciaLocal!=null) {
				if(this.getId()!=null && provinciaLocal.getId()!=null) {
					if(this.getId().equals(provinciaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProvinciaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProvinciaConstantesFunciones.getProvinciaDescripcion(this);
		} else {
			sDetalle=ProvinciaConstantesFunciones.getProvinciaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Provincia getProvinciaOriginal() {
		return this.provinciaOriginal;
	}
	
	public void setProvinciaOriginal(Provincia provincia) {
		try {
			this.provinciaOriginal=provincia;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProvinciaAdditional provinciaAdditional=null;
	
	public ProvinciaAdditional getProvinciaAdditional() {
		return this.provinciaAdditional;
	}
	
	public void setProvinciaAdditional(ProvinciaAdditional provinciaAdditional) {
		try {
			this.provinciaAdditional=provinciaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_region() {
		return this.id_region;
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
						System.out.println("Provincia:Valor nulo no permitido en columna id_pais");
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
						System.out.println("Provincia:Valor nulo no permitido en columna id_region");
					}
				}

				this.id_region=newid_region;
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
						System.out.println("Provincia:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Provincia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Provincia:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Provincia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
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

	public Region getRegion() {
		return this.region;
	}

	
	
	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getregion_descripcion() {
		return this.region_descripcion;
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


	
	
	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<Canton> getCantons() {
		return this.cantons;
	}

	public List<Barrio> getBarrios() {
		return this.barrios;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() {
		return this.parametrocarteradefectos;
	}

	
	
	public  void  setCiudads(List<Ciudad> ciudads) {
		try {
			this.ciudads=ciudads;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCantons(List<Canton> cantons) {
		try {
			this.cantons=cantons;
		} catch(Exception e) {
			;
		}
	}

	public  void  setBarrios(List<Barrio> barrios) {
		try {
			this.barrios=barrios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
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
	String id_pais_descripcion="";String id_region_descripcion="";
	
	
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_region_descripcion() {
		return id_region_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_pais_descripcion="";this.id_region_descripcion="";
	}
	
	
	Object barriosDescripcionReporte;
	Object cantonsDescripcionReporte;
	Object numeropatronalsDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object datogeneralusuariosDescripcionReporte;
	Object clientesDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	Object ciudadsDescripcionReporte;
	
	
	public Object getbarriosDescripcionReporte() {
		return barriosDescripcionReporte;
	}

	public Object getcantonsDescripcionReporte() {
		return cantonsDescripcionReporte;
	}

	public Object getnumeropatronalsDescripcionReporte() {
		return numeropatronalsDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getdatogeneralusuariosDescripcionReporte() {
		return datogeneralusuariosDescripcionReporte;
	}

	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getparametrocarteradefectosDescripcionReporte() {
		return parametrocarteradefectosDescripcionReporte;
	}

	public Object getciudadsDescripcionReporte() {
		return ciudadsDescripcionReporte;
	}

	
	
	public  void  setbarriosDescripcionReporte(Object barrios) {
		try {
			this.barriosDescripcionReporte=barrios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcantonsDescripcionReporte(Object cantons) {
		try {
			this.cantonsDescripcionReporte=cantons;
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

	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdatogeneralusuariosDescripcionReporte(Object datogeneralusuarios) {
		try {
			this.datogeneralusuariosDescripcionReporte=datogeneralusuarios;
		} catch(Exception ex) {
			;
		}
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

	public  void  setciudadsDescripcionReporte(Object ciudads) {
		try {
			this.ciudadsDescripcionReporte=ciudads;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

