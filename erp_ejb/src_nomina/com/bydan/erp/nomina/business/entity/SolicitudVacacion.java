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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.SolicitudVacacionConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class SolicitudVacacion extends SolicitudVacacionAdditional implements Serializable ,Cloneable {//SolicitudVacacionAdditional,GeneralEntity
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
	
	private SolicitudVacacion solicitudvacacionOriginal;
	
	private Map<String, Object> mapSolicitudVacacion;
			
	public Map<String, Object> getMapSolicitudVacacion() {
		return mapSolicitudVacacion;
	}

	public void setMapSolicitudVacacion(Map<String, Object> mapSolicitudVacacion) {
		this.mapSolicitudVacacion = mapSolicitudVacacion;
	}
	
	public void inicializarMapSolicitudVacacion() {
		this.mapSolicitudVacacion = new HashMap<String,Object>();
	}
	
	public void setMapSolicitudVacacionValue(String sKey,Object oValue) {
		this.mapSolicitudVacacion.put(sKey, oValue);
	}
	
	public Object getMapSolicitudVacacionValue(String sKey) {
		return this.mapSolicitudVacacion.get(sKey);
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
	private Long id_empleado_jefe;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_solicitud_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SolicitudVacacionConstantesFunciones.SREGEXSECUENCIAL,message=SolicitudVacacionConstantesFunciones.SMENSAJEREGEXSECUENCIAL)
	private String secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_solicita;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_ejecuta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_horas;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_unitario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_total;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=250,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=SolicitudVacacionConstantesFunciones.SREGEXDESCRIPCION,message=SolicitudVacacionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Empleado empleadojefe;
	public Empleado empleado;
	public Estructura estructura;
	public EstadoSolicitudNomi estadosolicitudnomi;
	public Formato formato;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String empleadojefe_descripcion;
	private String empleado_descripcion;
	private String estructura_descripcion;
	private String estadosolicitudnomi_descripcion;
	private String formato_descripcion;
	
	
		
	public SolicitudVacacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.solicitudvacacionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.id_empleado_jefe=-1L;
 		this.id_empleado=-1L;
 		this.id_estructura=-1L;
 		this.id_estado_solicitud_nomi=-1L;
 		this.id_formato=-1L;
 		this.secuencial="";
 		this.fecha_solicita=new Date();
 		this.fecha_ejecuta=new Date();
 		this.numero_horas=0;
 		this.costo_unitario=0.0;
 		this.costo_total=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.sucursal=null;
		this.empleadojefe=null;
		this.empleado=null;
		this.estructura=null;
		this.estadosolicitudnomi=null;
		this.formato=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.empleadojefe_descripcion="";
		this.empleado_descripcion="";
		this.estructura_descripcion="";
		this.estadosolicitudnomi_descripcion="";
		this.formato_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public SolicitudVacacion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,Long id_empleado_jefe,Long id_empleado,Long id_estructura,Long id_estado_solicitud_nomi,Long id_formato,String secuencial,Date fecha_solicita,Date fecha_ejecuta,Integer numero_horas,Double costo_unitario,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.solicitudvacacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado_jefe=id_empleado_jefe;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_estado_solicitud_nomi=id_estado_solicitud_nomi;
 		this.id_formato=id_formato;
 		this.secuencial=secuencial;
 		this.fecha_solicita=fecha_solicita;
 		this.fecha_ejecuta=fecha_ejecuta;
 		this.numero_horas=numero_horas;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public SolicitudVacacion (Long id_empresa,Long id_sucursal,Long id_empleado_jefe,Long id_empleado,Long id_estructura,Long id_estado_solicitud_nomi,Long id_formato,String secuencial,Date fecha_solicita,Date fecha_ejecuta,Integer numero_horas,Double costo_unitario,Double costo_total,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.solicitudvacacionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.id_empleado_jefe=id_empleado_jefe;
 		this.id_empleado=id_empleado;
 		this.id_estructura=id_estructura;
 		this.id_estado_solicitud_nomi=id_estado_solicitud_nomi;
 		this.id_formato=id_formato;
 		this.secuencial=secuencial;
 		this.fecha_solicita=fecha_solicita;
 		this.fecha_ejecuta=fecha_ejecuta;
 		this.numero_horas=numero_horas;
 		this.costo_unitario=costo_unitario;
 		this.costo_total=costo_total;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		SolicitudVacacion solicitudvacacionLocal=null;
		
		if(object!=null) {
			solicitudvacacionLocal=(SolicitudVacacion)object;
			
			if(solicitudvacacionLocal!=null) {
				if(this.getId()!=null && solicitudvacacionLocal.getId()!=null) {
					if(this.getId().equals(solicitudvacacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!SolicitudVacacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=SolicitudVacacionConstantesFunciones.getSolicitudVacacionDescripcion(this);
		} else {
			sDetalle=SolicitudVacacionConstantesFunciones.getSolicitudVacacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public SolicitudVacacion getSolicitudVacacionOriginal() {
		return this.solicitudvacacionOriginal;
	}
	
	public void setSolicitudVacacionOriginal(SolicitudVacacion solicitudvacacion) {
		try {
			this.solicitudvacacionOriginal=solicitudvacacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected SolicitudVacacionAdditional solicitudvacacionAdditional=null;
	
	public SolicitudVacacionAdditional getSolicitudVacacionAdditional() {
		return this.solicitudvacacionAdditional;
	}
	
	public void setSolicitudVacacionAdditional(SolicitudVacacionAdditional solicitudvacacionAdditional) {
		try {
			this.solicitudvacacionAdditional=solicitudvacacionAdditional;
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
    
	
	public Long getid_empleado_jefe() {
		return this.id_empleado_jefe;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_estado_solicitud_nomi() {
		return this.id_estado_solicitud_nomi;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getsecuencial() {
		return this.secuencial;
	}
    
	
	public Date getfecha_solicita() {
		return this.fecha_solicita;
	}
    
	
	public Date getfecha_ejecuta() {
		return this.fecha_ejecuta;
	}
    
	
	public Integer getnumero_horas() {
		return this.numero_horas;
	}
    
	
	public Double getcosto_unitario() {
		return this.costo_unitario;
	}
    
	
	public Double getcosto_total() {
		return this.costo_total;
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
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_jefe(Long newid_empleado_jefe)throws Exception
	{
		try {
			if(this.id_empleado_jefe!=newid_empleado_jefe) {
				if(newid_empleado_jefe==null) {
					//newid_empleado_jefe=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_empleado_jefe");
					}
				}

				this.id_empleado_jefe=newid_empleado_jefe;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_solicitud_nomi(Long newid_estado_solicitud_nomi)throws Exception
	{
		try {
			if(this.id_estado_solicitud_nomi!=newid_estado_solicitud_nomi) {
				if(newid_estado_solicitud_nomi==null) {
					//newid_estado_solicitud_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_estado_solicitud_nomi");
					}
				}

				this.id_estado_solicitud_nomi=newid_estado_solicitud_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(String newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna secuencial");
					}
				}

				if(newsecuencial!=null&&newsecuencial.length()>50) {
					newsecuencial=newsecuencial.substring(0,48);
					System.out.println("SolicitudVacacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna secuencial");
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_solicita(Date newfecha_solicita)throws Exception
	{
		try {
			if(this.fecha_solicita!=newfecha_solicita) {
				if(newfecha_solicita==null) {
					//newfecha_solicita=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna fecha_solicita");
					}
				}

				this.fecha_solicita=newfecha_solicita;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_ejecuta(Date newfecha_ejecuta)throws Exception
	{
		try {
			if(this.fecha_ejecuta!=newfecha_ejecuta) {
				if(newfecha_ejecuta==null) {
					//newfecha_ejecuta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna fecha_ejecuta");
					}
				}

				this.fecha_ejecuta=newfecha_ejecuta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_horas(Integer newnumero_horas)throws Exception
	{
		try {
			if(this.numero_horas!=newnumero_horas) {
				if(newnumero_horas==null) {
					//newnumero_horas=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna numero_horas");
					}
				}

				this.numero_horas=newnumero_horas;
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
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna costo_unitario");
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
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna costo_total");
					}
				}

				this.costo_total=newcosto_total;
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
						System.out.println("SolicitudVacacion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>250) {
					newdescripcion=newdescripcion.substring(0,248);
					System.out.println("SolicitudVacacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=250 en columna descripcion");
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

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Empleado getEmpleadoJefe() {
		return this.empleadojefe;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public EstadoSolicitudNomi getEstadoSolicitudNomi() {
		return this.estadosolicitudnomi;
	}

	public Formato getFormato() {
		return this.formato;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getempleadojefe_descripcion() {
		return this.empleadojefe_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getestadosolicitudnomi_descripcion() {
		return this.estadosolicitudnomi_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
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


	public  void  setEmpleadoJefe(Empleado empleadojefe) {
		try {
			this.empleadojefe=empleadojefe;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpleado(Empleado empleado) {
		try {
			this.empleado=empleado;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstadoSolicitudNomi(EstadoSolicitudNomi estadosolicitudnomi) {
		try {
			this.estadosolicitudnomi=estadosolicitudnomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
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


	public  void  setempleadojefe_descripcion(String empleadojefe_descripcion) {
		try {
			this.empleadojefe_descripcion=empleadojefe_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setestadosolicitudnomi_descripcion(String estadosolicitudnomi_descripcion) {
		try {
			this.estadosolicitudnomi_descripcion=estadosolicitudnomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_empleado_jefe_descripcion="";String id_empleado_descripcion="";String id_estructura_descripcion="";String id_estado_solicitud_nomi_descripcion="";String id_formato_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_empleado_jefe_descripcion() {
		return id_empleado_jefe_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_estado_solicitud_nomi_descripcion() {
		return id_estado_solicitud_nomi_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
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
	public void setid_empleado_jefe_descripcion(String newid_empleado_jefe_descripcion)throws Exception {
		try {
			this.id_empleado_jefe_descripcion=newid_empleado_jefe_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empleado_descripcion(String newid_empleado_descripcion)throws Exception {
		try {
			this.id_empleado_descripcion=newid_empleado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estado_solicitud_nomi_descripcion(String newid_estado_solicitud_nomi_descripcion)throws Exception {
		try {
			this.id_estado_solicitud_nomi_descripcion=newid_estado_solicitud_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_empleado_jefe_descripcion="";this.id_empleado_descripcion="";this.id_estructura_descripcion="";this.id_estado_solicitud_nomi_descripcion="";this.id_formato_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

