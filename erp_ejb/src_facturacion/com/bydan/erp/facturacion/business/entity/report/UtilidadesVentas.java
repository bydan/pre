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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.UtilidadesVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class UtilidadesVentas extends UtilidadesVentasAdditional implements Serializable ,Cloneable {//UtilidadesVentasAdditional,GeneralEntity
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
	
	private UtilidadesVentas utilidadesventasOriginal;
	
	private Map<String, Object> mapUtilidadesVentas;
			
	public Map<String, Object> getMapUtilidadesVentas() {
		return mapUtilidadesVentas;
	}

	public void setMapUtilidadesVentas(Map<String, Object> mapUtilidadesVentas) {
		this.mapUtilidadesVentas = mapUtilidadesVentas;
	}
	
	public void inicializarMapUtilidadesVentas() {
		this.mapUtilidadesVentas = new HashMap<String,Object>();
	}
	
	public void setMapUtilidadesVentasValue(String sKey,Object oValue) {
		this.mapUtilidadesVentas.put(sKey, oValue);
	}
	
	public Object getMapUtilidadesVentasValue(String sKey) {
		return this.mapUtilidadesVentas.get(sKey);
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
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=UtilidadesVentasConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=UtilidadesVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=UtilidadesVentasConstantesFunciones.SREGEXNOMBRE_TIPO_FACTURA,message=UtilidadesVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_FACTURA)
	private String nombre_tipo_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=UtilidadesVentasConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=UtilidadesVentasConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=UtilidadesVentasConstantesFunciones.SREGEXTIPO,message=UtilidadesVentasConstantesFunciones.SMENSAJEREGEXTIPO)
	private String tipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double venta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double utilidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public UtilidadesVentas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.utilidadesventasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_completo_cliente="";
 		this.nombre_tipo_factura="";
 		this.fecha_emision=new Date();
 		this.numero_documento="";
 		this.tipo="";
 		this.venta=0.0;
 		this.costo=0.0;
 		this.utilidad=0.0;
 		this.porcentaje=0.0;
		
		
		this.empresa=null;
		this.sucursal=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public UtilidadesVentas (Long id,Date versionRow,String nombre_completo_cliente,String nombre_tipo_factura,Date fecha_emision,String numero_documento,String tipo,Double venta,Double costo,Double utilidad,Double porcentaje) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.utilidadesventasOriginal=this;
		
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_tipo_factura=nombre_tipo_factura;
 		this.fecha_emision=fecha_emision;
 		this.numero_documento=numero_documento;
 		this.tipo=tipo;
 		this.venta=venta;
 		this.costo=costo;
 		this.utilidad=utilidad;
 		this.porcentaje=porcentaje;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public UtilidadesVentas (String nombre_completo_cliente,String nombre_tipo_factura,Date fecha_emision,String numero_documento,String tipo,Double venta,Double costo,Double utilidad,Double porcentaje) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.utilidadesventasOriginal=this;
		
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_tipo_factura=nombre_tipo_factura;
 		this.fecha_emision=fecha_emision;
 		this.numero_documento=numero_documento;
 		this.tipo=tipo;
 		this.venta=venta;
 		this.costo=costo;
 		this.utilidad=utilidad;
 		this.porcentaje=porcentaje;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public UtilidadesVentas getUtilidadesVentasOriginal() {
		return this.utilidadesventasOriginal;
	}
	
	public void setUtilidadesVentasOriginal(UtilidadesVentas utilidadesventas) {
		try {
			this.utilidadesventasOriginal=utilidadesventas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected UtilidadesVentasAdditional utilidadesventasAdditional=null;
	
	public UtilidadesVentasAdditional getUtilidadesVentasAdditional() {
		return this.utilidadesventasAdditional;
	}
	
	public void setUtilidadesVentasAdditional(UtilidadesVentasAdditional utilidadesventasAdditional) {
		try {
			this.utilidadesventasAdditional=utilidadesventasAdditional;
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
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnombre_tipo_factura() {
		return this.nombre_tipo_factura;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public String gettipo() {
		return this.tipo;
	}
    
	
	public Double getventa() {
		return this.venta;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getutilidad() {
		return this.utilidad;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_cliente(String newnombre_completo_cliente)throws Exception
	{
		try {
			if(this.nombre_completo_cliente!=newnombre_completo_cliente) {
				if(newnombre_completo_cliente==null) {
					//newnombre_completo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("UtilidadesVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_factura(String newnombre_tipo_factura)throws Exception
	{
		try {
			if(this.nombre_tipo_factura!=newnombre_tipo_factura) {
				if(newnombre_tipo_factura==null) {
					//newnombre_tipo_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna nombre_tipo_factura");
					}
				}

				if(newnombre_tipo_factura!=null&&newnombre_tipo_factura.length()>100) {
					newnombre_tipo_factura=newnombre_tipo_factura.substring(0,98);
					System.out.println("UtilidadesVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_factura");
				}

				this.nombre_tipo_factura=newnombre_tipo_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision(Date newfecha_emision)throws Exception
	{
		try {
			if(this.fecha_emision!=newfecha_emision) {
				if(newfecha_emision==null) {
					//newfecha_emision=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_documento(String newnumero_documento)throws Exception
	{
		try {
			if(this.numero_documento!=newnumero_documento) {
				if(newnumero_documento==null) {
					//newnumero_documento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("UtilidadesVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo(String newtipo)throws Exception
	{
		try {
			if(this.tipo!=newtipo) {
				if(newtipo==null) {
					//newtipo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna tipo");
					}
				}

				if(newtipo!=null&&newtipo.length()>50) {
					newtipo=newtipo.substring(0,48);
					System.out.println("UtilidadesVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna tipo");
				}

				this.tipo=newtipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setventa(Double newventa)throws Exception
	{
		try {
			if(this.venta!=newventa) {
				if(newventa==null) {
					//newventa=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna venta");
					}
				}

				this.venta=newventa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto(Double newcosto)throws Exception
	{
		try {
			if(this.costo!=newcosto) {
				if(newcosto==null) {
					//newcosto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setutilidad(Double newutilidad)throws Exception
	{
		try {
			if(this.utilidad!=newutilidad) {
				if(newutilidad==null) {
					//newutilidad=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna utilidad");
					}
				}

				this.utilidad=newutilidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setporcentaje(Double newporcentaje)throws Exception
	{
		try {
			if(this.porcentaje!=newporcentaje) {
				if(newporcentaje==null) {
					//newporcentaje=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("UtilidadesVentas:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

