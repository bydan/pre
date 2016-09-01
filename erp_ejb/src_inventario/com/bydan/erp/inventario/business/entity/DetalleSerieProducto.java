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
//import com.bydan.erp.inventario.util.DetalleSerieProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;









@SuppressWarnings("unused")
public class DetalleSerieProducto extends DetalleSerieProductoAdditional implements Serializable ,Cloneable {//DetalleSerieProductoAdditional,GeneralEntity
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
	
	private DetalleSerieProducto detalleserieproductoOriginal;
	
	private Map<String, Object> mapDetalleSerieProducto;
			
	public Map<String, Object> getMapDetalleSerieProducto() {
		return mapDetalleSerieProducto;
	}

	public void setMapDetalleSerieProducto(Map<String, Object> mapDetalleSerieProducto) {
		this.mapDetalleSerieProducto = mapDetalleSerieProducto;
	}
	
	public void inicializarMapDetalleSerieProducto() {
		this.mapDetalleSerieProducto = new HashMap<String,Object>();
	}
	
	public void setMapDetalleSerieProductoValue(String sKey,Object oValue) {
		this.mapDetalleSerieProducto.put(sKey, oValue);
	}
	
	public Object getMapDetalleSerieProductoValue(String sKey) {
		return this.mapDetalleSerieProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_serie_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleSerieProductoConstantesFunciones.SREGEXNOMBRE,message=DetalleSerieProductoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleSerieProductoConstantesFunciones.SREGEXDESCRIPCION,message=DetalleSerieProductoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public SerieProducto serieproducto;
	
	
	private String serieproducto_descripcion;
	
	
		
	public DetalleSerieProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleserieproductoOriginal=this;
		
 		this.id_serie_producto=-1L;
 		this.nombre="";
 		this.descripcion="";
		
		
		this.serieproducto=null;
		
		
		this.serieproducto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleSerieProducto (Long id,Date versionRow,Long id_serie_producto,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleserieproductoOriginal=this;
		
 		this.id_serie_producto=id_serie_producto;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleSerieProducto (Long id_serie_producto,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleserieproductoOriginal=this;
		
 		this.id_serie_producto=id_serie_producto;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleSerieProducto detalleserieproductoLocal=null;
		
		if(object!=null) {
			detalleserieproductoLocal=(DetalleSerieProducto)object;
			
			if(detalleserieproductoLocal!=null) {
				if(this.getId()!=null && detalleserieproductoLocal.getId()!=null) {
					if(this.getId().equals(detalleserieproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleSerieProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleSerieProductoConstantesFunciones.getDetalleSerieProductoDescripcion(this);
		} else {
			sDetalle=DetalleSerieProductoConstantesFunciones.getDetalleSerieProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleSerieProducto getDetalleSerieProductoOriginal() {
		return this.detalleserieproductoOriginal;
	}
	
	public void setDetalleSerieProductoOriginal(DetalleSerieProducto detalleserieproducto) {
		try {
			this.detalleserieproductoOriginal=detalleserieproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleSerieProductoAdditional detalleserieproductoAdditional=null;
	
	public DetalleSerieProductoAdditional getDetalleSerieProductoAdditional() {
		return this.detalleserieproductoAdditional;
	}
	
	public void setDetalleSerieProductoAdditional(DetalleSerieProductoAdditional detalleserieproductoAdditional) {
		try {
			this.detalleserieproductoAdditional=detalleserieproductoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_serie_producto() {
		return this.id_serie_producto;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_serie_producto(Long newid_serie_producto)throws Exception
	{
		try {
			if(this.id_serie_producto!=newid_serie_producto) {
				if(newid_serie_producto==null) {
					//newid_serie_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleSerieProducto:Valor nulo no permitido en columna id_serie_producto");
					}
				}

				this.id_serie_producto=newid_serie_producto;
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
						System.out.println("DetalleSerieProducto:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("DetalleSerieProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("DetalleSerieProducto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("DetalleSerieProducto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public SerieProducto getSerieProducto() {
		return this.serieproducto;
	}

	
	
	public String getserieproducto_descripcion() {
		return this.serieproducto_descripcion;
	}

	
	
	public  void  setSerieProducto(SerieProducto serieproducto) {
		try {
			this.serieproducto=serieproducto;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setserieproducto_descripcion(String serieproducto_descripcion) {
		try {
			this.serieproducto_descripcion=serieproducto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_serie_producto_descripcion="";
	
	
	public String getid_serie_producto_descripcion() {
		return id_serie_producto_descripcion;
	}
	
	
	public void setid_serie_producto_descripcion(String newid_serie_producto_descripcion)throws Exception {
		try {
			this.id_serie_producto_descripcion=newid_serie_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_serie_producto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

