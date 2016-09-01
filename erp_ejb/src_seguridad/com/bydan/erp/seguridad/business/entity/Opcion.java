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
package com.bydan.erp.seguridad.business.entity;

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
//import com.bydan.erp.seguridad.util.OpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class Opcion extends OpcionAdditional implements Serializable ,Cloneable {//OpcionAdditional,GeneralEntity
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
	
	private Opcion opcionOriginal;
	
	private Map<String, Object> mapOpcion;
			
	public Map<String, Object> getMapOpcion() {
		return mapOpcion;
	}

	public void setMapOpcion(Map<String, Object> mapOpcion) {
		this.mapOpcion = mapOpcion;
	}
	
	public void inicializarMapOpcion() {
		this.mapOpcion = new HashMap<String,Object>();
	}
	
	public void setMapOpcionValue(String sKey,Object oValue) {
		this.mapOpcion.put(sKey, oValue);
	}
	
	public Object getMapOpcionValue(String sKey) {
		return this.mapOpcion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_opcion;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	private Long id_opcion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXCODIGO,message=OpcionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXNOMBRE,message=OpcionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tecla_mascara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXTECLA,message=OpcionConstantesFunciones.SMENSAJEREGEXTECLA)
	private String tecla;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=5,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONSMALLINT)
	private Short posicion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXICON_NAME,message=OpcionConstantesFunciones.SMENSAJEREGEXICON_NAME)
	private String icon_name;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXNOMBRE_CLASE,message=OpcionConstantesFunciones.SMENSAJEREGEXNOMBRE_CLASE)
	private String nombre_clase;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXSUB_MODULO,message=OpcionConstantesFunciones.SMENSAJEREGEXSUB_MODULO)
	private String sub_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXPAQUETE,message=OpcionConstantesFunciones.SMENSAJEREGEXPAQUETE)
	private String paquete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXPAQUETE_ORIGINAL,message=OpcionConstantesFunciones.SMENSAJEREGEXPAQUETE_ORIGINAL)
	private String paquete_original;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=OpcionConstantesFunciones.SREGEXPATH_AUXILIAR,message=OpcionConstantesFunciones.SMENSAJEREGEXPATH_AUXILIAR)
	private String path_auxiliar;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_menu;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_mostrar_acciones_campo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_guardar_relaciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
			
	
	public Sistema sistema;
	public Modulo modulo;
	public GrupoOpcion grupoopcion;
	public Opcion opcion;
	public TipoTeclaMascara tipoteclamascara;
	
	
	private String sistema_descripcion;
	private String modulo_descripcion;
	private String grupoopcion_descripcion;
	private String opcion_descripcion;
	private String tipoteclamascara_descripcion;
	
	
	public List<UsuarioOpcion> usuarioopcions;
	public List<Opcion> opcions;
	public List<Accion> accions;
	public List<PerfilOpcion> perfilopcions;
	public List<Campo> campos;
		
	public Opcion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.opcionOriginal=this;
		
 		this.id_sistema=-1L;
 		this.id_modulo=-1L;
 		this.id_grupo_opcion=null;
 		this.id_opcion=null;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_tecla_mascara=-1L;
 		this.tecla="";
 		this.posicion=Short.parseShort("0");
 		this.icon_name="";
 		this.nombre_clase="";
 		this.sub_modulo="";
 		this.paquete="";
 		this.paquete_original="";
 		this.path_auxiliar="";
 		this.es_para_menu=false;
 		this.con_mostrar_acciones_campo=false;
 		this.es_guardar_relaciones=false;
 		this.estado=false;
		
		
		this.sistema=null;
		this.modulo=null;
		this.grupoopcion=null;
		this.tipoteclamascara=null;
		
		
		this.sistema_descripcion="";
		this.modulo_descripcion="";
		this.grupoopcion_descripcion="";
		this.tipoteclamascara_descripcion="";
		
		
		this.usuarioopcions=null;
		this.opcions=null;
		this.accions=null;
		this.perfilopcions=null;
		this.campos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Opcion (Long id,Date versionRow,Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_opcion,String codigo,String nombre,Long id_tipo_tecla_mascara,String tecla,Short posicion,String icon_name,String nombre_clase,String sub_modulo,String paquete,String paquete_original,String path_auxiliar,Boolean es_para_menu,Boolean con_mostrar_acciones_campo,Boolean es_guardar_relaciones,Boolean estado) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.opcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_opcion=id_opcion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_tecla_mascara=id_tipo_tecla_mascara;
 		this.tecla=tecla;
 		this.posicion=posicion;
 		this.icon_name=icon_name;
 		this.nombre_clase=nombre_clase;
 		this.sub_modulo=sub_modulo;
 		this.paquete=paquete;
 		this.paquete_original=paquete_original;
 		this.path_auxiliar=path_auxiliar;
 		this.es_para_menu=es_para_menu;
 		this.con_mostrar_acciones_campo=con_mostrar_acciones_campo;
 		this.es_guardar_relaciones=es_guardar_relaciones;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Opcion (Long id_sistema,Long id_modulo,Long id_grupo_opcion,Long id_opcion,String codigo,String nombre,Long id_tipo_tecla_mascara,String tecla,Short posicion,String icon_name,String nombre_clase,String sub_modulo,String paquete,String paquete_original,String path_auxiliar,Boolean es_para_menu,Boolean con_mostrar_acciones_campo,Boolean es_guardar_relaciones,Boolean estado) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.opcionOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_modulo=id_modulo;
 		this.id_grupo_opcion=id_grupo_opcion;
 		this.id_opcion=id_opcion;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_tecla_mascara=id_tipo_tecla_mascara;
 		this.tecla=tecla;
 		this.posicion=posicion;
 		this.icon_name=icon_name;
 		this.nombre_clase=nombre_clase;
 		this.sub_modulo=sub_modulo;
 		this.paquete=paquete;
 		this.paquete_original=paquete_original;
 		this.path_auxiliar=path_auxiliar;
 		this.es_para_menu=es_para_menu;
 		this.con_mostrar_acciones_campo=con_mostrar_acciones_campo;
 		this.es_guardar_relaciones=es_guardar_relaciones;
 		this.estado=estado;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Opcion opcionLocal=null;
		
		if(object!=null) {
			opcionLocal=(Opcion)object;
			
			if(opcionLocal!=null) {
				if(this.getId()!=null && opcionLocal.getId()!=null) {
					if(this.getId().equals(opcionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!OpcionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=OpcionConstantesFunciones.getOpcionDescripcion(this);
		} else {
			sDetalle=OpcionConstantesFunciones.getOpcionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Opcion getOpcionOriginal() {
		return this.opcionOriginal;
	}
	
	public void setOpcionOriginal(Opcion opcion) {
		try {
			this.opcionOriginal=opcion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected OpcionAdditional opcionAdditional=null;
	
	public OpcionAdditional getOpcionAdditional() {
		return this.opcionAdditional;
	}
	
	public void setOpcionAdditional(OpcionAdditional opcionAdditional) {
		try {
			this.opcionAdditional=opcionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_sistema() {
		return this.id_sistema;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_grupo_opcion() {
		return this.id_grupo_opcion;
	}
    
	
	public Long getid_opcion() {
		return this.id_opcion;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_tecla_mascara() {
		return this.id_tipo_tecla_mascara;
	}
    
	
	public String gettecla() {
		return this.tecla;
	}
    
	
	public Short getposicion() {
		return this.posicion;
	}
    
	
	public String geticon_name() {
		return this.icon_name;
	}
    
	
	public String getnombre_clase() {
		return this.nombre_clase;
	}
    
	
	public String getsub_modulo() {
		return this.sub_modulo;
	}
    
	
	public String getpaquete() {
		return this.paquete;
	}
    
	
	public String getpaquete_original() {
		return this.paquete_original;
	}
    
	
	public String getpath_auxiliar() {
		return this.path_auxiliar;
	}
    
	
	public Boolean getes_para_menu() {
		return this.es_para_menu;
	}
    
	
	public Boolean getcon_mostrar_acciones_campo() {
		return this.con_mostrar_acciones_campo;
	}
    
	
	public Boolean getes_guardar_relaciones() {
		return this.es_guardar_relaciones;
	}
    
	
	public Boolean getestado() {
		return this.estado;
	}
	
    
	public void setid_sistema(Long newid_sistema)throws Exception
	{
		try {
			if(this.id_sistema!=newid_sistema) {
				if(newid_sistema==null) {
					//newid_sistema=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna id_sistema");
					}
				}

				this.id_sistema=newid_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_opcion(Long newid_grupo_opcion) {
		if(this.id_grupo_opcion==null&&newid_grupo_opcion!=null) {
			this.id_grupo_opcion=newid_grupo_opcion;
				this.setIsChanged(true);
		}

		if(this.id_grupo_opcion!=null&&!this.id_grupo_opcion.equals(newid_grupo_opcion)) {

			this.id_grupo_opcion=newid_grupo_opcion;
				this.setIsChanged(true);
		}
	}
    
	public void setid_opcion(Long newid_opcion) {
		if(this.id_opcion==null&&newid_opcion!=null) {
			this.id_opcion=newid_opcion;
				this.setIsChanged(true);
		}

		if(this.id_opcion!=null&&!this.id_opcion.equals(newid_opcion)) {

			this.id_opcion=newid_opcion;
				this.setIsChanged(true);
		}
	}
    
	public void setcodigo(String newcodigo)throws Exception
	{
		try {
			if(this.codigo!=newcodigo) {
				if(newcodigo==null) {
					//newcodigo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Opcion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_tecla_mascara(Long newid_tipo_tecla_mascara)throws Exception
	{
		try {
			if(this.id_tipo_tecla_mascara!=newid_tipo_tecla_mascara) {
				if(newid_tipo_tecla_mascara==null) {
					//newid_tipo_tecla_mascara=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna id_tipo_tecla_mascara");
					}
				}

				this.id_tipo_tecla_mascara=newid_tipo_tecla_mascara;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void settecla(String newtecla)throws Exception
	{
		try {
			if(this.tecla!=newtecla) {
				if(newtecla==null) {
					//newtecla="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna tecla");
					}
				}

				if(newtecla!=null&&newtecla.length()>20) {
					newtecla=newtecla.substring(0,18);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna tecla");
				}

				this.tecla=newtecla;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setposicion(Short newposicion)throws Exception
	{
		try {
			if(this.posicion!=newposicion) {
				if(newposicion==null) {
					//newposicion=Short.parseShort("0");
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna posicion");
					}
				}

				this.posicion=newposicion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void seticon_name(String newicon_name)throws Exception
	{
		try {
			if(this.icon_name!=newicon_name) {
				if(newicon_name==null) {
					//newicon_name="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna icon_name");
					}
				}

				if(newicon_name!=null&&newicon_name.length()>150) {
					newicon_name=newicon_name.substring(0,148);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna icon_name");
				}

				this.icon_name=newicon_name;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnombre_clase(String newnombre_clase)throws Exception
	{
		try {
			if(this.nombre_clase!=newnombre_clase) {
				if(newnombre_clase==null) {
					//newnombre_clase="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna nombre_clase");
					}
				}

				if(newnombre_clase!=null&&newnombre_clase.length()>50) {
					newnombre_clase=newnombre_clase.substring(0,48);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre_clase");
				}

				this.nombre_clase=newnombre_clase;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsub_modulo(String newsub_modulo)throws Exception
	{
		try {
			if(this.sub_modulo!=newsub_modulo) {
				if(newsub_modulo==null) {
					//newsub_modulo="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna sub_modulo");
					}
				}

				if(newsub_modulo!=null&&newsub_modulo.length()>50) {
					newsub_modulo=newsub_modulo.substring(0,48);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna sub_modulo");
				}

				this.sub_modulo=newsub_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpaquete(String newpaquete)throws Exception
	{
		try {
			if(this.paquete!=newpaquete) {
				if(newpaquete==null) {
					//newpaquete="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna paquete");
					}
				}

				if(newpaquete!=null&&newpaquete.length()>200) {
					newpaquete=newpaquete.substring(0,198);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna paquete");
				}

				this.paquete=newpaquete;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpaquete_original(String newpaquete_original)throws Exception
	{
		try {
			if(this.paquete_original!=newpaquete_original) {
				if(newpaquete_original==null) {
					//newpaquete_original="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna paquete_original");
					}
				}

				if(newpaquete_original!=null&&newpaquete_original.length()>200) {
					newpaquete_original=newpaquete_original.substring(0,198);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna paquete_original");
				}

				this.paquete_original=newpaquete_original;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpath_auxiliar(String newpath_auxiliar)throws Exception
	{
		try {
			if(this.path_auxiliar!=newpath_auxiliar) {
				if(newpath_auxiliar==null) {
					//newpath_auxiliar="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna path_auxiliar");
					}
				}

				if(newpath_auxiliar!=null&&newpath_auxiliar.length()>50) {
					newpath_auxiliar=newpath_auxiliar.substring(0,48);
					System.out.println("Opcion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna path_auxiliar");
				}

				this.path_auxiliar=newpath_auxiliar;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_menu(Boolean newes_para_menu)throws Exception
	{
		try {
			if(this.es_para_menu!=newes_para_menu) {
				if(newes_para_menu==null) {
					//newes_para_menu=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna es_para_menu");
					}
				}

				this.es_para_menu=newes_para_menu;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_mostrar_acciones_campo(Boolean newcon_mostrar_acciones_campo)throws Exception
	{
		try {
			if(this.con_mostrar_acciones_campo!=newcon_mostrar_acciones_campo) {
				if(newcon_mostrar_acciones_campo==null) {
					//newcon_mostrar_acciones_campo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna con_mostrar_acciones_campo");
					}
				}

				this.con_mostrar_acciones_campo=newcon_mostrar_acciones_campo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_guardar_relaciones(Boolean newes_guardar_relaciones)throws Exception
	{
		try {
			if(this.es_guardar_relaciones!=newes_guardar_relaciones) {
				if(newes_guardar_relaciones==null) {
					//newes_guardar_relaciones=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna es_guardar_relaciones");
					}
				}

				this.es_guardar_relaciones=newes_guardar_relaciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setestado(Boolean newestado)throws Exception
	{
		try {
			if(this.estado!=newestado) {
				if(newestado==null) {
					//newestado=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Opcion:Valor nulo no permitido en columna estado");
					}
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Sistema getSistema() {
		return this.sistema;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public GrupoOpcion getGrupoOpcion() {
		return this.grupoopcion;
	}

	public Opcion getOpcion() {
		return this.opcion;
	}

	public TipoTeclaMascara getTipoTeclaMascara() {
		return this.tipoteclamascara;
	}

	
	
	public String getsistema_descripcion() {
		return this.sistema_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String getgrupoopcion_descripcion() {
		return this.grupoopcion_descripcion;
	}

	public String getopcion_descripcion() {
		return this.opcion_descripcion;
	}

	public String gettipoteclamascara_descripcion() {
		return this.tipoteclamascara_descripcion;
	}

	
	
	public  void  setSistema(Sistema sistema) {
		try {
			this.sistema=sistema;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoOpcion(GrupoOpcion grupoopcion) {
		try {
			this.grupoopcion=grupoopcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setOpcion(Opcion opcion) {
		try {
			this.opcion=opcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoTeclaMascara(TipoTeclaMascara tipoteclamascara) {
		try {
			this.tipoteclamascara=tipoteclamascara;
		} catch(Exception e) {
			;
		}
	}


	
	
	public  void  setsistema_descripcion(String sistema_descripcion) {
		try {
			this.sistema_descripcion=sistema_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupoopcion_descripcion(String grupoopcion_descripcion) {
		try {
			this.grupoopcion_descripcion=grupoopcion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setopcion_descripcion(String opcion_descripcion) {
		try {
			this.opcion_descripcion=opcion_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipoteclamascara_descripcion(String tipoteclamascara_descripcion) {
		try {
			this.tipoteclamascara_descripcion=tipoteclamascara_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<UsuarioOpcion> getUsuarioOpcions() {
		return this.usuarioopcions;
	}

	public List<Opcion> getOpcions() {
		return this.opcions;
	}

	public List<Accion> getAccions() {
		return this.accions;
	}

	public List<PerfilOpcion> getPerfilOpcions() {
		return this.perfilopcions;
	}

	public List<Campo> getCampos() {
		return this.campos;
	}

	
	
	public  void  setUsuarioOpcions(List<UsuarioOpcion> usuarioopcions) {
		try {
			this.usuarioopcions=usuarioopcions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setOpcions(List<Opcion> opcions) {
		try {
			this.opcions=opcions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setAccions(List<Accion> accions) {
		try {
			this.accions=accions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setPerfilOpcions(List<PerfilOpcion> perfilopcions) {
		try {
			this.perfilopcions=perfilopcions;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCampos(List<Campo> campos) {
		try {
			this.campos=campos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_sistema_descripcion="";String id_modulo_descripcion="";String id_grupo_opcion_descripcion="";String id_opcion_descripcion="";String id_tipo_tecla_mascara_descripcion="";String es_para_menu_descripcion="";String con_mostrar_acciones_campo_descripcion="";String es_guardar_relaciones_descripcion="";String estado_descripcion="";
	
	
	public String getid_sistema_descripcion() {
		return id_sistema_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_grupo_opcion_descripcion() {
		return id_grupo_opcion_descripcion;
	}
	public String getid_opcion_descripcion() {
		return id_opcion_descripcion;
	}
	public String getid_tipo_tecla_mascara_descripcion() {
		return id_tipo_tecla_mascara_descripcion;
	}
	public String getes_para_menu_descripcion() {
		return es_para_menu_descripcion;
	}
	public String getcon_mostrar_acciones_campo_descripcion() {
		return con_mostrar_acciones_campo_descripcion;
	}
	public String getes_guardar_relaciones_descripcion() {
		return es_guardar_relaciones_descripcion;
	}
	public String getestado_descripcion() {
		return estado_descripcion;
	}
	
	
	public void setid_sistema_descripcion(String newid_sistema_descripcion)throws Exception {
		try {
			this.id_sistema_descripcion=newid_sistema_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_opcion_descripcion(String newid_grupo_opcion_descripcion)throws Exception {
		try {
			this.id_grupo_opcion_descripcion=newid_grupo_opcion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_opcion_descripcion(String newid_opcion_descripcion) {
		this.id_opcion_descripcion=newid_opcion_descripcion;
	}
	public void setid_tipo_tecla_mascara_descripcion(String newid_tipo_tecla_mascara_descripcion)throws Exception {
		try {
			this.id_tipo_tecla_mascara_descripcion=newid_tipo_tecla_mascara_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_menu_descripcion(String newes_para_menu_descripcion)throws Exception {
		try {
			this.es_para_menu_descripcion=newes_para_menu_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_mostrar_acciones_campo_descripcion(String newcon_mostrar_acciones_campo_descripcion)throws Exception {
		try {
			this.con_mostrar_acciones_campo_descripcion=newcon_mostrar_acciones_campo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_guardar_relaciones_descripcion(String newes_guardar_relaciones_descripcion)throws Exception {
		try {
			this.es_guardar_relaciones_descripcion=newes_guardar_relaciones_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setestado_descripcion(String newestado_descripcion)throws Exception {
		try {
			this.estado_descripcion=newestado_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_sistema_descripcion="";this.id_modulo_descripcion="";this.id_grupo_opcion_descripcion="";this.id_opcion_descripcion="";this.id_tipo_tecla_mascara_descripcion="";this.es_para_menu_descripcion="";this.con_mostrar_acciones_campo_descripcion="";this.es_guardar_relaciones_descripcion="";this.estado_descripcion="";
	}
	
	
	Object usuarioopcionsDescripcionReporte;
	Object opcionsDescripcionReporte;
	Object accionsDescripcionReporte;
	Object perfilopcionsDescripcionReporte;
	Object camposDescripcionReporte;
	
	
	public Object getusuarioopcionsDescripcionReporte() {
		return usuarioopcionsDescripcionReporte;
	}

	public Object getopcionsDescripcionReporte() {
		return opcionsDescripcionReporte;
	}

	public Object getaccionsDescripcionReporte() {
		return accionsDescripcionReporte;
	}

	public Object getperfilopcionsDescripcionReporte() {
		return perfilopcionsDescripcionReporte;
	}

	public Object getcamposDescripcionReporte() {
		return camposDescripcionReporte;
	}

	
	
	public  void  setusuarioopcionsDescripcionReporte(Object usuarioopcions) {
		try {
			this.usuarioopcionsDescripcionReporte=usuarioopcions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setopcionsDescripcionReporte(Object opcions) {
		try {
			this.opcionsDescripcionReporte=opcions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setaccionsDescripcionReporte(Object accions) {
		try {
			this.accionsDescripcionReporte=accions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setperfilopcionsDescripcionReporte(Object perfilopcions) {
		try {
			this.perfilopcionsDescripcionReporte=perfilopcions;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcamposDescripcionReporte(Object campos) {
		try {
			this.camposDescripcionReporte=campos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

