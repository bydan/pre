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
//import com.bydan.erp.facturacion.util.DetalleProformaConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class DetalleProforma extends DetalleProformaAdditional implements Serializable ,Cloneable {//DetalleProformaAdditional,GeneralEntity
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
	
	private DetalleProforma detalleproformaOriginal;
	
	private Map<String, Object> mapDetalleProforma;
			
	public Map<String, Object> getMapDetalleProforma() {
		return mapDetalleProforma;
	}

	public void setMapDetalleProforma(Map<String, Object> mapDetalleProforma) {
		this.mapDetalleProforma = mapDetalleProforma;
	}
	
	public void inicializarMapDetalleProforma() {
		this.mapDetalleProforma = new HashMap<String,Object>();
	}
	
	public void setMapDetalleProformaValue(String sKey,Object oValue) {
		this.mapDetalleProforma.put(sKey, oValue);
	}
	
	public Object getMapDetalleProformaValue(String sKey) {
		return this.mapDetalleProforma.get(sKey);
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
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_empaque;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_detalle_proforma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProformaConstantesFunciones.SREGEXDESCRIPCION,message=DetalleProformaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cantidad_envases;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProformaConstantesFunciones.SREGEXLOTE,message=DetalleProformaConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProformaConstantesFunciones.SREGEXAREA,message=DetalleProformaConstantesFunciones.SMENSAJEREGEXAREA)
	private String area;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetalleProformaConstantesFunciones.SREGEXMEDIDA,message=DetalleProformaConstantesFunciones.SMENSAJEREGEXMEDIDA)
	private String medida;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public Proforma proforma;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public Empaque empaque;
	public CentroCosto centrocosto;
	public EstadoDetalleProforma estadodetalleproforma;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String proforma_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String empaque_descripcion;
	private String centrocosto_descripcion;
	private String estadodetalleproforma_descripcion;
	
	
		
	public DetalleProforma () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleproformaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_proforma=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_empaque=null;
 		this.id_centro_costo=null;
 		this.id_estado_detalle_proforma=-1L;
 		this.descripcion="";
 		this.cantidad_envases=0.0;
 		this.cantidad=0;
 		this.precio=0.0;
 		this.iva=0.0;
 		this.descuento_porcentaje=0.0;
 		this.descuento_valor=0.0;
 		this.lote="";
 		this.total=0.0;
 		this.ice=0.0;
 		this.costo=0.0;
 		this.utilidad=0.0;
 		this.area="";
 		this.medida="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.proforma=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.empaque=null;
		this.centrocosto=null;
		this.estadodetalleproforma=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.proforma_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.empaque_descripcion="";
		this.centrocosto_descripcion="";
		this.estadodetalleproforma_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleProforma (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_proforma,Long id_bodega,Long id_producto,Long id_unidad,Long id_empaque,Long id_centro_costo,Long id_estado_detalle_proforma,String descripcion,Double cantidad_envases,Integer cantidad,Double precio,Double iva,Double descuento_porcentaje,Double descuento_valor,String lote,Double total,Double ice,Double costo,Double utilidad,String area,String medida) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_proforma=id_proforma;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_empaque=id_empaque;
 		this.id_centro_costo=id_centro_costo;
 		this.id_estado_detalle_proforma=id_estado_detalle_proforma;
 		this.descripcion=descripcion;
 		this.cantidad_envases=cantidad_envases;
 		this.cantidad=cantidad;
 		this.precio=precio;
 		this.iva=iva;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.descuento_valor=descuento_valor;
 		this.lote=lote;
 		this.total=total;
 		this.ice=ice;
 		this.costo=costo;
 		this.utilidad=utilidad;
 		this.area=area;
 		this.medida=medida;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleProforma (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_proforma,Long id_bodega,Long id_producto,Long id_unidad,Long id_empaque,Long id_centro_costo,Long id_estado_detalle_proforma,String descripcion,Double cantidad_envases,Integer cantidad,Double precio,Double iva,Double descuento_porcentaje,Double descuento_valor,String lote,Double total,Double ice,Double costo,Double utilidad,String area,String medida) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleproformaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_proforma=id_proforma;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_empaque=id_empaque;
 		this.id_centro_costo=id_centro_costo;
 		this.id_estado_detalle_proforma=id_estado_detalle_proforma;
 		this.descripcion=descripcion;
 		this.cantidad_envases=cantidad_envases;
 		this.cantidad=cantidad;
 		this.precio=precio;
 		this.iva=iva;
 		this.descuento_porcentaje=descuento_porcentaje;
 		this.descuento_valor=descuento_valor;
 		this.lote=lote;
 		this.total=total;
 		this.ice=ice;
 		this.costo=costo;
 		this.utilidad=utilidad;
 		this.area=area;
 		this.medida=medida;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleProforma detalleproformaLocal=null;
		
		if(object!=null) {
			detalleproformaLocal=(DetalleProforma)object;
			
			if(detalleproformaLocal!=null) {
				if(this.getId()!=null && detalleproformaLocal.getId()!=null) {
					if(this.getId().equals(detalleproformaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleProformaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleProformaConstantesFunciones.getDetalleProformaDescripcion(this);
		} else {
			sDetalle=DetalleProformaConstantesFunciones.getDetalleProformaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleProforma getDetalleProformaOriginal() {
		return this.detalleproformaOriginal;
	}
	
	public void setDetalleProformaOriginal(DetalleProforma detalleproforma) {
		try {
			this.detalleproformaOriginal=detalleproforma;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleProformaAdditional detalleproformaAdditional=null;
	
	public DetalleProformaAdditional getDetalleProformaAdditional() {
		return this.detalleproformaAdditional;
	}
	
	public void setDetalleProformaAdditional(DetalleProformaAdditional detalleproformaAdditional) {
		try {
			this.detalleproformaAdditional=detalleproformaAdditional;
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
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_proforma() {
		return this.id_proforma;
	}
    
	
	public Long getid_bodega() {
		return this.id_bodega;
	}
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Long getid_empaque() {
		return this.id_empaque;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_estado_detalle_proforma() {
		return this.id_estado_detalle_proforma;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getcantidad_envases() {
		return this.cantidad_envases;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getdescuento_porcentaje() {
		return this.descuento_porcentaje;
	}
    
	
	public Double getdescuento_valor() {
		return this.descuento_valor;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getutilidad() {
		return this.utilidad;
	}
    
	
	public String getarea() {
		return this.area;
	}
    
	
	public String getmedida() {
		return this.medida;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setid_proforma(Long newid_proforma)throws Exception
	{
		try {
			if(this.id_proforma!=newid_proforma) {
				if(newid_proforma==null) {
					//newid_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_proforma");
					}
				}

				this.id_proforma=newid_proforma;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empaque(Long newid_empaque) {
		if(this.id_empaque==null&&newid_empaque!=null) {
			this.id_empaque=newid_empaque;
				this.setIsChanged(true);
		}

		if(this.id_empaque!=null&&!this.id_empaque.equals(newid_empaque)) {

			this.id_empaque=newid_empaque;
				this.setIsChanged(true);
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
    
	public void setid_estado_detalle_proforma(Long newid_estado_detalle_proforma)throws Exception
	{
		try {
			if(this.id_estado_detalle_proforma!=newid_estado_detalle_proforma) {
				if(newid_estado_detalle_proforma==null) {
					//newid_estado_detalle_proforma=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna id_estado_detalle_proforma");
					}
				}

				this.id_estado_detalle_proforma=newid_estado_detalle_proforma;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetalleProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_envases(Double newcantidad_envases)throws Exception
	{
		try {
			if(this.cantidad_envases!=newcantidad_envases) {
				if(newcantidad_envases==null) {
					//newcantidad_envases=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna cantidad_envases");
					}
				}

				this.cantidad_envases=newcantidad_envases;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setprecio(Double newprecio)throws Exception
	{
		try {
			if(this.precio!=newprecio) {
				if(newprecio==null) {
					//newprecio=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_porcentaje(Double newdescuento_porcentaje)throws Exception
	{
		try {
			if(this.descuento_porcentaje!=newdescuento_porcentaje) {
				if(newdescuento_porcentaje==null) {
					//newdescuento_porcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna descuento_porcentaje");
					}
				}

				this.descuento_porcentaje=newdescuento_porcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_valor(Double newdescuento_valor)throws Exception
	{
		try {
			if(this.descuento_valor!=newdescuento_valor) {
				if(newdescuento_valor==null) {
					//newdescuento_valor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna descuento_valor");
					}
				}

				this.descuento_valor=newdescuento_valor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote(String newlote)throws Exception
	{
		try {
			if(this.lote!=newlote) {
				if(newlote==null) {
					//newlote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("DetalleProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("DetalleProforma:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad(Double newutilidad)throws Exception
	{
		try {
			if(this.utilidad!=newutilidad) {
				if(newutilidad==null) {
					//newutilidad=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna utilidad");
					}
				}

				this.utilidad=newutilidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setarea(String newarea)throws Exception
	{
		try {
			if(this.area!=newarea) {
				if(newarea==null) {
					//newarea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna area");
					}
				}

				if(newarea!=null&&newarea.length()>100) {
					newarea=newarea.substring(0,98);
					System.out.println("DetalleProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna area");
				}

				this.area=newarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmedida(String newmedida)throws Exception
	{
		try {
			if(this.medida!=newmedida) {
				if(newmedida==null) {
					//newmedida="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleProforma:Valor nulo no permitido en columna medida");
					}
				}

				if(newmedida!=null&&newmedida.length()>100) {
					newmedida=newmedida.substring(0,98);
					System.out.println("DetalleProforma:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna medida");
				}

				this.medida=newmedida;
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

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public Empaque getEmpaque() {
		return this.empaque;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public EstadoDetalleProforma getEstadoDetalleProforma() {
		return this.estadodetalleproforma;
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

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getproforma_descripcion() {
		return this.proforma_descripcion;
	}

	public String getbodega_descripcion() {
		return this.bodega_descripcion;
	}

	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getempaque_descripcion() {
		return this.empaque_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getestadodetalleproforma_descripcion() {
		return this.estadodetalleproforma_descripcion;
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


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
		} catch(Exception e) {
			;
		}
	}


	public  void  setProforma(Proforma proforma) {
		try {
			this.proforma=proforma;
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


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpaque(Empaque empaque) {
		try {
			this.empaque=empaque;
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


	public  void  setEstadoDetalleProforma(EstadoDetalleProforma estadodetalleproforma) {
		try {
			this.estadodetalleproforma=estadodetalleproforma;
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


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setproforma_descripcion(String proforma_descripcion) {
		try {
			this.proforma_descripcion=proforma_descripcion;
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


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempaque_descripcion(String empaque_descripcion) {
		try {
			this.empaque_descripcion=empaque_descripcion;
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


	public  void  setestadodetalleproforma_descripcion(String estadodetalleproforma_descripcion) {
		try {
			this.estadodetalleproforma_descripcion=estadodetalleproforma_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_proforma_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_empaque_descripcion="";String id_centro_costo_descripcion="";String id_estado_detalle_proforma_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_proforma_descripcion() {
		return id_proforma_descripcion;
	}
	public String getid_bodega_descripcion() {
		return id_bodega_descripcion;
	}
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_empaque_descripcion() {
		return id_empaque_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_estado_detalle_proforma_descripcion() {
		return id_estado_detalle_proforma_descripcion;
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
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_proforma_descripcion(String newid_proforma_descripcion)throws Exception {
		try {
			this.id_proforma_descripcion=newid_proforma_descripcion;
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
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empaque_descripcion(String newid_empaque_descripcion) {
		this.id_empaque_descripcion=newid_empaque_descripcion;
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setid_estado_detalle_proforma_descripcion(String newid_estado_detalle_proforma_descripcion)throws Exception {
		try {
			this.id_estado_detalle_proforma_descripcion=newid_estado_detalle_proforma_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_proforma_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_empaque_descripcion="";this.id_centro_costo_descripcion="";this.id_estado_detalle_proforma_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

