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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.BarrioConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Barrio extends BarrioAdditional implements Serializable ,Cloneable {//BarrioAdditional,GeneralEntity
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
	
	private Barrio barrioOriginal;
	
	private Map<String, Object> mapBarrio;
			
	public Map<String, Object> getMapBarrio() {
		return mapBarrio;
	}

	public void setMapBarrio(Map<String, Object> mapBarrio) {
		this.mapBarrio = mapBarrio;
	}
	
	public void inicializarMapBarrio() {
		this.mapBarrio = new HashMap<String,Object>();
	}
	
	public void setMapBarrioValue(String sKey,Object oValue) {
		this.mapBarrio.put(sKey, oValue);
	}
	
	public Object getMapBarrioValue(String sKey) {
		return this.mapBarrio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_canton;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parroquia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BarrioConstantesFunciones.SREGEXCODIGO,message=BarrioConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=BarrioConstantesFunciones.SREGEXNOMBRE,message=BarrioConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Provincia provincia;
	public Canton canton;
	public Parroquia parroquia;
	
	
	private String provincia_descripcion;
	private String canton_descripcion;
	private String parroquia_descripcion;
	
	
		
	public Barrio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.barrioOriginal=this;
		
 		this.id_provincia=-1L;
 		this.id_canton=-1L;
 		this.id_parroquia=-1L;
 		this.codigo="";
 		this.nombre="";
		
		
		this.provincia=null;
		this.canton=null;
		this.parroquia=null;
		
		
		this.provincia_descripcion="";
		this.canton_descripcion="";
		this.parroquia_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Barrio (Long id,Date versionRow,Long id_provincia,Long id_canton,Long id_parroquia,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.barrioOriginal=this;
		
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Barrio (Long id_provincia,Long id_canton,Long id_parroquia,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.barrioOriginal=this;
		
 		this.id_provincia=id_provincia;
 		this.id_canton=id_canton;
 		this.id_parroquia=id_parroquia;
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Barrio barrioLocal=null;
		
		if(object!=null) {
			barrioLocal=(Barrio)object;
			
			if(barrioLocal!=null) {
				if(this.getId()!=null && barrioLocal.getId()!=null) {
					if(this.getId().equals(barrioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!BarrioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=BarrioConstantesFunciones.getBarrioDescripcion(this);
		} else {
			sDetalle=BarrioConstantesFunciones.getBarrioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Barrio getBarrioOriginal() {
		return this.barrioOriginal;
	}
	
	public void setBarrioOriginal(Barrio barrio) {
		try {
			this.barrioOriginal=barrio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected BarrioAdditional barrioAdditional=null;
	
	public BarrioAdditional getBarrioAdditional() {
		return this.barrioAdditional;
	}
	
	public void setBarrioAdditional(BarrioAdditional barrioAdditional) {
		try {
			this.barrioAdditional=barrioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_provincia() {
		return this.id_provincia;
	}
    
	
	public Long getid_canton() {
		return this.id_canton;
	}
    
	
	public Long getid_parroquia() {
		return this.id_parroquia;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_provincia(Long newid_provincia)throws Exception
	{
		try {
			if(this.id_provincia!=newid_provincia) {
				if(newid_provincia==null) {
					//newid_provincia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Barrio:Valor nulo no permitido en columna id_provincia");
					}
				}

				this.id_provincia=newid_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_canton(Long newid_canton)throws Exception
	{
		try {
			if(this.id_canton!=newid_canton) {
				if(newid_canton==null) {
					//newid_canton=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Barrio:Valor nulo no permitido en columna id_canton");
					}
				}

				this.id_canton=newid_canton;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parroquia(Long newid_parroquia)throws Exception
	{
		try {
			if(this.id_parroquia!=newid_parroquia) {
				if(newid_parroquia==null) {
					//newid_parroquia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Barrio:Valor nulo no permitido en columna id_parroquia");
					}
				}

				this.id_parroquia=newid_parroquia;
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
						System.out.println("Barrio:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Barrio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Barrio:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Barrio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Provincia getProvincia() {
		return this.provincia;
	}

	public Canton getCanton() {
		return this.canton;
	}

	public Parroquia getParroquia() {
		return this.parroquia;
	}

	
	
	public String getprovincia_descripcion() {
		return this.provincia_descripcion;
	}

	public String getcanton_descripcion() {
		return this.canton_descripcion;
	}

	public String getparroquia_descripcion() {
		return this.parroquia_descripcion;
	}

	
	
	public  void  setProvincia(Provincia provincia) {
		try {
			this.provincia=provincia;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCanton(Canton canton) {
		try {
			this.canton=canton;
		} catch(Exception e) {
			;
		}
	}


	public  void  setParroquia(Parroquia parroquia) {
		try {
			this.parroquia=parroquia;
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


	public  void  setcanton_descripcion(String canton_descripcion) {
		try {
			this.canton_descripcion=canton_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setparroquia_descripcion(String parroquia_descripcion) {
		try {
			this.parroquia_descripcion=parroquia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_provincia_descripcion="";String id_canton_descripcion="";String id_parroquia_descripcion="";
	
	
	public String getid_provincia_descripcion() {
		return id_provincia_descripcion;
	}
	public String getid_canton_descripcion() {
		return id_canton_descripcion;
	}
	public String getid_parroquia_descripcion() {
		return id_parroquia_descripcion;
	}
	
	
	public void setid_provincia_descripcion(String newid_provincia_descripcion)throws Exception {
		try {
			this.id_provincia_descripcion=newid_provincia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_canton_descripcion(String newid_canton_descripcion)throws Exception {
		try {
			this.id_canton_descripcion=newid_canton_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_parroquia_descripcion(String newid_parroquia_descripcion)throws Exception {
		try {
			this.id_parroquia_descripcion=newid_parroquia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_provincia_descripcion="";this.id_canton_descripcion="";this.id_parroquia_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

