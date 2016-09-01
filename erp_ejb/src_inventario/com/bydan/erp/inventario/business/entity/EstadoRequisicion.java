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
//import com.bydan.erp.inventario.util.EstadoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class EstadoRequisicion extends EstadoRequisicionAdditional implements Serializable ,Cloneable {//EstadoRequisicionAdditional,GeneralEntity
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
	
	private EstadoRequisicion estadorequisicionOriginal;
	
	private Map<String, Object> mapEstadoRequisicion;
			
	public Map<String, Object> getMapEstadoRequisicion() {
		return mapEstadoRequisicion;
	}

	public void setMapEstadoRequisicion(Map<String, Object> mapEstadoRequisicion) {
		this.mapEstadoRequisicion = mapEstadoRequisicion;
	}
	
	public void inicializarMapEstadoRequisicion() {
		this.mapEstadoRequisicion = new HashMap<String,Object>();
	}
	
	public void setMapEstadoRequisicionValue(String sKey,Object oValue) {
		this.mapEstadoRequisicion.put(sKey, oValue);
	}
	
	public Object getMapEstadoRequisicionValue(String sKey) {
		return this.mapEstadoRequisicion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoRequisicionConstantesFunciones.SREGEXCODIGO,message=EstadoRequisicionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoRequisicionConstantesFunciones.SREGEXNOMBRE,message=EstadoRequisicionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<RequisicionCompra> requisicioncompraCompras;
		
	public EstadoRequisicion () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadorequisicionOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.requisicioncompraCompras=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoRequisicion (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadorequisicionOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoRequisicion (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadorequisicionOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoRequisicion estadorequisicionLocal=null;
		
		if(object!=null) {
			estadorequisicionLocal=(EstadoRequisicion)object;
			
			if(estadorequisicionLocal!=null) {
				if(this.getId()!=null && estadorequisicionLocal.getId()!=null) {
					if(this.getId().equals(estadorequisicionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoRequisicionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcion(this);
		} else {
			sDetalle=EstadoRequisicionConstantesFunciones.getEstadoRequisicionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoRequisicion getEstadoRequisicionOriginal() {
		return this.estadorequisicionOriginal;
	}
	
	public void setEstadoRequisicionOriginal(EstadoRequisicion estadorequisicion) {
		try {
			this.estadorequisicionOriginal=estadorequisicion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstadoRequisicionAdditional estadorequisicionAdditional=null;
	
	public EstadoRequisicionAdditional getEstadoRequisicionAdditional() {
		return this.estadorequisicionAdditional;
	}
	
	public void setEstadoRequisicionAdditional(EstadoRequisicionAdditional estadorequisicionAdditional) {
		try {
			this.estadorequisicionAdditional=estadorequisicionAdditional;
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
						System.out.println("EstadoRequisicion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoRequisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("EstadoRequisicion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("EstadoRequisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<RequisicionCompra> getRequisicionCompraCompras() {
		return this.requisicioncompraCompras;
	}

	
	
	public  void  setRequisicionCompraCompras(List<RequisicionCompra> requisicioncompraCompras) {
		try {
			this.requisicioncompraCompras=requisicioncompraCompras;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object requisicionsDescripcionReporte;
	Object requisicioncompraComprasDescripcionReporte;
	
	
	public Object getrequisicionsDescripcionReporte() {
		return requisicionsDescripcionReporte;
	}

	public Object getrequisicioncompraComprasDescripcionReporte() {
		return requisicioncompraComprasDescripcionReporte;
	}

	
	
	public  void  setrequisicionsDescripcionReporte(Object requisicions) {
		try {
			this.requisicionsDescripcionReporte=requisicions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrequisicioncompraComprasDescripcionReporte(Object requisicioncompras) {
		try {
			this.requisicioncompraComprasDescripcionReporte=requisicioncompras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

