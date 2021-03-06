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



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.ConversionInvenConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ConversionInven extends ConversionInvenAdditional implements Serializable ,Cloneable {//ConversionInvenAdditional,GeneralEntity
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
	
	private ConversionInven conversioninvenOriginal;
	
	private Map<String, Object> mapConversionInven;
			
	public Map<String, Object> getMapConversionInven() {
		return mapConversionInven;
	}

	public void setMapConversionInven(Map<String, Object> mapConversionInven) {
		this.mapConversionInven = mapConversionInven;
	}
	
	public void inicializarMapConversionInven() {
		this.mapConversionInven = new HashMap<String,Object>();
	}
	
	public void setMapConversionInvenValue(String sKey,Object oValue) {
		this.mapConversionInven.put(sKey, oValue);
	}
	
	public Object getMapConversionInvenValue(String sKey) {
		return this.mapConversionInven.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_conversion_inven;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_unidad_conversion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ConversionInvenConstantesFunciones.SREGEXDESCRIPCION,message=ConversionInvenConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public TipoConversionInven tipoconversioninven;
	public Unidad unidad;
	public Unidad unidadconversion;
	
	
	private String empresa_descripcion;
	private String tipoconversioninven_descripcion;
	private String unidad_descripcion;
	private String unidadconversion_descripcion;
	
	
		
	public ConversionInven () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.conversioninvenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_conversion_inven=-1L;
 		this.id_unidad=-1L;
 		this.id_unidad_conversion=-1L;
 		this.valor=0.0;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.tipoconversioninven=null;
		this.unidad=null;
		this.unidadconversion=null;
		
		
		this.empresa_descripcion="";
		this.tipoconversioninven_descripcion="";
		this.unidad_descripcion="";
		this.unidadconversion_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConversionInven (Long id,Date versionRow,Long id_empresa,Long id_tipo_conversion_inven,Long id_unidad,Long id_unidad_conversion,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conversioninvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_conversion_inven=id_tipo_conversion_inven;
 		this.id_unidad=id_unidad;
 		this.id_unidad_conversion=id_unidad_conversion;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConversionInven (Long id_empresa,Long id_tipo_conversion_inven,Long id_unidad,Long id_unidad_conversion,Double valor,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.conversioninvenOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_conversion_inven=id_tipo_conversion_inven;
 		this.id_unidad=id_unidad;
 		this.id_unidad_conversion=id_unidad_conversion;
 		this.valor=valor;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ConversionInven conversioninvenLocal=null;
		
		if(object!=null) {
			conversioninvenLocal=(ConversionInven)object;
			
			if(conversioninvenLocal!=null) {
				if(this.getId()!=null && conversioninvenLocal.getId()!=null) {
					if(this.getId().equals(conversioninvenLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConversionInvenConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConversionInvenConstantesFunciones.getConversionInvenDescripcion(this);
		} else {
			sDetalle=ConversionInvenConstantesFunciones.getConversionInvenDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ConversionInven getConversionInvenOriginal() {
		return this.conversioninvenOriginal;
	}
	
	public void setConversionInvenOriginal(ConversionInven conversioninven) {
		try {
			this.conversioninvenOriginal=conversioninven;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConversionInvenAdditional conversioninvenAdditional=null;
	
	public ConversionInvenAdditional getConversionInvenAdditional() {
		return this.conversioninvenAdditional;
	}
	
	public void setConversionInvenAdditional(ConversionInvenAdditional conversioninvenAdditional) {
		try {
			this.conversioninvenAdditional=conversioninvenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_conversion_inven() {
		return this.id_tipo_conversion_inven;
	}
    
	
	public Long getid_unidad() {
		return this.id_unidad;
	}
    
	
	public Long getid_unidad_conversion() {
		return this.id_unidad_conversion;
	}
    
	
	public Double getvalor() {
		return this.valor;
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
						System.out.println("ConversionInven:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_conversion_inven(Long newid_tipo_conversion_inven)throws Exception
	{
		try {
			if(this.id_tipo_conversion_inven!=newid_tipo_conversion_inven) {
				if(newid_tipo_conversion_inven==null) {
					//newid_tipo_conversion_inven=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionInven:Valor nulo no permitido en columna id_tipo_conversion_inven");
					}
				}

				this.id_tipo_conversion_inven=newid_tipo_conversion_inven;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad(Long newid_unidad)throws Exception
	{
		try {
			if(this.id_unidad!=newid_unidad) {
				if(newid_unidad==null) {
					//newid_unidad=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionInven:Valor nulo no permitido en columna id_unidad");
					}
				}

				this.id_unidad=newid_unidad;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_unidad_conversion(Long newid_unidad_conversion)throws Exception
	{
		try {
			if(this.id_unidad_conversion!=newid_unidad_conversion) {
				if(newid_unidad_conversion==null) {
					//newid_unidad_conversion=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConversionInven:Valor nulo no permitido en columna id_unidad_conversion");
					}
				}

				this.id_unidad_conversion=newid_unidad_conversion;
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
						System.out.println("ConversionInven:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
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
						System.out.println("ConversionInven:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>50) {
					newdescripcion=newdescripcion.substring(0,48);
					System.out.println("ConversionInven:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna descripcion");
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

	public TipoConversionInven getTipoConversionInven() {
		return this.tipoconversioninven;
	}

	public Unidad getUnidad() {
		return this.unidad;
	}

	public Unidad getUnidadConversion() {
		return this.unidadconversion;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoconversioninven_descripcion() {
		return this.tipoconversioninven_descripcion;
	}

	public String getunidad_descripcion() {
		return this.unidad_descripcion;
	}

	public String getunidadconversion_descripcion() {
		return this.unidadconversion_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoConversionInven(TipoConversionInven tipoconversioninven) {
		try {
			this.tipoconversioninven=tipoconversioninven;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidad(Unidad unidad) {
		try {
			this.unidad=unidad;
		} catch(Exception e) {
			;
		}
	}


	public  void  setUnidadConversion(Unidad unidadconversion) {
		try {
			this.unidadconversion=unidadconversion;
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


	public  void  settipoconversioninven_descripcion(String tipoconversioninven_descripcion) {
		try {
			this.tipoconversioninven_descripcion=tipoconversioninven_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidad_descripcion(String unidad_descripcion) {
		try {
			this.unidad_descripcion=unidad_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setunidadconversion_descripcion(String unidadconversion_descripcion) {
		try {
			this.unidadconversion_descripcion=unidadconversion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_conversion_inven_descripcion="";String id_unidad_descripcion="";String id_unidad_conversion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_conversion_inven_descripcion() {
		return id_tipo_conversion_inven_descripcion;
	}
	public String getid_unidad_descripcion() {
		return id_unidad_descripcion;
	}
	public String getid_unidad_conversion_descripcion() {
		return id_unidad_conversion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_conversion_inven_descripcion(String newid_tipo_conversion_inven_descripcion)throws Exception {
		try {
			this.id_tipo_conversion_inven_descripcion=newid_tipo_conversion_inven_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_descripcion(String newid_unidad_descripcion)throws Exception {
		try {
			this.id_unidad_descripcion=newid_unidad_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_unidad_conversion_descripcion(String newid_unidad_conversion_descripcion)throws Exception {
		try {
			this.id_unidad_conversion_descripcion=newid_unidad_conversion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_conversion_inven_descripcion="";this.id_unidad_descripcion="";this.id_unidad_conversion_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

