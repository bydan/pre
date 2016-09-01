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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.PedidoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class PedidoPuntoVenta extends PedidoPuntoVentaAdditional implements Serializable ,Cloneable {//PedidoPuntoVentaAdditional,GeneralEntity
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
	
	private PedidoPuntoVenta pedidopuntoventaOriginal;
	
	private Map<String, Object> mapPedidoPuntoVenta;
			
	public Map<String, Object> getMapPedidoPuntoVenta() {
		return mapPedidoPuntoVenta;
	}

	public void setMapPedidoPuntoVenta(Map<String, Object> mapPedidoPuntoVenta) {
		this.mapPedidoPuntoVenta = mapPedidoPuntoVenta;
	}
	
	public void inicializarMapPedidoPuntoVenta() {
		this.mapPedidoPuntoVenta = new HashMap<String,Object>();
	}
	
	public void setMapPedidoPuntoVentaValue(String sKey,Object oValue) {
		this.mapPedidoPuntoVenta.put(sKey, oValue);
	}
	
	public Object getMapPedidoPuntoVentaValue(String sKey) {
		return this.mapPedidoPuntoVenta.get(sKey);
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
	private Long id_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_caja;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mesa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_pedido_punto_venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXCODIGO_CLIENTE,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXCODIGO_CLIENTE)
	private String codigo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXNOMBRE_CLIENTE,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXNOMBRE_CLIENTE)
	private String nombre_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXDIRECCION_CLIENTE,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXDIRECCION_CLIENTE)
	private String direccion_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXTELEFONO_CLIENTE,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXTELEFONO_CLIENTE)
	private String telefono_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=PedidoPuntoVentaConstantesFunciones.SREGEXTARJETA_CLIENTE,message=PedidoPuntoVentaConstantesFunciones.SMENSAJEREGEXTARJETA_CLIENTE)
	private String tarjeta_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double sub_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double descuento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Usuario usuario;
	public Vendedor vendedor;
	public Caja caja;
	public Cliente cliente;
	public TipoPrecio tipoprecio;
	public Mesa mesa;
	public EstadoPedidoPuntoVenta estadopedidopuntoventa;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String usuario_descripcion;
	private String vendedor_descripcion;
	private String caja_descripcion;
	private String cliente_descripcion;
	private String tipoprecio_descripcion;
	private String mesa_descripcion;
	private String estadopedidopuntoventa_descripcion;
	
	
	public List<DetallePedidoPuntoVenta> detallepedidopuntoventas;
		
	public PedidoPuntoVenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.pedidopuntoventaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_usuario=-1L;
 		this.id_vendedor=-1L;
 		this.id_caja=-1L;
 		this.id_cliente=-1L;
 		this.id_tipo_precio=-1L;
 		this.id_mesa=-1L;
 		this.id_estado_pedido_punto_venta=-1L;
 		this.numero_secuencial="";
 		this.codigo_cliente="";
 		this.nombre_cliente="";
 		this.direccion_cliente="";
 		this.telefono_cliente="";
 		this.tarjeta_cliente="";
 		this.fecha=new Date();
 		this.hora=new Time((new Date()).getTime());
 		this.sub_total=0.0;
 		this.iva=0.0;
 		this.ice=0.0;
 		this.descuento=0.0;
 		this.total=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.usuario=null;
		this.vendedor=null;
		this.caja=null;
		this.cliente=null;
		this.tipoprecio=null;
		this.mesa=null;
		this.estadopedidopuntoventa=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.usuario_descripcion="";
		this.vendedor_descripcion="";
		this.caja_descripcion="";
		this.cliente_descripcion="";
		this.tipoprecio_descripcion="";
		this.mesa_descripcion="";
		this.estadopedidopuntoventa_descripcion="";
		
		
		this.detallepedidopuntoventas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PedidoPuntoVenta (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_caja,Long id_cliente,Long id_tipo_precio,Long id_mesa,Long id_estado_pedido_punto_venta,String numero_secuencial,String codigo_cliente,String nombre_cliente,String direccion_cliente,String telefono_cliente,String tarjeta_cliente,Date fecha,Time hora,Double sub_total,Double iva,Double ice,Double descuento,Double total) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_caja=id_caja;
 		this.id_cliente=id_cliente;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_mesa=id_mesa;
 		this.id_estado_pedido_punto_venta=id_estado_pedido_punto_venta;
 		this.numero_secuencial=numero_secuencial;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.tarjeta_cliente=tarjeta_cliente;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.sub_total=sub_total;
 		this.iva=iva;
 		this.ice=ice;
 		this.descuento=descuento;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PedidoPuntoVenta (Long id_empresa,Long id_sucursal,Long id_usuario,Long id_vendedor,Long id_caja,Long id_cliente,Long id_tipo_precio,Long id_mesa,Long id_estado_pedido_punto_venta,String numero_secuencial,String codigo_cliente,String nombre_cliente,String direccion_cliente,String telefono_cliente,String tarjeta_cliente,Date fecha,Time hora,Double sub_total,Double iva,Double ice,Double descuento,Double total) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.pedidopuntoventaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_usuario=id_usuario;
 		this.id_vendedor=id_vendedor;
 		this.id_caja=id_caja;
 		this.id_cliente=id_cliente;
 		this.id_tipo_precio=id_tipo_precio;
 		this.id_mesa=id_mesa;
 		this.id_estado_pedido_punto_venta=id_estado_pedido_punto_venta;
 		this.numero_secuencial=numero_secuencial;
 		this.codigo_cliente=codigo_cliente;
 		this.nombre_cliente=nombre_cliente;
 		this.direccion_cliente=direccion_cliente;
 		this.telefono_cliente=telefono_cliente;
 		this.tarjeta_cliente=tarjeta_cliente;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.sub_total=sub_total;
 		this.iva=iva;
 		this.ice=ice;
 		this.descuento=descuento;
 		this.total=total;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PedidoPuntoVenta pedidopuntoventaLocal=null;
		
		if(object!=null) {
			pedidopuntoventaLocal=(PedidoPuntoVenta)object;
			
			if(pedidopuntoventaLocal!=null) {
				if(this.getId()!=null && pedidopuntoventaLocal.getId()!=null) {
					if(this.getId().equals(pedidopuntoventaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PedidoPuntoVentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaDescripcion(this);
		} else {
			sDetalle=PedidoPuntoVentaConstantesFunciones.getPedidoPuntoVentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PedidoPuntoVenta getPedidoPuntoVentaOriginal() {
		return this.pedidopuntoventaOriginal;
	}
	
	public void setPedidoPuntoVentaOriginal(PedidoPuntoVenta pedidopuntoventa) {
		try {
			this.pedidopuntoventaOriginal=pedidopuntoventa;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PedidoPuntoVentaAdditional pedidopuntoventaAdditional=null;
	
	public PedidoPuntoVentaAdditional getPedidoPuntoVentaAdditional() {
		return this.pedidopuntoventaAdditional;
	}
	
	public void setPedidoPuntoVentaAdditional(PedidoPuntoVentaAdditional pedidopuntoventaAdditional) {
		try {
			this.pedidopuntoventaAdditional=pedidopuntoventaAdditional;
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
    
	
	public Long getid_usuario() {
		return this.id_usuario;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public Long getid_caja() {
		return this.id_caja;
	}
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_tipo_precio() {
		return this.id_tipo_precio;
	}
    
	
	public Long getid_mesa() {
		return this.id_mesa;
	}
    
	
	public Long getid_estado_pedido_punto_venta() {
		return this.id_estado_pedido_punto_venta;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public String getcodigo_cliente() {
		return this.codigo_cliente;
	}
    
	
	public String getnombre_cliente() {
		return this.nombre_cliente;
	}
    
	
	public String getdireccion_cliente() {
		return this.direccion_cliente;
	}
    
	
	public String gettelefono_cliente() {
		return this.telefono_cliente;
	}
    
	
	public String gettarjeta_cliente() {
		return this.tarjeta_cliente;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
    
	
	public Double getsub_total() {
		return this.sub_total;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public Double getdescuento() {
		return this.descuento;
	}
    
	
	public Double gettotal() {
		return this.total;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_usuario");
					}
				}

				this.id_usuario=newid_usuario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_vendedor(Long newid_vendedor)throws Exception
	{
		try {
			if(this.id_vendedor!=newid_vendedor) {
				if(newid_vendedor==null) {
					//newid_vendedor=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_caja(Long newid_caja)throws Exception
	{
		try {
			if(this.id_caja!=newid_caja) {
				if(newid_caja==null) {
					//newid_caja=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_caja");
					}
				}

				this.id_caja=newid_caja;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_tipo_precio");
					}
				}

				this.id_tipo_precio=newid_tipo_precio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mesa(Long newid_mesa)throws Exception
	{
		try {
			if(this.id_mesa!=newid_mesa) {
				if(newid_mesa==null) {
					//newid_mesa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_mesa");
					}
				}

				this.id_mesa=newid_mesa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_pedido_punto_venta(Long newid_estado_pedido_punto_venta)throws Exception
	{
		try {
			if(this.id_estado_pedido_punto_venta!=newid_estado_pedido_punto_venta) {
				if(newid_estado_pedido_punto_venta==null) {
					//newid_estado_pedido_punto_venta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna id_estado_pedido_punto_venta");
					}
				}

				this.id_estado_pedido_punto_venta=newid_estado_pedido_punto_venta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_secuencial(String newnumero_secuencial)throws Exception
	{
		try {
			if(this.numero_secuencial!=newnumero_secuencial) {
				if(newnumero_secuencial==null) {
					//newnumero_secuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_cliente(String newcodigo_cliente)throws Exception
	{
		try {
			if(this.codigo_cliente!=newcodigo_cliente) {
				if(newcodigo_cliente==null) {
					//newcodigo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna codigo_cliente");
					}
				}

				if(newcodigo_cliente!=null&&newcodigo_cliente.length()>20) {
					newcodigo_cliente=newcodigo_cliente.substring(0,18);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna codigo_cliente");
				}

				this.codigo_cliente=newcodigo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_cliente(String newnombre_cliente)throws Exception
	{
		try {
			if(this.nombre_cliente!=newnombre_cliente) {
				if(newnombre_cliente==null) {
					//newnombre_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna nombre_cliente");
					}
				}

				if(newnombre_cliente!=null&&newnombre_cliente.length()>150) {
					newnombre_cliente=newnombre_cliente.substring(0,148);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_cliente");
				}

				this.nombre_cliente=newnombre_cliente;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna direccion_cliente");
					}
				}

				if(newdireccion_cliente!=null&&newdireccion_cliente.length()>150) {
					newdireccion_cliente=newdireccion_cliente.substring(0,148);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna direccion_cliente");
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna telefono_cliente");
					}
				}

				if(newtelefono_cliente!=null&&newtelefono_cliente.length()>100) {
					newtelefono_cliente=newtelefono_cliente.substring(0,98);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono_cliente");
				}

				this.telefono_cliente=newtelefono_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settarjeta_cliente(String newtarjeta_cliente)throws Exception
	{
		try {
			if(this.tarjeta_cliente!=newtarjeta_cliente) {
				if(newtarjeta_cliente==null) {
					//newtarjeta_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna tarjeta_cliente");
					}
				}

				if(newtarjeta_cliente!=null&&newtarjeta_cliente.length()>50) {
					newtarjeta_cliente=newtarjeta_cliente.substring(0,48);
					System.out.println("PedidoPuntoVenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tarjeta_cliente");
				}

				this.tarjeta_cliente=newtarjeta_cliente;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_total(Double newsub_total)throws Exception
	{
		try {
			if(this.sub_total!=newsub_total) {
				if(newsub_total==null) {
					//newsub_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna sub_total");
					}
				}

				this.sub_total=newsub_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setice(Double newice)throws Exception
	{
		try {
			if(this.ice!=newice) {
				if(newice==null) {
					//newice=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna descuento");
					}
				}

				this.descuento=newdescuento;
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
						System.out.println("PedidoPuntoVenta:Valor nulo no permitido en columna total");
					}
				}

				this.total=newtotal;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public TipoPrecio getTipoPrecio() {
		return this.tipoprecio;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public EstadoPedidoPuntoVenta getEstadoPedidoPuntoVenta() {
		return this.estadopedidopuntoventa;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getusuario_descripcion() {
		return this.usuario_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
	}

	public String getcaja_descripcion() {
		return this.caja_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettipoprecio_descripcion() {
		return this.tipoprecio_descripcion;
	}

	public String getmesa_descripcion() {
		return this.mesa_descripcion;
	}

	public String getestadopedidopuntoventa_descripcion() {
		return this.estadopedidopuntoventa_descripcion;
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


	public  void  setUsuario(Usuario usuario) {
		try {
			this.usuario=usuario;
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


	public  void  setCaja(Caja caja) {
		try {
			this.caja=caja;
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


	public  void  setTipoPrecio(TipoPrecio tipoprecio) {
		try {
			this.tipoprecio=tipoprecio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesa(Mesa mesa) {
		try {
			this.mesa=mesa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoPedidoPuntoVenta(EstadoPedidoPuntoVenta estadopedidopuntoventa) {
		try {
			this.estadopedidopuntoventa=estadopedidopuntoventa;
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


	public  void  setusuario_descripcion(String usuario_descripcion) {
		try {
			this.usuario_descripcion=usuario_descripcion;
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


	public  void  setcaja_descripcion(String caja_descripcion) {
		try {
			this.caja_descripcion=caja_descripcion;
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


	public  void  settipoprecio_descripcion(String tipoprecio_descripcion) {
		try {
			this.tipoprecio_descripcion=tipoprecio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesa_descripcion(String mesa_descripcion) {
		try {
			this.mesa_descripcion=mesa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadopedidopuntoventa_descripcion(String estadopedidopuntoventa_descripcion) {
		try {
			this.estadopedidopuntoventa_descripcion=estadopedidopuntoventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetallePedidoPuntoVenta> getDetallePedidoPuntoVentas() {
		return this.detallepedidopuntoventas;
	}

	
	
	public  void  setDetallePedidoPuntoVentas(List<DetallePedidoPuntoVenta> detallepedidopuntoventas) {
		try {
			this.detallepedidopuntoventas=detallepedidopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_usuario_descripcion="";String id_vendedor_descripcion="";String id_caja_descripcion="";String id_cliente_descripcion="";String id_tipo_precio_descripcion="";String id_mesa_descripcion="";String id_estado_pedido_punto_venta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_usuario_descripcion() {
		return id_usuario_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
	}
	public String getid_caja_descripcion() {
		return id_caja_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_tipo_precio_descripcion() {
		return id_tipo_precio_descripcion;
	}
	public String getid_mesa_descripcion() {
		return id_mesa_descripcion;
	}
	public String getid_estado_pedido_punto_venta_descripcion() {
		return id_estado_pedido_punto_venta_descripcion;
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
	public void setid_usuario_descripcion(String newid_usuario_descripcion)throws Exception {
		try {
			this.id_usuario_descripcion=newid_usuario_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_vendedor_descripcion(String newid_vendedor_descripcion)throws Exception {
		try {
			this.id_vendedor_descripcion=newid_vendedor_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_caja_descripcion(String newid_caja_descripcion)throws Exception {
		try {
			this.id_caja_descripcion=newid_caja_descripcion;
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
	public void setid_tipo_precio_descripcion(String newid_tipo_precio_descripcion)throws Exception {
		try {
			this.id_tipo_precio_descripcion=newid_tipo_precio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mesa_descripcion(String newid_mesa_descripcion)throws Exception {
		try {
			this.id_mesa_descripcion=newid_mesa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_pedido_punto_venta_descripcion(String newid_estado_pedido_punto_venta_descripcion)throws Exception {
		try {
			this.id_estado_pedido_punto_venta_descripcion=newid_estado_pedido_punto_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_usuario_descripcion="";this.id_vendedor_descripcion="";this.id_caja_descripcion="";this.id_cliente_descripcion="";this.id_tipo_precio_descripcion="";this.id_mesa_descripcion="";this.id_estado_pedido_punto_venta_descripcion="";
	}
	
	
	Object detallepedidopuntoventasDescripcionReporte;
	
	
	public Object getdetallepedidopuntoventasDescripcionReporte() {
		return detallepedidopuntoventasDescripcionReporte;
	}

	
	
	public  void  setdetallepedidopuntoventasDescripcionReporte(Object detallepedidopuntoventas) {
		try {
			this.detallepedidopuntoventasDescripcionReporte=detallepedidopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

