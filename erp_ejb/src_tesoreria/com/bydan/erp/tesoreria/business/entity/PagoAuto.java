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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.PagoAutoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;




@SuppressWarnings("unused")
public class PagoAuto extends PagoAutoAdditional implements Serializable ,Cloneable {//PagoAutoAdditional,GeneralEntity
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
	
	private PagoAuto pagoautoOriginal;
	
	private Map<String, Object> mapPagoAuto;
			
	public Map<String, Object> getMapPagoAuto() {
		return mapPagoAuto;
	}

	public void setMapPagoAuto(Map<String, Object> mapPagoAuto) {
		this.mapPagoAuto = mapPagoAuto;
	}
	
	public void inicializarMapPagoAuto() {
		this.mapPagoAuto = new HashMap<String,Object>();
	}
	
	public void setMapPagoAutoValue(String sKey,Object oValue) {
		this.mapPagoAuto.put(sKey, oValue);
	}
	
	public Object getMapPagoAutoValue(String sKey) {
		return this.mapPagoAuto.get(sKey);
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_actividad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_prove;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pago_auto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PagoAutoConstantesFunciones.SREGEXNUMERO_FACTURA,message=PagoAutoConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_vencimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_corte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_por_pagar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_cancelado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_autorizado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PagoAutoConstantesFunciones.SREGEXDESCRIPCION,message=PagoAutoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Cliente cliente;
	public AsientoContable asientocontable;
	public CentroCosto centrocosto;
	public CentroActividad centroactividad;
	public Factura factura;
	public DetalleProve detalleprove;
	public CuentaBanco cuentabanco;
	public Transaccion transaccion;
	public EstadoPagoAuto estadopagoauto;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String cliente_descripcion;
	private String asientocontable_descripcion;
	private String centrocosto_descripcion;
	private String centroactividad_descripcion;
	private String factura_descripcion;
	private String detalleprove_descripcion;
	private String cuentabanco_descripcion;
	private String transaccion_descripcion;
	private String estadopagoauto_descripcion;
	
	
		
	public PagoAuto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pagoautoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_cliente=-1L;
 		this.id_asiento_contable=-1L;
 		this.id_centro_costo=null;
 		this.id_centro_actividad=null;
 		this.id_factura=-1L;
 		this.id_detalle_prove=-1L;
 		this.id_cuenta_banco=-1L;
 		this.id_transaccion=-1L;
 		this.id_estado_pago_auto=-1L;
 		this.numero_factura="";
 		this.fecha_emision=new Date();
 		this.fecha_vencimiento=new Date();
 		this.fecha_corte=new Date();
 		this.valor_por_pagar=0.0;
 		this.valor_cancelado=0.0;
 		this.esta_autorizado=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.cliente=null;
		this.asientocontable=null;
		this.centrocosto=null;
		this.centroactividad=null;
		this.factura=null;
		this.detalleprove=null;
		this.cuentabanco=null;
		this.transaccion=null;
		this.estadopagoauto=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.cliente_descripcion="";
		this.asientocontable_descripcion="";
		this.centrocosto_descripcion="";
		this.centroactividad_descripcion="";
		this.factura_descripcion="";
		this.detalleprove_descripcion="";
		this.cuentabanco_descripcion="";
		this.transaccion_descripcion="";
		this.estadopagoauto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PagoAuto (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_cliente,Long id_asiento_contable,Long id_centro_costo,Long id_centro_actividad,Long id_factura,Long id_detalle_prove,Long id_cuenta_banco,Long id_transaccion,Long id_estado_pago_auto,String numero_factura,Date fecha_emision,Date fecha_vencimiento,Date fecha_corte,Double valor_por_pagar,Double valor_cancelado,Boolean esta_autorizado,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagoautoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_cliente=id_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_centro_costo=id_centro_costo;
 		this.id_centro_actividad=id_centro_actividad;
 		this.id_factura=id_factura;
 		this.id_detalle_prove=id_detalle_prove;
 		this.id_cuenta_banco=id_cuenta_banco;
 		this.id_transaccion=id_transaccion;
 		this.id_estado_pago_auto=id_estado_pago_auto;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_corte=fecha_corte;
 		this.valor_por_pagar=valor_por_pagar;
 		this.valor_cancelado=valor_cancelado;
 		this.esta_autorizado=esta_autorizado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PagoAuto (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_cliente,Long id_asiento_contable,Long id_centro_costo,Long id_centro_actividad,Long id_factura,Long id_detalle_prove,Long id_cuenta_banco,Long id_transaccion,Long id_estado_pago_auto,String numero_factura,Date fecha_emision,Date fecha_vencimiento,Date fecha_corte,Double valor_por_pagar,Double valor_cancelado,Boolean esta_autorizado,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pagoautoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_cliente=id_cliente;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_centro_costo=id_centro_costo;
 		this.id_centro_actividad=id_centro_actividad;
 		this.id_factura=id_factura;
 		this.id_detalle_prove=id_detalle_prove;
 		this.id_cuenta_banco=id_cuenta_banco;
 		this.id_transaccion=id_transaccion;
 		this.id_estado_pago_auto=id_estado_pago_auto;
 		this.numero_factura=numero_factura;
 		this.fecha_emision=fecha_emision;
 		this.fecha_vencimiento=fecha_vencimiento;
 		this.fecha_corte=fecha_corte;
 		this.valor_por_pagar=valor_por_pagar;
 		this.valor_cancelado=valor_cancelado;
 		this.esta_autorizado=esta_autorizado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PagoAuto pagoautoLocal=null;
		
		if(object!=null) {
			pagoautoLocal=(PagoAuto)object;
			
			if(pagoautoLocal!=null) {
				if(this.getId()!=null && pagoautoLocal.getId()!=null) {
					if(this.getId().equals(pagoautoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PagoAutoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PagoAutoConstantesFunciones.getPagoAutoDescripcion(this);
		} else {
			sDetalle=PagoAutoConstantesFunciones.getPagoAutoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PagoAuto getPagoAutoOriginal() {
		return this.pagoautoOriginal;
	}
	
	public void setPagoAutoOriginal(PagoAuto pagoauto) {
		try {
			this.pagoautoOriginal=pagoauto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PagoAutoAdditional pagoautoAdditional=null;
	
	public PagoAutoAdditional getPagoAutoAdditional() {
		return this.pagoautoAdditional;
	}
	
	public void setPagoAutoAdditional(PagoAutoAdditional pagoautoAdditional) {
		try {
			this.pagoautoAdditional=pagoautoAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_centro_actividad() {
		return this.id_centro_actividad;
	}
    
	
	public Long getid_factura() {
		return this.id_factura;
	}
    
	
	public Long getid_detalle_prove() {
		return this.id_detalle_prove;
	}
    
	
	public Long getid_cuenta_banco() {
		return this.id_cuenta_banco;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_estado_pago_auto() {
		return this.id_estado_pago_auto;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public Date getfecha_vencimiento() {
		return this.fecha_vencimiento;
	}
    
	
	public Date getfecha_corte() {
		return this.fecha_corte;
	}
    
	
	public Double getvalor_por_pagar() {
		return this.valor_por_pagar;
	}
    
	
	public Double getvalor_cancelado() {
		return this.valor_cancelado;
	}
    
	
	public Boolean getesta_autorizado() {
		return this.esta_autorizado;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_asiento_contable(Long newid_asiento_contable)throws Exception
	{
		try {
			if(this.id_asiento_contable!=newid_asiento_contable) {
				if(newid_asiento_contable==null) {
					//newid_asiento_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
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
    
	public void setid_centro_actividad(Long newid_centro_actividad) {
		if(this.id_centro_actividad==null&&newid_centro_actividad!=null) {
			this.id_centro_actividad=newid_centro_actividad;
				this.setIsChanged(true);
		}

		if(this.id_centro_actividad!=null&&!this.id_centro_actividad.equals(newid_centro_actividad)) {

			this.id_centro_actividad=newid_centro_actividad;
				this.setIsChanged(true);
		}
	}
    
	public void setid_factura(Long newid_factura)throws Exception
	{
		try {
			if(this.id_factura!=newid_factura) {
				if(newid_factura==null) {
					//newid_factura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_factura");
					}
				}

				this.id_factura=newid_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_prove(Long newid_detalle_prove)throws Exception
	{
		try {
			if(this.id_detalle_prove!=newid_detalle_prove) {
				if(newid_detalle_prove==null) {
					//newid_detalle_prove=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_detalle_prove");
					}
				}

				this.id_detalle_prove=newid_detalle_prove;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_banco(Long newid_cuenta_banco)throws Exception
	{
		try {
			if(this.id_cuenta_banco!=newid_cuenta_banco) {
				if(newid_cuenta_banco==null) {
					//newid_cuenta_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_cuenta_banco");
					}
				}

				this.id_cuenta_banco=newid_cuenta_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pago_auto(Long newid_estado_pago_auto)throws Exception
	{
		try {
			if(this.id_estado_pago_auto!=newid_estado_pago_auto) {
				if(newid_estado_pago_auto==null) {
					//newid_estado_pago_auto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna id_estado_pago_auto");
					}
				}

				this.id_estado_pago_auto=newid_estado_pago_auto;
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
						System.out.println("PagoAuto:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("PagoAuto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
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
						System.out.println("PagoAuto:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_vencimiento(Date newfecha_vencimiento)throws Exception
	{
		try {
			if(this.fecha_vencimiento!=newfecha_vencimiento) {
				if(newfecha_vencimiento==null) {
					//newfecha_vencimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna fecha_vencimiento");
					}
				}

				this.fecha_vencimiento=newfecha_vencimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_corte(Date newfecha_corte)throws Exception
	{
		try {
			if(this.fecha_corte!=newfecha_corte) {
				if(newfecha_corte==null) {
					//newfecha_corte=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna fecha_corte");
					}
				}

				this.fecha_corte=newfecha_corte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_por_pagar(Double newvalor_por_pagar)throws Exception
	{
		try {
			if(this.valor_por_pagar!=newvalor_por_pagar) {
				if(newvalor_por_pagar==null) {
					//newvalor_por_pagar=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna valor_por_pagar");
					}
				}

				this.valor_por_pagar=newvalor_por_pagar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_cancelado(Double newvalor_cancelado)throws Exception
	{
		try {
			if(this.valor_cancelado!=newvalor_cancelado) {
				if(newvalor_cancelado==null) {
					//newvalor_cancelado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna valor_cancelado");
					}
				}

				this.valor_cancelado=newvalor_cancelado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_autorizado(Boolean newesta_autorizado)throws Exception
	{
		try {
			if(this.esta_autorizado!=newesta_autorizado) {
				if(newesta_autorizado==null) {
					//newesta_autorizado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PagoAuto:Valor nulo no permitido en columna esta_autorizado");
					}
				}

				this.esta_autorizado=newesta_autorizado;
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
						System.out.println("PagoAuto:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PagoAuto:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public CentroActividad getCentroActividad() {
		return this.centroactividad;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public DetalleProve getDetalleProve() {
		return this.detalleprove;
	}

	public CuentaBanco getCuentaBanco() {
		return this.cuentabanco;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public EstadoPagoAuto getEstadoPagoAuto() {
		return this.estadopagoauto;
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

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getcentroactividad_descripcion() {
		return this.centroactividad_descripcion;
	}

	public String getfactura_descripcion() {
		return this.factura_descripcion;
	}

	public String getdetalleprove_descripcion() {
		return this.detalleprove_descripcion;
	}

	public String getcuentabanco_descripcion() {
		return this.cuentabanco_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getestadopagoauto_descripcion() {
		return this.estadopagoauto_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAsientoContable(AsientoContable asientocontable) {
		try {
			this.asientocontable=asientocontable;
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


	public  void  setCentroActividad(CentroActividad centroactividad) {
		try {
			this.centroactividad=centroactividad;
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


	public  void  setDetalleProve(DetalleProve detalleprove) {
		try {
			this.detalleprove=detalleprove;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaBanco(CuentaBanco cuentabanco) {
		try {
			this.cuentabanco=cuentabanco;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPagoAuto(EstadoPagoAuto estadopagoauto) {
		try {
			this.estadopagoauto=estadopagoauto;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setasientocontable_descripcion(String asientocontable_descripcion) {
		try {
			this.asientocontable_descripcion=asientocontable_descripcion;
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


	public  void  setcentroactividad_descripcion(String centroactividad_descripcion) {
		try {
			this.centroactividad_descripcion=centroactividad_descripcion;
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


	public  void  setdetalleprove_descripcion(String detalleprove_descripcion) {
		try {
			this.detalleprove_descripcion=detalleprove_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentabanco_descripcion(String cuentabanco_descripcion) {
		try {
			this.cuentabanco_descripcion=cuentabanco_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopagoauto_descripcion(String estadopagoauto_descripcion) {
		try {
			this.estadopagoauto_descripcion=estadopagoauto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_cliente_descripcion="";String id_asiento_contable_descripcion="";String id_centro_costo_descripcion="";String id_centro_actividad_descripcion="";String id_factura_descripcion="";String id_detalle_prove_descripcion="";String id_cuenta_banco_descripcion="";String id_transaccion_descripcion="";String id_estado_pago_auto_descripcion="";String esta_autorizado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_centro_actividad_descripcion() {
		return id_centro_actividad_descripcion;
	}
	public String getid_factura_descripcion() {
		return id_factura_descripcion;
	}
	public String getid_detalle_prove_descripcion() {
		return id_detalle_prove_descripcion;
	}
	public String getid_cuenta_banco_descripcion() {
		return id_cuenta_banco_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_estado_pago_auto_descripcion() {
		return id_estado_pago_auto_descripcion;
	}
	public String getesta_autorizado_descripcion() {
		return esta_autorizado_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_asiento_contable_descripcion(String newid_asiento_contable_descripcion)throws Exception {
		try {
			this.id_asiento_contable_descripcion=newid_asiento_contable_descripcion;
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
	public void setid_centro_actividad_descripcion(String newid_centro_actividad_descripcion)throws Exception {
		try {
			this.id_centro_actividad_descripcion=newid_centro_actividad_descripcion;
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
	public void setid_detalle_prove_descripcion(String newid_detalle_prove_descripcion)throws Exception {
		try {
			this.id_detalle_prove_descripcion=newid_detalle_prove_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_banco_descripcion(String newid_cuenta_banco_descripcion)throws Exception {
		try {
			this.id_cuenta_banco_descripcion=newid_cuenta_banco_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pago_auto_descripcion(String newid_estado_pago_auto_descripcion)throws Exception {
		try {
			this.id_estado_pago_auto_descripcion=newid_estado_pago_auto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_autorizado_descripcion(String newesta_autorizado_descripcion)throws Exception {
		try {
			this.esta_autorizado_descripcion=newesta_autorizado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_cliente_descripcion="";this.id_asiento_contable_descripcion="";this.id_centro_costo_descripcion="";this.id_centro_actividad_descripcion="";this.id_factura_descripcion="";this.id_detalle_prove_descripcion="";this.id_cuenta_banco_descripcion="";this.id_transaccion_descripcion="";this.id_estado_pago_auto_descripcion="";this.esta_autorizado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

