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
//import com.bydan.erp.facturacion.util.DetaFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class DetaFormaPago extends DetaFormaPagoAdditional implements Serializable ,Cloneable {//DetaFormaPagoAdditional,GeneralEntity
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
	
	private DetaFormaPago detaformapagoOriginal;
	
	private Map<String, Object> mapDetaFormaPago;
			
	public Map<String, Object> getMapDetaFormaPago() {
		return mapDetaFormaPago;
	}

	public void setMapDetaFormaPago(Map<String, Object> mapDetaFormaPago) {
		this.mapDetaFormaPago = mapDetaFormaPago;
	}
	
	public void inicializarMapDetaFormaPago() {
		this.mapDetaFormaPago = new HashMap<String,Object>();
	}
	
	public void setMapDetaFormaPagoValue(String sKey,Object oValue) {
		this.mapDetaFormaPago.put(sKey, oValue);
	}
	
	public Object getMapDetaFormaPagoValue(String sKey) {
		return this.mapDetaFormaPago.get(sKey);
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
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_deta_forma_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_deta_forma_pago_factu;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double base_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetaFormaPagoConstantesFunciones.SREGEXNUMERO_RETENCION,message=DetaFormaPagoConstantesFunciones.SMENSAJEREGEXNUMERO_RETENCION)
	private String numero_retencion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_cuota;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DetaFormaPagoConstantesFunciones.SREGEXDESCRIPCION,message=DetaFormaPagoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Factura factura;
	public TipoFormaPago tipoformapago;
	public TipoDetaFormaPago tipodetaformapago;
	public DetaFormaPagoFactu detaformapagofactu;
	public CuentaContable cuentacontable;
	public TipoRetencion tiporetencion;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String factura_descripcion;
	private String tipoformapago_descripcion;
	private String tipodetaformapago_descripcion;
	private String detaformapagofactu_descripcion;
	private String cuentacontable_descripcion;
	private String tiporetencion_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<BancoFormaPago> bancoformapagos;
		
	public DetaFormaPago () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.detaformapagoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_factura=-1L;
 		this.id_tipo_forma_pago=-1L;
 		this.id_tipo_deta_forma_pago=-1L;
 		this.id_deta_forma_pago_factu=-1L;
 		this.id_cuenta_contable=null;
 		this.id_tipo_retencion=-1L;
 		this.valor=0.0;
 		this.fecha_inicial=new Date();
 		this.fecha_final=new Date();
 		this.porcentaje=0.0;
 		this.retencion=0.0;
 		this.porcentaje_retencion=0.0;
 		this.base_retencion=0.0;
 		this.valor_retencion=0.0;
 		this.numero_retencion="";
 		this.numero_dias=0;
 		this.numero_cuota=0;
 		this.descripcion="";
 		this.id_anio=null;
 		this.id_mes=null;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.factura=null;
		this.tipoformapago=null;
		this.tipodetaformapago=null;
		this.detaformapagofactu=null;
		this.cuentacontable=null;
		this.tiporetencion=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.factura_descripcion="";
		this.tipoformapago_descripcion="";
		this.tipodetaformapago_descripcion="";
		this.detaformapagofactu_descripcion="";
		this.cuentacontable_descripcion="";
		this.tiporetencion_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.bancoformapagos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DetaFormaPago (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura,Long id_tipo_forma_pago,Long id_tipo_deta_forma_pago,Long id_deta_forma_pago_factu,Long id_cuenta_contable,Long id_tipo_retencion,Double valor,Date fecha_inicial,Date fecha_final,Double porcentaje,Double retencion,Double porcentaje_retencion,Double base_retencion,Double valor_retencion,String numero_retencion,Integer numero_dias,Integer numero_cuota,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detaformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura=id_factura;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.id_tipo_deta_forma_pago=id_tipo_deta_forma_pago;
 		this.id_deta_forma_pago_factu=id_deta_forma_pago_factu;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.valor=valor;
 		this.fecha_inicial=fecha_inicial;
 		this.fecha_final=fecha_final;
 		this.porcentaje=porcentaje;
 		this.retencion=retencion;
 		this.porcentaje_retencion=porcentaje_retencion;
 		this.base_retencion=base_retencion;
 		this.valor_retencion=valor_retencion;
 		this.numero_retencion=numero_retencion;
 		this.numero_dias=numero_dias;
 		this.numero_cuota=numero_cuota;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DetaFormaPago (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_factura,Long id_tipo_forma_pago,Long id_tipo_deta_forma_pago,Long id_deta_forma_pago_factu,Long id_cuenta_contable,Long id_tipo_retencion,Double valor,Date fecha_inicial,Date fecha_final,Double porcentaje,Double retencion,Double porcentaje_retencion,Double base_retencion,Double valor_retencion,String numero_retencion,Integer numero_dias,Integer numero_cuota,String descripcion,Long id_anio,Long id_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.detaformapagoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_factura=id_factura;
 		this.id_tipo_forma_pago=id_tipo_forma_pago;
 		this.id_tipo_deta_forma_pago=id_tipo_deta_forma_pago;
 		this.id_deta_forma_pago_factu=id_deta_forma_pago_factu;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.id_tipo_retencion=id_tipo_retencion;
 		this.valor=valor;
 		this.fecha_inicial=fecha_inicial;
 		this.fecha_final=fecha_final;
 		this.porcentaje=porcentaje;
 		this.retencion=retencion;
 		this.porcentaje_retencion=porcentaje_retencion;
 		this.base_retencion=base_retencion;
 		this.valor_retencion=valor_retencion;
 		this.numero_retencion=numero_retencion;
 		this.numero_dias=numero_dias;
 		this.numero_cuota=numero_cuota;
 		this.descripcion=descripcion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DetaFormaPago detaformapagoLocal=null;
		
		if(object!=null) {
			detaformapagoLocal=(DetaFormaPago)object;
			
			if(detaformapagoLocal!=null) {
				if(this.getId()!=null && detaformapagoLocal.getId()!=null) {
					if(this.getId().equals(detaformapagoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DetaFormaPagoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DetaFormaPagoConstantesFunciones.getDetaFormaPagoDescripcion(this);
		} else {
			sDetalle=DetaFormaPagoConstantesFunciones.getDetaFormaPagoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DetaFormaPago getDetaFormaPagoOriginal() {
		return this.detaformapagoOriginal;
	}
	
	public void setDetaFormaPagoOriginal(DetaFormaPago detaformapago) {
		try {
			this.detaformapagoOriginal=detaformapago;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DetaFormaPagoAdditional detaformapagoAdditional=null;
	
	public DetaFormaPagoAdditional getDetaFormaPagoAdditional() {
		return this.detaformapagoAdditional;
	}
	
	public void setDetaFormaPagoAdditional(DetaFormaPagoAdditional detaformapagoAdditional) {
		try {
			this.detaformapagoAdditional=detaformapagoAdditional;
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
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_tipo_forma_pago() {
		return this.id_tipo_forma_pago;
	}
    
	
	public Long getid_tipo_deta_forma_pago() {
		return this.id_tipo_deta_forma_pago;
	}
    
	
	public Long getid_deta_forma_pago_factu() {
		return this.id_deta_forma_pago_factu;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Long getid_tipo_retencion() {
		return this.id_tipo_retencion;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha_inicial() {
		return this.fecha_inicial;
	}
    
	
	public Date getfecha_final() {
		return this.fecha_final;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getretencion() {
		return this.retencion;
	}
    
	
	public Double getporcentaje_retencion() {
		return this.porcentaje_retencion;
	}
    
	
	public Double getbase_retencion() {
		return this.base_retencion;
	}
    
	
	public Double getvalor_retencion() {
		return this.valor_retencion;
	}
    
	
	public String getnumero_retencion() {
		return this.numero_retencion;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
    
	
	public Integer getnumero_cuota() {
		return this.numero_cuota;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_forma_pago(Long newid_tipo_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_forma_pago!=newid_tipo_forma_pago) {
				if(newid_tipo_forma_pago==null) {
					//newid_tipo_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_tipo_forma_pago");
					}
				}

				this.id_tipo_forma_pago=newid_tipo_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_deta_forma_pago(Long newid_tipo_deta_forma_pago)throws Exception
	{
		try {
			if(this.id_tipo_deta_forma_pago!=newid_tipo_deta_forma_pago) {
				if(newid_tipo_deta_forma_pago==null) {
					//newid_tipo_deta_forma_pago=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_tipo_deta_forma_pago");
					}
				}

				this.id_tipo_deta_forma_pago=newid_tipo_deta_forma_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_deta_forma_pago_factu(Long newid_deta_forma_pago_factu)throws Exception
	{
		try {
			if(this.id_deta_forma_pago_factu!=newid_deta_forma_pago_factu) {
				if(newid_deta_forma_pago_factu==null) {
					//newid_deta_forma_pago_factu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_deta_forma_pago_factu");
					}
				}

				this.id_deta_forma_pago_factu=newid_deta_forma_pago_factu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable) {
		if(this.id_cuenta_contable==null&&newid_cuenta_contable!=null) {
			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable!=null&&!this.id_cuenta_contable.equals(newid_cuenta_contable)) {

			this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_retencion(Long newid_tipo_retencion)throws Exception
	{
		try {
			if(this.id_tipo_retencion!=newid_tipo_retencion) {
				if(newid_tipo_retencion==null) {
					//newid_tipo_retencion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna id_tipo_retencion");
					}
				}

				this.id_tipo_retencion=newid_tipo_retencion;
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicial(Date newfecha_inicial)throws Exception
	{
		try {
			if(this.fecha_inicial!=newfecha_inicial) {
				if(newfecha_inicial==null) {
					//newfecha_inicial=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna fecha_inicial");
					}
				}

				this.fecha_inicial=newfecha_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_final(Date newfecha_final)throws Exception
	{
		try {
			if(this.fecha_final!=newfecha_final) {
				if(newfecha_final==null) {
					//newfecha_final=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna fecha_final");
					}
				}

				this.fecha_final=newfecha_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setretencion(Double newretencion)throws Exception
	{
		try {
			if(this.retencion!=newretencion) {
				if(newretencion==null) {
					//newretencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna retencion");
					}
				}

				this.retencion=newretencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_retencion(Double newporcentaje_retencion)throws Exception
	{
		try {
			if(this.porcentaje_retencion!=newporcentaje_retencion) {
				if(newporcentaje_retencion==null) {
					//newporcentaje_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna porcentaje_retencion");
					}
				}

				this.porcentaje_retencion=newporcentaje_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setbase_retencion(Double newbase_retencion)throws Exception
	{
		try {
			if(this.base_retencion!=newbase_retencion) {
				if(newbase_retencion==null) {
					//newbase_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna base_retencion");
					}
				}

				this.base_retencion=newbase_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_retencion(Double newvalor_retencion)throws Exception
	{
		try {
			if(this.valor_retencion!=newvalor_retencion) {
				if(newvalor_retencion==null) {
					//newvalor_retencion=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna valor_retencion");
					}
				}

				this.valor_retencion=newvalor_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_retencion(String newnumero_retencion)throws Exception
	{
		try {
			if(this.numero_retencion!=newnumero_retencion) {
				if(newnumero_retencion==null) {
					//newnumero_retencion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna numero_retencion");
					}
				}

				if(newnumero_retencion!=null&&newnumero_retencion.length()>50) {
					newnumero_retencion=newnumero_retencion.substring(0,48);
					System.out.println("DetaFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_retencion");
				}

				this.numero_retencion=newnumero_retencion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuota(Integer newnumero_cuota)throws Exception
	{
		try {
			if(this.numero_cuota!=newnumero_cuota) {
				if(newnumero_cuota==null) {
					//newnumero_cuota=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna numero_cuota");
					}
				}

				this.numero_cuota=newnumero_cuota;
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
						System.out.println("DetaFormaPago:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>100) {
					newdescripcion=newdescripcion.substring(0,98);
					System.out.println("DetaFormaPago:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Factura getFactura() {
		return this.factura;
	}

	public TipoFormaPago getTipoFormaPago() {
		return this.tipoformapago;
	}

	public TipoDetaFormaPago getTipoDetaFormaPago() {
		return this.tipodetaformapago;
	}

	public DetaFormaPagoFactu getDetaFormaPagoFactu() {
		return this.detaformapagofactu;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	public TipoRetencion getTipoRetencion() {
		return this.tiporetencion;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
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

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String gettipoformapago_descripcion() {
		return this.tipoformapago_descripcion;
	}

	public String gettipodetaformapago_descripcion() {
		return this.tipodetaformapago_descripcion;
	}

	public String getdetaformapagofactu_descripcion() {
		return this.detaformapagofactu_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	public String gettiporetencion_descripcion() {
		return this.tiporetencion_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setFactura(Factura factura) {
		try {
			this.factura=factura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFormaPago(TipoFormaPago tipoformapago) {
		try {
			this.tipoformapago=tipoformapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDetaFormaPago(TipoDetaFormaPago tipodetaformapago) {
		try {
			this.tipodetaformapago=tipodetaformapago;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetaFormaPagoFactu(DetaFormaPagoFactu detaformapagofactu) {
		try {
			this.detaformapagofactu=detaformapagofactu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContable(CuentaContable cuentacontable) {
		try {
			this.cuentacontable=cuentacontable;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRetencion(TipoRetencion tiporetencion) {
		try {
			this.tiporetencion=tiporetencion;
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


	public  void  setfactura_descripcion(String factura_descripcion) {
		try {
			this.factura_descripcion=factura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoformapago_descripcion(String tipoformapago_descripcion) {
		try {
			this.tipoformapago_descripcion=tipoformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodetaformapago_descripcion(String tipodetaformapago_descripcion) {
		try {
			this.tipodetaformapago_descripcion=tipodetaformapago_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetaformapagofactu_descripcion(String detaformapagofactu_descripcion) {
		try {
			this.detaformapagofactu_descripcion=detaformapagofactu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontable_descripcion(String cuentacontable_descripcion) {
		try {
			this.cuentacontable_descripcion=cuentacontable_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporetencion_descripcion(String tiporetencion_descripcion) {
		try {
			this.tiporetencion_descripcion=tiporetencion_descripcion;
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


	
	
	public List<BancoFormaPago> getBancoFormaPagos() {
		return this.bancoformapagos;
	}

	
	
	public  void  setBancoFormaPagos(List<BancoFormaPago> bancoformapagos) {
		try {
			this.bancoformapagos=bancoformapagos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_factura_descripcion="";String id_tipo_forma_pago_descripcion="";String id_tipo_deta_forma_pago_descripcion="";String id_deta_forma_pago_factu_descripcion="";String id_cuenta_contable_descripcion="";String id_tipo_retencion_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
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
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_tipo_forma_pago_descripcion() {
		return id_tipo_forma_pago_descripcion;
	}
	public String getid_tipo_deta_forma_pago_descripcion() {
		return id_tipo_deta_forma_pago_descripcion;
	}
	public String getid_deta_forma_pago_factu_descripcion() {
		return id_deta_forma_pago_factu_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	public String getid_tipo_retencion_descripcion() {
		return id_tipo_retencion_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_factura_descripcion(String newid_factura_descripcion)throws Exception {
		try {
			this.id_factura_descripcion=newid_factura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_forma_pago_descripcion(String newid_tipo_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_forma_pago_descripcion=newid_tipo_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_deta_forma_pago_descripcion(String newid_tipo_deta_forma_pago_descripcion)throws Exception {
		try {
			this.id_tipo_deta_forma_pago_descripcion=newid_tipo_deta_forma_pago_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_deta_forma_pago_factu_descripcion(String newid_deta_forma_pago_factu_descripcion)throws Exception {
		try {
			this.id_deta_forma_pago_factu_descripcion=newid_deta_forma_pago_factu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descripcion(String newid_cuenta_contable_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descripcion=newid_cuenta_contable_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_retencion_descripcion(String newid_tipo_retencion_descripcion)throws Exception {
		try {
			this.id_tipo_retencion_descripcion=newid_tipo_retencion_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_factura_descripcion="";this.id_tipo_forma_pago_descripcion="";this.id_tipo_deta_forma_pago_descripcion="";this.id_deta_forma_pago_factu_descripcion="";this.id_cuenta_contable_descripcion="";this.id_tipo_retencion_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	Object bancoformapagosDescripcionReporte;
	
	
	public Object getbancoformapagosDescripcionReporte() {
		return bancoformapagosDescripcionReporte;
	}

	
	
	public  void  setbancoformapagosDescripcionReporte(Object bancoformapagos) {
		try {
			this.bancoformapagosDescripcionReporte=bancoformapagos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

