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
//import com.bydan.erp.activosfijos.util.DepreciacionesConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Depreciaciones extends DepreciacionesAdditional implements Serializable ,Cloneable {//DepreciacionesAdditional,GeneralEntity
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
	
	private Depreciaciones depreciacionesOriginal;
	
	private Map<String, Object> mapDepreciaciones;
			
	public Map<String, Object> getMapDepreciaciones() {
		return mapDepreciaciones;
	}

	public void setMapDepreciaciones(Map<String, Object> mapDepreciaciones) {
		this.mapDepreciaciones = mapDepreciaciones;
	}
	
	public void inicializarMapDepreciaciones() {
		this.mapDepreciaciones = new HashMap<String,Object>();
	}
	
	public void setMapDepreciacionesValue(String sKey,Object oValue) {
		this.mapDepreciaciones.put(sKey, oValue);
	}
	
	public Object getMapDepreciacionesValue(String sKey) {
		return this.mapDepreciaciones.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_inicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_fin;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXCODIGO_SUB_GRUPO,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXCODIGO_SUB_GRUPO)
	private String codigo_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXNOMBRE_SUB_GRUPO,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXNOMBRE_SUB_GRUPO)
	private String nombre_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXCODIGO_DETALLE_GRUPO,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXCODIGO_DETALLE_GRUPO)
	private String codigo_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXNOMBRE_DETALLE_GRUPO,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXNOMBRE_DETALLE_GRUPO)
	private String nombre_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXCLAVE,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=DepreciacionesConstantesFunciones.SREGEXNOMBRE,message=DepreciacionesConstantesFunciones.SMENSAJEREGEXNOMBRE)
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
	private Date fecha_mantenimiento;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha_depreciacion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_acumulado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor_gasto;
			
	
	public Empresa empresa;
	public Anio anioinicio;
	public Anio aniofin;
	public Mes mesinicio;
	public Mes mesfin;
	public Anio anio;
	public Mes mes;
	
	
	private String empresa_descripcion;
	private String anioinicio_descripcion;
	private String aniofin_descripcion;
	private String mesinicio_descripcion;
	private String mesfin_descripcion;
	private String anio_descripcion;
	private String mes_descripcion;
	
	
		
	public Depreciaciones () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.depreciacionesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_anio_inicio=-1L;
 		this.id_anio_fin=-1L;
 		this.id_mes_inicio=-1L;
 		this.id_mes_fin=-1L;
 		this.codigo_sub_grupo="";
 		this.nombre_sub_grupo="";
 		this.codigo_detalle_grupo="";
 		this.nombre_detalle_grupo="";
 		this.clave="";
 		this.nombre="";
 		this.fecha_compra=new Date();
 		this.vida_util=0.0;
 		this.costo_de_compra=0.0;
 		this.fecha_mantenimiento=new Date();
 		this.fecha_depreciacion=new Date();
 		this.id_anio=null;
 		this.id_mes=null;
 		this.valor_acumulado=0.0;
 		this.valor_gasto=0.0;
		
		
		this.empresa=null;
		this.anioinicio=null;
		this.aniofin=null;
		this.mesinicio=null;
		this.mesfin=null;
		this.anio=null;
		this.mes=null;
		
		
		this.empresa_descripcion="";
		this.anioinicio_descripcion="";
		this.aniofin_descripcion="";
		this.mesinicio_descripcion="";
		this.mesfin_descripcion="";
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Depreciaciones (Long id,Date versionRow,String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,Date fecha_mantenimiento,Date fecha_depreciacion,Long id_anio,Long id_mes,Double valor_acumulado,Double valor_gasto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.depreciacionesOriginal=this;
		
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.fecha_mantenimiento=fecha_mantenimiento;
 		this.fecha_depreciacion=fecha_depreciacion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.valor_acumulado=valor_acumulado;
 		this.valor_gasto=valor_gasto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Depreciaciones (String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo,String clave,String nombre,Date fecha_compra,Double vida_util,Double costo_de_compra,Date fecha_mantenimiento,Date fecha_depreciacion,Long id_anio,Long id_mes,Double valor_acumulado,Double valor_gasto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.depreciacionesOriginal=this;
		
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
 		this.clave=clave;
 		this.nombre=nombre;
 		this.fecha_compra=fecha_compra;
 		this.vida_util=vida_util;
 		this.costo_de_compra=costo_de_compra;
 		this.fecha_mantenimiento=fecha_mantenimiento;
 		this.fecha_depreciacion=fecha_depreciacion;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.valor_acumulado=valor_acumulado;
 		this.valor_gasto=valor_gasto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public Depreciaciones getDepreciacionesOriginal() {
		return this.depreciacionesOriginal;
	}
	
	public void setDepreciacionesOriginal(Depreciaciones depreciaciones) {
		try {
			this.depreciacionesOriginal=depreciaciones;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DepreciacionesAdditional depreciacionesAdditional=null;
	
	public DepreciacionesAdditional getDepreciacionesAdditional() {
		return this.depreciacionesAdditional;
	}
	
	public void setDepreciacionesAdditional(DepreciacionesAdditional depreciacionesAdditional) {
		try {
			this.depreciacionesAdditional=depreciacionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_anio_inicio() {
		return this.id_anio_inicio;
	}
    
	
	public Long getid_anio_fin() {
		return this.id_anio_fin;
	}
    
	
	public Long getid_mes_inicio() {
		return this.id_mes_inicio;
	}
    
	
	public Long getid_mes_fin() {
		return this.id_mes_fin;
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
    
	
	public Date getfecha_mantenimiento() {
		return this.fecha_mantenimiento;
	}
    
	
	public Date getfecha_depreciacion() {
		return this.fecha_depreciacion;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Double getvalor_acumulado() {
		return this.valor_acumulado;
	}
    
	
	public Double getvalor_gasto() {
		return this.valor_gasto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio_inicio(Long newid_anio_inicio)throws Exception
	{
		try {
			if(this.id_anio_inicio!=newid_anio_inicio) {
				if(newid_anio_inicio==null) {
					//newid_anio_inicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna id_anio_inicio");
					}
				}

				this.id_anio_inicio=newid_anio_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_anio_fin(Long newid_anio_fin)throws Exception
	{
		try {
			if(this.id_anio_fin!=newid_anio_fin) {
				if(newid_anio_fin==null) {
					//newid_anio_fin=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna id_anio_fin");
					}
				}

				this.id_anio_fin=newid_anio_fin;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_inicio(Long newid_mes_inicio)throws Exception
	{
		try {
			if(this.id_mes_inicio!=newid_mes_inicio) {
				if(newid_mes_inicio==null) {
					//newid_mes_inicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna id_mes_inicio");
					}
				}

				this.id_mes_inicio=newid_mes_inicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_fin(Long newid_mes_fin)throws Exception
	{
		try {
			if(this.id_mes_fin!=newid_mes_fin) {
				if(newid_mes_fin==null) {
					//newid_mes_fin=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna id_mes_fin");
					}
				}

				this.id_mes_fin=newid_mes_fin;
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna codigo_sub_grupo");
					}
				}

				if(newcodigo_sub_grupo!=null&&newcodigo_sub_grupo.length()>50) {
					newcodigo_sub_grupo=newcodigo_sub_grupo.substring(0,48);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sub_grupo");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna nombre_sub_grupo");
					}
				}

				if(newnombre_sub_grupo!=null&&newnombre_sub_grupo.length()>150) {
					newnombre_sub_grupo=newnombre_sub_grupo.substring(0,148);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sub_grupo");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna codigo_detalle_grupo");
					}
				}

				if(newcodigo_detalle_grupo!=null&&newcodigo_detalle_grupo.length()>50) {
					newcodigo_detalle_grupo=newcodigo_detalle_grupo.substring(0,48);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_detalle_grupo");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna nombre_detalle_grupo");
					}
				}

				if(newnombre_detalle_grupo!=null&&newnombre_detalle_grupo.length()>150) {
					newnombre_detalle_grupo=newnombre_detalle_grupo.substring(0,148);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_detalle_grupo");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Depreciaciones:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna fecha_compra");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna vida_util");
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
						System.out.println("Depreciaciones:Valor nulo no permitido en columna costo_de_compra");
					}
				}

				this.costo_de_compra=newcosto_de_compra;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_mantenimiento(Date newfecha_mantenimiento)throws Exception
	{
		try {
			if(this.fecha_mantenimiento!=newfecha_mantenimiento) {
				if(newfecha_mantenimiento==null) {
					//newfecha_mantenimiento=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna fecha_mantenimiento");
					}
				}

				this.fecha_mantenimiento=newfecha_mantenimiento;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setfecha_depreciacion(Date newfecha_depreciacion)throws Exception
	{
		try {
			if(this.fecha_depreciacion!=newfecha_depreciacion) {
				if(newfecha_depreciacion==null) {
					//newfecha_depreciacion=new Date();
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna fecha_depreciacion");
					}
				}

				this.fecha_depreciacion=newfecha_depreciacion;
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
    
	public void setvalor_acumulado(Double newvalor_acumulado)throws Exception
	{
		try {
			if(this.valor_acumulado!=newvalor_acumulado) {
				if(newvalor_acumulado==null) {
					//newvalor_acumulado=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna valor_acumulado");
					}
				}

				this.valor_acumulado=newvalor_acumulado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor_gasto(Double newvalor_gasto)throws Exception
	{
		try {
			if(this.valor_gasto!=newvalor_gasto) {
				if(newvalor_gasto==null) {
					//newvalor_gasto=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Depreciaciones:Valor nulo no permitido en columna valor_gasto");
					}
				}

				this.valor_gasto=newvalor_gasto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Anio getAnioInicio() {
		return this.anioinicio;
	}

	public Anio getAnioFin() {
		return this.aniofin;
	}

	public Mes getMesInicio() {
		return this.mesinicio;
	}

	public Mes getMesFin() {
		return this.mesfin;
	}

	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getanioinicio_descripcion() {
		return this.anioinicio_descripcion;
	}

	public String getaniofin_descripcion() {
		return this.aniofin_descripcion;
	}

	public String getmesinicio_descripcion() {
		return this.mesinicio_descripcion;
	}

	public String getmesfin_descripcion() {
		return this.mesfin_descripcion;
	}

	public String getanio_descripcion() {
		return this.anio_descripcion;
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


	public  void  setAnioInicio(Anio anioinicio) {
		try {
			this.anioinicio=anioinicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setAnioFin(Anio aniofin) {
		try {
			this.aniofin=aniofin;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesInicio(Mes mesinicio) {
		try {
			this.mesinicio=mesinicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesFin(Mes mesfin) {
		try {
			this.mesfin=mesfin;
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


	
	
	public  void  setempresa_descripcion(String empresa_descripcion) {
		try {
			this.empresa_descripcion=empresa_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setanioinicio_descripcion(String anioinicio_descripcion) {
		try {
			this.anioinicio_descripcion=anioinicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setaniofin_descripcion(String aniofin_descripcion) {
		try {
			this.aniofin_descripcion=aniofin_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesinicio_descripcion(String mesinicio_descripcion) {
		try {
			this.mesinicio_descripcion=mesinicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesfin_descripcion(String mesfin_descripcion) {
		try {
			this.mesfin_descripcion=mesfin_descripcion;
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
	String id_empresa_descripcion="";String id_anio_inicio_descripcion="";String id_anio_fin_descripcion="";String id_mes_inicio_descripcion="";String id_mes_fin_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_anio_inicio_descripcion() {
		return id_anio_inicio_descripcion;
	}
	public String getid_anio_fin_descripcion() {
		return id_anio_fin_descripcion;
	}
	public String getid_mes_inicio_descripcion() {
		return id_mes_inicio_descripcion;
	}
	public String getid_mes_fin_descripcion() {
		return id_mes_fin_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
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
	public void setid_anio_inicio_descripcion(String newid_anio_inicio_descripcion)throws Exception {
		try {
			this.id_anio_inicio_descripcion=newid_anio_inicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_anio_fin_descripcion(String newid_anio_fin_descripcion)throws Exception {
		try {
			this.id_anio_fin_descripcion=newid_anio_fin_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_inicio_descripcion(String newid_mes_inicio_descripcion)throws Exception {
		try {
			this.id_mes_inicio_descripcion=newid_mes_inicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_fin_descripcion(String newid_mes_fin_descripcion)throws Exception {
		try {
			this.id_mes_fin_descripcion=newid_mes_fin_descripcion;
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
		this.id_empresa_descripcion="";this.id_anio_inicio_descripcion="";this.id_anio_fin_descripcion="";this.id_mes_inicio_descripcion="";this.id_mes_fin_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

