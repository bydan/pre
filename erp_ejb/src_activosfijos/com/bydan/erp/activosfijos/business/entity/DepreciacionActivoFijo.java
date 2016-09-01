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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DepreciacionActivoFijo extends DepreciacionActivoFijoAdditional implements Serializable ,Cloneable {//DepreciacionActivoFijoAdditional,GeneralEntity
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
	
	private DepreciacionActivoFijo depreciacionactivofijoOriginal;
	
	private Map<String, Object> mapDepreciacionActivoFijo;
			
	public Map<String, Object> getMapDepreciacionActivoFijo() {
		return mapDepreciacionActivoFijo;
	}

	public void setMapDepreciacionActivoFijo(Map<String, Object> mapDepreciacionActivoFijo) {
		this.mapDepreciacionActivoFijo = mapDepreciacionActivoFijo;
	}
	
	public void inicializarMapDepreciacionActivoFijo() {
		this.mapDepreciacionActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapDepreciacionActivoFijoValue(String sKey,Object oValue) {
		this.mapDepreciacionActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapDepreciacionActivoFijoValue(String sKey) {
		return this.mapDepreciacionActivoFijo.get(sKey);
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
	private Long id_detalle_activo_fijo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_depreciacion_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_depre_acti;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_depre_acti;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_acumulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_gasto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleActivoFijo detalleactivofijo;
	public TipoDepreciacionEmpresa tipodepreciacionempresa;
	public EstadoDepreActi estadodepreacti;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detalleactivofijo_descripcion;
	private String tipodepreciacionempresa_descripcion;
	private String estadodepreacti_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public DepreciacionActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.depreciacionactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_activo_fijo=-1L;
 		this.id_tipo_depreciacion_empresa=-1L;
 		this.id_estado_depre_acti=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.fecha_compra=new Date();
 		this.fecha_depre_acti=new Date();
 		this.porcentaje=0.0;
 		this.costo=0.0;
 		this.valor_acumulado=0.0;
 		this.valor_total=0.0;
 		this.valor_gasto=0.0;
 		this.fecha=new Date();
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detalleactivofijo=null;
		this.tipodepreciacionempresa=null;
		this.estadodepreacti=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detalleactivofijo_descripcion="";
		this.tipodepreciacionempresa_descripcion="";
		this.estadodepreacti_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DepreciacionActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_tipo_depreciacion_empresa,Long id_estado_depre_acti,Long id_anio,Long id_mes,Date fecha_compra,Date fecha_depre_acti,Double porcentaje,Double costo,Double valor_acumulado,Double valor_total,Double valor_gasto,Date fecha) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.depreciacionactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_tipo_depreciacion_empresa=id_tipo_depreciacion_empresa;
 		this.id_estado_depre_acti=id_estado_depre_acti;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha_compra=fecha_compra;
 		this.fecha_depre_acti=fecha_depre_acti;
 		this.porcentaje=porcentaje;
 		this.costo=costo;
 		this.valor_acumulado=valor_acumulado;
 		this.valor_total=valor_total;
 		this.valor_gasto=valor_gasto;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DepreciacionActivoFijo (Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_tipo_depreciacion_empresa,Long id_estado_depre_acti,Long id_anio,Long id_mes,Date fecha_compra,Date fecha_depre_acti,Double porcentaje,Double costo,Double valor_acumulado,Double valor_total,Double valor_gasto,Date fecha) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.depreciacionactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_tipo_depreciacion_empresa=id_tipo_depreciacion_empresa;
 		this.id_estado_depre_acti=id_estado_depre_acti;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.fecha_compra=fecha_compra;
 		this.fecha_depre_acti=fecha_depre_acti;
 		this.porcentaje=porcentaje;
 		this.costo=costo;
 		this.valor_acumulado=valor_acumulado;
 		this.valor_total=valor_total;
 		this.valor_gasto=valor_gasto;
 		this.fecha=fecha;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DepreciacionActivoFijo depreciacionactivofijoLocal=null;
		
		if(object!=null) {
			depreciacionactivofijoLocal=(DepreciacionActivoFijo)object;
			
			if(depreciacionactivofijoLocal!=null) {
				if(this.getId()!=null && depreciacionactivofijoLocal.getId()!=null) {
					if(this.getId().equals(depreciacionactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DepreciacionActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DepreciacionActivoFijoConstantesFunciones.getDepreciacionActivoFijoDescripcion(this);
		} else {
			sDetalle=DepreciacionActivoFijoConstantesFunciones.getDepreciacionActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DepreciacionActivoFijo getDepreciacionActivoFijoOriginal() {
		return this.depreciacionactivofijoOriginal;
	}
	
	public void setDepreciacionActivoFijoOriginal(DepreciacionActivoFijo depreciacionactivofijo) {
		try {
			this.depreciacionactivofijoOriginal=depreciacionactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DepreciacionActivoFijoAdditional depreciacionactivofijoAdditional=null;
	
	public DepreciacionActivoFijoAdditional getDepreciacionActivoFijoAdditional() {
		return this.depreciacionactivofijoAdditional;
	}
	
	public void setDepreciacionActivoFijoAdditional(DepreciacionActivoFijoAdditional depreciacionactivofijoAdditional) {
		try {
			this.depreciacionactivofijoAdditional=depreciacionactivofijoAdditional;
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
    
	
	public Long getid_detalle_activo_fijo() {
		return this.id_detalle_activo_fijo;
	}
    
	
	public Long getid_tipo_depreciacion_empresa() {
		return this.id_tipo_depreciacion_empresa;
	}
    
	
	public Long getid_estado_depre_acti() {
		return this.id_estado_depre_acti;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Date getfecha_compra() {
		return this.fecha_compra;
	}
    
	
	public Date getfecha_depre_acti() {
		return this.fecha_depre_acti;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public Double getvalor_acumulado() {
		return this.valor_acumulado;
	}
    
	
	public Double getvalor_total() {
		return this.valor_total;
	}
    
	
	public Double getvalor_gasto() {
		return this.valor_gasto;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_detalle_activo_fijo(Long newid_detalle_activo_fijo)throws Exception
	{
		try {
			if(this.id_detalle_activo_fijo!=newid_detalle_activo_fijo) {
				if(newid_detalle_activo_fijo==null) {
					//newid_detalle_activo_fijo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna id_detalle_activo_fijo");
					}
				}

				this.id_detalle_activo_fijo=newid_detalle_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_depreciacion_empresa(Long newid_tipo_depreciacion_empresa)throws Exception
	{
		try {
			if(this.id_tipo_depreciacion_empresa!=newid_tipo_depreciacion_empresa) {
				if(newid_tipo_depreciacion_empresa==null) {
					//newid_tipo_depreciacion_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna id_tipo_depreciacion_empresa");
					}
				}

				this.id_tipo_depreciacion_empresa=newid_tipo_depreciacion_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_depre_acti(Long newid_estado_depre_acti)throws Exception
	{
		try {
			if(this.id_estado_depre_acti!=newid_estado_depre_acti) {
				if(newid_estado_depre_acti==null) {
					//newid_estado_depre_acti=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna id_estado_depre_acti");
					}
				}

				this.id_estado_depre_acti=newid_estado_depre_acti;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}
	}
    
	public void setid_mes(Long newid_mes) {
		if(this.id_mes==null&&newid_mes!=null) {
			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}

		if(this.id_mes!=null&&!this.id_mes.equals(newid_mes)) {

			this.id_mes=newid_mes;
				this.setIsChanged(true);
		}
	}
    
	public void setfecha_compra(Date newfecha_compra)throws Exception
	{
		try {
			if(this.fecha_compra!=newfecha_compra) {
				if(newfecha_compra==null) {
					//newfecha_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna fecha_compra");
					}
				}

				this.fecha_compra=newfecha_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_depre_acti(Date newfecha_depre_acti)throws Exception
	{
		try {
			if(this.fecha_depre_acti!=newfecha_depre_acti) {
				if(newfecha_depre_acti==null) {
					//newfecha_depre_acti=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna fecha_depre_acti");
					}
				}

				this.fecha_depre_acti=newfecha_depre_acti;
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
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
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
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_acumulado(Double newvalor_acumulado)throws Exception
	{
		try {
			if(this.valor_acumulado!=newvalor_acumulado) {
				if(newvalor_acumulado==null) {
					//newvalor_acumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna valor_acumulado");
					}
				}

				this.valor_acumulado=newvalor_acumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_total(Double newvalor_total)throws Exception
	{
		try {
			if(this.valor_total!=newvalor_total) {
				if(newvalor_total==null) {
					//newvalor_total=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna valor_total");
					}
				}

				this.valor_total=newvalor_total;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_gasto(Double newvalor_gasto)throws Exception
	{
		try {
			if(this.valor_gasto!=newvalor_gasto) {
				if(newvalor_gasto==null) {
					//newvalor_gasto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna valor_gasto");
					}
				}

				this.valor_gasto=newvalor_gasto;
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
						System.out.println("DepreciacionActivoFijo:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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

	public DetalleActivoFijo getDetalleActivoFijo() {
		return this.detalleactivofijo;
	}

	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresa() {
		return this.tipodepreciacionempresa;
	}

	public EstadoDepreActi getEstadoDepreActi() {
		return this.estadodepreacti;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getdetalleactivofijo_descripcion() {
		return this.detalleactivofijo_descripcion;
	}

	public String gettipodepreciacionempresa_descripcion() {
		return this.tipodepreciacionempresa_descripcion;
	}

	public String getestadodepreacti_descripcion() {
		return this.estadodepreacti_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	public  void  setDetalleActivoFijo(DetalleActivoFijo detalleactivofijo) {
		try {
			this.detalleactivofijo=detalleactivofijo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		try {
			this.tipodepreciacionempresa=tipodepreciacionempresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoDepreActi(EstadoDepreActi estadodepreacti) {
		try {
			this.estadodepreacti=estadodepreacti;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMes(Mes mes) {
		try {
			this.mes=mes;
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


	public  void  setdetalleactivofijo_descripcion(String detalleactivofijo_descripcion) {
		try {
			this.detalleactivofijo_descripcion=detalleactivofijo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipodepreciacionempresa_descripcion(String tipodepreciacionempresa_descripcion) {
		try {
			this.tipodepreciacionempresa_descripcion=tipodepreciacionempresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadodepreacti_descripcion(String estadodepreacti_descripcion) {
		try {
			this.estadodepreacti_descripcion=estadodepreacti_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmes_descripcion(String mes_descripcion) {
		try {
			this.mes_descripcion=mes_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_activo_fijo_descripcion="";String id_tipo_depreciacion_empresa_descripcion="";String id_estado_depre_acti_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_activo_fijo_descripcion() {
		return id_detalle_activo_fijo_descripcion;
	}
	public String getid_tipo_depreciacion_empresa_descripcion() {
		return id_tipo_depreciacion_empresa_descripcion;
	}
	public String getid_estado_depre_acti_descripcion() {
		return id_estado_depre_acti_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
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
	public void setid_detalle_activo_fijo_descripcion(String newid_detalle_activo_fijo_descripcion)throws Exception {
		try {
			this.id_detalle_activo_fijo_descripcion=newid_detalle_activo_fijo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_depreciacion_empresa_descripcion(String newid_tipo_depreciacion_empresa_descripcion)throws Exception {
		try {
			this.id_tipo_depreciacion_empresa_descripcion=newid_tipo_depreciacion_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_depre_acti_descripcion(String newid_estado_depre_acti_descripcion)throws Exception {
		try {
			this.id_estado_depre_acti_descripcion=newid_estado_depre_acti_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_descripcion(String newid_mes_descripcion)throws Exception {
		try {
			this.id_mes_descripcion=newid_mes_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_activo_fijo_descripcion="";this.id_tipo_depreciacion_empresa_descripcion="";this.id_estado_depre_acti_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

