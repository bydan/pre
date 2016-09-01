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
//import com.bydan.erp.facturacion.util.DetaNotaCreditoSoliConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class DetaNotaCreditoSoli extends DetaNotaCreditoSoliAdditional implements Serializable ,Cloneable {//DetaNotaCreditoSoliAdditional,GeneralEntity
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
	
	private DetaNotaCreditoSoli detanotacreditosoliOriginal;
	
	private Map<String, Object> mapDetaNotaCreditoSoli;
			
	public Map<String, Object> getMapDetaNotaCreditoSoli() {
		return mapDetaNotaCreditoSoli;
	}

	public void setMapDetaNotaCreditoSoli(Map<String, Object> mapDetaNotaCreditoSoli) {
		this.mapDetaNotaCreditoSoli = mapDetaNotaCreditoSoli;
	}
	
	public void inicializarMapDetaNotaCreditoSoli() {
		this.mapDetaNotaCreditoSoli = new HashMap<String,Object>();
	}
	
	public void setMapDetaNotaCreditoSoliValue(String sKey,Object oValue) {
		this.mapDetaNotaCreditoSoli.put(sKey, oValue);
	}
	
	public Object getMapDetaNotaCreditoSoliValue(String sKey) {
		return this.mapDetaNotaCreditoSoli.get(sKey);
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
	private Long id_nota_credito_soli;
	
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_devolucion_empresa;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_descuen;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=DetaNotaCreditoSoliConstantesFunciones.SREGEXDESCRIPCION,message=DetaNotaCreditoSoliConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetaNotaCreditoSoliConstantesFunciones.SREGEXCODIGO_LOTE,message=DetaNotaCreditoSoliConstantesFunciones.SMENSAJEREGEXCODIGO_LOTE)
	private String codigo_lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetaNotaCreditoSoliConstantesFunciones.SREGEXNUMERO_CAJA,message=DetaNotaCreditoSoliConstantesFunciones.SMENSAJEREGEXNUMERO_CAJA)
	private String numero_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean incluye_impuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcen_ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Anio anio;
	public Mes mes;
	public NotaCreditoSoli notacreditosoli;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public Empaque empaque;
	public TipoDevolucionEmpresa tipodevolucionempresa;
	public CentroCosto centrocosto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	private String notacreditosoli_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String empaque_descripcion;
	private String tipodevolucionempresa_descripcion;
	private String centrocosto_descripcion;
	
	
		
	public DetaNotaCreditoSoli () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detanotacreditosoliOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_nota_credito_soli=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_empaque=null;
 		this.id_tipo_devolucion_empresa=-1L;
 		this.id_centro_costo=null;
 		this.cantidad=0;
 		this.precio=0.0;
 		this.porcen_descuen=0.0;
 		this.descuento=0.0;
 		this.impuesto=0.0;
 		this.porcen_iva=0.0;
 		this.total=0.0;
 		this.descripcion="";
 		this.codigo_lote="";
 		this.numero_caja="";
 		this.descuento2=0.0;
 		this.costo=0.0;
 		this.incluye_impuesto=false;
 		this.porcen_ice=0.0;
 		this.fecha_emision=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.anio=null;
		this.mes=null;
		this.notacreditosoli=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.empaque=null;
		this.tipodevolucionempresa=null;
		this.centrocosto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.notacreditosoli_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.empaque_descripcion="";
		this.tipodevolucionempresa_descripcion="";
		this.centrocosto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetaNotaCreditoSoli (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_nota_credito_soli,Long id_bodega,Long id_producto,Long id_unidad,Long id_empaque,Long id_tipo_devolucion_empresa,Long id_centro_costo,Integer cantidad,Double precio,Double porcen_descuen,Double descuento,Double impuesto,Double porcen_iva,Double total,String descripcion,String codigo_lote,String numero_caja,Double descuento2,Double costo,Boolean incluye_impuesto,Double porcen_ice,Date fecha_emision) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detanotacreditosoliOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_nota_credito_soli=id_nota_credito_soli;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_empaque=id_empaque;
 		this.id_tipo_devolucion_empresa=id_tipo_devolucion_empresa;
 		this.id_centro_costo=id_centro_costo;
 		this.cantidad=cantidad;
 		this.precio=precio;
 		this.porcen_descuen=porcen_descuen;
 		this.descuento=descuento;
 		this.impuesto=impuesto;
 		this.porcen_iva=porcen_iva;
 		this.total=total;
 		this.descripcion=descripcion;
 		this.codigo_lote=codigo_lote;
 		this.numero_caja=numero_caja;
 		this.descuento2=descuento2;
 		this.costo=costo;
 		this.incluye_impuesto=incluye_impuesto;
 		this.porcen_ice=porcen_ice;
 		this.fecha_emision=fecha_emision;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetaNotaCreditoSoli (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_anio,Long id_mes,Long id_nota_credito_soli,Long id_bodega,Long id_producto,Long id_unidad,Long id_empaque,Long id_tipo_devolucion_empresa,Long id_centro_costo,Integer cantidad,Double precio,Double porcen_descuen,Double descuento,Double impuesto,Double porcen_iva,Double total,String descripcion,String codigo_lote,String numero_caja,Double descuento2,Double costo,Boolean incluye_impuesto,Double porcen_ice,Date fecha_emision) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detanotacreditosoliOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_nota_credito_soli=id_nota_credito_soli;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_empaque=id_empaque;
 		this.id_tipo_devolucion_empresa=id_tipo_devolucion_empresa;
 		this.id_centro_costo=id_centro_costo;
 		this.cantidad=cantidad;
 		this.precio=precio;
 		this.porcen_descuen=porcen_descuen;
 		this.descuento=descuento;
 		this.impuesto=impuesto;
 		this.porcen_iva=porcen_iva;
 		this.total=total;
 		this.descripcion=descripcion;
 		this.codigo_lote=codigo_lote;
 		this.numero_caja=numero_caja;
 		this.descuento2=descuento2;
 		this.costo=costo;
 		this.incluye_impuesto=incluye_impuesto;
 		this.porcen_ice=porcen_ice;
 		this.fecha_emision=fecha_emision;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetaNotaCreditoSoli detanotacreditosoliLocal=null;
		
		if(object!=null) {
			detanotacreditosoliLocal=(DetaNotaCreditoSoli)object;
			
			if(detanotacreditosoliLocal!=null) {
				if(this.getId()!=null && detanotacreditosoliLocal.getId()!=null) {
					if(this.getId().equals(detanotacreditosoliLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetaNotaCreditoSoliConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetaNotaCreditoSoliConstantesFunciones.getDetaNotaCreditoSoliDescripcion(this);
		} else {
			sDetalle=DetaNotaCreditoSoliConstantesFunciones.getDetaNotaCreditoSoliDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetaNotaCreditoSoli getDetaNotaCreditoSoliOriginal() {
		return this.detanotacreditosoliOriginal;
	}
	
	public void setDetaNotaCreditoSoliOriginal(DetaNotaCreditoSoli detanotacreditosoli) {
		try {
			this.detanotacreditosoliOriginal=detanotacreditosoli;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetaNotaCreditoSoliAdditional detanotacreditosoliAdditional=null;
	
	public DetaNotaCreditoSoliAdditional getDetaNotaCreditoSoliAdditional() {
		return this.detanotacreditosoliAdditional;
	}
	
	public void setDetaNotaCreditoSoliAdditional(DetaNotaCreditoSoliAdditional detanotacreditosoliAdditional) {
		try {
			this.detanotacreditosoliAdditional=detanotacreditosoliAdditional;
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
    
	
	public Long getid_nota_credito_soli() {
		return this.id_nota_credito_soli;
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
    
	
	public Long getid_tipo_devolucion_empresa() {
		return this.id_tipo_devolucion_empresa;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getporcen_descuen() {
		return this.porcen_descuen;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double getimpuesto() {
		return this.impuesto;
	}
    
	
	public Double getporcen_iva() {
		return this.porcen_iva;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public String getcodigo_lote() {
		return this.codigo_lote;
	}
    
	
	public String getnumero_caja() {
		return this.numero_caja;
	}
    
	
	public Double getdescuento2() {
		return this.descuento2;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Boolean getincluye_impuesto() {
		return this.incluye_impuesto;
	}
    
	
	public Double getporcen_ice() {
		return this.porcen_ice;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_periodo");
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
    
	public void setid_nota_credito_soli(Long newid_nota_credito_soli)throws Exception
	{
		try {
			if(this.id_nota_credito_soli!=newid_nota_credito_soli) {
				if(newid_nota_credito_soli==null) {
					//newid_nota_credito_soli=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_nota_credito_soli");
					}
				}

				this.id_nota_credito_soli=newid_nota_credito_soli;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_producto");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_unidad");
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
    
	public void setid_tipo_devolucion_empresa(Long newid_tipo_devolucion_empresa)throws Exception
	{
		try {
			if(this.id_tipo_devolucion_empresa!=newid_tipo_devolucion_empresa) {
				if(newid_tipo_devolucion_empresa==null) {
					//newid_tipo_devolucion_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna id_tipo_devolucion_empresa");
					}
				}

				this.id_tipo_devolucion_empresa=newid_tipo_devolucion_empresa;
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
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna cantidad");
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_descuen(Double newporcen_descuen)throws Exception
	{
		try {
			if(this.porcen_descuen!=newporcen_descuen) {
				if(newporcen_descuen==null) {
					//newporcen_descuen=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna porcen_descuen");
					}
				}

				this.porcen_descuen=newporcen_descuen;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setimpuesto(Double newimpuesto)throws Exception
	{
		try {
			if(this.impuesto!=newimpuesto) {
				if(newimpuesto==null) {
					//newimpuesto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna impuesto");
					}
				}

				this.impuesto=newimpuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_iva(Double newporcen_iva)throws Exception
	{
		try {
			if(this.porcen_iva!=newporcen_iva) {
				if(newporcen_iva==null) {
					//newporcen_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna porcen_iva");
					}
				}

				this.porcen_iva=newporcen_iva;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DetaNotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_lote(String newcodigo_lote)throws Exception
	{
		try {
			if(this.codigo_lote!=newcodigo_lote) {
				if(newcodigo_lote==null) {
					//newcodigo_lote="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna codigo_lote");
					}
				}

				if(newcodigo_lote!=null&&newcodigo_lote.length()>50) {
					newcodigo_lote=newcodigo_lote.substring(0,48);
					System.out.println("DetaNotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_lote");
				}

				this.codigo_lote=newcodigo_lote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_caja(String newnumero_caja)throws Exception
	{
		try {
			if(this.numero_caja!=newnumero_caja) {
				if(newnumero_caja==null) {
					//newnumero_caja="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna numero_caja");
					}
				}

				if(newnumero_caja!=null&&newnumero_caja.length()>50) {
					newnumero_caja=newnumero_caja.substring(0,48);
					System.out.println("DetaNotaCreditoSoli:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_caja");
				}

				this.numero_caja=newnumero_caja;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna descuento2");
					}
				}

				this.descuento2=newdescuento2;
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
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setincluye_impuesto(Boolean newincluye_impuesto)throws Exception
	{
		try {
			if(this.incluye_impuesto!=newincluye_impuesto) {
				if(newincluye_impuesto==null) {
					//newincluye_impuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna incluye_impuesto");
					}
				}

				this.incluye_impuesto=newincluye_impuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcen_ice(Double newporcen_ice)throws Exception
	{
		try {
			if(this.porcen_ice!=newporcen_ice) {
				if(newporcen_ice==null) {
					//newporcen_ice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna porcen_ice");
					}
				}

				this.porcen_ice=newporcen_ice;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaNotaCreditoSoli:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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

	public NotaCreditoSoli getNotaCreditoSoli() {
		return this.notacreditosoli;
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

	public TipoDevolucionEmpresa getTipoDevolucionEmpresa() {
		return this.tipodevolucionempresa;
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

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getnotacreditosoli_descripcion() {
		return this.notacreditosoli_descripcion;
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

	public String gettipodevolucionempresa_descripcion() {
		return this.tipodevolucionempresa_descripcion;
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


	public  void  setNotaCreditoSoli(NotaCreditoSoli notacreditosoli) {
		try {
			this.notacreditosoli=notacreditosoli;
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


	public  void  setTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa) {
		try {
			this.tipodevolucionempresa=tipodevolucionempresa;
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


	public  void  setnotacreditosoli_descripcion(String notacreditosoli_descripcion) {
		try {
			this.notacreditosoli_descripcion=notacreditosoli_descripcion;
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


	public  void  settipodevolucionempresa_descripcion(String tipodevolucionempresa_descripcion) {
		try {
			this.tipodevolucionempresa_descripcion=tipodevolucionempresa_descripcion;
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
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_nota_credito_soli_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_empaque_descripcion="";String id_tipo_devolucion_empresa_descripcion="";String id_centro_costo_descripcion="";String incluye_impuesto_descripcion="";
	
	
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
	public String getid_nota_credito_soli_descripcion() {
		return id_nota_credito_soli_descripcion;
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
	public String getid_tipo_devolucion_empresa_descripcion() {
		return id_tipo_devolucion_empresa_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getincluye_impuesto_descripcion() {
		return incluye_impuesto_descripcion;
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
	public void setid_nota_credito_soli_descripcion(String newid_nota_credito_soli_descripcion)throws Exception {
		try {
			this.id_nota_credito_soli_descripcion=newid_nota_credito_soli_descripcion;
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
	public void setid_tipo_devolucion_empresa_descripcion(String newid_tipo_devolucion_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_devolucion_empresa_descripcion=newid_tipo_devolucion_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion) {
		this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
	}
	public void setincluye_impuesto_descripcion(String newincluye_impuesto_descripcion)throws Exception {
		try {
			this.incluye_impuesto_descripcion=newincluye_impuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_nota_credito_soli_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_empaque_descripcion="";this.id_tipo_devolucion_empresa_descripcion="";this.id_centro_costo_descripcion="";this.incluye_impuesto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

