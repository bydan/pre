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


import java.sql.Time;

import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.TipoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class TipoRequisicion extends TipoRequisicionAdditional implements Serializable ,Cloneable {//TipoRequisicionAdditional,GeneralEntity
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
	
	private TipoRequisicion tiporequisicionOriginal;
	
	private Map<String, Object> mapTipoRequisicion;
			
	public Map<String, Object> getMapTipoRequisicion() {
		return mapTipoRequisicion;
	}

	public void setMapTipoRequisicion(Map<String, Object> mapTipoRequisicion) {
		this.mapTipoRequisicion = mapTipoRequisicion;
	}
	
	public void inicializarMapTipoRequisicion() {
		this.mapTipoRequisicion = new HashMap<String,Object>();
	}
	
	public void setMapTipoRequisicionValue(String sKey,Object oValue) {
		this.mapTipoRequisicion.put(sKey, oValue);
	}
	
	public Object getMapTipoRequisicionValue(String sKey) {
		return this.mapTipoRequisicion.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoRequisicionConstantesFunciones.SREGEXCODIGO,message=TipoRequisicionConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoRequisicionConstantesFunciones.SREGEXNOMBRE,message=TipoRequisicionConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dia;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Time hora;
			
	
	public Empresa empresa;
	public TipoPeriodo tipoperiodo;
	public Dia dia;
	
	
	private String empresa_descripcion;
	private String tipoperiodo_descripcion;
	private String dia_descripcion;
	
	
		
	public TipoRequisicion () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tiporequisicionOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.id_tipo_periodo=-1L;
 		this.id_dia=-1L;
 		this.hora=new Time((new Date()).getTime());
		
		
		this.empresa=null;
		this.tipoperiodo=null;
		this.dia=null;
		
		
		this.empresa_descripcion="";
		this.tipoperiodo_descripcion="";
		this.dia_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoRequisicion (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Long id_tipo_periodo,Long id_dia,Time hora) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporequisicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_periodo=id_tipo_periodo;
 		this.id_dia=id_dia;
 		this.hora=hora;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoRequisicion (Long id_empresa,String codigo,String nombre,Long id_tipo_periodo,Long id_dia,Time hora) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tiporequisicionOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.id_tipo_periodo=id_tipo_periodo;
 		this.id_dia=id_dia;
 		this.hora=hora;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoRequisicion tiporequisicionLocal=null;
		
		if(object!=null) {
			tiporequisicionLocal=(TipoRequisicion)object;
			
			if(tiporequisicionLocal!=null) {
				if(this.getId()!=null && tiporequisicionLocal.getId()!=null) {
					if(this.getId().equals(tiporequisicionLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoRequisicionConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoRequisicionConstantesFunciones.getTipoRequisicionDescripcion(this);
		} else {
			sDetalle=TipoRequisicionConstantesFunciones.getTipoRequisicionDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoRequisicion getTipoRequisicionOriginal() {
		return this.tiporequisicionOriginal;
	}
	
	public void setTipoRequisicionOriginal(TipoRequisicion tiporequisicion) {
		try {
			this.tiporequisicionOriginal=tiporequisicion;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoRequisicionAdditional tiporequisicionAdditional=null;
	
	public TipoRequisicionAdditional getTipoRequisicionAdditional() {
		return this.tiporequisicionAdditional;
	}
	
	public void setTipoRequisicionAdditional(TipoRequisicionAdditional tiporequisicionAdditional) {
		try {
			this.tiporequisicionAdditional=tiporequisicionAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Long getid_tipo_periodo() {
		return this.id_tipo_periodo;
	}
    
	
	public Long getid_dia() {
		return this.id_dia;
	}
    
	
	public Time gethora() {
		return this.hora;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoRequisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("TipoRequisicion:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_periodo(Long newid_tipo_periodo)throws Exception
	{
		try {
			if(this.id_tipo_periodo!=newid_tipo_periodo) {
				if(newid_tipo_periodo==null) {
					//newid_tipo_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna id_tipo_periodo");
					}
				}

				this.id_tipo_periodo=newid_tipo_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dia(Long newid_dia)throws Exception
	{
		try {
			if(this.id_dia!=newid_dia) {
				if(newid_dia==null) {
					//newid_dia=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna id_dia");
					}
				}

				this.id_dia=newid_dia;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void sethora(Time newhora)throws Exception
	{
		try {
			if(this.hora!=newhora) {
				if(newhora==null) {
					//newhora=new Time((new Date()).getTime());
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoRequisicion:Valor nulo no permitido en columna hora");
					}
				}

				this.hora=newhora;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoPeriodo getTipoPeriodo() {
		return this.tipoperiodo;
	}

	public Dia getDia() {
		return this.dia;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoperiodo_descripcion() {
		return this.tipoperiodo_descripcion;
	}

	public String getdia_descripcion() {
		return this.dia_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoPeriodo(TipoPeriodo tipoperiodo) {
		try {
			this.tipoperiodo=tipoperiodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDia(Dia dia) {
		try {
			this.dia=dia;
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


	public  void  settipoperiodo_descripcion(String tipoperiodo_descripcion) {
		try {
			this.tipoperiodo_descripcion=tipoperiodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdia_descripcion(String dia_descripcion) {
		try {
			this.dia_descripcion=dia_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_periodo_descripcion="";String id_dia_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_periodo_descripcion() {
		return id_tipo_periodo_descripcion;
	}
	public String getid_dia_descripcion() {
		return id_dia_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_periodo_descripcion(String newid_tipo_periodo_descripcion)throws Exception {
		try {
			this.id_tipo_periodo_descripcion=newid_tipo_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_dia_descripcion(String newid_dia_descripcion)throws Exception {
		try {
			this.id_dia_descripcion=newid_dia_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_periodo_descripcion="";this.id_dia_descripcion="";
	}
	
	
	Object requisicionsDescripcionReporte;
	
	
	public Object getrequisicionsDescripcionReporte() {
		return requisicionsDescripcionReporte;
	}

	
	
	public  void  setrequisicionsDescripcionReporte(Object requisicions) {
		try {
			this.requisicionsDescripcionReporte=requisicions;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

