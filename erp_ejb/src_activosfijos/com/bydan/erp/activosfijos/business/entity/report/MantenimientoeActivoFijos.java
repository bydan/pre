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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.MantenimientoeActivoFijosConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class MantenimientoeActivoFijos extends MantenimientoeActivoFijosAdditional implements Serializable ,Cloneable {//MantenimientoeActivoFijosAdditional,GeneralEntity
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
	
	private MantenimientoeActivoFijos mantenimientoeactivofijosOriginal;
	
	private Map<String, Object> mapMantenimientoeActivoFijos;
			
	public Map<String, Object> getMapMantenimientoeActivoFijos() {
		return mapMantenimientoeActivoFijos;
	}

	public void setMapMantenimientoeActivoFijos(Map<String, Object> mapMantenimientoeActivoFijos) {
		this.mapMantenimientoeActivoFijos = mapMantenimientoeActivoFijos;
	}
	
	public void inicializarMapMantenimientoeActivoFijos() {
		this.mapMantenimientoeActivoFijos = new HashMap<String,Object>();
	}
	
	public void setMapMantenimientoeActivoFijosValue(String sKey,Object oValue) {
		this.mapMantenimientoeActivoFijos.put(sKey, oValue);
	}
	
	public Object getMapMantenimientoeActivoFijosValue(String sKey) {
		return this.mapMantenimientoeActivoFijos.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXNUMERO_DOCUMENTO,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXNUMERO_DOCUMENTO)
	private String numero_documento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXCAUSA,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXCAUSA)
	private String causa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXREFERENCIA,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXREFERENCIA)
	private String referencia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXTALLER,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXTALLER)
	private String taller;
	
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
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXRESPONSABLE,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXRESPONSABLE)
	private String responsable;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXOBSERVACION,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXOBSERVACION)
	private String observacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXTIPO_MOVIMIENTO,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXTIPO_MOVIMIENTO)
	private String tipo_movimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXCLAVE,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXNOMBRE,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXCODIGO_DETALLE_GRUPO,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXCODIGO_DETALLE_GRUPO)
	private String codigo_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=MantenimientoeActivoFijosConstantesFunciones.SREGEXNOMBRE_DETALLE_GRUPO,message=MantenimientoeActivoFijosConstantesFunciones.SMENSAJEREGEXNOMBRE_DETALLE_GRUPO)
	private String nombre_detalle_grupo;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public MantenimientoeActivoFijos () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.mantenimientoeactivofijosOriginal=this;
		
 		this.id_empresa=-1L;
 		this.numero_documento="";
 		this.causa="";
 		this.referencia="";
 		this.taller="";
 		this.fecha_inicio=new Date();
 		this.fecha_entrega=new Date();
 		this.costo=0.0;
 		this.responsable="";
 		this.observacion="";
 		this.tipo_movimiento="";
 		this.clave="";
 		this.nombre="";
 		this.codigo_detalle_grupo="";
 		this.nombre_detalle_grupo="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public MantenimientoeActivoFijos (Long id,Date versionRow,String numero_documento,String causa,String referencia,String taller,Date fecha_inicio,Date fecha_entrega,Double costo,String responsable,String observacion,String tipo_movimiento,String clave,String nombre,String codigo_detalle_grupo,String nombre_detalle_grupo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mantenimientoeactivofijosOriginal=this;
		
 		this.numero_documento=numero_documento;
 		this.causa=causa;
 		this.referencia=referencia;
 		this.taller=taller;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_entrega=fecha_entrega;
 		this.costo=costo;
 		this.responsable=responsable;
 		this.observacion=observacion;
 		this.tipo_movimiento=tipo_movimiento;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public MantenimientoeActivoFijos (String numero_documento,String causa,String referencia,String taller,Date fecha_inicio,Date fecha_entrega,Double costo,String responsable,String observacion,String tipo_movimiento,String clave,String nombre,String codigo_detalle_grupo,String nombre_detalle_grupo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.mantenimientoeactivofijosOriginal=this;
		
 		this.numero_documento=numero_documento;
 		this.causa=causa;
 		this.referencia=referencia;
 		this.taller=taller;
 		this.fecha_inicio=fecha_inicio;
 		this.fecha_entrega=fecha_entrega;
 		this.costo=costo;
 		this.responsable=responsable;
 		this.observacion=observacion;
 		this.tipo_movimiento=tipo_movimiento;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public MantenimientoeActivoFijos getMantenimientoeActivoFijosOriginal() {
		return this.mantenimientoeactivofijosOriginal;
	}
	
	public void setMantenimientoeActivoFijosOriginal(MantenimientoeActivoFijos mantenimientoeactivofijos) {
		try {
			this.mantenimientoeactivofijosOriginal=mantenimientoeactivofijos;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected MantenimientoeActivoFijosAdditional mantenimientoeactivofijosAdditional=null;
	
	public MantenimientoeActivoFijosAdditional getMantenimientoeActivoFijosAdditional() {
		return this.mantenimientoeactivofijosAdditional;
	}
	
	public void setMantenimientoeActivoFijosAdditional(MantenimientoeActivoFijosAdditional mantenimientoeactivofijosAdditional) {
		try {
			this.mantenimientoeactivofijosAdditional=mantenimientoeactivofijosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
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
    
	
	public String gettipo_movimiento() {
		return this.tipo_movimiento;
	}
    
	
	public String getclave() {
		return this.clave;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcodigo_detalle_grupo() {
		return this.codigo_detalle_grupo;
	}
    
	
	public String getnombre_detalle_grupo() {
		return this.nombre_detalle_grupo;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna numero_documento");
					}
				}

				if(newnumero_documento!=null&&newnumero_documento.length()>50) {
					newnumero_documento=newnumero_documento.substring(0,48);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_documento");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna causa");
					}
				}

				if(newcausa!=null&&newcausa.length()>250) {
					newcausa=newcausa.substring(0,248);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna causa");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna referencia");
					}
				}

				if(newreferencia!=null&&newreferencia.length()>200) {
					newreferencia=newreferencia.substring(0,198);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna referencia");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna taller");
					}
				}

				if(newtaller!=null&&newtaller.length()>200) {
					newtaller=newtaller.substring(0,198);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna taller");
				}

				this.taller=newtaller;
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna fecha_inicio");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna fecha_entrega");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna costo");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna responsable");
					}
				}

				if(newresponsable!=null&&newresponsable.length()>250) {
					newresponsable=newresponsable.substring(0,248);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna responsable");
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna observacion");
					}
				}

				if(newobservacion!=null&&newobservacion.length()>250) {
					newobservacion=newobservacion.substring(0,248);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna observacion");
				}

				this.observacion=newobservacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settipo_movimiento(String newtipo_movimiento)throws Exception
	{
		try {
			if(this.tipo_movimiento!=newtipo_movimiento) {
				if(newtipo_movimiento==null) {
					//newtipo_movimiento="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna tipo_movimiento");
					}
				}

				if(newtipo_movimiento!=null&&newtipo_movimiento.length()>100) {
					newtipo_movimiento=newtipo_movimiento.substring(0,98);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna tipo_movimiento");
				}

				this.tipo_movimiento=newtipo_movimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setclave(String newclave)throws Exception
	{
		try {
			if(this.clave!=newclave) {
				if(newclave==null) {
					//newclave="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
				}

				this.clave=newclave;
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
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_detalle_grupo(String newcodigo_detalle_grupo)throws Exception
	{
		try {
			if(this.codigo_detalle_grupo!=newcodigo_detalle_grupo) {
				if(newcodigo_detalle_grupo==null) {
					//newcodigo_detalle_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna codigo_detalle_grupo");
					}
				}

				if(newcodigo_detalle_grupo!=null&&newcodigo_detalle_grupo.length()>50) {
					newcodigo_detalle_grupo=newcodigo_detalle_grupo.substring(0,48);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_detalle_grupo");
				}

				this.codigo_detalle_grupo=newcodigo_detalle_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_detalle_grupo(String newnombre_detalle_grupo)throws Exception
	{
		try {
			if(this.nombre_detalle_grupo!=newnombre_detalle_grupo) {
				if(newnombre_detalle_grupo==null) {
					//newnombre_detalle_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("MantenimientoeActivoFijos:Valor nulo no permitido en columna nombre_detalle_grupo");
					}
				}

				if(newnombre_detalle_grupo!=null&&newnombre_detalle_grupo.length()>150) {
					newnombre_detalle_grupo=newnombre_detalle_grupo.substring(0,148);
					System.out.println("MantenimientoeActivoFijos:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_detalle_grupo");
				}

				this.nombre_detalle_grupo=newnombre_detalle_grupo;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

