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
package com.bydan.erp.inventario.business.entity.report;

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
//import com.bydan.erp.inventario.util.MovimientosDetalladosConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;

import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;




@SuppressWarnings("unused")
public class MovimientosDetallados extends MovimientosDetalladosAdditional implements Serializable ,Cloneable {//MovimientosDetalladosAdditional,GeneralEntity
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
	
	private MovimientosDetallados movimientosdetalladosOriginal;
	
	private Map<String, Object> mapMovimientosDetallados;
			
	public Map<String, Object> getMapMovimientosDetallados() {
		return mapMovimientosDetallados;
	}

	public void setMapMovimientosDetallados(Map<String, Object> mapMovimientosDetallados) {
		this.mapMovimientosDetallados = mapMovimientosDetallados;
	}
	
	public void inicializarMapMovimientosDetallados() {
		this.mapMovimientosDetallados = new HashMap<String,Object>();
	}
	
	public void setMapMovimientosDetalladosValue(String sKey,Object oValue) {
		this.mapMovimientosDetallados.put(sKey, oValue);
	}
	
	public Object getMapMovimientosDetalladosValue(String sKey) {
		return this.mapMovimientosDetallados.get(sKey);
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
	private Long id_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_categoria;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_linea_marca;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNOMBRE_COMPLETO_CLIENTE,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_COMPLETO_CLIENTE)
	private String nombre_completo_cliente;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNOMBRE_TRANSACCION,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_TRANSACCION)
	private String nombre_transaccion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNUMERO_COMPROBANTE,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNUMERO_COMPROBANTE)
	private String numero_comprobante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNUMERO_FACTURA,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNUMERO_FACTURA)
	private String numero_factura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNOMBRE_PRODUCTO,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_PRODUCTO)
	private String nombre_producto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXNOMBRE_UNIDAD,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXNOMBRE_UNIDAD)
	private String nombre_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_unitario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double ice;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MovimientosDetalladosConstantesFunciones.SREGEXCODIGO_PRODUCTO,message=MovimientosDetalladosConstantesFunciones.SMENSAJEREGEXCODIGO_PRODUCTO)
	private String codigo_producto;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Cliente cliente;
	public Transaccion transaccion;
	public Linea linea;
	public Linea lineagrupo;
	public Linea lineacategoria;
	public Linea lineamarca;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String cliente_descripcion;
	private String transaccion_descripcion;
	private String linea_descripcion;
	private String lineagrupo_descripcion;
	private String lineacategoria_descripcion;
	private String lineamarca_descripcion;
	
	
		
	public MovimientosDetallados () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.movimientosdetalladosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_cliente=-1L;
 		this.id_transaccion=-1L;
 		this.id_linea=-1L;
 		this.id_linea_grupo=-1L;
 		this.id_linea_categoria=-1L;
 		this.id_linea_marca=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.nombre_sucursal="";
 		this.nombre_completo_cliente="";
 		this.nombre_transaccion="";
 		this.numero_comprobante="";
 		this.numero_factura="";
 		this.numero_secuencial="";
 		this.fecha_emision=new Date();
 		this.nombre_producto="";
 		this.nombre_unidad="";
 		this.cantidad=0;
 		this.iva=0.0;
 		this.costo_unitario=0.0;
 		this.costo_total=0.0;
 		this.ice=0.0;
 		this.codigo_producto="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.cliente=null;
		this.transaccion=null;
		this.linea=null;
		this.lineagrupo=null;
		this.lineacategoria=null;
		this.lineamarca=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.cliente_descripcion="";
		this.transaccion_descripcion="";
		this.linea_descripcion="";
		this.lineagrupo_descripcion="";
		this.lineacategoria_descripcion="";
		this.lineamarca_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MovimientosDetallados (Long id,Date versionRow,String nombre_sucursal,String nombre_completo_cliente,String nombre_transaccion,String numero_comprobante,String numero_factura,String numero_secuencial,Date fecha_emision,String nombre_producto,String nombre_unidad,Integer cantidad,Double iva,Double costo_unitario,Double costo_total,Double ice,String codigo_producto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientosdetalladosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.nombre_producto=nombre_producto;
 		this.nombre_unidad=nombre_unidad;
 		this.cantidad=cantidad;
 		this.iva=iva;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.ice=ice;
 		this.codigo_producto=codigo_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MovimientosDetallados (String nombre_sucursal,String nombre_completo_cliente,String nombre_transaccion,String numero_comprobante,String numero_factura,String numero_secuencial,Date fecha_emision,String nombre_producto,String nombre_unidad,Integer cantidad,Double iva,Double costo_unitario,Double costo_total,Double ice,String codigo_producto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.movimientosdetalladosOriginal=this;
		
 		this.nombre_sucursal=nombre_sucursal;
 		this.nombre_completo_cliente=nombre_completo_cliente;
 		this.nombre_transaccion=nombre_transaccion;
 		this.numero_comprobante=numero_comprobante;
 		this.numero_factura=numero_factura;
 		this.numero_secuencial=numero_secuencial;
 		this.fecha_emision=fecha_emision;
 		this.nombre_producto=nombre_producto;
 		this.nombre_unidad=nombre_unidad;
 		this.cantidad=cantidad;
 		this.iva=iva;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.ice=ice;
 		this.codigo_producto=codigo_producto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public MovimientosDetallados getMovimientosDetalladosOriginal() {
		return this.movimientosdetalladosOriginal;
	}
	
	public void setMovimientosDetalladosOriginal(MovimientosDetallados movimientosdetallados) {
		try {
			this.movimientosdetalladosOriginal=movimientosdetallados;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MovimientosDetalladosAdditional movimientosdetalladosAdditional=null;
	
	public MovimientosDetalladosAdditional getMovimientosDetalladosAdditional() {
		return this.movimientosdetalladosAdditional;
	}
	
	public void setMovimientosDetalladosAdditional(MovimientosDetalladosAdditional movimientosdetalladosAdditional) {
		try {
			this.movimientosdetalladosAdditional=movimientosdetalladosAdditional;
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
    
	
	public Long getid_cliente() {
		return this.id_cliente;
	}
    
	
	public Long getid_transaccion() {
		return this.id_transaccion;
	}
    
	
	public Long getid_linea() {
		return this.id_linea;
	}
    
	
	public Long getid_linea_grupo() {
		return this.id_linea_grupo;
	}
    
	
	public Long getid_linea_categoria() {
		return this.id_linea_categoria;
	}
    
	
	public Long getid_linea_marca() {
		return this.id_linea_marca;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getnombre_completo_cliente() {
		return this.nombre_completo_cliente;
	}
    
	
	public String getnombre_transaccion() {
		return this.nombre_transaccion;
	}
    
	
	public String getnumero_comprobante() {
		return this.numero_comprobante;
	}
    
	
	public String getnumero_factura() {
		return this.numero_factura;
	}
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public Date getfecha_emision() {
		return this.fecha_emision;
	}
    
	
	public String getnombre_producto() {
		return this.nombre_producto;
	}
    
	
	public String getnombre_unidad() {
		return this.nombre_unidad;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public Double getcosto_unitario() {
		return this.costo_unitario;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
	}
    
	
	public Double getice() {
		return this.ice;
	}
    
	
	public String getcodigo_producto() {
		return this.codigo_producto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_cliente");
					}
				}

				this.id_cliente=newid_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_transaccion(Long newid_transaccion)throws Exception
	{
		try {
			if(this.id_transaccion!=newid_transaccion) {
				if(newid_transaccion==null) {
					//newid_transaccion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_transaccion");
					}
				}

				this.id_transaccion=newid_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea(Long newid_linea)throws Exception
	{
		try {
			if(this.id_linea!=newid_linea) {
				if(newid_linea==null) {
					//newid_linea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_linea");
					}
				}

				this.id_linea=newid_linea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_grupo(Long newid_linea_grupo)throws Exception
	{
		try {
			if(this.id_linea_grupo!=newid_linea_grupo) {
				if(newid_linea_grupo==null) {
					//newid_linea_grupo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_linea_grupo");
					}
				}

				this.id_linea_grupo=newid_linea_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_categoria(Long newid_linea_categoria)throws Exception
	{
		try {
			if(this.id_linea_categoria!=newid_linea_categoria) {
				if(newid_linea_categoria==null) {
					//newid_linea_categoria=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_linea_categoria");
					}
				}

				this.id_linea_categoria=newid_linea_categoria;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_linea_marca(Long newid_linea_marca)throws Exception
	{
		try {
			if(this.id_linea_marca!=newid_linea_marca) {
				if(newid_linea_marca==null) {
					//newid_linea_marca=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna id_linea_marca");
					}
				}

				this.id_linea_marca=newid_linea_marca;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna fecha_emision_desde");
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna nombre_completo_cliente");
					}
				}

				if(newnombre_completo_cliente!=null&&newnombre_completo_cliente.length()>150) {
					newnombre_completo_cliente=newnombre_completo_cliente.substring(0,148);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_completo_cliente");
				}

				this.nombre_completo_cliente=newnombre_completo_cliente;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_transaccion(String newnombre_transaccion)throws Exception
	{
		try {
			if(this.nombre_transaccion!=newnombre_transaccion) {
				if(newnombre_transaccion==null) {
					//newnombre_transaccion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna nombre_transaccion");
					}
				}

				if(newnombre_transaccion!=null&&newnombre_transaccion.length()>150) {
					newnombre_transaccion=newnombre_transaccion.substring(0,148);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_transaccion");
				}

				this.nombre_transaccion=newnombre_transaccion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_comprobante(String newnumero_comprobante)throws Exception
	{
		try {
			if(this.numero_comprobante!=newnumero_comprobante) {
				if(newnumero_comprobante==null) {
					//newnumero_comprobante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna numero_comprobante");
					}
				}

				if(newnumero_comprobante!=null&&newnumero_comprobante.length()>50) {
					newnumero_comprobante=newnumero_comprobante.substring(0,48);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_comprobante");
				}

				this.numero_comprobante=newnumero_comprobante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_factura(String newnumero_factura)throws Exception
	{
		try {
			if(this.numero_factura!=newnumero_factura) {
				if(newnumero_factura==null) {
					//newnumero_factura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna numero_factura");
					}
				}

				if(newnumero_factura!=null&&newnumero_factura.length()>50) {
					newnumero_factura=newnumero_factura.substring(0,48);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_factura");
				}

				this.numero_factura=newnumero_factura;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna fecha_emision");
					}
				}

				this.fecha_emision=newfecha_emision;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna nombre_producto");
					}
				}

				if(newnombre_producto!=null&&newnombre_producto.length()>150) {
					newnombre_producto=newnombre_producto.substring(0,148);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_producto");
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna nombre_unidad");
					}
				}

				if(newnombre_unidad!=null&&newnombre_unidad.length()>50) {
					newnombre_unidad=newnombre_unidad.substring(0,48);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_unidad");
				}

				this.nombre_unidad=newnombre_unidad;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_unitario(Double newcosto_unitario)throws Exception
	{
		try {
			if(this.costo_unitario!=newcosto_unitario) {
				if(newcosto_unitario==null) {
					//newcosto_unitario=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna costo_unitario");
					}
				}

				this.costo_unitario=newcosto_unitario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_total(Double newcosto_total)throws Exception
	{
		try {
			if(this.costo_total!=newcosto_total) {
				if(newcosto_total==null) {
					//newcosto_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna ice");
					}
				}

				this.ice=newice;
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
						System.out.println("MovimientosDetallados:Valor nulo no permitido en columna codigo_producto");
					}
				}

				if(newcodigo_producto!=null&&newcodigo_producto.length()>50) {
					newcodigo_producto=newcodigo_producto.substring(0,48);
					System.out.println("MovimientosDetallados:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_producto");
				}

				this.codigo_producto=newcodigo_producto;
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

	public Cliente getCliente() {
		return this.cliente;
	}

	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	public Linea getLinea() {
		return this.linea;
	}

	public Linea getLineaGrupo() {
		return this.lineagrupo;
	}

	public Linea getLineaCategoria() {
		return this.lineacategoria;
	}

	public Linea getLineaMarca() {
		return this.lineamarca;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getcliente_descripcion() {
		return this.cliente_descripcion;
	}

	public String gettransaccion_descripcion() {
		return this.transaccion_descripcion;
	}

	public String getlinea_descripcion() {
		return this.linea_descripcion;
	}

	public String getlineagrupo_descripcion() {
		return this.lineagrupo_descripcion;
	}

	public String getlineacategoria_descripcion() {
		return this.lineacategoria_descripcion;
	}

	public String getlineamarca_descripcion() {
		return this.lineamarca_descripcion;
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


	public  void  setCliente(Cliente cliente) {
		try {
			this.cliente=cliente;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTransaccion(Transaccion transaccion) {
		try {
			this.transaccion=transaccion;
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


	public  void  setLineaGrupo(Linea lineagrupo) {
		try {
			this.lineagrupo=lineagrupo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaCategoria(Linea lineacategoria) {
		try {
			this.lineacategoria=lineacategoria;
		} catch(Exception e) {
			;
		}
	}


	public  void  setLineaMarca(Linea lineamarca) {
		try {
			this.lineamarca=lineamarca;
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


	public  void  setcliente_descripcion(String cliente_descripcion) {
		try {
			this.cliente_descripcion=cliente_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settransaccion_descripcion(String transaccion_descripcion) {
		try {
			this.transaccion_descripcion=transaccion_descripcion;
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


	public  void  setlineagrupo_descripcion(String lineagrupo_descripcion) {
		try {
			this.lineagrupo_descripcion=lineagrupo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineacategoria_descripcion(String lineacategoria_descripcion) {
		try {
			this.lineacategoria_descripcion=lineacategoria_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setlineamarca_descripcion(String lineamarca_descripcion) {
		try {
			this.lineamarca_descripcion=lineamarca_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_cliente_descripcion="";String id_transaccion_descripcion="";String id_linea_descripcion="";String id_linea_grupo_descripcion="";String id_linea_categoria_descripcion="";String id_linea_marca_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_cliente_descripcion() {
		return id_cliente_descripcion;
	}
	public String getid_transaccion_descripcion() {
		return id_transaccion_descripcion;
	}
	public String getid_linea_descripcion() {
		return id_linea_descripcion;
	}
	public String getid_linea_grupo_descripcion() {
		return id_linea_grupo_descripcion;
	}
	public String getid_linea_categoria_descripcion() {
		return id_linea_categoria_descripcion;
	}
	public String getid_linea_marca_descripcion() {
		return id_linea_marca_descripcion;
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
	public void setid_cliente_descripcion(String newid_cliente_descripcion)throws Exception {
		try {
			this.id_cliente_descripcion=newid_cliente_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_transaccion_descripcion(String newid_transaccion_descripcion)throws Exception {
		try {
			this.id_transaccion_descripcion=newid_transaccion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_descripcion(String newid_linea_descripcion)throws Exception {
		try {
			this.id_linea_descripcion=newid_linea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_grupo_descripcion(String newid_linea_grupo_descripcion)throws Exception {
		try {
			this.id_linea_grupo_descripcion=newid_linea_grupo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_categoria_descripcion(String newid_linea_categoria_descripcion)throws Exception {
		try {
			this.id_linea_categoria_descripcion=newid_linea_categoria_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_linea_marca_descripcion(String newid_linea_marca_descripcion)throws Exception {
		try {
			this.id_linea_marca_descripcion=newid_linea_marca_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_cliente_descripcion="";this.id_transaccion_descripcion="";this.id_linea_descripcion="";this.id_linea_grupo_descripcion="";this.id_linea_categoria_descripcion="";this.id_linea_marca_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

