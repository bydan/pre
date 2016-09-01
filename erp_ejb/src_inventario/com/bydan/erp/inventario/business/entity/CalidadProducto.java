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
//import com.bydan.erp.inventario.util.CalidadProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;









@SuppressWarnings("unused")
public class CalidadProducto extends CalidadProductoAdditional implements Serializable ,Cloneable {//CalidadProductoAdditional,GeneralEntity
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
	
	private CalidadProducto calidadproductoOriginal;
	
	private Map<String, Object> mapCalidadProducto;
			
	public Map<String, Object> getMapCalidadProducto() {
		return mapCalidadProducto;
	}

	public void setMapCalidadProducto(Map<String, Object> mapCalidadProducto) {
		this.mapCalidadProducto = mapCalidadProducto;
	}
	
	public void inicializarMapCalidadProducto() {
		this.mapCalidadProducto = new HashMap<String,Object>();
	}
	
	public void setMapCalidadProductoValue(String sKey,Object oValue) {
		this.mapCalidadProducto.put(sKey, oValue);
	}
	
	public Object getMapCalidadProductoValue(String sKey) {
		return this.mapCalidadProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CalidadProductoConstantesFunciones.SREGEXCODIGO,message=CalidadProductoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CalidadProductoConstantesFunciones.SREGEXNOMBRE,message=CalidadProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<Bodega> bodegas;
	public List<ParametroInventarioDefecto> parametroinventariodefectos;
		
	public CalidadProducto () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.calidadproductoOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.bodegas=null;
		this.parametroinventariodefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CalidadProducto (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.calidadproductoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CalidadProducto (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.calidadproductoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CalidadProducto calidadproductoLocal=null;
		
		if(object!=null) {
			calidadproductoLocal=(CalidadProducto)object;
			
			if(calidadproductoLocal!=null) {
				if(this.getId()!=null && calidadproductoLocal.getId()!=null) {
					if(this.getId().equals(calidadproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CalidadProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CalidadProductoConstantesFunciones.getCalidadProductoDescripcion(this);
		} else {
			sDetalle=CalidadProductoConstantesFunciones.getCalidadProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CalidadProducto getCalidadProductoOriginal() {
		return this.calidadproductoOriginal;
	}
	
	public void setCalidadProductoOriginal(CalidadProducto calidadproducto) {
		try {
			this.calidadproductoOriginal=calidadproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CalidadProductoAdditional calidadproductoAdditional=null;
	
	public CalidadProductoAdditional getCalidadProductoAdditional() {
		return this.calidadproductoAdditional;
	}
	
	public void setCalidadProductoAdditional(CalidadProductoAdditional calidadproductoAdditional) {
		try {
			this.calidadproductoAdditional=calidadproductoAdditional;
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
						System.out.println("CalidadProducto:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("CalidadProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("CalidadProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CalidadProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Bodega> getBodegas() {
		return this.bodegas;
	}

	public List<ParametroInventarioDefecto> getParametroInventarioDefectos() {
		return this.parametroinventariodefectos;
	}

	
	
	public  void  setBodegas(List<Bodega> bodegas) {
		try {
			this.bodegas=bodegas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroInventarioDefectos(List<ParametroInventarioDefecto> parametroinventariodefectos) {
		try {
			this.parametroinventariodefectos=parametroinventariodefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object bodegasDescripcionReporte;
	Object parametroinventariodefectosDescripcionReporte;
	
	
	public Object getbodegasDescripcionReporte() {
		return bodegasDescripcionReporte;
	}

	public Object getparametroinventariodefectosDescripcionReporte() {
		return parametroinventariodefectosDescripcionReporte;
	}

	
	
	public  void  setbodegasDescripcionReporte(Object bodegas) {
		try {
			this.bodegasDescripcionReporte=bodegas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametroinventariodefectosDescripcionReporte(Object parametroinventariodefectos) {
		try {
			this.parametroinventariodefectosDescripcionReporte=parametroinventariodefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

