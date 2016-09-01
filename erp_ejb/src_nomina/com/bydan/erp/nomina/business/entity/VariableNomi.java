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
//import com.bydan.erp.nomina.util.VariableNomiConstantesFunciones;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.util.*;



import com.bydan.erp.seguridad.business.entity.*;




@SuppressWarnings("unused")
public class VariableNomi extends VariableNomiAdditional implements Serializable ,Cloneable {//VariableNomiAdditional,GeneralEntity
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
	
	private VariableNomi variablenomiOriginal;
	
	private Map<String, Object> mapVariableNomi;
			
	public Map<String, Object> getMapVariableNomi() {
		return mapVariableNomi;
	}

	public void setMapVariableNomi(Map<String, Object> mapVariableNomi) {
		this.mapVariableNomi = mapVariableNomi;
	}
	
	public void inicializarMapVariableNomi() {
		this.mapVariableNomi = new HashMap<String,Object>();
	}
	
	public void setMapVariableNomiValue(String sKey,Object oValue) {
		this.mapVariableNomi.put(sKey, oValue);
	}
	
	public Object getMapVariableNomiValue(String sKey) {
		return this.mapVariableNomi.get(sKey);
	}
	
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_empresa;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_modulo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_variable_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=19,fractionalDigits=0,message=ConstantesValidacion.SVALIDACIONBIGINT)
	@Min(value=0,message=ConstantesValidacion.SVALIDACIONNOVACIO)
	private Long id_tipo_valor_variable_nomi;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=50,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VariableNomiConstantesFunciones.SREGEXCODIGO,message=VariableNomiConstantesFunciones.SMENSAJEREGEXCODIGO)
	private String codigo;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@NotEmpty(message=ConstantesValidacion.SVALIDACIONNOVACIO)
	@Pattern(regex=VariableNomiConstantesFunciones.SREGEXNOMBRE,message=VariableNomiConstantesFunciones.SMENSAJEREGEXNOMBRE)
	private String nombre;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VariableNomiConstantesFunciones.SREGEXSQL1,message=VariableNomiConstantesFunciones.SMENSAJEREGEXSQL1)
	private String sql1;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VariableNomiConstantesFunciones.SREGEXSQL2,message=VariableNomiConstantesFunciones.SMENSAJEREGEXSQL2)
	private String sql2;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Length(min=0,max=150,message=ConstantesValidacion.SVALIDACIONLENGTH)
	@Pattern(regex=VariableNomiConstantesFunciones.SREGEXSQL3,message=VariableNomiConstantesFunciones.SMENSAJEREGEXSQL3)
	private String sql3;
	
	@NotNull(message=ConstantesValidacion.SVALIDACIONNOTNULL)
	@Digits(integerDigits=18,fractionalDigits=2,message=ConstantesValidacion.SVALIDACIONDECIMAL)
	private Double valor;
			
	
	public Empresa empresa;
	public Modulo modulo;
	public TipoVariableNomi tipovariablenomi;
	public TipoValorVariableNomi tipovalorvariablenomi;
	
	
	private String empresa_descripcion;
	private String modulo_descripcion;
	private String tipovariablenomi_descripcion;
	private String tipovalorvariablenomi_descripcion;
	
	
		
	public VariableNomi () throws Exception {
		super();		
		
		this.id=0L;
		
		
		this.versionRow=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());//new Date();
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		this.sType="NONE";
		
		this.variablenomiOriginal=this;
		
 		this.id_empresa=-1L;
 		this.id_modulo=-1L;
 		this.id_tipo_variable_nomi=-1L;
 		this.id_tipo_valor_variable_nomi=-1L;
 		this.codigo="";
 		this.nombre="";
 		this.sql1="";
 		this.sql2="";
 		this.sql3="";
 		this.valor=0.0;
		
		
		this.empresa=null;
		this.modulo=null;
		this.tipovariablenomi=null;
		this.tipovalorvariablenomi=null;
		
		
		this.empresa_descripcion="";
		this.modulo_descripcion="";
		this.tipovariablenomi_descripcion="";
		this.tipovalorvariablenomi_descripcion="";
		
		
		
			
		
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
    //PARA REPORTES
	public VariableNomi (Long id,Date versionRow,Long id_empresa,Long id_modulo,Long id_tipo_variable_nomi,Long id_tipo_valor_variable_nomi,String codigo,String nombre,String sql1,String sql2,String sql3,Double valor) throws Exception {
		super();		
		
		this.id=id;
		this.versionRow=versionRow;
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.variablenomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_variable_nomi=id_tipo_variable_nomi;
 		this.id_tipo_valor_variable_nomi=id_tipo_valor_variable_nomi;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.sql1=sql1;
 		this.sql2=sql2;
 		this.sql3=sql3;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	 //PARA REPORTES
	public VariableNomi (Long id_empresa,Long id_modulo,Long id_tipo_variable_nomi,Long id_tipo_valor_variable_nomi,String codigo,String nombre,String sql1,String sql2,String sql3,Double valor) throws Exception {
		super();		
		
		this.id=0L;
		this.versionRow=new Date();
		
		this.isNew=true;
		this.isChanged=false;
		this.isDeleted=false;
		
		this.variablenomiOriginal=this;
		
 		this.id_empresa=id_empresa;
 		this.id_modulo=id_modulo;
 		this.id_tipo_variable_nomi=id_tipo_variable_nomi;
 		this.id_tipo_valor_variable_nomi=id_tipo_valor_variable_nomi;
 		this.codigo=codigo;
 		this.nombre=nombre;
 		this.sql1=sql1;
 		this.sql2=sql2;
 		this.sql3=sql3;
 		this.valor=valor;
		
		/*PARA REPORTES*/
		this.inicializarVariablesParaReporte();
		/*PARA REPORTES*/
    } 
	
	public boolean equals(Object object) {
		boolean equal=false;
		VariableNomi variablenomiLocal=null;
		
		if(object!=null) {
			variablenomiLocal=(VariableNomi)object;
			
			if(variablenomiLocal!=null) {
				if(this.getId()!=null && variablenomiLocal.getId()!=null) {
					if(this.getId().equals(variablenomiLocal.getId())) {
						equal=true;
					}
				}
			}
		}
		
		return equal;
	}
	
	public String toString() {
		String sDetalle="";
		
		if(!VariableNomiConstantesFunciones.CON_DESCRIPCION_DETALLADO) {
        	sDetalle=VariableNomiConstantesFunciones.getVariableNomiDescripcion(this);
		} else {
			sDetalle=VariableNomiConstantesFunciones.getVariableNomiDescripcionDetallado(this);
		}
		
		return sDetalle;
    }
	
	public VariableNomi getVariableNomiOriginal() {
		return this.variablenomiOriginal;
	}
	
	public void setVariableNomiOriginal(VariableNomi variablenomi) {
		try {
			this.variablenomiOriginal=variablenomi;
		} catch(Exception e) {
			;
		}
	}
	
	
	protected VariableNomiAdditional variablenomiAdditional=null;
	
	public VariableNomiAdditional getVariableNomiAdditional() {
		return this.variablenomiAdditional;
	}
	
	public void setVariableNomiAdditional(VariableNomiAdditional variablenomiAdditional) {
		try {
			this.variablenomiAdditional=variablenomiAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
    
	
	public Long getid_empresa() {
		return this.id_empresa;
	}
    
	
	public Long getid_modulo() {
		return this.id_modulo;
	}
    
	
	public Long getid_tipo_variable_nomi() {
		return this.id_tipo_variable_nomi;
	}
    
	
	public Long getid_tipo_valor_variable_nomi() {
		return this.id_tipo_valor_variable_nomi;
	}
    
	
	public String getcodigo() {
		return this.codigo;
	}
    
	
	public String getnombre() {
		return this.nombre;
	}
    
	
	public String getsql1() {
		return this.sql1;
	}
    
	
	public String getsql2() {
		return this.sql2;
	}
    
	
	public String getsql3() {
		return this.sql3;
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
						System.out.println("VariableNomi:Valor nulo no permitido en columna id_empresa");
					}
				}

				this.id_empresa=newid_empresa;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_modulo(Long newid_modulo)throws Exception
	{
		try {
			if(this.id_modulo!=newid_modulo) {
				if(newid_modulo==null) {
					//newid_modulo=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna id_modulo");
					}
				}

				this.id_modulo=newid_modulo;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_variable_nomi(Long newid_tipo_variable_nomi)throws Exception
	{
		try {
			if(this.id_tipo_variable_nomi!=newid_tipo_variable_nomi) {
				if(newid_tipo_variable_nomi==null) {
					//newid_tipo_variable_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna id_tipo_variable_nomi");
					}
				}

				this.id_tipo_variable_nomi=newid_tipo_variable_nomi;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setid_tipo_valor_variable_nomi(Long newid_tipo_valor_variable_nomi)throws Exception
	{
		try {
			if(this.id_tipo_valor_variable_nomi!=newid_tipo_valor_variable_nomi) {
				if(newid_tipo_valor_variable_nomi==null) {
					//newid_tipo_valor_variable_nomi=-1L;
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna id_tipo_valor_variable_nomi");
					}
				}

				this.id_tipo_valor_variable_nomi=newid_tipo_valor_variable_nomi;
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
						System.out.println("VariableNomi:Valor nulo no permitido en columna codigo");
					}
				}

				if(newcodigo!=null&&newcodigo.length()>50) {
					newcodigo=newcodigo.substring(0,48);
					System.out.println("VariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=50 en columna codigo");
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
						System.out.println("VariableNomi:Valor nulo no permitido en columna nombre");
					}
				}

				if(newnombre!=null&&newnombre.length()>150) {
					newnombre=newnombre.substring(0,148);
					System.out.println("VariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna nombre");
				}

				this.nombre=newnombre;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsql1(String newsql1)throws Exception
	{
		try {
			if(this.sql1!=newsql1) {
				if(newsql1==null) {
					//newsql1="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna sql1");
					}
				}

				if(newsql1!=null&&newsql1.length()>150) {
					newsql1=newsql1.substring(0,148);
					System.out.println("VariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sql1");
				}

				this.sql1=newsql1;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsql2(String newsql2)throws Exception
	{
		try {
			if(this.sql2!=newsql2) {
				if(newsql2==null) {
					//newsql2="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna sql2");
					}
				}

				if(newsql2!=null&&newsql2.length()>150) {
					newsql2=newsql2.substring(0,148);
					System.out.println("VariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sql2");
				}

				this.sql2=newsql2;
				this.setIsChanged(true);
			}
		} catch(Exception e) {
			throw e;
		}
	}
    
	public void setsql3(String newsql3)throws Exception
	{
		try {
			if(this.sql3!=newsql3) {
				if(newsql3==null) {
					//newsql3="";
					if(Constantes.ISDEVELOPING) {
						System.out.println("VariableNomi:Valor nulo no permitido en columna sql3");
					}
				}

				if(newsql3!=null&&newsql3.length()>150) {
					newsql3=newsql3.substring(0,148);
					System.out.println("VariableNomi:Ha sobrepasado el numero maximo de caracteres permitidos,Maximo=150 en columna sql3");
				}

				this.sql3=newsql3;
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
						System.out.println("VariableNomi:Valor nulo no permitido en columna valor");
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

	public Modulo getModulo() {
		return this.modulo;
	}

	public TipoVariableNomi getTipoVariableNomi() {
		return this.tipovariablenomi;
	}

	public TipoValorVariableNomi getTipoValorVariableNomi() {
		return this.tipovalorvariablenomi;
	}

	
	
	public String getempresa_descripcion() {
		return this.empresa_descripcion;
	}

	public String getmodulo_descripcion() {
		return this.modulo_descripcion;
	}

	public String gettipovariablenomi_descripcion() {
		return this.tipovariablenomi_descripcion;
	}

	public String gettipovalorvariablenomi_descripcion() {
		return this.tipovalorvariablenomi_descripcion;
	}

	
	
	public  void  setEmpresa(Empresa empresa) {
		try {
			this.empresa=empresa;
		} catch(Exception e) {
			;
		}
	}


	public  void  setModulo(Modulo modulo) {
		try {
			this.modulo=modulo;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoVariableNomi(TipoVariableNomi tipovariablenomi) {
		try {
			this.tipovariablenomi=tipovariablenomi;
		} catch(Exception e) {
			;
		}
	}


	public  void  setTipoValorVariableNomi(TipoValorVariableNomi tipovalorvariablenomi) {
		try {
			this.tipovalorvariablenomi=tipovalorvariablenomi;
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


	public  void  setmodulo_descripcion(String modulo_descripcion) {
		try {
			this.modulo_descripcion=modulo_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovariablenomi_descripcion(String tipovariablenomi_descripcion) {
		try {
			this.tipovariablenomi_descripcion=tipovariablenomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	public  void  settipovalorvariablenomi_descripcion(String tipovalorvariablenomi_descripcion) {
		try {
			this.tipovalorvariablenomi_descripcion=tipovalorvariablenomi_descripcion;
		} catch(Exception e) {
			;
		}
	}


	
	
	
	
	
	/*PARA REPORTES*/
	String id_empresa_descripcion="";String id_modulo_descripcion="";String id_tipo_variable_nomi_descripcion="";String id_tipo_valor_variable_nomi_descripcion="";
	
	
	public String getid_empresa_descripcion() {
		return id_empresa_descripcion;
	}
	public String getid_modulo_descripcion() {
		return id_modulo_descripcion;
	}
	public String getid_tipo_variable_nomi_descripcion() {
		return id_tipo_variable_nomi_descripcion;
	}
	public String getid_tipo_valor_variable_nomi_descripcion() {
		return id_tipo_valor_variable_nomi_descripcion;
	}
	
	
	public void setid_empresa_descripcion(String newid_empresa_descripcion)throws Exception {
		try {
			this.id_empresa_descripcion=newid_empresa_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_modulo_descripcion(String newid_modulo_descripcion)throws Exception {
		try {
			this.id_modulo_descripcion=newid_modulo_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_variable_nomi_descripcion(String newid_tipo_variable_nomi_descripcion)throws Exception {
		try {
			this.id_tipo_variable_nomi_descripcion=newid_tipo_variable_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	public void setid_tipo_valor_variable_nomi_descripcion(String newid_tipo_valor_variable_nomi_descripcion)throws Exception {
		try {
			this.id_tipo_valor_variable_nomi_descripcion=newid_tipo_valor_variable_nomi_descripcion;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
	public void inicializarVariablesParaReporte() {
		this.id_empresa_descripcion="";this.id_modulo_descripcion="";this.id_tipo_variable_nomi_descripcion="";this.id_tipo_valor_variable_nomi_descripcion="";
	}
	
	
	
	
	
	
	/*PARA REPORTES FIN*/		
}

