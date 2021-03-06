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
package com.bydan.erp.activosfijos.business.entity.report;

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
//import com.bydan.erp.activosfijos.util.ConsolidadosResumenConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ConsolidadosResumen extends ConsolidadosResumenAdditional implements Serializable ,Cloneable {//ConsolidadosResumenAdditional,GeneralEntity
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
	
	private ConsolidadosResumen consolidadosresumenOriginal;
	
	private Map<String, Object> mapConsolidadosResumen;
			
	public Map<String, Object> getMapConsolidadosResumen() {
		return mapConsolidadosResumen;
	}

	public void setMapConsolidadosResumen(Map<String, Object> mapConsolidadosResumen) {
		this.mapConsolidadosResumen = mapConsolidadosResumen;
	}
	
	public void inicializarMapConsolidadosResumen() {
		this.mapConsolidadosResumen = new HashMap<String,Object>();
	}
	
	public void setMapConsolidadosResumenValue(String sKey,Object oValue) {
		this.mapConsolidadosResumen.put(sKey, oValue);
	}
	
	public Object getMapConsolidadosResumenValue(String sKey) {
		return this.mapConsolidadosResumen.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXNOMBRE_EMPRESA,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXNOMBRE_EMPRESA)
	private String nombre_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXNOMBRE_SUCURSAL,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXNOMBRE_SUCURSAL)
	private String nombre_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXCODIGO_SUB_GRUPO,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXCODIGO_SUB_GRUPO)
	private String codigo_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXNOMBRE_SUB_GRUPO,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXNOMBRE_SUB_GRUPO)
	private String nombre_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXCODIGO_DETALLE_GRUPO,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXCODIGO_DETALLE_GRUPO)
	private String codigo_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXNOMBRE_DETALLE_GRUPO,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXNOMBRE_DETALLE_GRUPO)
	private String nombre_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXCLAVE,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ConsolidadosResumenConstantesFunciones.SREGEXNOMBRE,message=ConsolidadosResumenConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double vida_util;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double costo_de_compra;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer cantidad;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public ConsolidadosResumen () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.consolidadosresumenOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre_empresa="";
 		this.nombre_sucursal="";
 		this.codigo_sub_grupo="";
 		this.nombre_sub_grupo="";
 		this.codigo_detalle_grupo="";
 		this.nombre_detalle_grupo="";
 		this.clave="";
 		this.nombre="";
 		this.fecha_compra=new Date();
 		this.vida_util=0.0;
 		this.costo_de_compra=0.0;
 		this.cantidad=0;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConsolidadosResumen (Long id,Date versionRow,String nombre_empresa,String nombre_sucursal,String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,Integer cantidad) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.consolidadosresumenOriginal=this;
		
 		this.nombre_empresa=nombre_empresa;
 		this.nombre_sucursal=nombre_sucursal;
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.cantidad=cantidad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConsolidadosResumen (String nombre_empresa,String nombre_sucursal,String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,Integer cantidad) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.consolidadosresumenOriginal=this;
		
 		this.nombre_empresa=nombre_empresa;
 		this.nombre_sucursal=nombre_sucursal;
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.cantidad=cantidad;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public ConsolidadosResumen getConsolidadosResumenOriginal() {
		return this.consolidadosresumenOriginal;
	}
	
	public void setConsolidadosResumenOriginal(ConsolidadosResumen consolidadosresumen) {
		try {
			this.consolidadosresumenOriginal=consolidadosresumen;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ConsolidadosResumenAdditional consolidadosresumenAdditional=null;
	
	public ConsolidadosResumenAdditional getConsolidadosResumenAdditional() {
		return this.consolidadosresumenAdditional;
	}
	
	public void setConsolidadosResumenAdditional(ConsolidadosResumenAdditional consolidadosresumenAdditional) {
		try {
			this.consolidadosresumenAdditional=consolidadosresumenAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre_empresa() {
		return this.nombre_empresa;
	}
    
	
	public String getnombre_sucursal() {
		return this.nombre_sucursal;
	}
    
	
	public String getcodigo_sub_grupo() {
		return this.codigo_sub_grupo;
	}
    
	
	public String getnombre_sub_grupo() {
		return this.nombre_sub_grupo;
	}
    
	
	public String getcodigo_detalle_grupo() {
		return this.codigo_detalle_grupo;
	}
    
	
	public String getnombre_detalle_grupo() {
		return this.nombre_detalle_grupo;
	}
    
	
	public String getclave() {
		return this.clave;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Date getfecha_compra() {
		return this.fecha_compra;
	}
    
	
	public Double getvida_util() {
		return this.vida_util;
	}
    
	
	public Double getcosto_de_compra() {
		return this.costo_de_compra;
	}
    
	
	public Integer getcantidad() {
		return this.cantidad;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_empresa(String newnombre_empresa)throws Exception
	{
		try {
			if(this.nombre_empresa!=newnombre_empresa) {
				if(newnombre_empresa==null) {
					//newnombre_empresa="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna nombre_empresa");
					}
				}

				if(newnombre_empresa!=null&&newnombre_empresa.length()>150) {
					newnombre_empresa=newnombre_empresa.substring(0,148);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_empresa");
				}

				this.nombre_empresa=newnombre_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sucursal(String newnombre_sucursal)throws Exception
	{
		try {
			if(this.nombre_sucursal!=newnombre_sucursal) {
				if(newnombre_sucursal==null) {
					//newnombre_sucursal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna nombre_sucursal");
					}
				}

				if(newnombre_sucursal!=null&&newnombre_sucursal.length()>150) {
					newnombre_sucursal=newnombre_sucursal.substring(0,148);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sucursal");
				}

				this.nombre_sucursal=newnombre_sucursal;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_sub_grupo(String newcodigo_sub_grupo)throws Exception
	{
		try {
			if(this.codigo_sub_grupo!=newcodigo_sub_grupo) {
				if(newcodigo_sub_grupo==null) {
					//newcodigo_sub_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna codigo_sub_grupo");
					}
				}

				if(newcodigo_sub_grupo!=null&&newcodigo_sub_grupo.length()>50) {
					newcodigo_sub_grupo=newcodigo_sub_grupo.substring(0,48);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sub_grupo");
				}

				this.codigo_sub_grupo=newcodigo_sub_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_sub_grupo(String newnombre_sub_grupo)throws Exception
	{
		try {
			if(this.nombre_sub_grupo!=newnombre_sub_grupo) {
				if(newnombre_sub_grupo==null) {
					//newnombre_sub_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna nombre_sub_grupo");
					}
				}

				if(newnombre_sub_grupo!=null&&newnombre_sub_grupo.length()>150) {
					newnombre_sub_grupo=newnombre_sub_grupo.substring(0,148);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sub_grupo");
				}

				this.nombre_sub_grupo=newnombre_sub_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_detalle_grupo(String newcodigo_detalle_grupo)throws Exception
	{
		try {
			if(this.codigo_detalle_grupo!=newcodigo_detalle_grupo) {
				if(newcodigo_detalle_grupo==null) {
					//newcodigo_detalle_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna codigo_detalle_grupo");
					}
				}

				if(newcodigo_detalle_grupo!=null&&newcodigo_detalle_grupo.length()>50) {
					newcodigo_detalle_grupo=newcodigo_detalle_grupo.substring(0,48);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_detalle_grupo");
				}

				this.codigo_detalle_grupo=newcodigo_detalle_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_detalle_grupo(String newnombre_detalle_grupo)throws Exception
	{
		try {
			if(this.nombre_detalle_grupo!=newnombre_detalle_grupo) {
				if(newnombre_detalle_grupo==null) {
					//newnombre_detalle_grupo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna nombre_detalle_grupo");
					}
				}

				if(newnombre_detalle_grupo!=null&&newnombre_detalle_grupo.length()>150) {
					newnombre_detalle_grupo=newnombre_detalle_grupo.substring(0,148);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_detalle_grupo");
				}

				this.nombre_detalle_grupo=newnombre_detalle_grupo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setclave(String newclave)throws Exception
	{
		try {
			if(this.clave!=newclave) {
				if(newclave==null) {
					//newclave="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
				}

				this.clave=newclave;
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
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("ConsolidadosResumen:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_compra(Date newfecha_compra)throws Exception
	{
		try {
			if(this.fecha_compra!=newfecha_compra) {
				if(newfecha_compra==null) {
					//newfecha_compra=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna fecha_compra");
					}
				}

				this.fecha_compra=newfecha_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvida_util(Double newvida_util)throws Exception
	{
		try {
			if(this.vida_util!=newvida_util) {
				if(newvida_util==null) {
					//newvida_util=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna vida_util");
					}
				}

				this.vida_util=newvida_util;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcosto_de_compra(Double newcosto_de_compra)throws Exception
	{
		try {
			if(this.costo_de_compra!=newcosto_de_compra) {
				if(newcosto_de_compra==null) {
					//newcosto_de_compra=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna costo_de_compra");
					}
				}

				this.costo_de_compra=newcosto_de_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcantidad(Integer newcantidad)throws Exception
	{
		try {
			if(this.cantidad!=newcantidad) {
				if(newcantidad==null) {
					//newcantidad=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConsolidadosResumen:Valor nulo no permitido en columna cantidad");
					}
				}

				this.cantidad=newcantidad;
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

