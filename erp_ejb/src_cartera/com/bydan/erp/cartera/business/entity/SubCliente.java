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
//import com.bydan.erp.cartera.util.SubClienteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class SubCliente extends SubClienteAdditional implements Serializable ,Cloneable {//SubClienteAdditional,GeneralEntity
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
	
	private SubCliente subclienteOriginal;
	
	private Map<String, Object> mapSubCliente;
			
	public Map<String, Object> getMapSubCliente() {
		return mapSubCliente;
	}

	public void setMapSubCliente(Map<String, Object> mapSubCliente) {
		this.mapSubCliente = mapSubCliente;
	}
	
	public void inicializarMapSubCliente() {
		this.mapSubCliente = new HashMap<String,Object>();
	}
	
	public void setMapSubClienteValue(String sKey,Object oValue) {
		this.mapSubCliente.put(sKey, oValue);
	}
	
	public Object getMapSubClienteValue(String sKey) {
		return this.mapSubCliente.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=25,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXIDENTIFICACION,message=SubClienteConstantesFunciones.SMENSAJEREGEXIDENTIFICACION)
	private String identificacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXRUC,message=SubClienteConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXNOMBRE,message=SubClienteConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXAPELLIDO,message=SubClienteConstantesFunciones.SMENSAJEREGEXAPELLIDO)
	private String apellido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=SubClienteConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXDIRECCION,message=SubClienteConstantesFunciones.SMENSAJEREGEXDIRECCION)
	private String direccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXTELEFONO,message=SubClienteConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXNUMERO_CELULAR,message=SubClienteConstantesFunciones.SMENSAJEREGEXNUMERO_CELULAR)
	private String numero_celular;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXMAIL,message=SubClienteConstantesFunciones.SMENSAJEREGEXMAIL)
	private String mail;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_nacimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fechao;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXOBSERVACION,message=SubClienteConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_pais_nacionalidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_genero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_civil;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_legal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_nivel_edu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXPATH_IMAGEN_FIRMA,message=SubClienteConstantesFunciones.SMENSAJEREGEXPATH_IMAGEN_FIRMA)
	private String path_imagen_firma;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_carga;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double limite_credito;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=SubClienteConstantesFunciones.SREGEXCODIGO_CONTRATO,message=SubClienteConstantesFunciones.SMENSAJEREGEXCODIGO_CONTRATO)
	private String codigo_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_contrato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer plazo;
			
	
	public Empresa empresa;
	public Cliente cliente;
	public Sucursal sucursal;
	public TipoIdentificacion tipoidentificacion;
	public Pais pais;
	public Ciudad ciudad;
	public Zona zona;
	public Pais paisnacionalidad;
	public TipoGenero tipogenero;
	public EstadoCivil estadocivil;
	public EstadoLegal estadolegal;
	public TipoNivelEdu tiponiveledu;
	public CuentaContable cuentacontable;
	
	
	private String empresa_descripcion;
	private String cliente_descripcion;
	private String sucursal_descripcion;
	private String tipoidentificacion_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	private String paisnacionalidad_descripcion;
	private String tipogenero_descripcion;
	private String estadocivil_descripcion;
	private String estadolegal_descripcion;
	private String tiponiveledu_descripcion;
	private String cuentacontable_descripcion;
	
	
	public List<Factura> facturas;
	public List<Consignacion> consignacions;
	public List<GuiaRemision> guiaremisions;
	public List<Proforma> proformas;
	public List<PedidoExpor> pedidoexpors;
	public List<Pedido> pedidos;
		
	public SubCliente () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.subclienteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_cliente=-1L;
 		this.id_sucursal=-1L;
 		this.id_tipo_identificacion=-1L;
 		this.identificacion="";
 		this.ruc="";
 		this.nombre="";
 		this.apellido="";
 		this.nombre_completo="";
 		this.direccion="";
 		this.telefono="";
 		this.numero_celular="";
 		this.mail="";
 		this.fecha_nacimiento=new Date();
 		this.fechao=new Date();
 		this.observacion="";
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.id_pais_nacionalidad=-1L;
 		this.id_tipo_genero=-1L;
 		this.id_estado_civil=-1L;
 		this.id_estado_legal=-1L;
 		this.id_tipo_nivel_edu=-1L;
 		this.path_imagen_firma="";
 		this.id_cuenta_contable=-1L;
 		this.numero_carga=0;
 		this.limite_credito=0.0;
 		this.descuento=0.0;
 		this.codigo_contrato="";
 		this.valor_contrato=0.0;
 		this.fecha_inicio=new Date();
 		this.fecha_fin=new Date();
 		this.plazo=0;
		
		
		this.empresa=null;
		this.cliente=null;
		this.sucursal=null;
		this.tipoidentificacion=null;
		this.pais=null;
		this.ciudad=null;
		this.zona=null;
		this.paisnacionalidad=null;
		this.tipogenero=null;
		this.estadocivil=null;
		this.estadolegal=null;
		this.tiponiveledu=null;
		this.cuentacontable=null;
		
		
		this.empresa_descripcion="";
		this.cliente_descripcion="";
		this.sucursal_descripcion="";
		this.tipoidentificacion_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		this.paisnacionalidad_descripcion="";
		this.tipogenero_descripcion="";
		this.estadocivil_descripcion="";
		this.estadolegal_descripcion="";
		this.tiponiveledu_descripcion="";
		this.cuentacontable_descripcion="";
		
		
		this.facturas=null;
		this.consignacions=null;
		this.guiaremisions=null;
		this.proformas=null;
		this.pedidoexpors=null;
		this.pedidos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SubCliente (Long id,Date versionRow,Long id_empresa,Long id_cliente,Long id_sucursal,Long id_tipo_identificacion,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String direccion,String telefono,String numero_celular,String mail,Date fecha_nacimiento,Date fechao,String observacion,Long id_pais,Long id_ciudad,Long id_zona,Long id_pais_nacionalidad,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Long id_tipo_nivel_edu,String path_imagen_firma,Long id_cuenta_contable,Integer numero_carga,Double limite_credito,Double descuento,String codigo_contrato,Double valor_contrato,Date fecha_inicio,Date fecha_fin,Integer plazo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.subclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.numero_celular=numero_celular;
 		this.mail=mail;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.fechao=fechao;
 		this.observacion=observacion;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.path_imagen_firma=path_imagen_firma;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.numero_carga=numero_carga;
 		this.limite_credito=limite_credito;
 		this.descuento=descuento;
 		this.codigo_contrato=codigo_contrato;
 		this.valor_contrato=valor_contrato;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.plazo=plazo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SubCliente (Long id_empresa,Long id_cliente,Long id_sucursal,Long id_tipo_identificacion,String identificacion,String ruc,String nombre,String apellido,String nombre_completo,String direccion,String telefono,String numero_celular,String mail,Date fecha_nacimiento,Date fechao,String observacion,Long id_pais,Long id_ciudad,Long id_zona,Long id_pais_nacionalidad,Long id_tipo_genero,Long id_estado_civil,Long id_estado_legal,Long id_tipo_nivel_edu,String path_imagen_firma,Long id_cuenta_contable,Integer numero_carga,Double limite_credito,Double descuento,String codigo_contrato,Double valor_contrato,Date fecha_inicio,Date fecha_fin,Integer plazo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.subclienteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_cliente=id_cliente;
 		this.id_sucursal=id_sucursal;
 		this.id_tipo_identificacion=id_tipo_identificacion;
 		this.identificacion=identificacion;
 		this.ruc=ruc;
 		this.nombre=nombre;
 		this.apellido=apellido;
 		this.nombre_completo=nombre_completo;
 		this.direccion=direccion;
 		this.telefono=telefono;
 		this.numero_celular=numero_celular;
 		this.mail=mail;
 		this.fecha_nacimiento=fecha_nacimiento;
 		this.fechao=fechao;
 		this.observacion=observacion;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.id_pais_nacionalidad=id_pais_nacionalidad;
 		this.id_tipo_genero=id_tipo_genero;
 		this.id_estado_civil=id_estado_civil;
 		this.id_estado_legal=id_estado_legal;
 		this.id_tipo_nivel_edu=id_tipo_nivel_edu;
 		this.path_imagen_firma=path_imagen_firma;
 		this.id_cuenta_contable=id_cuenta_contable;
 		this.numero_carga=numero_carga;
 		this.limite_credito=limite_credito;
 		this.descuento=descuento;
 		this.codigo_contrato=codigo_contrato;
 		this.valor_contrato=valor_contrato;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_fin=fecha_fin;
 		this.plazo=plazo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		SubCliente subclienteLocal=null;
		
		if(object!=null) {
			subclienteLocal=(SubCliente)object;
			
			if(subclienteLocal!=null) {
				if(this.getId()!=null && subclienteLocal.getId()!=null) {
					if(this.getId().equals(subclienteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!SubClienteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=SubClienteConstantesFunciones.getSubClienteDescripcion(this);
		} else {
			sDetalle=SubClienteConstantesFunciones.getSubClienteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public SubCliente getSubClienteOriginal() {
		return this.subclienteOriginal;
	}
	
	public void setSubClienteOriginal(SubCliente subcliente) {
		try {
			this.subclienteOriginal=subcliente;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SubClienteAdditional subclienteAdditional=null;
	
	public SubClienteAdditional getSubClienteAdditional() {
		return this.subclienteAdditional;
	}
	
	public void setSubClienteAdditional(SubClienteAdditional subclienteAdditional) {
		try {
			this.subclienteAdditional=subclienteAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public Long getid_tipo_identificacion() {
		return this.id_tipo_identificacion;
	}
    
	
	public String getidentificacion() {
		return this.identificacion;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getapellido() {
		return this.apellido;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getdireccion() {
		return this.direccion;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public String getnumero_celular() {
		return this.numero_celular;
	}
    
	
	public String getmail() {
		return this.mail;
	}
    
	
	public Date getfecha_nacimiento() {
		return this.fecha_nacimiento;
	}
    
	
	public Date getfechao() {
		return this.fechao;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
    
	
	public Long getid_pais() {
		return this.id_pais;
	}
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
    
	
	public Long getid_pais_nacionalidad() {
		return this.id_pais_nacionalidad;
	}
    
	
	public Long getid_tipo_genero() {
		return this.id_tipo_genero;
	}
    
	
	public Long getid_estado_civil() {
		return this.id_estado_civil;
	}
    
	
	public Long getid_estado_legal() {
		return this.id_estado_legal;
	}
    
	
	public Long getid_tipo_nivel_edu() {
		return this.id_tipo_nivel_edu;
	}
    
	
	public String getpath_imagen_firma() {
		return this.path_imagen_firma;
	}
    
	
	public Long getid_cuenta_contable() {
		return this.id_cuenta_contable;
	}
    
	
	public Integer getnumero_carga() {
		return this.numero_carga;
	}
    
	
	public Double getlimite_credito() {
		return this.limite_credito;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public String getcodigo_contrato() {
		return this.codigo_contrato;
	}
    
	
	public Double getvalor_contrato() {
		return this.valor_contrato;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_fin() {
		return this.fecha_fin;
	}
    
	
	public Integer getplazo() {
		return this.plazo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_identificacion(Long newid_tipo_identificacion)throws Exception
	{
		try {
			if(this.id_tipo_identificacion!=newid_tipo_identificacion) {
				if(newid_tipo_identificacion==null) {
					//newid_tipo_identificacion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_tipo_identificacion");
					}
				}

				this.id_tipo_identificacion=newid_tipo_identificacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setidentificacion(String newidentificacion)throws Exception
	{
		try {
			if(this.identificacion!=newidentificacion) {
				if(newidentificacion==null) {
					//newidentificacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna identificacion");
					}
				}

				if(newidentificacion!=null&&newidentificacion.length()>25) {
					newidentificacion=newidentificacion.substring(0,23);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=25 en columna identificacion");
				}

				this.identificacion=newidentificacion;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre(String newnombre)throws Exception
	{
		try {
			if(this.nombre!=newnombre) {
				if(newnombre==null) {
					//newnombre="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido(String newapellido)throws Exception
	{
		try {
			if(this.apellido!=newapellido) {
				if(newapellido==null) {
					//newapellido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna apellido");
					}
				}

				if(newapellido!=null&&newapellido.length()>100) {
					newapellido=newapellido.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna apellido");
				}

				this.apellido=newapellido;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>200) {
					newnombre_completo=newnombre_completo.substring(0,198);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion(String newdireccion)throws Exception
	{
		try {
			if(this.direccion!=newdireccion) {
				if(newdireccion==null) {
					//newdireccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna direccion");
					}
				}

				if(newdireccion!=null&&newdireccion.length()>150) {
					newdireccion=newdireccion.substring(0,148);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion");
				}

				this.direccion=newdireccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>100) {
					newtelefono=newtelefono.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_celular(String newnumero_celular)throws Exception
	{
		try {
			if(this.numero_celular!=newnumero_celular) {
				if(newnumero_celular==null) {
					//newnumero_celular="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna numero_celular");
					}
				}

				if(newnumero_celular!=null&&newnumero_celular.length()>100) {
					newnumero_celular=newnumero_celular.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna numero_celular");
				}

				this.numero_celular=newnumero_celular;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmail(String newmail)throws Exception
	{
		try {
			if(this.mail!=newmail) {
				if(newmail==null) {
					//newmail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna mail");
					}
				}

				if(newmail!=null&&newmail.length()>100) {
					newmail=newmail.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna mail");
				}

				this.mail=newmail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_nacimiento(Date newfecha_nacimiento)throws Exception
	{
		try {
			if(this.fecha_nacimiento!=newfecha_nacimiento) {
				if(newfecha_nacimiento==null) {
					//newfecha_nacimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna fecha_nacimiento");
					}
				}

				this.fecha_nacimiento=newfecha_nacimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfechao(Date newfechao)throws Exception
	{
		try {
			if(this.fechao!=newfechao) {
				if(newfechao==null) {
					//newfechao=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna fechao");
					}
				}

				this.fechao=newfechao;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_pais");
					}
				}

				this.id_pais=newid_pais;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_ciudad");
					}
				}

				this.id_ciudad=newid_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_zona(Long newid_zona)throws Exception
	{
		try {
			if(this.id_zona!=newid_zona) {
				if(newid_zona==null) {
					//newid_zona=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_pais_nacionalidad(Long newid_pais_nacionalidad)throws Exception
	{
		try {
			if(this.id_pais_nacionalidad!=newid_pais_nacionalidad) {
				if(newid_pais_nacionalidad==null) {
					//newid_pais_nacionalidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_pais_nacionalidad");
					}
				}

				this.id_pais_nacionalidad=newid_pais_nacionalidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_genero(Long newid_tipo_genero)throws Exception
	{
		try {
			if(this.id_tipo_genero!=newid_tipo_genero) {
				if(newid_tipo_genero==null) {
					//newid_tipo_genero=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_tipo_genero");
					}
				}

				this.id_tipo_genero=newid_tipo_genero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_civil(Long newid_estado_civil)throws Exception
	{
		try {
			if(this.id_estado_civil!=newid_estado_civil) {
				if(newid_estado_civil==null) {
					//newid_estado_civil=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_estado_civil");
					}
				}

				this.id_estado_civil=newid_estado_civil;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_legal(Long newid_estado_legal)throws Exception
	{
		try {
			if(this.id_estado_legal!=newid_estado_legal) {
				if(newid_estado_legal==null) {
					//newid_estado_legal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_estado_legal");
					}
				}

				this.id_estado_legal=newid_estado_legal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_nivel_edu(Long newid_tipo_nivel_edu)throws Exception
	{
		try {
			if(this.id_tipo_nivel_edu!=newid_tipo_nivel_edu) {
				if(newid_tipo_nivel_edu==null) {
					//newid_tipo_nivel_edu=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_tipo_nivel_edu");
					}
				}

				this.id_tipo_nivel_edu=newid_tipo_nivel_edu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_imagen_firma(String newpath_imagen_firma)throws Exception
	{
		try {
			if(this.path_imagen_firma!=newpath_imagen_firma) {
				if(newpath_imagen_firma==null) {
					//newpath_imagen_firma="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna path_imagen_firma");
					}
				}

				if(newpath_imagen_firma!=null&&newpath_imagen_firma.length()>100) {
					newpath_imagen_firma=newpath_imagen_firma.substring(0,98);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna path_imagen_firma");
				}

				this.path_imagen_firma=newpath_imagen_firma;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable(Long newid_cuenta_contable)throws Exception
	{
		try {
			if(this.id_cuenta_contable!=newid_cuenta_contable) {
				if(newid_cuenta_contable==null) {
					//newid_cuenta_contable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna id_cuenta_contable");
					}
				}

				this.id_cuenta_contable=newid_cuenta_contable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_carga(Integer newnumero_carga)throws Exception
	{
		try {
			if(this.numero_carga!=newnumero_carga) {
				if(newnumero_carga==null) {
					//newnumero_carga=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna numero_carga");
					}
				}

				this.numero_carga=newnumero_carga;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna limite_credito");
					}
				}

				this.limite_credito=newlimite_credito;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_contrato(String newcodigo_contrato)throws Exception
	{
		try {
			if(this.codigo_contrato!=newcodigo_contrato) {
				if(newcodigo_contrato==null) {
					//newcodigo_contrato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna codigo_contrato");
					}
				}

				if(newcodigo_contrato!=null&&newcodigo_contrato.length()>50) {
					newcodigo_contrato=newcodigo_contrato.substring(0,48);
					System.out.println("SubCliente:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_contrato");
				}

				this.codigo_contrato=newcodigo_contrato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_contrato(Double newvalor_contrato)throws Exception
	{
		try {
			if(this.valor_contrato!=newvalor_contrato) {
				if(newvalor_contrato==null) {
					//newvalor_contrato=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna valor_contrato");
					}
				}

				this.valor_contrato=newvalor_contrato;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
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
						System.out.println("SubCliente:Valor nulo no permitido en columna fecha_fin");
					}
				}

				this.fecha_fin=newfecha_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setplazo(Integer newplazo)throws Exception
	{
		try {
			if(this.plazo!=newplazo) {
				if(newplazo==null) {
					//newplazo=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SubCliente:Valor nulo no permitido en columna plazo");
					}
				}

				this.plazo=newplazo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoidentificacion;
	}

	public Pais getPais() {
		return this.pais;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public Pais getPaisNacionalidad() {
		return this.paisnacionalidad;
	}

	public TipoGenero getTipoGenero() {
		return this.tipogenero;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadocivil;
	}

	public EstadoLegal getEstadoLegal() {
		return this.estadolegal;
	}

	public TipoNivelEdu getTipoNivelEdu() {
		return this.tiponiveledu;
	}

	public CuentaContable getCuentaContable() {
		return this.cuentacontable;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettipoidentificacion_descripcion() {
		return this.tipoidentificacion_descripcion;
	}

	public String getpais_descripcion() {
		return this.pais_descripcion;
	}

	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
	}

	public String getpaisnacionalidad_descripcion() {
		return this.paisnacionalidad_descripcion;
	}

	public String gettipogenero_descripcion() {
		return this.tipogenero_descripcion;
	}

	public String getestadocivil_descripcion() {
		return this.estadocivil_descripcion;
	}

	public String getestadolegal_descripcion() {
		return this.estadolegal_descripcion;
	}

	public String gettiponiveledu_descripcion() {
		return this.tiponiveledu_descripcion;
	}

	public String getcuentacontable_descripcion() {
		return this.cuentacontable_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoIdentificacion(TipoIdentificacion tipoidentificacion) {
		try {
			this.tipoidentificacion=tipoidentificacion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPais(Pais pais) {
		try {
			this.pais=pais;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCiudad(Ciudad ciudad) {
		try {
			this.ciudad=ciudad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setZona(Zona zona) {
		try {
			this.zona=zona;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPaisNacionalidad(Pais paisnacionalidad) {
		try {
			this.paisnacionalidad=paisnacionalidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGenero(TipoGenero tipogenero) {
		try {
			this.tipogenero=tipogenero;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoCivil(EstadoCivil estadocivil) {
		try {
			this.estadocivil=estadocivil;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoLegal(EstadoLegal estadolegal) {
		try {
			this.estadolegal=estadolegal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoNivelEdu(TipoNivelEdu tiponiveledu) {
		try {
			this.tiponiveledu=tiponiveledu;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoidentificacion_descripcion(String tipoidentificacion_descripcion) {
		try {
			this.tipoidentificacion_descripcion=tipoidentificacion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpais_descripcion(String pais_descripcion) {
		try {
			this.pais_descripcion=pais_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setciudad_descripcion(String ciudad_descripcion) {
		try {
			this.ciudad_descripcion=ciudad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setzona_descripcion(String zona_descripcion) {
		try {
			this.zona_descripcion=zona_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setpaisnacionalidad_descripcion(String paisnacionalidad_descripcion) {
		try {
			this.paisnacionalidad_descripcion=paisnacionalidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogenero_descripcion(String tipogenero_descripcion) {
		try {
			this.tipogenero_descripcion=tipogenero_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadocivil_descripcion(String estadocivil_descripcion) {
		try {
			this.estadocivil_descripcion=estadocivil_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadolegal_descripcion(String estadolegal_descripcion) {
		try {
			this.estadolegal_descripcion=estadolegal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiponiveledu_descripcion(String tiponiveledu_descripcion) {
		try {
			this.tiponiveledu_descripcion=tiponiveledu_descripcion;
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


	
	
	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public List<Consignacion> getConsignacions() {
		return this.consignacions;
	}

	public List<GuiaRemision> getGuiaRemisions() {
		return this.guiaremisions;
	}

	public List<Proforma> getProformas() {
		return this.proformas;
	}

	public List<PedidoExpor> getPedidoExpors() {
		return this.pedidoexpors;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	
	
	public  void  setFacturas(List<Factura> facturas) {
		try {
			this.facturas=facturas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setConsignacions(List<Consignacion> consignacions) {
		try {
			this.consignacions=consignacions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setGuiaRemisions(List<GuiaRemision> guiaremisions) {
		try {
			this.guiaremisions=guiaremisions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProformas(List<Proforma> proformas) {
		try {
			this.proformas=proformas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoExpors(List<PedidoExpor> pedidoexpors) {
		try {
			this.pedidoexpors=pedidoexpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidos(List<Pedido> pedidos) {
		try {
			this.pedidos=pedidos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_cliente_descripcion="";String id_sucursal_descripcion="";String id_tipo_identificacion_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";String id_pais_nacionalidad_descripcion="";String id_tipo_genero_descripcion="";String id_estado_civil_descripcion="";String id_estado_legal_descripcion="";String id_tipo_nivel_edu_descripcion="";String id_cuenta_contable_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_identificacion_descripcion() {
		return id_tipo_identificacion_descripcion;
	}
	public String getid_pais_descripcion() {
		return id_pais_descripcion;
	}
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
	}
	public String getid_pais_nacionalidad_descripcion() {
		return id_pais_nacionalidad_descripcion;
	}
	public String getid_tipo_genero_descripcion() {
		return id_tipo_genero_descripcion;
	}
	public String getid_estado_civil_descripcion() {
		return id_estado_civil_descripcion;
	}
	public String getid_estado_legal_descripcion() {
		return id_estado_legal_descripcion;
	}
	public String getid_tipo_nivel_edu_descripcion() {
		return id_tipo_nivel_edu_descripcion;
	}
	public String getid_cuenta_contable_descripcion() {
		return id_cuenta_contable_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_identificacion_descripcion(String newid_tipo_identificacion_descripcion)throws Exception {
		try {
			this.id_tipo_identificacion_descripcion=newid_tipo_identificacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_descripcion(String newid_pais_descripcion)throws Exception {
		try {
			this.id_pais_descripcion=newid_pais_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ciudad_descripcion(String newid_ciudad_descripcion)throws Exception {
		try {
			this.id_ciudad_descripcion=newid_ciudad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_zona_descripcion(String newid_zona_descripcion)throws Exception {
		try {
			this.id_zona_descripcion=newid_zona_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_pais_nacionalidad_descripcion(String newid_pais_nacionalidad_descripcion)throws Exception {
		try {
			this.id_pais_nacionalidad_descripcion=newid_pais_nacionalidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_genero_descripcion(String newid_tipo_genero_descripcion)throws Exception {
		try {
			this.id_tipo_genero_descripcion=newid_tipo_genero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_civil_descripcion(String newid_estado_civil_descripcion)throws Exception {
		try {
			this.id_estado_civil_descripcion=newid_estado_civil_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_legal_descripcion(String newid_estado_legal_descripcion)throws Exception {
		try {
			this.id_estado_legal_descripcion=newid_estado_legal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_nivel_edu_descripcion(String newid_tipo_nivel_edu_descripcion)throws Exception {
		try {
			this.id_tipo_nivel_edu_descripcion=newid_tipo_nivel_edu_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_cliente_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_identificacion_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.id_pais_nacionalidad_descripcion="";this.id_tipo_genero_descripcion="";this.id_estado_civil_descripcion="";this.id_estado_legal_descripcion="";this.id_tipo_nivel_edu_descripcion="";this.id_cuenta_contable_descripcion="";
	}
	
	
	Object facturasDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object proformasDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object pedidosDescripcionReporte;
	
	
	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	
	
	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setconsignacionsDescripcionReporte(Object consignacions) {
		try {
			this.consignacionsDescripcionReporte=consignacions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setguiaremisionsDescripcionReporte(Object guiaremisions) {
		try {
			this.guiaremisionsDescripcionReporte=guiaremisions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproformasDescripcionReporte(Object proformas) {
		try {
			this.proformasDescripcionReporte=proformas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidosDescripcionReporte(Object pedidos) {
		try {
			this.pedidosDescripcionReporte=pedidos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

