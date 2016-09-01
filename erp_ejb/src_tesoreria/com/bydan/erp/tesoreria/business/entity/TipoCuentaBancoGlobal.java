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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;



import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;




@SuppressWarnings("unused")
public class TipoCuentaBancoGlobal extends GeneralEntitySinIdGenerated implements Serializable ,Cloneable {//TipoCuentaBancoGlobalAdditional,GeneralEntity
	private static final long serialVersionUID=1L;
	
	public Object clone() {
        return super.clone();
    }
	
	protected Long id;
	protected Long idOriginal;
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
	
	public Long getIdOriginal() {
		return this.idOriginal;
	}
	
	public void setIdOriginal(Long newIdOriginal) {		
		this.idOriginal=newIdOriginal;
		super.setIdOriginal(newIdOriginal);
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
	
	private TipoCuentaBancoGlobal tipocuentabancoglobalOriginal;
	
	private Map<String, Object> mapTipoCuentaBancoGlobal;
			
	public Map<String, Object> getMapTipoCuentaBancoGlobal() {
		return mapTipoCuentaBancoGlobal;
	}

	public void setMapTipoCuentaBancoGlobal(Map<String, Object> mapTipoCuentaBancoGlobal) {
		this.mapTipoCuentaBancoGlobal = mapTipoCuentaBancoGlobal;
	}
	
	public void inicializarMapTipoCuentaBancoGlobal() {
		this.mapTipoCuentaBancoGlobal = new HashMap<String,Object>();
	}
	
	public void setMapTipoCuentaBancoGlobalValue(String sKey,Object oValue) {
		this.mapTipoCuentaBancoGlobal.put(sKey, oValue);
	}
	
	public Object getMapTipoCuentaBancoGlobalValue(String sKey) {
		return this.mapTipoCuentaBancoGlobal.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoCuentaBancoGlobalConstantesFunciones.SREGEXCODIGO,message=TipoCuentaBancoGlobalConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoCuentaBancoGlobalConstantesFunciones.SREGEXNOMBRE,message=TipoCuentaBancoGlobalConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
			
	
	
	
	
	
	public List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals;
	public List<DatoGeneralEmpleado> datogeneralempleados;
	public List<PoliticasCliente> politicasclientes;
	public List<Empleado> empleados;
	public List<ParametroTesoreriaDefecto> parametrotesoreriadefectos;
		
	public TipoCuentaBancoGlobal () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipocuentabancoglobalOriginal=this;
		
 		this.codigo="";
 		this.nombre="";
		
		
		
		
		
		
		this.bancotipocuentabancoglobals=null;
		this.datogeneralempleados=null;
		this.politicasclientes=null;
		this.empleados=null;
		this.parametrotesoreriadefectos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoCuentaBancoGlobal (Long id,Date versionRow,String codigo,String nombre) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocuentabancoglobalOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoCuentaBancoGlobal (String codigo,String nombre) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocuentabancoglobalOriginal=this;
		
 		this.codigo=codigo;
 		this.nombre=nombre;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoCuentaBancoGlobal tipocuentabancoglobalLocal=null;
		
		if(object!=null) {
			tipocuentabancoglobalLocal=(TipoCuentaBancoGlobal)object;
			
			if(tipocuentabancoglobalLocal!=null) {
				if(this.getId()!=null && tipocuentabancoglobalLocal.getId()!=null) {
					if(this.getId().equals(tipocuentabancoglobalLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoCuentaBancoGlobalConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(this);
		} else {
			sDetalle=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobalOriginal() {
		return this.tipocuentabancoglobalOriginal;
	}
	
	public void setTipoCuentaBancoGlobalOriginal(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		try {
			this.tipocuentabancoglobalOriginal=tipocuentabancoglobal;
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
						System.out.println("TipoCuentaBancoGlobal:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoCuentaBancoGlobal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoCuentaBancoGlobal:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoCuentaBancoGlobal:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	public List<BancoTipoCuentaBancoGlobal> getBancoTipoCuentaBancoGlobals() {
		return this.bancotipocuentabancoglobals;
	}

	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	public List<PoliticasCliente> getPoliticasClientes() {
		return this.politicasclientes;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public List<ParametroTesoreriaDefecto> getParametroTesoreriaDefectos() {
		return this.parametrotesoreriadefectos;
	}

	
	
	public  void  setBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals) {
		try {
			this.bancotipocuentabancoglobals=bancotipocuentabancoglobals;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPoliticasClientes(List<PoliticasCliente> politicasclientes) {
		try {
			this.politicasclientes=politicasclientes;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos) {
		try {
			this.parametrotesoreriadefectos=parametrotesoreriadefectos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	
	
	
	
	
	
	public void inicializarVariablesParaReporte() {
		
	}
	
	
	Object bancotipocuentabancoglobalsDescripcionReporte;
	Object datogeneralempleadosDescripcionReporte;
	Object politicasclientesDescripcionReporte;
	Object empleadosDescripcionReporte;
	Object cuentabancosDescripcionReporte;
	Object parametrotesoreriadefectosDescripcionReporte;
	
	
	public Object getbancotipocuentabancoglobalsDescripcionReporte() {
		return bancotipocuentabancoglobalsDescripcionReporte;
	}

	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getpoliticasclientesDescripcionReporte() {
		return politicasclientesDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	public Object getcuentabancosDescripcionReporte() {
		return cuentabancosDescripcionReporte;
	}

	public Object getparametrotesoreriadefectosDescripcionReporte() {
		return parametrotesoreriadefectosDescripcionReporte;
	}

	
	
	public  void  setbancotipocuentabancoglobalsDescripcionReporte(Object bancotipocuentabancoglobals) {
		try {
			this.bancotipocuentabancoglobalsDescripcionReporte=bancotipocuentabancoglobals;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setpoliticasclientesDescripcionReporte(Object politicasclientes) {
		try {
			this.politicasclientesDescripcionReporte=politicasclientes;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuentabancosDescripcionReporte(Object cuentabancos) {
		try {
			this.cuentabancosDescripcionReporte=cuentabancos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setparametrotesoreriadefectosDescripcionReporte(Object parametrotesoreriadefectos) {
		try {
			this.parametrotesoreriadefectosDescripcionReporte=parametrotesoreriadefectos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

