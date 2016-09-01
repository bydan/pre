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
//import com.bydan.erp.nomina.util.AsistenciaPorCentroCostoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class AsistenciaPorCentroCosto extends AsistenciaPorCentroCostoAdditional implements Serializable ,Cloneable {//AsistenciaPorCentroCostoAdditional,GeneralEntity
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
	
	private AsistenciaPorCentroCosto asistenciaporcentrocostoOriginal;
	
	private Map<String, Object> mapAsistenciaPorCentroCosto;
			
	public Map<String, Object> getMapAsistenciaPorCentroCosto() {
		return mapAsistenciaPorCentroCosto;
	}

	public void setMapAsistenciaPorCentroCosto(Map<String, Object> mapAsistenciaPorCentroCosto) {
		this.mapAsistenciaPorCentroCosto = mapAsistenciaPorCentroCosto;
	}
	
	public void inicializarMapAsistenciaPorCentroCosto() {
		this.mapAsistenciaPorCentroCosto = new HashMap<String,Object>();
	}
	
	public void setMapAsistenciaPorCentroCostoValue(String sKey,Object oValue) {
		this.mapAsistenciaPorCentroCosto.put(sKey, oValue);
	}
	
	public Object getMapAsistenciaPorCentroCostoValue(String sKey) {
		return this.mapAsistenciaPorCentroCosto.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_centro_costo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double porcentaje;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_hora;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double permiso;
			
	
	public Empresa empresa;
	public CentroCosto centrocosto;
	public Empleado empleado;
	
	
	private String empresa_descripcion;
	private String centrocosto_descripcion;
	private String empleado_descripcion;
	
	
		
	public AsistenciaPorCentroCosto () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.asistenciaporcentrocostoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_centro_costo=null;
 		this.id_empleado=-1L;
 		this.fecha=new Date();
 		this.porcentaje=0.0;
 		this.valor_hora=0.0;
 		this.permiso=0.0;
		
		
		this.empresa=null;
		this.centrocosto=null;
		this.empleado=null;
		
		
		this.empresa_descripcion="";
		this.centrocosto_descripcion="";
		this.empleado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public AsistenciaPorCentroCosto (Long id,Date versionRow,Long id_empresa,Long id_centro_costo,Long id_empleado,Date fecha,Double porcentaje,Double valor_hora,Double permiso) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciaporcentrocostoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_centro_costo=id_centro_costo;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.porcentaje=porcentaje;
 		this.valor_hora=valor_hora;
 		this.permiso=permiso;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public AsistenciaPorCentroCosto (Long id_empresa,Long id_centro_costo,Long id_empleado,Date fecha,Double porcentaje,Double valor_hora,Double permiso) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.asistenciaporcentrocostoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_centro_costo=id_centro_costo;
 		this.id_empleado=id_empleado;
 		this.fecha=fecha;
 		this.porcentaje=porcentaje;
 		this.valor_hora=valor_hora;
 		this.permiso=permiso;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		AsistenciaPorCentroCosto asistenciaporcentrocostoLocal=null;
		
		if(object!=null) {
			asistenciaporcentrocostoLocal=(AsistenciaPorCentroCosto)object;
			
			if(asistenciaporcentrocostoLocal!=null) {
				if(this.getId()!=null && asistenciaporcentrocostoLocal.getId()!=null) {
					if(this.getId().equals(asistenciaporcentrocostoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AsistenciaPorCentroCostoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AsistenciaPorCentroCostoConstantesFunciones.getAsistenciaPorCentroCostoDescripcion(this);
		} else {
			sDetalle=AsistenciaPorCentroCostoConstantesFunciones.getAsistenciaPorCentroCostoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public AsistenciaPorCentroCosto getAsistenciaPorCentroCostoOriginal() {
		return this.asistenciaporcentrocostoOriginal;
	}
	
	public void setAsistenciaPorCentroCostoOriginal(AsistenciaPorCentroCosto asistenciaporcentrocosto) {
		try {
			this.asistenciaporcentrocostoOriginal=asistenciaporcentrocosto;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AsistenciaPorCentroCostoAdditional asistenciaporcentrocostoAdditional=null;
	
	public AsistenciaPorCentroCostoAdditional getAsistenciaPorCentroCostoAdditional() {
		return this.asistenciaporcentrocostoAdditional;
	}
	
	public void setAsistenciaPorCentroCostoAdditional(AsistenciaPorCentroCostoAdditional asistenciaporcentrocostoAdditional) {
		try {
			this.asistenciaporcentrocostoAdditional=asistenciaporcentrocostoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_centro_costo() {
		return this.id_centro_costo;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Double getporcentaje() {
		return this.porcentaje;
	}
    
	
	public Double getvalor_hora() {
		return this.valor_hora;
	}
    
	
	public Double getpermiso() {
		return this.permiso;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_centro_costo(Long newid_centro_costo) {
		if(this.id_centro_costo==null&&newid_centro_costo!=null) {
			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}

		if(this.id_centro_costo!=null&&!this.id_centro_costo.equals(newid_centro_costo)) {

			this.id_centro_costo=newid_centro_costo;
				this.setIsChanged(true);
		}
	}
    
	public void setid_empleado(Long newid_empleado)throws Exception
	{
		try {
			if(this.id_empleado!=newid_empleado) {
				if(newid_empleado==null) {
					//newid_empleado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
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
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna porcentaje");
					}
				}

				this.porcentaje=newporcentaje;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_hora(Double newvalor_hora)throws Exception
	{
		try {
			if(this.valor_hora!=newvalor_hora) {
				if(newvalor_hora==null) {
					//newvalor_hora=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna valor_hora");
					}
				}

				this.valor_hora=newvalor_hora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpermiso(Double newpermiso)throws Exception
	{
		try {
			if(this.permiso!=newpermiso) {
				if(newpermiso==null) {
					//newpermiso=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("AsistenciaPorCentroCosto:Valor nulo no permitido en columna permiso");
					}
				}

				this.permiso=newpermiso;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public CentroCosto getCentroCosto() {
		return this.centrocosto;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getcentrocosto_descripcion() {
		return this.centrocosto_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setCentroCosto(CentroCosto centrocosto) {
		try {
			this.centrocosto=centrocosto;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setcentrocosto_descripcion(String centrocosto_descripcion) {
		try {
			this.centrocosto_descripcion=centrocosto_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_centro_costo_descripcion="";String id_empleado_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_centro_costo_descripcion() {
		return id_centro_costo_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_centro_costo_descripcion(String newid_centro_costo_descripcion)throws Exception {
		try {
			this.id_centro_costo_descripcion=newid_centro_costo_descripcion;
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
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_centro_costo_descripcion="";this.id_empleado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

