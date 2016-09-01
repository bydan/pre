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
//import com.bydan.erp.nomina.util.PreguntaNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class PreguntaNomi extends PreguntaNomiAdditional implements Serializable ,Cloneable {//PreguntaNomiAdditional,GeneralEntity
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
	
	private PreguntaNomi preguntanomiOriginal;
	
	private Map<String, Object> mapPreguntaNomi;
			
	public Map<String, Object> getMapPreguntaNomi() {
		return mapPreguntaNomi;
	}

	public void setMapPreguntaNomi(Map<String, Object> mapPreguntaNomi) {
		this.mapPreguntaNomi = mapPreguntaNomi;
	}
	
	public void inicializarMapPreguntaNomi() {
		this.mapPreguntaNomi = new HashMap<String,Object>();
	}
	
	public void setMapPreguntaNomiValue(String sKey,Object oValue) {
		this.mapPreguntaNomi.put(sKey, oValue);
	}
	
	public Object getMapPreguntaNomiValue(String sKey) {
		return this.mapPreguntaNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_factor_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=PreguntaNomiConstantesFunciones.SREGEXPREGUNTA,message=PreguntaNomiConstantesFunciones.SMENSAJEREGEXPREGUNTA)
	private String pregunta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer orden;
			
	
	public Empresa empresa;
	public FactorNomi factornomi;
	
	
	private String empresa_descripcion;
	private String factornomi_descripcion;
	
	
	public List<FormatoNomiPreguntaNomi> formatonomipreguntanomis;
	public List<DetalleEvaluacionNomi> detalleevaluacionnomis;
		
	public PreguntaNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.preguntanomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_factor_nomi=-1L;
 		this.pregunta="";
 		this.orden=0;
		
		
		this.empresa=null;
		this.factornomi=null;
		
		
		this.empresa_descripcion="";
		this.factornomi_descripcion="";
		
		
		this.formatonomipreguntanomis=null;
		this.detalleevaluacionnomis=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public PreguntaNomi (Long id,Date versionRow,Long id_empresa,Long id_factor_nomi,String pregunta,Integer orden) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.preguntanomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_factor_nomi=id_factor_nomi;
 		this.pregunta=pregunta;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public PreguntaNomi (Long id_empresa,Long id_factor_nomi,String pregunta,Integer orden) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.preguntanomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_factor_nomi=id_factor_nomi;
 		this.pregunta=pregunta;
 		this.orden=orden;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		PreguntaNomi preguntanomiLocal=null;
		
		if(object!=null) {
			preguntanomiLocal=(PreguntaNomi)object;
			
			if(preguntanomiLocal!=null) {
				if(this.getId()!=null && preguntanomiLocal.getId()!=null) {
					if(this.getId().equals(preguntanomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!PreguntaNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcion(this);
		} else {
			sDetalle=PreguntaNomiConstantesFunciones.getPreguntaNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public PreguntaNomi getPreguntaNomiOriginal() {
		return this.preguntanomiOriginal;
	}
	
	public void setPreguntaNomiOriginal(PreguntaNomi preguntanomi) {
		try {
			this.preguntanomiOriginal=preguntanomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected PreguntaNomiAdditional preguntanomiAdditional=null;
	
	public PreguntaNomiAdditional getPreguntaNomiAdditional() {
		return this.preguntanomiAdditional;
	}
	
	public void setPreguntaNomiAdditional(PreguntaNomiAdditional preguntanomiAdditional) {
		try {
			this.preguntanomiAdditional=preguntanomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_factor_nomi() {
		return this.id_factor_nomi;
	}
    
	
	public String getpregunta() {
		return this.pregunta;
	}
    
	
	public Integer getorden() {
		return this.orden;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PreguntaNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_factor_nomi(Long newid_factor_nomi)throws Exception
	{
		try {
			if(this.id_factor_nomi!=newid_factor_nomi) {
				if(newid_factor_nomi==null) {
					//newid_factor_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("PreguntaNomi:Valor nulo no permitido en columna id_factor_nomi");
					}
				}

				this.id_factor_nomi=newid_factor_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpregunta(String newpregunta)throws Exception
	{
		try {
			if(this.pregunta!=newpregunta) {
				if(newpregunta==null) {
					//newpregunta="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("PreguntaNomi:Valor nulo no permitido en columna pregunta");
					}
				}

				if(newpregunta!=null&&newpregunta.length()>150) {
					newpregunta=newpregunta.substring(0,148);
					System.out.println("PreguntaNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna pregunta");
				}

				this.pregunta=newpregunta;
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
						System.out.println("PreguntaNomi:Valor nulo no permitido en columna orden");
					}
				}

				this.orden=neworden;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public FactorNomi getFactorNomi() {
		return this.factornomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getfactornomi_descripcion() {
		return this.factornomi_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setFactorNomi(FactorNomi factornomi) {
		try {
			this.factornomi=factornomi;
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


	public  void  setfactornomi_descripcion(String factornomi_descripcion) {
		try {
			this.factornomi_descripcion=factornomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<FormatoNomiPreguntaNomi> getFormatoNomiPreguntaNomis() {
		return this.formatonomipreguntanomis;
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

	public  void  setDetalleEvaluacionNomis(List<DetalleEvaluacionNomi> detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomis=detalleevaluacionnomis;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_factor_nomi_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_factor_nomi_descripcion() {
		return id_factor_nomi_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_factor_nomi_descripcion(String newid_factor_nomi_descripcion)throws Exception {
		try {
			this.id_factor_nomi_descripcion=newid_factor_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_factor_nomi_descripcion="";
	}
	
	
	Object formatonomipreguntanomisDescripcionReporte;
	Object detalleevaluacionnomisDescripcionReporte;
	
	
	public Object getformatonomipreguntanomisDescripcionReporte() {
		return formatonomipreguntanomisDescripcionReporte;
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

	public  void  setdetalleevaluacionnomisDescripcionReporte(Object detalleevaluacionnomis) {
		try {
			this.detalleevaluacionnomisDescripcionReporte=detalleevaluacionnomis;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

