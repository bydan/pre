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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.TipoMonedaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;









@SuppressWarnings("unused")
public class TipoMoneda extends TipoMonedaAdditional implements Serializable ,Cloneable {//TipoMonedaAdditional,GeneralEntity
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
	
	private TipoMoneda tipomonedaOriginal;
	
	private Map<String, Object> mapTipoMoneda;
			
	public Map<String, Object> getMapTipoMoneda() {
		return mapTipoMoneda;
	}

	public void setMapTipoMoneda(Map<String, Object> mapTipoMoneda) {
		this.mapTipoMoneda = mapTipoMoneda;
	}
	
	public void inicializarMapTipoMoneda() {
		this.mapTipoMoneda = new HashMap<String,Object>();
	}
	
	public void setMapTipoMonedaValue(String sKey,Object oValue) {
		this.mapTipoMoneda.put(sKey, oValue);
	}
	
	public Object getMapTipoMonedaValue(String sKey) {
		return this.mapTipoMoneda.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMonedaConstantesFunciones.SREGEXNOMBRE,message=TipoMonedaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMonedaConstantesFunciones.SREGEXSIGLA,message=TipoMonedaConstantesFunciones.SMENSAJEREGEXSIGLA)
	private String sigla;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=5,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoMonedaConstantesFunciones.SREGEXSIMBOLO,message=TipoMonedaConstantesFunciones.SMENSAJEREGEXSIMBOLO)
	private String simbolo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
			
	
	
	
	
	
	public List<ParametroContabilidadDefecto> parametrocontabilidaddefectos;
		
	public TipoMoneda () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipomonedaOriginal=this;
		
 		this.nombre="";
 		this.sigla="";
 		this.simbolo="";
 		this.esta_activo=false;
		
		
		
		
		
		
		this.parametrocontabilidaddefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoMoneda (Long id,Date versionRow,String nombre,String sigla,String simbolo,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomonedaOriginal=this;
		
 		this.nombre=nombre;
 		this.sigla=sigla;
 		this.simbolo=simbolo;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoMoneda (String nombre,String sigla,String simbolo,Boolean esta_activo) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipomonedaOriginal=this;
		
 		this.nombre=nombre;
 		this.sigla=sigla;
 		this.simbolo=simbolo;
 		this.esta_activo=esta_activo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoMoneda tipomonedaLocal=null;
		
		if(object!=null) {
			tipomonedaLocal=(TipoMoneda)object;
			
			if(tipomonedaLocal!=null) {
				if(this.getId()!=null && tipomonedaLocal.getId()!=null) {
					if(this.getId().equals(tipomonedaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoMonedaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoMonedaConstantesFunciones.getTipoMonedaDescripcion(this);
		} else {
			sDetalle=TipoMonedaConstantesFunciones.getTipoMonedaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoMoneda getTipoMonedaOriginal() {
		return this.tipomonedaOriginal;
	}
	
	public void setTipoMonedaOriginal(TipoMoneda tipomoneda) {
		try {
			this.tipomonedaOriginal=tipomoneda;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoMonedaAdditional tipomonedaAdditional=null;
	
	public TipoMonedaAdditional getTipoMonedaAdditional() {
		return this.tipomonedaAdditional;
	}
	
	public void setTipoMonedaAdditional(TipoMonedaAdditional tipomonedaAdditional) {
		try {
			this.tipomonedaAdditional=tipomonedaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsigla() {
		return this.sigla;
	}
    
	
	public String getsimbolo() {
		return this.simbolo;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
	}
	
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMoneda:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("TipoMoneda:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsigla(String newsigla)throws Exception
	{
		try {
			if(this.sigla!=newsigla) {
				if(newsigla==null) {
					//newsigla="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMoneda:Valor nulo no permitido en columna sigla");
					}
				}

				if(newsigla!=null&&newsigla.length()>50) {
					newsigla=newsigla.substring(0,48);
					System.out.println("TipoMoneda:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sigla");
				}

				this.sigla=newsigla;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsimbolo(String newsimbolo)throws Exception
	{
		try {
			if(this.simbolo!=newsimbolo) {
				if(newsimbolo==null) {
					//newsimbolo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMoneda:Valor nulo no permitido en columna simbolo");
					}
				}

				if(newsimbolo!=null&&newsimbolo.length()>5) {
					newsimbolo=newsimbolo.substring(0,3);
					System.out.println("TipoMoneda:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=5 en columna simbolo");
				}

				this.simbolo=newsimbolo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoMoneda:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<ParametroContabilidadDefecto> getParametroContabilidadDefectos() {
		return this.parametrocontabilidaddefectos;
	}

	
	
	public  void  setParametroContabilidadDefectos(List<ParametroContabilidadDefecto> parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectos=parametrocontabilidaddefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String esta_activo_descripcion="";
	
	
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.esta_activo_descripcion="";
	}
	
	
	Object parametrocontabilidaddefectosDescripcionReporte;
	
	
	public Object getparametrocontabilidaddefectosDescripcionReporte() {
		return parametrocontabilidaddefectosDescripcionReporte;
	}

	
	
	public  void  setparametrocontabilidaddefectosDescripcionReporte(Object parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectosDescripcionReporte=parametrocontabilidaddefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

