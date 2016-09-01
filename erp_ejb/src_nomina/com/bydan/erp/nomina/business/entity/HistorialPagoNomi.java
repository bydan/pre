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
//import com.bydan.erp.nomina.util.HistorialPagoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class HistorialPagoNomi extends HistorialPagoNomiAdditional implements Serializable ,Cloneable {//HistorialPagoNomiAdditional,GeneralEntity
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
	
	private HistorialPagoNomi historialpagonomiOriginal;
	
	private Map<String, Object> mapHistorialPagoNomi;
			
	public Map<String, Object> getMapHistorialPagoNomi() {
		return mapHistorialPagoNomi;
	}

	public void setMapHistorialPagoNomi(Map<String, Object> mapHistorialPagoNomi) {
		this.mapHistorialPagoNomi = mapHistorialPagoNomi;
	}
	
	public void inicializarMapHistorialPagoNomi() {
		this.mapHistorialPagoNomi = new HashMap<String,Object>();
	}
	
	public void setMapHistorialPagoNomiValue(String sKey,Object oValue) {
		this.mapHistorialPagoNomi.put(sKey, oValue);
	}
	
	public Object getMapHistorialPagoNomiValue(String sKey) {
		return this.mapHistorialPagoNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_rubro_emplea;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_liquidacion;
			
	
	public Empresa empresa;
	public Estructura estructura;
	public Empleado empleado;
	public RubroEmplea rubroemplea;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String estructura_descripcion;
	private String empleado_descripcion;
	private String rubroemplea_descripcion;
	private String mes_descripcion;
	
	
		
	public HistorialPagoNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.historialpagonomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_estructura=-1L;
 		this.id_empleado=-1L;
 		this.id_rubro_emplea=-1L;
 		this.id_mes=null;
 		this.valor=0.0;
 		this.fecha=new Date();
 		this.fecha_liquidacion=new Date();
		
		
		this.empresa=null;
		this.estructura=null;
		this.empleado=null;
		this.rubroemplea=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.estructura_descripcion="";
		this.empleado_descripcion="";
		this.rubroemplea_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public HistorialPagoNomi (Long id,Date versionRow,Long id_empresa,Long id_estructura,Long id_empleado,Long id_rubro_emplea,Long id_mes,Double valor,Date fecha,Date fecha_liquidacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialpagonomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_mes=id_mes;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.fecha_liquidacion=fecha_liquidacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public HistorialPagoNomi (Long id_empresa,Long id_estructura,Long id_empleado,Long id_rubro_emplea,Long id_mes,Double valor,Date fecha,Date fecha_liquidacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.historialpagonomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_estructura=id_estructura;
 		this.id_empleado=id_empleado;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_mes=id_mes;
 		this.valor=valor;
 		this.fecha=fecha;
 		this.fecha_liquidacion=fecha_liquidacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		HistorialPagoNomi historialpagonomiLocal=null;
		
		if(object!=null) {
			historialpagonomiLocal=(HistorialPagoNomi)object;
			
			if(historialpagonomiLocal!=null) {
				if(this.getId()!=null && historialpagonomiLocal.getId()!=null) {
					if(this.getId().equals(historialpagonomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!HistorialPagoNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=HistorialPagoNomiConstantesFunciones.getHistorialPagoNomiDescripcion(this);
		} else {
			sDetalle=HistorialPagoNomiConstantesFunciones.getHistorialPagoNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public HistorialPagoNomi getHistorialPagoNomiOriginal() {
		return this.historialpagonomiOriginal;
	}
	
	public void setHistorialPagoNomiOriginal(HistorialPagoNomi historialpagonomi) {
		try {
			this.historialpagonomiOriginal=historialpagonomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected HistorialPagoNomiAdditional historialpagonomiAdditional=null;
	
	public HistorialPagoNomiAdditional getHistorialPagoNomiAdditional() {
		return this.historialpagonomiAdditional;
	}
	
	public void setHistorialPagoNomiAdditional(HistorialPagoNomiAdditional historialpagonomiAdditional) {
		try {
			this.historialpagonomiAdditional=historialpagonomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_rubro_emplea() {
		return this.id_rubro_emplea;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public Date getfecha_liquidacion() {
		return this.fecha_liquidacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_rubro_emplea(Long newid_rubro_emplea)throws Exception
	{
		try {
			if(this.id_rubro_emplea!=newid_rubro_emplea) {
				if(newid_rubro_emplea==null) {
					//newid_rubro_emplea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna id_rubro_emplea");
					}
				}

				this.id_rubro_emplea=newid_rubro_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
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
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna valor");
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
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_liquidacion(Date newfecha_liquidacion)throws Exception
	{
		try {
			if(this.fecha_liquidacion!=newfecha_liquidacion) {
				if(newfecha_liquidacion==null) {
					//newfecha_liquidacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("HistorialPagoNomi:Valor nulo no permitido en columna fecha_liquidacion");
					}
				}

				this.fecha_liquidacion=newfecha_liquidacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public RubroEmplea getRubroEmplea() {
		return this.rubroemplea;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getrubroemplea_descripcion() {
		return this.rubroemplea_descripcion;
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


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
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


	public  void  setRubroEmplea(RubroEmplea rubroemplea) {
		try {
			this.rubroemplea=rubroemplea;
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


	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	public  void  setrubroemplea_descripcion(String rubroemplea_descripcion) {
		try {
			this.rubroemplea_descripcion=rubroemplea_descripcion;
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
	String id_empresa_descripcion="";String id_estructura_descripcion="";String id_empleado_descripcion="";String id_rubro_emplea_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_rubro_emplea_descripcion() {
		return id_rubro_emplea_descripcion;
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
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
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
	public void setid_rubro_emplea_descripcion(String newid_rubro_emplea_descripcion)throws Exception {
		try {
			this.id_rubro_emplea_descripcion=newid_rubro_emplea_descripcion;
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
		this.id_empresa_descripcion="";this.id_estructura_descripcion="";this.id_empleado_descripcion="";this.id_rubro_emplea_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

