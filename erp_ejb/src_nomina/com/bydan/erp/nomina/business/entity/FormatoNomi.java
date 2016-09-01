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
package com.bydan.erp.nomina.business.entity;

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
//import com.bydan.erp.nomina.util.FormatoNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class FormatoNomi extends FormatoNomiAdditional implements Serializable ,Cloneable {//FormatoNomiAdditional,GeneralEntity
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
	
	private FormatoNomi formatonomiOriginal;
	
	private Map<String, Object> mapFormatoNomi;
			
	public Map<String, Object> getMapFormatoNomi() {
		return mapFormatoNomi;
	}

	public void setMapFormatoNomi(Map<String, Object> mapFormatoNomi) {
		this.mapFormatoNomi = mapFormatoNomi;
	}
	
	public void inicializarMapFormatoNomi() {
		this.mapFormatoNomi = new HashMap<String,Object>();
	}
	
	public void setMapFormatoNomiValue(String sKey,Object oValue) {
		this.mapFormatoNomi.put(sKey, oValue);
	}
	
	public Object getMapFormatoNomiValue(String sKey) {
		return this.mapFormatoNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_sucursal;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormatoNomiConstantesFunciones.SREGEXCODIGO,message=FormatoNomiConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormatoNomiConstantesFunciones.SREGEXNOMBRE,message=FormatoNomiConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Date fecha;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=300,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormatoNomiConstantesFunciones.SREGEXINSTRUCCIONES,message=FormatoNomiConstantesFunciones.SMENSAJEREGEXINSTRUCCIONES)
	private String instrucciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_estructura;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_puntaje_nomi;
			
	
	public Empresa empresa;
	public Sucursal sucursal;
	public Estructura estructura;
	public PuntajeNomi puntajenomi;
	
	
	private String empresa_descripcion;
	private String sucursal_descripcion;
	private String estructura_descripcion;
	private String puntajenomi_descripcion;
	
	
	public List<FormatoNomiPreguntaNomi> formatonomipreguntanomis;
	public List<FormatoNomiFactorNomi> formatonomifactornomis;
	public List<EvaluacionNomi> evaluacionnomis;
	public List<DetalleEvaluacionNomi> detalleevaluacionnomis;
		
	public FormatoNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formatonomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_sucursal=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.fecha=new Date();
 		this.instrucciones="";
 		this.id_estructura=-1L;
 		this.id_puntaje_nomi=-1L;
		
		
		this.empresa=null;
		this.sucursal=null;
		this.estructura=null;
		this.puntajenomi=null;
		
		
		this.empresa_descripcion="";
		this.sucursal_descripcion="";
		this.estructura_descripcion="";
		this.puntajenomi_descripcion="";
		
		
		this.formatonomipreguntanomis=null;
		this.formatonomifactornomis=null;
		this.evaluacionnomis=null;
		this.detalleevaluacionnomis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormatoNomi (Long id,Date versionRow,Long id_empresa,Long id_sucursal,String codigo,String nombre,Date fecha,String instrucciones,Long id_estructura,Long id_puntaje_nomi) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatonomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.fecha=fecha;
 		this.instrucciones=instrucciones;
 		this.id_estructura=id_estructura;
 		this.id_puntaje_nomi=id_puntaje_nomi;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormatoNomi (Long id_empresa,Long id_sucursal,String codigo,String nombre,Date fecha,String instrucciones,Long id_estructura,Long id_puntaje_nomi) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formatonomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_sucursal=id_sucursal;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.fecha=fecha;
 		this.instrucciones=instrucciones;
 		this.id_estructura=id_estructura;
 		this.id_puntaje_nomi=id_puntaje_nomi;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormatoNomi formatonomiLocal=null;
		
		if(object!=null) {
			formatonomiLocal=(FormatoNomi)object;
			
			if(formatonomiLocal!=null) {
				if(this.getId()!=null && formatonomiLocal.getId()!=null) {
					if(this.getId().equals(formatonomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormatoNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormatoNomiConstantesFunciones.getFormatoNomiDescripcion(this);
		} else {
			sDetalle=FormatoNomiConstantesFunciones.getFormatoNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormatoNomi getFormatoNomiOriginal() {
		return this.formatonomiOriginal;
	}
	
	public void setFormatoNomiOriginal(FormatoNomi formatonomi) {
		try {
			this.formatonomiOriginal=formatonomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormatoNomiAdditional formatonomiAdditional=null;
	
	public FormatoNomiAdditional getFormatoNomiAdditional() {
		return this.formatonomiAdditional;
	}
	
	public void setFormatoNomiAdditional(FormatoNomiAdditional formatonomiAdditional) {
		try {
			this.formatonomiAdditional=formatonomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_sucursal() {
		return this.id_sucursal;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Date getfecha() {
		return this.fecha;
	}
    
	
	public String getinstrucciones() {
		return this.instrucciones;
	}
    
	
	public Long getid_estructura() {
		return this.id_estructura;
	}
    
	
	public Long getid_puntaje_nomi() {
		return this.id_puntaje_nomi;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_sucursal(Long newid_sucursal)throws Exception
	{
		try {
			if(this.id_sucursal!=newid_sucursal) {
				if(newid_sucursal==null) {
					//newid_sucursal=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomi:Valor nulo no permitido en columna id_sucursal");
					}
				}

				this.id_sucursal=newid_sucursal;
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
						System.out.println("FormatoNomi:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("FormatoNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("FormatoNomi:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("FormatoNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("FormatoNomi:Valor nulo no permitido en columna fecha");
					}
				}

				this.fecha=newfecha;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setinstrucciones(String newinstrucciones)throws Exception
	{
		try {
			if(this.instrucciones!=newinstrucciones) {
				if(newinstrucciones==null) {
					//newinstrucciones="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomi:Valor nulo no permitido en columna instrucciones");
					}
				}

				if(newinstrucciones!=null&&newinstrucciones.length()>300) {
					newinstrucciones=newinstrucciones.substring(0,298);
					System.out.println("FormatoNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=300 en columna instrucciones");
				}

				this.instrucciones=newinstrucciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_estructura(Long newid_estructura)throws Exception
	{
		try {
			if(this.id_estructura!=newid_estructura) {
				if(newid_estructura==null) {
					//newid_estructura=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomi:Valor nulo no permitido en columna id_estructura");
					}
				}

				this.id_estructura=newid_estructura;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_puntaje_nomi(Long newid_puntaje_nomi)throws Exception
	{
		try {
			if(this.id_puntaje_nomi!=newid_puntaje_nomi) {
				if(newid_puntaje_nomi==null) {
					//newid_puntaje_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormatoNomi:Valor nulo no permitido en columna id_puntaje_nomi");
					}
				}

				this.id_puntaje_nomi=newid_puntaje_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public Estructura getEstructura() {
		return this.estructura;
	}

	public PuntajeNomi getPuntajeNomi() {
		return this.puntajenomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getsucursal_descripcion() {
		return this.sucursal_descripcion;
	}

	public String getestructura_descripcion() {
		return this.estructura_descripcion;
	}

	public String getpuntajenomi_descripcion() {
		return this.puntajenomi_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setSucursal(Sucursal sucursal) {
		try {
			this.sucursal=sucursal;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEstructura(Estructura estructura) {
		try {
			this.estructura=estructura;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPuntajeNomi(PuntajeNomi puntajenomi) {
		try {
			this.puntajenomi=puntajenomi;
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


	public  void  setsucursal_descripcion(String sucursal_descripcion) {
		try {
			this.sucursal_descripcion=sucursal_descripcion;
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


	public  void  setpuntajenomi_descripcion(String puntajenomi_descripcion) {
		try {
			this.puntajenomi_descripcion=puntajenomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<FormatoNomiPreguntaNomi> getFormatoNomiPreguntaNomis() {
		return this.formatonomipreguntanomis;
	}

	public List<FormatoNomiFactorNomi> getFormatoNomiFactorNomis() {
		return this.formatonomifactornomis;
	}

	public List<EvaluacionNomi> getEvaluacionNomis() {
		return this.evaluacionnomis;
	}

	public List<DetalleEvaluacionNomi> getDetalleEvaluacionNomis() {
		return this.detalleevaluacionnomis;
	}

	
	
	public  void  setFormatoNomiPreguntaNomis(List<FormatoNomiPreguntaNomi> formatonomipreguntanomis) {
		try {
			this.formatonomipreguntanomis=formatonomipreguntanomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormatoNomiFactorNomis(List<FormatoNomiFactorNomi> formatonomifactornomis) {
		try {
			this.formatonomifactornomis=formatonomifactornomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEvaluacionNomis(List<EvaluacionNomi> evaluacionnomis) {
		try {
			this.evaluacionnomis=evaluacionnomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomis=detalleevaluacionnomis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_sucursal_descripcion="";String id_estructura_descripcion="";String id_puntaje_nomi_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_sucursal_descripcion() {
		return id_sucursal_descripcion;
	}
	public String getid_estructura_descripcion() {
		return id_estructura_descripcion;
	}
	public String getid_puntaje_nomi_descripcion() {
		return id_puntaje_nomi_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_sucursal_descripcion(String newid_sucursal_descripcion)throws Exception {
		try {
			this.id_sucursal_descripcion=newid_sucursal_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_estructura_descripcion(String newid_estructura_descripcion)throws Exception {
		try {
			this.id_estructura_descripcion=newid_estructura_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_puntaje_nomi_descripcion(String newid_puntaje_nomi_descripcion)throws Exception {
		try {
			this.id_puntaje_nomi_descripcion=newid_puntaje_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_sucursal_descripcion="";this.id_estructura_descripcion="";this.id_puntaje_nomi_descripcion="";
	}
	
	
	Object formatonomipreguntanomisDescripcionReporte;
	Object formatonomifactornomisDescripcionReporte;
	Object evaluacionnomisDescripcionReporte;
	Object detalleevaluacionnomisDescripcionReporte;
	
	
	public Object getformatonomipreguntanomisDescripcionReporte() {
		return formatonomipreguntanomisDescripcionReporte;
	}

	public Object getformatonomifactornomisDescripcionReporte() {
		return formatonomifactornomisDescripcionReporte;
	}

	public Object getevaluacionnomisDescripcionReporte() {
		return evaluacionnomisDescripcionReporte;
	}

	public Object getdetalleevaluacionnomisDescripcionReporte() {
		return detalleevaluacionnomisDescripcionReporte;
	}

	
	
	public  void  setformatonomipreguntanomisDescripcionReporte(Object formatonomipreguntanomis) {
		try {
			this.formatonomipreguntanomisDescripcionReporte=formatonomipreguntanomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformatonomifactornomisDescripcionReporte(Object formatonomifactornomis) {
		try {
			this.formatonomifactornomisDescripcionReporte=formatonomifactornomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setevaluacionnomisDescripcionReporte(Object evaluacionnomis) {
		try {
			this.evaluacionnomisDescripcionReporte=evaluacionnomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdetalleevaluacionnomisDescripcionReporte(Object detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomisDescripcionReporte=detalleevaluacionnomis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

