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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.RequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class Requisicion extends RequisicionAdditional implements Serializable ,Cloneable {//RequisicionAdditional,GeneralEntity
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
	
	private Requisicion requisicionOriginal;
	
	private Map<String, Object> mapRequisicion;
			
	public Map<String, Object> getMapRequisicion() {
		return mapRequisicion;
	}

	public void setMapRequisicion(Map<String, Object> mapRequisicion) {
		this.mapRequisicion = mapRequisicion;
	}
	
	public void inicializarMapRequisicion() {
		this.mapRequisicion = new HashMap<String,Object>();
	}
	
	public void setMapRequisicionValue(String sKey,Object oValue) {
		this.mapRequisicion.put(sKey, oValue);
	}
	
	public Object getMapRequisicionValue(String sKey) {
		return this.mapRequisicion.get(sKey);
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
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RequisicionConstantesFunciones.SREGEXNUMERO_SECUENCIAL,message=RequisicionConstantesFunciones.SMENSAJEREGEXNUMERO_SECUENCIAL)
	private String numero_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estado_requisicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_solicitar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=RequisicionConstantesFunciones.SREGEXDESCRIPCION,message=RequisicionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_bodega_solicita;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public TipoRequisicion tiporequisicion;
	public Empleado empleado;
	public EstadoRequisicion estadorequisicion;
	public Formato formato;
	public Bodega bodegasolicitar;
	public Bodega bodegasolicita;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String tiporequisicion_descripcion;
	private String empleado_descripcion;
	private String estadorequisicion_descripcion;
	private String formato_descripcion;
	private String bodegasolicitar_descripcion;
	private String bodegasolicita_descripcion;
	
	
	public List<DetalleRequisicion> detallerequisicions;
		
	public Requisicion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.requisicionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.numero_secuencial="";
 		this.id_tipo_requisicion=-1L;
 		this.fecha=new Date();
 		this.hora=new Time((new Date()).getTime());
 		this.id_empleado=-1L;
 		this.id_estado_requisicion=-1L;
 		this.id_formato=-1L;
 		this.id_bodega_solicitar=-1L;
 		this.descripcion="";
 		this.id_bodega_solicita=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.tiporequisicion=null;
		this.empleado=null;
		this.estadorequisicion=null;
		this.formato=null;
		this.bodegasolicitar=null;
		this.bodegasolicita=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.tiporequisicion_descripcion="";
		this.empleado_descripcion="";
		this.estadorequisicion_descripcion="";
		this.formato_descripcion="";
		this.bodegasolicitar_descripcion="";
		this.bodegasolicita_descripcion="";
		
		
		this.detallerequisicions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Requisicion (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String numero_secuencial,Long id_tipo_requisicion,Date fecha,Time hora,Long id_empleado,Long id_estado_requisicion,Long id_formato,Long id_bodega_solicitar,String descripcion,Long id_bodega_solicita) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.requisicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.numero_secuencial=numero_secuencial;
 		this.id_tipo_requisicion=id_tipo_requisicion;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.id_empleado=id_empleado;
 		this.id_estado_requisicion=id_estado_requisicion;
 		this.id_formato=id_formato;
 		this.id_bodega_solicitar=id_bodega_solicitar;
 		this.descripcion=descripcion;
 		this.id_bodega_solicita=id_bodega_solicita;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Requisicion (Long id_empresa,Long id_sucursal,String numero_secuencial,Long id_tipo_requisicion,Date fecha,Time hora,Long id_empleado,Long id_estado_requisicion,Long id_formato,Long id_bodega_solicitar,String descripcion,Long id_bodega_solicita) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.requisicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.numero_secuencial=numero_secuencial;
 		this.id_tipo_requisicion=id_tipo_requisicion;
 		this.fecha=fecha;
 		this.hora=hora;
 		this.id_empleado=id_empleado;
 		this.id_estado_requisicion=id_estado_requisicion;
 		this.id_formato=id_formato;
 		this.id_bodega_solicitar=id_bodega_solicitar;
 		this.descripcion=descripcion;
 		this.id_bodega_solicita=id_bodega_solicita;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Requisicion requisicionLocal=null;
		
		if(object!=null) {
			requisicionLocal=(Requisicion)object;
			
			if(requisicionLocal!=null) {
				if(this.getId()!=null && requisicionLocal.getId()!=null) {
					if(this.getId().equals(requisicionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RequisicionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RequisicionConstantesFunciones.getRequisicionDescripcion(this);
		} else {
			sDetalle=RequisicionConstantesFunciones.getRequisicionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Requisicion getRequisicionOriginal() {
		return this.requisicionOriginal;
	}
	
	public void setRequisicionOriginal(Requisicion requisicion) {
		try {
			this.requisicionOriginal=requisicion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RequisicionAdditional requisicionAdditional=null;
	
	public RequisicionAdditional getRequisicionAdditional() {
		return this.requisicionAdditional;
	}
	
	public void setRequisicionAdditional(RequisicionAdditional requisicionAdditional) {
		try {
			this.requisicionAdditional=requisicionAdditional;
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
    
	
	public String getnumero_secuencial() {
		return this.numero_secuencial;
	}
    
	
	public Long getid_tipo_requisicion() {
		return this.id_tipo_requisicion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_estado_requisicion() {
		return this.id_estado_requisicion;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public Long getid_bodega_solicitar() {
		return this.id_bodega_solicitar;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public Long getid_bodega_solicita() {
		return this.id_bodega_solicita;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("Requisicion:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("Requisicion:Valor nulo no permitido en columna numero_secuencial");
					}
				}

				if(newnumero_secuencial!=null&&newnumero_secuencial.length()>50) {
					newnumero_secuencial=newnumero_secuencial.substring(0,48);
					System.out.println("Requisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_secuencial");
				}

				this.numero_secuencial=newnumero_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_requisicion(Long newid_tipo_requisicion)throws Exception
	{
		try {
			if(this.id_tipo_requisicion!=newid_tipo_requisicion) {
				if(newid_tipo_requisicion==null) {
					//newid_tipo_requisicion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna id_tipo_requisicion");
					}
				}

				this.id_tipo_requisicion=newid_tipo_requisicion;
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
						System.out.println("Requisicion:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
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
						System.out.println("Requisicion:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estado_requisicion(Long newid_estado_requisicion)throws Exception
	{
		try {
			if(this.id_estado_requisicion!=newid_estado_requisicion) {
				if(newid_estado_requisicion==null) {
					//newid_estado_requisicion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna id_estado_requisicion");
					}
				}

				this.id_estado_requisicion=newid_estado_requisicion;
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
						System.out.println("Requisicion:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_solicitar(Long newid_bodega_solicitar)throws Exception
	{
		try {
			if(this.id_bodega_solicitar!=newid_bodega_solicitar) {
				if(newid_bodega_solicitar==null) {
					//newid_bodega_solicitar=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna id_bodega_solicitar");
					}
				}

				this.id_bodega_solicitar=newid_bodega_solicitar;
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
						System.out.println("Requisicion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Requisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_bodega_solicita(Long newid_bodega_solicita)throws Exception
	{
		try {
			if(this.id_bodega_solicita!=newid_bodega_solicita) {
				if(newid_bodega_solicita==null) {
					//newid_bodega_solicita=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Requisicion:Valor nulo no permitido en columna id_bodega_solicita");
					}
				}

				this.id_bodega_solicita=newid_bodega_solicita;
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

	public TipoRequisicion getTipoRequisicion() {
		return this.tiporequisicion;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public EstadoRequisicion getEstadoRequisicion() {
		return this.estadorequisicion;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Bodega getBodegaSolicitar() {
		return this.bodegasolicitar;
	}

	public Bodega getBodegaSolicita() {
		return this.bodegasolicita;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String gettiporequisicion_descripcion() {
		return this.tiporequisicion_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getestadorequisicion_descripcion() {
		return this.estadorequisicion_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getbodegasolicitar_descripcion() {
		return this.bodegasolicitar_descripcion;
	}

	public String getbodegasolicita_descripcion() {
		return this.bodegasolicita_descripcion;
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


	public  void  setTipoRequisicion(TipoRequisicion tiporequisicion) {
		try {
			this.tiporequisicion=tiporequisicion;
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


	public  void  setEstadoRequisicion(EstadoRequisicion estadorequisicion) {
		try {
			this.estadorequisicion=estadorequisicion;
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


	public  void  setBodegaSolicitar(Bodega bodegasolicitar) {
		try {
			this.bodegasolicitar=bodegasolicitar;
		} catch(Exception e) {
			;
		}
	}


	public  void  setBodegaSolicita(Bodega bodegasolicita) {
		try {
			this.bodegasolicita=bodegasolicita;
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


	public  void  settiporequisicion_descripcion(String tiporequisicion_descripcion) {
		try {
			this.tiporequisicion_descripcion=tiporequisicion_descripcion;
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


	public  void  setestadorequisicion_descripcion(String estadorequisicion_descripcion) {
		try {
			this.estadorequisicion_descripcion=estadorequisicion_descripcion;
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


	public  void  setbodegasolicitar_descripcion(String bodegasolicitar_descripcion) {
		try {
			this.bodegasolicitar_descripcion=bodegasolicitar_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setbodegasolicita_descripcion(String bodegasolicita_descripcion) {
		try {
			this.bodegasolicita_descripcion=bodegasolicita_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DetalleRequisicion> getDetalleRequisicions() {
		return this.detallerequisicions;
	}

	
	
	public  void  setDetalleRequisicions(List<DetalleRequisicion> detallerequisicions) {
		try {
			this.detallerequisicions=detallerequisicions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_tipo_requisicion_descripcion="";String id_empleado_descripcion="";String id_estado_requisicion_descripcion="";String id_formato_descripcion="";String id_bodega_solicitar_descripcion="";String id_bodega_solicita_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_tipo_requisicion_descripcion() {
		return id_tipo_requisicion_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_estado_requisicion_descripcion() {
		return id_estado_requisicion_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_bodega_solicitar_descripcion() {
		return id_bodega_solicitar_descripcion;
	}
	public String getid_bodega_solicita_descripcion() {
		return id_bodega_solicita_descripcion;
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
	public void setid_tipo_requisicion_descripcion(String newid_tipo_requisicion_descripcion)throws Exception {
		try {
			this.id_tipo_requisicion_descripcion=newid_tipo_requisicion_descripcion;
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
	public void setid_estado_requisicion_descripcion(String newid_estado_requisicion_descripcion)throws Exception {
		try {
			this.id_estado_requisicion_descripcion=newid_estado_requisicion_descripcion;
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
	public void setid_bodega_solicitar_descripcion(String newid_bodega_solicitar_descripcion)throws Exception {
		try {
			this.id_bodega_solicitar_descripcion=newid_bodega_solicitar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_bodega_solicita_descripcion(String newid_bodega_solicita_descripcion)throws Exception {
		try {
			this.id_bodega_solicita_descripcion=newid_bodega_solicita_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_tipo_requisicion_descripcion="";this.id_empleado_descripcion="";this.id_estado_requisicion_descripcion="";this.id_formato_descripcion="";this.id_bodega_solicitar_descripcion="";this.id_bodega_solicita_descripcion="";
	}
	
	
	Object detallerequisicionsDescripcionReporte;
	
	
	public Object getdetallerequisicionsDescripcionReporte() {
		return detallerequisicionsDescripcionReporte;
	}

	
	
	public  void  setdetallerequisicionsDescripcionReporte(Object detallerequisicions) {
		try {
			this.detallerequisicionsDescripcionReporte=detallerequisicions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

