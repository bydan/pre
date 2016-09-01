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
//import com.bydan.erp.facturacion.util.ParametroFactuEmpresaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class ParametroFactuEmpresa extends ParametroFactuEmpresaAdditional implements Serializable ,Cloneable {//ParametroFactuEmpresaAdditional,GeneralEntity
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
	
	private ParametroFactuEmpresa parametrofactuempresaOriginal;
	
	private Map<String, Object> mapParametroFactuEmpresa;
			
	public Map<String, Object> getMapParametroFactuEmpresa() {
		return mapParametroFactuEmpresa;
	}

	public void setMapParametroFactuEmpresa(Map<String, Object> mapParametroFactuEmpresa) {
		this.mapParametroFactuEmpresa = mapParametroFactuEmpresa;
	}
	
	public void inicializarMapParametroFactuEmpresa() {
		this.mapParametroFactuEmpresa = new HashMap<String,Object>();
	}
	
	public void setMapParametroFactuEmpresaValue(String sKey,Object oValue) {
		this.mapParametroFactuEmpresa.put(sKey, oValue);
	}
	
	public Object getMapParametroFactuEmpresaValue(String sKey) {
		return this.mapParametroFactuEmpresa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_empresa_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_transferencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa_multi_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal_multi_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion_multi_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_multi_origen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_multi_destino;
			
	
	public Empresa empresa;
	public Empresa empresaorigen;
	public Sucursal sucursal;
	public Transaccion transaccionorigen;
	public Bodega bodegaorigen;
	public Cliente clienteorigen;
	public Empresa empresadestino;
	public Sucursal sucursaldestino;
	public Transaccion transacciondestino;
	public Bodega bodegadestino;
	public Cliente clientedestino;
	public Empresa empresamultidestino;
	public Sucursal sucursalmultidestino;
	public Transaccion transaccionmultidestino;
	public Bodega bodegamultiorigen;
	public Bodega bodegamultidestino;
	
	
	private String empresa_descripcion;
	private String empresaorigen_descripcion;
	private String sucursal_descripcion;
	private String transaccionorigen_descripcion;
	private String bodegaorigen_descripcion;
	private String clienteorigen_descripcion;
	private String empresadestino_descripcion;
	private String sucursaldestino_descripcion;
	private String transacciondestino_descripcion;
	private String bodegadestino_descripcion;
	private String clientedestino_descripcion;
	private String empresamultidestino_descripcion;
	private String sucursalmultidestino_descripcion;
	private String transaccionmultidestino_descripcion;
	private String bodegamultiorigen_descripcion;
	private String bodegamultidestino_descripcion;
	
	
		
	public ParametroFactuEmpresa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.parametrofactuempresaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empresa_origen=-1L;
 		this.id_sucursal=-1L;
 		this.id_transaccion_origen=-1L;
 		this.id_bodega_origen=-1L;
 		this.id_cliente_origen=-1L;
 		this.costo_origen=0.0;
 		this.id_empresa_destino=-1L;
 		this.id_sucursal_destino=-1L;
 		this.id_transaccion_destino=-1L;
 		this.id_bodega_destino=-1L;
 		this.id_cliente_destino=-1L;
 		this.costo_destino=0.0;
 		this.con_transferencia=false;
 		this.id_empresa_multi_destino=-1L;
 		this.id_sucursal_multi_destino=-1L;
 		this.id_transaccion_multi_destino=-1L;
 		this.id_bodega_multi_origen=-1L;
 		this.id_bodega_multi_destino=-1L;
		
		
		this.empresa=null;
		this.empresaorigen=null;
		this.sucursal=null;
		this.transaccionorigen=null;
		this.bodegaorigen=null;
		this.clienteorigen=null;
		this.empresadestino=null;
		this.sucursaldestino=null;
		this.transacciondestino=null;
		this.bodegadestino=null;
		this.clientedestino=null;
		this.empresamultidestino=null;
		this.sucursalmultidestino=null;
		this.transaccionmultidestino=null;
		this.bodegamultiorigen=null;
		this.bodegamultidestino=null;
		
		
		this.empresa_descripcion="";
		this.empresaorigen_descripcion="";
		this.sucursal_descripcion="";
		this.transaccionorigen_descripcion="";
		this.bodegaorigen_descripcion="";
		this.clienteorigen_descripcion="";
		this.empresadestino_descripcion="";
		this.sucursaldestino_descripcion="";
		this.transacciondestino_descripcion="";
		this.bodegadestino_descripcion="";
		this.clientedestino_descripcion="";
		this.empresamultidestino_descripcion="";
		this.sucursalmultidestino_descripcion="";
		this.transaccionmultidestino_descripcion="";
		this.bodegamultiorigen_descripcion="";
		this.bodegamultidestino_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ParametroFactuEmpresa (Long id,Date versionRow,Long id_empresa,Long id_empresa_origen,Long id_sucursal,Long id_transaccion_origen,Long id_bodega_origen,Long id_cliente_origen,Double costo_origen,Long id_empresa_destino,Long id_sucursal_destino,Long id_transaccion_destino,Long id_bodega_destino,Long id_cliente_destino,Double costo_destino,Boolean con_transferencia,Long id_empresa_multi_destino,Long id_sucursal_multi_destino,Long id_transaccion_multi_destino,Long id_bodega_multi_origen,Long id_bodega_multi_destino) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empresa_origen=id_empresa_origen;
 		this.id_sucursal=id_sucursal;
 		this.id_transaccion_origen=id_transaccion_origen;
 		this.id_bodega_origen=id_bodega_origen;
 		this.id_cliente_origen=id_cliente_origen;
 		this.costo_origen=costo_origen;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_sucursal_destino=id_sucursal_destino;
 		this.id_transaccion_destino=id_transaccion_destino;
 		this.id_bodega_destino=id_bodega_destino;
 		this.id_cliente_destino=id_cliente_destino;
 		this.costo_destino=costo_destino;
 		this.con_transferencia=con_transferencia;
 		this.id_empresa_multi_destino=id_empresa_multi_destino;
 		this.id_sucursal_multi_destino=id_sucursal_multi_destino;
 		this.id_transaccion_multi_destino=id_transaccion_multi_destino;
 		this.id_bodega_multi_origen=id_bodega_multi_origen;
 		this.id_bodega_multi_destino=id_bodega_multi_destino;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ParametroFactuEmpresa (Long id_empresa,Long id_empresa_origen,Long id_sucursal,Long id_transaccion_origen,Long id_bodega_origen,Long id_cliente_origen,Double costo_origen,Long id_empresa_destino,Long id_sucursal_destino,Long id_transaccion_destino,Long id_bodega_destino,Long id_cliente_destino,Double costo_destino,Boolean con_transferencia,Long id_empresa_multi_destino,Long id_sucursal_multi_destino,Long id_transaccion_multi_destino,Long id_bodega_multi_origen,Long id_bodega_multi_destino) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.parametrofactuempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empresa_origen=id_empresa_origen;
 		this.id_sucursal=id_sucursal;
 		this.id_transaccion_origen=id_transaccion_origen;
 		this.id_bodega_origen=id_bodega_origen;
 		this.id_cliente_origen=id_cliente_origen;
 		this.costo_origen=costo_origen;
 		this.id_empresa_destino=id_empresa_destino;
 		this.id_sucursal_destino=id_sucursal_destino;
 		this.id_transaccion_destino=id_transaccion_destino;
 		this.id_bodega_destino=id_bodega_destino;
 		this.id_cliente_destino=id_cliente_destino;
 		this.costo_destino=costo_destino;
 		this.con_transferencia=con_transferencia;
 		this.id_empresa_multi_destino=id_empresa_multi_destino;
 		this.id_sucursal_multi_destino=id_sucursal_multi_destino;
 		this.id_transaccion_multi_destino=id_transaccion_multi_destino;
 		this.id_bodega_multi_origen=id_bodega_multi_origen;
 		this.id_bodega_multi_destino=id_bodega_multi_destino;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ParametroFactuEmpresa parametrofactuempresaLocal=null;
		
		if(object!=null) {
			parametrofactuempresaLocal=(ParametroFactuEmpresa)object;
			
			if(parametrofactuempresaLocal!=null) {
				if(this.getId()!=null && parametrofactuempresaLocal.getId()!=null) {
					if(this.getId().equals(parametrofactuempresaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ParametroFactuEmpresaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ParametroFactuEmpresaConstantesFunciones.getParametroFactuEmpresaDescripcion(this);
		} else {
			sDetalle=ParametroFactuEmpresaConstantesFunciones.getParametroFactuEmpresaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ParametroFactuEmpresa getParametroFactuEmpresaOriginal() {
		return this.parametrofactuempresaOriginal;
	}
	
	public void setParametroFactuEmpresaOriginal(ParametroFactuEmpresa parametrofactuempresa) {
		try {
			this.parametrofactuempresaOriginal=parametrofactuempresa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ParametroFactuEmpresaAdditional parametrofactuempresaAdditional=null;
	
	public ParametroFactuEmpresaAdditional getParametroFactuEmpresaAdditional() {
		return this.parametrofactuempresaAdditional;
	}
	
	public void setParametroFactuEmpresaAdditional(ParametroFactuEmpresaAdditional parametrofactuempresaAdditional) {
		try {
			this.parametrofactuempresaAdditional=parametrofactuempresaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empresa_origen() {
		return this.id_empresa_origen;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_transaccion_origen() {
		return this.id_transaccion_origen;
	}
    
	
	public Long getid_bodega_origen() {
		return this.id_bodega_origen;
	}
    
	
	public Long getid_cliente_origen() {
		return this.id_cliente_origen;
	}
    
	
	public Double getcosto_origen() {
		return this.costo_origen;
	}
    
	
	public Long getid_empresa_destino() {
		return this.id_empresa_destino;
	}
    
	
	public Long getid_sucursal_destino() {
		return this.id_sucursal_destino;
	}
    
	
	public Long getid_transaccion_destino() {
		return this.id_transaccion_destino;
	}
    
	
	public Long getid_bodega_destino() {
		return this.id_bodega_destino;
	}
    
	
	public Long getid_cliente_destino() {
		return this.id_cliente_destino;
	}
    
	
	public Double getcosto_destino() {
		return this.costo_destino;
	}
    
	
	public Boolean getcon_transferencia() {
		return this.con_transferencia;
	}
    
	
	public Long getid_empresa_multi_destino() {
		return this.id_empresa_multi_destino;
	}
    
	
	public Long getid_sucursal_multi_destino() {
		return this.id_sucursal_multi_destino;
	}
    
	
	public Long getid_transaccion_multi_destino() {
		return this.id_transaccion_multi_destino;
	}
    
	
	public Long getid_bodega_multi_origen() {
		return this.id_bodega_multi_origen;
	}
    
	
	public Long getid_bodega_multi_destino() {
		return this.id_bodega_multi_destino;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_origen(Long newid_empresa_origen)throws Exception
	{
		try {
			if(this.id_empresa_origen!=newid_empresa_origen) {
				if(newid_empresa_origen==null) {
					//newid_empresa_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_empresa_origen");
					}
				}

				this.id_empresa_origen=newid_empresa_origen;
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
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_origen(Long newid_transaccion_origen)throws Exception
	{
		try {
			if(this.id_transaccion_origen!=newid_transaccion_origen) {
				if(newid_transaccion_origen==null) {
					//newid_transaccion_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_transaccion_origen");
					}
				}

				this.id_transaccion_origen=newid_transaccion_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_origen(Long newid_bodega_origen)throws Exception
	{
		try {
			if(this.id_bodega_origen!=newid_bodega_origen) {
				if(newid_bodega_origen==null) {
					//newid_bodega_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_bodega_origen");
					}
				}

				this.id_bodega_origen=newid_bodega_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_origen(Long newid_cliente_origen)throws Exception
	{
		try {
			if(this.id_cliente_origen!=newid_cliente_origen) {
				if(newid_cliente_origen==null) {
					//newid_cliente_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_cliente_origen");
					}
				}

				this.id_cliente_origen=newid_cliente_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_origen(Double newcosto_origen)throws Exception
	{
		try {
			if(this.costo_origen!=newcosto_origen) {
				if(newcosto_origen==null) {
					//newcosto_origen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna costo_origen");
					}
				}

				this.costo_origen=newcosto_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_destino(Long newid_empresa_destino)throws Exception
	{
		try {
			if(this.id_empresa_destino!=newid_empresa_destino) {
				if(newid_empresa_destino==null) {
					//newid_empresa_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_empresa_destino");
					}
				}

				this.id_empresa_destino=newid_empresa_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal_destino(Long newid_sucursal_destino)throws Exception
	{
		try {
			if(this.id_sucursal_destino!=newid_sucursal_destino) {
				if(newid_sucursal_destino==null) {
					//newid_sucursal_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_sucursal_destino");
					}
				}

				this.id_sucursal_destino=newid_sucursal_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_destino(Long newid_transaccion_destino)throws Exception
	{
		try {
			if(this.id_transaccion_destino!=newid_transaccion_destino) {
				if(newid_transaccion_destino==null) {
					//newid_transaccion_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_transaccion_destino");
					}
				}

				this.id_transaccion_destino=newid_transaccion_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_destino(Long newid_bodega_destino)throws Exception
	{
		try {
			if(this.id_bodega_destino!=newid_bodega_destino) {
				if(newid_bodega_destino==null) {
					//newid_bodega_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_bodega_destino");
					}
				}

				this.id_bodega_destino=newid_bodega_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_destino(Long newid_cliente_destino)throws Exception
	{
		try {
			if(this.id_cliente_destino!=newid_cliente_destino) {
				if(newid_cliente_destino==null) {
					//newid_cliente_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_cliente_destino");
					}
				}

				this.id_cliente_destino=newid_cliente_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_destino(Double newcosto_destino)throws Exception
	{
		try {
			if(this.costo_destino!=newcosto_destino) {
				if(newcosto_destino==null) {
					//newcosto_destino=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna costo_destino");
					}
				}

				this.costo_destino=newcosto_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_transferencia(Boolean newcon_transferencia)throws Exception
	{
		try {
			if(this.con_transferencia!=newcon_transferencia) {
				if(newcon_transferencia==null) {
					//newcon_transferencia=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna con_transferencia");
					}
				}

				this.con_transferencia=newcon_transferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa_multi_destino(Long newid_empresa_multi_destino)throws Exception
	{
		try {
			if(this.id_empresa_multi_destino!=newid_empresa_multi_destino) {
				if(newid_empresa_multi_destino==null) {
					//newid_empresa_multi_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_empresa_multi_destino");
					}
				}

				this.id_empresa_multi_destino=newid_empresa_multi_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal_multi_destino(Long newid_sucursal_multi_destino)throws Exception
	{
		try {
			if(this.id_sucursal_multi_destino!=newid_sucursal_multi_destino) {
				if(newid_sucursal_multi_destino==null) {
					//newid_sucursal_multi_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_sucursal_multi_destino");
					}
				}

				this.id_sucursal_multi_destino=newid_sucursal_multi_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion_multi_destino(Long newid_transaccion_multi_destino)throws Exception
	{
		try {
			if(this.id_transaccion_multi_destino!=newid_transaccion_multi_destino) {
				if(newid_transaccion_multi_destino==null) {
					//newid_transaccion_multi_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_transaccion_multi_destino");
					}
				}

				this.id_transaccion_multi_destino=newid_transaccion_multi_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_multi_origen(Long newid_bodega_multi_origen)throws Exception
	{
		try {
			if(this.id_bodega_multi_origen!=newid_bodega_multi_origen) {
				if(newid_bodega_multi_origen==null) {
					//newid_bodega_multi_origen=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_bodega_multi_origen");
					}
				}

				this.id_bodega_multi_origen=newid_bodega_multi_origen;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_multi_destino(Long newid_bodega_multi_destino)throws Exception
	{
		try {
			if(this.id_bodega_multi_destino!=newid_bodega_multi_destino) {
				if(newid_bodega_multi_destino==null) {
					//newid_bodega_multi_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ParametroFactuEmpresa:Valor nulo no permitido en columna id_bodega_multi_destino");
					}
				}

				this.id_bodega_multi_destino=newid_bodega_multi_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empresa getEmpresaOrigen() {
		return this.empresaorigen;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Transaccion getTransaccionOrigen() {
		return this.transaccionorigen;
	}

	public Bodega getBodegaOrigen() {
		return this.bodegaorigen;
	}

	public Cliente getClienteOrigen() {
		return this.clienteorigen;
	}

	public Empresa getEmpresaDestino() {
		return this.empresadestino;
	}

	public Sucursal getSucursalDestino() {
		return this.sucursaldestino;
	}

	public Transaccion getTransaccionDestino() {
		return this.transacciondestino;
	}

	public Bodega getBodegaDestino() {
		return this.bodegadestino;
	}

	public Cliente getClienteDestino() {
		return this.clientedestino;
	}

	public Empresa getEmpresaMultiDestino() {
		return this.empresamultidestino;
	}

	public Sucursal getSucursalMultiDestino() {
		return this.sucursalmultidestino;
	}

	public Transaccion getTransaccionMultiDestino() {
		return this.transaccionmultidestino;
	}

	public Bodega getBodegaMultiOrigen() {
		return this.bodegamultiorigen;
	}

	public Bodega getBodegaMultiDestino() {
		return this.bodegamultidestino;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempresaorigen_descripcion() {
		return this.empresaorigen_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettransaccionorigen_descripcion() {
		return this.transaccionorigen_descripcion;
	}

	public String getbodegaorigen_descripcion() {
		return this.bodegaorigen_descripcion;
	}

	public String getclienteorigen_descripcion() {
		return this.clienteorigen_descripcion;
	}

	public String getempresadestino_descripcion() {
		return this.empresadestino_descripcion;
	}

	public String getsucursaldestino_descripcion() {
		return this.sucursaldestino_descripcion;
	}

	public String gettransacciondestino_descripcion() {
		return this.transacciondestino_descripcion;
	}

	public String getbodegadestino_descripcion() {
		return this.bodegadestino_descripcion;
	}

	public String getclientedestino_descripcion() {
		return this.clientedestino_descripcion;
	}

	public String getempresamultidestino_descripcion() {
		return this.empresamultidestino_descripcion;
	}

	public String getsucursalmultidestino_descripcion() {
		return this.sucursalmultidestino_descripcion;
	}

	public String gettransaccionmultidestino_descripcion() {
		return this.transaccionmultidestino_descripcion;
	}

	public String getbodegamultiorigen_descripcion() {
		return this.bodegamultiorigen_descripcion;
	}

	public String getbodegamultidestino_descripcion() {
		return this.bodegamultidestino_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresaOrigen(Empresa empresaorigen) {
		try {
			this.empresaorigen=empresaorigen;
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


	public  void  setTransaccionOrigen(Transaccion transaccionorigen) {
		try {
			this.transaccionorigen=transaccionorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaOrigen(Bodega bodegaorigen) {
		try {
			this.bodegaorigen=bodegaorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteOrigen(Cliente clienteorigen) {
		try {
			this.clienteorigen=clienteorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresaDestino(Empresa empresadestino) {
		try {
			this.empresadestino=empresadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursalDestino(Sucursal sucursaldestino) {
		try {
			this.sucursaldestino=sucursaldestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionDestino(Transaccion transacciondestino) {
		try {
			this.transacciondestino=transacciondestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaDestino(Bodega bodegadestino) {
		try {
			this.bodegadestino=bodegadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteDestino(Cliente clientedestino) {
		try {
			this.clientedestino=clientedestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresaMultiDestino(Empresa empresamultidestino) {
		try {
			this.empresamultidestino=empresamultidestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursalMultiDestino(Sucursal sucursalmultidestino) {
		try {
			this.sucursalmultidestino=sucursalmultidestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccionMultiDestino(Transaccion transaccionmultidestino) {
		try {
			this.transaccionmultidestino=transaccionmultidestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaMultiOrigen(Bodega bodegamultiorigen) {
		try {
			this.bodegamultiorigen=bodegamultiorigen;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaMultiDestino(Bodega bodegamultidestino) {
		try {
			this.bodegamultidestino=bodegamultidestino;
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


	public  void  setempresaorigen_descripcion(String empresaorigen_descripcion) {
		try {
			this.empresaorigen_descripcion=empresaorigen_descripcion;
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


	public  void  settransaccionorigen_descripcion(String transaccionorigen_descripcion) {
		try {
			this.transaccionorigen_descripcion=transaccionorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegaorigen_descripcion(String bodegaorigen_descripcion) {
		try {
			this.bodegaorigen_descripcion=bodegaorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclienteorigen_descripcion(String clienteorigen_descripcion) {
		try {
			this.clienteorigen_descripcion=clienteorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempresadestino_descripcion(String empresadestino_descripcion) {
		try {
			this.empresadestino_descripcion=empresadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsucursaldestino_descripcion(String sucursaldestino_descripcion) {
		try {
			this.sucursaldestino_descripcion=sucursaldestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransacciondestino_descripcion(String transacciondestino_descripcion) {
		try {
			this.transacciondestino_descripcion=transacciondestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegadestino_descripcion(String bodegadestino_descripcion) {
		try {
			this.bodegadestino_descripcion=bodegadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclientedestino_descripcion(String clientedestino_descripcion) {
		try {
			this.clientedestino_descripcion=clientedestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempresamultidestino_descripcion(String empresamultidestino_descripcion) {
		try {
			this.empresamultidestino_descripcion=empresamultidestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setsucursalmultidestino_descripcion(String sucursalmultidestino_descripcion) {
		try {
			this.sucursalmultidestino_descripcion=sucursalmultidestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccionmultidestino_descripcion(String transaccionmultidestino_descripcion) {
		try {
			this.transaccionmultidestino_descripcion=transaccionmultidestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegamultiorigen_descripcion(String bodegamultiorigen_descripcion) {
		try {
			this.bodegamultiorigen_descripcion=bodegamultiorigen_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegamultidestino_descripcion(String bodegamultidestino_descripcion) {
		try {
			this.bodegamultidestino_descripcion=bodegamultidestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empresa_origen_descripcion="";String id_sucursal_descripcion="";String id_transaccion_origen_descripcion="";String id_bodega_origen_descripcion="";String id_cliente_origen_descripcion="";String id_empresa_destino_descripcion="";String id_sucursal_destino_descripcion="";String id_transaccion_destino_descripcion="";String id_bodega_destino_descripcion="";String id_cliente_destino_descripcion="";String con_transferencia_descripcion="";String id_empresa_multi_destino_descripcion="";String id_sucursal_multi_destino_descripcion="";String id_transaccion_multi_destino_descripcion="";String id_bodega_multi_origen_descripcion="";String id_bodega_multi_destino_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empresa_origen_descripcion() {
		return id_empresa_origen_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_transaccion_origen_descripcion() {
		return id_transaccion_origen_descripcion;
	}
	public String getid_bodega_origen_descripcion() {
		return id_bodega_origen_descripcion;
	}
	public String getid_cliente_origen_descripcion() {
		return id_cliente_origen_descripcion;
	}
	public String getid_empresa_destino_descripcion() {
		return id_empresa_destino_descripcion;
	}
	public String getid_sucursal_destino_descripcion() {
		return id_sucursal_destino_descripcion;
	}
	public String getid_transaccion_destino_descripcion() {
		return id_transaccion_destino_descripcion;
	}
	public String getid_bodega_destino_descripcion() {
		return id_bodega_destino_descripcion;
	}
	public String getid_cliente_destino_descripcion() {
		return id_cliente_destino_descripcion;
	}
	public String getcon_transferencia_descripcion() {
		return con_transferencia_descripcion;
	}
	public String getid_empresa_multi_destino_descripcion() {
		return id_empresa_multi_destino_descripcion;
	}
	public String getid_sucursal_multi_destino_descripcion() {
		return id_sucursal_multi_destino_descripcion;
	}
	public String getid_transaccion_multi_destino_descripcion() {
		return id_transaccion_multi_destino_descripcion;
	}
	public String getid_bodega_multi_origen_descripcion() {
		return id_bodega_multi_origen_descripcion;
	}
	public String getid_bodega_multi_destino_descripcion() {
		return id_bodega_multi_destino_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_origen_descripcion(String newid_empresa_origen_descripcion)throws Exception {
		try {
			this.id_empresa_origen_descripcion=newid_empresa_origen_descripcion;
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
	public void setid_transaccion_origen_descripcion(String newid_transaccion_origen_descripcion)throws Exception {
		try {
			this.id_transaccion_origen_descripcion=newid_transaccion_origen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_origen_descripcion(String newid_bodega_origen_descripcion)throws Exception {
		try {
			this.id_bodega_origen_descripcion=newid_bodega_origen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_origen_descripcion(String newid_cliente_origen_descripcion)throws Exception {
		try {
			this.id_cliente_origen_descripcion=newid_cliente_origen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_destino_descripcion(String newid_empresa_destino_descripcion) {
		this.id_empresa_destino_descripcion=newid_empresa_destino_descripcion;
	}
	public void setid_sucursal_destino_descripcion(String newid_sucursal_destino_descripcion)throws Exception {
		try {
			this.id_sucursal_destino_descripcion=newid_sucursal_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_destino_descripcion(String newid_transaccion_destino_descripcion)throws Exception {
		try {
			this.id_transaccion_destino_descripcion=newid_transaccion_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_destino_descripcion(String newid_bodega_destino_descripcion)throws Exception {
		try {
			this.id_bodega_destino_descripcion=newid_bodega_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_destino_descripcion(String newid_cliente_destino_descripcion)throws Exception {
		try {
			this.id_cliente_destino_descripcion=newid_cliente_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_transferencia_descripcion(String newcon_transferencia_descripcion)throws Exception {
		try {
			this.con_transferencia_descripcion=newcon_transferencia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_multi_destino_descripcion(String newid_empresa_multi_destino_descripcion)throws Exception {
		try {
			this.id_empresa_multi_destino_descripcion=newid_empresa_multi_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_multi_destino_descripcion(String newid_sucursal_multi_destino_descripcion)throws Exception {
		try {
			this.id_sucursal_multi_destino_descripcion=newid_sucursal_multi_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_multi_destino_descripcion(String newid_transaccion_multi_destino_descripcion)throws Exception {
		try {
			this.id_transaccion_multi_destino_descripcion=newid_transaccion_multi_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_multi_origen_descripcion(String newid_bodega_multi_origen_descripcion)throws Exception {
		try {
			this.id_bodega_multi_origen_descripcion=newid_bodega_multi_origen_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_multi_destino_descripcion(String newid_bodega_multi_destino_descripcion)throws Exception {
		try {
			this.id_bodega_multi_destino_descripcion=newid_bodega_multi_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empresa_origen_descripcion="";this.id_sucursal_descripcion="";this.id_transaccion_origen_descripcion="";this.id_bodega_origen_descripcion="";this.id_cliente_origen_descripcion="";this.id_empresa_destino_descripcion="";this.id_sucursal_destino_descripcion="";this.id_transaccion_destino_descripcion="";this.id_bodega_destino_descripcion="";this.id_cliente_destino_descripcion="";this.con_transferencia_descripcion="";this.id_empresa_multi_destino_descripcion="";this.id_sucursal_multi_destino_descripcion="";this.id_transaccion_multi_destino_descripcion="";this.id_bodega_multi_origen_descripcion="";this.id_bodega_multi_destino_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

