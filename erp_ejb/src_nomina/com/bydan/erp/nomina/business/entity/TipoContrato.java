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
//import com.bydan.erp.nomina.util.TipoContratoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;




@SuppressWarnings("unused")
public class TipoContrato extends TipoContratoAdditional implements Serializable ,Cloneable {//TipoContratoAdditional,GeneralEntity
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
	
	private TipoContrato tipocontratoOriginal;
	
	private Map<String, Object> mapTipoContrato;
			
	public Map<String, Object> getMapTipoContrato() {
		return mapTipoContrato;
	}

	public void setMapTipoContrato(Map<String, Object> mapTipoContrato) {
		this.mapTipoContrato = mapTipoContrato;
	}
	
	public void inicializarMapTipoContrato() {
		this.mapTipoContrato = new HashMap<String,Object>();
	}
	
	public void setMapTipoContratoValue(String sKey,Object oValue) {
		this.mapTipoContrato.put(sKey, oValue);
	}
	
	public Object getMapTipoContratoValue(String sKey) {
		return this.mapTipoContrato.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoContratoConstantesFunciones.SREGEXCODIGO,message=TipoContratoConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoContratoConstantesFunciones.SREGEXNOMBRE,message=TipoContratoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer numero_dias;
			
	
	public Empresa empresa;
	public Formato formato;
	
	
	private String empresa_descripcion;
	private String formato_descripcion;
	
	
	public List<DatoGeneralEmpleado> datogeneralempleados;
	public List<Empleado> empleados;
		
	public TipoContrato () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipocontratoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_formato=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.numero_dias=0;
		
		
		this.empresa=null;
		this.formato=null;
		
		
		this.empresa_descripcion="";
		this.formato_descripcion="";
		
		
		this.datogeneralempleados=null;
		this.empleados=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoContrato (Long id,Date versionRow,Long id_empresa,Long id_formato,String codigo,String nombre,Integer numero_dias) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocontratoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_formato=id_formato;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.numero_dias=numero_dias;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoContrato (Long id_empresa,Long id_formato,String codigo,String nombre,Integer numero_dias) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipocontratoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_formato=id_formato;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.numero_dias=numero_dias;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoContrato tipocontratoLocal=null;
		
		if(object!=null) {
			tipocontratoLocal=(TipoContrato)object;
			
			if(tipocontratoLocal!=null) {
				if(this.getId()!=null && tipocontratoLocal.getId()!=null) {
					if(this.getId().equals(tipocontratoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoContratoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoContratoConstantesFunciones.getTipoContratoDescripcion(this);
		} else {
			sDetalle=TipoContratoConstantesFunciones.getTipoContratoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoContrato getTipoContratoOriginal() {
		return this.tipocontratoOriginal;
	}
	
	public void setTipoContratoOriginal(TipoContrato tipocontrato) {
		try {
			this.tipocontratoOriginal=tipocontrato;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoContratoAdditional tipocontratoAdditional=null;
	
	public TipoContratoAdditional getTipoContratoAdditional() {
		return this.tipocontratoAdditional;
	}
	
	public void setTipoContratoAdditional(TipoContratoAdditional tipocontratoAdditional) {
		try {
			this.tipocontratoAdditional=tipocontratoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Integer getnumero_dias() {
		return this.numero_dias;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoContrato:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_formato(Long newid_formato)throws Exception
	{
		try {
			if(this.id_formato!=newid_formato) {
				if(newid_formato==null) {
					//newid_formato=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoContrato:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
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
						System.out.println("TipoContrato:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoContrato:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoContrato:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoContrato:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_dias(Integer newnumero_dias)throws Exception
	{
		try {
			if(this.numero_dias!=newnumero_dias) {
				if(newnumero_dias==null) {
					//newnumero_dias=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoContrato:Valor nulo no permitido en columna numero_dias");
					}
				}

				this.numero_dias=newnumero_dias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Formato getFormato() {
		return this.formato;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFormato(Formato formato) {
		try {
			this.formato=formato;
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


	public  void  setformato_descripcion(String formato_descripcion) {
		try {
			this.formato_descripcion=formato_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<DatoGeneralEmpleado> getDatoGeneralEmpleados() {
		return this.datogeneralempleados;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	
	
	public  void  setDatoGeneralEmpleados(List<DatoGeneralEmpleado> datogeneralempleados) {
		try {
			this.datogeneralempleados=datogeneralempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleados(List<Empleado> empleados) {
		try {
			this.empleados=empleados;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_formato_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_formato_descripcion(String newid_formato_descripcion)throws Exception {
		try {
			this.id_formato_descripcion=newid_formato_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_formato_descripcion="";
	}
	
	
	Object datogeneralempleadosDescripcionReporte;
	Object empleadosDescripcionReporte;
	
	
	public Object getdatogeneralempleadosDescripcionReporte() {
		return datogeneralempleadosDescripcionReporte;
	}

	public Object getempleadosDescripcionReporte() {
		return empleadosDescripcionReporte;
	}

	
	
	public  void  setdatogeneralempleadosDescripcionReporte(Object datogeneralempleados) {
		try {
			this.datogeneralempleadosDescripcionReporte=datogeneralempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadosDescripcionReporte(Object empleados) {
		try {
			this.empleadosDescripcionReporte=empleados;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

