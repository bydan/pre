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
//import com.bydan.erp.cartera.util.DetalleRecapConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DetalleRecap extends DetalleRecapAdditional implements Serializable ,Cloneable {//DetalleRecapAdditional,GeneralEntity
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
	
	private DetalleRecap detallerecapOriginal;
	
	private Map<String, Object> mapDetalleRecap;
			
	public Map<String, Object> getMapDetalleRecap() {
		return mapDetalleRecap;
	}

	public void setMapDetalleRecap(Map<String, Object> mapDetalleRecap) {
		this.mapDetalleRecap = mapDetalleRecap;
	}
	
	public void inicializarMapDetalleRecap() {
		this.mapDetalleRecap = new HashMap<String,Object>();
	}
	
	public void setMapDetalleRecapValue(String sKey,Object oValue) {
		this.mapDetalleRecap.put(sKey, oValue);
	}
	
	public Object getMapDetalleRecapValue(String sKey) {
		return this.mapDetalleRecap.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_recap;
	
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Recap recap;
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public DetalleCliente detallecliente;
	public Cliente cliente;
	
	
	private String recap_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String detallecliente_descripcion;
	private String cliente_descripcion;
	
	
		
	public DetalleRecap () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detallerecapOriginal=this;
		
 		this.id_recap=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_detalle_cliente=-1L;
 		this.id_cliente=-1L;
 		this.valor=0.0;
 		this.iva_porcentaje=0.0;
 		this.total=0.0;
		
		
		this.recap=null;
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.detallecliente=null;
		this.cliente=null;
		
		
		this.recap_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.detallecliente_descripcion="";
		this.cliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleRecap (Long id,Date versionRow,Long id_recap,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_detalle_cliente,Long id_cliente,Double valor,Double iva_porcentaje,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallerecapOriginal=this;
		
 		this.id_recap=id_recap;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_detalle_cliente=id_detalle_cliente;
 		this.id_cliente=id_cliente;
 		this.valor=valor;
 		this.iva_porcentaje=iva_porcentaje;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleRecap (Long id_recap,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_detalle_cliente,Long id_cliente,Double valor,Double iva_porcentaje,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detallerecapOriginal=this;
		
 		this.id_recap=id_recap;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_detalle_cliente=id_detalle_cliente;
 		this.id_cliente=id_cliente;
 		this.valor=valor;
 		this.iva_porcentaje=iva_porcentaje;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleRecap detallerecapLocal=null;
		
		if(object!=null) {
			detallerecapLocal=(DetalleRecap)object;
			
			if(detallerecapLocal!=null) {
				if(this.getId()!=null && detallerecapLocal.getId()!=null) {
					if(this.getId().equals(detallerecapLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleRecapConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleRecapConstantesFunciones.getDetalleRecapDescripcion(this);
		} else {
			sDetalle=DetalleRecapConstantesFunciones.getDetalleRecapDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleRecap getDetalleRecapOriginal() {
		return this.detallerecapOriginal;
	}
	
	public void setDetalleRecapOriginal(DetalleRecap detallerecap) {
		try {
			this.detallerecapOriginal=detallerecap;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleRecapAdditional detallerecapAdditional=null;
	
	public DetalleRecapAdditional getDetalleRecapAdditional() {
		return this.detallerecapAdditional;
	}
	
	public void setDetalleRecapAdditional(DetalleRecapAdditional detallerecapAdditional) {
		try {
			this.detallerecapAdditional=detallerecapAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_recap() {
		return this.id_recap;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_detalle_cliente() {
		return this.id_detalle_cliente;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Double getiva_porcentaje() {
		return this.iva_porcentaje;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_recap(Long newid_recap)throws Exception
	{
		try {
			if(this.id_recap!=newid_recap) {
				if(newid_recap==null) {
					//newid_recap=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_recap");
					}
				}

				this.id_recap=newid_recap;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_cliente(Long newid_detalle_cliente)throws Exception
	{
		try {
			if(this.id_detalle_cliente!=newid_detalle_cliente) {
				if(newid_detalle_cliente==null) {
					//newid_detalle_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_detalle_cliente");
					}
				}

				this.id_detalle_cliente=newid_detalle_cliente;
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
						System.out.println("DetalleRecap:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva_porcentaje(Double newiva_porcentaje)throws Exception
	{
		try {
			if(this.iva_porcentaje!=newiva_porcentaje) {
				if(newiva_porcentaje==null) {
					//newiva_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna iva_porcentaje");
					}
				}

				this.iva_porcentaje=newiva_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal(Double newtotal)throws Exception
	{
		try {
			if(this.total!=newtotal) {
				if(newtotal==null) {
					//newtotal=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleRecap:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Recap getRecap() {
		return this.recap;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public DetalleCliente getDetalleCliente() {
		return this.detallecliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	
	
	public String getrecap_descripcion() {
		return this.recap_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getdetallecliente_descripcion() {
		return this.detallecliente_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	
	
	public  void  setRecap(Recap recap) {
		try {
			this.recap=recap;
		} catch(Exception e) {
			;
		}
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


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleCliente(DetalleCliente detallecliente) {
		try {
			this.detallecliente=detallecliente;
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


	
	
	public  void  setrecap_descripcion(String recap_descripcion) {
		try {
			this.recap_descripcion=recap_descripcion;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetallecliente_descripcion(String detallecliente_descripcion) {
		try {
			this.detallecliente_descripcion=detallecliente_descripcion;
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
	String id_recap_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_detalle_cliente_descripcion="";String id_cliente_descripcion="";
	
	
	public String getid_recap_descripcion() {
		return id_recap_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_detalle_cliente_descripcion() {
		return id_detalle_cliente_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	
	
	public void setid_recap_descripcion(String newid_recap_descripcion)throws Exception {
		try {
			this.id_recap_descripcion=newid_recap_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_detalle_cliente_descripcion(String newid_detalle_cliente_descripcion)throws Exception {
		try {
			this.id_detalle_cliente_descripcion=newid_detalle_cliente_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_recap_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_detalle_cliente_descripcion="";this.id_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

