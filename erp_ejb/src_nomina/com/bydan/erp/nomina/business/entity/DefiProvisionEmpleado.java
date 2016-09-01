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
//import com.bydan.erp.nomina.util.DefiProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;




@SuppressWarnings("unused")
public class DefiProvisionEmpleado extends DefiProvisionEmpleadoAdditional implements Serializable ,Cloneable {//DefiProvisionEmpleadoAdditional,GeneralEntity
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
	
	private DefiProvisionEmpleado defiprovisionempleadoOriginal;
	
	private Map<String, Object> mapDefiProvisionEmpleado;
			
	public Map<String, Object> getMapDefiProvisionEmpleado() {
		return mapDefiProvisionEmpleado;
	}

	public void setMapDefiProvisionEmpleado(Map<String, Object> mapDefiProvisionEmpleado) {
		this.mapDefiProvisionEmpleado = mapDefiProvisionEmpleado;
	}
	
	public void inicializarMapDefiProvisionEmpleado() {
		this.mapDefiProvisionEmpleado = new HashMap<String,Object>();
	}
	
	public void setMapDefiProvisionEmpleadoValue(String sKey,Object oValue) {
		this.mapDefiProvisionEmpleado.put(sKey, oValue);
	}
	
	public Object getMapDefiProvisionEmpleadoValue(String sKey) {
		return this.mapDefiProvisionEmpleado.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_rubro_emplea;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_formato;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DefiProvisionEmpleadoConstantesFunciones.SREGEXNOMBRE,message=DefiProvisionEmpleadoConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_inicial;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=10,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONINT)
	private Integer dia_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_mes_final;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean para_liquidacion;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=DefiProvisionEmpleadoConstantesFunciones.SREGEXDESCRIPCION,message=DefiProvisionEmpleadoConstantesFunciones.SMENSAJEREGEXDESCRIPCION)
	private String descripcion;
			
	
	public Empresa empresa;
	public RubroEmplea rubroemplea;
	public Formato formato;
	public Mes mesinicial;
	public Mes mesfinal;
	
	
	private String empresa_descripcion;
	private String rubroemplea_descripcion;
	private String formato_descripcion;
	private String mesinicial_descripcion;
	private String mesfinal_descripcion;
	
	
	public List<ProvisionEmpleado> provisionempleados;
	public List<Cuota> cuotas;
		
	public DefiProvisionEmpleado () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.defiprovisionempleadoOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_rubro_emplea=-1L;
 		this.id_formato=-1L;
 		this.nombre="";
 		this.dia_inicial=0;
 		this.id_mes_inicial=-1L;
 		this.dia_final=0;
 		this.id_mes_final=-1L;
 		this.para_liquidacion=false;
 		this.descripcion="";
		
		
		this.empresa=null;
		this.rubroemplea=null;
		this.formato=null;
		this.mesinicial=null;
		this.mesfinal=null;
		
		
		this.empresa_descripcion="";
		this.rubroemplea_descripcion="";
		this.formato_descripcion="";
		this.mesinicial_descripcion="";
		this.mesfinal_descripcion="";
		
		
		this.provisionempleados=null;
		this.cuotas=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public DefiProvisionEmpleado (Long id,Date versionRow,Long id_empresa,Long id_rubro_emplea,Long id_formato,String nombre,Integer dia_inicial,Long id_mes_inicial,Integer dia_final,Long id_mes_final,Boolean para_liquidacion,String descripcion) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.defiprovisionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_formato=id_formato;
 		this.nombre=nombre;
 		this.dia_inicial=dia_inicial;
 		this.id_mes_inicial=id_mes_inicial;
 		this.dia_final=dia_final;
 		this.id_mes_final=id_mes_final;
 		this.para_liquidacion=para_liquidacion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public DefiProvisionEmpleado (Long id_empresa,Long id_rubro_emplea,Long id_formato,String nombre,Integer dia_inicial,Long id_mes_inicial,Integer dia_final,Long id_mes_final,Boolean para_liquidacion,String descripcion) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.defiprovisionempleadoOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_rubro_emplea=id_rubro_emplea;
 		this.id_formato=id_formato;
 		this.nombre=nombre;
 		this.dia_inicial=dia_inicial;
 		this.id_mes_inicial=id_mes_inicial;
 		this.dia_final=dia_final;
 		this.id_mes_final=id_mes_final;
 		this.para_liquidacion=para_liquidacion;
 		this.descripcion=descripcion;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		DefiProvisionEmpleado defiprovisionempleadoLocal=null;
		
		if(object!=null) {
			defiprovisionempleadoLocal=(DefiProvisionEmpleado)object;
			
			if(defiprovisionempleadoLocal!=null) {
				if(this.getId()!=null && defiprovisionempleadoLocal.getId()!=null) {
					if(this.getId().equals(defiprovisionempleadoLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!DefiProvisionEmpleadoConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcion(this);
		} else {
			sDetalle=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public DefiProvisionEmpleado getDefiProvisionEmpleadoOriginal() {
		return this.defiprovisionempleadoOriginal;
	}
	
	public void setDefiProvisionEmpleadoOriginal(DefiProvisionEmpleado defiprovisionempleado) {
		try {
			this.defiprovisionempleadoOriginal=defiprovisionempleado;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected DefiProvisionEmpleadoAdditional defiprovisionempleadoAdditional=null;
	
	public DefiProvisionEmpleadoAdditional getDefiProvisionEmpleadoAdditional() {
		return this.defiprovisionempleadoAdditional;
	}
	
	public void setDefiProvisionEmpleadoAdditional(DefiProvisionEmpleadoAdditional defiprovisionempleadoAdditional) {
		try {
			this.defiprovisionempleadoAdditional=defiprovisionempleadoAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_rubro_emplea() {
		return this.id_rubro_emplea;
	}
    
	
	public Long getid_formato() {
		return this.id_formato;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Integer getdia_inicial() {
		return this.dia_inicial;
	}
    
	
	public Long getid_mes_inicial() {
		return this.id_mes_inicial;
	}
    
	
	public Integer getdia_final() {
		return this.dia_final;
	}
    
	
	public Long getid_mes_final() {
		return this.id_mes_final;
	}
    
	
	public Boolean getpara_liquidacion() {
		return this.para_liquidacion;
	}
    
	
	public String getdescripcion() {
		return this.descripcion;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_rubro_emplea(Long newid_rubro_emplea)throws Exception
	{
		try {
			if(this.id_rubro_emplea!=newid_rubro_emplea) {
				if(newid_rubro_emplea==null) {
					//newid_rubro_emplea=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna id_rubro_emplea");
					}
				}

				this.id_rubro_emplea=newid_rubro_emplea;
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
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna id_formato");
					}
				}

				this.id_formato=newid_formato;
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
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("DefiProvisionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_inicial(Integer newdia_inicial)throws Exception
	{
		try {
			if(this.dia_inicial!=newdia_inicial) {
				if(newdia_inicial==null) {
					//newdia_inicial=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna dia_inicial");
					}
				}

				this.dia_inicial=newdia_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_inicial(Long newid_mes_inicial)throws Exception
	{
		try {
			if(this.id_mes_inicial!=newid_mes_inicial) {
				if(newid_mes_inicial==null) {
					//newid_mes_inicial=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna id_mes_inicial");
					}
				}

				this.id_mes_inicial=newid_mes_inicial;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdia_final(Integer newdia_final)throws Exception
	{
		try {
			if(this.dia_final!=newdia_final) {
				if(newdia_final==null) {
					//newdia_final=0;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna dia_final");
					}
				}

				this.dia_final=newdia_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_mes_final(Long newid_mes_final)throws Exception
	{
		try {
			if(this.id_mes_final!=newid_mes_final) {
				if(newid_mes_final==null) {
					//newid_mes_final=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna id_mes_final");
					}
				}

				this.id_mes_final=newid_mes_final;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setpara_liquidacion(Boolean newpara_liquidacion)throws Exception
	{
		try {
			if(this.para_liquidacion!=newpara_liquidacion) {
				if(newpara_liquidacion==null) {
					//newpara_liquidacion=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna para_liquidacion");
					}
				}

				this.para_liquidacion=newpara_liquidacion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setdescripcion(String newdescripcion)throws Exception
	{
		try {
			if(this.descripcion!=newdescripcion) {
				if(newdescripcion==null) {
					//newdescripcion="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("DefiProvisionEmpleado:Valor nulo no permitido en columna descripcion");
					}
				}

				if(newdescripcion!=null&&newdescripcion.length()>150) {
					newdescripcion=newdescripcion.substring(0,148);
					System.out.println("DefiProvisionEmpleado:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna descripcion");
				}

				this.descripcion=newdescripcion;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public RubroEmplea getRubroEmplea() {
		return this.rubroemplea;
	}

	public Formato getFormato() {
		return this.formato;
	}

	public Mes getMesInicial() {
		return this.mesinicial;
	}

	public Mes getMesFinal() {
		return this.mesfinal;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getrubroemplea_descripcion() {
		return this.rubroemplea_descripcion;
	}

	public String getformato_descripcion() {
		return this.formato_descripcion;
	}

	public String getmesinicial_descripcion() {
		return this.mesinicial_descripcion;
	}

	public String getmesfinal_descripcion() {
		return this.mesfinal_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setRubroEmplea(RubroEmplea rubroemplea) {
		try {
			this.rubroemplea=rubroemplea;
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


	public  void  setMesInicial(Mes mesinicial) {
		try {
			this.mesinicial=mesinicial;
		} catch(Exception e) {
			;
		}
	}


	public  void  setMesFinal(Mes mesfinal) {
		try {
			this.mesfinal=mesfinal;
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


	public  void  setrubroemplea_descripcion(String rubroemplea_descripcion) {
		try {
			this.rubroemplea_descripcion=rubroemplea_descripcion;
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


	public  void  setmesinicial_descripcion(String mesinicial_descripcion) {
		try {
			this.mesinicial_descripcion=mesinicial_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  setmesfinal_descripcion(String mesfinal_descripcion) {
		try {
			this.mesfinal_descripcion=mesfinal_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<ProvisionEmpleado> getProvisionEmpleados() {
		return this.provisionempleados;
	}

	public List<Cuota> getCuotas() {
		return this.cuotas;
	}

	
	
	public  void  setProvisionEmpleados(List<ProvisionEmpleado> provisionempleados) {
		try {
			this.provisionempleados=provisionempleados;
		} catch(Exception e) {
			;
		}
	}

	public  void  setCuotas(List<Cuota> cuotas) {
		try {
			this.cuotas=cuotas;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_rubro_emplea_descripcion="";String id_formato_descripcion="";String id_mes_inicial_descripcion="";String id_mes_final_descripcion="";String para_liquidacion_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_rubro_emplea_descripcion() {
		return id_rubro_emplea_descripcion;
	}
	public String getid_formato_descripcion() {
		return id_formato_descripcion;
	}
	public String getid_mes_inicial_descripcion() {
		return id_mes_inicial_descripcion;
	}
	public String getid_mes_final_descripcion() {
		return id_mes_final_descripcion;
	}
	public String getpara_liquidacion_descripcion() {
		return para_liquidacion_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_rubro_emplea_descripcion(String newid_rubro_emplea_descripcion)throws Exception {
		try {
			this.id_rubro_emplea_descripcion=newid_rubro_emplea_descripcion;
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
	public void setid_mes_inicial_descripcion(String newid_mes_inicial_descripcion)throws Exception {
		try {
			this.id_mes_inicial_descripcion=newid_mes_inicial_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_mes_final_descripcion(String newid_mes_final_descripcion)throws Exception {
		try {
			this.id_mes_final_descripcion=newid_mes_final_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setpara_liquidacion_descripcion(String newpara_liquidacion_descripcion)throws Exception {
		try {
			this.para_liquidacion_descripcion=newpara_liquidacion_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_rubro_emplea_descripcion="";this.id_formato_descripcion="";this.id_mes_inicial_descripcion="";this.id_mes_final_descripcion="";this.para_liquidacion_descripcion="";
	}
	
	
	Object provisionempleadosDescripcionReporte;
	Object cuotasDescripcionReporte;
	
	
	public Object getprovisionempleadosDescripcionReporte() {
		return provisionempleadosDescripcionReporte;
	}

	public Object getcuotasDescripcionReporte() {
		return cuotasDescripcionReporte;
	}

	
	
	public  void  setprovisionempleadosDescripcionReporte(Object provisionempleados) {
		try {
			this.provisionempleadosDescripcionReporte=provisionempleados;
		} catch(Exception ex) {
			;
		}
	}

	public  void  setcuotasDescripcionReporte(Object cuotas) {
		try {
			this.cuotasDescripcionReporte=cuotas;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

