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
//import com.bydan.erp.facturacion.util.DetalleGuiaRemisionConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class DetalleGuiaRemision extends DetalleGuiaRemisionAdditional implements Serializable ,Cloneable {//DetalleGuiaRemisionAdditional,GeneralEntity
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
	
	private DetalleGuiaRemision detalleguiaremisionOriginal;
	
	private Map<String, Object> mapDetalleGuiaRemision;
			
	public Map<String, Object> getMapDetalleGuiaRemision() {
		return mapDetalleGuiaRemision;
	}

	public void setMapDetalleGuiaRemision(Map<String, Object> mapDetalleGuiaRemision) {
		this.mapDetalleGuiaRemision = mapDetalleGuiaRemision;
	}
	
	public void inicializarMapDetalleGuiaRemision() {
		this.mapDetalleGuiaRemision = new HashMap<String,Object>();
	}
	
	public void setMapDetalleGuiaRemisionValue(String sKey,Object oValue) {
		this.mapDetalleGuiaRemision.put(sKey, oValue);
	}
	
	public Object getMapDetalleGuiaRemisionValue(String sKey) {
		return this.mapDetalleGuiaRemision.get(sKey);
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_guia_remision;
	
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
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_envases;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXDESCRIPCION,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXLOTE,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXLOTE_CLIENTE,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXLOTE_CLIENTE)
	private String lote_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXORDEN_COMPRA,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXORDEN_COMPRA)
	private String orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXAREA,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXAREA)
	private String area;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXMEDIDAS,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXMEDIDAS)
	private String medidas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXACABADO,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXACABADO)
	private String acabado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetalleGuiaRemisionConstantesFunciones.SREGEXACABADO2,message=DetalleGuiaRemisionConstantesFunciones.SMENSAJEREGEXACABADO2)
	private String acabado2;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public GuiaRemision guiaremision;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public CentroCosto centrocosto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String guiaremision_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String centrocosto_descripcion;
	
	
		
	public DetalleGuiaRemision () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detalleguiaremisionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_guia_remision=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_centro_costo=null;
 		this.cantidad_envases=0;
 		this.cantidad_auxiliar=0;
 		this.descripcion="";
 		this.cantidad=0;
 		this.monto=0.0;
 		this.precio=0.0;
 		this.porcentaje_descuento=0.0;
 		this.descuento=0.0;
 		this.descuento2=0.0;
 		this.descuento3=0.0;
 		this.porcentaje_iva=0.0;
 		this.iva=0.0;
 		this.total_descuento=0.0;
 		this.total_impuesto=0.0;
 		this.sub_total=0.0;
 		this.total=0.0;
 		this.lote="";
 		this.lote_cliente="";
 		this.orden_compra="";
 		this.area="";
 		this.medidas="";
 		this.acabado="";
 		this.acabado2="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.guiaremision=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.centrocosto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.guiaremision_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.centrocosto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetalleGuiaRemision (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_guia_remision,Long id_bodega,Long id_producto,Long id_unidad,Long id_centro_costo,Integer cantidad_envases,Integer cantidad_auxiliar,String descripcion,Integer cantidad,Double monto,Double precio,Double porcentaje_descuento,Double descuento,Double descuento2,Double descuento3,Double porcentaje_iva,Double iva,Double total_descuento,Double total_impuesto,Double sub_total,Double total,String lote,String lote_cliente,String orden_compra,String area,String medidas,String acabado,String acabado2) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleguiaremisionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_guia_remision=id_guia_remision;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_centro_costo=id_centro_costo;
 		this.cantidad_envases=cantidad_envases;
 		this.cantidad_auxiliar=cantidad_auxiliar;
 		this.descripcion=descripcion;
 		this.cantidad=cantidad;
 		this.monto=monto;
 		this.precio=precio;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.descuento=descuento;
 		this.descuento2=descuento2;
 		this.descuento3=descuento3;
 		this.porcentaje_iva=porcentaje_iva;
 		this.iva=iva;
 		this.total_descuento=total_descuento;
 		this.total_impuesto=total_impuesto;
 		this.sub_total=sub_total;
 		this.total=total;
 		this.lote=lote;
 		this.lote_cliente=lote_cliente;
 		this.orden_compra=orden_compra;
 		this.area=area;
 		this.medidas=medidas;
 		this.acabado=acabado;
 		this.acabado2=acabado2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetalleGuiaRemision (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_guia_remision,Long id_bodega,Long id_producto,Long id_unidad,Long id_centro_costo,Integer cantidad_envases,Integer cantidad_auxiliar,String descripcion,Integer cantidad,Double monto,Double precio,Double porcentaje_descuento,Double descuento,Double descuento2,Double descuento3,Double porcentaje_iva,Double iva,Double total_descuento,Double total_impuesto,Double sub_total,Double total,String lote,String lote_cliente,String orden_compra,String area,String medidas,String acabado,String acabado2) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detalleguiaremisionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_guia_remision=id_guia_remision;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_centro_costo=id_centro_costo;
 		this.cantidad_envases=cantidad_envases;
 		this.cantidad_auxiliar=cantidad_auxiliar;
 		this.descripcion=descripcion;
 		this.cantidad=cantidad;
 		this.monto=monto;
 		this.precio=precio;
 		this.porcentaje_descuento=porcentaje_descuento;
 		this.descuento=descuento;
 		this.descuento2=descuento2;
 		this.descuento3=descuento3;
 		this.porcentaje_iva=porcentaje_iva;
 		this.iva=iva;
 		this.total_descuento=total_descuento;
 		this.total_impuesto=total_impuesto;
 		this.sub_total=sub_total;
 		this.total=total;
 		this.lote=lote;
 		this.lote_cliente=lote_cliente;
 		this.orden_compra=orden_compra;
 		this.area=area;
 		this.medidas=medidas;
 		this.acabado=acabado;
 		this.acabado2=acabado2;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetalleGuiaRemision detalleguiaremisionLocal=null;
		
		if(object!=null) {
			detalleguiaremisionLocal=(DetalleGuiaRemision)object;
			
			if(detalleguiaremisionLocal!=null) {
				if(this.getId()!=null && detalleguiaremisionLocal.getId()!=null) {
					if(this.getId().equals(detalleguiaremisionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetalleGuiaRemisionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetalleGuiaRemisionConstantesFunciones.getDetalleGuiaRemisionDescripcion(this);
		} else {
			sDetalle=DetalleGuiaRemisionConstantesFunciones.getDetalleGuiaRemisionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetalleGuiaRemision getDetalleGuiaRemisionOriginal() {
		return this.detalleguiaremisionOriginal;
	}
	
	public void setDetalleGuiaRemisionOriginal(DetalleGuiaRemision detalleguiaremision) {
		try {
			this.detalleguiaremisionOriginal=detalleguiaremision;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetalleGuiaRemisionAdditional detalleguiaremisionAdditional=null;
	
	public DetalleGuiaRemisionAdditional getDetalleGuiaRemisionAdditional() {
		return this.detalleguiaremisionAdditional;
	}
	
	public void setDetalleGuiaRemisionAdditional(DetalleGuiaRemisionAdditional detalleguiaremisionAdditional) {
		try {
			this.detalleguiaremisionAdditional=detalleguiaremisionAdditional;
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
    
	
	public Long getid_guia_remision() {
		return this.id_guia_remision;
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
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Integer getcantidad_envases() {
		return this.cantidad_envases;
	}
    
	
	public Integer getcantidad_auxiliar() {
		return this.cantidad_auxiliar;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getporcentaje_descuento() {
		return this.porcentaje_descuento;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getdescuento2() {
		return this.descuento2;
	}
    
	
	public Double getdescuento3() {
		return this.descuento3;
	}
    
	
	public Double getporcentaje_iva() {
		return this.porcentaje_iva;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double gettotal_descuento() {
		return this.total_descuento;
	}
    
	
	public Double gettotal_impuesto() {
		return this.total_impuesto;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public String getlote_cliente() {
		return this.lote_cliente;
	}
    
	
	public String getorden_compra() {
		return this.orden_compra;
	}
    
	
	public String getarea() {
		return this.area;
	}
    
	
	public String getmedidas() {
		return this.medidas;
	}
    
	
	public String getacabado() {
		return this.acabado;
	}
    
	
	public String getacabado2() {
		return this.acabado2;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_guia_remision(Long newid_guia_remision)throws Exception
	{
		try {
			if(this.id_guia_remision!=newid_guia_remision) {
				if(newid_guia_remision==null) {
					//newid_guia_remision=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_guia_remision");
					}
				}

				this.id_guia_remision=newid_guia_remision;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_producto");
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
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
    
	public void setcantidad_envases(Integer newcantidad_envases)throws Exception
	{
		try {
			if(this.cantidad_envases!=newcantidad_envases) {
				if(newcantidad_envases==null) {
					//newcantidad_envases=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna cantidad_envases");
					}
				}

				this.cantidad_envases=newcantidad_envases;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_auxiliar(Integer newcantidad_auxiliar)throws Exception
	{
		try {
			if(this.cantidad_auxiliar!=newcantidad_auxiliar) {
				if(newcantidad_auxiliar==null) {
					//newcantidad_auxiliar=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna cantidad_auxiliar");
					}
				}

				this.cantidad_auxiliar=newcantidad_auxiliar;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_descuento(Double newporcentaje_descuento)throws Exception
	{
		try {
			if(this.porcentaje_descuento!=newporcentaje_descuento) {
				if(newporcentaje_descuento==null) {
					//newporcentaje_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna porcentaje_descuento");
					}
				}

				this.porcentaje_descuento=newporcentaje_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento(Double newdescuento)throws Exception
	{
		try {
			if(this.descuento!=newdescuento) {
				if(newdescuento==null) {
					//newdescuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento2(Double newdescuento2)throws Exception
	{
		try {
			if(this.descuento2!=newdescuento2) {
				if(newdescuento2==null) {
					//newdescuento2=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna descuento2");
					}
				}

				this.descuento2=newdescuento2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento3(Double newdescuento3)throws Exception
	{
		try {
			if(this.descuento3!=newdescuento3) {
				if(newdescuento3==null) {
					//newdescuento3=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna descuento3");
					}
				}

				this.descuento3=newdescuento3;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_iva(Double newporcentaje_iva)throws Exception
	{
		try {
			if(this.porcentaje_iva!=newporcentaje_iva) {
				if(newporcentaje_iva==null) {
					//newporcentaje_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna porcentaje_iva");
					}
				}

				this.porcentaje_iva=newporcentaje_iva;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_descuento(Double newtotal_descuento)throws Exception
	{
		try {
			if(this.total_descuento!=newtotal_descuento) {
				if(newtotal_descuento==null) {
					//newtotal_descuento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna total_descuento");
					}
				}

				this.total_descuento=newtotal_descuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_impuesto(Double newtotal_impuesto)throws Exception
	{
		try {
			if(this.total_impuesto!=newtotal_impuesto) {
				if(newtotal_impuesto==null) {
					//newtotal_impuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna total_impuesto");
					}
				}

				this.total_impuesto=newtotal_impuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_total(Double newsub_total)throws Exception
	{
		try {
			if(this.sub_total!=newsub_total) {
				if(newsub_total==null) {
					//newsub_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlote_cliente(String newlote_cliente)throws Exception
	{
		try {
			if(this.lote_cliente!=newlote_cliente) {
				if(newlote_cliente==null) {
					//newlote_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna lote_cliente");
					}
				}

				if(newlote_cliente!=null&&newlote_cliente.length()>50) {
					newlote_cliente=newlote_cliente.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote_cliente");
				}

				this.lote_cliente=newlote_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden_compra(String neworden_compra)throws Exception
	{
		try {
			if(this.orden_compra!=neworden_compra) {
				if(neworden_compra==null) {
					//neworden_compra="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna orden_compra");
					}
				}

				if(neworden_compra!=null&&neworden_compra.length()>50) {
					neworden_compra=neworden_compra.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna orden_compra");
				}

				this.orden_compra=neworden_compra;
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
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna area");
					}
				}

				if(newarea!=null&&newarea.length()>50) {
					newarea=newarea.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna area");
				}

				this.area=newarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmedidas(String newmedidas)throws Exception
	{
		try {
			if(this.medidas!=newmedidas) {
				if(newmedidas==null) {
					//newmedidas="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna medidas");
					}
				}

				if(newmedidas!=null&&newmedidas.length()>50) {
					newmedidas=newmedidas.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna medidas");
				}

				this.medidas=newmedidas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacabado(String newacabado)throws Exception
	{
		try {
			if(this.acabado!=newacabado) {
				if(newacabado==null) {
					//newacabado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna acabado");
					}
				}

				if(newacabado!=null&&newacabado.length()>50) {
					newacabado=newacabado.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna acabado");
				}

				this.acabado=newacabado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setacabado2(String newacabado2)throws Exception
	{
		try {
			if(this.acabado2!=newacabado2) {
				if(newacabado2==null) {
					//newacabado2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetalleGuiaRemision:Valor nulo no permitido en columna acabado2");
					}
				}

				if(newacabado2!=null&&newacabado2.length()>50) {
					newacabado2=newacabado2.substring(0,48);
					System.out.println("DetalleGuiaRemision:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna acabado2");
				}

				this.acabado2=newacabado2;
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

	public GuiaRemision getGuiaRemision() {
		return this.guiaremision;
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

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
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

	public String getguiaremision_descripcion() {
		return this.guiaremision_descripcion;
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

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
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


	public  void  setGuiaRemision(GuiaRemision guiaremision) {
		try {
			this.guiaremision=guiaremision;
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


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	public  void  setguiaremision_descripcion(String guiaremision_descripcion) {
		try {
			this.guiaremision_descripcion=guiaremision_descripcion;
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


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_guia_remision_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_centro_costo_descripcion="";
	
	
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
	public String getid_guia_remision_descripcion() {
		return id_guia_remision_descripcion;
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
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
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
	public void setid_guia_remision_descripcion(String newid_guia_remision_descripcion)throws Exception {
		try {
			this.id_guia_remision_descripcion=newid_guia_remision_descripcion;
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
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_guia_remision_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_centro_costo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

