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
package com.bydan.erp.facturacion.business.entity;

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
//import com.bydan.erp.facturacion.util.CuentaContableTipoConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class CuentaContableTipo extends CuentaContableTipoAdditional implements Serializable ,Cloneable {//CuentaContableTipoAdditional,GeneralEntity
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
	
	private CuentaContableTipo cuentacontabletipoOriginal;
	
	private Map<String, Object> mapCuentaContableTipo;
			
	public Map<String, Object> getMapCuentaContableTipo() {
		return mapCuentaContableTipo;
	}

	public void setMapCuentaContableTipo(Map<String, Object> mapCuentaContableTipo) {
		this.mapCuentaContableTipo = mapCuentaContableTipo;
	}
	
	public void inicializarMapCuentaContableTipo() {
		this.mapCuentaContableTipo = new HashMap<String,Object>();
	}
	
	public void setMapCuentaContableTipoValue(String sKey,Object oValue) {
		this.mapCuentaContableTipo.put(sKey, oValue);
	}
	
	public Object getMapCuentaContableTipoValue(String sKey) {
		return this.mapCuentaContableTipo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CuentaContableTipoConstantesFunciones.SREGEXNOMBRE,message=CuentaContableTipoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer digito_verificador;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_cuenta_contable_tipo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_producto_servicio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_venta;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_descuento;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_devolucion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_cuenta_contable_costo;
			
	
	public Empresa empresa;
	public TipoCuentaContableTipo tipocuentacontabletipo;
	public TipoProductoServicio tipoproductoservicio;
	public CuentaContable cuentacontableventa;
	public CuentaContable cuentacontabledescuento;
	public CuentaContable cuentacontabledevolucion;
	public CuentaContable cuentacontablecosto;
	
	
	private String empresa_descripcion;
	private String tipocuentacontabletipo_descripcion;
	private String tipoproductoservicio_descripcion;
	private String cuentacontableventa_descripcion;
	private String cuentacontabledescuento_descripcion;
	private String cuentacontabledevolucion_descripcion;
	private String cuentacontablecosto_descripcion;
	
	
		
	public CuentaContableTipo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cuentacontabletipoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.digito_verificador=0;
 		this.id_tipo_cuenta_contable_tipo=-1L;
 		this.id_tipo_producto_servicio=-1L;
 		this.id_cuenta_contable_venta=null;
 		this.id_cuenta_contable_descuento=null;
 		this.id_cuenta_contable_devolucion=null;
 		this.id_cuenta_contable_costo=null;
		
		
		this.empresa=null;
		this.tipocuentacontabletipo=null;
		this.tipoproductoservicio=null;
		this.cuentacontableventa=null;
		this.cuentacontabledescuento=null;
		this.cuentacontabledevolucion=null;
		this.cuentacontablecosto=null;
		
		
		this.empresa_descripcion="";
		this.tipocuentacontabletipo_descripcion="";
		this.tipoproductoservicio_descripcion="";
		this.cuentacontableventa_descripcion="";
		this.cuentacontabledescuento_descripcion="";
		this.cuentacontabledevolucion_descripcion="";
		this.cuentacontablecosto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CuentaContableTipo (Long id,Date versionRow,Long id_empresa,String nombre,Integer digito_verificador,Long id_tipo_cuenta_contable_tipo,Long id_tipo_producto_servicio,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_costo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontabletipoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.digito_verificador=digito_verificador;
 		this.id_tipo_cuenta_contable_tipo=id_tipo_cuenta_contable_tipo;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CuentaContableTipo (Long id_empresa,String nombre,Integer digito_verificador,Long id_tipo_cuenta_contable_tipo,Long id_tipo_producto_servicio,Long id_cuenta_contable_venta,Long id_cuenta_contable_descuento,Long id_cuenta_contable_devolucion,Long id_cuenta_contable_costo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cuentacontabletipoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.digito_verificador=digito_verificador;
 		this.id_tipo_cuenta_contable_tipo=id_tipo_cuenta_contable_tipo;
 		this.id_tipo_producto_servicio=id_tipo_producto_servicio;
 		this.id_cuenta_contable_venta=id_cuenta_contable_venta;
 		this.id_cuenta_contable_descuento=id_cuenta_contable_descuento;
 		this.id_cuenta_contable_devolucion=id_cuenta_contable_devolucion;
 		this.id_cuenta_contable_costo=id_cuenta_contable_costo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CuentaContableTipo cuentacontabletipoLocal=null;
		
		if(object!=null) {
			cuentacontabletipoLocal=(CuentaContableTipo)object;
			
			if(cuentacontabletipoLocal!=null) {
				if(this.getId()!=null && cuentacontabletipoLocal.getId()!=null) {
					if(this.getId().equals(cuentacontabletipoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CuentaContableTipoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CuentaContableTipoConstantesFunciones.getCuentaContableTipoDescripcion(this);
		} else {
			sDetalle=CuentaContableTipoConstantesFunciones.getCuentaContableTipoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CuentaContableTipo getCuentaContableTipoOriginal() {
		return this.cuentacontabletipoOriginal;
	}
	
	public void setCuentaContableTipoOriginal(CuentaContableTipo cuentacontabletipo) {
		try {
			this.cuentacontabletipoOriginal=cuentacontabletipo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CuentaContableTipoAdditional cuentacontabletipoAdditional=null;
	
	public CuentaContableTipoAdditional getCuentaContableTipoAdditional() {
		return this.cuentacontabletipoAdditional;
	}
	
	public void setCuentaContableTipoAdditional(CuentaContableTipoAdditional cuentacontabletipoAdditional) {
		try {
			this.cuentacontabletipoAdditional=cuentacontabletipoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Integer getdigito_verificador() {
		return this.digito_verificador;
	}
    
	
	public Long getid_tipo_cuenta_contable_tipo() {
		return this.id_tipo_cuenta_contable_tipo;
	}
    
	
	public Long getid_tipo_producto_servicio() {
		return this.id_tipo_producto_servicio;
	}
    
	
	public Long getid_cuenta_contable_venta() {
		return this.id_cuenta_contable_venta;
	}
    
	
	public Long getid_cuenta_contable_descuento() {
		return this.id_cuenta_contable_descuento;
	}
    
	
	public Long getid_cuenta_contable_devolucion() {
		return this.id_cuenta_contable_devolucion;
	}
    
	
	public Long getid_cuenta_contable_costo() {
		return this.id_cuenta_contable_costo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContableTipo:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("CuentaContableTipo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("CuentaContableTipo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdigito_verificador(Integer newdigito_verificador)throws Exception
	{
		try {
			if(this.digito_verificador!=newdigito_verificador) {
				if(newdigito_verificador==null) {
					//newdigito_verificador=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContableTipo:Valor nulo no permitido en columna digito_verificador");
					}
				}

				this.digito_verificador=newdigito_verificador;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_cuenta_contable_tipo(Long newid_tipo_cuenta_contable_tipo)throws Exception
	{
		try {
			if(this.id_tipo_cuenta_contable_tipo!=newid_tipo_cuenta_contable_tipo) {
				if(newid_tipo_cuenta_contable_tipo==null) {
					//newid_tipo_cuenta_contable_tipo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContableTipo:Valor nulo no permitido en columna id_tipo_cuenta_contable_tipo");
					}
				}

				this.id_tipo_cuenta_contable_tipo=newid_tipo_cuenta_contable_tipo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_producto_servicio(Long newid_tipo_producto_servicio)throws Exception
	{
		try {
			if(this.id_tipo_producto_servicio!=newid_tipo_producto_servicio) {
				if(newid_tipo_producto_servicio==null) {
					//newid_tipo_producto_servicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CuentaContableTipo:Valor nulo no permitido en columna id_tipo_producto_servicio");
					}
				}

				this.id_tipo_producto_servicio=newid_tipo_producto_servicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_cuenta_contable_venta(Long newid_cuenta_contable_venta) {
		if(this.id_cuenta_contable_venta==null&&newid_cuenta_contable_venta!=null) {
			this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_venta!=null&&!this.id_cuenta_contable_venta.equals(newid_cuenta_contable_venta)) {

			this.id_cuenta_contable_venta=newid_cuenta_contable_venta;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_descuento(Long newid_cuenta_contable_descuento) {
		if(this.id_cuenta_contable_descuento==null&&newid_cuenta_contable_descuento!=null) {
			this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_descuento!=null&&!this.id_cuenta_contable_descuento.equals(newid_cuenta_contable_descuento)) {

			this.id_cuenta_contable_descuento=newid_cuenta_contable_descuento;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_devolucion(Long newid_cuenta_contable_devolucion) {
		if(this.id_cuenta_contable_devolucion==null&&newid_cuenta_contable_devolucion!=null) {
			this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_devolucion!=null&&!this.id_cuenta_contable_devolucion.equals(newid_cuenta_contable_devolucion)) {

			this.id_cuenta_contable_devolucion=newid_cuenta_contable_devolucion;
				this.setIsChanged(true);
		}
	}
    
	public void setid_cuenta_contable_costo(Long newid_cuenta_contable_costo) {
		if(this.id_cuenta_contable_costo==null&&newid_cuenta_contable_costo!=null) {
			this.id_cuenta_contable_costo=newid_cuenta_contable_costo;
				this.setIsChanged(true);
		}

		if(this.id_cuenta_contable_costo!=null&&!this.id_cuenta_contable_costo.equals(newid_cuenta_contable_costo)) {

			this.id_cuenta_contable_costo=newid_cuenta_contable_costo;
				this.setIsChanged(true);
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoCuentaContableTipo getTipoCuentaContableTipo() {
		return this.tipocuentacontabletipo;
	}

	public TipoProductoServicio getTipoProductoServicio() {
		return this.tipoproductoservicio;
	}

	public CuentaContable getCuentaContableVenta() {
		return this.cuentacontableventa;
	}

	public CuentaContable getCuentaContableDescuento() {
		return this.cuentacontabledescuento;
	}

	public CuentaContable getCuentaContableDevolucion() {
		return this.cuentacontabledevolucion;
	}

	public CuentaContable getCuentaContableCosto() {
		return this.cuentacontablecosto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipocuentacontabletipo_descripcion() {
		return this.tipocuentacontabletipo_descripcion;
	}

	public String gettipoproductoservicio_descripcion() {
		return this.tipoproductoservicio_descripcion;
	}

	public String getcuentacontableventa_descripcion() {
		return this.cuentacontableventa_descripcion;
	}

	public String getcuentacontabledescuento_descripcion() {
		return this.cuentacontabledescuento_descripcion;
	}

	public String getcuentacontabledevolucion_descripcion() {
		return this.cuentacontabledevolucion_descripcion;
	}

	public String getcuentacontablecosto_descripcion() {
		return this.cuentacontablecosto_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCuentaContableTipo(TipoCuentaContableTipo tipocuentacontabletipo) {
		try {
			this.tipocuentacontabletipo=tipocuentacontabletipo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoProductoServicio(TipoProductoServicio tipoproductoservicio) {
		try {
			this.tipoproductoservicio=tipoproductoservicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableVenta(CuentaContable cuentacontableventa) {
		try {
			this.cuentacontableventa=cuentacontableventa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDescuento(CuentaContable cuentacontabledescuento) {
		try {
			this.cuentacontabledescuento=cuentacontabledescuento;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableDevolucion(CuentaContable cuentacontabledevolucion) {
		try {
			this.cuentacontabledevolucion=cuentacontabledevolucion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCuentaContableCosto(CuentaContable cuentacontablecosto) {
		try {
			this.cuentacontablecosto=cuentacontablecosto;
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


	public  void  settipocuentacontabletipo_descripcion(String tipocuentacontabletipo_descripcion) {
		try {
			this.tipocuentacontabletipo_descripcion=tipocuentacontabletipo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoproductoservicio_descripcion(String tipoproductoservicio_descripcion) {
		try {
			this.tipoproductoservicio_descripcion=tipoproductoservicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontableventa_descripcion(String cuentacontableventa_descripcion) {
		try {
			this.cuentacontableventa_descripcion=cuentacontableventa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledescuento_descripcion(String cuentacontabledescuento_descripcion) {
		try {
			this.cuentacontabledescuento_descripcion=cuentacontabledescuento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontabledevolucion_descripcion(String cuentacontabledevolucion_descripcion) {
		try {
			this.cuentacontabledevolucion_descripcion=cuentacontabledevolucion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcuentacontablecosto_descripcion(String cuentacontablecosto_descripcion) {
		try {
			this.cuentacontablecosto_descripcion=cuentacontablecosto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_cuenta_contable_tipo_descripcion="";String id_tipo_producto_servicio_descripcion="";String id_cuenta_contable_venta_descripcion="";String id_cuenta_contable_descuento_descripcion="";String id_cuenta_contable_devolucion_descripcion="";String id_cuenta_contable_costo_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_cuenta_contable_tipo_descripcion() {
		return id_tipo_cuenta_contable_tipo_descripcion;
	}
	public String getid_tipo_producto_servicio_descripcion() {
		return id_tipo_producto_servicio_descripcion;
	}
	public String getid_cuenta_contable_venta_descripcion() {
		return id_cuenta_contable_venta_descripcion;
	}
	public String getid_cuenta_contable_descuento_descripcion() {
		return id_cuenta_contable_descuento_descripcion;
	}
	public String getid_cuenta_contable_devolucion_descripcion() {
		return id_cuenta_contable_devolucion_descripcion;
	}
	public String getid_cuenta_contable_costo_descripcion() {
		return id_cuenta_contable_costo_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_cuenta_contable_tipo_descripcion(String newid_tipo_cuenta_contable_tipo_descripcion)throws Exception {
		try {
			this.id_tipo_cuenta_contable_tipo_descripcion=newid_tipo_cuenta_contable_tipo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_producto_servicio_descripcion(String newid_tipo_producto_servicio_descripcion)throws Exception {
		try {
			this.id_tipo_producto_servicio_descripcion=newid_tipo_producto_servicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_venta_descripcion(String newid_cuenta_contable_venta_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_venta_descripcion=newid_cuenta_contable_venta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_descuento_descripcion(String newid_cuenta_contable_descuento_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_descuento_descripcion=newid_cuenta_contable_descuento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_devolucion_descripcion(String newid_cuenta_contable_devolucion_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_devolucion_descripcion=newid_cuenta_contable_devolucion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_cuenta_contable_costo_descripcion(String newid_cuenta_contable_costo_descripcion)throws Exception {
		try {
			this.id_cuenta_contable_costo_descripcion=newid_cuenta_contable_costo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_cuenta_contable_tipo_descripcion="";this.id_tipo_producto_servicio_descripcion="";this.id_cuenta_contable_venta_descripcion="";this.id_cuenta_contable_descuento_descripcion="";this.id_cuenta_contable_devolucion_descripcion="";this.id_cuenta_contable_costo_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

