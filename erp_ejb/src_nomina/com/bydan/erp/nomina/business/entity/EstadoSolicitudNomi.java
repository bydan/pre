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
//import com.bydan.erp.nomina.util.EstadoSolicitudNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;









@SuppressWarnings("unused")
public class EstadoSolicitudNomi extends EstadoSolicitudNomiAdditional implements Serializable ,Cloneable {//EstadoSolicitudNomiAdditional,GeneralEntity
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
	
	private EstadoSolicitudNomi estadosolicitudnomiOriginal;
	
	private Map<String, Object> mapEstadoSolicitudNomi;
			
	public Map<String, Object> getMapEstadoSolicitudNomi() {
		return mapEstadoSolicitudNomi;
	}

	public void setMapEstadoSolicitudNomi(Map<String, Object> mapEstadoSolicitudNomi) {
		this.mapEstadoSolicitudNomi = mapEstadoSolicitudNomi;
	}
	
	public void inicializarMapEstadoSolicitudNomi() {
		this.mapEstadoSolicitudNomi = new HashMap<String,Object>();
	}
	
	public void setMapEstadoSolicitudNomiValue(String sKey,Object oValue) {
		this.mapEstadoSolicitudNomi.put(sKey, oValue);
	}
	
	public Object getMapEstadoSolicitudNomiValue(String sKey) {
		return this.mapEstadoSolicitudNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoSolicitudNomiConstantesFunciones.SREGEXCODIGO,message=EstadoSolicitudNomiConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoSolicitudNomiConstantesFunciones.SREGEXNOMBRE,message=EstadoSolicitudNomiConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<SolicitudReemplazo> solicitudreemplazos;
	public List<SolicitudHoraExtra> solicitudhoraextras;
	public List<SolicitudVacacion> solicitudvacacions;
		
	public EstadoSolicitudNomi () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadosolicitudnomiOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.solicitudreemplazos=null;
		this.solicitudhoraextras=null;
		this.solicitudvacacions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoSolicitudNomi (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosolicitudnomiOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoSolicitudNomi (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadosolicitudnomiOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoSolicitudNomi estadosolicitudnomiLocal=null;
		
		if(object!=null) {
			estadosolicitudnomiLocal=(EstadoSolicitudNomi)object;
			
			if(estadosolicitudnomiLocal!=null) {
				if(this.getId()!=null && estadosolicitudnomiLocal.getId()!=null) {
					if(this.getId().equals(estadosolicitudnomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoSolicitudNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcion(this);
		} else {
			sDetalle=EstadoSolicitudNomiConstantesFunciones.getEstadoSolicitudNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoSolicitudNomi getEstadoSolicitudNomiOriginal() {
		return this.estadosolicitudnomiOriginal;
	}
	
	public void setEstadoSolicitudNomiOriginal(EstadoSolicitudNomi estadosolicitudnomi) {
		try {
			this.estadosolicitudnomiOriginal=estadosolicitudnomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstadoSolicitudNomiAdditional estadosolicitudnomiAdditional=null;
	
	public EstadoSolicitudNomiAdditional getEstadoSolicitudNomiAdditional() {
		return this.estadosolicitudnomiAdditional;
	}
	
	public void setEstadoSolicitudNomiAdditional(EstadoSolicitudNomiAdditional estadosolicitudnomiAdditional) {
		try {
			this.estadosolicitudnomiAdditional=estadosolicitudnomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoSolicitudNomi:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoSolicitudNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadoSolicitudNomi:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("EstadoSolicitudNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<SolicitudReemplazo> getSolicitudReemplazos() {
		return this.solicitudreemplazos;
	}

	public List<SolicitudHoraExtra> getSolicitudHoraExtras() {
		return this.solicitudhoraextras;
	}

	public List<SolicitudVacacion> getSolicitudVacacions() {
		return this.solicitudvacacions;
	}

	
	
	public  void  setSolicitudReemplazos(List<SolicitudReemplazo> solicitudreemplazos) {
		try {
			this.solicitudreemplazos=solicitudreemplazos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSolicitudHoraExtras(List<SolicitudHoraExtra> solicitudhoraextras) {
		try {
			this.solicitudhoraextras=solicitudhoraextras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setSolicitudVacacions(List<SolicitudVacacion> solicitudvacacions) {
		try {
			this.solicitudvacacions=solicitudvacacions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object solicitudreemplazosDescripcionReporte;
	Object solicitudhoraextrasDescripcionReporte;
	Object solicitudvacacionsDescripcionReporte;
	
	
	public Object getsolicitudreemplazosDescripcionReporte() {
		return solicitudreemplazosDescripcionReporte;
	}

	public Object getsolicitudhoraextrasDescripcionReporte() {
		return solicitudhoraextrasDescripcionReporte;
	}

	public Object getsolicitudvacacionsDescripcionReporte() {
		return solicitudvacacionsDescripcionReporte;
	}

	
	
	public  void  setsolicitudreemplazosDescripcionReporte(Object solicitudreemplazos) {
		try {
			this.solicitudreemplazosDescripcionReporte=solicitudreemplazos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsolicitudhoraextrasDescripcionReporte(Object solicitudhoraextras) {
		try {
			this.solicitudhoraextrasDescripcionReporte=solicitudhoraextras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setsolicitudvacacionsDescripcionReporte(Object solicitudvacacions) {
		try {
			this.solicitudvacacionsDescripcionReporte=solicitudvacacions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

