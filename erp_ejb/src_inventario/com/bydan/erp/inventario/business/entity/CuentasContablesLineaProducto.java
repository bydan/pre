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
//import com.bydan.erp.inventario.util.CuentasContablesLineaProductoConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CuentasContablesLineaProducto extends CuentasContablesLineaProductoAdditional implements Serializable ,Cloneable {//CuentasContablesLineaProductoAdditional,GeneralEntity
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
	
	private CuentasContablesLineaProducto cuentascontableslineaproductoOriginal;
	
	private Map<String, Object> mapCuentasContablesLineaProducto;
			
	public Map<String, Object> getMapCuentasContablesLineaProducto() {
		return mapCuentasContablesLineaProducto;
	}

	public void setMapCuentasContablesLineaProducto(Map<String, Object> mapCuentasContablesLineaProducto) {
		this.mapCuentasContablesLineaProducto = mapCuentasContablesLineaProducto;
	}
	
	public void inicializarMapCuentasContablesLineaProducto() {
		this.mapCuentasContablesLineaProducto = new HashMap<String,Object>();
	}
	
	public void setMapCuentasContablesLineaProductoValue(String sKey,Object oValue) {
		this.mapCuentasContablesLineaProducto.put(sKey, oValue);
	}
	
	public Object getMapCuentasContablesLineaProductoValue(String sKey) {
		return this.mapCuentasContablesLineaProducto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_inventario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_venta;
	
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
	private Long id_cuenta_contable_produccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_devolucion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_iva_debito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_iva_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_bonifica;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo_bonifica;
			
	
	public Empresa empresa;
	public Bodega bodega;
	public CentroCosto centrocosto;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public CuentaContable cuentacontableinventario;
	public CuentaContable cuentacontablecostoventa;
	public CuentaContable cuentacontableventa;
	public CuentaContable cuentacontabledescuento;
	public CuentaContable cuentacontableproduccion;
	public CuentaContable cuentacontabledevolucion;
	public CuentaContable cuentacontableivadebito;
	public CuentaContable cuentacontableivacredito;
	public CuentaContable cuentacontablebonifica;
	public CuentaContable cuentacontablecostobonifica;
	
	
	private String empresa_descripcion;
	private String bodega_descripcion;
	private String centrocosto_descripcion;
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String cuentacontableinventario_descripcion;
	private String cuentacontablecostoventa_descripcion;
	private String cuentacontableventa_descripcion;
	private String cuentacontabledescuento_descripcion;
	private String cuentacontableproduccion_descripcion;
	private String cuentacontabledevolucion_descripcion;
	private String cuentacontableivadebito_descripcion;
	private String cuentacontableivacredito_descripcion;
	private String cuentacontablebonifica_descripcion;
	private String cuentacontablecostobonifica_descripcion;
	
	
		
	public CuentasContablesLineaProducto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentascontableslineaproductoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_bodega=-1L;
 		this.id_centro_costo=null;
 		this.id_linea=-1L;
 		this.id_linea_grupo=-1L;
 		this.id_linea_categoria=-1L;
 		this.id_cuenta_contable_inventario=-1L;
 		this.id_cuenta_contable_costo_venta=-1L;
 		this.id_cuenta_contable_venta=-1L;
 		this.id_cuenta_contable_descuento=-1L;
 		this.id_cuenta_contable_produccion=-1L;
 		this.id_cuenta_contable_devolucion=-1L;
 		this.id_cuenta_contable_iva_debito=-1L;
 		this.id_cuenta_contable_iva_credito=-1L;
 		this.id_cuenta_contable_bonifica=-1L;
 		this.id_cuenta_contable_costo_bonifica=-1L;
		
		
		this.empresa=null;
		this.bodega=null;
		this.centrocosto=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.cuentacontableinventario=null;
		this.cuentacontablecostoventa=null;
		this.cuentacontableventa=null;
		this.cuentacontabledescuento=null;
		this.cuentacontableproduccion=null;
		this.cuentacontabledevolucion=null;
		this.cuentacontableivadebito=null;
		this.cuentacontableivacredito=null;
		this.cuentacontablebonifica=null;
		this.cuentacontablecostobonifica=null;
		
		
		this.empresa_descripcion="";
		this.bodega_descripcion="";
		this.centrocosto_descripcion="";
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.cuentacontableinventario_descripcion="";
		this.cuentacontablecostoventa_descripcion="";
		this.cuentacontableventa_descripcion="";
		this.cuentacontabledescuento_descripcion="";
		this.cuentacontableproduccion_descripcion="";
		this.cuentacontabledevolucion_descripcion="";
		this.cuentacontableivadebito_descripcion="";
		this.cuentacontableivacredito_descripcion="";
		this.cuentacontablebonifica_descripcion="";
		this.cuentacontablecostobonifica_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentasContablesLineaProducto (Long id,Date versionRow,Long id_empresa,Long id_bodega,Long id_centro_costo,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_produccion,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_iva_debito,Long id_cuenta_contable_iva_credito,Long id_cuenta_contable_bonifica,Long id_cuenta_contable_costo_bonifica) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentascontableslineaproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_bodega=id_bodega;
 		this.id_centro_costo=id_centro_costo;
 		this.id_linea=id_linea;
 		this.id_linea_grupo=id_linea_grupo;
 		this.id_linea_categoria=id_linea_categoria;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_iva_debito=id_cuenta_contable_iva_debito;
 		this.id_cuenta_contable_iva_credito=id_cuenta_contable_iva_credito;
 		this.id_cuenta_contable_bonifica=id_cuenta_contable_bonifica;
 		this.id_cuenta_contable_costo_bonifica=id_cuenta_contable_costo_bonifica;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentasContablesLineaProducto (Long id_empresa,Long id_bodega,Long id_centro_costo,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_cuenta_contable_inventario,Long id_cuenta_contable_costo_venta,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_produccion,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_iva_debito,Long id_cuenta_contable_iva_credito,Long id_cuenta_contable_bonifica,Long id_cuenta_contable_costo_bonifica) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentascontableslineaproductoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_bodega=id_bodega;
 		this.id_centro_costo=id_centro_costo;
 		this.id_linea=id_linea;
 		this.id_linea_grupo=id_linea_grupo;
 		this.id_linea_categoria=id_linea_categoria;
 		this.id_cuenta_contable_inventario=id_cuenta_contable_inventario;
 		this.id_cuenta_contable_costo_venta=id_cuenta_contable_costo_venta;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_produccion=id_cuenta_contable_produccion;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_iva_debito=id_cuenta_contable_iva_debito;
 		this.id_cuenta_contable_iva_credito=id_cuenta_contable_iva_credito;
 		this.id_cuenta_contable_bonifica=id_cuenta_contable_bonifica;
 		this.id_cuenta_contable_costo_bonifica=id_cuenta_contable_costo_bonifica;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentasContablesLineaProducto cuentascontableslineaproductoLocal=null;
		
		if(object!=null) {
			cuentascontableslineaproductoLocal=(CuentasContablesLineaProducto)object;
			
			if(cuentascontableslineaproductoLocal!=null) {
				if(this.getId()!=null && cuentascontableslineaproductoLocal.getId()!=null) {
					if(this.getId().equals(cuentascontableslineaproductoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentasContablesLineaProductoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentasContablesLineaProductoConstantesFunciones.getCuentasContablesLineaProductoDescripcion(this);
		} else {
			sDetalle=CuentasContablesLineaProductoConstantesFunciones.getCuentasContablesLineaProductoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentasContablesLineaProducto getCuentasContablesLineaProductoOriginal() {
		return this.cuentascontableslineaproductoOriginal;
	}
	
	public void setCuentasContablesLineaProductoOriginal(CuentasContablesLineaProducto cuentascontableslineaproducto) {
		try {
			this.cuentascontableslineaproductoOriginal=cuentascontableslineaproducto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentasContablesLineaProductoAdditional cuentascontableslineaproductoAdditional=null;
	
	public CuentasContablesLineaProductoAdditional getCuentasContablesLineaProductoAdditional() {
		return this.cuentascontableslineaproductoAdditional;
	}
	
	public void setCuentasContablesLineaProductoAdditional(CuentasContablesLineaProductoAdditional cuentascontableslineaproductoAdditional) {
		try {
			this.cuentascontableslineaproductoAdditional=cuentascontableslineaproductoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_linea_grupo() {
		return this.id_linea_grupo;
	}
    
	
	public Long getid_linea_categoria() {
		return this.id_linea_categoria;
	}
    
	
	public Long getid_cuenta_contable_inventario() {
		return this.id_cuenta_contable_inventario;
	}
    
	
	public Long getid_cuenta_contable_costo_venta() {
		return this.id_cuenta_contable_costo_venta;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Long getid_cuenta_contable_descuento() {
		return this.id_cuenta_contable_descuento;
	}
    
	
	public Long getid_cuenta_contable_produccion() {
		return this.id_cuenta_contable_produccion;
	}
    
	
	public Long getid_cuenta_contable_devolucion() {
		return this.id_cuenta_contable_devolucion;
	}
    
	
	public Long getid_cuenta_contable_iva_debito() {
		return this.id_cuenta_contable_iva_debito;
	}
    
	
	public Long getid_cuenta_contable_iva_credito() {
		return this.id_cuenta_contable_iva_credito;
	}
    
	
	public Long getid_cuenta_contable_bonifica() {
		return this.id_cuenta_contable_bonifica;
	}
    
	
	public Long getid_cuenta_contable_costo_bonifica() {
		return this.id_cuenta_contable_costo_bonifica;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_bodega");
					}
				}

				this.id_bodega=newid_bodega;
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
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_grupo(Long newid_linea_grupo)throws Exception
	{
		try {
			if(this.id_linea_grupo!=newid_linea_grupo) {
				if(newid_linea_grupo==null) {
					//newid_linea_grupo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_linea_grupo");
					}
				}

				this.id_linea_grupo=newid_linea_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_categoria(Long newid_linea_categoria)throws Exception
	{
		try {
			if(this.id_linea_categoria!=newid_linea_categoria) {
				if(newid_linea_categoria==null) {
					//newid_linea_categoria=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_linea_categoria");
					}
				}

				this.id_linea_categoria=newid_linea_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_inventario(Long newid_cuenta_contable_inventario)throws Exception
	{
		try {
			if(this.id_cuenta_contable_inventario!=newid_cuenta_contable_inventario) {
				if(newid_cuenta_contable_inventario==null) {
					//newid_cuenta_contable_inventario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_inventario");
					}
				}

				this.id_cuenta_contable_inventario=newid_cuenta_contable_inventario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_venta(Long newid_cuenta_contable_costo_venta)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo_venta!=newid_cuenta_contable_costo_venta) {
				if(newid_cuenta_contable_costo_venta==null) {
					//newid_cuenta_contable_costo_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_costo_venta");
					}
				}

				this.id_cuenta_contable_costo_venta=newid_cuenta_contable_costo_venta;
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
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_venta");
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
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_descuento");
					}
				}

				this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_produccion(Long newid_cuenta_contable_produccion)throws Exception
	{
		try {
			if(this.id_cuenta_contable_produccion!=newid_cuenta_contable_produccion) {
				if(newid_cuenta_contable_produccion==null) {
					//newid_cuenta_contable_produccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_produccion");
					}
				}

				this.id_cuenta_contable_produccion=newid_cuenta_contable_produccion;
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
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_devolucion");
					}
				}

				this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_iva_debito(Long newid_cuenta_contable_iva_debito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_iva_debito!=newid_cuenta_contable_iva_debito) {
				if(newid_cuenta_contable_iva_debito==null) {
					//newid_cuenta_contable_iva_debito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_iva_debito");
					}
				}

				this.id_cuenta_contable_iva_debito=newid_cuenta_contable_iva_debito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_iva_credito(Long newid_cuenta_contable_iva_credito)throws Exception
	{
		try {
			if(this.id_cuenta_contable_iva_credito!=newid_cuenta_contable_iva_credito) {
				if(newid_cuenta_contable_iva_credito==null) {
					//newid_cuenta_contable_iva_credito=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_iva_credito");
					}
				}

				this.id_cuenta_contable_iva_credito=newid_cuenta_contable_iva_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_bonifica(Long newid_cuenta_contable_bonifica)throws Exception
	{
		try {
			if(this.id_cuenta_contable_bonifica!=newid_cuenta_contable_bonifica) {
				if(newid_cuenta_contable_bonifica==null) {
					//newid_cuenta_contable_bonifica=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_bonifica");
					}
				}

				this.id_cuenta_contable_bonifica=newid_cuenta_contable_bonifica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_costo_bonifica(Long newid_cuenta_contable_costo_bonifica)throws Exception
	{
		try {
			if(this.id_cuenta_contable_costo_bonifica!=newid_cuenta_contable_costo_bonifica) {
				if(newid_cuenta_contable_costo_bonifica==null) {
					//newid_cuenta_contable_costo_bonifica=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentasContablesLineaProducto:Valor nulo no permitido en columna id_cuenta_contable_costo_bonifica");
					}
				}

				this.id_cuenta_contable_costo_bonifica=newid_cuenta_contable_costo_bonifica;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public Linea getLineaGrupo() {
		return this.lineagrupo;
	}

	public Linea getLineaCategoria() {
		return this.lineacategoria;
	}

	public CuentaContable getCuentaContableInventario() {
		return this.cuentacontableinventario;
	}

	public CuentaContable getCuentaContableCostoVenta() {
		return this.cuentacontablecostoventa;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	public CuentaContable getCuentaContableDescuento() {
		return this.cuentacontabledescuento;
	}

	public CuentaContable getCuentaContableProduccion() {
		return this.cuentacontableproduccion;
	}

	public CuentaContable getCuentaContableDevolucion() {
		return this.cuentacontabledevolucion;
	}

	public CuentaContable getCuentaContableIvaDebito() {
		return this.cuentacontableivadebito;
	}

	public CuentaContable getCuentaContableIvaCredito() {
		return this.cuentacontableivacredito;
	}

	public CuentaContable getCuentaContableBonifica() {
		return this.cuentacontablebonifica;
	}

	public CuentaContable getCuentaContableCostoBonifica() {
		return this.cuentacontablecostobonifica;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getlineagrupo_descripcion() {
		return this.lineagrupo_descripcion;
	}

	public String getlineacategoria_descripcion() {
		return this.lineacategoria_descripcion;
	}

	public String getcuentacontableinventario_descripcion() {
		return this.cuentacontableinventario_descripcion;
	}

	public String getcuentacontablecostoventa_descripcion() {
		return this.cuentacontablecostoventa_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	public String getcuentacontabledescuento_descripcion() {
		return this.cuentacontabledescuento_descripcion;
	}

	public String getcuentacontableproduccion_descripcion() {
		return this.cuentacontableproduccion_descripcion;
	}

	public String getcuentacontabledevolucion_descripcion() {
		return this.cuentacontabledevolucion_descripcion;
	}

	public String getcuentacontableivadebito_descripcion() {
		return this.cuentacontableivadebito_descripcion;
	}

	public String getcuentacontableivacredito_descripcion() {
		return this.cuentacontableivacredito_descripcion;
	}

	public String getcuentacontablebonifica_descripcion() {
		return this.cuentacontablebonifica_descripcion;
	}

	public String getcuentacontablecostobonifica_descripcion() {
		return this.cuentacontablecostobonifica_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaGrupo(Linea lineagrupo) {
		try {
			this.lineagrupo=lineagrupo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaCategoria(Linea lineacategoria) {
		try {
			this.lineacategoria=lineacategoria;
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


	public  void  setCuentaContableCostoVenta(CuentaContable cuentacontablecostoventa) {
		try {
			this.cuentacontablecostoventa=cuentacontablecostoventa;
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


	public  void  setCuentaContableProduccion(CuentaContable cuentacontableproduccion) {
		try {
			this.cuentacontableproduccion=cuentacontableproduccion;
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


	public  void  setCuentaContableIvaDebito(CuentaContable cuentacontableivadebito) {
		try {
			this.cuentacontableivadebito=cuentacontableivadebito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableIvaCredito(CuentaContable cuentacontableivacredito) {
		try {
			this.cuentacontableivacredito=cuentacontableivacredito;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableBonifica(CuentaContable cuentacontablebonifica) {
		try {
			this.cuentacontablebonifica=cuentacontablebonifica;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCostoBonifica(CuentaContable cuentacontablecostobonifica) {
		try {
			this.cuentacontablecostobonifica=cuentacontablecostobonifica;
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


	public  void  setbodega_descripcion(String bodega_descripcion) {
		try {
			this.bodega_descripcion=bodega_descripcion;
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


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineagrupo_descripcion(String lineagrupo_descripcion) {
		try {
			this.lineagrupo_descripcion=lineagrupo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineacategoria_descripcion(String lineacategoria_descripcion) {
		try {
			this.lineacategoria_descripcion=lineacategoria_descripcion;
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


	public  void  setcuentacontablecostoventa_descripcion(String cuentacontablecostoventa_descripcion) {
		try {
			this.cuentacontablecostoventa_descripcion=cuentacontablecostoventa_descripcion;
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


	public  void  setcuentacontableproduccion_descripcion(String cuentacontableproduccion_descripcion) {
		try {
			this.cuentacontableproduccion_descripcion=cuentacontableproduccion_descripcion;
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


	public  void  setcuentacontableivadebito_descripcion(String cuentacontableivadebito_descripcion) {
		try {
			this.cuentacontableivadebito_descripcion=cuentacontableivadebito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableivacredito_descripcion(String cuentacontableivacredito_descripcion) {
		try {
			this.cuentacontableivacredito_descripcion=cuentacontableivacredito_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablebonifica_descripcion(String cuentacontablebonifica_descripcion) {
		try {
			this.cuentacontablebonifica_descripcion=cuentacontablebonifica_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecostobonifica_descripcion(String cuentacontablecostobonifica_descripcion) {
		try {
			this.cuentacontablecostobonifica_descripcion=cuentacontablecostobonifica_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_bodega_descripcion="";String id_centro_costo_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_cuenta_contable_inventario_descripcion="";String id_cuenta_contable_costo_venta_descripcion="";String id_cuenta_contable_venta_descripcion="";String id_cuenta_contable_descuento_descripcion="";String id_cuenta_contable_produccion_descripcion="";String id_cuenta_contable_devolucion_descripcion="";String id_cuenta_contable_iva_debito_descripcion="";String id_cuenta_contable_iva_credito_descripcion="";String id_cuenta_contable_bonifica_descripcion="";String id_cuenta_contable_costo_bonifica_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_linea_grupo_descripcion() {
		return id_linea_grupo_descripcion;
	}
	public String getid_linea_categoria_descripcion() {
		return id_linea_categoria_descripcion;
	}
	public String getid_cuenta_contable_inventario_descripcion() {
		return id_cuenta_contable_inventario_descripcion;
	}
	public String getid_cuenta_contable_costo_venta_descripcion() {
		return id_cuenta_contable_costo_venta_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	public String getid_cuenta_contable_descuento_descripcion() {
		return id_cuenta_contable_descuento_descripcion;
	}
	public String getid_cuenta_contable_produccion_descripcion() {
		return id_cuenta_contable_produccion_descripcion;
	}
	public String getid_cuenta_contable_devolucion_descripcion() {
		return id_cuenta_contable_devolucion_descripcion;
	}
	public String getid_cuenta_contable_iva_debito_descripcion() {
		return id_cuenta_contable_iva_debito_descripcion;
	}
	public String getid_cuenta_contable_iva_credito_descripcion() {
		return id_cuenta_contable_iva_credito_descripcion;
	}
	public String getid_cuenta_contable_bonifica_descripcion() {
		return id_cuenta_contable_bonifica_descripcion;
	}
	public String getid_cuenta_contable_costo_bonifica_descripcion() {
		return id_cuenta_contable_costo_bonifica_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_grupo_descripcion(String newid_linea_grupo_descripcion)throws Exception {
		try {
			this.id_linea_grupo_descripcion=newid_linea_grupo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_categoria_descripcion(String newid_linea_categoria_descripcion)throws Exception {
		try {
			this.id_linea_categoria_descripcion=newid_linea_categoria_descripcion;
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
	public void setid_cuenta_contable_costo_venta_descripcion(String newid_cuenta_contable_costo_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_venta_descripcion=newid_cuenta_contable_costo_venta_descripcion;
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
	public void setid_cuenta_contable_produccion_descripcion(String newid_cuenta_contable_produccion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_produccion_descripcion=newid_cuenta_contable_produccion_descripcion;
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
	public void setid_cuenta_contable_iva_debito_descripcion(String newid_cuenta_contable_iva_debito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_iva_debito_descripcion=newid_cuenta_contable_iva_debito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_iva_credito_descripcion(String newid_cuenta_contable_iva_credito_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_iva_credito_descripcion=newid_cuenta_contable_iva_credito_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_bonifica_descripcion(String newid_cuenta_contable_bonifica_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_bonifica_descripcion=newid_cuenta_contable_bonifica_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_bonifica_descripcion(String newid_cuenta_contable_costo_bonifica_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_bonifica_descripcion=newid_cuenta_contable_costo_bonifica_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_bodega_descripcion="";this.id_centro_costo_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_cuenta_contable_inventario_descripcion="";this.id_cuenta_contable_costo_venta_descripcion="";this.id_cuenta_contable_venta_descripcion="";this.id_cuenta_contable_descuento_descripcion="";this.id_cuenta_contable_produccion_descripcion="";this.id_cuenta_contable_devolucion_descripcion="";this.id_cuenta_contable_iva_debito_descripcion="";this.id_cuenta_contable_iva_credito_descripcion="";this.id_cuenta_contable_bonifica_descripcion="";this.id_cuenta_contable_costo_bonifica_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

