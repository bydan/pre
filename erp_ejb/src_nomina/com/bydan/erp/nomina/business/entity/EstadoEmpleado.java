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
//import com.bydan.erp.nomina.util.EstadoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class EstadoEmpleado extends EstadoEmpleadoAdditional implements Serializable ,Cloneable {//EstadoEmpleadoAdditional,GeneralEntity
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
	
	private EstadoEmpleado estadoempleadoOriginal;
	
	private Map<String, Object> mapEstadoEmpleado;
			
	public Map<String, Object> getMapEstadoEmpleado() {
		return mapEstadoEmpleado;
	}

	public void setMapEstadoEmpleado(Map<String, Object> mapEstadoEmpleado) {
		this.mapEstadoEmpleado = mapEstadoEmpleado;
	}
	
	public void inicializarMapEstadoEmpleado() {
		this.mapEstadoEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapEstadoEmpleadoValue(String sKey,Object oValue) {
		this.mapEstadoEmpleado.put(sKey, oValue);
	}
	
	public Object getMapEstadoEmpleadoValue(String sKey) {
		return this.mapEstadoEmpleado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoEmpleadoConstantesFunciones.SREGEXCODIGO,message=EstadoEmpleadoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=EstadoEmpleadoConstantesFunciones.SREGEXNOMBRE,message=EstadoEmpleadoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<Empleado> empleados;
	public List<CierreRolMensual> cierrerolmensuals;
		
	public EstadoEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.estadoempleadoOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.empleados=null;
		this.cierrerolmensuals=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public EstadoEmpleado (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadoempleadoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public EstadoEmpleado (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.estadoempleadoOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		EstadoEmpleado estadoempleadoLocal=null;
		
		if(object!=null) {
			estadoempleadoLocal=(EstadoEmpleado)object;
			
			if(estadoempleadoLocal!=null) {
				if(this.getId()!=null && estadoempleadoLocal.getId()!=null) {
					if(this.getId().equals(estadoempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!EstadoEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcion(this);
		} else {
			sDetalle=EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public EstadoEmpleado getEstadoEmpleadoOriginal() {
		return this.estadoempleadoOriginal;
	}
	
	public void setEstadoEmpleadoOriginal(EstadoEmpleado estadoempleado) {
		try {
			this.estadoempleadoOriginal=estadoempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected EstadoEmpleadoAdditional estadoempleadoAdditional=null;
	
	public EstadoEmpleadoAdditional getEstadoEmpleadoAdditional() {
		return this.estadoempleadoAdditional;
	}
	
	public void setEstadoEmpleadoAdditional(EstadoEmpleadoAdditional estadoempleadoAdditional) {
		try {
			this.estadoempleadoAdditional=estadoempleadoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
	
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("EstadoEmpleado:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("EstadoEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
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
						System.out.println("EstadoEmpleado:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("EstadoEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<CierreRolMensual> getCierreRolMensuals() {
		return this.cierrerolmensuals;
	}

	
	
	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCierreRolMensuals(List<CierreRolMensual> cierrerolmensuals) {
		try {
			this.cierrerolmensuals=cierrerolmensuals;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object empleadosDescripcionReporte;
	Object cierrerolmensualsDescripcionReporte;
	
	
	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getcierrerolmensualsDescripcionReporte() {
		return cierrerolmensualsDescripcionReporte;
	}

	
	
	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcierrerolmensualsDescripcionReporte(Object cierrerolmensuals) {
		try {
			this.cierrerolmensualsDescripcionReporte=cierrerolmensuals;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

