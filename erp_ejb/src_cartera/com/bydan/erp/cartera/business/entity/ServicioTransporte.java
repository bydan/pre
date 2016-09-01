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
//import com.bydan.erp.cartera.util.ServicioTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class ServicioTransporte extends ServicioTransporteAdditional implements Serializable ,Cloneable {//ServicioTransporteAdditional,GeneralEntity
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
	
	private ServicioTransporte serviciotransporteOriginal;
	
	private Map<String, Object> mapServicioTransporte;
			
	public Map<String, Object> getMapServicioTransporte() {
		return mapServicioTransporte;
	}

	public void setMapServicioTransporte(Map<String, Object> mapServicioTransporte) {
		this.mapServicioTransporte = mapServicioTransporte;
	}
	
	public void inicializarMapServicioTransporte() {
		this.mapServicioTransporte = new HashMap<String,Object>();
	}
	
	public void setMapServicioTransporteValue(String sKey,Object oValue) {
		this.mapServicioTransporte.put(sKey, oValue);
	}
	
	public Object getMapServicioTransporteValue(String sKey) {
		return this.mapServicioTransporte.get(sKey);
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
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente_proveedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transportista;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vehiculo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ruta_transporte;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_detalle_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ingreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ServicioTransporteConstantesFunciones.SREGEXCODIGO_GUIA1,message=ServicioTransporteConstantesFunciones.SMENSAJEREGEXCODIGO_GUIA1)
	private String codigo_guia1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ServicioTransporteConstantesFunciones.SREGEXCODIGO_GUIA2,message=ServicioTransporteConstantesFunciones.SMENSAJEREGEXCODIGO_GUIA2)
	private String codigo_guia2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ServicioTransporteConstantesFunciones.SREGEXDESCRIPCION,message=ServicioTransporteConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Cliente cliente;
	public Cliente clienteproveedor;
	public Transportista transportista;
	public Vehiculo vehiculo;
	public RutaTransporte rutatransporte;
	public DetalleActivoFijo detalleactivofijo;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String cliente_descripcion;
	private String clienteproveedor_descripcion;
	private String transportista_descripcion;
	private String vehiculo_descripcion;
	private String rutatransporte_descripcion;
	private String detalleactivofijo_descripcion;
	
	
	public List<DetalleServicioTransporte> detalleserviciotransportes;
		
	public ServicioTransporte () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.serviciotransporteOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_cliente=-1L;
 		this.id_cliente_proveedor=-1L;
 		this.id_transportista=-1L;
 		this.id_vehiculo=-1L;
 		this.id_ruta_transporte=-1L;
 		this.id_detalle_activo_fijo=-1L;
 		this.fecha_ingreso=new Date();
 		this.fecha_entrega=new Date();
 		this.codigo_guia1="";
 		this.codigo_guia2="";
 		this.precio=0.0;
 		this.valor_iva=0.0;
 		this.valor_total=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.cliente=null;
		this.clienteproveedor=null;
		this.transportista=null;
		this.vehiculo=null;
		this.rutatransporte=null;
		this.detalleactivofijo=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.cliente_descripcion="";
		this.clienteproveedor_descripcion="";
		this.transportista_descripcion="";
		this.vehiculo_descripcion="";
		this.rutatransporte_descripcion="";
		this.detalleactivofijo_descripcion="";
		
		
		this.detalleserviciotransportes=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ServicioTransporte (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_cliente,Long id_cliente_proveedor,Long id_transportista,Long id_vehiculo,Long id_ruta_transporte,Long id_detalle_activo_fijo,Date fecha_ingreso,Date fecha_entrega,String codigo_guia1,String codigo_guia2,Double precio,Double valor_iva,Double valor_total,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.serviciotransporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_transportista=id_transportista;
 		this.id_vehiculo=id_vehiculo;
 		this.id_ruta_transporte=id_ruta_transporte;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_entrega=fecha_entrega;
 		this.codigo_guia1=codigo_guia1;
 		this.codigo_guia2=codigo_guia2;
 		this.precio=precio;
 		this.valor_iva=valor_iva;
 		this.valor_total=valor_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ServicioTransporte (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_cliente,Long id_cliente_proveedor,Long id_transportista,Long id_vehiculo,Long id_ruta_transporte,Long id_detalle_activo_fijo,Date fecha_ingreso,Date fecha_entrega,String codigo_guia1,String codigo_guia2,Double precio,Double valor_iva,Double valor_total,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.serviciotransporteOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_cliente=id_cliente;
 		this.id_cliente_proveedor=id_cliente_proveedor;
 		this.id_transportista=id_transportista;
 		this.id_vehiculo=id_vehiculo;
 		this.id_ruta_transporte=id_ruta_transporte;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.fecha_ingreso=fecha_ingreso;
 		this.fecha_entrega=fecha_entrega;
 		this.codigo_guia1=codigo_guia1;
 		this.codigo_guia2=codigo_guia2;
 		this.precio=precio;
 		this.valor_iva=valor_iva;
 		this.valor_total=valor_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ServicioTransporte serviciotransporteLocal=null;
		
		if(object!=null) {
			serviciotransporteLocal=(ServicioTransporte)object;
			
			if(serviciotransporteLocal!=null) {
				if(this.getId()!=null && serviciotransporteLocal.getId()!=null) {
					if(this.getId().equals(serviciotransporteLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ServicioTransporteConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ServicioTransporteConstantesFunciones.getServicioTransporteDescripcion(this);
		} else {
			sDetalle=ServicioTransporteConstantesFunciones.getServicioTransporteDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ServicioTransporte getServicioTransporteOriginal() {
		return this.serviciotransporteOriginal;
	}
	
	public void setServicioTransporteOriginal(ServicioTransporte serviciotransporte) {
		try {
			this.serviciotransporteOriginal=serviciotransporte;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ServicioTransporteAdditional serviciotransporteAdditional=null;
	
	public ServicioTransporteAdditional getServicioTransporteAdditional() {
		return this.serviciotransporteAdditional;
	}
	
	public void setServicioTransporteAdditional(ServicioTransporteAdditional serviciotransporteAdditional) {
		try {
			this.serviciotransporteAdditional=serviciotransporteAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_cliente_proveedor() {
		return this.id_cliente_proveedor;
	}
    
	
	public Long getid_transportista() {
		return this.id_transportista;
	}
    
	
	public Long getid_vehiculo() {
		return this.id_vehiculo;
	}
    
	
	public Long getid_ruta_transporte() {
		return this.id_ruta_transporte;
	}
    
	
	public Long getid_detalle_activo_fijo() {
		return this.id_detalle_activo_fijo;
	}
    
	
	public Date getfecha_ingreso() {
		return this.fecha_ingreso;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public String getcodigo_guia1() {
		return this.codigo_guia1;
	}
    
	
	public String getcodigo_guia2() {
		return this.codigo_guia2;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public Double getvalor_iva() {
		return this.valor_iva;
	}
    
	
	public Double getvalor_total() {
		return this.valor_total;
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cliente_proveedor(Long newid_cliente_proveedor)throws Exception
	{
		try {
			if(this.id_cliente_proveedor!=newid_cliente_proveedor) {
				if(newid_cliente_proveedor==null) {
					//newid_cliente_proveedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_cliente_proveedor");
					}
				}

				this.id_cliente_proveedor=newid_cliente_proveedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transportista(Long newid_transportista)throws Exception
	{
		try {
			if(this.id_transportista!=newid_transportista) {
				if(newid_transportista==null) {
					//newid_transportista=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_transportista");
					}
				}

				this.id_transportista=newid_transportista;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vehiculo(Long newid_vehiculo)throws Exception
	{
		try {
			if(this.id_vehiculo!=newid_vehiculo) {
				if(newid_vehiculo==null) {
					//newid_vehiculo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_vehiculo");
					}
				}

				this.id_vehiculo=newid_vehiculo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ruta_transporte(Long newid_ruta_transporte)throws Exception
	{
		try {
			if(this.id_ruta_transporte!=newid_ruta_transporte) {
				if(newid_ruta_transporte==null) {
					//newid_ruta_transporte=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_ruta_transporte");
					}
				}

				this.id_ruta_transporte=newid_ruta_transporte;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo(Long newid_detalle_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_activo_fijo!=newid_detalle_activo_fijo) {
				if(newid_detalle_activo_fijo==null) {
					//newid_detalle_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna id_detalle_activo_fijo");
					}
				}

				this.id_detalle_activo_fijo=newid_detalle_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ingreso(Date newfecha_ingreso)throws Exception
	{
		try {
			if(this.fecha_ingreso!=newfecha_ingreso) {
				if(newfecha_ingreso==null) {
					//newfecha_ingreso=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna fecha_ingreso");
					}
				}

				this.fecha_ingreso=newfecha_ingreso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(Date newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_guia1(String newcodigo_guia1)throws Exception
	{
		try {
			if(this.codigo_guia1!=newcodigo_guia1) {
				if(newcodigo_guia1==null) {
					//newcodigo_guia1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna codigo_guia1");
					}
				}

				if(newcodigo_guia1!=null&&newcodigo_guia1.length()>100) {
					newcodigo_guia1=newcodigo_guia1.substring(0,98);
					System.out.println("ServicioTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo_guia1");
				}

				this.codigo_guia1=newcodigo_guia1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_guia2(String newcodigo_guia2)throws Exception
	{
		try {
			if(this.codigo_guia2!=newcodigo_guia2) {
				if(newcodigo_guia2==null) {
					//newcodigo_guia2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna codigo_guia2");
					}
				}

				if(newcodigo_guia2!=null&&newcodigo_guia2.length()>100) {
					newcodigo_guia2=newcodigo_guia2.substring(0,98);
					System.out.println("ServicioTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo_guia2");
				}

				this.codigo_guia2=newcodigo_guia2;
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_iva(Double newvalor_iva)throws Exception
	{
		try {
			if(this.valor_iva!=newvalor_iva) {
				if(newvalor_iva==null) {
					//newvalor_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna valor_iva");
					}
				}

				this.valor_iva=newvalor_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_total(Double newvalor_total)throws Exception
	{
		try {
			if(this.valor_total!=newvalor_total) {
				if(newvalor_total==null) {
					//newvalor_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna valor_total");
					}
				}

				this.valor_total=newvalor_total;
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
						System.out.println("ServicioTransporte:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("ServicioTransporte:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
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

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public Cliente getClienteProveedor() {
		return this.clienteproveedor;
	}

	public Transportista getTransportista() {
		return this.transportista;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public RutaTransporte getRutaTransporte() {
		return this.rutatransporte;
	}

	public DetalleActivoFijo getDetalleActivoFijo() {
		return this.detalleactivofijo;
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

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getclienteproveedor_descripcion() {
		return this.clienteproveedor_descripcion;
	}

	public String gettransportista_descripcion() {
		return this.transportista_descripcion;
	}

	public String getvehiculo_descripcion() {
		return this.vehiculo_descripcion;
	}

	public String getrutatransporte_descripcion() {
		return this.rutatransporte_descripcion;
	}

	public String getdetalleactivofijo_descripcion() {
		return this.detalleactivofijo_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setClienteProveedor(Cliente clienteproveedor) {
		try {
			this.clienteproveedor=clienteproveedor;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransportista(Transportista transportista) {
		try {
			this.transportista=transportista;
		} catch(Exception e) {
			;
		}
	}


	public  void  setVehiculo(Vehiculo vehiculo) {
		try {
			this.vehiculo=vehiculo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setRutaTransporte(RutaTransporte rutatransporte) {
		try {
			this.rutatransporte=rutatransporte;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) {
		try {
			this.detalleactivofijo=detalleactivofijo;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setclienteproveedor_descripcion(String clienteproveedor_descripcion) {
		try {
			this.clienteproveedor_descripcion=clienteproveedor_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransportista_descripcion(String transportista_descripcion) {
		try {
			this.transportista_descripcion=transportista_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setvehiculo_descripcion(String vehiculo_descripcion) {
		try {
			this.vehiculo_descripcion=vehiculo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setrutatransporte_descripcion(String rutatransporte_descripcion) {
		try {
			this.rutatransporte_descripcion=rutatransporte_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdetalleactivofijo_descripcion(String detalleactivofijo_descripcion) {
		try {
			this.detalleactivofijo_descripcion=detalleactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleServicioTransporte> getDetalleServicioTransportes() {
		return this.detalleserviciotransportes;
	}

	
	
	public  void  setDetalleServicioTransportes(List<DetalleServicioTransporte> detalleserviciotransportes) {
		try {
			this.detalleserviciotransportes=detalleserviciotransportes;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_cliente_descripcion="";String id_cliente_proveedor_descripcion="";String id_transportista_descripcion="";String id_vehiculo_descripcion="";String id_ruta_transporte_descripcion="";String id_detalle_activo_fijo_descripcion="";
	
	
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
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_cliente_proveedor_descripcion() {
		return id_cliente_proveedor_descripcion;
	}
	public String getid_transportista_descripcion() {
		return id_transportista_descripcion;
	}
	public String getid_vehiculo_descripcion() {
		return id_vehiculo_descripcion;
	}
	public String getid_ruta_transporte_descripcion() {
		return id_ruta_transporte_descripcion;
	}
	public String getid_detalle_activo_fijo_descripcion() {
		return id_detalle_activo_fijo_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cliente_proveedor_descripcion(String newid_cliente_proveedor_descripcion)throws Exception {
		try {
			this.id_cliente_proveedor_descripcion=newid_cliente_proveedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transportista_descripcion(String newid_transportista_descripcion)throws Exception {
		try {
			this.id_transportista_descripcion=newid_transportista_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_vehiculo_descripcion(String newid_vehiculo_descripcion)throws Exception {
		try {
			this.id_vehiculo_descripcion=newid_vehiculo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ruta_transporte_descripcion(String newid_ruta_transporte_descripcion)throws Exception {
		try {
			this.id_ruta_transporte_descripcion=newid_ruta_transporte_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_detalle_activo_fijo_descripcion(String newid_detalle_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_activo_fijo_descripcion=newid_detalle_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_cliente_descripcion="";this.id_cliente_proveedor_descripcion="";this.id_transportista_descripcion="";this.id_vehiculo_descripcion="";this.id_ruta_transporte_descripcion="";this.id_detalle_activo_fijo_descripcion="";
	}
	
	
	Object detalleserviciotransportesDescripcionReporte;
	
	
	public Object getdetalleserviciotransportesDescripcionReporte() {
		return detalleserviciotransportesDescripcionReporte;
	}

	
	
	public  void  setdetalleserviciotransportesDescripcionReporte(Object detalleserviciotransportes) {
		try {
			this.detalleserviciotransportesDescripcionReporte=detalleserviciotransportes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

