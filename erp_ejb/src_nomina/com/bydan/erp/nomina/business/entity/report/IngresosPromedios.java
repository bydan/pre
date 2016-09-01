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
package com.bydan.erp.nomina.business.entity.report;

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
//import com.bydan.erp.nomina.util.IngresosPromediosConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class IngresosPromedios extends IngresosPromediosAdditional implements Serializable ,Cloneable {//IngresosPromediosAdditional,GeneralEntity
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
	
	private IngresosPromedios ingresospromediosOriginal;
	
	private Map<String, Object> mapIngresosPromedios;
			
	public Map<String, Object> getMapIngresosPromedios() {
		return mapIngresosPromedios;
	}

	public void setMapIngresosPromedios(Map<String, Object> mapIngresosPromedios) {
		this.mapIngresosPromedios = mapIngresosPromedios;
	}
	
	public void inicializarMapIngresosPromedios() {
		this.mapIngresosPromedios = new HashMap<String,Object>();
	}
	
	public void setMapIngresosPromediosValue(String sKey,Object oValue) {
		this.mapIngresosPromedios.put(sKey, oValue);
	}
	
	public Object getMapIngresosPromediosValue(String sKey) {
		return this.mapIngresosPromedios.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosPromediosConstantesFunciones.SREGEXCODIGO,message=IngresosPromediosConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosPromediosConstantesFunciones.SREGEXCODIGO_CARGO,message=IngresosPromediosConstantesFunciones.SMENSAJEREGEXCODIGO_CARGO)
	private String codigo_cargo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosPromediosConstantesFunciones.SREGEXCODIGO_DATO,message=IngresosPromediosConstantesFunciones.SMENSAJEREGEXCODIGO_DATO)
	private String codigo_dato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosPromediosConstantesFunciones.SREGEXNOMBRE,message=IngresosPromediosConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_pago;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=IngresosPromediosConstantesFunciones.SREGEXNOMBRE_RUBRO_EMPLEA,message=IngresosPromediosConstantesFunciones.SMENSAJEREGEXNOMBRE_RUBRO_EMPLEA)
	private String nombre_rubro_emplea;
			
	
	public Estructura estructura;
	public Empresa empresa;
	public Anio anio;
	public Mes mes;
	
	
	private String estructura_descripcion;
	private String empresa_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public IngresosPromedios () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.ingresospromediosOriginal=this;
		
 		this.id_estructura=-1L;
 		this.codigo="";
 		this.id_empresa=-1L;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.codigo_cargo="";
 		this.codigo_dato="";
 		this.nombre="";
 		this.valor_pago=0.0;
 		this.nombre_rubro_emplea="";
		
		
		this.estructura=null;
		this.empresa=null;
		this.anio=null;
		this.mes=null;
		
		
		this.estructura_descripcion="";
		this.empresa_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public IngresosPromedios (Long id,Date versionRow,String codigo_cargo,String codigo_dato,String nombre,Double valor_pago,String nombre_rubro_emplea) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ingresospromediosOriginal=this;
		
 		this.codigo_cargo=codigo_cargo;
 		this.codigo_dato=codigo_dato;
 		this.nombre=nombre;
 		this.valor_pago=valor_pago;
 		this.nombre_rubro_emplea=nombre_rubro_emplea;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public IngresosPromedios (String codigo_cargo,String codigo_dato,String nombre,Double valor_pago,String nombre_rubro_emplea) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.ingresospromediosOriginal=this;
		
 		this.codigo_cargo=codigo_cargo;
 		this.codigo_dato=codigo_dato;
 		this.nombre=nombre;
 		this.valor_pago=valor_pago;
 		this.nombre_rubro_emplea=nombre_rubro_emplea;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public IngresosPromedios getIngresosPromediosOriginal() {
		return this.ingresospromediosOriginal;
	}
	
	public void setIngresosPromediosOriginal(IngresosPromedios ingresospromedios) {
		try {
			this.ingresospromediosOriginal=ingresospromedios;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected IngresosPromediosAdditional ingresospromediosAdditional=null;
	
	public IngresosPromediosAdditional getIngresosPromediosAdditional() {
		return this.ingresospromediosAdditional;
	}
	
	public void setIngresosPromediosAdditional(IngresosPromediosAdditional ingresospromediosAdditional) {
		try {
			this.ingresospromediosAdditional=ingresospromediosAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public String getcodigo_cargo() {
		return this.codigo_cargo;
	}
    
	
	public String getcodigo_dato() {
		return this.codigo_dato;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getvalor_pago() {
		return this.valor_pago;
	}
    
	
	public String getnombre_rubro_emplea() {
		return this.nombre_rubro_emplea;
	}
	
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
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
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("IngresosPromedios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
				}

				this.codigo=newcodigo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio(Long newid_anio) {
		if(this.id_anio==null&&newid_anio!=null) {
			this.id_anio=newid_anio;
				this.setIsChanged(true);
		}

		if(this.id_anio!=null&&!this.id_anio.equals(newid_anio)) {

			this.id_anio=newid_anio;
				this.setIsChanged(true);
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
    
	public void setcodigo_cargo(String newcodigo_cargo)throws Exception
	{
		try {
			if(this.codigo_cargo!=newcodigo_cargo) {
				if(newcodigo_cargo==null) {
					//newcodigo_cargo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna codigo_cargo");
					}
				}

				if(newcodigo_cargo!=null&&newcodigo_cargo.length()>50) {
					newcodigo_cargo=newcodigo_cargo.substring(0,48);
					System.out.println("IngresosPromedios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_cargo");
				}

				this.codigo_cargo=newcodigo_cargo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_dato(String newcodigo_dato)throws Exception
	{
		try {
			if(this.codigo_dato!=newcodigo_dato) {
				if(newcodigo_dato==null) {
					//newcodigo_dato="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna codigo_dato");
					}
				}

				if(newcodigo_dato!=null&&newcodigo_dato.length()>50) {
					newcodigo_dato=newcodigo_dato.substring(0,48);
					System.out.println("IngresosPromedios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_dato");
				}

				this.codigo_dato=newcodigo_dato;
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
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("IngresosPromedios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_pago(Double newvalor_pago)throws Exception
	{
		try {
			if(this.valor_pago!=newvalor_pago) {
				if(newvalor_pago==null) {
					//newvalor_pago=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna valor_pago");
					}
				}

				this.valor_pago=newvalor_pago;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_rubro_emplea(String newnombre_rubro_emplea)throws Exception
	{
		try {
			if(this.nombre_rubro_emplea!=newnombre_rubro_emplea) {
				if(newnombre_rubro_emplea==null) {
					//newnombre_rubro_emplea="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("IngresosPromedios:Valor nulo no permitido en columna nombre_rubro_emplea");
					}
				}

				if(newnombre_rubro_emplea!=null&&newnombre_rubro_emplea.length()>150) {
					newnombre_rubro_emplea=newnombre_rubro_emplea.substring(0,148);
					System.out.println("IngresosPromedios:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_rubro_emplea");
				}

				this.nombre_rubro_emplea=newnombre_rubro_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Estructura getEstructura() {
		return this.estructura;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	
	
	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnio(Anio anio) {
		try {
			this.anio=anio;
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


	
	
	public  void  setestructura_descripcion(String estructura_descripcion) {
		try {
			this.estructura_descripcion=estructura_descripcion;
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


	public  void  setanio_descripcion(String anio_descripcion) {
		try {
			this.anio_descripcion=anio_descripcion;
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
	String id_estructura_descripcion="";String id_empresa_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	
	
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_descripcion(String newid_anio_descripcion)throws Exception {
		try {
			this.id_anio_descripcion=newid_anio_descripcion;
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
		this.id_estructura_descripcion="";this.id_empresa_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

