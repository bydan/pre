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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.TipoCambioConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.sris.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.sris.business.entity.*;




@SuppressWarnings("unused")
public class TipoCambio extends TipoCambioAdditional implements Serializable ,Cloneable {//TipoCambioAdditional,GeneralEntity
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
	
	private TipoCambio tipocambioOriginal;
	
	private Map<String, Object> mapTipoCambio;
			
	public Map<String, Object> getMapTipoCambio() {
		return mapTipoCambio;
	}

	public void setMapTipoCambio(Map<String, Object> mapTipoCambio) {
		this.mapTipoCambio = mapTipoCambio;
	}
	
	public void inicializarMapTipoCambio() {
		this.mapTipoCambio = new HashMap<String,Object>();
	}
	
	public void setMapTipoCambioValue(String sKey,Object oValue) {
		this.mapTipoCambio.put(sKey, oValue);
	}
	
	public Object getMapTipoCambioValue(String sKey) {
		return this.mapTipoCambio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Moneda moneda;
	
	
	private String empresa_descripcion;
	private String moneda_descripcion;
	
	
		
	public TipoCambio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipocambioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_moneda=-1L;
 		this.valor_compra=0.0;
 		this.valor_venta=0.0;
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.moneda=null;
		
		
		this.empresa_descripcion="";
		this.moneda_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoCambio (Long id,Date versionRow,Long id_empresa,Long id_moneda,Double valor_compra,Double valor_venta,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocambioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_moneda=id_moneda;
 		this.valor_compra=valor_compra;
 		this.valor_venta=valor_venta;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoCambio (Long id_empresa,Long id_moneda,Double valor_compra,Double valor_venta,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocambioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_moneda=id_moneda;
 		this.valor_compra=valor_compra;
 		this.valor_venta=valor_venta;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoCambio tipocambioLocal=null;
		
		if(object!=null) {
			tipocambioLocal=(TipoCambio)object;
			
			if(tipocambioLocal!=null) {
				if(this.getId()!=null && tipocambioLocal.getId()!=null) {
					if(this.getId().equals(tipocambioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoCambioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoCambioConstantesFunciones.getTipoCambioDescripcion(this);
		} else {
			sDetalle=TipoCambioConstantesFunciones.getTipoCambioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoCambio getTipoCambioOriginal() {
		return this.tipocambioOriginal;
	}
	
	public void setTipoCambioOriginal(TipoCambio tipocambio) {
		try {
			this.tipocambioOriginal=tipocambio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoCambioAdditional tipocambioAdditional=null;
	
	public TipoCambioAdditional getTipoCambioAdditional() {
		return this.tipocambioAdditional;
	}
	
	public void setTipoCambioAdditional(TipoCambioAdditional tipocambioAdditional) {
		try {
			this.tipocambioAdditional=tipocambioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Double getvalor_compra() {
		return this.valor_compra;
	}
    
	
	public Double getvalor_venta() {
		return this.valor_venta;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCambio:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCambio:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_compra(Double newvalor_compra)throws Exception
	{
		try {
			if(this.valor_compra!=newvalor_compra) {
				if(newvalor_compra==null) {
					//newvalor_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCambio:Valor nulo no permitido en columna valor_compra");
					}
				}

				this.valor_compra=newvalor_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_venta(Double newvalor_venta)throws Exception
	{
		try {
			if(this.valor_venta!=newvalor_venta) {
				if(newvalor_venta==null) {
					//newvalor_venta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCambio:Valor nulo no permitido en columna valor_venta");
					}
				}

				this.valor_venta=newvalor_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoCambio:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
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


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_moneda_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_moneda_descripcion="";
	}
	
	
	Object pedidocompraimporsDescripcionReporte;
	Object movimientoinventariosDescripcionReporte;
	Object autoripagoordencomprasDescripcionReporte;
	Object comprasDescripcionReporte;
	Object proformasDescripcionReporte;
	Object pedidocomprasDescripcionReporte;
	Object detalleasientocontablesDescripcionReporte;
	Object facturasDescripcionReporte;
	Object detalleasientocontablecajachicasDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object transferenciasDescripcionReporte;
	Object requisicioncomprasDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object ordencomprasDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	
	
	public Object getpedidocompraimporsDescripcionReporte() {
		return pedidocompraimporsDescripcionReporte;
	}

	public Object getmovimientoinventariosDescripcionReporte() {
		return movimientoinventariosDescripcionReporte;
	}

	public Object getautoripagoordencomprasDescripcionReporte() {
		return autoripagoordencomprasDescripcionReporte;
	}

	public Object getcomprasDescripcionReporte() {
		return comprasDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getpedidocomprasDescripcionReporte() {
		return pedidocomprasDescripcionReporte;
	}

	public Object getdetalleasientocontablesDescripcionReporte() {
		return detalleasientocontablesDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getdetalleasientocontablecajachicasDescripcionReporte() {
		return detalleasientocontablecajachicasDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object gettransferenciasDescripcionReporte() {
		return transferenciasDescripcionReporte;
	}

	public Object getrequisicioncomprasDescripcionReporte() {
		return requisicioncomprasDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getordencomprasDescripcionReporte() {
		return ordencomprasDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	
	
	public  void  setpedidocompraimporsDescripcionReporte(Object pedidocompraimpors) {
		try {
			this.pedidocompraimporsDescripcionReporte=pedidocompraimpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setmovimientoinventariosDescripcionReporte(Object movimientoinventarios) {
		try {
			this.movimientoinventariosDescripcionReporte=movimientoinventarios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setautoripagoordencomprasDescripcionReporte(Object autoripagoordencompras) {
		try {
			this.autoripagoordencomprasDescripcionReporte=autoripagoordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomprasDescripcionReporte(Object compras) {
		try {
			this.comprasDescripcionReporte=compras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidocomprasDescripcionReporte(Object pedidocompras) {
		try {
			this.pedidocomprasDescripcionReporte=pedidocompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablesDescripcionReporte(Object detalleasientocontables) {
		try {
			this.detalleasientocontablesDescripcionReporte=detalleasientocontables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleasientocontablecajachicasDescripcionReporte(Object detalleasientocontablecajachicas) {
		try {
			this.detalleasientocontablecajachicasDescripcionReporte=detalleasientocontablecajachicas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settransferenciasDescripcionReporte(Object transferencias) {
		try {
			this.transferenciasDescripcionReporte=transferencias;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrequisicioncomprasDescripcionReporte(Object requisicioncompras) {
		try {
			this.requisicioncomprasDescripcionReporte=requisicioncompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setguiaremisionsDescripcionReporte(Object guiaremisions) {
		try {
			this.guiaremisionsDescripcionReporte=guiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setordencomprasDescripcionReporte(Object ordencompras) {
		try {
			this.ordencomprasDescripcionReporte=ordencompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

