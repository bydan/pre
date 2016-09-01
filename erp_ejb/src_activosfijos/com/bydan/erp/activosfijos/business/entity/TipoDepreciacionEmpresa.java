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
package com.bydan.erp.activosfijos.business.entity;

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
//import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaConstantesFunciones;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;




@SuppressWarnings("unused")
public class TipoDepreciacionEmpresa extends GeneralEntity implements Serializable ,Cloneable {//TipoDepreciacionEmpresaAdditional,GeneralEntity
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
	
	private TipoDepreciacionEmpresa tipodepreciacionempresaOriginal;
	
	private Map<String, Object> mapTipoDepreciacionEmpresa;
			
	public Map<String, Object> getMapTipoDepreciacionEmpresa() {
		return mapTipoDepreciacionEmpresa;
	}

	public void setMapTipoDepreciacionEmpresa(Map<String, Object> mapTipoDepreciacionEmpresa) {
		this.mapTipoDepreciacionEmpresa = mapTipoDepreciacionEmpresa;
	}
	
	public void inicializarMapTipoDepreciacionEmpresa() {
		this.mapTipoDepreciacionEmpresa = new HashMap<String,Object>();
	}
	
	public void setMapTipoDepreciacionEmpresaValue(String sKey,Object oValue) {
		this.mapTipoDepreciacionEmpresa.put(sKey, oValue);
	}
	
	public Object getMapTipoDepreciacionEmpresaValue(String sKey) {
		return this.mapTipoDepreciacionEmpresa.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDepreciacionEmpresaConstantesFunciones.SREGEXCODIGO,message=TipoDepreciacionEmpresaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoDepreciacionEmpresaConstantesFunciones.SREGEXNOMBRE,message=TipoDepreciacionEmpresaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_linea_recta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_mensual;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<DetalleActivoFijo> detalleactivofijos;
	public List<DepreciacionActivoFijo> depreciacionactivofijos;
		
	public TipoDepreciacionEmpresa () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipodepreciacionempresaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.es_linea_recta=false;
 		this.es_mensual=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.detalleactivofijos=null;
		this.depreciacionactivofijos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoDepreciacionEmpresa (Long id,Date versionRow,Long id_empresa,String codigo,String nombre,Boolean es_linea_recta,Boolean es_mensual) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodepreciacionempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_linea_recta=es_linea_recta;
 		this.es_mensual=es_mensual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoDepreciacionEmpresa (Long id_empresa,String codigo,String nombre,Boolean es_linea_recta,Boolean es_mensual) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipodepreciacionempresaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.es_linea_recta=es_linea_recta;
 		this.es_mensual=es_mensual;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoDepreciacionEmpresa tipodepreciacionempresaLocal=null;
		
		if(object!=null) {
			tipodepreciacionempresaLocal=(TipoDepreciacionEmpresa)object;
			
			if(tipodepreciacionempresaLocal!=null) {
				if(this.getId()!=null && tipodepreciacionempresaLocal.getId()!=null) {
					if(this.getId().equals(tipodepreciacionempresaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoDepreciacionEmpresaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(this);
		} else {
			sDetalle=TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoDepreciacionEmpresa getTipoDepreciacionEmpresaOriginal() {
		return this.tipodepreciacionempresaOriginal;
	}
	
	public void setTipoDepreciacionEmpresaOriginal(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		try {
			this.tipodepreciacionempresaOriginal=tipodepreciacionempresa;
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
    
	
	public Boolean getes_linea_recta() {
		return this.es_linea_recta;
	}
    
	
	public Boolean getes_mensual() {
		return this.es_mensual;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDepreciacionEmpresa:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("TipoDepreciacionEmpresa:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("TipoDepreciacionEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("TipoDepreciacionEmpresa:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("TipoDepreciacionEmpresa:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_linea_recta(Boolean newes_linea_recta)throws Exception
	{
		try {
			if(this.es_linea_recta!=newes_linea_recta) {
				if(newes_linea_recta==null) {
					//newes_linea_recta=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDepreciacionEmpresa:Valor nulo no permitido en columna es_linea_recta");
					}
				}

				this.es_linea_recta=newes_linea_recta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_mensual(Boolean newes_mensual)throws Exception
	{
		try {
			if(this.es_mensual!=newes_mensual) {
				if(newes_mensual==null) {
					//newes_mensual=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoDepreciacionEmpresa:Valor nulo no permitido en columna es_mensual");
					}
				}

				this.es_mensual=newes_mensual;
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


	
	
	public List<DetalleActivoFijo> getDetalleActivoFijos() {
		return this.detalleactivofijos;
	}

	public List<DepreciacionActivoFijo> getDepreciacionActivoFijos() {
		return this.depreciacionactivofijos;
	}

	
	
	public  void  setDetalleActivoFijos(List<DetalleActivoFijo> detalleactivofijos) {
		try {
			this.detalleactivofijos=detalleactivofijos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos) {
		try {
			this.depreciacionactivofijos=depreciacionactivofijos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String es_linea_recta_descripcion="";String es_mensual_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getes_linea_recta_descripcion() {
		return es_linea_recta_descripcion;
	}
	public String getes_mensual_descripcion() {
		return es_mensual_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_linea_recta_descripcion(String newes_linea_recta_descripcion)throws Exception {
		try {
			this.es_linea_recta_descripcion=newes_linea_recta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_mensual_descripcion(String newes_mensual_descripcion)throws Exception {
		try {
			this.es_mensual_descripcion=newes_mensual_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.es_linea_recta_descripcion="";this.es_mensual_descripcion="";
	}
	
	
	Object detalleactivofijosDescripcionReporte;
	Object depreciacionactivofijosDescripcionReporte;
	
	
	public Object getdetalleactivofijosDescripcionReporte() {
		return detalleactivofijosDescripcionReporte;
	}

	public Object getdepreciacionactivofijosDescripcionReporte() {
		return depreciacionactivofijosDescripcionReporte;
	}

	
	
	public  void  setdetalleactivofijosDescripcionReporte(Object detalleactivofijos) {
		try {
			this.detalleactivofijosDescripcionReporte=detalleactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdepreciacionactivofijosDescripcionReporte(Object depreciacionactivofijos) {
		try {
			this.depreciacionactivofijosDescripcionReporte=depreciacionactivofijos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

