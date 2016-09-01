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
package com.bydan.erp.inventario.business.entity;

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
//import com.bydan.erp.inventario.util.TipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TipoPrecio extends TipoPrecioAdditional implements Serializable ,Cloneable {//TipoPrecioAdditional,GeneralEntity
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
	
	private TipoPrecio tipoprecioOriginal;
	
	private Map<String, Object> mapTipoPrecio;
			
	public Map<String, Object> getMapTipoPrecio() {
		return mapTipoPrecio;
	}

	public void setMapTipoPrecio(Map<String, Object> mapTipoPrecio) {
		this.mapTipoPrecio = mapTipoPrecio;
	}
	
	public void inicializarMapTipoPrecio() {
		this.mapTipoPrecio = new HashMap<String,Object>();
	}
	
	public void setMapTipoPrecioValue(String sKey,Object oValue) {
		this.mapTipoPrecio.put(sKey, oValue);
	}
	
	public Object getMapTipoPrecioValue(String sKey) {
		return this.mapTipoPrecio.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoPrecioConstantesFunciones.SREGEXCODIGO,message=TipoPrecioConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoPrecioConstantesFunciones.SREGEXNOMBRE,message=TipoPrecioConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double monto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean esta_activo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=TipoPrecioConstantesFunciones.SREGEXDESCRIPCION,message=TipoPrecioConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<Precio> precios;
	public List<PoliticasCliente> politicasclientes;
	public List<NotaCreditoSoli> notacreditosolis;
	public List<GuiaRemision> guiaremisions;
	public List<PedidoExpor> pedidoexpors;
	public List<FacturaPuntoVenta> facturapuntoventas;
	public List<PedidoPuntoVenta> pedidopuntoventas;
	public List<UtilidadTipoPrecio> utilidadtipoprecios;
	public List<Cliente> clientes;
	public List<ServicioCliente> servicioclientes;
	public List<Proforma> proformas;
	public List<DescuentoTipoPrecio> descuentotipoprecios;
	public List<NotaCreditoPuntoVenta> notacreditopuntoventas;
	public List<ParametroCarteraDefecto> parametrocarteradefectos;
	public List<Consignacion> consignacions;
		
	public TipoPrecio () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipoprecioOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.fecha_desde=new Date();
 		this.fecha_hasta=new Date();
 		this.monto=0.0;
 		this.esta_activo=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.precios=null;
		this.politicasclientes=null;
		this.notacreditosolis=null;
		this.guiaremisions=null;
		this.pedidoexpors=null;
		this.facturapuntoventas=null;
		this.pedidopuntoventas=null;
		this.utilidadtipoprecios=null;
		this.clientes=null;
		this.servicioclientes=null;
		this.proformas=null;
		this.descuentotipoprecios=null;
		this.notacreditopuntoventas=null;
		this.parametrocarteradefectos=null;
		this.consignacions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoPrecio (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Date fecha_desde,Date fecha_hasta,Double monto,Boolean esta_activo,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoprecioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.fecha_desde=fecha_desde;
 		this.fecha_hasta=fecha_hasta;
 		this.monto=monto;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoPrecio (Long id_empresa,String codigo,String nombre,Date fecha_desde,Date fecha_hasta,Double monto,Boolean esta_activo,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipoprecioOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.fecha_desde=fecha_desde;
 		this.fecha_hasta=fecha_hasta;
 		this.monto=monto;
 		this.esta_activo=esta_activo;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoPrecio tipoprecioLocal=null;
		
		if(object!=null) {
			tipoprecioLocal=(TipoPrecio)object;
			
			if(tipoprecioLocal!=null) {
				if(this.getId()!=null && tipoprecioLocal.getId()!=null) {
					if(this.getId().equals(tipoprecioLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoPrecioConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoPrecioConstantesFunciones.getTipoPrecioDescripcion(this);
		} else {
			sDetalle=TipoPrecioConstantesFunciones.getTipoPrecioDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoPrecio getTipoPrecioOriginal() {
		return this.tipoprecioOriginal;
	}
	
	public void setTipoPrecioOriginal(TipoPrecio tipoprecio) {
		try {
			this.tipoprecioOriginal=tipoprecio;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoPrecioAdditional tipoprecioAdditional=null;
	
	public TipoPrecioAdditional getTipoPrecioAdditional() {
		return this.tipoprecioAdditional;
	}
	
	public void setTipoPrecioAdditional(TipoPrecioAdditional tipoprecioAdditional) {
		try {
			this.tipoprecioAdditional=tipoprecioAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Date getfecha_desde() {
		return this.fecha_desde;
	}
    
	
	public Date getfecha_hasta() {
		return this.fecha_hasta;
	}
    
	
	public Double getmonto() {
		return this.monto;
	}
    
	
	public Boolean getesta_activo() {
		return this.esta_activo;
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
						System.out.println("TipoPrecio:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("TipoPrecio:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>100) {
					newcodigo=newcodigo.substring(0,98);
					System.out.println("TipoPrecio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna codigo");
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
						System.out.println("TipoPrecio:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoPrecio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_desde(Date newfecha_desde)throws Exception
	{
		try {
			if(this.fecha_desde!=newfecha_desde) {
				if(newfecha_desde==null) {
					//newfecha_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoPrecio:Valor nulo no permitido en columna fecha_desde");
					}
				}

				this.fecha_desde=newfecha_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_hasta(Date newfecha_hasta)throws Exception
	{
		try {
			if(this.fecha_hasta!=newfecha_hasta) {
				if(newfecha_hasta==null) {
					//newfecha_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoPrecio:Valor nulo no permitido en columna fecha_hasta");
					}
				}

				this.fecha_hasta=newfecha_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setmonto(Double newmonto)throws Exception
	{
		try {
			if(this.monto!=newmonto) {
				if(newmonto==null) {
					//newmonto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoPrecio:Valor nulo no permitido en columna monto");
					}
				}

				this.monto=newmonto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setesta_activo(Boolean newesta_activo)throws Exception
	{
		try {
			if(this.esta_activo!=newesta_activo) {
				if(newesta_activo==null) {
					//newesta_activo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoPrecio:Valor nulo no permitido en columna esta_activo");
					}
				}

				this.esta_activo=newesta_activo;
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
						System.out.println("TipoPrecio:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("TipoPrecio:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
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


	
	
	public List<Precio> getPrecios() {
		return this.precios;
	}

	public List<PoliticasCliente> getPoliticasClientes() {
		return this.politicasclientes;
	}

	public List<NotaCreditoSoli> getNotaCreditoSolis() {
		return this.notacreditosolis;
	}

	public List<GuiaRemision> getGuiaRemisions() {
		return this.guiaremisions;
	}

	public List<PedidoExpor> getPedidoExpors() {
		return this.pedidoexpors;
	}

	public List<FacturaPuntoVenta> getFacturaPuntoVentas() {
		return this.facturapuntoventas;
	}

	public List<PedidoPuntoVenta> getPedidoPuntoVentas() {
		return this.pedidopuntoventas;
	}

	public List<UtilidadTipoPrecio> getUtilidadTipoPrecios() {
		return this.utilidadtipoprecios;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public List<ServicioCliente> getServicioClientes() {
		return this.servicioclientes;
	}

	public List<Proforma> getProformas() {
		return this.proformas;
	}

	public List<DescuentoTipoPrecio> getDescuentoTipoPrecios() {
		return this.descuentotipoprecios;
	}

	public List<NotaCreditoPuntoVenta> getNotaCreditoPuntoVentas() {
		return this.notacreditopuntoventas;
	}

	public List<ParametroCarteraDefecto> getParametroCarteraDefectos() {
		return this.parametrocarteradefectos;
	}

	public List<Consignacion> getConsignacions() {
		return this.consignacions;
	}

	
	
	public  void  setPrecios(List<Precio> precios) {
		try {
			this.precios=precios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticasClientes(List<PoliticasCliente> politicasclientes) {
		try {
			this.politicasclientes=politicasclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNotaCreditoSolis(List<NotaCreditoSoli> notacreditosolis) {
		try {
			this.notacreditosolis=notacreditosolis;
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

	public  void  setPedidoExpors(List<PedidoExpor> pedidoexpors) {
		try {
			this.pedidoexpors=pedidoexpors;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFacturaPuntoVentas(List<FacturaPuntoVenta> facturapuntoventas) {
		try {
			this.facturapuntoventas=facturapuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPedidoPuntoVentas(List<PedidoPuntoVenta> pedidopuntoventas) {
		try {
			this.pedidopuntoventas=pedidopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setUtilidadTipoPrecios(List<UtilidadTipoPrecio> utilidadtipoprecios) {
		try {
			this.utilidadtipoprecios=utilidadtipoprecios;
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

	public  void  setServicioClientes(List<ServicioCliente> servicioclientes) {
		try {
			this.servicioclientes=servicioclientes;
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

	public  void  setDescuentoTipoPrecios(List<DescuentoTipoPrecio> descuentotipoprecios) {
		try {
			this.descuentotipoprecios=descuentotipoprecios;
		} catch(Exception e) {
			;
		}
	}

	public  void  setNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas) {
		try {
			this.notacreditopuntoventas=notacreditopuntoventas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroCarteraDefectos(List<ParametroCarteraDefecto> parametrocarteradefectos) {
		try {
			this.parametrocarteradefectos=parametrocarteradefectos;
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

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String esta_activo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getesta_activo_descripcion() {
		return esta_activo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setesta_activo_descripcion(String newesta_activo_descripcion)throws Exception {
		try {
			this.esta_activo_descripcion=newesta_activo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.esta_activo_descripcion="";
	}
	
	
	Object preciosDescripcionReporte;
	Object utilidadtipopreciosDescripcionReporte;
	Object pedidopuntoventasDescripcionReporte;
	Object parametrocarteradefectosDescripcionReporte;
	Object descuentotipopreciosDescripcionReporte;
	Object politicasclientesDescripcionReporte;
	Object proformasDescripcionReporte;
	Object facturasDescripcionReporte;
	Object notacreditosolisDescripcionReporte;
	Object consignacionsDescripcionReporte;
	Object pedidoexporsDescripcionReporte;
	Object servicioclientesDescripcionReporte;
	Object facturapuntoventasDescripcionReporte;
	Object guiaremisionsDescripcionReporte;
	Object notacreditosDescripcionReporte;
	Object pedidosDescripcionReporte;
	Object clientesDescripcionReporte;
	Object notacreditopuntoventasDescripcionReporte;
	
	
	public Object getpreciosDescripcionReporte() {
		return preciosDescripcionReporte;
	}

	public Object getutilidadtipopreciosDescripcionReporte() {
		return utilidadtipopreciosDescripcionReporte;
	}

	public Object getpedidopuntoventasDescripcionReporte() {
		return pedidopuntoventasDescripcionReporte;
	}

	public Object getparametrocarteradefectosDescripcionReporte() {
		return parametrocarteradefectosDescripcionReporte;
	}

	public Object getdescuentotipopreciosDescripcionReporte() {
		return descuentotipopreciosDescripcionReporte;
	}

	public Object getpoliticasclientesDescripcionReporte() {
		return politicasclientesDescripcionReporte;
	}

	public Object getproformasDescripcionReporte() {
		return proformasDescripcionReporte;
	}

	public Object getfacturasDescripcionReporte() {
		return facturasDescripcionReporte;
	}

	public Object getnotacreditosolisDescripcionReporte() {
		return notacreditosolisDescripcionReporte;
	}

	public Object getconsignacionsDescripcionReporte() {
		return consignacionsDescripcionReporte;
	}

	public Object getpedidoexporsDescripcionReporte() {
		return pedidoexporsDescripcionReporte;
	}

	public Object getservicioclientesDescripcionReporte() {
		return servicioclientesDescripcionReporte;
	}

	public Object getfacturapuntoventasDescripcionReporte() {
		return facturapuntoventasDescripcionReporte;
	}

	public Object getguiaremisionsDescripcionReporte() {
		return guiaremisionsDescripcionReporte;
	}

	public Object getnotacreditosDescripcionReporte() {
		return notacreditosDescripcionReporte;
	}

	public Object getpedidosDescripcionReporte() {
		return pedidosDescripcionReporte;
	}

	public Object getclientesDescripcionReporte() {
		return clientesDescripcionReporte;
	}

	public Object getnotacreditopuntoventasDescripcionReporte() {
		return notacreditopuntoventasDescripcionReporte;
	}

	
	
	public  void  setpreciosDescripcionReporte(Object precios) {
		try {
			this.preciosDescripcionReporte=precios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setutilidadtipopreciosDescripcionReporte(Object utilidadtipoprecios) {
		try {
			this.utilidadtipopreciosDescripcionReporte=utilidadtipoprecios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpedidopuntoventasDescripcionReporte(Object pedidopuntoventas) {
		try {
			this.pedidopuntoventasDescripcionReporte=pedidopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrocarteradefectosDescripcionReporte(Object parametrocarteradefectos) {
		try {
			this.parametrocarteradefectosDescripcionReporte=parametrocarteradefectos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdescuentotipopreciosDescripcionReporte(Object descuentotipoprecios) {
		try {
			this.descuentotipopreciosDescripcionReporte=descuentotipoprecios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticasclientesDescripcionReporte(Object politicasclientes) {
		try {
			this.politicasclientesDescripcionReporte=politicasclientes;
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

	public  void  setfacturasDescripcionReporte(Object facturas) {
		try {
			this.facturasDescripcionReporte=facturas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditosolisDescripcionReporte(Object notacreditosolis) {
		try {
			this.notacreditosolisDescripcionReporte=notacreditosolis;
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

	public  void  setpedidoexporsDescripcionReporte(Object pedidoexpors) {
		try {
			this.pedidoexporsDescripcionReporte=pedidoexpors;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setservicioclientesDescripcionReporte(Object servicioclientes) {
		try {
			this.servicioclientesDescripcionReporte=servicioclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setfacturapuntoventasDescripcionReporte(Object facturapuntoventas) {
		try {
			this.facturapuntoventasDescripcionReporte=facturapuntoventas;
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

	public  void  setnotacreditosDescripcionReporte(Object notacreditos) {
		try {
			this.notacreditosDescripcionReporte=notacreditos;
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

	public  void  setclientesDescripcionReporte(Object clientes) {
		try {
			this.clientesDescripcionReporte=clientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setnotacreditopuntoventasDescripcionReporte(Object notacreditopuntoventas) {
		try {
			this.notacreditopuntoventasDescripcionReporte=notacreditopuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

