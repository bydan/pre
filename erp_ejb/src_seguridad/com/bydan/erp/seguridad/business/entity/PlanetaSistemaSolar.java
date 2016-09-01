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
//import com.bydan.erp.seguridad.util.PlanetaSistemaSolarConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class PlanetaSistemaSolar extends PlanetaSistemaSolarAdditional implements Serializable ,Cloneable {//PlanetaSistemaSolarAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private PlanetaSistemaSolar planetasistemasolarOriginal;
	
	private Map<String, Object> mapPlanetaSistemaSolar;
			
	public Map<String, Object> getMapPlanetaSistemaSolar() {
		return mapPlanetaSistemaSolar;
	}

	public void setMapPlanetaSistemaSolar(Map<String, Object> mapPlanetaSistemaSolar) {
		this.mapPlanetaSistemaSolar = mapPlanetaSistemaSolar;
	}
	
	public void inicializarMapPlanetaSistemaSolar() {
		this.mapPlanetaSistemaSolar = new HashMap<String,Object>();
	}
	
	public void setMapPlanetaSistemaSolarValue(String sKey,Object oValue) {
		this.mapPlanetaSistemaSolar.put(sKey, oValue);
	}
	
	public Object getMapPlanetaSistemaSolarValue(String sKey) {
		return this.mapPlanetaSistemaSolar.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_valoracion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlanetaSistemaSolarConstantesFunciones.SREGEXCODIGO,message=PlanetaSistemaSolarConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlanetaSistemaSolarConstantesFunciones.SREGEXNOMBRE,message=PlanetaSistemaSolarConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PlanetaSistemaSolarConstantesFunciones.SREGEXDESCRIPCION,message=PlanetaSistemaSolarConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public TipoValoracion tipovaloracion;
	
	
	private String tipovaloracion_descripcion;
	
	
		
	public PlanetaSistemaSolar () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.planetasistemasolarOriginal=this;
		
 		this.id_tipo_valoracion=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.descripcion="";
		
		
		this.tipovaloracion=null;
		
		
		this.tipovaloracion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PlanetaSistemaSolar (Long id,Date versionRow,Long id_tipo_valoracion,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planetasistemasolarOriginal=this;
		
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PlanetaSistemaSolar (Long id_tipo_valoracion,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.planetasistemasolarOriginal=this;
		
 		this.id_tipo_valoracion=id_tipo_valoracion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PlanetaSistemaSolar planetasistemasolarLocal=null;
		
		if(object!=null) {
			planetasistemasolarLocal=(PlanetaSistemaSolar)object;
			
			if(planetasistemasolarLocal!=null) {
				if(this.getId()!=null && planetasistemasolarLocal.getId()!=null) {
					if(this.getId().equals(planetasistemasolarLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PlanetaSistemaSolarConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PlanetaSistemaSolarConstantesFunciones.getPlanetaSistemaSolarDescripcion(this);
		} else {
			sDetalle=PlanetaSistemaSolarConstantesFunciones.getPlanetaSistemaSolarDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PlanetaSistemaSolar getPlanetaSistemaSolarOriginal() {
		return this.planetasistemasolarOriginal;
	}
	
	public void setPlanetaSistemaSolarOriginal(PlanetaSistemaSolar planetasistemasolar) {
		try {
			this.planetasistemasolarOriginal=planetasistemasolar;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PlanetaSistemaSolarAdditional planetasistemasolarAdditional=null;
	
	public PlanetaSistemaSolarAdditional getPlanetaSistemaSolarAdditional() {
		return this.planetasistemasolarAdditional;
	}
	
	public void setPlanetaSistemaSolarAdditional(PlanetaSistemaSolarAdditional planetasistemasolarAdditional) {
		try {
			this.planetasistemasolarAdditional=planetasistemasolarAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_valoracion() {
		return this.id_tipo_valoracion;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_tipo_valoracion(Long newid_tipo_valoracion)throws Exception
	{
		try {
			if(this.id_tipo_valoracion!=newid_tipo_valoracion) {
				if(newid_tipo_valoracion==null) {
					//newid_tipo_valoracion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlanetaSistemaSolar:Valor nulo no permitido en columna id_tipo_valoracion");
					}
				}

				this.id_tipo_valoracion=newid_tipo_valoracion;
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
						System.out.println("PlanetaSistemaSolar:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("PlanetaSistemaSolar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("PlanetaSistemaSolar:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("PlanetaSistemaSolar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PlanetaSistemaSolar:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("PlanetaSistemaSolar:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoValoracion getTipoValoracion() {
		return this.tipovaloracion;
	}

	
	
	public String gettipovaloracion_descripcion() {
		return this.tipovaloracion_descripcion;
	}

	
	
	public  void  setTipoValoracion(TipoValoracion tipovaloracion) {
		try {
			this.tipovaloracion=tipovaloracion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  settipovaloracion_descripcion(String tipovaloracion_descripcion) {
		try {
			this.tipovaloracion_descripcion=tipovaloracion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_valoracion_descripcion="";
	
	
	public String getid_tipo_valoracion_descripcion() {
		return id_tipo_valoracion_descripcion;
	}
	
	
	public void setid_tipo_valoracion_descripcion(String newid_tipo_valoracion_descripcion)throws Exception {
		try {
			this.id_tipo_valoracion_descripcion=newid_tipo_valoracion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_valoracion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

