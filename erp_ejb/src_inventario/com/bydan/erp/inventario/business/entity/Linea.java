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
//import com.bydan.erp.inventario.util.LineaConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class Linea extends LineaAdditional implements Serializable ,Cloneable {//LineaAdditional,GeneralEntity
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
	
	private Linea lineaOriginal;
	
	private Map<String, Object> mapLinea;
			
	public Map<String, Object> getMapLinea() {
		return mapLinea;
	}

	public void setMapLinea(Map<String, Object> mapLinea) {
		this.mapLinea = mapLinea;
	}
	
	public void inicializarMapLinea() {
		this.mapLinea = new HashMap<String,Object>();
	}
	
	public void setMapLineaValue(String sKey,Object oValue) {
		this.mapLinea.put(sKey, oValue);
	}
	
	public Object getMapLineaValue(String sKey) {
		return this.mapLinea.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_nivel_linea;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LineaConstantesFunciones.SREGEXCODIGO,message=LineaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=LineaConstantesFunciones.SREGEXNOMBRE,message=LineaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=LineaConstantesFunciones.SREGEXDESCRIPCION,message=LineaConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public NivelLinea nivellinea;
	public Linea linea;
	
	
	private String empresa_descripcion;
	private String nivellinea_descripcion;
	private String linea_descripcion;
	
	
	public List<PresupuestoLinea> presupuestolineas;
	public List<Linea> lineas;
	public List<ComisionGrupo> comisiongrupoGrupos;
	public List<ProductoPuntoVenta> productopuntoventas;
	public List<ComisionLinea> comisionlineas;
	public List<ComisionCate> comisioncates;
	public List<DetallePlaneacionCompra> detalleplaneacioncompras;
	public List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias;
	public List<Precio> precioGrupos;
	public List<LineaPuntoVenta> lineapuntoventaMarcas;
	public List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas;
	public List<PresupuestoVentasLineas> presupuestoventaslineasMarcas;
	public List<CentroCostoGrupoProducto> centrocostogrupoproductos;
	public List<Producto> productos;
	public List<ComisionMarca> comisionmarcaGrupos;
		
	public Linea () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.lineaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_nivel_linea=-1L;
 		this.id_linea=null;
 		this.codigo="";
 		this.nombre="";
 		this.descripcion="";
		
		
		this.empresa=null;
		this.nivellinea=null;
		
		
		this.empresa_descripcion="";
		this.nivellinea_descripcion="";
		
		
		this.presupuestolineas=null;
		this.lineas=null;
		this.comisiongrupoGrupos=null;
		this.productopuntoventas=null;
		this.comisionlineas=null;
		this.comisioncates=null;
		this.detalleplaneacioncompras=null;
		this.cuentascontableslineaproductoCategorias=null;
		this.precioGrupos=null;
		this.lineapuntoventaMarcas=null;
		this.detallecodigobarraproductoMarcas=null;
		this.presupuestoventaslineasMarcas=null;
		this.centrocostogrupoproductos=null;
		this.productos=null;
		this.comisionmarcaGrupos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Linea (Long id,Date versionRow,Long id_empresa,Long id_nivel_linea,Long id_linea,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.lineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_nivel_linea=id_nivel_linea;
 		this.id_linea=id_linea;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Linea (Long id_empresa,Long id_nivel_linea,Long id_linea,String codigo,String nombre,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.lineaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_nivel_linea=id_nivel_linea;
 		this.id_linea=id_linea;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Linea lineaLocal=null;
		
		if(object!=null) {
			lineaLocal=(Linea)object;
			
			if(lineaLocal!=null) {
				if(this.getId()!=null && lineaLocal.getId()!=null) {
					if(this.getId().equals(lineaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!LineaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=LineaConstantesFunciones.getLineaDescripcion(this);
		} else {
			sDetalle=LineaConstantesFunciones.getLineaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Linea getLineaOriginal() {
		return this.lineaOriginal;
	}
	
	public void setLineaOriginal(Linea linea) {
		try {
			this.lineaOriginal=linea;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected LineaAdditional lineaAdditional=null;
	
	public LineaAdditional getLineaAdditional() {
		return this.lineaAdditional;
	}
	
	public void setLineaAdditional(LineaAdditional lineaAdditional) {
		try {
			this.lineaAdditional=lineaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_nivel_linea() {
		return this.id_nivel_linea;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
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
						System.out.println("Linea:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_nivel_linea(Long newid_nivel_linea)throws Exception
	{
		try {
			if(this.id_nivel_linea!=newid_nivel_linea) {
				if(newid_nivel_linea==null) {
					//newid_nivel_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Linea:Valor nulo no permitido en columna id_nivel_linea");
					}
				}

				this.id_nivel_linea=newid_nivel_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea) {
		if(this.id_linea==null&&newid_linea!=null) {
			this.id_linea=newid_linea;
				this.setIsChanged(true);
		}

		if(this.id_linea!=null&&!this.id_linea.equals(newid_linea)) {

			this.id_linea=newid_linea;
				this.setIsChanged(true);
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Linea:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Linea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Linea:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Linea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("Linea:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("Linea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
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

	public NivelLinea getNivelLinea() {
		return this.nivellinea;
	}

	public Linea getLinea() {
		return this.linea;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getnivellinea_descripcion() {
		return this.nivellinea_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setNivelLinea(NivelLinea nivellinea) {
		try {
			this.nivellinea=nivellinea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLinea(Linea linea) {
		try {
			this.linea=linea;
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


	public  void  setnivellinea_descripcion(String nivellinea_descripcion) {
		try {
			this.nivellinea_descripcion=nivellinea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlinea_descripcion(String linea_descripcion) {
		try {
			this.linea_descripcion=linea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<PresupuestoLinea> getPresupuestoLineas() {
		return this.presupuestolineas;
	}

	public List<Linea> getLineas() {
		return this.lineas;
	}

	public List<ComisionGrupo> getComisionGrupoGrupos() {
		return this.comisiongrupoGrupos;
	}

	public List<ProductoPuntoVenta> getProductoPuntoVentas() {
		return this.productopuntoventas;
	}

	public List<ComisionLinea> getComisionLineas() {
		return this.comisionlineas;
	}

	public List<ComisionCate> getComisionCates() {
		return this.comisioncates;
	}

	public List<DetallePlaneacionCompra> getDetallePlaneacionCompras() {
		return this.detalleplaneacioncompras;
	}

	public List<CuentasContablesLineaProducto> getCuentasContablesLineaProductoCategorias() {
		return this.cuentascontableslineaproductoCategorias;
	}

	public List<Precio> getPrecioGrupos() {
		return this.precioGrupos;
	}

	public List<LineaPuntoVenta> getLineaPuntoVentaMarcas() {
		return this.lineapuntoventaMarcas;
	}

	public List<DetalleCodigoBarraProducto> getDetalleCodigoBarraProductoMarcas() {
		return this.detallecodigobarraproductoMarcas;
	}

	public List<PresupuestoVentasLineas> getPresupuestoVentasLineasMarcas() {
		return this.presupuestoventaslineasMarcas;
	}

	public List<CentroCostoGrupoProducto> getCentroCostoGrupoProductos() {
		return this.centrocostogrupoproductos;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public List<ComisionMarca> getComisionMarcaGrupos() {
		return this.comisionmarcaGrupos;
	}

	
	
	public  void  setPresupuestoLineas(List<PresupuestoLinea> presupuestolineas) {
		try {
			this.presupuestolineas=presupuestolineas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setLineas(List<Linea> lineas) {
		try {
			this.lineas=lineas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionGrupoGrupos(List<ComisionGrupo> comisiongrupoGrupos) {
		try {
			this.comisiongrupoGrupos=comisiongrupoGrupos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductoPuntoVentas(List<ProductoPuntoVenta> productopuntoventas) {
		try {
			this.productopuntoventas=productopuntoventas;
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

	public  void  setComisionCates(List<ComisionCate> comisioncates) {
		try {
			this.comisioncates=comisioncates;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetallePlaneacionCompras(List<DetallePlaneacionCompra> detalleplaneacioncompras) {
		try {
			this.detalleplaneacioncompras=detalleplaneacioncompras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuentasContablesLineaProductoCategorias(List<CuentasContablesLineaProducto> cuentascontableslineaproductoCategorias) {
		try {
			this.cuentascontableslineaproductoCategorias=cuentascontableslineaproductoCategorias;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPrecioGrupos(List<Precio> precioGrupos) {
		try {
			this.precioGrupos=precioGrupos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setLineaPuntoVentaMarcas(List<LineaPuntoVenta> lineapuntoventaMarcas) {
		try {
			this.lineapuntoventaMarcas=lineapuntoventaMarcas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleCodigoBarraProductoMarcas(List<DetalleCodigoBarraProducto> detallecodigobarraproductoMarcas) {
		try {
			this.detallecodigobarraproductoMarcas=detallecodigobarraproductoMarcas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPresupuestoVentasLineasMarcas(List<PresupuestoVentasLineas> presupuestoventaslineasMarcas) {
		try {
			this.presupuestoventaslineasMarcas=presupuestoventaslineasMarcas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCentroCostoGrupoProductos(List<CentroCostoGrupoProducto> centrocostogrupoproductos) {
		try {
			this.centrocostogrupoproductos=centrocostogrupoproductos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setProductos(List<Producto> productos) {
		try {
			this.productos=productos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setComisionMarcaGrupos(List<ComisionMarca> comisionmarcaGrupos) {
		try {
			this.comisionmarcaGrupos=comisionmarcaGrupos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_nivel_linea_descripcion="";String id_linea_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_nivel_linea_descripcion() {
		return id_nivel_linea_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_nivel_linea_descripcion(String newid_nivel_linea_descripcion)throws Exception {
		try {
			this.id_nivel_linea_descripcion=newid_nivel_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_descripcion(String newid_linea_descripcion) {
		this.id_linea_descripcion=newid_linea_descripcion;
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_nivel_linea_descripcion="";this.id_linea_descripcion="";
	}
	
	
	Object presupuestolineasDescripcionReporte;
	Object lineasDescripcionReporte;
	Object comisiongrupoGruposDescripcionReporte;
	Object productopuntoventasDescripcionReporte;
	Object comisionlineasDescripcionReporte;
	Object comisioncatesDescripcionReporte;
	Object detalleplaneacioncomprasDescripcionReporte;
	Object cuentascontableslineaproductoCategoriasDescripcionReporte;
	Object precioGruposDescripcionReporte;
	Object lineapuntoventaMarcasDescripcionReporte;
	Object detallecodigobarraproductoMarcasDescripcionReporte;
	Object presupuestoventaslineasMarcasDescripcionReporte;
	Object centrocostogrupoproductosDescripcionReporte;
	Object productosDescripcionReporte;
	Object comisionmarcaGruposDescripcionReporte;
	
	
	public Object getpresupuestolineasDescripcionReporte() {
		return presupuestolineasDescripcionReporte;
	}

	public Object getlineasDescripcionReporte() {
		return lineasDescripcionReporte;
	}

	public Object getcomisiongrupoGruposDescripcionReporte() {
		return comisiongrupoGruposDescripcionReporte;
	}

	public Object getproductopuntoventasDescripcionReporte() {
		return productopuntoventasDescripcionReporte;
	}

	public Object getcomisionlineasDescripcionReporte() {
		return comisionlineasDescripcionReporte;
	}

	public Object getcomisioncatesDescripcionReporte() {
		return comisioncatesDescripcionReporte;
	}

	public Object getdetalleplaneacioncomprasDescripcionReporte() {
		return detalleplaneacioncomprasDescripcionReporte;
	}

	public Object getcuentascontableslineaproductoCategoriasDescripcionReporte() {
		return cuentascontableslineaproductoCategoriasDescripcionReporte;
	}

	public Object getprecioGruposDescripcionReporte() {
		return precioGruposDescripcionReporte;
	}

	public Object getlineapuntoventaMarcasDescripcionReporte() {
		return lineapuntoventaMarcasDescripcionReporte;
	}

	public Object getdetallecodigobarraproductoMarcasDescripcionReporte() {
		return detallecodigobarraproductoMarcasDescripcionReporte;
	}

	public Object getpresupuestoventaslineasMarcasDescripcionReporte() {
		return presupuestoventaslineasMarcasDescripcionReporte;
	}

	public Object getcentrocostogrupoproductosDescripcionReporte() {
		return centrocostogrupoproductosDescripcionReporte;
	}

	public Object getproductosDescripcionReporte() {
		return productosDescripcionReporte;
	}

	public Object getcomisionmarcaGruposDescripcionReporte() {
		return comisionmarcaGruposDescripcionReporte;
	}

	
	
	public  void  setpresupuestolineasDescripcionReporte(Object presupuestolineas) {
		try {
			this.presupuestolineasDescripcionReporte=presupuestolineas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setlineasDescripcionReporte(Object lineas) {
		try {
			this.lineasDescripcionReporte=lineas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisiongrupoGruposDescripcionReporte(Object comisiongrupos) {
		try {
			this.comisiongrupoGruposDescripcionReporte=comisiongrupos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductopuntoventasDescripcionReporte(Object productopuntoventas) {
		try {
			this.productopuntoventasDescripcionReporte=productopuntoventas;
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

	public  void  setcomisioncatesDescripcionReporte(Object comisioncates) {
		try {
			this.comisioncatesDescripcionReporte=comisioncates;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleplaneacioncomprasDescripcionReporte(Object detalleplaneacioncompras) {
		try {
			this.detalleplaneacioncomprasDescripcionReporte=detalleplaneacioncompras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentascontableslineaproductoCategoriasDescripcionReporte(Object cuentascontableslineaproductos) {
		try {
			this.cuentascontableslineaproductoCategoriasDescripcionReporte=cuentascontableslineaproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setprecioGruposDescripcionReporte(Object precios) {
		try {
			this.precioGruposDescripcionReporte=precios;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setlineapuntoventaMarcasDescripcionReporte(Object lineapuntoventas) {
		try {
			this.lineapuntoventaMarcasDescripcionReporte=lineapuntoventas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetallecodigobarraproductoMarcasDescripcionReporte(Object detallecodigobarraproductos) {
		try {
			this.detallecodigobarraproductoMarcasDescripcionReporte=detallecodigobarraproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpresupuestoventaslineasMarcasDescripcionReporte(Object presupuestoventaslineass) {
		try {
			this.presupuestoventaslineasMarcasDescripcionReporte=presupuestoventaslineass;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcentrocostogrupoproductosDescripcionReporte(Object centrocostogrupoproductos) {
		try {
			this.centrocostogrupoproductosDescripcionReporte=centrocostogrupoproductos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setproductosDescripcionReporte(Object productos) {
		try {
			this.productosDescripcionReporte=productos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcomisionmarcaGruposDescripcionReporte(Object comisionmarcas) {
		try {
			this.comisionmarcaGruposDescripcionReporte=comisionmarcas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

