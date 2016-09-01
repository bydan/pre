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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.EstadoDetallePedidoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.inventario.util.*;



import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class EstadoDetallePedido extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//EstadoDetallePedidoAdditional,GeneralEntity
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
	
	private EstadoDetallePedido estadodetallepedidoOriginal;
	
	private Map<String, Object> mapEstadoDetallePedido;
			
	public Map<String, Object> getMapEstadoDetallePedido() {
		return mapEstadoDetallePedido;
	}

	public void setMapEstadoDetallePedido(Map<String, Object> mapEstadoDetallePedido) {
		this.mapEstadoDetallePedido = mapEstadoDetallePedido;
	}
	
	public void inicializarMapEstadoDetallePedido() {
		this.mapEstadoDetallePedido = new HashMap<String,Object>();
	}
	
	public void setMapEstadoDetallePedidoValue(String sKey,Object oValue) {
		this.mapEstadoDetallePedido.put(sKey, oValue);
	}
	
	public Object getMapEstadoDetallePedidoValue(String sKey) {
		return this.mapEstadoDetallePedido.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoDetallePedidoConstantesFunciones.SREGEXCODIGO,message=EstadoDetallePedidoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoDetallePedidoConstantesFunciones.SREGEXNOMBRE,message=EstadoDetallePedidoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<DetalleConsignacion> detalleconsignacions;
	public List<DetallePedidoExpor> detallepedidoexporExpors;
		
	public EstadoDetallePedido () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadodetallepedidoOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.detalleconsignacions=null;
		this.detallepedidoexporExpors=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoDetallePedido (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadodetallepedidoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoDetallePedido (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadodetallepedidoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoDetallePedido estadodetallepedidoLocal=null;
		
		if(object!=null) {
			estadodetallepedidoLocal=(EstadoDetallePedido)object;
			
			if(estadodetallepedidoLocal!=null) {
				if(this.getId()!=null && estadodetallepedidoLocal.getId()!=null) {
					if(this.getId().equals(estadodetallepedidoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoDetallePedidoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcion(this);
		} else {
			sDetalle=EstadoDetallePedidoConstantesFunciones.getEstadoDetallePedidoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoDetallePedido getEstadoDetallePedidoOriginal() {
		return this.estadodetallepedidoOriginal;
	}
	
	public void setEstadoDetallePedidoOriginal(EstadoDetallePedido estadodetallepedido) {
		try {
			this.estadodetallepedidoOriginal=estadodetallepedido;
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
						System.out.println("EstadoDetallePedido:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoDetallePedido:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadoDetallePedido:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("EstadoDetallePedido:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<DetalleConsignacion> getDetalleConsignacions() {
		return this.detalleconsignacions;
	}

	public List<DetallePedidoExpor> getDetallePedidoExporExpors() {
		return this.detallepedidoexporExpors;
	}

	
	
	public  void  setDetalleConsignacions(List<DetalleConsignacion> detalleconsignacions) {
		try {
			this.detalleconsignacions=detalleconsignacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetallePedidoExporExpors(List<DetallePedidoExpor> detallepedidoexporExpors) {
		try {
			this.detallepedidoexporExpors=detallepedidoexporExpors;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object detalleconsignacionsDescripcionReporte;
	Object detallepedidosDescripcionReporte;
	Object detallepedidoexporExporsDescripcionReporte;
	
	
	public Object getdetalleconsignacionsDescripcionReporte() {
		return detalleconsignacionsDescripcionReporte;
	}

	public Object getdetallepedidosDescripcionReporte() {
		return detallepedidosDescripcionReporte;
	}

	public Object getdetallepedidoexporExporsDescripcionReporte() {
		return detallepedidoexporExporsDescripcionReporte;
	}

	
	
	public  void  setdetalleconsignacionsDescripcionReporte(Object detalleconsignacions) {
		try {
			this.detalleconsignacionsDescripcionReporte=detalleconsignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallepedidosDescripcionReporte(Object detallepedidos) {
		try {
			this.detallepedidosDescripcionReporte=detallepedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallepedidoexporExporsDescripcionReporte(Object detallepedidoexpors) {
		try {
			this.detallepedidoexporExporsDescripcionReporte=detallepedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

