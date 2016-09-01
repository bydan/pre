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
package com.bydan.erp.produccion.business.entity;

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
//import com.bydan.erp.produccion.util.TipoGastoProduEmpresaConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class TipoGastoProduEmpresa extends TipoGastoProduEmpresaAdditional implements Serializable ,Cloneable {//TipoGastoProduEmpresaAdditional,GeneralEntity
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
	
	private TipoGastoProduEmpresa tipogastoproduempresaOriginal;
	
	private Map<String, Object> mapTipoGastoProduEmpresa;
			
	public Map<String, Object> getMapTipoGastoProduEmpresa() {
		return mapTipoGastoProduEmpresa;
	}

	public void setMapTipoGastoProduEmpresa(Map<String, Object> mapTipoGastoProduEmpresa) {
		this.mapTipoGastoProduEmpresa = mapTipoGastoProduEmpresa;
	}
	
	public void inicializarMapTipoGastoProduEmpresa() {
		this.mapTipoGastoProduEmpresa = new HashMap<String,Object>();
	}
	
	public void setMapTipoGastoProduEmpresaValue(String sKey,Object oValue) {
		this.mapTipoGastoProduEmpresa.put(sKey, oValue);
	}
	
	public Object getMapTipoGastoProduEmpresaValue(String sKey) {
		return this.mapTipoGastoProduEmpresa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGastoProduEmpresaConstantesFunciones.SREGEXNOMBRE,message=TipoGastoProduEmpresaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoGastoProduEmpresaConstantesFunciones.SREGEXDESCRIPCION,message=TipoGastoProduEmpresaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public TipoGastoProduEmpresa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipogastoproduempresaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoGastoProduEmpresa (Long id,Date versionRow,Long id_empresa,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogastoproduempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoGastoProduEmpresa (Long id_empresa,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipogastoproduempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoGastoProduEmpresa tipogastoproduempresaLocal=null;
		
		if(object!=null) {
			tipogastoproduempresaLocal=(TipoGastoProduEmpresa)object;
			
			if(tipogastoproduempresaLocal!=null) {
				if(this.getId()!=null && tipogastoproduempresaLocal.getId()!=null) {
					if(this.getId().equals(tipogastoproduempresaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoGastoProduEmpresaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcion(this);
		} else {
			sDetalle=TipoGastoProduEmpresaConstantesFunciones.getTipoGastoProduEmpresaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoGastoProduEmpresa getTipoGastoProduEmpresaOriginal() {
		return this.tipogastoproduempresaOriginal;
	}
	
	public void setTipoGastoProduEmpresaOriginal(TipoGastoProduEmpresa tipogastoproduempresa) {
		try {
			this.tipogastoproduempresaOriginal=tipogastoproduempresa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoGastoProduEmpresaAdditional tipogastoproduempresaAdditional=null;
	
	public TipoGastoProduEmpresaAdditional getTipoGastoProduEmpresaAdditional() {
		return this.tipogastoproduempresaAdditional;
	}
	
	public void setTipoGastoProduEmpresaAdditional(TipoGastoProduEmpresaAdditional tipogastoproduempresaAdditional) {
		try {
			this.tipogastoproduempresaAdditional=tipogastoproduempresaAdditional;
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
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoGastoProduEmpresa:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TipoGastoProduEmpresa:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoGastoProduEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("TipoGastoProduEmpresa:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("TipoGastoProduEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
	
	
	Object productoordendetaprodugastosDescripcionReporte;
	Object productoprodugastosDescripcionReporte;
	
	
	public Object getproductoordendetaprodugastosDescripcionReporte() {
		return productoordendetaprodugastosDescripcionReporte;
	}

	public Object getproductoprodugastosDescripcionReporte() {
		return productoprodugastosDescripcionReporte;
	}

	
	
	public  void  setproductoordendetaprodugastosDescripcionReporte(Object productoordendetaprodugastos) {
		try {
			this.productoordendetaprodugastosDescripcionReporte=productoordendetaprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoprodugastosDescripcionReporte(Object productoprodugastos) {
		try {
			this.productoprodugastosDescripcionReporte=productoprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

