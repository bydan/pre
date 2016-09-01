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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.EstadoBodegaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;









@SuppressWarnings("unused")
public class EstadoBodegaProducto extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//EstadoBodegaProductoAdditional,GeneralEntity
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
	
	private EstadoBodegaProducto estadobodegaproductoOriginal;
	
	private Map<String, Object> mapEstadoBodegaProducto;
			
	public Map<String, Object> getMapEstadoBodegaProducto() {
		return mapEstadoBodegaProducto;
	}

	public void setMapEstadoBodegaProducto(Map<String, Object> mapEstadoBodegaProducto) {
		this.mapEstadoBodegaProducto = mapEstadoBodegaProducto;
	}
	
	public void inicializarMapEstadoBodegaProducto() {
		this.mapEstadoBodegaProducto = new HashMap<String,Object>();
	}
	
	public void setMapEstadoBodegaProductoValue(String sKey,Object oValue) {
		this.mapEstadoBodegaProducto.put(sKey, oValue);
	}
	
	public Object getMapEstadoBodegaProductoValue(String sKey) {
		return this.mapEstadoBodegaProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoBodegaProductoConstantesFunciones.SREGEXCODIGO,message=EstadoBodegaProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoBodegaProductoConstantesFunciones.SREGEXNOMBRE,message=EstadoBodegaProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_defecto;
			
	
	
	
	
	
		
	public EstadoBodegaProducto () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadobodegaproductoOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
 		this.es_defecto=false;
		
		
		
		
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoBodegaProducto (Long id,Date versionRow,String codigo,String nombre,Boolean es_defecto) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadobodegaproductoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_defecto=es_defecto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoBodegaProducto (String codigo,String nombre,Boolean es_defecto) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadobodegaproductoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_defecto=es_defecto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoBodegaProducto estadobodegaproductoLocal=null;
		
		if(object!=null) {
			estadobodegaproductoLocal=(EstadoBodegaProducto)object;
			
			if(estadobodegaproductoLocal!=null) {
				if(this.getId()!=null && estadobodegaproductoLocal.getId()!=null) {
					if(this.getId().equals(estadobodegaproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoBodegaProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoDescripcion(this);
		} else {
			sDetalle=EstadoBodegaProductoConstantesFunciones.getEstadoBodegaProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoBodegaProducto getEstadoBodegaProductoOriginal() {
		return this.estadobodegaproductoOriginal;
	}
	
	public void setEstadoBodegaProductoOriginal(EstadoBodegaProducto estadobodegaproducto) {
		try {
			this.estadobodegaproductoOriginal=estadobodegaproducto;
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
    
	
	public Boolean getes_defecto() {
		return this.es_defecto;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoBodegaProducto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoBodegaProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadoBodegaProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("EstadoBodegaProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_defecto(Boolean newes_defecto)throws Exception
	{
		try {
			if(this.es_defecto!=newes_defecto) {
				if(newes_defecto==null) {
					//newes_defecto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoBodegaProducto:Valor nulo no permitido en columna es_defecto");
					}
				}

				this.es_defecto=newes_defecto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*PARA REPORTES*/
	String es_defecto_descripcion="";
	
	
	public String getes_defecto_descripcion() {
		return es_defecto_descripcion;
	}
	
	
	public void setes_defecto_descripcion(String newes_defecto_descripcion)throws Exception {
		try {
			this.es_defecto_descripcion=newes_defecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.es_defecto_descripcion="";
	}
	
	
	Object bodegaproductosDescripcionReporte;
	
	
	public Object getbodegaproductosDescripcionReporte() {
		return bodegaproductosDescripcionReporte;
	}

	
	
	public  void  setbodegaproductosDescripcionReporte(Object bodegaproductos) {
		try {
			this.bodegaproductosDescripcionReporte=bodegaproductos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

