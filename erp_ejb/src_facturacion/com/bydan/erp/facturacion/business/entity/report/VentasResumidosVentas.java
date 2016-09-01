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
package com.bydan.erp.facturacion.business.entity.report;

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
//import com.bydan.erp.facturacion.util.VentasResumidosVentasConstantesFunciones;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VentasResumidosVentas extends VentasResumidosVentasAdditional implements Serializable ,Cloneable {//VentasResumidosVentasAdditional,GeneralEntity
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
	
	private VentasResumidosVentas ventasresumidosventasOriginal;
	
	private Map<String, Object> mapVentasResumidosVentas;
			
	public Map<String, Object> getMapVentasResumidosVentas() {
		return mapVentasResumidosVentas;
	}

	public void setMapVentasResumidosVentas(Map<String, Object> mapVentasResumidosVentas) {
		this.mapVentasResumidosVentas = mapVentasResumidosVentas;
	}
	
	public void inicializarMapVentasResumidosVentas() {
		this.mapVentasResumidosVentas = new HashMap<String,Object>();
	}
	
	public void setMapVentasResumidosVentasValue(String sKey,Object oValue) {
		this.mapVentasResumidosVentas.put(sKey, oValue);
	}
	
	public Object getMapVentasResumidosVentasValue(String sKey) {
		return this.mapVentasResumidosVentas.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_desde;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_emision_hasta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidosVentasConstantesFunciones.SREGEXDIA,message=VentasResumidosVentasConstantesFunciones.SMENSAJEREGEXDIA)
	private String dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_sin_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double total_flete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidosVentasConstantesFunciones.SREGEXNOMBRE_ANIO,message=VentasResumidosVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_ANIO)
	private String nombre_anio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=VentasResumidosVentasConstantesFunciones.SREGEXNOMBRE_MES,message=VentasResumidosVentasConstantesFunciones.SMENSAJEREGEXNOMBRE_MES)
	private String nombre_mes;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public VentasResumidosVentas () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ventasresumidosventasOriginal=this;
		
 		this.id_empresa=-1L;
 		this.fecha_emision_desde=new Date();
 		this.fecha_emision_hasta=new Date();
 		this.dia="";
 		this.total_iva=0.0;
 		this.total_sin_iva=0.0;
 		this.total_flete=0.0;
 		this.iva=0.0;
 		this.nombre_anio="";
 		this.nombre_mes="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VentasResumidosVentas (Long id,Date versionRow,String dia,Double total_iva,Double total_sin_iva,Double total_flete,Double iva,String nombre_anio,String nombre_mes) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventasresumidosventasOriginal=this;
		
 		this.dia=dia;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.total_flete=total_flete;
 		this.iva=iva;
 		this.nombre_anio=nombre_anio;
 		this.nombre_mes=nombre_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VentasResumidosVentas (String dia,Double total_iva,Double total_sin_iva,Double total_flete,Double iva,String nombre_anio,String nombre_mes) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ventasresumidosventasOriginal=this;
		
 		this.dia=dia;
 		this.total_iva=total_iva;
 		this.total_sin_iva=total_sin_iva;
 		this.total_flete=total_flete;
 		this.iva=iva;
 		this.nombre_anio=nombre_anio;
 		this.nombre_mes=nombre_mes;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public VentasResumidosVentas getVentasResumidosVentasOriginal() {
		return this.ventasresumidosventasOriginal;
	}
	
	public void setVentasResumidosVentasOriginal(VentasResumidosVentas ventasresumidosventas) {
		try {
			this.ventasresumidosventasOriginal=ventasresumidosventas;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VentasResumidosVentasAdditional ventasresumidosventasAdditional=null;
	
	public VentasResumidosVentasAdditional getVentasResumidosVentasAdditional() {
		return this.ventasresumidosventasAdditional;
	}
	
	public void setVentasResumidosVentasAdditional(VentasResumidosVentasAdditional ventasresumidosventasAdditional) {
		try {
			this.ventasresumidosventasAdditional=ventasresumidosventasAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Date getfecha_emision_desde() {
		return this.fecha_emision_desde;
	}
    
	
	public Date getfecha_emision_hasta() {
		return this.fecha_emision_hasta;
	}
    
	
	public String getdia() {
		return this.dia;
	}
    
	
	public Double gettotal_iva() {
		return this.total_iva;
	}
    
	
	public Double gettotal_sin_iva() {
		return this.total_sin_iva;
	}
    
	
	public Double gettotal_flete() {
		return this.total_flete;
	}
    
	
	public Double getiva() {
		return this.iva;
	}
    
	
	public String getnombre_anio() {
		return this.nombre_anio;
	}
    
	
	public String getnombre_mes() {
		return this.nombre_mes;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_desde(Date newfecha_emision_desde)throws Exception
	{
		try {
			if(this.fecha_emision_desde!=newfecha_emision_desde) {
				if(newfecha_emision_desde==null) {
					//newfecha_emision_desde=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna fecha_emision_desde");
					}
				}

				this.fecha_emision_desde=newfecha_emision_desde;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_emision_hasta(Date newfecha_emision_hasta)throws Exception
	{
		try {
			if(this.fecha_emision_hasta!=newfecha_emision_hasta) {
				if(newfecha_emision_hasta==null) {
					//newfecha_emision_hasta=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna fecha_emision_hasta");
					}
				}

				this.fecha_emision_hasta=newfecha_emision_hasta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia(String newdia)throws Exception
	{
		try {
			if(this.dia!=newdia) {
				if(newdia==null) {
					//newdia="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna dia");
					}
				}

				if(newdia!=null&&newdia.length()>50) {
					newdia=newdia.substring(0,48);
					System.out.println("VentasResumidosVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna dia");
				}

				this.dia=newdia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_iva(Double newtotal_iva)throws Exception
	{
		try {
			if(this.total_iva!=newtotal_iva) {
				if(newtotal_iva==null) {
					//newtotal_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna total_iva");
					}
				}

				this.total_iva=newtotal_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_sin_iva(Double newtotal_sin_iva)throws Exception
	{
		try {
			if(this.total_sin_iva!=newtotal_sin_iva) {
				if(newtotal_sin_iva==null) {
					//newtotal_sin_iva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna total_sin_iva");
					}
				}

				this.total_sin_iva=newtotal_sin_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settotal_flete(Double newtotal_flete)throws Exception
	{
		try {
			if(this.total_flete!=newtotal_flete) {
				if(newtotal_flete==null) {
					//newtotal_flete=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna total_flete");
					}
				}

				this.total_flete=newtotal_flete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setiva(Double newiva)throws Exception
	{
		try {
			if(this.iva!=newiva) {
				if(newiva==null) {
					//newiva=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna iva");
					}
				}

				this.iva=newiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_anio(String newnombre_anio)throws Exception
	{
		try {
			if(this.nombre_anio!=newnombre_anio) {
				if(newnombre_anio==null) {
					//newnombre_anio="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna nombre_anio");
					}
				}

				if(newnombre_anio!=null&&newnombre_anio.length()>50) {
					newnombre_anio=newnombre_anio.substring(0,48);
					System.out.println("VentasResumidosVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_anio");
				}

				this.nombre_anio=newnombre_anio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_mes(String newnombre_mes)throws Exception
	{
		try {
			if(this.nombre_mes!=newnombre_mes) {
				if(newnombre_mes==null) {
					//newnombre_mes="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VentasResumidosVentas:Valor nulo no permitido en columna nombre_mes");
					}
				}

				if(newnombre_mes!=null&&newnombre_mes.length()>50) {
					newnombre_mes=newnombre_mes.substring(0,48);
					System.out.println("VentasResumidosVentas:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_mes");
				}

				this.nombre_mes=newnombre_mes;
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

