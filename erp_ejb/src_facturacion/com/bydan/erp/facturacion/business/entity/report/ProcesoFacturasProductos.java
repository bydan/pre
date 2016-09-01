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
//import com.bydan.erp.facturacion.util.ProcesoFacturasProductosConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;




@SuppressWarnings("unused")
public class ProcesoFacturasProductos extends ProcesoFacturasProductosAdditional implements Serializable ,Cloneable {//ProcesoFacturasProductosAdditional,GeneralEntity
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
	
	private ProcesoFacturasProductos procesofacturasproductosOriginal;
	
	private Map<String, Object> mapProcesoFacturasProductos;
			
	public Map<String, Object> getMapProcesoFacturasProductos() {
		return mapProcesoFacturasProductos;
	}

	public void setMapProcesoFacturasProductos(Map<String, Object> mapProcesoFacturasProductos) {
		this.mapProcesoFacturasProductos = mapProcesoFacturasProductos;
	}
	
	public void inicializarMapProcesoFacturasProductos() {
		this.mapProcesoFacturasProductos = new HashMap<String,Object>();
	}
	
	public void setMapProcesoFacturasProductosValue(String sKey,Object oValue) {
		this.mapProcesoFacturasProductos.put(sKey, oValue);
	}
	
	public Object getMapProcesoFacturasProductosValue(String sKey) {
		return this.mapProcesoFacturasProductos.get(sKey);
	}
	
	
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
	private Long id_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_vendedor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXCODIGO,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_COMPLETO,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO)
	private String nombre_completo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_PROVINCIA,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_PROVINCIA)
	private String nombre_provincia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_CIUDAD,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_CIUDAD)
	private String nombre_ciudad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_ZONA,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_ZONA)
	private String nombre_zona;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_GRUPO_CLIENTE,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_GRUPO_CLIENTE)
	private String nombre_grupo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXCODIGO_DATO,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXCODIGO_DATO)
	private String codigo_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_COMPLETO_DATO,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_DATO)
	private String nombre_completo_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO_FACTURA,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA)
	private String numero_pre_impreso_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_PRODUCTO,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_PRODUCTO)
	private String nombre_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXNOMBRE_UNIDAD,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXNOMBRE_UNIDAD)
	private String nombre_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double precio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ProcesoFacturasProductosConstantesFunciones.SREGEXTAREA,message=ProcesoFacturasProductosConstantesFunciones.SMENSAJEREGEXTAREA)
	private String tarea;
			
	
	public Ciudad ciudad;
	public Zona zona;
	public GrupoCliente grupocliente;
	public Vendedor vendedor;
	
	
	private String ciudad_descripcion;
	private String zona_descripcion;
	private String grupocliente_descripcion;
	private String vendedor_descripcion;
	
	
		
	public ProcesoFacturasProductos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.procesofacturasproductosOriginal=this;
		
 		this.id_ciudad=-1L;
 		this.id_zona=-1L;
 		this.id_grupo_cliente=-1L;
 		this.id_vendedor=-1L;
 		this.codigo="";
 		this.nombre_completo="";
 		this.nombre_provincia="";
 		this.nombre_ciudad="";
 		this.nombre_zona="";
 		this.nombre_grupo_cliente="";
 		this.codigo_dato="";
 		this.nombre_completo_dato="";
 		this.numero_pre_impreso_factura="";
 		this.nombre_producto="";
 		this.nombre_unidad="";
 		this.precio=0.0;
 		this.tarea="";
		
		
		this.ciudad=null;
		this.zona=null;
		this.grupocliente=null;
		this.vendedor=null;
		
		
		this.ciudad_descripcion="";
		this.zona_descripcion="";
		this.grupocliente_descripcion="";
		this.vendedor_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ProcesoFacturasProductos (Long id,Date versionRow,String nombre_provincia,String nombre_ciudad,String nombre_zona,String nombre_grupo_cliente,String codigo_dato,String nombre_completo_dato,String numero_pre_impreso_factura,String nombre_producto,String nombre_unidad,Double precio,String tarea) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.procesofacturasproductosOriginal=this;
		
 		this.nombre_provincia=nombre_provincia;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_grupo_cliente=nombre_grupo_cliente;
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo_dato=nombre_completo_dato;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.nombre_producto=nombre_producto;
 		this.nombre_unidad=nombre_unidad;
 		this.precio=precio;
 		this.tarea=tarea;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ProcesoFacturasProductos (String nombre_provincia,String nombre_ciudad,String nombre_zona,String nombre_grupo_cliente,String codigo_dato,String nombre_completo_dato,String numero_pre_impreso_factura,String nombre_producto,String nombre_unidad,Double precio,String tarea) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.procesofacturasproductosOriginal=this;
		
 		this.nombre_provincia=nombre_provincia;
 		this.nombre_ciudad=nombre_ciudad;
 		this.nombre_zona=nombre_zona;
 		this.nombre_grupo_cliente=nombre_grupo_cliente;
 		this.codigo_dato=codigo_dato;
 		this.nombre_completo_dato=nombre_completo_dato;
 		this.numero_pre_impreso_factura=numero_pre_impreso_factura;
 		this.nombre_producto=nombre_producto;
 		this.nombre_unidad=nombre_unidad;
 		this.precio=precio;
 		this.tarea=tarea;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ProcesoFacturasProductos getProcesoFacturasProductosOriginal() {
		return this.procesofacturasproductosOriginal;
	}
	
	public void setProcesoFacturasProductosOriginal(ProcesoFacturasProductos procesofacturasproductos) {
		try {
			this.procesofacturasproductosOriginal=procesofacturasproductos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ProcesoFacturasProductosAdditional procesofacturasproductosAdditional=null;
	
	public ProcesoFacturasProductosAdditional getProcesoFacturasProductosAdditional() {
		return this.procesofacturasproductosAdditional;
	}
	
	public void setProcesoFacturasProductosAdditional(ProcesoFacturasProductosAdditional procesofacturasproductosAdditional) {
		try {
			this.procesofacturasproductosAdditional=procesofacturasproductosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_ciudad() {
		return this.id_ciudad;
	}
    
	
	public Long getid_zona() {
		return this.id_zona;
	}
    
	
	public Long getid_grupo_cliente() {
		return this.id_grupo_cliente;
	}
    
	
	public Long getid_vendedor() {
		return this.id_vendedor;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre_completo() {
		return this.nombre_completo;
	}
    
	
	public String getnombre_provincia() {
		return this.nombre_provincia;
	}
    
	
	public String getnombre_ciudad() {
		return this.nombre_ciudad;
	}
    
	
	public String getnombre_zona() {
		return this.nombre_zona;
	}
    
	
	public String getnombre_grupo_cliente() {
		return this.nombre_grupo_cliente;
	}
    
	
	public String getcodigo_dato() {
		return this.codigo_dato;
	}
    
	
	public String getnombre_completo_dato() {
		return this.nombre_completo_dato;
	}
    
	
	public String getnumero_pre_impreso_factura() {
		return this.numero_pre_impreso_factura;
	}
    
	
	public String getnombre_producto() {
		return this.nombre_producto;
	}
    
	
	public String getnombre_unidad() {
		return this.nombre_unidad;
	}
    
	
	public Double getprecio() {
		return this.precio;
	}
    
	
	public String gettarea() {
		return this.tarea;
	}
	
    
	public void setid_ciudad(Long newid_ciudad)throws Exception
	{
		try {
			if(this.id_ciudad!=newid_ciudad) {
				if(newid_ciudad==null) {
					//newid_ciudad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna id_ciudad");
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
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna id_zona");
					}
				}

				this.id_zona=newid_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_cliente(Long newid_grupo_cliente)throws Exception
	{
		try {
			if(this.id_grupo_cliente!=newid_grupo_cliente) {
				if(newid_grupo_cliente==null) {
					//newid_grupo_cliente=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna id_grupo_cliente");
					}
				}

				this.id_grupo_cliente=newid_grupo_cliente;
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
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna id_vendedor");
					}
				}

				this.id_vendedor=newid_vendedor;
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
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_completo");
					}
				}

				if(newnombre_completo!=null&&newnombre_completo.length()>150) {
					newnombre_completo=newnombre_completo.substring(0,148);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo");
				}

				this.nombre_completo=newnombre_completo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_provincia(String newnombre_provincia)throws Exception
	{
		try {
			if(this.nombre_provincia!=newnombre_provincia) {
				if(newnombre_provincia==null) {
					//newnombre_provincia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_provincia");
					}
				}

				if(newnombre_provincia!=null&&newnombre_provincia.length()>200) {
					newnombre_provincia=newnombre_provincia.substring(0,198);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_provincia");
				}

				this.nombre_provincia=newnombre_provincia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_ciudad(String newnombre_ciudad)throws Exception
	{
		try {
			if(this.nombre_ciudad!=newnombre_ciudad) {
				if(newnombre_ciudad==null) {
					//newnombre_ciudad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_ciudad");
					}
				}

				if(newnombre_ciudad!=null&&newnombre_ciudad.length()>200) {
					newnombre_ciudad=newnombre_ciudad.substring(0,198);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna nombre_ciudad");
				}

				this.nombre_ciudad=newnombre_ciudad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_zona(String newnombre_zona)throws Exception
	{
		try {
			if(this.nombre_zona!=newnombre_zona) {
				if(newnombre_zona==null) {
					//newnombre_zona="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_zona");
					}
				}

				if(newnombre_zona!=null&&newnombre_zona.length()>50) {
					newnombre_zona=newnombre_zona.substring(0,48);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_zona");
				}

				this.nombre_zona=newnombre_zona;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_grupo_cliente(String newnombre_grupo_cliente)throws Exception
	{
		try {
			if(this.nombre_grupo_cliente!=newnombre_grupo_cliente) {
				if(newnombre_grupo_cliente==null) {
					//newnombre_grupo_cliente="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_grupo_cliente");
					}
				}

				if(newnombre_grupo_cliente!=null&&newnombre_grupo_cliente.length()>150) {
					newnombre_grupo_cliente=newnombre_grupo_cliente.substring(0,148);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_grupo_cliente");
				}

				this.nombre_grupo_cliente=newnombre_grupo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_dato(String newcodigo_dato)throws Exception
	{
		try {
			if(this.codigo_dato!=newcodigo_dato) {
				if(newcodigo_dato==null) {
					//newcodigo_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna codigo_dato");
					}
				}

				if(newcodigo_dato!=null&&newcodigo_dato.length()>50) {
					newcodigo_dato=newcodigo_dato.substring(0,48);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_dato");
				}

				this.codigo_dato=newcodigo_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_completo_dato(String newnombre_completo_dato)throws Exception
	{
		try {
			if(this.nombre_completo_dato!=newnombre_completo_dato) {
				if(newnombre_completo_dato==null) {
					//newnombre_completo_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_completo_dato");
					}
				}

				if(newnombre_completo_dato!=null&&newnombre_completo_dato.length()>150) {
					newnombre_completo_dato=newnombre_completo_dato.substring(0,148);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_dato");
				}

				this.nombre_completo_dato=newnombre_completo_dato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso_factura(String newnumero_pre_impreso_factura)throws Exception
	{
		try {
			if(this.numero_pre_impreso_factura!=newnumero_pre_impreso_factura) {
				if(newnumero_pre_impreso_factura==null) {
					//newnumero_pre_impreso_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna numero_pre_impreso_factura");
					}
				}

				if(newnumero_pre_impreso_factura!=null&&newnumero_pre_impreso_factura.length()>50) {
					newnumero_pre_impreso_factura=newnumero_pre_impreso_factura.substring(0,48);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso_factura");
				}

				this.numero_pre_impreso_factura=newnumero_pre_impreso_factura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_producto(String newnombre_producto)throws Exception
	{
		try {
			if(this.nombre_producto!=newnombre_producto) {
				if(newnombre_producto==null) {
					//newnombre_producto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_producto");
					}
				}

				if(newnombre_producto!=null&&newnombre_producto.length()>150) {
					newnombre_producto=newnombre_producto.substring(0,148);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_producto");
				}

				this.nombre_producto=newnombre_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_unidad(String newnombre_unidad)throws Exception
	{
		try {
			if(this.nombre_unidad!=newnombre_unidad) {
				if(newnombre_unidad==null) {
					//newnombre_unidad="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna nombre_unidad");
					}
				}

				if(newnombre_unidad!=null&&newnombre_unidad.length()>50) {
					newnombre_unidad=newnombre_unidad.substring(0,48);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_unidad");
				}

				this.nombre_unidad=newnombre_unidad;
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
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna precio");
					}
				}

				this.precio=newprecio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settarea(String newtarea)throws Exception
	{
		try {
			if(this.tarea!=newtarea) {
				if(newtarea==null) {
					//newtarea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ProcesoFacturasProductos:Valor nulo no permitido en columna tarea");
					}
				}

				if(newtarea!=null&&newtarea.length()>250) {
					newtarea=newtarea.substring(0,248);
					System.out.println("ProcesoFacturasProductos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna tarea");
				}

				this.tarea=newtarea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public Zona getZona() {
		return this.zona;
	}

	public GrupoCliente getGrupoCliente() {
		return this.grupocliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	
	
	public String getciudad_descripcion() {
		return this.ciudad_descripcion;
	}

	public String getzona_descripcion() {
		return this.zona_descripcion;
	}

	public String getgrupocliente_descripcion() {
		return this.grupocliente_descripcion;
	}

	public String getvendedor_descripcion() {
		return this.vendedor_descripcion;
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


	public  void  setGrupoCliente(GrupoCliente grupocliente) {
		try {
			this.grupocliente=grupocliente;
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


	public  void  setgrupocliente_descripcion(String grupocliente_descripcion) {
		try {
			this.grupocliente_descripcion=grupocliente_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_ciudad_descripcion="";String id_zona_descripcion="";String id_grupo_cliente_descripcion="";String id_vendedor_descripcion="";
	
	
	public String getid_ciudad_descripcion() {
		return id_ciudad_descripcion;
	}
	public String getid_zona_descripcion() {
		return id_zona_descripcion;
	}
	public String getid_grupo_cliente_descripcion() {
		return id_grupo_cliente_descripcion;
	}
	public String getid_vendedor_descripcion() {
		return id_vendedor_descripcion;
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
	public void setid_grupo_cliente_descripcion(String newid_grupo_cliente_descripcion)throws Exception {
		try {
			this.id_grupo_cliente_descripcion=newid_grupo_cliente_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_ciudad_descripcion="";this.id_zona_descripcion="";this.id_grupo_cliente_descripcion="";this.id_vendedor_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

