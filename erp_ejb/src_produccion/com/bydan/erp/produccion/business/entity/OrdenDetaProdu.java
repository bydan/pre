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
//import com.bydan.erp.produccion.util.OrdenDetaProduConstantesFunciones;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class OrdenDetaProdu extends OrdenDetaProduAdditional implements Serializable ,Cloneable {//OrdenDetaProduAdditional,GeneralEntity
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
	
	private OrdenDetaProdu ordendetaproduOriginal;
	
	private Map<String, Object> mapOrdenDetaProdu;
			
	public Map<String, Object> getMapOrdenDetaProdu() {
		return mapOrdenDetaProdu;
	}

	public void setMapOrdenDetaProdu(Map<String, Object> mapOrdenDetaProdu) {
		this.mapOrdenDetaProdu = mapOrdenDetaProdu;
	}
	
	public void inicializarMapOrdenDetaProdu() {
		this.mapOrdenDetaProdu = new HashMap<String,Object>();
	}
	
	public void setMapOrdenDetaProduValue(String sKey,Object oValue) {
		this.mapOrdenDetaProdu.put(sKey, oValue);
	}
	
	public Object getMapOrdenDetaProduValue(String sKey) {
		return this.mapOrdenDetaProdu.get(sKey);
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
	private Long id_orden_produ;
	
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
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_destino;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_proceso_produ;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad_pendiente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OrdenDetaProduConstantesFunciones.SREGEXDESCRIPCION,message=OrdenDetaProduConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public OrdenProdu ordenprodu;
	public Bodega bodega;
	public Producto producto;
	public Unidad unidad;
	public Bodega bodegadestino;
	public TipoProcesoProdu tipoprocesoprodu;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String ordenprodu_descripcion;
	private String bodega_descripcion;
	private String producto_descripcion;
	private String unidad_descripcion;
	private String bodegadestino_descripcion;
	private String tipoprocesoprodu_descripcion;
	
	
	public List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos;
	public List<ProductoOrdenDetaProduMano> productoordendetaprodumanos;
	public List<ProductoOrdenDetaProdu> productoordendetaprodus;
	public List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas;
	public List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas;
		
	public OrdenDetaProdu () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ordendetaproduOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_orden_produ=-1L;
 		this.id_bodega=-1L;
 		this.id_producto=-1L;
 		this.id_unidad=-1L;
 		this.id_bodega_destino=-1L;
 		this.id_tipo_proceso_produ=-1L;
 		this.cantidad=0;
 		this.cantidad_pendiente=0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.ejercicio=null;
		this.periodo=null;
		this.ordenprodu=null;
		this.bodega=null;
		this.producto=null;
		this.unidad=null;
		this.bodegadestino=null;
		this.tipoprocesoprodu=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.ordenprodu_descripcion="";
		this.bodega_descripcion="";
		this.producto_descripcion="";
		this.unidad_descripcion="";
		this.bodegadestino_descripcion="";
		this.tipoprocesoprodu_descripcion="";
		
		
		this.productoordendetaprodugastos=null;
		this.productoordendetaprodumanos=null;
		this.productoordendetaprodus=null;
		this.productoordendetaprodumaquinas=null;
		this.productoordendetaprodumermas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public OrdenDetaProdu (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_orden_produ,Long id_bodega,Long id_producto,Long id_unidad,Long id_bodega_destino,Long id_tipo_proceso_produ,Integer cantidad,Integer cantidad_pendiente,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ordendetaproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_orden_produ=id_orden_produ;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_bodega_destino=id_bodega_destino;
 		this.id_tipo_proceso_produ=id_tipo_proceso_produ;
 		this.cantidad=cantidad;
 		this.cantidad_pendiente=cantidad_pendiente;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public OrdenDetaProdu (Long id_empresa,Long id_sucursal,Long id_ejercicio,Long id_periodo,Long id_orden_produ,Long id_bodega,Long id_producto,Long id_unidad,Long id_bodega_destino,Long id_tipo_proceso_produ,Integer cantidad,Integer cantidad_pendiente,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ordendetaproduOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_orden_produ=id_orden_produ;
 		this.id_bodega=id_bodega;
 		this.id_producto=id_producto;
 		this.id_unidad=id_unidad;
 		this.id_bodega_destino=id_bodega_destino;
 		this.id_tipo_proceso_produ=id_tipo_proceso_produ;
 		this.cantidad=cantidad;
 		this.cantidad_pendiente=cantidad_pendiente;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		OrdenDetaProdu ordendetaproduLocal=null;
		
		if(object!=null) {
			ordendetaproduLocal=(OrdenDetaProdu)object;
			
			if(ordendetaproduLocal!=null) {
				if(this.getId()!=null && ordendetaproduLocal.getId()!=null) {
					if(this.getId().equals(ordendetaproduLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!OrdenDetaProduConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcion(this);
		} else {
			sDetalle=OrdenDetaProduConstantesFunciones.getOrdenDetaProduDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public OrdenDetaProdu getOrdenDetaProduOriginal() {
		return this.ordendetaproduOriginal;
	}
	
	public void setOrdenDetaProduOriginal(OrdenDetaProdu ordendetaprodu) {
		try {
			this.ordendetaproduOriginal=ordendetaprodu;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected OrdenDetaProduAdditional ordendetaproduAdditional=null;
	
	public OrdenDetaProduAdditional getOrdenDetaProduAdditional() {
		return this.ordendetaproduAdditional;
	}
	
	public void setOrdenDetaProduAdditional(OrdenDetaProduAdditional ordendetaproduAdditional) {
		try {
			this.ordendetaproduAdditional=ordendetaproduAdditional;
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
    
	
	public Long getid_orden_produ() {
		return this.id_orden_produ;
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
    
	
	public Long getid_bodega_destino() {
		return this.id_bodega_destino;
	}
    
	
	public Long getid_tipo_proceso_produ() {
		return this.id_tipo_proceso_produ;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Integer getcantidad_pendiente() {
		return this.cantidad_pendiente;
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_ejercicio");
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_orden_produ(Long newid_orden_produ)throws Exception
	{
		try {
			if(this.id_orden_produ!=newid_orden_produ) {
				if(newid_orden_produ==null) {
					//newid_orden_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_orden_produ");
					}
				}

				this.id_orden_produ=newid_orden_produ;
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_bodega");
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_producto");
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_destino(Long newid_bodega_destino)throws Exception
	{
		try {
			if(this.id_bodega_destino!=newid_bodega_destino) {
				if(newid_bodega_destino==null) {
					//newid_bodega_destino=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_bodega_destino");
					}
				}

				this.id_bodega_destino=newid_bodega_destino;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_proceso_produ(Long newid_tipo_proceso_produ)throws Exception
	{
		try {
			if(this.id_tipo_proceso_produ!=newid_tipo_proceso_produ) {
				if(newid_tipo_proceso_produ==null) {
					//newid_tipo_proceso_produ=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna id_tipo_proceso_produ");
					}
				}

				this.id_tipo_proceso_produ=newid_tipo_proceso_produ;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad_pendiente(Integer newcantidad_pendiente)throws Exception
	{
		try {
			if(this.cantidad_pendiente!=newcantidad_pendiente) {
				if(newcantidad_pendiente==null) {
					//newcantidad_pendiente=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna cantidad_pendiente");
					}
				}

				this.cantidad_pendiente=newcantidad_pendiente;
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
						System.out.println("OrdenDetaProdu:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("OrdenDetaProdu:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public OrdenProdu getOrdenProdu() {
		return this.ordenprodu;
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

	public Bodega getBodegaDestino() {
		return this.bodegadestino;
	}

	public TipoProcesoProdu getTipoProcesoProdu() {
		return this.tipoprocesoprodu;
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

	public String getordenprodu_descripcion() {
		return this.ordenprodu_descripcion;
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

	public String getbodegadestino_descripcion() {
		return this.bodegadestino_descripcion;
	}

	public String gettipoprocesoprodu_descripcion() {
		return this.tipoprocesoprodu_descripcion;
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


	public  void  setOrdenProdu(OrdenProdu ordenprodu) {
		try {
			this.ordenprodu=ordenprodu;
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


	public  void  setBodegaDestino(Bodega bodegadestino) {
		try {
			this.bodegadestino=bodegadestino;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProcesoProdu(TipoProcesoProdu tipoprocesoprodu) {
		try {
			this.tipoprocesoprodu=tipoprocesoprodu;
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


	public  void  setordenprodu_descripcion(String ordenprodu_descripcion) {
		try {
			this.ordenprodu_descripcion=ordenprodu_descripcion;
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


	public  void  setbodegadestino_descripcion(String bodegadestino_descripcion) {
		try {
			this.bodegadestino_descripcion=bodegadestino_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoprocesoprodu_descripcion(String tipoprocesoprodu_descripcion) {
		try {
			this.tipoprocesoprodu_descripcion=tipoprocesoprodu_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ProductoOrdenDetaProduGasto> getProductoOrdenDetaProduGastos() {
		return this.productoordendetaprodugastos;
	}

	public List<ProductoOrdenDetaProduMano> getProductoOrdenDetaProduManos() {
		return this.productoordendetaprodumanos;
	}

	public List<ProductoOrdenDetaProdu> getProductoOrdenDetaProdus() {
		return this.productoordendetaprodus;
	}

	public List<ProductoOrdenDetaProduMaquina> getProductoOrdenDetaProduMaquinas() {
		return this.productoordendetaprodumaquinas;
	}

	public List<ProductoOrdenDetaProduMerma> getProductoOrdenDetaProduMermas() {
		return this.productoordendetaprodumermas;
	}

	
	
	public  void  setProductoOrdenDetaProduGastos(List<ProductoOrdenDetaProduGasto> productoordendetaprodugastos) {
		try {
			this.productoordendetaprodugastos=productoordendetaprodugastos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProduManos(List<ProductoOrdenDetaProduMano> productoordendetaprodumanos) {
		try {
			this.productoordendetaprodumanos=productoordendetaprodumanos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProdus(List<ProductoOrdenDetaProdu> productoordendetaprodus) {
		try {
			this.productoordendetaprodus=productoordendetaprodus;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProduMaquinas(List<ProductoOrdenDetaProduMaquina> productoordendetaprodumaquinas) {
		try {
			this.productoordendetaprodumaquinas=productoordendetaprodumaquinas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoOrdenDetaProduMermas(List<ProductoOrdenDetaProduMerma> productoordendetaprodumermas) {
		try {
			this.productoordendetaprodumermas=productoordendetaprodumermas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_orden_produ_descripcion="";String id_bodega_descripcion="";String id_producto_descripcion="";String id_unidad_descripcion="";String id_bodega_destino_descripcion="";String id_tipo_proceso_produ_descripcion="";
	
	
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
	public String getid_orden_produ_descripcion() {
		return id_orden_produ_descripcion;
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
	public String getid_bodega_destino_descripcion() {
		return id_bodega_destino_descripcion;
	}
	public String getid_tipo_proceso_produ_descripcion() {
		return id_tipo_proceso_produ_descripcion;
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
	public void setid_orden_produ_descripcion(String newid_orden_produ_descripcion)throws Exception {
		try {
			this.id_orden_produ_descripcion=newid_orden_produ_descripcion;
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
	public void setid_bodega_destino_descripcion(String newid_bodega_destino_descripcion)throws Exception {
		try {
			this.id_bodega_destino_descripcion=newid_bodega_destino_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_proceso_produ_descripcion(String newid_tipo_proceso_produ_descripcion)throws Exception {
		try {
			this.id_tipo_proceso_produ_descripcion=newid_tipo_proceso_produ_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_orden_produ_descripcion="";this.id_bodega_descripcion="";this.id_producto_descripcion="";this.id_unidad_descripcion="";this.id_bodega_destino_descripcion="";this.id_tipo_proceso_produ_descripcion="";
	}
	
	
	Object productoordendetaprodugastosDescripcionReporte;
	Object productoordendetaprodumanosDescripcionReporte;
	Object productoordendetaprodusDescripcionReporte;
	Object productoordendetaprodumaquinasDescripcionReporte;
	Object productoordendetaprodumermasDescripcionReporte;
	
	
	public Object getproductoordendetaprodugastosDescripcionReporte() {
		return productoordendetaprodugastosDescripcionReporte;
	}

	public Object getproductoordendetaprodumanosDescripcionReporte() {
		return productoordendetaprodumanosDescripcionReporte;
	}

	public Object getproductoordendetaprodusDescripcionReporte() {
		return productoordendetaprodusDescripcionReporte;
	}

	public Object getproductoordendetaprodumaquinasDescripcionReporte() {
		return productoordendetaprodumaquinasDescripcionReporte;
	}

	public Object getproductoordendetaprodumermasDescripcionReporte() {
		return productoordendetaprodumermasDescripcionReporte;
	}

	
	
	public  void  setproductoordendetaprodugastosDescripcionReporte(Object productoordendetaprodugastos) {
		try {
			this.productoordendetaprodugastosDescripcionReporte=productoordendetaprodugastos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodumanosDescripcionReporte(Object productoordendetaprodumanos) {
		try {
			this.productoordendetaprodumanosDescripcionReporte=productoordendetaprodumanos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodusDescripcionReporte(Object productoordendetaprodus) {
		try {
			this.productoordendetaprodusDescripcionReporte=productoordendetaprodus;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodumaquinasDescripcionReporte(Object productoordendetaprodumaquinas) {
		try {
			this.productoordendetaprodumaquinasDescripcionReporte=productoordendetaprodumaquinas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductoordendetaprodumermasDescripcionReporte(Object productoordendetaprodumermas) {
		try {
			this.productoordendetaprodumermasDescripcionReporte=productoordendetaprodumermas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

