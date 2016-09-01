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
//import com.bydan.erp.seguridad.util.ParroquiaConstantesFunciones;
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
public class Parroquia extends ParroquiaAdditional implements Serializable ,Cloneable {//ParroquiaAdditional,GeneralEntity
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
	
	private Parroquia parroquiaOriginal;
	
	private Map<String, Object> mapParroquia;
			
	public Map<String, Object> getMapParroquia() {
		return mapParroquia;
	}

	public void setMapParroquia(Map<String, Object> mapParroquia) {
		this.mapParroquia = mapParroquia;
	}
	
	public void inicializarMapParroquia() {
		this.mapParroquia = new HashMap<String,Object>();
	}
	
	public void setMapParroquiaValue(String sKey,Object oValue) {
		this.mapParroquia.put(sKey, oValue);
	}
	
	public Object getMapParroquiaValue(String sKey) {
		return this.mapParroquia.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_canton;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParroquiaConstantesFunciones.SREGEXCODIGO,message=ParroquiaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ParroquiaConstantesFunciones.SREGEXNOMBRE,message=ParroquiaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_activo;
			
	
	public Canton canton;
	
	
	private String canton_descripcion;
	
	
		
	public Parroquia () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parroquiaOriginal=this;
		
 		this.id_canton=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.es_activo=false;
		
		
		this.canton=null;
		
		
		this.canton_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Parroquia (Long id,Date versionRow,Long id_canton,String codigo,String nombre,Boolean es_activo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parroquiaOriginal=this;
		
 		this.id_canton=id_canton;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Parroquia (Long id_canton,String codigo,String nombre,Boolean es_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parroquiaOriginal=this;
		
 		this.id_canton=id_canton;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_activo=es_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Parroquia parroquiaLocal=null;
		
		if(object!=null) {
			parroquiaLocal=(Parroquia)object;
			
			if(parroquiaLocal!=null) {
				if(this.getId()!=null && parroquiaLocal.getId()!=null) {
					if(this.getId().equals(parroquiaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParroquiaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParroquiaConstantesFunciones.getParroquiaDescripcion(this);
		} else {
			sDetalle=ParroquiaConstantesFunciones.getParroquiaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Parroquia getParroquiaOriginal() {
		return this.parroquiaOriginal;
	}
	
	public void setParroquiaOriginal(Parroquia parroquia) {
		try {
			this.parroquiaOriginal=parroquia;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParroquiaAdditional parroquiaAdditional=null;
	
	public ParroquiaAdditional getParroquiaAdditional() {
		return this.parroquiaAdditional;
	}
	
	public void setParroquiaAdditional(ParroquiaAdditional parroquiaAdditional) {
		try {
			this.parroquiaAdditional=parroquiaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_canton() {
		return this.id_canton;
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
	
    
	public void setid_canton(Long newid_canton)throws Exception
	{
		try {
			if(this.id_canton!=newid_canton) {
				if(newid_canton==null) {
					//newid_canton=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Parroquia:Valor nulo no permitido en columna id_canton");
					}
				}

				this.id_canton=newid_canton;
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
						System.out.println("Parroquia:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Parroquia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Parroquia:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>200) {
					newnombre=newnombre.substring(0,198);
					System.out.println("Parroquia:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre");
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
						System.out.println("Parroquia:Valor nulo no permitido en columna es_activo");
					}
				}

				this.es_activo=newes_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Canton getCanton() {
		return this.canton;
	}

	
	
	public String getcanton_descripcion() {
		return this.canton_descripcion;
	}

	
	
	public  void  setCanton(Canton canton) {
		try {
			this.canton=canton;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcanton_descripcion(String canton_descripcion) {
		try {
			this.canton_descripcion=canton_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_canton_descripcion="";String es_activo_descripcion="";
	
	
	public String getid_canton_descripcion() {
		return id_canton_descripcion;
	}
	public String getes_activo_descripcion() {
		return es_activo_descripcion;
	}
	
	
	public void setid_canton_descripcion(String newid_canton_descripcion)throws Exception {
		try {
			this.id_canton_descripcion=newid_canton_descripcion;
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
		this.id_canton_descripcion="";this.es_activo_descripcion="";
	}
	
	
	Object barriosDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object numeropatronalsDescripcionReporte;
	
	
	public Object getbarriosDescripcionReporte() {
		return barriosDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getnumeropatronalsDescripcionReporte() {
		return numeropatronalsDescripcionReporte;
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

	/*PARA REPORTES FIN*/		
}

