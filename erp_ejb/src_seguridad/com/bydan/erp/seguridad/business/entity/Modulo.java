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
//import com.bydan.erp.seguridad.util.ModuloConstantesFunciones;
import com.bydan.erp.seguridad.util.*;









@SuppressWarnings("unused")
public class Modulo extends ModuloAdditional implements Serializable ,Cloneable {//ModuloAdditional,GeneralEntity
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
	
	private Modulo moduloOriginal;
	
	private Map<String, Object> mapModulo;
			
	public Map<String, Object> getMapModulo() {
		return mapModulo;
	}

	public void setMapModulo(Map<String, Object> mapModulo) {
		this.mapModulo = mapModulo;
	}
	
	public void inicializarMapModulo() {
		this.mapModulo = new HashMap<String,Object>();
	}
	
	public void setMapModuloValue(String sKey,Object oValue) {
		this.mapModulo.put(sKey, oValue);
	}
	
	public Object getMapModuloValue(String sKey) {
		return this.mapModulo.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=-100000,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sistema;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_paquete;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ModuloConstantesFunciones.SREGEXCODIGO,message=ModuloConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ModuloConstantesFunciones.SREGEXNOMBRE,message=ModuloConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_tecla_mascara;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=20,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ModuloConstantesFunciones.SREGEXTECLA,message=ModuloConstantesFunciones.SMENSAJEREGEXTECLA)
	private String tecla;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean estado;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=200,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=ModuloConstantesFunciones.SREGEXDESCRIPCION,message=ModuloConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Sistema sistema;
	public Paquete paquete;
	public TipoTeclaMascara tipoteclamascara;
	
	
	private String sistema_descripcion;
	private String paquete_descripcion;
	private String tipoteclamascara_descripcion;
	
	
		
	public Modulo () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.moduloOriginal=this;
		
 		this.id_sistema=-1L;
 		this.id_paquete=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_tecla_mascara=-1L;
 		this.tecla="";
 		this.estado=false;
 		this.orden=0;
 		this.descripcion="";
		
		
		this.sistema=null;
		this.paquete=null;
		this.tipoteclamascara=null;
		
		
		this.sistema_descripcion="";
		this.paquete_descripcion="";
		this.tipoteclamascara_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Modulo (Long id,Date versionRow,Long id_sistema,Long id_paquete,String codigo,String nombre,Long id_tipo_tecla_mascara,String tecla,Boolean estado,Integer orden,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.moduloOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_paquete=id_paquete;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_tecla_mascara=id_tipo_tecla_mascara;
 		this.tecla=tecla;
 		this.estado=estado;
 		this.orden=orden;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Modulo (Long id_sistema,Long id_paquete,String codigo,String nombre,Long id_tipo_tecla_mascara,String tecla,Boolean estado,Integer orden,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.moduloOriginal=this;
		
 		this.id_sistema=id_sistema;
 		this.id_paquete=id_paquete;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_tecla_mascara=id_tipo_tecla_mascara;
 		this.tecla=tecla;
 		this.estado=estado;
 		this.orden=orden;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Modulo moduloLocal=null;
		
		if(object!=null) {
			moduloLocal=(Modulo)object;
			
			if(moduloLocal!=null) {
				if(this.getId()!=null && moduloLocal.getId()!=null) {
					if(this.getId().equals(moduloLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ModuloConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ModuloConstantesFunciones.getModuloDescripcion(this);
		} else {
			sDetalle=ModuloConstantesFunciones.getModuloDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Modulo getModuloOriginal() {
		return this.moduloOriginal;
	}
	
	public void setModuloOriginal(Modulo modulo) {
		try {
			this.moduloOriginal=modulo;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected ModuloAdditional moduloAdditional=null;
	
	public ModuloAdditional getModuloAdditional() {
		return this.moduloAdditional;
	}
	
	public void setModuloAdditional(ModuloAdditional moduloAdditional) {
		try {
			this.moduloAdditional=moduloAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_sistema() {
		return this.id_sistema;
	}
    
	
	public Long getid_paquete() {
		return this.id_paquete;
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
    
	
	public Boolean getestado() {
		return this.estado;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_sistema(Long newid_sistema)throws Exception
	{
		try {
			if(this.id_sistema!=newid_sistema) {
				if(newid_sistema==null) {
					//newid_sistema=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Modulo:Valor nulo no permitido en columna id_sistema");
					}
				}

				this.id_sistema=newid_sistema;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_paquete(Long newid_paquete)throws Exception
	{
		try {
			if(this.id_paquete!=newid_paquete) {
				if(newid_paquete==null) {
					//newid_paquete=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Modulo:Valor nulo no permitido en columna id_paquete");
					}
				}

				this.id_paquete=newid_paquete;
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
						System.out.println("Modulo:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Modulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Modulo:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Modulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
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
						System.out.println("Modulo:Valor nulo no permitido en columna id_tipo_tecla_mascara");
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
						System.out.println("Modulo:Valor nulo no permitido en columna tecla");
					}
				}

				if(newtecla!=null&&newtecla.length()>20) {
					newtecla=newtecla.substring(0,18);
					System.out.println("Modulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=20 en columna tecla");
				}

				this.tecla=newtecla;
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
						System.out.println("Modulo:Valor nulo no permitido en columna estado");
					}
				}

				this.estado=newestado;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setorden(Integer neworden)throws Exception
	{
		try {
			if(this.orden!=neworden) {
				if(neworden==null) {
					//neworden=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Modulo:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
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
						System.out.println("Modulo:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>200) {
					newdescripcion=newdescripcion.substring(0,198);
					System.out.println("Modulo:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=200 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Sistema getSistema() {
		return this.sistema;
	}

	public Paquete getPaquete() {
		return this.paquete;
	}

	public TipoTeclaMascara getTipoTeclaMascara() {
		return this.tipoteclamascara;
	}

	
	
	public String getsistema_descripcion() {
		return this.sistema_descripcion;
	}

	public String getpaquete_descripcion() {
		return this.paquete_descripcion;
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


	public  void  setPaquete(Paquete paquete) {
		try {
			this.paquete=paquete;
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


	public  void  setpaquete_descripcion(String paquete_descripcion) {
		try {
			this.paquete_descripcion=paquete_descripcion;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_sistema_descripcion="";String id_paquete_descripcion="";String id_tipo_tecla_mascara_descripcion="";String estado_descripcion="";
	
	
	public String getid_sistema_descripcion() {
		return id_sistema_descripcion;
	}
	public String getid_paquete_descripcion() {
		return id_paquete_descripcion;
	}
	public String getid_tipo_tecla_mascara_descripcion() {
		return id_tipo_tecla_mascara_descripcion;
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
	public void setid_paquete_descripcion(String newid_paquete_descripcion)throws Exception {
		try {
			this.id_paquete_descripcion=newid_paquete_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_tecla_mascara_descripcion(String newid_tipo_tecla_mascara_descripcion)throws Exception {
		try {
			this.id_tipo_tecla_mascara_descripcion=newid_tipo_tecla_mascara_descripcion;
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
		this.id_sistema_descripcion="";this.id_paquete_descripcion="";this.id_tipo_tecla_mascara_descripcion="";this.estado_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

