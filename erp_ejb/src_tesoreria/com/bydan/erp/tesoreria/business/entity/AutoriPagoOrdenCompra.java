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
//import com.bydan.erp.tesoreria.util.AutoriPagoOrdenCompraConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class AutoriPagoOrdenCompra extends AutoriPagoOrdenCompraAdditional implements Serializable ,Cloneable {//AutoriPagoOrdenCompraAdditional,GeneralEntity
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
	
	private AutoriPagoOrdenCompra autoripagoordencompraOriginal;
	
	private Map<String, Object> mapAutoriPagoOrdenCompra;
			
	public Map<String, Object> getMapAutoriPagoOrdenCompra() {
		return mapAutoriPagoOrdenCompra;
	}

	public void setMapAutoriPagoOrdenCompra(Map<String, Object> mapAutoriPagoOrdenCompra) {
		this.mapAutoriPagoOrdenCompra = mapAutoriPagoOrdenCompra;
	}
	
	public void inicializarMapAutoriPagoOrdenCompra() {
		this.mapAutoriPagoOrdenCompra = new HashMap<String,Object>();
	}
	
	public void setMapAutoriPagoOrdenCompraValue(String sKey,Object oValue) {
		this.mapAutoriPagoOrdenCompra.put(sKey, oValue);
	}
	
	public Object getMapAutoriPagoOrdenCompraValue(String sKey) {
		return this.mapAutoriPagoOrdenCompra.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cambio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_moneda;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
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
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_orden_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_asiento_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AutoriPagoOrdenCompraConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=AutoriPagoOrdenCompraConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_autori;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_servidor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AutoriPagoOrdenCompraConstantesFunciones.SREGEXCODIGO_ASIENTO,message=AutoriPagoOrdenCompraConstantesFunciones.SMENSAJEREGEXCODIGO_ASIENTO)
	private String codigo_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_asiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_saldo;
			
	
	public TipoCambio tipocambio;
	public Moneda moneda;
	public Cliente cliente;
	public Empresa empresa;
	public Sucursal sucursal;
	public OrdenCompra ordencompra;
	public Transaccion transaccion;
	public Modulo modulo;
	public Ejercicio ejercicio;
	public Usuario usuario;
	public AsientoContable asientocontable;
	public Banco banco;
	public CuentaBanco cuentabanco;
	
	
	private String tipocambio_descripcion;
	private String moneda_descripcion;
	private String cliente_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ordencompra_descripcion;
	private String transaccion_descripcion;
	private String modulo_descripcion;
	private String ejercicio_descripcion;
	private String usuario_descripcion;
	private String asientocontable_descripcion;
	private String banco_descripcion;
	private String cuentabanco_descripcion;
	
	
		
	public AutoriPagoOrdenCompra () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.autoripagoordencompraOriginal=this;
		
 		this.id_tipo_cambio=null;
 		this.id_moneda=-1L;
 		this.id_cliente=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_orden_compra=-1L;
 		this.id_transaccion=-1L;
 		this.id_modulo=-1L;
 		this.id_ejercicio=-1L;
 		this.id_usuario=-1L;
 		this.id_asiento_contable=-1L;
 		this.id_banco=-1L;
 		this.id_cuenta_banco=-1L;
 		this.numero_comprobante="";
 		this.fecha=new Date();
 		this.fecha_autori=new Date();
 		this.total=0.0;
 		this.fecha_servidor=new Date();
 		this.codigo_asiento="";
 		this.fecha_asiento=new Date();
 		this.valor_asiento=0.0;
 		this.total_saldo=0.0;
		
		
		this.tipocambio=null;
		this.moneda=null;
		this.cliente=null;
		this.empresa=null;
		this.sucursal=null;
		this.ordencompra=null;
		this.transaccion=null;
		this.modulo=null;
		this.ejercicio=null;
		this.usuario=null;
		this.asientocontable=null;
		this.banco=null;
		this.cuentabanco=null;
		
		
		this.tipocambio_descripcion="";
		this.moneda_descripcion="";
		this.cliente_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ordencompra_descripcion="";
		this.transaccion_descripcion="";
		this.modulo_descripcion="";
		this.ejercicio_descripcion="";
		this.usuario_descripcion="";
		this.asientocontable_descripcion="";
		this.banco_descripcion="";
		this.cuentabanco_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AutoriPagoOrdenCompra (Long id,Date versionRow,Long id_tipo_cambio,Long id_moneda,Long id_cliente,Long id_empresa,Long id_sucursal,Long id_orden_compra,Long id_transaccion,Long id_modulo,Long id_ejercicio,Long id_usuario,Long id_asiento_contable,Long id_banco,Long id_cuenta_banco,String numero_comprobante,Date fecha,Date fecha_autori,Double total,Date fecha_servidor,String codigo_asiento,Date fecha_asiento,Double valor_asiento,Double total_saldo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoripagoordencompraOriginal=this;
		
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_moneda=id_moneda;
 		this.id_cliente=id_cliente;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_orden_compra=id_orden_compra;
 		this.id_transaccion=id_transaccion;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_usuario=id_usuario;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_banco=id_banco;
 		this.id_cuenta_banco=id_cuenta_banco;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha=fecha;
 		this.fecha_autori=fecha_autori;
 		this.total=total;
 		this.fecha_servidor=fecha_servidor;
 		this.codigo_asiento=codigo_asiento;
 		this.fecha_asiento=fecha_asiento;
 		this.valor_asiento=valor_asiento;
 		this.total_saldo=total_saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AutoriPagoOrdenCompra (Long id_tipo_cambio,Long id_moneda,Long id_cliente,Long id_empresa,Long id_sucursal,Long id_orden_compra,Long id_transaccion,Long id_modulo,Long id_ejercicio,Long id_usuario,Long id_asiento_contable,Long id_banco,Long id_cuenta_banco,String numero_comprobante,Date fecha,Date fecha_autori,Double total,Date fecha_servidor,String codigo_asiento,Date fecha_asiento,Double valor_asiento,Double total_saldo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.autoripagoordencompraOriginal=this;
		
 		this.id_tipo_cambio=id_tipo_cambio;
 		this.id_moneda=id_moneda;
 		this.id_cliente=id_cliente;
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_orden_compra=id_orden_compra;
 		this.id_transaccion=id_transaccion;
 		this.id_modulo=id_modulo;
 		this.id_ejercicio=id_ejercicio;
 		this.id_usuario=id_usuario;
 		this.id_asiento_contable=id_asiento_contable;
 		this.id_banco=id_banco;
 		this.id_cuenta_banco=id_cuenta_banco;
 		this.numero_comprobante=numero_comprobante;
 		this.fecha=fecha;
 		this.fecha_autori=fecha_autori;
 		this.total=total;
 		this.fecha_servidor=fecha_servidor;
 		this.codigo_asiento=codigo_asiento;
 		this.fecha_asiento=fecha_asiento;
 		this.valor_asiento=valor_asiento;
 		this.total_saldo=total_saldo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AutoriPagoOrdenCompra autoripagoordencompraLocal=null;
		
		if(object!=null) {
			autoripagoordencompraLocal=(AutoriPagoOrdenCompra)object;
			
			if(autoripagoordencompraLocal!=null) {
				if(this.getId()!=null && autoripagoordencompraLocal.getId()!=null) {
					if(this.getId().equals(autoripagoordencompraLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AutoriPagoOrdenCompraConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AutoriPagoOrdenCompraConstantesFunciones.getAutoriPagoOrdenCompraDescripcion(this);
		} else {
			sDetalle=AutoriPagoOrdenCompraConstantesFunciones.getAutoriPagoOrdenCompraDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AutoriPagoOrdenCompra getAutoriPagoOrdenCompraOriginal() {
		return this.autoripagoordencompraOriginal;
	}
	
	public void setAutoriPagoOrdenCompraOriginal(AutoriPagoOrdenCompra autoripagoordencompra) {
		try {
			this.autoripagoordencompraOriginal=autoripagoordencompra;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AutoriPagoOrdenCompraAdditional autoripagoordencompraAdditional=null;
	
	public AutoriPagoOrdenCompraAdditional getAutoriPagoOrdenCompraAdditional() {
		return this.autoripagoordencompraAdditional;
	}
	
	public void setAutoriPagoOrdenCompraAdditional(AutoriPagoOrdenCompraAdditional autoripagoordencompraAdditional) {
		try {
			this.autoripagoordencompraAdditional=autoripagoordencompraAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_tipo_cambio() {
		return this.id_tipo_cambio;
	}
    
	
	public Long getid_moneda() {
		return this.id_moneda;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_orden_compra() {
		return this.id_orden_compra;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_asiento_contable() {
		return this.id_asiento_contable;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_cuenta_banco() {
		return this.id_cuenta_banco;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_autori() {
		return this.fecha_autori;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
    
	
	public Date getfecha_servidor() {
		return this.fecha_servidor;
	}
    
	
	public String getcodigo_asiento() {
		return this.codigo_asiento;
	}
    
	
	public Date getfecha_asiento() {
		return this.fecha_asiento;
	}
    
	
	public Double getvalor_asiento() {
		return this.valor_asiento;
	}
    
	
	public Double gettotal_saldo() {
		return this.total_saldo;
	}
	
    
	public void setid_tipo_cambio(Long newid_tipo_cambio) {
		if(this.id_tipo_cambio==null&&newid_tipo_cambio!=null) {
			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}

		if(this.id_tipo_cambio!=null&&!this.id_tipo_cambio.equals(newid_tipo_cambio)) {

			this.id_tipo_cambio=newid_tipo_cambio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_moneda(Long newid_moneda)throws Exception
	{
		try {
			if(this.id_moneda!=newid_moneda) {
				if(newid_moneda==null) {
					//newid_moneda=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_moneda");
					}
				}

				this.id_moneda=newid_moneda;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_orden_compra(Long newid_orden_compra)throws Exception
	{
		try {
			if(this.id_orden_compra!=newid_orden_compra) {
				if(newid_orden_compra==null) {
					//newid_orden_compra=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_orden_compra");
					}
				}

				this.id_orden_compra=newid_orden_compra;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_usuario(Long newid_usuario)throws Exception
	{
		try {
			if(this.id_usuario!=newid_usuario) {
				if(newid_usuario==null) {
					//newid_usuario=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_asiento_contable");
					}
				}

				this.id_asiento_contable=newid_asiento_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_banco(Long newid_banco)throws Exception
	{
		try {
			if(this.id_banco!=newid_banco) {
				if(newid_banco==null) {
					//newid_banco=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna id_cuenta_banco");
					}
				}

				this.id_cuenta_banco=newid_cuenta_banco;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("AutoriPagoOrdenCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha(Date newfecha)throws Exception
	{
		try {
			if(this.fecha!=newfecha) {
				if(newfecha==null) {
					//newfecha=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_autori(Date newfecha_autori)throws Exception
	{
		try {
			if(this.fecha_autori!=newfecha_autori) {
				if(newfecha_autori==null) {
					//newfecha_autori=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna fecha_autori");
					}
				}

				this.fecha_autori=newfecha_autori;
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
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_servidor(Date newfecha_servidor)throws Exception
	{
		try {
			if(this.fecha_servidor!=newfecha_servidor) {
				if(newfecha_servidor==null) {
					//newfecha_servidor=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna fecha_servidor");
					}
				}

				this.fecha_servidor=newfecha_servidor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_asiento(String newcodigo_asiento)throws Exception
	{
		try {
			if(this.codigo_asiento!=newcodigo_asiento) {
				if(newcodigo_asiento==null) {
					//newcodigo_asiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna codigo_asiento");
					}
				}

				if(newcodigo_asiento!=null&&newcodigo_asiento.length()>50) {
					newcodigo_asiento=newcodigo_asiento.substring(0,48);
					System.out.println("AutoriPagoOrdenCompra:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_asiento");
				}

				this.codigo_asiento=newcodigo_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_asiento(Date newfecha_asiento)throws Exception
	{
		try {
			if(this.fecha_asiento!=newfecha_asiento) {
				if(newfecha_asiento==null) {
					//newfecha_asiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna fecha_asiento");
					}
				}

				this.fecha_asiento=newfecha_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_asiento(Double newvalor_asiento)throws Exception
	{
		try {
			if(this.valor_asiento!=newvalor_asiento) {
				if(newvalor_asiento==null) {
					//newvalor_asiento=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna valor_asiento");
					}
				}

				this.valor_asiento=newvalor_asiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_saldo(Double newtotal_saldo)throws Exception
	{
		try {
			if(this.total_saldo!=newtotal_saldo) {
				if(newtotal_saldo==null) {
					//newtotal_saldo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AutoriPagoOrdenCompra:Valor nulo no permitido en columna total_saldo");
					}
				}

				this.total_saldo=newtotal_saldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public TipoCambio getTipoCambio() {
		return this.tipocambio;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public OrdenCompra getOrdenCompra() {
		return this.ordencompra;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public AsientoContable getAsientoContable() {
		return this.asientocontable;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public CuentaBanco getCuentaBanco() {
		return this.cuentabanco;
	}

	
	
	public String gettipocambio_descripcion() {
		return this.tipocambio_descripcion;
	}

	public String getmoneda_descripcion() {
		return this.moneda_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getordencompra_descripcion() {
		return this.ordencompra_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getasientocontable_descripcion() {
		return this.asientocontable_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String getcuentabanco_descripcion() {
		return this.cuentabanco_descripcion;
	}

	
	
	public  void  setTipoCambio(TipoCambio tipocambio) {
		try {
			this.tipocambio=tipocambio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMoneda(Moneda moneda) {
		try {
			this.moneda=moneda;
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


	public  void  setOrdenCompra(OrdenCompra ordencompra) {
		try {
			this.ordencompra=ordencompra;
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


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setBanco(Banco banco) {
		try {
			this.banco=banco;
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


	
	
	public  void  settipocambio_descripcion(String tipocambio_descripcion) {
		try {
			this.tipocambio_descripcion=tipocambio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmoneda_descripcion(String moneda_descripcion) {
		try {
			this.moneda_descripcion=moneda_descripcion;
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


	public  void  setordencompra_descripcion(String ordencompra_descripcion) {
		try {
			this.ordencompra_descripcion=ordencompra_descripcion;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setbanco_descripcion(String banco_descripcion) {
		try {
			this.banco_descripcion=banco_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_tipo_cambio_descripcion="";String id_moneda_descripcion="";String id_cliente_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_orden_compra_descripcion="";String id_transaccion_descripcion="";String id_modulo_descripcion="";String id_ejercicio_descripcion="";String id_usuario_descripcion="";String id_asiento_contable_descripcion="";String id_banco_descripcion="";String id_cuenta_banco_descripcion="";
	
	
	public String getid_tipo_cambio_descripcion() {
		return id_tipo_cambio_descripcion;
	}
	public String getid_moneda_descripcion() {
		return id_moneda_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_orden_compra_descripcion() {
		return id_orden_compra_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_asiento_contable_descripcion() {
		return id_asiento_contable_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_cuenta_banco_descripcion() {
		return id_cuenta_banco_descripcion;
	}
	
	
	public void setid_tipo_cambio_descripcion(String newid_tipo_cambio_descripcion)throws Exception {
		try {
			this.id_tipo_cambio_descripcion=newid_tipo_cambio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_moneda_descripcion(String newid_moneda_descripcion)throws Exception {
		try {
			this.id_moneda_descripcion=newid_moneda_descripcion;
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
	public void setid_orden_compra_descripcion(String newid_orden_compra_descripcion)throws Exception {
		try {
			this.id_orden_compra_descripcion=newid_orden_compra_descripcion;
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
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
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
	public void setid_banco_descripcion(String newid_banco_descripcion)throws Exception {
		try {
			this.id_banco_descripcion=newid_banco_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_tipo_cambio_descripcion="";this.id_moneda_descripcion="";this.id_cliente_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_orden_compra_descripcion="";this.id_transaccion_descripcion="";this.id_modulo_descripcion="";this.id_ejercicio_descripcion="";this.id_usuario_descripcion="";this.id_asiento_contable_descripcion="";this.id_banco_descripcion="";this.id_cuenta_banco_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

