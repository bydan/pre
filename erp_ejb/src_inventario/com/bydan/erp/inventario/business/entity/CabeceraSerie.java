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



import org.hibernate.validator.*;

import com.bydan.framework.erp.business.entity.*;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
//import com.bydan.framework.erp.business.entity.Mensajes;
import com.bydan.framework.erp.util.Constantes;
import com.bydan.framework.erp.util.ConstantesValidacion;
//import com.bydan.erp.inventario.util.CabeceraSerieConstantesFunciones;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class CabeceraSerie extends CabeceraSerieAdditional implements Serializable ,Cloneable {//CabeceraSerieAdditional,GeneralEntity
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
	
	private CabeceraSerie cabeceraserieOriginal;
	
	private Map<String, Object> mapCabeceraSerie;
			
	public Map<String, Object> getMapCabeceraSerie() {
		return mapCabeceraSerie;
	}

	public void setMapCabeceraSerie(Map<String, Object> mapCabeceraSerie) {
		this.mapCabeceraSerie = mapCabeceraSerie;
	}
	
	public void inicializarMapCabeceraSerie() {
		this.mapCabeceraSerie = new HashMap<String,Object>();
	}
	
	public void setMapCabeceraSerieValue(String sKey,Object oValue) {
		this.mapCabeceraSerie.put(sKey, oValue);
	}
	
	public Object getMapCabeceraSerieValue(String sKey) {
		return this.mapCabeceraSerie.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=CabeceraSerieConstantesFunciones.SREGEXNOMBRE,message=CabeceraSerieConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=CabeceraSerieConstantesFunciones.SREGEXFORMULA,message=CabeceraSerieConstantesFunciones.SMENSAJEREGEXFORMULA)
	private String formula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_formula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean con_totalizar;
			
	
	public Empresa empresa;
	
	
	private String empresa_descripcion;
	
	
		
	public CabeceraSerie () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.cabeceraserieOriginal=this;
		
 		this.id_empresa=-1L;
 		this.nombre="";
 		this.formula="";
 		this.con_formula=false;
 		this.con_totalizar=false;
		
		
		this.empresa=null;
		
		
		this.empresa_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public CabeceraSerie (Long id,Date versionRow,Long id_empresa,String nombre,String formula,Boolean con_formula,Boolean con_totalizar) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cabeceraserieOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.formula=formula;
 		this.con_formula=con_formula;
 		this.con_totalizar=con_totalizar;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public CabeceraSerie (Long id_empresa,String nombre,String formula,Boolean con_formula,Boolean con_totalizar) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.cabeceraserieOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.nombre=nombre;
 		this.formula=formula;
 		this.con_formula=con_formula;
 		this.con_totalizar=con_totalizar;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		CabeceraSerie cabeceraserieLocal=null;
		
		if(object!=null) {
			cabeceraserieLocal=(CabeceraSerie)object;
			
			if(cabeceraserieLocal!=null) {
				if(this.getId()!=null && cabeceraserieLocal.getId()!=null) {
					if(this.getId().equals(cabeceraserieLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!CabeceraSerieConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=CabeceraSerieConstantesFunciones.getCabeceraSerieDescripcion(this);
		} else {
			sDetalle=CabeceraSerieConstantesFunciones.getCabeceraSerieDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public CabeceraSerie getCabeceraSerieOriginal() {
		return this.cabeceraserieOriginal;
	}
	
	public void setCabeceraSerieOriginal(CabeceraSerie cabeceraserie) {
		try {
			this.cabeceraserieOriginal=cabeceraserie;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected CabeceraSerieAdditional cabeceraserieAdditional=null;
	
	public CabeceraSerieAdditional getCabeceraSerieAdditional() {
		return this.cabeceraserieAdditional;
	}
	
	public void setCabeceraSerieAdditional(CabeceraSerieAdditional cabeceraserieAdditional) {
		try {
			this.cabeceraserieAdditional=cabeceraserieAdditional;
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
    
	
	public String getformula() {
		return this.formula;
	}
    
	
	public Boolean getcon_formula() {
		return this.con_formula;
	}
    
	
	public Boolean getcon_totalizar() {
		return this.con_totalizar;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CabeceraSerie:Valor nulo no permitido en columna id_empresa");
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
						System.out.println("CabeceraSerie:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>50) {
					newnombre=newnombre.substring(0,48);
					System.out.println("CabeceraSerie:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setformula(String newformula)throws Exception
	{
		try {
			if(this.formula!=newformula) {
				if(newformula==null) {
					//newformula="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("CabeceraSerie:Valor nulo no permitido en columna formula");
					}
				}

				if(newformula!=null&&newformula.length()>150) {
					newformula=newformula.substring(0,148);
					System.out.println("CabeceraSerie:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna formula");
				}

				this.formula=newformula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_formula(Boolean newcon_formula)throws Exception
	{
		try {
			if(this.con_formula!=newcon_formula) {
				if(newcon_formula==null) {
					//newcon_formula=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CabeceraSerie:Valor nulo no permitido en columna con_formula");
					}
				}

				this.con_formula=newcon_formula;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setcon_totalizar(Boolean newcon_totalizar)throws Exception
	{
		try {
			if(this.con_totalizar!=newcon_totalizar) {
				if(newcon_totalizar==null) {
					//newcon_totalizar=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("CabeceraSerie:Valor nulo no permitido en columna con_totalizar");
					}
				}

				this.con_totalizar=newcon_totalizar;
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


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String con_formula_descripcion="";String con_totalizar_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getcon_formula_descripcion() {
		return con_formula_descripcion;
	}
	public String getcon_totalizar_descripcion() {
		return con_totalizar_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_formula_descripcion(String newcon_formula_descripcion)throws Exception {
		try {
			this.con_formula_descripcion=newcon_formula_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setcon_totalizar_descripcion(String newcon_totalizar_descripcion)throws Exception {
		try {
			this.con_totalizar_descripcion=newcon_totalizar_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.con_formula_descripcion="";this.con_totalizar_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

