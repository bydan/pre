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
//import com.bydan.erp.contabilidad.util.AreaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class Area extends AreaAdditional implements Serializable ,Cloneable {//AreaAdditional,GeneralEntity
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
	
	private Area areaOriginal;
	
	private Map<String, Object> mapArea;
			
	public Map<String, Object> getMapArea() {
		return mapArea;
	}

	public void setMapArea(Map<String, Object> mapArea) {
		this.mapArea = mapArea;
	}
	
	public void inicializarMapArea() {
		this.mapArea = new HashMap<String,Object>();
	}
	
	public void setMapAreaValue(String sKey,Object oValue) {
		this.mapArea.put(sKey, oValue);
	}
	
	public Object getMapAreaValue(String sKey) {
		return this.mapArea.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empleado_sustituto;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AreaConstantesFunciones.SREGEXCODIGO,message=AreaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AreaConstantesFunciones.SREGEXNOMBRE,message=AreaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AreaConstantesFunciones.SREGEXSECUENCIAL_PEDIDO,message=AreaConstantesFunciones.SMENSAJEREGEXSECUENCIAL_PEDIDO)
	private String secuencial_pedido;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=AreaConstantesFunciones.SREGEXSECUENCIAL_COTIZACION,message=AreaConstantesFunciones.SMENSAJEREGEXSECUENCIAL_COTIZACION)
	private String secuencial_cotizacion;
			
	
	public Empresa empresa;
	public Empleado empleado;
	public Empleado empleadosustituto;
	
	
	private String empresa_descripcion;
	private String empleado_descripcion;
	private String empleadosustituto_descripcion;
	
	
		
	public Area () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.areaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_empleado=-1L;
 		this.id_empleado_sustituto=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.secuencial_pedido="";
 		this.secuencial_cotizacion="";
		
		
		this.empresa=null;
		this.empleado=null;
		this.empleadosustituto=null;
		
		
		this.empresa_descripcion="";
		this.empleado_descripcion="";
		this.empleadosustituto_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Area (Long id,Date versionRow,Long id_empresa,Long id_empleado,Long id_empleado_sustituto,String codigo,String nombre,String secuencial_pedido,String secuencial_cotizacion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.areaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_empleado_sustituto=id_empleado_sustituto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_cotizacion=secuencial_cotizacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Area (Long id_empresa,Long id_empleado,Long id_empleado_sustituto,String codigo,String nombre,String secuencial_pedido,String secuencial_cotizacion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.areaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_empleado=id_empleado;
 		this.id_empleado_sustituto=id_empleado_sustituto;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.secuencial_pedido=secuencial_pedido;
 		this.secuencial_cotizacion=secuencial_cotizacion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Area areaLocal=null;
		
		if(object!=null) {
			areaLocal=(Area)object;
			
			if(areaLocal!=null) {
				if(this.getId()!=null && areaLocal.getId()!=null) {
					if(this.getId().equals(areaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!AreaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=AreaConstantesFunciones.getAreaDescripcion(this);
		} else {
			sDetalle=AreaConstantesFunciones.getAreaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Area getAreaOriginal() {
		return this.areaOriginal;
	}
	
	public void setAreaOriginal(Area area) {
		try {
			this.areaOriginal=area;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected AreaAdditional areaAdditional=null;
	
	public AreaAdditional getAreaAdditional() {
		return this.areaAdditional;
	}
	
	public void setAreaAdditional(AreaAdditional areaAdditional) {
		try {
			this.areaAdditional=areaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_empleado() {
		return this.id_empleado;
	}
    
	
	public Long getid_empleado_sustituto() {
		return this.id_empleado_sustituto;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsecuencial_pedido() {
		return this.secuencial_pedido;
	}
    
	
	public String getsecuencial_cotizacion() {
		return this.secuencial_cotizacion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Area:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("Area:Valor nulo no permitido en columna id_empleado");
					}
				}

				this.id_empleado=newid_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empleado_sustituto(Long newid_empleado_sustituto)throws Exception
	{
		try {
			if(this.id_empleado_sustituto!=newid_empleado_sustituto) {
				if(newid_empleado_sustituto==null) {
					//newid_empleado_sustituto=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Area:Valor nulo no permitido en columna id_empleado_sustituto");
					}
				}

				this.id_empleado_sustituto=newid_empleado_sustituto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Area:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Area:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Area:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Area:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_pedido(String newsecuencial_pedido)throws Exception
	{
		try {
			if(this.secuencial_pedido!=newsecuencial_pedido) {
				if(newsecuencial_pedido==null) {
					//newsecuencial_pedido="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Area:Valor nulo no permitido en columna secuencial_pedido");
					}
				}

				if(newsecuencial_pedido!=null&&newsecuencial_pedido.length()>20) {
					newsecuencial_pedido=newsecuencial_pedido.substring(0,18);
					System.out.println("Area:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna secuencial_pedido");
				}

				this.secuencial_pedido=newsecuencial_pedido;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial_cotizacion(String newsecuencial_cotizacion)throws Exception
	{
		try {
			if(this.secuencial_cotizacion!=newsecuencial_cotizacion) {
				if(newsecuencial_cotizacion==null) {
					//newsecuencial_cotizacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Area:Valor nulo no permitido en columna secuencial_cotizacion");
					}
				}

				if(newsecuencial_cotizacion!=null&&newsecuencial_cotizacion.length()>20) {
					newsecuencial_cotizacion=newsecuencial_cotizacion.substring(0,18);
					System.out.println("Area:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna secuencial_cotizacion");
				}

				this.secuencial_cotizacion=newsecuencial_cotizacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public Empleado getEmpleadoSustituto() {
		return this.empleadosustituto;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getempleado_descripcion() {
		return this.empleado_descripcion;
	}

	public String getempleadosustituto_descripcion() {
		return this.empleadosustituto_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
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


	public  void  setEmpleadoSustituto(Empleado empleadosustituto) {
		try {
			this.empleadosustituto=empleadosustituto;
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


	public  void  setempleado_descripcion(String empleado_descripcion) {
		try {
			this.empleado_descripcion=empleado_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setempleadosustituto_descripcion(String empleadosustituto_descripcion) {
		try {
			this.empleadosustituto_descripcion=empleadosustituto_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_empleado_descripcion="";String id_empleado_sustituto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_empleado_descripcion() {
		return id_empleado_descripcion;
	}
	public String getid_empleado_sustituto_descripcion() {
		return id_empleado_sustituto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
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
	public void setid_empleado_sustituto_descripcion(String newid_empleado_sustituto_descripcion)throws Exception {
		try {
			this.id_empleado_sustituto_descripcion=newid_empleado_sustituto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_empleado_descripcion="";this.id_empleado_sustituto_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

