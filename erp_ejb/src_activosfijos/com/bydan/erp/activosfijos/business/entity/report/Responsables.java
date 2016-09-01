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
//import com.bydan.erp.activosfijos.util.ResponsablesConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;

import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class Responsables extends ResponsablesAdditional implements Serializable ,Cloneable {//ResponsablesAdditional,GeneralEntity
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
	
	private Responsables responsablesOriginal;
	
	private Map<String, Object> mapResponsables;
			
	public Map<String, Object> getMapResponsables() {
		return mapResponsables;
	}

	public void setMapResponsables(Map<String, Object> mapResponsables) {
		this.mapResponsables = mapResponsables;
	}
	
	public void inicializarMapResponsables() {
		this.mapResponsables = new HashMap<String,Object>();
	}
	
	public void setMapResponsablesValue(String sKey,Object oValue) {
		this.mapResponsables.put(sKey, oValue);
	}
	
	public Object getMapResponsablesValue(String sKey) {
		return this.mapResponsables.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXCODIGO_EMPLEADO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXCODIGO_EMPLEADO)
	private String codigo_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXNOMBRE_EMPLEADO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXNOMBRE_EMPLEADO)
	private String nombre_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXAPELLIDO_EMPLEADO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXAPELLIDO_EMPLEADO)
	private String apellido_empleado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXNOMBRE_ESTRUCTURA,message=ResponsablesConstantesFunciones.SMENSAJEREGEXNOMBRE_ESTRUCTURA)
	private String nombre_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXUBICACION,message=ResponsablesConstantesFunciones.SMENSAJEREGEXUBICACION)
	private String ubicacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXDESCRIPCION,message=ResponsablesConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXNOMBRE,message=ResponsablesConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXCLAVE,message=ResponsablesConstantesFunciones.SMENSAJEREGEXCLAVE)
	private String clave;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXCODIGO_SUB_GRUPO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXCODIGO_SUB_GRUPO)
	private String codigo_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXNOMBRE_SUB_GRUPO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXNOMBRE_SUB_GRUPO)
	private String nombre_sub_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXCODIGO_DETALLE_GRUPO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXCODIGO_DETALLE_GRUPO)
	private String codigo_detalle_grupo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	//@Pattern(regex=ResponsablesConstantesFunciones.SREGEXNOMBRE_DETALLE_GRUPO,message=ResponsablesConstantesFunciones.SMENSAJEREGEXNOMBRE_DETALLE_GRUPO)
	private String nombre_detalle_grupo;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public Responsables () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.responsablesOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo_empleado="";
 		this.nombre_empleado="";
 		this.apellido_empleado="";
 		this.nombre_estructura="";
 		this.ubicacion="";
 		this.fecha=new Date();
 		this.descripcion="";
 		this.nombre="";
 		this.clave="";
 		this.codigo_sub_grupo="";
 		this.nombre_sub_grupo="";
 		this.codigo_detalle_grupo="";
 		this.nombre_detalle_grupo="";
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Responsables (Long id,Date versionRow,String codigo_empleado,String nombre_empleado,String apellido_empleado,String nombre_estructura,String ubicacion,Date fecha,String descripcion,String nombre,String clave,String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.responsablesOriginal=this;
		
 		this.codigo_empleado=codigo_empleado;
 		this.nombre_empleado=nombre_empleado;
 		this.apellido_empleado=apellido_empleado;
 		this.nombre_estructura=nombre_estructura;
 		this.ubicacion=ubicacion;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.nombre=nombre;
 		this.clave=clave;
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Responsables (String codigo_empleado,String nombre_empleado,String apellido_empleado,String nombre_estructura,String ubicacion,Date fecha,String descripcion,String nombre,String clave,String codigo_sub_grupo,String nombre_sub_grupo,String codigo_detalle_grupo,String nombre_detalle_grupo) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.responsablesOriginal=this;
		
 		this.codigo_empleado=codigo_empleado;
 		this.nombre_empleado=nombre_empleado;
 		this.apellido_empleado=apellido_empleado;
 		this.nombre_estructura=nombre_estructura;
 		this.ubicacion=ubicacion;
 		this.fecha=fecha;
 		this.descripcion=descripcion;
 		this.nombre=nombre;
 		this.clave=clave;
 		this.codigo_sub_grupo=codigo_sub_grupo;
 		this.nombre_sub_grupo=nombre_sub_grupo;
 		this.codigo_detalle_grupo=codigo_detalle_grupo;
 		this.nombre_detalle_grupo=nombre_detalle_grupo;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	
	public Responsables getResponsablesOriginal() {
		return this.responsablesOriginal;
	}
	
	public void setResponsablesOriginal(Responsables responsables) {
		try {
			this.responsablesOriginal=responsables;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ResponsablesAdditional responsablesAdditional=null;
	
	public ResponsablesAdditional getResponsablesAdditional() {
		return this.responsablesAdditional;
	}
	
	public void setResponsablesAdditional(ResponsablesAdditional responsablesAdditional) {
		try {
			this.responsablesAdditional=responsablesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo_empleado() {
		return this.codigo_empleado;
	}
    
	
	public String getnombre_empleado() {
		return this.nombre_empleado;
	}
    
	
	public String getapellido_empleado() {
		return this.apellido_empleado;
	}
    
	
	public String getnombre_estructura() {
		return this.nombre_estructura;
	}
    
	
	public String getubicacion() {
		return this.ubicacion;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getclave() {
		return this.clave;
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
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_empleado(String newcodigo_empleado)throws Exception
	{
		try {
			if(this.codigo_empleado!=newcodigo_empleado) {
				if(newcodigo_empleado==null) {
					//newcodigo_empleado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna codigo_empleado");
					}
				}

				if(newcodigo_empleado!=null&&newcodigo_empleado.length()>50) {
					newcodigo_empleado=newcodigo_empleado.substring(0,48);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_empleado");
				}

				this.codigo_empleado=newcodigo_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_empleado(String newnombre_empleado)throws Exception
	{
		try {
			if(this.nombre_empleado!=newnombre_empleado) {
				if(newnombre_empleado==null) {
					//newnombre_empleado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna nombre_empleado");
					}
				}

				if(newnombre_empleado!=null&&newnombre_empleado.length()>150) {
					newnombre_empleado=newnombre_empleado.substring(0,148);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_empleado");
				}

				this.nombre_empleado=newnombre_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setapellido_empleado(String newapellido_empleado)throws Exception
	{
		try {
			if(this.apellido_empleado!=newapellido_empleado) {
				if(newapellido_empleado==null) {
					//newapellido_empleado="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna apellido_empleado");
					}
				}

				if(newapellido_empleado!=null&&newapellido_empleado.length()>150) {
					newapellido_empleado=newapellido_empleado.substring(0,148);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna apellido_empleado");
				}

				this.apellido_empleado=newapellido_empleado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_estructura(String newnombre_estructura)throws Exception
	{
		try {
			if(this.nombre_estructura!=newnombre_estructura) {
				if(newnombre_estructura==null) {
					//newnombre_estructura="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna nombre_estructura");
					}
				}

				if(newnombre_estructura!=null&&newnombre_estructura.length()>100) {
					newnombre_estructura=newnombre_estructura.substring(0,98);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre_estructura");
				}

				this.nombre_estructura=newnombre_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setubicacion(String newubicacion)throws Exception
	{
		try {
			if(this.ubicacion!=newubicacion) {
				if(newubicacion==null) {
					//newubicacion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Responsables:Valor nulo no permitido en columna ubicacion");
					}
				}

				if(newubicacion!=null&&newubicacion.length()>100) {
					newubicacion=newubicacion.substring(0,98);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna ubicacion");
				}

				this.ubicacion=newubicacion;
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
						System.out.println("Responsables:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
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
						System.out.println("Responsables:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
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
						System.out.println("Responsables:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("Responsables:Valor nulo no permitido en columna clave");
					}
				}

				if(newclave!=null&&newclave.length()>50) {
					newclave=newclave.substring(0,48);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna clave");
				}

				this.clave=newclave;
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
						System.out.println("Responsables:Valor nulo no permitido en columna codigo_sub_grupo");
					}
				}

				if(newcodigo_sub_grupo!=null&&newcodigo_sub_grupo.length()>50) {
					newcodigo_sub_grupo=newcodigo_sub_grupo.substring(0,48);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sub_grupo");
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
						System.out.println("Responsables:Valor nulo no permitido en columna nombre_sub_grupo");
					}
				}

				if(newnombre_sub_grupo!=null&&newnombre_sub_grupo.length()>150) {
					newnombre_sub_grupo=newnombre_sub_grupo.substring(0,148);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_sub_grupo");
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
						System.out.println("Responsables:Valor nulo no permitido en columna codigo_detalle_grupo");
					}
				}

				if(newcodigo_detalle_grupo!=null&&newcodigo_detalle_grupo.length()>50) {
					newcodigo_detalle_grupo=newcodigo_detalle_grupo.substring(0,48);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_detalle_grupo");
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
						System.out.println("Responsables:Valor nulo no permitido en columna nombre_detalle_grupo");
					}
				}

				if(newnombre_detalle_grupo!=null&&newnombre_detalle_grupo.length()>150) {
					newnombre_detalle_grupo=newnombre_detalle_grupo.substring(0,148);
					System.out.println("Responsables:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre_detalle_grupo");
				}

				this.nombre_detalle_grupo=newnombre_detalle_grupo;
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

