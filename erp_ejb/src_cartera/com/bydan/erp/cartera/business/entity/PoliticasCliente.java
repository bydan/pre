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
package com.bydan.erp.cartera.business.entity;

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
//import com.bydan.erp.cartera.util.PoliticasClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class PoliticasCliente extends PoliticasClienteAdditional implements Serializable ,Cloneable {//PoliticasClienteAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private PoliticasCliente politicasclienteOriginal;
	
	private Map<String, Object> mapPoliticasCliente;
			
	public Map<String, Object> getMapPoliticasCliente() {
		return mapPoliticasCliente;
	}

	public void setMapPoliticasCliente(Map<String, Object> mapPoliticasCliente) {
		this.mapPoliticasCliente = mapPoliticasCliente;
	}
	
	public void inicializarMapPoliticasCliente() {
		this.mapPoliticasCliente = new HashMap<String,Object>();
	}
	
	public void setMapPoliticasClienteValue(String sKey,Object oValue) {
		this.mapPoliticasCliente.put(sKey, oValue);
	}
	
	public Object getMapPoliticasClienteValue(String sKey) {
		return this.mapPoliticasCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double limite_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_renovacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias_neto_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dias_gracia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double cupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_general;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento_pronto_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_lista_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_impuestos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean activar_monto_facturacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_sobregiro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_venci_sobregiro;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_solicitado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_aprobado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_negocio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_solicitud;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PoliticasClienteConstantesFunciones.SREGEXOBSEVACION,message=PoliticasClienteConstantesFunciones.SMENSAJEREGEXOBSEVACION)
	private String obsevacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PoliticasClienteConstantesFunciones.SREGEXWEB,message=PoliticasClienteConstantesFunciones.SMENSAJEREGEXWEB)
	private String web;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PoliticasClienteConstantesFunciones.SREGEXCASILLA_POSTAL,message=PoliticasClienteConstantesFunciones.SMENSAJEREGEXCASILLA_POSTAL)
	private String casilla_postal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PoliticasClienteConstantesFunciones.SREGEXFORMA_ENVIO,message=PoliticasClienteConstantesFunciones.SMENSAJEREGEXFORMA_ENVIO)
	private String forma_envio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_banco;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_banco_global;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PoliticasClienteConstantesFunciones.SREGEXNUMERO_CUENTA,message=PoliticasClienteConstantesFunciones.SMENSAJEREGEXNUMERO_CUENTA)
	private String numero_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_politicas_cliente;
			
	
	public Cliente cliente;
	public Empresa empresa;
	public TipoPrecio tipoprecio;
	public Transporte transporte;
	public LineaNegocio lineanegocio;
	public Banco banco;
	public TipoCuentaBancoGlobal tipocuentabancoglobal;
	public EstadoPoliticasCliente estadopoliticascliente;
	
	
	private String cliente_descripcion;
	private String empresa_descripcion;
	private String tipoprecio_descripcion;
	private String transporte_descripcion;
	private String lineanegocio_descripcion;
	private String banco_descripcion;
	private String tipocuentabancoglobal_descripcion;
	private String estadopoliticascliente_descripcion;
	
	
		
	public PoliticasCliente () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.politicasclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.limite_credito=0.0;
 		this.fecha_inicio=new Date();
 		this.fecha_renovacion=new Date();
 		this.fecha_fin=new Date();
 		this.dias_neto_pago=0;
 		this.dias_gracia=0;
 		this.cupo=0.0;
 		this.descuento_general=0.0;
 		this.descuento_pronto_pago=0.0;
 		this.id_tipo_precio=-1L;
 		this.con_lista_precio=false;
 		this.con_impuestos=false;
 		this.activar_monto_facturacion=false;
 		this.valor_sobregiro=0.0;
 		this.fecha_venci_sobregiro=new Date();
 		this.id_transporte=-1L;
 		this.valor_solicitado=0.0;
 		this.valor_aprobado=0.0;
 		this.id_linea_negocio=-1L;
 		this.fecha_solicitud=new Date();
 		this.obsevacion="";
 		this.web="";
 		this.casilla_postal="";
 		this.forma_envio="";
 		this.id_banco=-1L;
 		this.id_tipo_cuenta_banco_global=-1L;
 		this.numero_cuenta="";
 		this.id_estado_politicas_cliente=-1L;
		
		
		this.cliente=null;
		this.empresa=null;
		this.tipoprecio=null;
		this.transporte=null;
		this.lineanegocio=null;
		this.banco=null;
		this.tipocuentabancoglobal=null;
		this.estadopoliticascliente=null;
		
		
		this.cliente_descripcion="";
		this.empresa_descripcion="";
		this.tipoprecio_descripcion="";
		this.transporte_descripcion="";
		this.lineanegocio_descripcion="";
		this.banco_descripcion="";
		this.tipocuentabancoglobal_descripcion="";
		this.estadopoliticascliente_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PoliticasCliente (Long id,Date versionRow,Long id_empresa,Double limite_credito,Date fecha_inicio,Date fecha_renovacion,Date fecha_fin,Integer dias_neto_pago,Integer dias_gracia,Double cupo,Double descuento_general,Double descuento_pronto_pago,Long id_tipo_precio,Boolean con_lista_precio,Boolean con_impuestos,Boolean activar_monto_facturacion,Double valor_sobregiro,Date fecha_venci_sobregiro,Long id_transporte,Double valor_solicitado,Double valor_aprobado,Long id_linea_negocio,Date fecha_solicitud,String obsevacion,String web,String casilla_postal,String forma_envio,Long id_banco,Long id_tipo_cuenta_banco_global,String numero_cuenta,Long id_estado_politicas_cliente) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.politicasclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.limite_credito=limite_credito;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_renovacion=fecha_renovacion;
 		this.fecha_fin=fecha_fin;
 		this.dias_neto_pago=dias_neto_pago;
 		this.dias_gracia=dias_gracia;
 		this.cupo=cupo;
 		this.descuento_general=descuento_general;
 		this.descuento_pronto_pago=descuento_pronto_pago;
 		this.id_tipo_precio=id_tipo_precio;
 		this.con_lista_precio=con_lista_precio;
 		this.con_impuestos=con_impuestos;
 		this.activar_monto_facturacion=activar_monto_facturacion;
 		this.valor_sobregiro=valor_sobregiro;
 		this.fecha_venci_sobregiro=fecha_venci_sobregiro;
 		this.id_transporte=id_transporte;
 		this.valor_solicitado=valor_solicitado;
 		this.valor_aprobado=valor_aprobado;
 		this.id_linea_negocio=id_linea_negocio;
 		this.fecha_solicitud=fecha_solicitud;
 		this.obsevacion=obsevacion;
 		this.web=web;
 		this.casilla_postal=casilla_postal;
 		this.forma_envio=forma_envio;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.id_estado_politicas_cliente=id_estado_politicas_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PoliticasCliente (Long id_empresa,Double limite_credito,Date fecha_inicio,Date fecha_renovacion,Date fecha_fin,Integer dias_neto_pago,Integer dias_gracia,Double cupo,Double descuento_general,Double descuento_pronto_pago,Long id_tipo_precio,Boolean con_lista_precio,Boolean con_impuestos,Boolean activar_monto_facturacion,Double valor_sobregiro,Date fecha_venci_sobregiro,Long id_transporte,Double valor_solicitado,Double valor_aprobado,Long id_linea_negocio,Date fecha_solicitud,String obsevacion,String web,String casilla_postal,String forma_envio,Long id_banco,Long id_tipo_cuenta_banco_global,String numero_cuenta,Long id_estado_politicas_cliente) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.politicasclienteOriginal=this;
		
 		
 		this.id_empresa=id_empresa;
 		this.limite_credito=limite_credito;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_renovacion=fecha_renovacion;
 		this.fecha_fin=fecha_fin;
 		this.dias_neto_pago=dias_neto_pago;
 		this.dias_gracia=dias_gracia;
 		this.cupo=cupo;
 		this.descuento_general=descuento_general;
 		this.descuento_pronto_pago=descuento_pronto_pago;
 		this.id_tipo_precio=id_tipo_precio;
 		this.con_lista_precio=con_lista_precio;
 		this.con_impuestos=con_impuestos;
 		this.activar_monto_facturacion=activar_monto_facturacion;
 		this.valor_sobregiro=valor_sobregiro;
 		this.fecha_venci_sobregiro=fecha_venci_sobregiro;
 		this.id_transporte=id_transporte;
 		this.valor_solicitado=valor_solicitado;
 		this.valor_aprobado=valor_aprobado;
 		this.id_linea_negocio=id_linea_negocio;
 		this.fecha_solicitud=fecha_solicitud;
 		this.obsevacion=obsevacion;
 		this.web=web;
 		this.casilla_postal=casilla_postal;
 		this.forma_envio=forma_envio;
 		this.id_banco=id_banco;
 		this.id_tipo_cuenta_banco_global=id_tipo_cuenta_banco_global;
 		this.numero_cuenta=numero_cuenta;
 		this.id_estado_politicas_cliente=id_estado_politicas_cliente;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PoliticasCliente politicasclienteLocal=null;
		
		if(object!=null) {
			politicasclienteLocal=(PoliticasCliente)object;
			
			if(politicasclienteLocal!=null) {
				if(this.getId()!=null && politicasclienteLocal.getId()!=null) {
					if(this.getId().equals(politicasclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PoliticasClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PoliticasClienteConstantesFunciones.getPoliticasClienteDescripcion(this);
		} else {
			sDetalle=PoliticasClienteConstantesFunciones.getPoliticasClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PoliticasCliente getPoliticasClienteOriginal() {
		return this.politicasclienteOriginal;
	}
	
	public void setPoliticasClienteOriginal(PoliticasCliente politicascliente) {
		try {
			this.politicasclienteOriginal=politicascliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PoliticasClienteAdditional politicasclienteAdditional=null;
	
	public PoliticasClienteAdditional getPoliticasClienteAdditional() {
		return this.politicasclienteAdditional;
	}
	
	public void setPoliticasClienteAdditional(PoliticasClienteAdditional politicasclienteAdditional) {
		try {
			this.politicasclienteAdditional=politicasclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_cliente() {
		this.id_cliente=this.id;

		return this.id_cliente;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Double getlimite_credito() {
		return this.limite_credito;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_renovacion() {
		return this.fecha_renovacion;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Integer getdias_neto_pago() {
		return this.dias_neto_pago;
	}
    
	
	public Integer getdias_gracia() {
		return this.dias_gracia;
	}
    
	
	public Double getcupo() {
		return this.cupo;
	}
    
	
	public Double getdescuento_general() {
		return this.descuento_general;
	}
    
	
	public Double getdescuento_pronto_pago() {
		return this.descuento_pronto_pago;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Boolean getcon_lista_precio() {
		return this.con_lista_precio;
	}
    
	
	public Boolean getcon_impuestos() {
		return this.con_impuestos;
	}
    
	
	public Boolean getactivar_monto_facturacion() {
		return this.activar_monto_facturacion;
	}
    
	
	public Double getvalor_sobregiro() {
		return this.valor_sobregiro;
	}
    
	
	public Date getfecha_venci_sobregiro() {
		return this.fecha_venci_sobregiro;
	}
    
	
	public Long getid_transporte() {
		return this.id_transporte;
	}
    
	
	public Double getvalor_solicitado() {
		return this.valor_solicitado;
	}
    
	
	public Double getvalor_aprobado() {
		return this.valor_aprobado;
	}
    
	
	public Long getid_linea_negocio() {
		return this.id_linea_negocio;
	}
    
	
	public Date getfecha_solicitud() {
		return this.fecha_solicitud;
	}
    
	
	public String getobsevacion() {
		return this.obsevacion;
	}
    
	
	public String getweb() {
		return this.web;
	}
    
	
	public String getcasilla_postal() {
		return this.casilla_postal;
	}
    
	
	public String getforma_envio() {
		return this.forma_envio;
	}
    
	
	public Long getid_banco() {
		return this.id_banco;
	}
    
	
	public Long getid_tipo_cuenta_banco_global() {
		return this.id_tipo_cuenta_banco_global;
	}
    
	
	public String getnumero_cuenta() {
		return this.numero_cuenta;
	}
    
	
	public Long getid_estado_politicas_cliente() {
		return this.id_estado_politicas_cliente;
	}
	
    
	public void setid_cliente(Long newid_cliente)throws Exception
	{
		try {
			if(this.id_cliente!=null && this.id_cliente!=newid_cliente) {
				if(newid_cliente==null) {
					//newid_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			} else if(this.id_cliente==null && newid_cliente!=null) {
				this.id_cliente=newid_cliente;
				this.id=newid_cliente;
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
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setlimite_credito(Double newlimite_credito)throws Exception
	{
		try {
			if(this.limite_credito!=newlimite_credito) {
				if(newlimite_credito==null) {
					//newlimite_credito=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna limite_credito");
					}
				}

				this.limite_credito=newlimite_credito;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_renovacion(Date newfecha_renovacion)throws Exception
	{
		try {
			if(this.fecha_renovacion!=newfecha_renovacion) {
				if(newfecha_renovacion==null) {
					//newfecha_renovacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna fecha_renovacion");
					}
				}

				this.fecha_renovacion=newfecha_renovacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_fin(Date newfecha_fin)throws Exception
	{
		try {
			if(this.fecha_fin!=newfecha_fin) {
				if(newfecha_fin==null) {
					//newfecha_fin=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_neto_pago(Integer newdias_neto_pago)throws Exception
	{
		try {
			if(this.dias_neto_pago!=newdias_neto_pago) {
				if(newdias_neto_pago==null) {
					//newdias_neto_pago=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna dias_neto_pago");
					}
				}

				this.dias_neto_pago=newdias_neto_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdias_gracia(Integer newdias_gracia)throws Exception
	{
		try {
			if(this.dias_gracia!=newdias_gracia) {
				if(newdias_gracia==null) {
					//newdias_gracia=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna dias_gracia");
					}
				}

				this.dias_gracia=newdias_gracia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcupo(Double newcupo)throws Exception
	{
		try {
			if(this.cupo!=newcupo) {
				if(newcupo==null) {
					//newcupo=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna cupo");
					}
				}

				this.cupo=newcupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_general(Double newdescuento_general)throws Exception
	{
		try {
			if(this.descuento_general!=newdescuento_general) {
				if(newdescuento_general==null) {
					//newdescuento_general=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna descuento_general");
					}
				}

				this.descuento_general=newdescuento_general;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescuento_pronto_pago(Double newdescuento_pronto_pago)throws Exception
	{
		try {
			if(this.descuento_pronto_pago!=newdescuento_pronto_pago) {
				if(newdescuento_pronto_pago==null) {
					//newdescuento_pronto_pago=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna descuento_pronto_pago");
					}
				}

				this.descuento_pronto_pago=newdescuento_pronto_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_precio(Long newid_tipo_precio)throws Exception
	{
		try {
			if(this.id_tipo_precio!=newid_tipo_precio) {
				if(newid_tipo_precio==null) {
					//newid_tipo_precio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_lista_precio(Boolean newcon_lista_precio)throws Exception
	{
		try {
			if(this.con_lista_precio!=newcon_lista_precio) {
				if(newcon_lista_precio==null) {
					//newcon_lista_precio=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna con_lista_precio");
					}
				}

				this.con_lista_precio=newcon_lista_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_impuestos(Boolean newcon_impuestos)throws Exception
	{
		try {
			if(this.con_impuestos!=newcon_impuestos) {
				if(newcon_impuestos==null) {
					//newcon_impuestos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna con_impuestos");
					}
				}

				this.con_impuestos=newcon_impuestos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setactivar_monto_facturacion(Boolean newactivar_monto_facturacion)throws Exception
	{
		try {
			if(this.activar_monto_facturacion!=newactivar_monto_facturacion) {
				if(newactivar_monto_facturacion==null) {
					//newactivar_monto_facturacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna activar_monto_facturacion");
					}
				}

				this.activar_monto_facturacion=newactivar_monto_facturacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_sobregiro(Double newvalor_sobregiro)throws Exception
	{
		try {
			if(this.valor_sobregiro!=newvalor_sobregiro) {
				if(newvalor_sobregiro==null) {
					//newvalor_sobregiro=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna valor_sobregiro");
					}
				}

				this.valor_sobregiro=newvalor_sobregiro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_venci_sobregiro(Date newfecha_venci_sobregiro)throws Exception
	{
		try {
			if(this.fecha_venci_sobregiro!=newfecha_venci_sobregiro) {
				if(newfecha_venci_sobregiro==null) {
					//newfecha_venci_sobregiro=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna fecha_venci_sobregiro");
					}
				}

				this.fecha_venci_sobregiro=newfecha_venci_sobregiro;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transporte(Long newid_transporte)throws Exception
	{
		try {
			if(this.id_transporte!=newid_transporte) {
				if(newid_transporte==null) {
					//newid_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_transporte");
					}
				}

				this.id_transporte=newid_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_solicitado(Double newvalor_solicitado)throws Exception
	{
		try {
			if(this.valor_solicitado!=newvalor_solicitado) {
				if(newvalor_solicitado==null) {
					//newvalor_solicitado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna valor_solicitado");
					}
				}

				this.valor_solicitado=newvalor_solicitado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_aprobado(Double newvalor_aprobado)throws Exception
	{
		try {
			if(this.valor_aprobado!=newvalor_aprobado) {
				if(newvalor_aprobado==null) {
					//newvalor_aprobado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna valor_aprobado");
					}
				}

				this.valor_aprobado=newvalor_aprobado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_negocio(Long newid_linea_negocio)throws Exception
	{
		try {
			if(this.id_linea_negocio!=newid_linea_negocio) {
				if(newid_linea_negocio==null) {
					//newid_linea_negocio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_linea_negocio");
					}
				}

				this.id_linea_negocio=newid_linea_negocio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_solicitud(Date newfecha_solicitud)throws Exception
	{
		try {
			if(this.fecha_solicitud!=newfecha_solicitud) {
				if(newfecha_solicitud==null) {
					//newfecha_solicitud=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna fecha_solicitud");
					}
				}

				this.fecha_solicitud=newfecha_solicitud;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobsevacion(String newobsevacion)throws Exception
	{
		try {
			if(this.obsevacion!=newobsevacion) {
				if(newobsevacion==null) {
					//newobsevacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna obsevacion");
					}
				}

				if(newobsevacion!=null&&newobsevacion.length()>250) {
					newobsevacion=newobsevacion.substring(0,248);
					System.out.println("PoliticasCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna obsevacion");
				}

				this.obsevacion=newobsevacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setweb(String newweb)throws Exception
	{
		try {
			if(this.web!=newweb) {
				if(newweb==null) {
					//newweb="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna web");
					}
				}

				if(newweb!=null&&newweb.length()>150) {
					newweb=newweb.substring(0,148);
					System.out.println("PoliticasCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna web");
				}

				this.web=newweb;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcasilla_postal(String newcasilla_postal)throws Exception
	{
		try {
			if(this.casilla_postal!=newcasilla_postal) {
				if(newcasilla_postal==null) {
					//newcasilla_postal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna casilla_postal");
					}
				}

				if(newcasilla_postal!=null&&newcasilla_postal.length()>50) {
					newcasilla_postal=newcasilla_postal.substring(0,48);
					System.out.println("PoliticasCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna casilla_postal");
				}

				this.casilla_postal=newcasilla_postal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setforma_envio(String newforma_envio)throws Exception
	{
		try {
			if(this.forma_envio!=newforma_envio) {
				if(newforma_envio==null) {
					//newforma_envio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna forma_envio");
					}
				}

				if(newforma_envio!=null&&newforma_envio.length()>150) {
					newforma_envio=newforma_envio.substring(0,148);
					System.out.println("PoliticasCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna forma_envio");
				}

				this.forma_envio=newforma_envio;
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
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_banco");
					}
				}

				this.id_banco=newid_banco;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_banco_global(Long newid_tipo_cuenta_banco_global)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_banco_global!=newid_tipo_cuenta_banco_global) {
				if(newid_tipo_cuenta_banco_global==null) {
					//newid_tipo_cuenta_banco_global=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_tipo_cuenta_banco_global");
					}
				}

				this.id_tipo_cuenta_banco_global=newid_tipo_cuenta_banco_global;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_cuenta(String newnumero_cuenta)throws Exception
	{
		try {
			if(this.numero_cuenta!=newnumero_cuenta) {
				if(newnumero_cuenta==null) {
					//newnumero_cuenta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna numero_cuenta");
					}
				}

				if(newnumero_cuenta!=null&&newnumero_cuenta.length()>50) {
					newnumero_cuenta=newnumero_cuenta.substring(0,48);
					System.out.println("PoliticasCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_cuenta");
				}

				this.numero_cuenta=newnumero_cuenta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_politicas_cliente(Long newid_estado_politicas_cliente)throws Exception
	{
		try {
			if(this.id_estado_politicas_cliente!=newid_estado_politicas_cliente) {
				if(newid_estado_politicas_cliente==null) {
					//newid_estado_politicas_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PoliticasCliente:Valor nulo no permitido en columna id_estado_politicas_cliente");
					}
				}

				this.id_estado_politicas_cliente=newid_estado_politicas_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Cliente getCliente() {
		return this.cliente;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Transporte getTransporte() {
		return this.transporte;
	}

	public LineaNegocio getLineaNegocio() {
		return this.lineanegocio;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() {
		return this.tipocuentabancoglobal;
	}

	public EstadoPoliticasCliente getEstadoPoliticasCliente() {
		return this.estadopoliticascliente;
	}

	
	
	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String gettransporte_descripcion() {
		return this.transporte_descripcion;
	}

	public String getlineanegocio_descripcion() {
		return this.lineanegocio_descripcion;
	}

	public String getbanco_descripcion() {
		return this.banco_descripcion;
	}

	public String gettipocuentabancoglobal_descripcion() {
		return this.tipocuentabancoglobal_descripcion;
	}

	public String getestadopoliticascliente_descripcion() {
		return this.estadopoliticascliente_descripcion;
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


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransporte(Transporte transporte) {
		try {
			this.transporte=transporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaNegocio(LineaNegocio lineanegocio) {
		try {
			this.lineanegocio=lineanegocio;
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


	public  void  setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobal=tipocuentabancoglobal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPoliticasCliente(EstadoPoliticasCliente estadopoliticascliente) {
		try {
			this.estadopoliticascliente=estadopoliticascliente;
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


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransporte_descripcion(String transporte_descripcion) {
		try {
			this.transporte_descripcion=transporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineanegocio_descripcion(String lineanegocio_descripcion) {
		try {
			this.lineanegocio_descripcion=lineanegocio_descripcion;
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


	public  void  settipocuentabancoglobal_descripcion(String tipocuentabancoglobal_descripcion) {
		try {
			this.tipocuentabancoglobal_descripcion=tipocuentabancoglobal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopoliticascliente_descripcion(String estadopoliticascliente_descripcion) {
		try {
			this.estadopoliticascliente_descripcion=estadopoliticascliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_clienteNONE_descripcion="";String id_empresa_descripcion="";String id_tipo_precio_descripcion="";String con_lista_precio_descripcion="";String con_impuestos_descripcion="";String activar_monto_facturacion_descripcion="";String id_transporte_descripcion="";String id_linea_negocio_descripcion="";String id_banco_descripcion="";String id_tipo_cuenta_banco_global_descripcion="";String id_estado_politicas_cliente_descripcion="";
	
	
	public String getid_clienteNONE_descripcion() {
		return id_clienteNONE_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getcon_lista_precio_descripcion() {
		return con_lista_precio_descripcion;
	}
	public String getcon_impuestos_descripcion() {
		return con_impuestos_descripcion;
	}
	public String getactivar_monto_facturacion_descripcion() {
		return activar_monto_facturacion_descripcion;
	}
	public String getid_transporte_descripcion() {
		return id_transporte_descripcion;
	}
	public String getid_linea_negocio_descripcion() {
		return id_linea_negocio_descripcion;
	}
	public String getid_banco_descripcion() {
		return id_banco_descripcion;
	}
	public String getid_tipo_cuenta_banco_global_descripcion() {
		return id_tipo_cuenta_banco_global_descripcion;
	}
	public String getid_estado_politicas_cliente_descripcion() {
		return id_estado_politicas_cliente_descripcion;
	}
	
	
	public void setid_clienteNONE_descripcion(String newid_clienteNONE_descripcion)throws Exception {
		try {
			this.id_clienteNONE_descripcion=newid_clienteNONE_descripcion;
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
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_lista_precio_descripcion(String newcon_lista_precio_descripcion)throws Exception {
		try {
			this.con_lista_precio_descripcion=newcon_lista_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_impuestos_descripcion(String newcon_impuestos_descripcion)throws Exception {
		try {
			this.con_impuestos_descripcion=newcon_impuestos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setactivar_monto_facturacion_descripcion(String newactivar_monto_facturacion_descripcion)throws Exception {
		try {
			this.activar_monto_facturacion_descripcion=newactivar_monto_facturacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transporte_descripcion(String newid_transporte_descripcion)throws Exception {
		try {
			this.id_transporte_descripcion=newid_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_negocio_descripcion(String newid_linea_negocio_descripcion)throws Exception {
		try {
			this.id_linea_negocio_descripcion=newid_linea_negocio_descripcion;
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
	public void setid_tipo_cuenta_banco_global_descripcion(String newid_tipo_cuenta_banco_global_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_banco_global_descripcion=newid_tipo_cuenta_banco_global_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_politicas_cliente_descripcion(String newid_estado_politicas_cliente_descripcion)throws Exception {
		try {
			this.id_estado_politicas_cliente_descripcion=newid_estado_politicas_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_precio_descripcion="";this.con_lista_precio_descripcion="";this.con_impuestos_descripcion="";this.activar_monto_facturacion_descripcion="";this.id_transporte_descripcion="";this.id_linea_negocio_descripcion="";this.id_banco_descripcion="";this.id_tipo_cuenta_banco_global_descripcion="";this.id_estado_politicas_cliente_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

