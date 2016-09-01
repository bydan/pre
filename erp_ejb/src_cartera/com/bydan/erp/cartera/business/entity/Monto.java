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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.MontoConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Monto extends MontoAdditional implements Serializable ,Cloneable {//MontoAdditional,GeneralEntity
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
	
	private Monto montoOriginal;
	
	private Map<String, Object> mapMonto;
			
	public Map<String, Object> getMapMonto() {
		return mapMonto;
	}

	public void setMapMonto(Map<String, Object> mapMonto) {
		this.mapMonto = mapMonto;
	}
	
	public void inicializarMapMonto() {
		this.mapMonto = new HashMap<String,Object>();
	}
	
	public void setMapMontoValue(String sKey,Object oValue) {
		this.mapMonto.put(sKey, oValue);
	}
	
	public Object getMapMontoValue(String sKey) {
		return this.mapMonto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cuota;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_general;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	
	
		
	public Monto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.montoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.valor_inicio=0.0;
 		this.valor_fin=0.0;
 		this.numero_dias=0;
 		this.numero_cuota=0;
 		this.es_general=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Monto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_cliente,Double valor_inicio,Double valor_fin,Integer numero_dias,Integer numero_cuota,Boolean es_general) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.montoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.valor_inicio=valor_inicio;
 		this.valor_fin=valor_fin;
 		this.numero_dias=numero_dias;
 		this.numero_cuota=numero_cuota;
 		this.es_general=es_general;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Monto (Long id_empresa,Long id_sucursal,Long id_cliente,Double valor_inicio,Double valor_fin,Integer numero_dias,Integer numero_cuota,Boolean es_general) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.montoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_cliente=id_cliente;
 		this.valor_inicio=valor_inicio;
 		this.valor_fin=valor_fin;
 		this.numero_dias=numero_dias;
 		this.numero_cuota=numero_cuota;
 		this.es_general=es_general;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Monto montoLocal=null;
		
		if(object!=null) {
			montoLocal=(Monto)object;
			
			if(montoLocal!=null) {
				if(this.getId()!=null && montoLocal.getId()!=null) {
					if(this.getId().equals(montoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!MontoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=MontoConstantesFunciones.getMontoDescripcion(this);
		} else {
			sDetalle=MontoConstantesFunciones.getMontoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Monto getMontoOriginal() {
		return this.montoOriginal;
	}
	
	public void setMontoOriginal(Monto monto) {
		try {
			this.montoOriginal=monto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MontoAdditional montoAdditional=null;
	
	public MontoAdditional getMontoAdditional() {
		return this.montoAdditional;
	}
	
	public void setMontoAdditional(MontoAdditional montoAdditional) {
		try {
			this.montoAdditional=montoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Double getvalor_inicio() {
		return this.valor_inicio;
	}
    
	
	public Double getvalor_fin() {
		return this.valor_fin;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
    
	
	public Integer getnumero_cuota() {
		return this.numero_cuota;
	}
    
	
	public Boolean getes_general() {
		return this.es_general;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_inicio(Double newvalor_inicio)throws Exception
	{
		try {
			if(this.valor_inicio!=newvalor_inicio) {
				if(newvalor_inicio==null) {
					//newvalor_inicio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna valor_inicio");
					}
				}

				this.valor_inicio=newvalor_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_fin(Double newvalor_fin)throws Exception
	{
		try {
			if(this.valor_fin!=newvalor_fin) {
				if(newvalor_fin==null) {
					//newvalor_fin=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna valor_fin");
					}
				}

				this.valor_fin=newvalor_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuota(Integer newnumero_cuota)throws Exception
	{
		try {
			if(this.numero_cuota!=newnumero_cuota) {
				if(newnumero_cuota==null) {
					//newnumero_cuota=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna numero_cuota");
					}
				}

				this.numero_cuota=newnumero_cuota;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_general(Boolean newes_general)throws Exception
	{
		try {
			if(this.es_general!=newes_general) {
				if(newes_general==null) {
					//newes_general=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Monto:Valor nulo no permitido en columna es_general");
					}
				}

				this.es_general=newes_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String es_general_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_general_descripcion() {
		return es_general_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_general_descripcion(String newes_general_descripcion)throws Exception {
		try {
			this.es_general_descripcion=newes_general_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.es_general_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

