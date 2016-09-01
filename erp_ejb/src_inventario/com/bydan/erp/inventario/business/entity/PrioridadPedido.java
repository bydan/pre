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
//import com.bydan.erp.inventario.util.PrioridadPedidoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PrioridadPedido extends PrioridadPedidoAdditional implements Serializable ,Cloneable {//PrioridadPedidoAdditional,GeneralEntity
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
	
	private PrioridadPedido prioridadpedidoOriginal;
	
	private Map<String, Object> mapPrioridadPedido;
			
	public Map<String, Object> getMapPrioridadPedido() {
		return mapPrioridadPedido;
	}

	public void setMapPrioridadPedido(Map<String, Object> mapPrioridadPedido) {
		this.mapPrioridadPedido = mapPrioridadPedido;
	}
	
	public void inicializarMapPrioridadPedido() {
		this.mapPrioridadPedido = new HashMap<String,Object>();
	}
	
	public void setMapPrioridadPedidoValue(String sKey,Object oValue) {
		this.mapPrioridadPedido.put(sKey, oValue);
	}
	
	public Object getMapPrioridadPedidoValue(String sKey) {
		return this.mapPrioridadPedido.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PrioridadPedidoConstantesFunciones.SREGEXNOMBRE,message=PrioridadPedidoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public PrioridadPedido () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.prioridadpedidoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.dia=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PrioridadPedido (Long id,Date versionRow,Long id_empresa,String nombre,Integer dia) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prioridadpedidoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.dia=dia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PrioridadPedido (Long id_empresa,String nombre,Integer dia) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.prioridadpedidoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.dia=dia;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PrioridadPedido prioridadpedidoLocal=null;
		
		if(object!=null) {
			prioridadpedidoLocal=(PrioridadPedido)object;
			
			if(prioridadpedidoLocal!=null) {
				if(this.getId()!=null && prioridadpedidoLocal.getId()!=null) {
					if(this.getId().equals(prioridadpedidoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PrioridadPedidoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PrioridadPedidoConstantesFunciones.getPrioridadPedidoDescripcion(this);
		} else {
			sDetalle=PrioridadPedidoConstantesFunciones.getPrioridadPedidoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PrioridadPedido getPrioridadPedidoOriginal() {
		return this.prioridadpedidoOriginal;
	}
	
	public void setPrioridadPedidoOriginal(PrioridadPedido prioridadpedido) {
		try {
			this.prioridadpedidoOriginal=prioridadpedido;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PrioridadPedidoAdditional prioridadpedidoAdditional=null;
	
	public PrioridadPedidoAdditional getPrioridadPedidoAdditional() {
		return this.prioridadpedidoAdditional;
	}
	
	public void setPrioridadPedidoAdditional(PrioridadPedidoAdditional prioridadpedidoAdditional) {
		try {
			this.prioridadpedidoAdditional=prioridadpedidoAdditional;
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
    
	
	public Integer getdia() {
		return this.dia;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PrioridadPedido:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PrioridadPedido:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("PrioridadPedido:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia(Integer newdia)throws Exception
	{
		try {
			if(this.dia!=newdia) {
				if(newdia==null) {
					//newdia=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PrioridadPedido:Valor nulo no permitido en columna dia");
					}
				}

				this.dia=newdia;
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
	
	
	Object parametrocomprasDescripcionReporte;
	
	
	public Object getparametrocomprasDescripcionReporte() {
		return parametrocomprasDescripcionReporte;
	}

	
	
	public  void  setparametrocomprasDescripcionReporte(Object parametrocompras) {
		try {
			this.parametrocomprasDescripcionReporte=parametrocompras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

