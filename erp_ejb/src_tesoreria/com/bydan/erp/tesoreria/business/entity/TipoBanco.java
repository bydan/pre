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
package com.bydan.erp.tesoreria.business.entity;

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
//import com.bydan.erp.tesoreria.util.TipoBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;




@SuppressWarnings("unused")
public class TipoBanco extends TipoBancoAdditional implements Serializable ,Cloneable {//TipoBancoAdditional,GeneralEntity
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
	
	private TipoBanco tipobancoOriginal;
	
	private Map<String, Object> mapTipoBanco;
			
	public Map<String, Object> getMapTipoBanco() {
		return mapTipoBanco;
	}

	public void setMapTipoBanco(Map<String, Object> mapTipoBanco) {
		this.mapTipoBanco = mapTipoBanco;
	}
	
	public void inicializarMapTipoBanco() {
		this.mapTipoBanco = new HashMap<String,Object>();
	}
	
	public void setMapTipoBancoValue(String sKey,Object oValue) {
		this.mapTipoBanco.put(sKey, oValue);
	}
	
	public Object getMapTipoBancoValue(String sKey) {
		return this.mapTipoBanco.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoBancoConstantesFunciones.SREGEXNOMBRE,message=TipoBancoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=TipoBancoConstantesFunciones.SREGEXCODIGO_SRI,message=TipoBancoConstantesFunciones.SMENSAJEREGEXCODIGO_SRI)
	private String codigo_sri;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_defecto;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
	public List<Banco> bancos;
		
	public TipoBanco () throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.tipobancoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.codigo_sri="";
 		this.es_defecto=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		this.bancos=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public TipoBanco (Long id,Date versionRow,Long id_empresa,String nombre,String codigo_sri,Boolean es_defecto) throws Exception {
		super();		
		
		this.id=id;
		this.idOriginal=this.id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipobancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.codigo_sri=codigo_sri;
 		this.es_defecto=es_defecto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public TipoBanco (Long id_empresa,String nombre,String codigo_sri,Boolean es_defecto) throws Exception {
		super();		
		
		this.id=0L;
		this.idOriginal=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.tipobancoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.codigo_sri=codigo_sri;
 		this.es_defecto=es_defecto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		TipoBanco tipobancoLocal=null;
		
		if(object!=null) {
			tipobancoLocal=(TipoBanco)object;
			
			if(tipobancoLocal!=null) {
				if(this.getId()!=null && tipobancoLocal.getId()!=null) {
					if(this.getId().equals(tipobancoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!TipoBancoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=TipoBancoConstantesFunciones.getTipoBancoDescripcion(this);
		} else {
			sDetalle=TipoBancoConstantesFunciones.getTipoBancoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public TipoBanco getTipoBancoOriginal() {
		return this.tipobancoOriginal;
	}
	
	public void setTipoBancoOriginal(TipoBanco tipobanco) {
		try {
			this.tipobancoOriginal=tipobanco;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected TipoBancoAdditional tipobancoAdditional=null;
	
	public TipoBancoAdditional getTipoBancoAdditional() {
		return this.tipobancoAdditional;
	}
	
	public void setTipoBancoAdditional(TipoBancoAdditional tipobancoAdditional) {
		try {
			this.tipobancoAdditional=tipobancoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getcodigo_sri() {
		return this.codigo_sri;
	}
    
	
	public Boolean getes_defecto() {
		return this.es_defecto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoBanco:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
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
						System.out.println("TipoBanco:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("TipoBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcodigo_sri(String newcodigo_sri)throws Exception
	{
		try {
			if(this.codigo_sri!=newcodigo_sri) {
				if(newcodigo_sri==null) {
					//newcodigo_sri="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoBanco:Valor nulo no permitido en columna codigo_sri");
					}
				}

				if(newcodigo_sri!=null&&newcodigo_sri.length()>50) {
					newcodigo_sri=newcodigo_sri.substring(0,48);
					System.out.println("TipoBanco:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo_sri");
				}

				this.codigo_sri=newcodigo_sri;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_defecto(Boolean newes_defecto)throws Exception
	{
		try {
			if(this.es_defecto!=newes_defecto) {
				if(newes_defecto==null) {
					//newes_defecto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("TipoBanco:Valor nulo no permitido en columna es_defecto");
					}
				}

				this.es_defecto=newes_defecto;
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


	
	
	public List<Banco> getBancos() {
		return this.bancos;
	}

	
	
	public  void  setBancos(List<Banco> bancos) {
		try {
			this.bancos=bancos;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String es_defecto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getes_defecto_descripcion() {
		return es_defecto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_defecto_descripcion(String newes_defecto_descripcion)throws Exception {
		try {
			this.es_defecto_descripcion=newes_defecto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.es_defecto_descripcion="";
	}
	
	
	Object importarexportarsDescripcionReporte;
	Object bancosDescripcionReporte;
	
	
	public Object getimportarexportarsDescripcionReporte() {
		return importarexportarsDescripcionReporte;
	}

	public Object getbancosDescripcionReporte() {
		return bancosDescripcionReporte;
	}

	
	
	public  void  setimportarexportarsDescripcionReporte(Object importarexportars) {
		try {
			this.importarexportarsDescripcionReporte=importarexportars;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setbancosDescripcionReporte(Object bancos) {
		try {
			this.bancosDescripcionReporte=bancos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

