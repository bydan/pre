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
//import com.bydan.erp.nomina.util.RubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class RubroEmplea extends RubroEmpleaAdditional implements Serializable ,Cloneable {//RubroEmpleaAdditional,GeneralEntity
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
	
	private RubroEmplea rubroempleaOriginal;
	
	private Map<String, Object> mapRubroEmplea;
			
	public Map<String, Object> getMapRubroEmplea() {
		return mapRubroEmplea;
	}

	public void setMapRubroEmplea(Map<String, Object> mapRubroEmplea) {
		this.mapRubroEmplea = mapRubroEmplea;
	}
	
	public void inicializarMapRubroEmplea() {
		this.mapRubroEmplea = new HashMap<String,Object>();
	}
	
	public void setMapRubroEmpleaValue(String sKey,Object oValue) {
		this.mapRubroEmplea.put(sKey, oValue);
	}
	
	public Object getMapRubroEmpleaValue(String sKey) {
		return this.mapRubroEmplea.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_calculo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_rubro_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_grupo_rubro_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RubroEmpleaConstantesFunciones.SREGEXCODIGO,message=RubroEmpleaConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RubroEmpleaConstantesFunciones.SREGEXNOMBRE,message=RubroEmpleaConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RubroEmpleaConstantesFunciones.SREGEXFORMULA,message=RubroEmpleaConstantesFunciones.SMENSAJEREGEXFORMULA)
	private String formula;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=RubroEmpleaConstantesFunciones.SREGEXALIAS,message=RubroEmpleaConstantesFunciones.SMENSAJEREGEXALIAS)
	private String alias;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer secuencial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_rol_pagos;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_sueldo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_vacaciones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_impuesto_renta;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_seguro_social;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_provisiones;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_utilidades;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_rubro_iess;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_fondo_reserva;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_decimo_tercero;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_decimo_cuarto;
			
	
	public Empresa empresa;
	public TipoCalculo tipocalculo;
	public TipoRubroEmplea tiporubroemplea;
	public TipoGrupoRubroEmplea tipogruporubroemplea;
	
	
	private String empresa_descripcion;
	private String tipocalculo_descripcion;
	private String tiporubroemplea_descripcion;
	private String tipogruporubroemplea_descripcion;
	
	
	public List<HistorialPagoNomi> historialpagonomis;
	public List<RubroEstructura> rubroestructuras;
	public List<DefiProvisionEmpleado> defiprovisionempleados;
	public List<EmpleadoPagoRubro> empleadopagorubros;
	public List<HistorialPagoMesNomi> historialpagomesnomis;
	public List<RubroEmpleado> rubroempleados;
	public List<ValorRubroVariable> valorrubrovariables;
	public List<TipoPrestamo> tipoprestamos;
	public List<RubroEmpleaCuentaContable> rubroempleacuentacontables;
		
	public RubroEmplea () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.rubroempleaOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_calculo=-1L;
 		this.id_tipo_rubro_emplea=-1L;
 		this.id_tipo_grupo_rubro_emplea=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.formula="";
 		this.alias="";
 		this.secuencial=0;
 		this.para_rol_pagos=false;
 		this.para_sueldo=false;
 		this.para_vacaciones=false;
 		this.para_impuesto_renta=false;
 		this.para_seguro_social=false;
 		this.para_provisiones=false;
 		this.para_utilidades=false;
 		this.para_rubro_iess=false;
 		this.es_fondo_reserva=false;
 		this.es_decimo_tercero=false;
 		this.es_decimo_cuarto=false;
		
		
		this.empresa=null;
		this.tipocalculo=null;
		this.tiporubroemplea=null;
		this.tipogruporubroemplea=null;
		
		
		this.empresa_descripcion="";
		this.tipocalculo_descripcion="";
		this.tiporubroemplea_descripcion="";
		this.tipogruporubroemplea_descripcion="";
		
		
		this.historialpagonomis=null;
		this.rubroestructuras=null;
		this.defiprovisionempleados=null;
		this.empleadopagorubros=null;
		this.historialpagomesnomis=null;
		this.rubroempleados=null;
		this.valorrubrovariables=null;
		this.tipoprestamos=null;
		this.rubroempleacuentacontables=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public RubroEmplea (Long id,Date versionRow,Long id_empresa,Long id_tipo_calculo,Long id_tipo_rubro_emplea,Long id_tipo_grupo_rubro_emplea,String codigo,String nombre,String formula,String alias,Integer secuencial,Boolean para_rol_pagos,Boolean para_sueldo,Boolean para_vacaciones,Boolean para_impuesto_renta,Boolean para_seguro_social,Boolean para_provisiones,Boolean para_utilidades,Boolean para_rubro_iess,Boolean es_fondo_reserva,Boolean es_decimo_tercero,Boolean es_decimo_cuarto) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rubroempleaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_calculo=id_tipo_calculo;
 		this.id_tipo_rubro_emplea=id_tipo_rubro_emplea;
 		this.id_tipo_grupo_rubro_emplea=id_tipo_grupo_rubro_emplea;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.formula=formula;
 		this.alias=alias;
 		this.secuencial=secuencial;
 		this.para_rol_pagos=para_rol_pagos;
 		this.para_sueldo=para_sueldo;
 		this.para_vacaciones=para_vacaciones;
 		this.para_impuesto_renta=para_impuesto_renta;
 		this.para_seguro_social=para_seguro_social;
 		this.para_provisiones=para_provisiones;
 		this.para_utilidades=para_utilidades;
 		this.para_rubro_iess=para_rubro_iess;
 		this.es_fondo_reserva=es_fondo_reserva;
 		this.es_decimo_tercero=es_decimo_tercero;
 		this.es_decimo_cuarto=es_decimo_cuarto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public RubroEmplea (Long id_empresa,Long id_tipo_calculo,Long id_tipo_rubro_emplea,Long id_tipo_grupo_rubro_emplea,String codigo,String nombre,String formula,String alias,Integer secuencial,Boolean para_rol_pagos,Boolean para_sueldo,Boolean para_vacaciones,Boolean para_impuesto_renta,Boolean para_seguro_social,Boolean para_provisiones,Boolean para_utilidades,Boolean para_rubro_iess,Boolean es_fondo_reserva,Boolean es_decimo_tercero,Boolean es_decimo_cuarto) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.rubroempleaOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_calculo=id_tipo_calculo;
 		this.id_tipo_rubro_emplea=id_tipo_rubro_emplea;
 		this.id_tipo_grupo_rubro_emplea=id_tipo_grupo_rubro_emplea;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.formula=formula;
 		this.alias=alias;
 		this.secuencial=secuencial;
 		this.para_rol_pagos=para_rol_pagos;
 		this.para_sueldo=para_sueldo;
 		this.para_vacaciones=para_vacaciones;
 		this.para_impuesto_renta=para_impuesto_renta;
 		this.para_seguro_social=para_seguro_social;
 		this.para_provisiones=para_provisiones;
 		this.para_utilidades=para_utilidades;
 		this.para_rubro_iess=para_rubro_iess;
 		this.es_fondo_reserva=es_fondo_reserva;
 		this.es_decimo_tercero=es_decimo_tercero;
 		this.es_decimo_cuarto=es_decimo_cuarto;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		RubroEmplea rubroempleaLocal=null;
		
		if(object!=null) {
			rubroempleaLocal=(RubroEmplea)object;
			
			if(rubroempleaLocal!=null) {
				if(this.getId()!=null && rubroempleaLocal.getId()!=null) {
					if(this.getId().equals(rubroempleaLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!RubroEmpleaConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcion(this);
		} else {
			sDetalle=RubroEmpleaConstantesFunciones.getRubroEmpleaDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public RubroEmplea getRubroEmpleaOriginal() {
		return this.rubroempleaOriginal;
	}
	
	public void setRubroEmpleaOriginal(RubroEmplea rubroemplea) {
		try {
			this.rubroempleaOriginal=rubroemplea;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected RubroEmpleaAdditional rubroempleaAdditional=null;
	
	public RubroEmpleaAdditional getRubroEmpleaAdditional() {
		return this.rubroempleaAdditional;
	}
	
	public void setRubroEmpleaAdditional(RubroEmpleaAdditional rubroempleaAdditional) {
		try {
			this.rubroempleaAdditional=rubroempleaAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_calculo() {
		return this.id_tipo_calculo;
	}
    
	
	public Long getid_tipo_rubro_emplea() {
		return this.id_tipo_rubro_emplea;
	}
    
	
	public Long getid_tipo_grupo_rubro_emplea() {
		return this.id_tipo_grupo_rubro_emplea;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getformula() {
		return this.formula;
	}
    
	
	public String getalias() {
		return this.alias;
	}
    
	
	public Integer getsecuencial() {
		return this.secuencial;
	}
    
	
	public Boolean getpara_rol_pagos() {
		return this.para_rol_pagos;
	}
    
	
	public Boolean getpara_sueldo() {
		return this.para_sueldo;
	}
    
	
	public Boolean getpara_vacaciones() {
		return this.para_vacaciones;
	}
    
	
	public Boolean getpara_impuesto_renta() {
		return this.para_impuesto_renta;
	}
    
	
	public Boolean getpara_seguro_social() {
		return this.para_seguro_social;
	}
    
	
	public Boolean getpara_provisiones() {
		return this.para_provisiones;
	}
    
	
	public Boolean getpara_utilidades() {
		return this.para_utilidades;
	}
    
	
	public Boolean getpara_rubro_iess() {
		return this.para_rubro_iess;
	}
    
	
	public Boolean getes_fondo_reserva() {
		return this.es_fondo_reserva;
	}
    
	
	public Boolean getes_decimo_tercero() {
		return this.es_decimo_tercero;
	}
    
	
	public Boolean getes_decimo_cuarto() {
		return this.es_decimo_cuarto;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_calculo(Long newid_tipo_calculo)throws Exception
	{
		try {
			if(this.id_tipo_calculo!=newid_tipo_calculo) {
				if(newid_tipo_calculo==null) {
					//newid_tipo_calculo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna id_tipo_calculo");
					}
				}

				this.id_tipo_calculo=newid_tipo_calculo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_rubro_emplea(Long newid_tipo_rubro_emplea)throws Exception
	{
		try {
			if(this.id_tipo_rubro_emplea!=newid_tipo_rubro_emplea) {
				if(newid_tipo_rubro_emplea==null) {
					//newid_tipo_rubro_emplea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna id_tipo_rubro_emplea");
					}
				}

				this.id_tipo_rubro_emplea=newid_tipo_rubro_emplea;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_grupo_rubro_emplea(Long newid_tipo_grupo_rubro_emplea)throws Exception
	{
		try {
			if(this.id_tipo_grupo_rubro_emplea!=newid_tipo_grupo_rubro_emplea) {
				if(newid_tipo_grupo_rubro_emplea==null) {
					//newid_tipo_grupo_rubro_emplea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna id_tipo_grupo_rubro_emplea");
					}
				}

				this.id_tipo_grupo_rubro_emplea=newid_tipo_grupo_rubro_emplea;
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
						System.out.println("RubroEmplea:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("RubroEmplea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("RubroEmplea:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("RubroEmplea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
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
						System.out.println("RubroEmplea:Valor nulo no permitido en columna formula");
					}
				}

				if(newformula!=null&&newformula.length()>100) {
					newformula=newformula.substring(0,98);
					System.out.println("RubroEmplea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna formula");
				}

				this.formula=newformula;
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
						System.out.println("RubroEmplea:Valor nulo no permitido en columna alias");
					}
				}

				if(newalias!=null&&newalias.length()>50) {
					newalias=newalias.substring(0,48);
					System.out.println("RubroEmplea:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna alias");
				}

				this.alias=newalias;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsecuencial(Integer newsecuencial)throws Exception
	{
		try {
			if(this.secuencial!=newsecuencial) {
				if(newsecuencial==null) {
					//newsecuencial=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna secuencial");
					}
				}

				this.secuencial=newsecuencial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_rol_pagos(Boolean newpara_rol_pagos)throws Exception
	{
		try {
			if(this.para_rol_pagos!=newpara_rol_pagos) {
				if(newpara_rol_pagos==null) {
					//newpara_rol_pagos=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_rol_pagos");
					}
				}

				this.para_rol_pagos=newpara_rol_pagos;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_sueldo(Boolean newpara_sueldo)throws Exception
	{
		try {
			if(this.para_sueldo!=newpara_sueldo) {
				if(newpara_sueldo==null) {
					//newpara_sueldo=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_sueldo");
					}
				}

				this.para_sueldo=newpara_sueldo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_vacaciones(Boolean newpara_vacaciones)throws Exception
	{
		try {
			if(this.para_vacaciones!=newpara_vacaciones) {
				if(newpara_vacaciones==null) {
					//newpara_vacaciones=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_vacaciones");
					}
				}

				this.para_vacaciones=newpara_vacaciones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_impuesto_renta(Boolean newpara_impuesto_renta)throws Exception
	{
		try {
			if(this.para_impuesto_renta!=newpara_impuesto_renta) {
				if(newpara_impuesto_renta==null) {
					//newpara_impuesto_renta=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_impuesto_renta");
					}
				}

				this.para_impuesto_renta=newpara_impuesto_renta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_seguro_social(Boolean newpara_seguro_social)throws Exception
	{
		try {
			if(this.para_seguro_social!=newpara_seguro_social) {
				if(newpara_seguro_social==null) {
					//newpara_seguro_social=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_seguro_social");
					}
				}

				this.para_seguro_social=newpara_seguro_social;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_provisiones(Boolean newpara_provisiones)throws Exception
	{
		try {
			if(this.para_provisiones!=newpara_provisiones) {
				if(newpara_provisiones==null) {
					//newpara_provisiones=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_provisiones");
					}
				}

				this.para_provisiones=newpara_provisiones;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_utilidades(Boolean newpara_utilidades)throws Exception
	{
		try {
			if(this.para_utilidades!=newpara_utilidades) {
				if(newpara_utilidades==null) {
					//newpara_utilidades=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_utilidades");
					}
				}

				this.para_utilidades=newpara_utilidades;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_rubro_iess(Boolean newpara_rubro_iess)throws Exception
	{
		try {
			if(this.para_rubro_iess!=newpara_rubro_iess) {
				if(newpara_rubro_iess==null) {
					//newpara_rubro_iess=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna para_rubro_iess");
					}
				}

				this.para_rubro_iess=newpara_rubro_iess;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_fondo_reserva(Boolean newes_fondo_reserva)throws Exception
	{
		try {
			if(this.es_fondo_reserva!=newes_fondo_reserva) {
				if(newes_fondo_reserva==null) {
					//newes_fondo_reserva=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna es_fondo_reserva");
					}
				}

				this.es_fondo_reserva=newes_fondo_reserva;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_decimo_tercero(Boolean newes_decimo_tercero)throws Exception
	{
		try {
			if(this.es_decimo_tercero!=newes_decimo_tercero) {
				if(newes_decimo_tercero==null) {
					//newes_decimo_tercero=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna es_decimo_tercero");
					}
				}

				this.es_decimo_tercero=newes_decimo_tercero;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_decimo_cuarto(Boolean newes_decimo_cuarto)throws Exception
	{
		try {
			if(this.es_decimo_cuarto!=newes_decimo_cuarto) {
				if(newes_decimo_cuarto==null) {
					//newes_decimo_cuarto=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("RubroEmplea:Valor nulo no permitido en columna es_decimo_cuarto");
					}
				}

				this.es_decimo_cuarto=newes_decimo_cuarto;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoCalculo getTipoCalculo() {
		return this.tipocalculo;
	}

	public TipoRubroEmplea getTipoRubroEmplea() {
		return this.tiporubroemplea;
	}

	public TipoGrupoRubroEmplea getTipoGrupoRubroEmplea() {
		return this.tipogruporubroemplea;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipocalculo_descripcion() {
		return this.tipocalculo_descripcion;
	}

	public String gettiporubroemplea_descripcion() {
		return this.tiporubroemplea_descripcion;
	}

	public String gettipogruporubroemplea_descripcion() {
		return this.tipogruporubroemplea_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoCalculo(TipoCalculo tipocalculo) {
		try {
			this.tipocalculo=tipocalculo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoRubroEmplea(TipoRubroEmplea tiporubroemplea) {
		try {
			this.tiporubroemplea=tiporubroemplea;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea) {
		try {
			this.tipogruporubroemplea=tipogruporubroemplea;
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


	public  void  settipocalculo_descripcion(String tipocalculo_descripcion) {
		try {
			this.tipocalculo_descripcion=tipocalculo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settiporubroemplea_descripcion(String tiporubroemplea_descripcion) {
		try {
			this.tiporubroemplea_descripcion=tiporubroemplea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipogruporubroemplea_descripcion(String tipogruporubroemplea_descripcion) {
		try {
			this.tipogruporubroemplea_descripcion=tipogruporubroemplea_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<HistorialPagoNomi> getHistorialPagoNomis() {
		return this.historialpagonomis;
	}

	public List<RubroEstructura> getRubroEstructuras() {
		return this.rubroestructuras;
	}

	public List<DefiProvisionEmpleado> getDefiProvisionEmpleados() {
		return this.defiprovisionempleados;
	}

	public List<EmpleadoPagoRubro> getEmpleadoPagoRubros() {
		return this.empleadopagorubros;
	}

	public List<HistorialPagoMesNomi> getHistorialPagoMesNomis() {
		return this.historialpagomesnomis;
	}

	public List<RubroEmpleado> getRubroEmpleados() {
		return this.rubroempleados;
	}

	public List<ValorRubroVariable> getValorRubroVariables() {
		return this.valorrubrovariables;
	}

	public List<TipoPrestamo> getTipoPrestamos() {
		return this.tipoprestamos;
	}

	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables() {
		return this.rubroempleacuentacontables;
	}

	
	
	public  void  setHistorialPagoNomis(List<HistorialPagoNomi> historialpagonomis) {
		try {
			this.historialpagonomis=historialpagonomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEstructuras(List<RubroEstructura> rubroestructuras) {
		try {
			this.rubroestructuras=rubroestructuras;
		} catch(Exception e) {
			;
		}
	}

	public  void  setDefiProvisionEmpleados(List<DefiProvisionEmpleado> defiprovisionempleados) {
		try {
			this.defiprovisionempleados=defiprovisionempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setEmpleadoPagoRubros(List<EmpleadoPagoRubro> empleadopagorubros) {
		try {
			this.empleadopagorubros=empleadopagorubros;
		} catch(Exception e) {
			;
		}
	}

	public  void  setHistorialPagoMesNomis(List<HistorialPagoMesNomi> historialpagomesnomis) {
		try {
			this.historialpagomesnomis=historialpagomesnomis;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEmpleados(List<RubroEmpleado> rubroempleados) {
		try {
			this.rubroempleados=rubroempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setValorRubroVariables(List<ValorRubroVariable> valorrubrovariables) {
		try {
			this.valorrubrovariables=valorrubrovariables;
		} catch(Exception e) {
			;
		}
	}

	public  void  setTipoPrestamos(List<TipoPrestamo> tipoprestamos) {
		try {
			this.tipoprestamos=tipoprestamos;
		} catch(Exception e) {
			;
		}
	}

	public  void  setRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> rubroempleacuentacontables) {
		try {
			this.rubroempleacuentacontables=rubroempleacuentacontables;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_calculo_descripcion="";String id_tipo_rubro_emplea_descripcion="";String id_tipo_grupo_rubro_emplea_descripcion="";String para_rol_pagos_descripcion="";String para_sueldo_descripcion="";String para_vacaciones_descripcion="";String para_impuesto_renta_descripcion="";String para_seguro_social_descripcion="";String para_provisiones_descripcion="";String para_utilidades_descripcion="";String para_rubro_iess_descripcion="";String es_fondo_reserva_descripcion="";String es_decimo_tercero_descripcion="";String es_decimo_cuarto_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_calculo_descripcion() {
		return id_tipo_calculo_descripcion;
	}
	public String getid_tipo_rubro_emplea_descripcion() {
		return id_tipo_rubro_emplea_descripcion;
	}
	public String getid_tipo_grupo_rubro_emplea_descripcion() {
		return id_tipo_grupo_rubro_emplea_descripcion;
	}
	public String getpara_rol_pagos_descripcion() {
		return para_rol_pagos_descripcion;
	}
	public String getpara_sueldo_descripcion() {
		return para_sueldo_descripcion;
	}
	public String getpara_vacaciones_descripcion() {
		return para_vacaciones_descripcion;
	}
	public String getpara_impuesto_renta_descripcion() {
		return para_impuesto_renta_descripcion;
	}
	public String getpara_seguro_social_descripcion() {
		return para_seguro_social_descripcion;
	}
	public String getpara_provisiones_descripcion() {
		return para_provisiones_descripcion;
	}
	public String getpara_utilidades_descripcion() {
		return para_utilidades_descripcion;
	}
	public String getpara_rubro_iess_descripcion() {
		return para_rubro_iess_descripcion;
	}
	public String getes_fondo_reserva_descripcion() {
		return es_fondo_reserva_descripcion;
	}
	public String getes_decimo_tercero_descripcion() {
		return es_decimo_tercero_descripcion;
	}
	public String getes_decimo_cuarto_descripcion() {
		return es_decimo_cuarto_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_calculo_descripcion(String newid_tipo_calculo_descripcion)throws Exception {
		try {
			this.id_tipo_calculo_descripcion=newid_tipo_calculo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_rubro_emplea_descripcion(String newid_tipo_rubro_emplea_descripcion)throws Exception {
		try {
			this.id_tipo_rubro_emplea_descripcion=newid_tipo_rubro_emplea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_grupo_rubro_emplea_descripcion(String newid_tipo_grupo_rubro_emplea_descripcion)throws Exception {
		try {
			this.id_tipo_grupo_rubro_emplea_descripcion=newid_tipo_grupo_rubro_emplea_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_rol_pagos_descripcion(String newpara_rol_pagos_descripcion)throws Exception {
		try {
			this.para_rol_pagos_descripcion=newpara_rol_pagos_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_sueldo_descripcion(String newpara_sueldo_descripcion)throws Exception {
		try {
			this.para_sueldo_descripcion=newpara_sueldo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_vacaciones_descripcion(String newpara_vacaciones_descripcion)throws Exception {
		try {
			this.para_vacaciones_descripcion=newpara_vacaciones_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_impuesto_renta_descripcion(String newpara_impuesto_renta_descripcion)throws Exception {
		try {
			this.para_impuesto_renta_descripcion=newpara_impuesto_renta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_seguro_social_descripcion(String newpara_seguro_social_descripcion)throws Exception {
		try {
			this.para_seguro_social_descripcion=newpara_seguro_social_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_provisiones_descripcion(String newpara_provisiones_descripcion)throws Exception {
		try {
			this.para_provisiones_descripcion=newpara_provisiones_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_utilidades_descripcion(String newpara_utilidades_descripcion)throws Exception {
		try {
			this.para_utilidades_descripcion=newpara_utilidades_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_rubro_iess_descripcion(String newpara_rubro_iess_descripcion)throws Exception {
		try {
			this.para_rubro_iess_descripcion=newpara_rubro_iess_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_fondo_reserva_descripcion(String newes_fondo_reserva_descripcion)throws Exception {
		try {
			this.es_fondo_reserva_descripcion=newes_fondo_reserva_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_decimo_tercero_descripcion(String newes_decimo_tercero_descripcion)throws Exception {
		try {
			this.es_decimo_tercero_descripcion=newes_decimo_tercero_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_decimo_cuarto_descripcion(String newes_decimo_cuarto_descripcion)throws Exception {
		try {
			this.es_decimo_cuarto_descripcion=newes_decimo_cuarto_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_calculo_descripcion="";this.id_tipo_rubro_emplea_descripcion="";this.id_tipo_grupo_rubro_emplea_descripcion="";this.para_rol_pagos_descripcion="";this.para_sueldo_descripcion="";this.para_vacaciones_descripcion="";this.para_impuesto_renta_descripcion="";this.para_seguro_social_descripcion="";this.para_provisiones_descripcion="";this.para_utilidades_descripcion="";this.para_rubro_iess_descripcion="";this.es_fondo_reserva_descripcion="";this.es_decimo_tercero_descripcion="";this.es_decimo_cuarto_descripcion="";
	}
	
	
	Object historialpagonomisDescripcionReporte;
	Object rubroestructurasDescripcionReporte;
	Object defiprovisionempleadosDescripcionReporte;
	Object empleadopagorubrosDescripcionReporte;
	Object historialpagomesnomisDescripcionReporte;
	Object rubroempleadosDescripcionReporte;
	Object valorrubrovariablesDescripcionReporte;
	Object tipoprestamosDescripcionReporte;
	Object rubroempleacuentacontablesDescripcionReporte;
	
	
	public Object gethistorialpagonomisDescripcionReporte() {
		return historialpagonomisDescripcionReporte;
	}

	public Object getrubroestructurasDescripcionReporte() {
		return rubroestructurasDescripcionReporte;
	}

	public Object getdefiprovisionempleadosDescripcionReporte() {
		return defiprovisionempleadosDescripcionReporte;
	}

	public Object getempleadopagorubrosDescripcionReporte() {
		return empleadopagorubrosDescripcionReporte;
	}

	public Object gethistorialpagomesnomisDescripcionReporte() {
		return historialpagomesnomisDescripcionReporte;
	}

	public Object getrubroempleadosDescripcionReporte() {
		return rubroempleadosDescripcionReporte;
	}

	public Object getvalorrubrovariablesDescripcionReporte() {
		return valorrubrovariablesDescripcionReporte;
	}

	public Object gettipoprestamosDescripcionReporte() {
		return tipoprestamosDescripcionReporte;
	}

	public Object getrubroempleacuentacontablesDescripcionReporte() {
		return rubroempleacuentacontablesDescripcionReporte;
	}

	
	
	public  void  sethistorialpagonomisDescripcionReporte(Object historialpagonomis) {
		try {
			this.historialpagonomisDescripcionReporte=historialpagonomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroestructurasDescripcionReporte(Object rubroestructuras) {
		try {
			this.rubroestructurasDescripcionReporte=rubroestructuras;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setdefiprovisionempleadosDescripcionReporte(Object defiprovisionempleados) {
		try {
			this.defiprovisionempleadosDescripcionReporte=defiprovisionempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setempleadopagorubrosDescripcionReporte(Object empleadopagorubros) {
		try {
			this.empleadopagorubrosDescripcionReporte=empleadopagorubros;
		} catch(Exception ex) {
			;
		}
	}

	public  void  sethistorialpagomesnomisDescripcionReporte(Object historialpagomesnomis) {
		try {
			this.historialpagomesnomisDescripcionReporte=historialpagomesnomis;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroempleadosDescripcionReporte(Object rubroempleados) {
		try {
			this.rubroempleadosDescripcionReporte=rubroempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setvalorrubrovariablesDescripcionReporte(Object valorrubrovariables) {
		try {
			this.valorrubrovariablesDescripcionReporte=valorrubrovariables;
		} catch(Exception ex) {
			;
		}
	}

	public  void  settipoprestamosDescripcionReporte(Object tipoprestamos) {
		try {
			this.tipoprestamosDescripcionReporte=tipoprestamos;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setrubroempleacuentacontablesDescripcionReporte(Object rubroempleacuentacontables) {
		try {
			this.rubroempleacuentacontablesDescripcionReporte=rubroempleacuentacontables;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

