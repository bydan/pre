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
//import com.bydan.erp.activosfijos.util.MantenimientoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class MantenimientoActivoFijo extends MantenimientoActivoFijoAdditional implements Serializable ,Cloneable {//MantenimientoActivoFijoAdditional,GeneralEntity
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
	
	private MantenimientoActivoFijo mantenimientoactivofijoOriginal;
	
	private Map<String, Object> mapMantenimientoActivoFijo;
			
	public Map<String, Object> getMapMantenimientoActivoFijo() {
		return mapMantenimientoActivoFijo;
	}

	public void setMapMantenimientoActivoFijo(Map<String, Object> mapMantenimientoActivoFijo) {
		this.mapMantenimientoActivoFijo = mapMantenimientoActivoFijo;
	}
	
	public void inicializarMapMantenimientoActivoFijo() {
		this.mapMantenimientoActivoFijo = new HashMap<String,Object>();
	}
	
	public void setMapMantenimientoActivoFijoValue(String sKey,Object oValue) {
		this.mapMantenimientoActivoFijo.put(sKey, oValue);
	}
	
	public Object getMapMantenimientoActivoFijoValue(String sKey) {
		return this.mapMantenimientoActivoFijo.get(sKey);
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
	private Long id_tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXCAUSA,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXCAUSA)
	private String causa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXREFERENCIA,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXTALLER,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXTALLER)
	private String taller;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXTELEFONO,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXTELEFONO)
	private String telefono;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_entrega;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXRESPONSABLE,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXRESPONSABLE)
	private String responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=MantenimientoActivoFijoConstantesFunciones.SREGEXOBSERVACION,message=MantenimientoActivoFijoConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public DetalleActivoFijo detalleactivofijo;
	public TipoMovimiento tipomovimiento;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String detalleactivofijo_descripcion;
	private String tipomovimiento_descripcion;
	
	
		
	public MantenimientoActivoFijo () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.mantenimientoactivofijoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_detalle_activo_fijo=-1L;
 		this.id_tipo_movimiento=-1L;
 		this.numero_documento="";
 		this.causa="";
 		this.referencia="";
 		this.taller="";
 		this.telefono="";
 		this.fecha_inicio=new Date();
 		this.fecha_entrega=new Date();
 		this.costo=0.0;
 		this.responsable="";
 		this.observacion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.detalleactivofijo=null;
		this.tipomovimiento=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.detalleactivofijo_descripcion="";
		this.tipomovimiento_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MantenimientoActivoFijo (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_tipo_movimiento,String numero_documento,String causa,String referencia,String taller,String telefono,Date fecha_inicio,Date fecha_entrega,Double costo,String responsable,String observacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mantenimientoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_documento=numero_documento;
 		this.causa=causa;
 		this.referencia=referencia;
 		this.taller=taller;
 		this.telefono=telefono;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_entrega=fecha_entrega;
 		this.costo=costo;
 		this.responsable=responsable;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MantenimientoActivoFijo (Long id_empresa,Long id_sucursal,Long id_detalle_activo_fijo,Long id_tipo_movimiento,String numero_documento,String causa,String referencia,String taller,String telefono,Date fecha_inicio,Date fecha_entrega,Double costo,String responsable,String observacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mantenimientoactivofijoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_detalle_activo_fijo=id_detalle_activo_fijo;
 		this.id_tipo_movimiento=id_tipo_movimiento;
 		this.numero_documento=numero_documento;
 		this.causa=causa;
 		this.referencia=referencia;
 		this.taller=taller;
 		this.telefono=telefono;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_entrega=fecha_entrega;
 		this.costo=costo;
 		this.responsable=responsable;
 		this.observacion=observacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		MantenimientoActivoFijo mantenimientoactivofijoLocal=null;
		
		if(object!=null) {
			mantenimientoactivofijoLocal=(MantenimientoActivoFijo)object;
			
			if(mantenimientoactivofijoLocal!=null) {
				if(this.getId()!=null && mantenimientoactivofijoLocal.getId()!=null) {
					if(this.getId().equals(mantenimientoactivofijoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!MantenimientoActivoFijoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=MantenimientoActivoFijoConstantesFunciones.getMantenimientoActivoFijoDescripcion(this);
		} else {
			sDetalle=MantenimientoActivoFijoConstantesFunciones.getMantenimientoActivoFijoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public MantenimientoActivoFijo getMantenimientoActivoFijoOriginal() {
		return this.mantenimientoactivofijoOriginal;
	}
	
	public void setMantenimientoActivoFijoOriginal(MantenimientoActivoFijo mantenimientoactivofijo) {
		try {
			this.mantenimientoactivofijoOriginal=mantenimientoactivofijo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MantenimientoActivoFijoAdditional mantenimientoactivofijoAdditional=null;
	
	public MantenimientoActivoFijoAdditional getMantenimientoActivoFijoAdditional() {
		return this.mantenimientoactivofijoAdditional;
	}
	
	public void setMantenimientoActivoFijoAdditional(MantenimientoActivoFijoAdditional mantenimientoactivofijoAdditional) {
		try {
			this.mantenimientoactivofijoAdditional=mantenimientoactivofijoAdditional;
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
    
	
	public Long getid_tipo_movimiento() {
		return this.id_tipo_movimiento;
	}
    
	
	public String getnumero_documento() {
		return this.numero_documento;
	}
    
	
	public String getcausa() {
		return this.causa;
	}
    
	
	public String getreferencia() {
		return this.referencia;
	}
    
	
	public String gettaller() {
		return this.taller;
	}
    
	
	public String gettelefono() {
		return this.telefono;
	}
    
	
	public Date getfecha_inicio() {
		return this.fecha_inicio;
	}
    
	
	public Date getfecha_entrega() {
		return this.fecha_entrega;
	}
    
	
	public Double getcosto() {
		return this.costo;
	}
    
	
	public String getresponsable() {
		return this.responsable;
	}
    
	
	public String getobservacion() {
		return this.observacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna id_sucursal");
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
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna id_detalle_activo_fijo");
					}
				}

				this.id_detalle_activo_fijo=newid_detalle_activo_fijo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_movimiento(Long newid_tipo_movimiento)throws Exception
	{
		try {
			if(this.id_tipo_movimiento!=newid_tipo_movimiento) {
				if(newid_tipo_movimiento==null) {
					//newid_tipo_movimiento=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna id_tipo_movimiento");
					}
				}

				this.id_tipo_movimiento=newid_tipo_movimiento;
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
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
				}

				this.numero_documento=newnumero_documento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcausa(String newcausa)throws Exception
	{
		try {
			if(this.causa!=newcausa) {
				if(newcausa==null) {
					//newcausa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna causa");
					}
				}

				if(newcausa!=null&&newcausa.length()>250) {
					newcausa=newcausa.substring(0,248);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna causa");
				}

				this.causa=newcausa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setreferencia(String newreferencia)throws Exception
	{
		try {
			if(this.referencia!=newreferencia) {
				if(newreferencia==null) {
					//newreferencia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>200) {
					newreferencia=newreferencia.substring(0,198);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna referencia");
				}

				this.referencia=newreferencia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settaller(String newtaller)throws Exception
	{
		try {
			if(this.taller!=newtaller) {
				if(newtaller==null) {
					//newtaller="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna taller");
					}
				}

				if(newtaller!=null&&newtaller.length()>200) {
					newtaller=newtaller.substring(0,198);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna taller");
				}

				this.taller=newtaller;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settelefono(String newtelefono)throws Exception
	{
		try {
			if(this.telefono!=newtelefono) {
				if(newtelefono==null) {
					//newtelefono="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna telefono");
					}
				}

				if(newtelefono!=null&&newtelefono.length()>100) {
					newtelefono=newtelefono.substring(0,98);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna telefono");
				}

				this.telefono=newtelefono;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_inicio(Date newfecha_inicio)throws Exception
	{
		try {
			if(this.fecha_inicio!=newfecha_inicio) {
				if(newfecha_inicio==null) {
					//newfecha_inicio=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna fecha_inicio");
					}
				}

				this.fecha_inicio=newfecha_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_entrega(Date newfecha_entrega)throws Exception
	{
		try {
			if(this.fecha_entrega!=newfecha_entrega) {
				if(newfecha_entrega==null) {
					//newfecha_entrega=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna fecha_entrega");
					}
				}

				this.fecha_entrega=newfecha_entrega;
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
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna costo");
					}
				}

				this.costo=newcosto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setresponsable(String newresponsable)throws Exception
	{
		try {
			if(this.responsable!=newresponsable) {
				if(newresponsable==null) {
					//newresponsable="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna responsable");
					}
				}

				if(newresponsable!=null&&newresponsable.length()>250) {
					newresponsable=newresponsable.substring(0,248);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna responsable");
				}

				this.responsable=newresponsable;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setobservacion(String newobservacion)throws Exception
	{
		try {
			if(this.observacion!=newobservacion) {
				if(newobservacion==null) {
					//newobservacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoActivoFijo:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("MantenimientoActivoFijo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
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

	public TipoMovimiento getTipoMovimiento() {
		return this.tipomovimiento;
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

	public String gettipomovimiento_descripcion() {
		return this.tipomovimiento_descripcion;
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


	public  void  setTipoMovimiento(TipoMovimiento tipomovimiento) {
		try {
			this.tipomovimiento=tipomovimiento;
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


	public  void  settipomovimiento_descripcion(String tipomovimiento_descripcion) {
		try {
			this.tipomovimiento_descripcion=tipomovimiento_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_detalle_activo_fijo_descripcion="";String id_tipo_movimiento_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_detalle_activo_fijo_descripcion() {
		return id_detalle_activo_fijo_descripcion;
	}
	public String getid_tipo_movimiento_descripcion() {
		return id_tipo_movimiento_descripcion;
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
	public void setid_tipo_movimiento_descripcion(String newid_tipo_movimiento_descripcion)throws Exception {
		try {
			this.id_tipo_movimiento_descripcion=newid_tipo_movimiento_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_detalle_activo_fijo_descripcion="";this.id_tipo_movimiento_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

