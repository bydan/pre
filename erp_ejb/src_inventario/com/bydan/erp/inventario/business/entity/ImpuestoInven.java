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
//import com.bydan.erp.inventario.util.ImpuestoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ImpuestoInven extends ImpuestoInvenAdditional implements Serializable ,Cloneable {//ImpuestoInvenAdditional,GeneralEntity
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
	
	private ImpuestoInven impuestoinvenOriginal;
	
	private Map<String, Object> mapImpuestoInven;
			
	public Map<String, Object> getMapImpuestoInven() {
		return mapImpuestoInven;
	}

	public void setMapImpuestoInven(Map<String, Object> mapImpuestoInven) {
		this.mapImpuestoInven = mapImpuestoInven;
	}
	
	public void inicializarMapImpuestoInven() {
		this.mapImpuestoInven = new HashMap<String,Object>();
	}
	
	public void setMapImpuestoInvenValue(String sKey,Object oValue) {
		this.mapImpuestoInven.put(sKey, oValue);
	}
	
	public Object getMapImpuestoInvenValue(String sKey) {
		return this.mapImpuestoInven.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ImpuestoInvenConstantesFunciones.SREGEXNOMBRE,message=ImpuestoInvenConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<ProductoImpuesto> productoimpuestos;
	public List<DetalleImpuestoInven> detalleimpuestoinvens;
		
	public ImpuestoInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.impuestoinvenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.productoimpuestos=null;
		this.detalleimpuestoinvens=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ImpuestoInven (Long id,Date versionRow,Long id_empresa,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.impuestoinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ImpuestoInven (Long id_empresa,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.impuestoinvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ImpuestoInven impuestoinvenLocal=null;
		
		if(object!=null) {
			impuestoinvenLocal=(ImpuestoInven)object;
			
			if(impuestoinvenLocal!=null) {
				if(this.getId()!=null && impuestoinvenLocal.getId()!=null) {
					if(this.getId().equals(impuestoinvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ImpuestoInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcion(this);
		} else {
			sDetalle=ImpuestoInvenConstantesFunciones.getImpuestoInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ImpuestoInven getImpuestoInvenOriginal() {
		return this.impuestoinvenOriginal;
	}
	
	public void setImpuestoInvenOriginal(ImpuestoInven impuestoinven) {
		try {
			this.impuestoinvenOriginal=impuestoinven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ImpuestoInvenAdditional impuestoinvenAdditional=null;
	
	public ImpuestoInvenAdditional getImpuestoInvenAdditional() {
		return this.impuestoinvenAdditional;
	}
	
	public void setImpuestoInvenAdditional(ImpuestoInvenAdditional impuestoinvenAdditional) {
		try {
			this.impuestoinvenAdditional=impuestoinvenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ImpuestoInven:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("ImpuestoInven:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("ImpuestoInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ProductoImpuesto> getProductoImpuestos() {
		return this.productoimpuestos;
	}

	public List<DetalleImpuestoInven> getDetalleImpuestoInvens() {
		return this.detalleimpuestoinvens;
	}

	
	
	public  void  setProductoImpuestos(List<ProductoImpuesto> productoimpuestos) {
		try {
			this.productoimpuestos=productoimpuestos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleImpuestoInvens(List<DetalleImpuestoInven> detalleimpuestoinvens) {
		try {
			this.detalleimpuestoinvens=detalleimpuestoinvens;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	Object productoimpuestosDescripcionReporte;
	Object detalleimpuestoinvensDescripcionReporte;
	
	
	public Object getproductoimpuestosDescripcionReporte() {
		return productoimpuestosDescripcionReporte;
	}

	public Object getdetalleimpuestoinvensDescripcionReporte() {
		return detalleimpuestoinvensDescripcionReporte;
	}

	
	
	public  void  setproductoimpuestosDescripcionReporte(Object productoimpuestos) {
		try {
			this.productoimpuestosDescripcionReporte=productoimpuestos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleimpuestoinvensDescripcionReporte(Object detalleimpuestoinvens) {
		try {
			this.detalleimpuestoinvensDescripcionReporte=detalleimpuestoinvens;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

