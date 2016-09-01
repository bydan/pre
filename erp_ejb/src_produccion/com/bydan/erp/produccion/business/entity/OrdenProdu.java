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
package com.bydan.erp.produccion.business.entity;

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
//import com.bydan.erp.produccion.util.OrdenProduConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class OrdenProdu extends OrdenProduAdditional implements Serializable ,Cloneable {//OrdenProduAdditional,GeneralEntity
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
	
	private OrdenProdu ordenproduOriginal;
	
	private Map<String, Object> mapOrdenProdu;
			
	public Map<String, Object> getMapOrdenProdu() {
		return mapOrdenProdu;
	}

	public void setMapOrdenProdu(Map<String, Object> mapOrdenProdu) {
		this.mapOrdenProdu = mapOrdenProdu;
	}
	
	public void inicializarMapOrdenProdu() {
		this.mapOrdenProdu = new HashMap<String,Object>();
	}
	
	public void setMapOrdenProduValue(String sKey,Object oValue) {
		this.mapOrdenProdu.put(sKey, oValue);
	}
	
	public Object getMapOrdenProduValue(String sKey) {
		return this.mapOrdenProdu.get(sKey);
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
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_prioridad_empresa_produ;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado_responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXSECUENCIAL,message=OrdenProduConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXDIRECCION_CLIENTE,message=OrdenProduConstantesFunciones.SMENSAJEREGEXDIRECCION_CLIENTE)
	private String direccion_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXTELEFONO_CLIENTE,message=OrdenProduConstantesFunciones.SMENSAJEREGEXTELEFONO_CLIENTE)
	private String telefono_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXRUC_CLIENTE,message=OrdenProduConstantesFunciones.SMENSAJEREGEXRUC_CLIENTE)
	private String ruc_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXLOTE,message=OrdenProduConstantesFunciones.SMENSAJEREGEXLOTE)
	private String lote;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_uso_interno;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenProduConstantesFunciones.SREGEXDESCRIPCION,message=OrdenProduConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_orden_produ;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public Formato formato;
	public TipoPrioridadEmpresaProdu tipoprioridadempresaprodu;
	public Empleado empleadoresponsable;
	public Cliente cliente;
	public EstadoOrdenProdu estadoordenprodu;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String formato_descripcion;
	private String tipoprioridadempresaprodu_descripcion;
	private String empleadoresponsable_descripcion;
	private String cliente_descripcion;
	private String estadoordenprodu_descripcion;
	
	
	public List<OrdenDetaProdu> ordendetaprodus;
		
	public OrdenProdu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ordenproduOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_formato=null;
 		this.id_tipo_prioridad_empresa_produ=-1L;
 		this.id_empleado_responsable=-1L;
 		this.secuencial="";
 		this.id_cliente=-1L;
 		this.direccion_cliente="";
 		this.telefono_cliente="";
 		this.ruc_cliente="";
 		this.lote="";
 		this.fecha_pedido=new Date();
 		this.fecha_entrega=new Date();
 		this.es_uso_interno=false;
 		this.fecha=new Date();
 		this.descripcion="";
 		this.id_estado_orden_produ=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.formato=null;
		this.tipoprioridadempresaprodu=null;
		this.empleadoresponsable=null;
		this.cliente=null;
		this.estadoordenprodu=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.formato_descripcion="";
		this.tipoprioridadempresaprodu_descripcion="";
		this.empleadoresponsable_descripcion="";
		this.cliente_descripcion="";
		this.estadoordenprodu_descripcion="";
		
		
		this.ordendetaprodus=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public OrdenProdu (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_formato,Long id_tipo_prioridad_empresa_produ,Long id_empleado_responsable,String secuencial,Long id_cliente,String direccion_cliente,String telefono_cliente,String ruc_cliente,String lote,Date fecha_pedido,Date fecha_entrega,Boolean es_uso_interno,Date fecha,String descripcion,Long id_estado_orden_produ) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ordenproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_formato=id_formato;
 		this.id_tipo_prioridad_empresa_produ=id_tipo_prioridad_empresa_produ;
 		this.id_empleado_responsable=id_empleado_responsable;
 		this.secuencial=secuencial;
 		this.id_cliente=id_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.ruc_cliente=ruc_cliente;
 		this.lote=lote;
 		this.fecha_pedido=fecha_pedido;
 		this.fecha_entrega=fecha_entrega;
 		this.es_uso_interno=es_uso_interno;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.id_estado_orden_produ=id_estado_orden_produ;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public OrdenProdu (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_formato,Long id_tipo_prioridad_empresa_produ,Long id_empleado_responsable,String secuencial,Long id_cliente,String direccion_cliente,String telefono_cliente,String ruc_cliente,String lote,Date fecha_pedido,Date fecha_entrega,Boolean es_uso_interno,Date fecha,String descripcion,Long id_estado_orden_produ) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ordenproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_formato=id_formato;
 		this.id_tipo_prioridad_empresa_produ=id_tipo_prioridad_empresa_produ;
 		this.id_empleado_responsable=id_empleado_responsable;
 		this.secuencial=secuencial;
 		this.id_cliente=id_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.ruc_cliente=ruc_cliente;
 		this.lote=lote;
 		this.fecha_pedido=fecha_pedido;
 		this.fecha_entrega=fecha_entrega;
 		this.es_uso_interno=es_uso_interno;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.id_estado_orden_produ=id_estado_orden_produ;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		OrdenProdu ordenproduLocal=null;
		
		if(object!=null) {
			ordenproduLocal=(OrdenProdu)object;
			
			if(ordenproduLocal!=null) {
				if(this.getId()!=null && ordenproduLocal.getId()!=null) {
					if(this.getId().equals(ordenproduLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!OrdenProduConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=OrdenProduConstantesFunciones.getOrdenProduDescripcion(this);
		} else {
			sDetalle=OrdenProduConstantesFunciones.getOrdenProduDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public OrdenProdu getOrdenProduOriginal() {
		return this.ordenproduOriginal;
	}
	
	public void setOrdenProduOriginal(OrdenProdu ordenprodu) {
		try {
			this.ordenproduOriginal=ordenprodu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected OrdenProduAdditional ordenproduAdditional=null;
	
	public OrdenProduAdditional getOrdenProduAdditional() {
		return this.ordenproduAdditional;
	}
	
	public void setOrdenProduAdditional(OrdenProduAdditional ordenproduAdditional) {
		try {
			this.ordenproduAdditional=ordenproduAdditional;
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
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_tipo_prioridad_empresa_produ() {
		return this.id_tipo_prioridad_empresa_produ;
	}
    
	
	public Long getid_empleado_responsable() {
		return this.id_empleado_responsable;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public String getdireccion_cliente() {
		return this.direccion_cliente;
	}
    
	
	public String gettelefono_cliente() {
		return this.telefono_cliente;
	}
    
	
	public String getruc_cliente() {
		return this.ruc_cliente;
	}
    
	
	public String getlote() {
		return this.lote;
	}
    
	
	public Date getfecha_pedido() {
		return this.fecha_pedido;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public Boolean getes_uso_interno() {
		return this.es_uso_interno;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_estado_orden_produ() {
		return this.id_estado_orden_produ;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato) {
		if(this.id_formato==null&&newid_formato!=null) {
			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}

		if(this.id_formato!=null&&!this.id_formato.equals(newid_formato)) {

			this.id_formato=newid_formato;
				this.setIsChanged(true);
		}
	}
    
	public void setid_tipo_prioridad_empresa_produ(Long newid_tipo_prioridad_empresa_produ)throws Exception
	{
		try {
			if(this.id_tipo_prioridad_empresa_produ!=newid_tipo_prioridad_empresa_produ) {
				if(newid_tipo_prioridad_empresa_produ==null) {
					//newid_tipo_prioridad_empresa_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_tipo_prioridad_empresa_produ");
					}
				}

				this.id_tipo_prioridad_empresa_produ=newid_tipo_prioridad_empresa_produ;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_responsable(Long newid_empleado_responsable)throws Exception
	{
		try {
			if(this.id_empleado_responsable!=newid_empleado_responsable) {
				if(newid_empleado_responsable==null) {
					//newid_empleado_responsable=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_empleado_responsable");
					}
				}

				this.id_empleado_responsable=newid_empleado_responsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdireccion_cliente(String newdireccion_cliente)throws Exception
	{
		try {
			if(this.direccion_cliente!=newdireccion_cliente) {
				if(newdireccion_cliente==null) {
					//newdireccion_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna direccion_cliente");
					}
				}

				if(newdireccion_cliente!=null&&newdireccion_cliente.length()>150) {
					newdireccion_cliente=newdireccion_cliente.substring(0,148);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_cliente");
				}

				this.direccion_cliente=newdireccion_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono_cliente(String newtelefono_cliente)throws Exception
	{
		try {
			if(this.telefono_cliente!=newtelefono_cliente) {
				if(newtelefono_cliente==null) {
					//newtelefono_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna telefono_cliente");
					}
				}

				if(newtelefono_cliente!=null&&newtelefono_cliente.length()>50) {
					newtelefono_cliente=newtelefono_cliente.substring(0,48);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna telefono_cliente");
				}

				this.telefono_cliente=newtelefono_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setruc_cliente(String newruc_cliente)throws Exception
	{
		try {
			if(this.ruc_cliente!=newruc_cliente) {
				if(newruc_cliente==null) {
					//newruc_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna ruc_cliente");
					}
				}

				if(newruc_cliente!=null&&newruc_cliente.length()>20) {
					newruc_cliente=newruc_cliente.substring(0,18);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna ruc_cliente");
				}

				this.ruc_cliente=newruc_cliente;
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna lote");
					}
				}

				if(newlote!=null&&newlote.length()>50) {
					newlote=newlote.substring(0,48);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna lote");
				}

				this.lote=newlote;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_pedido(Date newfecha_pedido)throws Exception
	{
		try {
			if(this.fecha_pedido!=newfecha_pedido) {
				if(newfecha_pedido==null) {
					//newfecha_pedido=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna fecha_pedido");
					}
				}

				this.fecha_pedido=newfecha_pedido;
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_uso_interno(Boolean newes_uso_interno)throws Exception
	{
		try {
			if(this.es_uso_interno!=newes_uso_interno) {
				if(newes_uso_interno==null) {
					//newes_uso_interno=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna es_uso_interno");
					}
				}

				this.es_uso_interno=newes_uso_interno;
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("OrdenProdu:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("OrdenProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_orden_produ(Long newid_estado_orden_produ)throws Exception
	{
		try {
			if(this.id_estado_orden_produ!=newid_estado_orden_produ) {
				if(newid_estado_orden_produ==null) {
					//newid_estado_orden_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenProdu:Valor nulo no permitido en columna id_estado_orden_produ");
					}
				}

				this.id_estado_orden_produ=newid_estado_orden_produ;
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

	public Formato getFormato() {
		return this.formato;
	}

	public TipoPrioridadEmpresaProdu getTipoPrioridadEmpresaProdu() {
		return this.tipoprioridadempresaprodu;
	}

	public Empleado getEmpleadoResponsable() {
		return this.empleadoresponsable;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public EstadoOrdenProdu getEstadoOrdenProdu() {
		return this.estadoordenprodu;
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

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String gettipoprioridadempresaprodu_descripcion() {
		return this.tipoprioridadempresaprodu_descripcion;
	}

	public String getempleadoresponsable_descripcion() {
		return this.empleadoresponsable_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String getestadoordenprodu_descripcion() {
		return this.estadoordenprodu_descripcion;
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


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPrioridadEmpresaProdu(TipoPrioridadEmpresaProdu tipoprioridadempresaprodu) {
		try {
			this.tipoprioridadempresaprodu=tipoprioridadempresaprodu;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleadoResponsable(Empleado empleadoresponsable) {
		try {
			this.empleadoresponsable=empleadoresponsable;
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


	public  void  setEstadoOrdenProdu(EstadoOrdenProdu estadoordenprodu) {
		try {
			this.estadoordenprodu=estadoordenprodu;
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


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprioridadempresaprodu_descripcion(String tipoprioridadempresaprodu_descripcion) {
		try {
			this.tipoprioridadempresaprodu_descripcion=tipoprioridadempresaprodu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleadoresponsable_descripcion(String empleadoresponsable_descripcion) {
		try {
			this.empleadoresponsable_descripcion=empleadoresponsable_descripcion;
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


	public  void  setestadoordenprodu_descripcion(String estadoordenprodu_descripcion) {
		try {
			this.estadoordenprodu_descripcion=estadoordenprodu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<OrdenDetaProdu> getOrdenDetaProdus() {
		return this.ordendetaprodus;
	}

	
	
	public  void  setOrdenDetaProdus(List<OrdenDetaProdu> ordendetaprodus) {
		try {
			this.ordendetaprodus=ordendetaprodus;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_formato_descripcion="";String id_tipo_prioridad_empresa_produ_descripcion="";String id_empleado_responsable_descripcion="";String id_cliente_descripcion="";String es_uso_interno_descripcion="";String id_estado_orden_produ_descripcion="";
	
	
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
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_tipo_prioridad_empresa_produ_descripcion() {
		return id_tipo_prioridad_empresa_produ_descripcion;
	}
	public String getid_empleado_responsable_descripcion() {
		return id_empleado_responsable_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getes_uso_interno_descripcion() {
		return es_uso_interno_descripcion;
	}
	public String getid_estado_orden_produ_descripcion() {
		return id_estado_orden_produ_descripcion;
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
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_prioridad_empresa_produ_descripcion(String newid_tipo_prioridad_empresa_produ_descripcion)throws Exception {
		try {
			this.id_tipo_prioridad_empresa_produ_descripcion=newid_tipo_prioridad_empresa_produ_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_responsable_descripcion(String newid_empleado_responsable_descripcion)throws Exception {
		try {
			this.id_empleado_responsable_descripcion=newid_empleado_responsable_descripcion;
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
	public void setes_uso_interno_descripcion(String newes_uso_interno_descripcion)throws Exception {
		try {
			this.es_uso_interno_descripcion=newes_uso_interno_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_orden_produ_descripcion(String newid_estado_orden_produ_descripcion)throws Exception {
		try {
			this.id_estado_orden_produ_descripcion=newid_estado_orden_produ_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_formato_descripcion="";this.id_tipo_prioridad_empresa_produ_descripcion="";this.id_empleado_responsable_descripcion="";this.id_cliente_descripcion="";this.es_uso_interno_descripcion="";this.id_estado_orden_produ_descripcion="";
	}
	
	
	Object ordendetaprodusDescripcionReporte;
	
	
	public Object getordendetaprodusDescripcionReporte() {
		return ordendetaprodusDescripcionReporte;
	}

	
	
	public  void  setordendetaprodusDescripcionReporte(Object ordendetaprodus) {
		try {
			this.ordendetaprodusDescripcionReporte=ordendetaprodus;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

