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
//import com.bydan.erp.facturacion.util.ParametroFactuTransaccionConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFactuTransaccion extends ParametroFactuTransaccionAdditional implements Serializable ,Cloneable {//ParametroFactuTransaccionAdditional,GeneralEntity
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
	
	private ParametroFactuTransaccion parametrofactutransaccionOriginal;
	
	private Map<String, Object> mapParametroFactuTransaccion;
			
	public Map<String, Object> getMapParametroFactuTransaccion() {
		return mapParametroFactuTransaccion;
	}

	public void setMapParametroFactuTransaccion(Map<String, Object> mapParametroFactuTransaccion) {
		this.mapParametroFactuTransaccion = mapParametroFactuTransaccion;
	}
	
	public void inicializarMapParametroFactuTransaccion() {
		this.mapParametroFactuTransaccion = new HashMap<String,Object>();
	}
	
	public void setMapParametroFactuTransaccionValue(String sKey,Object oValue) {
		this.mapParametroFactuTransaccion.put(sKey, oValue);
	}
	
	public Object getMapParametroFactuTransaccionValue(String sKey) {
		return this.mapParametroFactuTransaccion.get(sKey);
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
	private Long id_transaccion_inven_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_inven_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_inven_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_co_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_co_nota_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_co_nota_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_co_tarjeta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_pa_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_cuenta_pa_nota_credito;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Transaccion transaccioninvenfactura;
	public Transaccion transaccioninvennotacredito;
	public Transaccion transaccioninvennotaventa;
	public Transaccion transaccioncuentacofactura;
	public Transaccion transaccioncuentaconotacredito;
	public Transaccion transaccioncuentaconotaventa;
	public Transaccion transaccioncuentacotarjeta;
	public Transaccion transaccioncuentapafactura;
	public Transaccion transaccioncuentapanotacredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String transaccioninvenfactura_descripcion;
	private String transaccioninvennotacredito_descripcion;
	private String transaccioninvennotaventa_descripcion;
	private String transaccioncuentacofactura_descripcion;
	private String transaccioncuentaconotacredito_descripcion;
	private String transaccioncuentaconotaventa_descripcion;
	private String transaccioncuentacotarjeta_descripcion;
	private String transaccioncuentapafactura_descripcion;
	private String transaccioncuentapanotacredito_descripcion;
	
	
		
	public ParametroFactuTransaccion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofactutransaccionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_transaccion_inven_factura=-1L;
 		this.id_transaccion_inven_nota_credito=-1L;
 		this.id_transaccion_inven_nota_venta=-1L;
 		this.id_transaccion_cuenta_co_factura=-1L;
 		this.id_transaccion_cuenta_co_nota_credito=-1L;
 		this.id_transaccion_cuenta_co_nota_venta=-1L;
 		this.id_transaccion_cuenta_co_tarjeta=-1L;
 		this.id_transaccion_cuenta_pa_factura=-1L;
 		this.id_transaccion_cuenta_pa_nota_credito=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.transaccioninvenfactura=null;
		this.transaccioninvennotacredito=null;
		this.transaccioninvennotaventa=null;
		this.transaccioncuentacofactura=null;
		this.transaccioncuentaconotacredito=null;
		this.transaccioncuentaconotaventa=null;
		this.transaccioncuentacotarjeta=null;
		this.transaccioncuentapafactura=null;
		this.transaccioncuentapanotacredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.transaccioninvenfactura_descripcion="";
		this.transaccioninvennotacredito_descripcion="";
		this.transaccioninvennotaventa_descripcion="";
		this.transaccioncuentacofactura_descripcion="";
		this.transaccioncuentaconotacredito_descripcion="";
		this.transaccioncuentaconotaventa_descripcion="";
		this.transaccioncuentacotarjeta_descripcion="";
		this.transaccioncuentapafactura_descripcion="";
		this.transaccioncuentapanotacredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFactuTransaccion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_transaccion_inven_factura,Long id_transaccion_inven_nota_credito,Long id_transaccion_inven_nota_venta,Long id_transaccion_cuenta_co_factura,Long id_transaccion_cuenta_co_nota_credito,Long id_transaccion_cuenta_co_nota_venta,Long id_transaccion_cuenta_co_tarjeta,Long id_transaccion_cuenta_pa_factura,Long id_transaccion_cuenta_pa_nota_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactutransaccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_transaccion_inven_factura=id_transaccion_inven_factura;
 		this.id_transaccion_inven_nota_credito=id_transaccion_inven_nota_credito;
 		this.id_transaccion_inven_nota_venta=id_transaccion_inven_nota_venta;
 		this.id_transaccion_cuenta_co_factura=id_transaccion_cuenta_co_factura;
 		this.id_transaccion_cuenta_co_nota_credito=id_transaccion_cuenta_co_nota_credito;
 		this.id_transaccion_cuenta_co_nota_venta=id_transaccion_cuenta_co_nota_venta;
 		this.id_transaccion_cuenta_co_tarjeta=id_transaccion_cuenta_co_tarjeta;
 		this.id_transaccion_cuenta_pa_factura=id_transaccion_cuenta_pa_factura;
 		this.id_transaccion_cuenta_pa_nota_credito=id_transaccion_cuenta_pa_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFactuTransaccion (Long id_empresa,Long id_sucursal,Long id_transaccion_inven_factura,Long id_transaccion_inven_nota_credito,Long id_transaccion_inven_nota_venta,Long id_transaccion_cuenta_co_factura,Long id_transaccion_cuenta_co_nota_credito,Long id_transaccion_cuenta_co_nota_venta,Long id_transaccion_cuenta_co_tarjeta,Long id_transaccion_cuenta_pa_factura,Long id_transaccion_cuenta_pa_nota_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactutransaccionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_transaccion_inven_factura=id_transaccion_inven_factura;
 		this.id_transaccion_inven_nota_credito=id_transaccion_inven_nota_credito;
 		this.id_transaccion_inven_nota_venta=id_transaccion_inven_nota_venta;
 		this.id_transaccion_cuenta_co_factura=id_transaccion_cuenta_co_factura;
 		this.id_transaccion_cuenta_co_nota_credito=id_transaccion_cuenta_co_nota_credito;
 		this.id_transaccion_cuenta_co_nota_venta=id_transaccion_cuenta_co_nota_venta;
 		this.id_transaccion_cuenta_co_tarjeta=id_transaccion_cuenta_co_tarjeta;
 		this.id_transaccion_cuenta_pa_factura=id_transaccion_cuenta_pa_factura;
 		this.id_transaccion_cuenta_pa_nota_credito=id_transaccion_cuenta_pa_nota_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFactuTransaccion parametrofactutransaccionLocal=null;
		
		if(object!=null) {
			parametrofactutransaccionLocal=(ParametroFactuTransaccion)object;
			
			if(parametrofactutransaccionLocal!=null) {
				if(this.getId()!=null && parametrofactutransaccionLocal.getId()!=null) {
					if(this.getId().equals(parametrofactutransaccionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFactuTransaccionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFactuTransaccionConstantesFunciones.getParametroFactuTransaccionDescripcion(this);
		} else {
			sDetalle=ParametroFactuTransaccionConstantesFunciones.getParametroFactuTransaccionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFactuTransaccion getParametroFactuTransaccionOriginal() {
		return this.parametrofactutransaccionOriginal;
	}
	
	public void setParametroFactuTransaccionOriginal(ParametroFactuTransaccion parametrofactutransaccion) {
		try {
			this.parametrofactutransaccionOriginal=parametrofactutransaccion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFactuTransaccionAdditional parametrofactutransaccionAdditional=null;
	
	public ParametroFactuTransaccionAdditional getParametroFactuTransaccionAdditional() {
		return this.parametrofactutransaccionAdditional;
	}
	
	public void setParametroFactuTransaccionAdditional(ParametroFactuTransaccionAdditional parametrofactutransaccionAdditional) {
		try {
			this.parametrofactutransaccionAdditional=parametrofactutransaccionAdditional;
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
    
	
	public Long getid_transaccion_inven_factura() {
		return this.id_transaccion_inven_factura;
	}
    
	
	public Long getid_transaccion_inven_nota_credito() {
		return this.id_transaccion_inven_nota_credito;
	}
    
	
	public Long getid_transaccion_inven_nota_venta() {
		return this.id_transaccion_inven_nota_venta;
	}
    
	
	public Long getid_transaccion_cuenta_co_factura() {
		return this.id_transaccion_cuenta_co_factura;
	}
    
	
	public Long getid_transaccion_cuenta_co_nota_credito() {
		return this.id_transaccion_cuenta_co_nota_credito;
	}
    
	
	public Long getid_transaccion_cuenta_co_nota_venta() {
		return this.id_transaccion_cuenta_co_nota_venta;
	}
    
	
	public Long getid_transaccion_cuenta_co_tarjeta() {
		return this.id_transaccion_cuenta_co_tarjeta;
	}
    
	
	public Long getid_transaccion_cuenta_pa_factura() {
		return this.id_transaccion_cuenta_pa_factura;
	}
    
	
	public Long getid_transaccion_cuenta_pa_nota_credito() {
		return this.id_transaccion_cuenta_pa_nota_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_inven_factura(Long newid_transaccion_inven_factura)throws Exception
	{
		try {
			if(this.id_transaccion_inven_factura!=newid_transaccion_inven_factura) {
				if(newid_transaccion_inven_factura==null) {
					//newid_transaccion_inven_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_inven_factura");
					}
				}

				this.id_transaccion_inven_factura=newid_transaccion_inven_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_inven_nota_credito(Long newid_transaccion_inven_nota_credito)throws Exception
	{
		try {
			if(this.id_transaccion_inven_nota_credito!=newid_transaccion_inven_nota_credito) {
				if(newid_transaccion_inven_nota_credito==null) {
					//newid_transaccion_inven_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_inven_nota_credito");
					}
				}

				this.id_transaccion_inven_nota_credito=newid_transaccion_inven_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_inven_nota_venta(Long newid_transaccion_inven_nota_venta)throws Exception
	{
		try {
			if(this.id_transaccion_inven_nota_venta!=newid_transaccion_inven_nota_venta) {
				if(newid_transaccion_inven_nota_venta==null) {
					//newid_transaccion_inven_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_inven_nota_venta");
					}
				}

				this.id_transaccion_inven_nota_venta=newid_transaccion_inven_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_co_factura(Long newid_transaccion_cuenta_co_factura)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_co_factura!=newid_transaccion_cuenta_co_factura) {
				if(newid_transaccion_cuenta_co_factura==null) {
					//newid_transaccion_cuenta_co_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_co_factura");
					}
				}

				this.id_transaccion_cuenta_co_factura=newid_transaccion_cuenta_co_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_co_nota_credito(Long newid_transaccion_cuenta_co_nota_credito)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_co_nota_credito!=newid_transaccion_cuenta_co_nota_credito) {
				if(newid_transaccion_cuenta_co_nota_credito==null) {
					//newid_transaccion_cuenta_co_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_co_nota_credito");
					}
				}

				this.id_transaccion_cuenta_co_nota_credito=newid_transaccion_cuenta_co_nota_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_co_nota_venta(Long newid_transaccion_cuenta_co_nota_venta)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_co_nota_venta!=newid_transaccion_cuenta_co_nota_venta) {
				if(newid_transaccion_cuenta_co_nota_venta==null) {
					//newid_transaccion_cuenta_co_nota_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_co_nota_venta");
					}
				}

				this.id_transaccion_cuenta_co_nota_venta=newid_transaccion_cuenta_co_nota_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_co_tarjeta(Long newid_transaccion_cuenta_co_tarjeta)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_co_tarjeta!=newid_transaccion_cuenta_co_tarjeta) {
				if(newid_transaccion_cuenta_co_tarjeta==null) {
					//newid_transaccion_cuenta_co_tarjeta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_co_tarjeta");
					}
				}

				this.id_transaccion_cuenta_co_tarjeta=newid_transaccion_cuenta_co_tarjeta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_pa_factura(Long newid_transaccion_cuenta_pa_factura)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_pa_factura!=newid_transaccion_cuenta_pa_factura) {
				if(newid_transaccion_cuenta_pa_factura==null) {
					//newid_transaccion_cuenta_pa_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_pa_factura");
					}
				}

				this.id_transaccion_cuenta_pa_factura=newid_transaccion_cuenta_pa_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_cuenta_pa_nota_credito(Long newid_transaccion_cuenta_pa_nota_credito)throws Exception
	{
		try {
			if(this.id_transaccion_cuenta_pa_nota_credito!=newid_transaccion_cuenta_pa_nota_credito) {
				if(newid_transaccion_cuenta_pa_nota_credito==null) {
					//newid_transaccion_cuenta_pa_nota_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuTransaccion:Valor nulo no permitido en columna id_transaccion_cuenta_pa_nota_credito");
					}
				}

				this.id_transaccion_cuenta_pa_nota_credito=newid_transaccion_cuenta_pa_nota_credito;
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

	public Transaccion getTransaccionInvenFactura() {
		return this.transaccioninvenfactura;
	}

	public Transaccion getTransaccionInvenNotaCredito() {
		return this.transaccioninvennotacredito;
	}

	public Transaccion getTransaccionInvenNotaVenta() {
		return this.transaccioninvennotaventa;
	}

	public Transaccion getTransaccionCuentaCoFactura() {
		return this.transaccioncuentacofactura;
	}

	public Transaccion getTransaccionCuentaCoNotaCredito() {
		return this.transaccioncuentaconotacredito;
	}

	public Transaccion getTransaccionCuentaCoNotaVenta() {
		return this.transaccioncuentaconotaventa;
	}

	public Transaccion getTransaccionCuentaCoTarjeta() {
		return this.transaccioncuentacotarjeta;
	}

	public Transaccion getTransaccionCuentaPaFactura() {
		return this.transaccioncuentapafactura;
	}

	public Transaccion getTransaccionCuentaPaNotaCredito() {
		return this.transaccioncuentapanotacredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettransaccioninvenfactura_descripcion() {
		return this.transaccioninvenfactura_descripcion;
	}

	public String gettransaccioninvennotacredito_descripcion() {
		return this.transaccioninvennotacredito_descripcion;
	}

	public String gettransaccioninvennotaventa_descripcion() {
		return this.transaccioninvennotaventa_descripcion;
	}

	public String gettransaccioncuentacofactura_descripcion() {
		return this.transaccioncuentacofactura_descripcion;
	}

	public String gettransaccioncuentaconotacredito_descripcion() {
		return this.transaccioncuentaconotacredito_descripcion;
	}

	public String gettransaccioncuentaconotaventa_descripcion() {
		return this.transaccioncuentaconotaventa_descripcion;
	}

	public String gettransaccioncuentacotarjeta_descripcion() {
		return this.transaccioncuentacotarjeta_descripcion;
	}

	public String gettransaccioncuentapafactura_descripcion() {
		return this.transaccioncuentapafactura_descripcion;
	}

	public String gettransaccioncuentapanotacredito_descripcion() {
		return this.transaccioncuentapanotacredito_descripcion;
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


	public  void  setTransaccionInvenFactura(Transaccion transaccioninvenfactura) {
		try {
			this.transaccioninvenfactura=transaccioninvenfactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionInvenNotaCredito(Transaccion transaccioninvennotacredito) {
		try {
			this.transaccioninvennotacredito=transaccioninvennotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionInvenNotaVenta(Transaccion transaccioninvennotaventa) {
		try {
			this.transaccioninvennotaventa=transaccioninvennotaventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaCoFactura(Transaccion transaccioncuentacofactura) {
		try {
			this.transaccioncuentacofactura=transaccioncuentacofactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaCoNotaCredito(Transaccion transaccioncuentaconotacredito) {
		try {
			this.transaccioncuentaconotacredito=transaccioncuentaconotacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaCoNotaVenta(Transaccion transaccioncuentaconotaventa) {
		try {
			this.transaccioncuentaconotaventa=transaccioncuentaconotaventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaCoTarjeta(Transaccion transaccioncuentacotarjeta) {
		try {
			this.transaccioncuentacotarjeta=transaccioncuentacotarjeta;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaPaFactura(Transaccion transaccioncuentapafactura) {
		try {
			this.transaccioncuentapafactura=transaccioncuentapafactura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionCuentaPaNotaCredito(Transaccion transaccioncuentapanotacredito) {
		try {
			this.transaccioncuentapanotacredito=transaccioncuentapanotacredito;
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


	public  void  settransaccioninvenfactura_descripcion(String transaccioninvenfactura_descripcion) {
		try {
			this.transaccioninvenfactura_descripcion=transaccioninvenfactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioninvennotacredito_descripcion(String transaccioninvennotacredito_descripcion) {
		try {
			this.transaccioninvennotacredito_descripcion=transaccioninvennotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioninvennotaventa_descripcion(String transaccioninvennotaventa_descripcion) {
		try {
			this.transaccioninvennotaventa_descripcion=transaccioninvennotaventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentacofactura_descripcion(String transaccioncuentacofactura_descripcion) {
		try {
			this.transaccioncuentacofactura_descripcion=transaccioncuentacofactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentaconotacredito_descripcion(String transaccioncuentaconotacredito_descripcion) {
		try {
			this.transaccioncuentaconotacredito_descripcion=transaccioncuentaconotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentaconotaventa_descripcion(String transaccioncuentaconotaventa_descripcion) {
		try {
			this.transaccioncuentaconotaventa_descripcion=transaccioncuentaconotaventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentacotarjeta_descripcion(String transaccioncuentacotarjeta_descripcion) {
		try {
			this.transaccioncuentacotarjeta_descripcion=transaccioncuentacotarjeta_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentapafactura_descripcion(String transaccioncuentapafactura_descripcion) {
		try {
			this.transaccioncuentapafactura_descripcion=transaccioncuentapafactura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccioncuentapanotacredito_descripcion(String transaccioncuentapanotacredito_descripcion) {
		try {
			this.transaccioncuentapanotacredito_descripcion=transaccioncuentapanotacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_transaccion_inven_factura_descripcion="";String id_transaccion_inven_nota_credito_descripcion="";String id_transaccion_inven_nota_venta_descripcion="";String id_transaccion_cuenta_co_factura_descripcion="";String id_transaccion_cuenta_co_nota_credito_descripcion="";String id_transaccion_cuenta_co_nota_venta_descripcion="";String id_transaccion_cuenta_co_tarjeta_descripcion="";String id_transaccion_cuenta_pa_factura_descripcion="";String id_transaccion_cuenta_pa_nota_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_transaccion_inven_factura_descripcion() {
		return id_transaccion_inven_factura_descripcion;
	}
	public String getid_transaccion_inven_nota_credito_descripcion() {
		return id_transaccion_inven_nota_credito_descripcion;
	}
	public String getid_transaccion_inven_nota_venta_descripcion() {
		return id_transaccion_inven_nota_venta_descripcion;
	}
	public String getid_transaccion_cuenta_co_factura_descripcion() {
		return id_transaccion_cuenta_co_factura_descripcion;
	}
	public String getid_transaccion_cuenta_co_nota_credito_descripcion() {
		return id_transaccion_cuenta_co_nota_credito_descripcion;
	}
	public String getid_transaccion_cuenta_co_nota_venta_descripcion() {
		return id_transaccion_cuenta_co_nota_venta_descripcion;
	}
	public String getid_transaccion_cuenta_co_tarjeta_descripcion() {
		return id_transaccion_cuenta_co_tarjeta_descripcion;
	}
	public String getid_transaccion_cuenta_pa_factura_descripcion() {
		return id_transaccion_cuenta_pa_factura_descripcion;
	}
	public String getid_transaccion_cuenta_pa_nota_credito_descripcion() {
		return id_transaccion_cuenta_pa_nota_credito_descripcion;
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
	public void setid_transaccion_inven_factura_descripcion(String newid_transaccion_inven_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_inven_factura_descripcion=newid_transaccion_inven_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_inven_nota_credito_descripcion(String newid_transaccion_inven_nota_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_inven_nota_credito_descripcion=newid_transaccion_inven_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_inven_nota_venta_descripcion(String newid_transaccion_inven_nota_venta_descripcion)throws Exception {
		try {
			this.id_transaccion_inven_nota_venta_descripcion=newid_transaccion_inven_nota_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_co_factura_descripcion(String newid_transaccion_cuenta_co_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_co_factura_descripcion=newid_transaccion_cuenta_co_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_co_nota_credito_descripcion(String newid_transaccion_cuenta_co_nota_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_co_nota_credito_descripcion=newid_transaccion_cuenta_co_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_co_nota_venta_descripcion(String newid_transaccion_cuenta_co_nota_venta_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_co_nota_venta_descripcion=newid_transaccion_cuenta_co_nota_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_co_tarjeta_descripcion(String newid_transaccion_cuenta_co_tarjeta_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_co_tarjeta_descripcion=newid_transaccion_cuenta_co_tarjeta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_pa_factura_descripcion(String newid_transaccion_cuenta_pa_factura_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_pa_factura_descripcion=newid_transaccion_cuenta_pa_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_cuenta_pa_nota_credito_descripcion(String newid_transaccion_cuenta_pa_nota_credito_descripcion)throws Exception {
		try {
			this.id_transaccion_cuenta_pa_nota_credito_descripcion=newid_transaccion_cuenta_pa_nota_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_transaccion_inven_factura_descripcion="";this.id_transaccion_inven_nota_credito_descripcion="";this.id_transaccion_inven_nota_venta_descripcion="";this.id_transaccion_cuenta_co_factura_descripcion="";this.id_transaccion_cuenta_co_nota_credito_descripcion="";this.id_transaccion_cuenta_co_nota_venta_descripcion="";this.id_transaccion_cuenta_co_tarjeta_descripcion="";this.id_transaccion_cuenta_pa_factura_descripcion="";this.id_transaccion_cuenta_pa_nota_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

