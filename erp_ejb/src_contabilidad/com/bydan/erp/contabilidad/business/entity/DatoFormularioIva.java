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
package com.bydan.erp.contabilidad.business.entity;

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
//import com.bydan.erp.contabilidad.util.DatoFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DatoFormularioIva extends DatoFormularioIvaAdditional implements Serializable ,Cloneable {//DatoFormularioIvaAdditional,GeneralEntity
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
	
	private DatoFormularioIva datoformularioivaOriginal;
	
	private Map<String, Object> mapDatoFormularioIva;
			
	public Map<String, Object> getMapDatoFormularioIva() {
		return mapDatoFormularioIva;
	}

	public void setMapDatoFormularioIva(Map<String, Object> mapDatoFormularioIva) {
		this.mapDatoFormularioIva = mapDatoFormularioIva;
	}
	
	public void inicializarMapDatoFormularioIva() {
		this.mapDatoFormularioIva = new HashMap<String,Object>();
	}
	
	public void setMapDatoFormularioIvaValue(String sKey,Object oValue) {
		this.mapDatoFormularioIva.put(sKey, oValue);
	}
	
	public Object getMapDatoFormularioIvaValue(String sKey) {
		return this.mapDatoFormularioIva.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_mensual;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_semestre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_sustitutiva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoFormularioIvaConstantesFunciones.SREGEXNUMERO_FORMULARIO,message=DatoFormularioIvaConstantesFunciones.SMENSAJEREGEXNUMERO_FORMULARIO)
	private String numero_formulario;
			
	
	public Anio anio;
	public Mes mes;
	public Semestre semestre;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	private String semestre_descripcion;
	
	
	public List<FormularioIva> formularioivas;
		
	public DatoFormularioIva () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.datoformularioivaOriginal=this;
		
 		this.es_mensual=false;
 		this.id_anio=null;
 		this.id_mes=null;
 		this.id_semestre=-1L;
 		this.es_sustitutiva=false;
 		this.numero_formulario="";
		
		
		this.anio=null;
		this.mes=null;
		this.semestre=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		this.semestre_descripcion="";
		
		
		this.formularioivas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DatoFormularioIva (Long id,Date versionRow,Boolean es_mensual,Long id_anio,Long id_mes,Long id_semestre,Boolean es_sustitutiva,String numero_formulario) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoformularioivaOriginal=this;
		
 		this.es_mensual=es_mensual;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_semestre=id_semestre;
 		this.es_sustitutiva=es_sustitutiva;
 		this.numero_formulario=numero_formulario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DatoFormularioIva (Boolean es_mensual,Long id_anio,Long id_mes,Long id_semestre,Boolean es_sustitutiva,String numero_formulario) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoformularioivaOriginal=this;
		
 		this.es_mensual=es_mensual;
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.id_semestre=id_semestre;
 		this.es_sustitutiva=es_sustitutiva;
 		this.numero_formulario=numero_formulario;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DatoFormularioIva datoformularioivaLocal=null;
		
		if(object!=null) {
			datoformularioivaLocal=(DatoFormularioIva)object;
			
			if(datoformularioivaLocal!=null) {
				if(this.getId()!=null && datoformularioivaLocal.getId()!=null) {
					if(this.getId().equals(datoformularioivaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DatoFormularioIvaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaDescripcion(this);
		} else {
			sDetalle=DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DatoFormularioIva getDatoFormularioIvaOriginal() {
		return this.datoformularioivaOriginal;
	}
	
	public void setDatoFormularioIvaOriginal(DatoFormularioIva datoformularioiva) {
		try {
			this.datoformularioivaOriginal=datoformularioiva;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DatoFormularioIvaAdditional datoformularioivaAdditional=null;
	
	public DatoFormularioIvaAdditional getDatoFormularioIvaAdditional() {
		return this.datoformularioivaAdditional;
	}
	
	public void setDatoFormularioIvaAdditional(DatoFormularioIvaAdditional datoformularioivaAdditional) {
		try {
			this.datoformularioivaAdditional=datoformularioivaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Boolean getes_mensual() {
		return this.es_mensual;
	}
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Long getid_semestre() {
		return this.id_semestre;
	}
    
	
	public Boolean getes_sustitutiva() {
		return this.es_sustitutiva;
	}
    
	
	public String getnumero_formulario() {
		return this.numero_formulario;
	}
	
    
	public void setes_mensual(Boolean newes_mensual)throws Exception
	{
		try {
			if(this.es_mensual!=newes_mensual) {
				if(newes_mensual==null) {
					//newes_mensual=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioIva:Valor nulo no permitido en columna es_mensual");
					}
				}

				this.es_mensual=newes_mensual;
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
    
	public void setid_semestre(Long newid_semestre)throws Exception
	{
		try {
			if(this.id_semestre!=newid_semestre) {
				if(newid_semestre==null) {
					//newid_semestre=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioIva:Valor nulo no permitido en columna id_semestre");
					}
				}

				this.id_semestre=newid_semestre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_sustitutiva(Boolean newes_sustitutiva)throws Exception
	{
		try {
			if(this.es_sustitutiva!=newes_sustitutiva) {
				if(newes_sustitutiva==null) {
					//newes_sustitutiva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioIva:Valor nulo no permitido en columna es_sustitutiva");
					}
				}

				this.es_sustitutiva=newes_sustitutiva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_formulario(String newnumero_formulario)throws Exception
	{
		try {
			if(this.numero_formulario!=newnumero_formulario) {
				if(newnumero_formulario==null) {
					//newnumero_formulario="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioIva:Valor nulo no permitido en columna numero_formulario");
					}
				}

				if(newnumero_formulario!=null&&newnumero_formulario.length()>50) {
					newnumero_formulario=newnumero_formulario.substring(0,48);
					System.out.println("DatoFormularioIva:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_formulario");
				}

				this.numero_formulario=newnumero_formulario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Anio getAnio() {
		return this.anio;
	}

	public Mes getMes() {
		return this.mes;
	}

	public Semestre getSemestre() {
		return this.semestre;
	}

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
	}

	public String getsemestre_descripcion() {
		return this.semestre_descripcion;
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


	public  void  setSemestre(Semestre semestre) {
		try {
			this.semestre=semestre;
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


	public  void  setsemestre_descripcion(String semestre_descripcion) {
		try {
			this.semestre_descripcion=semestre_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<FormularioIva> getFormularioIvas() {
		return this.formularioivas;
	}

	
	
	public  void  setFormularioIvas(List<FormularioIva> formularioivas) {
		try {
			this.formularioivas=formularioivas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String es_mensual_descripcion="";String id_anio_descripcion="";String id_mes_descripcion="";String id_semestre_descripcion="";String es_sustitutiva_descripcion="";
	
	
	public String getes_mensual_descripcion() {
		return es_mensual_descripcion;
	}
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getid_semestre_descripcion() {
		return id_semestre_descripcion;
	}
	public String getes_sustitutiva_descripcion() {
		return es_sustitutiva_descripcion;
	}
	
	
	public void setes_mensual_descripcion(String newes_mensual_descripcion)throws Exception {
		try {
			this.es_mensual_descripcion=newes_mensual_descripcion;
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
	public void setid_semestre_descripcion(String newid_semestre_descripcion)throws Exception {
		try {
			this.id_semestre_descripcion=newid_semestre_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_sustitutiva_descripcion(String newes_sustitutiva_descripcion)throws Exception {
		try {
			this.es_sustitutiva_descripcion=newes_sustitutiva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.es_mensual_descripcion="";this.id_anio_descripcion="";this.id_mes_descripcion="";this.id_semestre_descripcion="";this.es_sustitutiva_descripcion="";
	}
	
	
	Object formularioivasDescripcionReporte;
	
	
	public Object getformularioivasDescripcionReporte() {
		return formularioivasDescripcionReporte;
	}

	
	
	public  void  setformularioivasDescripcionReporte(Object formularioivas) {
		try {
			this.formularioivasDescripcionReporte=formularioivas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

