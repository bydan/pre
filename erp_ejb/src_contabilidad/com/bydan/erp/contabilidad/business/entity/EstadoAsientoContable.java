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
//import com.bydan.erp.contabilidad.util.EstadoAsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class EstadoAsientoContable extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//EstadoAsientoContableAdditional,GeneralEntity
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
	
	private EstadoAsientoContable estadoasientocontableOriginal;
	
	private Map<String, Object> mapEstadoAsientoContable;
			
	public Map<String, Object> getMapEstadoAsientoContable() {
		return mapEstadoAsientoContable;
	}

	public void setMapEstadoAsientoContable(Map<String, Object> mapEstadoAsientoContable) {
		this.mapEstadoAsientoContable = mapEstadoAsientoContable;
	}
	
	public void inicializarMapEstadoAsientoContable() {
		this.mapEstadoAsientoContable = new HashMap<String,Object>();
	}
	
	public void setMapEstadoAsientoContableValue(String sKey,Object oValue) {
		this.mapEstadoAsientoContable.put(sKey, oValue);
	}
	
	public Object getMapEstadoAsientoContableValue(String sKey) {
		return this.mapEstadoAsientoContable.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoAsientoContableConstantesFunciones.SREGEXCODIGO,message=EstadoAsientoContableConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoAsientoContableConstantesFunciones.SREGEXNOMBRE,message=EstadoAsientoContableConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_color_general;
			
	
	public ColorGeneral colorgeneral;
	
	
	private String colorgeneral_descripcion;
	
	
	public List<ParametroContabilidadDefecto> parametrocontabilidaddefectos;
		
	public EstadoAsientoContable () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadoasientocontableOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
 		this.id_color_general=-1L;
		
		
		this.colorgeneral=null;
		
		
		this.colorgeneral_descripcion="";
		
		
		this.parametrocontabilidaddefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoAsientoContable (Long id,Date versionRow,String codigo,String nombre,Long id_color_general) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadoasientocontableOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_color_general=id_color_general;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoAsientoContable (String codigo,String nombre,Long id_color_general) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadoasientocontableOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_color_general=id_color_general;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoAsientoContable estadoasientocontableLocal=null;
		
		if(object!=null) {
			estadoasientocontableLocal=(EstadoAsientoContable)object;
			
			if(estadoasientocontableLocal!=null) {
				if(this.getId()!=null && estadoasientocontableLocal.getId()!=null) {
					if(this.getId().equals(estadoasientocontableLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoAsientoContableConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcion(this);
		} else {
			sDetalle=EstadoAsientoContableConstantesFunciones.getEstadoAsientoContableDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoAsientoContable getEstadoAsientoContableOriginal() {
		return this.estadoasientocontableOriginal;
	}
	
	public void setEstadoAsientoContableOriginal(EstadoAsientoContable estadoasientocontable) {
		try {
			this.estadoasientocontableOriginal=estadoasientocontable;
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
    
	
	public Long getid_color_general() {
		return this.id_color_general;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoAsientoContable:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoAsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadoAsientoContable:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("EstadoAsientoContable:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_color_general(Long newid_color_general)throws Exception
	{
		try {
			if(this.id_color_general!=newid_color_general) {
				if(newid_color_general==null) {
					//newid_color_general=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoAsientoContable:Valor nulo no permitido en columna id_color_general");
					}
				}

				this.id_color_general=newid_color_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public ColorGeneral getColorGeneral() {
		return this.colorgeneral;
	}

	
	
	public String getcolorgeneral_descripcion() {
		return this.colorgeneral_descripcion;
	}

	
	
	public  void  setColorGeneral(ColorGeneral colorgeneral) {
		try {
			this.colorgeneral=colorgeneral;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setcolorgeneral_descripcion(String colorgeneral_descripcion) {
		try {
			this.colorgeneral_descripcion=colorgeneral_descripcion;
		} catch(Exception e) {
			;
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
	String id_color_general_descripcion="";
	
	
	public String getid_color_general_descripcion() {
		return id_color_general_descripcion;
	}
	
	
	public void setid_color_general_descripcion(String newid_color_general_descripcion)throws Exception {
		try {
			this.id_color_general_descripcion=newid_color_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_color_general_descripcion="";
	}
	
	
	Object parametrocontabilidaddefectosDescripcionReporte;
	Object asientocontablesDescripcionReporte;
	
	
	public Object getparametrocontabilidaddefectosDescripcionReporte() {
		return parametrocontabilidaddefectosDescripcionReporte;
	}

	public Object getasientocontablesDescripcionReporte() {
		return asientocontablesDescripcionReporte;
	}

	
	
	public  void  setparametrocontabilidaddefectosDescripcionReporte(Object parametrocontabilidaddefectos) {
		try {
			this.parametrocontabilidaddefectosDescripcionReporte=parametrocontabilidaddefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setasientocontablesDescripcionReporte(Object asientocontables) {
		try {
			this.asientocontablesDescripcionReporte=asientocontables;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

