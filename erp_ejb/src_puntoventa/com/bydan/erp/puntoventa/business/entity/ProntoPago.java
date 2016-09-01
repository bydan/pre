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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.ProntoPagoConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ProntoPago extends ProntoPagoAdditional implements Serializable ,Cloneable {//ProntoPagoAdditional,GeneralEntity
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
	
	private ProntoPago prontopagoOriginal;
	
	private Map<String, Object> mapProntoPago;
			
	public Map<String, Object> getMapProntoPago() {
		return mapProntoPago;
	}

	public void setMapProntoPago(Map<String, Object> mapProntoPago) {
		this.mapProntoPago = mapProntoPago;
	}
	
	public void inicializarMapProntoPago() {
		this.mapProntoPago = new HashMap<String,Object>();
	}
	
	public void setMapProntoPagoValue(String sKey,Object oValue) {
		this.mapProntoPago.put(sKey, oValue);
	}
	
	public Object getMapProntoPagoValue(String sKey) {
		return this.mapProntoPago.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_descuento;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ProntoPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.prontopagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.dia_inicio=0;
 		this.dia_fin=0;
 		this.porcentaje_descuento=0.0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProntoPago (Long id,Date versionRow,Long id_empresa,Integer dia_inicio,Integer dia_fin,Double porcentaje_descuento) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prontopagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.dia_inicio=dia_inicio;
 		this.dia_fin=dia_fin;
 		this.porcentaje_descuento=porcentaje_descuento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProntoPago (Long id_empresa,Integer dia_inicio,Integer dia_fin,Double porcentaje_descuento) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prontopagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.dia_inicio=dia_inicio;
 		this.dia_fin=dia_fin;
 		this.porcentaje_descuento=porcentaje_descuento;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProntoPago prontopagoLocal=null;
		
		if(object!=null) {
			prontopagoLocal=(ProntoPago)object;
			
			if(prontopagoLocal!=null) {
				if(this.getId()!=null && prontopagoLocal.getId()!=null) {
					if(this.getId().equals(prontopagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProntoPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProntoPagoConstantesFunciones.getProntoPagoDescripcion(this);
		} else {
			sDetalle=ProntoPagoConstantesFunciones.getProntoPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProntoPago getProntoPagoOriginal() {
		return this.prontopagoOriginal;
	}
	
	public void setProntoPagoOriginal(ProntoPago prontopago) {
		try {
			this.prontopagoOriginal=prontopago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProntoPagoAdditional prontopagoAdditional=null;
	
	public ProntoPagoAdditional getProntoPagoAdditional() {
		return this.prontopagoAdditional;
	}
	
	public void setProntoPagoAdditional(ProntoPagoAdditional prontopagoAdditional) {
		try {
			this.prontopagoAdditional=prontopagoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Integer getdia_inicio() {
		return this.dia_inicio;
	}
    
	
	public Integer getdia_fin() {
		return this.dia_fin;
	}
    
	
	public Double getporcentaje_descuento() {
		return this.porcentaje_descuento;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProntoPago:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_inicio(Integer newdia_inicio)throws Exception
	{
		try {
			if(this.dia_inicio!=newdia_inicio) {
				if(newdia_inicio==null) {
					//newdia_inicio=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProntoPago:Valor nulo no permitido en columna dia_inicio");
					}
				}

				this.dia_inicio=newdia_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_fin(Integer newdia_fin)throws Exception
	{
		try {
			if(this.dia_fin!=newdia_fin) {
				if(newdia_fin==null) {
					//newdia_fin=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProntoPago:Valor nulo no permitido en columna dia_fin");
					}
				}

				this.dia_fin=newdia_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_descuento(Double newporcentaje_descuento)throws Exception
	{
		try {
			if(this.porcentaje_descuento!=newporcentaje_descuento) {
				if(newporcentaje_descuento==null) {
					//newporcentaje_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProntoPago:Valor nulo no permitido en columna porcentaje_descuento");
					}
				}

				this.porcentaje_descuento=newporcentaje_descuento;
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
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

