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
//import com.bydan.erp.contabilidad.util.DatoFormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class DatoFormularioRenta extends DatoFormularioRentaAdditional implements Serializable ,Cloneable {//DatoFormularioRentaAdditional,GeneralEntity
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
	
	private DatoFormularioRenta datoformulariorentaOriginal;
	
	private Map<String, Object> mapDatoFormularioRenta;
			
	public Map<String, Object> getMapDatoFormularioRenta() {
		return mapDatoFormularioRenta;
	}

	public void setMapDatoFormularioRenta(Map<String, Object> mapDatoFormularioRenta) {
		this.mapDatoFormularioRenta = mapDatoFormularioRenta;
	}
	
	public void inicializarMapDatoFormularioRenta() {
		this.mapDatoFormularioRenta = new HashMap<String,Object>();
	}
	
	public void setMapDatoFormularioRentaValue(String sKey,Object oValue) {
		this.mapDatoFormularioRenta.put(sKey, oValue);
	}
	
	public Object getMapDatoFormularioRentaValue(String sKey) {
		return this.mapDatoFormularioRenta.get(sKey);
	}
	
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_anio;
	
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_sustitutiva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoFormularioRentaConstantesFunciones.SREGEXNUMERO_FORMULARIO,message=DatoFormularioRentaConstantesFunciones.SMENSAJEREGEXNUMERO_FORMULARIO)
	private String numero_formulario;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoFormularioRentaConstantesFunciones.SREGEXCEDULA_REPRESENTANTE,message=DatoFormularioRentaConstantesFunciones.SMENSAJEREGEXCEDULA_REPRESENTANTE)
	private String cedula_representante;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DatoFormularioRentaConstantesFunciones.SREGEXNUMERO_FISCAL,message=DatoFormularioRentaConstantesFunciones.SMENSAJEREGEXNUMERO_FISCAL)
	private String numero_fiscal;
			
	
	public Anio anio;
	public Mes mes;
	
	
	private String anio_descripcion;
	private String mes_descripcion;
	
	
	public List<FormularioRenta> formulariorentas;
	public List<FormularioRentaExtra> formulariorentaextras;
		
	public DatoFormularioRenta () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.datoformulariorentaOriginal=this;
		
 		this.id_anio=null;
 		this.id_mes=null;
 		this.es_sustitutiva=false;
 		this.numero_formulario="";
 		this.cedula_representante="";
 		this.numero_fiscal="";
		
		
		this.anio=null;
		this.mes=null;
		
		
		this.anio_descripcion="";
		this.mes_descripcion="";
		
		
		this.formulariorentas=null;
		this.formulariorentaextras=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DatoFormularioRenta (Long id,Date versionRow,Long id_anio,Long id_mes,Boolean es_sustitutiva,String numero_formulario,String cedula_representante,String numero_fiscal) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoformulariorentaOriginal=this;
		
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.es_sustitutiva=es_sustitutiva;
 		this.numero_formulario=numero_formulario;
 		this.cedula_representante=cedula_representante;
 		this.numero_fiscal=numero_fiscal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DatoFormularioRenta (Long id_anio,Long id_mes,Boolean es_sustitutiva,String numero_formulario,String cedula_representante,String numero_fiscal) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.datoformulariorentaOriginal=this;
		
 		this.id_anio=id_anio;
 		this.id_mes=id_mes;
 		this.es_sustitutiva=es_sustitutiva;
 		this.numero_formulario=numero_formulario;
 		this.cedula_representante=cedula_representante;
 		this.numero_fiscal=numero_fiscal;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DatoFormularioRenta datoformulariorentaLocal=null;
		
		if(object!=null) {
			datoformulariorentaLocal=(DatoFormularioRenta)object;
			
			if(datoformulariorentaLocal!=null) {
				if(this.getId()!=null && datoformulariorentaLocal.getId()!=null) {
					if(this.getId().equals(datoformulariorentaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DatoFormularioRentaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcion(this);
		} else {
			sDetalle=DatoFormularioRentaConstantesFunciones.getDatoFormularioRentaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DatoFormularioRenta getDatoFormularioRentaOriginal() {
		return this.datoformulariorentaOriginal;
	}
	
	public void setDatoFormularioRentaOriginal(DatoFormularioRenta datoformulariorenta) {
		try {
			this.datoformulariorentaOriginal=datoformulariorenta;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DatoFormularioRentaAdditional datoformulariorentaAdditional=null;
	
	public DatoFormularioRentaAdditional getDatoFormularioRentaAdditional() {
		return this.datoformulariorentaAdditional;
	}
	
	public void setDatoFormularioRentaAdditional(DatoFormularioRentaAdditional datoformulariorentaAdditional) {
		try {
			this.datoformulariorentaAdditional=datoformulariorentaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_anio() {
		return this.id_anio;
	}
    
	
	public Long getid_mes() {
		return this.id_mes;
	}
    
	
	public Boolean getes_sustitutiva() {
		return this.es_sustitutiva;
	}
    
	
	public String getnumero_formulario() {
		return this.numero_formulario;
	}
    
	
	public String getcedula_representante() {
		return this.cedula_representante;
	}
    
	
	public String getnumero_fiscal() {
		return this.numero_fiscal;
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
    
	public void setes_sustitutiva(Boolean newes_sustitutiva)throws Exception
	{
		try {
			if(this.es_sustitutiva!=newes_sustitutiva) {
				if(newes_sustitutiva==null) {
					//newes_sustitutiva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioRenta:Valor nulo no permitido en columna es_sustitutiva");
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
						System.out.println("DatoFormularioRenta:Valor nulo no permitido en columna numero_formulario");
					}
				}

				if(newnumero_formulario!=null&&newnumero_formulario.length()>50) {
					newnumero_formulario=newnumero_formulario.substring(0,48);
					System.out.println("DatoFormularioRenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_formulario");
				}

				this.numero_formulario=newnumero_formulario;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcedula_representante(String newcedula_representante)throws Exception
	{
		try {
			if(this.cedula_representante!=newcedula_representante) {
				if(newcedula_representante==null) {
					//newcedula_representante="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioRenta:Valor nulo no permitido en columna cedula_representante");
					}
				}

				if(newcedula_representante!=null&&newcedula_representante.length()>50) {
					newcedula_representante=newcedula_representante.substring(0,48);
					System.out.println("DatoFormularioRenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna cedula_representante");
				}

				this.cedula_representante=newcedula_representante;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setnumero_fiscal(String newnumero_fiscal)throws Exception
	{
		try {
			if(this.numero_fiscal!=newnumero_fiscal) {
				if(newnumero_fiscal==null) {
					//newnumero_fiscal="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DatoFormularioRenta:Valor nulo no permitido en columna numero_fiscal");
					}
				}

				if(newnumero_fiscal!=null&&newnumero_fiscal.length()>50) {
					newnumero_fiscal=newnumero_fiscal.substring(0,48);
					System.out.println("DatoFormularioRenta:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna numero_fiscal");
				}

				this.numero_fiscal=newnumero_fiscal;
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

	
	
	public String getanio_descripcion() {
		return this.anio_descripcion;
	}

	public String getmes_descripcion() {
		return this.mes_descripcion;
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


	
	
	public List<FormularioRenta> getFormularioRentas() {
		return this.formulariorentas;
	}

	public List<FormularioRentaExtra> getFormularioRentaExtras() {
		return this.formulariorentaextras;
	}

	
	
	public  void  setFormularioRentas(List<FormularioRenta> formulariorentas) {
		try {
			this.formulariorentas=formulariorentas;
		} catch(Exception e) {
			;
		}
	}

	public  void  setFormularioRentaExtras(List<FormularioRentaExtra> formulariorentaextras) {
		try {
			this.formulariorentaextras=formulariorentaextras;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_anio_descripcion="";String id_mes_descripcion="";String es_sustitutiva_descripcion="";
	
	
	public String getid_anio_descripcion() {
		return id_anio_descripcion;
	}
	public String getid_mes_descripcion() {
		return id_mes_descripcion;
	}
	public String getes_sustitutiva_descripcion() {
		return es_sustitutiva_descripcion;
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
	public void setes_sustitutiva_descripcion(String newes_sustitutiva_descripcion)throws Exception {
		try {
			this.es_sustitutiva_descripcion=newes_sustitutiva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_anio_descripcion="";this.id_mes_descripcion="";this.es_sustitutiva_descripcion="";
	}
	
	
	Object formulariorentasDescripcionReporte;
	Object formulariorentaextrasDescripcionReporte;
	
	
	public Object getformulariorentasDescripcionReporte() {
		return formulariorentasDescripcionReporte;
	}

	public Object getformulariorentaextrasDescripcionReporte() {
		return formulariorentaextrasDescripcionReporte;
	}

	
	
	public  void  setformulariorentasDescripcionReporte(Object formulariorentas) {
		try {
			this.formulariorentasDescripcionReporte=formulariorentas;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setformulariorentaextrasDescripcionReporte(Object formulariorentaextras) {
		try {
			this.formulariorentaextrasDescripcionReporte=formulariorentaextras;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

