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
//import com.bydan.erp.nomina.util.ConstanteNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class ConstanteNomi extends GeneralEntity implements Serializable ,Cloneable {//ConstanteNomiAdditional,GeneralEntity
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
	
	private ConstanteNomi constantenomiOriginal;
	
	private Map<String, Object> mapConstanteNomi;
			
	public Map<String, Object> getMapConstanteNomi() {
		return mapConstanteNomi;
	}

	public void setMapConstanteNomi(Map<String, Object> mapConstanteNomi) {
		this.mapConstanteNomi = mapConstanteNomi;
	}
	
	public void inicializarMapConstanteNomi() {
		this.mapConstanteNomi = new HashMap<String,Object>();
	}
	
	public void setMapConstanteNomiValue(String sKey,Object oValue) {
		this.mapConstanteNomi.put(sKey, oValue);
	}
	
	public Object getMapConstanteNomiValue(String sKey) {
		return this.mapConstanteNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_constante_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=100,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=ConstanteNomiConstantesFunciones.SREGEXNOMBRE,message=ConstanteNomiConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	private Boolean es_para_pregunta;
			
	
	public Empresa empresa;
	public TipoConstanteNomi tipoconstantenomi;
	
	
	private String empresa_descripcion;
	private String tipoconstantenomi_descripcion;
	
	
	public List<EmpleadoConstante> empleadoconstantes;
		
	public ConstanteNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.constantenomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_tipo_constante_nomi=-1L;
 		this.nombre="";
 		this.valor=0.0;
 		this.es_para_pregunta=false;
		
		
		this.empresa=null;
		this.tipoconstantenomi=null;
		
		
		this.empresa_descripcion="";
		this.tipoconstantenomi_descripcion="";
		
		
		this.empleadoconstantes=null;
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public ConstanteNomi (Long id,Date versionRow,Long id_empresa,Long id_tipo_constante_nomi,String nombre,Double valor,Boolean es_para_pregunta) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.constantenomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_constante_nomi=id_tipo_constante_nomi;
 		this.nombre=nombre;
 		this.valor=valor;
 		this.es_para_pregunta=es_para_pregunta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public ConstanteNomi (Long id_empresa,Long id_tipo_constante_nomi,String nombre,Double valor,Boolean es_para_pregunta) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.constantenomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_tipo_constante_nomi=id_tipo_constante_nomi;
 		this.nombre=nombre;
 		this.valor=valor;
 		this.es_para_pregunta=es_para_pregunta;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		ConstanteNomi constantenomiLocal=null;
		
		if(object!=null) {
			constantenomiLocal=(ConstanteNomi)object;
			
			if(constantenomiLocal!=null) {
				if(this.getId()!=null && constantenomiLocal.getId()!=null) {
					if(this.getId().equals(constantenomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!ConstanteNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=ConstanteNomiConstantesFunciones.getConstanteNomiDescripcion(this);
		} else {
			sDetalle=ConstanteNomiConstantesFunciones.getConstanteNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public ConstanteNomi getConstanteNomiOriginal() {
		return this.constantenomiOriginal;
	}
	
	public void setConstanteNomiOriginal(ConstanteNomi constantenomi) {
		try {
			this.constantenomiOriginal=constantenomi;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_tipo_constante_nomi() {
		return this.id_tipo_constante_nomi;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public Double getvalor() {
		return this.valor;
	}
    
	
	public Boolean getes_para_pregunta() {
		return this.es_para_pregunta;
	}
	
    
	public void setid_empresa(Long newid_empresa)throws Exception
	{
		try {
			if(this.id_empresa!=newid_empresa) {
				if(newid_empresa==null) {
					//newid_empresa=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConstanteNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_constante_nomi(Long newid_tipo_constante_nomi)throws Exception
	{
		try {
			if(this.id_tipo_constante_nomi!=newid_tipo_constante_nomi) {
				if(newid_tipo_constante_nomi==null) {
					//newid_tipo_constante_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConstanteNomi:Valor nulo no permitido en columna id_tipo_constante_nomi");
					}
				}

				this.id_tipo_constante_nomi=newid_tipo_constante_nomi;
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
						System.out.println("ConstanteNomi:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>100) {
					newnombre=newnombre.substring(0,98);
					System.out.println("ConstanteNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=100 en columna nombre");
				}

				this.nombre=newnombre;
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
						System.out.println("ConstanteNomi:Valor nulo no permitido en columna valor");
					}
				}

				this.valor=newvalor;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setes_para_pregunta(Boolean newes_para_pregunta)throws Exception
	{
		try {
			if(this.es_para_pregunta!=newes_para_pregunta) {
				if(newes_para_pregunta==null) {
					//newes_para_pregunta=false;
					if(Constantes.ISDEVELOPING) {
						System.out.println("ConstanteNomi:Valor nulo no permitido en columna es_para_pregunta");
					}
				}

				this.es_para_pregunta=newes_para_pregunta;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public TipoConstanteNomi getTipoConstanteNomi() {
		return this.tipoconstantenomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String gettipoconstantenomi_descripcion() {
		return this.tipoconstantenomi_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoConstanteNomi(TipoConstanteNomi tipoconstantenomi) {
		try {
			this.tipoconstantenomi=tipoconstantenomi;
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


	public  void  settipoconstantenomi_descripcion(String tipoconstantenomi_descripcion) {
		try {
			this.tipoconstantenomi_descripcion=tipoconstantenomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	public List<EmpleadoConstante> getEmpleadoConstantes() {
		return this.empleadoconstantes;
	}

	
	
	public  void  setEmpleadoConstantes(List<EmpleadoConstante> empleadoconstantes) {
		try {
			this.empleadoconstantes=empleadoconstantes;
		} catch(Exception e) {
			;
		}
	}

	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_tipo_constante_nomi_descripcion="";String es_para_pregunta_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_tipo_constante_nomi_descripcion() {
		return id_tipo_constante_nomi_descripcion;
	}
	public String getes_para_pregunta_descripcion() {
		return es_para_pregunta_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_constante_nomi_descripcion(String newid_tipo_constante_nomi_descripcion)throws Exception {
		try {
			this.id_tipo_constante_nomi_descripcion=newid_tipo_constante_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setes_para_pregunta_descripcion(String newes_para_pregunta_descripcion)throws Exception {
		try {
			this.es_para_pregunta_descripcion=newes_para_pregunta_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_tipo_constante_nomi_descripcion="";this.es_para_pregunta_descripcion="";
	}
	
	
	Object empleadoconstantesDescripcionReporte;
	
	
	public Object getempleadoconstantesDescripcionReporte() {
		return empleadoconstantesDescripcionReporte;
	}

	
	
	public  void  setempleadoconstantesDescripcionReporte(Object empleadoconstantes) {
		try {
			this.empleadoconstantesDescripcionReporte=empleadoconstantes;
		} catch(Exception ex) {
			;
		}
	}

	/*PARA REPORTES FIN*/		
}

