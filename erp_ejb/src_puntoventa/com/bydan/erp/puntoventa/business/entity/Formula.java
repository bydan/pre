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
package com.bydan.erp.puntoventa.business.entity;

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
//import com.bydan.erp.puntoventa.util.FormulaConstantesFunciones;
import com.bydan.erp.puntoventa.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class Formula extends FormulaAdditional implements Serializable ,Cloneable {//FormulaAdditional,GeneralEntity
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
	
	private Formula formulaOriginal;
	
	private Map<String, Object> mapFormula;
			
	public Map<String, Object> getMapFormula() {
		return mapFormula;
	}

	public void setMapFormula(Map<String, Object> mapFormula) {
		this.mapFormula = mapFormula;
	}
	
	public void inicializarMapFormula() {
		this.mapFormula = new HashMap<String,Object>();
	}
	
	public void setMapFormulaValue(String sKey,Object oValue) {
		this.mapFormula.put(sKey, oValue);
	}
	
	public Object getMapFormulaValue(String sKey) {
		return this.mapFormula.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_formula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormulaConstantesFunciones.SREGEXCODIGO,message=FormulaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=FormulaConstantesFunciones.SREGEXNOMBRE,message=FormulaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormulaConstantesFunciones.SREGEXALIAS,message=FormulaConstantesFunciones.SMENSAJEREGEXALIAS)
	private String alias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=FormulaConstantesFunciones.SREGEXFORMULA1,message=FormulaConstantesFunciones.SMENSAJEREGEXFORMULA1)
	private String formula1;
			
	
	public Empresa empresa;
	public TipoFormula tipoformula;
	
	
	private String empresa_descripcion;
	private String tipoformula_descripcion;
	
	
	public List<TarjetaCredito> tarjetacreditoComisions;
		
	public Formula () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.formulaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_formula=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.alias="";
 		this.valor=0.0;
 		this.formula1="";
		
		
		this.empresa=null;
		this.tipoformula=null;
		
		
		this.empresa_descripcion="";
		this.tipoformula_descripcion="";
		
		
		this.tarjetacreditoComisions=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public Formula (Long id,Date versionRow,Long id_empresa,Long id_tipo_formula,String codigo,String nombre,String alias,Double valor,String formula1) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_formula=id_tipo_formula;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.alias=alias;
 		this.valor=valor;
 		this.formula1=formula1;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public Formula (Long id_empresa,Long id_tipo_formula,String codigo,String nombre,String alias,Double valor,String formula1) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.formulaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_formula=id_tipo_formula;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.alias=alias;
 		this.valor=valor;
 		this.formula1=formula1;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		Formula formulaLocal=null;
		
		if(object!=null) {
			formulaLocal=(Formula)object;
			
			if(formulaLocal!=null) {
				if(this.getId()!=null && formulaLocal.getId()!=null) {
					if(this.getId().equals(formulaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!FormulaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=FormulaConstantesFunciones.getFormulaDescripcion(this);
		} else {
			sDetalle=FormulaConstantesFunciones.getFormulaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public Formula getFormulaOriginal() {
		return this.formulaOriginal;
	}
	
	public void setFormulaOriginal(Formula formula) {
		try {
			this.formulaOriginal=formula;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected FormulaAdditional formulaAdditional=null;
	
	public FormulaAdditional getFormulaAdditional() {
		return this.formulaAdditional;
	}
	
	public void setFormulaAdditional(FormulaAdditional formulaAdditional) {
		try {
			this.formulaAdditional=formulaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_formula() {
		return this.id_tipo_formula;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getalias() {
		return this.alias;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public String getformula1() {
		return this.formula1;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formula:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_formula(Long newid_tipo_formula)throws Exception
	{
		try {
			if(this.id_tipo_formula!=newid_tipo_formula) {
				if(newid_tipo_formula==null) {
					//newid_tipo_formula=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formula:Valor nulo no permitido en columna id_tipo_formula");
					}
				}

				this.id_tipo_formula=newid_tipo_formula;
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
						System.out.println("Formula:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("Formula:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("Formula:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("Formula:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setalias(String newalias)throws Exception
	{
		try {
			if(this.alias!=newalias) {
				if(newalias==null) {
					//newalias="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formula:Valor nulo no permitido en columna alias");
					}
				}

				if(newalias!=null&&newalias.length()>50) {
					newalias=newalias.substring(0,48);
					System.out.println("Formula:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna alias");
				}

				this.alias=newalias;
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
						System.out.println("Formula:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setformula1(String newformula1)throws Exception
	{
		try {
			if(this.formula1!=newformula1) {
				if(newformula1==null) {
					//newformula1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("Formula:Valor nulo no permitido en columna formula1");
					}
				}

				if(newformula1!=null&&newformula1.length()>150) {
					newformula1=newformula1.substring(0,148);
					System.out.println("Formula:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna formula1");
				}

				this.formula1=newformula1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoFormula getTipoFormula() {
		return this.tipoformula;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoformula_descripcion() {
		return this.tipoformula_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoFormula(TipoFormula tipoformula) {
		try {
			this.tipoformula=tipoformula;
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


	public  void  settipoformula_descripcion(String tipoformula_descripcion) {
		try {
			this.tipoformula_descripcion=tipoformula_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<TarjetaCredito> getTarjetaCreditoComisions() {
		return this.tarjetacreditoComisions;
	}

	
	
	public  void  setTarjetaCreditoComisions(List<TarjetaCredito> tarjetacreditoComisions) {
		try {
			this.tarjetacreditoComisions=tarjetacreditoComisions;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_formula_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_formula_descripcion() {
		return id_tipo_formula_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_formula_descripcion(String newid_tipo_formula_descripcion)throws Exception {
		try {
			this.id_tipo_formula_descripcion=newid_tipo_formula_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_formula_descripcion="";
	}
	
	
	Object tarjetacreditoComisionsDescripcionReporte;
	
	
	public Object gettarjetacreditoComisionsDescripcionReporte() {
		return tarjetacreditoComisionsDescripcionReporte;
	}

	
	
	public  void  settarjetacreditoComisionsDescripcionReporte(Object tarjetacreditos) {
		try {
			this.tarjetacreditoComisionsDescripcionReporte=tarjetacreditos;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

