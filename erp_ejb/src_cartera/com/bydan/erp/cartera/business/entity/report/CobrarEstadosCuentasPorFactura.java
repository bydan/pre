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
package com.bydan.erp.cartera.business.entity.report;

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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.cartera.util.CobrarEstadosCuentasPorFacturaConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CobrarEstadosCuentasPorFactura extends CobrarEstadosCuentasPorFacturaAdditional implements Serializable ,Cloneable {//CobrarEstadosCuentasPorFacturaAdditional,GeneralEntity
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
	
	private CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfacturaOriginal;
	
	private Map<String, Object> mapCobrarEstadosCuentasPorFactura;
			
	public Map<String, Object> getMapCobrarEstadosCuentasPorFactura() {
		return mapCobrarEstadosCuentasPorFactura;
	}

	public void setMapCobrarEstadosCuentasPorFactura(Map<String, Object> mapCobrarEstadosCuentasPorFactura) {
		this.mapCobrarEstadosCuentasPorFactura = mapCobrarEstadosCuentasPorFactura;
	}
	
	public void inicializarMapCobrarEstadosCuentasPorFactura() {
		this.mapCobrarEstadosCuentasPorFactura = new HashMap<String,Object>();
	}
	
	public void setMapCobrarEstadosCuentasPorFacturaValue(String sKey,Object oValue) {
		this.mapCobrarEstadosCuentasPorFactura.put(sKey, oValue);
	}
	
	public Object getMapCobrarEstadosCuentasPorFacturaValue(String sKey) {
		return this.mapCobrarEstadosCuentasPorFactura.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNOMBRE_CUENTA_CONTABLE,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE)
	private String nombre_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNOMBRE_CIUDAD,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_CIUDAD)
	private String nombre_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNOMBRE_ZONA,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_ZONA)
	private String nombre_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXRUC,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXREPRESENTANTE,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXREPRESENTANTE)
	private String representante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXOBSERVACION,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNOMBRE_TRANSACCION,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNOMBRE_TRANSACCION)
	private String nombre_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vence;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXNUMERO_FACTURA,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double debito_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double credito_mone_local;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXDIRECCION_DIRECCION,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXDIRECCION_DIRECCION)
	private String direccion_direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=CobrarEstadosCuentasPorFacturaConstantesFunciones.SREGEXTELEFONO_TELEFONO,message=CobrarEstadosCuentasPorFacturaConstantesFunciones.SMENSAJEREGEXTELEFONO_TELEFONO)
	private String telefono_telefono;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public CobrarEstadosCuentasPorFactura () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cobrarestadoscuentasporfacturaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.fecha_vence_desde=new Date();
 		this.fecha_vence_hasta=new Date();
 		this.nombre_cuenta_contable="";
 		this.nombre_ciudad="";
 		this.nombre_zona="";
 		this.nombre_completo="";
 		this.ruc="";
 		this.representante="";
 		this.dia_pago=0;
 		this.hora_pago=new Time((new Date()).getTime());
 		this.observacion="";
 		this.nombre_transaccion="";
 		this.fecha_vence=new Date();
 		this.fecha_emision=new Date();
 		this.numero_comprobante="";
 		this.numero_factura="";
 		this.debito_mone_local=0.0;
 		this.credito_mone_local=0.0;
 		this.direccion_direccion="";
 		this.telefono_telefono="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CobrarEstadosCuentasPorFactura (Long id,Date versionRow,String nombre_cuenta_contable,String nombre_ciudad,String nombre_zona,String nombre_completo,String ruc,String representante,Integer dia_pago,Time hora_pago,String observacion,String nombre_transaccion,Date fecha_vence,Date fecha_emision,String numero_comprobante,String numero_factura,Double debito_mone_local,Double credito_mone_local,String direccion_direccion,String telefono_telefono) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarestadoscuentasporfacturaOriginal=this;
		
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_completo=nombre_completo;
 		this.ruc=ruc;
 		this.representante=representante;
 		this.dia_pago=dia_pago;
 		this.hora_pago=hora_pago;
 		this.observacion=observacion;
 		this.nombre_transaccion=nombre_transaccion;
 		this.fecha_vence=fecha_vence;
 		this.fecha_emision=fecha_emision;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CobrarEstadosCuentasPorFactura (String nombre_cuenta_contable,String nombre_ciudad,String nombre_zona,String nombre_completo,String ruc,String representante,Integer dia_pago,Time hora_pago,String observacion,String nombre_transaccion,Date fecha_vence,Date fecha_emision,String numero_comprobante,String numero_factura,Double debito_mone_local,Double credito_mone_local,String direccion_direccion,String telefono_telefono) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cobrarestadoscuentasporfacturaOriginal=this;
		
 		this.nombre_cuenta_contable=nombre_cuenta_contable;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_completo=nombre_completo;
 		this.ruc=ruc;
 		this.representante=representante;
 		this.dia_pago=dia_pago;
 		this.hora_pago=hora_pago;
 		this.observacion=observacion;
 		this.nombre_transaccion=nombre_transaccion;
 		this.fecha_vence=fecha_vence;
 		this.fecha_emision=fecha_emision;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.debito_mone_local=debito_mone_local;
 		this.credito_mone_local=credito_mone_local;
 		this.direccion_direccion=direccion_direccion;
 		this.telefono_telefono=telefono_telefono;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public CobrarEstadosCuentasPorFactura getCobrarEstadosCuentasPorFacturaOriginal() {
		return this.cobrarestadoscuentasporfacturaOriginal;
	}
	
	public void setCobrarEstadosCuentasPorFacturaOriginal(CobrarEstadosCuentasPorFactura cobrarestadoscuentasporfactura) {
		try {
			this.cobrarestadoscuentasporfacturaOriginal=cobrarestadoscuentasporfactura;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CobrarEstadosCuentasPorFacturaAdditional cobrarestadoscuentasporfacturaAdditional=null;
	
	public CobrarEstadosCuentasPorFacturaAdditional getCobrarEstadosCuentasPorFacturaAdditional() {
		return this.cobrarestadoscuentasporfacturaAdditional;
	}
	
	public void setCobrarEstadosCuentasPorFacturaAdditional(CobrarEstadosCuentasPorFacturaAdditional cobrarestadoscuentasporfacturaAdditional) {
		try {
			this.cobrarestadoscuentasporfacturaAdditional=cobrarestadoscuentasporfacturaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public Date getfecha_vence_desde() {
		return this.fecha_vence_desde;
	}
    
	
	public Date getfecha_vence_hasta() {
		return this.fecha_vence_hasta;
	}
    
	
	public String getnombre_cuenta_contable() {
		return this.nombre_cuenta_contable;
	}
    
	
	public String getnombre_ciudad() {
		return this.nombre_ciudad;
	}
    
	
	public String getnombre_zona() {
		return this.nombre_zona;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getrepresentante() {
		return this.representante;
	}
    
	
	public Integer getdia_pago() {
		return this.dia_pago;
	}
    
	
	public Time gethora_pago() {
		return this.hora_pago;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
    
	
	public String getnombre_transaccion() {
		return this.nombre_transaccion;
	}
    
	
	public Date getfecha_vence() {
		return this.fecha_vence;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Double getdebito_mone_local() {
		return this.debito_mone_local;
	}
    
	
	public Double getcredito_mone_local() {
		return this.credito_mone_local;
	}
    
	
	public String getdireccion_direccion() {
		return this.direccion_direccion;
	}
    
	
	public String gettelefono_telefono() {
		return this.telefono_telefono;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence_desde(Date newfecha_vence_desde)throws Exception
	{
		try {
			if(this.fecha_vence_desde!=newfecha_vence_desde) {
				if(newfecha_vence_desde==null) {
					//newfecha_vence_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_vence_desde");
					}
				}

				this.fecha_vence_desde=newfecha_vence_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence_hasta(Date newfecha_vence_hasta)throws Exception
	{
		try {
			if(this.fecha_vence_hasta!=newfecha_vence_hasta) {
				if(newfecha_vence_hasta==null) {
					//newfecha_vence_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_vence_hasta");
					}
				}

				this.fecha_vence_hasta=newfecha_vence_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cuenta_contable(String newnombre_cuenta_contable)throws Exception
	{
		try {
			if(this.nombre_cuenta_contable!=newnombre_cuenta_contable) {
				if(newnombre_cuenta_contable==null) {
					//newnombre_cuenta_contable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna nombre_cuenta_contable");
					}
				}

				if(newnombre_cuenta_contable!=null&&newnombre_cuenta_contable.length()>150) {
					newnombre_cuenta_contable=newnombre_cuenta_contable.substring(0,148);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cuenta_contable");
				}

				this.nombre_cuenta_contable=newnombre_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ciudad(String newnombre_ciudad)throws Exception
	{
		try {
			if(this.nombre_ciudad!=newnombre_ciudad) {
				if(newnombre_ciudad==null) {
					//newnombre_ciudad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna nombre_ciudad");
					}
				}

				if(newnombre_ciudad!=null&&newnombre_ciudad.length()>200) {
					newnombre_ciudad=newnombre_ciudad.substring(0,198);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_ciudad");
				}

				this.nombre_ciudad=newnombre_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_zona(String newnombre_zona)throws Exception
	{
		try {
			if(this.nombre_zona!=newnombre_zona) {
				if(newnombre_zona==null) {
					//newnombre_zona="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna nombre_zona");
					}
				}

				if(newnombre_zona!=null&&newnombre_zona.length()>50) {
					newnombre_zona=newnombre_zona.substring(0,48);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_zona");
				}

				this.nombre_zona=newnombre_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo(String newnombre_completo)throws Exception
	{
		try {
			if(this.nombre_completo!=newnombre_completo) {
				if(newnombre_completo==null) {
					//newnombre_completo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc(String newruc)throws Exception
	{
		try {
			if(this.ruc!=newruc) {
				if(newruc==null) {
					//newruc="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setrepresentante(String newrepresentante)throws Exception
	{
		try {
			if(this.representante!=newrepresentante) {
				if(newrepresentante==null) {
					//newrepresentante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna representante");
					}
				}

				if(newrepresentante!=null&&newrepresentante.length()>100) {
					newrepresentante=newrepresentante.substring(0,98);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna representante");
				}

				this.representante=newrepresentante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_pago(Integer newdia_pago)throws Exception
	{
		try {
			if(this.dia_pago!=newdia_pago) {
				if(newdia_pago==null) {
					//newdia_pago=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna dia_pago");
					}
				}

				this.dia_pago=newdia_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora_pago(Time newhora_pago)throws Exception
	{
		try {
			if(this.hora_pago!=newhora_pago) {
				if(newhora_pago==null) {
					//newhora_pago=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna hora_pago");
					}
				}

				this.hora_pago=newhora_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_transaccion(String newnombre_transaccion)throws Exception
	{
		try {
			if(this.nombre_transaccion!=newnombre_transaccion) {
				if(newnombre_transaccion==null) {
					//newnombre_transaccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna nombre_transaccion");
					}
				}

				if(newnombre_transaccion!=null&&newnombre_transaccion.length()>150) {
					newnombre_transaccion=newnombre_transaccion.substring(0,148);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_transaccion");
				}

				this.nombre_transaccion=newnombre_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vence(Date newfecha_vence)throws Exception
	{
		try {
			if(this.fecha_vence!=newfecha_vence) {
				if(newfecha_vence==null) {
					//newfecha_vence=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_vence");
					}
				}

				this.fecha_vence=newfecha_vence;
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
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdebito_mone_local(Double newdebito_mone_local)throws Exception
	{
		try {
			if(this.debito_mone_local!=newdebito_mone_local) {
				if(newdebito_mone_local==null) {
					//newdebito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna debito_mone_local");
					}
				}

				this.debito_mone_local=newdebito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcredito_mone_local(Double newcredito_mone_local)throws Exception
	{
		try {
			if(this.credito_mone_local!=newcredito_mone_local) {
				if(newcredito_mone_local==null) {
					//newcredito_mone_local=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna credito_mone_local");
					}
				}

				this.credito_mone_local=newcredito_mone_local;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_direccion(String newdireccion_direccion)throws Exception
	{
		try {
			if(this.direccion_direccion!=newdireccion_direccion) {
				if(newdireccion_direccion==null) {
					//newdireccion_direccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna direccion_direccion");
					}
				}

				if(newdireccion_direccion!=null&&newdireccion_direccion.length()>200) {
					newdireccion_direccion=newdireccion_direccion.substring(0,198);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna direccion_direccion");
				}

				this.direccion_direccion=newdireccion_direccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_telefono(String newtelefono_telefono)throws Exception
	{
		try {
			if(this.telefono_telefono!=newtelefono_telefono) {
				if(newtelefono_telefono==null) {
					//newtelefono_telefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CobrarEstadosCuentasPorFactura:Valor nulo no permitido en columna telefono_telefono");
					}
				}

				if(newtelefono_telefono!=null&&newtelefono_telefono.length()>200) {
					newtelefono_telefono=newtelefono_telefono.substring(0,198);
					System.out.println("CobrarEstadosCuentasPorFactura:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna telefono_telefono");
				}

				this.telefono_telefono=newtelefono_telefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

