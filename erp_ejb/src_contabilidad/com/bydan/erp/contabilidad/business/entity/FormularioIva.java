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
//import com.bydan.erp.contabilidad.util.FormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class FormularioIva extends FormularioIvaAdditional implements Serializable ,Cloneable {//FormularioIvaAdditional,GeneralEntity
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
	
	private FormularioIva formularioivaOriginal;
	
	private Map<String, Object> mapFormularioIva;
			
	public Map<String, Object> getMapFormularioIva() {
		return mapFormularioIva;
	}

	public void setMapFormularioIva(Map<String, Object> mapFormularioIva) {
		this.mapFormularioIva = mapFormularioIva;
	}
	
	public void inicializarMapFormularioIva() {
		this.mapFormularioIva = new HashMap<String,Object>();
	}
	
	public void setMapFormularioIvaValue(String sKey,Object oValue) {
		this.mapFormularioIva.put(sKey, oValue);
	}
	
	public Object getMapFormularioIvaValue(String sKey) {
		return this.mapFormularioIva.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_ejercicio;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_periodo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_dato_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_grupo_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_parametro_formulario_iva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	public Ejercicio ejercicio;
	public Periodo periodo;
	public DatoFormularioIva datoformularioiva;
	public GrupoParametroFormularioIva grupoparametroformularioiva;
	public ParametroFormularioIva parametroformularioiva;
	
	
	private String empresa_descripcion;
	private String ejercicio_descripcion;
	private String periodo_descripcion;
	private String datoformularioiva_descripcion;
	private String grupoparametroformularioiva_descripcion;
	private String parametroformularioiva_descripcion;
	
	
		
	public FormularioIva () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formularioivaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_ejercicio=-1L;
 		this.id_periodo=-1L;
 		this.id_dato_formulario_iva=-1L;
 		this.id_grupo_parametro_formulario_iva=-1L;
 		this.id_parametro_formulario_iva=-1L;
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.ejercicio=null;
		this.periodo=null;
		this.datoformularioiva=null;
		this.grupoparametroformularioiva=null;
		this.parametroformularioiva=null;
		
		
		this.empresa_descripcion="";
		this.ejercicio_descripcion="";
		this.periodo_descripcion="";
		this.datoformularioiva_descripcion="";
		this.grupoparametroformularioiva_descripcion="";
		this.parametroformularioiva_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public FormularioIva (Long id,Date versionRow,Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_iva,Long id_grupo_parametro_formulario_iva,Long id_parametro_formulario_iva,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formularioivaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_iva=id_dato_formulario_iva;
 		this.id_grupo_parametro_formulario_iva=id_grupo_parametro_formulario_iva;
 		this.id_parametro_formulario_iva=id_parametro_formulario_iva;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public FormularioIva (Long id_empresa,Long id_ejercicio,Long id_periodo,Long id_dato_formulario_iva,Long id_grupo_parametro_formulario_iva,Long id_parametro_formulario_iva,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formularioivaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_ejercicio=id_ejercicio;
 		this.id_periodo=id_periodo;
 		this.id_dato_formulario_iva=id_dato_formulario_iva;
 		this.id_grupo_parametro_formulario_iva=id_grupo_parametro_formulario_iva;
 		this.id_parametro_formulario_iva=id_parametro_formulario_iva;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		FormularioIva formularioivaLocal=null;
		
		if(object!=null) {
			formularioivaLocal=(FormularioIva)object;
			
			if(formularioivaLocal!=null) {
				if(this.getId()!=null && formularioivaLocal.getId()!=null) {
					if(this.getId().equals(formularioivaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormularioIvaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormularioIvaConstantesFunciones.getFormularioIvaDescripcion(this);
		} else {
			sDetalle=FormularioIvaConstantesFunciones.getFormularioIvaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public FormularioIva getFormularioIvaOriginal() {
		return this.formularioivaOriginal;
	}
	
	public void setFormularioIvaOriginal(FormularioIva formularioiva) {
		try {
			this.formularioivaOriginal=formularioiva;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormularioIvaAdditional formularioivaAdditional=null;
	
	public FormularioIvaAdditional getFormularioIvaAdditional() {
		return this.formularioivaAdditional;
	}
	
	public void setFormularioIvaAdditional(FormularioIvaAdditional formularioivaAdditional) {
		try {
			this.formularioivaAdditional=formularioivaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_ejercicio() {
		return this.id_ejercicio;
	}
    
	
	public Long getid_periodo() {
		return this.id_periodo;
	}
    
	
	public Long getid_dato_formulario_iva() {
		return this.id_dato_formulario_iva;
	}
    
	
	public Long getid_grupo_parametro_formulario_iva() {
		return this.id_grupo_parametro_formulario_iva;
	}
    
	
	public Long getid_parametro_formulario_iva() {
		return this.id_parametro_formulario_iva;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_ejercicio(Long newid_ejercicio)throws Exception
	{
		try {
			if(this.id_ejercicio!=newid_ejercicio) {
				if(newid_ejercicio==null) {
					//newid_ejercicio=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_ejercicio");
					}
				}

				this.id_ejercicio=newid_ejercicio;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_periodo(Long newid_periodo)throws Exception
	{
		try {
			if(this.id_periodo!=newid_periodo) {
				if(newid_periodo==null) {
					//newid_periodo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_periodo");
					}
				}

				this.id_periodo=newid_periodo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_dato_formulario_iva(Long newid_dato_formulario_iva)throws Exception
	{
		try {
			if(this.id_dato_formulario_iva!=newid_dato_formulario_iva) {
				if(newid_dato_formulario_iva==null) {
					//newid_dato_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_dato_formulario_iva");
					}
				}

				this.id_dato_formulario_iva=newid_dato_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_grupo_parametro_formulario_iva(Long newid_grupo_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_grupo_parametro_formulario_iva!=newid_grupo_parametro_formulario_iva) {
				if(newid_grupo_parametro_formulario_iva==null) {
					//newid_grupo_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_grupo_parametro_formulario_iva");
					}
				}

				this.id_grupo_parametro_formulario_iva=newid_grupo_parametro_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_parametro_formulario_iva(Long newid_parametro_formulario_iva)throws Exception
	{
		try {
			if(this.id_parametro_formulario_iva!=newid_parametro_formulario_iva) {
				if(newid_parametro_formulario_iva==null) {
					//newid_parametro_formulario_iva=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna id_parametro_formulario_iva");
					}
				}

				this.id_parametro_formulario_iva=newid_parametro_formulario_iva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setvalor(Double newvalor)throws Exception
	{
		try {
			if(this.valor!=newvalor) {
				if(newvalor==null) {
					//newvalor=0.0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("FormularioIva:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public DatoFormularioIva getDatoFormularioIva() {
		return this.datoformularioiva;
	}

	public GrupoParametroFormularioIva getGrupoParametroFormularioIva() {
		return this.grupoparametroformularioiva;
	}

	public ParametroFormularioIva getParametroFormularioIva() {
		return this.parametroformularioiva;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getejercicio_descripcion() {
		return this.ejercicio_descripcion;
	}

	public String getperiodo_descripcion() {
		return this.periodo_descripcion;
	}

	public String getdatoformularioiva_descripcion() {
		return this.datoformularioiva_descripcion;
	}

	public String getgrupoparametroformularioiva_descripcion() {
		return this.grupoparametroformularioiva_descripcion;
	}

	public String getparametroformularioiva_descripcion() {
		return this.parametroformularioiva_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setEjercicio(Ejercicio ejercicio) {
		try {
			this.ejercicio=ejercicio;
		} catch(Exception e) {
			;
		}
	}


	public  void  setPeriodo(Periodo periodo) {
		try {
			this.periodo=periodo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setDatoFormularioIva(DatoFormularioIva datoformularioiva) {
		try {
			this.datoformularioiva=datoformularioiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setGrupoParametroFormularioIva(GrupoParametroFormularioIva grupoparametroformularioiva) {
		try {
			this.grupoparametroformularioiva=grupoparametroformularioiva;
		} catch(Exception e) {
			;
		}
	}


	public  void  setParametroFormularioIva(ParametroFormularioIva parametroformularioiva) {
		try {
			this.parametroformularioiva=parametroformularioiva;
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


	public  void  setejercicio_descripcion(String ejercicio_descripcion) {
		try {
			this.ejercicio_descripcion=ejercicio_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setperiodo_descripcion(String periodo_descripcion) {
		try {
			this.periodo_descripcion=periodo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setdatoformularioiva_descripcion(String datoformularioiva_descripcion) {
		try {
			this.datoformularioiva_descripcion=datoformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setgrupoparametroformularioiva_descripcion(String grupoparametroformularioiva_descripcion) {
		try {
			this.grupoparametroformularioiva_descripcion=grupoparametroformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setparametroformularioiva_descripcion(String parametroformularioiva_descripcion) {
		try {
			this.parametroformularioiva_descripcion=parametroformularioiva_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_ejercicio_descripcion="";String id_periodo_descripcion="";String id_dato_formulario_iva_descripcion="";String id_grupo_parametro_formulario_iva_descripcion="";String id_parametro_formulario_iva_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_ejercicio_descripcion() {
		return id_ejercicio_descripcion;
	}
	public String getid_periodo_descripcion() {
		return id_periodo_descripcion;
	}
	public String getid_dato_formulario_iva_descripcion() {
		return id_dato_formulario_iva_descripcion;
	}
	public String getid_grupo_parametro_formulario_iva_descripcion() {
		return id_grupo_parametro_formulario_iva_descripcion;
	}
	public String getid_parametro_formulario_iva_descripcion() {
		return id_parametro_formulario_iva_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_ejercicio_descripcion(String newid_ejercicio_descripcion)throws Exception {
		try {
			this.id_ejercicio_descripcion=newid_ejercicio_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_periodo_descripcion(String newid_periodo_descripcion)throws Exception {
		try {
			this.id_periodo_descripcion=newid_periodo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_dato_formulario_iva_descripcion(String newid_dato_formulario_iva_descripcion)throws Exception {
		try {
			this.id_dato_formulario_iva_descripcion=newid_dato_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_grupo_parametro_formulario_iva_descripcion(String newid_grupo_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_grupo_parametro_formulario_iva_descripcion=newid_grupo_parametro_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_parametro_formulario_iva_descripcion(String newid_parametro_formulario_iva_descripcion)throws Exception {
		try {
			this.id_parametro_formulario_iva_descripcion=newid_parametro_formulario_iva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_ejercicio_descripcion="";this.id_periodo_descripcion="";this.id_dato_formulario_iva_descripcion="";this.id_grupo_parametro_formulario_iva_descripcion="";this.id_parametro_formulario_iva_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

