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
//import com.bydan.erp.produccion.util.ProductoOrdenDetaProduGastoConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class ProductoOrdenDetaProduGasto extends ProductoOrdenDetaProduGastoAdditional implements Serializable ,Cloneable {//ProductoOrdenDetaProduGastoAdditional,GeneralEntity
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
	
	private ProductoOrdenDetaProduGasto productoordendetaprodugastoOriginal;
	
	private Map<String, Object> mapProductoOrdenDetaProduGasto;
			
	public Map<String, Object> getMapProductoOrdenDetaProduGasto() {
		return mapProductoOrdenDetaProduGasto;
	}

	public void setMapProductoOrdenDetaProduGasto(Map<String, Object> mapProductoOrdenDetaProduGasto) {
		this.mapProductoOrdenDetaProduGasto = mapProductoOrdenDetaProduGasto;
	}
	
	public void inicializarMapProductoOrdenDetaProduGasto() {
		this.mapProductoOrdenDetaProduGasto = new HashMap<String,Object>();
	}
	
	public void setMapProductoOrdenDetaProduGastoValue(String sKey,Object oValue) {
		this.mapProductoOrdenDetaProduGasto.put(sKey, oValue);
	}
	
	public Object getMapProductoOrdenDetaProduGastoValue(String sKey) {
		return this.mapProductoOrdenDetaProduGasto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_orden_deta_produ;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_gasto_produ_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ProductoOrdenDetaProduGastoConstantesFunciones.SREGEXDESCRIPCION,message=ProductoOrdenDetaProduGastoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public OrdenDetaProdu ordendetaprodu;
	public TipoGastoProduEmpresa tipogastoproduempresa;
	public CuentaContable cuentacontabledebito;
	public CuentaContable cuentacontablecredito;
	public Cliente clienteproveedor;
	public Factura factura;
	public Unidad unidad;
	
	
	private String ordendetaprodu_descripcion;
	private String tipogastoproduempresa_descripcion;
	private String cuentacontabledebito_descripcion;
	private String cuentacontablecredito_descripcion;
	private String clienteproveedor_descripcion;
	private String factura_descripcion;
	private String unidad_descripcion;
	
	
		
	public ProductoOrdenDetaProduGasto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.productoordendetaprodugastoOriginal=this;
		
 		this.id_orden_deta_produ=-1L;
 		this.id_tipo_gasto_produ_empresa=-1L;
 		this.id_cuenta_contable_debito=-1L;
 		this.id_cuenta_contable_credito=-1L;
 		this.id_cliente_proveedor=-1L;
 		this.id_factura=-1L;
 		this.id_unidad=-1L;
 		this.cantidad=0;
 		this.costo=0.0;
 		this.costo_total=0.0;
 		this.descripcion="";
		
		
		this.ordendetaprodu=null;
		this.tipogastoproduempresa=null;
		this.cuentacontabledebito=null;
		this.cuentacontablecredito=null;
		this.clienteproveedor=null;
		this.factura=null;
		this.unidad=null;
		
		
		this.ordendetaprodu_descripcion="";
		this.tipogastoproduempresa_descripcion="";
		this.cuentacontabledebito_descripcion="";
		this.cuentacontablecredito_descripcion="";
		this.clienteproveedor_descripcion="";
		this.factura_descripcion="";
		this.unidad_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProductoOrdenDetaProduGasto (Long id,Date versionRow,Long id_orden_deta_produ,Long id_tipo_gasto_produ_empresa,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Long id_cliente_proveedor,Long id_factura,Long id_unidad,Integer cantidad,Double costo,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoordendetaprodugastoOriginal=this;
		
 		this.id_orden_deta_produ=id_orden_deta_produ;
 		this.id_tipo_gasto_produ_empresa=id_tipo_gasto_produ_empresa;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_factura=id_factura;
 		this.id_unidad=id_unidad;
 		this.cantidad=cantidad;
 		this.costo=costo;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProductoOrdenDetaProduGasto (Long id_orden_deta_produ,Long id_tipo_gasto_produ_empresa,Long id_cuenta_contable_debito,Long id_cuenta_contable_credito,Long id_cliente_proveedor,Long id_factura,Long id_unidad,Integer cantidad,Double costo,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.productoordendetaprodugastoOriginal=this;
		
 		this.id_orden_deta_produ=id_orden_deta_produ;
 		this.id_tipo_gasto_produ_empresa=id_tipo_gasto_produ_empresa;
 		this.id_cuenta_contable_debito=id_cuenta_contable_debito;
 		this.id_cuenta_contable_credito=id_cuenta_contable_credito;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_factura=id_factura;
 		this.id_unidad=id_unidad;
 		this.cantidad=cantidad;
 		this.costo=costo;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ProductoOrdenDetaProduGasto productoordendetaprodugastoLocal=null;
		
		if(object!=null) {
			productoordendetaprodugastoLocal=(ProductoOrdenDetaProduGasto)object;
			
			if(productoordendetaprodugastoLocal!=null) {
				if(this.getId()!=null && productoordendetaprodugastoLocal.getId()!=null) {
					if(this.getId().equals(productoordendetaprodugastoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ProductoOrdenDetaProduGastoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ProductoOrdenDetaProduGastoConstantesFunciones.getProductoOrdenDetaProduGastoDescripcion(this);
		} else {
			sDetalle=ProductoOrdenDetaProduGastoConstantesFunciones.getProductoOrdenDetaProduGastoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ProductoOrdenDetaProduGasto getProductoOrdenDetaProduGastoOriginal() {
		return this.productoordendetaprodugastoOriginal;
	}
	
	public void setProductoOrdenDetaProduGastoOriginal(ProductoOrdenDetaProduGasto productoordendetaprodugasto) {
		try {
			this.productoordendetaprodugastoOriginal=productoordendetaprodugasto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProductoOrdenDetaProduGastoAdditional productoordendetaprodugastoAdditional=null;
	
	public ProductoOrdenDetaProduGastoAdditional getProductoOrdenDetaProduGastoAdditional() {
		return this.productoordendetaprodugastoAdditional;
	}
	
	public void setProductoOrdenDetaProduGastoAdditional(ProductoOrdenDetaProduGastoAdditional productoordendetaprodugastoAdditional) {
		try {
			this.productoordendetaprodugastoAdditional=productoordendetaprodugastoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_orden_deta_produ() {
		return this.id_orden_deta_produ;
	}
    
	
	public Long getid_tipo_gasto_produ_empresa() {
		return this.id_tipo_gasto_produ_empresa;
	}
    
	
	public Long getid_cuenta_contable_debito() {
		return this.id_cuenta_contable_debito;
	}
    
	
	public Long getid_cuenta_contable_credito() {
		return this.id_cuenta_contable_credito;
	}
    
	
	public Long getid_cliente_proveedor() {
		return this.id_cliente_proveedor;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_orden_deta_produ(Long newid_orden_deta_produ)throws Exception
	{
		try {
			if(this.id_orden_deta_produ!=newid_orden_deta_produ) {
				if(newid_orden_deta_produ==null) {
					//newid_orden_deta_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_orden_deta_produ");
					}
				}

				this.id_orden_deta_produ=newid_orden_deta_produ;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_gasto_produ_empresa(Long newid_tipo_gasto_produ_empresa)throws Exception
	{
		try {
			if(this.id_tipo_gasto_produ_empresa!=newid_tipo_gasto_produ_empresa) {
				if(newid_tipo_gasto_produ_empresa==null) {
					//newid_tipo_gasto_produ_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_tipo_gasto_produ_empresa");
					}
				}

				this.id_tipo_gasto_produ_empresa=newid_tipo_gasto_produ_empresa;
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
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_cuenta_contable_debito");
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
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_cuenta_contable_credito");
					}
				}

				this.id_cuenta_contable_credito=newid_cuenta_contable_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_proveedor(Long newid_cliente_proveedor)throws Exception
	{
		try {
			if(this.id_cliente_proveedor!=newid_cliente_proveedor) {
				if(newid_cliente_proveedor==null) {
					//newid_cliente_proveedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_cliente_proveedor");
					}
				}

				this.id_cliente_proveedor=newid_cliente_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto(Double newcosto)throws Exception
	{
		try {
			if(this.costo!=newcosto) {
				if(newcosto==null) {
					//newcosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_total(Double newcosto_total)throws Exception
	{
		try {
			if(this.costo_total!=newcosto_total) {
				if(newcosto_total==null) {
					//newcosto_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
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
						System.out.println("ProductoOrdenDetaProduGasto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("ProductoOrdenDetaProduGasto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public OrdenDetaProdu getOrdenDetaProdu() {
		return this.ordendetaprodu;
	}

	public TipoGastoProduEmpresa getTipoGastoProduEmpresa() {
		return this.tipogastoproduempresa;
	}

	public CuentaContable getCuentaContableDebito() {
		return this.cuentacontabledebito;
	}

	public CuentaContable getCuentaContableCredito() {
		return this.cuentacontablecredito;
	}

	public Cliente getClienteProveedor() {
		return this.clienteproveedor;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	
	
	public String getordendetaprodu_descripcion() {
		return this.ordendetaprodu_descripcion;
	}

	public String gettipogastoproduempresa_descripcion() {
		return this.tipogastoproduempresa_descripcion;
	}

	public String getcuentacontabledebito_descripcion() {
		return this.cuentacontabledebito_descripcion;
	}

	public String getcuentacontablecredito_descripcion() {
		return this.cuentacontablecredito_descripcion;
	}

	public String getclienteproveedor_descripcion() {
		return this.clienteproveedor_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	
	
	public  void  setOrdenDetaProdu(OrdenDetaProdu ordendetaprodu) {
		try {
			this.ordendetaprodu=ordendetaprodu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGastoProduEmpresa(TipoGastoProduEmpresa tipogastoproduempresa) {
		try {
			this.tipogastoproduempresa=tipogastoproduempresa;
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


	public  void  setClienteProveedor(Cliente clienteproveedor) {
		try {
			this.clienteproveedor=clienteproveedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setordendetaprodu_descripcion(String ordendetaprodu_descripcion) {
		try {
			this.ordendetaprodu_descripcion=ordendetaprodu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogastoproduempresa_descripcion(String tipogastoproduempresa_descripcion) {
		try {
			this.tipogastoproduempresa_descripcion=tipogastoproduempresa_descripcion;
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


	public  void  setclienteproveedor_descripcion(String clienteproveedor_descripcion) {
		try {
			this.clienteproveedor_descripcion=clienteproveedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_orden_deta_produ_descripcion="";String id_tipo_gasto_produ_empresa_descripcion="";String id_cuenta_contable_debito_descripcion="";String id_cuenta_contable_credito_descripcion="";String id_cliente_proveedor_descripcion="";String id_factura_descripcion="";String id_unidad_descripcion="";
	
	
	public String getid_orden_deta_produ_descripcion() {
		return id_orden_deta_produ_descripcion;
	}
	public String getid_tipo_gasto_produ_empresa_descripcion() {
		return id_tipo_gasto_produ_empresa_descripcion;
	}
	public String getid_cuenta_contable_debito_descripcion() {
		return id_cuenta_contable_debito_descripcion;
	}
	public String getid_cuenta_contable_credito_descripcion() {
		return id_cuenta_contable_credito_descripcion;
	}
	public String getid_cliente_proveedor_descripcion() {
		return id_cliente_proveedor_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	
	
	public void setid_orden_deta_produ_descripcion(String newid_orden_deta_produ_descripcion)throws Exception {
		try {
			this.id_orden_deta_produ_descripcion=newid_orden_deta_produ_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_gasto_produ_empresa_descripcion(String newid_tipo_gasto_produ_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_gasto_produ_empresa_descripcion=newid_tipo_gasto_produ_empresa_descripcion;
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
	public void setid_cliente_proveedor_descripcion(String newid_cliente_proveedor_descripcion)throws Exception {
		try {
			this.id_cliente_proveedor_descripcion=newid_cliente_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_orden_deta_produ_descripcion="";this.id_tipo_gasto_produ_empresa_descripcion="";this.id_cuenta_contable_debito_descripcion="";this.id_cuenta_contable_credito_descripcion="";this.id_cliente_proveedor_descripcion="";this.id_factura_descripcion="";this.id_unidad_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

