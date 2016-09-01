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
//import com.bydan.erp.inventario.util.ProductoCuentaContableConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class ProductoCuentaContable extends ProductoCuentaContableAdditional implements Serializable ,Cloneable {//ProductoCuentaContableAdditional,GeneralEntity
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
	
	private ProductoCuentaContable productocuentacontableOriginal;
	
	private Map<String, Object> mapProductoCuentaContable;
			
	public Map<String, Object> getMapProductoCuentaContable() {
		return mapProductoCuentaContable;
	}

	public void setMapProductoCuentaContable(Map<String, Object> mapProductoCuentaContable) {
		this.mapProductoCuentaContable = mapProductoCuentaContable;
	}
	
	public void inicializarMapProductoCuentaContable() {
		this.mapProductoCuentaContable = new HashMap<String,Object>();
	}
	
	public void setMapProductoCuentaContableValue(String sKey,Object oValue) {
		this.mapProductoCuentaContable.put(sKey, oValue);
	}
	
	public Object getMapProductoCuentaContableValue(String sKey) {
		return this.mapProductoCuentaContable.get(sKey);
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
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Bodega bodega;
	public Producto producto;
	public CentroCosto centrocosto;
	public CuentaContable cuentacontableinventario;
	public CuentaContable cuentacontablecosto;
	public CuentaContable cuentacontableventa;
	public CuentaContable cuentacontabledescuento;
	public CuentaContable cuentacontabledevolucion;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String centrocosto_descripcion;
	private String cuentacontableinventario_descripcion;
	private String cuentacontablecosto_descripcion;
	private String cuentacontableventa_descripcion;
	private String cuentacontabledescuento_descripcion;
	private String cuentacontabledevolucion_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	
	
		
	public ProductoCuentaContable () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productocuentacontableOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_centro_costo=null;
 		this.id_cuenta_contable_inventario=-1L;
 		this.id_cuenta_contable_costo=-1L;
 		this.id_cuenta_contable_venta=-1L;
 		this.id_cuenta_contable_descuento=-1L;
 		this.id_cuenta_contable_devolucion=-1L;
 		this.id_cuenta_contable_debito=-1L;
 		this.id_cuenta_contable_credito=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.bodega=null;
		this.producto=null;
		this.centrocosto=null;
		this.cuentacontableinventario=null;
		this.cuentacontablecosto=null;
		this.cuentacontableventa=null;
		this.cuentacontabledescuento=null;
		this.cuentacontabledevolucion=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.centrocosto_descripcion="";
		this.cuentacontableinventario_descripcion="";
		this.cuentacontablecosto_descripcion="";
		this.cuentacontableventa_descripcion="";
		this.cuentacontabledescuento_descripcion="";
		this.cuentacontabledevolucion_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductoCuentaContable (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_centro_costo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productocuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductoCuentaContable (Long id_empresa,Long id_sucursal,Long id_bodega,Long id_producto,Long id_centro_costo,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productocuentacontableOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_centro_costo=id_centro_costo;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProductoCuentaContable productocuentacontableLocal=null;
		
		if(object!=null) {
			productocuentacontableLocal=(ProductoCuentaContable)object;
			
			if(productocuentacontableLocal!=null) {
				if(this.getId()!=null && productocuentacontableLocal.getId()!=null) {
					if(this.getId().equals(productocuentacontableLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoCuentaContableConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoCuentaContableConstantesFunciones.getProductoCuentaContableDescripcion(this);
		} else {
			sDetalle=ProductoCuentaContableConstantesFunciones.getProductoCuentaContableDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProductoCuentaContable getProductoCuentaContableOriginal() {
		return this.productocuentacontableOriginal;
	}
	
	public void setProductoCuentaContableOriginal(ProductoCuentaContable productocuentacontable) {
		try {
			this.productocuentacontableOriginal=productocuentacontable;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoCuentaContableAdditional productocuentacontableAdditional=null;
	
	public ProductoCuentaContableAdditional getProductoCuentaContableAdditional() {
		return this.productocuentacontableAdditional;
	}
	
	public void setProductoCuentaContableAdditional(ProductoCuentaContableAdditional productocuentacontableAdditional) {
		try {
			this.productocuentacontableAdditional=productocuentacontableAdditional;
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
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_cuenta_contable_inventario() {
		return this.id_cuenta_contable_inventario;
	}
    
	
	public Long getid_cuenta_contable_costo() {
		return this.id_cuenta_contable_costo;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Long getid_cuenta_contable_descuento() {
		return this.id_cuenta_contable_descuento;
	}
    
	
	public Long getid_cuenta_contable_devolucion() {
		return this.id_cuenta_contable_devolucion;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega(Long newid_bodega)throws Exception
	{
		try {
			if(this.id_bodega!=newid_bodega) {
				if(newid_bodega==null) {
					//newid_bodega=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_inventario(Long newid_cuenta_contable_inventario)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario!=newid_cuenta_contable_inventario) {
				if(newid_cuenta_contable_inventario==null) {
					//newid_cuenta_contable_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_inventario");
					}
				}

				this.id_cuenta_contable_inventario=newid_cuenta_contable_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo(Long newid_cuenta_contable_costo)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo!=newid_cuenta_contable_costo) {
				if(newid_cuenta_contable_costo==null) {
					//newid_cuenta_contable_costo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_costo");
					}
				}

				this.id_cuenta_contable_costo=newid_cuenta_contable_costo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta(Long newid_cuenta_contable_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_venta!=newid_cuenta_contable_venta) {
				if(newid_cuenta_contable_venta==null) {
					//newid_cuenta_contable_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_venta");
					}
				}

				this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_descuento(Long newid_cuenta_contable_descuento)throws Exception
	{
		try {
			if(this.id_cuenta_contable_descuento!=newid_cuenta_contable_descuento) {
				if(newid_cuenta_contable_descuento==null) {
					//newid_cuenta_contable_descuento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_descuento");
					}
				}

				this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_devolucion(Long newid_cuenta_contable_devolucion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_devolucion!=newid_cuenta_contable_devolucion) {
				if(newid_cuenta_contable_devolucion==null) {
					//newid_cuenta_contable_devolucion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_devolucion");
					}
				}

				this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_debito(Long newid_cuenta_contable_debito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_debito!=newid_cuenta_contable_debito) {
				if(newid_cuenta_contable_debito==null) {
					//newid_cuenta_contable_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_debito");
					}
				}

				this.id_cuenta_contable_debito=newid_cuenta_contable_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_credito(Long newid_cuenta_contable_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_credito!=newid_cuenta_contable_credito) {
				if(newid_cuenta_contable_credito==null) {
					//newid_cuenta_contable_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoCuentaContable:Valor nulo no permitido en columna id_cuenta_contable_credito");
					}
				}

				this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
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

	public Bodega getBodega() {
		return this.bodega;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public CuentaContable getCuentaContableInventario() {
		return this.cuentacontableinventario;
	}

	public CuentaContable getCuentaContableCosto() {
		return this.cuentacontablecosto;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	public CuentaContable getCuentaContableDescuento() {
		return this.cuentacontabledescuento;
	}

	public CuentaContable getCuentaContableDevolucion() {
		return this.cuentacontabledevolucion;
	}

	public CuentaContable getCuentaContableDebito() {
		return this.cuentacontabledebito;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getcuentacontableinventario_descripcion() {
		return this.cuentacontableinventario_descripcion;
	}

	public String getcuentacontablecosto_descripcion() {
		return this.cuentacontablecosto_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	public String getcuentacontabledescuento_descripcion() {
		return this.cuentacontabledescuento_descripcion;
	}

	public String getcuentacontabledevolucion_descripcion() {
		return this.cuentacontabledevolucion_descripcion;
	}

	public String getcuentacontabledebito_descripcion() {
		return this.cuentacontabledebito_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
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


	public  void  setBodega(Bodega bodega) {
		try {
			this.bodega=bodega;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableInventario(CuentaContable cuentacontableinventario) {
		try {
			this.cuentacontableinventario=cuentacontableinventario;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCosto(CuentaContable cuentacontablecosto) {
		try {
			this.cuentacontablecosto=cuentacontablecosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVenta(CuentaContable cuentacontableventa) {
		try {
			this.cuentacontableventa=cuentacontableventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDescuento(CuentaContable cuentacontabledescuento) {
		try {
			this.cuentacontabledescuento=cuentacontabledescuento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDevolucion(CuentaContable cuentacontabledevolucion) {
		try {
			this.cuentacontabledevolucion=cuentacontabledevolucion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDebito(CuentaContable cuentacontabledebito) {
		try {
			this.cuentacontabledebito=cuentacontabledebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCredito(CuentaContable cuentacontablecredito) {
		try {
			this.cuentacontablecredito=cuentacontablecredito;
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


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableinventario_descripcion(String cuentacontableinventario_descripcion) {
		try {
			this.cuentacontableinventario_descripcion=cuentacontableinventario_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecosto_descripcion(String cuentacontablecosto_descripcion) {
		try {
			this.cuentacontablecosto_descripcion=cuentacontablecosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventa_descripcion(String cuentacontableventa_descripcion) {
		try {
			this.cuentacontableventa_descripcion=cuentacontableventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledescuento_descripcion(String cuentacontabledescuento_descripcion) {
		try {
			this.cuentacontabledescuento_descripcion=cuentacontabledescuento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledevolucion_descripcion(String cuentacontabledevolucion_descripcion) {
		try {
			this.cuentacontabledevolucion_descripcion=cuentacontabledevolucion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledebito_descripcion(String cuentacontabledebito_descripcion) {
		try {
			this.cuentacontabledebito_descripcion=cuentacontabledebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecredito_descripcion(String cuentacontablecredito_descripcion) {
		try {
			this.cuentacontablecredito_descripcion=cuentacontablecredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_centro_costo_descripcion="";String id_cuenta_contable_inventario_descripcion="";String id_cuenta_contable_costo_descripcion="";String id_cuenta_contable_venta_descripcion="";String id_cuenta_contable_descuento_descripcion="";String id_cuenta_contable_devolucion_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_cuenta_contable_inventario_descripcion() {
		return id_cuenta_contable_inventario_descripcion;
	}
	public String getid_cuenta_contable_costo_descripcion() {
		return id_cuenta_contable_costo_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	public String getid_cuenta_contable_descuento_descripcion() {
		return id_cuenta_contable_descuento_descripcion;
	}
	public String getid_cuenta_contable_devolucion_descripcion() {
		return id_cuenta_contable_devolucion_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
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
	public void setid_bodega_descripcion(String newid_bodega_descripcion)throws Exception {
		try {
			this.id_bodega_descripcion=newid_bodega_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_inventario_descripcion(String newid_cuenta_contable_inventario_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_inventario_descripcion=newid_cuenta_contable_inventario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_descripcion(String newid_cuenta_contable_costo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_descripcion=newid_cuenta_contable_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_descripcion(String newid_cuenta_contable_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_descripcion=newid_cuenta_contable_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descuento_descripcion(String newid_cuenta_contable_descuento_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descuento_descripcion=newid_cuenta_contable_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_devolucion_descripcion(String newid_cuenta_contable_devolucion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_devolucion_descripcion=newid_cuenta_contable_devolucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_debito_descripcion(String newid_cuenta_contable_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_debito_descripcion=newid_cuenta_contable_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_credito_descripcion(String newid_cuenta_contable_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_credito_descripcion=newid_cuenta_contable_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_centro_costo_descripcion="";this.id_cuenta_contable_inventario_descripcion="";this.id_cuenta_contable_costo_descripcion="";this.id_cuenta_contable_venta_descripcion="";this.id_cuenta_contable_descuento_descripcion="";this.id_cuenta_contable_devolucion_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

