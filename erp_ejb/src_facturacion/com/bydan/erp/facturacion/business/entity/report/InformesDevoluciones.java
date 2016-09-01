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
//import com.bydan.erp.facturacion.util.InformesDevolucionesConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class InformesDevoluciones extends InformesDevolucionesAdditional implements Serializable ,Cloneable {//InformesDevolucionesAdditional,GeneralEntity
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
	
	private InformesDevoluciones informesdevolucionesOriginal;
	
	private Map<String, Object> mapInformesDevoluciones;
			
	public Map<String, Object> getMapInformesDevoluciones() {
		return mapInformesDevoluciones;
	}

	public void setMapInformesDevoluciones(Map<String, Object> mapInformesDevoluciones) {
		this.mapInformesDevoluciones = mapInformesDevoluciones;
	}
	
	public void inicializarMapInformesDevoluciones() {
		this.mapInformesDevoluciones = new HashMap<String,Object>();
	}
	
	public void setMapInformesDevolucionesValue(String sKey,Object oValue) {
		this.mapInformesDevoluciones.put(sKey, oValue);
	}
	
	public Object getMapInformesDevolucionesValue(String sKey) {
		return this.mapInformesDevoluciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_devolucion_empresa;
	
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXUSER_NAME_USUARIO,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXUSER_NAME_USUARIO)
	private String user_name_usuario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXNUMERO_PRE_IMPRESO,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXNUMERO_PRE_IMPRESO)
	private String numero_pre_impreso;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXNOMBRE_BODEGA,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXNOMBRE_BODEGA)
	private String nombre_bodega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXNOMBRE_PRODUCTO,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXNOMBRE_PRODUCTO)
	private String nombre_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXNOMBRE_TIPO_DEVOLUCION_EMPRESA,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXNOMBRE_TIPO_DEVOLUCION_EMPRESA)
	private String nombre_tipo_devolucion_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=InformesDevolucionesConstantesFunciones.SREGEXCODIGO_PRODUCTO,message=InformesDevolucionesConstantesFunciones.SMENSAJEREGEXCODIGO_PRODUCTO)
	private String codigo_producto;
			
	
	public Producto producto;
	public TipoDevolucionEmpresa tipodevolucionempresa;
	public Empresa empresa;
	public Sucursal sucursal;
	
	
	private String producto_descripcion;
	private String tipodevolucionempresa_descripcion;
	private String empresa_descripcion;
	private String sucursal_descripcion;
	
	
		
	public InformesDevoluciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.informesdevolucionesOriginal=this;
		
 		this.id_producto=-1L;
 		this.id_tipo_devolucion_empresa=-1L;
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.user_name_usuario="";
 		this.nombre_completo_cliente="";
 		this.numero_pre_impreso="";
 		this.fecha_emision=new Date();
 		this.nombre_bodega="";
 		this.nombre_producto="";
 		this.nombre_tipo_devolucion_empresa="";
 		this.cantidad=0;
 		this.codigo_producto="";
		
		
		this.producto=null;
		this.tipodevolucionempresa=null;
		this.empresa=null;
		this.sucursal=null;
		
		
		this.producto_descripcion="";
		this.tipodevolucionempresa_descripcion="";
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public InformesDevoluciones (Long id,Date versionRow,String user_name_usuario,String nombre_completo_cliente,String numero_pre_impreso,Date fecha_emision,String nombre_bodega,String nombre_producto,String nombre_tipo_devolucion_empresa,Integer cantidad,String codigo_producto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informesdevolucionesOriginal=this;
		
 		this.user_name_usuario=user_name_usuario;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_producto=nombre_producto;
 		this.nombre_tipo_devolucion_empresa=nombre_tipo_devolucion_empresa;
 		this.cantidad=cantidad;
 		this.codigo_producto=codigo_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public InformesDevoluciones (String user_name_usuario,String nombre_completo_cliente,String numero_pre_impreso,Date fecha_emision,String nombre_bodega,String nombre_producto,String nombre_tipo_devolucion_empresa,Integer cantidad,String codigo_producto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.informesdevolucionesOriginal=this;
		
 		this.user_name_usuario=user_name_usuario;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.numero_pre_impreso=numero_pre_impreso;
 		this.fecha_emision=fecha_emision;
 		this.nombre_bodega=nombre_bodega;
 		this.nombre_producto=nombre_producto;
 		this.nombre_tipo_devolucion_empresa=nombre_tipo_devolucion_empresa;
 		this.cantidad=cantidad;
 		this.codigo_producto=codigo_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public InformesDevoluciones getInformesDevolucionesOriginal() {
		return this.informesdevolucionesOriginal;
	}
	
	public void setInformesDevolucionesOriginal(InformesDevoluciones informesdevoluciones) {
		try {
			this.informesdevolucionesOriginal=informesdevoluciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected InformesDevolucionesAdditional informesdevolucionesAdditional=null;
	
	public InformesDevolucionesAdditional getInformesDevolucionesAdditional() {
		return this.informesdevolucionesAdditional;
	}
	
	public void setInformesDevolucionesAdditional(InformesDevolucionesAdditional informesdevolucionesAdditional) {
		try {
			this.informesdevolucionesAdditional=informesdevolucionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_producto() {
		return this.id_producto;
	}
    
	
	public Long getid_tipo_devolucion_empresa() {
		return this.id_tipo_devolucion_empresa;
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
    
	
	public String getuser_name_usuario() {
		return this.user_name_usuario;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnumero_pre_impreso() {
		return this.numero_pre_impreso;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnombre_bodega() {
		return this.nombre_bodega;
	}
    
	
	public String getnombre_producto() {
		return this.nombre_producto;
	}
    
	
	public String getnombre_tipo_devolucion_empresa() {
		return this.nombre_tipo_devolucion_empresa;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public String getcodigo_producto() {
		return this.codigo_producto;
	}
	
    
	public void setid_producto(Long newid_producto)throws Exception
	{
		try {
			if(this.id_producto!=newid_producto) {
				if(newid_producto==null) {
					//newid_producto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna id_producto");
					}
				}

				this.id_producto=newid_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_devolucion_empresa(Long newid_tipo_devolucion_empresa)throws Exception
	{
		try {
			if(this.id_tipo_devolucion_empresa!=newid_tipo_devolucion_empresa) {
				if(newid_tipo_devolucion_empresa==null) {
					//newid_tipo_devolucion_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna id_tipo_devolucion_empresa");
					}
				}

				this.id_tipo_devolucion_empresa=newid_tipo_devolucion_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna fecha_emision_desde");
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setuser_name_usuario(String newuser_name_usuario)throws Exception
	{
		try {
			if(this.user_name_usuario!=newuser_name_usuario) {
				if(newuser_name_usuario==null) {
					//newuser_name_usuario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna user_name_usuario");
					}
				}

				if(newuser_name_usuario!=null&&newuser_name_usuario.length()>50) {
					newuser_name_usuario=newuser_name_usuario.substring(0,48);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna user_name_usuario");
				}

				this.user_name_usuario=newuser_name_usuario;
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_pre_impreso(String newnumero_pre_impreso)throws Exception
	{
		try {
			if(this.numero_pre_impreso!=newnumero_pre_impreso) {
				if(newnumero_pre_impreso==null) {
					//newnumero_pre_impreso="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna numero_pre_impreso");
					}
				}

				if(newnumero_pre_impreso!=null&&newnumero_pre_impreso.length()>50) {
					newnumero_pre_impreso=newnumero_pre_impreso.substring(0,48);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_pre_impreso");
				}

				this.numero_pre_impreso=newnumero_pre_impreso;
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_bodega(String newnombre_bodega)throws Exception
	{
		try {
			if(this.nombre_bodega!=newnombre_bodega) {
				if(newnombre_bodega==null) {
					//newnombre_bodega="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna nombre_bodega");
					}
				}

				if(newnombre_bodega!=null&&newnombre_bodega.length()>150) {
					newnombre_bodega=newnombre_bodega.substring(0,148);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_bodega");
				}

				this.nombre_bodega=newnombre_bodega;
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna nombre_producto");
					}
				}

				if(newnombre_producto!=null&&newnombre_producto.length()>150) {
					newnombre_producto=newnombre_producto.substring(0,148);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_producto");
				}

				this.nombre_producto=newnombre_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_tipo_devolucion_empresa(String newnombre_tipo_devolucion_empresa)throws Exception
	{
		try {
			if(this.nombre_tipo_devolucion_empresa!=newnombre_tipo_devolucion_empresa) {
				if(newnombre_tipo_devolucion_empresa==null) {
					//newnombre_tipo_devolucion_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna nombre_tipo_devolucion_empresa");
					}
				}

				if(newnombre_tipo_devolucion_empresa!=null&&newnombre_tipo_devolucion_empresa.length()>100) {
					newnombre_tipo_devolucion_empresa=newnombre_tipo_devolucion_empresa.substring(0,98);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_tipo_devolucion_empresa");
				}

				this.nombre_tipo_devolucion_empresa=newnombre_tipo_devolucion_empresa;
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
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_producto(String newcodigo_producto)throws Exception
	{
		try {
			if(this.codigo_producto!=newcodigo_producto) {
				if(newcodigo_producto==null) {
					//newcodigo_producto="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("InformesDevoluciones:Valor nulo no permitido en columna codigo_producto");
					}
				}

				if(newcodigo_producto!=null&&newcodigo_producto.length()>50) {
					newcodigo_producto=newcodigo_producto.substring(0,48);
					System.out.println("InformesDevoluciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_producto");
				}

				this.codigo_producto=newcodigo_producto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Producto getProducto() {
		return this.producto;
	}

	public TipoDevolucionEmpresa getTipoDevolucionEmpresa() {
		return this.tipodevolucionempresa;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	
	
	public String getproducto_descripcion() {
		return this.producto_descripcion;
	}

	public String gettipodevolucionempresa_descripcion() {
		return this.tipodevolucionempresa_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	
	
	public  void  setProducto(Producto producto) {
		try {
			this.producto=producto;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDevolucionEmpresa(TipoDevolucionEmpresa tipodevolucionempresa) {
		try {
			this.tipodevolucionempresa=tipodevolucionempresa;
		} catch(Exception e) {
			;
		}
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


	
	
	public  void  setproducto_descripcion(String producto_descripcion) {
		try {
			this.producto_descripcion=producto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodevolucionempresa_descripcion(String tipodevolucionempresa_descripcion) {
		try {
			this.tipodevolucionempresa_descripcion=tipodevolucionempresa_descripcion;
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
	String id_producto_descripcion="";String id_tipo_devolucion_empresa_descripcion="";String id_empresa_descripcion="";String id_sucursal_descripcion="";
	
	
	public String getid_producto_descripcion() {
		return id_producto_descripcion;
	}
	public String getid_tipo_devolucion_empresa_descripcion() {
		return id_tipo_devolucion_empresa_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	
	
	public void setid_producto_descripcion(String newid_producto_descripcion)throws Exception {
		try {
			this.id_producto_descripcion=newid_producto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_devolucion_empresa_descripcion(String newid_tipo_devolucion_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_devolucion_empresa_descripcion=newid_tipo_devolucion_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
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
		this.id_producto_descripcion="";this.id_tipo_devolucion_empresa_descripcion="";this.id_empresa_descripcion="";this.id_sucursal_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

