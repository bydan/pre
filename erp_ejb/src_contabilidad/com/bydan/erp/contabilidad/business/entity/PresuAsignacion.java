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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.PresuAsignacionConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.nomina.util.*;



import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class PresuAsignacion extends PresuAsignacionAdditional implements Serializable ,Cloneable {//PresuAsignacionAdditional,GeneralEntity
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
	
	private PresuAsignacion presuasignacionOriginal;
	
	private Map<String, Object> mapPresuAsignacion;
			
	public Map<String, Object> getMapPresuAsignacion() {
		return mapPresuAsignacion;
	}

	public void setMapPresuAsignacion(Map<String, Object> mapPresuAsignacion) {
		this.mapPresuAsignacion = mapPresuAsignacion;
	}
	
	public void inicializarMapPresuAsignacion() {
		this.mapPresuAsignacion = new HashMap<String,Object>();
	}
	
	public void setMapPresuAsignacionValue(String sKey,Object oValue) {
		this.mapPresuAsignacion.put(sKey, oValue);
	}
	
	public Object getMapPresuAsignacionValue(String sKey) {
		return this.mapPresuAsignacion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_proyecto_cuenta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long codigo_secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_presu_estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PresuAsignacionConstantesFunciones.SREGEXDESCRIPCION,message=PresuAsignacionConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public PresuProyectoCuenta presuproyectocuenta;
	public Empleado empleado;
	public PresuEstado presuestado;
	
	
	private String presuproyectocuenta_descripcion;
	private String empleado_descripcion;
	private String presuestado_descripcion;
	
	
		
	public PresuAsignacion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.presuasignacionOriginal=this;
		
 		this.id_presu_proyecto_cuenta=-1L;
 		this.id_empleado=-1L;
 		this.codigo_secuencial=0L;
 		this.valor=0.0;
 		this.fecha=new Date();
 		this.id_presu_estado=-1L;
 		this.descripcion="";
		
		
		this.presuproyectocuenta=null;
		this.empleado=null;
		this.presuestado=null;
		
		
		this.presuproyectocuenta_descripcion="";
		this.empleado_descripcion="";
		this.presuestado_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PresuAsignacion (Long id,Date versionRow,Long id_presu_proyecto_cuenta,Long id_empleado,Long codigo_secuencial,Double valor,Date fecha,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuasignacionOriginal=this;
		
 		this.id_presu_proyecto_cuenta=id_presu_proyecto_cuenta;
 		this.id_empleado=id_empleado;
 		this.codigo_secuencial=codigo_secuencial;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PresuAsignacion (Long id_presu_proyecto_cuenta,Long id_empleado,Long codigo_secuencial,Double valor,Date fecha,Long id_presu_estado,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.presuasignacionOriginal=this;
		
 		this.id_presu_proyecto_cuenta=id_presu_proyecto_cuenta;
 		this.id_empleado=id_empleado;
 		this.codigo_secuencial=codigo_secuencial;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.id_presu_estado=id_presu_estado;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PresuAsignacion presuasignacionLocal=null;
		
		if(object!=null) {
			presuasignacionLocal=(PresuAsignacion)object;
			
			if(presuasignacionLocal!=null) {
				if(this.getId()!=null && presuasignacionLocal.getId()!=null) {
					if(this.getId().equals(presuasignacionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PresuAsignacionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PresuAsignacionConstantesFunciones.getPresuAsignacionDescripcion(this);
		} else {
			sDetalle=PresuAsignacionConstantesFunciones.getPresuAsignacionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PresuAsignacion getPresuAsignacionOriginal() {
		return this.presuasignacionOriginal;
	}
	
	public void setPresuAsignacionOriginal(PresuAsignacion presuasignacion) {
		try {
			this.presuasignacionOriginal=presuasignacion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PresuAsignacionAdditional presuasignacionAdditional=null;
	
	public PresuAsignacionAdditional getPresuAsignacionAdditional() {
		return this.presuasignacionAdditional;
	}
	
	public void setPresuAsignacionAdditional(PresuAsignacionAdditional presuasignacionAdditional) {
		try {
			this.presuasignacionAdditional=presuasignacionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_presu_proyecto_cuenta() {
		return this.id_presu_proyecto_cuenta;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getcodigo_secuencial() {
		return this.codigo_secuencial;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Long getid_presu_estado() {
		return this.id_presu_estado;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_presu_proyecto_cuenta(Long newid_presu_proyecto_cuenta)throws Exception
	{
		try {
			if(this.id_presu_proyecto_cuenta!=newid_presu_proyecto_cuenta) {
				if(newid_presu_proyecto_cuenta==null) {
					//newid_presu_proyecto_cuenta=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna id_presu_proyecto_cuenta");
					}
				}

				this.id_presu_proyecto_cuenta=newid_presu_proyecto_cuenta;
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
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_secuencial(Long newcodigo_secuencial)throws Exception
	{
		try {
			if(this.codigo_secuencial!=newcodigo_secuencial) {
				if(newcodigo_secuencial==null) {
					//newcodigo_secuencial=0L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna codigo_secuencial");
					}
				}

				this.codigo_secuencial=newcodigo_secuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_presu_estado(Long newid_presu_estado)throws Exception
	{
		try {
			if(this.id_presu_estado!=newid_presu_estado) {
				if(newid_presu_estado==null) {
					//newid_presu_estado=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna id_presu_estado");
					}
				}

				this.id_presu_estado=newid_presu_estado;
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
						System.out.println("PresuAsignacion:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("PresuAsignacion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public PresuProyectoCuenta getPresuProyectoCuenta() {
		return this.presuproyectocuenta;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public PresuEstado getPresuEstado() {
		return this.presuestado;
	}

	
	
	public String getpresuproyectocuenta_descripcion() {
		return this.presuproyectocuenta_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getpresuestado_descripcion() {
		return this.presuestado_descripcion;
	}

	
	
	public  void  setPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta) {
		try {
			this.presuproyectocuenta=presuproyectocuenta;
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


	public  void  setPresuEstado(PresuEstado presuestado) {
		try {
			this.presuestado=presuestado;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setpresuproyectocuenta_descripcion(String presuproyectocuenta_descripcion) {
		try {
			this.presuproyectocuenta_descripcion=presuproyectocuenta_descripcion;
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


	public  void  setpresuestado_descripcion(String presuestado_descripcion) {
		try {
			this.presuestado_descripcion=presuestado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_presu_proyecto_cuenta_descripcion="";String id_empleado_descripcion="";String id_presu_estado_descripcion="";
	
	
	public String getid_presu_proyecto_cuenta_descripcion() {
		return id_presu_proyecto_cuenta_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_presu_estado_descripcion() {
		return id_presu_estado_descripcion;
	}
	
	
	public void setid_presu_proyecto_cuenta_descripcion(String newid_presu_proyecto_cuenta_descripcion)throws Exception {
		try {
			this.id_presu_proyecto_cuenta_descripcion=newid_presu_proyecto_cuenta_descripcion;
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
	public void setid_presu_estado_descripcion(String newid_presu_estado_descripcion)throws Exception {
		try {
			this.id_presu_estado_descripcion=newid_presu_estado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_presu_proyecto_cuenta_descripcion="";this.id_empleado_descripcion="";this.id_presu_estado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

