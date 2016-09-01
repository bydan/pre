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
package com.bydan.erp.comisiones.business.entity;

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
//import com.bydan.erp.comisiones.util.VendedorConstantesFunciones;
import com.bydan.erp.comisiones.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;




@SuppressWarnings("unused")
public class Vendedor extends VendedorAdditional implements Serializable ,Cloneable {//VendedorAdditional,GeneralEntity
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
	
	private Vendedor vendedorOriginal;
	
	private Map<String, Object> mapVendedor;
			
	public Map<String, Object> getMapVendedor() {
		return mapVendedor;
	}

	public void setMapVendedor(Map<String, Object> mapVendedor) {
		this.mapVendedor = mapVendedor;
	}
	
	public void inicializarMapVendedor() {
		this.mapVendedor = new HashMap<String,Object>();
	}
	
	public void setMapVendedorValue(String sKey,Object oValue) {
		this.mapVendedor.put(sKey, oValue);
	}
	
	public Object getMapVendedorValue(String sKey) {
		return this.mapVendedor.get(sKey);
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
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXCODIGO,message=VendedorConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXNOMBRE,message=VendedorConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=15,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXRUC,message=VendedorConstantesFunciones.SMENSAJEREGEXRUC)
	private String ruc;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXEMAIL,message=VendedorConstantesFunciones.SMENSAJEREGEXEMAIL)
	private String email;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXTELEFONO,message=VendedorConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_empleado_soporte;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_vendedor;
	
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
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXREPRESENTANTE,message=VendedorConstantesFunciones.SMENSAJEREGEXREPRESENTANTE)
	private String representante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_supervisor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_creacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXDIRECCION_DOMICILIO,message=VendedorConstantesFunciones.SMENSAJEREGEXDIRECCION_DOMICILIO)
	private String direccion_domicilio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXDIRECCION_REFERENCIA,message=VendedorConstantesFunciones.SMENSAJEREGEXDIRECCION_REFERENCIA)
	private String direccion_referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VendedorConstantesFunciones.SREGEXDESCRIPCION,message=VendedorConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje_comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double comision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_vendido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_facturas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ultima_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto_ultima_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_presupuesto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_cobertura;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Empleado empleado;
	public Empleado empleadosoporte;
	public Vendedor vendedor;
	public Pais pais;
	public Ciudad ciudad;
	public Zona zona;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String empleado_descripcion;
	private String empleadosoporte_descripcion;
	private String vendedor_descripcion;
	private String pais_descripcion;
	private String ciudad_descripcion;
	private String zona_descripcion;
	
	
	public List<NotaCreditoSoli> notacreditosolis;
	public List<ComisionVentaCobro> comisionventacobros;
	public List<Vendedor> vendedors;
	public List<Cliente> clientes;
	public List<ComisionGrupo> comisiongrupos;
	public List<ComisionLinea> comisionlineas;
	public List<VendedorZona> vendedorzonas;
	public List<ComisionCate> comisioncates;
	public List<CajeroTurno> cajeroturnos;
	public List<ComisionMarca> comisionmarcas;
	public List<PresupuestoVentas> presupuestoventass;
	public List<PresupuestoVentasLineas> presupuestoventaslineass;
		
	public Vendedor () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.vendedorOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.ruc="";
 		this.email="";
 		this.id_empleado=-1L;
 		this.telefono="";
 		this.id_empleado_soporte=null;
 		this.id_vendedor=null;
 		this.id_pais=-1L;
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.representante="";
 		this.es_supervisor=false;
 		this.fecha_creacion=new Date();
 		this.direccion_domicilio="";
 		this.direccion_referencia="";
 		this.descripcion="";
 		this.porcentaje_comision=0.0;
 		this.comision=0.0;
 		this.monto_vendido=0.0;
 		this.numero_facturas=0;
 		this.fecha_ultima_venta=new Date();
 		this.monto_ultima_venta=0.0;
 		this.con_presupuesto=false;
 		this.con_cobertura=false;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.empleado=null;
		this.empleadosoporte=null;
		this.pais=null;
		this.ciudad=null;
		this.zona=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.empleado_descripcion="";
		this.empleadosoporte_descripcion="";
		this.pais_descripcion="";
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		
		
		this.notacreditosolis=null;
		this.comisionventacobros=null;
		this.vendedors=null;
		this.clientes=null;
		this.comisiongrupos=null;
		this.comisionlineas=null;
		this.vendedorzonas=null;
		this.comisioncates=null;
		this.cajeroturnos=null;
		this.comisionmarcas=null;
		this.presupuestoventass=null;
		this.presupuestoventaslineass=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Vendedor (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,String nombre,String ruc,String email,Long id_empleado,String telefono,Long id_empleado_soporte,Long id_vendedor,Long id_pais,Long id_ciudad,Long id_zona,String representante,Boolean es_supervisor,Date fecha_creacion,String direccion_domicilio,String direccion_referencia,String descripcion,Double porcentaje_comision,Double comision,Double monto_vendido,Integer numero_facturas,Date fecha_ultima_venta,Double monto_ultima_venta,Boolean con_presupuesto,Boolean con_cobertura) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vendedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.email=email;
 		this.id_empleado=id_empleado;
 		this.telefono=telefono;
 		this.id_empleado_soporte=id_empleado_soporte;
 		this.id_vendedor=id_vendedor;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.representante=representante;
 		this.es_supervisor=es_supervisor;
 		this.fecha_creacion=fecha_creacion;
 		this.direccion_domicilio=direccion_domicilio;
 		this.direccion_referencia=direccion_referencia;
 		this.descripcion=descripcion;
 		this.porcentaje_comision=porcentaje_comision;
 		this.comision=comision;
 		this.monto_vendido=monto_vendido;
 		this.numero_facturas=numero_facturas;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.monto_ultima_venta=monto_ultima_venta;
 		this.con_presupuesto=con_presupuesto;
 		this.con_cobertura=con_cobertura;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Vendedor (Long id_empresa,Long id_sucursal,String codigo,String nombre,String ruc,String email,Long id_empleado,String telefono,Long id_empleado_soporte,Long id_vendedor,Long id_pais,Long id_ciudad,Long id_zona,String representante,Boolean es_supervisor,Date fecha_creacion,String direccion_domicilio,String direccion_referencia,String descripcion,Double porcentaje_comision,Double comision,Double monto_vendido,Integer numero_facturas,Date fecha_ultima_venta,Double monto_ultima_venta,Boolean con_presupuesto,Boolean con_cobertura) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.vendedorOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.ruc=ruc;
 		this.email=email;
 		this.id_empleado=id_empleado;
 		this.telefono=telefono;
 		this.id_empleado_soporte=id_empleado_soporte;
 		this.id_vendedor=id_vendedor;
 		this.id_pais=id_pais;
 		this.id_ciudad=id_ciudad;
 		this.id_zona=id_zona;
 		this.representante=representante;
 		this.es_supervisor=es_supervisor;
 		this.fecha_creacion=fecha_creacion;
 		this.direccion_domicilio=direccion_domicilio;
 		this.direccion_referencia=direccion_referencia;
 		this.descripcion=descripcion;
 		this.porcentaje_comision=porcentaje_comision;
 		this.comision=comision;
 		this.monto_vendido=monto_vendido;
 		this.numero_facturas=numero_facturas;
 		this.fecha_ultima_venta=fecha_ultima_venta;
 		this.monto_ultima_venta=monto_ultima_venta;
 		this.con_presupuesto=con_presupuesto;
 		this.con_cobertura=con_cobertura;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Vendedor vendedorLocal=null;
		
		if(object!=null) {
			vendedorLocal=(Vendedor)object;
			
			if(vendedorLocal!=null) {
				if(this.getId()!=null && vendedorLocal.getId()!=null) {
					if(this.getId().equals(vendedorLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VendedorConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VendedorConstantesFunciones.getVendedorDescripcion(this);
		} else {
			sDetalle=VendedorConstantesFunciones.getVendedorDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Vendedor getVendedorOriginal() {
		return this.vendedorOriginal;
	}
	
	public void setVendedorOriginal(Vendedor vendedor) {
		try {
			this.vendedorOriginal=vendedor;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VendedorAdditional vendedorAdditional=null;
	
	public VendedorAdditional getVendedorAdditional() {
		return this.vendedorAdditional;
	}
	
	public void setVendedorAdditional(VendedorAdditional vendedorAdditional) {
		try {
			this.vendedorAdditional=vendedorAdditional;
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
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getruc() {
		return this.ruc;
	}
    
	
	public String getemail() {
		return this.email;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Long getid_empleado_soporte() {
		return this.id_empleado_soporte;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
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
    
	
	public String getrepresentante() {
		return this.representante;
	}
    
	
	public Boolean getes_supervisor() {
		return this.es_supervisor;
	}
    
	
	public Date getfecha_creacion() {
		return this.fecha_creacion;
	}
    
	
	public String getdireccion_domicilio() {
		return this.direccion_domicilio;
	}
    
	
	public String getdireccion_referencia() {
		return this.direccion_referencia;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Double getporcentaje_comision() {
		return this.porcentaje_comision;
	}
    
	
	public Double getcomision() {
		return this.comision;
	}
    
	
	public Double getmonto_vendido() {
		return this.monto_vendido;
	}
    
	
	public Integer getnumero_facturas() {
		return this.numero_facturas;
	}
    
	
	public Date getfecha_ultima_venta() {
		return this.fecha_ultima_venta;
	}
    
	
	public Double getmonto_ultima_venta() {
		return this.monto_ultima_venta;
	}
    
	
	public Boolean getcon_presupuesto() {
		return this.con_presupuesto;
	}
    
	
	public Boolean getcon_cobertura() {
		return this.con_cobertura;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Vendedor:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>20) {
					newcodigo=newcodigo.substring(0,18);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("Vendedor:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("Vendedor:Valor nulo no permitido en columna ruc");
					}
				}

				if(newruc!=null&&newruc.length()>15) {
					newruc=newruc.substring(0,13);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=15 en columna ruc");
				}

				this.ruc=newruc;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setemail(String newemail)throws Exception
	{
		try {
			if(this.email!=newemail) {
				if(newemail==null) {
					//newemail="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna email");
					}
				}

				if(newemail!=null&&newemail.length()>100) {
					newemail=newemail.substring(0,98);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna email");
				}

				this.email=newemail;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("Vendedor:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>100) {
					newtelefono=newtelefono.substring(0,98);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_soporte(Long newid_empleado_soporte) {
		if(this.id_empleado_soporte==null&&newid_empleado_soporte!=null) {
			this.id_empleado_soporte=newid_empleado_soporte;
				this.setIsChanged(true);
		}

		if(this.id_empleado_soporte!=null&&!this.id_empleado_soporte.equals(newid_empleado_soporte)) {

			this.id_empleado_soporte=newid_empleado_soporte;
				this.setIsChanged(true);
		}
	}
    
	public void setid_vendedor(Long newid_vendedor) {
		if(this.id_vendedor==null&&newid_vendedor!=null) {
			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}

		if(this.id_vendedor!=null&&!this.id_vendedor.equals(newid_vendedor)) {

			this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
		}
	}
    
	public void setid_pais(Long newid_pais)throws Exception
	{
		try {
			if(this.id_pais!=newid_pais) {
				if(newid_pais==null) {
					//newid_pais=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna id_pais");
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
						System.out.println("Vendedor:Valor nulo no permitido en columna id_ciudad");
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
						System.out.println("Vendedor:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
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
						System.out.println("Vendedor:Valor nulo no permitido en columna representante");
					}
				}

				if(newrepresentante!=null&&newrepresentante.length()>150) {
					newrepresentante=newrepresentante.substring(0,148);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna representante");
				}

				this.representante=newrepresentante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_supervisor(Boolean newes_supervisor)throws Exception
	{
		try {
			if(this.es_supervisor!=newes_supervisor) {
				if(newes_supervisor==null) {
					//newes_supervisor=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna es_supervisor");
					}
				}

				this.es_supervisor=newes_supervisor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_creacion(Date newfecha_creacion)throws Exception
	{
		try {
			if(this.fecha_creacion!=newfecha_creacion) {
				if(newfecha_creacion==null) {
					//newfecha_creacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna fecha_creacion");
					}
				}

				this.fecha_creacion=newfecha_creacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_domicilio(String newdireccion_domicilio)throws Exception
	{
		try {
			if(this.direccion_domicilio!=newdireccion_domicilio) {
				if(newdireccion_domicilio==null) {
					//newdireccion_domicilio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna direccion_domicilio");
					}
				}

				if(newdireccion_domicilio!=null&&newdireccion_domicilio.length()>150) {
					newdireccion_domicilio=newdireccion_domicilio.substring(0,148);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_domicilio");
				}

				this.direccion_domicilio=newdireccion_domicilio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_referencia(String newdireccion_referencia)throws Exception
	{
		try {
			if(this.direccion_referencia!=newdireccion_referencia) {
				if(newdireccion_referencia==null) {
					//newdireccion_referencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna direccion_referencia");
					}
				}

				if(newdireccion_referencia!=null&&newdireccion_referencia.length()>150) {
					newdireccion_referencia=newdireccion_referencia.substring(0,148);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_referencia");
				}

				this.direccion_referencia=newdireccion_referencia;
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
						System.out.println("Vendedor:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Vendedor:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje_comision(Double newporcentaje_comision)throws Exception
	{
		try {
			if(this.porcentaje_comision!=newporcentaje_comision) {
				if(newporcentaje_comision==null) {
					//newporcentaje_comision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna porcentaje_comision");
					}
				}

				this.porcentaje_comision=newporcentaje_comision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcomision(Double newcomision)throws Exception
	{
		try {
			if(this.comision!=newcomision) {
				if(newcomision==null) {
					//newcomision=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna comision");
					}
				}

				this.comision=newcomision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_vendido(Double newmonto_vendido)throws Exception
	{
		try {
			if(this.monto_vendido!=newmonto_vendido) {
				if(newmonto_vendido==null) {
					//newmonto_vendido=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna monto_vendido");
					}
				}

				this.monto_vendido=newmonto_vendido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_facturas(Integer newnumero_facturas)throws Exception
	{
		try {
			if(this.numero_facturas!=newnumero_facturas) {
				if(newnumero_facturas==null) {
					//newnumero_facturas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna numero_facturas");
					}
				}

				this.numero_facturas=newnumero_facturas;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ultima_venta(Date newfecha_ultima_venta)throws Exception
	{
		try {
			if(this.fecha_ultima_venta!=newfecha_ultima_venta) {
				if(newfecha_ultima_venta==null) {
					//newfecha_ultima_venta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna fecha_ultima_venta");
					}
				}

				this.fecha_ultima_venta=newfecha_ultima_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto_ultima_venta(Double newmonto_ultima_venta)throws Exception
	{
		try {
			if(this.monto_ultima_venta!=newmonto_ultima_venta) {
				if(newmonto_ultima_venta==null) {
					//newmonto_ultima_venta=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna monto_ultima_venta");
					}
				}

				this.monto_ultima_venta=newmonto_ultima_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_presupuesto(Boolean newcon_presupuesto)throws Exception
	{
		try {
			if(this.con_presupuesto!=newcon_presupuesto) {
				if(newcon_presupuesto==null) {
					//newcon_presupuesto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna con_presupuesto");
					}
				}

				this.con_presupuesto=newcon_presupuesto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_cobertura(Boolean newcon_cobertura)throws Exception
	{
		try {
			if(this.con_cobertura!=newcon_cobertura) {
				if(newcon_cobertura==null) {
					//newcon_cobertura=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Vendedor:Valor nulo no permitido en columna con_cobertura");
					}
				}

				this.con_cobertura=newcon_cobertura;
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

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Empleado getEmpleadoSoporte() {
		return this.empleadosoporte;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getempleadosoporte_descripcion() {
		return this.empleadosoporte_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
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


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleadoSoporte(Empleado empleadosoporte) {
		try {
			this.empleadosoporte=empleadosoporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setVendedor(Vendedor vendedor) {
		try {
			this.vendedor=vendedor;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleadosoporte_descripcion(String empleadosoporte_descripcion) {
		try {
			this.empleadosoporte_descripcion=empleadosoporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setvendedor_descripcion(String vendedor_descripcion) {
		try {
			this.vendedor_descripcion=vendedor_descripcion;
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


	
	
	public List<NotaCreditoSoli> getNotaCreditoSolis() {
		return this.notacreditosolis;
	}

	public List<ComisionVentaCobro> getComisionVentaCobros() {
		return this.comisionventacobros;
	}

	public List<Vendedor> getVendedors() {
		return this.vendedors;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<ComisionGrupo> getComisionGrupos() {
		return this.comisiongrupos;
	}

	public List<ComisionLinea> getComisionLineas() {
		return this.comisionlineas;
	}

	public List<VendedorZona> getVendedorZonas() {
		return this.vendedorzonas;
	}

	public List<ComisionCate> getComisionCates() {
		return this.comisioncates;
	}

	public List<CajeroTurno> getCajeroTurnos() {
		return this.cajeroturnos;
	}

	public List<ComisionMarca> getComisionMarcas() {
		return this.comisionmarcas;
	}

	public List<PresupuestoVentas> getPresupuestoVentass() {
		return this.presupuestoventass;
	}

	public List<PresupuestoVentasLineas> getPresupuestoVentasLineass() {
		return this.presupuestoventaslineass;
	}

	
	
	public  void  setNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis) {
		try {
			this.notacreditosolis=notacreditosolis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionVentaCobros(List<ComisionVentaCobro> comisionventacobros) {
		try {
			this.comisionventacobros=comisionventacobros;
		} catch(Exception e) {
			;
		}
	}

	public  void  setVendedors(List<Vendedor> vendedors) {
		try {
			this.vendedors=vendedors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setClientes(List<Cliente> clientes) {
		try {
			this.clientes=clientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionGrupos(List<ComisionGrupo> comisiongrupos) {
		try {
			this.comisiongrupos=comisiongrupos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionLineas(List<ComisionLinea> comisionlineas) {
		try {
			this.comisionlineas=comisionlineas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setVendedorZonas(List<VendedorZona> vendedorzonas) {
		try {
			this.vendedorzonas=vendedorzonas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionCates(List<ComisionCate> comisioncates) {
		try {
			this.comisioncates=comisioncates;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCajeroTurnos(List<CajeroTurno> cajeroturnos) {
		try {
			this.cajeroturnos=cajeroturnos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionMarcas(List<ComisionMarca> comisionmarcas) {
		try {
			this.comisionmarcas=comisionmarcas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoVentass(List<PresupuestoVentas> presupuestoventass) {
		try {
			this.presupuestoventass=presupuestoventass;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoVentasLineass(List<PresupuestoVentasLineas> presupuestoventaslineass) {
		try {
			this.presupuestoventaslineass=presupuestoventaslineass;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_empleado_descripcion="";String id_empleado_soporte_descripcion="";String id_vendedor_descripcion="";String id_pais_descripcion="";String id_ciudad_descripcion="";String id_zona_descripcion="";String es_supervisor_descripcion="";String con_presupuesto_descripcion="";String con_cobertura_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_empleado_soporte_descripcion() {
		return id_empleado_soporte_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
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
	public String getes_supervisor_descripcion() {
		return es_supervisor_descripcion;
	}
	public String getcon_presupuesto_descripcion() {
		return con_presupuesto_descripcion;
	}
	public String getcon_cobertura_descripcion() {
		return con_cobertura_descripcion;
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
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_soporte_descripcion(String newid_empleado_soporte_descripcion) {
		this.id_empleado_soporte_descripcion=newid_empleado_soporte_descripcion;
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion) {
		this.id_vendedor_descripcion=newid_vendedor_descripcion;
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
	public void setes_supervisor_descripcion(String newes_supervisor_descripcion)throws Exception {
		try {
			this.es_supervisor_descripcion=newes_supervisor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_presupuesto_descripcion(String newcon_presupuesto_descripcion)throws Exception {
		try {
			this.con_presupuesto_descripcion=newcon_presupuesto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_cobertura_descripcion(String newcon_cobertura_descripcion)throws Exception {
		try {
			this.con_cobertura_descripcion=newcon_cobertura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_empleado_descripcion="";this.id_empleado_soporte_descripcion="";this.id_vendedor_descripcion="";this.id_pais_descripcion="";this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.es_supervisor_descripcion="";this.con_presupuesto_descripcion="";this.con_cobertura_descripcion="";
	}
	
	
	Object notacreditosolisDescripcionReporte;
	Object comisionventacobrosDescripcionReporte;
	Object vendedorsDescripcionReporte;
	Object clientesDescripcionReporte;
	Object comisiongruposDescripcionReporte;
	Object comisionlineasDescripcionReporte;
	Object vendedorzonasDescripcionReporte;
	Object comisioncatesDescripcionReporte;
	Object cajeroturnosDescripcionReporte;
	Object comisionmarcasDescripcionReporte;
	Object presupuestoventassDescripcionReporte;
	Object presupuestoventaslineassDescripcionReporte;
	
	
	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getcomisionventacobrosDescripcionReporte() {
		return comisionventacobrosDescripcionReporte;
	}

	public Object getvendedorsDescripcionReporte() {
		return vendedorsDescripcionReporte;
	}

	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getcomisiongruposDescripcionReporte() {
		return comisiongruposDescripcionReporte;
	}

	public Object getcomisionlineasDescripcionReporte() {
		return comisionlineasDescripcionReporte;
	}

	public Object getvendedorzonasDescripcionReporte() {
		return vendedorzonasDescripcionReporte;
	}

	public Object getcomisioncatesDescripcionReporte() {
		return comisioncatesDescripcionReporte;
	}

	public Object getcajeroturnosDescripcionReporte() {
		return cajeroturnosDescripcionReporte;
	}

	public Object getcomisionmarcasDescripcionReporte() {
		return comisionmarcasDescripcionReporte;
	}

	public Object getpresupuestoventassDescripcionReporte() {
		return presupuestoventassDescripcionReporte;
	}

	public Object getpresupuestoventaslineassDescripcionReporte() {
		return presupuestoventaslineassDescripcionReporte;
	}

	
	
	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionventacobrosDescripcionReporte(Object comisionventacobros) {
		try {
			this.comisionventacobrosDescripcionReporte=comisionventacobros;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvendedorsDescripcionReporte(Object vendedors) {
		try {
			this.vendedorsDescripcionReporte=vendedors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisiongruposDescripcionReporte(Object comisiongrupos) {
		try {
			this.comisiongruposDescripcionReporte=comisiongrupos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionlineasDescripcionReporte(Object comisionlineas) {
		try {
			this.comisionlineasDescripcionReporte=comisionlineas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvendedorzonasDescripcionReporte(Object vendedorzonas) {
		try {
			this.vendedorzonasDescripcionReporte=vendedorzonas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisioncatesDescripcionReporte(Object comisioncates) {
		try {
			this.comisioncatesDescripcionReporte=comisioncates;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcajeroturnosDescripcionReporte(Object cajeroturnos) {
		try {
			this.cajeroturnosDescripcionReporte=cajeroturnos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionmarcasDescripcionReporte(Object comisionmarcas) {
		try {
			this.comisionmarcasDescripcionReporte=comisionmarcas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoventassDescripcionReporte(Object presupuestoventass) {
		try {
			this.presupuestoventassDescripcionReporte=presupuestoventass;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoventaslineassDescripcionReporte(Object presupuestoventaslineass) {
		try {
			this.presupuestoventaslineassDescripcionReporte=presupuestoventaslineass;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

